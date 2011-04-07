/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Send Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getPortName <em>Port Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortSendAction()
 * @model
 * @generated
 */
public interface PortSendAction extends CommunicationAction {
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
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortSendAction_PortName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Name getPortName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getPortName <em>Port Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Name</em>' containment reference.
	 * @see #getPortName()
	 * @generated
	 */
	void setPortName(Name value);

	/**
	 * Returns the value of the '<em><b>Value Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Expression Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression Owned</em>' containment reference.
	 * @see #setValueExpressionOwned(ValueExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortSendAction_ValueExpressionOwned()
	 * @model containment="true"
	 * @generated
	 */
	ValueExpression getValueExpressionOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getValueExpressionOwned <em>Value Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression Owned</em>' containment reference.
	 * @see #getValueExpressionOwned()
	 * @generated
	 */
	void setValueExpressionOwned(ValueExpression value);

} // PortSendAction
