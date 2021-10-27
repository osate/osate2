package org.osate.aadl2.contrib.communication;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum FanOutPolicy implements GeneratedEnumeration {
	BROADCAST("Broadcast", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.0"),
	ROUNDROBIN("RoundRobin", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.1"),
	SELECTIVE("Selective", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.2"),
	ONDEMAND("OnDemand", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.3");
	
	private final String originalName;
	private final URI uri;
	
	private FanOutPolicy(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static FanOutPolicy valueOf(PropertyExpression propertyExpression) {
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
