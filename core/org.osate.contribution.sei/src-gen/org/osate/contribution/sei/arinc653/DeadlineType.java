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
public enum DeadlineType implements GeneratedEnumeration {
	SOFT("soft", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedProperty.17/@ownedPropertyType/@ownedLiteral.0"),
	HARD("hard", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedProperty.17/@ownedPropertyType/@ownedLiteral.1");

	private final String originalName;
	private final URI uri;

	private DeadlineType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static DeadlineType valueOf(PropertyExpression propertyExpression) {
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
