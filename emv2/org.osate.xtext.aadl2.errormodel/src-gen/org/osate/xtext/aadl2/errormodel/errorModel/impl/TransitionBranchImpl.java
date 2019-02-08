/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#isSteadyState <em>Steady State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionBranchImpl extends ElementImpl implements TransitionBranch
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState target;

  /**
   * The cached value of the '{@link #getTargetToken() <em>Target Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetToken()
   * @generated
   * @ordered
   */
  protected TypeSet targetToken;

  /**
   * The default value of the '{@link #isSteadyState() <em>Steady State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSteadyState()
   * @generated
   * @ordered
   */
  protected static final boolean STEADY_STATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSteadyState() <em>Steady State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSteadyState()
   * @generated
   * @ordered
   */
  protected boolean steadyState = STEADY_STATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected BranchValue value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionBranchImpl()
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
    return ErrorModelPackage.Literals.TRANSITION_BRANCH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ErrorBehaviorState)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.TRANSITION_BRANCH__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ErrorBehaviorState newTarget)
  {
    ErrorBehaviorState oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTargetToken()
  {
    return targetToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetToken(TypeSet newTargetToken, NotificationChain msgs)
  {
    TypeSet oldTargetToken = targetToken;
    targetToken = newTargetToken;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, oldTargetToken, newTargetToken);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetToken(TypeSet newTargetToken)
  {
    if (newTargetToken != targetToken)
    {
      NotificationChain msgs = null;
      if (targetToken != null)
        msgs = ((InternalEObject)targetToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, null, msgs);
      if (newTargetToken != null)
        msgs = ((InternalEObject)newTargetToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, null, msgs);
      msgs = basicSetTargetToken(newTargetToken, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, newTargetToken, newTargetToken));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSteadyState()
  {
    return steadyState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSteadyState(boolean newSteadyState)
  {
    boolean oldSteadyState = steadyState;
    steadyState = newSteadyState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__STEADY_STATE, oldSteadyState, steadyState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BranchValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(BranchValue newValue, NotificationChain msgs)
  {
    BranchValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(BranchValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_BRANCH__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_BRANCH__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__VALUE, newValue, newValue));
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
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
        return basicSetTargetToken(null, msgs);
      case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
        return basicSetValue(null, msgs);
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
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
        return getTargetToken();
      case ErrorModelPackage.TRANSITION_BRANCH__STEADY_STATE:
        return isSteadyState();
      case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
        return getValue();
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
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
        setTarget((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
        setTargetToken((TypeSet)newValue);
        return;
      case ErrorModelPackage.TRANSITION_BRANCH__STEADY_STATE:
        setSteadyState((Boolean)newValue);
        return;
      case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
        setValue((BranchValue)newValue);
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
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
        setTarget((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
        setTargetToken((TypeSet)null);
        return;
      case ErrorModelPackage.TRANSITION_BRANCH__STEADY_STATE:
        setSteadyState(STEADY_STATE_EDEFAULT);
        return;
      case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
        setValue((BranchValue)null);
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
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
        return target != null;
      case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
        return targetToken != null;
      case ErrorModelPackage.TRANSITION_BRANCH__STEADY_STATE:
        return steadyState != STEADY_STATE_EDEFAULT;
      case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
        return value != null;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (steadyState: ");
    result.append(steadyState);
    result.append(')');
    return result.toString();
  }

} //TransitionBranchImpl
