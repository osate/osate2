/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.Enumeration#getLiteral <em>Literal</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.Enumeration#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends QualifiedNamedElement {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference.
	 * @see #setLiteral(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getEnumeration_Literal()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getLiteral();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.Enumeration#getLiteral <em>Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' containment reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(Identifier value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference.
	 * @see #setProperty(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getEnumeration_Property()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getProperty();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.Enumeration#getProperty <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' containment reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Identifier value);

} // Enumeration
