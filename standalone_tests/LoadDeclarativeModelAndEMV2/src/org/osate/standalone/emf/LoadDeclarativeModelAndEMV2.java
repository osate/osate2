package org.osate.standalone.emf;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
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
import org.osate.annexsupport.AnnexRegistry;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;

import com.google.inject.Injector;

public final class LoadDeclarativeModelAndEMV2 {
	public static void main(String[] args) {
		try {
			// Read the meta information about the plug-ins to get the annex information
			AnnexRegistry.process();

			final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();
			ErrorModelStandaloneSetup.doSetup();

			final XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
			final Resource[] resources = new Resource[args.length];
			for (int i = 0; i < args.length; i++) {
				resources[i] = rs.getResource(URI.createURI(args[i]), true);
			}

			System.out.println("Loading...");
			for (final Resource resource : resources) {
				try {
					resource.load(null);
				} catch (final IOException e) {
					System.err.println("ERROR LOADING RESOURCE: " + e.getMessage());
				}
			}

			System.out.println();
			System.out.println("Validating...");
			for (final Resource resource : resources) {
				// Validation
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
		} catch (final CoreException | IOException e) {
			System.err.println("ERROR INITIALIZING THE EXTENSION REGISTRY");
			e.printStackTrace(System.err);
		}
	}
}
