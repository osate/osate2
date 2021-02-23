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
public enum Staterepresentationtype implements GeneratedEnumeration {
	STATE("State", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.1/@ownedLiteral.0"),
	STATEDELTA("StateDelta", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.1/@ownedLiteral.1");

	private final String originalName;
	private final URI uri;

	private Staterepresentationtype(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static Staterepresentationtype valueOf(PropertyExpression propertyExpression) {
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
