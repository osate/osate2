/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl#getTypeSet <em>Type Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl#getEventcondition <em>Eventcondition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorEventImpl extends ErrorBehaviorEventImpl implements ErrorEvent
{
  /**
   * The cached value of the '{@link #getTypeSet() <em>Type Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeSet()
   * @generated
   * @ordered
   */
  protected TypeSet typeSet;

  /**
   * The default value of the '{@link #getEventcondition() <em>Eventcondition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventcondition()
   * @generated
   * @ordered
   */
  protected static final String EVENTCONDITION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEventcondition() <em>Eventcondition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventcondition()
   * @generated
   * @ordered
   */
  protected String eventcondition = EVENTCONDITION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorEventImpl()
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
    return ErrorModelPackage.Literals.ERROR_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTypeSet()
  {
    return typeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeSet(TypeSet newTypeSet, NotificationChain msgs)
  {
    TypeSet oldTypeSet = typeSet;
    typeSet = newTypeSet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__TYPE_SET, oldTypeSet, newTypeSet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeSet(TypeSet newTypeSet)
  {
    if (newTypeSet != typeSet)
    {
      NotificationChain msgs = null;
      if (typeSet != null)
        msgs = ((InternalEObject)typeSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_EVENT__TYPE_SET, null, msgs);
      if (newTypeSet != null)
        msgs = ((InternalEObject)newTypeSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_EVENT__TYPE_SET, null, msgs);
      msgs = basicSetTypeSet(newTypeSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__TYPE_SET, newTypeSet, newTypeSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEventcondition()
  {
    return eventcondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEventcondition(String newEventcondition)
  {
    String oldEventcondition = eventcondition;
    eventcondition = newEventcondition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__EVENTCONDITION, oldEventcondition, eventcondition));
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        return basicSetTypeSet(null, msgs);
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        return getTypeSet();
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        return getEventcondition();
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        setTypeSet((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        setEventcondition((String)newValue);
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        setTypeSet((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        setEventcondition(EVENTCONDITION_EDEFAULT);
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        return typeSet != null;
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        return EVENTCONDITION_EDEFAULT == null ? eventcondition != null : !EVENTCONDITION_EDEFAULT.equals(eventcondition);
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
    result.append(" (eventcondition: ");
    result.append(eventcondition);
    result.append(')');
    return result.toString();
  }

} //ErrorEventImpl
