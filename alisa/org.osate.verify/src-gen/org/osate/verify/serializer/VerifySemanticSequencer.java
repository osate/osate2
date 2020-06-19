/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.verify.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
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
import org.osate.alisa.common.common.TypeRef;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.verify.services.VerifyGrammarAccess;
import org.osate.verify.verify.AgreeMethod;
import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ComputeRef;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.JUnit4Method;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.JavaParameter;
import org.osate.verify.verify.ManualMethod;
import org.osate.verify.verify.PluginMethod;
import org.osate.verify.verify.PythonMethod;
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
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
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
		else if (epackage == CommonPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
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
				if (rule == grammarAccess.getAModelOrPropertyReferenceRule()
						|| rule == grammarAccess.getAExpressionRule()
						|| rule == grammarAccess.getAOrExpressionRule()
						|| action == grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAAndExpressionRule()
						|| action == grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAEqualityExpressionRule()
						|| action == grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getARelationalExpressionRule()
						|| action == grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAAdditiveExpressionRule()
						|| action == grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAMultiplicativeExpressionRule()
						|| action == grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAUnaryOperationRule()
						|| rule == grammarAccess.getAUnitExpressionRule()
						|| action == grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()
						|| rule == grammarAccess.getAPrimaryExpressionRule()
						|| rule == grammarAccess.getAParenthesizedExpressionRule()) {
					sequence_AModelOrPropertyReference_APropertyReference(context, (APropertyReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAPropertyReferenceRule()) {
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
				if (rule == grammarAccess.getAExpressionRule()
						|| rule == grammarAccess.getAOrExpressionRule()
						|| action == grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAAndExpressionRule()
						|| action == grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAEqualityExpressionRule()
						|| action == grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getARelationalExpressionRule()
						|| action == grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAAdditiveExpressionRule()
						|| action == grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAMultiplicativeExpressionRule()
						|| action == grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0()
						|| rule == grammarAccess.getAUnaryOperationRule()
						|| rule == grammarAccess.getAUnitExpressionRule()
						|| action == grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0()
						|| rule == grammarAccess.getAPrimaryExpressionRule()
						|| rule == grammarAccess.getAParenthesizedExpressionRule()) {
					sequence_AUnitExpression(context, (AUnitExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getShowValueRule()) {
					sequence_ShowValue(context, (AUnitExpression) semanticObject); 
					return; 
				}
				else break;
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
		else if (epackage == VerifyPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case VerifyPackage.AGREE_METHOD:
				sequence_AgreeMethod(context, (AgreeMethod) semanticObject); 
				return; 
			case VerifyPackage.ALL_EXPR:
				sequence_QuantifiedEvidenceExpr(context, (AllExpr) semanticObject); 
				return; 
			case VerifyPackage.CLAIM:
				sequence_Claim(context, (Claim) semanticObject); 
				return; 
			case VerifyPackage.COMPUTE_REF:
				sequence_ComputeRef(context, (ComputeRef) semanticObject); 
				return; 
			case VerifyPackage.ELSE_EXPR:
				if (rule == grammarAccess.getArgumentExprRule()
						|| rule == grammarAccess.getThenEvidenceExprRule()
						|| action == grammarAccess.getThenEvidenceExprAccess().getThenExprLeftAction_1_0_0_0()
						|| rule == grammarAccess.getElseEvidenceExprRule()
						|| rule == grammarAccess.getCompositeElseEvidenceExprRule()
						|| action == grammarAccess.getCompositeElseEvidenceExprAccess().getElseExprLeftAction_1_0_0_0()
						|| rule == grammarAccess.getCompositeEvidenceExprRule()) {
					sequence_CompositeElseEvidenceExpr_SingleElseEvidenceExpr(context, (ElseExpr) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSingleElseEvidenceExprRule()
						|| action == grammarAccess.getSingleElseEvidenceExprAccess().getElseExprLeftAction_1_0_0_0()) {
					sequence_SingleElseEvidenceExpr(context, (ElseExpr) semanticObject); 
					return; 
				}
				else break;
			case VerifyPackage.FORMAL_PARAMETER:
				sequence_FormalParameter(context, (FormalParameter) semanticObject); 
				return; 
			case VerifyPackage.JUNIT4_METHOD:
				sequence_JUnit4Method(context, (JUnit4Method) semanticObject); 
				return; 
			case VerifyPackage.JAVA_METHOD:
				sequence_JavaMethod(context, (JavaMethod) semanticObject); 
				return; 
			case VerifyPackage.JAVA_PARAMETER:
				sequence_JavaParameter(context, (JavaParameter) semanticObject); 
				return; 
			case VerifyPackage.MANUAL_METHOD:
				sequence_ManualMethod(context, (ManualMethod) semanticObject); 
				return; 
			case VerifyPackage.PLUGIN_METHOD:
				sequence_PluginMethod(context, (PluginMethod) semanticObject); 
				return; 
			case VerifyPackage.PYTHON_METHOD:
				sequence_PythonMethod(context, (PythonMethod) semanticObject); 
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
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     MethodKind returns AgreeMethod
	 *     AgreeMethod returns AgreeMethod
	 *
	 * Constraint:
	 *     (singleLayer?='single' | all?='all')
	 */
	protected void sequence_AgreeMethod(ISerializationContext context, AgreeMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Claim returns Claim
	 *
	 * Constraint:
	 *     (
	 *         requirement=[Requirement|QualifiedName]? 
	 *         title=STRING? 
	 *         (
	 *             activities+=VerificationActivity | 
	 *             assert=ArgumentExpr | 
	 *             rationale=Rationale | 
	 *             weight=INT | 
	 *             subclaim+=Claim | 
	 *             issues+=STRING
	 *         )*
	 *     )
	 */
	protected void sequence_Claim(ISerializationContext context, Claim semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ArgumentExpr returns ElseExpr
	 *     ThenEvidenceExpr returns ElseExpr
	 *     ThenEvidenceExpr.ThenExpr_1_0_0_0 returns ElseExpr
	 *     ElseEvidenceExpr returns ElseExpr
	 *     CompositeElseEvidenceExpr returns ElseExpr
	 *     CompositeElseEvidenceExpr.ElseExpr_1_0_0_0 returns ElseExpr
	 *     CompositeEvidenceExpr returns ElseExpr
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             left=SingleElseEvidenceExpr_ElseExpr_1_0_0_0 
	 *             (error=ElseEvidenceExpr | (fail=ThenEvidenceExpr? timeout=ThenEvidenceExpr? error=ThenEvidenceExpr?))?
	 *         ) | 
	 *         (left=CompositeElseEvidenceExpr_ElseExpr_1_0_0_0 error=ElseEvidenceExpr)
	 *     )
	 */
	protected void sequence_CompositeElseEvidenceExpr_SingleElseEvidenceExpr(ISerializationContext context, ElseExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComputeRef returns ComputeRef
	 *
	 * Constraint:
	 *     compute=[ComputeDeclaration|ID]
	 */
	protected void sequence_ComputeRef(ISerializationContext context, ComputeRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.COMPUTE_REF__COMPUTE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.COMPUTE_REF__COMPUTE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getComputeRefAccess().getComputeComputeDeclarationIDTerminalRuleCall_0_1(), semanticObject.eGet(VerifyPackage.Literals.COMPUTE_REF__COMPUTE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     FormalParameter returns FormalParameter
	 *
	 * Constraint:
	 *     (name=ID (type=TypeRef | type=PropertyRef) unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_FormalParameter(ISerializationContext context, FormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MethodKind returns JUnit4Method
	 *     JUnit4Method returns JUnit4Method
	 *
	 * Constraint:
	 *     classPath=QualifiedName
	 */
	protected void sequence_JUnit4Method(ISerializationContext context, JUnit4Method semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.JUNIT4_METHOD__CLASS_PATH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.JUNIT4_METHOD__CLASS_PATH));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJUnit4MethodAccess().getClassPathQualifiedNameParserRuleCall_1_0(), semanticObject.getClassPath());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MethodKind returns JavaMethod
	 *     JavaMethod returns JavaMethod
	 *
	 * Constraint:
	 *     (methodPath=QualifiedName (params+=JavaParameter params+=JavaParameter*)?)
	 */
	protected void sequence_JavaMethod(ISerializationContext context, JavaMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     JavaParameter returns JavaParameter
	 *
	 * Constraint:
	 *     (parameterType=ID name=ID)
	 */
	protected void sequence_JavaParameter(ISerializationContext context, JavaParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.JAVA_PARAMETER__PARAMETER_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.JAVA_PARAMETER__PARAMETER_TYPE));
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.JAVA_PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.JAVA_PARAMETER__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJavaParameterAccess().getParameterTypeIDTerminalRuleCall_0_0(), semanticObject.getParameterType());
		feeder.accept(grammarAccess.getJavaParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MethodKind returns ManualMethod
	 *     ManualMethod returns ManualMethod
	 *
	 * Constraint:
	 *     dialogID=QualifiedName
	 */
	protected void sequence_ManualMethod(ISerializationContext context, ManualMethod semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.MANUAL_METHOD__DIALOG_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.MANUAL_METHOD__DIALOG_ID));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getManualMethodAccess().getDialogIDQualifiedNameParserRuleCall_2_0(), semanticObject.getDialogID());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MethodKind returns PluginMethod
	 *     PluginMethod returns PluginMethod
	 *
	 * Constraint:
	 *     methodID=ID
	 */
	protected void sequence_PluginMethod(ISerializationContext context, PluginMethod semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPluginMethodAccess().getMethodIDIDTerminalRuleCall_1_0(), semanticObject.getMethodID());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MethodKind returns PythonMethod
	 *     PythonMethod returns PythonMethod
	 *
	 * Constraint:
	 *     methodPath=QualifiedName
	 */
	protected void sequence_PythonMethod(ISerializationContext context, PythonMethod semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.PYTHON_METHOD__METHOD_PATH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.PYTHON_METHOD__METHOD_PATH));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPythonMethodAccess().getMethodPathQualifiedNameParserRuleCall_1_0(), semanticObject.getMethodPath());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ArgumentExpr returns AllExpr
	 *     ThenEvidenceExpr returns AllExpr
	 *     ThenEvidenceExpr.ThenExpr_1_0_0_0 returns AllExpr
	 *     ElseEvidenceExpr returns AllExpr
	 *     CompositeElseEvidenceExpr returns AllExpr
	 *     CompositeElseEvidenceExpr.ElseExpr_1_0_0_0 returns AllExpr
	 *     QuantifiedEvidenceExpr returns AllExpr
	 *     CompositeEvidenceExpr returns AllExpr
	 *
	 * Constraint:
	 *     (elements+=ThenEvidenceExpr elements+=ThenEvidenceExpr*)
	 */
	protected void sequence_QuantifiedEvidenceExpr(ISerializationContext context, AllExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MethodKind returns ResoluteMethod
	 *     ResoluteMethod returns ResoluteMethod
	 *
	 * Constraint:
	 *     methodReference=[EObject|QualifiedName]
	 */
	protected void sequence_ResoluteMethod(ISerializationContext context, ResoluteMethod semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.RESOLUTE_METHOD__METHOD_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.RESOLUTE_METHOD__METHOD_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getResoluteMethodAccess().getMethodReferenceEObjectQualifiedNameParserRuleCall_1_0_1(), semanticObject.eGet(VerifyPackage.Literals.RESOLUTE_METHOD__METHOD_REFERENCE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SingleElseEvidenceExpr returns ElseExpr
	 *     SingleElseEvidenceExpr.ElseExpr_1_0_0_0 returns ElseExpr
	 *
	 * Constraint:
	 *     (
	 *         left=SingleElseEvidenceExpr_ElseExpr_1_0_0_0 
	 *         (error=ElseEvidenceExpr | (fail=ThenEvidenceExpr? timeout=ThenEvidenceExpr? error=ThenEvidenceExpr?))?
	 *     )
	 */
	protected void sequence_SingleElseEvidenceExpr(ISerializationContext context, ElseExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ArgumentExpr returns ThenExpr
	 *     ThenEvidenceExpr returns ThenExpr
	 *     ThenEvidenceExpr.ThenExpr_1_0_0_0 returns ThenExpr
	 *     ElseEvidenceExpr returns ThenExpr
	 *     CompositeElseEvidenceExpr returns ThenExpr
	 *     CompositeElseEvidenceExpr.ElseExpr_1_0_0_0 returns ThenExpr
	 *     CompositeEvidenceExpr returns ThenExpr
	 *
	 * Constraint:
	 *     (left=ThenEvidenceExpr_ThenExpr_1_0_0_0 successor=ThenEvidenceExpr)
	 */
	protected void sequence_ThenEvidenceExpr(ISerializationContext context, ThenExpr semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.THEN_EXPR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.THEN_EXPR__LEFT));
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.THEN_EXPR__SUCCESSOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.THEN_EXPR__SUCCESSOR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getThenEvidenceExprAccess().getThenExprLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getThenEvidenceExprAccess().getSuccessorThenEvidenceExprParserRuleCall_1_1_0(), semanticObject.getSuccessor());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ArgumentExpr returns RefExpr
	 *     ThenEvidenceExpr returns RefExpr
	 *     ThenEvidenceExpr.ThenExpr_1_0_0_0 returns RefExpr
	 *     ElseEvidenceExpr returns RefExpr
	 *     SingleElseEvidenceExpr returns RefExpr
	 *     SingleElseEvidenceExpr.ElseExpr_1_0_0_0 returns RefExpr
	 *     CompositeElseEvidenceExpr returns RefExpr
	 *     CompositeElseEvidenceExpr.ElseExpr_1_0_0_0 returns RefExpr
	 *     CompositeEvidenceExpr returns RefExpr
	 *     VAReference returns RefExpr
	 *
	 * Constraint:
	 *     verification=[VerificationActivity|ID]
	 */
	protected void sequence_VAReference(ISerializationContext context, RefExpr semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VerifyPackage.Literals.REF_EXPR__VERIFICATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VerifyPackage.Literals.REF_EXPR__VERIFICATION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVAReferenceAccess().getVerificationVerificationActivityIDTerminalRuleCall_1_0_1(), semanticObject.eGet(VerifyPackage.Literals.REF_EXPR__VERIFICATION, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     VerificationActivity returns VerificationActivity
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (computes+=ComputeRef computes+=ComputeRef*)? 
	 *         method=[VerificationMethod|QualifiedName] 
	 *         (actuals+=AExpression actuals+=AExpression*)? 
	 *         (propertyValues+=AExpression propertyValues+=AExpression*)? 
	 *         (category+=[Category|QualifiedName] | timeout=AIntegerTerm | weight=INT)*
	 *     )
	 */
	protected void sequence_VerificationActivity(ISerializationContext context, VerificationActivity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VerificationMethodRegistry returns VerificationMethodRegistry
	 *
	 * Constraint:
	 *     (name=QualifiedName title=STRING? description=Description? methods+=VerificationMethod*)
	 */
	protected void sequence_VerificationMethodRegistry(ISerializationContext context, VerificationMethodRegistry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VerificationMethod returns VerificationMethod
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (
	 *             targetType=TargetType | 
	 *             (formals+=FormalParameter formals+=FormalParameter*) | 
	 *             (targetType=TargetType formals+=FormalParameter formals+=FormalParameter*)
	 *         )? 
	 *         (properties+=[Property|AADLPROPERTYREFERENCE] properties+=[Property|AADLPROPERTYREFERENCE]*)? 
	 *         (results+=FormalParameter results+=FormalParameter*)? 
	 *         (isPredicate?='boolean' | isResultReport?='report')? 
	 *         title=STRING? 
	 *         (target=[ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+)? 
	 *         methodKind=MethodKind? 
	 *         (
	 *             (description=Description | precondition=VerificationPrecondition | validation=VerificationValidation | category+=[Category|QualifiedName])? 
	 *             methodKind=MethodKind?
	 *         )*
	 *     )
	 */
	protected void sequence_VerificationMethod(ISerializationContext context, VerificationMethod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VerificationPlan returns VerificationPlan
	 *
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         requirementSet=[RequirementSet|QualifiedName] 
	 *         (description=Description | claim+=Claim | rationale=Rationale | issues+=STRING)*
	 *     )
	 */
	protected void sequence_VerificationPlan(ISerializationContext context, VerificationPlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VerificationPrecondition returns VerificationPrecondition
	 *
	 * Constraint:
	 *     (method=[VerificationMethod|QualifiedName] (parameters+=[FormalParameter|ID] parameters+=[FormalParameter|ID]*)?)
	 */
	protected void sequence_VerificationPrecondition(ISerializationContext context, VerificationPrecondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VerificationValidation returns VerificationValidation
	 *
	 * Constraint:
	 *     (method=[VerificationMethod|QualifiedName] (parameters+=[FormalParameter|ID] parameters+=[FormalParameter|ID]*)?)
	 */
	protected void sequence_VerificationValidation(ISerializationContext context, VerificationValidation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Verification returns Verification
	 *
	 * Constraint:
	 *     (contents+=VerificationPlan | contents+=VerificationMethodRegistry)+
	 */
	protected void sequence_Verification(ISerializationContext context, Verification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
