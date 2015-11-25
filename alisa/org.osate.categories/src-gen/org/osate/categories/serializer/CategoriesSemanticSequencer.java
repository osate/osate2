/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
package org.osate.categories.serializer;

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
import org.osate.categories.categories.CategoriesDefinitions;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;
import org.osate.categories.categories.PhaseCategories;
import org.osate.categories.categories.PhaseCategory;
import org.osate.categories.categories.QualityCategories;
import org.osate.categories.categories.QualityCategory;
import org.osate.categories.categories.UserCategories;
import org.osate.categories.categories.UserCategory;
import org.osate.categories.services.CategoriesGrammarAccess;

@SuppressWarnings("all")
public class CategoriesSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CategoriesGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CategoriesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CategoriesPackage.CATEGORIES_DEFINITIONS:
				sequence_CategoriesDefinitions(context, (CategoriesDefinitions) semanticObject); 
				return; 
			case CategoriesPackage.CATEGORY_FILTER:
				sequence_CategoryFilter(context, (CategoryFilter) semanticObject); 
				return; 
			case CategoriesPackage.PHASE_CATEGORIES:
				sequence_PhaseCategories(context, (PhaseCategories) semanticObject); 
				return; 
			case CategoriesPackage.PHASE_CATEGORY:
				sequence_PhaseCategory(context, (PhaseCategory) semanticObject); 
				return; 
			case CategoriesPackage.QUALITY_CATEGORIES:
				sequence_QualityCategories(context, (QualityCategories) semanticObject); 
				return; 
			case CategoriesPackage.QUALITY_CATEGORY:
				sequence_QualityCategory(context, (QualityCategory) semanticObject); 
				return; 
			case CategoriesPackage.USER_CATEGORIES:
				sequence_UserCategories(context, (UserCategories) semanticObject); 
				return; 
			case CategoriesPackage.USER_CATEGORY:
				sequence_UserCategory(context, (UserCategory) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (userCategories=UserCategories? phaseCategories=PhaseCategories? qualityCategories=QualityCategories?)
	 */
	protected void sequence_CategoriesDefinitions(EObject context, CategoriesDefinitions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (userCategory+=[UserCategory|ID]+ anyUserSelection?='any'?)? 
	 *         (qualityCategory+=[QualityCategory|ID]+ anyQualityAttribute?='any'?)? 
	 *         (phaseCategory+=[PhaseCategory|ID]+ anyDevelopmentPhase?='any'?)?
	 *     )
	 */
	protected void sequence_CategoryFilter(EObject context, CategoryFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     category+=PhaseCategory+
	 */
	protected void sequence_PhaseCategories(EObject context, PhaseCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_PhaseCategory(EObject context, PhaseCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=QualityCategory+
	 */
	protected void sequence_QualityCategories(EObject context, QualityCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_QualityCategory(EObject context, QualityCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=UserCategory+
	 */
	protected void sequence_UserCategories(EObject context, UserCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_UserCategory(EObject context, UserCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
