/**
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
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

import org.osate.results.results.ResultReport;

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
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getResultReport <em>Result Report</em>}</li>
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
   * The cached value of the '{@link #getResultReport() <em>Result Report</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultReport()
   * @generated
   * @ordered
   */
  protected ResultReport resultReport;

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
  public ResultReport getResultReport()
  {
    if (resultReport != null && resultReport.eIsProxy())
    {
      InternalEObject oldResultReport = (InternalEObject)resultReport;
      resultReport = (ResultReport)eResolveProxy(oldResultReport);
      if (resultReport != oldResultReport)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_RESULT__RESULT_REPORT, oldResultReport, resultReport));
      }
    }
    return resultReport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResultReport basicGetResultReport()
  {
    return resultReport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultReport(ResultReport newResultReport)
  {
    ResultReport oldResultReport = resultReport;
    resultReport = newResultReport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__RESULT_REPORT, oldResultReport, resultReport));
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        if (resolve) return getResultReport();
        return basicGetResultReport();
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        setResultReport((ResultReport)newValue);
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        setResultReport((ResultReport)null);
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        return resultReport != null;
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
