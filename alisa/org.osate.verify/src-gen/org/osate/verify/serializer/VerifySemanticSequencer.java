package org.osate.verify.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.FinalValue;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.MultiLineString;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.common.TextElement;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.verify.services.VerifyGrammarAccess;
import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.AndThenExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.FailThenExpr;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationAssumption;
import org.osate.verify.verify.VerificationFolder;
import org.osate.verify.verify.VerificationLibrary;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationMethodRegistry;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerificationPrecondition;
import org.osate.verify.verify.VerifyPackage;
import org.osate.verify.verify.WeightedClaim;
import org.osate.verify.verify.WhenExpr;

@SuppressWarnings("all")
public class VerifySemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private VerifyGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
			case CommonPackage.REFERENCE_PATH:
				if(context == grammarAccess.getReferencePathRule()) {
					sequence_ReferencePath(context, (ReferencePath) semanticObject); 
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
		else if(semanticObject.eClass().getEPackage() == VerifyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case VerifyPackage.ALL_EXPR:
				if(context == grammarAccess.getAllEvidenceExprRule() ||
				   context == grammarAccess.getAndThenEvidenceExprRule() ||
				   context == grammarAccess.getAndThenEvidenceExprAccess().getAndThenExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArgumentExprRule() ||
				   context == grammarAccess.getAtomicEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprAccess().getFailThenExprLeftAction_1_0_0_0()) {
					sequence_AllEvidenceExpr(context, (AllExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.AND_THEN_EXPR:
				if(context == grammarAccess.getAndThenEvidenceExprRule() ||
				   context == grammarAccess.getAndThenEvidenceExprAccess().getAndThenExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAtomicEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprAccess().getFailThenExprLeftAction_1_0_0_0()) {
					sequence_AndThenEvidenceExpr(context, (AndThenExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.CLAIM:
				if(context == grammarAccess.getClaimRule()) {
					sequence_Claim(context, (Claim) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.FAIL_THEN_EXPR:
				if(context == grammarAccess.getAndThenEvidenceExprRule() ||
				   context == grammarAccess.getAndThenEvidenceExprAccess().getAndThenExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAtomicEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprAccess().getFailThenExprLeftAction_1_0_0_0()) {
					sequence_FailThenEvidenceExpr(context, (FailThenExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.REF_EXPR:
				if(context == grammarAccess.getAndThenEvidenceExprRule() ||
				   context == grammarAccess.getAndThenEvidenceExprAccess().getAndThenExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAtomicEvidenceExprRule() ||
				   context == grammarAccess.getConditionalEvidenceRule() ||
				   context == grammarAccess.getConditionalEvidenceAccess().getWhenExprVerificationAction_1_0_0_0() ||
				   context == grammarAccess.getFailThenEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprAccess().getFailThenExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getVAReferenceRule()) {
					sequence_VAReference(context, (RefExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION:
				if(context == grammarAccess.getVerificationRule()) {
					sequence_Verification(context, (Verification) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_ACTIVITY:
				if(context == grammarAccess.getVerificationActionRule() ||
				   context == grammarAccess.getVerificationActivityRule()) {
					sequence_VerificationActivity(context, (VerificationActivity) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_ASSUMPTION:
				if(context == grammarAccess.getVerificationConditionRule()) {
					sequence_VerificationCondition(context, (VerificationAssumption) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_FOLDER:
				if(context == grammarAccess.getVerificationContainerRule() ||
				   context == grammarAccess.getVerificationFolderRule()) {
					sequence_VerificationFolder(context, (VerificationFolder) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_LIBRARY:
				if(context == grammarAccess.getVerificationContainerRule() ||
				   context == grammarAccess.getVerificationLibraryRule()) {
					sequence_VerificationLibrary(context, (VerificationLibrary) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_METHOD:
				if(context == grammarAccess.getVerificationActionRule() ||
				   context == grammarAccess.getVerificationMethodRule()) {
					sequence_VerificationMethod(context, (VerificationMethod) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_METHOD_REGISTRY:
				if(context == grammarAccess.getVerificationMethodRegistryRule()) {
					sequence_VerificationMethodRegistry(context, (VerificationMethodRegistry) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_PLAN:
				if(context == grammarAccess.getVerificationPlanRule()) {
					sequence_VerificationPlan(context, (VerificationPlan) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_PRECONDITION:
				if(context == grammarAccess.getVerificationConditionRule()) {
					sequence_VerificationCondition(context, (VerificationPrecondition) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.WEIGHTED_CLAIM:
				if(context == grammarAccess.getWeightedClaimRule()) {
					sequence_WeightedClaim(context, (WeightedClaim) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.WHEN_EXPR:
				if(context == grammarAccess.getAndThenEvidenceExprRule() ||
				   context == grammarAccess.getAndThenEvidenceExprAccess().getAndThenExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAtomicEvidenceExprRule() ||
				   context == grammarAccess.getConditionalEvidenceRule() ||
				   context == grammarAccess.getFailThenEvidenceExprRule() ||
				   context == grammarAccess.getFailThenEvidenceExprAccess().getFailThenExprLeftAction_1_0_0_0()) {
					sequence_ConditionalEvidence(context, (WhenExpr) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (all+=AndThenEvidenceExpr all+=AndThenEvidenceExpr*)
	 */
	protected void sequence_AllEvidenceExpr(EObject context, AllExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AndThenEvidenceExpr_AndThenExpr_1_0_0_0 right=AndThenEvidenceExpr)
	 */
	protected void sequence_AndThenEvidenceExpr(EObject context, AndThenExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.AND_THEN_EXPR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.AND_THEN_EXPR__LEFT));
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.AND_THEN_EXPR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.AND_THEN_EXPR__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAndThenEvidenceExprAccess().getAndThenExprLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndThenEvidenceExprAccess().getRightAndThenEvidenceExprParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         requirement=[Requirement|QualifiedName] 
	 *         assert=ArgumentExpr 
	 *         rationale=STRING? 
	 *         subclaim+=Claim*
	 *     )
	 */
	protected void sequence_Claim(EObject context, Claim semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (verification=ConditionalEvidence_WhenExpr_1_0_0_0 condition+=[VerificationCategory|CatRef]+)
	 */
	protected void sequence_ConditionalEvidence(EObject context, WhenExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=FailThenEvidenceExpr_FailThenExpr_1_0_0_0 right=FailThenEvidenceExpr)
	 */
	protected void sequence_FailThenEvidenceExpr(EObject context, FailThenExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.FAIL_THEN_EXPR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.FAIL_THEN_EXPR__LEFT));
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.FAIL_THEN_EXPR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.FAIL_THEN_EXPR__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFailThenEvidenceExprAccess().getFailThenExprLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getFailThenEvidenceExprAccess().getRightFailThenEvidenceExprParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (verification=[VerificationAction|QualifiedName] weight=INT?)
	 */
	protected void sequence_VAReference(EObject context, RefExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         requirement=[Requirement|QualifiedName]? 
	 *         description=Description? 
	 *         category+=[SelectionCategory|CatRef]* 
	 *         method=[VerificationMethod|QualifiedName]? 
	 *         timeout=INT? 
	 *         rationale=MultiLineString?
	 *     )
	 */
	protected void sequence_VerificationActivity(EObject context, VerificationActivity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID title=ValueString? description=Description? assert=ArgumentExpr? rationale=MultiLineString?)
	 */
	protected void sequence_VerificationCondition(EObject context, VerificationAssumption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID title=ValueString? description=Description? assert=ArgumentExpr? rationale=MultiLineString?)
	 */
	protected void sequence_VerificationCondition(EObject context, VerificationPrecondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID (content+=VerificationActivity | content+=VerificationFolder)*)
	 */
	protected void sequence_VerificationFolder(EObject context, VerificationFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         target=[ComponentClassifier|AadlClassifierReference]? 
	 *         description=Description? 
	 *         (content+=VerificationActivity | content+=VerificationFolder)*
	 *     )
	 */
	protected void sequence_VerificationLibrary(EObject context, VerificationLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID title=ValueString? description=Description? methods+=VerificationMethod*)
	 */
	protected void sequence_VerificationMethodRegistry(EObject context, VerificationMethodRegistry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         requirement=[Requirement|QualifiedName]? 
	 *         methodType=SupportedTypes 
	 *         methodPath=QualifiedName 
	 *         marker=ValueString? 
	 *         description=Description? 
	 *         category=[VerificationCategory|CatRef]? 
	 *         conditions+=VerificationCondition*
	 *     )
	 */
	protected void sequence_VerificationMethod(EObject context, VerificationMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         target=[ComponentClassifier|AadlClassifierReference] 
	 *         description=MultiLineString? 
	 *         claim+=Claim* 
	 *         weightedClaim+=WeightedClaim? 
	 *         rationale=MultiLineString? 
	 *         planAssumption+=[VerificationPlan|QualifiedName]*
	 *     )
	 */
	protected void sequence_VerificationPlan(EObject context, VerificationPlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (contents+=VerificationLibrary | contents+=VerificationPlan | contents+=VerificationMethodRegistry)
	 */
	protected void sequence_Verification(EObject context, Verification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (claim=[Claim|QualifiedName] weight=INT?)
	 */
	protected void sequence_WeightedClaim(EObject context, WeightedClaim semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
