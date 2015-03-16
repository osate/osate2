/**
 */
package org.osate.results.results;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.results.results.ResultContributor#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.osate.results.results.ResultContributor#getCell <em>Cell</em>}</li>
 *   <li>{@link org.osate.results.results.ResultContributor#getSubcontributor <em>Subcontributor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.results.results.ResultsPackage#getResultContributor()
 * @model
 * @generated
 */
public interface ResultContributor extends ResultIssueHolder
{
  /**
   * Returns the value of the '<em><b>Contributor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contributor</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contributor</em>' reference.
   * @see #setContributor(EObject)
   * @see org.osate.results.results.ResultsPackage#getResultContributor_Contributor()
   * @model
   * @generated
   */
  EObject getContributor();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultContributor#getContributor <em>Contributor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contributor</em>' reference.
   * @see #getContributor()
   * @generated
   */
  void setContributor(EObject value);

  /**
   * Returns the value of the '<em><b>Cell</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cell</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cell</em>' attribute list.
   * @see org.osate.results.results.ResultsPackage#getResultContributor_Cell()
   * @model unique="false"
   * @generated
   */
  EList<String> getCell();

  /**
   * Returns the value of the '<em><b>Subcontributor</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.ResultContributor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subcontributor</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcontributor</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultContributor_Subcontributor()
   * @model containment="true"
   * @generated
   */
  EList<ResultContributor> getSubcontributor();

} // ResultContributor
