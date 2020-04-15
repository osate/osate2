package aadl_project;

import java.util.Objects;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

public class Time {
	private final long value;
	private final TimeUnits unit;
	
	public Time(PropertyExpression propertyExpression) {
		IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
		value = numberValue.getValue();
		unit = TimeUnits.valueOf(numberValue.getUnit().getName().toUpperCase());
	}
	
	public long getValue() {
		return value;
	}
	
	public TimeUnits getUnit() {
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
		if (!(obj instanceof Time)) {
			return false;
		}
		Time other = (Time) obj;
		return value == other.value && unit == other.unit;
	}
	
	@Override
	public String toString() {
		return value + unit.toString();
	}
}
