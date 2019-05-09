package org.osate.standalone.emf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
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

public final class LoadDeclarativeModelAndContributedProperties {
	public static void main(String[] args) {
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		final XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);

		// Add predeclared resources

		/*
		 * String fullpath = configElems[j].getDeclaringExtension().getContributor().getName()
		 * + (path.charAt(0) == '/' ? "" : "/") + path;
		 *
		 * result.add(URI.createPlatformPluginURI(fullpath, false));
		 *
		 */

		final URI psURI1 = URI.createPlatformPluginURI(
				"org.osate.workspace/resources/properties/Predeclared_Property_Sets/Programming_Properties.aadl",
				false);

		final URI psURI2 = URI.createPlatformPluginURI(
				"org.osate.workspace/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl",
				false);

		/*
		 * Map<URI, URI> uriMap = set.getURIConverter().getURIMap();
		 *
		 * set.getResource(uri, true);
		 * uriMap.put(uri, URI.createPlatformResourceURI(uri.path().substring(7), false));
		 *
		 */

		final List<Resource> resources = new ArrayList<>();

		final Map<URI, URI> uriMap = rs.getURIConverter().getURIMap();
		resources.add(rs.getResource(psURI1, true));
		uriMap.put(psURI1, URI.createPlatformResourceURI(psURI1.path().substring(7), false));
		resources.add(rs.getResource(psURI2, true));
		uriMap.put(psURI2, URI.createPlatformResourceURI(psURI2.path().substring(7), false));

		// Load the resources
		for (int i = 0; i < args.length; i++ ) {
			resources.add(rs.getResource(URI.createURI(args[i]), true));
		}

		System.out.println("Loading...");
		for (final Resource resource : resources) {
			try {
				System.out.println("..." + resource.getURI());
				resource.load(null);
			} catch (final IOException e) {
				System.err.println("ERROR LOADING RESOURCE: " + e.getMessage());
			}
		}

		System.out.println();
		System.out.println("Validating...");
		for (final Resource resource : resources) {
			// Validation
			System.out.println("..." + resource.getURI());
			IResourceValidator validator = ((XtextResource) resource).getResourceServiceProvider()
					.getResourceValidator();
			List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			for (Issue issue : issues) {
				System.out.println(issue.getMessage());
			}
		}

		System.out.println();
		System.out.println("Traversing...");
		for (final Resource resource : resources) {
			System.out.println("*** " + resource.getURI().toString() + " ***");
			final TreeIterator<EObject> treeIter = resource.getAllContents();
			while (treeIter.hasNext()) {
				System.out.println(treeIter.next());
			}
			System.out.println("-- -- -- -- -- -- -- --");
		}
	}
}
