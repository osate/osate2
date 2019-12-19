package org.osate.propertiescodegen

import java.util.List
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.PropertySet
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class PropertiesCodeGen {
	def static List<GeneratedJava> generateJava(PropertySet propertySet) {
		val packageName = propertySet.name.toLowerCase
		propertySet.ownedPropertyTypes.map[type |
			switch type {
				UnitsType: generateUnits(packageName, type)
				EnumerationType: generateEnum(packageName, type)
				AadlInteger: generateInteger(packageName, type)
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
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor»)''']
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
	
	def private static GeneratedJava generateInteger(String packageName, AadlInteger integerType) {
		val typeName = integerType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		val contents = if (integerType.ownedUnitsType !== null) {
			val literals = integerType.ownedUnitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor»)''']
			'''
				package «packageName»;
				
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.PropertyExpression;
				
				public class «typeName» {
					private final long value;
					private final Units unit;
					
					public «typeName»(PropertyExpression propertyExpression) {
						IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
						value = integerLiteral.getValue();
						unit = Units.valueOf(integerLiteral.getUnit().getName().toUpperCase());
					}
					
					public long getValue() {
						return value;
					}
					
					public Units getUnit() {
						return unit;
					}
					
					public enum Units {
						«literals»;
						
						private final double factorToBase;
						
						private Units(double factorToBase) {
							this.factorToBase = factorToBase;
						}
						
						public double getFactorTo(Units target) {
							return factorToBase / target.factorToBase;
						}
					}
				}
			'''
		} else if (integerType.referencedUnitsType !== null) {
			val unitsType = integerType.referencedUnitsType
			val unitsTypeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
			if (unitsType.eContainer == integerType.eContainer) {
				'''
					package «packageName»;
					
					import org.osate.aadl2.IntegerLiteral;
					import org.osate.aadl2.PropertyExpression;
					
					public class «typeName» {
						private final long value;
						private final «unitsTypeName» unit;
						
						public «typeName»(PropertyExpression propertyExpression) {
							IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
							value = integerLiteral.getValue();
							unit = «unitsTypeName».valueOf(integerLiteral.getUnit().getName().toUpperCase());
						}
						
						public long getValue() {
							return value;
						}
						
						public «unitsTypeName» getUnit() {
							return unit;
						}
					}
				'''
			} else {
				val unitsPackageName = unitsType.getContainerOfType(PropertySet).name.toLowerCase
				'''
					package «packageName»;
					
					import org.osate.aadl2.IntegerLiteral;
					import org.osate.aadl2.PropertyExpression;
					
					import «unitsPackageName».«unitsTypeName»;
					
					public class «typeName» {
						private final long value;
						private final «unitsTypeName» unit;
						
						public «typeName»(PropertyExpression propertyExpression) {
							IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
							value = integerLiteral.getValue();
							unit = «unitsTypeName».valueOf(integerLiteral.getUnit().getName().toUpperCase());
						}
						
						public long getValue() {
							return value;
						}
						
						public «unitsTypeName» getUnit() {
							return unit;
						}
					}
				'''
			}
		} else {
			'''
				package «packageName»;
				
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.PropertyExpression;
				
				public class «typeName» {
					public static long getValue(PropertyExpression propertyExpression) {
						return ((IntegerLiteral) propertyExpression).getValue();
					}
				}
			'''
		}
		new GeneratedJava(typeName + ".java", contents)
	}
}
