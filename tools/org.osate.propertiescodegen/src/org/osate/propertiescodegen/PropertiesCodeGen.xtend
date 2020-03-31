package org.osate.propertiescodegen

import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
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
	
	def private static GeneratedJava generateFile(PropertySet propertySet) {
		val generator = new PropertiesCodeGen(propertySet)
		/*
		 * Place the property getters into a new ArrayList for eager evaluation. This is important so that
		 * generator.imports will be filled when populating javaImports, orgImports, and otherImports.
		 */
		val propertyGetters = new ArrayList(propertySet.ownedProperties.map[generator.generatePropertyGetter(it)])
		val javaImports = generator.imports.filter[it.startsWith("java.")].sort
		val orgImports = generator.imports.filter[it.startsWith("org.")].sort
		val otherImports = generator.imports.filter[!it.startsWith("java.") && !it.startsWith("org.")].sort
		val className = propertySet.name.toCamelCase
		val contents = '''
			package «propertySet.name.toLowerCase»;
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
		val camelName = property.name.toCamelCase
		val optionalType = switch type {
			AadlInteger case type.unitsType === null: "OptionalLong"
			AadlReal case type.unitsType === null: "OptionalDouble"
			default: "Optional"
		}
		val otherJavaClass = if (property.referencedPropertyType !== null) {
			property.referencedPropertyType.name.toCamelCase
		} else {
			camelName
		}
		
		imports += #{
			"java.util." + optionalType,
			"org.osate.aadl2.Aadl2Package",
			"org.osate.aadl2.Property",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.instance.InstanceObject",
			"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
			"org.osate.aadl2.properties.PropertyNotPresentException"
		}
		if (type instanceof ListType) {
			imports += #{"java.util.List", "java.util.stream.Collectors", "org.osate.aadl2.ListValue"}
		}
		val baseType = type.basePropertyType
		imports += switch baseType {
			AadlBoolean: #{"org.osate.aadl2.BooleanLiteral"}
			AadlString: #{"org.osate.aadl2.StringLiteral"}
			ClassifierType: #{"org.osate.aadl2.Classifier", "org.osate.aadl2.ClassifierValue"}
			AadlInteger case baseType.unitsType === null: #{"org.osate.aadl2.IntegerLiteral"}
			AadlReal case baseType.unitsType === null: #{"org.osate.aadl2.RealLiteral"}
			ReferenceType: #{"org.osate.aadl2.instance.InstanceReferenceValue"}
			default: {
				val basePropertySet = baseType.getContainerOfType(PropertySet)
				if (propertySet != basePropertySet) {
					#{basePropertySet.name.toLowerCase + "." + baseType.name.toCamelCase}
				} else {
					emptySet
				}
			}
		}
		
		val valueExtractor = switch type {
			ListType: '''
				((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
					«getListValueExtractor(type, type.elementType, "element1", 2, camelName)»
				}).collect(Collectors.toList())'''
			AadlBoolean: "((BooleanLiteral) propertyExpression).getValue()"
			AadlString: "((StringLiteral) propertyExpression).getValue()"
			ClassifierType: "((ClassifierValue) propertyExpression).getClassifier()"
			EnumerationType: otherJavaClass + ".valueOf(propertyExpression)"
			AadlInteger case type.unitsType === null: "((IntegerLiteral) propertyExpression).getValue()"
			AadlReal case type.unitsType === null: "((RealLiteral) propertyExpression).getValue()"
			ReferenceType: "((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject()"
			default: otherJavaClass + ".getValue(propertyExpression)"
		}
		
		'''
			public static «getOptionalType(property, type, camelName)» get«camelName»(InstanceObject instanceObject) {
				String name = "«propertySet.name»::«property.name»";
				Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
				try {
					PropertyExpression propertyExpression = instanceObject.getNonModalPropertyValue(property);
					return «optionalType».of(«valueExtractor»);
				} catch (PropertyNotPresentException e) {
					return «optionalType».empty();
				}
			}
		'''
	}
	
	def private static getOptionalType(EObject topObject, PropertyType type, String ownedTypeName) {
		switch type {
			AadlInteger case type.unitsType === null: "OptionalLong"
			AadlReal case type.unitsType === null: "OptionalDouble"
			default: '''Optional<«getGenericType(topObject, type, ownedTypeName)»>'''
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
		val javaImports = generator.imports.filter[it.startsWith("java.")].sort
		val orgImports = generator.imports.filter[it.startsWith("org.")].sort
		val otherImports = generator.imports.filter[!it.startsWith("java.") && !it.startsWith("org.")].sort
		val contents = '''
			package «propertySet.name.toLowerCase»;
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
			
			«generatedJavaType»
		'''
		new GeneratedJava(typeName + ".java", contents)
	}
	
	def private static String getGenericType(EObject topObject, PropertyType type, String ownedTypeName) {
		switch type {
			ListType: '''List<«getGenericType(topObject, type.elementType, ownedTypeName)»>'''
			AadlBoolean: "Boolean"
			AadlString: "String"
			ClassifierType: "Classifier"
			AadlInteger case type.unitsType === null: "Long"
			AadlReal case type.unitsType === null: "Double"
			ReferenceType: "InstanceObject"
			case topObject.isAncestor(type): ownedTypeName
			default: type.name.toCamelCase
		}
	}
	
	def private static String getListValueExtractor(
		ListType topListType,
		PropertyType type,
		String parameterName,
		int listDepth,
		String ownedTypeName
	) {
		switch type {
			ListType: {
				val nextParameterName = "element" + listDepth
				'''
					return ((ListValue) «parameterName»).getOwnedListElements().stream().map(«nextParameterName» -> {
						«getListValueExtractor(topListType, type.elementType, nextParameterName, listDepth + 1, ownedTypeName)»
					}).collect(Collectors.toList());
				'''
			}
			AadlBoolean: '''return ((BooleanLiteral) «parameterName»).getValue();'''
			AadlString: '''return ((StringLiteral) «parameterName»).getValue();'''
			ClassifierType: '''return ((ClassifierValue) «parameterName»).getClassifier();'''
			EnumerationType case topListType.isAncestor(type): '''return «ownedTypeName».valueOf(«parameterName»);'''
			EnumerationType: '''return «type.name.toCamelCase».valueOf(«parameterName»);'''
			AadlInteger case type.unitsType === null: '''return ((IntegerLiteral) «parameterName»).getValue();'''
			AadlReal case type.unitsType === null: '''return ((RealLiteral) «parameterName»).getValue();'''
			ReferenceType: '''return ((InstanceReferenceValue) «parameterName»).getReferencedInstanceObject();'''
			case topListType.isAncestor(type) && !(topListType.eContainer instanceof Property): '''return new «ownedTypeName»(«parameterName»);'''
			case topListType.isAncestor(type): '''return «ownedTypeName».getValue(«parameterName»);'''
			default: '''return «type.name.toCamelCase».getValue(«parameterName»);'''
		}
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
		val javaType = switch numberType {
			AadlInteger: "long"
			AadlReal: "double"
		}
		val unitsType = numberType.unitsType
		val unitsTypeName = if (unitsType == numberType.ownedUnitsType) {
			"Units"
		} else {
			unitsType.name.toCamelCase
		}
		imports += #{"java.util.Objects", "org.osate.aadl2.PropertyExpression", "org.osate.aadl2." + valueType}
		val unitsPropertySet = unitsType.getContainerOfType(PropertySet)
		if (unitsType !== null && unitsType == numberType.referencedUnitsType && unitsPropertySet != propertySet) {
			imports += unitsPropertySet.name.toLowerCase + "." + unitsType.name.toCamelCase
		}
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
				private final «javaType» value;
				private final «unitsTypeName» unit;
				
				private «typeName»(PropertyExpression propertyExpression) {
					«valueType» numberValue = («valueType») propertyExpression;
					value = numberValue.getValue();
					unit = «unitsTypeName».valueOf(numberValue.getUnit().getName().toUpperCase());
				}
				«IF topLevel»
				
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
				
				«generateUnits("Units", unitsType)»
				«ENDIF»
			}
		'''
	}
	
	def private String generateRange(String typeName, RangeType rangeType, boolean topLevel) {
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
		
		imports += #{"java.util.Objects", "org.osate.aadl2.PropertyExpression", "org.osate.aadl2.RangeValue"}
		imports += if (unitsType === null) {
			#{"java.util." + optionalType, "org.osate.aadl2." + literalType}
		} else {
			#{"java.util.Optional"}
		}
		if (unitsType !== null) {
			val numberPropertySet = numberType.getContainerOfType(PropertySet)
			val unitsPropertySet = unitsType.getContainerOfType(PropertySet)
			if (numberType == rangeType.referencedNumberType && numberPropertySet != propertySet) {
				imports += numberPropertySet.name.toLowerCase + "." + numberTypeName
			} else if (numberType == rangeType.ownedNumberType && unitsType == numberType.referencedUnitsType &&
				unitsPropertySet != propertySet) {
				imports += unitsPropertySet.name.toLowerCase + "." + unitsType.name.toCamelCase
			}
		}
		
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
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
				«IF topLevel»
				
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
				
				«generateNumberWithUnits("Number", numberType, false)»
				«ENDIF»
			}
		'''
	}
	
	def private String generateRecord(String typeName, RecordType recordType, boolean topLevel) {
		imports += #{"java.util.Objects", "org.osate.aadl2.PropertyExpression", "org.osate.aadl2.RecordValue"}
		for (field : recordType.ownedFields) {
			val propertyType = field.propertyType
			val baseType = propertyType.basePropertyType
			
			imports += switch propertyType {
				AadlInteger case propertyType.unitsType === null: "java.util.OptionalLong"
				AadlReal case propertyType.unitsType === null: "java.util.OptionalDouble"
				default: "java.util.Optional"
			}
			
			if (propertyType instanceof ListType) {
				imports += #{"java.util.List", "java.util.stream.Collectors", "org.osate.aadl2.ListValue"}
			}
			
			imports += switch baseType {
				AadlBoolean: #{"org.osate.aadl2.BooleanLiteral"}
				AadlString: #{"org.osate.aadl2.StringLiteral"}
				ClassifierType: #{"org.osate.aadl2.Classifier", "org.osate.aadl2.ClassifierValue"}
				AadlInteger case baseType.unitsType === null: #{"org.osate.aadl2.IntegerLiteral"}
				AadlReal case baseType.unitsType === null: #{"org.osate.aadl2.RealLiteral"}
				ReferenceType: #{
					"org.osate.aadl2.instance.InstanceObject",
					"org.osate.aadl2.instance.InstanceReferenceValue"
				}
				default: emptySet
			}
			
			if (!field.isAncestor(baseType)) {
				val basePropertySet = baseType.getContainerOfType(PropertySet)
				if (basePropertySet != propertySet) {
					switch baseType {
						EnumerationType,
						NumberType case baseType.unitsType !== null,
						RangeType,
						RecordType: {
							imports += basePropertySet.name.toLowerCase + "." + baseType.name.toCamelCase
						}
					}
				}
			}
		}
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
				«FOR field : recordType.ownedFields»
				«val fieldType = getOptionalType(field, field.propertyType, field.name.toCamelCase + "Type")»
				private final «fieldType» «field.name.toCamelCase.toFirstLower»;
				«ENDFOR»
				
				private «typeName»(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					«FOR field : recordType.ownedFields»
					«field.name.toCamelCase.toFirstLower» = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("«field.name»"))
							«getFieldValueExtractor(field)»
							.findAny();
					«ENDFOR»
				}
				«IF topLevel»
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					return new «typeName»(propertyExpression);
				}
				«ENDIF»
				«FOR field : recordType.ownedFields»
				
				«val fieldType = getOptionalType(field, field.propertyType, field.name.toCamelCase + "Type")»
				public «fieldType» get«field.name.toCamelCase»() {
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
					return Objects.equals(«fieldName», other.«fieldName»);
					«ELSE»
					«val firstFieldName = recordType.ownedFields.head.name.toCamelCase.toFirstLower»
					return Objects.equals(«firstFieldName», other.«firstFieldName»)
							«FOR field : recordType.ownedFields.take(recordType.ownedFields.size - 1).tail»
							«val fieldName = field.name.toCamelCase.toFirstLower»
							&& Objects.equals(«fieldName», other.«fieldName»)
							«ENDFOR»
							«val lastFieldName = recordType.ownedFields.last.name.toCamelCase.toFirstLower»
							&& Objects.equals(«lastFieldName», other.«lastFieldName»);
					«ENDIF»
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					«FOR field : recordType.ownedFields»
					«field.name.toCamelCase.toFirstLower».ifPresent(field -> {
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
				
				«generateUnits(field.name.toCamelCase + "Type", baseType)»
				«ELSEIF baseType instanceof EnumerationType»
				
				«generateEnumeration(field.name.toCamelCase + "Type", baseType)»
				«ELSEIF baseType instanceof NumberType && (baseType as NumberType).unitsType !== null»
				
				«generateNumberWithUnits(field.name.toCamelCase + "Type", baseType as NumberType, false)»
				«ELSEIF baseType instanceof RangeType»
				
				«generateRange(field.name.toCamelCase + "Type", baseType, false)»
				«ELSEIF baseType instanceof RecordType»
				
				«generateRecord(field.name.toCamelCase + "Type", baseType, false)»
				«ENDIF»
				«ENDFOR»
			}
		'''
	}
	
	def private static String getFieldValueExtractor(BasicProperty field) {
		switch propertyType : field.propertyType {
			ListType: '''
				.map(field -> {
					return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
						«getListValueExtractor(propertyType, propertyType.elementType, "element1", 2, field.name.toCamelCase + "Type")»
					}).collect(Collectors.toList());
				})
			'''
			AadlBoolean: ".map(field -> ((BooleanLiteral) field.getOwnedValue()).getValue())"
			AadlString: ".map(field -> ((StringLiteral) field.getOwnedValue()).getValue())"
			ClassifierType: ".map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())"
			EnumerationType case field.ownedPropertyType !== null: '''.map(field -> «field.name.toCamelCase»Type.valueOf(field.getOwnedValue()))'''
			EnumerationType case field.referencedPropertyType !== null: '''.map(field -> «propertyType.name.toCamelCase».valueOf(field.getOwnedValue()))'''
			AadlInteger case propertyType.unitsType === null: ".mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())"
			AadlReal case propertyType.unitsType === null: ".mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())"
			ReferenceType: ".map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())"
			case field.ownedPropertyType !== null: '''.map(field -> new «field.name.toCamelCase»Type(field.getOwnedValue()))'''
			case field.referencedPropertyType !== null: '''.map(field -> «propertyType.name.toCamelCase».getValue(field.getOwnedValue()))'''
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
	
	def private static String getStringBody(PropertyType type) {
		switch type {
			ListType: {
				val transform = getStringTransform(type.elementType, 1)
				'''field.stream().map(«transform»).collect(Collectors.joining(", ", "(", ")"))'''
			}
			ClassifierType: "field.getQualifiedName()"
			ReferenceType: "field.getName()"
			default: "field"
		}
	}
	
	def private static String getStringTransform(PropertyType type, int listDepth) {
		switch type {
			ListType: {
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