/**
 */
package org.osate.results;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.ResultContributor#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.ResultContributor#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.results.ResultContributor#getSubcontributor <em>Subcontributor</em>}</li>
 * </ul>
 *
 * @see org.osate.results.ResultsPackage#getResultContributor()
 * @model
 * @generated
 */
public interface ResultContributor extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see org.osate.results.ResultsPackage#getResultContributor_Target()
	 * @model
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.osate.results.ResultContributor#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.results.ResultIssue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issues</em>' containment reference list.
	 * @see org.osate.results.ResultsPackage#getResultContributor_Issues()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResultIssue> getIssues();

	/**
	 * Returns the value of the '<em><b>Subcontributor</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.results.ResultContributor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subcontributor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subcontributor</em>' containment reference list.
	 * @see org.osate.results.ResultsPackage#getResultContributor_Subcontributor()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResultContributor> getSubcontributor();

} // ResultContributor
