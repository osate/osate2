package org.osate.propertiescodegen.common;

import java.util.Objects;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

public class IntegerWithUnits<U extends Enum<U>> {
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