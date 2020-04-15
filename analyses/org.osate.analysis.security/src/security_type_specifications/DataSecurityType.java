package security_type_specifications;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum DataSecurityType {
	NO_PROTECTION("no_protection"),
	ENCRYPTION("encryption"),
	AUTHENTICATION("authentication"),
	AUTHENTICATED_ENCRYPTION("authenticated_encryption"),
	TLS("TLS");
	
	private final String originalName;
	
	private DataSecurityType(String originalName) {
		this.originalName = originalName;
	}
	
	public static DataSecurityType getValue(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
