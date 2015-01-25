package org.osate.assure.util


import org.osate.assure.assure.VerificationActivityResult
import org.osate.verify.verify.SupportedTypes
import org.osate.aadl2.instance.InstanceObject
import static extension org.osate.assure.util.AssureUtilExtension.*
import com.google.inject.ImplementedBy

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def Object dispatchVerificationMethod(String methodPath, InstanceObject target);
	def Object runVerificationMethod(VerificationActivityResult verificationActivityResult);
}

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher{
	override runVerificationMethod(VerificationActivityResult verificationActivityResult) {
		val method = verificationActivityResult.getTarget().getMethod();
		if (method.getMethodType() == SupportedTypes.SINGLEPREDICATE) {
			val methodpath = method.getMethodPath();
			try { 
				val res = dispatchVerificationMethod(methodpath, verificationActivityResult.caseSubject)
				setToSuccess(verificationActivityResult)
				res
			} catch (AssertionError e) {
				setToFail(verificationActivityResult, e);
				null
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				setToError(verificationActivityResult, e);
				null
			}
			
			}
	}
	
	
	override dispatchVerificationMethod(String methodPath, InstanceObject target) {
		println("Dispatching "+methodPath + " on "+target.getQualifiedName)
		
	}
	
}