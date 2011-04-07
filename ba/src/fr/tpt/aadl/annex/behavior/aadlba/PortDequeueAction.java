/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Dequeue Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPortName <em>Port Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTargetOwned <em>Target Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortDequeueAction()
 * @model
 * @generated
 */
public interface PortDequeueAction extends CommunicationAction {
	/**
	 * Returns the value of the '<em><b>Port Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Name</em>' containment reference.
	 * @see #setPortName(Name)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortDequeueAction_PortName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Name getPortName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPortName <em>Port Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Name</em>' containment reference.
	 * @see #getPortName()
	 * @generated
	 */
	void setPortName(Name value);

	/**
	 * Returns the value of the '<em><b>Target Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Owned</em>' containment reference.
	 * @see #setTargetOwned(Target)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortDequeueAction_TargetOwned()
	 * @model containment="true"
	 * @generated
	 */
	Target getTargetOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTargetOwned <em>Target Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Owned</em>' containment reference.
	 * @see #getTargetOwned()
	 * @generated
	 */
	void setTargetOwned(Target value);

} // PortDequeueAction
