package org.osate.propertiescodegen

import org.eclipse.xtend.lib.annotations.Accessors
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.ClassifierType
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.ListType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.Property
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.ReferenceType
import org.osate.aadl2.UnitsType

import static org.osate.propertiescodegen.PropertiesCodeGen.getPackageName

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.propertiescodegen.PropertiesCodeGen.toCamelCase

package abstract class AbstractPropertyGenerator {
	val protected String packageName
	@Accessors
	val ImportCollector imports
	
	new(String packageName, ImportCollector imports) {
		this.packageName = packageName
		this.imports = imports
	}
	
	new(String packageName) {
		this(packageName, new ImportCollector)
	}
	
	def String generate()
	
	def protected String getBaseOptionalType(PropertyType type) {
		switch type {
			AadlInteger case type.unitsType === null: {
				imports.add("java.util.OptionalLong")
				"OptionalLong"
			}
			AadlReal case type.unitsType === null: {
				imports.add("java.util.OptionalDouble")
				"OptionalDouble"
			}
			default: {
				imports.add("java.util.Optional")
				"Optional"
			}
		}
	}
	
	def protected String getGenericOptionalType(PropertyType type) {
		switch type {
			AadlInteger case type.unitsType === null: {
				imports.add("java.util.OptionalLong")
				"OptionalLong"
			}
			AadlReal case type.unitsType === null: {
				imports.add("java.util.OptionalDouble")
				"OptionalDouble"
			}
			default: {
				imports.add("java.util.Optional")
				'''Optional<«getJavaName(type)»>'''
			}
		}
	}
	
	def protected String getJavaName(PropertyType type) {
		switch type {
			ListType: {
				imports.add("java.util.List")
				'''List<«getJavaName(type.elementType)»>'''
			}
			AadlBoolean: "Boolean"
			AadlString: "String"
			ClassifierType: {
				imports.add("org.osate.aadl2.Classifier")
				"Classifier"
			}
			AadlInteger case type.unitsType === null: "Long"
			AadlInteger: {
				imports.add("org.osate.pluginsupport.properties.IntegerWithUnits")
				'''IntegerWithUnits<«getUnitsJavaName(type.unitsType)»>'''
			}
			AadlReal case type.unitsType === null: "Double"
			AadlReal: {
				imports.add("org.osate.pluginsupport.properties.RealWithUnits")
				'''RealWithUnits<«getUnitsJavaName(type.unitsType)»>'''
			}
			RangeType: {
				switch numberType : type.numberType {
					AadlInteger case numberType.unitsType === null: {
						imports.add("org.osate.pluginsupport.properties.IntegerRange")
						"IntegerRange"
					}
					AadlInteger: {
						imports.add("org.osate.pluginsupport.properties.IntegerRangeWithUnits")
						'''IntegerRangeWithUnits<«getUnitsJavaName(numberType.unitsType)»>'''
					}
					AadlReal case numberType.unitsType === null: {
						imports.add("org.osate.pluginsupport.properties.RealRange")
						"RealRange"
					}
					AadlReal: {
						imports.add("org.osate.pluginsupport.properties.RealRangeWithUnits")
						'''RealRangeWithUnits<«getUnitsJavaName(numberType.unitsType)»>'''
					}
				}
			}
			ReferenceType: {
				imports.add("org.osate.aadl2.instance.InstanceObject")
				"InstanceObject"
			}
			case type.name !== null: {
				val name = type.name.toCamelCase
				val packageToImport = getPackageName(type.getContainerOfType(PropertySet))
				if (packageToImport != packageName) {
					imports.add(packageToImport + "." + name)
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
	
	def protected String getUnitsJavaName(UnitsType type) {
		/*
		 * Options for getting the name of a UnitsType:
		 * 1. The UnitsType could have a name.
		 * 2. The UnitsType could be in a NumberType with a name.
		 * 3. The UnitsType could be in a NumberType in a RangeType with a name.
		 * 4. The UnitsType could be indirectly in a Property which must have a name.
		 * 5. The UnitsType could be indirectly in a BasicProperty (record field) which must have a name.
		 */
		var NamedElement namedElement = type
		while (namedElement.name === null) {
			namedElement = namedElement.eContainer.getContainerOfType(NamedElement)
		}
		val name = namedElement.name.toCamelCase
		switch namedElement {
			PropertyType: {
				val packageToImport = getPackageName(namedElement.getContainerOfType(PropertySet))
				if (packageToImport != packageName) {
					imports.add(packageToImport + "." + name)
				}
				name
			}
			Property: name
			BasicProperty: name + "_FieldType"
		}
	}
	
	def protected String getValueExtractor(PropertyType type, String parameterName, int listDepth) {
		switch type {
			ListType: {
				imports.add(
					"java.util.stream.Collectors",
					"org.osate.aadl2.ListValue",
					"org.osate.aadl2.PropertyExpression",
					"org.osate.pluginsupport.properties.CodeGenUtil"
				)
				val nextParameterName = "element" + listDepth
				val resolvedName = "resolved" + listDepth
				'''
					((ListValue) «parameterName»).getOwnedListElements().stream().map(«nextParameterName» -> {
						PropertyExpression «resolvedName» = CodeGenUtil.resolveNamedValue(«nextParameterName», lookupContext, mode);
						return «getValueExtractor(type.elementType, resolvedName, listDepth + 1)»;
					}).collect(Collectors.toList())'''
			}
			AadlBoolean: {
				imports.add("org.osate.aadl2.BooleanLiteral")
				'''((BooleanLiteral) «parameterName»).getValue()'''
			}
			AadlString: {
				imports.add("org.osate.aadl2.StringLiteral")
				'''((StringLiteral) «parameterName»).getValue()'''
			}
			ClassifierType: {
				imports.add("org.osate.aadl2.ClassifierValue")
				'''((ClassifierValue) «parameterName»).getClassifier()'''
			}
			EnumerationType: '''«getJavaName(type)».valueOf(«parameterName»)'''
			AadlInteger case type.unitsType === null: {
				imports.add("org.osate.aadl2.IntegerLiteral")
				'''((IntegerLiteral) «parameterName»).getValue()'''
			}
			AadlInteger: {
				imports.add("org.osate.pluginsupport.properties.IntegerWithUnits")
				'''new IntegerWithUnits<>(«parameterName», «getUnitsJavaName(type.unitsType)».class)'''
			}
			AadlReal case type.unitsType === null: {
				imports.add("org.osate.aadl2.RealLiteral")
				'''((RealLiteral) «parameterName»).getValue()'''
			}
			AadlReal: {
				imports.add("org.osate.pluginsupport.properties.RealWithUnits")
				'''new RealWithUnits<>(«parameterName», «getUnitsJavaName(type.unitsType)».class)'''
			}
			RangeType: {
				switch numberType : type.numberType {
					AadlInteger case numberType.unitsType === null: {
						imports.add("org.osate.pluginsupport.properties.IntegerRange")
						'''new IntegerRange(«parameterName», lookupContext, mode)'''
					}
					AadlInteger: {
						imports.add("org.osate.pluginsupport.properties.IntegerRangeWithUnits")
						val unitsName = getUnitsJavaName(numberType.unitsType)
						'''new IntegerRangeWithUnits<>(«parameterName», «unitsName».class, lookupContext, mode)'''
					}
					AadlReal case numberType.unitsType === null: {
						imports.add("org.osate.pluginsupport.properties.RealRange")
						'''new RealRange(«parameterName», lookupContext, mode)'''
					}
					AadlReal: {
						imports.add("org.osate.pluginsupport.properties.RealRangeWithUnits")
						val unitsName = getUnitsJavaName(numberType.unitsType)
						'''new RealRangeWithUnits<>(«parameterName», «unitsName».class, lookupContext, mode)'''
					}
				}
			}
			RecordType: '''new «getJavaName(type)»(«parameterName», lookupContext, mode)'''
			ReferenceType: {
				imports.add("org.osate.aadl2.instance.InstanceReferenceValue")
				'''((InstanceReferenceValue) «parameterName»).getReferencedInstanceObject()'''
			}
		}
	}
}