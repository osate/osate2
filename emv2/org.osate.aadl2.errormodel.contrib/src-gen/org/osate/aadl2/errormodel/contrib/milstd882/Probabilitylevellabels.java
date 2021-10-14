package org.osate.aadl2.errormodel.contrib.milstd882;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Probabilitylevellabels implements GeneratedEnumeration {
	A("A", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.3/@ownedLiteral.0"),
	B("B", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.3/@ownedLiteral.1"),
	C("C", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.3/@ownedLiteral.2"),
	D("D", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.3/@ownedLiteral.3"),
	E("E", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.3/@ownedLiteral.4"),
	F("F", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.3/@ownedLiteral.5");
	
	private final String originalName;
	private final URI uri;
	
	private Probabilitylevellabels(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Probabilitylevellabels valueOf(PropertyExpression propertyExpression) {
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
