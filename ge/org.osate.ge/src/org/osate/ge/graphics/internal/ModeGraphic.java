package org.osate.ge.graphics.internal;

public class ModeGraphic implements AgeShape {
	public final boolean isInitialMode;

	public ModeGraphic(final boolean isInitialMode) {
		this.isInitialMode = isInitialMode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isInitialMode ? 1231 : 1237);
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
		return true;
	}
}
