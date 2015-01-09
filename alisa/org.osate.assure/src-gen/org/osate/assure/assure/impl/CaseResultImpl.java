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
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getSubCaseResult <em>Sub Case Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getClaimResult <em>Claim Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseResultImpl extends AssuranceResultImpl implements CaseResult
{
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
   * The cached value of the '{@link #getSubCaseResult() <em>Sub Case Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubCaseResult()
   * @generated
   * @ordered
   */
  protected EList<CaseResult> subCaseResult;

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
  protected CaseResultImpl()
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
    return AssurePackage.Literals.CASE_RESULT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__RESULT, oldResult, newResult);
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
        msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CASE_RESULT__RESULT, null, msgs);
      if (newResult != null)
        msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CASE_RESULT__RESULT, null, msgs);
      msgs = basicSetResult(newResult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__RESULT, newResult, newResult));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CaseResult> getSubCaseResult()
  {
    if (subCaseResult == null)
    {
      subCaseResult = new EObjectContainmentEList<CaseResult>(CaseResult.class, this, AssurePackage.CASE_RESULT__SUB_CASE_RESULT);
    }
    return subCaseResult;
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
      claimResult = new EObjectContainmentEList<ClaimResult>(ClaimResult.class, this, AssurePackage.CASE_RESULT__CLAIM_RESULT);
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
      case AssurePackage.CASE_RESULT__RESULT:
        return basicSetResult(null, msgs);
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return ((InternalEList<?>)getSubCaseResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
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
      case AssurePackage.CASE_RESULT__RESULT:
        return getResult();
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return getSubCaseResult();
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
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
      case AssurePackage.CASE_RESULT__RESULT:
        setResult((AggregateResultData)newValue);
        return;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        getSubCaseResult().clear();
        getSubCaseResult().addAll((Collection<? extends CaseResult>)newValue);
        return;
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
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
      case AssurePackage.CASE_RESULT__RESULT:
        setResult((AggregateResultData)null);
        return;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        getSubCaseResult().clear();
        return;
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
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
      case AssurePackage.CASE_RESULT__RESULT:
        return result != null;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return subCaseResult != null && !subCaseResult.isEmpty();
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return claimResult != null && !claimResult.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CaseResultImpl
