package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;

public enum SizeUnits {
	BITS(1.0, "bits"),
	BYTES(8.0, "Bytes"),
	KBYTE(8000.0, "KByte"),
	MBYTE(8000000.0, "MByte"),
	GBYTE(8.0E9, "GByte"),
	TBYTE(8.0E12, "TByte");
	
	private final double factorToBase;
	private final String originalName;
	
	private SizeUnits(double factorToBase, String originalName) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
	}
	
	public static SizeUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	public double getFactorToBase() {
		return factorToBase;
	}
	
	public double getFactorTo(SizeUnits target) {
		return factorToBase / target.factorToBase;
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
