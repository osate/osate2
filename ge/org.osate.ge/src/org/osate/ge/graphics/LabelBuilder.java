package org.osate.ge.graphics;

import org.osate.ge.graphics.internal.Label;

/**
 * Builder for creating label graphics
 * @noextend
 * @see Graphic
 */
public class LabelBuilder {
	private LabelBuilder() {}
	
	/**
	 * Creates a label graphic builder.
	 * @return a label graphic builder
	 */
	public static LabelBuilder create() {
		return new LabelBuilder();
	}
	/**
	 * Creates a label graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new Label();
	}
}
