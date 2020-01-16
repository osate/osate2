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

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.DockingPosition;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetBusinessObjectToModify;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.util.AnnotationUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.services.ReferenceBuilderService;

// ICreateFeature implementation that delegates behavior to a business object handler
public class BoHandlerCreateFeature extends AbstractCreateFeature implements Categorized {
	private final GraphitiService graphitiService;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramUpdater diagramUpdater;
	private final ReferenceBuilderService refBuilder;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;

	public BoHandlerCreateFeature(final GraphitiService graphitiService,
			final ExtensionService extService,
			final AadlModificationService aadlModService,
			final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder,
			final IFeatureProvider fp,
			final SimplePaletteEntry paletteEntry,
			final Object boHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiAgeDiagramProvider must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
		this.paletteEntry = Objects.requireNonNull(paletteEntry, "paletteEntry must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
	}

	@Override
	public String getCategory() {
		return paletteEntry.getCategory();
	}

	@Override
	public String getCreateImageId() {
		return paletteEntry.getImageId();
	}

	@Override
	public boolean canCreate(final ICreateContext context) {
		final DiagramNode targetNode = graphitiService.getGraphitiAgeDiagram().getClosestDiagramNode(context.getTargetContainer());
		if(targetNode == null) {
			return false;
		}

		final Object targetBo = targetNode.getBusinessObject();
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());

			// If the target BO is null then do not include it in the context. This allows create features to be used at the root level by using the BOC but
			// preserves compatibility with BO handlers that assume the target BO is not null.
			if (targetBo != null) {
				eclipseCtx.set(Names.TARGET_BO, targetBo);
			}

			eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreate.class, eclipseCtx, false);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public Object[] create(final ICreateContext context) {
		final DiagramNode targetNode = graphitiService.getGraphitiAgeDiagram().getClosestDiagramNode(context.getTargetContainer());
		if(targetNode == null) {
			return EMPTY;
		}

		class CreateAction implements AgeAction {
			private Object[] result = null;

			@Override
			public AgeAction execute() {
				final DockingPosition targetDockingPosition = AgeDiagramUtil.determineDockingPosition(targetNode,
						context.getX(), context.getY(), 0, 0);

				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
					eclipseCtx.set(Names.TARGET_BO, targetNode.getBusinessObject());
					eclipseCtx.set(InternalNames.PROJECT, graphitiService.getProject());
					eclipseCtx.set(Names.DOCKING_POSITION, targetDockingPosition); // Specify even if the shape will not be docked.
					eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);

					final Operation operation;

					// Check if the handler will modify the create operation directly
					if (AnnotationUtil.hasMethodWithAnnotation(BuildCreateOperation.class, handler)) {
						operation = (Operation) ContextInjectionFactory.invoke(handler, BuildCreateOperation.class,
								eclipseCtx);
					} else {
						operation = Operation.create(opBuilder -> {
							// Otherwise, create a single step based on other annotated methods
							final DiagramNode ownerNode = getOwnerDiagramNode(targetNode);
							final EObject boToModify = getBusinessObjectToModify(targetNode,
									ownerNode.getBusinessObject());

							opBuilder.modifyModel(boToModify, (tag, prevResult) -> tag,
									(tag, boToModify1, prevResult) -> {
										eclipseCtx.set(Names.MODIFY_BO, boToModify1);
										final Object newBo1 = ContextInjectionFactory.invoke(handler, Create.class,
												eclipseCtx);
										return StepResultBuilder.create().showNewBusinessObject(ownerNode, newBo1)
												.build();
									});
						});
					}

					if (operation == null) {
						return null;
					}

					// Perform modification
					final OperationExecutor opExecutor = new OperationExecutor(aadlModService);
					opExecutor.execute(operation,
							new GraphitiOperationResultsProcessor(getDiagram(), getFeatureProvider(), diagramUpdater,
									refBuilder,
									targetNode, new Point(context.getX(), context.getY())));
					result = EMPTY;
				} finally {
					eclipseCtx.dispose();
				}

				return null;
			}
		}

		final CreateAction createAction = new CreateAction();
		graphitiService.execute("Create " + paletteEntry.getLabel(), ExecutionMode.NORMAL, createAction);
		return createAction.result;
	}

	private DiagramNode getOwnerDiagramNode(final DiagramNode targetNode) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetNode.getBusinessObject());
			eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);
			final BusinessObjectContext ownerBoc = (BusinessObjectContext) ContextInjectionFactory.invoke(handler,
					GetCreateOwner.class, eclipseCtx, targetNode);
			if (!(ownerBoc instanceof DiagramNode)) {
				throw new RuntimeException("Expected diagram node");
			}

			return (DiagramNode) ownerBoc;
		} finally {
			eclipseCtx.dispose();
		}
	}

// Returns null if the business object to be modified is not an EObject
	private EObject getBusinessObjectToModify(final DiagramNode targetNode, final Object defaultValue) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetNode.getBusinessObject());
			eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);
			final Object boToModify = ContextInjectionFactory.invoke(handler,
					GetBusinessObjectToModify.class, eclipseCtx, defaultValue);
			if (!(boToModify instanceof EObject)) {
				throw new RuntimeException("Business object being modified must be an EObject");
			}

			return (EObject) boToModify;
		} finally {
			eclipseCtx.dispose();
		}
	}
}
