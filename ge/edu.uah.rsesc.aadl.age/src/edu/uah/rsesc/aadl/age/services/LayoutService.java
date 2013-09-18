package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * Contains methods for aiding in laying out shapes
 * @author philip.alldredge
 *
 */
public interface LayoutService {

	/**
	 * Checks the size of the container and resizes it if necessary
	 */
	void checkContainerSize(ContainerShape shape);

	void checkSize(ContainerShape container);
	
	void layoutChildren(ContainerShape shape);

	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container
	 * @param shape
	 * @param fp
	 */
	int[] adjustChildShapePositions(ContainerShape shape);
}