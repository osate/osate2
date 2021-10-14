package org.osate.aadl2.errormodel.contrib.milstd882;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Severitylabels implements GeneratedEnumeration {
	CATASTROPHIC("Catastrophic", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
	CRITICAL("Critical", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
	MARGINAL("Marginal", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
	NEGLIGIBLE("Negligible", "platform:/resource/EMV2_prop_sets/MILSTD882.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
	
	private final String originalName;
	private final URI uri;
	
	private Severitylabels(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Severitylabels valueOf(PropertyExpression propertyExpression) {
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
