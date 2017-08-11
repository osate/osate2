package org.osate.ge.internal.graphics;

public class ModeGraphic implements AgeShape {
	public final boolean isInitialMode;
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public ModeGraphic(final boolean isInitialMode, final int lineWidth, final LineStyle lineStyle) {
		this.isInitialMode = isInitialMode;
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isInitialMode ? 1231 : 1237);
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + lineWidth;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ModeGraphic other = (ModeGraphic) obj;
		if (isInitialMode != other.isInitialMode) {
			return false;
		}
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth != other.lineWidth) {
			return false;
		}
		return true;
	}
}
