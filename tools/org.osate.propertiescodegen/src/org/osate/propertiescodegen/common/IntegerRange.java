package org.osate.propertiescodegen.common;

import java.util.Objects;
import java.util.OptionalLong;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

public class IntegerRange {
	private final long minimum;
	private final long maximum;
	private final OptionalLong delta;
	
	public IntegerRange(PropertyExpression propertyExpression) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((IntegerLiteral) rangeValue.getMinimum()).getValue();
		maximum = ((IntegerLiteral) rangeValue.getMaximum()).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalLong.empty();
		} else {
			delta = OptionalLong.of(((IntegerLiteral) rangeValue.getDelta()).getValue());
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