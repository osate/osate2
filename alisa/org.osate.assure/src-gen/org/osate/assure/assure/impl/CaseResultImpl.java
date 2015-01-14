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
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.HazardResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getNeutralCount <em>Neutral Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getFailMsg <em>Fail Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getSubCaseResult <em>Sub Case Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getClaimResult <em>Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.CaseResultImpl#getHazardResult <em>Hazard Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseResultImpl extends AssuranceResultImpl implements CaseResult
{
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
   * The default value of the '{@link #getFailCount() <em>Fail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailCount()
   * @generated
   * @ordered
   */
  protected static final int FAIL_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFailCount() <em>Fail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailCount()
   * @generated
   * @ordered
   */
  protected int failCount = FAIL_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getNeutralCount() <em>Neutral Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNeutralCount()
   * @generated
   * @ordered
   */
  protected static final int NEUTRAL_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNeutralCount() <em>Neutral Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNeutralCount()
   * @generated
   * @ordered
   */
  protected int neutralCount = NEUTRAL_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getUnknownCount() <em>Unknown Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnknownCount()
   * @generated
   * @ordered
   */
  protected static final int UNKNOWN_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUnknownCount() <em>Unknown Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnknownCount()
   * @generated
   * @ordered
   */
  protected int unknownCount = UNKNOWN_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected static final int WEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected int weight = WEIGHT_EDEFAULT;

  /**
   * The default value of the '{@link #getSucessMsg() <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSucessMsg()
   * @generated
   * @ordered
   */
  protected static final String SUCESS_MSG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSucessMsg() <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSucessMsg()
   * @generated
   * @ordered
   */
  protected String sucessMsg = SUCESS_MSG_EDEFAULT;

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
   * The cached value of the '{@link #getHazardResult() <em>Hazard Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHazardResult()
   * @generated
   * @ordered
   */
  protected EList<HazardResult> hazardResult;

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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__PASS_COUNT, oldPassCount, passCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFailCount()
  {
    return failCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailCount(int newFailCount)
  {
    int oldFailCount = failCount;
    failCount = newFailCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__FAIL_COUNT, oldFailCount, failCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNeutralCount()
  {
    return neutralCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNeutralCount(int newNeutralCount)
  {
    int oldNeutralCount = neutralCount;
    neutralCount = newNeutralCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__NEUTRAL_COUNT, oldNeutralCount, neutralCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUnknownCount()
  {
    return unknownCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnknownCount(int newUnknownCount)
  {
    int oldUnknownCount = unknownCount;
    unknownCount = newUnknownCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__UNKNOWN_COUNT, oldUnknownCount, unknownCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWeight()
  {
    return weight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWeight(int newWeight)
  {
    int oldWeight = weight;
    weight = newWeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__WEIGHT, oldWeight, weight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSucessMsg()
  {
    return sucessMsg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSucessMsg(String newSucessMsg)
  {
    String oldSucessMsg = sucessMsg;
    sucessMsg = newSucessMsg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__SUCESS_MSG, oldSucessMsg, sucessMsg));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CASE_RESULT__FAIL_MSG, oldFailMsg, failMsg));
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
  public EList<HazardResult> getHazardResult()
  {
    if (hazardResult == null)
    {
      hazardResult = new EObjectContainmentEList<HazardResult>(HazardResult.class, this, AssurePackage.CASE_RESULT__HAZARD_RESULT);
    }
    return hazardResult;
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
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return ((InternalEList<?>)getSubCaseResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return ((InternalEList<?>)getClaimResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        return ((InternalEList<?>)getHazardResult()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        return getPassCount();
      case AssurePackage.CASE_RESULT__FAIL_COUNT:
        return getFailCount();
      case AssurePackage.CASE_RESULT__NEUTRAL_COUNT:
        return getNeutralCount();
      case AssurePackage.CASE_RESULT__UNKNOWN_COUNT:
        return getUnknownCount();
      case AssurePackage.CASE_RESULT__WEIGHT:
        return getWeight();
      case AssurePackage.CASE_RESULT__SUCESS_MSG:
        return getSucessMsg();
      case AssurePackage.CASE_RESULT__FAIL_MSG:
        return getFailMsg();
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return getSubCaseResult();
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return getClaimResult();
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        return getHazardResult();
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
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        setPassCount((Integer)newValue);
        return;
      case AssurePackage.CASE_RESULT__FAIL_COUNT:
        setFailCount((Integer)newValue);
        return;
      case AssurePackage.CASE_RESULT__NEUTRAL_COUNT:
        setNeutralCount((Integer)newValue);
        return;
      case AssurePackage.CASE_RESULT__UNKNOWN_COUNT:
        setUnknownCount((Integer)newValue);
        return;
      case AssurePackage.CASE_RESULT__WEIGHT:
        setWeight((Integer)newValue);
        return;
      case AssurePackage.CASE_RESULT__SUCESS_MSG:
        setSucessMsg((String)newValue);
        return;
      case AssurePackage.CASE_RESULT__FAIL_MSG:
        setFailMsg((String)newValue);
        return;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        getSubCaseResult().clear();
        getSubCaseResult().addAll((Collection<? extends CaseResult>)newValue);
        return;
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        getClaimResult().clear();
        getClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
        return;
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        getHazardResult().clear();
        getHazardResult().addAll((Collection<? extends HazardResult>)newValue);
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
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        setPassCount(PASS_COUNT_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__FAIL_COUNT:
        setFailCount(FAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__NEUTRAL_COUNT:
        setNeutralCount(NEUTRAL_COUNT_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__UNKNOWN_COUNT:
        setUnknownCount(UNKNOWN_COUNT_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__SUCESS_MSG:
        setSucessMsg(SUCESS_MSG_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__FAIL_MSG:
        setFailMsg(FAIL_MSG_EDEFAULT);
        return;
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        getSubCaseResult().clear();
        return;
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        getClaimResult().clear();
        return;
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        getHazardResult().clear();
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
      case AssurePackage.CASE_RESULT__PASS_COUNT:
        return passCount != PASS_COUNT_EDEFAULT;
      case AssurePackage.CASE_RESULT__FAIL_COUNT:
        return failCount != FAIL_COUNT_EDEFAULT;
      case AssurePackage.CASE_RESULT__NEUTRAL_COUNT:
        return neutralCount != NEUTRAL_COUNT_EDEFAULT;
      case AssurePackage.CASE_RESULT__UNKNOWN_COUNT:
        return unknownCount != UNKNOWN_COUNT_EDEFAULT;
      case AssurePackage.CASE_RESULT__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
      case AssurePackage.CASE_RESULT__SUCESS_MSG:
        return SUCESS_MSG_EDEFAULT == null ? sucessMsg != null : !SUCESS_MSG_EDEFAULT.equals(sucessMsg);
      case AssurePackage.CASE_RESULT__FAIL_MSG:
        return FAIL_MSG_EDEFAULT == null ? failMsg != null : !FAIL_MSG_EDEFAULT.equals(failMsg);
      case AssurePackage.CASE_RESULT__SUB_CASE_RESULT:
        return subCaseResult != null && !subCaseResult.isEmpty();
      case AssurePackage.CASE_RESULT__CLAIM_RESULT:
        return claimResult != null && !claimResult.isEmpty();
      case AssurePackage.CASE_RESULT__HAZARD_RESULT:
        return hazardResult != null && !hazardResult.isEmpty();
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
    result.append(", failCount: ");
    result.append(failCount);
    result.append(", neutralCount: ");
    result.append(neutralCount);
    result.append(", unknownCount: ");
    result.append(unknownCount);
    result.append(", weight: ");
    result.append(weight);
    result.append(", sucessMsg: ");
    result.append(sucessMsg);
    result.append(", failMsg: ");
    result.append(failMsg);
    result.append(')');
    return result.toString();
  }

} //CaseResultImpl
