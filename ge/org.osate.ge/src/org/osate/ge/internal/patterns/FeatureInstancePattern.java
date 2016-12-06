/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
package org.osate.ge.internal.patterns;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.GraphicsAlgorithmManipulationService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.LayoutService.DockArea;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;

public class FeatureInstancePattern extends AgePattern{
	private static final String nameShapeName = "label";
	private static final String symbolShapeName = "symbol";
	private final BusinessObjectResolutionService bor;
	private final ConnectionService connectionService;
	private final LayoutService layoutService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final GhostingService ghostingService;
	private final ShapeService shapeService;
	private final ShapeCreationService shapeCreationService;
	private final LabelService labelService;
	private final PropertyService propertyService;
	private final GraphicsAlgorithmManipulationService gaManipService;
	private final AnchorService anchorService;
	
	@Inject
	public FeatureInstancePattern(final BusinessObjectResolutionService bor, final ConnectionService connectionService,
			final LayoutService layoutService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, 
			final GhostingService ghostingService, final ShapeService shapeService, final ShapeCreationService shapeCreationService, final LabelService labelService,
			final PropertyService propertyService, final GraphicsAlgorithmManipulationService gaManipService, final AnchorService anchorService) {
		this.bor = bor;
		this.connectionService = connectionService;
		this.layoutService = layoutService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.ghostingService = ghostingService;
		this.shapeService = shapeService;
		this.shapeCreationService = shapeCreationService;
		this.labelService = labelService;
		this.propertyService = propertyService;
		this.gaManipService = gaManipService;
		this.anchorService = anchorService;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return isUnwrappedBoApplicable(bo);
	}
	
	private final boolean isUnwrappedBoApplicable(final Object bo) {
		return bo instanceof FeatureInstance;
	}
	
	@Override
	public boolean isPaletteApplicable() {
		return false;
	}
	
	// Movement	
	@Override
	protected void preMoveShape(final IMoveShapeContext ctx) {
		super.preMoveShape(ctx);

		// Restrict so that the feature will be placed inside the bounds of the container
		final Shape shape = ctx.getShape();
		final int containerWidth = shape.getContainer().getGraphicsAlgorithm().getWidth();
		final int containerHeight = shape.getContainer().getGraphicsAlgorithm().getHeight();
		final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
		final MoveShapeContext mutableContext = (MoveShapeContext)ctx;

		// Handle X
		if(ctx.getX() < 0) {
			mutableContext.setX(0);
		} else {
			final int rightX = ctx.getX() + shapeGa.getWidth();
			if(rightX > containerWidth) {
				mutableContext.setX(containerWidth - shapeGa.getWidth());
			}
		}
		
		// Handle Y
		if(ctx.getY() < 0) {
			mutableContext.setY(0);
		} else {
			final int bottomY = ctx.getY() + shapeGa.getHeight();
			if(bottomY > containerHeight) {
				mutableContext.setY(containerHeight - shapeGa.getHeight());
			}
		}
	}
	
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {	
		super.postMoveShape(context);
		
		final ContainerShape shape = (ContainerShape)context.getShape();		
        
		// Update the dock area
        final DockArea dockArea = getDockArea(shape.getContainer(), context.getX(), 0);
        propertyService.setDockArea(shape, dockArea.id);

        // Layout the shape
        layoutPictogramElement(shape);
        
        // Layout Parent
        if(shape.getContainer() != null) {
        	layoutPictogramElement(shape.getContainer());
        }

		// Update connection anchors
		connectionService.updateConnectionAnchors(shape);
	}
	
