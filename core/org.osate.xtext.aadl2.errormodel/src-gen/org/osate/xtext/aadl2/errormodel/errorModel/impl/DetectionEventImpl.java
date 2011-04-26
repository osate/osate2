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

import org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Detection Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl#isSelf <em>Self</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl#getEventPort <em>Event Port</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DetectionEventImpl extends MinimalEObjectImpl.Container implements DetectionEvent
{
  /**
   * The default value of the '{@link #isSelf() <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelf()
   * @generated
   * @ordered
   */
  protected static final boolean SELF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSelf() <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelf()
   * @generated
   * @ordered
   */
  protected boolean self = SELF_EDEFAULT;

  /**
   * The cached value of the '{@link #getEventPort() <em>Event Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventPort()
   * @generated
   * @ordered
   */
  protected Feature eventPort;

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
  protected DetectionEventImpl()
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
    return ErrorModelPackage.Literals.DETECTION_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSelf()
  {
    return self;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelf(boolean newSelf)
  {
    boolean oldSelf = self;
    self = newSelf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.DETECTION_EVENT__SELF, oldSelf, self));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getEventPort()
  {
    if (eventPort != null && eventPort.eIsProxy())
    {
      InternalEObject oldEventPort = (InternalEObject)eventPort;
      eventPort = (Feature)eResolveProxy(oldEventPort);
      if (eventPort != oldEventPort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.DETECTION_EVENT__EVENT_PORT, oldEventPort, eventPort));
      }
    }
    return eventPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetEventPort()
  {
    return eventPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEventPort(Feature newEventPort)
  {
    Feature oldEventPort = eventPort;
    eventPort = newEventPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.DETECTION_EVENT__EVENT_PORT, oldEventPort, eventPort));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.DETECTION_EVENT__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.DETECTION_EVENT__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.DETECTION_EVENT__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.DETECTION_EVENT__CONDITION, newCondition, newCondition));
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
      case ErrorModelPackage.DETECTION_EVENT__CONDITION:
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
      case ErrorModelPackage.DETECTION_EVENT__SELF:
        return isSelf();
      case ErrorModelPackage.DETECTION_EVENT__EVENT_PORT:
        if (resolve) return getEventPort();
        return basicGetEventPort();
      case ErrorModelPackage.DETECTION_EVENT__CONDITION:
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
      case ErrorModelPackage.DETECTION_EVENT__SELF:
        setSelf((Boolean)newValue);
        return;
      case ErrorModelPackage.DETECTION_EVENT__EVENT_PORT:
        setEventPort((Feature)newValue);
        return;
      case ErrorModelPackage.DETECTION_EVENT__CONDITION:
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
      case ErrorModelPackage.DETECTION_EVENT__SELF:
        setSelf(SELF_EDEFAULT);
        return;
      case ErrorModelPackage.DETECTION_EVENT__EVENT_PORT:
        setEventPort((Feature)null);
        return;
      case ErrorModelPackage.DETECTION_EVENT__CONDITION:
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
      case ErrorModelPackage.DETECTION_EVENT__SELF:
        return self != SELF_EDEFAULT;
      case ErrorModelPackage.DETECTION_EVENT__EVENT_PORT:
        return eventPort != null;
      case ErrorModelPackage.DETECTION_EVENT__CONDITION:
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
    result.append(" (self: ");
    result.append(self);
    result.append(')');
    return result.toString();
  }

} //DetectionEventImpl
