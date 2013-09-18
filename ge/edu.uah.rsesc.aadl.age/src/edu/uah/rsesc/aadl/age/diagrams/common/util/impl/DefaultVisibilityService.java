package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

public class DefaultVisibilityService implements VisibilityService {
	private final PropertyService propertyUtil;
	
	public DefaultVisibilityService(final PropertyService propertyUtil) {
		this.propertyUtil = propertyUtil;
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
}
