package org.osate.contribution.sei.datamodel;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

/**
 * @since 1.2
 */
public enum NumberRepresentation implements GeneratedEnumeration {
	SIGNED("Signed", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedLiteral.0"),
	UNSIGNED("Unsigned", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.13/@ownedPropertyType/@ownedLiteral.1");

	private final String originalName;
	private final URI uri;

	private NumberRepresentation(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static NumberRepresentation valueOf(PropertyExpression propertyExpression) {
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
