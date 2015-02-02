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
import org.osate.alisa.common.services.CommonGrammarAccess;

@SuppressWarnings("all")
public class CommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CommonGrammarAccess grammarAccess;
	
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID value=ConstantValue)
	 */
	protected void sequence_ConstantDecl(EObject context, ConstantDecl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.CONSTANT_DECL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.CONSTANT_DECL__NAME));
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.CONSTANT_DECL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.CONSTANT_DECL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConstantDeclAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getConstantDeclAccess().getValueConstantValueParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (text=STRING | value=ShowValue | newline?='&' | thisTarget?='this')
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
	 *     (value=INT unit=ID?)
	 */
	protected void sequence_IntegerTerm(EObject context, IntegerTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *     description+=TextElement+
	 */
	protected void sequence_MultiLineString(EObject context, MultiLineString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         op='=' | 
	 *         op='!=' | 
	 *         op='<' | 
	 *         op='<=' | 
	 *         op='>' | 
	 *         op='>='
	 *     )
	 */
	protected void sequence_PredicateExpression(EObject context, PredicateExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=REAL unit=ID?)
	 */
	protected void sequence_RealTerm(EObject context, RealTerm semanticObject) {
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
	
	
	/**
	 * Constraint:
	 *     (ref=[EObject|ID] unit=ID?)
	 */
	protected void sequence_ShowValue(EObject context, ShowValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringTerm(EObject context, StringTerm semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CommonPackage.Literals.STRING_TERM__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CommonPackage.Literals.STRING_TERM__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringTermAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (text=STRING | newline?='&')
	 */
	protected void sequence_TextElement(EObject context, TextElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
