/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getResultState <em>Result State</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getFailMsg <em>Fail Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getFailTarget <em>Fail Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getResultReport <em>Result Report</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationResultImpl extends MinimalEObjectImpl.Container implements VerificationResult
{
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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getFailMsg() <em>Fail Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailMsg()
   * @generated
   * @ordered
   */
  protected static final String FAIL_MSG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFailMsg() <em>Fail Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailMsg()
   * @generated
   * @ordered
   */
  protected String failMsg = FAIL_MSG_EDEFAULT;

  /**
   * The cached value of the '{@link #getFailTarget() <em>Fail Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailTarget()
   * @generated
   * @ordered
   */
  protected EObject failTarget;

  /**
   * The cached value of the '{@link #getResultReport() <em>Result Report</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultReport()
   * @generated
   * @ordered
   */
  protected EObject resultReport;

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
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFailMsg()
  {
    return failMsg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailMsg(String newFailMsg)
  {
    String oldFailMsg = failMsg;
    failMsg = newFailMsg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__FAIL_MSG, oldFailMsg, failMsg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getFailTarget()
  {
    if (failTarget != null && failTarget.eIsProxy())
    {
      InternalEObject oldFailTarget = (InternalEObject)failTarget;
      failTarget = eResolveProxy(oldFailTarget);
      if (failTarget != oldFailTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_RESULT__FAIL_TARGET, oldFailTarget, failTarget));
      }
    }
    return failTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetFailTarget()
  {
    return failTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailTarget(EObject newFailTarget)
  {
    EObject oldFailTarget = failTarget;
    failTarget = newFailTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__FAIL_TARGET, oldFailTarget, failTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getResultReport()
  {
    if (resultReport != null && resultReport.eIsProxy())
    {
      InternalEObject oldResultReport = (InternalEObject)resultReport;
      resultReport = eResolveProxy(oldResultReport);
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
  public EObject basicGetResultReport()
  {
    return resultReport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResultReport(EObject newResultReport)
  {
    EObject oldResultReport = resultReport;
    resultReport = newResultReport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__RESULT_REPORT, oldResultReport, resultReport));
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        return getResultState();
      case AssurePackage.VERIFICATION_RESULT__TYPE:
        return getType();
      case AssurePackage.VERIFICATION_RESULT__FAIL_MSG:
        return getFailMsg();
      case AssurePackage.VERIFICATION_RESULT__FAIL_TARGET:
        if (resolve) return getFailTarget();
        return basicGetFailTarget();
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        if (resolve) return getResultReport();
        return basicGetResultReport();
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        setResultState((VerificationResultState)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__TYPE:
        setType((String)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__FAIL_MSG:
        setFailMsg((String)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__FAIL_TARGET:
        setFailTarget((EObject)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        setResultReport((EObject)newValue);
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        setResultState(RESULT_STATE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__FAIL_MSG:
        setFailMsg(FAIL_MSG_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__FAIL_TARGET:
        setFailTarget((EObject)null);
        return;
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        setResultReport((EObject)null);
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
      case AssurePackage.VERIFICATION_RESULT__RESULT_STATE:
        return resultState != RESULT_STATE_EDEFAULT;
      case AssurePackage.VERIFICATION_RESULT__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case AssurePackage.VERIFICATION_RESULT__FAIL_MSG:
        return FAIL_MSG_EDEFAULT == null ? failMsg != null : !FAIL_MSG_EDEFAULT.equals(failMsg);
      case AssurePackage.VERIFICATION_RESULT__FAIL_TARGET:
        return failTarget != null;
      case AssurePackage.VERIFICATION_RESULT__RESULT_REPORT:
        return resultReport != null;
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
    result.append(" (resultState: ");
    result.append(resultState);
    result.append(", type: ");
    result.append(type);
    result.append(", failMsg: ");
    result.append(failMsg);
    result.append(')');
    return result.toString();
  }

} //VerificationResultImpl
