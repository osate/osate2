package org.osate.ge.graphics.internal;

import java.util.Optional;

import org.osate.ge.graphics.Dimension;

public class Ellipse implements AgeShape {
	private final Dimension fixedSize;

	public Ellipse(final Dimension fixedSize) {
		this.fixedSize = fixedSize;
	}

	@Override
	public final boolean isResizeable() {
		return fixedSize == null;
	}

	public final Optional<Dimension> getFixedSize() {
		return Optional.ofNullable(fixedSize);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fixedSize == null) ? 0 : fixedSize.hashCode());
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
		Ellipse other = (Ellipse) obj;
		if (fixedSize == null) {
			if (other.fixedSize != null) {
				return false;
			}
		} else if (!fixedSize.equals(other.fixedSize)) {
			return false;
		}
		return true;
	}
}
