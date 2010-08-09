/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage
 * @generated
 */
public interface AadlBaFactory extends EFactory
{
   /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   AadlBaFactory eINSTANCE = fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaFactoryImpl.init();

   /**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
   Comment createComment();

   /**
	 * Returns a new object of class '<em>Global Namespace</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Namespace</em>'.
	 * @generated
	 */
   GlobalNamespace createGlobalNamespace();

   /**
	 * Returns a new object of class '<em>Behavior Annex</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Annex</em>'.
	 * @generated
	 */
   BehaviorAnnex createBehaviorAnnex();

   /**
	 * Returns a new object of class '<em>Unique Component Classifier Reference</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unique Component Classifier Reference</em>'.
	 * @generated
	 */
   UniqueComponentClassifierReference createUniqueComponentClassifierReference();

   /**
	 * Returns a new object of class '<em>Behavior Variable</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Variable</em>'.
	 * @generated
	 */
   BehaviorVariable createBehaviorVariable();

   /**
	 * Returns a new object of class '<em>Behavior State</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior State</em>'.
	 * @generated
	 */
   BehaviorState createBehaviorState();

   /**
	 * Returns a new object of class '<em>Behavior Transition</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Transition</em>'.
	 * @generated
	 */
   BehaviorTransition createBehaviorTransition();

   /**
	 * Returns a new object of class '<em>Declarator</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declarator</em>'.
	 * @generated
	 */
   Declarator createDeclarator();

   /**
	 * Returns a new object of class '<em>Array Size</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Size</em>'.
	 * @generated
	 */
   ArraySize createArraySize();

   /**
	 * Returns a new object of class '<em>Dispatch Condition</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Condition</em>'.
	 * @generated
	 */
   DispatchCondition createDispatchCondition();

   /**
	 * Returns a new object of class '<em>Dispatch Logical Expression</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Logical Expression</em>'.
	 * @generated
	 */
   DispatchLogicalExpression createDispatchLogicalExpression();

   /**
	 * Returns a new object of class '<em>Dispatch Trigger</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Trigger</em>'.
	 * @generated
	 */
   DispatchTrigger createDispatchTrigger();

   /**
	 * Returns a new object of class '<em>Behavior Actions</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Actions</em>'.
	 * @generated
	 */
   BehaviorActions createBehaviorActions();

   /**
	 * Returns a new object of class '<em>Behavior Action</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Action</em>'.
	 * @generated
	 */
   BehaviorAction createBehaviorAction();

   /**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
   IfStatement createIfStatement();

   /**
	 * Returns a new object of class '<em>For Or For All Statement</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Or For All Statement</em>'.
	 * @generated
	 */
   ForOrForAllStatement createForOrForAllStatement();

   /**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
   WhileStatement createWhileStatement();

   /**
	 * Returns a new object of class '<em>Do Until Statement</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do Until Statement</em>'.
	 * @generated
	 */
   DoUntilStatement createDoUntilStatement();

   /**
	 * Returns a new object of class '<em>Assignment Action</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment Action</em>'.
	 * @generated
	 */
   AssignmentAction createAssignmentAction();

   /**
	 * Returns a new object of class '<em>Communication Action</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Action</em>'.
	 * @generated
	 */
   CommunicationAction createCommunicationAction();

   /**
	 * Returns a new object of class '<em>Subprogram Parameter List</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Parameter List</em>'.
	 * @generated
	 */
   SubprogramParameterList createSubprogramParameterList();

   /**
	 * Returns a new object of class '<em>Timed Action</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Action</em>'.
	 * @generated
	 */
   TimedAction createTimedAction();

   /**
	 * Returns a new object of class '<em>Target</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target</em>'.
	 * @generated
	 */
   Target createTarget();

   /**
	 * Returns a new object of class '<em>Data Component Reference</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Component Reference</em>'.
	 * @generated
	 */
   DataComponentReference createDataComponentReference();

   /**
	 * Returns a new object of class '<em>Name</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name</em>'.
	 * @generated
	 */
   Name createName();

   /**
	 * Returns a new object of class '<em>Array Index</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Index</em>'.
	 * @generated
	 */
   ArrayIndex createArrayIndex();

   /**
	 * Returns a new object of class '<em>Value Variable</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Variable</em>'.
	 * @generated
	 */
   ValueVariable createValueVariable();

   /**
	 * Returns a new object of class '<em>Value Expression</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Expression</em>'.
	 * @generated
	 */
   ValueExpression createValueExpression();

   /**
	 * Returns a new object of class '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation</em>'.
	 * @generated
	 */
   Relation createRelation();

   /**
	 * Returns a new object of class '<em>Simple Expression</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Expression</em>'.
	 * @generated
	 */
   SimpleExpression createSimpleExpression();

   /**
	 * Returns a new object of class '<em>Term</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term</em>'.
	 * @generated
	 */
   Term createTerm();

   /**
	 * Returns a new object of class '<em>Factor</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Factor</em>'.
	 * @generated
	 */
   Factor createFactor();

   /**
	 * Returns a new object of class '<em>Integer Range</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Range</em>'.
	 * @generated
	 */
   IntegerRange createIntegerRange();

   /**
	 * Returns a new object of class '<em>Behavior Time</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Time</em>'.
	 * @generated
	 */
   BehaviorTime createBehaviorTime();

   /**
	 * Returns a new object of class '<em>Property Constant</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Constant</em>'.
	 * @generated
	 */
   PropertyConstant createPropertyConstant();

   /**
	 * Returns a new object of class '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Value</em>'.
	 * @generated
	 */
   PropertyValue createPropertyValue();

   /**
	 * Returns a new object of class '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier</em>'.
	 * @generated
	 */
   Identifier createIdentifier();

   /**
	 * Returns a new object of class '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Literal</em>'.
	 * @generated
	 */
   NumericLiteral createNumericLiteral();

   /**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
   BooleanLiteral createBooleanLiteral();

   /**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
   StringLiteral createStringLiteral();

   /**
	 * Returns a new object of class '<em>Numeral</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeral</em>'.
	 * @generated
	 */
   Numeral createNumeral();

   /**
	 * Returns a new object of class '<em>Execute Condition</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute Condition</em>'.
	 * @generated
	 */
   ExecuteCondition createExecuteCondition();

   /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
   AadlBaPackage getAadlBaPackage();

} //AadlBaFactory
