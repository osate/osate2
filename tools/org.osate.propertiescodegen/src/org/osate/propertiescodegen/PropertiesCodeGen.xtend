package org.osate.propertiescodegen

import java.util.List
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.ClassifierType
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.NumberType
import org.osate.aadl2.PropertySet
import org.osate.aadl2.ReferenceType
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class PropertiesCodeGen {
	def static List<GeneratedJava> generateJava(PropertySet propertySet) {
		val packageName = propertySet.name.toLowerCase
		propertySet.ownedPropertyTypes.map[type |
			val typeName = type.name.split("_").map[it.toLowerCase.toFirstUpper].join
			switch type {
				AadlBoolean: generateBoolean(packageName, typeName)
				AadlString: generateString(packageName, typeName)
				ClassifierType: generateClassifier(packageName, typeName)
				UnitsType: generateUnits(packageName, type, typeName)
				EnumerationType: generateEnum(packageName, type, typeName)
				AadlInteger: generateNumber(packageName, type, typeName, "IntegerLiteral", "long", "value == other.value")
				AadlReal: generateNumber(packageName, type, typeName, "RealLiteral", "double", "Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value)")
				ReferenceType: generateReference(packageName, typeName)
				default: null
			}
		].filterNull.toList
	}
	
	def private static GeneratedJava generateBoolean(String packageName, String typeName) {
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.PropertyExpression;
			
			public class «typeName» {
				public static boolean getValue(PropertyExpression propertyExpression) {
					return ((BooleanLiteral) propertyExpression).getValue();
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateString(String packageName, String typeName) {
		 val contents = '''
		 	package «packageName»;
		 	
		 	import org.osate.aadl2.PropertyExpression;
		 	import org.osate.aadl2.StringLiteral;
		 	
		 	public class «typeName» {
		 		public static String getValue(PropertyExpression propertyExpression) {
		 			return ((StringLiteral) propertyExpression).getValue();
		 		}
		 	}
		 '''
		 new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateClassifier(String packageName, String typeName) {
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.PropertyExpression;
			
			public class «typeName» {
				public static Classifier getValue(PropertyExpression propertyExpression) {
					return ((ClassifierValue) propertyExpression).getClassifier();
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateEnum(String packageName, EnumerationType enumType, String typeName) {
		val literals = enumType.ownedLiterals.join(",\n")['''«it.name.toUpperCase»("«it.name»")''']
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
				
				private final String originalName;
				
				private «typeName»(String originalName) {
					this.originalName = originalName;
				}
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
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
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateUnits(String packageName, UnitsType unitsType, String typeName) {
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
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
				private final String originalName;
				
				private «typeName»(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(«typeName» target) {
					return factorToBase / target.factorToBase;
				}
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
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
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateNumber(String packageName, NumberType numberType, String typeName, String valueType, String javaType, String equalityExpression) {
		val metaModelImports = #["PropertyExpression", valueType].sort
		val contents = if (numberType.ownedUnitsType !== null) {
			val literals = numberType.ownedUnitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
			'''
				package «packageName»;
				
				import java.util.Objects;
				
				«FOR metaModelImport : metaModelImports»
				import org.osate.aadl2.«metaModelImport»;
				«ENDFOR»
				
				public class «typeName» {
					private final «javaType» value;
					private final Units unit;
					
					private «typeName»(PropertyExpression propertyExpression) {
						«valueType» numberValue = («valueType») propertyExpression;
						value = numberValue.getValue();
						unit = Units.valueOf(numberValue.getUnit().getName().toUpperCase());
					}
					
					public static «typeName» getValue(PropertyExpression propertyExpression) {
						return new «typeName»(propertyExpression);
					}
					
					public «javaType» getValue() {
						return value;
					}
					
					public Units getUnit() {
						return unit;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(value, unit);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof «typeName»)) {
							return false;
						}
						«typeName» other = («typeName») obj;
						return «equalityExpression» && unit == other.unit;
					}
					
					@Override
					public String toString() {
						return value + unit.toString();
					}
					
					public enum Units {
						«literals»;
						
						private final double factorToBase;
						private final String originalName;
						
						private Units(double factorToBase, String originalName) {
							this.factorToBase = factorToBase;
							this.originalName = originalName;
						}
						
						public double getFactorToBase() {
							return factorToBase;
						}
						
						public double getFactorTo(Units target) {
							return factorToBase / target.factorToBase;
						}
						
						@Override
						public String toString() {
							return originalName;
						}
					}
				}
			'''
		} else if (numberType.referencedUnitsType !== null) {
			val unitsType = numberType.referencedUnitsType
			val unitsTypeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
			if (unitsType.eContainer == numberType.eContainer) {
				'''
					package «packageName»;
					
					import java.util.Objects;
					
					«FOR metaModelImport : metaModelImports»
					import org.osate.aadl2.«metaModelImport»;
					«ENDFOR»
					
					public class «typeName» {
						private final «javaType» value;
						private final «unitsTypeName» unit;
						
						private «typeName»(PropertyExpression propertyExpression) {
							«valueType» numberValue = («valueType») propertyExpression;
							value = numberValue.getValue();
							unit = «unitsTypeName».valueOf(numberValue.getUnit().getName().toUpperCase());
						}
						
						public static «typeName» getValue(PropertyExpression propertyExpression) {
							return new «typeName»(propertyExpression);
						}
						
						public «javaType» getValue() {
							return value;
						}
						
						public «unitsTypeName» getUnit() {
							return unit;
						}
						
						@Override
						public int hashCode() {
							return Objects.hash(value, unit);
						}
						
						@Override
						public boolean equals(Object obj) {
							if (this == obj) {
								return true;
							}
							if (!(obj instanceof «typeName»)) {
								return false;
							}
							«typeName» other = («typeName») obj;
							return «equalityExpression» && unit == other.unit;
						}
						
						@Override
						public String toString() {
							return value + unit.toString();
						}
					}
				'''
			} else {
				val unitsPackageName = unitsType.getContainerOfType(PropertySet).name.toLowerCase
				'''
					package «packageName»;
					
					import java.util.Objects;
					
					«FOR metaModelImport : metaModelImports»
					import org.osate.aadl2.«metaModelImport»;
					«ENDFOR»
					
					import «unitsPackageName».«unitsTypeName»;
					
					public class «typeName» {
						private final «javaType» value;
						private final «unitsTypeName» unit;
						
						private «typeName»(PropertyExpression propertyExpression) {
							«valueType» numberValue = («valueType») propertyExpression;
							value = numberValue.getValue();
							unit = «unitsTypeName».valueOf(numberValue.getUnit().getName().toUpperCase());
						}
						
						public static «typeName» getValue(PropertyExpression propertyExpression) {
							return new «typeName»(propertyExpression);
						}
						
						public «javaType» getValue() {
							return value;
						}
						
						public «unitsTypeName» getUnit() {
							return unit;
						}
						
						@Override
						public int hashCode() {
							return Objects.hash(value, unit);
						}
						
						@Override
						public boolean equals(Object obj) {
							if (this == obj) {
								return true;
							}
							if (!(obj instanceof «typeName»)) {
								return false;
							}
							«typeName» other = («typeName») obj;
							return «equalityExpression» && unit == other.unit;
						}
						
						@Override
						public String toString() {
							return value + unit.toString();
						}
					}
				'''
			}
		} else {
			'''
				package «packageName»;
				
				«FOR metaModelImport : metaModelImports»
				import org.osate.aadl2.«metaModelImport»;
				«ENDFOR»
				
				public class «typeName» {
					public static «javaType» getValue(PropertyExpression propertyExpression) {
						return ((«valueType») propertyExpression).getValue();
					}
				}
			'''
		}
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateReference(String packageName, String typeName) {
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			
			public class ReferenceType1 {
				public static InstanceObject getValue(PropertyExpression propertyExpression) {
					return ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject();
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
}