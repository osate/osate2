package edu.uah.rsesc.aadl.age.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

public class DefaultVisibilityService implements VisibilityService {
	private final PropertyService propertyUtil;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultVisibilityService(final PropertyService propertyUtil, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.propertyUtil = propertyUtil;
		this.bor = bor;
		this.fp = fp;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService#setIsGhost(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public void setIsGhost(final PictogramElement pe, final boolean isGhost) {
		propertyUtil.setIsGhost(pe, isGhost);
		updateVisibility(pe);	
	}
	
	/**
	 * Updates the visibility of a pictogram element based on its properties
	 * @param pe
	 */
	private void updateVisibility(final PictogramElement pe) {
		pe.setVisible(!propertyUtil.isGhost(pe));
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService#getNonGhostChildren(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public List<Shape> getNonGhostChildren(final ContainerShape shape) {
		final List<Shape> children = new ArrayList<Shape>();
		for(final Shape child : shape.getChildren()) {
			if(!propertyUtil.isGhost(child)) {
				children.add(child);
			}
		}
		
		return children;
	}
	
	@Override
	public void ghostInvalidShapes(final ContainerShape shape) {
		for(final Shape childShape : shape.getChildren()) {
			// Check if the shape has a business object and can be updated
			final Object bo = bor.getBusinessObjectForPictogramElement(childShape);
			final UpdateContext updateContext = new UpdateContext(childShape);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Determine whether to ghost the shape
			boolean ghost = false;
			if(bo == null || updateFeature == null || (updateFeature != null && !updateFeature.canUpdate(updateContext))) {
				ghost = true;
			} else {
				EObject emfBusinessObject = (EObject)bo;
				if(emfBusinessObject.eIsProxy()) {
					emfBusinessObject = EcoreUtil.resolve(emfBusinessObject, OsateResourceUtil.getResourceSet());
				}
	
				if(emfBusinessObject.eIsProxy()) {
					ghost = true;
				}
			}
			
			// Ghost the shape
			if(ghost) {
				setIsGhost(childShape, true);
			}
		}
	}
	
	@Override
	public void ghostInvalidConnections() {
		for(final Connection connection : getDiagram().getConnections()) {
			final Object bo = bor.getBusinessObjectForPictogramElement(connection);
			if(!(bo instanceof EObject)) {
				setIsGhost(connection, true);
			}
		}
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
}
