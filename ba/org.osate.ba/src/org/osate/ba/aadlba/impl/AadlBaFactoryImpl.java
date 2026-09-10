/**
 * AADL-BA-FrontEnd
 *
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osate.ba.aadlba.AadlBaFactory;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.Any;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BasicPropertyHolder;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorActionSequence;
import org.osate.ba.aadlba.BehaviorActionSet;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorBooleanLiteral;
import org.osate.ba.aadlba.BehaviorFeatureType;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorPropertyConstant;
import org.osate.ba.aadlba.BehaviorRealLiteral;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorStringLiteral;
import org.osate.ba.aadlba.BehaviorTime;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.BehaviorVariableHolder;
import org.osate.ba.aadlba.BinaryAddingOperator;
import org.osate.ba.aadlba.BinaryNumericOperator;
import org.osate.ba.aadlba.CalledSubprogramHolder;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.ba.aadlba.ClassifierPropertyReference;
import org.osate.ba.aadlba.CompletionRelativeTimeout;
import org.osate.ba.aadlba.DataAccessHolder;
import org.osate.ba.aadlba.DataAccessPrototypeHolder;
import org.osate.ba.aadlba.DataComponentReference;
import org.osate.ba.aadlba.DataPortHolder;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.aadlba.DataSubcomponentHolder;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.ba.aadlba.DispatchConjunction;
import org.osate.ba.aadlba.DispatchRelativeTimeout;
import org.osate.ba.aadlba.DispatchTriggerConditionStop;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.EnumLiteralHolder;
import org.osate.ba.aadlba.EventDataPortHolder;
import org.osate.ba.aadlba.EventDataSourceHolder;
import org.osate.ba.aadlba.EventPortHolder;
import org.osate.ba.aadlba.EventSourceHolder;
import org.osate.ba.aadlba.ExecutionTimeoutCatch;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.FeatureHolder;
import org.osate.ba.aadlba.FeaturePrototypeHolder;
import org.osate.ba.aadlba.FeatureType;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.GroupHolder;
import org.osate.ba.aadlba.GroupPrototypeHolder;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.IntegerRange;
import org.osate.ba.aadlba.InternalPortSendAction;
import org.osate.ba.aadlba.IterativeVariable;
import org.osate.ba.aadlba.IterativeVariableHolder;
import org.osate.ba.aadlba.LockAction;
import org.osate.ba.aadlba.LogicalOperator;
import org.osate.ba.aadlba.LowerBound;
import org.osate.ba.aadlba.ModeSwitchConjunction;
import org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression;
import org.osate.ba.aadlba.MultiplyingOperator;
import org.osate.ba.aadlba.Otherwise;
import org.osate.ba.aadlba.ParameterHolder;
import org.osate.ba.aadlba.PortCountValue;
import org.osate.ba.aadlba.PortDequeueAction;
import org.osate.ba.aadlba.PortDequeueValue;
import org.osate.ba.aadlba.PortFreezeAction;
import org.osate.ba.aadlba.PortFreshValue;
import org.osate.ba.aadlba.PortPrototypeHolder;
import org.osate.ba.aadlba.PortSendAction;
import org.osate.ba.aadlba.PropertyAssociationHolder;
import org.osate.ba.aadlba.PropertyExpressionHolder;
import org.osate.ba.aadlba.PropertyNameHolder;
import org.osate.ba.aadlba.PropertySetPropertyReference;
import org.osate.ba.aadlba.PropertyTypeHolder;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.RelationalOperator;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.StructUnionElement;
import org.osate.ba.aadlba.StructUnionElementHolder;
import org.osate.ba.aadlba.SubcomponentHolder;
import org.osate.ba.aadlba.SubprogramAccessHolder;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.ba.aadlba.SubprogramHolder;
import org.osate.ba.aadlba.SubprogramHolderProxy;
import org.osate.ba.aadlba.SubprogramPrototypeHolder;
import org.osate.ba.aadlba.SubprogramSubcomponentHolder;
import org.osate.ba.aadlba.Target;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.TimedAction;
import org.osate.ba.aadlba.UnaryAddingOperator;
import org.osate.ba.aadlba.UnaryBooleanOperator;
import org.osate.ba.aadlba.UnaryNumericOperator;
import org.osate.ba.aadlba.UnlockAction;
import org.osate.ba.aadlba.UpperBound;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AadlBaFactoryImpl extends EFactoryImpl implements AadlBaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AadlBaFactory init() {
		try {
			AadlBaFactory theAadlBaFactory = (AadlBaFactory) EPackage.Registry.INSTANCE
					.getEFactory(AadlBaPackage.eNS_URI);
			if (theAadlBaFactory != null) {
				return theAadlBaFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AadlBaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlBaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AadlBaPackage.ASSIGNMENT_ACTION:
			return createAssignmentAction();
		case AadlBaPackage.ANY:
			return createAny();
		case AadlBaPackage.BASIC_PROPERTY_HOLDER:
			return createBasicPropertyHolder();
		case AadlBaPackage.BEHAVIOR_ACTION_BLOCK:
			return createBehaviorActionBlock();
		case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE:
			return createBehaviorActionSequence();
		case AadlBaPackage.BEHAVIOR_ACTION_SET:
			return createBehaviorActionSet();
		case AadlBaPackage.BEHAVIOR_ANNEX:
			return createBehaviorAnnex();
		case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL:
			return createBehaviorBooleanLiteral();
		case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL:
			return createBehaviorIntegerLiteral();
		case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT:
			return createBehaviorPropertyConstant();
		case AadlBaPackage.BEHAVIOR_REAL_LITERAL:
			return createBehaviorRealLiteral();
		case AadlBaPackage.BEHAVIOR_STATE:
			return createBehaviorState();
		case AadlBaPackage.BEHAVIOR_STRING_LITERAL:
			return createBehaviorStringLiteral();
		case AadlBaPackage.BEHAVIOR_TIME:
			return createBehaviorTime();
		case AadlBaPackage.BEHAVIOR_TRANSITION:
			return createBehaviorTransition();
		case AadlBaPackage.BEHAVIOR_VARIABLE:
			return createBehaviorVariable();
		case AadlBaPackage.BEHAVIOR_VARIABLE_HOLDER:
			return createBehaviorVariableHolder();
		case AadlBaPackage.CALLED_SUBPROGRAM_HOLDER:
			return createCalledSubprogramHolder();
		case AadlBaPackage.CLASSIFIER_FEATURE_PROPERTY_REFERENCE:
			return createClassifierFeaturePropertyReference();
		case AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE:
			return createClassifierPropertyReference();
		case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT:
			return createCompletionRelativeTimeout();
		case AadlBaPackage.DATA_ACCESS_HOLDER:
			return createDataAccessHolder();
		case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER:
			return createDataAccessPrototypeHolder();
		case AadlBaPackage.DATA_COMPONENT_REFERENCE:
			return createDataComponentReference();
		case AadlBaPackage.DATA_PORT_HOLDER:
			return createDataPortHolder();
		case AadlBaPackage.DATA_SUBCOMPONENT_HOLDER:
			return createDataSubcomponentHolder();
		case AadlBaPackage.DISPATCH_CONDITION:
			return createDispatchCondition();
		case AadlBaPackage.DISPATCH_CONJUNCTION:
			return createDispatchConjunction();
		case AadlBaPackage.DISPATCH_RELATIVE_TIMEOUT:
			return createDispatchRelativeTimeout();
		case AadlBaPackage.DISPATCH_TRIGGER_CONDITION_STOP:
			return createDispatchTriggerConditionStop();
		case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION:
			return createDispatchTriggerLogicalExpression();
		case AadlBaPackage.ELSE_STATEMENT:
			return createElseStatement();
		case AadlBaPackage.ENUM_LITERAL_HOLDER:
			return createEnumLiteralHolder();
		case AadlBaPackage.EVENT_DATA_PORT_HOLDER:
			return createEventDataPortHolder();
		case AadlBaPackage.EVENT_PORT_HOLDER:
			return createEventPortHolder();
		case AadlBaPackage.EXECUTION_TIMEOUT_CATCH:
			return createExecutionTimeoutCatch();
		case AadlBaPackage.FACTOR:
			return createFactor();
		case AadlBaPackage.FEATURE_HOLDER:
			return createFeatureHolder();
		case AadlBaPackage.FEATURE_PROTOTYPE_HOLDER:
			return createFeaturePrototypeHolder();
		case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT:
			return createForOrForAllStatement();
		case AadlBaPackage.GROUP_HOLDER:
			return createGroupHolder();
		case AadlBaPackage.GROUP_PROTOTYPE_HOLDER:
			return createGroupPrototypeHolder();
		case AadlBaPackage.IF_STATEMENT:
			return createIfStatement();
		case AadlBaPackage.INTEGER_RANGE:
			return createIntegerRange();
		case AadlBaPackage.ITERATIVE_VARIABLE:
			return createIterativeVariable();
		case AadlBaPackage.ITERATIVE_VARIABLE_HOLDER:
			return createIterativeVariableHolder();
		case AadlBaPackage.LOCK_ACTION:
			return createLockAction();
		case AadlBaPackage.LOWER_BOUND:
			return createLowerBound();
		case AadlBaPackage.OTHERWISE:
			return createOtherwise();
		case AadlBaPackage.PARAMETER_HOLDER:
			return createParameterHolder();
		case AadlBaPackage.PORT_COUNT_VALUE:
			return createPortCountValue();
		case AadlBaPackage.PORT_DEQUEUE_ACTION:
			return createPortDequeueAction();
		case AadlBaPackage.PORT_DEQUEUE_VALUE:
			return createPortDequeueValue();
		case AadlBaPackage.PORT_FREEZE_ACTION:
			return createPortFreezeAction();
		case AadlBaPackage.PORT_FRESH_VALUE:
			return createPortFreshValue();
		case AadlBaPackage.PORT_PROTOTYPE_HOLDER:
			return createPortPrototypeHolder();
		case AadlBaPackage.PORT_SEND_ACTION:
			return createPortSendAction();
		case AadlBaPackage.PROPERTY_ASSOCIATION_HOLDER:
			return createPropertyAssociationHolder();
		case AadlBaPackage.PROPERTY_EXPRESSION_HOLDER:
			return createPropertyExpressionHolder();
		case AadlBaPackage.PROPERTY_NAME_HOLDER:
			return createPropertyNameHolder();
		case AadlBaPackage.PROPERTY_SET_PROPERTY_REFERENCE:
			return createPropertySetPropertyReference();
		case AadlBaPackage.PROPERTY_TYPE_HOLDER:
			return createPropertyTypeHolder();
		case AadlBaPackage.RELATION:
			return createRelation();
		case AadlBaPackage.SIMPLE_EXPRESSION:
			return createSimpleExpression();
		case AadlBaPackage.STRUCT_UNION_ELEMENT:
			return createStructUnionElement();
		case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER:
			return createStructUnionElementHolder();
		case AadlBaPackage.SUBCOMPONENT_HOLDER:
			return createSubcomponentHolder();
		case AadlBaPackage.SUBPROGRAM_ACCESS_HOLDER:
			return createSubprogramAccessHolder();
		case AadlBaPackage.SUBPROGRAM_CALL_ACTION:
			return createSubprogramCallAction();
		case AadlBaPackage.SUBPROGRAM_HOLDER:
			return createSubprogramHolder();
		case AadlBaPackage.SUBPROGRAM_HOLDER_PROXY:
			return createSubprogramHolderProxy();
		case AadlBaPackage.SUBPROGRAM_PROTOTYPE_HOLDER:
			return createSubprogramPrototypeHolder();
		case AadlBaPackage.SUBPROGRAM_SUBCOMPONENT_HOLDER:
			return createSubprogramSubcomponentHolder();
		case AadlBaPackage.TARGET:
			return createTarget();
		case AadlBaPackage.TERM:
			return createTerm();
		case AadlBaPackage.TIMED_ACTION:
			return createTimedAction();
		case AadlBaPackage.UNLOCK_ACTION:
			return createUnlockAction();
		case AadlBaPackage.UPPER_BOUND:
			return createUpperBound();
		case AadlBaPackage.VALUE_EXPRESSION:
			return createValueExpression();
		case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT:
			return createWhileOrDoUntilStatement();
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION:
			return createModeSwitchTriggerLogicalExpression();
		case AadlBaPackage.MODE_SWITCH_CONJUNCTION:
			return createModeSwitchConjunction();
		case AadlBaPackage.EVENT_SOURCE_HOLDER:
			return createEventSourceHolder();
		case AadlBaPackage.EVENT_DATA_SOURCE_HOLDER:
			return createEventDataSourceHolder();
		case AadlBaPackage.INTERNAL_PORT_SEND_ACTION:
			return createInternalPortSendAction();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case AadlBaPackage.BEHAVIOR_FEATURE_TYPE:
			return createBehaviorFeatureTypeFromString(eDataType, initialValue);
		case AadlBaPackage.BINARY_ADDING_OPERATOR:
			return createBinaryAddingOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.BINARY_NUMERIC_OPERATOR:
			return createBinaryNumericOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.DATA_REPRESENTATION:
			return createDataRepresentationFromString(eDataType, initialValue);
		case AadlBaPackage.FEATURE_TYPE:
			return createFeatureTypeFromString(eDataType, initialValue);
		case AadlBaPackage.LOGICAL_OPERATOR:
			return createLogicalOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.MULTIPLYING_OPERATOR:
			return createMultiplyingOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.RELATIONAL_OPERATOR:
			return createRelationalOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.UNARY_ADDING_OPERATOR:
			return createUnaryAddingOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.UNARY_BOOLEAN_OPERATOR:
			return createUnaryBooleanOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.UNARY_NUMERIC_OPERATOR:
			return createUnaryNumericOperatorFromString(eDataType, initialValue);
		case AadlBaPackage.BOOLEAN:
			return createBooleanFromString(eDataType, initialValue);
		case AadlBaPackage.INTEGER:
			return createIntegerFromString(eDataType, initialValue);
		case AadlBaPackage.REAL:
			return createRealFromString(eDataType, initialValue);
		case AadlBaPackage.STRING:
			return createStringFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case AadlBaPackage.BEHAVIOR_FEATURE_TYPE:
			return convertBehaviorFeatureTypeToString(eDataType, instanceValue);
		case AadlBaPackage.BINARY_ADDING_OPERATOR:
			return convertBinaryAddingOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.BINARY_NUMERIC_OPERATOR:
			return convertBinaryNumericOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.DATA_REPRESENTATION:
			return convertDataRepresentationToString(eDataType, instanceValue);
		case AadlBaPackage.FEATURE_TYPE:
			return convertFeatureTypeToString(eDataType, instanceValue);
		case AadlBaPackage.LOGICAL_OPERATOR:
			return convertLogicalOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.MULTIPLYING_OPERATOR:
			return convertMultiplyingOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.RELATIONAL_OPERATOR:
			return convertRelationalOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.UNARY_ADDING_OPERATOR:
			return convertUnaryAddingOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.UNARY_BOOLEAN_OPERATOR:
			return convertUnaryBooleanOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.UNARY_NUMERIC_OPERATOR:
			return convertUnaryNumericOperatorToString(eDataType, instanceValue);
		case AadlBaPackage.BOOLEAN:
			return convertBooleanToString(eDataType, instanceValue);
		case AadlBaPackage.INTEGER:
			return convertIntegerToString(eDataType, instanceValue);
		case AadlBaPackage.REAL:
			return convertRealToString(eDataType, instanceValue);
		case AadlBaPackage.STRING:
			return convertStringToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssignmentAction createAssignmentAction() {
		AssignmentActionImpl assignmentAction = new AssignmentActionImpl();
		return assignmentAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Any createAny() {
		AnyImpl any = new AnyImpl();
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicPropertyHolder createBasicPropertyHolder() {
		BasicPropertyHolderImpl basicPropertyHolder = new BasicPropertyHolderImpl();
		return basicPropertyHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorActionBlock createBehaviorActionBlock() {
		BehaviorActionBlockImpl behaviorActionBlock = new BehaviorActionBlockImpl();
		return behaviorActionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorActionSequence createBehaviorActionSequence() {
		BehaviorActionSequenceImpl behaviorActionSequence = new BehaviorActionSequenceImpl();
		return behaviorActionSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorActionSet createBehaviorActionSet() {
		BehaviorActionSetImpl behaviorActionSet = new BehaviorActionSetImpl();
		return behaviorActionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorAnnex createBehaviorAnnex() {
		BehaviorAnnexImpl behaviorAnnex = new BehaviorAnnexImpl();
		return behaviorAnnex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorBooleanLiteral createBehaviorBooleanLiteral() {
		BehaviorBooleanLiteralImpl behaviorBooleanLiteral = new BehaviorBooleanLiteralImpl();
		return behaviorBooleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorIntegerLiteral createBehaviorIntegerLiteral() {
		BehaviorIntegerLiteralImpl behaviorIntegerLiteral = new BehaviorIntegerLiteralImpl();
		return behaviorIntegerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorPropertyConstant createBehaviorPropertyConstant() {
		BehaviorPropertyConstantImpl behaviorPropertyConstant = new BehaviorPropertyConstantImpl();
		return behaviorPropertyConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorRealLiteral createBehaviorRealLiteral() {
		BehaviorRealLiteralImpl behaviorRealLiteral = new BehaviorRealLiteralImpl();
		return behaviorRealLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorState createBehaviorState() {
		BehaviorStateImpl behaviorState = new BehaviorStateImpl();
		return behaviorState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorStringLiteral createBehaviorStringLiteral() {
		BehaviorStringLiteralImpl behaviorStringLiteral = new BehaviorStringLiteralImpl();
		return behaviorStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorTime createBehaviorTime() {
		BehaviorTimeImpl behaviorTime = new BehaviorTimeImpl();
		return behaviorTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorTransition createBehaviorTransition() {
		BehaviorTransitionImpl behaviorTransition = new BehaviorTransitionImpl();
		return behaviorTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorVariable createBehaviorVariable() {
		BehaviorVariableImpl behaviorVariable = new BehaviorVariableImpl();
		return behaviorVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorVariableHolder createBehaviorVariableHolder() {
		BehaviorVariableHolderImpl behaviorVariableHolder = new BehaviorVariableHolderImpl();
		return behaviorVariableHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CalledSubprogramHolder createCalledSubprogramHolder() {
		CalledSubprogramHolderImpl calledSubprogramHolder = new CalledSubprogramHolderImpl();
		return calledSubprogramHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompletionRelativeTimeout createCompletionRelativeTimeout() {
		CompletionRelativeTimeoutImpl completionRelativeTimeout = new CompletionRelativeTimeoutImpl();
		return completionRelativeTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassifierFeaturePropertyReference createClassifierFeaturePropertyReference() {
		ClassifierFeaturePropertyReferenceImpl classifierFeaturePropertyReference = new ClassifierFeaturePropertyReferenceImpl();
		return classifierFeaturePropertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataAccessHolder createDataAccessHolder() {
		DataAccessHolderImpl dataAccessHolder = new DataAccessHolderImpl();
		return dataAccessHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataAccessPrototypeHolder createDataAccessPrototypeHolder() {
		DataAccessPrototypeHolderImpl dataAccessPrototypeHolder = new DataAccessPrototypeHolderImpl();
		return dataAccessPrototypeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataComponentReference createDataComponentReference() {
		DataComponentReferenceImpl dataComponentReference = new DataComponentReferenceImpl();
		return dataComponentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataPortHolder createDataPortHolder() {
		DataPortHolderImpl dataPortHolder = new DataPortHolderImpl();
		return dataPortHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSubcomponentHolder createDataSubcomponentHolder() {
		DataSubcomponentHolderImpl dataSubcomponentHolder = new DataSubcomponentHolderImpl();
		return dataSubcomponentHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DispatchCondition createDispatchCondition() {
		DispatchConditionImpl dispatchCondition = new DispatchConditionImpl();
		return dispatchCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DispatchConjunction createDispatchConjunction() {
		DispatchConjunctionImpl dispatchConjunction = new DispatchConjunctionImpl();
		return dispatchConjunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DispatchRelativeTimeout createDispatchRelativeTimeout() {
		DispatchRelativeTimeoutImpl dispatchRelativeTimeout = new DispatchRelativeTimeoutImpl();
		return dispatchRelativeTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DispatchTriggerConditionStop createDispatchTriggerConditionStop() {
		DispatchTriggerConditionStopImpl dispatchTriggerConditionStop = new DispatchTriggerConditionStopImpl();
		return dispatchTriggerConditionStop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DispatchTriggerLogicalExpression createDispatchTriggerLogicalExpression() {
		DispatchTriggerLogicalExpressionImpl dispatchTriggerLogicalExpression = new DispatchTriggerLogicalExpressionImpl();
		return dispatchTriggerLogicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElseStatement createElseStatement() {
		ElseStatementImpl elseStatement = new ElseStatementImpl();
		return elseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumLiteralHolder createEnumLiteralHolder() {
		EnumLiteralHolderImpl enumLiteralHolder = new EnumLiteralHolderImpl();
		return enumLiteralHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventDataPortHolder createEventDataPortHolder() {
		EventDataPortHolderImpl eventDataPortHolder = new EventDataPortHolderImpl();
		return eventDataPortHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventPortHolder createEventPortHolder() {
		EventPortHolderImpl eventPortHolder = new EventPortHolderImpl();
		return eventPortHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionTimeoutCatch createExecutionTimeoutCatch() {
		ExecutionTimeoutCatchImpl executionTimeoutCatch = new ExecutionTimeoutCatchImpl();
		return executionTimeoutCatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Factor createFactor() {
		FactorImpl factor = new FactorImpl();
		return factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeaturePrototypeHolder createFeaturePrototypeHolder() {
		FeaturePrototypeHolderImpl featurePrototypeHolder = new FeaturePrototypeHolderImpl();
		return featurePrototypeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForOrForAllStatement createForOrForAllStatement() {
		ForOrForAllStatementImpl forOrForAllStatement = new ForOrForAllStatementImpl();
		return forOrForAllStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupHolder createGroupHolder() {
		GroupHolderImpl groupHolder = new GroupHolderImpl();
		return groupHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupPrototypeHolder createGroupPrototypeHolder() {
		GroupPrototypeHolderImpl groupPrototypeHolder = new GroupPrototypeHolderImpl();
		return groupPrototypeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerRange createIntegerRange() {
		IntegerRangeImpl integerRange = new IntegerRangeImpl();
		return integerRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IterativeVariable createIterativeVariable() {
		IterativeVariableImpl iterativeVariable = new IterativeVariableImpl();
		return iterativeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IterativeVariableHolder createIterativeVariableHolder() {
		IterativeVariableHolderImpl iterativeVariableHolder = new IterativeVariableHolderImpl();
		return iterativeVariableHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LockAction createLockAction() {
		LockActionImpl lockAction = new LockActionImpl();
		return lockAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Otherwise createOtherwise() {
		OtherwiseImpl otherwise = new OtherwiseImpl();
		return otherwise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterHolder createParameterHolder() {
		ParameterHolderImpl parameterHolder = new ParameterHolderImpl();
		return parameterHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortCountValue createPortCountValue() {
		PortCountValueImpl portCountValue = new PortCountValueImpl();
		return portCountValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortDequeueAction createPortDequeueAction() {
		PortDequeueActionImpl portDequeueAction = new PortDequeueActionImpl();
		return portDequeueAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortDequeueValue createPortDequeueValue() {
		PortDequeueValueImpl portDequeueValue = new PortDequeueValueImpl();
		return portDequeueValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortFreezeAction createPortFreezeAction() {
		PortFreezeActionImpl portFreezeAction = new PortFreezeActionImpl();
		return portFreezeAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortFreshValue createPortFreshValue() {
		PortFreshValueImpl portFreshValue = new PortFreshValueImpl();
		return portFreshValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortPrototypeHolder createPortPrototypeHolder() {
		PortPrototypeHolderImpl portPrototypeHolder = new PortPrototypeHolderImpl();
		return portPrototypeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortSendAction createPortSendAction() {
		PortSendActionImpl portSendAction = new PortSendActionImpl();
		return portSendAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyNameHolder createPropertyNameHolder() {
		PropertyNameHolderImpl propertyNameHolder = new PropertyNameHolderImpl();
		return propertyNameHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyAssociationHolder createPropertyAssociationHolder() {
		PropertyAssociationHolderImpl propertyAssociationHolder = new PropertyAssociationHolderImpl();
		return propertyAssociationHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyExpressionHolder createPropertyExpressionHolder() {
		PropertyExpressionHolderImpl propertyExpressionHolder = new PropertyExpressionHolderImpl();
		return propertyExpressionHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyTypeHolder createPropertyTypeHolder() {
		PropertyTypeHolderImpl propertyTypeHolder = new PropertyTypeHolderImpl();
		return propertyTypeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleExpression createSimpleExpression() {
		SimpleExpressionImpl simpleExpression = new SimpleExpressionImpl();
		return simpleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructUnionElement createStructUnionElement() {
		StructUnionElementImpl structUnionElement = new StructUnionElementImpl();
		return structUnionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructUnionElementHolder createStructUnionElementHolder() {
		StructUnionElementHolderImpl structUnionElementHolder = new StructUnionElementHolderImpl();
		return structUnionElementHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramAccessHolder createSubprogramAccessHolder() {
		SubprogramAccessHolderImpl subprogramAccessHolder = new SubprogramAccessHolderImpl();
		return subprogramAccessHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramCallAction createSubprogramCallAction() {
		SubprogramCallActionImpl subprogramCallAction = new SubprogramCallActionImpl();
		return subprogramCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramHolder createSubprogramHolder() {
		SubprogramHolderImpl subprogramHolder = new SubprogramHolderImpl();
		return subprogramHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramHolderProxy createSubprogramHolderProxy() {
		SubprogramHolderProxyImpl subprogramHolderProxy = new SubprogramHolderProxyImpl();
		return subprogramHolderProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramPrototypeHolder createSubprogramPrototypeHolder() {
		SubprogramPrototypeHolderImpl subprogramPrototypeHolder = new SubprogramPrototypeHolderImpl();
		return subprogramPrototypeHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term createTerm() {
		TermImpl term = new TermImpl();
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimedAction createTimedAction() {
		TimedActionImpl timedAction = new TimedActionImpl();
		return timedAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnlockAction createUnlockAction() {
		UnlockActionImpl unlockAction = new UnlockActionImpl();
		return unlockAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueExpression createValueExpression() {
		ValueExpressionImpl valueExpression = new ValueExpressionImpl();
		return valueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WhileOrDoUntilStatement createWhileOrDoUntilStatement() {
		WhileOrDoUntilStatementImpl whileOrDoUntilStatement = new WhileOrDoUntilStatementImpl();
		return whileOrDoUntilStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeSwitchTriggerLogicalExpression createModeSwitchTriggerLogicalExpression() {
		ModeSwitchTriggerLogicalExpressionImpl modeSwitchTriggerLogicalExpression = new ModeSwitchTriggerLogicalExpressionImpl();
		return modeSwitchTriggerLogicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeSwitchConjunction createModeSwitchConjunction() {
		ModeSwitchConjunctionImpl modeSwitchConjunction = new ModeSwitchConjunctionImpl();
		return modeSwitchConjunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertySetPropertyReference createPropertySetPropertyReference() {
		PropertySetPropertyReferenceImpl propertySetPropertyReference = new PropertySetPropertyReferenceImpl();
		return propertySetPropertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubcomponentHolder createSubcomponentHolder() {
		SubcomponentHolderImpl subcomponentHolder = new SubcomponentHolderImpl();
		return subcomponentHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramSubcomponentHolder createSubprogramSubcomponentHolder() {
		SubprogramSubcomponentHolderImpl subprogramSubcomponentHolder = new SubprogramSubcomponentHolderImpl();
		return subprogramSubcomponentHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureHolder createFeatureHolder() {
		FeatureHolderImpl featureHolder = new FeatureHolderImpl();
		return featureHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassifierPropertyReference createClassifierPropertyReference() {
		ClassifierPropertyReferenceImpl classifierPropertyReference = new ClassifierPropertyReferenceImpl();
		return classifierPropertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UpperBound createUpperBound() {
		UpperBoundImpl upperBound = new UpperBoundImpl();
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LowerBound createLowerBound() {
		LowerBoundImpl lowerBound = new LowerBoundImpl();
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorFeatureType createBehaviorFeatureTypeFromString(EDataType eDataType, String initialValue) {
		BehaviorFeatureType result = BehaviorFeatureType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBehaviorFeatureTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryAddingOperator createBinaryAddingOperatorFromString(EDataType eDataType, String initialValue) {
		BinaryAddingOperator result = BinaryAddingOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryAddingOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryNumericOperator createBinaryNumericOperatorFromString(EDataType eDataType, String initialValue) {
		BinaryNumericOperator result = BinaryNumericOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryNumericOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRepresentation createDataRepresentationFromString(EDataType eDataType, String initialValue) {
		DataRepresentation result = DataRepresentation.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataRepresentationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType createFeatureTypeFromString(EDataType eDataType, String initialValue) {
		FeatureType result = FeatureType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOperator createLogicalOperatorFromString(EDataType eDataType, String initialValue) {
		LogicalOperator result = LogicalOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplyingOperator createMultiplyingOperatorFromString(EDataType eDataType, String initialValue) {
		MultiplyingOperator result = MultiplyingOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplyingOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue) {
		RelationalOperator result = RelationalOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryAddingOperator createUnaryAddingOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryAddingOperator result = UnaryAddingOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryAddingOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryBooleanOperator createUnaryBooleanOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryBooleanOperator result = UnaryBooleanOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryBooleanOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryNumericOperator createUnaryNumericOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryNumericOperator result = UnaryNumericOperator.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryNumericOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean createBooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createIntegerFromString(EDataType eDataType, String initialValue) {
		return (Integer) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createRealFromString(EDataType eDataType, String initialValue) {
		return (Double) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventSourceHolder createEventSourceHolder() {
		EventSourceHolderImpl eventSourceHolder = new EventSourceHolderImpl();
		return eventSourceHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventDataSourceHolder createEventDataSourceHolder() {
		EventDataSourceHolderImpl eventDataSourceHolder = new EventDataSourceHolderImpl();
		return eventDataSourceHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InternalPortSendAction createInternalPortSendAction() {
		InternalPortSendActionImpl internalPortSendAction = new InternalPortSendActionImpl();
		return internalPortSendAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AadlBaPackage getAadlBaPackage() {
		return (AadlBaPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AadlBaPackage getPackage() {
		return AadlBaPackage.eINSTANCE;
	}

} // AadlBaFactoryImpl
