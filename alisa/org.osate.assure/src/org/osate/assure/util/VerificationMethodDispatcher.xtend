package org.osate.assure.util


import org.osate.assure.assure.VerificationActivityResult
import org.osate.verify.verify.SupportedTypes
import org.osate.aadl2.instance.InstanceObject
import static extension org.osate.assure.util.AssureUtilExtension.*
import com.google.inject.ImplementedBy
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import com.google.inject.Inject
import org.osate.assure.linking.AssureLinkingService
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import com.rockwellcollins.atc.resolute.analysis.results.FailResult
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider
import org.osate.assure.assure.ResultIssue
import org.osate.assure.assure.impl.ResultIssueImpl
import org.osate.assure.assure.AssureFactory

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def Object dispatchVerificationMethod(String methodPath, VerificationActivityResult vr);
	def void runVerificationMethod(VerificationActivityResult verificationActivityResult);
}

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher{
	
	override Object dispatchVerificationMethod(String methodPath, VerificationActivityResult vr) {
		println("Dispatching "+methodPath + " on "+vr.claimSubject.getQualifiedName)
		return null
		}

	override void runVerificationMethod(VerificationActivityResult verificationActivityResult) {
		val method = verificationActivityResult.getTarget().getMethod();
		val methodpath = method.getMethodPath();
		switch method.getMethodType() {
			case SupportedTypes.SINGLEPREDICATE : //|| SupportedTypes.SINGLEANALYSIS || SupportedTypes.ASSERTIONEXCEPTION: 
			{
			try { 
				val res = dispatchVerificationMethod(methodpath, verificationActivityResult)
				if (res != null && res instanceof Boolean && res != true){
				setToFail(verificationActivityResult, "");
				} else {
					setToSuccess(verificationActivityResult)
				}
			} catch (AssertionError e) {
				setToFail(verificationActivityResult, e);
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				setToError(verificationActivityResult, e);
			}
			}
			
		case SupportedTypes.MULTIMARKER: {
			try { 
				val res = dispatchVerificationMethod(methodpath, verificationActivityResult)
				if (res != null && res instanceof Boolean && res != true){
				setToFail(verificationActivityResult, "");
				} else {
				setToSuccess(verificationActivityResult)
				}
//			} catch (AssertionError e) {
//				setToFail(verificationActivityResult, e);
//				null
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				setToError(verificationActivityResult, e);
			}
		}
		case SupportedTypes.RESOLUTEPROVE:{
			// Resolute handling See AssureUtil for setup	
			val si = verificationActivityResult.caseSubject.systemInstance
			val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
			val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
			val ClaimResult proof = interpreter.evaluateProveStatement(createWrapperProveCall(verificationActivityResult.getMethodName)) as ClaimResult
			if (proof.valid){
				setToSuccess(verificationActivityResult)
			} else {
				val proveri = AssureFactory.eINSTANCE.createResultIssue
				proof.doResoluteResults(proveri)
				setToFail(verificationActivityResult, proveri.issues)
			}
		}
		}
	}
	
	@Inject static AssureLinkingService assureLinking
	
	def static ProveStatement createWrapperProveCall(String resoluteFunction){
		val factory = ResoluteFactory.eINSTANCE
		val call = factory.createFnCallExpr
		val found = assureLinking.resolveResoluteFunction(call,resoluteFunction)
		val found1 = assureLinking.findResoluteFunction(call,resoluteFunction)
		call.fn = found
		call.args.add(factory.createThisExpr)
		val prove = factory.createProveStatement
		prove.expr = call
		prove
	}
	
}