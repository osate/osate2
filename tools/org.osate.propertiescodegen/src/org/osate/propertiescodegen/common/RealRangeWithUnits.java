package org.osate.propertiescodegen.common;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

public class RealRangeWithUnits<U extends Enum<U>> {
	private final RealWithUnits<U> minimum;
	private final RealWithUnits<U> maximum;
	private final Optional<RealWithUnits<U>> delta;
	
	public RealRangeWithUnits(PropertyExpression propertyExpression, Class<U> unitsType) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new RealWithUnits<>(rangeValue.getMinimum(), unitsType);
		maximum = new RealWithUnits<>(rangeValue.getMaximum(), unitsType);
		delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new RealWithUnits<>(it, unitsType));
	}
	
	public RealWithUnits<U> getMinimum() {
		return minimum;
	}
	
	public RealWithUnits<U> getMaximum() {
		return maximum;
	}
	
	public Optional<RealWithUnits<U>> getDelta() {
		return delta;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(minimum, maximum, delta);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RealRangeWithUnits)) {
			return false;
		}
		RealRangeWithUnits<?> other = (RealRangeWithUnits<?>) obj;
		return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
				&& Objects.equals(delta, other.delta);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
		delta.ifPresent(it -> builder.append(" delta " + it));
		return builder.toString();
	}
}