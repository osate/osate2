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
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.verify.services.VerifyGrammarAccess;
import org.osate.verify.verify.ArgumentReference;
import org.osate.verify.verify.AssurancePlan;
import org.osate.verify.verify.BinaryExpr;
import org.osate.verify.verify.RSALContainer;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationAssumption;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

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
			case CommonPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.REFERENCE_PATH:
				if(context == grammarAccess.getReferencePathRule()) {
					sequence_ReferencePath(context, (ReferencePath) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == VerifyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case VerifyPackage.ARGUMENT_REFERENCE:
				if(context == grammarAccess.getArgumentReferenceRule()) {
					sequence_ArgumentReference(context, (ArgumentReference) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.ASSURANCE_PLAN:
				if(context == grammarAccess.getAssurancePlanRule()) {
					sequence_AssurancePlan(context, (AssurancePlan) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.BINARY_EXPR:
				if(context == grammarAccess.getAndExprRule() ||
				   context == grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArgumentExprRule() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getImpliesExprRule() ||
				   context == grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getOrExprRule() ||
				   context == grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0()) {
					sequence_AndExpr_ImpliesExpr_OrExpr(context, (BinaryExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.RSAL_CONTAINER:
				if(context == grammarAccess.getRSALContainerRule()) {
					sequence_RSALContainer(context, (RSALContainer) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.REF_EXPR:
				if(context == grammarAccess.getAndExprRule() ||
				   context == grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getArgumentExprRule() ||
				   context == grammarAccess.getAtomicExprRule() ||
				   context == grammarAccess.getImpliesExprRule() ||
				   context == grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getOrExprRule() ||
				   context == grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0()) {
					sequence_AtomicExpr(context, (RefExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_ACTIVITY:
				if(context == grammarAccess.getVerificationActivityRule()) {
					sequence_VerificationActivity(context, (VerificationActivity) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_ASSUMPTION:
				if(context == grammarAccess.getVerificationAssumptionRule()) {
					sequence_VerificationAssumption(context, (VerificationAssumption) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.VERIFICATION_METHOD:
				if(context == grammarAccess.getVerificationMethodRule()) {
					sequence_VerificationMethod(context, (VerificationMethod) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (left=OrExpr_BinaryExpr_1_0_0_0 op='or' right=AndExpr) | 
	 *         (left=AndExpr_BinaryExpr_1_0_0_0 op='and' right=AtomicExpr) | 
	 *         (left=ImpliesExpr_BinaryExpr_1_0_0_0 op='=>' right=ImpliesExpr)
	 *     )
	 */
	protected void sequence_AndExpr_ImpliesExpr_OrExpr(EObject context, BinaryExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (reference=[VerificationActivity|DOTTEDREF] weight=INT?)
	 */
	protected void sequence_ArgumentReference(EObject context, ArgumentReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID expression=ArgumentExpr rationale=ValueString?)
	 */
	protected void sequence_AssurancePlan(EObject context, AssurancePlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=ArgumentReference
	 */
	protected void sequence_AtomicExpr(EObject context, RefExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.REF_EXPR__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.REF_EXPR__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAtomicExprAccess().getIdArgumentReferenceParserRuleCall_0_1_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID target=[Requirement|DOTTEDREF]? (content+=VerificationActivity | content+=VerificationMethod | content+=RSALContainer)*)
	 */
	protected void sequence_RSALContainer(EObject context, RSALContainer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         description=ValueString? 
	 *         category=[VerificationCategory|DOTTEDREF]? 
	 *         method=VerificationMethod? 
	 *         assumption+=VerificationAssumption*
	 *     )
	 */
	protected void sequence_VerificationActivity(EObject context, VerificationActivity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         description=Description? 
	 *         assert=[Requirement|DOTTEDREF]? 
	 *         verifiedBy=[AssurancePlan|DOTTEDREF]? 
	 *         rationale=ValueString? 
	 *         (issue+=ValueString issue+=ValueString*)?
	 *     )
	 */
	protected void sequence_VerificationAssumption(EObject context, VerificationAssumption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         language=SupportedLanguage 
	 *         method=ValueString 
	 *         title=ValueString? 
	 *         description=ValueString? 
	 *         category=[VerificationCategory|CATREF]?
	 *     )
	 */
	protected void sequence_VerificationMethod(EObject context, VerificationMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
