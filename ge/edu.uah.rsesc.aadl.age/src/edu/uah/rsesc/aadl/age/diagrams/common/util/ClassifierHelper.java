package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class ClassifierHelper {
	public static void createUpdateFeatures(final ContainerShape shape, final Classifier classifier, final IFeatureProvider fp) {		
		int childY = 25;
		for(final Feature aadlFeature : classifier.getAllFeatures()) {
			final PictogramElement pictogramElement = ShapeHelper.getChildShapeByElement(shape, aadlFeature, fp);
			if(pictogramElement == null) {
				final AddContext addContext = new AddContext();
				addContext.setNewObject(new AadlElementWrapper(aadlFeature));
				addContext.setTargetContainer(shape);
				addContext.setX(0);
				addContext.setY(childY);
				final IAddFeature feature = fp.getAddFeature(addContext);
				if(feature != null && feature.canAdd(addContext)) {
					final PictogramElement pe = feature.add(addContext);
					childY += pe.getGraphicsAlgorithm().getHeight() + 10;
				}
			} else {
				final UpdateContext updateContext = new UpdateContext(pictogramElement);
				final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
				
				// Update the shape regardless of whether it is "needed" or not.
				if(updateFeature.canUpdate(updateContext)) {
					updateFeature.update(updateContext);
				}
			}
		}
	}
	
	public static void createUpdateFlowSpecifications(final ContainerShape shape, final ComponentType componentType, final IFeatureProvider fp) {
		for(final FlowSpecification fs : componentType.getAllFlowSpecifications()) {				
			// Only show flow specifications that re not in any modes
			if(fs.getAllInModes().size() == 0) {				
				final PictogramElement pictogramElement = fp.getPictogramElementForBusinessObject(fs);
				if(pictogramElement == null) {			
					final Anchor[] anchors = AnchorUtil.getAnchorsForFlowSpecification(fs, fp);
					
					if(anchors != null) {
						final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
						addContext.setNewObject(new AadlElementWrapper(fs));
						addContext.setTargetContainer(shape);
						
						final IAddFeature addFeature = fp.getAddFeature(addContext);
						if(addFeature.canAdd(addContext)) {
							addFeature.add(addContext);
						}
					}
				} else {
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
					
					// Update the connection regardless of whether it is "needed" or not.
					if(updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
			}
		}
	}
}
