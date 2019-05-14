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
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;

import com.google.inject.Injector;

public final class LoadDeclarativeModelAndContributedProperties {
	public static void main(String[] args) {
		EcorePlugin.ExtensionProcessor.process(Thread.currentThread().getContextClassLoader());
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
		InstancePackage.eINSTANCE.eClass();

		ErrorModelStandaloneSetup.doSetup();

		// URI mapping for loading files this defines the "workspace" needed to resolve relative references
		String wsRoot = Paths.get(".").toAbsolutePath().normalize().toString();
		EcorePlugin.getPlatformResourceMap().put("foo", URI.createFileURI(wsRoot + "/aadl_files/"));

		final XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		// ResourceSetImpl works even without platform resource map
//		final ResourceSet rs = new ResourceSetImpl();

		// Add predeclared resources

		/*
		 * String fullpath = configElems[j].getDeclaringExtension().getContributor().getName()
		 * + (path.charAt(0) == '/' ? "" : "/") + path;
		 *
		 * result.add(URI.createPlatformPluginURI(fullpath, false));
		 *
		 */

		// this jar file copied manually!
//		String jar = "jar:file:xxx/org.osate.workspace_1.0.0.v20180511-1311.jar!/";
		// XtextResourceSet also supports classpath:/
		String jar = "classpath:/";

		String path = "resources/properties/Predeclared_Property_Sets/";

		URI psURI1 = URI.createURI(jar + path + "AADL_Project.aadl");
		URI psURI2 = URI.createURI(jar + path + "Programming_Properties.aadl");

		// Load the resources

		System.out.println("Loading...");
		Resource res;

		res = rs.getResource(psURI1, true);
		System.out.println("..." + res.getURI());

		res = rs.getResource(psURI2, true);
		System.out.println("..." + res.getURI());

		for (int i = 0; i < args.length; i++) {
			res = rs.getResource(URI.createPlatformResourceURI(args[i], true), true);
			System.out.println("..." + res.getURI());
		}

		// set up URI mappings for reference resolution
		final Map<URI, URI> uriMap = rs.getURIConverter().getURIMap();
		// mapped URIs end in '/' => prefix mapping
		uriMap.put(URI.createPlatformPluginURI("/org.osate.workspace/", false), URI.createURI(jar));

		System.out.println();
		System.out.println("Validating...");
		for (final Resource resource : rs.getResources()) {
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

		IResourceDescriptionsProvider rdp = injector.getInstance(IResourceDescriptionsProvider.class);
		IResourceDescriptions descs = rdp.getResourceDescriptions(rs);
		for (IEObjectDescription eod : descs.getExportedObjectsByType(Aadl2Package.eINSTANCE.getProperty())) {
			System.out.println(eod.getQualifiedName());
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
