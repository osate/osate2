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
 * A representation of the model object '<em><b>Dispatch Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#isHasFrozenPorts <em>Has Frozen Ports</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchCondition()
 * @model
 * @generated
 */
public interface DispatchCondition extends BehaviorCondition
{
   /**
    * Returns the value of the '<em><b>Has Frozen Ports</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Frozen Ports</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Has Frozen Ports</em>' attribute.
    * @see #setHasFrozenPorts(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchCondition_HasFrozenPorts()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isHasFrozenPorts();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#isHasFrozenPorts <em>Has Frozen Ports</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Has Frozen Ports</em>' attribute.
    * @see #isHasFrozenPorts()
    * @generated
    */
   void setHasFrozenPorts(boolean value);

   /**
    * Returns the value of the '<em><b>The Dispatch Logical Expression</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>The Dispatch Logical Expression</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>The Dispatch Logical Expression</em>' containment reference.
    * @see #isSetTheDispatchLogicalExpression()
    * @see #unsetTheDispatchLogicalExpression()
    * @see #setTheDispatchLogicalExpression(DispatchLogicalExpression)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchCondition_TheDispatchLogicalExpression()
    * @model containment="true" unsettable="true"
    * @generated
    */
   DispatchLogicalExpression getTheDispatchLogicalExpression();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>The Dispatch Logical Expression</em>' containment reference.
    * @see #isSetTheDispatchLogicalExpression()
    * @see #unsetTheDispatchLogicalExpression()
    * @see #getTheDispatchLogicalExpression()
    * @generated
    */
   void setTheDispatchLogicalExpression(DispatchLogicalExpression value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetTheDispatchLogicalExpression()
    * @see #getTheDispatchLogicalExpression()
    * @see #setTheDispatchLogicalExpression(DispatchLogicalExpression)
    * @generated
    */
   void unsetTheDispatchLogicalExpression();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>The Dispatch Logical Expression</em>' containment reference is set.
    * @see #unsetTheDispatchLogicalExpression()
    * @see #getTheDispatchLogicalExpression()
    * @see #setTheDispatchLogicalExpression(DispatchLogicalExpression)
    * @generated
    */
   boolean isSetTheDispatchLogicalExpression();

   /**
    * Returns the value of the '<em><b>Frozen Ports</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Identifier}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Frozen Ports</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Frozen Ports</em>' containment reference list.
    * @see #isSetFrozenPorts()
    * @see #unsetFrozenPorts()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchCondition_FrozenPorts()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<Identifier> getFrozenPorts();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetFrozenPorts()
    * @see #getFrozenPorts()
    * @generated
    */
   void unsetFrozenPorts();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Frozen Ports</em>' containment reference list is set.
    * @see #unsetFrozenPorts()
    * @see #getFrozenPorts()
    * @generated
    */
   boolean isSetFrozenPorts();

} // DispatchCondition
