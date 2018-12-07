package org.osate.search;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.search.ui.SearchResultEvent;

@SuppressWarnings("serial")
public abstract class AadlSearchResultEvent extends SearchResultEvent {
	private final ResourceSet resourceSet;

	// TODO Add stuff here
	protected AadlSearchResultEvent(final AadlSearchResult searchResult, final ResourceSet resourceSet) {
		super(searchResult);
		this.resourceSet = resourceSet;
	}

	public final ResourceSet getResourceSet() {
		return resourceSet;
	}
}
