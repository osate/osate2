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
 * A representation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * If the boolean IsComputation is false it means it is delay.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getBehaviorTimesOwned <em>Behavior Times Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#isComputation <em>Computation</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction()
 * @model
 * @generated
 */
public interface TimedAction extends BasicAction
{
   /**
	 * Returns the value of the '<em><b>Behavior Times Owned</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Times Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Times Owned</em>' containment reference list.
	 * @see #isSetBehaviorTimesOwned()
	 * @see #unsetBehaviorTimesOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction_BehaviorTimesOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<BehaviorTime> getBehaviorTimesOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getBehaviorTimesOwned <em>Behavior Times Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetBehaviorTimesOwned()
	 * @see #getBehaviorTimesOwned()
	 * @generated
	 */
   void unsetBehaviorTimesOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getBehaviorTimesOwned <em>Behavior Times Owned</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior Times Owned</em>' containment reference list is set.
	 * @see #unsetBehaviorTimesOwned()
	 * @see #getBehaviorTimesOwned()
	 * @generated
	 */
   boolean isSetBehaviorTimesOwned();

   /**
	 * Returns the value of the '<em><b>Computation</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Computation</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation</em>' attribute.
	 * @see #setComputation(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction_Computation()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isComputation();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#isComputation <em>Computation</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computation</em>' attribute.
	 * @see #isComputation()
	 * @generated
	 */
   void setComputation(boolean value);

} // TimedAction
