package org.osate.ge.internal.services;

import org.osate.aadl2.NamedElement;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Contains methods to handle highlighting objects based on editor state
 *
 */
public interface ColoringService {
	// TODO: Should have a way to batch these changes before making API.
	interface Coloring {
		void dispose();

		/**
		 *
		 * @param de
		 * @param color setting color to null returns the element to its default color.
		 */
		void setForeground(DiagramElement de, Color color);

		void clear();
	}

	/**
	 * Allows the caller to configure the colors of specific pictograms. The returned Coloring object is used to configure colors.
	 * The Colorings object must be disposed() when coloring is no longer desired. Overrides default highlighting.
	 * @return
	 */
	Coloring adjustColors();

	/**
	 * Returns the override foreground color for the element.
	 * @param de
	 * @return the overridden color or null if the default color should be used.
	 */
	Color getForegroundColor(DiagramElement de);

	// TODO: Rework. Should be split out from the service.
	void setHighlightedMode(NamedElement ne);
	void setHighlightedFlow(NamedElement ne);
}