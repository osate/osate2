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
import org.osate.categories.categories.DevelopmentPhase;
import org.osate.categories.categories.DevelopmentPhaseCategories;
import org.osate.categories.categories.MethodType;
import org.osate.categories.categories.MethodTypeCategories;
import org.osate.categories.categories.QualityAttribute;
import org.osate.categories.categories.QualityAttributeCategories;
import org.osate.categories.categories.RequirementType;
import org.osate.categories.categories.RequirementTypeCategories;
import org.osate.categories.categories.UserSelection;
import org.osate.categories.categories.UserSelectionCategories;
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
			case CategoriesPackage.DEVELOPMENT_PHASE:
				sequence_DevelopmentPhase(context, (DevelopmentPhase) semanticObject); 
				return; 
			case CategoriesPackage.DEVELOPMENT_PHASE_CATEGORIES:
				sequence_DevelopmentPhaseCategories(context, (DevelopmentPhaseCategories) semanticObject); 
				return; 
			case CategoriesPackage.METHOD_TYPE:
				sequence_MethodType(context, (MethodType) semanticObject); 
				return; 
			case CategoriesPackage.METHOD_TYPE_CATEGORIES:
				sequence_MethodTypeCategories(context, (MethodTypeCategories) semanticObject); 
				return; 
			case CategoriesPackage.QUALITY_ATTRIBUTE:
				sequence_QualityAttribute(context, (QualityAttribute) semanticObject); 
				return; 
			case CategoriesPackage.QUALITY_ATTRIBUTE_CATEGORIES:
				sequence_QualityAttributeCategories(context, (QualityAttributeCategories) semanticObject); 
				return; 
			case CategoriesPackage.REQUIREMENT_TYPE:
				sequence_RequirementType(context, (RequirementType) semanticObject); 
				return; 
			case CategoriesPackage.REQUIREMENT_TYPE_CATEGORIES:
				sequence_RequirementTypeCategories(context, (RequirementTypeCategories) semanticObject); 
				return; 
			case CategoriesPackage.USER_SELECTION:
				sequence_UserSelection(context, (UserSelection) semanticObject); 
				return; 
			case CategoriesPackage.USER_SELECTION_CATEGORIES:
				sequence_UserSelectionCategories(context, (UserSelectionCategories) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         requirementTypeCategories=RequirementTypeCategories? 
	 *         methodTypeCategories=MethodTypeCategories? 
	 *         selectioncategories=UserSelectionCategories? 
	 *         developmentPhaseCategories=DevelopmentPhaseCategories? 
	 *         qualityAttributeCategories=QualityAttributeCategories?
	 *     )
	 */
	protected void sequence_CategoriesDefinitions(EObject context, CategoriesDefinitions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (requirementType+=[RequirementType|ID]+ anyRequirementType?='any'?)? 
	 *         (methodType+=[MethodType|ID]+ anyMethodType?='any'?)? 
	 *         (userSelection+=[UserSelection|ID]+ anyUserSelection?='any'?)? 
	 *         (qualityAttribute+=[QualityAttribute|ID]+ anyQualityAttribute?='any'?)? 
	 *         (developmentPhase+=[DevelopmentPhase|ID]+ anyDevelopmentPhase?='any'?)?
	 *     )
	 */
	protected void sequence_CategoryFilter(EObject context, CategoryFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     category+=DevelopmentPhase+
	 */
	protected void sequence_DevelopmentPhaseCategories(EObject context, DevelopmentPhaseCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_DevelopmentPhase(EObject context, DevelopmentPhase semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDevelopmentPhaseAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=MethodType+
	 */
	protected void sequence_MethodTypeCategories(EObject context, MethodTypeCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_MethodType(EObject context, MethodType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMethodTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=QualityAttribute+
	 */
	protected void sequence_QualityAttributeCategories(EObject context, QualityAttributeCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_QualityAttribute(EObject context, QualityAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQualityAttributeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=RequirementType+
	 */
	protected void sequence_RequirementTypeCategories(EObject context, RequirementTypeCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_RequirementType(EObject context, RequirementType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRequirementTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     category+=UserSelection+
	 */
	protected void sequence_UserSelectionCategories(EObject context, UserSelectionCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_UserSelection(EObject context, UserSelection semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CategoriesPackage.Literals.CATEGORY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUserSelectionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
