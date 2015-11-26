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
package org.osate.results.results.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.results.results.ResultIssue;
import org.osate.results.results.ResultIssueType;
import org.osate.results.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Issue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.results.impl.ResultIssueImpl#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultIssueImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.results.results.impl.ResultIssueImpl#getExceptionType <em>Exception Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultIssueImpl extends ResultReportsImpl implements ResultIssue
{
  /**
   * The default value of the '{@link #getIssueType() <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssueType()
   * @generated
   * @ordered
   */
  protected static final ResultIssueType ISSUE_TYPE_EDEFAULT = ResultIssueType.ERROR;

  /**
   * The cached value of the '{@link #getIssueType() <em>Issue Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssueType()
   * @generated
   * @ordered
   */
  protected ResultIssueType issueType = ISSUE_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getExceptionType() <em>Exception Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionType()
   * @generated
   * @ordered
   */
  protected static final String EXCEPTION_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExceptionType() <em>Exception Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptionType()
   * @generated
   * @ordered
   */
  protected String exceptionType = EXCEPTION_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResultIssueImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ResultsPackage.Literals.RESULT_ISSUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultIssueType getIssueType()
  {
    return issueType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIssueType(ResultIssueType newIssueType)
  {
    ResultIssueType oldIssueType = issueType;
    issueType = newIssueType == null ? ISSUE_TYPE_EDEFAULT : newIssueType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__ISSUE_TYPE, oldIssueType, issueType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(String newMessage)
  {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__MESSAGE, oldMessage, message));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExceptionType()
  {
    return exceptionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceptionType(String newExceptionType)
  {
    String oldExceptionType = exceptionType;
    exceptionType = newExceptionType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE, oldExceptionType, exceptionType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
        return getIssueType();
      case ResultsPackage.RESULT_ISSUE__MESSAGE:
        return getMessage();
      case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
        return getExceptionType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
        setIssueType((ResultIssueType)newValue);
        return;
      case ResultsPackage.RESULT_ISSUE__MESSAGE:
        setMessage((String)newValue);
        return;
      case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
        setExceptionType((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
        setIssueType(ISSUE_TYPE_EDEFAULT);
        return;
      case ResultsPackage.RESULT_ISSUE__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
        setExceptionType(EXCEPTION_TYPE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
        return issueType != ISSUE_TYPE_EDEFAULT;
      case ResultsPackage.RESULT_ISSUE__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
        return EXCEPTION_TYPE_EDEFAULT == null ? exceptionType != null : !EXCEPTION_TYPE_EDEFAULT.equals(exceptionType);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (issueType: ");
    result.append(issueType);
    result.append(", message: ");
    result.append(message);
    result.append(", exceptionType: ");
    result.append(exceptionType);
    result.append(')');
    return result.toString();
  }

} //ResultIssueImpl
