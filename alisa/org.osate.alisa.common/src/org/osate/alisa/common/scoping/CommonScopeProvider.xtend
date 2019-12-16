/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.scoping

import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AbstractFeature
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentPrototype
import org.osate.aadl2.Feature
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.FeatureGroupPrototype
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
import org.osate.alisa.common.common.AModelReference

import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isPredeclaredPropertySet
import static extension org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider.allMembers

class CommonScopeProvider extends AbstractDeclarativeScopeProvider {

	def scopeFor(Iterable<? extends EObject> elements) {
		new SimpleScope(IScope::NULLSCOPE,
			Scopes::scopedElementsFor(elements, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
	}

	def scope_UnitLiteral(EObject context, EReference reference) {
		val units = context.unitLiterals
		if (!units.empty) {
			units.scopeFor
		} else {
			IScope.NULLSCOPE
		}
	}

	val static EClass UNITS_TYPE = Aadl2Package.eINSTANCE.getUnitsType();

	def private getUnitLiterals(EObject context) {

		// TODO: Scope literals by type, but how to do we know the type of an
		// expression?
		val Collection<UnitLiteral> result = new ArrayList<UnitLiteral>()
		for (IEObjectDescription desc : Aadl2GlobalScopeUtil.getAllEObjectDescriptions(context, UNITS_TYPE)) {
			val unitsType = EcoreUtil.resolve(desc.getEObjectOrProxy(), context) as UnitsType;
			unitsType.ownedLiterals.forall[lit|result += lit as UnitLiteral];
		}

		return result;
	}

	def IScope scope_NumberType_referencedUnitsType(EObject context, EReference reference) {
		propertySetMemberScope(context, reference)
	}

	def IScope scope_TypeRef_ref(EObject context, EReference reference) {
		propertySetMemberScope(context, reference)
	}

	def IScope scope_Property(EObject context, EReference reference) {
		propertySetMemberScope(context, reference)
	}

	def IScope scope_APropertyReference_property(EObject context, EReference reference) {
		propertySetMemberScope(context, reference)
	}

	def IScope scope_ComponentImplementation(EObject context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.map[convertImplName], false)
	}

	def IScope scope_ComponentClassifier(EObject context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.map [
			if (Aadl2Package.eINSTANCE.componentImplementation.isSuperTypeOf(EObjectOrProxy.eClass)) {
				convertImplName
			} else {
				EObjectDescription.create(name.toString("::"), EObjectOrProxy)
			}
		], false)
	}

	def private propertySetMemberScope(EObject context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.map [
			#[EObjectDescription.create(name.toString("::"), EObjectOrProxy)] +
				if (name.firstSegment.predeclaredPropertySet) {
					#[EObjectDescription.create(name.lastSegment, EObjectOrProxy)]
				} else {
					emptyList
				}
		].flatten, false)
	}

	def private convertImplName(IEObjectDescription description) {
		val implName = description.name.lastSegment.split("\\.")
		val typename = description.name.skipLast(1).toString("::") + "::" + implName.get(0)
		val newName = if (implName.length > 1)
				QualifiedName.create(typename, implName.get(1))
			else
				QualifiedName.create(typename)
		EObjectDescription.create(newName, description.EObjectOrProxy)
	}

	def IScope scope_AModelReference_modelElement(EObject context, EReference reference) {
		new SimpleScope(#[EObjectDescription.create("this", context)])
	}

	def EObject getAModelReferenceContext(AModelReference amr) {
		var context = amr.eContainer
		while (context instanceof AModelReference) {
			context = context.eContainer
		}
		return context
	}

	def IScope scope_AModelReference_modelElement(AModelReference context, EReference reference) {
		if (context.prev === null) {
			scope_AModelReference_modelElement(context.AModelReferenceContext, reference)
		} else {
			val prev = context.prev
			val prevElement = prev.modelElement
			switch prevElement {
				Classifier:
					prevElement
				AbstractFeature:
					switch featureClassifier : prevElement.abstractFeatureClassifier {
						ComponentClassifier: featureClassifier
						ComponentPrototype: featureClassifier.constrainingClassifier
						default: prevElement.featurePrototype.constrainingClassifier
					}
				FeatureGroup:
					switch featureType : prevElement.featureType {
						FeatureGroupType: featureType
						FeatureGroupPrototype: featureType.constrainingFeatureGroupType
					}
				Feature:
					switch featureClassifier : prevElement.featureClassifier {
						ComponentClassifier: featureClassifier
						ComponentPrototype: featureClassifier.constrainingClassifier
					}
				Subcomponent:
					switch subcomponentType : prevElement.subcomponentType {
						ComponentClassifier: subcomponentType
						ComponentPrototype: subcomponentType.constrainingClassifier
					}
			}?.allMembers?.scopeFor
		}
	}

}
