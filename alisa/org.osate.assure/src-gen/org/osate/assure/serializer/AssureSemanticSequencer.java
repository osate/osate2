package org.osate.assure.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.assure.assure.AggregateResultData;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.services.AssureGrammarAccess;

@SuppressWarnings("all")
public class AssureSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AssureGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AssurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssurePackage.AGGREGATE_RESULT_DATA:
				if(context == grammarAccess.getAggregateResultDataRule()) {
					sequence_AggregateResultData(context, (AggregateResultData) semanticObject); 
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
			case AssurePackage.VERIFICATION_RESULT:
				if(context == grammarAccess.getAssuranceResultRule() ||
				   context == grammarAccess.getVerificationResultRule()) {
					sequence_VerificationResult(context, (VerificationResult) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (passCount=INT failCount=INT neutralCount=INT unknownCount=INT)
	 */
	protected void sequence_AggregateResultData(EObject context, AggregateResultData semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__PASS_COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__PASS_COUNT));
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__FAIL_COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__FAIL_COUNT));
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT));
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAggregateResultDataAccess().getPassCountINTTerminalRuleCall_0_1_0(), semanticObject.getPassCount());
		feeder.accept(grammarAccess.getAggregateResultDataAccess().getFailCountINTTerminalRuleCall_1_1_0(), semanticObject.getFailCount());
		feeder.accept(grammarAccess.getAggregateResultDataAccess().getNeutralCountINTTerminalRuleCall_2_1_0(), semanticObject.getNeutralCount());
		feeder.accept(grammarAccess.getAggregateResultDataAccess().getUnknownCountINTTerminalRuleCall_3_1_0(), semanticObject.getUnknownCount());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID target=[InstanceObject|ID] result=AggregateResultData? subCaseResult+=CaseResult* claimResult+=ClaimResult*)
	 */
	protected void sequence_CaseResult(EObject context, CaseResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         requirement=[Requirement|ID] 
	 *         target=[InstanceObject|ID] 
	 *         result=AggregateResultData? 
	 *         subClaimResult+=ClaimResult* 
	 *         verificationResult+=VerificationResult*
	 *     )
	 */
	protected void sequence_ClaimResult(EObject context, ClaimResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         verificationActivity=[VerificationActivity|ID] 
	 *         target=[InstanceObject|ID] 
	 *         title=STRING? 
	 *         description=STRING? 
	 *         date=STRING? 
	 *         state=VerificationResultState? 
	 *         status=VerificationResultStatus? 
	 *         assumptionVerificationResult+=VerificationResult*
	 *     )
	 */
	protected void sequence_VerificationResult(EObject context, VerificationResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
