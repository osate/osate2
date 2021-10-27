package org.osate.aadl2.contrib.aadlproject;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.pluginsupport.properties.GeneratedUnits;

public enum DataRateUnits implements GeneratedUnits<DataRateUnits> {
	BITSPS(1.0, "bitsps", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.17/@ownedLiteral.0"),
	BYTESPS(8.0, "Bytesps", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.17/@ownedLiteral.1"),
	KBYTESPS(8000.0, "KBytesps", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.17/@ownedLiteral.2"),
	MBYTESPS(8000000.0, "MBytesps", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.17/@ownedLiteral.3"),
	GBYTESPS(8.0E9, "GBytesps", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.17/@ownedLiteral.4");
	
	private final double factorToBase;
	private final String originalName;
	private final URI uri;
	
	private DataRateUnits(double factorToBase, String originalName, String uri) {
		this.factorToBase = factorToBase;
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static DataRateUnits valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public double getFactorToBase() {
		return factorToBase;
	}
	
	@Override
	public double getFactorTo(DataRateUnits target) {
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
