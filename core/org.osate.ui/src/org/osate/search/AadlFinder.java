package org.osate.search;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

public final class AadlFinder {
	private static final AadlFinder instance = new AadlFinder();

	@Inject
	private IResourceDescriptionsProvider resourcesDescriptionProvider;

	private AadlFinder() {
		final Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		injector.injectMembers(this);
	}

	public static AadlFinder getInstance() {
		return instance;
	}

	/**
	 * Get all the {@link Classifier}s in the workspace.
	 */
	public EList<IEObjectDescription> getAllClassifiersInWorkspace() {
		final EList<IEObjectDescription> classifiers = new BasicEList<IEObjectDescription>();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(OsateResourceUtil.getResourceSet());
		for (final IEObjectDescription eod : resourceDescriptions
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier())) {
			classifiers.add(eod);
		}
		return classifiers;
	}

	/**
	 * Get all the {@link Property} Declarations in the workspace.
	 */
	public EList<IEObjectDescription> getAllPropertyDeclarationsInWorkspace() {
		final EList<IEObjectDescription> classifiers = new BasicEList<IEObjectDescription>();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(OsateResourceUtil.getResourceSet());
		for (final IEObjectDescription eod : resourceDescriptions
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getProperty())) {
			classifiers.add(eod);
		}
		return classifiers;
	}

	public void doStuff() {
		final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(resourceSet);
		for (final IResourceDescription rsrcDesc : resourceDescriptions.getAllResourceDescriptions()) {
			System.out.println(">>> " + rsrcDesc.getURI());
			for (final IReferenceDescription refDesc : rsrcDesc.getReferenceDescriptions()) {
				System.out.println("  Source: " + resourceSet.getEObject(refDesc.getSourceEObjectUri(), true));
				System.out.println("  Target: " + resourceSet.getEObject(refDesc.getTargetEObjectUri(), true));
//				System.out.println(refDesc.getSourceEObjectUri() + " -> " + refDesc.getTargetEObjectUri());
//				System.out.println("  Container URI: " + refDesc.getContainerEObjectURI());
//				System.out.println("  EReference: " + refDesc.getEReference());
			}
		}
	}
}
