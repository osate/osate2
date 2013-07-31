package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;

/**
 * A pattern that controls the type shape that contains all the other shapes in the type diagram
 * @author philip.alldredge
 *
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
		final Diagram diagram = getDiagram();
		final IGaService gaService = Graphiti.getGaService();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape container = peCreateService.createContainerShape(diagram, true);
        link(container, new AadlElementWrapper(classifier));        
				
		// Create the graphics algorithm
        final GraphicsAlgorithm ga = GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(container, getDiagram(), classifier, 500, 500);        
        gaService.setLocation(ga, context.getX(), context.getY());

        // Add child shapes
        refresh(container, classifier);
        
        return container;
	}
	
	private void refresh(final ContainerShape container, final Classifier classifier) {
		// TODO: Remove invalid connections
		// BO not valid.
		// Anchors invalid
		// etc
		
		// Create/Update Shapes	
		// TODO: Ensure flow specifications are not created here... only shape features..
		int y = 25;
		for(final NamedElement el : classifier.getOwnedMembers()) {
			if(el instanceof Feature) {
				final PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(el);
				if(pictogramElement == null) {
					final AddContext addContext = new AddContext();
					addContext.setNewObject(new AadlElementWrapper(el));
					addContext.setTargetContainer(container);
					addContext.setX(0);
					addContext.setY(y);
					final IAddFeature feature = this.getFeatureProvider().getAddFeature(addContext);
					if(feature != null && feature.canAdd(addContext)) {
						feature.execute(addContext);
						y += 30;
					}
				} else {
					// TODO: Don't allow updating of connections!
					
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
					
					// Update the classifier regardless of whether it is "needed" or not.
					if(updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
			} else { // TODO: Remove
				//fs.getKind() == FlowKind.PATH
				//System.out.println("UNHANDLED: " + el);
			}
		}
		
		// Create/Update Connections
		for(final NamedElement el : classifier.getOwnedMembers()) {
			if(el instanceof FlowSpecification) {
				final PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(el);
				if(pictogramElement == null) {					
					final FlowSpecification fs = (FlowSpecification)el;
					final Anchor[] anchors = AnchorUtil.getAnchorsForFlowSpecification(fs, getFeatureProvider());
					
					if(anchors != null) {
						final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
						addContext.setNewObject(new AadlElementWrapper(fs));
						addContext.setTargetContainer(container);
						
						final IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
						if(addFeature.canAdd(addContext)) {
							addFeature.add(addContext);
						}
					}
				} else {
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
					
					// Update the classifier regardless of whether it is "needed" or not.
					if(updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
			}
		}		
		
		// Features
		// Bus/Data Access
		// In/Out/In Out Ports
		// Feature Groups
		// Arrays
				
		// Prototypes
		// Refinements
		
		// TODO: Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		GraphicsAlgorithm ga = container.getGraphicsAlgorithm();
		final int prevX = ga.getX();
		final int prevY = ga.getY();
		
		// TODO: Calculate max height
		int maxHeight = 300;
		for(final Shape shape : container.getChildren()) {
			final GraphicsAlgorithm childGa = shape.getGraphicsAlgorithm();
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight());
		}
		
		// Create a new graphics Algorithm
		ga = GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(container, getDiagram(), classifier, ga.getWidth(), maxHeight+25);        
        gaService.setLocation(ga, prevX, prevY);
	}
	
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Classifier classifier = (Classifier)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			this.refresh((ContainerShape)pe, classifier);
		}
		return true;
	}
	
	// TODO: Finish implementing
	// TODO: Resize when children added.. Will update get called?
}
