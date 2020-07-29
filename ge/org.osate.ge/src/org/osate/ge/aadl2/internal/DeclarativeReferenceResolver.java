/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.aadl2.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.PackageSection;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.StringUtil;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.internal.services.AadlResourceService;
import org.osate.ge.internal.services.AadlResourceService.AadlPackageReference;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.ChangeListener;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.referencehandling.CreateReferenceResolverFactoryContext;
import org.osate.ge.referencehandling.ReferenceResolver;
import org.osate.ge.referencehandling.ReferenceResolverFactory;
import org.osate.ge.referencehandling.ResolveContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

// Handles resolving references related to the AADL declarative model
public class DeclarativeReferenceResolver implements ReferenceResolver {
	public static class Factory implements ReferenceResolverFactory {
		@Override
		public ReferenceResolver create(final CreateReferenceResolverFactoryContext ctx) {
			final Bundle bundle = FrameworkUtil.getBundle(Factory.class);
			final AadlResourceService aadlResourceService = Objects.requireNonNull(
					EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(AadlResourceService.class),
					"Unable to get AADL resource service");
			final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
					EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ModelChangeNotifier.class),
					"Unable to get model change notifier");

			return new DeclarativeReferenceResolver(ctx.getProject(), aadlResourceService, modelChangeNotifier);
		}
	}

	// Cache for items that should not change unless models have changed.
	private static class DeclarativeCache {
		private static final EClass aadlPackageEClass = Aadl2Package.eINSTANCE
				.getAadlPackage();
		private final IProject project;

		// Map for caching. Not cleared to ensure strong references to the AadlPackageReference objects exist during the lifetime of the service
		private final Map<String, AadlPackageReference> packageNameToPackageMap = new HashMap<>();
		private Set<IResourceDescription> resourceDescriptions = null; // Resource descriptions for resources which are in the project references path
		private AadlResourceService aadlResourceService;

		public DeclarativeCache(final IProject project, final AadlResourceService aadlResourceService) {
			this.project = Objects.requireNonNull(project, "project must not be null");
			this.aadlResourceService = Objects.requireNonNull(aadlResourceService,
					"aadlResourceService must not be null");
		}

		public void dispose() {
			invalidate();

			// Clear map to remove object references
			packageNameToPackageMap.clear();
		}

		private void invalidate() {
			resourceDescriptions = null;
		}

		public AadlPackage getAadlPackage(final String packageName) {
			final String lowerCasePackageName = packageName.toLowerCase(Locale.ROOT);
			AadlPackageReference pkgRef = packageNameToPackageMap.get(lowerCasePackageName);
			final AadlPackage pkg;
			if (pkgRef == null) {
				pkgRef = findAadlPackage(lowerCasePackageName, getCachedResourceDescriptions(), aadlResourceService);
				if (pkgRef == null) {
					return null;
				}

				pkg = pkgRef.getAadlPackage();

				// If the package is valid. Store the reference
				if (pkg != null) {
					// Store a reference to the package in the cache if the reference was valid
					packageNameToPackageMap.put(lowerCasePackageName, pkgRef);
				}

			} else {
				pkg = pkgRef.getAadlPackage();

				// Remove the package reference if the package is not valid.
				if (pkg == null) {
					packageNameToPackageMap.remove(lowerCasePackageName);
				}
			}

			return pkg;

		}

		/**
		 * Returns an AadlPackageReference depending on whether the package is retrieved from disk or from an Xtext document
		 * @return
		 */
		private static AadlPackageReference findAadlPackage(final String packageName,
				Set<IResourceDescription> resourceDescriptions, final AadlResourceService aadlResourceService) {
			// Get the Xtext Resource for the package
			final String[] pkgNameSegs = packageName.split("::");
			final QualifiedName packageQualifiedName = QualifiedName.create(pkgNameSegs);
			for (final IResourceDescription resDesc : resourceDescriptions) {
				// If there are multiple objects, only check the first one.
				final Iterator<IEObjectDescription> it = resDesc
						.getExportedObjects(aadlPackageEClass, packageQualifiedName, true).iterator();
				if (it.hasNext()) {
					return aadlResourceService.getPackageReference(it.next().getEObjectURI());
				}
			}

			return null;
		}

		private Set<IResourceDescription> getCachedResourceDescriptions() {
			if (resourceDescriptions == null) {
				// Find resources that should be looked in
				resourceDescriptions = AadlModelAccessUtil.calculateVisibleResourceDescriptions(
						project)
						.collect(Collectors.toSet());
			}

			return resourceDescriptions;
		}
	}

	private final ModelChangeNotifier modelChangeNotifier;
	private final DeclarativeCache declarativeCache;
	private final ChangeListener modelChangeListener = new ChangeListener() {
		@Override
		public void modelChanged(final boolean modelWasLocked) {
			invalidateCache();
		}
	};

	public DeclarativeReferenceResolver(final IProject project, final AadlResourceService aadlResourceService,
			final ModelChangeNotifier modelChangeNotifier) {
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier must not be null");
		this.declarativeCache = new DeclarativeCache(project, aadlResourceService);
		modelChangeNotifier.addChangeListener(modelChangeListener);
	}

	@Override
	public void close() {
		modelChangeNotifier.removeChangeListener(modelChangeListener);
		declarativeCache.dispose();
	}

	@Override
	public Optional<Object> resolve(final ResolveContext ctx) {
		final CanonicalBusinessObjectReference ref = ctx.getReference();
		final List<String> refSegs = ref.getSegments();
		if (refSegs.size() < 2) {
			return Optional.empty();
		}

		Object referencedObject = null; // The object that will be returned
		final String type = refSegs.get(0);

		final String qualifiedName = refSegs.get(1);
		if (type.equals(DeclarativeReferenceType.PACKAGE.getId())) {
			referencedObject = getAadlPackage(qualifiedName);
		} else if (type.equals(DeclarativeReferenceType.CLASSIFIER.getId())) {
			referencedObject = getClassifierByQualifiedName(qualifiedName);
		}

		return Optional.ofNullable(referencedObject);
	}

	void invalidateCache() {
		declarativeCache.invalidate();
	}

	private Classifier getClassifierByQualifiedName(final String qualifiedName) {
		final String[] qualifiedNameSegs = qualifiedName.split("::");
		final String packageName = StringUtil.join(qualifiedNameSegs, 0, qualifiedNameSegs.length - 1, "::");
		final String classifierName = qualifiedNameSegs[qualifiedNameSegs.length - 1];

		final AadlPackage pkg = getAadlPackage(packageName);
		if (pkg == null) {
			return null;
		}

		// Return the package if that is the element that was being retrieved
		Classifier classifier = findClassifierByName(pkg.getPublicSection(), classifierName);
		if (classifier == null) {
			classifier = findClassifierByName(pkg.getPrivateSection(), classifierName);
		}

		return classifier;
	}

	public AadlPackage getAadlPackage(final String packageName) {
		return declarativeCache.getAadlPackage(packageName);
	}

	private Classifier findClassifierByName(final PackageSection section, final String classifierName) {
		if (section == null) {
			return null;
		}

		for (final Classifier classifier : section.getOwnedClassifiers()) {
			if (classifierName.equalsIgnoreCase(classifier.getName())) {
				return classifier;
			}
		}

		return null;
	}
}
