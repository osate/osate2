package org.osate.alisa.workbench.serializer;

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
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AssuranceCaseConfiguration;
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
			case AlisaPackage.ASSURANCE_CASE_CONFIGURATION:
				if(context == grammarAccess.getAssuranceCaseConfigurationRule()) {
					sequence_AssuranceCaseConfiguration(context, (AssuranceCaseConfiguration) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == CommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
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
	 *     (name=ID cases+=AssuranceCaseConfiguration*)
	 */
	protected void sequence_AlisaWorkArea(EObject context, AlisaWorkArea semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         title=ValueString? 
	 *         system=[ComponentImplementation|AadlClassifierReference] 
	 *         description=Description? 
	 *         constant+=ConstantDecl* 
	 *         plans+=[VerificationPlan|QualifiedName]+ 
	 *         selectionFilter+=[VerificationCategory|CatRef]*
	 *     )
	 */
	protected void sequence_AssuranceCaseConfiguration(EObject context, AssuranceCaseConfiguration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
