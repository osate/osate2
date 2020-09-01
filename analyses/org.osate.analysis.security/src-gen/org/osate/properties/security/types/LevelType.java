package org.osate.properties.security.types;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum LevelType implements GeneratedEnumeration {
	TOPSECRET("TopSecret", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
	SECRET("Secret", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
	CONFIDENTIAL("Confidential", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
	UNCLASSIFIED("Unclassified", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
	
	private final String originalName;
	private final URI uri;
	
	private LevelType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static LevelType valueOf(PropertyExpression propertyExpression) {
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
