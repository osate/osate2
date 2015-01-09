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

import org.osate.assure.assure.AggregateResultData;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.VerificationResult;

import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getSubClaimResult <em>Sub Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getVerificationResult <em>Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClaimResultImpl extends AssuranceResultImpl implements ClaimResult
{
  /**
   * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirement()
   * @generated
   * @ordered
   */
  protected Requirement requirement;

  /**
   * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected AggregateResultData result;

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
   * The cached value of the '{@link #getVerificationResult() <em>Verification Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationResult()
   * @generated
   * @ordered
   */
  protected EList<VerificationResult> verificationResult;

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
  public Requirement getRequirement()
  {
    if (requirement != null && requirement.eIsProxy())
    {
      InternalEObject oldRequirement = (InternalEObject)requirement;
      requirement = (Requirement)eResolveProxy(oldRequirement);
      if (requirement != oldRequirement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.CLAIM_RESULT__REQUIREMENT, oldRequirement, requirement));
      }
    }
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement basicGetRequirement()
  {
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirement(Requirement newRequirement)
  {
    Requirement oldRequirement = requirement;
    requirement = newRequirement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__REQUIREMENT, oldRequirement, requirement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregateResultData getResult()
  {
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResult(AggregateResultData newResult, NotificationChain msgs)
  {
    AggregateResultData oldResult = result;
    result = newResult;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__RESULT, oldResult, newResult);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResult(AggregateResultData newResult)
  {
    if (newResult != result)
    {
      NotificationChain msgs = null;
      if (result != null)
        msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CLAIM_RESULT__RESULT, null, msgs);
      if (newResult != null)
        msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CLAIM_RESULT__RESULT, null, msgs);
      msgs = basicSetResult(newResult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__RESULT, newResult, newResult));
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
  public EList<VerificationResult> getVerificationResult()
  {
    if (verificationResult == null)
    {
      verificationResult = new EObjectContainmentEList<VerificationResult>(VerificationResult.class, this, AssurePackage.CLAIM_RESULT__VERIFICATION_RESULT);
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
      case AssurePackage.CLAIM_RESULT__RESULT:
        return basicSetResult(null, msgs);
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        return ((InternalEList<?>)getSubClaimResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CLAIM_RESULT__VERIFICATION_RESULT:
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
      case AssurePackage.CLAIM_RESULT__REQUIREMENT:
        if (resolve) return getRequirement();
        return basicGetRequirement();
      case AssurePackage.CLAIM_RESULT__RESULT:
        return getResult();
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        return getSubClaimResult();
      case AssurePackage.CLAIM_RESULT__VERIFICATION_RESULT:
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
      case AssurePackage.CLAIM_RESULT__REQUIREMENT:
        setRequirement((Requirement)newValue);
        return;
      case AssurePackage.CLAIM_RESULT__RESULT:
        setResult((AggregateResultData)newValue);
        return;
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        getSubClaimResult().clear();
        getSubClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
        return;
      case AssurePackage.CLAIM_RESULT__VERIFICATION_RESULT:
        getVerificationResult().clear();
        getVerificationResult().addAll((Collection<? extends VerificationResult>)newValue);
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
      case AssurePackage.CLAIM_RESULT__REQUIREMENT:
        setRequirement((Requirement)null);
        return;
      case AssurePackage.CLAIM_RESULT__RESULT:
        setResult((AggregateResultData)null);
        return;
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        getSubClaimResult().clear();
        return;
      case AssurePackage.CLAIM_RESULT__VERIFICATION_RESULT:
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
      case AssurePackage.CLAIM_RESULT__REQUIREMENT:
        return requirement != null;
      case AssurePackage.CLAIM_RESULT__RESULT:
        return result != null;
      case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
        return subClaimResult != null && !subClaimResult.isEmpty();
      case AssurePackage.CLAIM_RESULT__VERIFICATION_RESULT:
        return verificationResult != null && !verificationResult.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClaimResultImpl
