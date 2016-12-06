package org.osate.ge.internal.graphiti.features;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

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
import org.osate.ge.internal.labels.LabelPosition;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.LayoutService.DockArea;

// ILayoutFeature implementation for shapes associated with a BO with a business object handler
public class BoHandlerLayoutFeature extends AbstractLayoutFeature implements ICustomUndoRedoFeature {
	private static final int labelPadding = 2;
	private final static LabelConfiguration defaultLabelConfiguration = LabelConfigurationBuilder.create().build();
	private final LayoutService layoutService;
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	
	@Inject
	public BoHandlerLayoutFeature(final IFeatureProvider fp, final LayoutService layoutService, final BusinessObjectResolutionService bor, 
			final ExtensionService extService, final ShapeService shapeService, final PropertyService propertyService) {
		super(fp);
		this.layoutService = Objects.requireNonNull(layoutService, "bor must not be null");
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
			final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
			eclipseCtx.set(InternalNames.INTERNAL_DIAGRAM_BO, diagramBo);
			eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(context.getPictogramElement()));	
			final AgeLabelConfiguration labelConfiguration = (AgeLabelConfiguration)ContextInjectionFactory.invoke(handler, GetNameLabelConfiguration.class, eclipseCtx, defaultLabelConfiguration);
			final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();

			final Object gr = ContextInjectionFactory.invoke(handler, GetGraphic.class, eclipseCtx, null);
			if(gr == null) {	
				return false;
			}

			// Determine the space needed for each area
			int innerWidth = 10;
			int innerHeight = 10;
			int leftOuterPadding = 0;
			int rightOuterPadding = 0;
			int topOuterPadding = 0;
			int bottomOuterPadding = 0;

			final Shape nameShape = shapeService.getChildShapeByName(shape, BoHandlerFeatureHelper.nameShapeName);
			final GraphicsAlgorithm nameGa = nameShape == null ? null : nameShape.getGraphicsAlgorithm();
			
			// Adjust label position if the shape is docked
			LabelPosition nameHorizontalPosition = labelConfiguration.horizontalPosition;
			LabelPosition nameVerticalPosition = labelConfiguration.verticalPosition;
			
			final DockArea shapeDockArea = layoutService.getDockArea(shape);
			if(shapeDockArea == LayoutService.DockArea.LEFT) {
				if(nameHorizontalPosition == LabelPosition.BEFORE_GRAPHIC) {
					nameHorizontalPosition = LabelPosition.AFTER_GRAPHIC;
				}
			} else if(shapeDockArea == LayoutService.DockArea.RIGHT) {
				if(nameHorizontalPosition == LabelPosition.AFTER_GRAPHIC) {
					nameHorizontalPosition = LabelPosition.BEFORE_GRAPHIC;
				}
			} else if(shapeDockArea == LayoutService.DockArea.TOP) {
				if(nameVerticalPosition == LabelPosition.BEFORE_GRAPHIC) {
					nameVerticalPosition = LabelPosition.AFTER_GRAPHIC;
				}
			} else if(shapeDockArea == LayoutService.DockArea.BOTTOM) {
				if(nameVerticalPosition == LabelPosition.AFTER_GRAPHIC) {
					nameVerticalPosition = LabelPosition.BEFORE_GRAPHIC;
				}
			}
			
			// Handle label configuration
			if(nameGa != null) {
				switch(nameHorizontalPosition) {
				case BEFORE_GRAPHIC:
					leftOuterPadding = Math.max(leftOuterPadding, nameGa.getWidth());
					break;	

				case DEFAULT:
				case GRAPHIC_BEGINNING:
				case GRAPHIC_CENTER:
				case GRAPHIC_END:
				default:
					innerWidth = Math.max(innerWidth, nameGa.getWidth() + labelPadding); // Add additional padding to avoid label background from overlapping shape border for simple shapes
					break;

				case AFTER_GRAPHIC:
					rightOuterPadding = Math.max(rightOuterPadding, nameGa.getWidth());
					break;			
				}					
				
				// Set Y value based on the label configuration
				switch(nameVerticalPosition) {
				case BEFORE_GRAPHIC:
					topOuterPadding = Math.max(topOuterPadding, nameGa.getHeight());
					break;	
					
				case DEFAULT:					
				case GRAPHIC_BEGINNING:
				case GRAPHIC_CENTER:
				case GRAPHIC_END:
				default:
					innerHeight = Math.max(innerHeight, nameGa.getHeight() + labelPadding);
					break;
					
				case AFTER_GRAPHIC:
					bottomOuterPadding = Math.max(bottomOuterPadding, nameGa.getHeight());
					break;			
				}
			}
			
