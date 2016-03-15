package org.osate.ge.internal.features;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.Element;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.Figure;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Ellipse;
import org.osate.ge.graphics.Rectangle;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ReferenceBuilderService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;

// IUpdateFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerUpdateFeature extends AbstractUpdateFeature implements ICustomUndoRedoFeature {
	public static final String nameShapeName = "name";
	private final ExtensionService extService;
	private final ReferenceBuilderService refBuilder;
	private final GhostingService ghostingService;
	private final BusinessObjectResolutionService bor;
	private final LabelService labelService;
	private final ShapeCreationService shapeCreationService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final Object handler;
	
	public PictogramHandlerUpdateFeature(final ExtensionService extService, final ReferenceBuilderService refBuilder, final GhostingService ghostingService, 
			final BusinessObjectResolutionService bor, final LabelService labelService, final ShapeCreationService shapeCreationService,
			final ShapeService shapeService, final PropertyService propertyService,
			final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.labelService = Objects.requireNonNull(labelService, "labelService must not be null");
		this.shapeCreationService = Objects.requireNonNull(shapeCreationService, "shapeCreationService must not be null");
		this.shapeService = Objects.requireNonNull(shapeService, "shapeService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		// Assumes that the feature was created after checking if the pictogram handler handles the context
		return true;
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		if(context.getPictogramElement() instanceof Diagram) {
			return Reason.createTrueReason();
		} else {
			return Reason.createFalseReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		// TODO: Support connections
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		if(pe.getGraphicsAlgorithm() == null) {
			return false;
		}
		
		// Special handling for diagrams
		final boolean isDiagram = pe instanceof Diagram;
		if(isDiagram) {
			// Update the diagram's name
			final Diagram diagram = (Diagram)pe;
			final String newTitle = refBuilder.getTitle(bo);
			if(newTitle != null) {
				diagram.setName(newTitle);
			}
		}
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			// Store the current position of the graphics algorithm
			final int x = pe.getGraphicsAlgorithm().getX();
			final int y = pe.getGraphicsAlgorithm().getY();
			
			// Assign  variables to context
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);

			// Unghost
			ghostingService.setIsGhost(pe, false);
			
			// Update Link
			getFeatureProvider().link(pe, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
			
			final Object gr = ContextInjectionFactory.invoke(handler, GetGraphicalRepresentation.class, eclipseCtx, null);
			if(pe instanceof ContainerShape) {
				final ContainerShape shape = (ContainerShape)pe;
				// TODO: Handle diagram case../null gr
				if(!(gr instanceof Figure)) {
					throw new RuntimeException("Unsupported case. Pictogram element is not container shape but graphic is not figure: " + gr);
				}
				
				// Ghost Children
				ghostingService.ghostChildren(shape);
				
				// Determine whether children should be shown
				final int depthLevel = shapeService.getDepthLevel(shape);
				final boolean showContents = depthLevel <= propertyService.getNestingDepth(getDiagram());
				if(showContents) {
					// Refresh Children
					// TODO: Support Connections. Connections must be done last
					final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(handler, GetChildren.class, eclipseCtx, null);
					if(childBos != null) {
						childBos.forEachOrdered((childBo)->shapeCreationService.createUpdateShape(shape, childBo));
					}
				}
			
				// Don't create labels and graphics for diagrams
				if(!(shape instanceof Diagram)) {
					// Create name label
					final String name = (String)ContextInjectionFactory.invoke(handler, GetName.class, eclipseCtx, null);
					if(name != null) {
						labelService.createLabelShape(shape, nameShapeName, bo, name);
					}

					if(pe instanceof Shape) {
						refreshGraphicsFromRepresentation(shape, gr);
					}
				}
				
				// Set the position of the refreshed graphics algorithm
				final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
				if(ga != null) {
					ga.setX(x);
					ga.setY(y);
				}
				
				// Layout the shape
				if(!(shape instanceof Diagram)) {
					layoutPictogramElement(shape);
				}
			}			

			return true;
		} finally {
			eclipseCtx.dispose();
		}
	}

	// TODO: Cleanup/move
	public static void refreshGraphicsFromRepresentation(final Shape shape, final Object gr) {
		final GraphicsAlgorithm oldGa = shape.getGraphicsAlgorithm();			
		final GraphicsAlgorithm ga;
		if(gr == null) {
			return; 
		} else if(gr instanceof Rectangle) {
			ga = Graphiti.getGaService().createPlainRectangle(shape);
			ga.setFilled(false);
		} else if(gr instanceof Ellipse) {
	        ga = Graphiti.getGaService().createPlainEllipse(shape);
	        ga.setFilled(false);
		} else {
			throw new RuntimeException("Unsupported object: " + gr);
		}
		
		// Set to appropriate size. If just recreating the graphics algorithm, retain previous size
		ga.setWidth(Math.max(50, oldGa == null ? 0 : oldGa.getWidth()));
        ga.setHeight(Math.max(50, oldGa == null ? 50 : oldGa.getHeight()));
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
