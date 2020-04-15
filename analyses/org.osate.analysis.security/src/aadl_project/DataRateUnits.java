package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;

public enum DataRateUnits {
	BITSPS(1.0, "bitsps"),
	BYTESPS(8.0, "Bytesps"),
	KBYTESPS(8000.0, "KBytesps"),
	MBYTESPS(8000000.0, "MBytesps"),
	GBYTESPS(8.0E9, "GBytesps");
	
	private final double factorToBase;
	private final String originalName;
	
	private DataRateUnits(double factorToBase, String originalName) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
	}
	
	public static DataRateUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	public double getFactorToBase() {
		return factorToBase;
	}
	
	public double getFactorTo(DataRateUnits target) {
		return factorToBase / target.factorToBase;
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
