package org.osate.aadl2.contrib.aadlproject;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum SupportedConnectionPatterns implements GeneratedEnumeration {
	ONE_TO_ONE("One_To_One", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.0"),
	ALL_TO_ALL("All_To_All", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.1"),
	ONE_TO_ALL("One_To_All", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.2"),
	ALL_TO_ONE("All_To_One", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.3"),
	NEXT("Next", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.4"),
	PREVIOUS("Previous", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.5"),
	CYCLIC_NEXT("Cyclic_Next", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.6"),
	CYCLIC_PREVIOUS("Cyclic_Previous", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.7"),
	ODD_TO_ODD("Odd_To_Odd", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.8"),
	EVEN_TO_EVEN("Even_To_Even", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.9"),
	NEXT_NEXT("Next_Next", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.10"),
	CYCLIC_NEXT_NEXT("Cyclic_Next_Next", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.11"),
	PREVIOUS_PREVIOUS("Previous_Previous", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.12"),
	CYCLIC_PREVIOUS_PREVIOUS("Cyclic_Previous_Previous", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.1/@ownedLiteral.13");
	
	private final String originalName;
	private final URI uri;
	
	private SupportedConnectionPatterns(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static SupportedConnectionPatterns valueOf(PropertyExpression propertyExpression) {
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
