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

import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getVerificationActivity <em>Verification Activity</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getAssumptionResult <em>Assumption Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getPreconditionResult <em>Precondition Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationResultImpl extends EvidenceResultImpl implements VerificationResult
{
  /**
   * The cached value of the '{@link #getVerificationActivity() <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationActivity()
   * @generated
   * @ordered
   */
  protected VerificationActivity verificationActivity;

  /**
   * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected static final VerificationResultState STATUS_EDEFAULT = VerificationResultState.TBD;

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected VerificationResultState status = STATUS_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssumptionResult() <em>Assumption Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssumptionResult()
   * @generated
   * @ordered
   */
  protected EList<AssumptionResult> assumptionResult;

  /**
   * The cached value of the '{@link #getPreconditionResult() <em>Precondition Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditionResult()
   * @generated
   * @ordered
   */
  protected EList<PreconditionResult> preconditionResult;

  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected EList<VerificationResult> first;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected EList<VerificationResult> second;

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
  public VerificationActivity getVerificationActivity()
  {
    if (verificationActivity != null && verificationActivity.eIsProxy())
    {
      InternalEObject oldVerificationActivity = (InternalEObject)verificationActivity;
      verificationActivity = (VerificationActivity)eResolveProxy(oldVerificationActivity);
      if (verificationActivity != oldVerificationActivity)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
      }
    }
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity basicGetVerificationActivity()
  {
    return verificationActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerificationActivity(VerificationActivity newVerificationActivity)
  {
    VerificationActivity oldVerificationActivity = verificationActivity;
    verificationActivity = newVerificationActivity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResultState getStatus()
  {
    return status;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatus(VerificationResultState newStatus)
  {
    VerificationResultState oldStatus = status;
    status = newStatus == null ? STATUS_EDEFAULT : newStatus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__STATUS, oldStatus, status));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssumptionResult> getAssumptionResult()
  {
    if (assumptionResult == null)
    {
      assumptionResult = new EObjectContainmentEList<AssumptionResult>(AssumptionResult.class, this, AssurePackage.VERIFICATION_RESULT__ASSUMPTION_RESULT);
    }
    return assumptionResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PreconditionResult> getPreconditionResult()
  {
    if (preconditionResult == null)
    {
      preconditionResult = new EObjectContainmentEList<PreconditionResult>(PreconditionResult.class, this, AssurePackage.VERIFICATION_RESULT__PRECONDITION_RESULT);
    }
    return preconditionResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationResult> getFirst()
  {
    if (first == null)
    {
      first = new EObjectContainmentEList<VerificationResult>(VerificationResult.class, this, AssurePackage.VERIFICATION_RESULT__FIRST);
    }
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationResult> getSecond()
  {
    if (second == null)
    {
      second = new EObjectContainmentEList<VerificationResult>(VerificationResult.class, this, AssurePackage.VERIFICATION_RESULT__SECOND);
    }
    return second;
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
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_RESULT:
        return ((InternalEList<?>)getAssumptionResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.VERIFICATION_RESULT__PRECONDITION_RESULT:
        return ((InternalEList<?>)getPreconditionResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.VERIFICATION_RESULT__FIRST:
        return ((InternalEList<?>)getFirst()).basicRemove(otherEnd, msgs);
      case AssurePackage.VERIFICATION_RESULT__SECOND:
        return ((InternalEList<?>)getSecond()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        if (resolve) return getVerificationActivity();
        return basicGetVerificationActivity();
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        return getStatus();
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_RESULT:
        return getAssumptionResult();
      case AssurePackage.VERIFICATION_RESULT__PRECONDITION_RESULT:
        return getPreconditionResult();
      case AssurePackage.VERIFICATION_RESULT__FIRST:
        return getFirst();
      case AssurePackage.VERIFICATION_RESULT__SECOND:
        return getSecond();
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationActivity)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        setStatus((VerificationResultState)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_RESULT:
        getAssumptionResult().clear();
        getAssumptionResult().addAll((Collection<? extends AssumptionResult>)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__PRECONDITION_RESULT:
        getPreconditionResult().clear();
        getPreconditionResult().addAll((Collection<? extends PreconditionResult>)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__FIRST:
        getFirst().clear();
        getFirst().addAll((Collection<? extends VerificationResult>)newValue);
        return;
      case AssurePackage.VERIFICATION_RESULT__SECOND:
        getSecond().clear();
        getSecond().addAll((Collection<? extends VerificationResult>)newValue);
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        setVerificationActivity((VerificationActivity)null);
        return;
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        setStatus(STATUS_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_RESULT:
        getAssumptionResult().clear();
        return;
      case AssurePackage.VERIFICATION_RESULT__PRECONDITION_RESULT:
        getPreconditionResult().clear();
        return;
      case AssurePackage.VERIFICATION_RESULT__FIRST:
        getFirst().clear();
        return;
      case AssurePackage.VERIFICATION_RESULT__SECOND:
        getSecond().clear();
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
      case AssurePackage.VERIFICATION_RESULT__VERIFICATION_ACTIVITY:
        return verificationActivity != null;
      case AssurePackage.VERIFICATION_RESULT__STATUS:
        return status != STATUS_EDEFAULT;
      case AssurePackage.VERIFICATION_RESULT__ASSUMPTION_RESULT:
        return assumptionResult != null && !assumptionResult.isEmpty();
      case AssurePackage.VERIFICATION_RESULT__PRECONDITION_RESULT:
        return preconditionResult != null && !preconditionResult.isEmpty();
      case AssurePackage.VERIFICATION_RESULT__FIRST:
        return first != null && !first.isEmpty();
      case AssurePackage.VERIFICATION_RESULT__SECOND:
        return second != null && !second.isEmpty();
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
    result.append(" (status: ");
    result.append(status);
    result.append(')');
    return result.toString();
  }

} //VerificationResultImpl
