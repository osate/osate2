/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl#getSystemImplementation <em>System Implementation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl#getSystemInstanceProxy <em>System Instance Proxy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemConfigurationImpl extends MinimalEObjectImpl.Container implements SystemConfiguration
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
   * The cached value of the '{@link #getSystemImplementation() <em>System Implementation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemImplementation()
   * @generated
   * @ordered
   */
  protected EObject systemImplementation;

  /**
   * The cached value of the '{@link #getSystemInstanceProxy() <em>System Instance Proxy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemInstanceProxy()
   * @generated
   * @ordered
   */
  protected SystemInstanceProxy systemInstanceProxy;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemConfigurationImpl()
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
    return SandboxPackage.Literals.SYSTEM_CONFIGURATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SandboxPackage.SYSTEM_CONFIGURATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getSystemImplementation()
  {
    if (systemImplementation != null && systemImplementation.eIsProxy())
    {
      InternalEObject oldSystemImplementation = (InternalEObject)systemImplementation;
      systemImplementation = eResolveProxy(oldSystemImplementation);
      if (systemImplementation != oldSystemImplementation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION, oldSystemImplementation, systemImplementation));
      }
    }
    return systemImplementation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetSystemImplementation()
  {
    return systemImplementation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSystemImplementation(EObject newSystemImplementation)
  {
    EObject oldSystemImplementation = systemImplementation;
    systemImplementation = newSystemImplementation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION, oldSystemImplementation, systemImplementation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemInstanceProxy getSystemInstanceProxy()
  {
    return systemInstanceProxy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSystemInstanceProxy(SystemInstanceProxy newSystemInstanceProxy, NotificationChain msgs)
  {
    SystemInstanceProxy oldSystemInstanceProxy = systemInstanceProxy;
    systemInstanceProxy = newSystemInstanceProxy;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY, oldSystemInstanceProxy, newSystemInstanceProxy);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSystemInstanceProxy(SystemInstanceProxy newSystemInstanceProxy)
  {
    if (newSystemInstanceProxy != systemInstanceProxy)
    {
      NotificationChain msgs = null;
      if (systemInstanceProxy != null)
        msgs = ((InternalEObject)systemInstanceProxy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY, null, msgs);
      if (newSystemInstanceProxy != null)
        msgs = ((InternalEObject)newSystemInstanceProxy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY, null, msgs);
      msgs = basicSetSystemInstanceProxy(newSystemInstanceProxy, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY, newSystemInstanceProxy, newSystemInstanceProxy));
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
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY:
        return basicSetSystemInstanceProxy(null, msgs);
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
      case SandboxPackage.SYSTEM_CONFIGURATION__NAME:
        return getName();
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION:
        if (resolve) return getSystemImplementation();
        return basicGetSystemImplementation();
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY:
        return getSystemInstanceProxy();
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
      case SandboxPackage.SYSTEM_CONFIGURATION__NAME:
        setName((String)newValue);
        return;
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION:
        setSystemImplementation((EObject)newValue);
        return;
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY:
        setSystemInstanceProxy((SystemInstanceProxy)newValue);
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
      case SandboxPackage.SYSTEM_CONFIGURATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION:
        setSystemImplementation((EObject)null);
        return;
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY:
        setSystemInstanceProxy((SystemInstanceProxy)null);
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
      case SandboxPackage.SYSTEM_CONFIGURATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION:
        return systemImplementation != null;
      case SandboxPackage.SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY:
        return systemInstanceProxy != null;
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
    result.append(')');
    return result.toString();
  }

} //SystemConfigurationImpl
