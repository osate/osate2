/*
 * /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.properties.scoping;

import java.util.LinkedHashMap
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.Element
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.NumberType
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeType
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.UnitsType
import org.osate.aadl2.modelsupport.util.AadlUtil

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class PropertiesScopeProvider extends AbstractDeclarativeScopeProvider {
	//Adds scope with renames for all references to Classifiers.
	def scope_Classifier(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference)
		val renameScopeElements = new LinkedHashMap
		val packageSection = EcoreUtil2::getContainerOfType(context, typeof(PackageSection))
		if (packageSection != null) {
			packageSection.ownedComponentTypeRenames.forEach[
				if (name == null) {
					renameScopeElements.put(renamedComponentType, QualifiedName::create(renamedComponentType.name))
				} else {
					renameScopeElements.put(renamedComponentType, QualifiedName::create(name))
				}
			]
			packageSection.ownedFeatureGroupTypeRenames.forEach[
				if (name == null) {
					renameScopeElements.put(renamedFeatureGroupType, QualifiedName::create(renamedFeatureGroupType.name))
				} else {
					renameScopeElements.put(renamedFeatureGroupType, QualifiedName::create(name))
				}
			]
			packageSection.ownedPackageRenames.forEach[
				if (renameAll) {
					renamedPackage.publicSection.ownedClassifiers.forEach[
						renameScopeElements.put(it, QualifiedName::create(name))
					]
				} else {
					val newPackageName = name
					renamedPackage.publicSection.ownedClassifiers.forEach[
						renameScopeElements.put(it, QualifiedName::create(newPackageName, name))
					]
				}
			]
			scope = Scopes::scopeFor(renameScopeElements.keySet, [renameScopeElements.get(it)], scope)
		}
		scope
	}
	
	/*
	 * Reference is from ModalPropertyValue and OptionalModalPropertyValue in Properties.xtext
	 * and SubprogramCallSequence, InternalFeature, ProcessorFeature, and DefaultAnnexSubclause in Aadl2.xtext
	 */
	def scope_ModalElement_inMode(Element context, EReference reference) {
		var scope = IScope::NULLSCOPE
		val containingPropertyAssociation = EcoreUtil2::getContainerOfType(context, typeof(PropertyAssociation))
		if (containingPropertyAssociation != null) {
			if (!containingPropertyAssociation.appliesTos.empty) {
				val path = containingPropertyAssociation.appliesTos.get(0)
				val cpelist = path.containmentPathElements
				val cpecl = (cpelist.findLast[namedElement instanceof Subcomponent].namedElement as Subcomponent)?.classifier
				if (cpecl != null) {
					scope = Scopes::scopeFor(cpecl.allModes)
				}
			} else if (containingPropertyAssociation.owner instanceof Subcomponent) {
				val subcomponentClassifier = (containingPropertyAssociation.owner as Subcomponent).allClassifier
				if (subcomponentClassifier != null) {
					scope = Scopes::scopeFor(subcomponentClassifier.allModes)
				}
			}
		}
		if (scope == IScope::NULLSCOPE) {
			scope = Scopes::scopeFor(EcoreUtil2::getContainerOfType(context, typeof(ComponentClassifier)).allModes)
		}
		scope
	}
	
	/*
	 * Reference is from LiteralorReferenceTerm in Properties.xtext
	 */
	def scope_NamedValue_namedValue(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference)
		var PropertyType propertyType = null;
		//Inner value of a record value.
		propertyType = EcoreUtil2::getContainerOfType(context, typeof(BasicPropertyAssociation))?.property?.propertyType
		if (propertyType == null) {
			//Value of the property constant.
			propertyType = EcoreUtil2::getContainerOfType(context, typeof(PropertyConstant))?.propertyType
		}
		if (propertyType == null) {
			//Default value of a property definition.
			propertyType = EcoreUtil2::getContainerOfType(context, typeof(Property))?.propertyType
		}
		if (propertyType == null) {
			//Value of an association.
			propertyType = EcoreUtil2::getContainerOfType(context, typeof(PropertyAssociation))?.property?.propertyType
		}
		propertyType = AadlUtil::getBasePropertyType(propertyType)
		switch (propertyType) {
			EnumerationType:
				scope = Scopes::scopeFor(propertyType.ownedLiterals, scope)
		}
		scope
	}
	
//	override getScope(EObject context, EReference reference) {
//		println('''
//		other scope
//			«context»
//			«reference»
//		''')
//		super.getScope(context, reference)
//	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(NumberType context, EReference reference) {
		//Lower bound or upper bound values of a number property type.
		val unitsType = context.unitsType
		if (unitsType != null) {
			Scopes::scopeFor(unitsType.ownedLiterals)
		} else {
			IScope::NULLSCOPE
		}
	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(PropertyConstant context, EReference reference) {
		//Value of the property constant.
		createUnitLiteralsScopeFromPropertyType(context.propertyType)
	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(Property context, EReference reference) {
		//Default value of a property definition.
		createUnitLiteralsScopeFromPropertyType(context.propertyType)
	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(PropertyAssociation context, EReference reference) {
		//Value of an association.
		createUnitLiteralsScopeFromPropertyType(context.property.propertyType)
	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(BasicPropertyAssociation context, EReference reference) {
		//Inner value of a record value.
		createUnitLiteralsScopeFromPropertyType(context.property.propertyType)
	}
	
	def private createUnitLiteralsScopeFromPropertyType(PropertyType type) {
		val baseType = AadlUtil::getBasePropertyType(type)
		var UnitsType unitsType = null
		switch baseType {
			NumberType:
				unitsType = baseType.unitsType
			RangeType:
				unitsType = baseType.numberType.unitsType
		}
		if (unitsType != null) {
			Scopes::scopeFor(unitsType.ownedLiterals)
		} else {
			IScope::NULLSCOPE
		}
	}
}