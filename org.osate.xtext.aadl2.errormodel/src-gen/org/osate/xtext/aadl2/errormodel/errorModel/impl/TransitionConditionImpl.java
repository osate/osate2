/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl#getErrorTransition <em>Error Transition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionConditionImpl extends MinimalEObjectImpl.Container implements TransitionCondition
{
  /**
   * The cached value of the '{@link #getErrorTransition() <em>Error Transition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorTransition()
   * @generated
   * @ordered
   */
  protected TriggeredTransition errorTransition;

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
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected TriggerConditionExpression condition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionConditionImpl()
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
    return ErrorModelPackage.Literals.TRANSITION_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggeredTransition getErrorTransition()
  {
    if (errorTransition != null && errorTransition.eIsProxy())
    {
      InternalEObject oldErrorTransition = (InternalEObject)errorTransition;
      errorTransition = (TriggeredTransition)eResolveProxy(oldErrorTransition);
      if (errorTransition != oldErrorTransition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.TRANSITION_CONDITION__ERROR_TRANSITION, oldErrorTransition, errorTransition));
      }
    }
    return errorTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggeredTransition basicGetErrorTransition()
  {
    return errorTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorTransition(TriggeredTransition newErrorTransition)
  {
    TriggeredTransition oldErrorTransition = errorTransition;
    errorTransition = newErrorTransition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_CONDITION__ERROR_TRANSITION, oldErrorTransition, errorTransition));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_CONDITION__MASK, oldMask, mask));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_CONDITION__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_CONDITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_CONDITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_CONDITION__CONDITION, newCondition, newCondition));
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
      case ErrorModelPackage.TRANSITION_CONDITION__CONDITION:
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
      case ErrorModelPackage.TRANSITION_CONDITION__ERROR_TRANSITION:
        if (resolve) return getErrorTransition();
        return basicGetErrorTransition();
      case ErrorModelPackage.TRANSITION_CONDITION__MASK:
        return isMask();
      case ErrorModelPackage.TRANSITION_CONDITION__CONDITION:
        return getCondition();
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
      case ErrorModelPackage.TRANSITION_CONDITION__ERROR_TRANSITION:
        setErrorTransition((TriggeredTransition)newValue);
        return;
      case ErrorModelPackage.TRANSITION_CONDITION__MASK:
        setMask((Boolean)newValue);
        return;
      case ErrorModelPackage.TRANSITION_CONDITION__CONDITION:
        setCondition((TriggerConditionExpression)newValue);
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
      case ErrorModelPackage.TRANSITION_CONDITION__ERROR_TRANSITION:
        setErrorTransition((TriggeredTransition)null);
        return;
      case ErrorModelPackage.TRANSITION_CONDITION__MASK:
        setMask(MASK_EDEFAULT);
        return;
      case ErrorModelPackage.TRANSITION_CONDITION__CONDITION:
        setCondition((TriggerConditionExpression)null);
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
      case ErrorModelPackage.TRANSITION_CONDITION__ERROR_TRANSITION:
        return errorTransition != null;
      case ErrorModelPackage.TRANSITION_CONDITION__MASK:
        return mask != MASK_EDEFAULT;
      case ErrorModelPackage.TRANSITION_CONDITION__CONDITION:
        return condition != null;
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
    result.append(')');
    return result.toString();
  }

} //TransitionConditionImpl
