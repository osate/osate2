package org.osate.aadl2.errormodel.contrib.emv2;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum Distributionfunction implements GeneratedEnumeration {
	FIXED("Fixed", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.0"),
	POISSON("Poisson", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.1"),
	EXPONENTIAL("Exponential", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.2"),
	NORMAL("Normal", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.3"),
	GAUSS("Gauss", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.4"),
	WEIBULL("Weibull", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.5"),
	BINOMINAL("Binominal", "platform:/resource/EMV2_prop_sets/EMV2.aadl#/0/@ownedPropertyType.1/@ownedLiteral.6");
	
	private final String originalName;
	private final URI uri;
	
	private Distributionfunction(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static Distributionfunction valueOf(PropertyExpression propertyExpression) {
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
