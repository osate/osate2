package org.osate.aadl2.contrib.memory;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum AccessRights implements GeneratedEnumeration {
	READ_ONLY("read_only", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
	WRITE_ONLY("write_only", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
	READ_WRITE("read_write", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
	BY_METHOD("by_method", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
	
	private final String originalName;
	private final URI uri;
	
	private AccessRights(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static AccessRights valueOf(PropertyExpression propertyExpression) {
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
