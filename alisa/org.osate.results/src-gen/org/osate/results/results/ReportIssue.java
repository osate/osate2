/**
 */
package org.osate.results.results;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Report Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.results.results.ReportIssue#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.results.results.ReportIssue#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.results.results.ReportIssue#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.results.results.ResultsPackage#getReportIssue()
 * @model
 * @generated
 */
public interface ReportIssue extends EObject
{
  /**
   * Returns the value of the '<em><b>Issue Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.results.results.IssueType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issue Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issue Type</em>' attribute.
   * @see org.osate.results.results.IssueType
   * @see #setIssueType(IssueType)
   * @see org.osate.results.results.ResultsPackage#getReportIssue_IssueType()
   * @model
   * @generated
   */
  IssueType getIssueType();

  /**
   * Sets the value of the '{@link org.osate.results.results.ReportIssue#getIssueType <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Issue Type</em>' attribute.
   * @see org.osate.results.results.IssueType
   * @see #getIssueType()
   * @generated
   */
  void setIssueType(IssueType value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.results.results.ResultsPackage#getReportIssue_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.results.results.ReportIssue#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

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
   * @see org.osate.results.results.ResultsPackage#getReportIssue_Target()
   * @model
   * @generated
   */
  EObject getTarget();

  /**
   * Sets the value of the '{@link org.osate.results.results.ReportIssue#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(EObject value);

} // ReportIssue
