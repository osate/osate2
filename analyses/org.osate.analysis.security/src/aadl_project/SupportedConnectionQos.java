package aadl_project;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum SupportedConnectionQos {
	GUARANTEEDDELIVERY("GuaranteedDelivery"),
	ORDEREDDELIVERY("OrderedDelivery"),
	SECUREDELIVERY("SecureDelivery");
	
	private final String originalName;
	
	private SupportedConnectionQos(String originalName) {
		this.originalName = originalName;
	}
	
	public static SupportedConnectionQos valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
