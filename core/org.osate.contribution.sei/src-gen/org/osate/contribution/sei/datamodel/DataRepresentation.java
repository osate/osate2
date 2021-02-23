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
public enum DataRepresentation implements GeneratedEnumeration {
	ARRAY("Array", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.0"),
	BOOLEAN("Boolean", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.1"),
	CHARACTER("Character", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.2"),
	ENUM("Enum", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.3"),
	FLOAT("Float", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.4"),
	FIXED("Fixed", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.5"),
	INTEGER("Integer", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.6"),
	STRING("String", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.7"),
	STRUCT("Struct", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.8"),
	UNION("Union", "platform:/plugin/org.osate.contribution.sei/resources/properties/Data_Model.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.9");

	private final String originalName;
	private final URI uri;

	private DataRepresentation(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static DataRepresentation valueOf(PropertyExpression propertyExpression) {
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
