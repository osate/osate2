package org.osate.aadl2.contrib.communication;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum IoReferenceTime implements GeneratedEnumeration {
	DISPATCH("Dispatch", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
	START("Start", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
	COMPLETION("Completion", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2"),
	DEADLINE("Deadline", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.2/@ownedLiteral.3"),
	NOIO("NoIO", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.2/@ownedLiteral.4"),
	DYNAMIC("Dynamic", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl#/0/@ownedPropertyType.2/@ownedLiteral.5");
	
	private final String originalName;
	private final URI uri;
	
	private IoReferenceTime(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static IoReferenceTime valueOf(PropertyExpression propertyExpression) {
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
