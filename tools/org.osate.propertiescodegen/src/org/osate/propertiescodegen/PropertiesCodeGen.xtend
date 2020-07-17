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
import org.osate.aadl2.NamedElement
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
		
		val typeFiles = propertySet.eContents.filter(NamedElement).map[namedElement |
			val name = namedElement.name.toCamelCase
			val type = switch namedElement {
				PropertyType: namedElement
				Property: {
					switch baseType : namedElement.propertyType.basePropertyType {
						case namedElement.isAncestor(baseType): baseType
						default: null
					}
				}
				default: null
			}
			val (PropertiesCodeGen)=>String generatorMethod = switch type {
				UnitsType: [it.generateUnits(name, type)]
				EnumerationType: [it.generateEnumeration(name, type)]
				NumberType case type.ownedUnitsType !== null: [it.generateUnits(name, type.unitsType)]
				RangeType case type.ownedNumberType?.ownedUnitsType !== null: {
					[it.generateUnits(name, type.numberType.unitsType)]
				}
				RecordType: [it.generateRecord(name, type, true)]
				default: null
			}
			if (generatorMethod !== null) {
				generateFile(propertySet, name, generatorMethod)
			} else {
				null
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
			package «propertySet.name.toLowerCase.replace("_", "")»;
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
		val baseOptionalType = getBaseOptionalType(type)
		
		imports += #{
			"java.util.Optional",
			"org.osate.aadl2.Aadl2Package",
			"org.osate.aadl2.Mode",
			"org.osate.aadl2.NamedElement",
			"org.osate.aadl2.Property",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
			"org.osate.aadl2.properties.PropertyNotPresentException",
			"org.osate.pluginsupport.properties.CodeGenUtil"
		}
		
		val returnType = getGenericOptionalType(type)
		val methodName = "get" + property.name.toCamelCase
		
		'''
			public static «returnType» «methodName»(NamedElement lookupContext) {
				return «methodName»(lookupContext, Optional.empty());
			}
			
			public static «returnType» «methodName»(NamedElement lookupContext, Mode mode) {
				return «methodName»(lookupContext, Optional.of(mode));
			}
			
			public static «returnType» «methodName»(NamedElement lookupContext, Optional<Mode> mode) {
				String name = "«propertySet.name»::«property.name»";
				Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				try {
					PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
					return «baseOptionalType».of(«getValueExtractor(type, "resolved", 1)»);
				} catch (PropertyNotPresentException e) {
					return «baseOptionalType».empty();
				}
			}
			
			public static PropertyExpression «methodName»_EObject(NamedElement lookupContext) {
				String name = "«propertySet.name»::«property.name»";
				Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				return lookupContext.getNonModalPropertyValue(property);
			}
		'''
	}
	
	def private String getBaseOptionalType(PropertyType type) {
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
				"Optional"
			}
		}
	}
	
	def private String getGenericOptionalType(PropertyType type) {
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
			AadlInteger: {
				imports += "org.osate.pluginsupport.properties.IntegerWithUnits"
				'''IntegerWithUnits<«getUnitsJavaName(type.unitsType)»>'''
			}
			AadlReal case type.unitsType === null: "Double"
			AadlReal: {
				imports += "org.osate.pluginsupport.properties.RealWithUnits"
				'''RealWithUnits<«getUnitsJavaName(type.unitsType)»>'''
			}
			RangeType: {
				switch numberType : type.numberType {
					AadlInteger case numberType.unitsType === null: {
						imports += "org.osate.pluginsupport.properties.IntegerRange"
						"IntegerRange"
					}
					AadlInteger: {
						imports += "org.osate.pluginsupport.properties.IntegerRangeWithUnits"
						'''IntegerRangeWithUnits<«getUnitsJavaName(numberType.unitsType)»>'''
					}
					AadlReal case numberType.unitsType === null: {
						imports += "org.osate.pluginsupport.properties.RealRange"
						"RealRange"
					}
					AadlReal: {
						imports += "org.osate.pluginsupport.properties.RealRangeWithUnits"
						'''RealRangeWithUnits<«getUnitsJavaName(numberType.unitsType)»>'''
					}
				}
			}
			ReferenceType: {
				imports += "org.osate.aadl2.instance.InstanceObject"
				"InstanceObject"
			}
			case type.name !== null: {
				val name = type.name.toCamelCase
				val typePropertySet = type.getContainerOfType(PropertySet)
				if (typePropertySet != propertySet) {
					imports += typePropertySet.name.toLowerCase.replace("_", "") + "." + name
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
	
	def private String getUnitsJavaName(UnitsType type) {
		/*
		 * Options for getting the name of a UnitsType:
		 * 1. The UnitsType could have a name.
		 * 2. The UnitsType could be in a NumberType with a name.
		 * 3. The UnitsType could be in a NumberType in a RangeType with a name.
		 * 4. The UnitsType could be indirectly in a Property which must have a name.
		 * 5. The UnitsType could be indirectly in a BasicProperty (record field) which must have a name.
		 */
		var NamedElement namedElement = type
		while (namedElement !== null && namedElement.name === null) {
			namedElement = namedElement.eContainer.getContainerOfType(NamedElement)
		}
		switch namedElement {
			PropertyType: {
				val unitsPropertySet = namedElement.getContainerOfType(PropertySet)
				if (unitsPropertySet != propertySet) {
					imports += unitsPropertySet.name.toLowerCase.replace("_", "") + "." + namedElement.name.toCamelCase
				}
				namedElement.name.toCamelCase
			}
			Property: namedElement.name.toCamelCase
			BasicProperty: namedElement.name.toCamelCase + "_FieldType"
		}
	}
	
	def private String getValueExtractor(PropertyType type, String parameterName, int listDepth) {
		switch type {
			ListType: {
				imports += #{
					"java.util.stream.Collectors",
					"org.osate.aadl2.ListValue",
					"org.osate.aadl2.PropertyExpression",
					"org.osate.pluginsupport.properties.CodeGenUtil"
				}
				val nextParameterName = "element" + listDepth
				val resolvedName = "resolved" + listDepth
				'''
					((ListValue) «parameterName»).getOwnedListElements().stream().map(«nextParameterName» -> {
						PropertyExpression «resolvedName» = CodeGenUtil.resolveNamedValue(«nextParameterName», lookupContext, mode);
						return «getValueExtractor(type.elementType, resolvedName, listDepth + 1)»;
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
			AadlInteger: {
				imports += "org.osate.pluginsupport.properties.IntegerWithUnits"
				'''new IntegerWithUnits<>(«parameterName», «getUnitsJavaName(type.unitsType)».class)'''
			}
			AadlReal case type.unitsType === null: {
				imports += "org.osate.aadl2.RealLiteral"
				'''((RealLiteral) «parameterName»).getValue()'''
			}
			AadlReal: {
				imports += "org.osate.pluginsupport.properties.RealWithUnits"
				'''new RealWithUnits<>(«parameterName», «getUnitsJavaName(type.unitsType)».class)'''
			}
			RangeType: {
				switch numberType : type.numberType {
					AadlInteger case numberType.unitsType === null: {
						imports += "org.osate.pluginsupport.properties.IntegerRange"
						'''new IntegerRange(«parameterName», lookupContext, mode)'''
					}
					AadlInteger: {
						imports += "org.osate.pluginsupport.properties.IntegerRangeWithUnits"
						val unitsName = getUnitsJavaName(numberType.unitsType)
						'''new IntegerRangeWithUnits<>(«parameterName», «unitsName».class, lookupContext, mode)'''
					}
					AadlReal case numberType.unitsType === null: {
						imports += "org.osate.pluginsupport.properties.RealRange"
						'''new RealRange(«parameterName», lookupContext, mode)'''
					}
					AadlReal: {
						imports += "org.osate.pluginsupport.properties.RealRangeWithUnits"
						val unitsName = getUnitsJavaName(numberType.unitsType)
						'''new RealRangeWithUnits<>(«parameterName», «unitsName».class, lookupContext, mode)'''
					}
				}
			}
			RecordType: '''new «getJavaName(type)»(«parameterName», lookupContext, mode)'''
			ReferenceType: {
				imports += "org.osate.aadl2.instance.InstanceReferenceValue"
				'''((InstanceReferenceValue) «parameterName»).getReferencedInstanceObject()'''
			}
		}
	}
	
	def private static GeneratedJava generateFile(
		PropertySet propertySet,
		String typeName,
		(PropertiesCodeGen)=>String generatorMethod
	) {
		val generator = new PropertiesCodeGen(propertySet)
		val generatedJavaType = generatorMethod.apply(generator)
		val contents = '''
			package «propertySet.name.toLowerCase.replace("_", "")»;
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
			"org.osate.aadl2.UnitLiteral",
			"org.osate.pluginsupport.properties.GeneratedUnits"
		}
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor]
		val literalsString = literals.join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»")''']
		'''
			public enum «typeName» implements GeneratedUnits {
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
				
				@Override
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
	
	def private String generateRecord(String typeName, RecordType recordType, boolean topLevel) {
		imports += #{
			"java.util.Objects",
			"java.util.Optional",
			"org.osate.aadl2.Mode",
			"org.osate.aadl2.NamedElement",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.RecordValue",
			"org.osate.aadl2.properties.PropertyNotPresentException"
		}
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» {
				«FOR field : recordType.ownedFields»
				private final «getGenericOptionalType(field.propertyType)» «field.name.toCamelCase.toFirstLower»;
				«ENDFOR»
				
				public «typeName»(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					«FOR field : recordType.ownedFields»
					
					«val fieldName = field.name.toCamelCase.toFirstLower»
					«getGenericOptionalType(field.propertyType)» «fieldName»_local;
					try {
						«fieldName»_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("«field.name»"))
								«getFieldValueExtractor(field)»
								.findAny();
					} catch (PropertyNotPresentException e) {
						«fieldName»_local = «getBaseOptionalType(field.propertyType)».empty();
					}
					this.«fieldName» = «fieldName»_local;
					«ENDFOR»
				}
				«FOR field : recordType.ownedFields»
				
				public «getGenericOptionalType(field.propertyType)» get«field.name.toCamelCase»() {
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
				«FOR fieldType : recordType.ownedFields.map[generateFieldType(it)].filterNull»
				
				«fieldType»
				«ENDFOR»
			}
		'''
	}
	
	def private String getFieldValueExtractor(BasicProperty field) {
		imports += #{"org.osate.aadl2.PropertyExpression", "org.osate.pluginsupport.properties.CodeGenUtil"}
		val propertyType = field.propertyType
		val mapMethod = switch propertyType {
			AadlInteger case propertyType.unitsType === null: "mapToLong"
			AadlReal case propertyType.unitsType === null: "mapToDouble"
			default: "map"
		}
		'''
			.«mapMethod»(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return «getValueExtractor(propertyType, "resolved", 1)»;
			})
		'''
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
	
	def private String generateFieldType(BasicProperty field) {
		val baseType = field.propertyType.basePropertyType
		if (field.isAncestor(baseType)) {
			val name = field.name.toCamelCase + "_FieldType"
			switch baseType {
				UnitsType: generateUnits(name, baseType)
				EnumerationType: generateEnumeration(name, baseType)
				NumberType case baseType.ownedUnitsType !== null: generateUnits(name, baseType.unitsType)
				RangeType case baseType.ownedNumberType?.ownedUnitsType !== null: {
					generateUnits(name, baseType.numberType.unitsType)
				}
				RecordType: generateRecord(name, baseType, false)
				default: null
			}
		} else {
			null
		}
	}
	
	def private static String toCamelCase(String s) {
		s.split("_").map[it.toLowerCase.toFirstUpper].join
	}
}