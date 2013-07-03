package org.osate.xtext.aadl2.errormodel.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.InternalEvent;
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
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPaths;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
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
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Aadl2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				if(context == grammarAccess.getArrayRangeRule()) {
					sequence_ArrayRange(context, (ArrayRange) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				if(context == grammarAccess.getFieldPropertyAssociationRule()) {
					sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.BOOLEAN_LITERAL:
				if(context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CLASSIFIER_VALUE:
				if(context == grammarAccess.getComponentClassifierTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.COMPUTED_VALUE:
				if(context == grammarAccess.getComputedTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				if(context == grammarAccess.getContainmentPathRule()) {
					sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				if(context == grammarAccess.getContainmentPathElementRule()) {
					sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getQualifiedContainmentPathElementRule()) {
					sequence_QualifiedContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.INTEGER_LITERAL:
				if(context == grammarAccess.getIntegerTermRule() ||
				   context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.INTERNAL_EVENT:
				if(context == grammarAccess.getInternalPortRule()) {
					sequence_InternalPort(context, (InternalEvent) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.LIST_VALUE:
				if(context == grammarAccess.getListTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_ListTerm(context, (ListValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if(context == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getLiteralorReferenceTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				if(context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getSignedConstantRule()) {
					sequence_SignedConstant(context, (Operation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if(context == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getContainedPropertyAssociationRule() ||
				   context == grammarAccess.getPModelRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				if(context == grammarAccess.getNumericRangeTermRule() ||
				   context == grammarAccess.getPropertyExpressionRule()) {
					sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REAL_LITERAL:
				if(context == grammarAccess.getNumAltRule() ||
				   context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getRealTermRule()) {
					sequence_RealTerm(context, (RealLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RECORD_VALUE:
				if(context == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getReferenceTermRule()) {
					sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.STRING_LITERAL:
				if(context == grammarAccess.getPropertyExpressionRule() ||
				   context == grammarAccess.getStringTermRule()) {
					sequence_StringTerm(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == ErrorModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ErrorModelPackage.AND_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionExpressionRule() ||
				   context == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionTermRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_AndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.BRANCH_VALUE:
				if(context == grammarAccess.getBranchValueRule()) {
					sequence_BranchValue(context, (BranchValue) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR:
				if(context == grammarAccess.getComponentErrorBehaviorRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_ComponentErrorBehavior(context, (ComponentErrorBehavior) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR:
				if(context == grammarAccess.getCompositeErrorBehaviorRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_CompositeErrorBehavior(context, (CompositeErrorBehavior) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.COMPOSITE_STATE:
				if(context == grammarAccess.getCompositeStateRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_CompositeState(context, (CompositeState) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.CONDITION_ELEMENT:
				if(context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionElementRule() ||
				   context == grammarAccess.getConditionExpressionRule() ||
				   context == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionTermRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_ConditionElement(context, (ConditionElement) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSAndExpressionRule() ||
				   context == grammarAccess.getSAndExpressionAccess().getSAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionElementRule() ||
				   context == grammarAccess.getSConditionExpressionRule() ||
				   context == grammarAccess.getSConditionExpressionAccess().getSOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionTermRule()) {
					sequence_SConditionElement(context, (ConditionElement) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.CONNECTION_ERROR_BEHAVIOR:
				if(context == grammarAccess.getConnectionErrorBehaviorRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_ConnectionErrorBehavior(context, (ConnectionErrorBehavior) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.CONNECTION_ERROR_SOURCE:
				if(context == grammarAccess.getConnectionErrorSourceRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ConnectionErrorSource(context, (ConnectionErrorSource) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_BEHAVIOR_STATE:
				if(context == grammarAccess.getErrorBehaviorStateRule() ||
				   context == grammarAccess.getErrorBehaviorStateOrTypeSetRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorBehaviorState(context, (ErrorBehaviorState) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getErrorBehaviorStateMachineRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getTypeUseContextRule()) {
					sequence_ErrorBehaviorStateMachine(context, (ErrorBehaviorStateMachine) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION:
				if(context == grammarAccess.getErrorBehaviorTransitionRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorBehaviorTransition(context, (ErrorBehaviorTransition) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_CODE_VALUE:
				if(context == grammarAccess.getErrorCodeValueRule()) {
					sequence_ErrorCodeValue(context, (ErrorCodeValue) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_DETECTION:
				if(context == grammarAccess.getErrorDetectionRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorDetection(context, (ErrorDetection) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_EVENT:
				if(context == grammarAccess.getErrorBehaviorEventRule() ||
				   context == grammarAccess.getErrorEventRule() ||
				   context == grammarAccess.getEventOrPropagationRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorEvent(context, (ErrorEvent) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT:
				if(context == grammarAccess.getErrorModelGrammarRootRule()) {
					sequence_ErrorModelGrammarRoot(context, (ErrorModelGrammarRoot) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_MODEL_LIBRARY:
				if(context == grammarAccess.getAnnexLibraryRule() ||
				   context == grammarAccess.getErrorModelLibraryRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorModelLibrary(context, (ErrorModelLibrary) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE:
				if(context == grammarAccess.getAnnexSubclauseRule() ||
				   context == grammarAccess.getEBSMUseContextRule() ||
				   context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getErrorModelSubclauseRule() ||
				   context == grammarAccess.getModalElementRule() ||
				   context == grammarAccess.getTypeUseContextRule()) {
					sequence_ErrorModelSubclause(context, (ErrorModelSubclause) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_PATH:
				if(context == grammarAccess.getErrorFlowRule() ||
				   context == grammarAccess.getErrorPathRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorPath(context, (ErrorPath) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_PROPAGATION:
				if(context == grammarAccess.getErrorPropagationRule() ||
				   context == grammarAccess.getEventOrPropagationRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorPropagation(context, (ErrorPropagation) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_PROPAGATIONS:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getErrorPropagationsRule()) {
					sequence_ErrorPropagations(context, (ErrorPropagations) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_SINK:
				if(context == grammarAccess.getErrorFlowRule() ||
				   context == grammarAccess.getErrorSinkRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorSink(context, (ErrorSink) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_SOURCE:
				if(context == grammarAccess.getErrorFlowRule() ||
				   context == grammarAccess.getErrorSourceRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_ErrorSource(context, (ErrorSource) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getErrorStateToModeMappingRule()) {
					sequence_ErrorStateToModeMapping(context, (ErrorStateToModeMapping) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ERROR_TYPE:
				if(context == grammarAccess.getErrorTypesRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getTypeDefinitionRule()) {
					sequence_TypeDefinition(context, (ErrorType) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.FEATUREOR_PP_REFERENCE:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getFeatureorPPReferenceRule()) {
					sequence_FeatureorPPReference(context, (FeatureorPPReference) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.OR_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionExpressionRule() ||
				   context == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionTermRule() ||
				   context == grammarAccess.getElementRule()) {
					sequence_ConditionExpression(context, (OrExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ORLESS_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionExpressionRule() ||
				   context == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionTermRule() ||
				   context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getOrlessExpressionRule()) {
					sequence_OrlessExpression(context, (OrlessExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSAndExpressionRule() ||
				   context == grammarAccess.getSAndExpressionAccess().getSAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionExpressionRule() ||
				   context == grammarAccess.getSConditionExpressionAccess().getSOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionTermRule() ||
				   context == grammarAccess.getSOrlessExpressionRule()) {
					sequence_SOrlessExpression(context, (OrlessExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.ORMORE_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionExpressionRule() ||
				   context == grammarAccess.getConditionExpressionAccess().getOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getConditionTermRule() ||
				   context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getOrmoreExpressionRule()) {
					sequence_OrmoreExpression(context, (OrmoreExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSAndExpressionRule() ||
				   context == grammarAccess.getSAndExpressionAccess().getSAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionExpressionRule() ||
				   context == grammarAccess.getSConditionExpressionAccess().getSOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionTermRule() ||
				   context == grammarAccess.getSOrmoreExpressionRule()) {
					sequence_SOrmoreExpression(context, (OrmoreExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getOutgoingPropagationConditionRule()) {
					sequence_OutgoingPropagationCondition(context, (OutgoingPropagationCondition) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.PROPAGATION_PATHS:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getPropagationPathsRule()) {
					sequence_PropagationPaths(context, (PropagationPaths) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.PROPAGATION_POINT:
				if(context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getPropagationPointRule()) {
					sequence_PropagationPoint(context, (PropagationPoint) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.PROPAGATION_POINT_CONNECTION:
				if(context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getPropagationPointConnectionRule()) {
					sequence_PropagationPointConnection(context, (PropagationPointConnection) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getQualifiedPropagationPointRule()) {
					sequence_QualifiedPropagationPoint(context, (QualifiedPropagationPoint) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.RECOVER_EVENT:
				if(context == grammarAccess.getErrorBehaviorEventRule() ||
				   context == grammarAccess.getEventOrPropagationRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getRecoverEventRule()) {
					sequence_RecoverEvent(context, (RecoverEvent) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.REPAIR_EVENT:
				if(context == grammarAccess.getErrorBehaviorEventRule() ||
				   context == grammarAccess.getEventOrPropagationRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getRepairEventRule()) {
					sequence_RepairEvent(context, (RepairEvent) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.SAND_EXPRESSION:
				if(context == grammarAccess.getSAndExpressionRule() ||
				   context == grammarAccess.getSAndExpressionAccess().getSAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionExpressionRule() ||
				   context == grammarAccess.getSConditionExpressionAccess().getSOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionTermRule()) {
					sequence_SAndExpression(context, (SAndExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.SOR_EXPRESSION:
				if(context == grammarAccess.getSAndExpressionRule() ||
				   context == grammarAccess.getSAndExpressionAccess().getSAndExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionExpressionRule() ||
				   context == grammarAccess.getSConditionExpressionAccess().getSOrExpressionOperandsAction_1_0() ||
				   context == grammarAccess.getSConditionTermRule()) {
					sequence_SConditionExpression(context, (SOrExpression) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.SUBCOMPONENT_ELEMENT:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getSubcomponentElementRule()) {
					sequence_SubcomponentElement(context, (SubcomponentElement) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TRANSITION_BRANCH:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getTransitionBranchRule()) {
					sequence_TransitionBranch(context, (TransitionBranch) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_MAPPING:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getTypeMappingRule()) {
					sequence_TypeMapping(context, (TypeMapping) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_MAPPING_SET:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getTypeMappingSetRule() ||
				   context == grammarAccess.getTypeUseContextRule()) {
					sequence_TypeMappingSet(context, (TypeMappingSet) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_SET:
				if(context == grammarAccess.getNoErrorRule()) {
					sequence_NoError(context, (TypeSet) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeSetConstructorRule() ||
				   context == grammarAccess.getTypeSetReferenceRule() ||
				   context == grammarAccess.getTypeTokenConstraintRule() ||
				   context == grammarAccess.getTypeTokenConstraintNoErrorRule()) {
					sequence_TypeSetConstructor(context, (TypeSet) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getErrorBehaviorStateOrTypeSetRule() ||
				   context == grammarAccess.getErrorTypesRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getTypeSetDefinitionRule()) {
					sequence_TypeSetDefinition(context, (TypeSet) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_TOKEN:
				if(context == grammarAccess.getElementRule()) {
					sequence_Element_TypeSetElement_TypeToken(context, (TypeToken) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeSetElementRule()) {
					sequence_TypeSetElement(context, (TypeToken) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeTokenOrNoErrorRule()) {
					sequence_TypeTokenOrNoError(context, (TypeToken) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeTokenRule()) {
					sequence_TypeToken(context, (TypeToken) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_TRANSFORMATION:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getTypeTransformationRule()) {
					sequence_TypeTransformation(context, (TypeTransformation) semanticObject); 
					return; 
				}
				else break;
			case ErrorModelPackage.TYPE_TRANSFORMATION_SET:
				if(context == grammarAccess.getElementRule() ||
				   context == grammarAccess.getNamedElementRule() ||
				   context == grammarAccess.getTypeTransformationSetRule() ||
				   context == grammarAccess.getTypeUseContextRule()) {
					sequence_TypeTransformationSet(context, (TypeTransformationSet) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (operands+=AndExpression_AndExpression_1_0 operands+=ConditionTerm)
	 */
	protected void sequence_AndExpression(EObject context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (realvalue=REAL_LIT | symboliclabel=[PropertyConstant|QEMREF] | others?='others')
	 */
	protected void sequence_BranchValue(EObject context, BranchValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF]? 
	 *         events+=ErrorBehaviorEvent* 
	 *         transitions+=ErrorBehaviorTransition* 
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition* 
	 *         errorDetections+=ErrorDetection* 
	 *         errorStateToModeMappings+=ErrorStateToModeMapping*
	 *     )
	 */
	protected void sequence_ComponentErrorBehavior(EObject context, ComponentErrorBehavior semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (states+=CompositeState*)
	 */
	protected void sequence_CompositeErrorBehavior(EObject context, CompositeErrorBehavior semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((condition=SConditionExpression | others?='others') state=[ErrorBehaviorState|ID] typedToken=TypeToken?)
	 */
	protected void sequence_CompositeState(EObject context, CompositeState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (incoming=[EventOrPropagation|ErrorPropagationPoint] constraint=TypeTokenConstraintNoError?)
	 */
	protected void sequence_ConditionElement(EObject context, ConditionElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operands+=ConditionExpression_OrExpression_1_0 operands+=AndExpression)
	 */
	protected void sequence_ConditionExpression(EObject context, OrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeTransformationSet=[TypeTransformationSet|QEMREF]? connectionErrorSources+=ConnectionErrorSource*)
	 */
	protected void sequence_ConnectionErrorBehavior(EObject context, ConnectionErrorBehavior semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (connection=[Connection|ID] | all?='all') typeTokenConstraint=TypeTokenConstraint? failureModeType=TypeSetConstructor?)
	 */
	protected void sequence_ConnectionErrorSource(EObject context, ConnectionErrorSource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((type+=[ErrorType|QEMREF] type+=[ErrorType|QEMREF]*) | (type+=[ErrorType|QEMREF] type+=[ErrorType|QEMREF]*))
	 */
	protected void sequence_Element_TypeSetElement_TypeToken(EObject context, TypeToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *         useTransformation+=[TypeTransformationSet|QEMREF]? 
	 *         events+=ErrorBehaviorEvent* 
	 *         states+=ErrorBehaviorState* 
	 *         transitions+=ErrorBehaviorTransition* 
	 *         properties+=ContainedPropertyAssociation*
	 *     )
	 */
	protected void sequence_ErrorBehaviorStateMachine(EObject context, ErrorBehaviorStateMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID intial?='initial'? typeSet=TypeSetReference?)
	 */
	protected void sequence_ErrorBehaviorState(EObject context, ErrorBehaviorState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((source=[ErrorBehaviorState|ID] typeTokenConstraint=TypeTokenConstraint?) | allStates?='all') 
	 *         condition=ConditionExpression 
	 *         (
	 *             (target=[ErrorBehaviorState|ID] targetToken=TypeToken?) | 
	 *             (destinationBranches+=TransitionBranch destinationBranches+=TransitionBranch+) | 
	 *             steadyState?=']'
	 *         )
	 *     )
	 */
	protected void sequence_ErrorBehaviorTransition(EObject context, ErrorBehaviorTransition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (intValue=INTEGER_LIT | constant=[PropertyConstant|QPREF] | enumLiteral=STRING)
	 */
	protected void sequence_ErrorCodeValue(EObject context, ErrorCodeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((state=[ErrorBehaviorState|ID] typeTokenConstraint=TypeTokenConstraint?) | allStates?='all') 
	 *         condition=ConditionExpression? 
	 *         (internalDetectionPort=InternalPort | detectionReportingPort=[Port|ID]) 
	 *         errorCode=ErrorCodeValue?
	 *     )
	 */
	protected void sequence_ErrorDetection(EObject context, ErrorDetection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID typeSet=TypeSetReference? condition=STRING?)
	 */
	protected void sequence_ErrorEvent(EObject context, ErrorEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (eml=ErrorModelLibrary | emsc=ErrorModelSubclause)
	 */
	protected void sequence_ErrorModelGrammarRoot(EObject context, ErrorModelGrammarRoot semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (extends+=[ErrorModelLibrary|QEMREF] extends+=[ErrorModelLibrary|QEMREF]*)? 
	 *             (types+=TypeDefinition | typesets+=TypeSetDefinition)* 
	 *             properties+=ContainedPropertyAssociation*
	 *         )? 
	 *         behaviors+=ErrorBehaviorStateMachine* 
	 *         mappings+=TypeMappingSet* 
	 *         transformations+=TypeTransformationSet*
	 *     )
	 */
	protected void sequence_ErrorModelLibrary(EObject context, ErrorModelLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? 
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF]? 
	 *         errorPropagations=ErrorPropagations? 
	 *         componentBehavior=ComponentErrorBehavior? 
	 *         compositeBehavior=CompositeErrorBehavior? 
	 *         connectionBehavior=ConnectionErrorBehavior? 
	 *         propagationPaths=PropagationPaths? 
	 *         properties+=ContainedPropertyAssociation*
	 *     )
	 */
	protected void sequence_ErrorModelSubclause(EObject context, ErrorModelSubclause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all') 
	 *         typeTokenConstraint=TypeTokenConstraint? 
	 *         (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all') 
	 *         (targetToken=TypeToken | typeMappingSet=[TypeMappingSet|QEMREF])?
	 *     )
	 */
	protected void sequence_ErrorPath(EObject context, ErrorPath semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (kind=PropagationKind | (featureorPPRefs+=FeatureorPPReference featureorPPRefs+=FeatureorPPReference*)) 
	 *         not?='not'? 
	 *         direction=PropagationDirection 
	 *         typeSet=TypeSetReference?
	 *     )
	 */
	protected void sequence_ErrorPropagation(EObject context, ErrorPropagation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (propagations+=ErrorPropagation* flows+=ErrorFlow*)
	 */
	protected void sequence_ErrorPropagations(EObject context, ErrorPropagations semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (incoming=[ErrorPropagation|ErrorPropagationPoint] | allIncoming?='all') typeTokenConstraint=TypeTokenConstraint?)
	 */
	protected void sequence_ErrorSink(EObject context, ErrorSink semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allOutgoing?='all') 
	 *         typeTokenConstraint=TypeTokenConstraint? 
	 *         ((failureModeReference=[ErrorBehaviorStateOrTypeSet|ID] failureModeType=TypeSetConstructor?) | failureModeType=TypeSetConstructor)?
	 *     )
	 */
	protected void sequence_ErrorSource(EObject context, ErrorSource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (errorState=[ErrorBehaviorState|ID] mappedModes+=[Mode|ID] mappedModes+=[Mode|ID]*)
	 */
	protected void sequence_ErrorStateToModeMapping(EObject context, ErrorStateToModeMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     featureorPP=[NamedElement|ID]
	 */
	protected void sequence_FeatureorPPReference(EObject context, FeatureorPPReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_InternalPort(EObject context, InternalEvent semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {TypeSet}
	 */
	protected void sequence_NoError(EObject context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (count=INTVALUE operands+=ConditionElement operands+=ConditionElement*)
	 */
	protected void sequence_OrlessExpression(EObject context, OrlessExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (count=INTVALUE operands+=ConditionElement operands+=ConditionElement*)
	 */
	protected void sequence_OrmoreExpression(EObject context, OrmoreExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         ((state=[ErrorBehaviorState|ID] typeTokenConstraint=TypeTokenConstraint?) | allStates?='all') 
	 *         condition=ConditionExpression? 
	 *         (outgoing=[ErrorPropagation|ErrorPropagationPoint] | allPropagations?='all') 
	 *         typeToken=TypeTokenOrNoError?
	 *     )
	 */
	protected void sequence_OutgoingPropagationCondition(EObject context, OutgoingPropagationCondition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (points+=PropagationPoint+ connections+=PropagationPointConnection*)
	 */
	protected void sequence_PropagationPaths(EObject context, PropagationPaths semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID source=QualifiedPropagationPoint target=QualifiedPropagationPoint)
	 */
	protected void sequence_PropagationPointConnection(EObject context, PropagationPointConnection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_PropagationPoint(EObject context, PropagationPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (subcomponent=[Subcomponent|ID]? propagationPoint=[PropagationPoint|ID])
	 */
	protected void sequence_QualifiedPropagationPoint(EObject context, QualifiedPropagationPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (condition+=[NamedElement|ID] condition+=[NamedElement|ID]*)?)
	 */
	protected void sequence_RecoverEvent(EObject context, RecoverEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID condition=STRING?)
	 */
	protected void sequence_RepairEvent(EObject context, RepairEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operands+=SAndExpression_SAndExpression_1_0 operands+=SConditionTerm)
	 */
	protected void sequence_SAndExpression(EObject context, SAndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (subcomponents+=SubcomponentElement+ reference=[ErrorBehaviorState|ID] constraint=TypeTokenConstraint?)
	 */
	protected void sequence_SConditionElement(EObject context, ConditionElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operands+=SConditionExpression_SOrExpression_1_0 operands+=SAndExpression)
	 */
	protected void sequence_SConditionExpression(EObject context, SOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (count=INTVALUE operands+=SConditionElement operands+=SConditionElement*)
	 */
	protected void sequence_SOrlessExpression(EObject context, OrlessExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (count=INTVALUE operands+=SConditionElement operands+=SConditionElement*)
	 */
	protected void sequence_SOrmoreExpression(EObject context, OrmoreExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     subcomponent=[Subcomponent|ID]
	 */
	protected void sequence_SubcomponentElement(EObject context, SubcomponentElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=[ErrorBehaviorState|ID] targetToken=TypeToken? value=BranchValue)
	 */
	protected void sequence_TransitionBranch(EObject context, TransitionBranch semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (superType=[ErrorType|QEMREF]? | aliasedType=[ErrorType|QEMREF]))
	 */
	protected void sequence_TypeDefinition(EObject context, ErrorType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? mapping+=TypeMapping+)
	 */
	protected void sequence_TypeMappingSet(EObject context, TypeMappingSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (source=TypeTokenConstraint target=TypeToken)
	 */
	protected void sequence_TypeMapping(EObject context, TypeMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeTokens+=TypeSetElement typeTokens+=TypeSetElement*)
	 */
	protected void sequence_TypeSetConstructor(EObject context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ((typeTokens+=TypeSetElement typeTokens+=TypeSetElement*) | aliasedType=[TypeSet|QEMREF]))
	 */
	protected void sequence_TypeSetDefinition(EObject context, TypeSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type+=[ErrorType|QEMREF] type+=[ErrorType|QEMREF]*)
	 */
	protected void sequence_TypeSetElement(EObject context, TypeToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((type+=[ErrorType|QEMREF] type+=[ErrorType|QEMREF]*) | noError?='noerror')
	 */
	protected void sequence_TypeTokenOrNoError(EObject context, TypeToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type+=[ErrorType|QEMREF] type+=[ErrorType|QEMREF]*)
	 */
	protected void sequence_TypeToken(EObject context, TypeToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (useTypes+=[ErrorModelLibrary|QEMREF] useTypes+=[ErrorModelLibrary|QEMREF]*)? transformation+=TypeTransformation+)
	 */
	protected void sequence_TypeTransformationSet(EObject context, TypeTransformationSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (source=TypeTokenConstraintNoError contributor=TypeTokenConstraintNoError target=TypeToken)
	 */
	protected void sequence_TypeTransformation(EObject context, TypeTransformation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
