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
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetBusinessObjectToModify;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
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

// ICreateConnectionFeature implementation that delegates behavior to a business object handler
public class BoHandlerCreateConnectionFeature extends AbstractCreateConnectionFeature implements Categorized {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	private final GraphitiService graphitiService;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final DiagramUpdater diagramUpdater;
	private final ReferenceBuilderService refBuilder;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;

	public BoHandlerCreateConnectionFeature(final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final GraphitiService graphitiService,
			final ExtensionService extService,
			final AadlModificationService aadlModService,
			final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder,
			final IFeatureProvider fp,
			final SimplePaletteEntry paletteEntry,
			final Object boHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiService must not be null");
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
	public boolean canStartConnection(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final DiagramElement srcElement = graphitiAgeDiagramProvider.getGraphitiAgeDiagram().getClosestDiagramElement(context.getSourcePictogramElement());
			if(srcElement == null) {
				return false;
			}

			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcElement.getBusinessObject());
			eclipseCtx.set(Names.SOURCE_BUSINESS_OBJECT_CONTEXT, srcElement);

			return (boolean)ContextInjectionFactory.invoke(handler, CanStartConnection.class, eclipseCtx, false);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
			final DiagramElement srcElement = graphitiAgeDiagram.getClosestDiagramElement(context.getSourcePictogramElement());
			final DiagramElement dstElement = graphitiAgeDiagram.getClosestDiagramElement(context.getTargetPictogramElement());
			if(srcElement == null || dstElement == null) {
				return false;
			}

			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.SOURCE_BO, srcElement.getBusinessObject());
			eclipseCtx.set(Names.SOURCE_BUSINESS_OBJECT_CONTEXT, srcElement);
			eclipseCtx.set(Names.DESTINATION_BO, dstElement.getBusinessObject());
			eclipseCtx.set(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT, dstElement);

			return (boolean)ContextInjectionFactory.invoke(handler, CanCreate.class, eclipseCtx, false);
		} finally {
			eclipseCtx.dispose();
		}
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiAgeDiagramProvider.getGraphitiAgeDiagram();
		final DiagramElement srcElement = graphitiAgeDiagram.getClosestDiagramElement(context.getSourcePictogramElement());
		final DiagramElement dstElement = graphitiAgeDiagram.getClosestDiagramElement(context.getTargetPictogramElement());
		if(srcElement == null || dstElement == null) {
			return null;
		}

		class CreateAction implements AgeAction {
			@Override
			public AgeAction execute() {
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
					eclipseCtx.set(Names.SOURCE_BO, srcElement.getBusinessObject());
					eclipseCtx.set(Names.SOURCE_BUSINESS_OBJECT_CONTEXT, srcElement);
					eclipseCtx.set(Names.DESTINATION_BO, dstElement.getBusinessObject());
					eclipseCtx.set(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT, dstElement);

					final Operation operation;

					// Check if the handler will modify the create operation directly
					if (AnnotationUtil.hasMethodWithAnnotation(BuildCreateOperation.class, handler)) {
						operation = (Operation) ContextInjectionFactory.invoke(handler, BuildCreateOperation.class,
								eclipseCtx);
					} else {
						final BusinessObjectContext ownerBoc = (BusinessObjectContext) ContextInjectionFactory
								.invoke(handler, GetCreateOwner.class, eclipseCtx);
						if (!(ownerBoc instanceof DiagramNode)) {
							throw new RuntimeException("Owner must be a diagram node");
						}

						final Object boToModify = ContextInjectionFactory.invoke(handler,
								GetBusinessObjectToModify.class, eclipseCtx, ownerBoc.getBusinessObject());
						if (!(boToModify instanceof EObject)) {
							throw new RuntimeException("Business object being modified must be an EObject");
						}

						operation = Operation.create(opBuilder -> {
							final DiagramNode ownerNode = (DiagramNode) ownerBoc;
							opBuilder.modifyModel((EObject) boToModify, (tag, prevResult) -> tag,
									(tag, ownerBo, prevResult) -> {
										eclipseCtx.set(Names.MODIFY_BO, ownerBo);
										final Object newBo = ContextInjectionFactory.invoke(handler, Create.class,
												eclipseCtx, null);
										return StepResultBuilder.create().showNewBusinessObject(ownerNode, newBo)
												.build();
									});
						});
					}

					if (operation == null) {
						return null;
					}

					// Perform modification
					final OperationExecutor opExecutor = new OperationExecutor(aadlModService);
					opExecutor.execute(operation, new GraphitiOperationResultsProcessor(getDiagram(),
							getFeatureProvider(), diagramUpdater, refBuilder));
				} finally {
					eclipseCtx.dispose();
				}

				return null;
			}
		}

		final CreateAction createAction = new CreateAction();
		graphitiService.execute("Create " + paletteEntry.getLabel(), ExecutionMode.NORMAL, createAction);

		return null;
	}
}
