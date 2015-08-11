package org.osate.verify.util

import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.osate.verify.verify.ElseExpr
import com.google.common.collect.HashMultimap
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.Claim
import org.osate.aadl2.ComponentClassifier
import org.osate.verify.verify.VerificationPlan
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
	
}