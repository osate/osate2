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

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.osate.aadl2.modelsupport.scoping.IEClassGlobalScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EClass
import org.osate.aadl2.Aadl2Package
import java.util.Collection
import org.osate.aadl2.UnitLiteral
import java.util.ArrayList
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.UnitsType
import org.eclipse.xtext.resource.EObjectDescription

import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isPredeclaredPropertySet

class CommonScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject
	var IEClassGlobalScopeProvider globalScope;


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

	val private static EClass UNITS_TYPE = Aadl2Package.eINSTANCE.getUnitsType();

	def private getUnitLiterals(EObject context) {

		// TODO: Scope literals by type, but how to do we know the type of an
		// expression?
		val Collection<UnitLiteral> result = new ArrayList<UnitLiteral>()
		val scope = globalScope.getScope(context.eResource(), UNITS_TYPE)
		for (IEObjectDescription desc : scope.allElements) {
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
		new SimpleScope(delegateGetScope(context, reference).allElements.map[
			if (Aadl2Package.eINSTANCE.componentImplementation.isSuperTypeOf(EObjectOrProxy.eClass)) {
				convertImplName
			} else {
				EObjectDescription.create(name.toString("::"), EObjectOrProxy)
			}
		], false)
	}
	
	def private propertySetMemberScope(EObject context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.map[
			#[EObjectDescription.create(name.toString("::"), EObjectOrProxy)] + if (name.firstSegment.predeclaredPropertySet) {
				#[EObjectDescription.create(name.lastSegment, EObjectOrProxy)]
			} else {
				emptyList
			}
		].flatten, false)
	}
	
	def private convertImplName(IEObjectDescription description) {
		val implName = description.name.lastSegment.split("\\.")
		val newName = QualifiedName.create(description.name.skipLast(1).toString("::") + "::" + implName.get(0), implName.get(1))
		EObjectDescription.create(newName, description.EObjectOrProxy)
	}
}