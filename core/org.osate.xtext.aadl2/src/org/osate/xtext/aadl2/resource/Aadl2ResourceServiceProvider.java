package org.osate.xtext.aadl2.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;

import com.google.inject.Inject;

public class Aadl2ResourceServiceProvider extends IGlobalServiceProvider.ResourceServiceProviderImpl {

	@Inject
	public Aadl2ResourceServiceProvider(Registry registry, IResourceServiceProvider thisLanguageServiceProvider) {
		super(registry, thisLanguageServiceProvider);
	}

	@Override
	public <T> T findService(EObject eObject, Class<T> serviceClazz) {
		NamedElement annex = EcoreUtil2.getContainerOfType(eObject, DefaultAnnexLibrary.class);

		if (annex == null) {
			annex = EcoreUtil2.getContainerOfType(eObject, DefaultAnnexSubclause.class);
		}
		if (annex != null) {
			// assumes that the annex file extension is the same as
			// the annex name in the AADL sources
			URI uri = URI.createURI("dummy." + annex.getName().toLowerCase());
			return findService(uri, serviceClazz);
		} else {
			return super.findService(eObject, serviceClazz);
		}
	}
}
