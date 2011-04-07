/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Identifier#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIdentifier()
 * @model
 * @generated
 */
public interface Identifier extends BehaviorElement, DispatchTriggerCondition {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIdentifier_Id()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Identifier#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Identifier
