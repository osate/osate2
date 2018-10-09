package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Builder for creating note graphics.
 * @noextend
 * @see Graphic
 */
public class NoteGraphicBuilder {
	private NoteGraphicBuilder() {}

	/**
	 * Creates a note graphic builder.
	 * @return a note graphic builder
	 */
	public static NoteGraphicBuilder create() {
		return new NoteGraphicBuilder();
	}

	/**
	 * Creates a note graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public Graphic build() {
		return new NoteGraphic();
	}
}
