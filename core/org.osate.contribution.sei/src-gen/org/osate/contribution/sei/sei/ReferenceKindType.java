package org.osate.contribution.sei.sei;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

/**
 * @since 1.2
 */
public enum ReferenceKindType implements GeneratedEnumeration {
	ANY("any", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.6/@ownedLiteral.0"),
	EXIST("exist", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.6/@ownedLiteral.1"),
	COMPONENT("component", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.6/@ownedLiteral.2"),
	CONNECTION("connection", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.6/@ownedLiteral.3"),
	BEHAVIOR("behavior", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.6/@ownedLiteral.4"),
	UNKNOWN("unknown", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.6/@ownedLiteral.5");

	private final String originalName;
	private final URI uri;

	private ReferenceKindType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static ReferenceKindType valueOf(PropertyExpression propertyExpression) {
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
