package org.osate.propertiescodegen.common;

import java.util.Objects;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;

public class RealWithUnits<U extends Enum<U>> {
	private final double value;
	private final U unit;
	
	public RealWithUnits(PropertyExpression propertyExpression, Class<U> unitsType) {
		RealLiteral numberValue = (RealLiteral) propertyExpression;
		value = numberValue.getValue();
		unit = Enum.valueOf(unitsType, numberValue.getUnit().getName().toUpperCase());
	}
	
	public double getValue() {
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
		if (!(obj instanceof RealWithUnits)) {
			return false;
		}
		RealWithUnits<?> other = (RealWithUnits<?>) obj;
		return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
	}
	
	@Override
	public String toString() {
		return value + unit.toString();
	}
}