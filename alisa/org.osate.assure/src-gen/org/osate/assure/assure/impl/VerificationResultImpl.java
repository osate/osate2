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
package org.osate.assure.assure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

import org.osate.results.ResultIssue;
import org.osate.results.Results;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getResultState <em>Result State</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerificationResultImpl extends AssureResultImpl implements VerificationResult
{
  /**
   * The default value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionState()
   * @generated
   * @ordered
   */
  protected static final VerificationExecutionState EXECUTION_STATE_EDEFAULT = VerificationExecutionState.TODO;

  /**
   * The cached value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionState()
   * @generated
   * @ordered
   */
  protected VerificationExecutionState executionState = EXECUTION_STATE_EDEFAULT;

  /**
   * The default value of the '{@link #getResultState() <em>Result State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultState()
   * @generated
   * @ordered
   */
  protected static final VerificationResultState RESULT_STATE_EDEFAULT = VerificationResultState.TBD;

  /**
   * The cached value of the '{@link #getResultState() <em>Result State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultState()
   * @generated
   * @ordered
   */
  protected VerificationResultState resultState = RESULT_STATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssues()
   * @generated
   * @ordered
   */
  protected EList<ResultIssue> issues;

  /**
   * The cached value of the '{@link #getResults() <em>Results</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResults()
   * @generated
   * @ordered
   */
  protected Results results;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationResultImpl()
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
    return AssurePackage.Literals.VERIFICATION_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationExecutionState getExecutionState()
  {
    return executionState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecutionState(VerificationExecutionState newExecutionState)
  {
    VerificationExecutionState oldExecutionState = executionState;
    executionState = newExecutionState == null ? EXECUTION_STATE_EDEFAULT : newExecutionState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__EXECUTION_STATE, oldExecutionState, executionState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResultState getResultState()
  {
    return resultState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultState(VerificationResultState newResultState)
  {
    VerificationResultState oldResultState = resultState;
    resultState = newResultState == null ? RESULT_STATE_EDEFAULT : newResultState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__RESULT_STATE, oldResultState, resultState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultIssue> getIssues()
  {
    if (issues == null)
    {
      issues = new EObjectContainmentEList<ResultIssue>(ResultIssue.class, this, AssurePackage.VERIFICATION_RESULT__ISSUES);
    }
    return issues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Results getResults()
  {
    if (results != null && results.eIsProxy())
    {
      InternalEObject oldResults = (InternalEObject)results;
      results = (Results)eResolveProxy(oldResults);
      if (results != oldResults)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_RESULT__RESULTS, oldResults, results));
      }
    }
    return results;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Results basicGetResults()
  {
    return results;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResults(Results newResults)
  {
    Results oldResults = results;
    results = newResults;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__RESULTS, oldResults, results));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__MESSAGE, oldMessage, message));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AssurePackage.VERIFICATION_RESULT__ISSUES:
        return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case AssurePackage.VERIFICATION_RESULT__EXECUTION_STATE:
        return getExecutionState();
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        return getResultState();
      case AssurePackage.VERIFICATION_RESULT__ISSUES:
        return getIssues();
      case AssurePackage.VERIFICATION_RESULT__RESULTS:
        if (resolve) return getResults();
        return basicGetResults();
      case AssurePackage.VERIFICATION_RESULT__MESSAGE:
        return getMessage();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AssurePackage.VERIFICATION_RESULT__EXECUTION_STATE:
        setExecutionState((VerificationExecutionState)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        setResultState((VerificationResultState)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__ISSUES:
        getIssues().clear();
        getIssues().addAll((Collection<? extends ResultIssue>)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__RESULTS:
        setResults((Results)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__MESSAGE:
        setMessage((String)newValue);
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
      case AssurePackage.VERIFICATION_RESULT__EXECUTION_STATE:
        setExecutionState(EXECUTION_STATE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        setResultState(RESULT_STATE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__ISSUES:
        getIssues().clear();
        return;
      case AssurePackage.VERIFICATION_RESULT__RESULTS:
        setResults((Results)null);
        return;
      case AssurePackage.VERIFICATION_RESULT__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
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
      case AssurePackage.VERIFICATION_RESULT__EXECUTION_STATE:
        return executionState != EXECUTION_STATE_EDEFAULT;
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        return resultState != RESULT_STATE_EDEFAULT;
      case AssurePackage.VERIFICATION_RESULT__ISSUES:
        return issues != null && !issues.isEmpty();
      case AssurePackage.VERIFICATION_RESULT__RESULTS:
        return results != null;
      case AssurePackage.VERIFICATION_RESULT__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
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
    result.append(" (executionState: ");
    result.append(executionState);
    result.append(", resultState: ");
    result.append(resultState);
    result.append(", message: ");
    result.append(message);
    result.append(')');
    return result.toString();
  }

} //VerificationResultImpl
