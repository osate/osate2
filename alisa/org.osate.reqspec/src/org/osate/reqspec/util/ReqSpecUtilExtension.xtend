package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.Requirement
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.osate.reqspec.reqSpec.SystemRequirements
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.reqspec.reqSpec.Goal

class ReqSpecUtilExtension {

	def static targetClassifier(ContractualElement req) {
		if(req.target != null) return req.target
		var EObject container = req
		while (container.eContainer != null) {
			container = container.eContainer
			if (container instanceof SystemRequirements) {
				val rs = container as SystemRequirements
				if(rs.target != null) return rs.target
			} else if (container instanceof StakeholderGoals) {
				val rs = container as StakeholderGoals
				if(rs.target != null) return rs.target
			}
		}
		return null;
	}

	def static containingRequirement(EObject sh) {
		sh.getContainerOfType(Requirement)
	}

	def static containingSystemRequirements(EObject sh) {
		sh.getContainerOfType(SystemRequirements)
	}

	def static containingStakeholderGoals(EObject sh) {
		sh.getContainerOfType(StakeholderGoals)
	}

	def static IScope scopeForValCompute(Requirement req, IScope parentscope) {
		var result=scopeForValComputeReq(req,parentscope)
		scopeForValComputeGoal(req,result)
	}
	def static IScope scopeForValComputeReq(Requirement req, IScope parentscope) {
		var result = parentscope
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(req.computes + req.constants,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		val sr = containingSystemRequirements(req)
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(sr.computes + sr.constants,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		for (r : req.refinesReference) {
			result = scopeForValComputeReq(r, result)
		}
//		for (g : req.goalReference) {
//			result = scopeForValCompute(g, result)
//		}
		result
	}
	
	def static IScope scopeForValComputeGoal(Requirement req, IScope parentscope) {
		var result = parentscope
		for (g : req.goalReference) {
			result = scopeForValCompute(g, result)
		}
		for (r : req.refinesReference) {
			result = scopeForValComputeGoal(r, result)
		}
		result
	}

	def static IScope scopeForValCompute(Goal goal, IScope parentscope) {
		var result = parentscope
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(goal.constants, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)),
			true)
			val sr = containingStakeholderGoals(goal)
			result = new SimpleScope(result,
				Scopes::scopedElementsFor(sr.constants, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)),
				true)
				for (r : goal.refinesReference) {
					result = scopeForValCompute(r, result)
				}

				result
			}

		}