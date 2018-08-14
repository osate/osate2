package org.osate.ge.internal.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;

public class EObjectDocumentationUtil {
	public static IEObjectDocumentationProvider getDocumentationProvider(final Object bo) {
		if (!(bo instanceof EObject)) {
			return null;
		}

		final EObject eobj = (EObject) bo;

		// Get the Xtext resource
		if (!(eobj.eResource() instanceof XtextResource)) {
			return null;
		}

		final XtextResource resource = (XtextResource) eobj.eResource();

		// Get the resource service provider
		final IResourceServiceProvider resourceServiceProvider = resource.getResourceServiceProvider();
		if (resourceServiceProvider == null) {
			return null;
		}

		// Get the documentation provider
		final IEObjectDocumentationProvider docProvider = resourceServiceProvider
				.get(IEObjectDocumentationProvider.class);
		return docProvider;
	}
}
