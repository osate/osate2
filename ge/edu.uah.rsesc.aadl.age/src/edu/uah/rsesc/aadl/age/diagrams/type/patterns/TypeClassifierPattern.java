package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import org.eclipse.graphiti.features.context.IAddContext;
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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

/**
 * A pattern that controls the type shape that contains all the other shapes in the type diagram
 * @author philip.alldredge
 */
public class TypeClassifierPattern extends AgePattern {
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
		// Remove invalid flow specifications from the diagram
		UpdateHelper.removeInvalidFlowSpecifications(getDiagram(), getFeatureProvider());
		
		// Remove invalid features
		UpdateHelper.removeInvalidShapes(shape, this.getFeatureProvider());
		
		ClassifierHelper.createUpdateFeatures(shape, classifier, getFeatureProvider());
		
		// Create/Update Flow Specifications
		if(classifier instanceof ComponentType) {
			final ComponentType componentType = (ComponentType)classifier;
			ClassifierHelper.createUpdateFlowSpecifications(shape, componentType, getFeatureProvider());
		}

		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		
		// Calculate max height
		int maxHeight = 300;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight());
		}
		
		// Create a new graphics Algorithm
		// Disable code to create the shape based on the type of classifier and simply make everything a rectangle for now. Avoids issue of features not being in reasonable positions.
		final int width = 500;
		final GraphicsAlgorithm ga;
		if(classifier instanceof FeatureGroupType) {
			ga = gaService.createRectangle(shape);
			ga.setStyle(StyleUtil.getSystemStyle(getDiagram(), false));
			gaService.setLocationAndSize(ga, x, y, width, maxHeight+25);
		} else {
			ga = GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, getDiagram(), classifier, width, maxHeight+25);
			gaService.setLocation(ga, x, y);
		}
		
		UpdateHelper.layoutChildren(shape, getFeatureProvider());

	}
}
