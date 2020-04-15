package aadl_project;

import java.util.Objects;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

public class DataVolume {
	private final long value;
	private final DataVolumeUnits unit;
	
	public DataVolume(PropertyExpression propertyExpression) {
		IntegerLiteral numberValue = (IntegerLiteral) propertyExpression;
		value = numberValue.getValue();
		unit = DataVolumeUnits.valueOf(numberValue.getUnit().getName().toUpperCase());
	}
	
	public long getValue() {
		return value;
	}
	
	public DataVolumeUnits getUnit() {
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
		if (!(obj instanceof DataVolume)) {
			return false;
		}
		DataVolume other = (DataVolume) obj;
		return value == other.value && unit == other.unit;
	}
	
	@Override
	public String toString() {
		return value + unit.toString();
	}
}
