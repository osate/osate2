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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPathImpl extends ErrorFlowImpl implements ErrorPath
{
  /**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
  protected ErrorPropagationReference incoming;

  /**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected ErrorPropagationReference outgoing;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorPathImpl()
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
    return ErrorModelPackage.Literals.ERROR_PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagationReference getIncoming()
  {
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIncoming(ErrorPropagationReference newIncoming, NotificationChain msgs)
  {
    ErrorPropagationReference oldIncoming = incoming;
    incoming = newIncoming;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__INCOMING, oldIncoming, newIncoming);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncoming(ErrorPropagationReference newIncoming)
  {
    if (newIncoming != incoming)
    {
      NotificationChain msgs = null;
      if (incoming != null)
        msgs = ((InternalEObject)incoming).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PATH__INCOMING, null, msgs);
      if (newIncoming != null)
        msgs = ((InternalEObject)newIncoming).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PATH__INCOMING, null, msgs);
      msgs = basicSetIncoming(newIncoming, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__INCOMING, newIncoming, newIncoming));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagationReference getOutgoing()
  {
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutgoing(ErrorPropagationReference newOutgoing, NotificationChain msgs)
  {
    ErrorPropagationReference oldOutgoing = outgoing;
    outgoing = newOutgoing;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__OUTGOING, oldOutgoing, newOutgoing);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutgoing(ErrorPropagationReference newOutgoing)
  {
    if (newOutgoing != outgoing)
    {
      NotificationChain msgs = null;
      if (outgoing != null)
        msgs = ((InternalEObject)outgoing).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PATH__OUTGOING, null, msgs);
      if (newOutgoing != null)
        msgs = ((InternalEObject)newOutgoing).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PATH__OUTGOING, null, msgs);
      msgs = basicSetOutgoing(newOutgoing, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__OUTGOING, newOutgoing, newOutgoing));
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
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        return basicSetIncoming(null, msgs);
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        return basicSetOutgoing(null, msgs);
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
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        return getIncoming();
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        return getOutgoing();
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
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        setIncoming((ErrorPropagationReference)newValue);
        return;
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        setOutgoing((ErrorPropagationReference)newValue);
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
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        setIncoming((ErrorPropagationReference)null);
        return;
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        setOutgoing((ErrorPropagationReference)null);
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
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        return incoming != null;
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        return outgoing != null;
    }
    return super.eIsSet(featureID);
  }

} //ErrorPathImpl
