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
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.GlobalRequirements;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.InformalPredicate;
import org.osate.reqspec.reqSpec.Predicate;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirements;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private ReqSpecGrammarAccess grammarAccess;
	
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
		else if(semanticObject.eClass().getEPackage() == ReqSpecPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ReqSpecPackage.DOCUMENT_SECTION:
				sequence_DocumentSection(context, (DocumentSection) semanticObject); 
				return; 
			case ReqSpecPackage.EXTERNAL_DOCUMENT:
				sequence_ExternalDocument(context, (ExternalDocument) semanticObject); 
				return; 
			case ReqSpecPackage.GLOBAL_CONSTANTS:
				sequence_GlobalConstants(context, (GlobalConstants) semanticObject); 
				return; 
			case ReqSpecPackage.GLOBAL_REQUIREMENTS:
				sequence_GlobalRequirements(context, (GlobalRequirements) semanticObject); 
				return; 
			case ReqSpecPackage.GOAL:
				if(context == grammarAccess.getContractualElementRule()) {
					sequence_ContractualElement_DocGoal_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDocGoalRule()) {
					sequence_DocGoal(context, (Goal) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getGoalRule()) {
					sequence_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.INFORMAL_PREDICATE:
				sequence_InformalPredicate(context, (InformalPredicate) semanticObject); 
				return; 
			case ReqSpecPackage.PREDICATE:
				sequence_Predicate(context, (Predicate) semanticObject); 
				return; 
			case ReqSpecPackage.REQ_DOCUMENT:
				sequence_ReqDocument(context, (ReqDocument) semanticObject); 
				return; 
			case ReqSpecPackage.REQ_SPEC:
				sequence_ReqSpec(context, (ReqSpec) semanticObject); 
				return; 
			case ReqSpecPackage.REQUIREMENT:
				if(context == grammarAccess.getContractualElementRule()) {
					sequence_ContractualElement_DocRequirement_Requirement(context, (Requirement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDocRequirementRule()) {
					sequence_DocRequirement(context, (Requirement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRequirementRule()) {
					sequence_Requirement(context, (Requirement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSystemRequirementRule()) {
					sequence_SystemRequirement(context, (Requirement) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.STAKEHOLDER_GOALS:
				sequence_StakeholderGoals(context, (StakeholderGoals) semanticObject); 
				return; 
			case ReqSpecPackage.SYSTEM_REQUIREMENTS:
				sequence_SystemRequirements(context, (SystemRequirements) semanticObject); 
				return; 
			case ReqSpecPackage.VALUE_PREDICATE:
				sequence_ValuePredicate(context, (ValuePredicate) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             name=ID 
	 *             title=STRING? 
	 *             targetElement=[NamedElement|ID]? 
	 *             category+=[RequirementCategory|ID]* 
	 *             category+=[QualityCategory|ID]* 
	 *             category+=[SelectionCategory|ID]* 
	 *             description=Description? 
	 *             constants+=ValDeclaration* 
	 *             rationale=Rationale? 
	 *             changeUncertainty=Uncertainty? 
	 *             refinesReference+=[Goal|QualifiedName]* 
	 *             conflictsReference+=[Goal|QualifiedName]* 
	 *             evolvesReference+=[Requirement|QualifiedName]* 
	 *             (dropped?='dropped' dropRationale=STRING?)? 
	 *             stakeholderReference+=[Stakeholder|QualifiedName]* 
	 *             docReference+=ExternalDocument* 
	 *             issues+=STRING*
	 *         ) | 
	 *         (
	 *             name=ID 
	 *             title=STRING? 
	 *             (targetDescription=STRING | (target=[ComponentClassifier|AadlClassifierReference] targetElement=[NamedElement|ID]?))? 
	 *             category+=[RequirementCategory|ID]* 
	 *             category+=[QualityCategory|ID]* 
	 *             category+=[SelectionCategory|ID]* 
	 *             description=Description? 
	 *             constants+=ValDeclaration* 
	 *             rationale=Rationale? 
	 *             changeUncertainty=Uncertainty? 
	 *             refinesReference+=[Goal|QualifiedName]* 
	 *             conflictsReference+=[Goal|QualifiedName]* 
	 *             evolvesReference+=[Requirement|QualifiedName]* 
	 *             (dropped?='dropped' dropRationale=STRING?)? 
	 *             stakeholderReference+=[Stakeholder|QualifiedName]* 
	 *             docReference+=ExternalDocument* 
	 *             issues+=STRING*
	 *         )
	 *     )
	 */
	protected void sequence_ContractualElement_DocGoal_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             name=ID 
	 *             title=STRING? 
	 *             (componentCategory+=ComponentCategory+ | global?='all')? 
	 *             category+=[RequirementCategory|ID]* 
	 *             category+=[QualityCategory|ID]* 
	 *             category+=[SelectionCategory|ID]* 
	 *             description=Description? 
	 *             constants+=ValDeclaration* 
	 *             computes+=ComputeDeclaration* 
	 *             predicate=ReqPredicate? 
	 *             rationale=Rationale? 
	 *             changeUncertainty=Uncertainty? 
	 *             (exception=[EObject|ID] | exceptionText=STRING)? 
	 *             refinesReference+=[Requirement|QualifiedName]* 
	 *             decomposesReference+=[Requirement|QualifiedName]* 
	 *             evolvesReference+=[Requirement|QualifiedName]* 
	 *             (dropped?='dropped' dropRationale=STRING?)? 
	 *             developmentStakeholder+=[Stakeholder|QualifiedName]* 
	 *             goalReference+=[Goal|QualifiedName]* 
	 *             docReference+=ExternalDocument* 
	 *             issues+=STRING*
	 *         ) | 
	 *         (
	 *             name=ID 
	 *             title=STRING? 
	 *             (
	 *                 targetDescription=STRING | 
	 *                 (target=[ComponentClassifier|AadlClassifierReference] targetElement=[NamedElement|ID]?) | 
	 *                 componentCategory+=ComponentCategory+ | 
	 *                 global?='all'
	 *             )? 
	 *             category+=[RequirementCategory|ID]* 
	 *             category+=[QualityCategory|ID]* 
	 *             category+=[SelectionCategory|ID]* 
	 *             description=Description? 
	 *             constants+=ValDeclaration* 
	 *             computes+=ComputeDeclaration* 
	 *             predicate=ReqPredicate? 
	 *             rationale=Rationale? 
	 *             changeUncertainty=Uncertainty? 
	 *             (exception=[EObject|ID] | exceptionText=STRING)? 
	 *             refinesReference+=[Requirement|QualifiedName]* 
	 *             decomposesReference+=[Requirement|QualifiedName]* 
	 *             evolvesReference+=[Requirement|QualifiedName]* 
	 *             (dropped?='dropped' dropRationale=STRING?)? 
	 *             developmentStakeholder+=[Stakeholder|QualifiedName]* 
	 *             goalReference+=[Goal|QualifiedName]* 
	 *             docReference+=ExternalDocument* 
	 *             issues+=STRING*
	 *         )
	 *     )
	 */
	protected void sequence_ContractualElement_DocRequirement_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (targetDescription=STRING | (target=[ComponentClassifier|AadlClassifierReference] targetElement=[NamedElement|ID]?))? 
	 *         category+=[RequirementCategory|ID]* 
	 *         category+=[QualityCategory|ID]* 
	 *         category+=[SelectionCategory|ID]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
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
	 *             componentCategory+=ComponentCategory+ | 
	 *             global?='all'
	 *         )? 
	 *         category+=[RequirementCategory|ID]* 
	 *         category+=[QualityCategory|ID]* 
	 *         category+=[SelectionCategory|ID]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
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
	 *     (docReference=DOCPATH docFragment=DOCFRAGMENT?)
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
	 *         content+=Requirement* 
	 *         docReference+=ExternalDocument* 
	 *         stakeholderGoals+=[ReqRoot|QualifiedName]* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_GlobalRequirements(EObject context, GlobalRequirements semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         targetElement=[NamedElement|ID]? 
	 *         category+=[RequirementCategory|ID]* 
	 *         category+=[QualityCategory|ID]* 
	 *         category+=[SelectionCategory|ID]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
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
	protected void sequence_Goal(EObject context, Goal semanticObject) {
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
	 *     xpression=AExpression
	 */
	protected void sequence_Predicate(EObject context, Predicate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.PREDICATE__XPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.PREDICATE__XPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPredicateAccess().getXpressionAExpressionParserRuleCall_1_0(), semanticObject.getXpression());
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
	 *     (parts+=SystemRequirements | parts+=GlobalRequirements | parts+=StakeholderGoals | parts+=ReqDocument | parts+=GlobalConstants)+
	 */
	protected void sequence_ReqSpec(EObject context, ReqSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=STRING? 
	 *         (componentCategory+=ComponentCategory+ | global?='all')? 
	 *         category+=[RequirementCategory|ID]* 
	 *         category+=[QualityCategory|ID]* 
	 *         category+=[SelectionCategory|ID]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
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
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         title=STRING? 
	 *         (target=[ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ | global?='all') 
	 *         importConstants+=[GlobalConstants|QualifiedName]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         content+=Goal* 
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
	 *         name=ID 
	 *         title=STRING? 
	 *         targetElement=[NamedElement|ID]? 
	 *         category+=[RequirementCategory|ID]* 
	 *         category+=[QualityCategory|ID]* 
	 *         category+=[SelectionCategory|ID]* 
	 *         description=Description? 
	 *         constants+=ValDeclaration* 
	 *         computes+=ComputeDeclaration* 
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
	 *         docReference+=ExternalDocument* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_SystemRequirement(EObject context, Requirement semanticObject) {
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
	 *         content+=SystemRequirement* 
	 *         docReference+=ExternalDocument* 
	 *         stakeholderGoals+=[ReqRoot|QualifiedName]* 
	 *         issues+=STRING*
	 *     )
	 */
	protected void sequence_SystemRequirements(EObject context, SystemRequirements semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     xpression=AAndExpression
	 */
	protected void sequence_ValuePredicate(EObject context, ValuePredicate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.VALUE_PREDICATE__XPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.VALUE_PREDICATE__XPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getValuePredicateAccess().getXpressionAAndExpressionParserRuleCall_2_0(), semanticObject.getXpression());
		feeder.finish();
	}
}
