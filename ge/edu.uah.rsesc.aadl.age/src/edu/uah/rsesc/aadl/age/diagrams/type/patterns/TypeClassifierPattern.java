package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

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

	private void refresh(final ContainerShape shape, final Classifier classifier) {
		// Remove invalid flow specifications from the diagram
		removeInvalidFlowSpecifications(getDiagram());
		
		// Remove invalid features
		UpdateHelper.removeInvalidShapes(shape, this.getFeatureProvider());
		
		// Create/Update Shapes	
		int y = 25;
		for(final NamedElement el : classifier.getOwnedMembers()) {
			if(el instanceof Feature) {
				final PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(el);
				if(pictogramElement == null) {
					final AddContext addContext = new AddContext();
					addContext.setNewObject(new AadlElementWrapper(el));
					addContext.setTargetContainer(shape);
					addContext.setX(0);
					addContext.setY(y);
					final IAddFeature feature = this.getFeatureProvider().getAddFeature(addContext);
					if(feature != null && feature.canAdd(addContext)) {
						final PictogramElement pe = feature.add(addContext);
						y += pe.getGraphicsAlgorithm().getHeight() + 10;
					}
				} else {
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
					
					// Update the shape regardless of whether it is "needed" or not.
					if(updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
			}
		}
		
		// Create/Update Connections
		for(final NamedElement el : classifier.getOwnedMembers()) {
			if(el instanceof FlowSpecification) {
				final FlowSpecification fs = (FlowSpecification)el;

				// Only show flow specifications that re not in any modes
				if(fs.getAllInModes().size() == 0) {				
					final PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(el);
					if(pictogramElement == null) {			
						final Anchor[] anchors = AnchorUtil.getAnchorsForFlowSpecification(fs, getFeatureProvider());
						
						if(anchors != null) {
							final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
							addContext.setNewObject(new AadlElementWrapper(fs));
							addContext.setTargetContainer(shape);
							
							final IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
							if(addFeature.canAdd(addContext)) {
								addFeature.add(addContext);
							}
						}
					} else {
						final UpdateContext updateContext = new UpdateContext(pictogramElement);
						final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
						
						// Update the connection regardless of whether it is "needed" or not.
						if(updateFeature.canUpdate(updateContext)) {
							updateFeature.update(updateContext);
						}
					}
				}
			}
		}
		
		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final int prevX = ga.getX();
		final int prevY = ga.getY();
		final int width = ga.getWidth();
		
		// Calculate max height
		int maxHeight = 300;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight());
		}
		
		// Create a new graphics Algorithm
		// Disable code to create the shape based on the type of classifier and simply make everything a rectangle for now. Avoids issue of features not being in reasonable positions.
		//GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(ga, getDiagram(), classifier, width, maxHeight+25);
		//gaService.setLocation(ga, prevX, prevY);
		
		ga = gaService.createRectangle(shape);
		ga.setStyle(StyleUtil.getSystemStyle(getDiagram(), false));
		gaService.setLocationAndSize(ga, prevX, prevY, width, maxHeight+25);

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
	
	private void removeInvalidFlowSpecifications(final Diagram diagram) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : diagram.getConnections()) {
			final Object bo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(connection));
			boolean remove = false;
			if(bo instanceof EObject) {
				if(bo instanceof FlowSpecification) {
					final FlowSpecification fs = (FlowSpecification)bo;
					
					// Remove the object if the flow specification is not available in all modes
					if(fs.getAllInModes().size() != 0) {
						remove = true;
					}
				}
			} else {
				// Remove the object if the business object was not an EObject
				remove = true;
			}
			
			if(remove) {
				connectionsToRemove.add(connection);
			}
		}
		
		// Remove the connections
		for(final Connection connection : connectionsToRemove) {
			EcoreUtil.delete(connection, true);
		}
	}
}
