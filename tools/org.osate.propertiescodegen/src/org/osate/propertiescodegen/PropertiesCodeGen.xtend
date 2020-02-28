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
import org.osate.aadl2.RangeType
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
				AadlInteger: generateNumber(packageName, type, typeName)
				AadlReal: generateNumber(packageName, type, typeName)
				RangeType: generateRange(packageName, type, typeName)
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
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			
			«generateUnitsEnum(typeName, true, unitsType.ownedLiterals.filter(UnitLiteral))»
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateNumber(String packageName, NumberType numberType, String typeName) {
		var String valueType
		var String javaType
		if (numberType instanceof AadlInteger) {
			valueType = "IntegerLiteral"
			javaType = "long"
		} else {
			valueType = "RealLiteral"
			javaType = "double"
		}
		val metaModelImports = #["PropertyExpression", valueType].sort
		val contents = if (numberType.unitsType === null) {
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
		} else {
			val unitsType = numberType.unitsType
			val unitsTypeName = if (unitsType == numberType.ownedUnitsType) {
				"Units"
			} else {
				unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
			}
			'''
				package «packageName»;
				
				import java.util.Objects;
				
				«FOR metaModelImport : metaModelImports»
				import org.osate.aadl2.«metaModelImport»;
				«ENDFOR»
				«IF unitsType == numberType.referencedUnitsType && unitsType.eContainer != numberType.eContainer»
				
				import «unitsType.getContainerOfType(PropertySet).name.toLowerCase».«unitsTypeName»;
				«ENDIF»
				
				«generateNumberClass(numberType, typeName, true)»
			'''
		}
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateRange(String packageName, RangeType rangeType, String typeName) {
		val numberType = rangeType.numberType
		val unitsType = numberType.unitsType
		
		val valueType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		
		val numberTypeName = switch numberType {
			AadlInteger case unitsType === null: "long"
			AadlReal case unitsType === null: "double"
			case rangeType.ownedNumberType: "Number"
			case rangeType.referencedNumberType: numberType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		}
		
		val optionalType = switch numberType {
			AadlInteger case unitsType === null: "OptionalLong"
			AadlReal case unitsType === null: "OptionalDouble"
			default: '''Optional<«numberTypeName»>'''
		}
		
		val optionalImport = if (unitsType === null) {
			optionalType
		} else {
			"Optional"
		}
		
		val metaModelImports = if (numberType == rangeType.referencedNumberType && unitsType !== null) {
			#["PropertyExpression", "RangeValue"]
		} else {
			#["PropertyExpression", "RangeValue", valueType].sort
		}
		
		val contents = '''
			package «packageName»;
			
			import java.util.Objects;
			import java.util.«optionalImport»;
			
			«FOR metaModelImport : metaModelImports»
			import org.osate.aadl2.«metaModelImport»;
			«ENDFOR»
			«IF unitsType !== null && numberType == rangeType.referencedNumberType && numberType.eContainer != rangeType.eContainer»
			
			import «numberType.getContainerOfType(PropertySet).name.toLowerCase».«numberTypeName»;
			«ELSEIF unitsType !== null && numberType == rangeType.ownedNumberType && unitsType == numberType.referencedUnitsType && unitsType.eContainer != rangeType.eContainer»
			
			«val unitsTypeName = unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join»
			import «unitsType.getContainerOfType(PropertySet).name.toLowerCase».«unitsTypeName»;
			«ENDIF»
			
			public class «typeName» {
				private final «numberTypeName» minimum;
				private final «numberTypeName» maximum;
				private final «optionalType» delta;
				
				private «typeName»(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					«IF unitsType === null»
					minimum = ((«valueType») rangeValue.getMinimum()).getValue();
					maximum = ((«valueType») rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = «optionalType».empty();
					} else {
						delta = «optionalType».of(((«valueType») rangeValue.getDelta()).getValue());
					}
					«ELSEIF numberType == rangeType.ownedNumberType»
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> new Number(it));
					«ELSE»
					minimum = «numberTypeName».getValue(rangeValue.getMinimum());
					maximum = «numberTypeName».getValue(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(it -> «numberTypeName».getValue(it));
					«ENDIF»
				}
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					return new «typeName»(propertyExpression);
				}
				
				public «numberTypeName» getMinimum() {
					return minimum;
				}
				
				public «numberTypeName» getMaximum() {
					return maximum;
				}
				
				public «optionalType» getDelta() {
					return delta;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(minimum, maximum, delta);
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
					«IF unitsType !== null»
					return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
							&& Objects.equals(delta, other.delta);
					«ELSEIF numberType instanceof AadlInteger»
					return minimum == other.minimum && maximum == other.maximum && Objects.equals(delta, other.delta);
					«ELSE»
					return Double.doubleToLongBits(minimum) == Double.doubleToLongBits(other.minimum)
							&& Double.doubleToLongBits(maximum) == Double.doubleToLongBits(other.maximum)
							&& Objects.equals(delta, other.delta);
					«ENDIF»
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
					delta.ifPresent(it -> builder.append(" delta " + it));
					return builder.toString();
				}
				«IF numberType == rangeType.ownedNumberType && unitsType !== null»
				
				«generateNumberClass(numberType, "Number", false)»
				«ENDIF»
			}
		'''
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
	
	def private static String generateUnitsEnum(String typeName, boolean generateGetValueMethod, Iterable<UnitLiteral> literals) {
		val literalsString = literals.sortBy[it.absoluteFactor].join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
		'''
			public enum «typeName» {
				«literalsString»;
				
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
				«IF generateGetValueMethod»
				
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
				«ENDIF»
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
	}
	
	def private static String generateNumberClass(NumberType numberType, String typeName, boolean generateGetValueMethod) {
		var String valueType
		var String javaType
		if (numberType instanceof AadlInteger) {
			valueType = "IntegerLiteral"
			javaType = "long"
		} else {
			valueType = "RealLiteral"
			javaType = "double"
		}
		val unitsType = numberType.unitsType
		val unitsTypeName = if (unitsType == numberType.ownedUnitsType) {
			"Units"
		} else {
			unitsType.name.split("_").map[it.toLowerCase.toFirstUpper].join
		}
		'''
			public«IF !generateGetValueMethod» static«ENDIF» class «typeName» {
				private final «javaType» value;
				private final «unitsTypeName» unit;
				
				private «typeName»(PropertyExpression propertyExpression) {
					«valueType» numberValue = («valueType») propertyExpression;
					value = numberValue.getValue();
					unit = «unitsTypeName».valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				«IF generateGetValueMethod»
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					return new «typeName»(propertyExpression);
				}
				«ENDIF»
				
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
					«IF numberType instanceof AadlInteger»
					return value == other.value && unit == other.unit;
					«ELSE»
					return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value) && unit == other.unit;
					«ENDIF»
				}
				
				@Override
				public String toString() {
					return value + unit.toString();
				}
				«IF unitsType == numberType.ownedUnitsType»
				
				«generateUnitsEnum("Units", false, unitsType.ownedLiterals.filter(UnitLiteral))»
				«ENDIF»
			}
		'''
	}
}