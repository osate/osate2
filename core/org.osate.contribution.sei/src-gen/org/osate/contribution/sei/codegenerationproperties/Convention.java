package org.osate.contribution.sei.codegenerationproperties;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

/**
 * @since 1.2
 */
public enum Convention implements GeneratedEnumeration {
	AADL("AADL", "platform:/plugin/org.osate.contribution.sei/resources/properties/Code_Generation_Properties.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.0"),
	LEGACY("Legacy", "platform:/plugin/org.osate.contribution.sei/resources/properties/Code_Generation_Properties.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.1");

	private final String originalName;
	private final URI uri;

	private Convention(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static Convention valueOf(PropertyExpression propertyExpression) {
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
