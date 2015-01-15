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
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.FinalValue;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.common.ResultIssue;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.HazardResult;
import org.osate.assure.assure.IfThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.services.AssureGrammarAccess;

@SuppressWarnings("all")
public class AssureSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private AssureGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AssurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssurePackage.ASSUMPTION_RESULT:
				if(context == grammarAccess.getAssumptionResultRule() ||
				   context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getEvidenceResultRule()) {
					sequence_AssumptionResult(context, (AssumptionResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.CASE_RESULT:
				if(context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getCaseResultRule()) {
					sequence_CaseResult(context, (CaseResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.CLAIM_RESULT:
				if(context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getClaimResultRule()) {
					sequence_ClaimResult(context, (ClaimResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.FAIL_THEN_RESULT:
				if(context == grammarAccess.getVerificationExprRule()) {
					sequence_VerificationExpr(context, (FailThenResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.HAZARD_RESULT:
				if(context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getHazardResultRule()) {
					sequence_HazardResult(context, (HazardResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.IF_THEN_RESULT:
				if(context == grammarAccess.getVerificationExprRule()) {
					sequence_VerificationExpr(context, (IfThenResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.PRECONDITION_RESULT:
				if(context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getEvidenceResultRule() ||
				   context == grammarAccess.getPreconditionResultRule()) {
					sequence_PreconditionResult(context, (PreconditionResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.VERIFICATION_RESULT:
				if(context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getEvidenceResultRule() ||
				   context == grammarAccess.getVerificationExprRule() ||
				   context == grammarAccess.getVerificationResultRule()) {
					sequence_VerificationResult(context, (VerificationResult) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CommonPackage.DESCRIPTION:
				if(context == grammarAccess.getDescriptionRule()) {
					sequence_Description(context, (Description) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.DESCRIPTION_ELEMENT:
				if(context == grammarAccess.getDescriptionElementRule()) {
					sequence_DescriptionElement(context, (DescriptionElement) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.FINAL_VALUE:
				if(context == grammarAccess.getFinalValueRule()) {
					sequence_FinalValue(context, (FinalValue) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.PREDICATE_EXPRESSION:
				if(context == grammarAccess.getPredicateExpressionRule()) {
					sequence_PredicateExpression(context, (PredicateExpression) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.REFERENCE_PATH:
				if(context == grammarAccess.getReferencePathRule()) {
					sequence_ReferencePath(context, (ReferencePath) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.RESULT_ISSUE:
				if(context == grammarAccess.getResultIssueRule()) {
					sequence_ResultIssue(context, (ResultIssue) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         verificationActivity=[VerificationAssumption|QualifiedName] 
	 *         state=VerificationResultState? 
	 *         status=VerificationResultStatus? 
	 *         weight=INT? 
	 *         sucessMsg=MultiLineString? 
	 *         failMsg=MultiLineString?
	 *     )
	 */
	protected void sequence_AssumptionResult(EObject context, AssumptionResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         system=[Classifier|AadlClassifierReference]? 
	 *         target=[InstanceObject|URIID]? 
	 *         passCount=INT 
	 *         failCount=INT 
	 *         neutralCount=INT 
	 *         unknownCount=INT 
	 *         weight=INT? 
	 *         sucessMsg=MultiLineString? 
	 *         failMsg=MultiLineString? 
	 *         subCaseResult+=CaseResult* 
	 *         claimResult+=ClaimResult* 
	 *         hazardResult+=HazardResult*
	 *     )
	 */
	protected void sequence_CaseResult(EObject context, CaseResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         requirement=[Requirement|QualifiedName] 
	 *         successCount=INT 
	 *         failCount=INT 
	 *         neutralCount=INT 
	 *         unknownCount=INT 
	 *         weight=INT? 
	 *         sucessMsg=MultiLineString? 
	 *         failMsg=MultiLineString? 
	 *         subClaimResult+=ClaimResult* 
	 *         verificationResult+=VerificationExpr*
	 *     )
	 */
	protected void sequence_ClaimResult(EObject context, ClaimResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         hazard=[Hazard|QualifiedName] 
	 *         target=[InstanceObject|URIID]? 
	 *         passCount=INT 
	 *         failCount=INT 
	 *         neutralCount=INT 
	 *         unknownCount=INT 
	 *         weight=INT? 
	 *         verificationResult+=VerificationResult*
	 *     )
	 */
	protected void sequence_HazardResult(EObject context, HazardResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         verificationActivity=[VerificationPrecondition|QualifiedName] 
	 *         state=VerificationResultState? 
	 *         status=VerificationResultStatus? 
	 *         weight=INT? 
	 *         sucessMsg=MultiLineString? 
	 *         failMsg=MultiLineString?
	 *     )
	 */
	protected void sequence_PreconditionResult(EObject context, PreconditionResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (first+=VerificationResult second+=VerificationResult)
	 */
	protected void sequence_VerificationExpr(EObject context, FailThenResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (first+=VerificationResult second+=VerificationResult)
	 */
	protected void sequence_VerificationExpr(EObject context, IfThenResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         verificationActivity=[VerificationActivity|QualifiedName] 
	 *         state=VerificationResultState? 
	 *         status=VerificationResultStatus? 
	 *         weight=INT? 
	 *         sucessMsg=MultiLineString? 
	 *         failMsg=MultiLineString? 
	 *         assumptionResult+=AssumptionResult* 
	 *         preconditionResult+=PreconditionResult*
	 *     )
	 */
	protected void sequence_VerificationResult(EObject context, VerificationResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
