package org.osate.pluginsupport.properties;

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.OptionalLong;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

/**
 * @since 3.1
 */
public class IntegerRange {
	private final long minimum;
	private final long maximum;
	private final OptionalLong delta;

	public IntegerRange(PropertyExpression propertyExpression, NamedElement lookupContext) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((IntegerLiteral) resolveNamedValue(rangeValue.getMinimum(), lookupContext)).getValue();
		maximum = ((IntegerLiteral) resolveNamedValue(rangeValue.getMaximum(), lookupContext)).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalLong.empty();
		} else {
			PropertyExpression resolvedDelta = resolveNamedValue(rangeValue.getDelta(), lookupContext);
			delta = OptionalLong.of(((IntegerLiteral) resolvedDelta).getValue());
		}
	}

	public long getMinimum() {
		return minimum;
	}

	public long getMaximum() {
		return maximum;
	}

	public OptionalLong getDelta() {
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
		if (!(obj instanceof IntegerRange)) {
			return false;
		}
		IntegerRange other = (IntegerRange) obj;
		return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
		delta.ifPresent(it -> builder.append(" delta " + it));
		return builder.toString();
	}
}