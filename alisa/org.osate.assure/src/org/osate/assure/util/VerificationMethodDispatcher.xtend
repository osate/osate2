package org.osate.assure.util


import org.osate.assure.assure.VerificationActivityResult
import org.osate.verify.verify.SupportedTypes
import junit.framework.AssertionFailedError
import org.osate.aadl2.instance.InstanceObject
import static extension org.osate.assure.util.AssureUtilExtension.*
import com.google.inject.ImplementedBy
import org.osate.assure.assure.VerificationResultState

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def void dispatchVerificationMethod(String methodPath, InstanceObject target);
	def void runVerificationMethod(VerificationActivityResult verificationActivityResult);
}

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher{
	
	extension AssureUtilExtension aue = new AssureUtilExtension
	
	override runVerificationMethod(VerificationActivityResult verificationActivityResult) {
		val method = verificationActivityResult.getTarget().getMethod();
		if (method.getMethodType() == SupportedTypes.SINGLEPREDICATE) {
			val methodpath = method.getMethodPath();
			try { // XXX remove the activity name from the method
				dispatchVerificationMethod(methodpath+"@@"+verificationActivityResult.name, verificationActivityResult.caseSubject)
				addSuccess(verificationActivityResult)
			} catch (AssertionFailedError e) {
				addFailure(verificationActivityResult, e);
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				addError(verificationActivityResult, e);
			}
			
			}
	}
	
	override dispatchVerificationMethod(String methodPath, InstanceObject target) {
		println("Dispatching "+methodPath + " on "+target.getQualifiedName)

	}
	
}