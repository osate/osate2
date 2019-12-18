package org.osate.propertiescodegen

import java.util.List
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.PropertySet
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

class PropertiesCodeGen {
	def static List<GeneratedJava> generateJava(PropertySet propertySet) {
		val packageName = propertySet.name.toLowerCase
		propertySet.ownedPropertyTypes.map[type |
			switch type {
				UnitsType: generateUnits(packageName, type)
				EnumerationType: generateEnum(packageName, type)
				default: null
			}
		].filterNull.toList
	}
	
	def private static GeneratedJava generateEnum(String packageName, EnumerationType enumType) {
		val typeName = enumType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		val literals = enumType.ownedLiterals.join(",\n")[it.name.toUpperCase]
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			
			public enum «typeName» {
				«literals»;
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					if (abstractNamedValue instanceof EnumerationLiteral) {
						return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
					} else if (abstractNamedValue instanceof Property) {
						throw new IllegalArgumentException("Reference to property not supported");
					} else if (abstractNamedValue instanceof PropertyConstant) {
						throw new IllegalArgumentException("Reference to property constant not supported");
					} else {
						throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
					}
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateUnits(String packageName, UnitsType unitsType) {
		val typeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor»)''']
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			public enum «typeName» {
				«literals»;
				
				private final double factorToBase;
				
				private «typeName»(double factorToBase) {
					this.factorToBase = factorToBase;
				}
				
				public double getFactorTo(«typeName» target) {
					return factorToBase / target.factorToBase;
				}
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					if (abstractNamedValue instanceof UnitLiteral) {
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					} else if (abstractNamedValue instanceof Property) {
						throw new IllegalArgumentException("Reference to property not supported");
					} else if (abstractNamedValue instanceof PropertyConstant) {
						throw new IllegalArgumentException("Reference to property constant not supported");
					} else {
						throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
					}
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
}
