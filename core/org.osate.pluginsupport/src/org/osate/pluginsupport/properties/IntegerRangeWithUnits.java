package org.osate.pluginsupport.properties;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

/**
 * @since 3.0
 */
public class IntegerRangeWithUnits<U extends Enum<U>> {
	private final IntegerWithUnits<U> minimum;
	private final IntegerWithUnits<U> maximum;
	private final Optional<IntegerWithUnits<U>> delta;
	
	public IntegerRangeWithUnits(PropertyExpression propertyExpression, Class<U> unitsType) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new IntegerWithUnits<>(rangeValue.getMinimum(), unitsType);
		maximum = new IntegerWithUnits<>(rangeValue.getMaximum(), unitsType);
		delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new IntegerWithUnits<>(it, unitsType));
	}
	
	public IntegerWithUnits<U> getMinimum() {
		return minimum;
	}
	
	public IntegerWithUnits<U> getMaximum() {
		return maximum;
	}
	
	public Optional<IntegerWithUnits<U>> getDelta() {
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
		if (!(obj instanceof IntegerRangeWithUnits)) {
			return false;
		}
		IntegerRangeWithUnits<?> other = (IntegerRangeWithUnits<?>) obj;
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