package org.osate.ge.internal.diagram.runtime.layout;

/**
 * Builder for LayoutOptions.
 *
 */
public class LayoutOptionsBuilder {
	private boolean layoutPortsOnDefaultSides = false;

	public LayoutOptionsBuilder layoutPortsOnDefaultSides(final boolean value) {
		layoutPortsOnDefaultSides = value;
		return this;
	}

	public final LayoutOptions build() {
		return new LayoutOptions(layoutPortsOnDefaultSides);
	}
}
