package org.osate.standalone.emf;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;

public final class LoadDeclarativeModelAndContributedProperties {
	public static void main(String[] args) {
		// Init AADL meta model
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		// Init the instance model
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
		InstancePackage.eINSTANCE.eClass();

		// URI mapping for loading files this defines the "workspace" needed to resolve relative references
		String wsRoot = Paths.get(".").toAbsolutePath().normalize().toString();
		EcorePlugin.getPlatformResourceMap().put("foo", URI.createFileURI(wsRoot + "/aadl_files/"));

		final XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);

		// Add predeclared resources

		final String jar = "classpath:/";
		final String path = "resources/properties/Predeclared_Property_Sets/";

		final URI psURI1 = URI.createURI(jar + path + "AADL_Project.aadl");
		final URI psURI2 = URI.createURI(jar + path + "Programming_Properties.aadl");

		// Load the resources

		System.out.println("Loading...");
		Resource res;

		res = rs.getResource(psURI1, true);
		System.out.println("..." + res.getURI());

		res = rs.getResource(psURI2, true);
		System.out.println("..." + res.getURI());

		// Load the user resources from the command line
		for (int i = 0; i < args.length; i++) {
			res = rs.getResource(URI.createPlatformResourceURI(args[i], true), true);
			System.out.println("..." + res.getURI());
		}

		// set up URI mappings for reference resolution
		final Map<URI, URI> uriMap = rs.getURIConverter().getURIMap();
		// mapped URIs end in '/' => prefix mapping
		uriMap.put(URI.createPlatformPluginURI("/org.osate.workspace/", false), URI.createURI(jar));

		System.out.println();
		for (final Resource resource : rs.getResources()) {
			System.out.println("Validating " + resource.getURI() + "...");
			if (resource instanceof XtextResource) {
				// Validation
				IResourceValidator validator = ((XtextResource) resource).getResourceServiceProvider()
						.getResourceValidator();
				List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
				for (Issue issue : issues) {
					System.err.println(issue.getMessage());
				}
			} else {
				EcoreUtil.resolveAll(resource);
				for (Diagnostic diag : resource.getErrors()) {
					System.err.println(diag.getMessage());
				}
			}
		}

		System.out.println();
		System.out.println("Traversing...");
		for (final Resource resource : rs.getResources()) {
			System.out.println("*** " + resource.getURI().toString() + " ***");
			final TreeIterator<EObject> treeIter = resource.getAllContents();
			while (treeIter.hasNext()) {
				System.out.println(treeIter.next());
			}
			System.out.println("-- -- -- -- -- -- -- --");
		}
	}
}
