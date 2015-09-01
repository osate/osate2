package org.osate.verify.util

import com.google.common.collect.HashMultimap
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.categories.VerificationCategory
import org.osate.categories.util.CategoriesUtil
import org.osate.verify.verify.Claim
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationPlan

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

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
	
	def static boolean hasOther(ElseExpr cee){
		cee.other != null 
	}
	
	def static Claim getContainingClaim(VerificationActivity va){
		return va.eContainer as Claim
	}
	
	def static ComponentClassifier getTargetComponentClassifier(VerificationPlan vp){
		vp.systemRequirements?.target
	}
	
	def static containingVerificationPlan(EObject sh) {
		sh.getContainerOfType(VerificationPlan)
	}
	
	
	def static evaluateSelectionFilter(VerificationActivity expr, List<SelectionCategory> selectionFilter, boolean strict) {
		val selection = expr.condition
		return CategoriesUtil.intersects(selection,selectionFilter,strict)
	}

	def static evaluateRequirementFilter(Claim claim, Iterable<RequirementCategory> requirementFilter, boolean strict) {
		val req = claim.requirement.category 
		return CategoriesUtil.intersects(req,requirementFilter,strict)
	}

	def static evaluateVerificationFilter(VerificationActivity va, List<VerificationCategory> verificationFilter, boolean strict) {
		val vcs = va.method.category
		return CategoriesUtil.intersects(vcs,verificationFilter,strict)
	}
	
	
}