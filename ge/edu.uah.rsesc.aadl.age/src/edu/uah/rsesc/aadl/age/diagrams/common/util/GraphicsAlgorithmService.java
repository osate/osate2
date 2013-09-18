package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;

public interface GraphicsAlgorithmService {

	/**
	 * Mirrors agraphics algorithm in the x axis
	 * @param ga the graphics algorithm to mirror
	 */
	void mirror(GraphicsAlgorithm ga);

	// TODO: Make note of when this method causes issues(out of bounds drawing)
	void shrink(GraphicsAlgorithm ga);

}