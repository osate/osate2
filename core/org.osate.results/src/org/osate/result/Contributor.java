/**
 */
package org.osate.result;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.Contributor#getInfo <em>Info</em>}</li>
 *   <li>{@link org.osate.result.Contributor#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.Contributor#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.result.Contributor#getDiagnostics <em>Diagnostics</em>}</li>
 *   <li>{@link org.osate.result.Contributor#getSubContributors <em>Sub Contributors</em>}</li>
 * </ul>
 *
 * @see org.osate.result.ResultPackage#getContributor()
 * @model
 * @generated
 */
public interface Contributor extends EObject {
	/**
	 * Returns the value of the '<em><b>Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Info</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' attribute.
	 * @see #setInfo(String)
	 * @see org.osate.result.ResultPackage#getContributor_Info()
	 * @model
	 * @generated
	 */
	String getInfo();

	/**
	 * Sets the value of the '{@link org.osate.result.Contributor#getInfo <em>Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Info</em>' attribute.
	 * @see #getInfo()
	 * @generated
	 */
	void setInfo(String value);

	/**
	 * Returns the value of the '<em><b>Source Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Reference</em>' reference.
	 * @see #setSourceReference(EObject)
	 * @see org.osate.result.ResultPackage#getContributor_SourceReference()
	 * @model
	 * @generated
	 */
	EObject getSourceReference();

	/**
	 * Sets the value of the '{@link org.osate.result.Contributor#getSourceReference <em>Source Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Reference</em>' reference.
	 * @see #getSourceReference()
	 * @generated
	 */
	void setSourceReference(EObject value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getContributor_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getValues();

	/**
	 * Returns the value of the '<em><b>Diagnostics</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Diagnostic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostics</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getContributor_Diagnostics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Diagnostic> getDiagnostics();

	/**
	 * Returns the value of the '<em><b>Sub Contributors</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Contributor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Contributors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Contributors</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getContributor_SubContributors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contributor> getSubContributors();

} // Contributor
