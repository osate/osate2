package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedSourceLanguages {
	ADA95("Ada95"),
	ADA2005("Ada2005"),
	C("C"),
	JAVA("Java"),
	SIMULINK_6_5("Simulink_6_5"),
	SCADE("SCADE");
	
	private final String originalName;
	
	private SupportedSourceLanguages(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedSourceLanguages valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
