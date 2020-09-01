package org.osate.properties.security;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum KeyDistribitionMethod implements GeneratedEnumeration {
	PUBLIC_BROADCAST_CHANNEL("public_broadcast_channel", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.0"),
	PUBLIC_ONE_TO_ONE_CHANNEL("public_one_to_one_channel", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.1"),
	ENCRYPTED_CHANNEL("encrypted_channel", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.2"),
	AUTHENTICATED_CHANNEL("authenticated_channel", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.3"),
	ENCRYPTED_AND_AUTHENTICATED_CHANNEL("encrypted_and_authenticated_channel", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.4"),
	QKD("QKD", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.5"),
	DIRECT_PHYSICAL_EXCHANGE("direct_physical_exchange", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.6"),
	COURIER("courier", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.21/@ownedPropertyType/@ownedLiteral.7");
	
	private final String originalName;
	private final URI uri;
	
	private KeyDistribitionMethod(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static KeyDistribitionMethod valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public URI getURI() {
		return uri;
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
