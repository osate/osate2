/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Data Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccessName <em>Data Access Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSharedDataAction()
 * @model abstract="true"
 * @generated
 */
public interface SharedDataAction extends CommunicationAction {
	/**
	 * Returns the value of the '<em><b>Data Access Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Access Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Access Name</em>' containment reference.
	 * @see #setDataAccessName(Name)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSharedDataAction_DataAccessName()
	 * @model containment="true"
	 * @generated
	 */
	Name getDataAccessName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccessName <em>Data Access Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Access Name</em>' containment reference.
	 * @see #getDataAccessName()
	 * @generated
	 */
	void setDataAccessName(Name value);

} // SharedDataAction
