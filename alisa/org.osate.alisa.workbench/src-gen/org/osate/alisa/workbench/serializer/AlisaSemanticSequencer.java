package org.osate.alisa.workbench.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AssuranceEvidenceConfiguration;
import org.osate.alisa.workbench.alisa.Description;
import org.osate.alisa.workbench.alisa.DescriptionElement;
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
			case AlisaPackage.ASSURANCE_EVIDENCE_CONFIGURATION:
				if(context == grammarAccess.getAssuranceEvidenceConfigurationRule()) {
					sequence_AssuranceEvidenceConfiguration(context, (AssuranceEvidenceConfiguration) semanticObject); 
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
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID cases+=AssuranceEvidenceConfiguration*)
	 */
	protected void sequence_AlisaWorkArea(EObject context, AlisaWorkArea semanticObject) {
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
	 *         selectionFilter+=[SelectionCategory|ID]*
	 *     )
	 */
	protected void sequence_AssuranceEvidenceConfiguration(EObject context, AssuranceEvidenceConfiguration semanticObject) {
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
}
