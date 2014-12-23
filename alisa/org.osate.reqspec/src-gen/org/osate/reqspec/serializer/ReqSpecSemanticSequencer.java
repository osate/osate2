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
import org.osate.alisa.common.common.Import;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.Hazard;
import org.osate.reqspec.reqSpec.RSLVariable;
import org.osate.reqspec.reqSpec.ReqSpecDocument;
import org.osate.reqspec.reqSpec.ReqSpecFolder;
import org.osate.reqspec.reqSpec.ReqSpecModel;
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
			case CommonPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
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
			case ReqSpecPackage.REQ_SPEC_DOCUMENT:
				if(context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecDocumentRule()) {
					sequence_ReqSpecDocument(context, (ReqSpecDocument) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_SPEC_FOLDER:
				if(context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecFolderRule()) {
					sequence_ReqSpecFolder(context, (ReqSpecFolder) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_SPEC_MODEL:
				if(context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecModelRule()) {
					sequence_ReqSpecModel(context, (ReqSpecModel) semanticObject); 
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
	 *         title=ValueString? 
	 *         target=[NamedElement|ID]? 
	 *         category=[RequirementCategory|CatRef]? 
	 *         description=Description? 
	 *         assert=ValueString? 
	 *         rationale=ValueString? 
	 *         (issue+=ValueString issue+=ValueString*)? 
	 *         (refinesReference+=[Goal|QualifiedName] refinesReference+=[Goal|QualifiedName]*)? 
	 *         subgoal+=Goal* 
	 *         (decomposesReference+=[Goal|QualifiedName] decomposesReference+=[Goal|QualifiedName]*)? 
	 *         (evolvesReference+=[Goal|QualifiedName] evolvesReference+=[Goal|QualifiedName]*)? 
	 *         (conflictsReference+=[Goal|QualifiedName] conflictsReference+=[Goal|QualifiedName]*)? 
	 *         (stakeholderReference+=[Stakeholder|QualifiedName] stakeholderReference+=[Stakeholder|QualifiedName]*)? 
	 *         (stakeholderRequirementReference+=[Goal|QualifiedName] stakeholderRequirementReference+=[Goal|QualifiedName]*)? 
	 *         (systemRequirementReference+=[ContractualElement|QualifiedName] systemRequirementReference+=[ContractualElement|QualifiedName]*)? 
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
	 *         target=[NamedElement|ID]? 
	 *         category=[HazardCategory|CatRef]? 
	 *         title=ValueString? 
	 *         description=ValueString? 
	 *         mitigated=[Requirement|QualifiedName]? 
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
	 *         docref=ExternalDocument? 
	 *         target=[Classifier|AadlClassifierReference]? 
	 *         (content+=Goal | content+=Requirement | content+=ReqSpecFolder)* 
	 *         (issue+=ValueString issue+=ValueString*)?
	 *     )
	 */
	protected void sequence_ReqSpecDocument(EObject context, ReqSpecDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         label=ID 
	 *         target=[Classifier|AadlClassifierReference]? 
	 *         (content+=Goal | content+=Requirement | content+=ReqSpecFolder)* 
	 *         (issue+=ValueString issue+=ValueString*)?
	 *     )
	 */
	protected void sequence_ReqSpecFolder(EObject context, ReqSpecFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         target=[Classifier|AadlClassifierReference]? 
	 *         import+=Import* 
	 *         (content+=Goal | content+=Requirement | content+=ReqSpecFolder)* 
	 *         (issue+=ValueString issue+=ValueString*)?
	 *     )
	 */
	protected void sequence_ReqSpecModel(EObject context, ReqSpecModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         category=[RequirementCategory|CatRef]? 
	 *         target=[NamedElement|ID]? 
	 *         description=Description? 
	 *         assert=ValueString? 
	 *         rationale=ValueString? 
	 *         reqValue+=RSLVariable* 
	 *         (issue+=ValueString issue+=ValueString*)? 
	 *         (goalReference+=[Goal|ID] goalReference+=[Goal|ID]*)? 
	 *         (hazardReference+=AadlClassifierReference hazardReference+=AadlClassifierReference*)? 
	 *         (refinesReference+=[Requirement|QualifiedName] refinesReference+=[Requirement|QualifiedName]*)? 
	 *         subrequirement+=Requirement* 
	 *         (decomposesReference+=[Requirement|QualifiedName] decomposesReference+=[Requirement|QualifiedName]*)? 
	 *         (evolvesReference+=[Requirement|QualifiedName] evolvesReference+=[Requirement|QualifiedName]*)? 
	 *         (stakeholderRequirementReference+=[Goal|QualifiedName] stakeholderRequirementReference+=[Goal|QualifiedName]*)? 
	 *         (systemRequirementReference+=[ContractualElement|QualifiedName] systemRequirementReference+=[ContractualElement|QualifiedName]*)? 
	 *         (docReference+=ExternalDocument docReference+=ExternalDocument*)?
	 *     )
	 */
	protected void sequence_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
