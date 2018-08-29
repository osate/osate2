package org.osate.ge.graphics.internal;

public class Rectangle implements AgeShape {
	public final boolean rounded;

	public Rectangle(final boolean rounded) {
		this.rounded = rounded;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (rounded ? 1231 : 1237);
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
		Rectangle other = (Rectangle) obj;
		if (rounded != other.rounded) {
			return false;
		}
		return true;
	}

}
