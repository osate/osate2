package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
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
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class SubcomponentPattern extends AgePattern{
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
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(sc));        
				
		// Finish Creating the Shape
        refresh(shape, sc, context.getX(), context.getY());
        
        return shape;
	}

	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
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
			this.refresh((ContainerShape)pe, sc, x, y);
		}
		return true;
	}
	
	private void refresh(final ContainerShape shape, final Subcomponent sc, final int x, final int y) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		// Remove invalid flow specifications from the diagram
		//removeInvalidFlowSpecifications(getDiagram());
		
		// Remove invalid shapes
		UpdateHelper.removeModeSpecificOrInvalidShapes(shape, this.getFeatureProvider());

		// Create/update child shapes
		final Classifier classifier = sc.getClassifier();
		if(classifier != null) {
			ClassifierHelper.createUpdateFeatures(shape, classifier, getFeatureProvider());			
		}
		
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        final String name = sc.getName() == null ? "" : sc.getName();
        final Text text = GraphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, getDiagram(), name);
        final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(text.getValue(), text.getStyle().getFont());
        
		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// Calculate max width and height
		int maxWidth = 50;
		int maxHeight = 50;
		final int extraWidth = 30;
		final int extraHeight = 30;
		maxWidth = Math.max(maxWidth, textSize.getWidth() + extraWidth);
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() + extraWidth);
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() + extraHeight);			
		}		

		// Create the graphics Algorithm
		ga = GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, getDiagram(), sc.getClassifier(), maxWidth, maxHeight);   
		ga.setStyle(StyleUtil.getSystemStyle(getDiagram(), false));
		gaService.setLocation(ga, x, y);
		
		// Set the position of the text
		gaService.setLocationAndSize(text, 0, 0, ga.getWidth(), 20);
		
		UpdateHelper.layoutChildren(shape, getFeatureProvider());
	}	
}
