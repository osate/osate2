package org.osate.ge.internal.services;

import java.util.Map;

import org.osate.aadl2.NamedElement;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.query.Queryable;

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
	 * Returns a map of override foreground colors for elements.
	 */
	Map<DiagramElement, Color> buildForegroundColorMap();

	// TODO: Rework. Should be split out from the service.
	void setHighlightedMode(NamedElement ne, Queryable boc);

	void setHighlightedFlow(NamedElement ne, Queryable boc);
}