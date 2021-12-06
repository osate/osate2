package org.osate.propertiescodegen

import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType

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
		'''
			public final class «className» {
				public static final String «propertySet.name.toUpperCase»__NAME = "«propertySet.name»";
				
				private «className»() {}
				«FOR getter : propertySet.ownedProperties.map[property | generateGetter(property)]»
				
				«getter»
				«ENDFOR»
				«FOR getter : propertySet.ownedPropertyConstants.map[constant | generateGetter(constant)]»
				
				«getter»
				«ENDFOR»
			}
		'''
	}
	
	def private String generateGetter(Property property) {
		val type = property.propertyType
		val baseOptionalType = getBaseOptionalType(type)
		
		imports.add(
			"java.util.Optional",
			"org.eclipse.emf.ecore.EObject",
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
		val camelName = property.name.toCamelCase
		
		'''
			// Lookup methods for «propertySet.name»::«property.name»
			
			public static final String «property.name.toUpperCase»__NAME = "«property.name»";
			
			public static boolean accepts«camelName»(NamedElement lookupContext) {
				return lookupContext.acceptsProperty(get«camelName»_Property(lookupContext));
			}
			
			public static «returnType» get«camelName»(NamedElement lookupContext) {
				return get«camelName»(lookupContext, Optional.empty());
			}
			
			public static «returnType» get«camelName»(NamedElement lookupContext, Mode mode) {
				return get«camelName»(lookupContext, Optional.of(mode));
			}
			
			public static «returnType» get«camelName»(NamedElement lookupContext, Optional<Mode> mode) {
				Property property = get«camelName»_Property(lookupContext);
				try {
					PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
					return «baseOptionalType».of(«getValueExtractor(type, "resolved", 1)»);
				} catch (PropertyNotPresentException e) {
					return «baseOptionalType».empty();
				}
			}
			
			public static Property get«camelName»_Property(EObject lookupContext) {
				String name = «propertySet.name.toUpperCase»__NAME + "::" + «property.name.toUpperCase»__NAME;
				return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
			}
			
			public static PropertyExpression get«camelName»_EObject(NamedElement lookupContext) {
				return lookupContext.getNonModalPropertyValue(get«camelName»_Property(lookupContext));
			}
		'''
	}
	
	def private String generateGetter(PropertyConstant constant) {
		imports.add(
			"org.eclipse.emf.ecore.EObject",
			"org.osate.aadl2.PropertyConstant",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.pluginsupport.properties.CodeGenUtil"
		)
		
		val camelName = constant.name.toCamelCase
		
		'''
			// Lookup methods for «propertySet.name»::«constant.name»
			
			public static final String «constant.name.toUpperCase»__NAME = "«constant.name»";
			
			public static «getPrimitiveJavaType(constant.propertyType)» get«camelName»(EObject lookupContext) {
				PropertyConstant constant = get«camelName»_PropertyConstant(lookupContext);
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				return «getConstantValueExtractor(constant.propertyType, "resolved", 1)»;
			}
			
			public static PropertyConstant get«camelName»_PropertyConstant(EObject lookupContext) {
				String name = «propertySet.name.toUpperCase»__NAME + "::" + «constant.name.toUpperCase»__NAME;
				return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
			}
		'''
	}
	
	def private String getPrimitiveJavaType(PropertyType type) {
		switch type {
			AadlBoolean: "boolean"
			AadlInteger case type.unitsType === null: "long"
			AadlReal case type.unitsType === null: "double"
			default: getJavaType(type)
		}
	}
}