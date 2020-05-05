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
package org.osate.ge.internal.graphiti.features;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.Names;
import org.osate.ge.di.Rename;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.ReferenceCollection;
import org.osate.ge.internal.services.DiagramService.UpdatedReferenceValueProvider;
import org.osate.ge.internal.ui.LtkRenameAction;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.util.AnnotationUtil;
import org.osate.ge.internal.util.ProjectUtil;
import org.osate.ge.internal.util.RenameUtil;
import org.osate.ge.services.ReferenceBuilderService;

// Direct Editing Feature implementation that uses Xtext/LTK refactoring to rename an element.
// Uses business Object Handlers to determine if an element can be renamed.
// Only supports NamedElement objects.
public class BoHandlerDirectEditFeature extends AbstractDirectEditingFeature {
	// Property for the context to specify whether the feature should require the specified pictogram element to be the primary label. Defaults to true.
	public static final String PROPERTY_REQUIRE_PRIMARY_LABEL = "org.osate.ge.require_primary_label";

	private final GraphitiService graphitiService;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramService diagramService;
	private final ReferenceBuilderService referenceBuilderService;
	private final ModelChangeNotifier modelChangeNotifier;

	@Inject
	public BoHandlerDirectEditFeature(final IFeatureProvider fp,
			final GraphitiService graphitiService,
			final ExtensionService extService, final AadlModificationService aadlModService,
			final DiagramService diagramService, final ReferenceBuilderService referenceBuilderService,
			final ModelChangeNotifier modelChangeNotifier) {
		super(fp);
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
		this.referenceBuilderService = Objects.requireNonNull(referenceBuilderService,
				"referenceBuilderService must not be null");
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier must not be null");
	}

	@Override
	public boolean canDirectEdit(final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		if(de == null) {
			return false;
		}

		final Object bo = de.getBusinessObject();

		// Only EObjects are supported at this time
		if (!(bo instanceof EObject)) {
			return false;
		}

		final Object handler = de.getBusinessObjectHandler();
		if (!RenameUtil.hasValidateNameMethod(handler)) {
			return false;
		}

		if (!AnnotationUtil.hasMethodWithAnnotation(Rename.class, handler)
				&& RenameUtil.getRenameRefactoring(bo) == null) {
			return false;
		}

		// Ensure that the specified pictogram elmenet is a primary label unless the context contains a property specifying otherwise.
		if (!Boolean.FALSE.equals(context.getProperty(PROPERTY_REQUIRE_PRIMARY_LABEL))) {
			if (!ShapeNames.primaryLabelShapeName.equals(PropertyUtil.getName(context.getPictogramElement()))) {
				return false;
			}
		}

		final IEclipseContext childCtx = extService.createChildContext();
		boolean canRename = true;
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.BUSINESS_OBJECT_CONTEXT, de);
			canRename = (boolean)ContextInjectionFactory.invoke(handler, CanRename.class, childCtx, true);
			if(!canRename) {
				return false;
			}
		} finally {
			childCtx.dispose();
		}

		return true;
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}

	@Override
	public String checkValueValid(final String value, final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		if(de == null) {
			return "Unable to get diagram element.";
		}

		return RenameUtil.checkNewNameValidity(de.getBusinessObject(), de.getBusinessObjectHandler(), value,
				graphitiService.getProject(), extService);
	}

	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		return RenameUtil.getCurrentEditingName(de.getBusinessObject(), de.getBusinessObjectHandler(),
				extService, de.getLabelName());
	}

	@Override
	public void setValue(final String value, final IDirectEditingContext context) {
		final DiagramElement de = graphitiService.getGraphitiAgeDiagram().getClosestDiagramElement(context.getPictogramElement());
		final EObject bo = (EObject) de.getBusinessObject();
		final Object handler = de.getBusinessObjectHandler();
		final String initialValue = getInitialValue(context);

		// If the business object handler provides a Rename method, then use it to rename the element instead of using LTK refactoring.
		if (RenameUtil.supportsNonLtkRename(handler)) {
			final CanonicalBusinessObjectReference canonicalRef = referenceBuilderService
					.getCanonicalReference(bo);
			final IProject project = ProjectUtil.getProject(EcoreUtil.getURI(bo));
			final ReferenceCollection references;
			if (canonicalRef == null || project == null) {
				references = null;
			} else {
				final Set<IProject> relevantProjects = ProjectUtil.getAffectedProjects(project, new HashSet<>());
				references = diagramService.getReferences(relevantProjects,
						Collections.singleton(canonicalRef));
			}

			aadlModService.modify(bo, (boToModify) -> {
				RenameUtil.performNonLtkRename(boToModify, handler, value, extService);

				// Update diagram references. This is done in the modify block because the project is build and the diagram is updated before the modify()
				// function returns.
				final CanonicalBusinessObjectReference newCanonicalRef = referenceBuilderService
						.getCanonicalReference(boToModify);
				final RelativeBusinessObjectReference newRelRef = referenceBuilderService
						.getRelativeReference(boToModify);

				if (newCanonicalRef != null && newRelRef != null) {
					references.update(new UpdatedReferenceValueProvider() {
						@Override
						public CanonicalBusinessObjectReference getNewCanonicalReference(
								final CanonicalBusinessObjectReference originalCanonicalReference) {
							if (originalCanonicalReference.equals(canonicalRef)) {
								return newCanonicalRef;
							}

							return null;
						}

						@Override
						public RelativeBusinessObjectReference getNewRelativeReference(
								final CanonicalBusinessObjectReference originalCanonicalReference) {
							if (originalCanonicalReference.equals(canonicalRef)) {
								return newRelRef;
							}

							return null;
						}
					});
				}
			});
		} else { // Rename using LTK
			graphitiService.execute("Rename Element " + initialValue + " to " + value,
					ActionExecutor.ExecutionMode.NORMAL,
					new LtkRenameAction(graphitiService, modelChangeNotifier, new BoSupplier(de), value, initialValue));
		}
	}

	/**
	 * Supplier that returns the latest business object from a diagram element but prevents memory leaks by only retaining a
	 * weak reference to the diagram element.
	 *
	 */
	private static class BoSupplier implements LtkRenameAction.BusinessObjectSupplier {
		private final WeakReference<DiagramElement> weakDiagramElement;

		public BoSupplier(final DiagramElement diagramElement) {
			this.weakDiagramElement = new WeakReference<>(
					Objects.requireNonNull(diagramElement, "diagramElement must not be null"));
		}

		@Override
		public EObject getBusinessObject(final String currentName) {
			final DiagramElement de = weakDiagramElement.get();
			if (de == null) {
				return null;
			}

			final Object bo = de.getBusinessObject();
			return bo instanceof EObject ? (EObject) bo : null;
		}
	}
}
