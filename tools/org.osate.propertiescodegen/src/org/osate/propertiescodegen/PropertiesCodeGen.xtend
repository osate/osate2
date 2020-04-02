package org.osate.propertiescodegen

import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.ClassifierType
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.ListType
import org.osate.aadl2.NumberType
import org.osate.aadl2.Property
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.ReferenceType
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

import static extension org.eclipse.emf.ecore.util.EcoreUtil.isAncestor
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType

@FinalFieldsConstructor
class PropertiesCodeGen {
	val PropertySet propertySet
	val Set<String> imports = newHashSet
	
	def static List<GeneratedJava> generateJava(PropertySet propertySet) {
		val propertySetFile = if (propertySet.ownedProperties.empty) {
			emptyList
		} else {
			#[generateFile(propertySet)]
		}
		
		val typeFiles = propertySet.eContents.map[eObject |
			switch eObject {
				EnumerationType,
				NumberType case eObject.unitsType !== null,
				RangeType,
				RecordType: generateFile(propertySet, eObject, eObject.name.toCamelCase)
				Property: {
					val baseType = eObject.propertyType.basePropertyType
					if (eObject.isAncestor(baseType)) {
						switch baseType {
							EnumerationType,
							NumberType case baseType.unitsType !== null,
							RangeType,
							RecordType: generateFile(propertySet, eObject.propertyType, eObject.name.toCamelCase)
							default: null
						}
					} else {
						null
					}
				}
				default: null
			}
		].filterNull.toList;
		
		(propertySetFile + typeFiles).toList
	}
	
	def private String generateImports() {
		val javaImports = imports.filter[it.startsWith("java.")].sort
		val orgImports = imports.filter[it.startsWith("org.")].sort
		val otherImports = imports.filter[!it.startsWith("java.") && !it.startsWith("org.")].sort
		'''
			«IF !javaImports.empty»
			
			«FOR javaImport : javaImports»
			import «javaImport»;
			«ENDFOR»
			«ENDIF»
			«IF !orgImports.empty»
			
			«FOR orgImport : orgImports»
			import «orgImport»;
			«ENDFOR»
			«ENDIF»
			«IF !otherImports.empty»
			
			«FOR otherImport : otherImports»
			import «otherImport»;
			«ENDFOR»
			«ENDIF»
		'''
	}
	
	def private static GeneratedJava generateFile(PropertySet propertySet) {
		val generator = new PropertiesCodeGen(propertySet)
		/*
		 * Place the property getters into a new ArrayList for eager evaluation. This is important so that
		 * generator.imports will be filled when calling generator.generateImports.
		 */
		val propertyGetters = new ArrayList(propertySet.ownedProperties.map[generator.generatePropertyGetter(it)])
		val className = propertySet.name.toCamelCase
		val contents = '''
			package «propertySet.name.toLowerCase»;
			«generator.generateImports»
			
			public class «className» {
				«propertyGetters.head»
				«FOR getter : propertyGetters.tail»
				
				«getter»
				«ENDFOR»
			}
		'''
		new GeneratedJava(className + ".java", contents)
	}
	
	def private String generatePropertyGetter(Property property) {
		val type = property.propertyType
		val optionalType = switch type {
			AadlInteger case type.unitsType === null: "OptionalLong"
			AadlReal case type.unitsType === null: "OptionalDouble"
			default: "Optional"
		}
		
		imports += #{
			"java.util." + optionalType,
			"org.osate.aadl2.Aadl2Package",
			"org.osate.aadl2.NamedElement",
			"org.osate.aadl2.Property",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
			"org.osate.aadl2.properties.PropertyNotPresentException"
		}
		
