package org.osate.pluginsupport.properties;

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;

/**
 * @since 5.0
 */
public class RealRange {
	private final double minimum;
	private final double maximum;
	private final OptionalDouble delta;
	
	public RealRange(double minimum, double maximum) {
		this(minimum, maximum, OptionalDouble.empty());
	}
	
	public RealRange(double minimum, double maximum, double delta) {
		this(minimum, maximum, OptionalDouble.of(delta));
	}
	
	public RealRange(double minimum, double maximum, OptionalDouble delta) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.delta = delta;
	}

	public RealRange(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((RealLiteral) resolveNamedValue(rangeValue.getMinimum(), lookupContext, mode)).getValue();
		maximum = ((RealLiteral) resolveNamedValue(rangeValue.getMaximum(), lookupContext, mode)).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalDouble.empty();
		} else {
			PropertyExpression resolvedDelta = resolveNamedValue(rangeValue.getDelta(), lookupContext, mode);
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
	
	public RangeValue toPropertyExpression() {
		RangeValue rangeValue = Aadl2Factory.eINSTANCE.createRangeValue();
		
		RealLiteral minimumValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		minimumValue.setValue(minimum);
		rangeValue.setMinimum(minimumValue);
		
		RealLiteral maximumValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		maximumValue.setValue(maximum);
		rangeValue.setMaximum(maximumValue);
		
		delta.ifPresent(delta -> {
			RealLiteral deltaValue = Aadl2Factory.eINSTANCE.createRealLiteral();
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