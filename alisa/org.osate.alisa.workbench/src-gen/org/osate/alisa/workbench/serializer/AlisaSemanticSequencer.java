package org.osate.alisa.workbench.serializer;

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
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AndSelectionConditionExpr;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.alisa.AssuranceTask;
import org.osate.alisa.workbench.alisa.Description;
import org.osate.alisa.workbench.alisa.DescriptionElement;
import org.osate.alisa.workbench.alisa.SelectionCategoryReference;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

@SuppressWarnings("all")
public class AlisaSemanticSequencer extends AbstractDelegatingSemanticSequencer {

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
			case AlisaPackage.ASSURANCE_PLAN:
				if(context == grammarAccess.getAssurancePlanRule()) {
					sequence_AssurancePlan(context, (AssurancePlan) semanticObject); 
					return; 
				}
				else break;
			case AlisaPackage.ASSURANCE_TASK:
				if(context == grammarAccess.getAssuranceTaskRule()) {
					sequence_AssuranceTask(context, (AssuranceTask) semanticObject); 
					return; 
				}
				else break;
			case AlisaPackage.DESCRIPTION:
				if(context == grammarAccess.getDescriptionRule()) {
					sequence_Description(context, (Description) semanticObject); 
					return; 
				}
				else break;
			case AlisaPackage.DESCRIPTION_ELEMENT:
				if(context == grammarAccess.getDescriptionElementRule()) {
					sequence_DescriptionElement(context, (DescriptionElement) semanticObject); 
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID (cases+=AssurancePlan | cases+=AssuranceTask)*)
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
	 *         title=STRING? 
	 *         system=[ComponentImplementation|AadlClassifierReference] 
	 *         description=Description? 
	 *         plans+=[VerificationPlan|QualifiedName]+ 
	 *         verifiedAssumption+=[ComponentClassifier|AadlClassifierReference]*
	 *     )
	 */
	protected void sequence_AssurancePlan(EObject context, AssurancePlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID title=STRING? assurancePlan=[AssurancePlan|ID] filter=OrSelectionConditionExpr)
	 */
	protected void sequence_AssuranceTask(EObject context, AssuranceTask semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (text=STRING | thisTarget?='this')
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
	 *     cat=[Category|ID]
	 */
	protected void sequence_SelectionCategoryReference(EObject context, SelectionCategoryReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlisaPackage.Literals.SELECTION_CATEGORY_REFERENCE__CAT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlisaPackage.Literals.SELECTION_CATEGORY_REFERENCE__CAT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSelectionCategoryReferenceAccess().getCatCategoryIDTerminalRuleCall_0_1(), semanticObject.getCat());
		feeder.finish();
	}
}
