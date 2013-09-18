package edu.uah.rsesc.aadl.age.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Provides methods for checking and affecting the visibility of objects. A ghost object is an object that is in the diagram
 * but is hidden because it has been deleted.
 * @author philip.alldredge
 *
 */
public interface VisibilityService {
	void setIsGhost(PictogramElement pe, boolean isGhost);

	List<Shape> getNonGhostChildren(ContainerShape shape);
	
	/**
	 * Ghosts invalid shapes from a diagram. An invalid shape is defined as a top level shape that is not associated with a business object or can not be updated
	 * @param diagram
	 */
	void ghostInvalidShapes(ContainerShape shape);
	
	/**
	 * Turns connections that are invalid into ghosts. Such as ones that do not have a valid business object associated with them.
	 * @param diagram
	 */
	void ghostInvalidConnections();
}