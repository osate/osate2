package org.osate.ge.internal.features;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.Figure;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;

// IAddFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerAddFeature extends AbstractAddFeature implements ICustomUndoRedoFeature{
	private final ExtensionService extService;
	private final GhostingService ghostingService; 
	private final LabelService labelService;
	private final ShapeCreationService shapeCreationService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final Object handler;
	
	public PictogramHandlerAddFeature(final ExtensionService extService, final GhostingService ghostingService, 
			final LabelService labelService, final ShapeCreationService shapeCreationService, 
			final ShapeService shapeService, final PropertyService propertyService,
			final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.labelService = Objects.requireNonNull(labelService, "labelService must not be null");
		this.shapeCreationService = Objects.requireNonNull(shapeCreationService, "shapeCreationService must not be null");
		this.shapeService = Objects.requireNonNull(shapeService, "shapeService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		// Assumes that the feature was created after checking if the pictogram handler handles the context
		return true;
	}
	
	@Override
	public PictogramElement add(final IAddContext context) {
		// TODO: Support connections
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final Object bo = AadlElementWrapper.unwrap(context.getNewObject());
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
			
			final Object gr = ContextInjectionFactory.invoke(handler, GetGraphicalRepresentation.class, eclipseCtx, null);
			final PictogramElement newPe;
			final ContainerShape childContainer; // Container for any children
			if(gr == null) {
				newPe = null;
				childContainer = context.getTargetContainer();
			} else {
				if(gr instanceof Figure) {
			        // Create the container shape
					final IPeCreateService peCreateService = Graphiti.getPeCreateService();
					newPe = childContainer = peCreateService.createContainerShape(context.getTargetContainer(), true);
				} else {
					throw new RuntimeException("Unsupported object: " + gr);
				}
			}
					
			if(newPe != null) {
			    getFeatureProvider().link(newPe, context.getNewObject());
				ghostingService.setIsGhost(newPe, false);	
			}
			
			if(childContainer != null) {
				// Determine whether children should be shown
				final int depthLevel = shapeService.getDepthLevel(childContainer);
				final boolean showContents = depthLevel <= propertyService.getNestingDepth(getDiagram());
				if(showContents) {
					// Refresh Children
					// TODO: Support Connections. Connections must be done last
					final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(handler, GetChildren.class, eclipseCtx, null);
					if(childBos != null) {
						childBos.forEachOrdered((childBo)->shapeCreationService.createUpdateShape(childContainer, childBo));
					}
				}
			}
				
			if(newPe != null) {
				// Create name label
				final String name = (String)ContextInjectionFactory.invoke(handler, GetName.class, eclipseCtx, null);
				if(name != null) {
					labelService.createLabelShape((ContainerShape)newPe, PictogramHandlerUpdateFeature.nameShapeName, bo, name);
				}
				
				// Refresh Graphics Algorithm
				if(newPe instanceof Shape) {
					PictogramHandlerUpdateFeature.refreshGraphicsFromRepresentation((Shape)newPe, gr);
				}
			}		
			
			return newPe;
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
