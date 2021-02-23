package org.osate.contribution.sei.arinc653;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

/**
 * @since 1.2
 */
public enum SupportedDalType implements GeneratedEnumeration {
	LEVEL_A("LEVEL_A", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
	LEVEL_B("LEVEL_B", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
	LEVEL_C("LEVEL_C", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2"),
	LEVEL_D("LEVEL_D", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.2/@ownedLiteral.3"),
	LEVEL_E("LEVEL_E", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.2/@ownedLiteral.4");

	private final String originalName;
	private final URI uri;

	private SupportedDalType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static SupportedDalType valueOf(PropertyExpression propertyExpression) {
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
