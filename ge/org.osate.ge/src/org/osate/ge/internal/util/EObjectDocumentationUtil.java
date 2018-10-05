package org.osate.ge.internal.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;

public class EObjectDocumentationUtil {
	public static String getPlainTextDocumentation(final Object bo) {
		// Get the documentation provider for the business object. If the documentation provider cannot be retrieved, then assume that the business object does
		// not have any documentation.
		final IEObjectDocumentationProvider docProvider = EObjectDocumentationUtil.getDocumentationProvider(bo);
		if (docProvider == null) {
			return null;
		}

		// Get the documentation
		String doc = docProvider.getDocumentation((EObject) bo);
		if (doc == null) {
			return null;
		}

		// Trim whitespace
		doc = doc.trim();
		if (doc.isEmpty()) {
			return null;
		}

		// Remove whitespace
		return doc.replaceAll("\\s+", " ");
	}

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
		return resourceServiceProvider
				.get(IEObjectDocumentationProvider.class);
	}
}
