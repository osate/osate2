/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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

package org.osate.verify.util

import com.google.common.collect.HashMultimap
import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.util.Aadl2Util
import org.osate.categories.categories.CategoryFilter
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.result.AnalysisResult
import org.osate.verify.verify.Claim
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.VerificationPlan

import static org.osate.categories.util.CategoriesUtil.*

import static extension org.eclipse.xtext.EcoreUtil2.*

class VerifyUtilExtension {

	static val HashMultimap <String,String> hasRunRecord = HashMultimap.create//Collections.synchronizedMap(newHashMap)
	static val HashMap <String,URI> analysisResultRecord = new HashMap//Collections.synchronizedMap(newHashMap)

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

	def static void setAnalysisResult(EObject target, AnalysisResult analysisResult) {
		analysisResultRecord.put(EcoreUtil.getURI(target).toString, EcoreUtil.getURI(analysisResult))
	}

	def static AnalysisResult getAnalysisResult(EObject target) {
		val result = analysisResultRecord.get(EcoreUtil.getURI(target).toString)
		target.resourceSet.getEObject(result,true) as AnalysisResult
	}

	def static void clearAllHasRunRecords() {
		hasRunRecord.clear
		analysisResultRecord.clear
	}
	
	def static boolean hasFail(ElseExpr cee){
		cee.fail !== null 
	}
	
	def static boolean hasTimeout(ElseExpr cee){
		cee.timeout !== null 
	}
	
	def static boolean hasError(ElseExpr cee){
		cee.error !== null 
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
		if (filter === null) return true
		if (Aadl2Util.isNull(req)) return false
		return  matches(req.category,filter.category,filter.anyCategory)
	}

	def static evaluateRequirementFilter(Claim claim, CategoryFilter filter) {
		if (filter === null) return true
		val req = claim.requirement
		if (Aadl2Util.isNull(req)) return false
		// for requirements always drop through to verification activities if no categories
		if (req.category.empty) return true
		return  matches(req.category,filter.category,filter.anyCategory)
	}

	def static evaluateVerificationMethodFilter(VerificationActivity va, CategoryFilter filter) {
		if (filter === null) return true
		val vm = va.method
		if (vm === null ) return false
		return  matches(vm.category,filter.category,filter.anyCategory)
	}
	
	def static evaluateVerificationActivityFilter(VerificationActivity va, CategoryFilter filter) {
		if (filter === null) return true
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
	
	def static ComponentClassifier getTargetClassifier(VerificationPlan vp){
		val rs = vp.requirementSet
		if (rs instanceof SystemRequirementSet){
			return rs.target
		}
		return null
	}
	
}