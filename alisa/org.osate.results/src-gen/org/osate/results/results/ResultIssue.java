/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.results.results;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.results.ResultIssue#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.results.results.ResultIssue#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.results.results.ResultIssue#getExceptionType <em>Exception Type</em>}</li>
 * </ul>
 *
 * @see org.osate.results.results.ResultsPackage#getResultIssue()
 * @model
 * @generated
 */
public interface ResultIssue extends ResultReports
{
  /**
   * Returns the value of the '<em><b>Issue Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.results.results.ResultIssueType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issue Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issue Type</em>' attribute.
   * @see org.osate.results.results.ResultIssueType
   * @see #setIssueType(ResultIssueType)
   * @see org.osate.results.results.ResultsPackage#getResultIssue_IssueType()
   * @model
   * @generated
   */
  ResultIssueType getIssueType();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultIssue#getIssueType <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Issue Type</em>' attribute.
   * @see org.osate.results.results.ResultIssueType
   * @see #getIssueType()
   * @generated
   */
  void setIssueType(ResultIssueType value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see org.osate.results.results.ResultsPackage#getResultIssue_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultIssue#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

  /**
   * Returns the value of the '<em><b>Exception Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception Type</em>' attribute.
   * @see #setExceptionType(String)
   * @see org.osate.results.results.ResultsPackage#getResultIssue_ExceptionType()
   * @model
   * @generated
   */
  String getExceptionType();

  /**
   * Sets the value of the '{@link org.osate.results.results.ResultIssue#getExceptionType <em>Exception Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Type</em>' attribute.
   * @see #getExceptionType()
   * @generated
   */
  void setExceptionType(String value);

} // ResultIssue
