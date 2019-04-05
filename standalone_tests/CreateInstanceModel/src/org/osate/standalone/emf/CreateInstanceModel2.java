package org.osate.standalone.emf;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;

// Takes the name of a declarative file, and the name of a SystemImplementation
public final class CreateInstanceModel2 {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println(
					"Need <declarative file> ... <declarative file> <name of system implementation (must be from the FIRST file)>");
			return;
		}

		// Init the AADL2 meta model
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		// Init the instance model -- need both these lines
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
		InstancePackage.eINSTANCE.eClass();

		// Load the declarative files
		final XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		final Resource[] resources = new Resource[args.length - 1];
		for (int i = 0; i < args.length - 1; i++) {
			resources[i] = rs.getResource(URI.createURI(args[i]), true);
			try {
				resources[i].load(null);
				System.out.println(resources[i].getContents().get(0));
			} catch (final IOException e) {
				System.err.println("Error loading " + args[i]);
				e.printStackTrace();
			}
		}

		// find the system implementation
		final AadlPackage aadlPackage = (AadlPackage) resources[0].getContents().get(0);
		final String systemImplName = args[args.length - 1];
		SystemImplementation systemImpl = null;
		System.out.println("Looking for " + systemImplName);
		for (final Classifier classifier : aadlPackage.getPublicSection().getOwnedClassifiers()) {
			if (systemImplName.equalsIgnoreCase(classifier.getName())) {
				systemImpl = (SystemImplementation) classifier;
				break;
			}
		}

		if (systemImpl == null) {
			System.err.println("Couldn't find " + systemImplName);
			return;
		}

		// Create the instance model
		try {
			final SystemInstance systemInstance = InstantiateModel.instantiate(systemImpl);
			System.out.println(systemInstance);
			for (final ComponentInstance ci : systemInstance.getAllComponentInstances()) {
				System.out.println("  " + ci);
			}
		} catch (final Exception e) {
			System.err.println("Error during instantiation " + e);
			e.printStackTrace();
		}
	}
}
