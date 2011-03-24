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
 * A representation of the model object '<em><b>Behavior Action Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getBehaviorActions <em>Behavior Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActionCollection()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface BehaviorActionCollection extends BehaviorActions {
	/**
	 * Returns the value of the '<em><b>Behavior Actions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Actions</em>' containment reference list.
	 * @see #isSetBehaviorActions()
	 * @see #unsetBehaviorActions()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorActionCollection_BehaviorActions()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<BehaviorAction> getBehaviorActions();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getBehaviorActions <em>Behavior Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBehaviorActions()
	 * @see #getBehaviorActions()
	 * @generated
	 */
	void unsetBehaviorActions();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getBehaviorActions <em>Behavior Actions</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior Actions</em>' containment reference list is set.
	 * @see #unsetBehaviorActions()
	 * @see #getBehaviorActions()
	 * @generated
	 */
	boolean isSetBehaviorActions();

} // BehaviorActionCollection
