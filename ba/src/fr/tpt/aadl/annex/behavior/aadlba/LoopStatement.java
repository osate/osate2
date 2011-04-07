/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.LoopStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getLoopStatement()
 * @model abstract="true"
 * @generated
 */
public interface LoopStatement extends CondStatement {
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
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getLoopStatement_BehaviorActionsOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BehaviorActions getBehaviorActionsOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.LoopStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 */
	void setBehaviorActionsOwned(BehaviorActions value);

} // LoopStatement
