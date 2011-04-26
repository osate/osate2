/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Propagation Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl#getOutPropagation <em>Out Propagation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl#isWorking <em>Working</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropagationConditionImpl extends MinimalEObjectImpl.Container implements PropagationCondition
{
  /**
   * The cached value of the '{@link #getOutPropagation() <em>Out Propagation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutPropagation()
   * @generated
   * @ordered
   */
  protected ErrorPropagation outPropagation;

  /**
   * The default value of the '{@link #isMask() <em>Mask</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMask()
   * @generated
   * @ordered
   */
  protected static final boolean MASK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMask() <em>Mask</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMask()
   * @generated
   * @ordered
   */
  protected boolean mask = MASK_EDEFAULT;

  /**
   * The default value of the '{@link #isWorking() <em>Working</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWorking()
   * @generated
   * @ordered
   */
  protected static final boolean WORKING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWorking() <em>Working</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWorking()
   * @generated
   * @ordered
   */
  protected boolean working = WORKING_EDEFAULT;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState state;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected TriggerConditionExpression condition;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected EList<Feature> feature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropagationConditionImpl()
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
    return ErrorModelPackage.Literals.PROPAGATION_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation getOutPropagation()
  {
    if (outPropagation != null && outPropagation.eIsProxy())
    {
      InternalEObject oldOutPropagation = (InternalEObject)outPropagation;
      outPropagation = (ErrorPropagation)eResolveProxy(oldOutPropagation);
      if (outPropagation != oldOutPropagation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.PROPAGATION_CONDITION__OUT_PROPAGATION, oldOutPropagation, outPropagation));
      }
    }
    return outPropagation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation basicGetOutPropagation()
  {
    return outPropagation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutPropagation(ErrorPropagation newOutPropagation)
  {
    ErrorPropagation oldOutPropagation = outPropagation;
    outPropagation = newOutPropagation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.PROPAGATION_CONDITION__OUT_PROPAGATION, oldOutPropagation, outPropagation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMask()
  {
    return mask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMask(boolean newMask)
  {
    boolean oldMask = mask;
    mask = newMask;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.PROPAGATION_CONDITION__MASK, oldMask, mask));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWorking()
  {
    return working;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorking(boolean newWorking)
  {
    boolean oldWorking = working;
    working = newWorking;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.PROPAGATION_CONDITION__WORKING, oldWorking, working));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (ErrorBehaviorState)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.PROPAGATION_CONDITION__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(ErrorBehaviorState newState)
  {
    ErrorBehaviorState oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.PROPAGATION_CONDITION__STATE, oldState, state));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerConditionExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(TriggerConditionExpression newCondition, NotificationChain msgs)
  {
    TriggerConditionExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.PROPAGATION_CONDITION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(TriggerConditionExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.PROPAGATION_CONDITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.PROPAGATION_CONDITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.PROPAGATION_CONDITION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeature()
  {
    if (feature == null)
    {
      feature = new EObjectResolvingEList<Feature>(Feature.class, this, ErrorModelPackage.PROPAGATION_CONDITION__FEATURE);
    }
    return feature;
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
      case ErrorModelPackage.PROPAGATION_CONDITION__CONDITION:
        return basicSetCondition(null, msgs);
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
      case ErrorModelPackage.PROPAGATION_CONDITION__OUT_PROPAGATION:
        if (resolve) return getOutPropagation();
        return basicGetOutPropagation();
      case ErrorModelPackage.PROPAGATION_CONDITION__MASK:
        return isMask();
      case ErrorModelPackage.PROPAGATION_CONDITION__WORKING:
        return isWorking();
      case ErrorModelPackage.PROPAGATION_CONDITION__STATE:
        if (resolve) return getState();
        return basicGetState();
      case ErrorModelPackage.PROPAGATION_CONDITION__CONDITION:
        return getCondition();
      case ErrorModelPackage.PROPAGATION_CONDITION__FEATURE:
        return getFeature();
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
      case ErrorModelPackage.PROPAGATION_CONDITION__OUT_PROPAGATION:
        setOutPropagation((ErrorPropagation)newValue);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__MASK:
        setMask((Boolean)newValue);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__WORKING:
        setWorking((Boolean)newValue);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__STATE:
        setState((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__CONDITION:
        setCondition((TriggerConditionExpression)newValue);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__FEATURE:
        getFeature().clear();
        getFeature().addAll((Collection<? extends Feature>)newValue);
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
      case ErrorModelPackage.PROPAGATION_CONDITION__OUT_PROPAGATION:
        setOutPropagation((ErrorPropagation)null);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__MASK:
        setMask(MASK_EDEFAULT);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__WORKING:
        setWorking(WORKING_EDEFAULT);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__STATE:
        setState((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__CONDITION:
        setCondition((TriggerConditionExpression)null);
        return;
      case ErrorModelPackage.PROPAGATION_CONDITION__FEATURE:
        getFeature().clear();
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
      case ErrorModelPackage.PROPAGATION_CONDITION__OUT_PROPAGATION:
        return outPropagation != null;
      case ErrorModelPackage.PROPAGATION_CONDITION__MASK:
        return mask != MASK_EDEFAULT;
      case ErrorModelPackage.PROPAGATION_CONDITION__WORKING:
        return working != WORKING_EDEFAULT;
      case ErrorModelPackage.PROPAGATION_CONDITION__STATE:
        return state != null;
      case ErrorModelPackage.PROPAGATION_CONDITION__CONDITION:
        return condition != null;
      case ErrorModelPackage.PROPAGATION_CONDITION__FEATURE:
        return feature != null && !feature.isEmpty();
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
    result.append(" (mask: ");
    result.append(mask);
    result.append(", working: ");
    result.append(working);
    result.append(')');
    return result.toString();
  }

} //PropagationConditionImpl
