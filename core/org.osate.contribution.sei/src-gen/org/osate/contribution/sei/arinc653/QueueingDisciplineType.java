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
public enum QueueingDisciplineType implements GeneratedEnumeration {
	FIFO("Fifo", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.7/@ownedLiteral.0"),
	BY_PRIORITY("By_Priority", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.7/@ownedLiteral.1");

	private final String originalName;
	private final URI uri;

	private QueueingDisciplineType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static QueueingDisciplineType valueOf(PropertyExpression propertyExpression) {
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
