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
import org.osate.alisa.common.common.NestedModelElement;
import org.osate.alisa.common.common.PropertyRef;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.ResultIssue;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.TypeRef;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.services.CommonGrammarAccess;

@SuppressWarnings("all")
public class CommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CommonGrammarAccess grammarAccess;
	
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
			case CommonPackage.NESTED_MODEL_ELEMENT:
				sequence_NestedModelelement(context, (NestedModelElement) semanticObject); 
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
	 *     (
	 *         (left=AAdditiveExpression_ABinaryOperation_1_0_0_0 operator=OpAdd right=AMultiplicativeExpression) | 
	 *         (left=AMultiplicativeExpression_ABinaryOperation_1_0_0_0 operator=OpMulti right=AUnaryOperation) | 
	 *         (left=ARelationalExpression_ABinaryOperation_1_0_0_0 operator=OpCompare right=AAdditiveExpression) | 
	 *         (left=AEqualityExpression_ABinaryOperation_1_0_0_0 operator=OpEquality right=ARelationalExpression) | 
	 *         (left=AAndExpression_ABinaryOperation_1_0_0_0 operator=OpAnd right=AEqualityExpression) | 
	 *         (left=AOrExpression_ABinaryOperation_1_0_0_0 operator=OpOr right=AAndExpression)
	 *     )
	 */
	protected void sequence_AAdditiveExpression_AAndExpression_AEqualityExpression_AMultiplicativeExpression_AOrExpression_ARelationalExpression(EObject context, ABinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value?='true'?)
	 */
	protected void sequence_ABooleanLiteral(EObject context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (function=ID arguments+=AExpression arguments+=AExpression*)
	 */
	protected void sequence_AFunctionCall(EObject context, AFunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=AExpression then=AExpression else=AExpression?)
	 */
	protected void sequence_AIfExpression(EObject context, AConditional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=AInt
	 */
	protected void sequence_AIntegerTerm(EObject context, IntegerLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (modelElementReference=AModelOrPropertyReference_APropertyReference_0_1_0_0_0 property=[AbstractNamedValue|AADLPROPERTYREFERENCE]) | 
	 *         property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     )
	 */
	protected void sequence_AModelOrPropertyReference_APropertyReference(EObject context, APropertyReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (next=NestedModelelement?)
	 */
	protected void sequence_AModelReference(EObject context, AModelReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 */
	protected void sequence_APropertyReference(EObject context, APropertyReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (minimum=AExpression maximum=AExpression delta=AExpression?)
	 */
	protected void sequence_ARangeExpression(EObject context, ARange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=AReal
	 */
	protected void sequence_ARealTerm(EObject context, RealLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator=OpUnary operand=AUnaryOperation)
	 */
	protected void sequence_AUnaryOperation(EObject context, AUnaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (expression=AUnitExpression_AUnitExpression_1_0 (convert?='%' | drop?='in')? unit=[UnitLiteral|ID]) | 
	 *         (expression=AUnitExpression_AUnitExpression_1_0 unit=[UnitLiteral|ID])
	 *     )
	 */
	protected void sequence_AUnitExpression(EObject context, AUnitExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     variable=[AVariableDeclaration|ID]
	 */
	protected void sequence_AVariableReference(EObject context, AVariableReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (type=TypeRef | type=PropertyRef | (range?='[' (type=TypeRef | type=PropertyRef))))
	 */
	protected void sequence_ComputeDeclaration(EObject context, ComputeDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (text=STRING | showValue=ShowValue | thisTarget?='this' | image=ImageReference)
	 */
	protected void sequence_DescriptionElement(EObject context, DescriptionElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     description+=DescriptionElement+
	 */
	protected void sequence_Description(EObject context, Description semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     imgfile=IMGREF
	 */
	protected void sequence_ImageReference(EObject context, ImageReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.IMAGE_REFERENCE__IMGFILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.IMAGE_REFERENCE__IMGFILE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0(), semanticObject.getImgfile());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (modelElement=[NamedElement|ID] next=NestedModelelement?)
	 */
	protected void sequence_NestedModelelement(EObject context, NestedModelElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=[Property|AADLPROPERTYREFERENCE]
	 */
	protected void sequence_PropertyRef(EObject context, PropertyRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     text=STRING
	 */
	protected void sequence_Rationale(EObject context, Rationale semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.RATIONALE__TEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.RATIONALE__TEXT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRationaleAccess().getTextSTRINGTerminalRuleCall_1_0(), semanticObject.getText());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         issueType=ResultIssueType 
	 *         message=STRING 
	 *         target=[EObject|URIID]? 
	 *         exceptionType=STRING? 
	 *         diagnosticId=STRING? 
	 *         issues+=ResultIssue*
	 *     )
	 */
	protected void sequence_ResultIssue(EObject context, ResultIssue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[AVariableDeclaration|ID] unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_ShowValue(EObject context, ShowValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=NoQuoteString
	 */
	protected void sequence_StringTerm(EObject context, StringLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AadlBoolean}
	 */
	protected void sequence_TypeRef(EObject context, AadlBoolean semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (referencedUnitsType=[UnitsType|AADLPROPERTYREFERENCE]?)
	 */
	protected void sequence_TypeRef(EObject context, AadlInteger semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (referencedUnitsType=[UnitsType|AADLPROPERTYREFERENCE]?)
	 */
	protected void sequence_TypeRef(EObject context, AadlReal semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AadlString}
	 */
	protected void sequence_TypeRef(EObject context, AadlString semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ModelRef}
	 */
	protected void sequence_TypeRef(EObject context, ModelRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=[PropertyType|AADLPROPERTYREFERENCE]
	 */
	protected void sequence_TypeRef(EObject context, TypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (volatility=INT impact=INT)
	 */
	protected void sequence_Uncertainty(EObject context, Uncertainty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (type=TypeRef | type=PropertyRef | (range?='[' (type=TypeRef | type=PropertyRef)))? value=AExpression)
	 */
	protected void sequence_ValDeclaration(EObject context, ValDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
