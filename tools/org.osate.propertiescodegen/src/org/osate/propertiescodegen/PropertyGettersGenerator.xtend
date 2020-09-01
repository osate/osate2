package org.osate.propertiescodegen

import org.osate.aadl2.Property
import org.osate.aadl2.PropertySet

import static extension org.osate.propertiescodegen.PropertiesCodeGen.toCamelCase

package class PropertyGettersGenerator extends AbstractPropertyGenerator {
	val PropertySet propertySet
	val String className
	
	new(PropertySet propertySet, String packageName, String className) {
		super(packageName)
		this.propertySet = propertySet
		this.className = className
	}
	
	override String generate() {
		val propertyGetters = propertySet.ownedProperties.map[generatePropertyGetter(it)]
		'''
			public class «className» {
				public static final String «propertySet.name.toUpperCase»__NAME = "«propertySet.name»";
				«IF !propertySet.ownedProperties.empty»
				
				«FOR property : propertySet.ownedProperties»
				public static final String «property.name.toUpperCase»__NAME = "«property.name»";
				«ENDFOR»
				
				«propertyGetters.head»
				«FOR getter : propertyGetters.tail»
				
				«getter»
				«ENDFOR»
				«ENDIF»
			}
		'''
	}
	
	def private String generatePropertyGetter(Property property) {
		val type = property.propertyType
		val baseOptionalType = getBaseOptionalType(type)
		
		imports.add(
			"java.util.Optional",
			"org.osate.aadl2.Aadl2Package",
			"org.osate.aadl2.Mode",
			"org.osate.aadl2.NamedElement",
			"org.osate.aadl2.Property",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
			"org.osate.aadl2.properties.PropertyNotPresentException",
			"org.osate.pluginsupport.properties.CodeGenUtil"
		)
		
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
}