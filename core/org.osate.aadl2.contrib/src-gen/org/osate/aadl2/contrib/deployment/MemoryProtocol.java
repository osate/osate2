package org.osate.aadl2.contrib.deployment;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum MemoryProtocol implements GeneratedEnumeration {
	EXECUTE_ONLY("execute_only", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedLiteral.0"),
	READ_ONLY("read_only", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedLiteral.1"),
	WRITE_ONLY("write_only", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedLiteral.2"),
	READ_WRITE("read_write", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedLiteral.3");
	
	private final String originalName;
	private final URI uri;
	
	private MemoryProtocol(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static MemoryProtocol valueOf(PropertyExpression propertyExpression) {
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
