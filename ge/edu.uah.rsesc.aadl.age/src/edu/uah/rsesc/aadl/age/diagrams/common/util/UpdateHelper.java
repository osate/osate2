package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class UpdateHelper {
	public static void removeShapesWithoutBusinessObjects(final Diagram diagram, final IFeatureProvider fp) {	
		final List<Shape> shapesToRemove = new ArrayList<Shape>();		
		for(final Shape shape : diagram.getChildren()) {
			final Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(shape));

			if(bo == null) {
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
