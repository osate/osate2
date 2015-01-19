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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationActivityResult;

import org.osate.verify.verify.VerificationPrecondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precondition Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getTbdCount <em>Tbd Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.PreconditionResultImpl#getVerificationResult <em>Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreconditionResultImpl extends MinimalEObjectImpl.Container implements PreconditionResult
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
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected VerificationPrecondition target;

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
   * The cached value of the '{@link #getVerificationResult() <em>Verification Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationResult()
   * @generated
   * @ordered
   */
  protected EList<VerificationActivityResult> verificationResult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PreconditionResultImpl()
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
    return AssurePackage.Literals.PRECONDITION_RESULT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPrecondition getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (VerificationPrecondition)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.PRECONDITION_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationPrecondition basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(VerificationPrecondition newTarget)
  {
    VerificationPrecondition oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__SUCCESS_COUNT, oldSuccessCount, successCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__FAIL_COUNT, oldFailCount, failCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__UNKNOWN_COUNT, oldUnknownCount, unknownCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__TBD_COUNT, oldTbdCount, tbdCount));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__WEIGHT, oldWeight, weight));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.PRECONDITION_RESULT__SUCESS_MSG, oldSucessMsg, sucessMsg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationActivityResult> getVerificationResult()
  {
    if (verificationResult == null)
    {
      verificationResult = new EObjectContainmentEList<VerificationActivityResult>(VerificationActivityResult.class, this, AssurePackage.PRECONDITION_RESULT__VERIFICATION_RESULT);
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
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_RESULT:
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
      case AssurePackage.PRECONDITION_RESULT__NAME:
        return getName();
      case AssurePackage.PRECONDITION_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.PRECONDITION_RESULT__SUCCESS_COUNT:
        return getSuccessCount();
      case AssurePackage.PRECONDITION_RESULT__FAIL_COUNT:
        return getFailCount();
      case AssurePackage.PRECONDITION_RESULT__UNKNOWN_COUNT:
        return getUnknownCount();
      case AssurePackage.PRECONDITION_RESULT__TBD_COUNT:
        return getTbdCount();
      case AssurePackage.PRECONDITION_RESULT__WEIGHT:
        return getWeight();
      case AssurePackage.PRECONDITION_RESULT__SUCESS_MSG:
        return getSucessMsg();
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_RESULT:
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
      case AssurePackage.PRECONDITION_RESULT__NAME:
        setName((String)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__TARGET:
        setTarget((VerificationPrecondition)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__SUCCESS_COUNT:
        setSuccessCount((Integer)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__FAIL_COUNT:
        setFailCount((Integer)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__UNKNOWN_COUNT:
        setUnknownCount((Integer)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__TBD_COUNT:
        setTbdCount((Integer)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__WEIGHT:
        setWeight((Integer)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__SUCESS_MSG:
        setSucessMsg((String)newValue);
        return;
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_RESULT:
        getVerificationResult().clear();
        getVerificationResult().addAll((Collection<? extends VerificationActivityResult>)newValue);
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
      case AssurePackage.PRECONDITION_RESULT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__TARGET:
        setTarget((VerificationPrecondition)null);
        return;
      case AssurePackage.PRECONDITION_RESULT__SUCCESS_COUNT:
        setSuccessCount(SUCCESS_COUNT_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__FAIL_COUNT:
        setFailCount(FAIL_COUNT_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__UNKNOWN_COUNT:
        setUnknownCount(UNKNOWN_COUNT_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__TBD_COUNT:
        setTbdCount(TBD_COUNT_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__SUCESS_MSG:
        setSucessMsg(SUCESS_MSG_EDEFAULT);
        return;
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_RESULT:
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
      case AssurePackage.PRECONDITION_RESULT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AssurePackage.PRECONDITION_RESULT__TARGET:
        return target != null;
      case AssurePackage.PRECONDITION_RESULT__SUCCESS_COUNT:
        return successCount != SUCCESS_COUNT_EDEFAULT;
      case AssurePackage.PRECONDITION_RESULT__FAIL_COUNT:
        return failCount != FAIL_COUNT_EDEFAULT;
      case AssurePackage.PRECONDITION_RESULT__UNKNOWN_COUNT:
        return unknownCount != UNKNOWN_COUNT_EDEFAULT;
      case AssurePackage.PRECONDITION_RESULT__TBD_COUNT:
        return tbdCount != TBD_COUNT_EDEFAULT;
      case AssurePackage.PRECONDITION_RESULT__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
      case AssurePackage.PRECONDITION_RESULT__SUCESS_MSG:
        return SUCESS_MSG_EDEFAULT == null ? sucessMsg != null : !SUCESS_MSG_EDEFAULT.equals(sucessMsg);
      case AssurePackage.PRECONDITION_RESULT__VERIFICATION_RESULT:
        return verificationResult != null && !verificationResult.isEmpty();
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
    result.append(", successCount: ");
    result.append(successCount);
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

} //PreconditionResultImpl