	// Resizing
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return false;
	}
	
	// Adding
	@Override
	public boolean canAdd(final IAddContext context) {
		return isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Element bo = (Element)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(bo));       
        
        // Create Graphics Algorithm
        final GraphicsAlgorithm ga = createStubGraphicsAlgorithm(shape, context.getX(), context.getY());
        
        // Set the initial state of the is left property
        final DockArea dockArea = getDockArea(shape.getContainer(), ga.getX(), ga.getY());
        propertyService.setDockArea(shape, dockArea.id);

        // Finish creating
        refresh(shape);
        
        return shape;
	}
	
	private GraphicsAlgorithm createStubGraphicsAlgorithm(final Shape shape, final int x, final int y) {
		final IGaService gaService = Graphiti.getGaService();
        final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
        gaService.setLocation(ga, x, y);
        return ga;
	}
	
	//  Update
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();

		if(pe instanceof ContainerShape) {
			final ContainerShape shape = (ContainerShape)pe;
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if(ga == null) {
				createStubGraphicsAlgorithm(shape, 25, 25);
			}

			refresh((ContainerShape)pe);
		}
		return true;
	}	
	
	// Shared Add/Update
	// Shape hierarchy:
	// <Feature Instance Shape>
	// Label Shape
	// Feature Symbol Shape
	// Children (For Feature Groups)
	private void refresh(final ContainerShape shape) {
		propertyService.setIsLogicalTreeNode(shape, true);
		ghostingService.setIsGhost(shape, false);
		
		final FeatureInstance fi = (FeatureInstance)bor.getBusinessObjectForPictogramElement(shape);

		// Ghost children
		ghostingService.ghostChildShapes(shape);
		
		// Create Child Feature Instances
		shapeCreationService.createUpdateFeatureShapes(shape, fi.getFeatureInstances());
		
		// Create label shape
		labelService.createLabelShape(shape, nameShapeName, fi, fi.getFullName());		
		
		// Create symbol shape
        final Shape symbolShape = Graphiti.getPeCreateService().createShape(shape, false);
        propertyService.setName(symbolShape, symbolShapeName);
        propertyService.setIsManuallyPositioned(symbolShape, true);
        propertyService.setIsTransient(symbolShape, true);	
		
		// Layout
        layoutPictogramElement(shape);
		
		// Create/update the chopbox anchor
		anchorService.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}	
	
	// Layout
	public boolean canLayout(final ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final FeatureInstance fi = (FeatureInstance)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());		
		final IGaService gaService = Graphiti.getGaService();
		final Shape nameShape = Objects.requireNonNull(getNameShape(shape), "unable to retrieve name shape");
		final Shape symbolShape = Objects.requireNonNull(getSymbolShape(shape), "unable to retrieve symbol shape");
		final GraphicsAlgorithm ga = Objects.requireNonNull(shape.getGraphicsAlgorithm(), "graphics algorithm must not be null");
				
		final int x = ga.getX();
		final int y = ga.getY();	

		// Layout children
		layoutService.layoutChildren(shape);
		
		// Group feature shapes based on docking area
		final Map<DockArea, List<Shape>> dockAreaToShapesMap = layoutService.buildDockAreaToChildrenMap(shape, false);

		// Adjust shapes so they do not overlap
		final int featureSymbolStartY = nameShape.getGraphicsAlgorithm().getY() + nameShape.getGraphicsAlgorithm().getHeight() + 5;
		layoutService.cleanupOverlappingDockedShapes(dockAreaToShapesMap, featureSymbolStartY);

		// Layout Labels
		gaService.setLocation(nameShape.getGraphicsAlgorithm(), 0, 0);
		
		// Find height that will contain the entire shape
		int height = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			if(!propertyService.isTransient(childShape) && childGa != null) {
				height = Math.max(height, childGa.getY() + childGa.getHeight());
			}
		}
		height += 2;
				
		// Create graphics algorithm for symbol shape
		final GraphicsAlgorithm symbolGa = graphicsAlgorithmCreator.createFeatureInstanceGraphicsAlgorithm(symbolShape, fi, height - featureSymbolStartY);
		gaService.setLocation(symbolGa, 0, featureSymbolStartY);
		height = Math.max(height,  symbolGa.getY() + symbolGa.getHeight());
		
		// Determine the width needed for the shape
		int maxChildFeatureShapeWidth = 0;
		for(final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
			for(final Shape childShape : dockAreaToShapesEntry.getValue()) {
				maxChildFeatureShapeWidth = Math.max(maxChildFeatureShapeWidth,childShape.getGraphicsAlgorithm().getWidth());	
			}
		}
		int width = Math.max(nameShape.getGraphicsAlgorithm().getWidth(), symbolGa.getWidth() + maxChildFeatureShapeWidth) + 2;
				
		// Set the size and position of the shape's graphics algorithm
		gaService.setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);

		// Since the size of the shape has been finalized, finish adjusting positions of docked shapes
		final boolean isRootFeatureLeft = getRootFeatureDockArea(shape) == LayoutService.DockArea.LEFT;
		
		if(!isRootFeatureLeft) {
			gaManipService.mirror(symbolGa);
			symbolGa.setX(shape.getGraphicsAlgorithm().getWidth() - symbolGa.getWidth());			
		}
		
		for(final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
			if(dockAreaToShapesEntry.getKey() == LayoutService.DockArea.FEATURE_GROUP) {
				for(final Shape childShape : dockAreaToShapesEntry.getValue()) {
					if(isRootFeatureLeft) {
						childShape.getGraphicsAlgorithm().setX(symbolGa.getWidth()-1);
					} else {
						childShape.getGraphicsAlgorithm().setX(symbolGa.getX() - childShape.getGraphicsAlgorithm().getWidth() + 1);
					}
				}
			}
		}
		
		// Update Fix Point Anchors
		final int innerX = symbolGa.getX() + (isRootFeatureLeft ? symbolGa.getWidth() : 0);
		final int outerX = symbolGa.getX() + (isRootFeatureLeft ? 0 : symbolGa.getWidth());
		final int connectorY = symbolGa.getY() + (symbolGa.getHeight() / 2);
		final int flowSpecConnectorY = connectorY;
	
		// Special cases for event out features
		if(fi.getCategory() == FeatureCategory.EVENT_PORT && fi.getDirection() == DirectionType.OUT) {
			anchorService.createOrUpdateFixPointAnchor(shape, FeaturePattern.innerConnectorAnchorName, outerX, connectorY);
		} else {
			anchorService.createOrUpdateFixPointAnchor(shape, FeaturePattern.innerConnectorAnchorName, innerX, connectorY);
		}
		
		if(fi.getCategory() == FeatureCategory.EVENT_PORT && fi.getDirection() == DirectionType.IN) {
			anchorService.createOrUpdateFixPointAnchor(shape, FeaturePattern.outerConnectorAnchorName, innerX, connectorY);
		} else {
			anchorService.createOrUpdateFixPointAnchor(shape, FeaturePattern.outerConnectorAnchorName, outerX, connectorY);
		}

		anchorService.createOrUpdateFixPointAnchor(shape, FeaturePattern.flowSpecificationAnchorName, innerX, flowSpecConnectorY);
		
		return true;
	}
	
	// TODO: In the future this could delegate to the container shape to support arbitrary dock area
	private DockArea getDockArea(final ContainerShape container, final int positionX, final int width) {
		final Object containerBo = bor.getBusinessObjectForPictogramElement(container);
		if(!isUnwrappedBoApplicable(containerBo)) {
			 final GraphicsAlgorithm containerGa = container.getGraphicsAlgorithm();	
			 final int centerX = positionX + width/2;
			 final boolean isLeft = containerGa == null ? true : centerX < containerGa.getWidth()/2;
			 return isLeft ? LayoutService.DockArea.LEFT : LayoutService.DockArea.RIGHT;
		} else if(containerBo instanceof FeatureInstance) {
			return LayoutService.DockArea.FEATURE_GROUP;
		}

		return null;		
	}	
		
	private DockArea getRootFeatureDockArea(ContainerShape shape) {
		while(true) {
			final ContainerShape container = shape.getContainer();
			if(container == null) {
				break;
			}
			
			final Object containerBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(container));
			if(containerBo instanceof Classifier || containerBo instanceof Subcomponent || containerBo instanceof SubprogramCall || containerBo instanceof ComponentInstance) {
				break;
			}
			shape = container;
		}

		return layoutService.getDockArea(shape);
	}
	
	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, nameShapeName);
	}
	
	private Shape getSymbolShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, symbolShapeName);
	}
}
