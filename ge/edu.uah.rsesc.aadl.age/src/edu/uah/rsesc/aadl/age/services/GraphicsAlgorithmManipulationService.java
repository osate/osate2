package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;

/**
 * Contains methods for manipulating graphics algorithms
 * @author philip.alldredge
 *
 */
public interface GraphicsAlgorithmManipulationService {
	/**
	 * Mirrors a graphics algorithm in the x axis
	 * @param ga the graphics algorithm to mirror
	 */
	void mirror(GraphicsAlgorithm ga);

	// TODO: Make note of when this method causes issues(out of bounds drawing)
	void shrink(GraphicsAlgorithm ga);

}