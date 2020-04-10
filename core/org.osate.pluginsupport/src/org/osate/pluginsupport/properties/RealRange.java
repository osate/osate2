package org.osate.pluginsupport.properties;

import java.util.Objects;
import java.util.OptionalDouble;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;

/**
 * @since 3.0
 */
public class RealRange {
	private final double minimum;
	private final double maximum;
	private final OptionalDouble delta;
	
	public RealRange(PropertyExpression propertyExpression) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((RealLiteral) rangeValue.getMinimum()).getValue();
		maximum = ((RealLiteral) rangeValue.getMaximum()).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalDouble.empty();
		} else {
			delta = OptionalDouble.of(((RealLiteral) rangeValue.getDelta()).getValue());
		}
	}
	
	public double getMinimum() {
		return minimum;
	}
	
	public double getMaximum() {
		return maximum;
	}
	
	public OptionalDouble getDelta() {
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
		if (!(obj instanceof RealRange)) {
			return false;
		}
		RealRange other = (RealRange) obj;
		return Double.doubleToLongBits(minimum) == Double.doubleToLongBits(other.minimum)
				&& Double.doubleToLongBits(maximum) == Double.doubleToLongBits(other.maximum)
				&& Objects.equals(delta, other.delta);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
		delta.ifPresent(it -> builder.append(" delta " + it));
		return builder.toString();
	}
}