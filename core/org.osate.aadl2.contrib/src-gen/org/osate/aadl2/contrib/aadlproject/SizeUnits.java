package org.osate.aadl2.contrib.aadlproject;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.pluginsupport.properties.GeneratedUnits;

public enum SizeUnits implements GeneratedUnits<SizeUnits> {
	BITS(1.0, "bits", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.15/@ownedLiteral.0"),
	BYTES(8.0, "Bytes", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.15/@ownedLiteral.1"),
	KBYTE(8000.0, "KByte", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.15/@ownedLiteral.2"),
	MBYTE(8000000.0, "MByte", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.15/@ownedLiteral.3"),
	GBYTE(8.0E9, "GByte", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.15/@ownedLiteral.4"),
	TBYTE(8.0E12, "TByte", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.15/@ownedLiteral.5");
	
	private final double factorToBase;
	private final String originalName;
	private final URI uri;
	
	private SizeUnits(double factorToBase, String originalName, String uri) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static SizeUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public double getFactorToBase() {
		return factorToBase;
	}
	
	@Override
	public double getFactorTo(SizeUnits target) {
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