		'''
			public static «getOptionalType(type)» get«property.name.toCamelCase»(NamedElement namedElement) {
				String name = "«propertySet.name»::«property.name»";
				Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
				try {
					PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
					return «optionalType».of(«getValueExtractor(type, "propertyExpression", 1)»);
				} catch (PropertyNotPresentException e) {
					return «optionalType».empty();
				}
			}
		'''
	}
	
	def private String getOptionalType(PropertyType type) {
		switch type {
			AadlInteger case type.unitsType === null: {
				imports += "java.util.OptionalLong"
				"OptionalLong"
			}
			AadlReal case type.unitsType === null: {
				imports += "java.util.OptionalDouble"
				"OptionalDouble"
			}
			default: {
				imports += "java.util.Optional"
				'''Optional<«getJavaName(type)»>'''
			}
		}
	}
	
	def private String getJavaName(PropertyType type) {
		switch type {
			ListType: {
				imports += "java.util.List"
				'''List<«getJavaName(type.elementType)»>'''
			}
			AadlBoolean: "Boolean"
			AadlString: "String"
			ClassifierType: {
				imports += "org.osate.aadl2.Classifier"
				"Classifier"
			}
			AadlInteger case type.unitsType === null: "Long"
			AadlReal case type.unitsType === null: "Double"
			ReferenceType: {
				imports += "org.osate.aadl2.instance.InstanceObject"
				"InstanceObject"
			}
			case type.name !== null: {
				val name = type.name.toCamelCase
				val typePropertySet = type.getContainerOfType(PropertySet)
				if (typePropertySet != propertySet) {
					imports += typePropertySet.name.toLowerCase + "." + name
				}
				name
			}
			default: {
				switch basicProperty : type.getContainerOfType(BasicProperty) {
					Property: basicProperty.name.toCamelCase
					default: basicProperty.name.toCamelCase + "_FieldType"
				}
			}
		}
	}
	
	def private String getValueExtractor(PropertyType type, String parameterName, int listDepth) {
		switch type {
			ListType: {
				imports += #{"java.util.stream.Collectors", "org.osate.aadl2.ListValue"}
				val nextParameterName = "element" + listDepth
				'''
					((ListValue) «parameterName»).getOwnedListElements().stream().map(«nextParameterName» -> {
						return «getValueExtractor(type.elementType, nextParameterName, listDepth + 1)»;
					}).collect(Collectors.toList())'''
			}
			AadlBoolean: {
				imports += "org.osate.aadl2.BooleanLiteral"
				'''((BooleanLiteral) «parameterName»).getValue()'''
			}
			AadlString: {
				imports += "org.osate.aadl2.StringLiteral"
				'''((StringLiteral) «parameterName»).getValue()'''
			}
			ClassifierType: {
				imports += "org.osate.aadl2.ClassifierValue"
				'''((ClassifierValue) «parameterName»).getClassifier()'''
			}
			EnumerationType: '''«getJavaName(type)».valueOf(«parameterName»)'''
			AadlInteger case type.unitsType === null: {
				imports += "org.osate.aadl2.IntegerLiteral"
				'''((IntegerLiteral) «parameterName»).getValue()'''
			}
			AadlReal case type.unitsType === null: {
				imports += "org.osate.aadl2.RealLiteral"
				'''((RealLiteral) «parameterName»).getValue()'''
			}
			ReferenceType: {
				imports += "org.osate.aadl2.instance.InstanceReferenceValue"
				'''((InstanceReferenceValue) «parameterName»).getReferencedInstanceObject()'''
			}
			default: '''new «getJavaName(type)»(«parameterName»)'''
		}
	}
	
	def private static GeneratedJava generateFile(PropertySet propertySet, PropertyType propertyType, String typeName) {
		val generator = new PropertiesCodeGen(propertySet)
		val generatedJavaType = switch baseType : propertyType.basePropertyType {
			UnitsType: generator.generateUnits(typeName, baseType)
			EnumerationType: generator.generateEnumeration(typeName, baseType)
			NumberType: generator.generateNumberWithUnits(typeName, baseType, true)
			RangeType: generator.generateRange(typeName, baseType, true)
			RecordType: generator.generateRecord(typeName, baseType, true)
		}
		val contents = '''
			package «propertySet.name.toLowerCase»;
			«generator.generateImports»
			
			«generatedJavaType»
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private String generateEnumeration(String typeName, EnumerationType enumType) {
		imports += #{
			"org.osate.aadl2.AbstractNamedValue",
			"org.osate.aadl2.EnumerationLiteral",
			"org.osate.aadl2.NamedValue",
			"org.osate.aadl2.PropertyExpression"
		}
		val literals = enumType.ownedLiterals.join(",\n")['''«it.name.toUpperCase»("«it.name»")''']
		'''
			public enum «typeName» {
				«literals»;
				
				private final String originalName;
				
				private «typeName»(String originalName) {
					this.originalName = originalName;
				}
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
	}
	
	def private String generateUnits(String typeName, UnitsType unitsType) {
		imports += #{
			"org.osate.aadl2.AbstractNamedValue",
			"org.osate.aadl2.NamedValue",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.UnitLiteral"
		}
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
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(«typeName» target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
	}
	
	def private String generateNumberWithUnits(String typeName, NumberType numberType, boolean topLevel) {
		val valueType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		val unitsType = numberType.unitsType
		val unitsTypeName = if (unitsType == numberType.ownedUnitsType) {
			"Units"
		} else {
			unitsType.name.toCamelCase
		}
		
		imports += #{"java.util.Objects", "org.osate.aadl2.PropertyExpression", "org.osate.aadl2." + valueType}
		val unitsPropertySet = unitsType.getContainerOfType(PropertySet)
		if (unitsType == numberType.referencedUnitsType && unitsPropertySet != propertySet) {
			imports += unitsPropertySet.name.toLowerCase + "." + unitsTypeName.toCamelCase
		}
		
		val javaType = switch numberType {
			AadlInteger: "long"
			AadlReal: "double"
		}
		
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
				private final «javaType» value;
				private final «unitsTypeName» unit;
				
				public «typeName»(PropertyExpression propertyExpression) {
					«valueType» numberValue = («valueType») propertyExpression;
					value = numberValue.getValue();
					unit = «unitsTypeName».valueOf(numberValue.getUnit().getName().toUpperCase());
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
				
				«generateUnits("Units", unitsType)»
				«ENDIF»
			}
		'''
	}
	
	def private String generateRange(String typeName, RangeType rangeType, boolean topLevel) {
		imports += #{"java.util.Objects", "org.osate.aadl2.PropertyExpression", "org.osate.aadl2.RangeValue"}
		
		val numberType = rangeType.numberType
		val unitsType = numberType.unitsType
		
		val numberTypeName = switch numberType {
			AadlInteger case unitsType === null: "long"
			AadlReal case unitsType === null: "double"
			case rangeType.ownedNumberType: "Number"
			case rangeType.referencedNumberType: {
				val numberTypeName = numberType.name.toCamelCase
				val numberPropertySet = numberType.getContainerOfType(PropertySet)
				if (numberPropertySet != propertySet) {
					imports += numberPropertySet.name.toLowerCase + "." + numberTypeName
				}
				numberTypeName
			}
		}
		
		val optionalType = switch numberType {
			AadlInteger case unitsType === null: {
				imports += "java.util.OptionalLong"
				"OptionalLong"
			}
			AadlReal case unitsType === null: {
				imports += "java.util.OptionalDouble"
				"OptionalDouble"
			}
			default: {
				imports += "java.util.Optional"
				'''Optional<«numberTypeName»>'''
			}
		}
		
		val literalType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		if (unitsType === null) {
			imports += "org.osate.aadl2." + literalType
		}
		
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
				private final «numberTypeName» minimum;
				private final «numberTypeName» maximum;
				private final «optionalType» delta;
				
				public «typeName»(PropertyExpression propertyExpression) {
					RangeValue rangeValue = (RangeValue) propertyExpression;
					«IF unitsType === null»
					minimum = ((«literalType») rangeValue.getMinimum()).getValue();
					maximum = ((«literalType») rangeValue.getMaximum()).getValue();
					if (rangeValue.getDelta() == null) {
						delta = «optionalType».empty();
					} else {
						delta = «optionalType».of(((«literalType») rangeValue.getDelta()).getValue());
					}
					«ELSE»
					minimum = new «numberTypeName»(rangeValue.getMinimum());
					maximum = new «numberTypeName»(rangeValue.getMaximum());
					delta = Optional.ofNullable(rangeValue.getDelta()).map(«numberTypeName»::new);
					«ENDIF»
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
				
				«generateNumberWithUnits("Number", numberType, false)»
				«ENDIF»
			}
		'''
	}
	
	def private String generateRecord(String typeName, RecordType recordType, boolean topLevel) {
		imports += #{"java.util.Objects", "org.osate.aadl2.PropertyExpression", "org.osate.aadl2.RecordValue"}
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
				«FOR field : recordType.ownedFields»
				private final «getOptionalType(field.propertyType)» «field.name.toCamelCase.toFirstLower»;
				«ENDFOR»
				
				public «typeName»(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					«FOR field : recordType.ownedFields»
					this.«field.name.toCamelCase.toFirstLower» = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("«field.name»"))
							«getFieldValueExtractor(field)»
							.findAny();
					«ENDFOR»
				}
				«FOR field : recordType.ownedFields»
				
				public «getOptionalType(field.propertyType)» get«field.name.toCamelCase»() {
					return «field.name.toCamelCase.toFirstLower»;
				}
				«ENDFOR»
				
				@Override
				public int hashCode() {
					«IF recordType.ownedFields.size == 1»
					return Objects.hash(«recordType.ownedFields.head.name.toCamelCase.toFirstLower»);
					«ELSE»
					return Objects.hash(
							«recordType.ownedFields.join(",\n")[it.name.toCamelCase.toFirstLower]»
					);
					«ENDIF»
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
					«IF recordType.ownedFields.size == 1»
					«val fieldName = recordType.ownedFields.head.name.toCamelCase.toFirstLower»
					return Objects.equals(this.«fieldName», other.«fieldName»);
					«ELSE»
					«val firstFieldName = recordType.ownedFields.head.name.toCamelCase.toFirstLower»
					return Objects.equals(this.«firstFieldName», other.«firstFieldName»)
							«FOR field : recordType.ownedFields.take(recordType.ownedFields.size - 1).tail»
							«val fieldName = field.name.toCamelCase.toFirstLower»
							&& Objects.equals(this.«fieldName», other.«fieldName»)
							«ENDFOR»
							«val lastFieldName = recordType.ownedFields.last.name.toCamelCase.toFirstLower»
							&& Objects.equals(this.«lastFieldName», other.«lastFieldName»);
					«ENDIF»
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					«FOR field : recordType.ownedFields»
					this.«field.name.toCamelCase.toFirstLower».ifPresent(field -> {
						builder.append("«field.name» => «getStringPrefix(field.propertyType)»");
						builder.append(«getStringBody(field.propertyType)»);
						builder.append(«getStringPostfix(field.propertyType)»);
					});
					«ENDFOR»
					builder.append(']');
					return builder.toString();
				}
				«FOR field : recordType.ownedFields.filter[it.isAncestor(it.propertyType.basePropertyType)]»
				«val baseType = field.propertyType.basePropertyType»
				«IF baseType instanceof UnitsType»
				
				«generateUnits(field.name.toCamelCase + "_FieldType", baseType)»
				«ELSEIF baseType instanceof EnumerationType»
				
				«generateEnumeration(field.name.toCamelCase + "_FieldType", baseType)»
				«ELSEIF baseType instanceof NumberType && (baseType as NumberType).unitsType !== null»
				
				«generateNumberWithUnits(field.name.toCamelCase + "_FieldType", baseType as NumberType, false)»
				«ELSEIF baseType instanceof RangeType»
				
				«generateRange(field.name.toCamelCase + "_FieldType", baseType, false)»
				«ELSEIF baseType instanceof RecordType»
				
				«generateRecord(field.name.toCamelCase + "_FieldType", baseType, false)»
				«ENDIF»
				«ENDFOR»
			}
		'''
	}
	
	def private String getFieldValueExtractor(BasicProperty field) {
		switch propertyType : field.propertyType {
			ListType: '''
				.map(field -> {
					return «getValueExtractor(propertyType, "field.getOwnedValue()", 1)»;
				})
			'''
			AadlInteger case propertyType.unitsType === null: {
				imports += "org.osate.aadl2.IntegerLiteral"
				".mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())"
			}
			AadlReal case propertyType.unitsType === null: {
				imports += "org.osate.aadl2.RealLiteral"
				".mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())"
			}
			default: '''.map(field -> «getValueExtractor(propertyType, "field.getOwnedValue()", 0)»)'''
		}
	}
	
	def private static String getStringPrefix(PropertyType type) {
		switch type {
			AadlString: '''\"'''
			ClassifierType: "classifier ("
			ReferenceType: "reference ("
			default: ""
		}
	}
	
	def private String getStringBody(PropertyType type) {
		switch type {
			ListType: {
				imports += "java.util.stream.Collectors"
				val transform = getStringTransform(type.elementType, 1)
				'''field.stream().map(«transform»).collect(Collectors.joining(", ", "(", ")"))'''
			}
			ClassifierType: "field.getQualifiedName()"
			ReferenceType: "field.getName()"
			default: "field"
		}
	}
	
	def private String getStringTransform(PropertyType type, int listDepth) {
		switch type {
			ListType: {
				imports += "java.util.stream.Collectors"
				val transform = getStringTransform(type.elementType, listDepth + 1)
				'''
					element«listDepth» -> {
						return element«listDepth».stream().map(«transform»).collect(Collectors.joining(", ", "(", ")"));
					}'''
			}
			AadlString: '''
				element«listDepth» -> {
					return '\"' + element«listDepth» + '\"';
				}'''
			ClassifierType: '''
				element«listDepth» -> {
					return "classifier (" + element«listDepth».getQualifiedName() + ")";
				}'''
			ReferenceType: '''
				element«listDepth» -> {
					return "reference (" + element«listDepth».getName() + ")";
				}'''
			default: "Object::toString"
		}
	}
	
	def private static String getStringPostfix(PropertyType type) {
		switch type {
			AadlString: '''"\";"'''
			ClassifierType,
			ReferenceType: '");"'
			default: "';'"
		}
	}
	
	def private static String toCamelCase(String s) {
		s.split("_").map[it.toLowerCase.toFirstUpper].join
	}
}