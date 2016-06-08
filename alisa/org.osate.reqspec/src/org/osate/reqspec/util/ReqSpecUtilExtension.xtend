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

package org.osate.reqspec.util

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.aadl2.ComponentCategory
import org.osate.alisa.common.common.AVariableDeclaration
import org.osate.alisa.common.util.CommonUtilExtension
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.RequirementSet
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet

import static extension org.eclipse.xtext.EcoreUtil2.*

class ReqSpecUtilExtension {

	/**
	 * return the classifier of the target.
	 * The target could be an element inside a classifier. Then return its classifier.
	 * If the target is a classifier return it.
	 */
	def static targetClassifier(ContractualElement req) {
		if(req.target != null) return req.target
		var EObject container = req
		while (container.eContainer != null) {
			container = container.eContainer
			if (container instanceof SystemRequirementSet) {
				val rs = container
				if(rs.target != null) return rs.target
			} else if (container instanceof StakeholderGoals) {
				val rs = container
				if(rs.target != null) return rs.target
			}
		}
		return null;
	}

	def static containingContractualElement(EObject sh) {
		sh.getContainerOfType(ContractualElement)
	}

	def static containingRequirement(EObject sh) {
		sh.getContainerOfType(Requirement)
	}

	def static containingRequirementSet(EObject sh) {
		sh.getContainerOfType(RequirementSet)
	}

	def static containingStakeholderGoals(EObject sh) {
		sh.getContainerOfType(StakeholderGoals)
	}

	def static IScope scopeForGlobalVal(EObject context, IScope parentScope) {
		var result = parentScope
		val projectconstants = getImportedGlobals(context) // refFinder.getAllGlobalConstants(context)
		var Iterable<AVariableDeclaration> constants = new BasicEList
		for (pc : projectconstants) {
			constants = constants + pc.constants
		}
		if (!constants.empty) {
			result = new SimpleScope(result,
				Scopes::scopedElementsFor(constants, QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)),
				true)
			}
			return result
		}

		def static getImportedGlobals(EObject context) {
			val sr = ReqSpecUtilExtension.containingRequirementSet(context)
			val sg = containingStakeholderGoals(context)
			val res = sr?.importConstants ?: sg?.importConstants
			res
		}

		def static IScope scopeForValCompute(Requirement req, IScope parentscope) {
			var result = scopeForValGoal(req, parentscope)
			return scopeForValComputeReq(req, result)
		}

		def static IScope scopeForValComputeReq(Requirement req, IScope parentscope) {
			var result = parentscope
			for (r : req.decomposesReference) {
				result = scopeForValComputeReq(r, result)
			}
			for (r : req.refinesReference) {
				result = scopeForValComputeReq(r, result)
			}
			val sr = ReqSpecUtilExtension.containingRequirementSet(req)
			if (sr != null) {
				result = new SimpleScope(result,
					Scopes::scopedElementsFor(sr.constants,
						QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			}
			result = new SimpleScope(result, Scopes::scopedElementsFor(req.computes + req.constants,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			return result
		}

		/**
		 * collect val definitions from goals up the req refinement hierarchy
		 */
		def static IScope scopeForValGoal(Requirement req, IScope parentscope) {
			var result = parentscope
			for (r : req.refinesReference) {
				result = scopeForValGoal(r, result)
			}
			for (g : req.goalReference) {
				result = scopeForVal(g, result)
			}
			result
		}

		/**
		 * collect val for goal incl. refinement & stakeholder goals container
		 */
		def static IScope scopeForVal(Goal goal, IScope parentscope) {
			var result = parentscope
			for (r : goal.refinesReference) {
				result = scopeForVal(r, result)
			}
			val sr = containingStakeholderGoals(goal)
			if (sr != null) {
				result = new SimpleScope(result,
					Scopes::scopedElementsFor(sr.constants,
						QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			}
			result = new SimpleScope(result,
				Scopes::scopedElementsFor(goal.constants,
					QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			return result
		}

		/**
		 * collect Val definitions in req incl. refinements & goals associated with req.
		 */
		def static IScope scopeForVal(Requirement req, IScope parentscope) {
			var result = scopeForValGoal(req, parentscope)
			return scopeForValReq(req, result)
		}

		/**
		 * collect val definitions in req including refinement
		 */
		def static IScope scopeForValReq(Requirement req, IScope parentscope) {
			var result = parentscope
			for (r : req.decomposesReference) {
				result = scopeForValReq(r, result)
			}
			for (r : req.refinesReference) {
				result = scopeForValReq(r, result)
			}
			val sr = ReqSpecUtilExtension.containingRequirementSet(req)
			if (sr != null) {
				result = new SimpleScope(result,
					Scopes::scopedElementsFor(sr.constants,
						QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			}
			result = new SimpleScope(result, Scopes::scopedElementsFor(req.constants,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			return result
		}

		/**
		 * collect compute variable in req including refinement
		 */
		def static IScope scopeForCompute(Requirement req, IScope parentscope) {
			scopeForComputeReq(req, parentscope)
		}

		def static IScope scopeForComputeReq(Requirement req, IScope parentscope) {
			var result = parentscope
			for (r : req.refinesReference) {
				result = scopeForComputeReq(r, result)
			}
			val sr = ReqSpecUtilExtension.containingRequirementSet(req)
			result = new SimpleScope(result, Scopes::scopedElementsFor(req.computes,
				QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), false)
			return result
		}

		def static String constructDescription(ContractualElement r) {
			if(r.description != null) return CommonUtilExtension.toText(r.description, r.contractualElementSubject)
			if(r.title != null) return r.title
			""
		}

		def static getContractualElementSubject(ContractualElement req) {
			req?.targetElement ?: req.targetClassifier

		}
		
		def static boolean matchingCategory(Iterable <ComponentCategory> catlist, ComponentCategory cat){
			if (catlist.empty) return true
			if (cat == null) return true
			catlist.exists[c|c.getName().equalsIgnoreCase(cat.getName())]
		}
		

	}