package org.osate.aadl2.contrib.deployment;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum AllowedConnectionType implements GeneratedEnumeration {
	SAMPLED_DATA_CONNECTION("Sampled_Data_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
	IMMEDIATE_DATA_CONNECTION("Immediate_Data_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
	DELAYED_DATA_CONNECTION("Delayed_Data_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.2"),
	PORT_CONNECTION("Port_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.3"),
	DATA_ACCESS_CONNECTION("Data_Access_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.4"),
	SUBPROGRAM_ACCESS_CONNECTION("Subprogram_Access_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.5");
	
	private final String originalName;
	private final URI uri;
	
	private AllowedConnectionType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static AllowedConnectionType valueOf(PropertyExpression propertyExpression) {
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
