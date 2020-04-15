package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;

public enum TimeUnits {
	PS(1.0, "ps"),
	NS(1000.0, "ns"),
	US(1000000.0, "us"),
	MS(1.0E9, "ms"),
	SEC(1.0E12, "sec"),
	MIN(6.0E13, "min"),
	HR(3.6E15, "hr");
	
	private final double factorToBase;
	private final String originalName;
	
	private TimeUnits(double factorToBase, String originalName) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
	}
	
	public static TimeUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	public double getFactorToBase() {
		return factorToBase;
	}
	
	public double getFactorTo(TimeUnits target) {
		return factorToBase / target.factorToBase;
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
