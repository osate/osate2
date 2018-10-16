package org.osate.search;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;

public final class AadlSearchResult implements ISearchResult {
	private final AadlSearchQuery searchQuery;
	private final ListenerList<ISearchResultListener> listeners = new ListenerList<>();

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
	private void notifyListeners() {
		final AadlSearchResultEvent event = new AadlSearchResultEvent(this);

		for (ISearchResultListener listener : listeners) {
			listener.searchResultChanged(event);
		}
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTooltip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISearchQuery getQuery() {
		return searchQuery;
	}

}
