package org.osate.ge.internal.labels;

public enum LabelPosition {
	DEFAULT,
	GRAPHIC_BEGINNING,
	GRAPHIC_CENTER,
	GRAPHIC_END,
	BEFORE_GRAPHIC,
	AFTER_GRAPHIC;
	
	/**
	 * Returns whether the position is outside the graphic. That is, the position is before or after the graphic.
	 * @return whether the position is outside the graphic
	 */
	public boolean isOutside() {
		return this == BEFORE_GRAPHIC || this == AFTER_GRAPHIC;
	}
}
