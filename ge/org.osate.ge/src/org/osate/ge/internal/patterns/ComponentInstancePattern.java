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
import java.util.Map.Entry;
import java.util.Objects;
import javax.inject.Inject;

import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.DefaultAgeResizeConfiguration;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.LayoutService.DockArea;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;

public class ComponentInstancePattern extends AgePattern {
	private static final String nameShapeName = "label";
	private final BusinessObjectResolutionService bor;
	private final LayoutService layoutService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final GhostingService ghostingService;
	private final ShapeService shapeService;
	private final ShapeCreationService shapeCreationService;
	private final LabelService labelService;
	private final PropertyService propertyService;
	private final ConnectionCreationService connectionCreationService;
	private final AnchorService anchorService;
	
	@Inject
	public ComponentInstancePattern(final BusinessObjectResolutionService bor, final LayoutService layoutService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, 
			final GhostingService ghostingService, final ShapeService shapeService, final ShapeCreationService shapeCreationService, final LabelService labelService,
			final PropertyService propertyService, final ConnectionCreationService connectionCreationService, final AnchorService anchorService) {
		this.bor = bor;
		this.layoutService = layoutService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.ghostingService = ghostingService;
		this.shapeService = shapeService;
		this.shapeCreationService = shapeCreationService;
		this.labelService = labelService;
		this.propertyService = propertyService;
		this.connectionCreationService = connectionCreationService;
		this.anchorService = anchorService;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof ComponentInstance;
	}
	
	@Override
	public boolean isPaletteApplicable() {
		return false;
	}
	
	// Movement
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		if(context.getSourceContainer() instanceof Diagram) {
			return false;
		}
		
		return super.canMoveShape(context);
	}
	
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {	
		super.postMoveShape(context);
		layoutService.checkShapeBoundsWithAncestors(((ContainerShape)context.getPictogramElement()));
		
		// Update Connection Anchors
		// TODO
		//final ContainerShape shape = (ContainerShape)context.getShape();
		//updateConnectionAnchors(shape);
	}
	
	// Resizing
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return !propertyService.isTransient(context.getPictogramElement()); // Don't allow resizing of transient shapes such as labels
	}
	
	
	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();			
		super.resizeShape(context);
		layoutService.checkShapeBoundsWithAncestors(shape);
		
		// Update Connection Anchors
		// TODO
		//updateConnectionAnchors(shape);
		
		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());
	}
	
	// Adding
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			final Object targetBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
			return targetBo instanceof ComponentInstance;
		}
		
		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Element bo = (Element)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(bo));       
        
        // Create Graphics Algorithm
        createStubGraphicsAlgorithm(shape, context.getX(), context.getY());
        
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
	private void refresh(final ContainerShape shape) {
		propertyService.setIsLogicalTreeNode(shape, true);
		ghostingService.setIsGhost(shape, false);
		
		final ComponentInstance ci = (ComponentInstance)bor.getBusinessObjectForPictogramElement(shape);
		
		// TODO: Limit Nesting?
		
		// Ghost children
		ghostingService.ghostChildren(shape);
		
		// Create Component Instances
		shapeCreationService.createUpdateShapes(shape, ci.getComponentInstances(), 25, true, 30, 25, true, 20);
		
		// Create Feature Instances
		shapeCreationService.createUpdateFeatureShapes(shape, ci.getFeatureInstances());
		
		// Create connections to represent each connection reference
		for(final ConnectionInstance connectionInstance : ci.getConnectionInstances()) {
			for(final ConnectionReference cr : connectionInstance.getConnectionReferences()) {
				connectionCreationService.createUpdateConnection(shape, cr);
			}
		}		
		
		// Create label shape
		labelService.createLabelShape(shape, nameShapeName,  ci, ci.getFullName());
		
		// Layout
		layoutPictogramElement(shape);
		
		// Create/update the chopbox anchor
		anchorService.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);

		// TODO: Bindings
	}	
	
	// Layout
	public boolean canLayout(final ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final ComponentInstance ci = (ComponentInstance)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		final int x = shape.getGraphicsAlgorithm().getX();
		final int y = shape.getGraphicsAlgorithm().getY();

		final IGaService gaService = Graphiti.getGaService();
		final Shape nameShape = Objects.requireNonNull(getNameShape(shape), "unable to retrieve name shape");
		
		// Group feature shapes based on docking area
		final Map<DockArea, List<Shape>> dockAreaToShapesMap = layoutService.buildDockAreaToChildrenMap(shape, false);

		// Adjust shapes so they do not overlap		
		layoutService.cleanupOverlappingDockedShapes(dockAreaToShapesMap, 0);
		
		// Determine size of the shape
		final int[] newSize = layoutService.getMinimumSize(shape); 
		
		// Enforce a minimum size for classifiers
		newSize[0] = Math.max(Math.max(newSize[0], layoutService.getMinimumWidth()), nameShape.getGraphicsAlgorithm().getWidth() + 30);
		newSize[1] = Math.max(Math.max(newSize[1], layoutService.getMinimumHeight()), nameShape.getGraphicsAlgorithm().getHeight() + 30);
				
		// Create new graphics algorithm
		final GraphicsAlgorithm ga = graphicsAlgorithmCreator.createComponentGraphicsAlgorithm(shape, ci.getCategory(), false, newSize[0], newSize[1]);
		ga.setFilled(false);
		gaService.setLocation(ga, x, y);
		
		// Since the size of the shape has been finalized, finish adjusting positions of docked shapes
		for(final Entry<DockArea, List<Shape>> dockAreaToShapesEntry : dockAreaToShapesMap.entrySet()) {
			for(final Shape childShape : dockAreaToShapesEntry.getValue()) {
				if(dockAreaToShapesEntry.getKey() == layoutService.getDockArea(LayoutService.DOCK_AREA_ID_LEFT)) {
					childShape.getGraphicsAlgorithm().setX(0);
				} else if(dockAreaToShapesEntry.getKey() == layoutService.getDockArea(LayoutService.DOCK_AREA_ID_RIGHT)) {
					childShape.getGraphicsAlgorithm().setX(shape.getGraphicsAlgorithm().getWidth() - childShape.getGraphicsAlgorithm().getWidth());
				}
			}
		}

		// Layout Labels
		final int shapeWidth = shape.getGraphicsAlgorithm().getWidth();
		gaService.setLocation(nameShape.getGraphicsAlgorithm(), (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, 5);
					
		// Set the shape as not filled
		ga.setFilled(false);
		
		return true;
	}
	
	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, nameShapeName);
	}
	
	@Override
	public IResizeConfiguration getResizeConfiguration(IResizeShapeContext context) {
		final DefaultAgeResizeConfiguration conf = new DefaultAgeResizeConfiguration();
		conf.setMinimumSize(layoutService.getMinimumWidth(), layoutService.getMinimumHeight());
		return conf;		
	}
}
