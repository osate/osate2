package edu.uah.rsesc.aadl.age.diagrams.type.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICustomUndoableFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;
import edu.uah.rsesc.aadl.age.util.Log;

public class TypeUpdateDiagramFeature extends AbstractUpdateFeature implements ICustomUndoableFeature {

	public TypeUpdateDiagramFeature(final IFeatureProvider fp) {
		super(fp);
	}

	private Classifier getClassifier(final IUpdateContext context) {
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getPictogramElement()));
		if(bo instanceof ComponentType || bo instanceof FeatureGroupType) {
			return (Classifier)bo;
		}
		
		return null;
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return getClassifier(context) != null;
	}

	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createTrueReason("");
	}

	@Override
	public boolean update(final IUpdateContext context) {
		Log.info("called with context: " + context);
		final Classifier classifier = getClassifier(context);
	//	System.out.println(classifier);

		final Diagram diagram = getDiagram();
		
		System.out.println("UPDATING");
		
		// TODO: Easier to put the features on the sides?
		// How to snap?
		/*
		// TODO: Update graphics for the classifier
		// TODO: Size
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final ContainerShape container = peCreateService.createContainerShape(diagram, true);
		final GraphicsAlgorithm ga = GraphicsAlgorithmCreator.createGraphicsAlgorithm(container, diagram, classifier, 1000, 1000);
		Graphiti.getGaLayoutService().setLocation(ga, 0, 0);
		ga.setFilled(false);
		*/
		
		// Remove all styles. Styles will be recreated as needed when the graphics algorithms are rebuilt.
		diagram.getStyles().clear();	
				
		// Remove shapes that are invalid
		UpdateHelper.removeInvalidShapes(diagram, getFeatureProvider());
		
		// TODO: Remove invalid connections
		// BO not valid.
		// Anchors invalid
		// etc
		
		// Create/Update Shapes	
		// TODO: Ensure flow specifications are not created here... only shape features..
		int y = 50;
		for(final NamedElement el : classifier.getOwnedMembers()) {
			//if(el instanceof Feature || (el instanceof FlowSpecification && (((FlowSpecification)el).getKind() == FlowKind.SOURCE || ((FlowSpecification)el).getKind() == FlowKind.SINK))) {
			if(el instanceof Feature) {
				final PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(el);
				if(pictogramElement == null) {
					final AddContext addContext = new AddContext();
					addContext.setNewObject(new AadlElementWrapper(el));
					addContext.setTargetContainer(diagram);
					addContext.setX(0);
					addContext.setY(y);
					final IAddFeature feature = this.getFeatureProvider().getAddFeature(addContext);
					if(feature != null && feature.canAdd(addContext)) {
						feature.execute(addContext);
						y += 50;
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
						addContext.setTargetContainer(diagram);
						
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
				
		// Flow sources
		// Flow Sinks
		// Flow Paths
		// Prototypes
		// Refinements
		
		return false;
	}

	@Override
	public void undo(final IContext context) {
	}

	@Override
	public boolean canRedo(final IContext context) {
		return false;
	}

	@Override
	public void redo(final IContext context) {	
	}
}
