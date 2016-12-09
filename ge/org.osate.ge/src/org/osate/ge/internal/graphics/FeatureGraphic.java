package org.osate.ge.internal.graphics;

import java.util.Objects;

public class FeatureGraphic implements AgeShape {
	public final Direction direction;
	public final FeatureType featureType;
	
	public FeatureGraphic(final Direction direction, final FeatureType featureType) {
		this.direction = Objects.requireNonNull(direction, "direction must not be null");
		this.featureType = Objects.requireNonNull(featureType, "featureType must not be null");
	}
}
