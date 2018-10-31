package org.osate.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.osate.search.AadlSearchQuery.LimitTo;
import org.osate.ui.OsateUiPlugin;

public final class AadlSearchResult implements ISearchResult {
	private final AadlSearchQuery searchQuery;
	private final ListenerList<ISearchResultListener> listeners = new ListenerList<>();

	private ResourceSet resourceSet;
	private final List<IEObjectDescription> foundDeclarations = new ArrayList<>();
	private final List<IReferenceDescription> foundReferences = new ArrayList<>();

	public AadlSearchResult(final AadlSearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	// only called from AadlSearchQuery
	void setResourceSet(final ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public void addListener(final ISearchResultListener l) {
		listeners.add(l);
	}

	@Override
	public void removeListener(final ISearchResultListener l) {
		listeners.remove(l);
	}

	// TODO Use this eventually
	@SuppressWarnings("unused")
	private void notifyListeners(final AadlSearchResultEvent event) {
		for (ISearchResultListener listener : listeners) {
			listener.searchResultChanged(event);
		}
	}

	@Override
	public String getLabel() {
		final LimitTo limitTo = searchQuery.getLimitTo();
		final StringBuilder sb = new StringBuilder(searchQuery.getLabel());
		sb.append("; Found ");
		if (limitTo.declarations()) {
			sb.append(foundDeclarations.size());
			sb.append(" declarations");
			if (limitTo.references()) {
				sb.append(" and ");
			}
		}
		if (limitTo.references()) {
			sb.append(foundReferences.size());
			sb.append(" references");
		}
		return sb.toString();
	}

	@Override
	public String getTooltip() {
		// TODO This is junk
		return "Here is the AadlSearchResultToolTip";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return OsateUiPlugin.getImageDescriptor("icons/aadl.gif");
	}

	@Override
	public ISearchQuery getQuery() {
		return searchQuery;
	}

	public void addFoundDeclaration(final ResourceSet resourceSet, final IEObjectDescription objDesc) {
		foundDeclarations.add(objDesc);
		notifyListeners(new FoundDeclarationEvent(this, resourceSet, objDesc));
	}

	public void addFoundReference(final ResourceSet resourceSet, final IReferenceDescription refDesc) {
		foundReferences.add(refDesc);
		notifyListeners(new FoundReferenceEvent(this, resourceSet, refDesc));
	}

	public Iterable<IEObjectDescription> getFoundDeclarations() {
		return foundDeclarations;
	}

	public Iterable<IReferenceDescription> getFoundReferences() {
		return foundReferences;
	}
}