			// Adjust inner width and height based on padding and current size
			innerWidth = Math.max(innerWidth, shapeGa.getWidth() - leftOuterPadding - rightOuterPadding);
			innerHeight = Math.max(innerHeight, shapeGa.getHeight() - topOuterPadding - bottomOuterPadding);
			
			// Prevent children from being positioned outside of the inner area
			for(final Shape childShape : shape.getChildren()) {
				if(!propertyService.isManuallyPositioned(childShape)) {
					final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
					if(childGa != null) {
						if(childGa.getX() < leftOuterPadding) {
							childGa.setX(leftOuterPadding);
						}
						
						if(childGa.getY() < topOuterPadding) {
							childGa.setY(topOuterPadding);
						}
					}
				}
			}			
			
			// Group feature shapes based on docking area
			final Map<DockArea, List<Shape>> dockAreaToShapesMap = layoutService.buildDockAreaToChildrenMap(shape, false);
			
			// Adjust shapes so they do not overlap
			layoutService.cleanupOverlappingDockedShapes(dockAreaToShapesMap, 0);
			
			// Consider children when determining size
			final int[] minSizeForChildren = getMinimumSizeForChildren(shape, leftOuterPadding, topOuterPadding);
			innerWidth = Math.max(innerWidth, minSizeForChildren[0]);
			innerHeight = Math.max(innerHeight, minSizeForChildren[1]);

			// Create the graphics algorithm					
			shapeGa.getGraphicsAlgorithmChildren().clear();
			final boolean filled = diagramBo != bo;
			final GraphicsAlgorithm innerGa = AgeGraphitiGraphicsUtil.createGraphicsAlgorithm(getDiagram(), shapeGa, gr, innerWidth, innerHeight, filled);
			
			// Update variables using actual size of inner graphics algorithm
			innerWidth = innerGa.getWidth();
			innerHeight = innerGa.getHeight();
			
			// Update the shape's graphics algorithm based on required size
			final int innerRight = leftOuterPadding + innerWidth;
			final int innerBottom = topOuterPadding + innerHeight;
			shapeGa.setWidth(innerRight + rightOuterPadding);
			shapeGa.setHeight(innerBottom + bottomOuterPadding);			
			
			// Position docked shapes
			for(final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
				for(final Shape childShape : dockAreaToShapesEntry.getValue()) {
					if(dockAreaToShapesEntry.getKey() == LayoutService.DockArea.LEFT) {
						childShape.getGraphicsAlgorithm().setX(leftOuterPadding);
					} else if(dockAreaToShapesEntry.getKey() == LayoutService.DockArea.RIGHT) {
						childShape.getGraphicsAlgorithm().setX(innerRight-childShape.getGraphicsAlgorithm().getWidth());
					} else if(dockAreaToShapesEntry.getKey() == LayoutService.DockArea.TOP) {
						childShape.getGraphicsAlgorithm().setY(topOuterPadding);
					} else if(dockAreaToShapesEntry.getKey() == LayoutService.DockArea.BOTTOM) {
						childShape.getGraphicsAlgorithm().setY(innerBottom-childShape.getGraphicsAlgorithm().getHeight());
					}
				}
			}
			
			// Position the inner graphics algorithm
			innerGa.setX(leftOuterPadding);
			innerGa.setY(topOuterPadding);

			if(nameGa != null) {
				// Position the labels
				switch(nameHorizontalPosition) {
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
				switch(nameVerticalPosition) {
				case BEFORE_GRAPHIC:
					nameGa.setY(0);
					break;	

				case DEFAULT:
				case GRAPHIC_BEGINNING:
				default:
					nameGa.setY(innerGa.getY() + labelPadding);
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
	
	// TODO: Deprecate version in layout service?
	private int[] getMinimumSizeForChildren(final ContainerShape shape, final int innerLeftX, final int innerTopY) {
		// Calculate max right and bottom
		int maxRight = 0;
		int maxBottom = 0;
		for(final Shape childShape :  shapeService.getNonGhostChildren(shape)) {
			if(childShape.isVisible()) {
				if(!propertyService.isManuallyPositioned(childShape) && propertyService.isLayedOut(childShape)) {
					final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
					maxRight = Math.max(maxRight, childGa.getX() + childGa.getWidth());
					maxBottom = Math.max(maxBottom, childGa.getY() + childGa.getHeight());					
				}
			}
		}

		return new int[] { maxRight - innerLeftX, maxBottom - innerTopY};
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
