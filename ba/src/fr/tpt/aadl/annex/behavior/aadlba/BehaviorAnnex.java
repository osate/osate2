/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates <em>States</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex()
 * @model
 * @generated
 */
public interface BehaviorAnnex extends AnnexSubclause, Element
{
   /**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see #isSetVariables()
	 * @see #unsetVariables()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex_Variables()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<BehaviorVariable> getVariables();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetVariables()
	 * @see #getVariables()
	 * @generated
	 */
   void unsetVariables();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Variables</em>' containment reference list is set.
	 * @see #unsetVariables()
	 * @see #getVariables()
	 * @generated
	 */
   boolean isSetVariables();

   /**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>States</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see #isSetStates()
	 * @see #unsetStates()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex_States()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<BehaviorState> getStates();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetStates()
	 * @see #getStates()
	 * @generated
	 */
   void unsetStates();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates <em>States</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>States</em>' containment reference list is set.
	 * @see #unsetStates()
	 * @see #getStates()
	 * @generated
	 */
   boolean isSetStates();

   /**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see #isSetTransitions()
	 * @see #unsetTransitions()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex_Transitions()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<BehaviorTransition> getTransitions();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetTransitions()
	 * @see #getTransitions()
	 * @generated
	 */
   void unsetTransitions();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transitions</em>' containment reference list is set.
	 * @see #unsetTransitions()
	 * @see #getTransitions()
	 * @generated
	 */
   boolean isSetTransitions();

} // BehaviorAnnex
