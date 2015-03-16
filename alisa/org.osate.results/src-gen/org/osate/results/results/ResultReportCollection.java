/**
 */
package org.osate.results.results;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Report Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.results.results.ResultReportCollection#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.results.results.ResultsPackage#getResultReportCollection()
 * @model
 * @generated
 */
public interface ResultReportCollection extends ResultReports
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.results.results.ResultReport}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see org.osate.results.results.ResultsPackage#getResultReportCollection_Content()
   * @model containment="true"
   * @generated
   */
  EList<ResultReport> getContent();

} // ResultReportCollection
