package org.osate.assure.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.services.AssureGrammarAccess;

@SuppressWarnings("all")
public class AssureSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AssureGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AssurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssurePackage.AND_THEN_RESULT:
				if(context == grammarAccess.getAndThenResultRule() ||
				   context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getVerificationExprRule()) {
					sequence_AndThenResult(context, (AndThenResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.ASSURANCE_EVIDENCE:
				if(context == grammarAccess.getAssuranceEvidenceRule() ||
				   context == grammarAccess.getAssureResultRule()) {
					sequence_AssuranceEvidence(context, (AssuranceEvidence) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.CLAIM_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getClaimResultRule()) {
					sequence_ClaimResult(context, (ClaimResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.FAIL_THEN_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getFailThenResultRule() ||
				   context == grammarAccess.getVerificationExprRule()) {
					sequence_FailThenResult(context, (FailThenResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.PRECONDITION_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getPreconditionResultRule()) {
					sequence_PreconditionResult(context, (PreconditionResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.RESULT_ISSUE:
				if(context == grammarAccess.getResultIssueRule()) {
					sequence_ResultIssue(context, (ResultIssue) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.VALIDATION_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getValidationResultRule()) {
					sequence_ValidationResult(context, (ValidationResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.VERIFICATION_ACTIVITY_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getVerificationActivityResultRule() ||
				   context == grammarAccess.getVerificationExprRule()) {
					sequence_VerificationActivityResult(context, (VerificationActivityResult) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         first+=VerificationExpr 
	 *         second+=VerificationExpr 
	 *         didAndThenFail?='andthenfailed'? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT?
	 *     )
	 */
	protected void sequence_AndThenResult(EObject context, AndThenResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[Classifier|AadlClassifierReference] 
	 *         instance=[InstanceObject|URIID] 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         subAssuranceEvidence+=AssuranceEvidence* 
	 *         claimResult+=ClaimResult*
	 *     )
	 */
	protected void sequence_AssuranceEvidence(EObject context, AssuranceEvidence semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[Requirement|QualifiedName] 
	 *         instance=[InstanceObject|URIID]? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         subClaimResult+=ClaimResult* 
	 *         verificationActivityResult+=VerificationExpr*
	 *     )
	 */
	protected void sequence_ClaimResult(EObject context, ClaimResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         first+=VerificationExpr 
	 *         second+=VerificationExpr 
	 *         failThen?='failthen'? 
	 *         unknownThen?='unknownthen'? 
	 *         didFail?='didfail'? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT?
	 *     )
	 */
	protected void sequence_FailThenResult(EObject context, FailThenResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[VerificationPrecondition|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING?
	 *     )
	 */
	protected void sequence_PreconditionResult(EObject context, PreconditionResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         issueType=ResultIssueType 
	 *         name=ID? 
	 *         message=STRING 
	 *         exceptionType=STRING? 
	 *         target=[EObject|URIID]? 
	 *         issues+=ResultIssue*
	 *     )
	 */
	protected void sequence_ResultIssue(EObject context, ResultIssue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[VerificationValidation|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING?
	 *     )
	 */
	protected void sequence_ValidationResult(EObject context, ValidationResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[VerificationActivity|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         unknownCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         validationResult+=ValidationResult* 
	 *         preconditionResult+=PreconditionResult*
	 *     )
	 */
	protected void sequence_VerificationActivityResult(EObject context, VerificationActivityResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
