package org.osate.pluginsupport.properties;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

/**
 * @since 5.0
 */
public class IntegerWithUnits<U extends Enum<U> & GeneratedUnits<U>> implements Comparable<IntegerWithUnits<U>> {
	private final long value;
	private final U unit;
	
	public IntegerWithUnits(long value, U unit) {
		this.value = value;
		this.unit = unit;
	}

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
	
	public IntegerLiteral toPropertyExpression(ResourceSet resourceSet) {
		IntegerLiteral numberValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		numberValue.setValue(value);
		numberValue.setUnit(unit.toUnitLiteral(resourceSet));
		return numberValue;
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