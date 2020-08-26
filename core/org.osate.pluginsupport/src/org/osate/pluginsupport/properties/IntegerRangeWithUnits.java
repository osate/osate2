package org.osate.pluginsupport.properties;

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

/**
 * @since 5.0
 */
public class IntegerRangeWithUnits<U extends Enum<U> & GeneratedUnits<U>> {
	private final IntegerWithUnits<U> minimum;
	private final IntegerWithUnits<U> maximum;
	private final Optional<IntegerWithUnits<U>> delta;
	
	public IntegerRangeWithUnits(IntegerWithUnits<U> minimum, IntegerWithUnits<U> maximum) {
		this(minimum, maximum, Optional.empty());
	}
	
	public IntegerRangeWithUnits(IntegerWithUnits<U> minimum, IntegerWithUnits<U> maximum, IntegerWithUnits<U> delta) {
		this(minimum, maximum, Optional.of(delta));
	}
	
	public IntegerRangeWithUnits(IntegerWithUnits<U> minimum, IntegerWithUnits<U> maximum,
			Optional<IntegerWithUnits<U>> delta) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.delta = delta;
	}

	public IntegerRangeWithUnits(PropertyExpression propertyExpression, Class<U> unitsType,
			NamedElement lookupContext, Optional<Mode> mode) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new IntegerWithUnits<>(resolveNamedValue(rangeValue.getMinimum(), lookupContext, mode), unitsType);
		maximum = new IntegerWithUnits<>(resolveNamedValue(rangeValue.getMaximum(), lookupContext, mode), unitsType);
		delta = Optional.ofNullable(resolveNamedValue(rangeValue.getDelta(), lookupContext, mode))
				.map(it -> new IntegerWithUnits<>(it, unitsType));
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
	
	public RangeValue toPropertyExpression(ResourceSet resourceSet) {
		RangeValue rangeValue = Aadl2Factory.eINSTANCE.createRangeValue();
		rangeValue.setMinimum(minimum.toPropertyExpression(resourceSet));
		rangeValue.setMaximum(maximum.toPropertyExpression(resourceSet));
		delta.ifPresent(delta -> rangeValue.setDelta(delta.toPropertyExpression(resourceSet)));
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