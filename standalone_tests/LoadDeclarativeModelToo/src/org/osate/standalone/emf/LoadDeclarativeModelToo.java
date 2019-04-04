package org.osate.standalone.emf;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;

public final class LoadDeclarativeModelToo {
	public static void main(String[] args) {
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
//		InstancePackage.eINSTANCE.eClass();

//		final ResourceSet rs = new ResourceSetImpl();
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);

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
	}
}
