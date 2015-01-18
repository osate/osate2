/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AggregateResult;
import org.osate.assure.assure.AssurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultImpl#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultImpl#getTbdCount <em>Tbd Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AggregateResultImpl#getSucessMsg <em>Sucess Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregateResultImpl extends MinimalEObjectImpl.Container implements AggregateResult
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AggregateResultImpl()
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
    return AssurePackage.Literals.AGGREGATE_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT__FAIL_COUNT, oldFailCount, failCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT__UNKNOWN_COUNT, oldUnknownCount, unknownCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT__TBD_COUNT, oldTbdCount, tbdCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT__WEIGHT, oldWeight, weight));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.AGGREGATE_RESULT__SUCESS_MSG, oldSucessMsg, sucessMsg));
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
      case AssurePackage.AGGREGATE_RESULT__NAME:
        return getName();
      case AssurePackage.AGGREGATE_RESULT__FAIL_COUNT:
        return getFailCount();
      case AssurePackage.AGGREGATE_RESULT__UNKNOWN_COUNT:
        return getUnknownCount();
      case AssurePackage.AGGREGATE_RESULT__TBD_COUNT:
        return getTbdCount();
      case AssurePackage.AGGREGATE_RESULT__WEIGHT:
        return getWeight();
      case AssurePackage.AGGREGATE_RESULT__SUCESS_MSG:
        return getSucessMsg();
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
      case AssurePackage.AGGREGATE_RESULT__NAME:
        setName((String)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT__FAIL_COUNT:
        setFailCount((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT__UNKNOWN_COUNT:
        setUnknownCount((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT__TBD_COUNT:
        setTbdCount((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT__WEIGHT:
        setWeight((Integer)newValue);
        return;
      case AssurePackage.AGGREGATE_RESULT__SUCESS_MSG:
        setSucessMsg((String)newValue);
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
      case AssurePackage.AGGREGATE_RESULT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT__FAIL_COUNT:
        setFailCount(FAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT__UNKNOWN_COUNT:
        setUnknownCount(UNKNOWN_COUNT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT__TBD_COUNT:
        setTbdCount(TBD_COUNT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
        return;
      case AssurePackage.AGGREGATE_RESULT__SUCESS_MSG:
        setSucessMsg(SUCESS_MSG_EDEFAULT);
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
      case AssurePackage.AGGREGATE_RESULT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AssurePackage.AGGREGATE_RESULT__FAIL_COUNT:
        return failCount != FAIL_COUNT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT__UNKNOWN_COUNT:
        return unknownCount != UNKNOWN_COUNT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT__TBD_COUNT:
        return tbdCount != TBD_COUNT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
      case AssurePackage.AGGREGATE_RESULT__SUCESS_MSG:
        return SUCESS_MSG_EDEFAULT == null ? sucessMsg != null : !SUCESS_MSG_EDEFAULT.equals(sucessMsg);
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
    result.append(" (name: ");
    result.append(name);
    result.append(", failCount: ");
    result.append(failCount);
    result.append(", unknownCount: ");
    result.append(unknownCount);
    result.append(", tbdCount: ");
    result.append(tbdCount);
    result.append(", weight: ");
    result.append(weight);
    result.append(", sucessMsg: ");
    result.append(sucessMsg);
    result.append(')');
    return result.toString();
  }

} //AggregateResultImpl
