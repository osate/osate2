package aadl_project;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

public class SizeRange {
	private final Size minimum;
	private final Size maximum;
	private final Optional<Size> delta;
	
	public SizeRange(PropertyExpression propertyExpression) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new Size(rangeValue.getMinimum());
		maximum = new Size(rangeValue.getMaximum());
		delta = Optional.ofNullable(rangeValue.getDelta()).map(Size::new);
	}
	
	public Size getMinimum() {
		return minimum;
	}
	
	public Size getMaximum() {
		return maximum;
	}
	
	public Optional<Size> getDelta() {
		return delta;
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
		if (!(obj instanceof SizeRange)) {
			return false;
		}
		SizeRange other = (SizeRange) obj;
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
