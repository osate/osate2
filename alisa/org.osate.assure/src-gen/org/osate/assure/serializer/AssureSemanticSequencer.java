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
package org.osate.assure.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.assure.assure.AssuranceCase;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.services.AssureGrammarAccess;
import org.osate.results.results.IssueReport;
import org.osate.results.results.ResultContributor;
import org.osate.results.results.ResultData;
import org.osate.results.results.ResultIssue;
import org.osate.results.results.ResultReport;
import org.osate.results.results.ResultReportCollection;
import org.osate.results.results.ResultsPackage;
import org.osate.results.serializer.ResultsSemanticSequencer;

@SuppressWarnings("all")
public class AssureSemanticSequencer extends ResultsSemanticSequencer {

	@Inject
	private AssureGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AssurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssurePackage.ASSURANCE_CASE:
				sequence_AssuranceCase(context, (AssuranceCase) semanticObject); 
				return; 
			case AssurePackage.CLAIM_RESULT:
				sequence_ClaimResult(context, (ClaimResult) semanticObject); 
				return; 
			case AssurePackage.ELSE_RESULT:
				sequence_ElseResult(context, (ElseResult) semanticObject); 
				return; 
			case AssurePackage.METRICS:
				sequence_Metrics(context, (Metrics) semanticObject); 
				return; 
			case AssurePackage.PRECONDITION_RESULT:
				sequence_PreconditionResult(context, (PreconditionResult) semanticObject); 
				return; 
			case AssurePackage.THEN_RESULT:
				sequence_ThenResult(context, (ThenResult) semanticObject); 
				return; 
			case AssurePackage.VALIDATION_RESULT:
				sequence_ValidationResult(context, (ValidationResult) semanticObject); 
				return; 
			case AssurePackage.VERIFICATION_ACTIVITY_RESULT:
				sequence_VerificationActivityResult(context, (VerificationActivityResult) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == ResultsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ResultsPackage.ISSUE_REPORT:
				sequence_IssueReport(context, (IssueReport) semanticObject); 
				return; 
			case ResultsPackage.RESULT_CONTRIBUTOR:
				sequence_ResultContributor(context, (ResultContributor) semanticObject); 
				return; 
			case ResultsPackage.RESULT_DATA:
				sequence_ResultData(context, (ResultData) semanticObject); 
				return; 
			case ResultsPackage.RESULT_ISSUE:
				sequence_ResultIssue(context, (ResultIssue) semanticObject); 
				return; 
			case ResultsPackage.RESULT_REPORT:
				sequence_ResultReport(context, (ResultReport) semanticObject); 
				return; 
			case ResultsPackage.RESULT_REPORT_COLLECTION:
				sequence_ResultReportCollection(context, (ResultReportCollection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         target=[AssurancePlan|QualifiedName]? 
	 *         targetSystem=ID? 
	 *         metrics=Metrics 
	 *         message=STRING? 
	 *         claimResult+=ClaimResult* 
	 *         subAssuranceCase+=AssuranceCase*
	 *     )
	 */
	protected void sequence_AssuranceCase(EObject context, AssuranceCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=[Requirement|QualifiedName] metrics=Metrics message=STRING? subClaimResult+=ClaimResult* verificationActivityResult+=VerificationExpr*)
	 */
	protected void sequence_ClaimResult(EObject context, ClaimResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         first+=VerificationExpr+ 
	 *         error+=VerificationExpr* 
	 *         fail+=VerificationExpr* 
	 *         timeout+=VerificationExpr* 
	 *         didFail=ElseType? 
	 *         metrics=Metrics
	 *     )
	 */
	protected void sequence_ElseResult(EObject context, ElseResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         tbdCount=INT? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         timeoutCount=INT? 
	 *         errorCount=INT? 
	 *         didelseCount=INT? 
	 *         thenskipCount=INT? 
	 *         preconditionfailCount=INT? 
	 *         validationfailCount=INT? 
	 *         weight=INT?
	 *     )
	 */
	protected void sequence_Metrics(EObject context, Metrics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         target=[VerificationMethod|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         metrics=Metrics 
	 *         message=STRING?
	 *     )
	 */
	protected void sequence_PreconditionResult(EObject context, PreconditionResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (first+=VerificationExpr+ second+=VerificationExpr+ didThenFail?='thenfailed'? metrics=Metrics)
	 */
	protected void sequence_ThenResult(EObject context, ThenResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         target=[VerificationMethod|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         metrics=Metrics 
	 *         message=STRING?
	 *     )
	 */
	protected void sequence_ValidationResult(EObject context, ValidationResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         target=[VerificationActivity|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         metrics=Metrics 
	 *         message=STRING? 
	 *         preconditionResult=PreconditionResult? 
	 *         validationResult=ValidationResult?
	 *     )
	 */
	protected void sequence_VerificationActivityResult(EObject context, VerificationActivityResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
