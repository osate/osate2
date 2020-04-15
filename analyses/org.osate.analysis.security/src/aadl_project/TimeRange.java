package aadl_project;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

public class TimeRange {
	private final Time minimum;
	private final Time maximum;
	private final Optional<Time> delta;
	
	public TimeRange(PropertyExpression propertyExpression) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new Time(rangeValue.getMinimum());
		maximum = new Time(rangeValue.getMaximum());
		delta = Optional.ofNullable(rangeValue.getDelta()).map(Time::new);
	}
	
	public Time getMinimum() {
		return minimum;
	}
	
	public Time getMaximum() {
		return maximum;
	}
	
	public Optional<Time> getDelta() {
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
		if (!(obj instanceof TimeRange)) {
			return false;
		}
		TimeRange other = (TimeRange) obj;
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
