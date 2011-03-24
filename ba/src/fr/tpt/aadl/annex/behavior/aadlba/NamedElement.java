/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A named element is an element in a model that may have a name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespaceSeparator <em>Namespace Separator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends Element {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the NamedElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_Name()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" required="true" ordered="false"
	 *        annotation="http://www.topcased.org/documentation documentation='The name of the NamedElement.'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_QualifiedName()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" required="true" ordered="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Namespace Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Separator</em>' attribute.
	 * @see #setNamespaceSeparator(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_NamespaceSeparator()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String"
	 * @generated
	 */
	String getNamespaceSeparator();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespaceSeparator <em>Namespace Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Separator</em>' attribute.
	 * @see #getNamespaceSeparator()
	 * @generated
	 */
	void setNamespaceSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNamedElement_Namespace()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NamedElement#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

} // NamedElement
