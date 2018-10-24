package org.osate.ui.search;

import org.eclipse.emf.common.util.URI;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.osate.search.AadlSearchResult;
import org.osate.search.AadlSearchResultEvent;
import org.osate.search.FoundDeclarationEvent;
import org.osate.search.FoundReferenceEvent;

public final class AadlSearchResultPage implements ISearchResultListener, ISearchResultPage {
	private AadlSearchResult searchResult;
	private Composite root;
	private IPageSite pageSite;
	private String id;

	public AadlSearchResultPage() {
		super();
	}

	@Override
	public IPageSite getSite() {
		return pageSite;
	}

	@Override
	public void init(final IPageSite site) throws PartInitException {
		pageSite = site;
	}

	@Override
	public void createControl(final Composite parent) {
		root = new Composite(parent, SWT.NULL);

	}

	@Override
	public void dispose() {
		// nothind to do
	}

	@Override
	public Control getControl() {
		return root;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		// nothing to do
	}

	@Override
	public void setFocus() {
		// TODO Is there a sub component that can receive the focus?
		root.setFocus();
	}

	@Override
	public Object getUIState() {
		// TODO Something better we can do here?
		return null;
	}

	@Override
	public void setInput(final ISearchResult search, final Object uiState) {
		if (search == null) {
			// clean up old search
			if (searchResult != null) {
				searchResult.removeListener(this);
			}
		} else {
			searchResult = (AadlSearchResult) search;
			search.addListener(this);
		}
	}

	@Override
	public void setViewPart(final ISearchResultViewPart part) {
		// nothing to do

	}

	@Override
	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(final IMemento memento) {
		// nothing to do

	}

	@Override
	public void setID(final String id) {
		this.id = id;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getLabel() {
		return searchResult.getLabel();
	}

	@Override
	public void searchResultChanged(final SearchResultEvent e) {
		if (e instanceof AadlSearchResultEvent) {
			if (e instanceof FoundDeclarationEvent) {
				final IEObjectDescription objDesc = ((FoundDeclarationEvent) e).getObjectDescription();
				final URI uri = objDesc.getEObjectURI();
				System.out.print("Found declaration in " + uri.lastSegment() + ": ");
				for (final String segment : objDesc.getName().getSegments()) {
					System.out.print("[" + segment + "]");
				}
				System.out.println(" -- " + uri);
			} else if (e instanceof FoundReferenceEvent) {
				final IReferenceDescription refDesc = ((FoundReferenceEvent) e).getReferenceDescription();
				final URI sourceURI = refDesc.getSourceEObjectUri();
				System.out.println("Found reference in " + sourceURI.lastSegment() + ": " + sourceURI + " -> "
						+ refDesc.getTargetEObjectUri());
			}
		}
	}

}
