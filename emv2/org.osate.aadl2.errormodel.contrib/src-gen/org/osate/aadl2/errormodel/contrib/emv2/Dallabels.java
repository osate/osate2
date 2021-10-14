package org.osate.aadl2.errormodel.contrib.emv2;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Dallabels implements GeneratedEnumeration {
	A("A", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.9/@ownedLiteral.0"),
	B("B", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.9/@ownedLiteral.1"),
	C("C", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.9/@ownedLiteral.2"),
	D("D", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.9/@ownedLiteral.3"),
	E("E", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.9/@ownedLiteral.4");
	
	private final String originalName;
	private final URI uri;
	
	private Dallabels(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Dallabels valueOf(PropertyExpression propertyExpression) {
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
