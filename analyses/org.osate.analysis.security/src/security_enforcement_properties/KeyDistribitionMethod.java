package security_enforcement_properties;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;

public enum KeyDistribitionMethod {
	PUBLIC_BROADCAST_CHANNEL("public_broadcast_channel"),
	PUBLIC_ONE_TO_ONE_CHANNEL("public_one_to_one_channel"),
	ENCRYPTED_CHANNEL("encrypted_channel"),
	AUTHENTICATED_CHANNEL("authenticated_channel"),
	ENCRYPTED_AND_AUTHENTICATED_CHANNEL("encrypted_and_authenticated_channel"),
	QKD("QKD"),
	DIRECT_PHYSICAL_EXCHANGE("direct_physical_exchange"),
	COURIER("courier");
	
	private final String originalName;
	
	private KeyDistribitionMethod(String originalName) {
		this.originalName = originalName;
	}
	
	public static KeyDistribitionMethod valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
