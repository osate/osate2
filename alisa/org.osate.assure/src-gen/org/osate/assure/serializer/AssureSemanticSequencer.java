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
import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.IntegerTerm;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.MultiLineString;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.RealTerm;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.StringTerm;
import org.osate.alisa.common.common.TextElement;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.services.AssureGrammarAccess;

@SuppressWarnings("all")
public class AssureSemanticSequencer extends CommonSemanticSequencer {

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
			case AssurePackage.ASSUMPTION_RESULT:
				if(context == grammarAccess.getAssumptionResultRule() ||
				   context == grammarAccess.getAssureResultRule()) {
					sequence_AssumptionResult(context, (AssumptionResult) semanticObject); 
					return; 
				}
				else break;
			case AssurePackage.CASE_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getCaseResultRule()) {
					sequence_CaseResult(context, (CaseResult) semanticObject); 
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
			case AssurePackage.VERIFICATION_ACTIVITY_RESULT:
				if(context == grammarAccess.getAssureResultRule() ||
				   context == grammarAccess.getVerificationActivityResultRule() ||
				   context == grammarAccess.getVerificationExprRule()) {
					sequence_VerificationActivityResult(context, (VerificationActivityResult) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CommonPackage.CONSTANT_DECL:
				if(context == grammarAccess.getConstantDeclRule()) {
					sequence_ConstantDecl(context, (ConstantDecl) semanticObject); 
					return; 
				}
				else break;
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
			case CommonPackage.INTEGER_TERM:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getIntegerTermRule()) {
					sequence_IntegerTerm(context, (IntegerTerm) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.MULTI_LINE_STRING:
				if(context == grammarAccess.getMultiLineStringRule()) {
					sequence_MultiLineString(context, (MultiLineString) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.PREDICATE_EXPRESSION:
				if(context == grammarAccess.getPredicateExpressionRule()) {
					sequence_PredicateExpression(context, (PredicateExpression) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.REAL_TERM:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getRealTermRule()) {
					sequence_RealTerm(context, (RealTerm) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.REFERENCE_PATH:
				if(context == grammarAccess.getReferencePathRule()) {
					sequence_ReferencePath(context, (ReferencePath) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.SHOW_VALUE:
				if(context == grammarAccess.getShowValueRule()) {
					sequence_ShowValue(context, (ShowValue) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.STRING_TERM:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getStringTermRule()) {
					sequence_StringTerm(context, (StringTerm) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.TEXT_ELEMENT:
				if(context == grammarAccess.getTextElementRule()) {
					sequence_TextElement(context, (TextElement) semanticObject); 
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
	 *         errorCount=INT? 
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
	 *         target=[VerificationAssumption|QualifiedName] 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         errorCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         verificationActivityResult+=VerificationExpr*
	 *     )
	 */
	protected void sequence_AssumptionResult(EObject context, AssumptionResult semanticObject) {
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
	 *         errorCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         subCaseResult+=CaseResult* 
	 *         claimResult+=ClaimResult*
	 *     )
	 */
	protected void sequence_CaseResult(EObject context, CaseResult semanticObject) {
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
	 *         errorCount=INT? 
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
	 *         didFailThenFail?='failthenfailed'? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         errorCount=INT? 
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
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         errorCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         verificationActivityResult+=VerificationExpr*
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
	 *         target=[VerificationActivity|QualifiedName] 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         successCount=INT? 
	 *         failCount=INT? 
	 *         errorCount=INT? 
	 *         failthenCount=INT? 
	 *         andthenCount=INT? 
	 *         tbdCount=INT? 
	 *         weight=INT? 
	 *         message=STRING? 
	 *         assumptionResult+=AssumptionResult* 
	 *         preconditionResult+=PreconditionResult*
	 *     )
	 */
	protected void sequence_VerificationActivityResult(EObject context, VerificationActivityResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
