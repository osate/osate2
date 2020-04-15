package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedClassifierSubstitutions {
	CLASSIFIER_MATCH("Classifier_Match"),
	TYPE_EXTENSION("Type_Extension"),
	SIGNATURE_MATCH("Signature_Match");
	
	private final String originalName;
	
	private SupportedClassifierSubstitutions(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedClassifierSubstitutions valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
