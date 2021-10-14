package org.osate.aadl2.errormodel.contrib.arpa4761;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Severityclassification implements GeneratedEnumeration {
	CATASTROPHIC("Catastrophic", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
	HAZARDOUS("Hazardous", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
	SEVEREMAJOR("SevereMajor", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
	MAJOR("Major", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3"),
	MINOR("Minor", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.0/@ownedLiteral.4"),
	NOEFFECT("NoEffect", "platform:/resource/EMV2_prop_sets/ARP4761.aadl#/0/@ownedPropertyType.0/@ownedLiteral.5");
	
	private final String originalName;
	private final URI uri;
	
	private Severityclassification(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Severityclassification valueOf(PropertyExpression propertyExpression) {
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
