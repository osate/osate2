/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
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
			"org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException",
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
				} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
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
			"org.osate.aadl2.Aadl2Package",
			"org.osate.aadl2.PropertyConstant",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil",
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