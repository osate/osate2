/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.IfCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;

@SuppressWarnings("all")
public abstract class AbstractErrorModelSemanticSequencer extends PropertiesSemanticSequencer {

	@Inject
	private ErrorModelGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				sequence_ArrayRange(context, (ArrayRange) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.CLASSIFIER_VALUE:
				sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
				return; 
			case Aadl2Package.COMPUTED_VALUE:
				sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
				return; 
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
				return; 
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.LIST_VALUE:
				sequence_ListTerm(context, (ListValue) semanticObject); 
				return; 
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if (rule == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if (rule == grammarAccess.getConstantValueRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPModelRule()
						|| rule == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_RealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.RECORD_VALUE:
				if (rule == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if (epackage == ErrorModelPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ErrorModelPackage.ALL_EXPRESSION:
				if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getConditionExpressionRule()
						|| action == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getAllExpressionRule()
						|| rule == grammarAccess.getConditionTermRule()) {
					sequence_AllExpression(context, (AllExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSConditionExpressionRule()
						|| action == grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSAndExpressionRule()
						|| action == grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSAllExpressionRule()
						|| rule == grammarAccess.getSConditionTermRule()) {
					sequence_SAllExpression(context, (AllExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.AND_EXPRESSION:
				if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getConditionExpressionRule()
						|| action == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getConditionTermRule()) {
					sequence_AndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSConditionExpressionRule()
						|| action == grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSAndExpressionRule()
						|| action == grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSConditionTermRule()) {
					sequence_SAndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.BRANCH_VALUE:
				sequence_BranchValue(context, (BranchValue) semanticObject); 
				return; 
			case ErrorModelPackage.COMPOSITE_STATE:
				sequence_CompositeState(context, (CompositeState) semanticObject); 
				return; 
			case ErrorModelPackage.CONDITION_ELEMENT:
				sequence_ConditionElement(context, (ConditionElement) semanticObject); 
				return; 
			case ErrorModelPackage.EMV2_PATH:
				if (rule == grammarAccess.getBasicEMV2PathRule()) {
					sequence_BasicEMV2Path(context, (EMV2Path) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getEMV2PathRule()) {
					sequence_EMV2Path(context, (EMV2Path) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.EMV2_PATH_ELEMENT:
				if (rule == grammarAccess.getEMV2ErrorPropagationPathRule()) {
					sequence_EMV2ErrorPropagationPath(context, (EMV2PathElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getEMV2PathElementOrKindRule()) {
					sequence_EMV2PathElementOrKind(context, (EMV2PathElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getEMV2PathElementRule()) {
					sequence_EMV2PathElement(context, (EMV2PathElement) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicEMV2PropertyAssociationRule()) {
					sequence_BasicEMV2PropertyAssociation(context, (EMV2PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getEMV2PropertyAssociationRule()) {
					sequence_EMV2PropertyAssociation(context, (EMV2PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.EMV2_ROOT:
				sequence_EMV2Root(context, (EMV2Root) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_BEHAVIOR_STATE:
				sequence_ErrorBehaviorState(context, (ErrorBehaviorState) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE:
				sequence_ErrorBehaviorStateMachine(context, (ErrorBehaviorStateMachine) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION:
				sequence_ErrorBehaviorTransition(context, (ErrorBehaviorTransition) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_CODE_VALUE:
				sequence_ErrorCodeValue(context, (ErrorCodeValue) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_DETECTION:
				sequence_ErrorDetection(context, (ErrorDetection) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_EVENT:
				sequence_ErrorEvent(context, (ErrorEvent) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_MODEL_LIBRARY:
				if (rule == grammarAccess.getEMV2LibraryRule()) {
					sequence_EMV2Library(context, (ErrorModelLibrary) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAnnexLibraryRule()
						|| rule == grammarAccess.getNamedElementRule()
						|| rule == grammarAccess.getErrorModelLibraryRule()) {
					sequence_ErrorModelLibrary(context, (ErrorModelLibrary) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE:
				if (rule == grammarAccess.getEMV2SubclauseRule()) {
					sequence_EMV2Subclause(context, (ErrorModelSubclause) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAnnexSubclauseRule()
						|| rule == grammarAccess.getModalElementRule()
						|| rule == grammarAccess.getErrorModelSubclauseRule()) {
					sequence_ErrorModelSubclause(context, (ErrorModelSubclause) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_PATH:
				sequence_ErrorPath(context, (ErrorPath) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_PROPAGATION:
				sequence_ErrorPropagation(context, (ErrorPropagation) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_SINK:
				sequence_ErrorSink(context, (ErrorSink) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_SOURCE:
				sequence_ErrorSource(context, (ErrorSource) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING:
				sequence_ErrorStateToModeMapping(context, (ErrorStateToModeMapping) semanticObject); 
				return; 
			case ErrorModelPackage.ERROR_TYPE:
				sequence_TypeDefinition(context, (ErrorType) semanticObject); 
				return; 
			case ErrorModelPackage.FEATUREOR_PP_REFERENCE:
				sequence_FeatureorPPReference(context, (FeatureorPPReference) semanticObject); 
				return; 
			case ErrorModelPackage.IF_CONDITION:
				sequence_IfCondition(context, (IfCondition) semanticObject); 
				return; 
			case ErrorModelPackage.OR_EXPRESSION:
				if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getConditionExpressionRule()
						|| action == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getConditionTermRule()) {
					sequence_ConditionExpression(context, (OrExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSConditionExpressionRule()
						|| action == grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSAndExpressionRule()
						|| action == grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSConditionTermRule()) {
					sequence_SConditionExpression(context, (OrExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ORLESS_EXPRESSION:
				if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getConditionExpressionRule()
						|| action == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getOrlessExpressionRule()
						|| rule == grammarAccess.getConditionTermRule()) {
					sequence_OrlessExpression(context, (OrlessExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSConditionExpressionRule()
						|| action == grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSAndExpressionRule()
						|| action == grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSOrlessExpressionRule()
						|| rule == grammarAccess.getSConditionTermRule()) {
					sequence_SOrlessExpression(context, (OrlessExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ORMORE_EXPRESSION:
				if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getConditionExpressionRule()
						|| action == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getOrmoreExpressionRule()
						|| rule == grammarAccess.getConditionTermRule()) {
					sequence_OrmoreExpression(context, (OrmoreExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSConditionExpressionRule()
						|| action == grammarAccess.getSConditionExpressionAccess().getOrExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSAndExpressionRule()
						|| action == grammarAccess.getSAndExpressionAccess().getAndExpressionOperandsAction_1_0()
						|| rule == grammarAccess.getSOrmoreExpressionRule()
						|| rule == grammarAccess.getSConditionTermRule()) {
					sequence_SOrmoreExpression(context, (OrmoreExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION:
				sequence_OutgoingPropagationCondition(context, (OutgoingPropagationCondition) semanticObject); 
				return; 
			case ErrorModelPackage.PROPAGATION_PATH:
				sequence_PropagationPath(context, (PropagationPath) semanticObject); 
				return; 
			case ErrorModelPackage.PROPAGATION_POINT:
				sequence_PropagationPoint(context, (PropagationPoint) semanticObject); 
				return; 
			case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE:
				sequence_QualifiedErrorBehaviorState(context, (QualifiedErrorBehaviorState) semanticObject); 
				return; 
			case ErrorModelPackage.QUALIFIED_ERROR_EVENT_OR_PROPAGATION:
				sequence_QualifiedErrorEventOrPropagation(context, (QualifiedErrorEventOrPropagation) semanticObject); 
				return; 
			case ErrorModelPackage.QUALIFIED_ERROR_PROPAGATION:
				sequence_QualifiedErrorPropagation(context, (QualifiedErrorPropagation) semanticObject); 
				return; 
			case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT:
				sequence_QualifiedPropagationPoint(context, (QualifiedPropagationPoint) semanticObject); 
				return; 
			case ErrorModelPackage.RECOVER_EVENT:
				sequence_RecoverEvent(context, (RecoverEvent) semanticObject); 
				return; 
			case ErrorModelPackage.REPAIR_EVENT:
				sequence_RepairEvent(context, (RepairEvent) semanticObject); 
				return; 
			case ErrorModelPackage.REPORTING_PORT_REFERENCE:
				sequence_ReportingPortReference(context, (ReportingPortReference) semanticObject); 
				return; 
			case ErrorModelPackage.SCONDITION_ELEMENT:
				sequence_SConditionElement(context, (SConditionElement) semanticObject); 
				return; 
			case ErrorModelPackage.SUBCOMPONENT_ELEMENT:
				sequence_SubcomponentElement(context, (SubcomponentElement) semanticObject); 
				return; 
			case ErrorModelPackage.TRANSITION_BRANCH:
				sequence_TransitionBranch(context, (TransitionBranch) semanticObject); 
				return; 
			case ErrorModelPackage.TYPE_MAPPING:
				sequence_TypeMapping(context, (TypeMapping) semanticObject); 
				return; 
			case ErrorModelPackage.TYPE_MAPPING_SET:
				sequence_TypeMappingSet(context, (TypeMappingSet) semanticObject); 
				return; 
			case ErrorModelPackage.TYPE_SET:
				if (rule == grammarAccess.getNoErrorTypeSetRule()) {
					sequence_NoErrorTypeSet(context, (TypeSet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeTokenOrNoErrorRule()
						|| rule == grammarAccess.getTypeTokenConstraintNoErrorRule()) {
					sequence_NoErrorTypeSet_TypeSetConstructor(context, (TypeSet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeSetConstructorRule()
						|| rule == grammarAccess.getTypeSetReferenceRule()
						|| rule == grammarAccess.getTypeTokenRule()
						|| rule == grammarAccess.getTypeTokenConstraintRule()) {
					sequence_TypeSetConstructor(context, (TypeSet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNamedElementRule()
						|| rule == grammarAccess.getErrorTypesRule()
						|| rule == grammarAccess.getTypeSetDefinitionRule()) {
					sequence_TypeSetDefinition(context, (TypeSet) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_TOKEN:
				if (rule == grammarAccess.getNoErrorTypeTokenRule()) {
					sequence_NoErrorTypeToken(context, (TypeToken) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getElementRule()
						|| rule == grammarAccess.getTypeSetElementRule()) {
					sequence_TypeSetElement(context, (TypeToken) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_TRANSFORMATION:
				sequence_TypeTransformation(context, (TypeTransformation) semanticObject); 
				return; 
			case ErrorModelPackage.TYPE_TRANSFORMATION_SET:
				sequence_TypeTransformationSet(context, (TypeTransformationSet) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Element returns AllExpression
	 *     ConditionExpression returns AllExpression
	 *     ConditionExpression.OrExpression_1_0 returns AllExpression
	 *     AndExpression returns AllExpression
	 *     AndExpression.AndExpression_1_0 returns AllExpression
	 *     AllExpression returns AllExpression
	 *     ConditionTerm returns AllExpression
	 *
	 * Constraint:
	 *     (count=INTVALUE? operands+=ConditionElement operands+=ConditionElement*)
	 */
	protected void sequence_AllExpression(ISerializationContext context, AllExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns AndExpression
	 *     ConditionExpression returns AndExpression
	 *     ConditionExpression.OrExpression_1_0 returns AndExpression
	 *     AndExpression returns AndExpression
	 *     AndExpression.AndExpression_1_0 returns AndExpression
	 *     ConditionTerm returns AndExpression
	 *
	 * Constraint:
	 *     (operands+=AndExpression_AndExpression_1_0 operands+=ConditionTerm)
	 */
	protected void sequence_AndExpression(ISerializationContext context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BasicEMV2Path returns EMV2Path
	 *
	 * Constraint:
	 *     emv2Target=EMV2PathElementOrKind
	 */
	protected void sequence_BasicEMV2Path(ISerializationContext context, EMV2Path semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.EMV2_PATH__EMV2_TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.EMV2_PATH__EMV2_TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetEMV2PathElementOrKindParserRuleCall_0(), semanticObject.getEmv2Target());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BasicEMV2PropertyAssociation returns EMV2PropertyAssociation
	 *
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         ownedValues+=OptionalModalPropertyValue 
	 *         ownedValues+=OptionalModalPropertyValue* 
	 *         (emv2Path+=BasicEMV2Path emv2Path+=BasicEMV2Path*)?
	 *     )
	 */
	protected void sequence_BasicEMV2PropertyAssociation(ISerializationContext context, EMV2PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns BranchValue
	 *     BranchValue returns BranchValue
	 *
	 * Constraint:
	 *     (realvalue=REAL_LIT | symboliclabel=[Property|QEMREF] | others?='others')
	 */
	protected void sequence_BranchValue(ISerializationContext context, BranchValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns CompositeState
	 *     CompositeState returns CompositeState
	 *
	 * Constraint:
	 *     (name=ID? (condition=SConditionExpression | others?='others') state=[ErrorBehaviorState|ID] typedToken=TypeToken?)
	 */
	protected void sequence_CompositeState(ISerializationContext context, CompositeState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns ConditionElement
	 *     ConditionExpression returns ConditionElement
	 *     ConditionExpression.OrExpression_1_0 returns ConditionElement
	 *     AndExpression returns ConditionElement
	 *     AndExpression.AndExpression_1_0 returns ConditionElement
	 *     ConditionTerm returns ConditionElement
	 *     ConditionElement returns ConditionElement
	 *
	 * Constraint:
	 *     (qualifiedErrorPropagationReference=QualifiedErrorEventOrPropagation constraint=TypeTokenConstraintNoError?)
	 */
	protected void sequence_ConditionElement(ISerializationContext context, ConditionElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns OrExpression
	 *     ConditionExpression returns OrExpression
	 *     ConditionExpression.OrExpression_1_0 returns OrExpression
	 *     AndExpression returns OrExpression
	 *     AndExpression.AndExpression_1_0 returns OrExpression
	 *     ConditionTerm returns OrExpression
	 *
	 * Constraint:
	 *     (operands+=ConditionExpression_OrExpression_1_0 operands+=AndExpression)
	 */
	protected void sequence_ConditionExpression(ISerializationContext context, OrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EMV2ErrorPropagationPath returns EMV2PathElement
	 *
	 * Constraint:
	 *     (emv2PropagationKind=PropagationKind | (namedElement=[NamedElement|ID] path=EMV2ErrorPropagationPath?))
	 */
	protected void sequence_EMV2ErrorPropagationPath(ISerializationContext context, EMV2PathElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EMV2Library returns ErrorModelLibrary
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             name=QEMREF 
	 *             (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *             (extends+=[ErrorModelLibrary|QEMREF] extends+=[ErrorModelLibrary|QEMREF]*)? 
	 *             (types+=TypeDefinition | typesets+=TypeSetDefinition)* 
	 *             properties+=BasicEMV2PropertyAssociation* 
	 *             behaviors+=ErrorBehaviorStateMachine* 
	 *             mappings+=TypeMappingSet* 
	 *             transformations+=TypeTransformationSet*
	 *         ) | 
	 *         (
	 *             name=QEMREF 
	 *             (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *             (extends+=[ErrorModelLibrary|QEMREF] extends+=[ErrorModelLibrary|QEMREF]*)? 
	 *             (types+=TypeDefinition | typesets+=TypeSetDefinition)* 
	 *             properties+=BasicEMV2PropertyAssociation* 
	 *             behaviors+=ErrorBehaviorStateMachine* 
	 *             mappings+=TypeMappingSet* 
	 *             transformations+=TypeTransformationSet*
	 *         )
	 *     )
	 */
	protected void sequence_EMV2Library(ISerializationContext context, ErrorModelLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EMV2PathElementOrKind returns EMV2PathElement
	 *
	 * Constraint:
	 *     ((emv2PropagationKind=PropagationKind errorType=[ErrorTypes|ID]?) | (namedElement=[NamedElement|ID] path=EMV2PathElement?))
	 */
	protected void sequence_EMV2PathElementOrKind(ISerializationContext context, EMV2PathElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns EMV2PathElement
	 *     EMV2PathElement returns EMV2PathElement
	 *
	 * Constraint:
	 *     (namedElement=[NamedElement|ID] path=EMV2PathElement?)
	 */
	protected void sequence_EMV2PathElement(ISerializationContext context, EMV2PathElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns EMV2Path
	 *     EMV2Path returns EMV2Path
	 *
	 * Constraint:
	 *     (containmentPath=ContainmentPathElement? emv2Target=EMV2PathElementOrKind)
	 */
	protected void sequence_EMV2Path(ISerializationContext context, EMV2Path semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns EMV2PropertyAssociation
	 *     EMV2PropertyAssociation returns EMV2PropertyAssociation
	 *
	 * Constraint:
	 *     (
	 *         property=[Property|QPREF] 
	 *         ownedValues+=OptionalModalPropertyValue 
	 *         ownedValues+=OptionalModalPropertyValue* 
	 *         (emv2Path+=EMV2Path emv2Path+=EMV2Path*)?
	 *     )
	 */
	protected void sequence_EMV2PropertyAssociation(ISerializationContext context, EMV2PropertyAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EMV2Root returns EMV2Root
	 *
	 * Constraint:
	 *     (library=EMV2Library | subclauses+=EMV2Subclause+)?
	 */
	protected void sequence_EMV2Root(ISerializationContext context, EMV2Root semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EMV2Subclause returns ErrorModelSubclause
	 *
	 * Constraint:
	 *     (
	 *         name=QCREF 
	 *         (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *         typeEquivalence=[TypeMappingSet|QEMREF]? 
	 *         typeMappingSet=[TypeMappingSet|QEMREF]? 
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF]? 
	 *         propagations+=ErrorPropagation* 
	 *         flows+=ErrorFlow* 
	 *         useTransformation=[TypeTransformationSet|QEMREF]? 
	 *         events+=ErrorBehaviorEvent* 
	 *         transitions+=ErrorBehaviorTransition* 
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition* 
	 *         errorDetections+=ErrorDetection* 
	 *         errorStateToModeMappings+=ErrorStateToModeMapping* 
	 *         states+=CompositeState* 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]? 
	 *         connectionErrorSources+=ErrorSource* 
	 *         points+=PropagationPoint* 
	 *         paths+=PropagationPath* 
	 *         properties+=EMV2PropertyAssociation*
	 *     )
	 */
	protected void sequence_EMV2Subclause(ISerializationContext context, ErrorModelSubclause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorBehaviorStateMachine
	 *     ErrorBehaviorStateMachine returns ErrorBehaviorStateMachine
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *         useTransformation+=[TypeTransformationSet|QEMREF]? 
	 *         events+=ErrorBehaviorEvent* 
	 *         states+=ErrorBehaviorState* 
	 *         transitions+=ErrorBehaviorTransition* 
	 *         properties+=BasicEMV2PropertyAssociation*
	 *     )
	 */
	protected void sequence_ErrorBehaviorStateMachine(ISerializationContext context, ErrorBehaviorStateMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorBehaviorState
	 *     ErrorBehaviorState returns ErrorBehaviorState
	 *
	 * Constraint:
	 *     (name=ID intial?='initial'? typeSet=TypeSetReference?)
	 */
	protected void sequence_ErrorBehaviorState(ISerializationContext context, ErrorBehaviorState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorBehaviorTransition
	 *     ErrorBehaviorTransition returns ErrorBehaviorTransition
	 *
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((source=[ErrorBehaviorState|ID] typeTokenConstraint=TypeTokenConstraint?) | allStates?='all') 
	 *         condition=ConditionExpression 
	 *         (
	 *             (target=[ErrorBehaviorState|ID] targetToken=TypeToken?) | 
	 *             steadyState?=SameStateKeywords | 
	 *             (destinationBranches+=TransitionBranch destinationBranches+=TransitionBranch+)
	 *         )
	 *     )
	 */
	protected void sequence_ErrorBehaviorTransition(ISerializationContext context, ErrorBehaviorTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns ErrorCodeValue
	 *     ErrorCodeValue returns ErrorCodeValue
	 *
	 * Constraint:
	 *     (intValue=INTEGER_LIT | constant=[PropertyConstant|QPREF] | enumLiteral=STRING)
	 */
	protected void sequence_ErrorCodeValue(ISerializationContext context, ErrorCodeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorDetection
	 *     ErrorDetection returns ErrorDetection
	 *
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((state=[ErrorBehaviorState|ID] typeTokenConstraint=TypeTokenConstraint?) | allStates?='all') 
	 *         condition=ConditionExpression? 
	 *         detectionReportingPort=ReportingPortReference 
	 *         errorCode=ErrorCodeValue?
	 *     )
	 */
	protected void sequence_ErrorDetection(ISerializationContext context, ErrorDetection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorEvent
	 *     ErrorBehaviorEvent returns ErrorEvent
	 *     ErrorEvent returns ErrorEvent
	 *     EventOrPropagation returns ErrorEvent
	 *
	 * Constraint:
	 *     (name=ID typeSet=TypeSetReference? eventcondition=IfCondition?)
	 */
	protected void sequence_ErrorEvent(ISerializationContext context, ErrorEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnnexLibrary returns ErrorModelLibrary
	 *     NamedElement returns ErrorModelLibrary
	 *     ErrorModelLibrary returns ErrorModelLibrary
	 *
	 * Constraint:
	 *     (
	 *         (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *         (extends+=[ErrorModelLibrary|QEMREF] extends+=[ErrorModelLibrary|QEMREF]*)? 
	 *         (types+=TypeDefinition | typesets+=TypeSetDefinition)* 
	 *         properties+=BasicEMV2PropertyAssociation* 
	 *         behaviors+=ErrorBehaviorStateMachine* 
	 *         mappings+=TypeMappingSet* 
	 *         transformations+=TypeTransformationSet*
	 *     )
	 */
	protected void sequence_ErrorModelLibrary(ISerializationContext context, ErrorModelLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnnexSubclause returns ErrorModelSubclause
	 *     ModalElement returns ErrorModelSubclause
	 *     ErrorModelSubclause returns ErrorModelSubclause
	 *
	 * Constraint:
	 *     (
	 *         (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *         typeEquivalence=[TypeMappingSet|QEMREF]? 
	 *         typeMappingSet=[TypeMappingSet|QEMREF]? 
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF]? 
	 *         propagations+=ErrorPropagation* 
	 *         flows+=ErrorFlow* 
	 *         useTransformation=[TypeTransformationSet|QEMREF]? 
	 *         events+=ErrorBehaviorEvent* 
	 *         transitions+=ErrorBehaviorTransition* 
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition* 
	 *         errorDetections+=ErrorDetection* 
	 *         errorStateToModeMappings+=ErrorStateToModeMapping* 
	 *         states+=CompositeState* 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]? 
	 *         connectionErrorSources+=ErrorSource* 
	 *         points+=PropagationPoint* 
	 *         paths+=PropagationPath* 
	 *         properties+=EMV2PropertyAssociation*
	 *     )
	 */
	protected void sequence_ErrorModelSubclause(ISerializationContext context, ErrorModelSubclause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorPath
	 *     ErrorFlow returns ErrorPath
	 *     ErrorPath returns ErrorPath
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all') 
	 *         typeTokenConstraint=TypeTokenConstraint? 
	 *         (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all') 
	 *         (targetToken=TypeToken | typeMappingSet=[TypeMappingSet|QEMREF])? 
	 *         flowcondition=IfCondition?
	 *     )
	 */
	protected void sequence_ErrorPath(ISerializationContext context, ErrorPath semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorPropagation
	 *     ErrorPropagation returns ErrorPropagation
	 *     EventOrPropagation returns ErrorPropagation
	 *
	 * Constraint:
	 *     ((kind=PropagationKind | featureorPPRef=FeatureorPPReference) not?='not'? direction=PropagationDirection typeSet=TypeSetReference)
	 */
	protected void sequence_ErrorPropagation(ISerializationContext context, ErrorPropagation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorSink
	 *     ErrorFlow returns ErrorSink
	 *     ErrorSink returns ErrorSink
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all') 
	 *         typeTokenConstraint=TypeTokenConstraint? 
	 *         flowcondition=IfCondition?
	 *     )
	 */
	protected void sequence_ErrorSink(ISerializationContext context, ErrorSink semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorSource
	 *     ErrorFlow returns ErrorSource
	 *     ErrorSource returns ErrorSource
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (sourceModelElement=[NamedElement|ErrorPropagationPoint] | all?='all') 
	 *         typeTokenConstraint=TypeTokenConstraint? 
	 *         (
	 *             (failureModeReference=[ErrorBehaviorState|ID] failureModeType=TypeSetReference?) | 
	 *             failureModeType=TypeSetConstructor | 
	 *             failureModeDescription=STRING
	 *         )? 
	 *         flowcondition=IfCondition?
	 *     )
	 */
	protected void sequence_ErrorSource(ISerializationContext context, ErrorSource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns ErrorStateToModeMapping
	 *     ErrorStateToModeMapping returns ErrorStateToModeMapping
	 *
	 * Constraint:
	 *     (errorState=[ErrorBehaviorState|ID] typeToken=TypeToken? mappedModes+=[Mode|ID] mappedModes+=[Mode|ID]*)
	 */
	protected void sequence_ErrorStateToModeMapping(ISerializationContext context, ErrorStateToModeMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns FeatureorPPReference
	 *     FeatureorPPReference returns FeatureorPPReference
	 *
	 * Constraint:
	 *     (featureorPP=[NamedElement|ID] next=FeatureorPPReference?)
	 */
	protected void sequence_FeatureorPPReference(ISerializationContext context, FeatureorPPReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IfCondition returns IfCondition
	 *
	 * Constraint:
	 *     (description=STRING | resoluteFunction=[EObject|QEMREF] | javaMethod=QUALIFIEDNAME)
	 */
	protected void sequence_IfCondition(ISerializationContext context, IfCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NoErrorTypeSet returns TypeSet
	 *
	 * Constraint:
	 *     typeTokens+=NoErrorTypeToken
	 */
	protected void sequence_NoErrorTypeSet(ISerializationContext context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeTokenOrNoError returns TypeSet
	 *     TypeTokenConstraintNoError returns TypeSet
	 *
	 * Constraint:
	 *     ((typeTokens+=TypeSetElement typeTokens+=TypeSetElement*) | typeTokens+=NoErrorTypeToken)
	 */
	protected void sequence_NoErrorTypeSet_TypeSetConstructor(ISerializationContext context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NoErrorTypeToken returns TypeToken
	 *
	 * Constraint:
	 *     noError?='noerror'
	 */
	protected void sequence_NoErrorTypeToken(ISerializationContext context, TypeToken semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.TYPE_TOKEN__NO_ERROR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.TYPE_TOKEN__NO_ERROR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorNoerrorKeyword_1_0(), semanticObject.isNoError());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns OrlessExpression
	 *     ConditionExpression returns OrlessExpression
	 *     ConditionExpression.OrExpression_1_0 returns OrlessExpression
	 *     AndExpression returns OrlessExpression
	 *     AndExpression.AndExpression_1_0 returns OrlessExpression
	 *     OrlessExpression returns OrlessExpression
	 *     ConditionTerm returns OrlessExpression
	 *
	 * Constraint:
	 *     (count=INTVALUE operands+=ConditionExpression operands+=ConditionExpression*)
	 */
	protected void sequence_OrlessExpression(ISerializationContext context, OrlessExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns OrmoreExpression
	 *     ConditionExpression returns OrmoreExpression
	 *     ConditionExpression.OrExpression_1_0 returns OrmoreExpression
	 *     AndExpression returns OrmoreExpression
	 *     AndExpression.AndExpression_1_0 returns OrmoreExpression
	 *     OrmoreExpression returns OrmoreExpression
	 *     ConditionTerm returns OrmoreExpression
	 *
	 * Constraint:
	 *     (count=INTVALUE operands+=ConditionExpression operands+=ConditionExpression*)
	 */
	protected void sequence_OrmoreExpression(ISerializationContext context, OrmoreExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns OutgoingPropagationCondition
	 *     OutgoingPropagationCondition returns OutgoingPropagationCondition
	 *
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((state=[ErrorBehaviorState|ID] typeTokenConstraint=TypeTokenConstraint?) | allStates?='all') 
	 *         condition=ConditionExpression? 
	 *         (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allPropagations?='all') 
	 *         typeToken=TypeTokenOrNoError?
	 *     )
	 */
	protected void sequence_OutgoingPropagationCondition(ISerializationContext context, OutgoingPropagationCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns PropagationPath
	 *     PropagationPath returns PropagationPath
	 *
	 * Constraint:
	 *     (name=ID? source=QualifiedPropagationPoint target=QualifiedPropagationPoint)
	 */
	protected void sequence_PropagationPath(ISerializationContext context, PropagationPath semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns PropagationPoint
	 *     PropagationPoint returns PropagationPoint
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_PropagationPoint(ISerializationContext context, PropagationPoint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropagationPointAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns QualifiedErrorBehaviorState
	 *     QualifiedErrorBehaviorState returns QualifiedErrorBehaviorState
	 *
	 * Constraint:
	 *     (subcomponent=SubcomponentElement (next=QualifiedErrorBehaviorState | state=[ErrorBehaviorState|ID]))
	 */
	protected void sequence_QualifiedErrorBehaviorState(ISerializationContext context, QualifiedErrorBehaviorState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     QualifiedErrorEventOrPropagation returns QualifiedErrorEventOrPropagation
	 *
	 * Constraint:
	 *     emv2Target=EMV2ErrorPropagationPath
	 */
	protected void sequence_QualifiedErrorEventOrPropagation(ISerializationContext context, QualifiedErrorEventOrPropagation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.EMV2_PATH__EMV2_TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.EMV2_PATH__EMV2_TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0(), semanticObject.getEmv2Target());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     QualifiedErrorPropagation returns QualifiedErrorPropagation
	 *
	 * Constraint:
	 *     emv2Target=EMV2ErrorPropagationPath
	 */
	protected void sequence_QualifiedErrorPropagation(ISerializationContext context, QualifiedErrorPropagation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.EMV2_PATH__EMV2_TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.EMV2_PATH__EMV2_TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetEMV2ErrorPropagationPathParserRuleCall_1_0(), semanticObject.getEmv2Target());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns QualifiedPropagationPoint
	 *     QualifiedPropagationPoint returns QualifiedPropagationPoint
	 *
	 * Constraint:
	 *     ((subcomponent=SubcomponentElement next=QualifiedPropagationPoint) | propagationPoint=[NamedElement|ID])
	 */
	protected void sequence_QualifiedPropagationPoint(ISerializationContext context, QualifiedPropagationPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns RecoverEvent
	 *     ErrorBehaviorEvent returns RecoverEvent
	 *     RecoverEvent returns RecoverEvent
	 *     EventOrPropagation returns RecoverEvent
	 *
	 * Constraint:
	 *     (name=ID (eventInitiator+=[NamedElement|ID] eventInitiator+=[NamedElement|ID]*)? condition=IfCondition?)
	 */
	protected void sequence_RecoverEvent(ISerializationContext context, RecoverEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns RepairEvent
	 *     ErrorBehaviorEvent returns RepairEvent
	 *     RepairEvent returns RepairEvent
	 *     EventOrPropagation returns RepairEvent
	 *
	 * Constraint:
	 *     (name=ID (eventInitiator+=[NamedElement|ID] eventInitiator+=[NamedElement|ID]*)?)
	 */
	protected void sequence_RepairEvent(ISerializationContext context, RepairEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ReportingPortReference returns ReportingPortReference
	 *     ReportingPortReference.ReportingPortReference_1_0 returns ReportingPortReference
	 *
	 * Constraint:
	 *     (element=[NamedElement|ID] | (previous=ReportingPortReference_ReportingPortReference_1_0 element=[NamedElement|ID]))
	 */
	protected void sequence_ReportingPortReference(ISerializationContext context, ReportingPortReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SConditionExpression returns AllExpression
	 *     SConditionExpression.OrExpression_1_0 returns AllExpression
	 *     SAndExpression returns AllExpression
	 *     SAndExpression.AndExpression_1_0 returns AllExpression
	 *     SAllExpression returns AllExpression
	 *     SConditionTerm returns AllExpression
	 *
	 * Constraint:
	 *     (count=INTVALUE? operands+=SConditionElement operands+=SConditionElement*)
	 */
	protected void sequence_SAllExpression(ISerializationContext context, AllExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SConditionExpression returns AndExpression
	 *     SConditionExpression.OrExpression_1_0 returns AndExpression
	 *     SAndExpression returns AndExpression
	 *     SAndExpression.AndExpression_1_0 returns AndExpression
	 *     SConditionTerm returns AndExpression
	 *
	 * Constraint:
	 *     (operands+=SAndExpression_AndExpression_1_0 operands+=SConditionTerm)
	 */
	protected void sequence_SAndExpression(ISerializationContext context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SConditionExpression returns SConditionElement
	 *     SConditionExpression.OrExpression_1_0 returns SConditionElement
	 *     SAndExpression returns SConditionElement
	 *     SAndExpression.AndExpression_1_0 returns SConditionElement
	 *     SConditionTerm returns SConditionElement
	 *     SConditionElement returns SConditionElement
	 *
	 * Constraint:
	 *     (
	 *         (qualifiedState=QualifiedErrorBehaviorState constraint=TypeTokenConstraint?) | 
	 *         (qualifiedErrorPropagationReference=QualifiedErrorPropagation constraint=TypeTokenConstraintNoError?)
	 *     )
	 */
	protected void sequence_SConditionElement(ISerializationContext context, SConditionElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SConditionExpression returns OrExpression
	 *     SConditionExpression.OrExpression_1_0 returns OrExpression
	 *     SAndExpression returns OrExpression
	 *     SAndExpression.AndExpression_1_0 returns OrExpression
	 *     SConditionTerm returns OrExpression
	 *
	 * Constraint:
	 *     (operands+=SConditionExpression_OrExpression_1_0 operands+=SAndExpression)
	 */
	protected void sequence_SConditionExpression(ISerializationContext context, OrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SConditionExpression returns OrlessExpression
	 *     SConditionExpression.OrExpression_1_0 returns OrlessExpression
	 *     SAndExpression returns OrlessExpression
	 *     SAndExpression.AndExpression_1_0 returns OrlessExpression
	 *     SOrlessExpression returns OrlessExpression
	 *     SConditionTerm returns OrlessExpression
	 *
	 * Constraint:
	 *     (count=INTVALUE operands+=SConditionExpression operands+=SConditionExpression*)
	 */
	protected void sequence_SOrlessExpression(ISerializationContext context, OrlessExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SConditionExpression returns OrmoreExpression
	 *     SConditionExpression.OrExpression_1_0 returns OrmoreExpression
	 *     SAndExpression returns OrmoreExpression
	 *     SAndExpression.AndExpression_1_0 returns OrmoreExpression
	 *     SOrmoreExpression returns OrmoreExpression
	 *     SConditionTerm returns OrmoreExpression
	 *
	 * Constraint:
	 *     (count=INTVALUE operands+=SConditionExpression operands+=SConditionExpression*)
	 */
	protected void sequence_SOrmoreExpression(ISerializationContext context, OrmoreExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns SubcomponentElement
	 *     SubcomponentElement returns SubcomponentElement
	 *
	 * Constraint:
	 *     subcomponent=[Subcomponent|ID]
	 */
	protected void sequence_SubcomponentElement(ISerializationContext context, SubcomponentElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.SUBCOMPONENT_ELEMENT__SUBCOMPONENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.SUBCOMPONENT_ELEMENT__SUBCOMPONENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubcomponentElementAccess().getSubcomponentSubcomponentIDTerminalRuleCall_0_1(), semanticObject.eGet(ErrorModelPackage.Literals.SUBCOMPONENT_ELEMENT__SUBCOMPONENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns TransitionBranch
	 *     TransitionBranch returns TransitionBranch
	 *
	 * Constraint:
	 *     (((target=[ErrorBehaviorState|ID] targetToken=TypeToken?) | steadyState?=SameStateKeywords) value=BranchValue)
	 */
	protected void sequence_TransitionBranch(ISerializationContext context, TransitionBranch semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns ErrorType
	 *     ErrorTypes returns ErrorType
	 *     TypeDefinition returns ErrorType
	 *
	 * Constraint:
	 *     (name=ID (superType=[ErrorType|QEMREF] | aliasedType=[ErrorType|QEMREF])?)
	 */
	protected void sequence_TypeDefinition(ISerializationContext context, ErrorType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns TypeMappingSet
	 *     TypeMappingSet returns TypeMappingSet
	 *
	 * Constraint:
	 *     (name=ID (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? mapping+=TypeMapping+)
	 */
	protected void sequence_TypeMappingSet(ISerializationContext context, TypeMappingSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns TypeMapping
	 *     TypeMapping returns TypeMapping
	 *
	 * Constraint:
	 *     (source=TypeTokenConstraint target=TypeToken)
	 */
	protected void sequence_TypeMapping(ISerializationContext context, TypeMapping semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.TYPE_MAPPING__SOURCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.TYPE_MAPPING__SOURCE));
			if (transientValues.isValueTransient(semanticObject, ErrorModelPackage.Literals.TYPE_MAPPING__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErrorModelPackage.Literals.TYPE_MAPPING__TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeMappingAccess().getSourceTypeTokenConstraintParserRuleCall_0_0(), semanticObject.getSource());
		feeder.accept(grammarAccess.getTypeMappingAccess().getTargetTypeTokenParserRuleCall_2_0(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TypeSetConstructor returns TypeSet
	 *     TypeSetReference returns TypeSet
	 *     TypeToken returns TypeSet
	 *     TypeTokenConstraint returns TypeSet
	 *
	 * Constraint:
	 *     (typeTokens+=TypeSetElement typeTokens+=TypeSetElement*)
	 */
	protected void sequence_TypeSetConstructor(ISerializationContext context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns TypeSet
	 *     ErrorTypes returns TypeSet
	 *     TypeSetDefinition returns TypeSet
	 *
	 * Constraint:
	 *     (name=ID ((typeTokens+=TypeSetElement typeTokens+=TypeSetElement*) | aliasedType=[TypeSet|QEMREF]))
	 */
	protected void sequence_TypeSetDefinition(ISerializationContext context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns TypeToken
	 *     TypeSetElement returns TypeToken
	 *
	 * Constraint:
	 *     (type+=[ErrorTypes|QEMREF] type+=[ErrorTypes|QEMREF]*)
	 */
	protected void sequence_TypeSetElement(ISerializationContext context, TypeToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns TypeTransformationSet
	 *     TypeTransformationSet returns TypeTransformationSet
	 *
	 * Constraint:
	 *     (name=ID (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? transformation+=TypeTransformation+)
	 */
	protected void sequence_TypeTransformationSet(ISerializationContext context, TypeTransformationSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns TypeTransformation
	 *     TypeTransformation returns TypeTransformation
	 *
	 * Constraint:
	 *     ((source=TypeTokenConstraintNoError | allSources?='all') contributor=TypeTokenConstraintNoError? target=TypeToken)
	 */
	protected void sequence_TypeTransformation(ISerializationContext context, TypeTransformation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
