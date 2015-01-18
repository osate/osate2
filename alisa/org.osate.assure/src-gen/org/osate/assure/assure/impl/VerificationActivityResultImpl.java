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

import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationResult;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Activity Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getAssumptionResult <em>Assumption Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getPreconditionResult <em>Precondition Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationActivityResultImpl#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationActivityResultImpl extends MinimalEObjectImpl.Container implements VerificationActivityResult
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
  protected VerificationActivity target;

  /**
   * The default value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionState()
   * @generated
   * @ordered
   */
  protected static final VerificationExecutionState EXECUTION_STATE_EDEFAULT = VerificationExecutionState.TODO;

  /**
   * The cached value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionState()
   * @generated
   * @ordered
   */
  protected VerificationExecutionState executionState = EXECUTION_STATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected VerificationResult result;

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
   * The cached value of the '{@link #getAssumptionResult() <em>Assumption Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssumptionResult()
   * @generated
   * @ordered
   */
  protected EList<AssumptionResult> assumptionResult;

  /**
   * The cached value of the '{@link #getPreconditionResult() <em>Precondition Result</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditionResult()
   * @generated
   * @ordered
   */
  protected EList<PreconditionResult> preconditionResult;

  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected EList<VerificationActivityResult> first;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected EList<VerificationActivityResult> second;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationActivityResultImpl()
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
    return AssurePackage.Literals.VERIFICATION_ACTIVITY_RESULT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (VerificationActivity)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_ACTIVITY_RESULT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationActivity basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(VerificationActivity newTarget)
  {
    VerificationActivity oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationExecutionState getExecutionState()
  {
    return executionState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecutionState(VerificationExecutionState newExecutionState)
  {
    VerificationExecutionState oldExecutionState = executionState;
    executionState = newExecutionState == null ? EXECUTION_STATE_EDEFAULT : newExecutionState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE, oldExecutionState, executionState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationResult getResult()
  {
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResult(VerificationResult newResult, NotificationChain msgs)
  {
    VerificationResult oldResult = result;
    result = newResult;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT, oldResult, newResult);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResult(VerificationResult newResult)
  {
    if (newResult != result)
    {
      NotificationChain msgs = null;
      if (result != null)
        msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT, null, msgs);
      if (newResult != null)
        msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT, null, msgs);
      msgs = basicSetResult(newResult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT, newResult, newResult));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__WEIGHT, oldWeight, weight));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG, oldSucessMsg, sucessMsg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssumptionResult> getAssumptionResult()
  {
    if (assumptionResult == null)
    {
      assumptionResult = new EObjectContainmentEList<AssumptionResult>(AssumptionResult.class, this, AssurePackage.VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT);
    }
    return assumptionResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PreconditionResult> getPreconditionResult()
  {
    if (preconditionResult == null)
    {
      preconditionResult = new EObjectContainmentEList<PreconditionResult>(PreconditionResult.class, this, AssurePackage.VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT);
    }
    return preconditionResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationActivityResult> getFirst()
  {
    if (first == null)
    {
      first = new EObjectContainmentEList<VerificationActivityResult>(VerificationActivityResult.class, this, AssurePackage.VERIFICATION_ACTIVITY_RESULT__FIRST);
    }
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationActivityResult> getSecond()
  {
    if (second == null)
    {
      second = new EObjectContainmentEList<VerificationActivityResult>(VerificationActivityResult.class, this, AssurePackage.VERIFICATION_ACTIVITY_RESULT__SECOND);
    }
    return second;
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
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT:
        return basicSetResult(null, msgs);
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT:
        return ((InternalEList<?>)getAssumptionResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT:
        return ((InternalEList<?>)getPreconditionResult()).basicRemove(otherEnd, msgs);
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__FIRST:
        return ((InternalEList<?>)getFirst()).basicRemove(otherEnd, msgs);
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SECOND:
        return ((InternalEList<?>)getSecond()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__NAME:
        return getName();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE:
        return getExecutionState();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT:
        return getResult();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__WEIGHT:
        return getWeight();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG:
        return getSucessMsg();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT:
        return getAssumptionResult();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT:
        return getPreconditionResult();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__FIRST:
        return getFirst();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SECOND:
        return getSecond();
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
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__NAME:
        setName((String)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__TARGET:
        setTarget((VerificationActivity)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE:
        setExecutionState((VerificationExecutionState)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT:
        setResult((VerificationResult)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__WEIGHT:
        setWeight((Integer)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG:
        setSucessMsg((String)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT:
        getAssumptionResult().clear();
        getAssumptionResult().addAll((Collection<? extends AssumptionResult>)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT:
        getPreconditionResult().clear();
        getPreconditionResult().addAll((Collection<? extends PreconditionResult>)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__FIRST:
        getFirst().clear();
        getFirst().addAll((Collection<? extends VerificationActivityResult>)newValue);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SECOND:
        getSecond().clear();
        getSecond().addAll((Collection<? extends VerificationActivityResult>)newValue);
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
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__TARGET:
        setTarget((VerificationActivity)null);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE:
        setExecutionState(EXECUTION_STATE_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT:
        setResult((VerificationResult)null);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG:
        setSucessMsg(SUCESS_MSG_EDEFAULT);
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT:
        getAssumptionResult().clear();
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT:
        getPreconditionResult().clear();
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__FIRST:
        getFirst().clear();
        return;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SECOND:
        getSecond().clear();
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
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__TARGET:
        return target != null;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE:
        return executionState != EXECUTION_STATE_EDEFAULT;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__RESULT:
        return result != null;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG:
        return SUCESS_MSG_EDEFAULT == null ? sucessMsg != null : !SUCESS_MSG_EDEFAULT.equals(sucessMsg);
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT:
        return assumptionResult != null && !assumptionResult.isEmpty();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT:
        return preconditionResult != null && !preconditionResult.isEmpty();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__FIRST:
        return first != null && !first.isEmpty();
      case AssurePackage.VERIFICATION_ACTIVITY_RESULT__SECOND:
        return second != null && !second.isEmpty();
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
    result.append(", executionState: ");
    result.append(executionState);
    result.append(", weight: ");
    result.append(weight);
    result.append(", sucessMsg: ");
    result.append(sucessMsg);
    result.append(')');
    return result.toString();
  }

} //VerificationActivityResultImpl
