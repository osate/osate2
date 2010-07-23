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
 * A representation of the model object '<em><b>Behavior Actions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#getBehaviorAction <em>Behavior Action</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSequence <em>Sequence</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSet <em>Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActions()
 * @model
 * @generated
 */
public interface BehaviorActions extends Element
{
   /**
    * Returns the value of the '<em><b>Behavior Action</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Action</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Behavior Action</em>' containment reference list.
    * @see #isSetBehaviorAction()
    * @see #unsetBehaviorAction()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActions_BehaviorAction()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<BehaviorAction> getBehaviorAction();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#getBehaviorAction <em>Behavior Action</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetBehaviorAction()
    * @see #getBehaviorAction()
    * @generated
    */
   void unsetBehaviorAction();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#getBehaviorAction <em>Behavior Action</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Behavior Action</em>' containment reference list is set.
    * @see #unsetBehaviorAction()
    * @see #getBehaviorAction()
    * @generated
    */
   boolean isSetBehaviorAction();

   /**
    * Returns the value of the '<em><b>Sequence</b></em>' attribute.
    * The default value is <code>"false"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Sequence</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Sequence</em>' attribute.
    * @see #setSequence(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActions_Sequence()
    * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isSequence();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSequence <em>Sequence</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Sequence</em>' attribute.
    * @see #isSequence()
    * @generated
    */
   void setSequence(boolean value);

   /**
    * Returns the value of the '<em><b>Set</b></em>' attribute.
    * The default value is <code>"false"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Set</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Set</em>' attribute.
    * @see #setSet(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActions_Set()
    * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isSet();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions#isSet <em>Set</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Set</em>' attribute.
    * @see #isSet()
    * @generated
    */
   void setSet(boolean value);

} // BehaviorActions
