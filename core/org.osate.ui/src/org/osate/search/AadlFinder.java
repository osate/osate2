package org.osate.search;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

public final class AadlFinder {
	private static final AadlFinder instance = new AadlFinder();

	@Inject
	private ResourceDescriptionsProvider resourcesDescriptionProvider;

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

}
