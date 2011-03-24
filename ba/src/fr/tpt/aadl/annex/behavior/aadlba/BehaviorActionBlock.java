/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Action Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorTimeOwned <em>Behavior Time Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActionBlock()
 * @model
 * @generated
 */
public interface BehaviorActionBlock extends Element, BehaviorAction {
	/**
	 * Returns the value of the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Actions Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #setBehaviorActionsOwned(BehaviorActions)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActionBlock_BehaviorActionsOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BehaviorActions getBehaviorActionsOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 */
	void setBehaviorActionsOwned(BehaviorActions value);

	/**
	 * Returns the value of the '<em><b>Behavior Time Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Time Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Time Owned</em>' containment reference.
	 * @see #setBehaviorTimeOwned(BehaviorTime)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActionBlock_BehaviorTimeOwned()
	 * @model containment="true"
	 * @generated
	 */
	BehaviorTime getBehaviorTimeOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getBehaviorTimeOwned <em>Behavior Time Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Time Owned</em>' containment reference.
	 * @see #getBehaviorTimeOwned()
	 * @generated
	 */
	void setBehaviorTimeOwned(BehaviorTime value);

} // BehaviorActionBlock
