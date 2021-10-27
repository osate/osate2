package org.osate.aadl2.contrib.aadlproject;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum SupportedConcurrencyControlProtocols implements GeneratedEnumeration {
	NONE_SPECIFIED("None_Specified", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
	INTERRUPT_MASKING("Interrupt_Masking", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
	MAXIMUM_PRIORITY("Maximum_Priority", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2"),
	PRIORITY_INHERITANCE("Priority_Inheritance", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.3"),
	PRIORITY_CEILING("Priority_Ceiling", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.4"),
	SPIN_LOCK("Spin_Lock", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.5"),
	SEMAPHORE("Semaphore", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.6"),
	PROTECTED_ACCESS("Protected_Access", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.7");
	
	private final String originalName;
	private final URI uri;
	
	private SupportedConcurrencyControlProtocols(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static SupportedConcurrencyControlProtocols valueOf(PropertyExpression propertyExpression) {
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
