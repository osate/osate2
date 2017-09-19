package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Marker for graphics which will be used to represent shapes. Not public API.
 */
public interface AgeShape extends Graphic {
	// Shapes may have a string which provides additional information about the shape. It is used in the case of internal and processor features 
	// which have the same graphical representation as other features.
	default String getAnnotation() { return null; }
	
	default boolean isMoveable() {
		return true;
	}
	
	default boolean isResizeable() {
		return true;
	}
}
