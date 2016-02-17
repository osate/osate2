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
import org.osate.alisa.common.services.CommonGrammarAccess;

@SuppressWarnings("all")
public class CommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CommonGrammarAccess grammarAccess;
	
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=AAdditiveExpression_ABinaryOperation_1_0_0_0 feature=OpAdd rightOperand=AMultiplicativeExpression) | 
	 *         (leftOperand=AMultiplicativeExpression_ABinaryOperation_1_0_0_0 feature=OpMulti rightOperand=AUnaryOperation) | 
	 *         (leftOperand=AOtherOperatorExpression_ABinaryOperation_1_0_0_0 feature=OpOther rightOperand=AAdditiveExpression) | 
	 *         (leftOperand=ARelationalExpression_ABinaryOperation_1_0_0_0 feature=OpCompare rightOperand=AOtherOperatorExpression) | 
	 *         (leftOperand=AEqualityExpression_ABinaryOperation_1_0_0_0 feature=OpEquality rightOperand=ARelationalExpression) | 
	 *         (leftOperand=AAndExpression_ABinaryOperation_1_0_0_0 feature=OpAnd rightOperand=AEqualityExpression) | 
	 *         (leftOperand=AOrExpression_ABinaryOperation_1_0_0_0 feature=OpOr rightOperand=AAndExpression)
	 *     )
	 */
	protected void sequence_AAdditiveExpression_AAndExpression_AEqualityExpression_AMultiplicativeExpression_AOrExpression_AOtherOperatorExpression_ARelationalExpression(EObject context, ABinaryOperation semanticObject) {
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
	 *     (value=AInt unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_AIntegerTerm(EObject context, IntegerLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((elements+=AExpression elements+=AExpression*)?)
	 */
	protected void sequence_AListTerm(EObject context, AListTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ANullLiteral}
	 */
	protected void sequence_ANullLiteral(EObject context, ANullLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (minimum=NumAlt maximum=NumAlt delta=NumAlt?)
	 */
	protected void sequence_ANumericRangeTerm(EObject context, RangeValue semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
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
	 *     (value=AReal unit=[UnitLiteral|ID]?)
	 */
	protected void sequence_ARealTerm(EObject context, RealLiteral semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((elements+=AExpression elements+=AExpression*)?)
	 */
	protected void sequence_ASetTerm(EObject context, ASetLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=OpUnary operand=AUnaryOperation)
	 */
	protected void sequence_AUnaryOperation(EObject context, AUnaryOperation semanticObject) {
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
	 *     ((type=ID name=ID) | name=ID)
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
	 *     (volatility=INT impact=INT)
	 */
	protected void sequence_Uncertainty(EObject context, Uncertainty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((type=ID name=ID) | name=ID) right=AExpression)
	 */
	protected void sequence_ValDeclaration(EObject context, ValDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
