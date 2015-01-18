package org.osate.assure.ui.handlers;

import org.osate.alisa.workbench.ui.utils.AlisaLoader;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

public class AssureProcessing {
	public static void processCaseResult(CaseResult caseResult) {
		System.out.println("case result=" + caseResult);

		for (ClaimResult claimResult : caseResult.getClaimResult()) {
			processClaimResult(claimResult);
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
		if (verificationActivity != null) {

			VerificationMethod method = verificationActivityResult.getTarget().getMethod();
			System.out.println("verification method=" + method);
			if (method.getMethodType() == SupportedTypes.SINGLEPREDICATE) {
				System.out.println("title=" + method.getTitle());
				System.out.println("method=" + method.getMethod());
				String className = "testresourcebudget.JulienTest";
				String methodName = "juliensimple";
				Object[] args;
				args = new Object[0];
				AlisaLoader.alisaInvoke("testresourcebudget.JulienTest", "juliensimple", args);

			}
		}

	}

}
