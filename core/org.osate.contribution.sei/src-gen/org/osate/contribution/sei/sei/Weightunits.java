package org.osate.contribution.sei.sei;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.pluginsupport.properties.GeneratedUnits;

/**
 * @since 1.2
 */
public enum Weightunits implements GeneratedUnits<Weightunits> {
	KG(1.0, "kg", "platform:/plugin/org.osate.contribution.sei/resources/properties/SEI.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0");

	private final double factorToBase;
	private final String originalName;
	private final URI uri;

	private Weightunits(double factorToBase, String originalName, String uri) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static Weightunits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}

	@Override
	public double getFactorToBase() {
		return factorToBase;
	}

	@Override
	public double getFactorTo(Weightunits target) {
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
