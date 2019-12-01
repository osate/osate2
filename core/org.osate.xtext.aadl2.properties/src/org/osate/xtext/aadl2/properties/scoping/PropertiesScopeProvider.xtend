/*
 * 
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

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.BehavioredImplementation
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentPrototype
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.Element
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.FeatureGroupPrototype
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.NumberType
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.ReferenceValue
import org.osate.aadl2.RefinableElement
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.parsesupport.AObject

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType
import static extension org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil.resolveComponentPrototype
import static extension org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil.resolveFeatureGroupPrototype

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
class PropertiesScopeProvider extends AbstractDeclarativeScopeProvider {
	//Adds scope with renames for all references to Classifiers.
	def scope_Classifier(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference)
		val renameScopeElements = newArrayList()
		val packageSection = context.getContainerOfType(PackageSection)
		if (packageSection !== null) {
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
			scope = new SimpleScope(scope, renameScopeElements, true)
		}
		scope
	}
	
	/*
	 * Reference is from ModalPropertyValue and OptionalModalPropertyValue in Properties.xtext
	 * and SubprogramCallSequence, InternalFeature, ProcessorFeature, and DefaultAnnexSubclause in Aadl2.xtext
	 */
	def scope_ModalElement_inMode(Element context, EReference reference) {
		var scope = IScope::NULLSCOPE
		val containingPropertyAssociation = context.getContainerOfType(PropertyAssociation)
		if (containingPropertyAssociation !== null) {
			if (!containingPropertyAssociation.appliesTos.empty) {
				scope = (containingPropertyAssociation.appliesTos.get(0).containmentPathElements.findLast[namedElement instanceof Subcomponent].namedElement as Subcomponent)?.
						classifier?.allModes?.scopeFor ?: scope
			} else if (containingPropertyAssociation.owner instanceof Subcomponent) {
				scope = (containingPropertyAssociation.owner as Subcomponent).allClassifier?.allModes?.scopeFor ?: scope
			}
		}
		if (scope == IScope::NULLSCOPE) {
			scope = context.getContainerOfType(ComponentClassifier).allModes.scopeFor
		}
		scope
	}
	
	//Reference is from LiteralorReferenceTerm in Properties.xtext
	def scope_NamedValue_namedValue(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference)
		var PropertyType propertyType = null;
		//Inner value of a record value.
		propertyType = context.getContainerOfType(BasicPropertyAssociation)?.property?.propertyType
		if (propertyType === null) {
			//Value of the property constant.
			propertyType = context.getContainerOfType(PropertyConstant)?.propertyType
		}
		if (propertyType === null) {
			//Default value of a property definition.
			propertyType = context.getContainerOfType(Property)?.propertyType
		}
		if (propertyType === null) {
			//Value of an association.
			propertyType = context.getContainerOfType(PropertyAssociation)?.property?.propertyType
		}
		propertyType = propertyType.basePropertyType
		if (propertyType instanceof EnumerationType) {
			scope = propertyType.ownedLiterals.scopeFor(scope)
		}
		scope
	}
	
	//Reference is from FieldPropertyAssociation in Properties.xtext
	def scope_BasicPropertyAssociation_property(Element context, EReference reference) {
		var parent = switch context {
			BasicPropertyAssociation:
				context.owner
			default:
				context
		}
		while (parent !== null && !(parent instanceof BasicPropertyAssociation || parent instanceof PropertyAssociation || parent instanceof Property || parent instanceof PropertyConstant)) {
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
		if (propertyType instanceof RecordType) {
			propertyType.ownedFields.scopeFor
		} else {
			IScope::NULLSCOPE
		}
	}
	
	//Reference is from ContainmentPathElement in Properties.xtext
	def scope_ContainmentPathElement_namedElement(Element context, EReference reference) {
		val Classifier namespace = switch context {
			ReferenceValue: {
				//Scoping for first element of a reference value when providing the scope for content assist
				context.getContainerOfType(PropertyAssociation)?.namespaceForPropertyAssociation
			}
			PropertyAssociation: {
				//Scoping for first element of the applies to when providing the scope for content assist
				context.namespaceForPropertyAssociation
			}
			ContainmentPathElement: {
				if (context.namedElement === null || context.namedElement.eIsProxy) {
					//Scoping for first element of the chain when providing the scope for quick fix
					if (context.owner instanceof ReferenceValue) {
						//Scoping for first element of a reference value
						context.getContainerOfType(PropertyAssociation)?.namespaceForPropertyAssociation
					} else if (context.owner.owner instanceof PropertyAssociation) {
						//Scoping for first element of the applies to
						(context.owner.owner as PropertyAssociation).namespaceForPropertyAssociation
					} else if (context.owner instanceof ContainmentPathElement) {
						//Scoping for chained element after the first element when providing the scope for quick fix
						(context.owner as ContainmentPathElement).classifierForPreviousContainmentPathElement
					}
				} else {
					//Scoping for chained element after the first element when providing the scope for content assist
					context.classifierForPreviousContainmentPathElement
				}
			}
		}
		namespace?.allMembers?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from IntegerTerm and RealTerm in Properties.xtext
	def scope_NumberValue_unit(NumberType context, EReference reference) {
		//Lower bound or upper bound values of a number property type.
		context.unitsType?.ownedLiterals?.scopeFor ?: IScope::NULLSCOPE
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
	
	def protected static scopeFor(Iterable<? extends EObject> elements) {
		elements.scopeFor(IScope::NULLSCOPE)
	}
	
	def protected static scopeFor(Iterable<? extends EObject> elements, IScope outer) {
		new SimpleScope(outer, Scopes::scopedElementsFor(elements, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
	}
	
	def protected static <T extends EObject> scopeFor(Iterable<? extends T> elements, (T)=>QualifiedName nameComputation, IScope outer) {
		new SimpleScope(outer, Scopes::scopedElementsFor(elements, nameComputation), true)
	}
	
	def protected static <T extends AObject> filterRefined(Iterable<T> unfiltered) {
		unfiltered.filter[member |
			if (member instanceof RefinableElement) {
				!unfiltered.filter(RefinableElement).exists[it.refinedElement == member]
			} else {
				true
			}
		]
	}
	
	def protected static allSubprogramCalls(BehavioredImplementation implementation) {
		val allSubprogramCalls = newArrayList
		for (var ComponentImplementation currentImplementation = implementation; currentImplementation !== null; currentImplementation = currentImplementation.extended) {
			//Should always be a BehavioredImplementation unless we have a malformed model.
			if (currentImplementation instanceof BehavioredImplementation) {
				allSubprogramCalls.addAll(currentImplementation.subprogramCalls())
			}
		}
		allSubprogramCalls
	}
	
	def protected static allFeatureType(FeatureGroup featureGroup) {
		var refinedFeatureGroup = featureGroup
		while (refinedFeatureGroup.featureType === null && refinedFeatureGroup.refined instanceof FeatureGroup) {
			refinedFeatureGroup = refinedFeatureGroup.refined as FeatureGroup
		}
		refinedFeatureGroup.featureType
	}
	
	def protected static allSubcomponentType(Subcomponent subcomponent) {
		var refinedSubcomponent = subcomponent
		while (refinedSubcomponent.subcomponentType === null && refinedSubcomponent.refined !== null) {
			refinedSubcomponent = refinedSubcomponent.refined
		}
		refinedSubcomponent.subcomponentType
	}
	
	def protected static allInternalFeatures(ComponentImplementation implementation) {
		val allInternalFeatures = newArrayList
		for (var ComponentImplementation currentImplementation = implementation; currentImplementation !== null; currentImplementation = currentImplementation.extended) {
			allInternalFeatures.addAll(currentImplementation.ownedInternalFeatures)
		}
		allInternalFeatures
	}
	
	def static allMembers(Classifier classifier) {
		val allMembers = newArrayList
		allMembers.addAll(classifier.members)
		if (classifier instanceof BehavioredImplementation) {
			allMembers.addAll(classifier.allSubprogramCalls)
		}
		allMembers
	}
	
	def static protected createUnitLiteralsScopeFromPropertyType(PropertyType type) {
		switch baseType : type.basePropertyType {
			NumberType:
				baseType.unitsType
			RangeType:
				baseType.numberType.unitsType
		}?.ownedLiterals?.scopeFor ?: IScope::NULLSCOPE
	}
	
	def protected static namespaceForPropertyAssociation(PropertyAssociation propertyAssociation) {
		switch container : propertyAssociation.owner {
			Classifier:
				container
			FeatureGroup: {
				switch featureType : container.allFeatureType {
					FeatureGroupType:
						featureType
					FeatureGroupPrototype:
						featureType.resolveFeatureGroupPrototype(propertyAssociation.getContainerOfType(Classifier))
				}
			}
			Subcomponent: {
				switch subcomponentType : container.allSubcomponentType {
					ComponentClassifier:
						subcomponentType
					ComponentPrototype:
						subcomponentType.resolveComponentPrototype(propertyAssociation.getContainerOfType(Classifier))
				}
			}
		}
	}
	
	def protected static getClassifierForPreviousContainmentPathElement(ContainmentPathElement previousCpe) {
		switch previousElement : previousCpe.namedElement {
			case null,
			case previousElement.eIsProxy:
				//Don't provide a scope if the previous element could not be resolved
				null
			Subcomponent: {
				switch subcomponentType : previousElement.allSubcomponentType {
					ComponentClassifier:
						subcomponentType
					ComponentPrototype:
						subcomponentType.resolveComponentPrototype(previousCpe)
				}
			}
			FeatureGroup: {
				switch featureType : previousElement.allFeatureType {
					FeatureGroupType:
						featureType
					FeatureGroupPrototype:
						featureType.resolveFeatureGroupPrototype(previousCpe)
				}
			}
		}
	}
}
