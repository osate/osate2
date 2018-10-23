package org.osate.search;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;

@SuppressWarnings("serial")
public final class FoundDeclarationEvent extends AadlSearchResultEvent {
	private final IEObjectDescription objDesc;

	public FoundDeclarationEvent(final AadlSearchResult searchResult, final ResourceSet resourceSet,
			final IEObjectDescription objDesc) {
		super(searchResult, resourceSet);
		this.objDesc = objDesc;
	}

	public IEObjectDescription getObjectDescription() {
		return objDesc;
	}
}
