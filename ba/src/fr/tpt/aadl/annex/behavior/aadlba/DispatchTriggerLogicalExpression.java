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
 * A representation of the model object '<em><b>Dispatch Trigger Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions <em>Dispatch Conjunctions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTriggerLogicalExpression()
 * @model
 * @generated
 */
public interface DispatchTriggerLogicalExpression extends DispatchTriggerCondition {
	/**
	 * Returns the value of the '<em><b>Dispatch Conjunctions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatch Conjunctions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatch Conjunctions</em>' containment reference list.
	 * @see #isSetDispatchConjunctions()
	 * @see #unsetDispatchConjunctions()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDispatchTriggerLogicalExpression_DispatchConjunctions()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<DispatchConjunction> getDispatchConjunctions();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions <em>Dispatch Conjunctions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDispatchConjunctions()
	 * @see #getDispatchConjunctions()
	 * @generated
	 */
	void unsetDispatchConjunctions();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions <em>Dispatch Conjunctions</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dispatch Conjunctions</em>' containment reference list is set.
	 * @see #unsetDispatchConjunctions()
	 * @see #getDispatchConjunctions()
	 * @generated
	 */
	boolean isSetDispatchConjunctions();

} // DispatchTriggerLogicalExpression
