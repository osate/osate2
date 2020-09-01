package org.osate.aadl2.contrib.modeling;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum ClassifierMatchingRule implements GeneratedEnumeration {
	CLASSIFIER_MATCH("Classifier_Match", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedLiteral.0"),
	EQUIVALENCE("Equivalence", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedLiteral.1"),
	SUBSET("Subset", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedLiteral.2"),
	CONVERSION("Conversion", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.1/@ownedPropertyType/@ownedLiteral.3");
	
	private final String originalName;
	private final URI uri;
	
	private ClassifierMatchingRule(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static ClassifierMatchingRule valueOf(PropertyExpression propertyExpression) {
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
