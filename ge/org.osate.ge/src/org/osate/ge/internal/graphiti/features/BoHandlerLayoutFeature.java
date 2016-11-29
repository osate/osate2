package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.graphiti.PictogramElementProxy;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;

// ILayoutFeature implementation for shapes associated with a BO with a business object handler
public class BoHandlerLayoutFeature extends AbstractLayoutFeature implements ICustomUndoRedoFeature {
	private final static LabelConfiguration defaultLabelConfiguration = LabelConfigurationBuilder.create().build();
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	
	@Inject
	public BoHandlerLayoutFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor, 
			final ExtensionService extService, final ShapeService shapeService, final PropertyService propertyService) {
		super(fp);
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.shapeService = Objects.requireNonNull(shapeService, "shapeService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
	}

	@Override
	public boolean canLayout(final ILayoutContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return context.getPictogramElement() instanceof ContainerShape && 
				!(context.getPictogramElement() instanceof Diagram) && 
				extService.getApplicableBusinessObjectHandler(bo) != null;
	}

	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		if(shape.getGraphicsAlgorithm() == null) {
			return false;
		}
			
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		final Object handler = extService.getApplicableBusinessObjectHandler(bo);
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
			eclipseCtx.set(InternalNames.INTERNAL_DIAGRAM_BO, bor.getBusinessObjectForPictogramElement(getDiagram()));
			eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(context.getPictogramElement()));	
			final AgeLabelConfiguration labelConfiguration = (AgeLabelConfiguration)ContextInjectionFactory.invoke(handler, GetNameLabelConfiguration.class, eclipseCtx, defaultLabelConfiguration);
			final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();

			final Object gr = ContextInjectionFactory.invoke(handler, GetGraphic.class, eclipseCtx, null);
			if(gr == null) {	
				return false;
			}

			// Determine the space needed for each area
			int innerWidth = 50;
			int innerHeight = 50;
			int leftOuterPadding = 0;
			int rightOuterPadding = 0;
			int topOuterPadding = 0;
			int bottomOuterPadding = 0;

			final Shape nameShape = shapeService.getChildShapeByName(shape, BoHandlerFeatureHelper.nameShapeName);
			final GraphicsAlgorithm nameGa = nameShape == null ? null : nameShape.getGraphicsAlgorithm();
			
			// Handle label configuration
			if(nameGa != null) {
				switch(labelConfiguration.horizontalPosition) {
				case BEFORE_GRAPHIC:
					leftOuterPadding = Math.max(leftOuterPadding, nameGa.getWidth());
					break;	

				case DEFAULT:
				case GRAPHIC_BEGINNING:
				case GRAPHIC_CENTER:
				case GRAPHIC_END:
				default:
					innerWidth = Math.max(innerWidth, nameGa.getWidth());
					break;

				case AFTER_GRAPHIC:
					rightOuterPadding = Math.max(rightOuterPadding, nameGa.getWidth());
					break;			
				}					
				
				// Set Y value based on the label configuration
				switch(labelConfiguration.verticalPosition) {
				case BEFORE_GRAPHIC:
					topOuterPadding = Math.max(topOuterPadding, nameGa.getHeight());
					break;	
					
				case DEFAULT:					
				case GRAPHIC_BEGINNING:
				case GRAPHIC_CENTER:
				case GRAPHIC_END:
				default:
					innerHeight = Math.max(innerHeight, nameGa.getHeight());
					break;
					
				case AFTER_GRAPHIC:
					bottomOuterPadding = Math.max(bottomOuterPadding, nameGa.getHeight());
					break;			
				}
			}
			
			// Adjust inner width and height based on padding and current size
			innerWidth = Math.max(innerWidth, shapeGa.getWidth() - leftOuterPadding - rightOuterPadding);
			innerHeight = Math.max(innerHeight, shapeGa.getHeight() - topOuterPadding - bottomOuterPadding);
			
			// Prevent children from being positioned with negative coordinates
			for(final Shape childShape : shape.getChildren()) {
				if(!propertyService.isManuallyPositioned(childShape)) {
					final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
					if(childGa != null) {
						if(childGa.getX() < 0) {
							childGa.setX(0);
						}
						
						if(childGa.getY() < 0) {
							childGa.setY(0);
						}
					}
				}
			}
			// TODO: Handle children
			//     Ignore shapes that are automatically positioned. (Labels)
			//     TODO: Docking					

			// Create the graphics algorithm					
			shapeGa.getGraphicsAlgorithmChildren().clear();
			final GraphicsAlgorithm innerGa = AgeGraphitiGraphicsUtil.createGraphicsAlgorithm(getDiagram(), shapeGa, gr, innerWidth, innerHeight);
			
			// Update variables using actual size of inner graphics algorithm
			innerWidth = innerGa.getWidth();
			innerHeight = innerGa.getHeight();
			
			// Update the shape's graphics algorithm based on required size
			shapeGa.setWidth(leftOuterPadding + innerWidth + rightOuterPadding);
			shapeGa.setHeight(topOuterPadding + innerHeight + bottomOuterPadding);
			
			// Position the inner graphics algorithm
			innerGa.setX(leftOuterPadding);
			innerGa.setY(topOuterPadding);

			if(nameGa != null) {
				// Position the labels
				switch(labelConfiguration.horizontalPosition) {
				case BEFORE_GRAPHIC:
					nameGa.setX(0);
					break;	

				case DEFAULT:
				case GRAPHIC_BEGINNING:
				default:
					nameGa.setX(innerGa.getX());
					break;
					
				case GRAPHIC_CENTER:
					nameGa.setX(innerGa.getX() + (innerWidth - nameGa.getWidth())/2);
					break;
					
				case GRAPHIC_END:						
					nameGa.setX(innerGa.getX() + innerWidth - nameGa.getWidth());
					break;

				case AFTER_GRAPHIC:
					nameGa.setX(innerGa.getX() + innerWidth);
					break;			
				}					
				
				// Set Y value based on the label configuration
				switch(labelConfiguration.verticalPosition) {
				case BEFORE_GRAPHIC:
					nameGa.setY(0);
					break;	

				case DEFAULT:
				case GRAPHIC_BEGINNING:
				default:
					nameGa.setY(innerGa.getY());
					break;
					
				case GRAPHIC_CENTER:
					nameGa.setY(innerGa.getY() + (innerHeight - nameGa.getHeight())/2);
					break;
					
				case GRAPHIC_END:						
					nameGa.setY(innerGa.getY() + innerHeight - nameGa.getHeight());
					break;

				case AFTER_GRAPHIC:
					nameGa.setY(innerGa.getY() + innerHeight);
					break;			
				}
			}
		} finally {
			eclipseCtx.dispose();
		}		
				
		return false;
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
