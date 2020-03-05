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
import org.osate.aadl2.RecordType
import org.osate.aadl2.ReferenceType
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class PropertiesCodeGen {
	def static List<GeneratedJava> generateJava(PropertySet propertySet) {
		val packageName = propertySet.name.toLowerCase
		propertySet.ownedPropertyTypes.map[type |
			val typeName = type.name.toCamelCase
			switch type {
				AadlBoolean: generateBoolean(packageName, typeName)
				AadlString: generateString(packageName, typeName)
				ClassifierType: generateClassifier(packageName, typeName)
				UnitsType: generateUnits(packageName, type, typeName)
				EnumerationType: generateEnum(packageName, type, typeName)
				AadlInteger: generateNumber(packageName, type, typeName)
				AadlReal: generateNumber(packageName, type, typeName)
				RangeType: generateRange(packageName, type, typeName)
				RecordType: generateRecord(packageName, type, typeName)
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
		val contents = '''
			package «packageName»;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			
			«generateEnumerationEnum(enumType, typeName, true)»
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
			
			«generateUnitsEnum(unitsType, typeName, true)»
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateNumber(String packageName, NumberType numberType, String typeName) {
		val literalType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		val javaType = switch numberType {
			AadlInteger: "long"
			AadlReal: "double"
		}
		val metaModelImports = #["PropertyExpression", literalType].sort
		val unitsType = numberType.unitsType
		val contents = '''
			package «packageName»;
			«IF unitsType !== null»
			
			import java.util.Objects;
			«ENDIF»
			
			«FOR metaModelImport : metaModelImports»
			import org.osate.aadl2.«metaModelImport»;
			«ENDFOR»
			«IF unitsType !== null && unitsType == numberType.referencedUnitsType && unitsType.eContainer != numberType.eContainer»
			
			import «unitsType.getContainerOfType(PropertySet).name.toLowerCase».«unitsType.name.toCamelCase»;
			«ENDIF»
			
			«IF unitsType === null»
			public class «typeName» {
				public static «javaType» getValue(PropertyExpression propertyExpression) {
					return ((«literalType») propertyExpression).getValue();
				}
			}
			«ELSE»
			«generateNumberClass(numberType, typeName, true)»
			«ENDIF»
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateRange(String packageName, RangeType rangeType, String typeName) {
		val numberType = rangeType.numberType
		val unitsType = numberType.unitsType
		
		val literalType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		
		val numberTypeName = switch numberType {
			AadlInteger case unitsType === null: "long"
			AadlReal case unitsType === null: "double"
			case rangeType.ownedNumberType: "Number"
			case rangeType.referencedNumberType: numberType.name.toCamelCase
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
			#["PropertyExpression", "RangeValue", literalType].sort
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
			
			import «unitsType.getContainerOfType(PropertySet).name.toLowerCase».«unitsType.name.toCamelCase»;
			«ENDIF»
			
			«generateRangeClass(rangeType, typeName, true)»
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static GeneratedJava generateRecord(String packageName, RecordType recordType, String typeName) {
		val otherImports = recordType.ownedFields
			.map[it.referencedPropertyType]
			.filterNull
			.filter[it.eContainer != recordType.eContainer && (it instanceof EnumerationType || it instanceof NumberType && (it as NumberType).unitsType !== null || it instanceof RangeType)]
			.map[it.getContainerOfType(PropertySet).name.toLowerCase + "." + it.name.toCamelCase]
			.toSet
			.sort
		val contents = '''
			package «packageName»;
			
			import java.util.Objects;
			«IF recordType.ownedFields.map[it.propertyType].exists[!(it instanceof NumberType) || (it as NumberType).unitsType !== null]»
			import java.util.Optional;
			«ENDIF»
			«IF recordType.ownedFields.map[it.propertyType].filter(AadlReal).exists[it.unitsType === null]»
			import java.util.OptionalDouble;
			«ENDIF»
			«IF recordType.ownedFields.map[it.propertyType].filter(AadlInteger).exists[it.unitsType === null]»
			import java.util.OptionalLong;
			«ENDIF»
			
			«IF recordType.ownedFields.exists[it.ownedPropertyType instanceof EnumerationType]»
			import org.osate.aadl2.AbstractNamedValue;
			«ENDIF»
			«IF recordType.ownedFields.exists[it.propertyType instanceof AadlBoolean]»
			import org.osate.aadl2.BooleanLiteral;
			«ENDIF»
			«IF recordType.ownedFields.exists[it.propertyType instanceof ClassifierType]»
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			«ENDIF»
			«IF recordType.ownedFields.map[it.ownedPropertyType].exists[it instanceof EnumerationType && !(it instanceof UnitsType)]»
			import org.osate.aadl2.EnumerationLiteral;
			«ENDIF»
			«IF recordType.ownedFields.map[it.propertyType].filter(AadlInteger).exists[it.unitsType === null]»
			import org.osate.aadl2.IntegerLiteral;
			«ENDIF»
			«IF recordType.ownedFields.exists[it.ownedPropertyType instanceof EnumerationType]»
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			«ENDIF»
			import org.osate.aadl2.PropertyExpression;
			«IF recordType.ownedFields.exists[it.propertyType instanceof RangeType]»
			import org.osate.aadl2.RangeValue;
			«ENDIF»
			«IF recordType.ownedFields.exists[it.propertyType instanceof AadlReal]»
			import org.osate.aadl2.RealLiteral;
			«ENDIF»
			import org.osate.aadl2.RecordValue;
			«IF recordType.ownedFields.exists[it.propertyType instanceof AadlString]»
			import org.osate.aadl2.StringLiteral;
			«ENDIF»
			«IF recordType.ownedFields.exists[it.ownedPropertyType instanceof UnitsType]»
			import org.osate.aadl2.UnitLiteral;
			«ENDIF»
			«IF recordType.ownedFields.exists[it.propertyType instanceof ReferenceType]»
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			«ENDIF»
			«IF !otherImports.empty»
			
			«FOR imported : otherImports»
			import «imported»;
			«ENDFOR»
			«ENDIF»
			
			public class «typeName» {
				«FOR field : recordType.ownedFields»
				«IF field.propertyType instanceof AadlBoolean»
				private final Optional<Boolean> «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.propertyType instanceof AadlString»
				private final Optional<String> «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.propertyType instanceof ClassifierType»
				private final Optional<Classifier> «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.propertyType instanceof AadlInteger && (field.propertyType as AadlInteger).unitsType === null»
				private final OptionalLong «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.propertyType instanceof AadlReal && (field.propertyType as AadlReal).unitsType === null»
				private final OptionalDouble «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.propertyType instanceof ReferenceType»
				private final Optional<InstanceObject> «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.ownedPropertyType !== null»
				private final Optional<«field.name.toCamelCase»Type> «field.name.toCamelCase.toFirstLower»;
				«ELSEIF field.referencedPropertyType !== null»
				private final Optional<«field.referencedPropertyType.name.toCamelCase»> «field.name.toCamelCase.toFirstLower»;
				«ENDIF»
				«ENDFOR»
				
				private «typeName»(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					«FOR field : recordType.ownedFields»
					«field.name.toCamelCase.toFirstLower» = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("«field.name»"))
							«IF field.propertyType instanceof AadlBoolean»
							.map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())
							«ELSEIF field.propertyType instanceof AadlString»
							.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
							«ELSEIF field.propertyType instanceof ClassifierType»
							.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
							«ELSEIF field.propertyType instanceof AadlInteger && (field.propertyType as AadlInteger).unitsType === null»
							.mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())
							«ELSEIF field.propertyType instanceof AadlReal && (field.propertyType as AadlReal).unitsType === null»
							.mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())
							«ELSEIF field.propertyType instanceof ReferenceType»
							.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
							«ELSEIF field.ownedPropertyType instanceof EnumerationType»
							.map(field -> {
								AbstractNamedValue abstractNamedValue = ((NamedValue) field.getOwnedValue()).getNamedValue();
								«IF field.ownedPropertyType instanceof UnitsType»
								if (abstractNamedValue instanceof UnitLiteral) {
									return «field.name.toCamelCase»Type.valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
								«ELSE»
								if (abstractNamedValue instanceof EnumerationLiteral) {
									return «field.name.toCamelCase»Type.valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
								«ENDIF»
								} else if (abstractNamedValue instanceof Property) {
									throw new IllegalArgumentException("Reference to property not supported");
								} else if (abstractNamedValue instanceof PropertyConstant) {
									throw new IllegalArgumentException("Reference to property constant not supported");
								} else {
									throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
								}
							})
							«ELSEIF field.ownedPropertyType !== null»
							.map(field -> new «field.name.toCamelCase»Type(field.getOwnedValue()))
							«ELSEIF field.referencedPropertyType !== null»
							.map(field -> «field.referencedPropertyType.name.toCamelCase».getValue(field.getOwnedValue()))
							«ENDIF»
							.findAny();
					«ENDFOR»
				}
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					return new «typeName»(propertyExpression);
				}
				«FOR field : recordType.ownedFields»
				
				«IF field.propertyType instanceof AadlBoolean»
				public Optional<Boolean> get«field.name.toCamelCase»() {
				«ELSEIF field.propertyType instanceof AadlString»
				public Optional<String> get«field.name.toCamelCase»() {
				«ELSEIF field.propertyType instanceof ClassifierType»
				public Optional<Classifier> get«field.name.toCamelCase»() {
				«ELSEIF field.propertyType instanceof AadlInteger && (field.propertyType as AadlInteger).unitsType === null»
				public OptionalLong get«field.name.toCamelCase»() {
				«ELSEIF field.propertyType instanceof AadlReal && (field.propertyType as AadlReal).unitsType === null»
				public OptionalDouble get«field.name.toCamelCase»() {
				«ELSEIF field.propertyType instanceof ReferenceType»
				public Optional<InstanceObject> get«field.name.toCamelCase»() {
				«ELSEIF field.ownedPropertyType !== null»
				public Optional<«field.name.toCamelCase»Type> get«field.name.toCamelCase»() {
				«ELSEIF field.referencedPropertyType !== null»
				public Optional<«field.referencedPropertyType.name.toCamelCase»> get«field.name.toCamelCase»() {
				«ENDIF»
					return «field.name.toCamelCase.toFirstLower»;
				}
				«ENDFOR»
				
				@Override
				public int hashCode() {
					return Objects.hash(
							«recordType.ownedFields.join(",\n")[it.name.toCamelCase.toFirstLower]»
					);
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
					return Objects.equals(«recordType.ownedFields.head.name.toCamelCase.toFirstLower», other.«recordType.ownedFields.head.name.toCamelCase.toFirstLower»)
							«FOR field : recordType.ownedFields.take(recordType.ownedFields.size - 1).tail»
							&& Objects.equals(«field.name.toCamelCase.toFirstLower», other.«field.name.toCamelCase.toFirstLower»)
							«ENDFOR»
							&& Objects.equals(«recordType.ownedFields.last.name.toCamelCase.toFirstLower», other.«recordType.ownedFields.last.name.toCamelCase.toFirstLower»);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					«FOR field : recordType.ownedFields»
					«field.name.toCamelCase.toFirstLower».ifPresent(field -> {
						«IF field.propertyType instanceof AadlString»
						builder.append("«field.name» => \"");
						«ELSEIF field.propertyType instanceof ClassifierType»
						builder.append("«field.name» => classifier (");
						«ELSEIF field.propertyType instanceof ReferenceType»
						builder.append("«field.name» => reference (");
						«ELSE»
						builder.append("«field.name» => ");
						«ENDIF»
						«IF field.propertyType instanceof ClassifierType»
						builder.append(field.getQualifiedName());
						«ELSEIF field.propertyType instanceof ReferenceType»
						builder.append(field.getName());
						«ELSE»
						builder.append(field);
						«ENDIF»
						«IF field.propertyType instanceof AadlString»
						builder.append("\";");
						«ELSEIF field.propertyType instanceof ClassifierType || field.propertyType instanceof ReferenceType»
						builder.append(");");
						«ELSE»
						builder.append(';');
						«ENDIF»
					});
					«ENDFOR»
					builder.append(']');
					return builder.toString();
				}
				«FOR field : recordType.ownedFields.filter[it.ownedPropertyType !== null]»
				«IF field.ownedPropertyType instanceof UnitsType»
				
				«generateUnitsEnum(field.ownedPropertyType as UnitsType, field.name.toCamelCase + "Type", false)»
				«ELSEIF field.ownedPropertyType instanceof EnumerationType»
				
				«generateEnumerationEnum(field.ownedPropertyType as EnumerationType, field.name.toCamelCase + "Type", false)»
				«ELSEIF field.ownedPropertyType instanceof NumberType && (field.ownedPropertyType as NumberType).unitsType !== null»
				
				«generateNumberClass(field.ownedPropertyType as NumberType, field.name.toCamelCase + "Type", false)»
				«ELSEIF field.ownedPropertyType instanceof RangeType»
				
				«generateRangeClass(field.ownedPropertyType as RangeType, field.name.toCamelCase + "Type", false)»
				«ENDIF»
				«ENDFOR»
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
			
			public class «typeName» {
				public static InstanceObject getValue(PropertyExpression propertyExpression) {
					return ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject();
				}
			}
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static String generateEnumerationEnum(EnumerationType enumType, String typeName, boolean generateGetValueMethod) {
		val literals = enumType.ownedLiterals.join(",\n")['''«it.name.toUpperCase»("«it.name»")''']
		'''
			public enum «typeName» {
				«literals»;
				
				private final String originalName;
				
				private «typeName»(String originalName) {
					this.originalName = originalName;
				}
				«IF generateGetValueMethod»
				
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
				«ENDIF»
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
	}
	
	def private static String generateUnitsEnum(UnitsType unitsType, String typeName, boolean generateGetValueMethod) {
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor]
		val literalsString = literals.join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
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
			unitsType.name.toCamelCase
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
				
				«generateUnitsEnum(unitsType, "Units", false)»
				«ENDIF»
			}
		'''
	}
	
	def private static String generateRangeClass(RangeType rangeType, String typeName, boolean generateGetValueMethod) {
		val numberType = rangeType.numberType
		val unitsType = numberType.unitsType
		
		val literalType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		
		val numberTypeName = switch numberType {
			AadlInteger case unitsType === null: "long"
			AadlReal case unitsType === null: "double"
			case rangeType.ownedNumberType: "Number"
			case rangeType.referencedNumberType: numberType.name.toCamelCase
		}
		
		val optionalType = switch numberType {
			AadlInteger case unitsType === null: "OptionalLong"
			AadlReal case unitsType === null: "OptionalDouble"
			default: '''Optional<«numberTypeName»>'''
		}
		
		'''
			public«IF !generateGetValueMethod» static«ENDIF» class «typeName» {
				private final «numberTypeName» minimum;
				private final «numberTypeName» maximum;
				private final «optionalType» delta;
				
				private «typeName»(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					«IF unitsType === null»
					minimum = ((«literalType») rangeValue.getMinimum()).getValue();
					maximum = ((«literalType») rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = «optionalType».empty();
					} else {
						delta = «optionalType».of(((«literalType») rangeValue.getDelta()).getValue());
					}
					«ELSEIF numberType == rangeType.ownedNumberType»
					minimum = new Number(rangeValue.getMinimum());
					maximum = new Number(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(Number::new);
					«ELSE»
					minimum = «numberTypeName».getValue(rangeValue.getMinimum());
					maximum = «numberTypeName».getValue(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(«numberTypeName»::getValue);
					«ENDIF»
				}
				«IF generateGetValueMethod»
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					return new «typeName»(propertyExpression);
				}
				«ENDIF»
				
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
	}
	
	def private static String toCamelCase(String s) {
		s.split("_").map[it.toLowerCase.toFirstUpper].join
	}
}