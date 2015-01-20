/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.AssureResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getErrorCount <em>Error Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getFailthenCount <em>Failthen Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getSkippedCount <em>Skipped Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getTotalCount <em>Total Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssureResultImpl extends MinimalEObjectImpl.Container implements AssureResult
{
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
   * The default value of the '{@link #getErrorCount() <em>Error Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorCount()
   * @generated
   * @ordered
   */
  protected static final int ERROR_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getErrorCount() <em>Error Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorCount()
   * @generated
   * @ordered
   */
  protected int errorCount = ERROR_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getFailthenCount() <em>Failthen Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailthenCount()
   * @generated
   * @ordered
   */
  protected static final int FAILTHEN_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFailthenCount() <em>Failthen Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailthenCount()
   * @generated
   * @ordered
   */
  protected int failthenCount = FAILTHEN_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getSkippedCount() <em>Skipped Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSkippedCount()
   * @generated
   * @ordered
   */
  protected static final int SKIPPED_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSkippedCount() <em>Skipped Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSkippedCount()
   * @generated
   * @ordered
   */
  protected int skippedCount = SKIPPED_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getTotalCount() <em>Total Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTotalCount()
   * @generated
   * @ordered
   */
  protected static final int TOTAL_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTotalCount() <em>Total Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTotalCount()
   * @generated
   * @ordered
   */
  protected int totalCount = TOTAL_COUNT_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssureResultImpl()
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
    return AssurePackage.Literals.ASSURE_RESULT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__SUCCESS_COUNT, oldSuccessCount, successCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__FAIL_COUNT, oldFailCount, failCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getErrorCount()
  {
    return errorCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorCount(int newErrorCount)
  {
    int oldErrorCount = errorCount;
    errorCount = newErrorCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__ERROR_COUNT, oldErrorCount, errorCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFailthenCount()
  {
    return failthenCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailthenCount(int newFailthenCount)
  {
    int oldFailthenCount = failthenCount;
    failthenCount = newFailthenCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT, oldFailthenCount, failthenCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSkippedCount()
  {
    return skippedCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSkippedCount(int newSkippedCount)
  {
    int oldSkippedCount = skippedCount;
    skippedCount = newSkippedCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__SKIPPED_COUNT, oldSkippedCount, skippedCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTotalCount()
  {
    return totalCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTotalCount(int newTotalCount)
  {
    int oldTotalCount = totalCount;
    totalCount = newTotalCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__TOTAL_COUNT, oldTotalCount, totalCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__WEIGHT, oldWeight, weight));
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
      case AssurePackage.ASSURE_RESULT__SUCCESS_COUNT:
        return getSuccessCount();
      case AssurePackage.ASSURE_RESULT__FAIL_COUNT:
        return getFailCount();
      case AssurePackage.ASSURE_RESULT__ERROR_COUNT:
        return getErrorCount();
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        return getFailthenCount();
      case AssurePackage.ASSURE_RESULT__SKIPPED_COUNT:
        return getSkippedCount();
      case AssurePackage.ASSURE_RESULT__TOTAL_COUNT:
        return getTotalCount();
      case AssurePackage.ASSURE_RESULT__WEIGHT:
        return getWeight();
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
      case AssurePackage.ASSURE_RESULT__SUCCESS_COUNT:
        setSuccessCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__FAIL_COUNT:
        setFailCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__ERROR_COUNT:
        setErrorCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        setFailthenCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__SKIPPED_COUNT:
        setSkippedCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__TOTAL_COUNT:
        setTotalCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__WEIGHT:
        setWeight((Integer)newValue);
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
      case AssurePackage.ASSURE_RESULT__SUCCESS_COUNT:
        setSuccessCount(SUCCESS_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__FAIL_COUNT:
        setFailCount(FAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__ERROR_COUNT:
        setErrorCount(ERROR_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        setFailthenCount(FAILTHEN_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__SKIPPED_COUNT:
        setSkippedCount(SKIPPED_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__TOTAL_COUNT:
        setTotalCount(TOTAL_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
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
      case AssurePackage.ASSURE_RESULT__SUCCESS_COUNT:
        return successCount != SUCCESS_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__FAIL_COUNT:
        return failCount != FAIL_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__ERROR_COUNT:
        return errorCount != ERROR_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        return failthenCount != FAILTHEN_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__SKIPPED_COUNT:
        return skippedCount != SKIPPED_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__TOTAL_COUNT:
        return totalCount != TOTAL_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
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
    result.append(", failCount: ");
    result.append(failCount);
    result.append(", errorCount: ");
    result.append(errorCount);
    result.append(", failthenCount: ");
    result.append(failthenCount);
    result.append(", skippedCount: ");
    result.append(skippedCount);
    result.append(", totalCount: ");
    result.append(totalCount);
    result.append(", weight: ");
    result.append(weight);
    result.append(')');
    return result.toString();
  }

} //AssureResultImpl
