package org.osate.alisa.workbench.serializer;

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
import org.osate.alisa.common.common.FinalValue;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.MultiLineString;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.common.TextElement;
import org.osate.alisa.common.serializer.CommonSemanticSequencer;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AndSelectionConditionExpr;
import org.osate.alisa.workbench.alisa.AssuranceCasePlan;
import org.osate.alisa.workbench.alisa.SelectionCategoryReference;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

@SuppressWarnings("all")
public class AlisaSemanticSequencer extends CommonSemanticSequencer {

	@Inject
	private AlisaGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AlisaPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AlisaPackage.ALISA_WORK_AREA:
				if(context == grammarAccess.getAlisaWorkAreaRule()) {
					sequence_AlisaWorkArea(context, (AlisaWorkArea) semanticObject); 
					return; 
				}
				else break;
			case AlisaPackage.AND_SELECTION_CONDITION_EXPR:
				if(context == grammarAccess.getAndSelectionConditionExprRule() ||
				   context == grammarAccess.getAndSelectionConditionExprAccess().getAndSelectionConditionExprLeftAction_1_0_0_0()) {
					sequence_AndSelectionConditionExpr(context, (AndSelectionConditionExpr) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOrSelectionConditionExprRule() ||
				   context == grammarAccess.getOrSelectionConditionExprAccess().getAndSelectionConditionExprLeftAction_1_0_0_0()) {
					sequence_AndSelectionConditionExpr_OrSelectionConditionExpr(context, (AndSelectionConditionExpr) semanticObject); 
					return; 
				}
				else break;
			case AlisaPackage.ASSURANCE_CASE_PLAN:
				if(context == grammarAccess.getAssuranceCasePlanRule()) {
					sequence_AssuranceCasePlan(context, (AssuranceCasePlan) semanticObject); 
					return; 
				}
				else break;
			case AlisaPackage.SELECTION_CATEGORY_REFERENCE:
				if(context == grammarAccess.getAndSelectionConditionExprRule() ||
				   context == grammarAccess.getAndSelectionConditionExprAccess().getAndSelectionConditionExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getOrSelectionConditionExprRule() ||
				   context == grammarAccess.getOrSelectionConditionExprAccess().getAndSelectionConditionExprLeftAction_1_0_0_0() ||
				   context == grammarAccess.getSelectionCategoryReferenceRule()) {
					sequence_SelectionCategoryReference(context, (SelectionCategoryReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
			case CommonPackage.REFERENCE_PATH:
				if(context == grammarAccess.getReferencePathRule()) {
					sequence_ReferencePath(context, (ReferencePath) semanticObject); 
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID cases+=AssuranceCasePlan*)
	 */
	protected void sequence_AlisaWorkArea(EObject context, AlisaWorkArea semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AndSelectionConditionExpr_AndSelectionConditionExpr_1_0_0_0 right=AndSelectionConditionExpr)
	 */
	protected void sequence_AndSelectionConditionExpr(EObject context, AndSelectionConditionExpr semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlisaPackage.Literals.AND_SELECTION_CONDITION_EXPR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlisaPackage.Literals.AND_SELECTION_CONDITION_EXPR__LEFT));
			if(transientValues.isValueTransient(semanticObject, AlisaPackage.Literals.AND_SELECTION_CONDITION_EXPR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlisaPackage.Literals.AND_SELECTION_CONDITION_EXPR__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAndSelectionConditionExprAccess().getAndSelectionConditionExprLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndSelectionConditionExprAccess().getRightAndSelectionConditionExprParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (left=OrSelectionConditionExpr_AndSelectionConditionExpr_1_0_0_0 right=OrSelectionConditionExpr) | 
	 *         (left=AndSelectionConditionExpr_AndSelectionConditionExpr_1_0_0_0 right=AndSelectionConditionExpr)
	 *     )
	 */
	protected void sequence_AndSelectionConditionExpr_OrSelectionConditionExpr(EObject context, AndSelectionConditionExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         system=[ComponentImplementation|AadlClassifierReference] 
	 *         description=Description? 
	 *         constant+=FinalValue* 
	 *         plans+=[VerificationPlan|QualifiedName]+ 
	 *         selectionFilter=OrSelectionConditionExpr?
	 *     )
	 */
	protected void sequence_AssuranceCasePlan(EObject context, AssuranceCasePlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     cat=[VerificationCategory|CatRef]
	 */
	protected void sequence_SelectionCategoryReference(EObject context, SelectionCategoryReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlisaPackage.Literals.SELECTION_CATEGORY_REFERENCE__CAT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlisaPackage.Literals.SELECTION_CATEGORY_REFERENCE__CAT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSelectionCategoryReferenceAccess().getCatVerificationCategoryCatRefParserRuleCall_0_1(), semanticObject.getCat());
		feeder.finish();
	}
}
