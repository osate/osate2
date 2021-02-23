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
public enum Ieee754Precision implements GeneratedEnumeration {
	SIMPLE("Simple", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedLiteral.0"),
	DOUBLE("Double", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedLiteral.1");

	private final String originalName;
	private final URI uri;

	private Ieee754Precision(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static Ieee754Precision valueOf(PropertyExpression propertyExpression) {
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
