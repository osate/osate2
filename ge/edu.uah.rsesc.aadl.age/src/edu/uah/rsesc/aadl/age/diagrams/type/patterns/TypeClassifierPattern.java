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
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

/**
 * A pattern that controls the type shape that contains all the other shapes in the type diagram
 * @author philip.alldredge
 */
public class TypeClassifierPattern extends AgePattern {
	private final VisibilityService visibilityHelper;
	private final UpdateService updateHelper;
	private final ClassifierService classifierHelper;
	private final ConnectionService connectionHelper;
	private final StyleService styleUtil;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	
	@Inject
	public TypeClassifierPattern(final VisibilityService visibilityHelper, final UpdateService updateHelper, final ClassifierService classifierHelper, 
			final ConnectionService connectionHelper, final StyleService styleUtil, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator) {
		this.visibilityHelper = visibilityHelper;
		this.updateHelper = updateHelper;
		this.classifierHelper = classifierHelper;
		this.connectionHelper = connectionHelper;
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
		updateHelper.ghostInvalidConnections(getDiagram());
		
		// Remove invalid features
		updateHelper.ghostInvalidShapes(shape);
		
		classifierHelper.createUpdateFeatureShapes(shape, classifierHelper.getAllOwnedFeatures(classifier), null);
		
		// Create/Update Flow Specifications and Modes
		if(classifier instanceof ComponentType) {
			final ComponentType componentType = (ComponentType)classifier;			
			classifierHelper.createUpdateModeShapes(shape, componentType.getAllModes());
			connectionHelper.createUpdateConnections(shape, componentType.getAllModeTransitions());	
			connectionHelper.createUpdateConnections(shape, componentType.getAllFlowSpecifications());
		}

		// Adjust size. Width and height
		final int newSize[] = classifierHelper.adjustChildShapePositions(shape);
		final IGaService gaService = Graphiti.getGaService();
		
		// Create a new graphics Algorithm
		// Disable code to create the shape based on the type of classifier and simply make everything a rectangle for now. Avoids issue of features not being in reasonable positions.
		final GraphicsAlgorithm ga;
		if(classifier instanceof FeatureGroupType) {
			ga = gaService.createRectangle(shape);
			ga.setStyle(styleUtil.getSystemStyle(getDiagram(), false));
			gaService.setLocationAndSize(ga, x, y, newSize[0], newSize[1]);
		} else {
			ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, getDiagram(), classifier, newSize[0], newSize[1]);
			gaService.setLocation(ga, x, y);
		}
		
		updateHelper.layoutChildren(shape);
	}
}
