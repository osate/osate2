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
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
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
import org.osate.assure.assure.AssuranceCase;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.PreconditionResult;
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
		else if(semanticObject.eClass().getEPackage() == AssurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssurePackage.ASSURANCE_CASE:
				sequence_AssuranceCase(context, (AssuranceCase) semanticObject); 
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
			case AssurePackage.PRECONDITION_RESULT:
				sequence_PreconditionResult(context, (PreconditionResult) semanticObject); 
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
	 *     (name=QualifiedName plan=[AssurancePlan|QualifiedName]? metrics=Metrics message=STRING? modelResult+=ModelResult+)
	 */
	protected void sequence_AssuranceCase(EObject context, AssuranceCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=[Requirement|QualifiedName] metrics=Metrics message=STRING? subClaimResult+=ClaimResult* verificationActivityResult+=VerificationExpr*)
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
	 *         weight=INT?
	 *     )
	 */
	protected void sequence_Metrics(EObject context, Metrics semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         target=[ComponentImplementation|AadlClassifierReference]? 
	 *         metrics=Metrics 
	 *         message=STRING? 
	 *         claimResult+=ClaimResult* 
	 *         subsystemResult+=SubsystemResult* 
	 *         subAssuranceCase+=[AssuranceCase|QualifiedName]*
	 *     )
	 */
	protected void sequence_ModelResult(EObject context, ModelResult semanticObject) {
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
	 *         name=QualifiedName 
	 *         targetSystem=ID 
	 *         metrics=Metrics 
	 *         message=STRING? 
	 *         claimResult+=ClaimResult* 
	 *         subsystemResult+=SubsystemResult*
	 *     )
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
	 *         target=[VerificationActivity|QualifiedName] 
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
