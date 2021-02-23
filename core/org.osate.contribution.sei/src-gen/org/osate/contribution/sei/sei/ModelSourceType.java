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
public enum ModelSourceType implements GeneratedEnumeration {
	SIMULINK("simulink", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.7/@ownedLiteral.0"),
	SCADE("scade", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.7/@ownedLiteral.1"),
	GEOMETRY_STP("geometry_stp", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.7/@ownedLiteral.2"),
	SYSML("sysml", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.7/@ownedLiteral.3");

	private final String originalName;
	private final URI uri;

	private ModelSourceType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static ModelSourceType valueOf(PropertyExpression propertyExpression) {
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
