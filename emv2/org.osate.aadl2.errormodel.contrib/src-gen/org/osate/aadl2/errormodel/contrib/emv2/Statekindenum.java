package org.osate.aadl2.errormodel.contrib.emv2;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Statekindenum implements GeneratedEnumeration {
	WORKING("Working", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.3/@ownedLiteral.0"),
	NONWORKING("NonWorking", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.3/@ownedLiteral.1");
	
	private final String originalName;
	private final URI uri;
	
	private Statekindenum(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Statekindenum valueOf(PropertyExpression propertyExpression) {
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
