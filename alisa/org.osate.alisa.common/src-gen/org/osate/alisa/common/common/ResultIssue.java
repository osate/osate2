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
package org.osate.alisa.common.common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ResultIssue#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ResultIssue#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ResultIssue#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ResultIssue#getExceptionType <em>Exception Type</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ResultIssue#getDiagnosticId <em>Diagnostic Id</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ResultIssue#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getResultIssue()
 * @model
 * @generated
 */
public interface ResultIssue extends EObject
{
  /**
   * Returns the value of the '<em><b>Issue Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.alisa.common.common.ResultIssueType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issue Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issue Type</em>' attribute.
   * @see org.osate.alisa.common.common.ResultIssueType
   * @see #setIssueType(ResultIssueType)
   * @see org.osate.alisa.common.common.CommonPackage#getResultIssue_IssueType()
   * @model
   * @generated
   */
  ResultIssueType getIssueType();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ResultIssue#getIssueType <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Issue Type</em>' attribute.
   * @see org.osate.alisa.common.common.ResultIssueType
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
   * @see org.osate.alisa.common.common.CommonPackage#getResultIssue_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ResultIssue#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

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
   * @see org.osate.alisa.common.common.CommonPackage#getResultIssue_Target()
   * @model
   * @generated
   */
  EObject getTarget();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ResultIssue#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(EObject value);

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
   * @see org.osate.alisa.common.common.CommonPackage#getResultIssue_ExceptionType()
   * @model
   * @generated
   */
  String getExceptionType();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ResultIssue#getExceptionType <em>Exception Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Type</em>' attribute.
   * @see #getExceptionType()
   * @generated
   */
  void setExceptionType(String value);

  /**
   * Returns the value of the '<em><b>Diagnostic Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Diagnostic Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Diagnostic Id</em>' attribute.
   * @see #setDiagnosticId(String)
   * @see org.osate.alisa.common.common.CommonPackage#getResultIssue_DiagnosticId()
   * @model
   * @generated
   */
  String getDiagnosticId();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ResultIssue#getDiagnosticId <em>Diagnostic Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Diagnostic Id</em>' attribute.
   * @see #getDiagnosticId()
   * @generated
   */
  void setDiagnosticId(String value);

  /**
   * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ResultIssue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' containment reference list.
   * @see org.osate.alisa.common.common.CommonPackage#getResultIssue_Issues()
   * @model containment="true"
   * @generated
   */
  EList<ResultIssue> getIssues();

} // ResultIssue
