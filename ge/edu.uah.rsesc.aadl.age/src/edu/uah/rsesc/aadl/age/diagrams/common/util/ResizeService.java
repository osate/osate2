package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;

public interface ResizeService {

	/**
	 * Checks the size of the container and resizes it if necessary
	 */
	void checkContainerSize(ContainerShape shape);

	void checkSize(ContainerShape container);

}