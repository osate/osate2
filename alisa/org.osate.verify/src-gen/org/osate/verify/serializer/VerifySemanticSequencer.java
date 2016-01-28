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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AListTerm;
import org.osate.alisa.common.common.ANullLiteral;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.ASetLiteral;
import org.osate.alisa.common.common.AUnaryOperation;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ImageReference;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.ResultIssue;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.verify.services.VerifyGrammarAccess;
import org.osate.verify.verify.AgreeMethod;
import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.ManualMethod;
import org.osate.verify.verify.PluginMethod;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.ResoluteMethod;
import org.osate.verify.verify.ThenExpr;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationMethodRegistry;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerificationPrecondition;
import org.osate.verify.verify.VerificationValidation;
import org.osate.verify.verify.VerifyPackage;

@SuppressWarnings("all")
public class VerifySemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private VerifyGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Aadl2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_ABooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_AIntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.RANGE_VALUE:
				sequence_ANumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_ARealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CommonPackage.ABINARY_OPERATION:
				sequence_AAdditiveExpression_AAndExpression_AEqualityExpression_AMultiplicativeExpression_AOrExpression_AOtherOperatorExpression_ARelationalExpression(context, (ABinaryOperation) semanticObject); 
				return; 
			case CommonPackage.ALIST_TERM:
				sequence_AListTerm(context, (AListTerm) semanticObject); 
				return; 
			case CommonPackage.ANULL_LITERAL:
				sequence_ANullLiteral(context, (ANullLiteral) semanticObject); 
				return; 
			case CommonPackage.APROPERTY_REFERENCE:
				sequence_APropertyReference(context, (APropertyReference) semanticObject); 
				return; 
			case CommonPackage.ASET_LITERAL:
				sequence_ASetTerm(context, (ASetLiteral) semanticObject); 
				return; 
			case CommonPackage.AUNARY_OPERATION:
				sequence_AUnaryOperation(context, (AUnaryOperation) semanticObject); 
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
			case CommonPackage.RATIONALE:
				sequence_Rationale(context, (Rationale) semanticObject); 
				return; 
			case CommonPackage.RESULT_ISSUE:
				sequence_ResultIssue(context, (ResultIssue) semanticObject); 
				return; 
			case CommonPackage.SHOW_VALUE:
				sequence_ShowValue(context, (ShowValue) semanticObject); 
				return; 
			case CommonPackage.UNCERTAINTY:
				sequence_Uncertainty(context, (Uncertainty) semanticObject); 
				return; 
			case CommonPackage.VAL_DECLARATION:
				sequence_ValDeclaration(context, (ValDeclaration) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == VerifyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case VerifyPackage.AGREE_METHOD:
				sequence_AgreeMethod(context, (AgreeMethod) semanticObject); 
				return; 
			case VerifyPackage.ALL_EXPR:
				sequence_QuantifiedEvidenceExpr(context, (AllExpr) semanticObject); 
				return; 
			case VerifyPackage.CLAIM:
				sequence_Claim(context, (Claim) semanticObject); 
				return; 
			case VerifyPackage.ELSE_EXPR:
				if(context == grammarAccess.getArgumentExprRule() ||
				   context == grammarAccess.getCompositeElseEvidenceExprRule() ||
				   context == grammarAccess.getCompositeElseEvidenceExprAccess().getElseExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getCompositeEvidenceExprRule() ||
				   context == grammarAccess.getElseEvidenceExprRule() ||
				   context == grammarAccess.getThenEvidenceExprRule() ||
				   context == grammarAccess.getThenEvidenceExprAccess().getThenExprLeftAction_1_0_0_0()) {
					sequence_CompositeElseEvidenceExpr_ElseEvidenceExpr_SingleElseEvidenceExpr(context, (ElseExpr) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSingleElseEvidenceExprRule() ||
				   context == grammarAccess.getSingleElseEvidenceExprAccess().getElseExprLeftAction_1_0_0_0()) {
					sequence_SingleElseEvidenceExpr(context, (ElseExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.FORMAL_PARAMETER:
				sequence_FormalParameter(context, (FormalParameter) semanticObject); 
				return; 
			case VerifyPackage.JAVA_METHOD:
				sequence_JavaMethod(context, (JavaMethod) semanticObject); 
				return; 
			case VerifyPackage.MANUAL_METHOD:
				sequence_ManualMethod(context, (ManualMethod) semanticObject); 
				return; 
			case VerifyPackage.PLUGIN_METHOD:
				sequence_PluginMethod(context, (PluginMethod) semanticObject); 
				return; 
			case VerifyPackage.REF_EXPR:
				sequence_VAReference(context, (RefExpr) semanticObject); 
				return; 
			case VerifyPackage.RESOLUTE_METHOD:
				sequence_ResoluteMethod(context, (ResoluteMethod) semanticObject); 
				return; 
			case VerifyPackage.THEN_EXPR:
				sequence_ThenEvidenceExpr(context, (ThenExpr) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION:
				sequence_Verification(context, (Verification) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION_ACTIVITY:
				sequence_VerificationActivity(context, (VerificationActivity) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION_METHOD:
				sequence_VerificationMethod(context, (VerificationMethod) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION_METHOD_REGISTRY:
				sequence_VerificationMethodRegistry(context, (VerificationMethodRegistry) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION_PLAN:
				sequence_VerificationPlan(context, (VerificationPlan) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION_PRECONDITION:
				sequence_VerificationPrecondition(context, (VerificationPrecondition) semanticObject); 
				return; 
			case VerifyPackage.VERIFICATION_VALIDATION:
				sequence_VerificationValidation(context, (VerificationValidation) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (singleLayer?='single' | all?='all')
	 */
	protected void sequence_AgreeMethod(EObject context, AgreeMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         requirement=[Requirement|QualifiedName]? 
	 *         title=STRING? 
	 *         activities+=VerificationActivity* 
	 *         assert=ArgumentExpr? 
	 *         rationale=Rationale? 
	 *         weight=INT? 
	 *         subclaim+=Claim* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_Claim(EObject context, Claim semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             left=SingleElseEvidenceExpr_ElseExpr_1_0_0_0 
	 *             (error=ElseEvidenceExpr | (fail=ThenEvidenceExpr? timeout=ThenEvidenceExpr? error=ThenEvidenceExpr?))
	 *         ) | 
	 *         (left=CompositeElseEvidenceExpr_ElseExpr_1_0_0_0 error=ElseEvidenceExpr)
	 *     )
	 */
	protected void sequence_CompositeElseEvidenceExpr_ElseEvidenceExpr_SingleElseEvidenceExpr(EObject context, ElseExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parameterType=ID name=ID unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_FormalParameter(EObject context, FormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     methodPath=QualifiedName
	 */
	protected void sequence_JavaMethod(EObject context, JavaMethod semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.JAVA_METHOD__METHOD_PATH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.JAVA_METHOD__METHOD_PATH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJavaMethodAccess().getMethodPathQualifiedNameParserRuleCall_1_0(), semanticObject.getMethodPath());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dialogID=QualifiedName
	 */
	protected void sequence_ManualMethod(EObject context, ManualMethod semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.MANUAL_METHOD__DIALOG_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.MANUAL_METHOD__DIALOG_ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getManualMethodAccess().getDialogIDQualifiedNameParserRuleCall_2_0(), semanticObject.getDialogID());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     methodID=ID
	 */
	protected void sequence_PluginMethod(EObject context, PluginMethod semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPluginMethodAccess().getMethodIDIDTerminalRuleCall_1_0(), semanticObject.getMethodID());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (elements+=ThenEvidenceExpr elements+=ThenEvidenceExpr*)
	 */
	protected void sequence_QuantifiedEvidenceExpr(EObject context, AllExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     methodReference=[FunctionDefinition|ID]
	 */
	protected void sequence_ResoluteMethod(EObject context, ResoluteMethod semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.RESOLUTE_METHOD__METHOD_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.RESOLUTE_METHOD__METHOD_REFERENCE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getResoluteMethodAccess().getMethodReferenceFunctionDefinitionIDTerminalRuleCall_1_0_1(), semanticObject.getMethodReference());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         left=SingleElseEvidenceExpr_ElseExpr_1_0_0_0 
	 *         (error=ElseEvidenceExpr | (fail=ThenEvidenceExpr? timeout=ThenEvidenceExpr? error=ThenEvidenceExpr?))
	 *     )
	 */
	protected void sequence_SingleElseEvidenceExpr(EObject context, ElseExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=ThenEvidenceExpr_ThenExpr_1_0_0_0 successor=ThenEvidenceExpr)
	 */
	protected void sequence_ThenEvidenceExpr(EObject context, ThenExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.THEN_EXPR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.THEN_EXPR__LEFT));
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.THEN_EXPR__SUCCESSOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.THEN_EXPR__SUCCESSOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getThenEvidenceExprAccess().getThenExprLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getThenEvidenceExprAccess().getSuccessorThenEvidenceExprParserRuleCall_1_1_0(), semanticObject.getSuccessor());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     verification=[VerificationActivity|ID]
	 */
	protected void sequence_VAReference(EObject context, RefExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.REF_EXPR__VERIFICATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.REF_EXPR__VERIFICATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVAReferenceAccess().getVerificationVerificationActivityIDTerminalRuleCall_1_0_1(), semanticObject.getVerification());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (result+=[ComputeDeclaration|ID] result+=[ComputeDeclaration|ID]*)? 
	 *         method=[VerificationMethod|QualifiedName] 
	 *         (parameters+=AExpression parameters+=AExpression*)? 
	 *         (propertyValues+=[ValDeclaration|ID] propertyValues+=[ValDeclaration|ID]*)? 
	 *         (phaseCategory+=[PhaseCategory|ID]* userCategory+=[UserCategory|ID]* timeout=AIntegerTerm? weight=INT?)?
	 *     )
	 */
	protected void sequence_VerificationActivity(EObject context, VerificationActivity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         (target=[ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+)? 
	 *         description=Description? 
	 *         methods+=VerificationMethod+
	 *     )
	 */
	protected void sequence_VerificationMethodRegistry(EObject context, VerificationMethodRegistry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (
	 *             (params+=FormalParameter params+=FormalParameter*)? 
	 *             (properties+=[Property|AADLPROPERTYREFERENCE] properties+=[Property|AADLPROPERTYREFERENCE]*)? 
	 *             (resultValues+=FormalParameter resultValues+=FormalParameter*)? 
	 *             (isPredicate?='boolean' | isResultReport?='report')?
	 *         )? 
	 *         title=STRING? 
	 *         (target=[ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+)? 
	 *         methodKind=MethodKind 
	 *         description=Description? 
	 *         precondition=VerificationPrecondition? 
	 *         validation=VerificationValidation? 
	 *         qualityCategory+=[QualityCategory|ID]* 
	 *         userCategory+=[UserCategory|ID]*
	 *     )
	 */
	protected void sequence_VerificationMethod(EObject context, VerificationMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         requirements=[Requirements|QualifiedName] 
	 *         description=Description? 
	 *         claim+=Claim* 
	 *         rationale=Rationale? 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_VerificationPlan(EObject context, VerificationPlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (method=[VerificationMethod|QualifiedName] (parameters+=[FormalParameter|ID] parameters+=[FormalParameter|ID]*)?)
	 */
	protected void sequence_VerificationPrecondition(EObject context, VerificationPrecondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (method=[VerificationMethod|QualifiedName] (parameters+=[FormalParameter|ID] parameters+=[FormalParameter|ID]*)?)
	 */
	protected void sequence_VerificationValidation(EObject context, VerificationValidation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (contents+=VerificationPlan | contents+=VerificationMethodRegistry)+
	 */
	protected void sequence_Verification(EObject context, Verification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
