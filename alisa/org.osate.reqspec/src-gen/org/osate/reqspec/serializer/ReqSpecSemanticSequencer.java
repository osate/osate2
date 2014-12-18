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
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.Hazard;
import org.osate.reqspec.reqSpec.RSLVariable;
import org.osate.reqspec.reqSpec.ReqSpecContainer;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private ReqSpecGrammarAccess grammarAccess;
	
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
		else if(semanticObject.eClass().getEPackage() == ReqSpecPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ReqSpecPackage.EXTERNAL_DOCUMENT:
				if(context == grammarAccess.getExternalDocumentRule()) {
					sequence_ExternalDocument(context, (ExternalDocument) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.GOAL:
				if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getGoalRule()) {
					sequence_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.HAZARD:
				if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getHazardRule()) {
					sequence_Hazard(context, (Hazard) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.RSL_VARIABLE:
				if(context == grammarAccess.getRSLVariableRule()) {
					sequence_RSLVariable(context, (RSLVariable) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_SPEC_CONTAINER:
				if(context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecModelRule()) {
					sequence_ReqSpecContainer(context, (ReqSpecContainer) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQUIREMENT:
				if(context == grammarAccess.getContractualElementRule() ||
				   context == grammarAccess.getRequirementRule()) {
					sequence_Requirement(context, (Requirement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
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
	 *     (
	 *         name=ID 
	 *         target=[NamedElement|QNEREF]? 
	 *         category=[RequirementCategory|CATREF]? 
	 *         title=ValueString? 
	 *         description=Description? 
	 *         assert=ValueString? 
	 *         rationale=ValueString? 
	 *         (issue+=ValueString issue+=ValueString*)? 
	 *         (refinesReference+=[Goal|DOTTEDREF] refinesReference+=[Goal|DOTTEDREF]*)? 
	 *         subgoal+=Goal* 
	 *         (decomposesReference+=[Goal|DOTTEDREF] decomposesReference+=[Goal|DOTTEDREF]*)? 
	 *         (evolvesReference+=[Goal|DOTTEDREF] evolvesReference+=[Goal|DOTTEDREF]*)? 
	 *         (conflictsReference+=[Goal|DOTTEDREF] conflictsReference+=[Goal|DOTTEDREF]*)? 
	 *         (stakeholderReference+=[Stakeholder|DOTTEDREF] stakeholderReference+=[Stakeholder|DOTTEDREF]*)? 
	 *         (stakeholderRequirementReference+=[Goal|DOTTEDREF] stakeholderRequirementReference+=[Goal|DOTTEDREF]*)? 
	 *         (systemRequirementReference+=[ContractualElement|DOTTEDREF] systemRequirementReference+=[ContractualElement|DOTTEDREF]*)? 
	 *         (docReference+=ExternalDocument docReference+=ExternalDocument*)?
	 *     )
	 */
	protected void sequence_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[NamedElement|QNEREF]? 
	 *         category=[HazardCategory|CATREF]? 
	 *         title=ValueString? 
	 *         description=ValueString? 
	 *         mitigated=[Requirement|DOTTEDREF]? 
	 *         rationale=ValueString? 
	 *         (issue+=ValueString issue+=ValueString*)?
	 *     )
	 */
	protected void sequence_Hazard(EObject context, Hazard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=ValueString)
	 */
	protected void sequence_RSLVariable(EObject context, RSLVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.RSL_VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.RSL_VARIABLE__NAME));
			if(transientValues.isValueTransient(semanticObject, ReqSpecPackage.Literals.RSL_VARIABLE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReqSpecPackage.Literals.RSL_VARIABLE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRSLVariableAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getRSLVariableAccess().getValueValueStringParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[NamedElement|QNEREF]? 
	 *         (content+=Goal | content+=Requirement | content+=ReqSpecContainer)* 
	 *         (issue+=ValueString issue+=ValueString*)?
	 *     )
	 */
	protected void sequence_ReqSpecContainer(EObject context, ReqSpecContainer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[NamedElement|QNEREF]? 
	 *         category=[RequirementCategory|CATREF]? 
	 *         title=ValueString? 
	 *         description=Description? 
	 *         assert=ValueString? 
	 *         rationale=ValueString? 
	 *         reqValue+=RSLVariable* 
	 *         (issue+=ValueString issue+=ValueString*)? 
	 *         (goalReference+=[Goal|ID] goalReference+=[Goal|ID]*)? 
	 *         (hazardReference+=QNEREF hazardReference+=QNEREF*)? 
	 *         (refinesReference+=[Requirement|DOTTEDREF] refinesReference+=[Requirement|DOTTEDREF]*)? 
	 *         subrequirement+=Requirement* 
	 *         (decomposesReference+=[Requirement|DOTTEDREF] decomposesReference+=[Requirement|DOTTEDREF]*)? 
	 *         (evolvesReference+=[Requirement|DOTTEDREF] evolvesReference+=[Requirement|DOTTEDREF]*)? 
	 *         (stakeholderRequirementReference+=[Goal|DOTTEDREF] stakeholderRequirementReference+=[Goal|DOTTEDREF]*)? 
	 *         (systemRequirementReference+=[ContractualElement|DOTTEDREF] systemRequirementReference+=[ContractualElement|DOTTEDREF]*)? 
	 *         (docReference+=ExternalDocument docReference+=ExternalDocument*)?
	 *     )
	 */
	protected void sequence_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
