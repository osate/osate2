/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.util;

import edu.cmu.sei.aadl.aadl2.util.Aadl2Validator;

import fr.tpt.aadl.annex.behavior.aadlba.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage
 * @generated
 */
public class AadlBaValidator extends EObjectValidator
{
   /**
    * The cached model package
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final AadlBaValidator INSTANCE = new AadlBaValidator();

   /**
    * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.emf.common.util.Diagnostic#getSource()
    * @see org.eclipse.emf.common.util.Diagnostic#getCode()
    * @generated
    */
   public static final String DIAGNOSTIC_SOURCE = "fr.tpt.aadl.annex.behavior.aadlba";

   /**
    * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has no qualified name' of 'Named Element'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final int NAMED_ELEMENT__HAS_NO_QUALIFIED_NAME = 1;

   /**
    * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has qualified name' of 'Named Element'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final int NAMED_ELEMENT__HAS_QUALIFIED_NAME = 2;

   /**
    * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Members distinguishable' of 'Namespace'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final int NAMESPACE__MEMBERS_DISTINGUISHABLE = 3;

   /**
    * A constant with a fixed name that can be used as the base value for additional hand written constants.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 3;

   /**
    * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

   /**
    * The cached base package validator.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected Aadl2Validator aadl2Validator;

   /**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public AadlBaValidator()
   {
      super();
      aadl2Validator = Aadl2Validator.INSTANCE;
   }

   /**
    * Returns the package of this validator switch.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EPackage getEPackage()
   {
     return AadlBaPackage.eINSTANCE;
   }

   /**
    * Calls <code>validateXXX</code> for the corresponding classifier of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      switch (classifierID)
      {
         case AadlBaPackage.ELEMENT:
            return validateElement((Element)value, diagnostics, context);
         case AadlBaPackage.COMMENT:
            return validateComment((Comment)value, diagnostics, context);
         case AadlBaPackage.NAMED_ELEMENT:
            return validateNamedElement((NamedElement)value, diagnostics, context);
         case AadlBaPackage.NAMESPACE:
            return validateNamespace((Namespace)value, diagnostics, context);
         case AadlBaPackage.GLOBAL_NAMESPACE:
            return validateGlobalNamespace((GlobalNamespace)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_ANNEX:
            return validateBehaviorAnnex((BehaviorAnnex)value, diagnostics, context);
         case AadlBaPackage.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
            return validateUniqueComponentClassifierReference((UniqueComponentClassifierReference)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_VARIABLE:
            return validateBehaviorVariable((BehaviorVariable)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_STATE:
            return validateBehaviorState((BehaviorState)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_TRANSITION:
            return validateBehaviorTransition((BehaviorTransition)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_CONDITION:
            return validateBehaviorCondition((BehaviorCondition)value, diagnostics, context);
         case AadlBaPackage.DECLARATOR:
            return validateDeclarator((Declarator)value, diagnostics, context);
         case AadlBaPackage.ARRAY_SIZE:
            return validateArraySize((ArraySize)value, diagnostics, context);
         case AadlBaPackage.DISPATCH_CONDITION:
            return validateDispatchCondition((DispatchCondition)value, diagnostics, context);
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION:
            return validateDispatchLogicalExpression((DispatchLogicalExpression)value, diagnostics, context);
         case AadlBaPackage.DISPATCH_TRIGGER:
            return validateDispatchTrigger((DispatchTrigger)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_ACTIONS:
            return validateBehaviorActions((BehaviorActions)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_ACTION:
            return validateBehaviorAction((BehaviorAction)value, diagnostics, context);
         case AadlBaPackage.COND_STATEMENT:
            return validateCondStatement((CondStatement)value, diagnostics, context);
         case AadlBaPackage.BASIC_ACTION:
            return validateBasicAction((BasicAction)value, diagnostics, context);
         case AadlBaPackage.IF_STATEMENT:
            return validateIfStatement((IfStatement)value, diagnostics, context);
         case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT:
            return validateForOrForAllStatement((ForOrForAllStatement)value, diagnostics, context);
         case AadlBaPackage.WHILE_STATEMENT:
            return validateWhileStatement((WhileStatement)value, diagnostics, context);
         case AadlBaPackage.DO_UNTIL_STATEMENT:
            return validateDoUntilStatement((DoUntilStatement)value, diagnostics, context);
         case AadlBaPackage.ELEMENT_VALUES:
            return validateElementValues((ElementValues)value, diagnostics, context);
         case AadlBaPackage.ASSIGNMENT_ACTION:
            return validateAssignmentAction((AssignmentAction)value, diagnostics, context);
         case AadlBaPackage.COMMUNICATION_ACTION:
            return validateCommunicationAction((CommunicationAction)value, diagnostics, context);
         case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST:
            return validateSubprogramParameterList((SubprogramParameterList)value, diagnostics, context);
         case AadlBaPackage.TIMED_ACTION:
            return validateTimedAction((TimedAction)value, diagnostics, context);
         case AadlBaPackage.TARGET:
            return validateTarget((Target)value, diagnostics, context);
         case AadlBaPackage.PARAMETER_LABEL:
            return validateParameterLabel((ParameterLabel)value, diagnostics, context);
         case AadlBaPackage.DATA_COMPONENT_REFERENCE:
            return validateDataComponentReference((DataComponentReference)value, diagnostics, context);
         case AadlBaPackage.NAME:
            return validateName((Name)value, diagnostics, context);
         case AadlBaPackage.ARRAY_INDEX:
            return validateArrayIndex((ArrayIndex)value, diagnostics, context);
         case AadlBaPackage.VALUE:
            return validateValue((Value)value, diagnostics, context);
         case AadlBaPackage.VALUE_VARIABLE:
            return validateValueVariable((ValueVariable)value, diagnostics, context);
         case AadlBaPackage.VALUE_CONSTANT:
            return validateValueConstant((ValueConstant)value, diagnostics, context);
         case AadlBaPackage.VALUE_EXPRESSION:
            return validateValueExpression((ValueExpression)value, diagnostics, context);
         case AadlBaPackage.RELATION:
            return validateRelation((Relation)value, diagnostics, context);
         case AadlBaPackage.SIMPLE_EXPRESSION:
            return validateSimpleExpression((SimpleExpression)value, diagnostics, context);
         case AadlBaPackage.TERM:
            return validateTerm((Term)value, diagnostics, context);
         case AadlBaPackage.FACTOR:
            return validateFactor((Factor)value, diagnostics, context);
         case AadlBaPackage.INTEGER_RANGE:
            return validateIntegerRange((IntegerRange)value, diagnostics, context);
         case AadlBaPackage.INTEGER_VALUE:
            return validateIntegerValue((IntegerValue)value, diagnostics, context);
         case AadlBaPackage.BEHAVIOR_TIME:
            return validateBehaviorTime((BehaviorTime)value, diagnostics, context);
         case AadlBaPackage.PROPERTY_CONSTANT:
            return validatePropertyConstant((PropertyConstant)value, diagnostics, context);
         case AadlBaPackage.PROPERTY_VALUE:
            return validatePropertyValue((PropertyValue)value, diagnostics, context);
         case AadlBaPackage.IDENTIFIER:
            return validateIdentifier((Identifier)value, diagnostics, context);
         case AadlBaPackage.NUMERIC_LITERAL:
            return validateNumericLiteral((NumericLiteral)value, diagnostics, context);
         case AadlBaPackage.BOOLEAN_LITERAL:
            return validateBooleanLiteral((BooleanLiteral)value, diagnostics, context);
         case AadlBaPackage.STRING_LITERAL:
            return validateStringLiteral((StringLiteral)value, diagnostics, context);
         case AadlBaPackage.NUMERAL:
            return validateNumeral((Numeral)value, diagnostics, context);
         case AadlBaPackage.EXECUTE_CONDITION:
            return validateExecuteCondition((ExecuteCondition)value, diagnostics, context);
         case AadlBaPackage.COMM_ACTION_PARAMETER:
            return validateCommActionParameter((CommActionParameter)value, diagnostics, context);
         case AadlBaPackage.LOGICAL_OPERATOR:
            return validateLogicalOperator((LogicalOperator)value, diagnostics, context);
         case AadlBaPackage.RELATIONAL_OPERATOR:
            return validateRelationalOperator((RelationalOperator)value, diagnostics, context);
         case AadlBaPackage.BINARY_ADDING_OPERATOR:
            return validateBinaryAddingOperator((BinaryAddingOperator)value, diagnostics, context);
         case AadlBaPackage.UNARY_ADDING_OPERATOR:
            return validateUnaryAddingOperator((UnaryAddingOperator)value, diagnostics, context);
         case AadlBaPackage.MULTIPLYING_OPERATOR:
            return validateMultiplyingOperator((MultiplyingOperator)value, diagnostics, context);
         case AadlBaPackage.BINARY_NUMERIC_OPERATOR:
            return validateBinaryNumericOperator((BinaryNumericOperator)value, diagnostics, context);
         case AadlBaPackage.UNARY_NUMERIC_OPERATOR:
            return validateUnaryNumericOperator((UnaryNumericOperator)value, diagnostics, context);
         case AadlBaPackage.UNARY_BOOLEAN_OPERATOR:
            return validateUnaryBooleanOperator((UnaryBooleanOperator)value, diagnostics, context);
         case AadlBaPackage.INTEGER:
            return validateInteger((Integer)value, diagnostics, context);
         case AadlBaPackage.REAL:
            return validateReal((Double)value, diagnostics, context);
         case AadlBaPackage.STRING:
            return validateString((String)value, diagnostics, context);
         case AadlBaPackage.BOOLEAN:
            return validateBoolean((Boolean)value, diagnostics, context);
         default:
            return true;
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)element, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(element, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(element, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateComment(Comment comment, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)comment, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(comment, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(comment, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(namedElement, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(namedElement, diagnostics, context);
      return result;
   }

   /**
    * Validates the has_no_qualified_name constraint of '<em>Named Element</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNamedElement_has_no_qualified_name(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return namedElement.has_no_qualified_name(diagnostics, context);
   }

   /**
    * Validates the has_qualified_name constraint of '<em>Named Element</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNamedElement_has_qualified_name(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return namedElement.has_qualified_name(diagnostics, context);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNamespace(Namespace namespace, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)namespace, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(namespace, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(namespace, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamespace_members_distinguishable(namespace, diagnostics, context);
      return result;
   }

   /**
    * Validates the members_distinguishable constraint of '<em>Namespace</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNamespace_members_distinguishable(Namespace namespace, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return namespace.members_distinguishable(diagnostics, context);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateGlobalNamespace(GlobalNamespace globalNamespace, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(globalNamespace, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamespace_members_distinguishable(globalNamespace, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorAnnex(BehaviorAnnex behaviorAnnex, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateNamedElement_has_no_qualified_name(behaviorAnnex, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateNamedElement_has_qualified_name(behaviorAnnex, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateUniqueComponentClassifierReference(UniqueComponentClassifierReference uniqueComponentClassifierReference, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(uniqueComponentClassifierReference, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(uniqueComponentClassifierReference, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorVariable(BehaviorVariable behaviorVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorVariable, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorVariable, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorState(BehaviorState behaviorState, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorState, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorState, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorTransition(BehaviorTransition behaviorTransition, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorTransition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorTransition, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorCondition(BehaviorCondition behaviorCondition, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorCondition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorCondition, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateDeclarator(Declarator declarator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)declarator, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(declarator, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(declarator, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(declarator, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateArraySize(ArraySize arraySize, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(arraySize, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(arraySize, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateDispatchCondition(DispatchCondition dispatchCondition, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(dispatchCondition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(dispatchCondition, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateDispatchLogicalExpression(DispatchLogicalExpression dispatchLogicalExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(dispatchLogicalExpression, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(dispatchLogicalExpression, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateDispatchTrigger(DispatchTrigger dispatchTrigger, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(dispatchTrigger, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(dispatchTrigger, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorActions(BehaviorActions behaviorActions, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorActions, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorActions, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorAction(BehaviorAction behaviorAction, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorAction, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateCondStatement(CondStatement condStatement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(condStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(condStatement, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBasicAction(BasicAction basicAction, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(basicAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(basicAction, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateIfStatement(IfStatement ifStatement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(ifStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(ifStatement, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateForOrForAllStatement(ForOrForAllStatement forOrForAllStatement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(forOrForAllStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(forOrForAllStatement, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateWhileStatement(WhileStatement whileStatement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(whileStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(whileStatement, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateDoUntilStatement(DoUntilStatement doUntilStatement, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(doUntilStatement, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(doUntilStatement, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateElementValues(ElementValues elementValues, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(elementValues, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(elementValues, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateAssignmentAction(AssignmentAction assignmentAction, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(assignmentAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(assignmentAction, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateCommunicationAction(CommunicationAction communicationAction, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(communicationAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(communicationAction, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateSubprogramParameterList(SubprogramParameterList subprogramParameterList, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(subprogramParameterList, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(subprogramParameterList, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateTimedAction(TimedAction timedAction, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(timedAction, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(timedAction, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateTarget(Target target, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)target, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(target, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(target, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateParameterLabel(ParameterLabel parameterLabel, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(parameterLabel, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(parameterLabel, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateDataComponentReference(DataComponentReference dataComponentReference, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(dataComponentReference, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(dataComponentReference, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateName(Name name, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)name, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(name, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(name, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(name, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(name, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateArrayIndex(ArrayIndex arrayIndex, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(arrayIndex, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(arrayIndex, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateValue(Value value, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)value, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(value, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(value, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateValueVariable(ValueVariable valueVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(valueVariable, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(valueVariable, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateValueConstant(ValueConstant valueConstant, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(valueConstant, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(valueConstant, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateValueExpression(ValueExpression valueExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(valueExpression, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(valueExpression, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)relation, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(relation, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(relation, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateSimpleExpression(SimpleExpression simpleExpression, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(simpleExpression, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(simpleExpression, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateTerm(Term term, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)term, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(term, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(term, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateFactor(Factor factor, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)factor, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(factor, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(factor, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateIntegerRange(IntegerRange integerRange, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(integerRange, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(integerRange, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateIntegerValue(IntegerValue integerValue, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(integerValue, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(integerValue, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBehaviorTime(BehaviorTime behaviorTime, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(behaviorTime, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(behaviorTime, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validatePropertyConstant(PropertyConstant propertyConstant, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(propertyConstant, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(propertyConstant, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validatePropertyValue(PropertyValue propertyValue, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_no_qualified_name(propertyValue, diagnostics, context);
      if (result || diagnostics != null) result &= validateNamedElement_has_qualified_name(propertyValue, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateIdentifier(Identifier identifier, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)identifier, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(identifier, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(identifier, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNumericLiteral(NumericLiteral numericLiteral, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(numericLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(numericLiteral, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBooleanLiteral(BooleanLiteral booleanLiteral, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(booleanLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(booleanLiteral, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateStringLiteral(StringLiteral stringLiteral, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(stringLiteral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(stringLiteral, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateNumeral(Numeral numeral, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)numeral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(numeral, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(numeral, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateExecuteCondition(ExecuteCondition executeCondition, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      boolean result = validate_EveryMultiplicityConforms((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_UniqueID((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_not_own_self(executeCondition, diagnostics, context);
      if (result || diagnostics != null) result &= aadl2Validator.validateElement_has_owner(executeCondition, diagnostics, context);
      return result;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateCommActionParameter(CommActionParameter commActionParameter, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateLogicalOperator(LogicalOperator logicalOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateRelationalOperator(RelationalOperator relationalOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBinaryAddingOperator(BinaryAddingOperator binaryAddingOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateUnaryAddingOperator(UnaryAddingOperator unaryAddingOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateMultiplyingOperator(MultiplyingOperator multiplyingOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBinaryNumericOperator(BinaryNumericOperator binaryNumericOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateUnaryNumericOperator(UnaryNumericOperator unaryNumericOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateUnaryBooleanOperator(UnaryBooleanOperator unaryBooleanOperator, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateInteger(int integer, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateReal(double real, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateString(String string, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean validateBoolean(boolean boolean_, DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      return true;
   }

   /**
    * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public ResourceLocator getResourceLocator()
   {
      // TODO
      // Specialize this to return a resource locator for messages specific to this validator.
      // Ensure that you remove @generated or mark it @generated NOT
      return super.getResourceLocator();
   }

} //AadlBaValidator
