package org.osate.pluginsupport.properties;

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.OptionalDouble;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;

/**
 * @since 3.1
 */
public class RealRange {
	private final double minimum;
	private final double maximum;
	private final OptionalDouble delta;

	public RealRange(PropertyExpression propertyExpression, NamedElement lookupContext) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((RealLiteral) resolveNamedValue(rangeValue.getMinimum(), lookupContext)).getValue();
		maximum = ((RealLiteral) resolveNamedValue(rangeValue.getMaximum(), lookupContext)).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalDouble.empty();
		} else {
			PropertyExpression resolvedDelta = resolveNamedValue(rangeValue.getDelta(), lookupContext);
			delta = OptionalDouble.of(((RealLiteral) resolvedDelta).getValue());
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