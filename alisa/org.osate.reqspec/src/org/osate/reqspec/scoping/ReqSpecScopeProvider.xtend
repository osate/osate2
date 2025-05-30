/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */

/*
 * generated by Xtext
 */
package org.osate.reqspec.scoping

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.BasicInternalEList
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.DirectionType
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
import org.osate.alisa.common.common.AVariableReference
import org.osate.alisa.common.scoping.CommonScopeProvider
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.reqspec.reqSpec.WhenCondition
import org.osate.xtext.aadl2.errormodel.scoping.ErrorModelScopeProvider
import org.osate.xtext.aadl2.errormodel.util.EMV2Util

import static org.osate.alisa.common.util.CommonUtilExtension.*
import static org.osate.reqspec.util.ReqSpecUtilExtension.*

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it 
 * 
 */
class ReqSpecScopeProvider extends CommonScopeProvider {

	def scope_ContractualElement_targetElement(ContractualElement context, EReference reference) {
		val targetClassifier = targetClassifier(context)
		if (targetClassifier !== null) {
			if (targetClassifier instanceof ComponentType){
			return new SimpleScope(IScope::NULLSCOPE,
				Scopes::scopedElementsFor(targetClassifier.getAllFeatures + targetClassifier.allFlowSpecifications + targetClassifier.allModes,
					QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			}
			if (targetClassifier instanceof ComponentImplementation) {
				return new SimpleScope(IScope::NULLSCOPE,
					Scopes::scopedElementsFor(targetClassifier.getAllFeatures + targetClassifier.type.allFlowSpecifications +
						targetClassifier.allModes+targetClassifier.allSubcomponents + targetClassifier.allEndToEndFlows
						+ targetClassifier.allConnections,
						QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			} 
		}
		return IScope.NULLSCOPE
	}

	def scope_Mode(WhenCondition context, EReference reference) {
		val targetClassifier = targetClassifier(containingRequirement(context))
		if (targetClassifier instanceof ComponentType) {
			val thescope = new SimpleScope(IScope::NULLSCOPE,
				Scopes::scopedElementsFor(targetClassifier.allModes,
					QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			return thescope
		} else {
			IScope.NULLSCOPE
		}
	}

	def scope_ErrorBehaviorState(WhenCondition context, EReference reference) {
		val targetClassifier = targetClassifier(containingRequirement(context))
		if (targetClassifier !== null) {
			val states = EMV2Util.getAllErrorBehaviorStates(targetClassifier)
			val thescope = new SimpleScope(IScope::NULLSCOPE,
				Scopes::scopedElementsFor(states, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			return thescope
		} else {
			IScope.NULLSCOPE
		}
	}

//	Offer property definitions via scope. Here we can add filter to allow only those properties that actually apply to the target object
//	def scope_Property(PropertyConsistentVariableDeclaration context, EReference reference){
//			val props = (scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(context,
//				Aadl2Package.eINSTANCE.property, null)
//		new SimpleScope(IScope::NULLSCOPE, props,true)
//	}
	def scope_AVariableDeclaration(AVariableReference context, EReference reference) {
		val result = scopeForGlobalVal(context, IScope.NULLSCOPE)
		val contract = containingContractualElement(context)
		switch (contract) {
			Requirement: return scopeForValCompute(contract, result)
			Goal: return scopeForVal(contract, result)
		}
	}

	def scope_AVariableDeclaration(Requirement context, EReference reference) {
		val result = scopeForGlobalVal(context, IScope.NULLSCOPE)
		return scopeForValCompute(context, result)
	}

	def scope_AVariableDeclaration(Goal context, EReference reference) {
		val result = scopeForGlobalVal(context, IScope.NULLSCOPE)
		return scopeForVal(context, result)
	}

	// TODO: probably want validation to take care of Refining itself. Need to take care of inheritance
	def scope_Requirement_refinesReference(Requirement context, EReference reference) {
// use delegate to get other scopes including the global scope
		var result = delegateGetScope(context, reference) // IScope.NULLSCOPE
		val reqs = containingRequirementSet(context)
		if (reqs instanceof SystemRequirementSet) {
			val targetComponentClassifier = reqs.target
			val Iterable<SystemRequirementSet> listAccessibleSystemRequirements = Aadl2GlobalScopeUtil.getAll(context, ReqSpecPackage.eINSTANCE.systemRequirementSet).filter[sysreqs|isSameorExtends(targetComponentClassifier, sysreqs.target)]
			// TODO sort in extends hierarchy order
			for (sr : listAccessibleSystemRequirements) {
				if (!sr.requirements.empty) {
					result = new SimpleScope(result,
						Scopes::scopedElementsFor(sr.requirements,
							QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
				}
			}
		}
		result
	}

	def scope_Requirement_decomposesReference(Requirement context, EReference reference) {
		scope_Requirement_refinesReference(context, reference)
	}

	def scope_Requirement_evolvesReference(Requirement context, EReference reference) {
		scope_Requirement_refinesReference(context, reference)
	}

	def scope_Requirement_inheritsReference(Requirement context, EReference reference) {
		scope_Requirement_refinesReference(context, reference)
	}

	def scope_Requirement_exception(Requirement context, EReference reference) {
		val targetClassifier = targetClassifier(context)
		if (targetClassifier !== null) {
			val exceptionItems = EMV2Util.getAllErrorSources(targetClassifier) +
				EMV2Util.getAllErrorPaths(targetClassifier)
			val propscope = ErrorModelScopeProvider.scopeForErrorPropagation(targetClassifier, DirectionType.OUT)
			val thescope = new SimpleScope(propscope,
				Scopes::scopedElementsFor(exceptionItems,
					QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			return thescope
		} else {
			IScope.NULLSCOPE
		}
	}
	
	override IScope scope_AModelReference_modelElement(EObject context, EReference reference) {
		val contractualElement = context.getContainerOfType(ContractualElement)
		val target = contractualElement?.targetElement ?:
				contractualElement?.target ?:
				context.getContainerOfType(StakeholderGoals)?.target ?:
				context.getContainerOfType(SystemRequirementSet).target
		new SimpleScope(#[EObjectDescription.create("this", target)])
	}
	
	// Brought from Aadl2JavaValidator
	def EList<ComponentClassifier> getSelfPlusAncestors(ComponentClassifier cl) {
		val cls = new BasicInternalEList<ComponentClassifier>(typeof(ComponentClassifier));
		cls.add(cl);

		var temp = cl
		while (temp.getExtended() !== null) {
			if (cls.contains(temp.getExtended())) {
				return cls;
			}
			temp = temp.getExtended() as ComponentClassifier;
			cls.add(temp);
		}

		// If implementation collect for type
		if (cl instanceof ComponentImplementation) {
			temp = cl.type
			cls.add(temp);
			while (temp.getExtended() !== null) {
				if (cls.contains(temp.getExtended())) {
					return cls;
				}
				temp = temp.getExtended() as ComponentClassifier;
				cls.add(temp);
			}

		}
		cls
	}

}
