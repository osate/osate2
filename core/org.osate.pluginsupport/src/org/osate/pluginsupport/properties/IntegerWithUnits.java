package org.osate.pluginsupport.properties;

import java.util.Objects;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

/**
 * @since 3.0
 */
public class IntegerWithUnits<U extends Enum<U> & GeneratedUnits> {
	private final long value;
	private final U unit;
	
	public IntegerWithUnits(PropertyExpression propertyExpression, Class<U> unitsType) {
		IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
		value = numberValue.getValue();
		unit = Enum.valueOf(unitsType, numberValue.getUnit().getName().toUpperCase());
	}
	
	public long getValue() {
		return value;
	}
	
	public U getUnit() {
		return unit;
	}
	
	public double getValue(U targetUnit) {
		return value * unit.getFactorToBase() / targetUnit.getFactorToBase();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value, unit);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IntegerWithUnits)) {
			return false;
		}
		IntegerWithUnits<?> other = (IntegerWithUnits<?>) obj;
		return value == other.value && unit == other.unit;
	}
	
	@Override
	public String toString() {
		return value + unit.toString();
	}
}