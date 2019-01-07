package org.osate.search;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;

@SuppressWarnings("serial")
public final class FoundReferenceEvent extends AadlSearchResultEvent {
	private final IReferenceDescription refDesc;

	public FoundReferenceEvent(final AadlSearchResult searchResult, final ResourceSet resourceSet,
			final IReferenceDescription refDesc) {
		super(searchResult, resourceSet);
		this.refDesc = refDesc;
	}

	public IReferenceDescription getReferenceDescription() {
		return refDesc;
	}
}
