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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.util.Aadl2Util
import org.osate.categories.categories.CategoryFilter
import org.osate.verify.verify.Claim
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.VerificationPlan

import static org.osate.categories.util.CategoriesUtil.*
import static org.osate.reqspec.util.ReqSpecUtilExtension.*

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.osate.aadl2.NumberValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.UnitLiteral
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.Classifier
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.aadl2.ComponentClassifier

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
	
	
	def static containingVerificationPlan(EObject sh) {
		sh.getContainerOfType(VerificationPlan)
	}
	
	def static getContainingClaim(EObject sh) {
		sh.getContainerOfType(Claim)
		
	}
	
	def static getContainingVerificationMethod(EObject sh) {
		sh.getContainerOfType(VerificationMethod)
	}

	def static ordinal(Integer i){
		val String[] suffixes =  newArrayOfSize(10)
		for(var m=0;m<suffixes.length;m++){
			suffixes.set(m,
				switch m {
					case 1 : "st"
					case 2 : "nd"
					case 3 : "rd"
					default : "th"
				}
			)
		}
//		suffixes.set(0, "th")
//		suffixes.set(1, "st")
//		suffixes.set(2, "nd")
//		suffixes.set(3, "rd")
//		suffixes.set(4, "th")
//		suffixes.set(5, "th")
//		suffixes.set(6, "th")
//		suffixes.set(7, "th")
//		suffixes.set(8, "th")
//		suffixes.set(9, "th")
		switch (i % 100) {
			case 11, case 12, case 13 :
				i + "th"
			default : {
				val suffIdx =  i % 10
				i + suffixes.get(suffIdx)
			}
		 }
	}
	
	def static newArrayofSize(int i) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def static evaluateRequirementFilter(Requirement req, CategoryFilter filter) {
		if (filter == null) return true
		if (Aadl2Util.isNull(req)) return false
		return  matches(req.category,filter.category,filter.anyCategory)
	}

	def static evaluateRequirementFilter(Claim claim, CategoryFilter filter) {
		if (filter == null) return true
		val req = claim.requirement
		if (Aadl2Util.isNull(req)) return false
		return  matches(req.category,filter.category,filter.anyCategory)
	}

	def static evaluateVerificationMethodFilter(VerificationActivity va, CategoryFilter filter) {
		if (filter == null) return true
		val vm = va.method
		if (vm == null ) return false
		return  matches(vm.category,filter.category,filter.anyCategory)
	}
	
	def static evaluateVerificationActivityFilter(VerificationActivity va, CategoryFilter filter) {
		if (filter == null) return true
		return matches(va.category,filter.category,filter.anyCategory) 
	}
	
	// Deal with qualified verification activity and claim references	(see Assure grammar)

	def static String constructVerificationActivityReference(VerificationActivity va){
		val claim = va.containingClaim
		val plan = va.containingVerificationPlan
		return plan.name+"#"+claim.constructClaimReferencePath+"#"+va.name
	}

	def static String constructClaimReference(Claim claim){
		val plan = claim.containingVerificationPlan
		return plan.name+"#"+claim.constructClaimReferencePath
	}
	
	def static String constructClaimReferencePath(Claim claim){
		val parent = claim.eContainer
		if (parent instanceof Claim){
			return constructClaimReferencePath(parent)+"."+claim.requirement.name
		}
		return claim.requirement.name
	}

	def static NumberValue convertValueToUnit(NumberValue numberValue, UnitLiteral target) {
		val value = numberValue.scaledValue;
		val unit = numberValue.getUnit();
		var factor = 1.0
		if (unit != null) factor = unit.getAbsoluteFactor(target);
		val result = value * factor;
		val resultValue = numberValue.cloneNumber();
		resultValue.setUnit(target);
		setValue(resultValue, result);
		return resultValue;
	}
	
	def static void setValue(NumberValue numberValue, double value) {
		switch (numberValue) {
			RealLiteral: numberValue.setValue(value)
			IntegerLiteral: numberValue.setValue((value as long))
		}
	}
	
	def static ComponentClassifier getTargetClassifier(VerificationPlan vp){
		val rs = vp.requirementSet
		if (rs instanceof SystemRequirementSet){
			return rs.target
		}
		return null
	}
	
}