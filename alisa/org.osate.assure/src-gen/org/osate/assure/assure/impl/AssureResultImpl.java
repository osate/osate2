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
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getFailthenCount <em>Failthen Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getAndthenCount <em>Andthen Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AssureResultImpl#getTbdCount <em>Tbd Count</em>}</li>
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
   * The default value of the '{@link #getAndthenCount() <em>Andthen Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndthenCount()
   * @generated
   * @ordered
   */
  protected static final int ANDTHEN_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getAndthenCount() <em>Andthen Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndthenCount()
   * @generated
   * @ordered
   */
  protected int andthenCount = ANDTHEN_COUNT_EDEFAULT;

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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__UNKNOWN_COUNT, oldUnknownCount, unknownCount));
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
  public int getAndthenCount()
  {
    return andthenCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAndthenCount(int newAndthenCount)
  {
    int oldAndthenCount = andthenCount;
    andthenCount = newAndthenCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__ANDTHEN_COUNT, oldAndthenCount, andthenCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ASSURE_RESULT__TBD_COUNT, oldTbdCount, tbdCount));
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
      case AssurePackage.ASSURE_RESULT__UNKNOWN_COUNT:
        return getUnknownCount();
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        return getFailthenCount();
      case AssurePackage.ASSURE_RESULT__ANDTHEN_COUNT:
        return getAndthenCount();
      case AssurePackage.ASSURE_RESULT__TBD_COUNT:
        return getTbdCount();
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
      case AssurePackage.ASSURE_RESULT__UNKNOWN_COUNT:
        setUnknownCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        setFailthenCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__ANDTHEN_COUNT:
        setAndthenCount((Integer)newValue);
        return;
      case AssurePackage.ASSURE_RESULT__TBD_COUNT:
        setTbdCount((Integer)newValue);
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
      case AssurePackage.ASSURE_RESULT__UNKNOWN_COUNT:
        setUnknownCount(UNKNOWN_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        setFailthenCount(FAILTHEN_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__ANDTHEN_COUNT:
        setAndthenCount(ANDTHEN_COUNT_EDEFAULT);
        return;
      case AssurePackage.ASSURE_RESULT__TBD_COUNT:
        setTbdCount(TBD_COUNT_EDEFAULT);
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
      case AssurePackage.ASSURE_RESULT__UNKNOWN_COUNT:
        return unknownCount != UNKNOWN_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__FAILTHEN_COUNT:
        return failthenCount != FAILTHEN_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__ANDTHEN_COUNT:
        return andthenCount != ANDTHEN_COUNT_EDEFAULT;
      case AssurePackage.ASSURE_RESULT__TBD_COUNT:
        return tbdCount != TBD_COUNT_EDEFAULT;
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
    result.append(", unknownCount: ");
    result.append(unknownCount);
    result.append(", failthenCount: ");
    result.append(failthenCount);
    result.append(", andthenCount: ");
    result.append(andthenCount);
    result.append(", tbdCount: ");
    result.append(tbdCount);
    result.append(", weight: ");
    result.append(weight);
    result.append(')');
    return result.toString();
  }

} //AssureResultImpl
