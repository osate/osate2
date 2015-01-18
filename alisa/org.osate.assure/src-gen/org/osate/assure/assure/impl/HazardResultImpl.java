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
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.HazardResult;

import org.osate.reqspec.reqSpec.Hazard;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hazard Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.HazardResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.HazardResultImpl#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.HazardResultImpl#getClaimResult <em>Claim Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HazardResultImpl extends AggregateResultImpl implements HazardResult
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Hazard target;

  /**
   * The default value of the '{@link #getPassCount() <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPassCount()
   * @generated
   * @ordered
   */
  protected static final int PASS_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPassCount() <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPassCount()
   * @generated
   * @ordered
   */
  protected int passCount = PASS_COUNT_EDEFAULT;

  /**
   * The cached value of the '{@link #getClaimResult() <em>Claim Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaimResult()
   * @generated
   * @ordered
   */
  protected EList<ClaimResult> claimResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HazardResultImpl()
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
    return AssurePackage.Literals.HAZARD_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Hazard getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (Hazard)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.HAZARD_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Hazard basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Hazard newTarget)
  {
    Hazard oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.HAZARD_RESULT__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPassCount()
  {
    return passCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPassCount(int newPassCount)
  {
    int oldPassCount = passCount;
    passCount = newPassCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.HAZARD_RESULT__PASS_COUNT, oldPassCount, passCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClaimResult> getClaimResult()
  {
    if (claimResult == null)
    {
      claimResult = new EObjectContainmentEList<ClaimResult>(ClaimResult.class, this, AssurePackage.HAZARD_RESULT__CLAIM_RESULT);
    }
    return claimResult;
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
      case AssurePackage.HAZARD_RESULT__CLAIM_RESULT:
        return ((InternalEList<?>)getClaimResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.HAZARD_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.HAZARD_RESULT__PASS_COUNT:
        return getPassCount();
      case AssurePackage.HAZARD_RESULT__CLAIM_RESULT:
        return getClaimResult();
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
      case AssurePackage.HAZARD_RESULT__TARGET:
        setTarget((Hazard)newValue);
        return;
      case AssurePackage.HAZARD_RESULT__PASS_COUNT:
        setPassCount((Integer)newValue);
        return;
      case AssurePackage.HAZARD_RESULT__CLAIM_RESULT:
        getClaimResult().clear();
        getClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
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
      case AssurePackage.HAZARD_RESULT__TARGET:
        setTarget((Hazard)null);
        return;
      case AssurePackage.HAZARD_RESULT__PASS_COUNT:
        setPassCount(PASS_COUNT_EDEFAULT);
        return;
      case AssurePackage.HAZARD_RESULT__CLAIM_RESULT:
        getClaimResult().clear();
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
      case AssurePackage.HAZARD_RESULT__TARGET:
        return target != null;
      case AssurePackage.HAZARD_RESULT__PASS_COUNT:
        return passCount != PASS_COUNT_EDEFAULT;
      case AssurePackage.HAZARD_RESULT__CLAIM_RESULT:
        return claimResult != null && !claimResult.isEmpty();
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
    result.append(" (passCount: ");
    result.append(passCount);
    result.append(')');
    return result.toString();
  }

} //HazardResultImpl
