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
package org.osate.reqspec.serializer;

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
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.DesiredValue;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.GlobalRequirementSet;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.IncludeGlobalRequirement;
import org.osate.reqspec.reqSpec.InformalPredicate;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ReqValDeclaration;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.reqspec.reqSpec.WhenCondition;
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private ReqSpecGrammarAccess grammarAccess;
	
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
			}
		else if(semanticObject.eClass().getEPackage() == ReqSpecPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ReqSpecPackage.DESIRED_VALUE:
				sequence_DesiredValue(context, (DesiredValue) semanticObject); 
				return; 
			case ReqSpecPackage.DOCUMENT_SECTION:
				sequence_DocumentSection(context, (DocumentSection) semanticObject); 
				return; 
			case ReqSpecPackage.EXTERNAL_DOCUMENT:
				sequence_ExternalDocument(context, (ExternalDocument) semanticObject); 
				return; 
			case ReqSpecPackage.GLOBAL_CONSTANTS:
				sequence_GlobalConstants(context, (GlobalConstants) semanticObject); 
				return; 
			case ReqSpecPackage.GLOBAL_REQUIREMENT_SET:
				sequence_GlobalRequirementSet(context, (GlobalRequirementSet) semanticObject); 
				return; 
			case ReqSpecPackage.GOAL:
				if(context == grammarAccess.getDocGoalRule()) {
					sequence_DocGoal(context, (Goal) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getGoalRule()) {
					sequence_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT:
				sequence_IncludeGlobalRequirement(context, (IncludeGlobalRequirement) semanticObject); 
				return; 
			case ReqSpecPackage.INFORMAL_PREDICATE:
				sequence_InformalPredicate(context, (InformalPredicate) semanticObject); 
				return; 
			case ReqSpecPackage.REQ_DOCUMENT:
				sequence_ReqDocument(context, (ReqDocument) semanticObject); 
				return; 
			case ReqSpecPackage.REQ_SPEC:
				sequence_ReqSpec(context, (ReqSpec) semanticObject); 
				return; 
			case ReqSpecPackage.REQ_VAL_DECLARATION:
				sequence_ValDeclaration(context, (ReqValDeclaration) semanticObject); 
				return; 
			case ReqSpecPackage.REQUIREMENT:
				if(context == grammarAccess.getDocRequirementRule()) {
					sequence_DocRequirement(context, (Requirement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getGlobalRequirementRule()) {
					sequence_GlobalRequirement(context, (Requirement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getSystemRequirementRule()) {
					sequence_SystemRequirement(context, (Requirement) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.STAKEHOLDER_GOALS:
				sequence_StakeholderGoals(context, (StakeholderGoals) semanticObject); 
				return; 
			case ReqSpecPackage.SYSTEM_REQUIREMENT_SET:
				sequence_SystemRequirementSet(context, (SystemRequirementSet) semanticObject); 
				return; 
			case ReqSpecPackage.VALUE_PREDICATE:
				sequence_ValuePredicate(context, (ValuePredicate) semanticObject); 
				return; 
			case ReqSpecPackage.WHEN_CONDITION:
				sequence_WhenCondition(context, (WhenCondition) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (desired=[AVariableReference|ID] upto?='upto'? value=AExpression)
	 */
	protected void sequence_DesiredValue(EObject context, DesiredValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (targetDescription=STRING | (target=[ComponentClassifier|AadlClassifierReference] targetElement=[NamedElement|ID]?))? 
	 *         category+=[Category|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         whencondition=WhenCondition? 
	 *         rationale=Rationale? 
	 *         changeUncertainty=Uncertainty? 
	 *         refinesReference+=[Goal|QualifiedName]* 
	 *         conflictsReference+=[Goal|QualifiedName]* 
	 *         evolvesReference+=[Requirement|QualifiedName]* 
	 *         (dropped?='dropped' dropRationale=STRING?)? 
	 *         stakeholderReference+=[Stakeholder|QualifiedName]* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_DocGoal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (
	 *             targetDescription=STRING | 
	 *             (target=[ComponentClassifier|AadlClassifierReference] targetElement=[NamedElement|ID]?) | 
	 *             componentCategory+=ComponentCategory+
	 *         )? 
	 *         category+=[Category|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
	 *         whencondition=WhenCondition? 
	 *         predicate=ReqPredicate? 
	 *         rationale=Rationale? 
	 *         changeUncertainty=Uncertainty? 
	 *         (exception=[EObject|ID] | exceptionText=STRING)? 
	 *         refinesReference+=[Requirement|QualifiedName]* 
	 *         decomposesReference+=[Requirement|QualifiedName]* 
	 *         inheritsReference=[Requirement|QualifiedName]? 
	 *         evolvesReference+=[Requirement|QualifiedName]* 
	 *         (dropped?='dropped' dropRationale=STRING?)? 
	 *         developmentStakeholder+=[Stakeholder|QualifiedName]* 
	 *         goalReference+=[Goal|QualifiedName]* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_DocRequirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID title=STRING? description=Description? (content+=DocGoal | content+=DocRequirement | content+=DocumentSection)*)
	 */
	protected void sequence_DocumentSection(EObject context, DocumentSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (docReference=DOCPATH docFragment=QualifiedName?)
	 */
	protected void sequence_ExternalDocument(EObject context, ExternalDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName constants+=ValDeclaration*)
	 */
	protected void sequence_GlobalConstants(EObject context, GlobalConstants semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         importConstants+=[GlobalConstants|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
	 *         requirements+=GlobalRequirement* 
	 *         docReference+=ExternalDocument* 
	 *         stakeholderGoals+=[ReqRoot|QualifiedName]* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_GlobalRequirementSet(EObject context, GlobalRequirementSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (componentCategory+=ComponentCategory+ | connections?='connections')? 
	 *         category+=[Category|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
	 *         whencondition=WhenCondition? 
	 *         predicate=ReqPredicate? 
	 *         rationale=Rationale? 
	 *         changeUncertainty=Uncertainty? 
	 *         (exception=[EObject|ID] | exceptionText=STRING)? 
	 *         refinesReference+=[Requirement|QualifiedName]* 
	 *         decomposesReference+=[Requirement|QualifiedName]* 
	 *         evolvesReference+=[Requirement|QualifiedName]* 
	 *         (dropped?='dropped' dropRationale=STRING?)? 
	 *         developmentStakeholder+=[Stakeholder|QualifiedName]* 
	 *         goalReference+=[Goal|QualifiedName]* 
	 *         requirementReference+=[Requirement|QualifiedName]* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_GlobalRequirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         targetElement=[NamedElement|ID]? 
	 *         category+=[Category|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         whencondition=WhenCondition? 
	 *         rationale=Rationale? 
	 *         changeUncertainty=Uncertainty? 
	 *         refinesReference+=[Goal|QualifiedName]* 
	 *         conflictsReference+=[Goal|QualifiedName]* 
	 *         evolvesReference+=[Requirement|QualifiedName]* 
	 *         (dropped?='dropped' dropRationale=STRING?)? 
	 *         stakeholderReference+=[Stakeholder|QualifiedName]* 
	 *         goalReference+=[Goal|QualifiedName]* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (include=[EObject|QualifiedName] (componentCategory+=ComponentCategory+ | self?='self')?)
	 */
	protected void sequence_IncludeGlobalRequirement(EObject context, IncludeGlobalRequirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     description=STRING
	 */
	protected void sequence_InformalPredicate(EObject context, InformalPredicate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.INFORMAL_PREDICATE__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.INFORMAL_PREDICATE__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInformalPredicateAccess().getDescriptionSTRINGTerminalRuleCall_2_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         description=Description? 
	 *         (content+=DocGoal | content+=DocRequirement | content+=DocumentSection)* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_ReqDocument(EObject context, ReqDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parts+=SystemRequirementSet | parts+=GlobalRequirementSet | parts+=StakeholderGoals | parts+=ReqDocument | parts+=GlobalConstants)+
	 */
	protected void sequence_ReqSpec(EObject context, ReqSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         (target=[ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+) 
	 *         importConstants+=[GlobalConstants|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         goals+=Goal* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_StakeholderGoals(EObject context, StakeholderGoals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         target=[ComponentClassifier|AadlClassifierReference] 
	 *         importConstants+=[GlobalConstants|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
	 *         requirements+=SystemRequirement* 
	 *         include+=IncludeGlobalRequirement* 
	 *         docReference+=ExternalDocument* 
	 *         stakeholderGoals+=[ReqRoot|QualifiedName]* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_SystemRequirementSet(EObject context, SystemRequirementSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         targetElement=[NamedElement|ID]? 
	 *         category+=[Category|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
	 *         whencondition=WhenCondition? 
	 *         predicate=ReqPredicate? 
	 *         rationale=Rationale? 
	 *         changeUncertainty=Uncertainty? 
	 *         (exception=[EObject|ID] | exceptionText=STRING)? 
	 *         refinesReference+=[Requirement|QualifiedName]* 
	 *         decomposesReference+=[Requirement|QualifiedName]* 
	 *         inheritsReference=[Requirement|QualifiedName]? 
	 *         evolvesReference+=[Requirement|QualifiedName]* 
	 *         (dropped?='dropped' dropRationale=STRING?)? 
	 *         developmentStakeholder+=[Stakeholder|QualifiedName]* 
	 *         goalReference+=[Goal|QualifiedName]* 
	 *         requirementReference+=[Requirement|QualifiedName]* 
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_SystemRequirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (type=TypeRef | type=PropertyRef | (range?='[' (type=TypeRef | type=PropertyRef)))? value=AExpression property=PropertyRef?)
	 */
	protected void sequence_ValDeclaration(EObject context, ReqValDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (xpression=AAndExpression desiredValue+=DesiredValue*)
	 */
	protected void sequence_ValuePredicate(EObject context, ValuePredicate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((inMode+=[Mode|ID] inMode+=[Mode|ID]*) | (inErrorState+=[ErrorBehaviorState|ID] inErrorState+=[ErrorBehaviorState|ID]*) | condition=AExpression)
	 */
	protected void sequence_WhenCondition(EObject context, WhenCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
