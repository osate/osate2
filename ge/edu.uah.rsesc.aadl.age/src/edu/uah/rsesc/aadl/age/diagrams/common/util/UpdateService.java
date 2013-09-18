package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public interface UpdateService {

	/**
	 * Ghosts invalid shapes from a diagram. An invalid shape is defined as a top level shape that is not associated with a business object or can not be updated
	 * @param diagram
	 */
	void ghostInvalidShapes(ContainerShape shape);

	void layoutChildren(ContainerShape shape);

	void removeConnectionsByAnchorParent(Diagram diagram,
			PictogramElement anchorParent);

	/**
	 * Turns connections that are invalid into ghosts. Such as ones that do not have a valid business object associated with them.
	 * @param diagram
	 * @param fp
	 */
	void ghostInvalidConnections(Diagram diagram);

	/**
	 * Removes anchors from a shape if they do not have connections. Not recursive.
	 * @param shape
	 */
	void removeAnchorsWithoutConnections(Shape shape);

	/**
	 * Refresh styles used by all the diagrams. Removes all styles from the diagram and then finds any usage of styles and reset them.
	 * @param diagram
	 */
	void refreshStyles(Diagram diagram);
	
	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container
	 * @param shape
	 * @param fp
	 */
	int[] adjustChildShapePositions(ContainerShape shape);

}