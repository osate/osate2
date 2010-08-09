/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AadlBaFactoryImpl extends EFactoryImpl implements AadlBaFactory
{
   /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static AadlBaFactory init()
   {
		try {
			AadlBaFactory theAadlBaFactory = (AadlBaFactory)EPackage.Registry.INSTANCE.getEFactory("http:///AADLBA"); 
			if (theAadlBaFactory != null) {
				return theAadlBaFactory;
			}
		}
		catch (Exception exception) {
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
   public AadlBaFactoryImpl()
   {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public EObject create(EClass eClass)
   {
		switch (eClass.getClassifierID()) {
			case AadlBaPackage.COMMENT: return (EObject)createComment();
			case AadlBaPackage.GLOBAL_NAMESPACE: return (EObject)createGlobalNamespace();
			case AadlBaPackage.BEHAVIOR_ANNEX: return (EObject)createBehaviorAnnex();
			case AadlBaPackage.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE: return (EObject)createUniqueComponentClassifierReference();
			case AadlBaPackage.BEHAVIOR_VARIABLE: return (EObject)createBehaviorVariable();
			case AadlBaPackage.BEHAVIOR_STATE: return (EObject)createBehaviorState();
			case AadlBaPackage.BEHAVIOR_TRANSITION: return (EObject)createBehaviorTransition();
			case AadlBaPackage.DECLARATOR: return (EObject)createDeclarator();
			case AadlBaPackage.ARRAY_SIZE: return (EObject)createArraySize();
			case AadlBaPackage.DISPATCH_CONDITION: return (EObject)createDispatchCondition();
			case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION: return (EObject)createDispatchLogicalExpression();
			case AadlBaPackage.DISPATCH_TRIGGER: return (EObject)createDispatchTrigger();
			case AadlBaPackage.BEHAVIOR_ACTIONS: return (EObject)createBehaviorActions();
			case AadlBaPackage.BEHAVIOR_ACTION: return (EObject)createBehaviorAction();
			case AadlBaPackage.IF_STATEMENT: return (EObject)createIfStatement();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT: return (EObject)createForOrForAllStatement();
			case AadlBaPackage.WHILE_STATEMENT: return (EObject)createWhileStatement();
			case AadlBaPackage.DO_UNTIL_STATEMENT: return (EObject)createDoUntilStatement();
			case AadlBaPackage.ASSIGNMENT_ACTION: return (EObject)createAssignmentAction();
			case AadlBaPackage.COMMUNICATION_ACTION: return (EObject)createCommunicationAction();
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST: return (EObject)createSubprogramParameterList();
			case AadlBaPackage.TIMED_ACTION: return (EObject)createTimedAction();
			case AadlBaPackage.TARGET: return (EObject)createTarget();
			case AadlBaPackage.DATA_COMPONENT_REFERENCE: return (EObject)createDataComponentReference();
			case AadlBaPackage.NAME: return (EObject)createName();
			case AadlBaPackage.ARRAY_INDEX: return (EObject)createArrayIndex();
			case AadlBaPackage.VALUE_VARIABLE: return (EObject)createValueVariable();
			case AadlBaPackage.VALUE_EXPRESSION: return (EObject)createValueExpression();
			case AadlBaPackage.RELATION: return (EObject)createRelation();
			case AadlBaPackage.SIMPLE_EXPRESSION: return (EObject)createSimpleExpression();
			case AadlBaPackage.TERM: return (EObject)createTerm();
			case AadlBaPackage.FACTOR: return (EObject)createFactor();
			case AadlBaPackage.INTEGER_RANGE: return (EObject)createIntegerRange();
			case AadlBaPackage.BEHAVIOR_TIME: return (EObject)createBehaviorTime();
			case AadlBaPackage.PROPERTY_CONSTANT: return (EObject)createPropertyConstant();
			case AadlBaPackage.PROPERTY_VALUE: return (EObject)createPropertyValue();
			case AadlBaPackage.IDENTIFIER: return (EObject)createIdentifier();
			case AadlBaPackage.NUMERIC_LITERAL: return (EObject)createNumericLiteral();
			case AadlBaPackage.BOOLEAN_LITERAL: return (EObject)createBooleanLiteral();
			case AadlBaPackage.STRING_LITERAL: return (EObject)createStringLiteral();
			case AadlBaPackage.NUMERAL: return (EObject)createNumeral();
			case AadlBaPackage.EXECUTE_CONDITION: return (EObject)createExecuteCondition();
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
   public Object createFromString(EDataType eDataType, String initialValue)
   {
		switch (eDataType.getClassifierID()) {
			case AadlBaPackage.COMM_ACTION_PARAMETER:
				return createCommActionParameterFromString(eDataType, initialValue);
			case AadlBaPackage.LOGICAL_OPERATOR:
				return createLogicalOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.BINARY_ADDING_OPERATOR:
				return createBinaryAddingOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.UNARY_ADDING_OPERATOR:
				return createUnaryAddingOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.MULTIPLYING_OPERATOR:
				return createMultiplyingOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.BINARY_NUMERIC_OPERATOR:
				return createBinaryNumericOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.UNARY_NUMERIC_OPERATOR:
				return createUnaryNumericOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.UNARY_BOOLEAN_OPERATOR:
				return createUnaryBooleanOperatorFromString(eDataType, initialValue);
			case AadlBaPackage.INTEGER:
				return createIntegerFromString(eDataType, initialValue);
			case AadlBaPackage.REAL:
				return createRealFromString(eDataType, initialValue);
			case AadlBaPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case AadlBaPackage.BOOLEAN:
				return createBooleanFromString(eDataType, initialValue);
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
   public String convertToString(EDataType eDataType, Object instanceValue)
   {
		switch (eDataType.getClassifierID()) {
			case AadlBaPackage.COMM_ACTION_PARAMETER:
				return convertCommActionParameterToString(eDataType, instanceValue);
			case AadlBaPackage.LOGICAL_OPERATOR:
				return convertLogicalOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.BINARY_ADDING_OPERATOR:
				return convertBinaryAddingOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.UNARY_ADDING_OPERATOR:
				return convertUnaryAddingOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.MULTIPLYING_OPERATOR:
				return convertMultiplyingOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.BINARY_NUMERIC_OPERATOR:
				return convertBinaryNumericOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.UNARY_NUMERIC_OPERATOR:
				return convertUnaryNumericOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.UNARY_BOOLEAN_OPERATOR:
				return convertUnaryBooleanOperatorToString(eDataType, instanceValue);
			case AadlBaPackage.INTEGER:
				return convertIntegerToString(eDataType, instanceValue);
			case AadlBaPackage.REAL:
				return convertRealToString(eDataType, instanceValue);
			case AadlBaPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case AadlBaPackage.BOOLEAN:
				return convertBooleanToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Comment createComment()
   {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public GlobalNamespace createGlobalNamespace()
   {
		GlobalNamespaceImpl globalNamespace = new GlobalNamespaceImpl();
		return globalNamespace;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorAnnex createBehaviorAnnex()
   {
		BehaviorAnnexImpl behaviorAnnex = new BehaviorAnnexImpl();
		return behaviorAnnex;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UniqueComponentClassifierReference createUniqueComponentClassifierReference()
   {
		UniqueComponentClassifierReferenceImpl uniqueComponentClassifierReference = new UniqueComponentClassifierReferenceImpl();
		return uniqueComponentClassifierReference;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorVariable createBehaviorVariable()
   {
		BehaviorVariableImpl behaviorVariable = new BehaviorVariableImpl();
		return behaviorVariable;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorState createBehaviorState()
   {
		BehaviorStateImpl behaviorState = new BehaviorStateImpl();
		return behaviorState;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorTransition createBehaviorTransition()
   {
		BehaviorTransitionImpl behaviorTransition = new BehaviorTransitionImpl();
		return behaviorTransition;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Declarator createDeclarator()
   {
		DeclaratorImpl declarator = new DeclaratorImpl();
		return declarator;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ArraySize createArraySize()
   {
		ArraySizeImpl arraySize = new ArraySizeImpl();
		return arraySize;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public DispatchCondition createDispatchCondition()
   {
		DispatchConditionImpl dispatchCondition = new DispatchConditionImpl();
		return dispatchCondition;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public DispatchLogicalExpression createDispatchLogicalExpression()
   {
		DispatchLogicalExpressionImpl dispatchLogicalExpression = new DispatchLogicalExpressionImpl();
		return dispatchLogicalExpression;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public DispatchTrigger createDispatchTrigger()
   {
		DispatchTriggerImpl dispatchTrigger = new DispatchTriggerImpl();
		return dispatchTrigger;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorActions createBehaviorActions()
   {
		BehaviorActionsImpl behaviorActions = new BehaviorActionsImpl();
		return behaviorActions;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorAction createBehaviorAction()
   {
		BehaviorActionImpl behaviorAction = new BehaviorActionImpl();
		return behaviorAction;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public IfStatement createIfStatement()
   {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ForOrForAllStatement createForOrForAllStatement()
   {
		ForOrForAllStatementImpl forOrForAllStatement = new ForOrForAllStatementImpl();
		return forOrForAllStatement;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public WhileStatement createWhileStatement()
   {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public DoUntilStatement createDoUntilStatement()
   {
		DoUntilStatementImpl doUntilStatement = new DoUntilStatementImpl();
		return doUntilStatement;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public AssignmentAction createAssignmentAction()
   {
		AssignmentActionImpl assignmentAction = new AssignmentActionImpl();
		return assignmentAction;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public CommunicationAction createCommunicationAction()
   {
		CommunicationActionImpl communicationAction = new CommunicationActionImpl();
		return communicationAction;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public SubprogramParameterList createSubprogramParameterList()
   {
		SubprogramParameterListImpl subprogramParameterList = new SubprogramParameterListImpl();
		return subprogramParameterList;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public TimedAction createTimedAction()
   {
		TimedActionImpl timedAction = new TimedActionImpl();
		return timedAction;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Target createTarget()
   {
		TargetImpl target = new TargetImpl();
		return target;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public DataComponentReference createDataComponentReference()
   {
		DataComponentReferenceImpl dataComponentReference = new DataComponentReferenceImpl();
		return dataComponentReference;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Name createName()
   {
		NameImpl name = new NameImpl();
		return name;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ArrayIndex createArrayIndex()
   {
		ArrayIndexImpl arrayIndex = new ArrayIndexImpl();
		return arrayIndex;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ValueVariable createValueVariable()
   {
		ValueVariableImpl valueVariable = new ValueVariableImpl();
		return valueVariable;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ValueExpression createValueExpression()
   {
		ValueExpressionImpl valueExpression = new ValueExpressionImpl();
		return valueExpression;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Relation createRelation()
   {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public SimpleExpression createSimpleExpression()
   {
		SimpleExpressionImpl simpleExpression = new SimpleExpressionImpl();
		return simpleExpression;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Term createTerm()
   {
		TermImpl term = new TermImpl();
		return term;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Factor createFactor()
   {
		FactorImpl factor = new FactorImpl();
		return factor;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public IntegerRange createIntegerRange()
   {
		IntegerRangeImpl integerRange = new IntegerRangeImpl();
		return integerRange;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorTime createBehaviorTime()
   {
		BehaviorTimeImpl behaviorTime = new BehaviorTimeImpl();
		return behaviorTime;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public PropertyConstant createPropertyConstant()
   {
		PropertyConstantImpl propertyConstant = new PropertyConstantImpl();
		return propertyConstant;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public PropertyValue createPropertyValue()
   {
		PropertyValueImpl propertyValue = new PropertyValueImpl();
		return propertyValue;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Identifier createIdentifier()
   {
		IdentifierImpl identifier = new IdentifierImpl();
		return identifier;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NumericLiteral createNumericLiteral()
   {
		NumericLiteralImpl numericLiteral = new NumericLiteralImpl();
		return numericLiteral;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BooleanLiteral createBooleanLiteral()
   {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public StringLiteral createStringLiteral()
   {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Numeral createNumeral()
   {
		NumeralImpl numeral = new NumeralImpl();
		return numeral;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ExecuteCondition createExecuteCondition()
   {
		ExecuteConditionImpl executeCondition = new ExecuteConditionImpl();
		return executeCondition;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public CommActionParameter createCommActionParameterFromString(EDataType eDataType, String initialValue)
   {
		CommActionParameter result = CommActionParameter.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertCommActionParameterToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public LogicalOperator createLogicalOperatorFromString(EDataType eDataType, String initialValue)
   {
		LogicalOperator result = LogicalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertLogicalOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
   {
		RelationalOperator result = RelationalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BinaryAddingOperator createBinaryAddingOperatorFromString(EDataType eDataType, String initialValue)
   {
		BinaryAddingOperator result = BinaryAddingOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertBinaryAddingOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UnaryAddingOperator createUnaryAddingOperatorFromString(EDataType eDataType, String initialValue)
   {
		UnaryAddingOperator result = UnaryAddingOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertUnaryAddingOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public MultiplyingOperator createMultiplyingOperatorFromString(EDataType eDataType, String initialValue)
   {
		MultiplyingOperator result = MultiplyingOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertMultiplyingOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BinaryNumericOperator createBinaryNumericOperatorFromString(EDataType eDataType, String initialValue)
   {
		BinaryNumericOperator result = BinaryNumericOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertBinaryNumericOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UnaryNumericOperator createUnaryNumericOperatorFromString(EDataType eDataType, String initialValue)
   {
		UnaryNumericOperator result = UnaryNumericOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertUnaryNumericOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UnaryBooleanOperator createUnaryBooleanOperatorFromString(EDataType eDataType, String initialValue)
   {
		UnaryBooleanOperator result = UnaryBooleanOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertUnaryBooleanOperatorToString(EDataType eDataType, Object instanceValue)
   {
		return instanceValue == null ? null : instanceValue.toString();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Integer createIntegerFromString(EDataType eDataType, String initialValue)
   {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertIntegerToString(EDataType eDataType, Object instanceValue)
   {
		return super.convertToString(eDataType, instanceValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Double createRealFromString(EDataType eDataType, String initialValue)
   {
		return (Double)super.createFromString(eDataType, initialValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertRealToString(EDataType eDataType, Object instanceValue)
   {
		return super.convertToString(eDataType, instanceValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String createStringFromString(EDataType eDataType, String initialValue)
   {
		return (String)super.createFromString(eDataType, initialValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertStringToString(EDataType eDataType, Object instanceValue)
   {
		return super.convertToString(eDataType, instanceValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Boolean createBooleanFromString(EDataType eDataType, String initialValue)
   {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String convertBooleanToString(EDataType eDataType, Object instanceValue)
   {
		return super.convertToString(eDataType, instanceValue);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public AadlBaPackage getAadlBaPackage()
   {
		return (AadlBaPackage)getEPackage();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
   @Deprecated
   public static AadlBaPackage getPackage()
   {
		return AadlBaPackage.eINSTANCE;
	}

} //AadlBaFactoryImpl
