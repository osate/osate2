package org.osate.ge.graphics.internal;

import java.util.Objects;

public class FeatureGraphic implements AgeShape {
	public final Direction direction;
	public final FeatureGraphicType featureType;

	public FeatureGraphic(final Direction direction, final FeatureGraphicType featureType) {
		this.direction = Objects.requireNonNull(direction, "direction must not be null");
		this.featureType = Objects.requireNonNull(featureType, "featureType must not be null");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((featureType == null) ? 0 : featureType.hashCode());
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
		FeatureGraphic other = (FeatureGraphic) obj;
		if (direction != other.direction) {
			return false;
		}
		if (featureType != other.featureType) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isResizeable() {
		return featureType == FeatureGraphicType.FEATURE_GROUP;
	}
}
