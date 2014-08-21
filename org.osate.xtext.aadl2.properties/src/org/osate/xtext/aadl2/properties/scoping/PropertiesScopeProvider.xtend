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

import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.osate.aadl2.Aadl2Package
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
import org.osate.aadl2.RecordType
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.UnitsType

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.eclipse.xtext.scoping.Scopes.scopeFor
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType

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
		val renameScopeElements = newArrayList()
		val packageSection = context.getContainerOfType(typeof(PackageSection))
		if (packageSection != null) {
			packageSection.ownedComponentTypeRenames.filter[reference.EReferenceType.isSuperTypeOf(renamedComponentType.eClass)].forEach[
				renameScopeElements.add(new EObjectDescription(QualifiedName::create(name ?: renamedComponentType.name), renamedComponentType, null))
			]
			if (reference.EReferenceType.isSuperTypeOf(Aadl2Package::eINSTANCE.featureGroupType)) {
				packageSection.ownedFeatureGroupTypeRenames.forEach[
					renameScopeElements.add(new EObjectDescription(QualifiedName::create(name ?: renamedFeatureGroupType.name), renamedFeatureGroupType, null))
				]
			}
			packageSection.ownedPackageRenames.forEach[packageRename|
				packageRename.renamedPackage.publicSection.ownedClassifiers.filter[reference.EReferenceType.isSuperTypeOf(eClass)].forEach[classifier|
					renameScopeElements.add(new EObjectDescription(QualifiedName::create(if (packageRename.renameAll) #[classifier.name] else #[packageRename.name, classifier.name]), classifier, null))
				]
			]
			scope = new SimpleScope(scope, renameScopeElements)
		}
		scope
	}
	
	/*
	 * Reference is from ModalPropertyValue and OptionalModalPropertyValue in Properties.xtext
	 * and SubprogramCallSequence, InternalFeature, ProcessorFeature, and DefaultAnnexSubclause in Aadl2.xtext
	 */
	def scope_ModalElement_inMode(Element context, EReference reference) {
		var scope = IScope::NULLSCOPE
		val containingPropertyAssociation = context.getContainerOfType(typeof(PropertyAssociation))
		if (containingPropertyAssociation != null) {
			if (!containingPropertyAssociation.appliesTos.empty) {
				scope = (containingPropertyAssociation.appliesTos.get(0).containmentPathElements.findLast[namedElement instanceof Subcomponent].namedElement as Subcomponent)?.
						classifier?.allModes.scopeFor ?: scope
			} else if (containingPropertyAssociation.owner instanceof Subcomponent) {
				scope = (containingPropertyAssociation.owner as Subcomponent).allClassifier?.allModes.scopeFor ?: scope
			}
		}
		if (scope == IScope::NULLSCOPE) {
			scope = context.getContainerOfType(typeof(ComponentClassifier)).allModes.scopeFor
		}
		scope
	}
	
	//Reference is from LiteralorReferenceTerm in Properties.xtext
	def scope_NamedValue_namedValue(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference)
		var PropertyType propertyType = null;
		//Inner value of a record value.
		propertyType = context.getContainerOfType(typeof(BasicPropertyAssociation))?.property?.propertyType
		if (propertyType == null) {
			//Value of the property constant.
			propertyType = context.getContainerOfType(typeof(PropertyConstant))?.propertyType
		}
		if (propertyType == null) {
			//Default value of a property definition.
			propertyType = context.getContainerOfType(typeof(Property))?.propertyType
		}
		if (propertyType == null) {
			//Value of an association.
			propertyType = context.getContainerOfType(typeof(PropertyAssociation))?.property?.propertyType
		}
		propertyType = propertyType.basePropertyType
		switch (propertyType) {
			EnumerationType:
				scope = propertyType.ownedLiterals.scopeFor(scope)
		}
		scope
	}
	
	//Reference is from FieldPropertyAssociation in Properties.xtext
	def scope_BasicPropertyAssociation_property(Element context, EReference reference) {
		var parent = switch context {
			BasicPropertyAssociation case context.property.propertyType == null:
				context.owner
			default:
				context
		}
		while (parent != null && !(parent instanceof BasicPropertyAssociation || parent instanceof PropertyAssociation || parent instanceof Property || parent instanceof PropertyConstant)) {
			parent = parent.owner
		}
		var PropertyType propertyType = null
		switch parent {
			BasicPropertyAssociation:
				propertyType = parent.property?.propertyType
			PropertyAssociation:
				propertyType = parent.property?.propertyType
			Property:
				propertyType = parent.propertyType
			PropertyConstant:
				propertyType = parent.propertyType
		}
		propertyType = propertyType.basePropertyType
		switch (propertyType) {
			RecordType:
				return propertyType.ownedFields.scopeFor
		}
		IScope::NULLSCOPE
	}
	
	//Reference is from ContainmentPathElement and QualifiedContainmentPathElement in Properties.xtext
//	def scope_ContainmentPathElement_namedElement(Element context, EReference reference) {
//		var scope = IScope::NULLSCOPE
//		if (context instanceof ContainmentPathElement) {
//			val path = context.owner as ContainedNamedElement
//			val list = path.containmentPathElements
//			val idx = list.indexOf(context)
//			if (idx > 0) {
//				//find next element in namespace of previous element
//				val el = list.get(idx - 1)
//				val ne = el.namedElement
//				switch ne {
//					Subcomponent: {
//						var ns = ne.classifier
//						if (!Aadl2Util::isNull(ns)) {
//							val ArrayList<EList<? extends NamedElement>> elementsInScope = newArrayList(ns.members)
//							//need to look for subprogram calls inside call sequences
//							if ((ne instanceof ThreadSubcomponent && ns instanceof ThreadImplementation) || (ne instanceof SubprogramSubcomponent && ns instanceof SubprogramImplementation)) {
//								elementsInScope.add((ns as BehavioredImplementation).subprogramCalls())
//							}
//							scope = Scopes::scopeFor(elementsInScope.flatten)
//						} else {
//							//look in prototype actuals
//							ns = ResolvePrototypeUtil::resolveComponentPrototype(ne.prototype, el)
//							if (ns != null) {
//								scope = Scopes::scopeFor(ns.members)
//							}
//						}
//					}
//					FeatureGroup: {
//						var ns = ne.allFeatureGroupType
//						if (ns != null) {
//							scope = Scopes::scopeFor(ns.members)
//						} else {
//							//look in prototype actuals
//							ns = ResolvePrototypeUtil::resolveFeatureGroupPrototype(ne.featureGroupPrototype, el)
//							if (ns != null) {
//								scope = Scopes::scopeFor(ns.members)
//							}
//						}
//					}
//					Feature: {
//						val ns = ne.classifier
//						if (ns != null) {
//							scope = Scopes::scopeFor(ns.members)
//						}
//					}
//					SubprogramCall: {
//						//looking inside a subprogram that is being called
//						val called = ne.calledSubprogram
//						switch called {
//							SubprogramImplementation:
//								scope = Scopes::scopeFor(called.members)
//							SubprogramSubcomponent:
//								scope = Scopes::scopeFor(called.allClassifier.members)
//						}
//					}
//				}
//			} else {
//				//the first containment path element
//				//need to make sure we look in the correct name space
//				val containingSubcomponent = EcoreUtil2::getContainerOfType(context, typeof(Subcomponent))
//				if (containingSubcomponent != null && containingSubcomponent.allClassifier != null) {
//					scope = Scopes::scopeFor(containingSubcomponent.allClassifier.members)
//				} else {
//					val containingFeature = EcoreUtil2::getContainerOfType(context, typeof(Feature))
//					if (containingFeature != null && containingFeature.allClassifier != null) {
//						scope = Scopes::scopeFor(containingFeature.allClassifier.members)
//					} else {
//						val containingSubprogramCall = EcoreUtil2::getContainerOfType(context, typeof(SubprogramCall))
//						switch containingSubprogramCall {
//							SubprogramImplementation:
//								scope = Scopes::scopeFor(containingSubprogramCall.members)
//							SubprogramSubcomponent:
//								scope = Scopes::scopeFor(containingSubprogramCall.allClassifier.members)
//						}
//					}
//				}
//			}
//		} else {
//			println("Not a ContainmentPathElement: " + context.eClass.name)
//		}
//		scope
//	}
	
//	override getScope(EObject context, EReference reference) {
//		println('''
//		other scope
//			«context»
//			«reference»
//			«reference.EReferenceType»
//		''')
//		super.getScope(context, reference)
//	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(NumberType context, EReference reference) {
		//Lower bound or upper bound values of a number property type.
		context.unitsType?.ownedLiterals.scopeFor ?: IScope::NULLSCOPE
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
		val baseType = type.basePropertyType
		var UnitsType unitsType = null
		switch baseType {
			NumberType:
				unitsType = baseType.unitsType
			RangeType:
				unitsType = baseType.numberType.unitsType
		}
		unitsType?.ownedLiterals.scopeFor ?: IScope::NULLSCOPE
	}
}