package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.services.AadlFeatureService;
import edu.uah.rsesc.aadl.age.services.ConnectionCreationService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.LayoutService;
import edu.uah.rsesc.aadl.age.services.ShapeCreationService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

/**
 * A pattern that controls the type shape that contains all the other shapes in the type diagram
 * @author philip.alldredge
 */
public class TypeClassifierPattern extends AgePattern {
	private final VisibilityService visibilityHelper;
	private final LayoutService layoutService;
	private final ShapeCreationService shapeCreationService;
	private final AadlFeatureService featureService;
	private final ConnectionCreationService connectionCreationService;
	private final StyleService styleUtil;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	
	@Inject
	public TypeClassifierPattern(final VisibilityService visibilityHelper, final LayoutService layoutService, final ShapeCreationService shapeCreationService,
			final AadlFeatureService featureService, final ConnectionCreationService connectionCreationService, final StyleService styleUtil,
			final GraphicsAlgorithmCreationService graphicsAlgorithmCreator) {
		this.visibilityHelper = visibilityHelper;
		this.layoutService = layoutService;
		this.shapeCreationService = shapeCreationService;
		this.featureService = featureService;
		this.connectionCreationService = connectionCreationService;
		this.styleUtil = styleUtil;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Classifier;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Classifier classifier = (Classifier)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(classifier));       
        
        // Finish creating
        refresh(shape, classifier, context.getX(), context.getY());
        
        return shape;
	}

	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Classifier classifier = (Classifier)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y;
			if(ga == null) {
				x = 25;
				y = 25;
			} else {
				x = ga.getX();
				y = ga.getY();
			}
			this.refresh((ContainerShape)pe, classifier, x, y);
		}
		return true;
	}	
	
	private void refresh(final ContainerShape shape, final Classifier classifier, final int x, final int y) {
		visibilityHelper.setIsGhost(shape, false);
		
		// Remove invalid connections from the diagram
		visibilityHelper.ghostInvalidConnections();
		
		// Remove invalid features
		visibilityHelper.ghostInvalidShapes(shape);
		
		shapeCreationService.createUpdateFeatureShapes(shape, featureService.getAllOwnedFeatures(classifier), null);
		
		// Create/Update Flow Specifications and Modes
		if(classifier instanceof ComponentType) {
			final ComponentType componentType = (ComponentType)classifier;			
			shapeCreationService.createUpdateModeShapes(shape, componentType.getAllModes());
			connectionCreationService.createUpdateConnections(shape, componentType.getAllModeTransitions());	
			connectionCreationService.createUpdateConnections(shape, componentType.getAllFlowSpecifications());
		}

		// Adjust size. Width and height
		final int newSize[] = layoutService.adjustChildShapePositions(shape);
		final IGaService gaService = Graphiti.getGaService();
		
		// Create a new graphics Algorithm
		// Disable code to create the shape based on the type of classifier and simply make everything a rectangle for now. Avoids issue of features not being in reasonable positions.
		final GraphicsAlgorithm ga;
		if(classifier instanceof FeatureGroupType) {
			ga = gaService.createRectangle(shape);
			ga.setStyle(styleUtil.getSystemStyle(false));
			gaService.setLocationAndSize(ga, x, y, newSize[0], newSize[1]);
		} else {
			ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, classifier, newSize[0], newSize[1]);
			gaService.setLocation(ga, x, y);
		}
		
		layoutService.layoutChildren(shape);
	}

	@Override
	public boolean isPaletteApplicable() {
		return false;
	}
}
