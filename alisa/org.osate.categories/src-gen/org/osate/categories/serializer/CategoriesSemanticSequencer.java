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
import org.osate.categories.categories.CategoryFilters;
import org.osate.categories.categories.CategorySet;
import org.osate.categories.categories.MethodCategories;
import org.osate.categories.categories.MethodCategory;
import org.osate.categories.categories.PhaseCategory;
import org.osate.categories.categories.QualityCategories;
import org.osate.categories.categories.QualityCategory;
import org.osate.categories.categories.RequirementCategories;
import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.SelectionCategories;
import org.osate.categories.categories.SelectionCategory;
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
			case CategoriesPackage.CATEGORY_FILTERS:
				sequence_CategoryFilters(context, (CategoryFilters) semanticObject); 
				return; 
			case CategoriesPackage.CATEGORY_SET:
				sequence_CategorySet(context, (CategorySet) semanticObject); 
				return; 
			case CategoriesPackage.METHOD_CATEGORIES:
				sequence_MethodCategories(context, (MethodCategories) semanticObject); 
				return; 
			case CategoriesPackage.METHOD_CATEGORY:
				sequence_MethodCategory(context, (MethodCategory) semanticObject); 
				return; 
			case CategoriesPackage.PHASE_CATEGORY:
				sequence_PhaseCategory(context, (PhaseCategory) semanticObject); 
				return; 
			case CategoriesPackage.QUALITY_CATEGORIES:
				if(context == grammarAccess.getPhaseCategoriesRule()) {
					sequence_PhaseCategories(context, (QualityCategories) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getQualityCategoriesRule()) {
					sequence_QualityCategories(context, (QualityCategories) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.QUALITY_CATEGORY:
				sequence_QualityCategory(context, (QualityCategory) semanticObject); 
				return; 
			case CategoriesPackage.REQUIREMENT_CATEGORIES:
				sequence_RequirementCategories(context, (RequirementCategories) semanticObject); 
				return; 
			case CategoriesPackage.REQUIREMENT_CATEGORY:
				sequence_RequirementCategory(context, (RequirementCategory) semanticObject); 
				return; 
			case CategoriesPackage.SELECTION_CATEGORIES:
				sequence_SelectionCategories(context, (SelectionCategories) semanticObject); 
				return; 
			case CategoriesPackage.SELECTION_CATEGORY:
				sequence_SelectionCategory(context, (SelectionCategory) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         requirementcategories=RequirementCategories? 
	 *         methodcategories=MethodCategories? 
	 *         selectioncategories=SelectionCategories? 
	 *         phasecategories=PhaseCategories? 
	 *         qualitycategories=QualityCategories? 
	 *         categoryfilter=CategoryFilters?
	 *     )
	 */
	protected void sequence_CategoriesDefinitions(EObject context, CategoriesDefinitions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     filters+=CategorySet+
	 */
	protected void sequence_CategoryFilters(EObject context, CategoryFilters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID elements+=[Category|CatRef]*)
	 */
	protected void sequence_CategorySet(EObject context, CategorySet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     category+=MethodCategory+
	 */
	protected void sequence_MethodCategories(EObject context, MethodCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_MethodCategory(EObject context, MethodCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=PhaseCategory+
	 */
	protected void sequence_PhaseCategories(EObject context, QualityCategories semanticObject) {
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
	 *     category+=RequirementCategory+
	 */
	protected void sequence_RequirementCategories(EObject context, RequirementCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_RequirementCategory(EObject context, RequirementCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=SelectionCategory+
	 */
	protected void sequence_SelectionCategories(EObject context, SelectionCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_SelectionCategory(EObject context, SelectionCategory semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
