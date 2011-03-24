/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerBehaviorTime <em>Lower Behavior Time</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperBehaviorTime <em>Upper Behavior Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction()
 * @model
 * @generated
 */
public interface TimedAction extends BasicAction {
	/**
	 * Returns the value of the '<em><b>Lower Behavior Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Behavior Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Behavior Time</em>' containment reference.
	 * @see #isSetLowerBehaviorTime()
	 * @see #unsetLowerBehaviorTime()
	 * @see #setLowerBehaviorTime(BehaviorTime)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction_LowerBehaviorTime()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	BehaviorTime getLowerBehaviorTime();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerBehaviorTime <em>Lower Behavior Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Behavior Time</em>' containment reference.
	 * @see #isSetLowerBehaviorTime()
	 * @see #unsetLowerBehaviorTime()
	 * @see #getLowerBehaviorTime()
	 * @generated
	 */
	void setLowerBehaviorTime(BehaviorTime value);

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerBehaviorTime <em>Lower Behavior Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLowerBehaviorTime()
	 * @see #getLowerBehaviorTime()
	 * @see #setLowerBehaviorTime(BehaviorTime)
	 * @generated
	 */
	void unsetLowerBehaviorTime();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerBehaviorTime <em>Lower Behavior Time</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lower Behavior Time</em>' containment reference is set.
	 * @see #unsetLowerBehaviorTime()
	 * @see #getLowerBehaviorTime()
	 * @see #setLowerBehaviorTime(BehaviorTime)
	 * @generated
	 */
	boolean isSetLowerBehaviorTime();

	/**
	 * Returns the value of the '<em><b>Upper Behavior Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Behavior Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Behavior Time</em>' containment reference.
	 * @see #setUpperBehaviorTime(BehaviorTime)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTimedAction_UpperBehaviorTime()
	 * @model containment="true"
	 * @generated
	 */
	BehaviorTime getUpperBehaviorTime();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperBehaviorTime <em>Upper Behavior Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Behavior Time</em>' containment reference.
	 * @see #getUpperBehaviorTime()
	 * @generated
	 */
	void setUpperBehaviorTime(BehaviorTime value);

} // TimedAction
