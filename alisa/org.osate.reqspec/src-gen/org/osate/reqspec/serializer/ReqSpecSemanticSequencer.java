package org.osate.reqspec.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.FinalValue;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.Hazard;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecFolder;
import org.osate.reqspec.reqSpec.ReqSpecLibrary;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemSpec;
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
			case CommonPackage.FINAL_VALUE:
				if(context == grammarAccess.getFinalValueRule()) {
					sequence_FinalValue(context, (FinalValue) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.PREDICATE_EXPRESSION:
				if(context == grammarAccess.getPredicateExpressionRule()) {
					sequence_PredicateExpression(context, (PredicateExpression) semanticObject); 
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
			case ReqSpecPackage.REQ_DOCUMENT:
				if(context == grammarAccess.getReqDocumentRule() ||
				   context == grammarAccess.getReqRootRule()) {
					sequence_ReqDocument(context, (ReqDocument) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_SPEC:
				if(context == grammarAccess.getReqSpecRule()) {
					sequence_ReqSpec(context, (ReqSpec) semanticObject); 
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
			case ReqSpecPackage.REQ_SPEC_LIBRARY:
				if(context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecLibraryRule()) {
					sequence_ReqSpecLibrary(context, (ReqSpecLibrary) semanticObject); 
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
			case ReqSpecPackage.STAKEHOLDER_GOALS:
				if(context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getStakeholderGoalsRule()) {
					sequence_StakeholderGoals(context, (StakeholderGoals) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.SYSTEM_SPEC:
				if(context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getSystemSpecRule()) {
					sequence_SystemSpec(context, (SystemSpec) semanticObject); 
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
	 *         assert=PredicateExpression? 
	 *         rationale=STRING? 
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
	 *         title=ValueString? 
	 *         target=[NamedElement|ID]? 
	 *         category=[HazardCategory|CatRef]? 
	 *         description=Description? 
	 *         (requirementReference+=[Requirement|QualifiedName] requirementReference+=[Requirement|QualifiedName]*)? 
	 *         rationale=STRING?
	 *     )
	 */
	protected void sequence_Hazard(EObject context, Hazard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID consistsOf+=[ReqSpecLibrary|QualifiedName])
	 */
	protected void sequence_ReqDocument(EObject context, ReqDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID (content+=Goal | content+=Requirement | content+=Hazard | content+=ReqSpecFolder)*)
	 */
	protected void sequence_ReqSpecFolder(EObject context, ReqSpecFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         importedNamespace=QualifiedNameWithWildCard? 
	 *         target=[Classifier|AadlClassifierReference]? 
	 *         constants+=FinalValue* 
	 *         (content+=Goal | content+=Requirement | content+=Hazard | content+=ReqSpecFolder)*
	 *     )
	 */
	protected void sequence_ReqSpecLibrary(EObject context, ReqSpecLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (contents+=ReqSpecLibrary | contents+=SystemSpec | contents+=StakeholderGoals | contents+=ReqDocument)
	 */
	protected void sequence_ReqSpec(EObject context, ReqSpec semanticObject) {
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
	 *         constants+=FinalValue* 
	 *         assert=PredicateExpression? 
	 *         rationale=STRING? 
	 *         (goalReference+=[Goal|QualifiedName] goalReference+=[Goal|QualifiedName]*)? 
	 *         (refinedReference+=[Requirement|QualifiedName] refinesReference+=[Requirement|QualifiedName]*)? 
	 *         subrequirement+=Requirement* 
	 *         (decomposedReference+=[Requirement|QualifiedName] decomposesReference+=[Requirement|QualifiedName]*)? 
	 *         (evolvesReference+=[Requirement|QualifiedName] evolvesReference+=[Requirement|QualifiedName]*)? 
	 *         (stakeholderRequirementReference+=[Goal|QualifiedName] stakeholderRequirementReference+=[Goal|QualifiedName]*)? 
	 *         (systemRequirementReference+=[ContractualElement|QualifiedName] systemRequirementReference+=[ContractualElement|QualifiedName]*)? 
	 *         (docReference+=ExternalDocument docReference+=ExternalDocument*)?
	 *     )
	 */
	protected void sequence_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID consistsOf+=[ReqSpecLibrary|QualifiedName])
	 */
	protected void sequence_StakeholderGoals(EObject context, StakeholderGoals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID target=[Classifier|AadlClassifierReference] consistsOf+=[ReqSpecLibrary|QualifiedName])
	 */
	protected void sequence_SystemSpec(EObject context, SystemSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
