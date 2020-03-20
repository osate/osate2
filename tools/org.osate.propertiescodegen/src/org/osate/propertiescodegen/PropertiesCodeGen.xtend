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
				PropertyType: generateFile(propertySet, eObject, eObject.name.toCamelCase)
				Property case eObject.ownedPropertyType !== null: {
					generateFile(propertySet, eObject.propertyType, eObject.name.toCamelCase)
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
		val ownedTypeName = '''«camelName»«IF type instanceof ListType».ElementType«ENDIF»'''
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
			"org.osate.aadl2.Aadl2Package",
			"org.osate.aadl2.Property",
			"org.osate.aadl2.instance.InstanceObject",
			"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
			"org.osate.aadl2.properties.PropertyNotPresentException"
		}
		if (type instanceof ListType) {
			imports += "java.util.List"
		}
		imports += "java.util." + optionalType
		switch baseType : type.basePropertyType {
			ClassifierType: imports += "org.osate.aadl2.Classifier"
			EnumerationType,
			NumberType case baseType.unitsType !== null,
			RangeType,
			RecordType: {
				val basePropertySet = baseType.getContainerOfType(PropertySet)
				if (propertySet != basePropertySet) {
					imports += basePropertySet.name.toLowerCase + "." + baseType.name.toCamelCase
				}
			}
		}
		
		'''
			public static «getOptionalType(property, type, ownedTypeName)» get«camelName»(InstanceObject instanceObject) {
				String name = "«propertySet.name»::«property.name»";
				Property property = Aadl2GlobalScopeUtil.get(instanceObject, Aadl2Package.eINSTANCE.getProperty(), name);
				try {
					return «optionalType».of(«otherJavaClass».getValue(instanceObject.getNonModalPropertyValue(property)));
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
		val generatedJavaType = switch propertyType {
			ListType: generator.generateList(typeName, propertyType)
			AadlBoolean: generator.generateBoolean(typeName)
			AadlString: generator.generateString(typeName)
			ClassifierType: generator.generateClassifier(typeName)
			UnitsType: generator.generateUnits(typeName, propertyType, true)
			EnumerationType: generator.generateEnumeration(typeName, propertyType, true)
			NumberType case propertyType.unitsType === null: generator.generateNumber(typeName, propertyType)
			NumberType: generator.generateNumberWithUnits(typeName, propertyType, true)
			RangeType: generator.generateRange(typeName, propertyType, true)
			RecordType: generator.generateRecord(typeName, propertyType, true)
			ReferenceType: generator.generateReference(typeName)
			default: null
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
	
	def private String generateList(String typeName, ListType listType) {
		imports += #{
			"java.util.List",
			"java.util.stream.Collectors",
			"org.osate.aadl2.ListValue",
			"org.osate.aadl2.PropertyExpression"
		}
		
		val baseType = listType.basePropertyType
		imports += switch baseType {
			AadlBoolean: #{"org.osate.aadl2.BooleanLiteral"}
			AadlString: #{"org.osate.aadl2.StringLiteral"}
			ClassifierType: #{"org.osate.aadl2.Classifier", "org.osate.aadl2.ClassifierValue"}
			UnitsType case listType.isAncestor(baseType): #{
				"org.osate.aadl2.AbstractNamedValue",
				"org.osate.aadl2.NamedValue",
				"org.osate.aadl2.UnitLiteral"
			}
			EnumerationType case listType.isAncestor(baseType): #{
				"org.osate.aadl2.AbstractNamedValue",
				"org.osate.aadl2.EnumerationLiteral",
				"org.osate.aadl2.NamedValue"
			}
			AadlInteger case baseType.unitsType === null: #{"org.osate.aadl2.IntegerLiteral"}
			AadlReal case baseType.unitsType === null: #{"org.osate.aadl2.RealLiteral"}
			ReferenceType: #{
				"org.osate.aadl2.instance.InstanceObject",
				"org.osate.aadl2.instance.InstanceReferenceValue"
			}
			default: emptySet
		}
		
		val basePropertySet = baseType.getContainerOfType(PropertySet)
		if (basePropertySet != propertySet) {
			switch baseType {
				EnumerationType,
				NumberType case baseType.unitsType !== null,
				RangeType,
				RecordType: imports += basePropertySet.name.toLowerCase + "." + baseType.name.toCamelCase
			}
		}
		
		'''
			public class «typeName» {
				public static «getGenericType(listType, listType, "ElementType")» getValue(PropertyExpression propertyExpression) {
					«getListValueExtractor(listType, listType, "propertyExpression", 1, "ElementType")»
				}
				«IF listType.isAncestor(baseType)»
				«IF baseType instanceof UnitsType»
				
				«generateUnits("ElementType", baseType, false)»
				«ELSEIF baseType instanceof EnumerationType»
				
				«generateEnumeration("ElementType", baseType, false)»
				«ELSEIF baseType instanceof NumberType && (baseType as NumberType).unitsType !== null»
				
				«generateNumberWithUnits("ElementType", baseType as NumberType, false)»
				«ELSEIF baseType instanceof RangeType»
				
				«generateRange("ElementType", baseType, false)»
				«ELSEIF baseType instanceof RecordType»
				
				«generateRecord("ElementType", baseType, false)»
				«ENDIF»
				«ENDIF»
			}
		'''
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
			UnitsType case topListType.isAncestor(type): '''
				AbstractNamedValue abstractNamedValue = ((NamedValue) «parameterName»).getNamedValue();
				return «ownedTypeName».valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
			'''
			EnumerationType case topListType.isAncestor(type): '''
				AbstractNamedValue abstractNamedValue = ((NamedValue) «parameterName»).getNamedValue();
				return «ownedTypeName».valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
			'''
			AadlInteger case type.unitsType === null: '''return ((IntegerLiteral) «parameterName»).getValue();'''
			AadlReal case type.unitsType === null: '''return ((RealLiteral) «parameterName»).getValue();'''
			ReferenceType: '''return ((InstanceReferenceValue) «parameterName»).getReferencedInstanceObject();'''
			case topListType.isAncestor(type): '''return new «ownedTypeName»(«parameterName»);'''
			default: '''return «type.name.toCamelCase».getValue(«parameterName»);'''
		}
	}
	
	def private String generateBoolean(String typeName) {
		imports += #{"org.osate.aadl2.BooleanLiteral", "org.osate.aadl2.PropertyExpression"}
		'''
			public class «typeName» {
				public static boolean getValue(PropertyExpression propertyExpression) {
					return ((BooleanLiteral) propertyExpression).getValue();
				}
			}
		'''
	}
	
	def private String generateString(String typeName) {
		imports += #{"org.osate.aadl2.PropertyExpression", "org.osate.aadl2.StringLiteral"}
		'''
			public class «typeName» {
				public static String getValue(PropertyExpression propertyExpression) {
					return ((StringLiteral) propertyExpression).getValue();
				}
			}
		'''
	}
	
	def private String generateClassifier(String typeName) {
		imports += #{
			"org.osate.aadl2.Classifier",
			"org.osate.aadl2.ClassifierValue",
			"org.osate.aadl2.PropertyExpression"
		}
		'''
			public class «typeName» {
				public static Classifier getValue(PropertyExpression propertyExpression) {
					return ((ClassifierValue) propertyExpression).getClassifier();
				}
			}
		'''
	}
	
	def private String generateEnumeration(String typeName, EnumerationType enumType, boolean topLevel) {
		if (topLevel) {
			imports += #{
				"org.osate.aadl2.AbstractNamedValue",
				"org.osate.aadl2.EnumerationLiteral",
				"org.osate.aadl2.NamedValue",
				"org.osate.aadl2.PropertyExpression"
			}
		}
		val literals = enumType.ownedLiterals.join(",\n")['''«it.name.toUpperCase»("«it.name»")''']
		'''
			public enum «typeName» {
				«literals»;
				
				private final String originalName;
				
				private «typeName»(String originalName) {
					this.originalName = originalName;
				}
				«IF topLevel»
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				}
				«ENDIF»
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
	}
	
	def private String generateUnits(String typeName, UnitsType unitsType, boolean topLevel) {
		if (topLevel) {
			imports += #{
				"org.osate.aadl2.AbstractNamedValue",
				"org.osate.aadl2.NamedValue",
				"org.osate.aadl2.PropertyExpression",
				"org.osate.aadl2.UnitLiteral"
			}
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
				«IF topLevel»
				
				public static «typeName» getValue(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				«ENDIF»
				
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
	
	def private String generateNumber(String typeName, NumberType numberType) {
		val literalType = switch numberType {
			AadlInteger: "IntegerLiteral"
			AadlReal: "RealLiteral"
		}
		val javaType = switch numberType {
			AadlInteger: "long"
			AadlReal: "double"
		}
		imports += #{"org.osate.aadl2.PropertyExpression", "org.osate.aadl2." + literalType}
		'''
			public class «typeName» {
				public static «javaType» getValue(PropertyExpression propertyExpression) {
					return ((«literalType») propertyExpression).getValue();
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
				
				«generateUnits("Units", unitsType, false)»
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
				UnitsType case field.isAncestor(baseType): #{
					"org.osate.aadl2.AbstractNamedValue",
					"org.osate.aadl2.NamedValue",
					"org.osate.aadl2.UnitLiteral"
				}
				EnumerationType case field.isAncestor(baseType): #{
					"org.osate.aadl2.AbstractNamedValue",
					"org.osate.aadl2.NamedValue",
					"org.osate.aadl2.EnumerationLiteral"
				}
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
				
				«generateUnits(field.name.toCamelCase + "Type", baseType, false)»
				«ELSEIF baseType instanceof EnumerationType»
				
				«generateEnumeration(field.name.toCamelCase + "Type", baseType, false)»
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
			AadlInteger case propertyType.unitsType === null: ".mapToLong(field -> ((IntegerLiteral) field.getOwnedValue()).getValue())"
			AadlReal case propertyType.unitsType === null: ".mapToDouble(field -> ((RealLiteral) field.getOwnedValue()).getValue())"
			ReferenceType: ".map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())"
			UnitsType case field.ownedPropertyType !== null: '''
				.map(field -> {
					AbstractNamedValue abstractNamedValue = ((NamedValue) field.getOwnedValue()).getNamedValue();
					return «field.name.toCamelCase»Type.valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				})
			'''
			EnumerationType case field.ownedPropertyType !== null: '''
				.map(field -> {
					AbstractNamedValue abstractNamedValue = ((NamedValue) field.getOwnedValue()).getNamedValue();
					return «field.name.toCamelCase»Type.valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				})
			'''
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
	
	def private String generateReference(String typeName) {
		imports += #{
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.instance.InstanceObject",
			"org.osate.aadl2.instance.InstanceReferenceValue"
		}
		'''
			public class «typeName» {
				public static InstanceObject getValue(PropertyExpression propertyExpression) {
					return ((InstanceReferenceValue) propertyExpression).getReferencedInstanceObject();
				}
			}
		'''
	}
	
	def private static String toCamelCase(String s) {
		s.split("_").map[it.toLowerCase.toFirstUpper].join
	}
}