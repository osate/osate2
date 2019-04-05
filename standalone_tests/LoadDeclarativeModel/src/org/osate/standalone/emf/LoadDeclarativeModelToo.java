package org.osate.standalone.emf;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;

public final class LoadDeclarativeModelToo {
	public static void main(String[] args) {
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		final XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		final Resource[] resources = new Resource[args.length];
		for (int i = 0; i < args.length; i++ ) {
			resources[i] = rs.getResource(URI.createURI(args[i]), true);
		}

		for (int i = 0; i < resources.length; i++) {
			try {
				resources[i].load(null);
				for (final EObject eObj : resources[i].getContents()) {
					System.out.println(eObj);
				}
			} catch (final IOException e) {
				System.err.println("ERROR LOADING RESOURCE: " + e.getMessage());
			}
		}

		for (int i = 0; i < resources.length; i++) {
			// Validation
			IResourceValidator validator = ((XtextResource) resources[i]).getResourceServiceProvider()
					.getResourceValidator();
			List<Issue> issues = validator.validate(resources[i], CheckMode.ALL, CancelIndicator.NullImpl);
			for (Issue issue : issues) {
				System.out.println(issue.getMessage());
			}
		}
	}
}
