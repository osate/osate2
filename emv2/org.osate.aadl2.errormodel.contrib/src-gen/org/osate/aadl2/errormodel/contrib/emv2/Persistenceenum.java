package org.osate.aadl2.errormodel.contrib.emv2;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Persistenceenum implements GeneratedEnumeration {
	PERMANENT("Permanent", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.5/@ownedLiteral.0"),
	TRANSIENT("Transient", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.5/@ownedLiteral.1"),
	SINGLETON("Singleton", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.5/@ownedLiteral.2");
	
	private final String originalName;
	private final URI uri;
	
	private Persistenceenum(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Persistenceenum valueOf(PropertyExpression propertyExpression) {
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
