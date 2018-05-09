package org.osate.ge.graphics.internal;

public class Parallelogram implements AgeShape {
	public final int horizontalOffset;

	public Parallelogram(final int horizontalOffset) {
		this.horizontalOffset = horizontalOffset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horizontalOffset;
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
		Parallelogram other = (Parallelogram) obj;
		if (horizontalOffset != other.horizontalOffset) {
			return false;
		}
		return true;
	}
}
