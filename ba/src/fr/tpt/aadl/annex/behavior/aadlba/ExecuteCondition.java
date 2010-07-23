/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#isCatchTimeout <em>Catch Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getExecuteCondition()
 * @model
 * @generated
 */
public interface ExecuteCondition extends BehaviorCondition
{
   /**
    * Returns the value of the '<em><b>Value Expression</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Expression</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Value Expression</em>' containment reference.
    * @see #setValueExpression(ValueExpression)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getExecuteCondition_ValueExpression()
    * @model containment="true"
    * @generated
    */
   ValueExpression getValueExpression();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#getValueExpression <em>Value Expression</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Value Expression</em>' containment reference.
    * @see #getValueExpression()
    * @generated
    */
   void setValueExpression(ValueExpression value);

   /**
    * Returns the value of the '<em><b>Catch Timeout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Catch Timeout</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Catch Timeout</em>' attribute.
    * @see #setCatchTimeout(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getExecuteCondition_CatchTimeout()
    * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isCatchTimeout();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition#isCatchTimeout <em>Catch Timeout</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Catch Timeout</em>' attribute.
    * @see #isCatchTimeout()
    * @generated
    */
   void setCatchTimeout(boolean value);

} // ExecuteCondition
