package org.osate.ge.internal.graphiti.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.DockingPosition;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetBusinessObjectToModify;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.CreateOperation.CreateStepResult;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.di.BuildCreateOperation;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.layout.IncrementalLayoutMode;
import org.osate.ge.internal.diagram.runtime.layout.LayoutPreferences;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.util.AnnotationUtil;
import org.osate.ge.services.ReferenceBuilderService;

// ICreateFeature implementation that delegates behavior to a business object handler
public class BoHandlerCreateFeature extends AbstractCreateFeature implements Categorized, ICustomUndoRedoFeature {
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
		if(targetBo == null) {
			return false;
		}

		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetBo);
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

		final DockingPosition targetDockingPosition = AgeDiagramUtil.determineDockingPosition(targetNode,
				context.getX(), context.getY(), 0, 0);

		// CreateOperation is used for all code paths
		final SimpleCreateOperation createOp = new SimpleCreateOperation();

		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetNode.getBusinessObject());
			eclipseCtx.set(InternalNames.PROJECT, graphitiService.getProject());
			eclipseCtx.set(Names.DOCKING_POSITION, targetDockingPosition); // Specify even if the shape will not be docked.
			eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);

			// Check if the handler will modify the create operation directly
			if (AnnotationUtil.hasMethodWithAnnotation(BuildCreateOperation.class, handler)) {
				eclipseCtx.set(InternalNames.OPERATION, createOp);
				ContextInjectionFactory.invoke(handler,
						BuildCreateOperation.class,
						eclipseCtx);

				if(createOp.isEmpty()) {
					return EMPTY;
				}
			} else {
				// Otherwise, create a single step based on other annotated methods
				final DiagramNode ownerNode = getOwnerDiagramNode(targetNode);
				final EObject boToModify = getBusinessObjectToModify(targetNode, ownerNode.getBusinessObject());

				createOp.addStep(boToModify, (resource, boToModify1) -> {
					eclipseCtx.set(Names.MODIFY_BO, boToModify1);
					final Object newBo1 = ContextInjectionFactory.invoke(handler, Create.class, eclipseCtx);
					return new CreateStepResult(ownerNode, newBo1);
				});
			}

			// Perform modification
			final List<Object> newBos = new ArrayList<>(createOp.stepMap.size());
			aadlModService.modify(createOp.stepMap, obj -> obj, results -> {
				// Process results. Add created elements to the diagram
				for (final CreateStepResult stepResult : results) {
					if (stepResult != null && stepResult.newBo != null) {
						final RelativeBusinessObjectReference newRef = refBuilder.getRelativeReference(stepResult.newBo);
						if (newRef != null && stepResult.container instanceof DiagramNode) {
							final DiagramNode containerNode = (DiagramNode) stepResult.container;
							// Don't set the position if the incremental layout mode is set to diagram.
							// This will ensure the shape is layed out even if it is a docked shape.
							if (LayoutPreferences.getCurrentLayoutMode() != IncrementalLayoutMode.LAYOUT_DIAGRAM
									&& containerNode == targetNode) {
								diagramUpdater.addToNextUpdate(containerNode, newRef,
										new Point(context.getX(), context.getY()));
							} else {
								diagramUpdater.addToNextUpdate(containerNode, newRef, null);
							}
						}

						newBos.add(stepResult.newBo);
					}
				}
			});

			// Return new business objects
			return newBos.isEmpty() ? EMPTY : newBos.toArray();
		} finally {
			eclipseCtx.dispose();
		}
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

	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}

	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
