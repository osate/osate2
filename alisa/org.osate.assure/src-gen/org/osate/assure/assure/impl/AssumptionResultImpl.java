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
import org.osate.assure.assure.VerificationActivityResult;

import org.osate.verify.verify.VerificationAssumption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assumption Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssumptionResultImpl#getVerificationResult <em>Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssumptionResultImpl extends AggregateResultImpl implements AssumptionResult
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected VerificationAssumption target;

  /**
   * The default value of the '{@link #getSuccessCount() <em>Success Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuccessCount()
   * @generated
   * @ordered
   */
  protected static final int SUCCESS_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSuccessCount() <em>Success Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuccessCount()
   * @generated
   * @ordered
   */
  protected int successCount = SUCCESS_COUNT_EDEFAULT;

  /**
   * The cached value of the '{@link #getVerificationResult() <em>Verification Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationResult()
   * @generated
   * @ordered
   */
  protected EList<VerificationActivityResult> verificationResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssumptionResultImpl()
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
    return AssurePackage.Literals.ASSUMPTION_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationAssumption getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (VerificationAssumption)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.ASSUMPTION_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationAssumption basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(VerificationAssumption newTarget)
  {
    VerificationAssumption oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSUMPTION_RESULT__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSuccessCount()
  {
    return successCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuccessCount(int newSuccessCount)
  {
    int oldSuccessCount = successCount;
    successCount = newSuccessCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSUMPTION_RESULT__SUCCESS_COUNT, oldSuccessCount, successCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationActivityResult> getVerificationResult()
  {
    if (verificationResult == null)
    {
      verificationResult = new EObjectContainmentEList<VerificationActivityResult>(VerificationActivityResult.class, this, AssurePackage.ASSUMPTION_RESULT__VERIFICATION_RESULT);
    }
    return verificationResult;
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
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_RESULT:
        return ((InternalEList<?>)getVerificationResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.ASSUMPTION_RESULT__SUCCESS_COUNT:
        return getSuccessCount();
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_RESULT:
        return getVerificationResult();
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
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        setTarget((VerificationAssumption)newValue);
        return;
      case AssurePackage.ASSUMPTION_RESULT__SUCCESS_COUNT:
        setSuccessCount((Integer)newValue);
        return;
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_RESULT:
        getVerificationResult().clear();
        getVerificationResult().addAll((Collection<? extends VerificationActivityResult>)newValue);
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
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        setTarget((VerificationAssumption)null);
        return;
      case AssurePackage.ASSUMPTION_RESULT__SUCCESS_COUNT:
        setSuccessCount(SUCCESS_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_RESULT:
        getVerificationResult().clear();
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
      case AssurePackage.ASSUMPTION_RESULT__TARGET:
        return target != null;
      case AssurePackage.ASSUMPTION_RESULT__SUCCESS_COUNT:
        return successCount != SUCCESS_COUNT_EDEFAULT;
      case AssurePackage.ASSUMPTION_RESULT__VERIFICATION_RESULT:
        return verificationResult != null && !verificationResult.isEmpty();
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
    result.append(" (successCount: ");
    result.append(successCount);
    result.append(')');
    return result.toString();
  }

} //AssumptionResultImpl
