package org.osate.pluginsupport.properties;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;

/**
 * @since 5.0
 */
public class RealWithUnits<U extends Enum<U> & GeneratedUnits<U>> implements Comparable<RealWithUnits<U>> {
	private final double value;
	private final U unit;
	
	public RealWithUnits(double value, U unit) {
		this.value = value;
		this.unit = unit;
	}

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

	public double getValue(U targetUnit) {
		return value * unit.getFactorToBase() / targetUnit.getFactorToBase();
	}
	
	public RealLiteral toPropertyExpression(ResourceSet resourceSet) {
		RealLiteral numberValue = Aadl2Factory.eINSTANCE.createRealLiteral();
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
		if (!(obj instanceof RealWithUnits)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		RealWithUnits<U> other = (RealWithUnits<U>) obj;
		if (!unit.getClass().equals(other.unit.getClass())) {
			return false;
		}
		if (unit == other.unit) {
			return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
		} else {
			return compareTo(other) == 0;
		}
	}

	@Override
	public int compareTo(RealWithUnits<U> o) {
		return Double.compare(value * unit.getFactorToBase(), o.value * o.unit.getFactorToBase());
	}

	@Override
	public String toString() {
		return value + unit.toString();
	}
}