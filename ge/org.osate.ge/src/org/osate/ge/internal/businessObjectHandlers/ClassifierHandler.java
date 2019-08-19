/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * This material is based upon work supported by
 * Aviation and Missile Research, Development, and Engineering Command (AMRDEC)
 * under W31P4Q-15-D-0062 TO 0045.
 *******************************************************************************/
package org.osate.ge.internal.businessObjectHandlers;

import java.util.Collection;
import java.util.EnumSet;

import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.ClassifierOperationDialog;
import org.osate.ge.internal.ui.dialogs.DefaultCreateSelectClassifierDialogModel;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.ge.internal.util.classifiers.ClassifierCreationHelper;
import org.osate.ge.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.internal.util.classifiers.ClassifierOperationExecutor;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPart;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;
import org.osate.ge.operations.Operation;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

import com.google.common.collect.ImmutableList;

public class ClassifierHandler {
	private static final StandaloneQuery packageQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof AadlPackage));

	private interface PaletteEntryContext {
		EClass getEClass();

		default boolean isComponentImplementation() {
			return false;
		}
	}

	private static class FeatureGroupPaletteEntryContext implements PaletteEntryContext {
		@Override
		public EClass getEClass() {
			return Aadl2Package.eINSTANCE.getFeatureGroupType();
		}
	}

	private static class ComponentPaletteEntryContext implements PaletteEntryContext {
		public final ComponentCategory componentCategory;
		public final boolean implementation;

		public ComponentPaletteEntryContext(final ComponentCategory componentCategory, final boolean implementation) {
			this.componentCategory = componentCategory;
			this.implementation = implementation;
		}

		@Override
		public EClass getEClass() {
			if (implementation) {
				return AadlClassifierUtil.getComponentImplementationEClass(componentCategory);
			} else {
				return AadlClassifierUtil.getComponentTypeEClass(componentCategory);
			}
		}

		@Override
		public boolean isComponentImplementation() {
			return implementation;
		}
	}

	@IsApplicable
	@CanRename
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Classifier bo) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) AadlPackage pkg) {
		return new PaletteEntry[] {
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.ABSTRACT, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.ABSTRACT, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.BUS, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.BUS, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.DATA, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.DATA, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.DEVICE, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.DEVICE, true)),
				createPaletteEntry(new FeatureGroupPaletteEntryContext()),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.MEMORY, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.MEMORY, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.PROCESS, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.PROCESS, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.PROCESSOR, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.PROCESSOR, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.SUBPROGRAM, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.SUBPROGRAM, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.SUBPROGRAM_GROUP, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.SUBPROGRAM_GROUP, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.SYSTEM, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.SYSTEM, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.THREAD, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.THREAD, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.THREAD_GROUP, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.THREAD_GROUP, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.VIRTUAL_BUS, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.VIRTUAL_BUS, true)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.VIRTUAL_PROCESSOR, false)),
				createPaletteEntry(new ComponentPaletteEntryContext(ComponentCategory.VIRTUAL_PROCESSOR, true))
		};
	}

	private static PaletteEntry createPaletteEntry(final PaletteEntryContext ctx) {
		final EClass eClass = ctx.getEClass();
		return PaletteEntryBuilder.create().label(StringUtil.camelCaseToUser(eClass.getName()))
				.icon(ImageHelper.getImage(eClass.getName())).category(Categories.CLASSIFIERS).context(ctx)
				.build();
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) EObject bo,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) PaletteEntryContext paletteEntryContext) {
		return bo instanceof AadlPackage || isValidBaseClassifier(bo, paletteEntryContext.getEClass());
	}

	private boolean isValidBaseClassifier(final EObject containerBo, final EClass classifierType) {
		final EClass containerType = containerBo.eClass();

		// Determine if the container is a valid base classifier
		boolean containerIsValidBaseClassifier = false;
		if(isComponentImplementation(classifierType)) {
			for(final EClass superType : classifierType.getESuperTypes()) {
				if(!Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(superType)) {
					if(superType.isSuperTypeOf(containerType)) {
						containerIsValidBaseClassifier = true;
						break;
					}
				}
			}
		} else {
			containerIsValidBaseClassifier = classifierType.isSuperTypeOf(containerType) || Aadl2Factory.eINSTANCE.getAadl2Package().getAbstractType().isSuperTypeOf(containerType);
		}

		return containerIsValidBaseClassifier;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(@Named(Names.TARGET_BO) final EObject targetBo,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) PaletteEntryContext paletteEntryContext,
			final @Named(InternalNames.PROJECT) IProject project,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc,
			final QueryService queryService,
			final NamingService namingService) {
		final BusinessObjectContext pkgBoc = getPackageBoc(targetBoc, queryService);
		if (pkgBoc == null) {
			return null;
		}

		final AadlPackage pkg = (AadlPackage) pkgBoc.getBusinessObject();
		final ResourceSet rs = targetBo.eResource().getResourceSet();
		final ClassifierOperation args = buildCreateOperations(pkg, targetBo, paletteEntryContext, project,
				namingService, rs);
		if (args == null) {
			return null;
		}

		return Operation.create(createOp -> {
			final ClassifierOperationExecutor opExec = new ClassifierOperationExecutor(namingService, rs, project);
			opExec.execute(createOp, args, pkgBoc);
		});
	}

	private BusinessObjectContext getPackageBoc(final BusinessObjectContext targetBoc,
			final QueryService queryService) {
		final Object targetBo = targetBoc.getBusinessObject();
		if(targetBo instanceof AadlPackage) {
			return targetBoc;
		} else if(targetBo instanceof Classifier) {
			// Get the AadlPackage based on the query. This ensures that the package is the one represented by the diagram rather than the one in which the
			// target business object is contained.
			return queryService.getFirstResult(packageQuery, targetBoc);
		}

		return null;
	}

	/**
	 * Build the operation that will be executed to create the classifier.
	 * Returns null if the operation could not be created. For example: if the dialog was canceled.
	 * @param pkg
	 * @param targetBo
	 * @param paletteEntryContext
	 * @param project
	 * @param namingService
	 * @param rs
	 * @return
	 */
	private ClassifierOperation buildCreateOperations(final AadlPackage pkg,
			final EObject targetBo, final PaletteEntryContext paletteEntryContext,
			final IProject project, final NamingService namingService, final ResourceSet rs) {
		final EClass classifierType = paletteEntryContext.getEClass();

		final ClassifierCreationHelper classifierCreationHelper = new ClassifierCreationHelper(namingService, rs);

		// Handle case where target is a valid base classifier for quick creation.
		// Determine if the container is a valid base classifier
		final boolean targetIsValidBase = isValidBaseClassifier(targetBo, classifierType);
		if (targetIsValidBase || !paletteEntryContext.isComponentImplementation()) {
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
			if (paletteEntryContext instanceof FeatureGroupPaletteEntryContext) {
				primaryType = ClassifierOperationPartType.NEW_FEATURE_GROUP_TYPE;
				primaryComponentCategory = null;
			} else if (paletteEntryContext instanceof ComponentPaletteEntryContext) {
				final ComponentPaletteEntryContext componentPaletteEntryContext = (ComponentPaletteEntryContext) paletteEntryContext;
				primaryType = componentPaletteEntryContext.isComponentImplementation()
						? ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION
								: ClassifierOperationPartType.NEW_COMPONENT_TYPE;
				primaryComponentCategory = componentPaletteEntryContext.componentCategory;
			} else {
				throw new RuntimeException("Unsupported palette entry context: " + paletteEntryContext);
			}

			final String defaultIdentifier = paletteEntryContext.isComponentImplementation() ? "impl"
					: "new_classifier";

			// Determine a unique name for the classifier
			final String potentialFullName = classifierCreationHelper.buildName(primaryType, pkg, defaultIdentifier,
					basePart);
			if (potentialFullName == null) {
				return null;
			}

			final String newName = namingService.buildUniqueIdentifier(pkg.getPublicSection(), potentialFullName);

			// Retrieve the identifier to be used for creation. For component implementations this is the part after the ".". For other types, it is the entire
			// name
			final String[] nameSegments = newName.split("\\.");
			final String primaryIdentifier = nameSegments[nameSegments.length - 1];

			final ClassifierOperationPart configuredPrimaryOperation = ClassifierOperationPart
					.createCreation(primaryType, pkg, primaryIdentifier, primaryComponentCategory);

			return new ClassifierOperation(configuredPrimaryOperation, basePart);
		} else {
			final ComponentPaletteEntryContext componentPaletteEntryCtx = (ComponentPaletteEntryContext) paletteEntryContext;

			final ClassifierOperationDialog.Model model = new DefaultCreateSelectClassifierDialogModel(namingService,
					rs, "Configure component implementation.") {
				@Override
				public String getTitle() {
					return "Create Component Implementation";
				}

				@Override
				public Collection<?> getPackageOptions() {
					return AadlHelper.getEditablePackages(project);
				}

				@Override
				public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return AadlClassifierUtil.getValidBaseClassifierDescriptions(project,
							componentPaletteEntryCtx.componentCategory, true);
				}

				@Override
				public Collection<?> getUnfilteredBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return null;
				}
			};

			// Show the dialog to determine the operation
			return ClassifierOperationDialog.show(Display.getCurrent().getActiveShell(),
					new ClassifierOperationDialog.ArgumentBuilder(model,
							EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION)).defaultPackage(pkg)
					.showPrimaryPackageSelector(false)
					.componentCategories(ImmutableList.of(componentPaletteEntryCtx.componentCategory))
									.create());
		}
	}

	private static boolean isComponentImplementation(EClass classifierType) {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getComponentImplementation().isSuperTypeOf(classifierType);
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Classifier bo) {
		return GraphicalConfigurationBuilder.create().
				graphic(AadlGraphics.getGraphic(bo)).
				style(AadlGraphics.getStyle(bo)).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Classifier classifier) {
		return classifier.getName();
	}

	@GetNameForEditing
	public String getName(final @Named(Names.BUSINESS_OBJECT) ComponentImplementation ci) {
		return ci.getImplementationName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) Classifier classifier, final @Named(Names.NAME) String value, final NamingService namingService) {
		final String newFullName;
		final String oldName;

		// Transform value so that is is the full name
		if(classifier instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)classifier;
			newFullName = ci.getTypeName() + "." + value;
			oldName = ci.getImplementationName();
		} else {
			newFullName = value;
			oldName = classifier.getName();
		}

		// If the name hasn't changed or has only changed case
		if(value.equalsIgnoreCase(oldName)) {
			return null;
		}

		// Check if the value matches the format for AADL identifiers
		if(!namingService.isValidIdentifier(value)) {
			return "The specified name is not a valid AADL identifier";
		}

		// Check for conflicts in the namespace
		if(namingService.isNameInUse(classifier.getNamespace(), newFullName)) {
			return "The specified name conflicts with an existing member of the namespace.";
		}

		// The value is valid
		return null;
	}
}
