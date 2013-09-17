package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class VisibilityHelper {
	public static void setIsGhost(final PictogramElement pe, final boolean isGhost) {
		PropertyUtil.setIsGhost(pe, isGhost);
		updateVisibility(pe);	
	}
	
	/**
	 * Updates the visibility of a pictogram element based on its properties
	 * @param pe
	 */
	private static void updateVisibility(final PictogramElement pe) {
		pe.setVisible(!PropertyUtil.isGhost(pe));
	}
	
	public static List<Shape> getNonGhostChildren(final ContainerShape shape) {
		final List<Shape> children = new ArrayList<Shape>();
		for(final Shape child : shape.getChildren()) {
			if(!PropertyUtil.isGhost(child)) {
				children.add(child);
			}
		}
		
		return children;
	}
}
