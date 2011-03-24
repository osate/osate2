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
 * A representation of the model object '<em><b>Dispatch Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchConjunction()
 * @model
 * @generated
 */
public interface DispatchConjunction extends Element {
	/**
	 * Returns the value of the '<em><b>Dispatch Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatch Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatch Triggers</em>' containment reference list.
	 * @see #isSetDispatchTriggers()
	 * @see #unsetDispatchTriggers()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchConjunction_DispatchTriggers()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Identifier> getDispatchTriggers();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDispatchTriggers()
	 * @see #getDispatchTriggers()
	 * @generated
	 */
	void unsetDispatchTriggers();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dispatch Triggers</em>' containment reference list is set.
	 * @see #unsetDispatchTriggers()
	 * @see #getDispatchTriggers()
	 * @generated
	 */
	boolean isSetDispatchTriggers();

} // DispatchConjunction
