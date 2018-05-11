package org.osate.ge.internal.diagram.runtime.layout;

/**
 * Options that can be passed to the layout algorithm.
 * This is empty at the moment but exists for future use.
 * It exists because options were used for experimentation but then removed during experimentation.
 *
 */
public class LayoutOptions {
	// If true, ports will be assigned to the default side provided by the business object handler. Otherwise, the layout algorithm will determine the side to
	// which the port should be positioned.
	public final boolean layoutPortsOnDefaultSides;

	LayoutOptions(final boolean layoutPortsOnDefaultSide) {
		this.layoutPortsOnDefaultSides = layoutPortsOnDefaultSide;
	}

	public static LayoutOptions createFromPreferences() {
		return new LayoutOptionsBuilder().layoutPortsOnDefaultSides(LayoutPreferences.getLayoutPortsOnDefaultSides())
				.build();
	}
}