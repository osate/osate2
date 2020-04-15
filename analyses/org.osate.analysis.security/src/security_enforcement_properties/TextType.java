package security_enforcement_properties;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum TextType {
	PLAINTEXT("plainText"),
	CIPHERTEXT("cipherText");
	
	private final String originalName;
	
	private TextType(String originalName) {
		this.originalName = originalName;
	}
	
	public static TextType valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
