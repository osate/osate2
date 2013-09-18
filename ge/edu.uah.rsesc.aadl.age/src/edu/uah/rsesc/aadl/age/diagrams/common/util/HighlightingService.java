package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.Element;

public interface HighlightingService {

	/**
	 * Sets the foreground color of the element depending on the selected mode, mode transition, or flow
	 * @param diagram
	 * @param modalElement
	 * @param ga
	 */
	void highlight(Diagram diagram, Element element, GraphicsAlgorithm ga);

}