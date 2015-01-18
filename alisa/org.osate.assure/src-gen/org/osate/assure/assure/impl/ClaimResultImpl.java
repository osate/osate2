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
import org.osate.assure.assure.VerificationActivityResult;

import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getSubClaimResult <em>Sub Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getVerificationActivityResult <em>Verification Activity Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClaimResultImpl extends AggregateResultImpl implements ClaimResult
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Requirement target;

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
   * The cached value of the '{@link #getSubClaimResult() <em>Sub Claim Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubClaimResult()
   * @generated
   * @ordered
   */
  protected EList<ClaimResult> subClaimResult;

  /**
   * The cached value of the '{@link #getVerificationActivityResult() <em>Verification Activity Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationActivityResult()
   * @generated
   * @ordered
   */
  protected EList<VerificationActivityResult> verificationActivityResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClaimResultImpl()
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
    return AssurePackage.Literals.CLAIM_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (Requirement)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.CLAIM_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Requirement newTarget)
  {
    Requirement oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__SUCCESS_COUNT, oldSuccessCount, successCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClaimResult> getSubClaimResult()
  {
    if (subClaimResult == null)
    {
      subClaimResult = new EObjectContainmentEList<ClaimResult>(ClaimResult.class, this, AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT);
    }
    return subClaimResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationActivityResult> getVerificationActivityResult()
  {
    if (verificationActivityResult == null)
    {
      verificationActivityResult = new EObjectContainmentEList<VerificationActivityResult>(VerificationActivityResult.class, this, AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT);
    }
    return verificationActivityResult;
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
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        return ((InternalEList<?>)getSubClaimResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
        return ((InternalEList<?>)getVerificationActivityResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.CLAIM_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.CLAIM_RESULT__SUCCESS_COUNT:
        return getSuccessCount();
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        return getSubClaimResult();
      case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
        return getVerificationActivityResult();
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
      case AssurePackage.CLAIM_RESULT__TARGET:
        setTarget((Requirement)newValue);
        return;
      case AssurePackage.CLAIM_RESULT__SUCCESS_COUNT:
        setSuccessCount((Integer)newValue);
        return;
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        getSubClaimResult().clear();
        getSubClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
        return;
      case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
        getVerificationActivityResult().clear();
        getVerificationActivityResult().addAll((Collection<? extends VerificationActivityResult>)newValue);
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
      case AssurePackage.CLAIM_RESULT__TARGET:
        setTarget((Requirement)null);
        return;
      case AssurePackage.CLAIM_RESULT__SUCCESS_COUNT:
        setSuccessCount(SUCCESS_COUNT_EDEFAULT);
        return;
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        getSubClaimResult().clear();
        return;
      case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
        getVerificationActivityResult().clear();
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
      case AssurePackage.CLAIM_RESULT__TARGET:
        return target != null;
      case AssurePackage.CLAIM_RESULT__SUCCESS_COUNT:
        return successCount != SUCCESS_COUNT_EDEFAULT;
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        return subClaimResult != null && !subClaimResult.isEmpty();
      case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
        return verificationActivityResult != null && !verificationActivityResult.isEmpty();
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

} //ClaimResultImpl
