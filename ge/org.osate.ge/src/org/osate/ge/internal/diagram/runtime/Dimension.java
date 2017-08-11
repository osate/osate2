package org.osate.ge.internal.diagram.runtime;

import java.util.Objects;

/**
 * Immutable dimension type.
 *
 */
public class Dimension {
	public Dimension(final int width, final int height) {
		this.width = width;
		this.height = height;
	}
	
	public Dimension(final Dimension d) {
		Objects.requireNonNull(d, "d must not be null");
		this.width = d.width;
		this.height = d.height;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		Dimension other = (Dimension) obj;
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}

	public org.osate.ge.diagram.Dimension toMetamodel() {
		final org.osate.ge.diagram.Dimension newDimension = new org.osate.ge.diagram.Dimension();
		newDimension.setWidth(width);
		newDimension.setHeight(height);
		return newDimension;
	}	
	
	public final int width;
	public final int height;
}
