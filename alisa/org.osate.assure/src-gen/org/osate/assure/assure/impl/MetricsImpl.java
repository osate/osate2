/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.Metrics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metrics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getTbdCount <em>Tbd Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getTimeoutCount <em>Timeout Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getErrorCount <em>Error Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getDidelseCount <em>Didelse Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getThenskipCount <em>Thenskip Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getPreconditionfailCount <em>Preconditionfail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getValidationfailCount <em>Validationfail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getExecutionTime <em>Execution Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetricsImpl extends MinimalEObjectImpl.Container implements Metrics
{
  /**
   * The default value of the '{@link #getTbdCount() <em>Tbd Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTbdCount()
   * @generated
   * @ordered
   */
  protected static final int TBD_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTbdCount() <em>Tbd Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTbdCount()
   * @generated
   * @ordered
   */
  protected int tbdCount = TBD_COUNT_EDEFAULT;

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
   * The default value of the '{@link #getTimeoutCount() <em>Timeout Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeoutCount()
   * @generated
   * @ordered
   */
  protected static final int TIMEOUT_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTimeoutCount() <em>Timeout Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeoutCount()
   * @generated
   * @ordered
   */
  protected int timeoutCount = TIMEOUT_COUNT_EDEFAULT;

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
   * The default value of the '{@link #getDidelseCount() <em>Didelse Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDidelseCount()
   * @generated
   * @ordered
   */
  protected static final int DIDELSE_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDidelseCount() <em>Didelse Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDidelseCount()
   * @generated
   * @ordered
   */
  protected int didelseCount = DIDELSE_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getThenskipCount() <em>Thenskip Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenskipCount()
   * @generated
   * @ordered
   */
  protected static final int THENSKIP_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getThenskipCount() <em>Thenskip Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenskipCount()
   * @generated
   * @ordered
   */
  protected int thenskipCount = THENSKIP_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getPreconditionfailCount() <em>Preconditionfail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditionfailCount()
   * @generated
   * @ordered
   */
  protected static final int PRECONDITIONFAIL_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPreconditionfailCount() <em>Preconditionfail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditionfailCount()
   * @generated
   * @ordered
   */
  protected int preconditionfailCount = PRECONDITIONFAIL_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getValidationfailCount() <em>Validationfail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidationfailCount()
   * @generated
   * @ordered
   */
  protected static final int VALIDATIONFAIL_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getValidationfailCount() <em>Validationfail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidationfailCount()
   * @generated
   * @ordered
   */
  protected int validationfailCount = VALIDATIONFAIL_COUNT_EDEFAULT;

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
   * The default value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionTime()
   * @generated
   * @ordered
   */
  protected static final long EXECUTION_TIME_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionTime()
   * @generated
   * @ordered
   */
  protected long executionTime = EXECUTION_TIME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MetricsImpl()
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
    return AssurePackage.Literals.METRICS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTbdCount()
  {
    return tbdCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTbdCount(int newTbdCount)
  {
    int oldTbdCount = tbdCount;
    tbdCount = newTbdCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__TBD_COUNT, oldTbdCount, tbdCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__SUCCESS_COUNT, oldSuccessCount, successCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__FAIL_COUNT, oldFailCount, failCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTimeoutCount()
  {
    return timeoutCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeoutCount(int newTimeoutCount)
  {
    int oldTimeoutCount = timeoutCount;
    timeoutCount = newTimeoutCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__TIMEOUT_COUNT, oldTimeoutCount, timeoutCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__ERROR_COUNT, oldErrorCount, errorCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDidelseCount()
  {
    return didelseCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDidelseCount(int newDidelseCount)
  {
    int oldDidelseCount = didelseCount;
    didelseCount = newDidelseCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__DIDELSE_COUNT, oldDidelseCount, didelseCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getThenskipCount()
  {
    return thenskipCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenskipCount(int newThenskipCount)
  {
    int oldThenskipCount = thenskipCount;
    thenskipCount = newThenskipCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__THENSKIP_COUNT, oldThenskipCount, thenskipCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPreconditionfailCount()
  {
    return preconditionfailCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreconditionfailCount(int newPreconditionfailCount)
  {
    int oldPreconditionfailCount = preconditionfailCount;
    preconditionfailCount = newPreconditionfailCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__PRECONDITIONFAIL_COUNT, oldPreconditionfailCount, preconditionfailCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValidationfailCount()
  {
    return validationfailCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidationfailCount(int newValidationfailCount)
  {
    int oldValidationfailCount = validationfailCount;
    validationfailCount = newValidationfailCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__VALIDATIONFAIL_COUNT, oldValidationfailCount, validationfailCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__WEIGHT, oldWeight, weight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getExecutionTime()
  {
    return executionTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecutionTime(long newExecutionTime)
  {
    long oldExecutionTime = executionTime;
    executionTime = newExecutionTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__EXECUTION_TIME, oldExecutionTime, executionTime));
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
      case AssurePackage.METRICS__TBD_COUNT:
        return getTbdCount();
      case AssurePackage.METRICS__SUCCESS_COUNT:
        return getSuccessCount();
      case AssurePackage.METRICS__FAIL_COUNT:
        return getFailCount();
      case AssurePackage.METRICS__TIMEOUT_COUNT:
        return getTimeoutCount();
      case AssurePackage.METRICS__ERROR_COUNT:
        return getErrorCount();
      case AssurePackage.METRICS__DIDELSE_COUNT:
        return getDidelseCount();
      case AssurePackage.METRICS__THENSKIP_COUNT:
        return getThenskipCount();
      case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
        return getPreconditionfailCount();
      case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
        return getValidationfailCount();
      case AssurePackage.METRICS__WEIGHT:
        return getWeight();
      case AssurePackage.METRICS__EXECUTION_TIME:
        return getExecutionTime();
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
      case AssurePackage.METRICS__TBD_COUNT:
        setTbdCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__SUCCESS_COUNT:
        setSuccessCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__FAIL_COUNT:
        setFailCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__TIMEOUT_COUNT:
        setTimeoutCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__ERROR_COUNT:
        setErrorCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__DIDELSE_COUNT:
        setDidelseCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__THENSKIP_COUNT:
        setThenskipCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
        setPreconditionfailCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
        setValidationfailCount((Integer)newValue);
        return;
      case AssurePackage.METRICS__WEIGHT:
        setWeight((Integer)newValue);
        return;
      case AssurePackage.METRICS__EXECUTION_TIME:
        setExecutionTime((Long)newValue);
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
      case AssurePackage.METRICS__TBD_COUNT:
        setTbdCount(TBD_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__SUCCESS_COUNT:
        setSuccessCount(SUCCESS_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__FAIL_COUNT:
        setFailCount(FAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__TIMEOUT_COUNT:
        setTimeoutCount(TIMEOUT_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__ERROR_COUNT:
        setErrorCount(ERROR_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__DIDELSE_COUNT:
        setDidelseCount(DIDELSE_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__THENSKIP_COUNT:
        setThenskipCount(THENSKIP_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
        setPreconditionfailCount(PRECONDITIONFAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
        setValidationfailCount(VALIDATIONFAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.METRICS__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
        return;
      case AssurePackage.METRICS__EXECUTION_TIME:
        setExecutionTime(EXECUTION_TIME_EDEFAULT);
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
      case AssurePackage.METRICS__TBD_COUNT:
        return tbdCount != TBD_COUNT_EDEFAULT;
      case AssurePackage.METRICS__SUCCESS_COUNT:
        return successCount != SUCCESS_COUNT_EDEFAULT;
      case AssurePackage.METRICS__FAIL_COUNT:
        return failCount != FAIL_COUNT_EDEFAULT;
      case AssurePackage.METRICS__TIMEOUT_COUNT:
        return timeoutCount != TIMEOUT_COUNT_EDEFAULT;
      case AssurePackage.METRICS__ERROR_COUNT:
        return errorCount != ERROR_COUNT_EDEFAULT;
      case AssurePackage.METRICS__DIDELSE_COUNT:
        return didelseCount != DIDELSE_COUNT_EDEFAULT;
      case AssurePackage.METRICS__THENSKIP_COUNT:
        return thenskipCount != THENSKIP_COUNT_EDEFAULT;
      case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
        return preconditionfailCount != PRECONDITIONFAIL_COUNT_EDEFAULT;
      case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
        return validationfailCount != VALIDATIONFAIL_COUNT_EDEFAULT;
      case AssurePackage.METRICS__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
      case AssurePackage.METRICS__EXECUTION_TIME:
        return executionTime != EXECUTION_TIME_EDEFAULT;
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
    result.append(" (tbdCount: ");
    result.append(tbdCount);
    result.append(", successCount: ");
    result.append(successCount);
    result.append(", failCount: ");
    result.append(failCount);
    result.append(", timeoutCount: ");
    result.append(timeoutCount);
    result.append(", errorCount: ");
    result.append(errorCount);
    result.append(", didelseCount: ");
    result.append(didelseCount);
    result.append(", thenskipCount: ");
    result.append(thenskipCount);
    result.append(", preconditionfailCount: ");
    result.append(preconditionfailCount);
    result.append(", validationfailCount: ");
    result.append(validationfailCount);
    result.append(", weight: ");
    result.append(weight);
    result.append(", executionTime: ");
    result.append(executionTime);
    result.append(')');
    return result.toString();
  }

} //MetricsImpl
