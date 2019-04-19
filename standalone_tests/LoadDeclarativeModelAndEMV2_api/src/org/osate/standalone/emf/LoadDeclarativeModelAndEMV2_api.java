package org.osate.standalone.emf;

import java.io.IOException;
import java.util.List;

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
import org.osate.xtext.aadl2.errormodel.parsing.EMV2AnnexLinkingService;
import org.osate.xtext.aadl2.errormodel.parsing.EMV2AnnexParser;
import org.osate.xtext.aadl2.errormodel.parsing.EMV2AnnexUnparser;

import com.google.inject.Injector;

public final class LoadDeclarativeModelAndEMV2_api {
	public static void main(String[] args) {
		// Init the XText/EMF meta model
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();
		ErrorModelStandaloneSetup.doSetup();

		// Add the EMV2 annex handling
		AnnexRegistry.registerProxy(AnnexRegistry.ANNEX_PARSER_EXT_ID, "EMV2", new EMV2AnnexParser());
		AnnexRegistry.registerProxy(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID, "EMV2", new EMV2AnnexLinkingService());
		AnnexRegistry.registerProxy(AnnexRegistry.ANNEX_UNPARSER_EXT_ID, "EMV2", new EMV2AnnexUnparser());

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
	}
}
