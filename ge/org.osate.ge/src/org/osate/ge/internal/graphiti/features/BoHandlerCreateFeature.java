package org.osate.ge.internal.graphiti.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.AgeDiagramUtil;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
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
		
		final DiagramNode ownerNode = getOwnerDiagramNode(targetNode);
		if(ownerNode == null) {
			return EMPTY;
		}

		final DockingPosition targetDockingPosition = AgeDiagramUtil.determineDockingPosition(targetNode, context.getX(), context.getY(), 0, 0);
		
		// Modify the AADL model
		final Object newBo = aadlModService.modify((EObject)ownerNode.getBusinessObject(), new AbstractModifier<EObject, Object>() {
			@Override
			public Object modify(Resource resource, EObject ownerBo) {
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
					eclipseCtx.set(Names.OWNER_BO, ownerBo);
					eclipseCtx.set(Names.TARGET_BO, targetNode.getBusinessObject());
					eclipseCtx.set(InternalNames.PROJECT, graphitiService.getProject());
					eclipseCtx.set(Names.DOCKING_POSITION, targetDockingPosition); // Specify even if the shape will not be docked.
					eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);
					final Object newBo = ContextInjectionFactory.invoke(handler, Create.class, eclipseCtx);
					if(newBo != null) {
						final RelativeBusinessObjectReference newRef = refBuilder.getRelativeReference(newBo);
						if(newRef != null) {
							if(ownerNode == targetNode) {
								diagramUpdater.addToNextUpdate(ownerNode, newRef, new Point(context.getX(), context.getY()));
							} else {
								diagramUpdater.addToNextUpdate(ownerNode, newRef, null);
							}
						}
					}
					
					return newBo == null ? EMPTY : newBo;
				} finally {
					eclipseCtx.dispose();
				}
			}
		});
		
		return newBo == null ? EMPTY : new Object[] {newBo};
	}
	
	// Returns null if the owner business object context's business object is not an EObject
	private DiagramNode getOwnerDiagramNode(final DiagramNode targetNode) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetNode.getBusinessObject());
			eclipseCtx.set(Names.TARGET_BUSINESS_OBJECT_CONTEXT, targetNode);
			final BusinessObjectContext ownerBoc = (BusinessObjectContext)ContextInjectionFactory.invoke(handler, GetCreateOwner.class, eclipseCtx, targetNode);
			if(ownerBoc instanceof DiagramNode && ownerBoc.getBusinessObject() instanceof EObject) {
				return (DiagramNode)ownerBoc;
			}
		} finally {
			eclipseCtx.dispose();
		}
		
		return null;
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
