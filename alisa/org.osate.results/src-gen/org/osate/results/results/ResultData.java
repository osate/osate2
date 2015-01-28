/**
 */
package org.osate.results.results;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.results.results.ResultData#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.results.results.ResultsPackage#getResultData()
 * @model
 * @generated
 */
public interface ResultData extends EObject
{
  /**
   * Returns the value of the '<em><b>Data</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.NameValuePair}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultData_Data()
   * @model containment="true"
   * @generated
   */
  EList<NameValuePair> getData();

} // ResultData
