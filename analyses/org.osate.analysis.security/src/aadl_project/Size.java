package aadl_project;

import java.util.Objects;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

public class Size {
	private final long value;
	private final SizeUnits unit;
	
	public Size(PropertyExpression propertyExpression) {
		IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
		value = numberValue.getValue();
		unit = SizeUnits.valueOf(numberValue.getUnit().getName().toUpperCase());
	}
	
	public long getValue() {
		return value;
	}
	
	public SizeUnits getUnit() {
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
		if (!(obj instanceof Size)) {
			return false;
		}
		Size other = (Size) obj;
		return value == other.value && unit == other.unit;
	}
	
	@Override
	public String toString() {
		return value + unit.toString();
	}
}
