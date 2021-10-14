package org.osate.aadl2.errormodel.contrib.milstd882;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Probabilitylabels implements GeneratedEnumeration {
	FREQUENT("Frequent", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
	PROBABLE("Probable", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
	OCCASIONAL("Occasional", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2"),
	REMOTE("Remote", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.2/@ownedLiteral.3"),
	IMPROBABLE("Improbable", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.2/@ownedLiteral.4"),
	ELIMINATED("Eliminated", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.2/@ownedLiteral.5");
	
	private final String originalName;
	private final URI uri;
	
	private Probabilitylabels(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Probabilitylabels valueOf(PropertyExpression propertyExpression) {
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
