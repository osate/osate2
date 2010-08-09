/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getWhileStatement()
 * @model
 * @generated
 */
public interface WhileStatement extends CondStatement
{
   /**
	 * Returns the value of the '<em><b>Value Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Expression Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression Owned</em>' containment reference.
	 * @see #setValueExpressionOwned(ValueExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getWhileStatement_ValueExpressionOwned()
	 * @model containment="true"
	 * @generated
	 */
   ValueExpression getValueExpressionOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getValueExpressionOwned <em>Value Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression Owned</em>' containment reference.
	 * @see #getValueExpressionOwned()
	 * @generated
	 */
   void setValueExpressionOwned(ValueExpression value);

   /**
	 * Returns the value of the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Actions Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #isSetBehaviorActionsOwned()
	 * @see #unsetBehaviorActionsOwned()
	 * @see #setBehaviorActionsOwned(BehaviorActions)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getWhileStatement_BehaviorActionsOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   BehaviorActions getBehaviorActionsOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #isSetBehaviorActionsOwned()
	 * @see #unsetBehaviorActionsOwned()
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 */
   void setBehaviorActionsOwned(BehaviorActions value);

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetBehaviorActionsOwned()
	 * @see #getBehaviorActionsOwned()
	 * @see #setBehaviorActionsOwned(BehaviorActions)
	 * @generated
	 */
   void unsetBehaviorActionsOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior Actions Owned</em>' containment reference is set.
	 * @see #unsetBehaviorActionsOwned()
	 * @see #getBehaviorActionsOwned()
	 * @see #setBehaviorActionsOwned(BehaviorActions)
	 * @generated
	 */
   boolean isSetBehaviorActionsOwned();

} // WhileStatement
