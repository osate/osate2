/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AggregateResultData;
import org.osate.assure.assure.AssurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Result Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultDataImpl#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultDataImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultDataImpl#getNeutralCount <em>Neutral Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultDataImpl#getUnknownCount <em>Unknown Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregateResultDataImpl extends MinimalEObjectImpl.Container implements AggregateResultData
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AggregateResultDataImpl()
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
    return AssurePackage.Literals.AGGREGATE_RESULT_DATA;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT_DATA__PASS_COUNT, oldPassCount, passCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT_DATA__FAIL_COUNT, oldFailCount, failCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT, oldNeutralCount, neutralCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT, oldUnknownCount, unknownCount));
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
      case AssurePackage.AGGREGATE_RESULT_DATA__PASS_COUNT:
        return getPassCount();
      case AssurePackage.AGGREGATE_RESULT_DATA__FAIL_COUNT:
        return getFailCount();
      case AssurePackage.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT:
        return getNeutralCount();
      case AssurePackage.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT:
        return getUnknownCount();
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
      case AssurePackage.AGGREGATE_RESULT_DATA__PASS_COUNT:
        setPassCount((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT_DATA__FAIL_COUNT:
        setFailCount((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT:
        setNeutralCount((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT:
        setUnknownCount((Integer)newValue);
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
      case AssurePackage.AGGREGATE_RESULT_DATA__PASS_COUNT:
        setPassCount(PASS_COUNT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT_DATA__FAIL_COUNT:
        setFailCount(FAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT:
        setNeutralCount(NEUTRAL_COUNT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT:
        setUnknownCount(UNKNOWN_COUNT_EDEFAULT);
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
      case AssurePackage.AGGREGATE_RESULT_DATA__PASS_COUNT:
        return passCount != PASS_COUNT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT_DATA__FAIL_COUNT:
        return failCount != FAIL_COUNT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT_DATA__NEUTRAL_COUNT:
        return neutralCount != NEUTRAL_COUNT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT_DATA__UNKNOWN_COUNT:
        return unknownCount != UNKNOWN_COUNT_EDEFAULT;
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
    result.append(')');
    return result.toString();
  }

} //AggregateResultDataImpl
