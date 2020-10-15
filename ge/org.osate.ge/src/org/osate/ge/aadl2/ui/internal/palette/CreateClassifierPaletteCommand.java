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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ProjectUtil;
import org.osate.ge.StringUtil;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.internal.util.AadlClassifierUtil;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierCreationHelper;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperationExecutor;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperationPart;
import org.osate.ge.aadl2.internal.util.classifiers.ClassifierOperationPartType;
import org.osate.ge.aadl2.ui.internal.AadlUiUtil;
import org.osate.ge.aadl2.ui.internal.dialogs.ClassifierOperationDialog;
import org.osate.ge.aadl2.ui.internal.dialogs.DefaultCreateSelectClassifierDialogModel;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

import com.google.common.collect.ImmutableList;

public class CreateClassifierPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	private static final StandaloneQuery packageQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof AadlPackage));

	private final EClass classifierEClass;
	private final ComponentCategory componentCategory; // Will be null for feature group types
	private final boolean componentImplementation;

	public CreateClassifierPaletteCommand(final ComponentCategory componentCategory, final boolean implementation) {
		this(implementation ? AadlClassifierUtil.getComponentImplementationEClass(componentCategory)
				: AadlClassifierUtil.getComponentTypeEClass(componentCategory), componentCategory, implementation);
	}

	private CreateClassifierPaletteCommand(final EClass eClass, final ComponentCategory componentCategory,
			final boolean componentImplementation) {
		super(StringUtil.camelCaseToUser(eClass.getName()),
				AadlPaletteCategories.CLASSIFIERS,
				AadlImages.getImage(eClass));
		this.classifierEClass = eClass;
		this.componentCategory = componentCategory;
		this.componentImplementation = componentImplementation;
	}

	public static CreateClassifierPaletteCommand createFeatureGroupTypeCommand() {
		return new CreateClassifierPaletteCommand(Aadl2Package.eINSTANCE.getFeatureGroupType(), null, false);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(EObject.class).map(targetBo -> {
			if (!(targetBo instanceof AadlPackage || isValidBaseClassifier(targetBo))) {
				return null;
			}

			final BusinessObjectContext pkgBoc = getPackageBoc(ctx.getTarget(), ctx.getQueryService());
			if (pkgBoc == null) {
				return null;
			}

			final AadlPackage pkg = (AadlPackage) pkgBoc.getBusinessObject();
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
			final ResourceSet rs = targetBo.eResource().getResourceSet();

			return Operation.createWithBuilder(builder -> {
				builder.supply(() -> {
					final ClassifierOperation args = buildCreateOperations(pkg, targetBo, project, rs);
					if (args == null) {
						return StepResult.abort();
					}

					return StepResult.forValue(args);
				}).executeOperation(classifierOp -> Operation.createWithBuilder(innerBuilder -> {
					final ClassifierOperationExecutor opExec = new ClassifierOperationExecutor(rs, project);
					opExec.execute(innerBuilder, classifierOp, pkgBoc);
				}));
			});
		});
	}

	/**
	 * Build the operation that will be executed to create the classifier.
	 * Returns null if the operation could not be created. For example: if the dialog was canceled.
	 * @param pkg
	 * @param targetBo
	 * @param classifierType
	 * @param project
	 * @param namingService
	 * @param rs
	 * @return
	 */
	private ClassifierOperation buildCreateOperations(final AadlPackage pkg, final EObject targetBo,
			final IProject project, final ResourceSet rs) {
		final ClassifierCreationHelper classifierCreationHelper = new ClassifierCreationHelper(rs);

		// Handle case where target is a valid base classifier for quick creation.
		// Determine if the container is a valid base classifier
		final boolean targetIsValidBase = isValidBaseClassifier(targetBo);
		if (targetIsValidBase || !componentImplementation) {
			//
			// Create the base operation part
			//
			final EObject baseClassifier = targetIsValidBase ? targetBo : null;
			final ClassifierOperationPart basePart = baseClassifier == null ? ClassifierOperationPart.createNone()
					: ClassifierOperationPart.createExisting(baseClassifier);

			//
			// Create the primary operation part
			//
			final ClassifierOperationPartType primaryType;
			final ComponentCategory primaryComponentCategory;
			if (componentCategory == null) {
				primaryType = ClassifierOperationPartType.NEW_FEATURE_GROUP_TYPE;
				primaryComponentCategory = null;
			} else {
				primaryType = componentImplementation
						? ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION
								: ClassifierOperationPartType.NEW_COMPONENT_TYPE;
				primaryComponentCategory = componentCategory;
			}

			final String defaultIdentifier = componentImplementation ? "impl" : "new_classifier";

			// Determine a unique name for the classifier
			final String potentialFullName = classifierCreationHelper.buildName(primaryType, pkg, defaultIdentifier,
					basePart);
			if (potentialFullName == null) {
				return null;
			}

			final String newName = AadlNamingUtil.buildUniqueIdentifier(pkg.getPublicSection(), potentialFullName);

			// Retrieve the identifier to be used for creation. For component implementations this is the part after the ".". For other types, it is the entire
			// name
			final String[] nameSegments = newName.split("\\.");
			final String primaryIdentifier = nameSegments[nameSegments.length - 1];

			final ClassifierOperationPart configuredPrimaryOperation = ClassifierOperationPart
					.createCreation(primaryType, pkg, primaryIdentifier, primaryComponentCategory);

			return new ClassifierOperation(configuredPrimaryOperation, basePart);
		} else {
			final ClassifierOperationDialog.Model model = new DefaultCreateSelectClassifierDialogModel(rs,
					"Configure component implementation.") {
				@Override
				public String getTitle() {
					return "Create Component Implementation";
				}

				@Override
				public Collection<?> getPackageOptions() {
					return AadlUiUtil.getEditablePackages(project);
				}

				@Override
				public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return AadlUiUtil.getValidBaseClassifierDescriptions(project, componentCategory, true);
				}

				@Override
				public Collection<?> getUnfilteredBaseSelectOptions(
						final ClassifierOperationPartType primaryOperation) {
					return null;
				}
			};

			// Show the dialog to determine the operation
			return ClassifierOperationDialog.show(Display.getCurrent().getActiveShell(),
					new ClassifierOperationDialog.ArgumentBuilder(model,
							EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION)).defaultPackage(pkg)
					.showPrimaryPackageSelector(false)
					.componentCategories(ImmutableList.of(componentCategory)).create());
		}
	}

	private BusinessObjectContext getPackageBoc(final BusinessObjectContext targetBoc,
			final QueryService queryService) {
		final Object targetBo = targetBoc.getBusinessObject();
		if (targetBo instanceof AadlPackage) {
			return targetBoc;
		} else if (targetBo instanceof Classifier) {
			// Get the AadlPackage based on the query. This ensures that the package is the one represented by the diagram rather than the one in which the
			// target business object is contained.
			return queryService.getFirstBusinessObjectContextOrNull(packageQuery, targetBoc);
		}

		return null;
	}

	private boolean isValidBaseClassifier(final EObject containerBo) {
		final EClass containerType = containerBo.eClass();

		// Determine if the container is a valid base classifier
		boolean containerIsValidBaseClassifier = false;
		if (componentImplementation) {
			for (final EClass superType : classifierEClass.getESuperTypes()) {
				if (!Aadl2Package.eINSTANCE.getComponentImplementation()
						.isSuperTypeOf(superType)) {
					if (superType.isSuperTypeOf(containerType)) {
						containerIsValidBaseClassifier = true;
						break;
					}
				}
			}
		} else {
			containerIsValidBaseClassifier = classifierEClass.isSuperTypeOf(
					containerType)
					|| Aadl2Package.eINSTANCE.getAbstractType().isSuperTypeOf(containerType);
		}

		return containerIsValidBaseClassifier;
	}
}
