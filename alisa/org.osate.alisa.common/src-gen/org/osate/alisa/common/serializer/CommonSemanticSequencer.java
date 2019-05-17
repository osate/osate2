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
package org.osate.alisa.common.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
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
import org.osate.alisa.common.services.CommonGrammarAccess;

@SuppressWarnings("all")
public class CommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CommonGrammarAccess grammarAccess;
	
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
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AExpression returns ABinaryOperation
	 *     AOrExpression returns ABinaryOperation
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns ABinaryOperation
	 *     AAndExpression returns ABinaryOperation
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns ABinaryOperation
	 *     AEqualityExpression returns ABinaryOperation
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns ABinaryOperation
	 *     ARelationalExpression returns ABinaryOperation
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns ABinaryOperation
	 *     AAdditiveExpression returns ABinaryOperation
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns ABinaryOperation
	 *     AMultiplicativeExpression returns ABinaryOperation
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns ABinaryOperation
	 *     AUnaryOperation returns ABinaryOperation
	 *     AUnitExpression returns ABinaryOperation
	 *     AUnitExpression.AUnitExpression_1_0 returns ABinaryOperation
	 *     APrimaryExpression returns ABinaryOperation
	 *     AParenthesizedExpression returns ABinaryOperation
	 *
	 * Constraint:
	 *     (
	 *         (left=AOrExpression_ABinaryOperation_1_0_0_0 operator=OpOr right=AAndExpression) | 
	 *         (left=AAndExpression_ABinaryOperation_1_0_0_0 operator=OpAnd right=AEqualityExpression) | 
	 *         (left=AEqualityExpression_ABinaryOperation_1_0_0_0 operator=OpEquality right=ARelationalExpression) | 
	 *         (left=ARelationalExpression_ABinaryOperation_1_0_0_0 operator=OpCompare right=AAdditiveExpression) | 
	 *         (left=AAdditiveExpression_ABinaryOperation_1_0_0_0 operator=OpAdd right=AMultiplicativeExpression) | 
	 *         (left=AMultiplicativeExpression_ABinaryOperation_1_0_0_0 operator=OpMulti right=AUnaryOperation)
	 *     )
	 */
	protected void sequence_AAdditiveExpression_AAndExpression_AEqualityExpression_AMultiplicativeExpression_AOrExpression_ARelationalExpression(ISerializationContext context, ABinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns BooleanLiteral
	 *     AOrExpression returns BooleanLiteral
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns BooleanLiteral
	 *     AAndExpression returns BooleanLiteral
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns BooleanLiteral
	 *     AEqualityExpression returns BooleanLiteral
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns BooleanLiteral
	 *     ARelationalExpression returns BooleanLiteral
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns BooleanLiteral
	 *     AAdditiveExpression returns BooleanLiteral
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns BooleanLiteral
	 *     AMultiplicativeExpression returns BooleanLiteral
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns BooleanLiteral
	 *     AUnaryOperation returns BooleanLiteral
	 *     AUnitExpression returns BooleanLiteral
	 *     AUnitExpression.AUnitExpression_1_0 returns BooleanLiteral
	 *     APrimaryExpression returns BooleanLiteral
	 *     ALiteral returns BooleanLiteral
	 *     ABooleanLiteral returns BooleanLiteral
	 *     AParenthesizedExpression returns BooleanLiteral
	 *
	 * Constraint:
	 *     value?='true'?
	 */
	protected void sequence_ABooleanLiteral(ISerializationContext context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns AFunctionCall
	 *     AOrExpression returns AFunctionCall
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns AFunctionCall
	 *     AAndExpression returns AFunctionCall
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns AFunctionCall
	 *     AEqualityExpression returns AFunctionCall
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns AFunctionCall
	 *     ARelationalExpression returns AFunctionCall
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns AFunctionCall
	 *     AAdditiveExpression returns AFunctionCall
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns AFunctionCall
	 *     AMultiplicativeExpression returns AFunctionCall
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns AFunctionCall
	 *     AUnaryOperation returns AFunctionCall
	 *     AUnitExpression returns AFunctionCall
	 *     AUnitExpression.AUnitExpression_1_0 returns AFunctionCall
	 *     APrimaryExpression returns AFunctionCall
	 *     AFunctionCall returns AFunctionCall
	 *     AParenthesizedExpression returns AFunctionCall
	 *
	 * Constraint:
	 *     (function=QualifiedName (arguments+=AExpression arguments+=AExpression*)?)
	 */
	protected void sequence_AFunctionCall(ISerializationContext context, AFunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns AConditional
	 *     AOrExpression returns AConditional
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns AConditional
	 *     AAndExpression returns AConditional
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns AConditional
	 *     AEqualityExpression returns AConditional
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns AConditional
	 *     ARelationalExpression returns AConditional
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns AConditional
	 *     AAdditiveExpression returns AConditional
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns AConditional
	 *     AMultiplicativeExpression returns AConditional
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns AConditional
	 *     AUnaryOperation returns AConditional
	 *     AUnitExpression returns AConditional
	 *     AUnitExpression.AUnitExpression_1_0 returns AConditional
	 *     APrimaryExpression returns AConditional
	 *     AIfExpression returns AConditional
	 *     AParenthesizedExpression returns AConditional
	 *
	 * Constraint:
	 *     (if=AExpression then=AExpression else=AExpression?)
	 */
	protected void sequence_AIfExpression(ISerializationContext context, AConditional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns IntegerLiteral
	 *     AOrExpression returns IntegerLiteral
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns IntegerLiteral
	 *     AAndExpression returns IntegerLiteral
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns IntegerLiteral
	 *     AEqualityExpression returns IntegerLiteral
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns IntegerLiteral
	 *     ARelationalExpression returns IntegerLiteral
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns IntegerLiteral
	 *     AAdditiveExpression returns IntegerLiteral
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns IntegerLiteral
	 *     AMultiplicativeExpression returns IntegerLiteral
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns IntegerLiteral
	 *     AUnaryOperation returns IntegerLiteral
	 *     AUnitExpression returns IntegerLiteral
	 *     AUnitExpression.AUnitExpression_1_0 returns IntegerLiteral
	 *     APrimaryExpression returns IntegerLiteral
	 *     ALiteral returns IntegerLiteral
	 *     AIntegerTerm returns IntegerLiteral
	 *     AParenthesizedExpression returns IntegerLiteral
	 *
	 * Constraint:
	 *     value=AInt
	 */
	protected void sequence_AIntegerTerm(ISerializationContext context, IntegerLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getIntegerLiteral_Value()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getIntegerLiteral_Value()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AModelOrPropertyReference returns APropertyReference
	 *     AExpression returns APropertyReference
	 *     AOrExpression returns APropertyReference
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns APropertyReference
	 *     AAndExpression returns APropertyReference
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns APropertyReference
	 *     AEqualityExpression returns APropertyReference
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns APropertyReference
	 *     ARelationalExpression returns APropertyReference
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns APropertyReference
	 *     AAdditiveExpression returns APropertyReference
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns APropertyReference
	 *     AMultiplicativeExpression returns APropertyReference
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns APropertyReference
	 *     AUnaryOperation returns APropertyReference
	 *     AUnitExpression returns APropertyReference
	 *     AUnitExpression.AUnitExpression_1_0 returns APropertyReference
	 *     APrimaryExpression returns APropertyReference
	 *     AParenthesizedExpression returns APropertyReference
	 *
	 * Constraint:
	 *     (
	 *         (modelElementReference=AModelOrPropertyReference_APropertyReference_0_1_0_0_0 property=[AbstractNamedValue|AADLPROPERTYREFERENCE]) | 
	 *         property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     )
	 */
	protected void sequence_AModelOrPropertyReference_APropertyReference(ISerializationContext context, APropertyReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AModelOrPropertyReference returns AModelReference
	 *     AModelOrPropertyReference.APropertyReference_0_1_0_0_0 returns AModelReference
	 *     AModelReference returns AModelReference
	 *     AModelReference.AModelReference_1_0 returns AModelReference
	 *     AExpression returns AModelReference
	 *     AOrExpression returns AModelReference
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns AModelReference
	 *     AAndExpression returns AModelReference
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns AModelReference
	 *     AEqualityExpression returns AModelReference
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns AModelReference
	 *     ARelationalExpression returns AModelReference
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns AModelReference
	 *     AAdditiveExpression returns AModelReference
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns AModelReference
	 *     AMultiplicativeExpression returns AModelReference
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns AModelReference
	 *     AUnaryOperation returns AModelReference
	 *     AUnitExpression returns AModelReference
	 *     AUnitExpression.AUnitExpression_1_0 returns AModelReference
	 *     APrimaryExpression returns AModelReference
	 *     AParenthesizedExpression returns AModelReference
	 *
	 * Constraint:
	 *     (modelElement=[NamedElement|ThisKeyword] | (prev=AModelReference_AModelReference_1_0 modelElement=[NamedElement|ID]))
	 */
	protected void sequence_AModelReference(ISerializationContext context, AModelReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     APropertyReference returns APropertyReference
	 *
	 * Constraint:
	 *     property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 */
	protected void sequence_APropertyReference(ISerializationContext context, APropertyReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.APROPERTY_REFERENCE__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.APROPERTY_REFERENCE__PROPERTY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1(), semanticObject.eGet(CommonPackage.Literals.APROPERTY_REFERENCE__PROPERTY, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns ARange
	 *     AOrExpression returns ARange
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns ARange
	 *     AAndExpression returns ARange
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns ARange
	 *     AEqualityExpression returns ARange
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns ARange
	 *     ARelationalExpression returns ARange
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns ARange
	 *     AAdditiveExpression returns ARange
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns ARange
	 *     AMultiplicativeExpression returns ARange
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns ARange
	 *     AUnaryOperation returns ARange
	 *     AUnitExpression returns ARange
	 *     AUnitExpression.AUnitExpression_1_0 returns ARange
	 *     APrimaryExpression returns ARange
	 *     ARangeExpression returns ARange
	 *     AParenthesizedExpression returns ARange
	 *
	 * Constraint:
	 *     (minimum=AExpression maximum=AExpression delta=AExpression?)
	 */
	protected void sequence_ARangeExpression(ISerializationContext context, ARange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns RealLiteral
	 *     AOrExpression returns RealLiteral
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns RealLiteral
	 *     AAndExpression returns RealLiteral
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns RealLiteral
	 *     AEqualityExpression returns RealLiteral
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns RealLiteral
	 *     ARelationalExpression returns RealLiteral
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns RealLiteral
	 *     AAdditiveExpression returns RealLiteral
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns RealLiteral
	 *     AMultiplicativeExpression returns RealLiteral
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns RealLiteral
	 *     AUnaryOperation returns RealLiteral
	 *     AUnitExpression returns RealLiteral
	 *     AUnitExpression.AUnitExpression_1_0 returns RealLiteral
	 *     APrimaryExpression returns RealLiteral
	 *     ALiteral returns RealLiteral
	 *     ARealTerm returns RealLiteral
	 *     AParenthesizedExpression returns RealLiteral
	 *
	 * Constraint:
	 *     value=AReal
	 */
	protected void sequence_ARealTerm(ISerializationContext context, RealLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getRealLiteral_Value()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getRealLiteral_Value()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns AUnaryOperation
	 *     AOrExpression returns AUnaryOperation
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns AUnaryOperation
	 *     AAndExpression returns AUnaryOperation
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns AUnaryOperation
	 *     AEqualityExpression returns AUnaryOperation
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns AUnaryOperation
	 *     ARelationalExpression returns AUnaryOperation
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns AUnaryOperation
	 *     AAdditiveExpression returns AUnaryOperation
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns AUnaryOperation
	 *     AMultiplicativeExpression returns AUnaryOperation
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns AUnaryOperation
	 *     AUnaryOperation returns AUnaryOperation
	 *     AUnitExpression returns AUnaryOperation
	 *     AUnitExpression.AUnitExpression_1_0 returns AUnaryOperation
	 *     APrimaryExpression returns AUnaryOperation
	 *     AParenthesizedExpression returns AUnaryOperation
	 *
	 * Constraint:
	 *     (operator=OpUnary operand=AUnaryOperation)
	 */
	protected void sequence_AUnaryOperation(ISerializationContext context, AUnaryOperation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.AUNARY_OPERATION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.AUNARY_OPERATION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.AUNARY_OPERATION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.AUNARY_OPERATION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns AUnitExpression
	 *     AOrExpression returns AUnitExpression
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns AUnitExpression
	 *     AAndExpression returns AUnitExpression
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns AUnitExpression
	 *     AEqualityExpression returns AUnitExpression
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns AUnitExpression
	 *     ARelationalExpression returns AUnitExpression
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns AUnitExpression
	 *     AAdditiveExpression returns AUnitExpression
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns AUnitExpression
	 *     AMultiplicativeExpression returns AUnitExpression
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns AUnitExpression
	 *     AUnaryOperation returns AUnitExpression
	 *     AUnitExpression returns AUnitExpression
	 *     AUnitExpression.AUnitExpression_1_0 returns AUnitExpression
	 *     APrimaryExpression returns AUnitExpression
	 *     AParenthesizedExpression returns AUnitExpression
	 *
	 * Constraint:
	 *     (expression=AUnitExpression_AUnitExpression_1_0 (convert?='%' | drop?='in')? unit=[UnitLiteral|ID])
	 */
	protected void sequence_AUnitExpression(ISerializationContext context, AUnitExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AVariableReference returns AVariableReference
	 *     AExpression returns AVariableReference
	 *     AOrExpression returns AVariableReference
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns AVariableReference
	 *     AAndExpression returns AVariableReference
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns AVariableReference
	 *     AEqualityExpression returns AVariableReference
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns AVariableReference
	 *     ARelationalExpression returns AVariableReference
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns AVariableReference
	 *     AAdditiveExpression returns AVariableReference
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns AVariableReference
	 *     AMultiplicativeExpression returns AVariableReference
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns AVariableReference
	 *     AUnaryOperation returns AVariableReference
	 *     AUnitExpression returns AVariableReference
	 *     AUnitExpression.AUnitExpression_1_0 returns AVariableReference
	 *     APrimaryExpression returns AVariableReference
	 *     AParenthesizedExpression returns AVariableReference
	 *
	 * Constraint:
	 *     variable=[AVariableDeclaration|ID]
	 */
	protected void sequence_AVariableReference(ISerializationContext context, AVariableReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.AVARIABLE_REFERENCE__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.AVARIABLE_REFERENCE__VARIABLE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationIDTerminalRuleCall_1_0_1(), semanticObject.eGet(CommonPackage.Literals.AVARIABLE_REFERENCE__VARIABLE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ComputeDeclaration returns ComputeDeclaration
	 *
	 * Constraint:
	 *     (name=ID (type=TypeRef | type=PropertyRef | (range?='[' (type=TypeRef | type=PropertyRef))))
	 */
	protected void sequence_ComputeDeclaration(ISerializationContext context, ComputeDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DescriptionElement returns DescriptionElement
	 *
	 * Constraint:
	 *     (text=STRING | thisTarget?='this' | image=ImageReference | showValue=ShowValue)
	 */
	protected void sequence_DescriptionElement(ISerializationContext context, DescriptionElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Description returns Description
	 *
	 * Constraint:
	 *     description+=DescriptionElement+
	 */
	protected void sequence_Description(ISerializationContext context, Description semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ImageReference returns ImageReference
	 *
	 * Constraint:
	 *     imgfile=IMGREF
	 */
	protected void sequence_ImageReference(ISerializationContext context, ImageReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.IMAGE_REFERENCE__IMGFILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.IMAGE_REFERENCE__IMGFILE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0(), semanticObject.getImgfile());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyRef returns PropertyRef
	 *
	 * Constraint:
	 *     ref=[Property|AADLPROPERTYREFERENCE]
	 */
	protected void sequence_PropertyRef(ISerializationContext context, PropertyRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.PROPERTY_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.PROPERTY_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropertyRefAccess().getRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1(), semanticObject.eGet(CommonPackage.Literals.PROPERTY_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Rationale returns Rationale
	 *
	 * Constraint:
	 *     description+=DescriptionElement+
	 */
	protected void sequence_Rationale(ISerializationContext context, Rationale semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ShowValue returns AUnitExpression
	 *
	 * Constraint:
	 *     (expression=AVariableReference ((convert?='%' | drop?='in') unit=[UnitLiteral|ID])?)
	 */
	protected void sequence_ShowValue(ISerializationContext context, AUnitExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AExpression returns StringLiteral
	 *     AOrExpression returns StringLiteral
	 *     AOrExpression.ABinaryOperation_1_0_0_0 returns StringLiteral
	 *     AAndExpression returns StringLiteral
	 *     AAndExpression.ABinaryOperation_1_0_0_0 returns StringLiteral
	 *     AEqualityExpression returns StringLiteral
	 *     AEqualityExpression.ABinaryOperation_1_0_0_0 returns StringLiteral
	 *     ARelationalExpression returns StringLiteral
	 *     ARelationalExpression.ABinaryOperation_1_0_0_0 returns StringLiteral
	 *     AAdditiveExpression returns StringLiteral
	 *     AAdditiveExpression.ABinaryOperation_1_0_0_0 returns StringLiteral
	 *     AMultiplicativeExpression returns StringLiteral
	 *     AMultiplicativeExpression.ABinaryOperation_1_0_0_0 returns StringLiteral
	 *     AUnaryOperation returns StringLiteral
	 *     AUnitExpression returns StringLiteral
	 *     AUnitExpression.AUnitExpression_1_0 returns StringLiteral
	 *     APrimaryExpression returns StringLiteral
	 *     ALiteral returns StringLiteral
	 *     StringTerm returns StringLiteral
	 *     AParenthesizedExpression returns StringLiteral
	 *
	 * Constraint:
	 *     value=NoQuoteString
	 */
	protected void sequence_StringTerm(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getStringLiteral_Value()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getStringLiteral_Value()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns AadlBoolean
	 *
	 * Constraint:
	 *     {AadlBoolean}
	 */
	protected void sequence_TypeRef(ISerializationContext context, AadlBoolean semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns AadlInteger
	 *
	 * Constraint:
	 *     referencedUnitsType=[UnitsType|AADLPROPERTYREFERENCE]?
	 */
	protected void sequence_TypeRef(ISerializationContext context, AadlInteger semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns AadlReal
	 *
	 * Constraint:
	 *     referencedUnitsType=[UnitsType|AADLPROPERTYREFERENCE]?
	 */
	protected void sequence_TypeRef(ISerializationContext context, AadlReal semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns AadlString
	 *
	 * Constraint:
	 *     {AadlString}
	 */
	protected void sequence_TypeRef(ISerializationContext context, AadlString semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns ModelRef
	 *
	 * Constraint:
	 *     {ModelRef}
	 */
	protected void sequence_TypeRef(ISerializationContext context, ModelRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns TypeRef
	 *
	 * Constraint:
	 *     ref=[PropertyType|AADLPROPERTYREFERENCE]
	 */
	protected void sequence_TypeRef(ISerializationContext context, TypeRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CommonPackage.Literals.TYPE_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.TYPE_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeRefAccess().getRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1(), semanticObject.eGet(CommonPackage.Literals.TYPE_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Uncertainty returns Uncertainty
	 *
	 * Constraint:
	 *     (volatility=INT | precedence=INT | impact=INT)*
	 */
	protected void sequence_Uncertainty(ISerializationContext context, Uncertainty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ValDeclaration returns ValDeclaration
	 *
	 * Constraint:
	 *     (name=ID (type=TypeRef | type=PropertyRef | (range?='[' (type=TypeRef | type=PropertyRef)))? value=AExpression)
	 */
	protected void sequence_ValDeclaration(ISerializationContext context, ValDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
