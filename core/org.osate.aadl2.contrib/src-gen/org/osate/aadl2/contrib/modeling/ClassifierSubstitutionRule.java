package org.osate.aadl2.contrib.modeling;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum ClassifierSubstitutionRule implements GeneratedEnumeration {
	CLASSIFIER_MATCH("Classifier_Match", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.2/@ownedPropertyType/@ownedLiteral.0"),
	TYPE_EXTENSION("Type_Extension", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.2/@ownedPropertyType/@ownedLiteral.1"),
	SIGNATURE_MATCH("Signature_Match", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl#/0/@ownedProperty.2/@ownedPropertyType/@ownedLiteral.2");
	
	private final String originalName;
	private final URI uri;
	
	private ClassifierSubstitutionRule(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static ClassifierSubstitutionRule valueOf(PropertyExpression propertyExpression) {
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
