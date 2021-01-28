/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.internal.util.classifiers;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.util.AadlClassifierUtil;
import org.osate.ge.aadl2.internal.util.AadlImportsUtil;
import org.osate.ge.aadl2.internal.util.AadlNameUtil;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResultBuilder;

public class ClassifierOperationExecutor {
	private final ClassifierCreationHelper classifierCreationHelper;
	private final IProject project;

	public ClassifierOperationExecutor(final ResourceSet resourceSet,
			final IProject project) {
		Objects.requireNonNull(resourceSet, "resourceSet must not be null");
		this.project = Objects.requireNonNull(project, "project must not be null");
		this.classifierCreationHelper = new ClassifierCreationHelper(resourceSet);
	}

	public OperationBuilder<Classifier> execute(final OperationBuilder<?> operation,
			final ClassifierOperation classifierOp,
			final BusinessObjectContext primaryPkgBoc) {
		final OperationBuilder<Classifier> baseOp = addStep(operation, classifierOp.getBasePart(), null, null);
		return addStep(baseOp, classifierOp.getPrimaryPart(), classifierOp.getBasePart(), primaryPkgBoc);
	}

	/**
	 *
	 * @param operation
	 * @param part
	 * @param basePart
	 * @param pkgBoc if non-null then the operation result will indicate that the object should be added to the diagram.
	 * @return
	 */
	private OperationBuilder<Classifier> addStep(final OperationBuilder<?> operation,
			final ClassifierOperationPart part,
			final ClassifierOperationPart basePart, final BusinessObjectContext pkgBoc) {
		Objects.requireNonNull(part, "part must not be null");
		Objects.requireNonNull(part.getType(), "operation part type must not be null");

		switch (part.getType()) {
		case EXISTING:
			return operation.supply(() -> StepResultBuilder
					.create(classifierCreationHelper.getResolvedClassifier(part.getSelectedClassifier())).build());

		case NEW_COMPONENT_IMPLEMENTATION:
		case NEW_COMPONENT_TYPE:
		case NEW_FEATURE_GROUP_TYPE:
			final EClass creationEClass = getCreationEClass(part);

			final PackageSection unmodifiableSection = classifierCreationHelper
					.getResolvedPublicSection(part.getSelectedPackage());

			return operation.modifyModel(unmodifiableSection, (tag, prevResult) -> tag, (tag, section, prevResult) -> {
				// Create the new classifier
				final Classifier newClassifier = section.createOwnedClassifier(creationEClass);

				// Set name
				newClassifier.setName(classifierCreationHelper.getName(part, basePart));

				final Classifier baseOperationResult = resolveWithLiveResourceSetOrThrowIfProxy(
						(Classifier) prevResult);

				// Handle component implementations
				if (newClassifier instanceof ComponentImplementation) {
					final ComponentImplementation newImpl = (ComponentImplementation) newClassifier;
					final ComponentType baseComponentType;
					if (baseOperationResult instanceof ComponentType) {
						final Realization realization = newImpl.createOwnedRealization();
						baseComponentType = (ComponentType) baseOperationResult;
						realization.setImplemented(baseComponentType);
					} else if (baseOperationResult instanceof ComponentImplementation) {
						final ComponentImplementation baseImpl = (ComponentImplementation) baseOperationResult;
						final ImplementationExtension extension = newImpl.createOwnedExtension();
						extension.setExtended(baseImpl);

						final Realization realization = newImpl.createOwnedRealization();
						realization.setImplemented(baseImpl.getType());

						baseComponentType = baseImpl.getType();

						// Import the base implementation's package
						final AadlPackage baseImplPkg = (AadlPackage) baseImpl.getNamespace().getOwner();
						AadlImportsUtil.addImportIfNeeded(section, baseImplPkg);
					} else {
						throw new RuntimeException("Invalid base classifier: " + baseOperationResult);
					}

					// Get the base component type
					if (baseComponentType == null) {
						throw new RuntimeException("Unable to determine base component type");
					}

					if (!AadlNameUtil.namesAreEqual(section, baseComponentType.getNamespace())) {
						// Import the package if necessary
						final AadlPackage baseComponentTypePkg = (AadlPackage) baseComponentType.getNamespace()
								.getOwner();
						AadlImportsUtil.addImportIfNeeded(section, baseComponentTypePkg);

						// Create an alias for the component type
						final ClassifierCreationHelper.RenamedTypeDetails aliasDetails = classifierCreationHelper
								.getRenamedType(section, baseComponentTypePkg, baseComponentType.getName());
						if (!aliasDetails.exists) {
							final ComponentTypeRename ctr = section.createOwnedComponentTypeRename();
							ctr.setName(aliasDetails.aliasName);
							ctr.setCategory(baseComponentType.getCategory());
							ctr.setRenamedComponentType(baseComponentType);
						}
					}

				} else if (newClassifier instanceof ComponentType && baseOperationResult instanceof ComponentType) {
					final ComponentType newType = (ComponentType) newClassifier;
					final TypeExtension extension = newType.createOwnedExtension();
					extension.setExtended((ComponentType) baseOperationResult);
				} else if (newClassifier instanceof FeatureGroupType
						&& baseOperationResult instanceof FeatureGroupType) {
					final FeatureGroupType newFgt = (FeatureGroupType) newClassifier;
					final GroupExtension extension = newFgt.createOwnedExtension();
					extension.setExtended((FeatureGroupType) baseOperationResult);
				}

				final StepResultBuilder<Classifier> resultBuilder = StepResultBuilder.create(newClassifier);

				// Hint for adding to diagram
				if (pkgBoc != null && newClassifier != null) {
					resultBuilder.showNewBusinessObject(pkgBoc, newClassifier);
				}

				return resultBuilder.build();
			});

		case NONE:
			return operation.map(prevResult -> StepResultBuilder.create((Classifier) null).build());

		default:
			throw new RuntimeException("Unexpected operation: " + part.getType());
		}

	}

// Resolves the classifier using a new resource set. Using the ClassifierCreationHelper to resolve the base classifier does not
// work if the classifier was just created. Throws if the classifier is a proxy and cannot be resolved
	private Classifier resolveWithLiveResourceSetOrThrowIfProxy(final Classifier c) {
		if (c == null || !c.eIsProxy()) {
			return c;
		}

		// Resolve the base classifier using a new resource set. Using the ClassifierCreationHelper to resolve the base classifier does not
		// work if the classifier was just created.
		final ResourceSet liveResourceSet = AadlModelAccessUtil.getLiveResourceSet(project);

		final Classifier resolvedClassifier = (Classifier) EcoreUtil.resolve(c, liveResourceSet);
		if (resolvedClassifier == null) {
			throw new RuntimeException("Unable to resolve classifier: " + c);
		}

		return resolvedClassifier;
	}

	private static EClass getCreationEClass(final ClassifierOperationPart configuredOp) {
		switch (configuredOp.getType()) {
		case NEW_COMPONENT_TYPE:
			return AadlClassifierUtil.getComponentTypeEClass(configuredOp.getComponentCategory());

		case NEW_COMPONENT_IMPLEMENTATION:
			return AadlClassifierUtil.getComponentImplementationEClass(configuredOp.getComponentCategory());

		case NEW_FEATURE_GROUP_TYPE:
			return Aadl2Package.eINSTANCE.getFeatureGroupType();

		default:
			return null;
		}
	}
}
