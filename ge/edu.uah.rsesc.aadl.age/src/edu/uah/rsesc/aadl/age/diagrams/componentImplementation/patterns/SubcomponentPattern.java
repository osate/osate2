package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
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
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.HighlightingHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ResizeHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;

public class SubcomponentPattern extends AgePattern {
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
		
		ResizeHelper.checkContainerSize(shape, getFeatureProvider());
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		ResizeHelper.checkContainerSize((ContainerShape)context.getPictogramElement(), getFeatureProvider());
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
		UpdateHelper.updateVisibility(shape);
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Remove invalid flow specifications from the diagram
		UpdateHelper.removeInvalidConnections(getDiagram(), getFeatureProvider());
		
		// Remove invalid shapes
		UpdateHelper.removeInvalidShapes(shape, this.getFeatureProvider());

		final Set<Shape> childShapesToDelete = new HashSet<Shape>();
		childShapesToDelete.addAll(shape.getChildren());

		// Create/update child shapes
		final Classifier classifier = ClassifierHelper.getComponentClassifier(shape,  sc, getFeatureProvider());
		if(classifier != null) {
			final List<Shape> touchedShapes = new ArrayList<Shape>();
			ClassifierHelper.createUpdateFeatureShapes(shape, ClassifierHelper.getAllOwnedFeatures(classifier), getFeatureProvider(), touchedShapes);
			childShapesToDelete.removeAll(touchedShapes);
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
			ClassifierHelper.createUpdateFlowSpecifications(shape, componentType, getFeatureProvider());
		} 

		// Remove child shapes that were not updated
		for(final Shape child : childShapesToDelete) {
			EcoreUtil.delete(child, true);	
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
		int maxWidth = Math.max(minWidth, 150);
		int maxHeight = Math.max(minHeight, 50);
		final int extraWidth = 30;
		final int extraHeight = 30;
		maxWidth = Math.max(maxWidth, textSize.getWidth() + extraWidth);
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Ignore shape like the label when determining size.
			if(getBusinessObjectForPictogramElement(childShape) != null) {
				maxWidth = Math.max(maxWidth, childGa.getWidth() + extraWidth);
				maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() + extraHeight);
			}
		}		

		// Create the graphics Algorithm
		ga = GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, getDiagram(), sc, maxWidth, maxHeight, getFeatureProvider());  
		gaService.setLocation(ga, x, y);
		
		// Set the position of the text
		gaService.setLocationAndSize(text, 0, 0, ga.getWidth(), 20);
		
		// Set color based on current mode
		HighlightingHelper.highlight(getDiagram(), sc, ga, getFeatureProvider());		
	
		UpdateHelper.layoutChildren(shape, getFeatureProvider());
		AnchorUtil.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}
}
