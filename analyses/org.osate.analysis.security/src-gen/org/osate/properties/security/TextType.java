package org.osate.properties.security;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum TextType implements GeneratedEnumeration {
	PLAINTEXT("plainText", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.19/@ownedPropertyType/@ownedLiteral.0"),
	CIPHERTEXT("cipherText", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security.aadl#/0/@ownedProperty.19/@ownedPropertyType/@ownedLiteral.1");
	
	private final String originalName;
	private final URI uri;
	
	private TextType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static TextType valueOf(PropertyExpression propertyExpression) {
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
