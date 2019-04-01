package org.osate.standalone.emf;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;

public final class LoadDeclarativeModelToo {
	public static void main(String[] args) {
		final Inj

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
		InstancePackage.eINSTANCE.eClass();

		final ResourceSet rs = new ResourceSetImpl();

		final Resource[] resources = new Resource[args.length];
		for (int i = 0; i < args.length; i++ ) {
			resources[i] = rs.getResource(URI.createURI(args[i]), true);
		}

		for (int i = 0; i < resources.length; i++) {
			try {
				resources[i].load(null);
				/* Inspect the resource set and see how many files there are */
				for (final EObject eObj : resources[i].getContents()) {
					System.out.println(eObj);
				}
			} catch (final IOException e) {
				System.err.println("ERROR LOADING RESOURCE: " + e.getMessage());
			}
		}
	}
}
