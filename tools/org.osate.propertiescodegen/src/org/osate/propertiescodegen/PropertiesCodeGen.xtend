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

import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumberType
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.UnitsType

import static extension org.eclipse.emf.ecore.util.EcoreUtil.isAncestor
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType

class PropertiesCodeGen {
	//This is needed because Xtend does not have character literals.
	val static char DASH = '-'
	
	def static GeneratedPackage generateJava(PropertySet propertySet) {
		val packageName = getPackageName(propertySet)
		
		val propertySetFile = generateFile(propertySet, packageName)
		
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
				PropertyConstant: {
					switch baseType : namedElement.propertyType.basePropertyType {
						case namedElement.isAncestor(baseType): baseType
						default: null
					}
				}
				default: null
			}
			val generator = switch type {
				UnitsType: new UnitsGenerator(type, packageName, name)
				EnumerationType: new EnumerationGenerator(type, packageName, name)
				NumberType case type.ownedUnitsType !== null: new UnitsGenerator(type.unitsType, packageName, name)
				RangeType case type.ownedNumberType?.ownedUnitsType !== null: {
					new UnitsGenerator(type.numberType.unitsType, packageName, name)
				}
				RecordType: new RecordGenerator(type, packageName, name)
				default: null
			}
			if (generator !== null) {
				generateFile(packageName, name, generator)
			}
		].filterNull.toList
		
		new GeneratedPackage("src-gen/" + packageName.replace(".", "/"), (#[propertySetFile] + typeFiles).toList)
	}
	
	def private static GeneratedClass generateFile(PropertySet propertySet, String packageName) {
		val className = propertySet.name.toCamelCase
		val generator = new PropertyGettersGenerator(propertySet, packageName, className)
		/*
		 * It is important to generate the class before the imports so that the imports in the collector will be
		 * populated.
		 */
		val generatedClass = generator.generate
		val contents = '''
			package «packageName»;
			«generator.imports.generate»
			
			«generatedClass»
		'''
		new GeneratedClass(className + ".java", contents)
	}
	
	def private static GeneratedClass generateFile(
		String packageName,
		String typeName,
		AbstractPropertyGenerator generator
	) {
		/*
		 * It is important to generate the type before the imports so that the imports in the collector will be
		 * populated.
		 */
		val generatedType = generator.generate
		val contents = '''
			package «packageName»;
			«generator.imports.generate»
			
			«generatedType»
		'''
		new GeneratedClass(typeName + ".java", contents)
	}
	
	def package static String getPackageName(PropertySet propertySet) {
		var String packageName = null
		val previousNode = NodeModelUtils.getNode(propertySet).leafNodes.filter[!it.hidden].head.previousSibling
		if (previousNode !== null) {
			val commentLine = previousNode.text.trim
			val firstNonComment = (0 ..< commentLine.length).findFirst[commentLine.charAt(it) != DASH]
			if (firstNonComment !== null) {
				val trimmed = commentLine.substring(firstNonComment).trim
				if (trimmed.startsWith("@codegen-package ")) {
					packageName = trimmed.substring(17).trim
				}
			}
		}
		packageName ?: propertySet.name.toLowerCase.replace("_", "")
	}
	
	def package static String toCamelCase(String s) {
		s.split("_").map[it.toLowerCase.toFirstUpper].join
	}
}