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
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.FinalValue;
import org.osate.alisa.common.common.Model;
import org.osate.alisa.common.common.PredicateExpression;
import org.osate.alisa.common.common.ReferencePath;
import org.osate.alisa.common.services.CommonGrammarAccess;

@SuppressWarnings("all")
public class CommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CommonGrammarAccess grammarAccess;
	
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (text=STRING | ref=[EObject|ID])
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
	 *     (name=ID value=ValueString)
	 */
	protected void sequence_FinalValue(EObject context, FinalValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.FINAL_VALUE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.FINAL_VALUE__NAME));
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.FINAL_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.FINAL_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFinalValueAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFinalValueAccess().getValueValueStringParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     content=Description
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.MODEL__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.MODEL__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelAccess().getContentDescriptionParserRuleCall_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         op='=' | 
	 *         op='!=' | 
	 *         op='<' | 
	 *         op='=<' | 
	 *         op='>' | 
	 *         op='>='
	 *     )
	 */
	protected void sequence_PredicateExpression(EObject context, PredicateExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[EObject|ID] subpath=ReferencePath)
	 */
	protected void sequence_ReferencePath(EObject context, ReferencePath semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.REFERENCE_PATH__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.REFERENCE_PATH__REF));
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.REFERENCE_PATH__SUBPATH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.REFERENCE_PATH__SUBPATH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1(), semanticObject.getRef());
		feeder.accept(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0(), semanticObject.getSubpath());
		feeder.finish();
	}
}
