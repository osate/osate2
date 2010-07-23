/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isHasElse <em>Has Else</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Element, CondStatement
{
   /**
    * Returns the value of the '<em><b>Has Else</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Else</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Has Else</em>' attribute.
    * @see #setHasElse(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement_HasElse()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isHasElse();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isHasElse <em>Has Else</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Has Else</em>' attribute.
    * @see #isHasElse()
    * @generated
    */
   void setHasElse(boolean value);

   /**
    * Returns the value of the '<em><b>Value Expression Owned</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Expression Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Value Expression Owned</em>' containment reference list.
    * @see #isSetValueExpressionOwned()
    * @see #unsetValueExpressionOwned()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement_ValueExpressionOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<ValueExpression> getValueExpressionOwned();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getValueExpressionOwned <em>Value Expression Owned</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetValueExpressionOwned()
    * @see #getValueExpressionOwned()
    * @generated
    */
   void unsetValueExpressionOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getValueExpressionOwned <em>Value Expression Owned</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Value Expression Owned</em>' containment reference list is set.
    * @see #unsetValueExpressionOwned()
    * @see #getValueExpressionOwned()
    * @generated
    */
   boolean isSetValueExpressionOwned();

   /**
    * Returns the value of the '<em><b>Behavior Actions Owned</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Actions Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Behavior Actions Owned</em>' containment reference list.
    * @see #isSetBehaviorActionsOwned()
    * @see #unsetBehaviorActionsOwned()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement_BehaviorActionsOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<BehaviorActions> getBehaviorActionsOwned();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetBehaviorActionsOwned()
    * @see #getBehaviorActionsOwned()
    * @generated
    */
   void unsetBehaviorActionsOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Behavior Actions Owned</em>' containment reference list is set.
    * @see #unsetBehaviorActionsOwned()
    * @see #getBehaviorActionsOwned()
    * @generated
    */
   boolean isSetBehaviorActionsOwned();

} // IfStatement
