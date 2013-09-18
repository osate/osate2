package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.osate.aadl2.Element;

/**
 * Contains methods to handle highlighting objects based on editor state
 * @author philip.alldredge
 *
 */
public interface HighlightingService {
	/**
	 * Sets the foreground color of the element depending on the selected mode, mode transition, flow, etc
	 * @param modalElement
	 * @param ga
	 */
	void highlight(Element element, GraphicsAlgorithm ga);
}