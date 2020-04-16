package org.osate.pluginsupport.properties;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

/**
 * @since 3.0
 */
public class IntegerWithUnits<U extends Enum<U> & GeneratedUnits> implements Comparable<IntegerWithUnits<U>> {
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
		return Double.hashCode(value * unit.getFactorToBase());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IntegerWithUnits)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		IntegerWithUnits<U> other = (IntegerWithUnits<U>) obj;
		if (!unit.getClass().equals(other.unit.getClass())) {
			return false;
		}
		if (unit == other.unit) {
			return value == other.value;
		} else {
			return compareTo(other) == 0;
		}
	}
	
	@Override
	public int compareTo(IntegerWithUnits<U> o) {
		return Double.compare(value * unit.getFactorToBase(), o.value * o.unit.getFactorToBase());
	}
	
	@Override
	public String toString() {
		return value + unit.toString();
	}
}