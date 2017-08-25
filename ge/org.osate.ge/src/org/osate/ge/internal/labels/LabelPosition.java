package org.osate.ge.internal.labels;

public enum LabelPosition {
	DEFAULT,
	GRAPHIC_BEGINNING,
	GRAPHIC_CENTER,
	GRAPHIC_END,
	BEFORE_GRAPHIC,
	AFTER_GRAPHIC;

	public LabelPosition mirror() {
		switch(this) {
		case AFTER_GRAPHIC:
			return BEFORE_GRAPHIC;

		case BEFORE_GRAPHIC:
			return AFTER_GRAPHIC;

		case GRAPHIC_BEGINNING:
			return GRAPHIC_END;

		case GRAPHIC_CENTER:
			return GRAPHIC_CENTER;

		case GRAPHIC_END:
			return GRAPHIC_BEGINNING;

		case DEFAULT:
			return DEFAULT;

		default:
			return this;
		}
	}

	public final boolean isOutside() {
		return this == BEFORE_GRAPHIC || this == AFTER_GRAPHIC;
	}
}
