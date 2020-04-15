package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedDistributions {
	FIXED("Fixed"),
	POISSON("Poisson");
	
	private final String originalName;
	
	private SupportedDistributions(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedDistributions valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
