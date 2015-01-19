package org.osate.assure.ui.handlers;

import junit.framework.AssertionFailedError;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.alisa.workbench.ui.utils.AlisaLoader;
import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.HazardResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

public class AssureProcessing {

	public static void processCaseResult(CaseResult caseResult) {
		System.out.println("case result=" + caseResult);

		for (ClaimResult claimResult : caseResult.getClaimResult()) {
			processClaimResult(claimResult);
		}
		for (HazardResult claimResult : caseResult.getHazardResult()) {
			processHazardResult(claimResult);
		}
		for (CaseResult subCaseResult : caseResult.getSubCaseResult()) {
			processCaseResult(subCaseResult);
		}
	}

	public static void processClaimResult(ClaimResult claimResult) {
		System.out.println("claim result=" + claimResult);

		for (VerificationActivityResult verificationResult : claimResult.getVerificationActivityResult()) {
			processVerificationResult(verificationResult);
		}

		for (ClaimResult subClaimResult : claimResult.getSubClaimResult()) {
			processClaimResult(subClaimResult);
		}
	}

	public static void processVerificationResult(VerificationActivityResult verificationActivityResult) {
		VerificationActivity verificationActivity = verificationActivityResult.getTarget();

		for (AssumptionResult assumptionResult : verificationActivityResult.getAssumptionResult()) {
			processAssumptionResult(assumptionResult);
		}

		for (PreconditionResult preResult : verificationActivityResult.getPreconditionResult()) {
			processPreconditionResult(preResult);
		}
		if (verificationActivity != null) {

			VerificationMethod method = verificationActivityResult.getTarget().getMethod();
			System.out.println("verification method=" + method.getName());
			if (method.getMethodType() == SupportedTypes.SINGLEPREDICATE) {
				System.out.println("title=" + method.getTitle());
				System.out.println("method=" + method.getMethod());
				String methodpath = method.getMethod();
				String className = methodpath.substring(0, methodpath.lastIndexOf("."));
				String methodName = methodpath.substring(methodpath.lastIndexOf(".") + 1, methodpath.length());
				Object[] args;
				args = new Object[0];
				try {
					AlisaLoader.alisaInvoke("testresourcebudget.JulienTest", "juliensimple", args);
					args = new Object[1];
					CaseResult cr = AssureUtilExtension.getEnclosingCaseResult(verificationActivityResult);
					InstanceObject obj = cr.getInstanceURI();
					args[0] = (ComponentInstance) obj;
					AlisaLoader.alisaInvoke("testresourcebudget.JulienTest", "julien", args);
					args[0] = (ComponentInstance) obj;
					AlisaLoader.alisaInvoke(className, methodName, args);
				} catch (AssertionFailedError e) {
					addFailure(verificationActivityResult, e);
				} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
					throw e;
				} catch (Throwable e) {
					addError(verificationActivityResult, e);
				}

			}
		}

	}

	public static void processHazardResult(HazardResult hazardResult) {
		System.out.println("hazard result=" + hazardResult);

//		for (VerificationActivityResult verificationResult : hazardResult.getVerificationActivityResult()) {
//			processVerificationResult(verificationResult);
//		}
//
//		for (ClaimResult subClaimResult : hazardResult.getSubClaimResult()) {
//			processClaimResult(subClaimResult);
//		}
	}

	public static void processAssumptionResult(AssumptionResult assumptionResult) {
		System.out.println("assumption result=" + assumptionResult);

//		for (VerificationActivityResult verificationResult : hazardResult.getVerificationActivityResult()) {
//			processVerificationResult(verificationResult);
//		}
//
//		for (ClaimResult subClaimResult : hazardResult.getSubClaimResult()) {
//			processClaimResult(subClaimResult);
//		}
	}

	public static void processPreconditionResult(PreconditionResult preconditionResult) {
		System.out.println("precondition result=" + preconditionResult);

//		for (VerificationActivityResult verificationResult : hazardResult.getVerificationActivityResult()) {
//			processVerificationResult(verificationResult);
//		}
//
//		for (ClaimResult subClaimResult : hazardResult.getSubClaimResult()) {
//			processClaimResult(subClaimResult);
//		}
	}

	public static void addFailure(VerificationActivityResult var, Throwable e) {
		String msg = e.getMessage();
		VerificationResult res = AssureFactory.eINSTANCE.createVerificationResult();
		res.setResultState(VerificationResultState.FAIL);
		res.setFailMsg(msg);
		res.setType(e.getClass().getName());
		var.setResult(res);
	}

	public static void addError(VerificationActivityResult var, Throwable e) {
		String msg = e.getMessage();
		VerificationResult res = AssureFactory.eINSTANCE.createVerificationResult();
		res.setResultState(VerificationResultState.UNKNOWN);
		res.setFailMsg(msg);
		res.setType(e.getClass().getName());
		var.setResult(res);
	}

}
