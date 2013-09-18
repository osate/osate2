package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AadlFeatureService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.HighlightingService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ResizeService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.SubcomponentService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

public class SubcomponentPattern extends AgePattern {
	private final AnchorService anchorUtil;
	private final VisibilityService visibilityHelper;
	private final ResizeService resizeHelper;
	private final UpdateService updateHelper;
	private final ShapeCreationService shapeCreationService;
	private final AadlFeatureService featureService;
	private final SubcomponentService subcomponentService;
	private final ConnectionCreationService connectionCreationService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final HighlightingService highlightingHelper;
	
	@Inject
	public SubcomponentPattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final ResizeService resizeHelper, final UpdateService updateHelper, 
			final ShapeCreationService shapeCreationService, AadlFeatureService featureService, SubcomponentService subcomponentService, 
			final ConnectionCreationService connectionCreationService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, final HighlightingService highlightingHelper) {
		this.anchorUtil = anchorUtil;
		this.visibilityHelper = visibilityHelper;
		this.resizeHelper = resizeHelper;
		this.updateHelper = updateHelper;
		this.shapeCreationService = shapeCreationService;
		this.featureService = featureService;
		this.subcomponentService = subcomponentService;
		this.connectionCreationService = connectionCreationService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.highlightingHelper = highlightingHelper;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Subcomponent;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		return isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		return super.canMoveShape(context);
	}
	
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		this.refresh(shape, sc, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		resizeHelper.checkContainerSize(shape);
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		resizeHelper.checkContainerSize((ContainerShape)context.getPictogramElement());
	}
	
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createFalseReason();
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(sc));        
				
		// Finish Creating the Shape
        refresh(shape, sc, context.getX(), context.getY(), 0, 0);

        return shape;
	}

	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y, width, height;
			if(ga == null) {
				x = y = 25;
				width = height = 0;
			} else {
				x = ga.getX();
				y = ga.getY();
				width = ga.getWidth();
				height = ga.getHeight();
			}
			this.refresh((ContainerShape)pe, sc, x, y, width, height);
		}
		return true;
	}
	
	private void refresh(final ContainerShape shape, final Subcomponent sc, final int x, final int y, final int minWidth, final int minHeight) {
		visibilityHelper.setIsGhost(shape, false);
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Remove invalid flow specifications from the diagram
		updateHelper.ghostInvalidConnections(getDiagram());
		
		// Remove invalid shapes
		updateHelper.ghostInvalidShapes(shape);

		final Set<Shape> childShapesToGhost = new HashSet<Shape>();
		childShapesToGhost.addAll(visibilityHelper.getNonGhostChildren(shape));

		// Create/update child shapes
		final Classifier classifier = subcomponentService.getComponentClassifier(shape,  sc);
		if(classifier != null) {
			final List<Shape> touchedShapes = new ArrayList<Shape>();
			shapeCreationService.createUpdateFeatureShapes(shape, featureService.getAllOwnedFeatures(classifier), touchedShapes);
			childShapesToGhost.removeAll(touchedShapes);
		}
		
		// Create/Update Flow Specifications
		final ComponentType componentType;
		if(classifier instanceof ComponentType) {
			componentType = (ComponentType)classifier;
		} else if(classifier instanceof ComponentImplementation) {
			componentType = ((ComponentImplementation)classifier).getType();
		} else {
			componentType = null;
		}
		
		// Create/Update Flow Specifications
		if(componentType != null) {
			connectionCreationService.createUpdateConnections(shape, componentType.getAllFlowSpecifications());
		} 

		// Ghost child shapes that were not updated
		for(final Shape child : childShapesToGhost) {
			visibilityHelper.setIsGhost(child, true);
		}
		
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        final String name = sc.getName() == null ? "" : sc.getName();
        final Text text = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, getDiagram(), name);
        final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(text.getValue(), text.getStyle().getFont());
        
		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// Calculate max width and height
		int maxWidth = Math.max(minWidth, 150);
		int maxHeight = Math.max(minHeight, 50);
		final int extraWidth = 30;
		final int extraHeight = 30;
		maxWidth = Math.max(maxWidth, textSize.getWidth() + extraWidth);
		for(final Shape childShape : visibilityHelper.getNonGhostChildren(shape)) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Ignore shape like the label when determining size.
			if(getBusinessObjectForPictogramElement(childShape) != null) {
				maxWidth = Math.max(maxWidth, childGa.getWidth() + extraWidth);
				maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() + extraHeight);
			}
		}		

		// Create the graphics Algorithm
		ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, getDiagram(), sc, maxWidth, maxHeight);  
		gaService.setLocation(ga, x, y);
		
		// Set the position of the text
		gaService.setLocationAndSize(text, 0, 0, ga.getWidth(), 20);
		
		// Set color based on current mode
		highlightingHelper.highlight(getDiagram(), sc, ga);		
	
		updateHelper.layoutChildren(shape);
		anchorUtil.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}
}
