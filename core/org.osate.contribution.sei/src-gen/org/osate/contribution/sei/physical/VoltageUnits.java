package org.osate.contribution.sei.physical;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.pluginsupport.properties.GeneratedUnits;

/**
 * @since 1.2
 */
public enum VoltageUnits implements GeneratedUnits<VoltageUnits> {
	MV(1.0, "mV", "platform:/plugin/org.osate.contribution.sei/resources/properties/Physical.aadl#/0/@ownedPropertyType.1/@ownedLiteral.0"),
	V(1000.0, "V", "platform:/plugin/org.osate.contribution.sei/resources/properties/Physical.aadl#/0/@ownedPropertyType.1/@ownedLiteral.1"),
	KV(1000000.0, "KV", "platform:/plugin/org.osate.contribution.sei/resources/properties/Physical.aadl#/0/@ownedPropertyType.1/@ownedLiteral.2");

	private final double factorToBase;
	private final String originalName;
	private final URI uri;

	private VoltageUnits(double factorToBase, String originalName, String uri) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static VoltageUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}

	@Override
	public double getFactorToBase() {
		return factorToBase;
	}

	@Override
	public double getFactorTo(VoltageUnits target) {
		return factorToBase / target.factorToBase;
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
