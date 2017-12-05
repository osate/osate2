package org.osate.ge.internal.diagram.runtime.layout;

import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.Dimension;

/**
 * Provides information needed to layout a diagram which is not contained in the runtime diagram data structure.
 *
 */
public interface LayoutInfoProvider {
	/**
	 *
	 * @param de
	 * @return null if a size cannot be determined.
	 */
	Dimension getPrimaryLabelSize(DiagramElement de);

	/**
	 * Returns the unrotated size of the port for a docked diagram element.
	 * For example, for data ports this is the size of the graphic if the port was docked to the left or right side of its parent. For feature groups it is the size of the circle.
	 * Must not return null.
	 * @param dockedElement must be a docked graphical element.
	 * @return
	 */
	Dimension getPortGraphicSize(DiagramElement dockedElement);

	/**
	 * Returns the size of all labels and padding. This includes any annotations as well.
	 * @param dockedElement
	 * @return
	 */
	Dimension getLabelsSize(DiagramElement dockedElement);
}
