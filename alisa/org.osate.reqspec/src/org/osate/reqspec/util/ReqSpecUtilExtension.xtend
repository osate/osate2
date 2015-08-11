package org.osate.reqspec.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirements

import static extension org.eclipse.xtext.EcoreUtil2.*

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
		scopeForValGoal(req,result)
	}
	def static IScope scopeForValComputeReq(Requirement req, IScope parentscope) {
		var result = parentscope
		result = new SimpleScope(result,
			Scopes::scopedElementsFor( req.computes +req.constants , 
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		val sr = containingSystemRequirements(req)
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(sr.computes + sr.constants,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		for (r : req.refinesReference) {
			result = scopeForValComputeReq(r, result)
		}
		result
	}
	
	def static IScope scopeForValGoal(Requirement req, IScope parentscope) {
		var result = parentscope
		for (g : req.goalReference) {
			result = scopeForVal(g, result)
		}
		for (r : req.refinesReference) {
			result = scopeForValGoal(r, result)
		}
		result
	}

	def static IScope scopeForVal(Goal goal, IScope parentscope) {
		var result = parentscope
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(goal.constants, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)),
			true)
			val sr = containingStakeholderGoals(goal)
			result = new SimpleScope(result,
				Scopes::scopedElementsFor(sr.constants, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)),
				true)
				for (r : goal.refinesReference) {
					result = scopeForVal(r, result)
				}

				result
	}
	def static IScope scopeForVal(Requirement req, IScope parentscope) {
		var result=scopeForValReq(req,parentscope)
		scopeForValGoal(req,result)
	}
	def static IScope scopeForValReq(Requirement req, IScope parentscope) {
		var result = parentscope
		result = new SimpleScope(result,
			Scopes::scopedElementsFor( req.constants , 
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		val sr = containingSystemRequirements(req)
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(sr.constants,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		for (r : req.refinesReference) {
			result = scopeForValReq(r, result)
		}
		result
	}

	def static IScope scopeForCompute(Requirement req, IScope parentscope) {
		scopeForComputeReq(req,parentscope)
	}
	def static IScope scopeForComputeReq(Requirement req, IScope parentscope) {
		var result = parentscope
		result = new SimpleScope(result,
			Scopes::scopedElementsFor( req.computes  , 
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		val sr = containingSystemRequirements(req)
		result = new SimpleScope(result,
			Scopes::scopedElementsFor(sr.computes ,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		for (r : req.refinesReference) {
			result = scopeForComputeReq(r, result)
		}
		result
	}
	

}