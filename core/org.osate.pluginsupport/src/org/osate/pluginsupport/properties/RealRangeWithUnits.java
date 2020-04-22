package org.osate.pluginsupport.properties;

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

/**
 * @since 4.0
 */
public class RealRangeWithUnits<U extends Enum<U> & GeneratedUnits> {
	private final RealWithUnits<U> minimum;
	private final RealWithUnits<U> maximum;
	private final Optional<RealWithUnits<U>> delta;

	public RealRangeWithUnits(PropertyExpression propertyExpression, Class<U> unitsType, NamedElement lookupContext) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new RealWithUnits<>(resolveNamedValue(rangeValue.getMinimum(), lookupContext), unitsType);
		maximum = new RealWithUnits<>(resolveNamedValue(rangeValue.getMaximum(), lookupContext), unitsType);
		delta = Optional.ofNullable(resolveNamedValue(rangeValue.getDelta(), lookupContext))
				.map(it -> new RealWithUnits<>(it, unitsType));
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