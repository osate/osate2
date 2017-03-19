package org.osate.ge.internal.graphiti.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.SimplePaletteEntry;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetCreateOwner;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.ui.util.SelectionHelper;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;

// ICreateFeature implementation that delegates behavior to a business object handler
public class BoHandlerCreateFeature extends AbstractCreateFeature implements Categorized, ICustomUndoRedoFeature {
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final AadlModificationService aadlModService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final ConnectionService connectionService;
	private final SimplePaletteEntry paletteEntry;
	private final Object handler;
	
	public BoHandlerCreateFeature(final BusinessObjectResolutionService bor, final ExtensionService extService, final AadlModificationService aadlModService, 
			final ShapeService shapeService, final PropertyService propertyService, final ConnectionService connectionService, final IFeatureProvider fp, final SimplePaletteEntry paletteEntry, 
			final Object boHandler) {
		super(fp, paletteEntry.getLabel(), "");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.shapeService = Objects.requireNonNull(shapeService, "shapeService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
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
		final PictogramElement targetPe = AgeFeatureUtil.getLogicalPictogramElement(context.getTargetContainer(), propertyService, connectionService);
		if(targetPe == null) {
			return false;
		}		
		final Object targetBo = bor.getBusinessObjectForPictogramElement(targetPe);
		if(targetBo == null) {
			return false;
		}
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetBo);
			//TODO: Migrate!eclipseCtx.set(InternalNames.TARGET_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(targetPe));
			return (boolean)ContextInjectionFactory.invoke(handler, CanCreate.class, eclipseCtx, false);
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		final PictogramElement targetPe = AgeFeatureUtil.getLogicalPictogramElement(context.getTargetContainer(), propertyService, connectionService);
		if(targetPe == null) {
			return EMPTY;
		}
		
		final Object targetBo = bor.getBusinessObjectForPictogramElement(targetPe);
		final EObject ownerBo = getOwnerBo(targetBo, targetPe);
		if(ownerBo == null) {
			return EMPTY;
		}
		
		final DockingPosition targetDockingPosition = AgeMoveShapeFeature.determineDockingPosition(context.getTargetContainer(), context.getX(), context.getY(), 0, 0);

		// Modify the AADL model
		final Object newBo = aadlModService.modify(ownerBo, new AbstractModifier<EObject, Object>() {
			@Override
			public Object modify(Resource resource, EObject ownerBo) {
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
					eclipseCtx.set(Names.OWNER_BO, ownerBo);
					eclipseCtx.set(Names.TARGET_BO, targetBo);
					eclipseCtx.set(InternalNames.PROJECT, SelectionHelper.getProject(getDiagram().eResource()));
					eclipseCtx.set(InternalNames.DOCKING_POSITION, targetDockingPosition); // Specify even if the shape will not be docked.
					//TODO: Migrate!eclipseCtx.set(InternalNames.TARGET_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(targetPe));
					final Object newBo = ContextInjectionFactory.invoke(handler, Create.class, eclipseCtx);
					return newBo == null ? EMPTY : newBo;
				} finally {
					eclipseCtx.dispose();
				}
			}
		});
		
		final Shape newShape = shapeService.getChildShapeByReference(context.getTargetContainer(), newBo);
		if(newShape != null) {
			// Move the shape to the desired position
			final MoveShapeContext moveShapeCtx = new MoveShapeContext(newShape);
			moveShapeCtx.setLocation(context.getX(), context.getY());
			moveShapeCtx.setSourceContainer(newShape.getContainer());
			moveShapeCtx.setTargetContainer(newShape.getContainer());
			
			final IMoveShapeFeature feature = getFeatureProvider().getMoveShapeFeature(moveShapeCtx);
			if(feature != null && feature.canMoveShape(moveShapeCtx)) {
				feature.moveShape(moveShapeCtx);
			}
		}
		
		return newBo == null ? EMPTY : new Object[] {newBo};
	}
	
	private EObject getOwnerBo(final Object targetBo, final PictogramElement targetPe) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.PALETTE_ENTRY_CONTEXT, paletteEntry.getContext());
			eclipseCtx.set(Names.TARGET_BO, targetBo);
			//TODO: Migrate!eclipseCtx.set(InternalNames.TARGET_DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(targetPe));
			final EObject ownerBo = (EObject)ContextInjectionFactory.invoke(handler, GetCreateOwner.class, eclipseCtx, null);
			if(ownerBo != null) {
				return (EObject)ownerBo;
			}
		} finally {
			eclipseCtx.dispose();
		}
		
		return (EObject)targetBo;
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
