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
import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.IntegerTerm;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.MultiLineString;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.RealTerm;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.StringTerm;
import org.osate.alisa.common.common.TextElement;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.GoalFolder;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpecFolder;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ReqSpecs;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private ReqSpecGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CommonPackage.CONSTANT_DECL:
				if(context == grammarAccess.getConstantDeclRule()) {
					sequence_ConstantDecl(context, (ConstantDecl) semanticObject); 
					return; 
				}
				else break;
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
			case CommonPackage.INTEGER_TERM:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getIntegerTermRule()) {
					sequence_IntegerTerm(context, (IntegerTerm) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.MULTI_LINE_STRING:
				if(context == grammarAccess.getMultiLineStringRule()) {
					sequence_MultiLineString(context, (MultiLineString) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.PREDICATE_EXPRESSION:
				if(context == grammarAccess.getPredicateExpressionRule()) {
					sequence_PredicateExpression(context, (PredicateExpression) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.REAL_TERM:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getRealTermRule()) {
					sequence_RealTerm(context, (RealTerm) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.REFERENCE_PATH:
				if(context == grammarAccess.getReferencePathRule()) {
					sequence_ReferencePath(context, (ReferencePath) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.SHOW_VALUE:
				if(context == grammarAccess.getShowValueRule()) {
					sequence_ShowValue(context, (ShowValue) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.STRING_TERM:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getStringTermRule()) {
					sequence_StringTerm(context, (StringTerm) semanticObject); 
					return; 
				}
				else break;
			case CommonPackage.TEXT_ELEMENT:
				if(context == grammarAccess.getTextElementRule()) {
					sequence_TextElement(context, (TextElement) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == ReqSpecPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ReqSpecPackage.DOCUMENT_SECTION:
				if(context == grammarAccess.getDocumentSectionRule()) {
					sequence_DocumentSection(context, (DocumentSection) semanticObject); 
					return; 
				}
				else break;
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
			case ReqSpecPackage.GOAL_FOLDER:
				if(context == grammarAccess.getGoalFolderRule() ||
				   context == grammarAccess.getReqSpecContainerRule()) {
					sequence_GoalFolder(context, (GoalFolder) semanticObject); 
					return; 
				}
				else break;
			case ReqSpecPackage.REQ_DOCUMENT:
				if(context == grammarAccess.getReqDocumentRule() ||
				   context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule()) {
					sequence_ReqDocument(context, (ReqDocument) semanticObject); 
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
			case ReqSpecPackage.REQ_SPECS:
				if(context == grammarAccess.getReqRootRule() ||
				   context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getReqSpecsRule()) {
					sequence_ReqSpecs(context, (ReqSpecs) semanticObject); 
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
				   context == grammarAccess.getReqSpecRule() ||
				   context == grammarAccess.getReqSpecContainerRule() ||
				   context == grammarAccess.getStakeholderGoalsRule()) {
					sequence_StakeholderGoals(context, (StakeholderGoals) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (label=ID title=ValueString? description=MultiLineString? (content+=Goal | content+=Requirement | content+=DocumentSection)*)
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
	 *     (label=ID title=ValueString? (content+=Goal | content+=GoalFolder)*)
	 */
	protected void sequence_GoalFolder(EObject context, GoalFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         (target=[NamedElement|ID] | targetDescription=ValueString)? 
	 *         category=[RequirementCategory|CatRef]? 
	 *         description=Description? 
	 *         rationale=ValueString? 
	 *         refinesReference+=[Goal|QualifiedName]* 
	 *         conflictsReference+=[Goal|QualifiedName]* 
	 *         stakeholderReference+=[Stakeholder|QualifiedName]* 
	 *         documentRequirement+=[ContractualElement|QualifiedName]* 
	 *         docReference+=ExternalDocument*
	 *     )
	 */
	protected void sequence_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID title=ValueString? description=MultiLineString? content+=DocumentSection)
	 */
	protected void sequence_ReqDocument(EObject context, ReqDocument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (label=ID title=ValueString? (content+=Goal | content+=Requirement | content+=ReqSpecFolder)*)
	 */
	protected void sequence_ReqSpecFolder(EObject context, ReqSpecFolder semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         (target=[Classifier|AadlClassifierReference] | targetDescription=ValueString)? 
	 *         otherreqspecs+=[ReqSpecs|QualifiedName]* 
	 *         constants+=ConstantDecl* 
	 *         (content+=Requirement | content+=ReqSpecFolder)*
	 *     )
	 */
	protected void sequence_ReqSpecs(EObject context, ReqSpecs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         (target=[NamedElement|ID] | targetDescription=ValueString)? 
	 *         category=[RequirementCategory|CatRef]? 
	 *         description=Description? 
	 *         constants+=ConstantDecl* 
	 *         assert=PredicateExpression? 
	 *         rationale=STRING? 
	 *         goalReference+=[Goal|QualifiedName]* 
	 *         (exception=[EObject|ID] | exceptionText=ValueString)? 
	 *         refinedReference+=[Requirement|QualifiedName]* 
	 *         stakeholderRequirementReference+=[Goal|QualifiedName]* 
	 *         documentRequirement+=[ContractualElement|QualifiedName]* 
	 *         docReference+=ExternalDocument*
	 *     )
	 */
	protected void sequence_Requirement(EObject context, Requirement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         (target=[Classifier|AadlClassifierReference] | targetDescription=ValueString)? 
	 *         description=MultiLineString? 
	 *         (content+=Goal | content+=GoalFolder)
	 *     )
	 */
	protected void sequence_StakeholderGoals(EObject context, StakeholderGoals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
