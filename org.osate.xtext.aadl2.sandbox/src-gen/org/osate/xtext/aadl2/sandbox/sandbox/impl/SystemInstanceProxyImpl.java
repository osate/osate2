/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.SystemImplementation;

import org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Instance Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemInstanceProxyImpl#getInstanceRef <em>Instance Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemInstanceProxyImpl extends MinimalEObjectImpl.Container implements SystemInstanceProxy
{
  /**
   * The cached value of the '{@link #getInstanceRef() <em>Instance Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceRef()
   * @generated
   * @ordered
   */
  protected SystemImplementation instanceRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemInstanceProxyImpl()
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
    return SandboxPackage.Literals.SYSTEM_INSTANCE_PROXY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemImplementation getInstanceRef()
  {
    if (instanceRef != null && ((EObject)instanceRef).eIsProxy())
    {
      InternalEObject oldInstanceRef = (InternalEObject)instanceRef;
      instanceRef = (SystemImplementation)eResolveProxy(oldInstanceRef);
      if (instanceRef != oldInstanceRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SandboxPackage.SYSTEM_INSTANCE_PROXY__INSTANCE_REF, oldInstanceRef, instanceRef));
      }
    }
    return instanceRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemImplementation basicGetInstanceRef()
  {
    return instanceRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstanceRef(SystemImplementation newInstanceRef)
  {
    SystemImplementation oldInstanceRef = instanceRef;
    instanceRef = newInstanceRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SandboxPackage.SYSTEM_INSTANCE_PROXY__INSTANCE_REF, oldInstanceRef, instanceRef));
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
      case SandboxPackage.SYSTEM_INSTANCE_PROXY__INSTANCE_REF:
        if (resolve) return getInstanceRef();
        return basicGetInstanceRef();
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
      case SandboxPackage.SYSTEM_INSTANCE_PROXY__INSTANCE_REF:
        setInstanceRef((SystemImplementation)newValue);
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
      case SandboxPackage.SYSTEM_INSTANCE_PROXY__INSTANCE_REF:
        setInstanceRef((SystemImplementation)null);
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
      case SandboxPackage.SYSTEM_INSTANCE_PROXY__INSTANCE_REF:
        return instanceRef != null;
    }
    return super.eIsSet(featureID);
  }

} //SystemInstanceProxyImpl
