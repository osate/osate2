package org.osate.aadl2.errormodel.contrib.arpa4761;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Probabilitylabels implements GeneratedEnumeration {
	FREQUENT("Frequent", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.1/@ownedLiteral.0"),
	PROBABLE("Probable", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.1/@ownedLiteral.1"),
	REMOTE("Remote", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.1/@ownedLiteral.2"),
	EXTREMELYREMOTE("ExtremelyRemote", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.1/@ownedLiteral.3"),
	EXTREMELYIMPROBABLE("ExtremelyImprobable", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.1/@ownedLiteral.4");
	
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
