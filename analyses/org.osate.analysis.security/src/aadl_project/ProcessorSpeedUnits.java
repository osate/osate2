package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;

public enum ProcessorSpeedUnits {
	KIPS(1.0, "KIPS"),
	MIPS(1000.0, "MIPS"),
	GIPS(1000000.0, "GIPS");
	
	private final double factorToBase;
	private final String originalName;
	
	private ProcessorSpeedUnits(double factorToBase, String originalName) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
	}
	
	public static ProcessorSpeedUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	public double getFactorToBase() {
		return factorToBase;
	}
	
	public double getFactorTo(ProcessorSpeedUnits target) {
		return factorToBase / target.factorToBase;
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
