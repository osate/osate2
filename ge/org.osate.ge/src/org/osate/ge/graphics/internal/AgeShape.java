package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Marker for graphics which will be used to represent shapes. Not public API.
 */
public interface AgeShape extends Graphic {
	default boolean isMoveable() {
		return true;
	}

	default boolean isResizeable() {
		return true;
	}
}
