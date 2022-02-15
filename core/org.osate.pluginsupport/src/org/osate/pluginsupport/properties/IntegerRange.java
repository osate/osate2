package org.osate.pluginsupport.properties;

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

/**
 * @since 5.0
 */
public class IntegerRange {
	private final long minimum;
	private final long maximum;
	private final OptionalLong delta;

	public IntegerRange(long minimum, long maximum) {
		this(minimum, maximum, OptionalLong.empty());
	}

	public IntegerRange(long minimum, long maximum, long delta) {
		this(minimum, maximum, OptionalLong.of(delta));
	}

	public IntegerRange(long minimum, long maximum, OptionalLong delta) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.delta = delta;
	}

	/**
	 * This constructor is meant only to be called by generated Java property getters when looking up the value of a
	 * property.
	 */
	public IntegerRange(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((IntegerLiteral) resolveNamedValue(rangeValue.getMinimum(), lookupContext, mode)).getValue();
		maximum = ((IntegerLiteral) resolveNamedValue(rangeValue.getMaximum(), lookupContext, mode)).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalLong.empty();
		} else {
			PropertyExpression resolvedDelta = resolveNamedValue(rangeValue.getDelta(), lookupContext, mode);
			delta = OptionalLong.of(((IntegerLiteral) resolvedDelta).getValue());
		}
	}

	/**
	 * This constructor is meant only to be called by generated Java property getters when looking up the value of a
	 * property constant.
	 *
	 * @since 7.1
	 */
	public IntegerRange(PropertyExpression propertyExpression) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((IntegerLiteral) resolveNamedValue(rangeValue.getMinimum())).getValue();
		maximum = ((IntegerLiteral) resolveNamedValue(rangeValue.getMaximum())).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalLong.empty();
		} else {
			delta = OptionalLong.of(((IntegerLiteral) resolveNamedValue(rangeValue.getDelta())).getValue());
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

	public RangeValue toPropertyExpression() {
		RangeValue rangeValue = Aadl2Factory.eINSTANCE.createRangeValue();

		IntegerLiteral minimumValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		minimumValue.setValue(minimum);
		rangeValue.setMinimum(minimumValue);

		IntegerLiteral maximumValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		maximumValue.setValue(maximum);
		rangeValue.setMaximum(maximumValue);

		delta.ifPresent(delta -> {
			IntegerLiteral deltaValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			deltaValue.setValue(delta);
			rangeValue.setDelta(deltaValue);
		});

		return rangeValue;
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