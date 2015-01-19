package org.osate.assure.util

import org.eclipse.emf.ecore.EObject
import org.osate.assure.assure.CaseResult
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.eclipse.core.resources.IResource
import org.osate.aadl2.modelsupport.AadlConstants
import org.eclipse.core.resources.IMarker
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.AssureFactory
import org.osate.assure.assure.VerificationResult
import org.osate.assure.assure.VerificationResultState
import org.eclipse.emf.ecore.util.EcoreUtil
import java.util.Collections

class AssureUtilExtension {

	def static CaseResult getEnclosingCaseResult(EObject assureObject) {
		var result = assureObject
		while (!(result instanceof CaseResult)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as CaseResult
	}

	def static void addErrorMarkers(VerificationActivityResult verificationActivityResult,InstanceObject instance, String markertype) {
		val res = instance.eResource
		val err = res.errors
		val mt = "org.osate.analysis.flows.FlowLatencyObjectMarker"
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markersforanalysis = irsrc.findMarkers(mt, true, IResource.DEPTH_INFINITE) // analysisMarkerType
		val markers = markersforanalysis.filter[IMarker m|
			m.getAttribute(AadlConstants.AADLURI) == EcoreUtil.getURI(instance).toString() &&
			m.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR
		]
//		markers.forEach[m|
// first one only
		val m = markers.head
		val VerificationResult vr = verificationActivityResult.result//AssureFactory.eINSTANCE.createVerificationResult();
		vr.setResultState(VerificationResultState.FAIL);
		vr.setFailMsg(m.getAttribute(IMarker.MESSAGE) as String);
		vr.setType(markertype);
		verificationActivityResult.setResult(vr);
//		]
	}

	def static void addFailure(VerificationActivityResult verificationActivityResult, Throwable e) {
		val VerificationResult res = verificationActivityResult.result //AssureFactory.eINSTANCE.createVerificationResult();
		res.setResultState(VerificationResultState.FAIL);
		res.setFailMsg(e.getMessage());
		res.setType(e.getClass().getName());
		verificationActivityResult.setResult(res);
	}

	def static void addError(VerificationActivityResult verificationActivityResult, Throwable e) {
		val VerificationResult res = verificationActivityResult.result
		//verificationActivityResult.setResult(AssureFactory.eINSTANCE.createVerificationResult());
		res.setResultState(VerificationResultState.UNKNOWN);
		res.setFailMsg(e.getMessage());
		res.setType(e.getClass().getName());
	}
	
	static val hasRunRecord = Collections.synchronizedMap(newHashMap)
	
	def static boolean hasRun(String analysisID, EObject target){
		try {
			hasRunRecord.put(analysisID, target)?:runme(analysisID,target)
			} catch (Exception e) {
				hasRunRecord.remove(analysisID)
				return false
			}
		return true
	}
	
	def static void clearHasRunRecords(){
		hasRunRecord.clear
	}
	
	def static EObject runme(String analysisID,EObject eo){
		return eo
	}

}
