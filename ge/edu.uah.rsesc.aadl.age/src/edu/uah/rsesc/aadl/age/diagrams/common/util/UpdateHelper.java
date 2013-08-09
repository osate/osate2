package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class UpdateHelper {
	/**
	 * Removes invalid shapes from a diagram. An invalid shape is defined as a top level shape that is not associated with a business object or can not be updated
	 * @param diagram
	 * @param fp
	 */
	public static void removeInvalidShapes(final ContainerShape shape, final IFeatureProvider fp) {	
		removeInvalidShapes(shape, fp, false);
	}
	
	// TODO: Refactor and/or remove when modes are actually supported. Will need a  more flexible method
	public static void removeModeSpecificOrInvalidShapes(final ContainerShape shape, final IFeatureProvider fp) {	
		removeInvalidShapes(shape, fp, true);
	}
	
	private static void removeInvalidShapes(final ContainerShape shape, final IFeatureProvider fp, boolean removeShapeInMode) {	
		final List<Shape> shapesToRemove = new ArrayList<Shape>();		
		for(final Shape childShape : shape.getChildren()) {
			// Check if the shape has a business object and can be updated
			final Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(childShape));
			final UpdateContext updateContext = new UpdateContext(childShape);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			if(bo == null || 
					(removeShapeInMode && (bo instanceof ModalElement) && ((ModalElement)bo).getAllInModes().size() != 0) ||
					updateFeature == null || (updateFeature != null && !updateFeature.canUpdate(updateContext))) {
				shapesToRemove.add(childShape);
			} else {
				EObject emfBusinesObject = (EObject)bo;
				if(emfBusinesObject.eIsProxy()) {
					emfBusinesObject = EcoreUtil.resolve(emfBusinesObject, OsateResourceUtil.getResourceSet());
				}
	
				if(emfBusinesObject.eIsProxy()) {
					shapesToRemove.add(childShape);
				}
			}
		}
		
		for(final Shape childShape : shapesToRemove) {
			EcoreUtil.delete(childShape, true);			
		}
	}
	
	public static void layoutChildren(final ContainerShape shape, final IFeatureProvider fp) {
		// Layout the children first
		for(final Shape child : shape.getChildren()) {
			final LayoutContext ctx = new LayoutContext(child);
			final ILayoutFeature feature = fp.getLayoutFeature(ctx);
			if(feature != null && feature.canLayout(ctx)) {
				feature.layout(ctx);
			}
		}
	}
	
	public static void removeInvalidFlowSpecifications(final Diagram diagram, final IFeatureProvider fp) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : diagram.getConnections()) {
			final Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(connection));
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
