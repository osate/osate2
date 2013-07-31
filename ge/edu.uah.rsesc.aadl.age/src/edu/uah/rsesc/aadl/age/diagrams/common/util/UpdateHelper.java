package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class UpdateHelper {
	/**
	 * Removes invalid shapes from a diagram. An invalid shape is defined as a top level shape that is not associated with a business object or can not be updated
	 * @param diagram
	 * @param fp
	 */
	public static void removeInvalidShapes(final Diagram diagram, final IFeatureProvider fp) {	
		final List<Shape> shapesToRemove = new ArrayList<Shape>();		
		for(final Shape shape : diagram.getChildren()) {
			// Check if the shape has a business object and can be updated
			final Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(shape));
			final UpdateContext updateContext = new UpdateContext(shape);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			if(bo == null || updateFeature == null || (updateFeature != null && !updateFeature.canUpdate(updateContext))) {
				shapesToRemove.add(shape);
			} else {
				EObject emfBusinesObject = (EObject)bo;
				if(emfBusinesObject.eIsProxy()) {
					emfBusinesObject = EcoreUtil.resolve(emfBusinesObject, OsateResourceUtil.getResourceSet());
				}
	
				if(emfBusinesObject.eIsProxy()) {
					shapesToRemove.add(shape);
				}
			}
		}
		
		for(final Shape shape : shapesToRemove) {
			EcoreUtil.delete(shape, true);			
		}
	}
}
