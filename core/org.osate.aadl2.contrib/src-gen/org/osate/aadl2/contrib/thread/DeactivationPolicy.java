package org.osate.aadl2.contrib.thread;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum DeactivationPolicy implements GeneratedEnumeration {
	INACTIVE("inactive", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Thread_Properties.aadl#/0/@ownedProperty.15/@ownedPropertyType/@ownedLiteral.0"),
	UNLOAD("unload", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Thread_Properties.aadl#/0/@ownedProperty.15/@ownedPropertyType/@ownedLiteral.1");
	
	private final String originalName;
	private final URI uri;
	
	private DeactivationPolicy(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static DeactivationPolicy valueOf(PropertyExpression propertyExpression) {
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
