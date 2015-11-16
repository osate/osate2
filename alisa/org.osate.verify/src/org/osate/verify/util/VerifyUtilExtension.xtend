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

package org.osate.verify.util

import com.google.common.collect.HashMultimap
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.categories.MethodCategory
import org.osate.categories.util.CategoriesUtil
import org.osate.verify.verify.Claim
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationPlan

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.osate.categories.categories.Category

class VerifyUtilExtension {

	static val HashMultimap <String,String> hasRunRecord = HashMultimap.create//Collections.synchronizedMap(newHashMap)

	def static boolean getHasRun(String analysisID, EObject target) {
		val value = hasRunRecord.get(analysisID)
		return value.contains(EcoreUtil.getURI(target).toString)
	}

	def static void setHasRun(String analysisID, EObject target) {
		hasRunRecord.put(analysisID, EcoreUtil.getURI(target).toString)
	}

	def static void unsetHasRun(String analysisID, EObject target) {
		hasRunRecord.remove(analysisID,EcoreUtil.getURI(target).toString)
	}

	def static void clearAllHasRunRecords() {
		hasRunRecord.clear
	}
	
	def static boolean hasFail(ElseExpr cee){
		cee.fail != null 
	}
	
	def static boolean hasTimeout(ElseExpr cee){
		cee.timeout != null 
	}
	
	def static boolean hasError(ElseExpr cee){
		cee.error != null 
	}
	
	def static ComponentClassifier getTargetComponentClassifier(VerificationPlan vp){
		vp.systemRequirements?.target
	}
	
	def static containingVerificationPlan(EObject sh) {
		sh.getContainerOfType(VerificationPlan)
	}
	
	def static getContainingClaim(EObject sh) {
		sh.getContainerOfType(Claim)
	}
	
	
	def static evaluateSelectionFilter(VerificationActivity expr, List<Category> selectionFilter, boolean strict) {
		val selection = expr.category
		return CategoriesUtil.intersects(selection,selectionFilter,strict)
	}

	def static evaluateRequirementFilter(Claim claim, Iterable<Category> requirementFilter, boolean strict) {
		val req = claim.requirement.category 
		return CategoriesUtil.intersects(req,requirementFilter,strict)
	}

	def static evaluateVerificationFilter(VerificationActivity va, List<Category> verificationFilter, boolean strict) {
		val vcs = va.method.category
		return CategoriesUtil.intersects(vcs,verificationFilter,strict)
	}
}