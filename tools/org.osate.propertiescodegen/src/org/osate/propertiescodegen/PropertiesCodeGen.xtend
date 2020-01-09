package org.osate.propertiescodegen

import java.util.List
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.ClassifierType
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
				AadlBoolean: generateBoolean(packageName, type)
				AadlString: generateString(packageName, type)
				ClassifierType: generateClassifier(packageName, type)
				UnitsType: generateUnits(packageName, type)
				EnumerationType: generateEnum(packageName, type)
				AadlInteger: generateInteger(packageName, type)
				AadlReal: generateReal(packageName, type)
				default: null
			}
		].filterNull.toList
	}
	
	def private static GeneratedJava generateBoolean(String packageName, AadlBoolean booleanType) {
		val typeName = booleanType.name.split("_").map[it.toLowerCase.toFirstUpper].join
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
	
	def private static GeneratedJava generateString(String packageName, AadlString stringType) {
		 val typeName = stringType.name.split("_").map[it.toLowerCase.toFirstUpper].join
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
	
	def private static GeneratedJava generateClassifier(String packageName, ClassifierType classifierType) {
		val typeName = classifierType.name.split("_").map[it.toLowerCase.toFirstUpper].join
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
	
	def private static GeneratedJava generateEnum(String packageName, EnumerationType enumType) {
		val typeName = enumType.name.split("_").map[it.toLowerCase.toFirstUpper].join
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
	
	def private static GeneratedJava generateUnits(String packageName, UnitsType unitsType) {
		val typeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
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
	
	def private static GeneratedJava generateInteger(String packageName, AadlInteger integerType) {
		val typeName = integerType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		val contents = if (integerType.ownedUnitsType !== null) {
			val literals = integerType.ownedUnitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
			'''
				package «packageName»;
				
				import java.util.Objects;
				
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.PropertyExpression;
				
				public class «typeName» {
					private final long value;
					private final Units unit;
					
					private «typeName»(PropertyExpression propertyExpression) {
						IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
						value = integerLiteral.getValue();
						unit = Units.valueOf(integerLiteral.getUnit().getName().toUpperCase());
					}
					
					public static «typeName» getValue(PropertyExpression propertyExpression) {
						return new «typeName»(propertyExpression);
					}
					
					public long getValue() {
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
						return value == other.value && unit == other.unit;
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
		} else if (integerType.referencedUnitsType !== null) {
			val unitsType = integerType.referencedUnitsType
			val unitsTypeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
			if (unitsType.eContainer == integerType.eContainer) {
				'''
					package «packageName»;
					
					import java.util.Objects;
					
					import org.osate.aadl2.IntegerLiteral;
					import org.osate.aadl2.PropertyExpression;
					
					public class «typeName» {
						private final long value;
						private final «unitsTypeName» unit;
						
						private «typeName»(PropertyExpression propertyExpression) {
							IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
							value = integerLiteral.getValue();
							unit = «unitsTypeName».valueOf(integerLiteral.getUnit().getName().toUpperCase());
						}
						
						public static «typeName» getValue(PropertyExpression propertyExpression) {
							return new «typeName»(propertyExpression);
						}
						
						public long getValue() {
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
							return value == other.value && unit == other.unit;
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
					
					import org.osate.aadl2.IntegerLiteral;
					import org.osate.aadl2.PropertyExpression;
					
					import «unitsPackageName».«unitsTypeName»;
					
					public class «typeName» {
						private final long value;
						private final «unitsTypeName» unit;
						
						private «typeName»(PropertyExpression propertyExpression) {
							IntegerLiteral integerLiteral = (IntegerLiteral) propertyExpression;
							value = integerLiteral.getValue();
							unit = «unitsTypeName».valueOf(integerLiteral.getUnit().getName().toUpperCase());
						}
						
						public static «typeName» getValue(PropertyExpression propertyExpression) {
							return new «typeName»(propertyExpression);
						}
						
						public long getValue() {
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
							return value == other.value && unit == other.unit;
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
	
	def private static GeneratedJava generateReal(String packageName, AadlReal realType) {
		val typeName = realType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		val contents = if (realType.ownedUnitsType !== null) {
			val literals = realType.ownedUnitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
			'''
				package «packageName»;
				
				import java.util.Objects;
				
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				
				public class «typeName» {
					private final double value;
					private final Units unit;
					
					private «typeName»(PropertyExpression propertyExpression) {
						RealLiteral realLiteral = (RealLiteral) propertyExpression;
						value = realLiteral.getValue();
						unit = Units.valueOf(realLiteral.getUnit().getName().toUpperCase());
					}
					
					public static «typeName» getValue(PropertyExpression propertyExpression) {
						return new «typeName»(propertyExpression);
					}
					
					public double getValue() {
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
						return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
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
		} else if (realType.referencedUnitsType !== null) {
			val unitsType = realType.referencedUnitsType
			val unitsTypeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
			if (unitsType.eContainer == realType.eContainer) {
				'''
					package «packageName»;
					
					import java.util.Objects;
					
					import org.osate.aadl2.PropertyExpression;
					import org.osate.aadl2.RealLiteral;
					
					public class «typeName» {
						private final double value;
						private final «unitsTypeName» unit;
						
						private «typeName»(PropertyExpression propertyExpression) {
							RealLiteral realLiteral = (RealLiteral) propertyExpression;
							value = realLiteral.getValue();
							unit = «unitsTypeName».valueOf(realLiteral.getUnit().getName().toUpperCase());
						}
						
						public static «typeName» getValue(PropertyExpression propertyExpression) {
							return new «typeName»(propertyExpression);
						}
						
						public double getValue() {
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
							return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
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
					
					import org.osate.aadl2.PropertyExpression;
					import org.osate.aadl2.RealLiteral;
					
					import «unitsPackageName».«unitsTypeName»;
					
					public class «typeName» {
						private final double value;
						private final «unitsTypeName» unit;
						
						private «typeName»(PropertyExpression propertyExpression) {
							RealLiteral realLiteral = (RealLiteral) propertyExpression;
							value = realLiteral.getValue();
							unit = Mass.valueOf(realLiteral.getUnit().getName().toUpperCase());
						}
						
						public static «typeName» getValue(PropertyExpression propertyExpression) {
							return new «typeName»(propertyExpression);
						}
						
						public double getValue() {
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
							return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
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
				
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				
				public class «typeName» {
					public static double getValue(PropertyExpression propertyExpression) {
						return ((RealLiteral) propertyExpression).getValue();
					}
				}
			'''
		}
		new GeneratedJava(typeName + ".java", contents)
	}
}
