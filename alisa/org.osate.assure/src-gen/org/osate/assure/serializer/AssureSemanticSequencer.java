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
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AConditional;
import org.osate.alisa.common.common.AFunctionCall;
import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.ARange;
import org.osate.alisa.common.common.AUnaryOperation;
import org.osate.alisa.common.common.AUnitExpression;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ImageReference;
import org.osate.alisa.common.common.ModelRef;
import org.osate.alisa.common.common.PropertyRef;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.ResultIssue;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.TypeRef;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.NestedClaimReference;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.PredicateResult;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.QualifiedVAReference;
import org.osate.assure.assure.SubsystemResult;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.services.AssureGrammarAccess;

@SuppressWarnings("all")
public class AssureSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private AssureGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Aadl2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.AADL_BOOLEAN:
				sequence_TypeRef(context, (AadlBoolean) semanticObject); 
				return; 
			case Aadl2Package.AADL_INTEGER:
				sequence_TypeRef(context, (AadlInteger) semanticObject); 
				return; 
			case Aadl2Package.AADL_REAL:
				sequence_TypeRef(context, (AadlReal) semanticObject); 
				return; 
			case Aadl2Package.AADL_STRING:
				sequence_TypeRef(context, (AadlString) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_ABooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_AIntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_ARealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == AssurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssurePackage.ASSURANCE_CASE_RESULT:
				sequence_AssuranceCaseResult(context, (AssuranceCaseResult) semanticObject); 
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
			case AssurePackage.MODEL_RESULT:
				sequence_ModelResult(context, (ModelResult) semanticObject); 
				return; 
			case AssurePackage.NESTED_CLAIM_REFERENCE:
				sequence_NestedClaimReference(context, (NestedClaimReference) semanticObject); 
				return; 
			case AssurePackage.PRECONDITION_RESULT:
				sequence_PreconditionResult(context, (PreconditionResult) semanticObject); 
				return; 
			case AssurePackage.PREDICATE_RESULT:
				sequence_PredicateResult(context, (PredicateResult) semanticObject); 
				return; 
			case AssurePackage.QUALIFIED_CLAIM_REFERENCE:
				sequence_QualifiedClaimReference(context, (QualifiedClaimReference) semanticObject); 
				return; 
			case AssurePackage.QUALIFIED_VA_REFERENCE:
				sequence_QualifiedVAReference(context, (QualifiedVAReference) semanticObject); 
				return; 
			case AssurePackage.SUBSYSTEM_RESULT:
				sequence_SubsystemResult(context, (SubsystemResult) semanticObject); 
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
		else if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CommonPackage.ABINARY_OPERATION:
				sequence_AAdditiveExpression_AAndExpression_AEqualityExpression_AMultiplicativeExpression_AOrExpression_ARelationalExpression(context, (ABinaryOperation) semanticObject); 
				return; 
			case CommonPackage.ACONDITIONAL:
				sequence_AIfExpression(context, (AConditional) semanticObject); 
				return; 
			case CommonPackage.AFUNCTION_CALL:
				sequence_AFunctionCall(context, (AFunctionCall) semanticObject); 
				return; 
			case CommonPackage.AMODEL_REFERENCE:
				sequence_AModelReference(context, (AModelReference) semanticObject); 
				return; 
			case CommonPackage.APROPERTY_REFERENCE:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAEqualityExpressionRule() ||
				   context == grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAExpressionRule() ||
				   context == grammarAccess.getAModelOrPropertyReferenceRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAParenthesizedExpressionRule() ||
				   context == grammarAccess.getAPrimaryExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAUnaryOperationRule() ||
				   context == grammarAccess.getAUnitExpressionRule() ||
				   context == grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()) {
					sequence_AModelOrPropertyReference_APropertyReference(context, (APropertyReference) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAPropertyReferenceRule()) {
					sequence_APropertyReference(context, (APropertyReference) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.ARANGE:
				sequence_ARangeExpression(context, (ARange) semanticObject); 
				return; 
			case CommonPackage.AUNARY_OPERATION:
				sequence_AUnaryOperation(context, (AUnaryOperation) semanticObject); 
				return; 
			case CommonPackage.AUNIT_EXPRESSION:
				sequence_AUnitExpression(context, (AUnitExpression) semanticObject); 
				return; 
			case CommonPackage.AVARIABLE_REFERENCE:
				sequence_AVariableReference(context, (AVariableReference) semanticObject); 
				return; 
			case CommonPackage.COMPUTE_DECLARATION:
				sequence_ComputeDeclaration(context, (ComputeDeclaration) semanticObject); 
				return; 
			case CommonPackage.DESCRIPTION:
				sequence_Description(context, (Description) semanticObject); 
				return; 
			case CommonPackage.DESCRIPTION_ELEMENT:
				sequence_DescriptionElement(context, (DescriptionElement) semanticObject); 
				return; 
			case CommonPackage.IMAGE_REFERENCE:
				sequence_ImageReference(context, (ImageReference) semanticObject); 
				return; 
			case CommonPackage.MODEL_REF:
				sequence_TypeRef(context, (ModelRef) semanticObject); 
				return; 
			case CommonPackage.PROPERTY_REF:
				sequence_PropertyRef(context, (PropertyRef) semanticObject); 
				return; 
			case CommonPackage.RATIONALE:
				sequence_Rationale(context, (Rationale) semanticObject); 
				return; 
			case CommonPackage.RESULT_ISSUE:
				sequence_ResultIssue(context, (ResultIssue) semanticObject); 
				return; 
			case CommonPackage.SHOW_VALUE:
				sequence_ShowValue(context, (ShowValue) semanticObject); 
				return; 
			case CommonPackage.TYPE_REF:
				sequence_TypeRef(context, (TypeRef) semanticObject); 
				return; 
			case CommonPackage.UNCERTAINTY:
				sequence_Uncertainty(context, (Uncertainty) semanticObject); 
				return; 
			case CommonPackage.VAL_DECLARATION:
				sequence_ValDeclaration(context, (ValDeclaration) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=QualifiedName metrics=Metrics message=STRING? modelResult+=ModelResult*)
	 */
	protected void sequence_AssuranceCaseResult(EObject context, AssuranceCaseResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         targetReference=QualifiedClaimReference 
	 *         metrics=Metrics 
	 *         modelElement=[NamedElement|ID]? 
	 *         message=STRING? 
	 *         subClaimResult+=ClaimResult* 
	 *         verificationActivityResult+=VerificationExpr* 
	 *         predicateResult=PredicateResult?
	 *     )
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
	 *         featuresCount=INT? 
	 *         featuresRequirementsCount=INT? 
	 *         qualityCategoryRequirementsCount=INT? 
	 *         totalQualityCategoryCount=INT? 
	 *         requirementsWithoutPlanClaimCount=INT? 
	 *         noVerificationPlansCount=INT? 
	 *         requirementsCount=INT? 
	 *         exceptionsCount=INT? 
	 *         reqTargetHasEMV2SubclauseCount=INT? 
	 *         featuresRequiringClassifierCount=INT? 
	 *         featuresWithRequiredClassifierCount=INT? 
	 *         weight=INT? 
	 *         executionTime=AInt?
	 *     )
	 */
	protected void sequence_Metrics(EObject context, Metrics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         plan=[AssurancePlan|QualifiedName] 
	 *         target=[ComponentImplementation|AadlClassifierReference] 
	 *         metrics=Metrics 
	 *         message=STRING? 
	 *         claimResult+=ClaimResult* 
	 *         (subsystemResult+=SubsystemResult | subAssuranceCase+=AssuranceCaseResult)*
	 *     )
	 */
	protected void sequence_ModelResult(EObject context, ModelResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (requirement=[Requirement|ID] sub=NestedClaimReference?)
	 */
	protected void sequence_NestedClaimReference(EObject context, NestedClaimReference semanticObject) {
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
	 *     (
	 *         targetReference=QualifiedClaimReference 
	 *         executionState=VerificationExecutionState 
	 *         resultState=VerificationResultState 
	 *         issues+=ResultIssue* 
	 *         resultReport=[ResultReport|QualifiedName]? 
	 *         metrics=Metrics 
	 *         message=STRING?
	 *     )
	 */
	protected void sequence_PredicateResult(EObject context, PredicateResult semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (verificationPlan=[VerificationPlan|QualifiedName] requirement=NestedClaimReference)
	 */
	protected void sequence_QualifiedClaimReference(EObject context, QualifiedClaimReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN));
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQualifiedClaimReferenceAccess().getVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1(), semanticObject.getVerificationPlan());
		feeder.accept(grammarAccess.getQualifiedClaimReferenceAccess().getRequirementNestedClaimReferenceParserRuleCall_2_0(), semanticObject.getRequirement());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (verificationPlan=[VerificationPlan|QualifiedName] requirement=NestedClaimReference verificationActivity=[VerificationActivity|ID])
	 */
	protected void sequence_QualifiedVAReference(EObject context, QualifiedVAReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN));
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT));
			if(transientValues.isValueTransient(semanticObject, AssurePackage.Literals.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssurePackage.Literals.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQualifiedVAReferenceAccess().getVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1(), semanticObject.getVerificationPlan());
		feeder.accept(grammarAccess.getQualifiedVAReferenceAccess().getRequirementNestedClaimReferenceParserRuleCall_2_0(), semanticObject.getRequirement());
		feeder.accept(grammarAccess.getQualifiedVAReferenceAccess().getVerificationActivityVerificationActivityIDTerminalRuleCall_4_0_1(), semanticObject.getVerificationActivity());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (targetSystem=[Subcomponent|ID] metrics=Metrics message=STRING? claimResult+=ClaimResult* subsystemResult+=SubsystemResult*)
	 */
	protected void sequence_SubsystemResult(EObject context, SubsystemResult semanticObject) {
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
	 *         targetReference=QualifiedVAReference 
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
