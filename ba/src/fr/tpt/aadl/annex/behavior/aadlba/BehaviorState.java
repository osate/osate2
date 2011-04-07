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
 * A representation of the model object '<em><b>Behavior State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isInitial <em>Initial</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isComplete <em>Complete</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isFinal <em>Final</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorState()
 * @model
 * @generated
 */
public interface BehaviorState extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see #isSetIdentifiers()
	 * @see #unsetIdentifiers()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorState_Identifiers()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Identifier> getIdentifiers();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getIdentifiers <em>Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentifiers()
	 * @see #getIdentifiers()
	 * @generated
	 */
	void unsetIdentifiers();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getIdentifiers <em>Identifiers</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Identifiers</em>' containment reference list is set.
	 * @see #unsetIdentifiers()
	 * @see #getIdentifiers()
	 * @generated
	 */
	boolean isSetIdentifiers();

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorState_Initial()
	 * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean" required="true"
	 * @generated
	 */
	boolean isInitial();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #isInitial()
	 * @generated
	 */
	void setInitial(boolean value);

	/**
	 * Returns the value of the '<em><b>Complete</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete</em>' attribute.
	 * @see #setComplete(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorState_Complete()
	 * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean" required="true"
	 * @generated
	 */
	boolean isComplete();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isComplete <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complete</em>' attribute.
	 * @see #isComplete()
	 * @generated
	 */
	void setComplete(boolean value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorState_Final()
	 * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean" required="true"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

} // BehaviorState
