package org.osate.ge.internal.diagram;

import java.util.Objects;

/**
 * Immutable dimension type.
 *
 */
public class Dimension {
	public Dimension(final int width, final int height) {
		this.width = width;
		this.height = height;
	}
	
	public Dimension(final Dimension d) {
		Objects.requireNonNull(d, "d must not be null");
		this.width = d.width;
		this.height = d.height;
	}
	
	public final int width;
	public final int height;
}
