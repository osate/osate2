package org.osate.search;

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

	private int numFoundDeclarations = 0;
	private int numFoundReferences = 0;

	public AadlSearchResult(final AadlSearchQuery searchQuery) {
		this.searchQuery = searchQuery;
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
			sb.append(numFoundDeclarations);
			sb.append(" declarations");
			if (limitTo.references()) {
				sb.append(" and ");
			}
		}
		if (limitTo.references()) {
			sb.append(numFoundReferences);
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
		numFoundDeclarations += 1;
		notifyListeners(new FoundDeclarationEvent(this, resourceSet, objDesc));
	}

	public void addFoundReference(final ResourceSet resourceSet, final IReferenceDescription refDesc) {
		numFoundReferences += 1;
		notifyListeners(new FoundReferenceEvent(this, resourceSet, refDesc));
	}
}
