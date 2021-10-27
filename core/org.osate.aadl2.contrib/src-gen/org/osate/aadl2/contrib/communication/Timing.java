package org.osate.aadl2.contrib.communication;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Timing implements GeneratedEnumeration {
	SAMPLED("sampled", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedLiteral.0"),
	IMMEDIATE("immediate", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedLiteral.1"),
	DELAYED("delayed", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.7/@ownedPropertyType/@ownedLiteral.2");
	
	private final String originalName;
	private final URI uri;
	
	private Timing(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Timing valueOf(PropertyExpression propertyExpression) {
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
