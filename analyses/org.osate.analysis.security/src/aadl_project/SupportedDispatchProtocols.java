package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedDispatchProtocols {
	PERIODIC("Periodic"),
	SPORADIC("Sporadic"),
	APERIODIC("Aperiodic"),
	TIMED("Timed"),
	HYBRID("Hybrid"),
	BACKGROUND("Background");
	
	private final String originalName;
	
	private SupportedDispatchProtocols(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedDispatchProtocols valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
