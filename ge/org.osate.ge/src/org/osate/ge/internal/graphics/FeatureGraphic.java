package org.osate.ge.internal.graphics;

import java.util.Objects;

public class FeatureGraphic implements AgeShape {
	public final Direction direction;
	public final FeatureType featureType;
	
	public FeatureGraphic(final Direction direction, final FeatureType featureType) {
		this.direction = Objects.requireNonNull(direction, "direction must not be null");
		this.featureType = Objects.requireNonNull(featureType, "featureType must not be null");
	}
	
	@Override
	public String getAnnotation() {
		switch(featureType) {
		case PORT_PROXY:
		case SUBPROGRAM_PROXY:
			return "<processor>";
			
		case EVENT_SOURCE:
		case EVENT_DATA_SOURCE:
			return "<internal>";
			
		default:
			return null;
		}
	}
}
