/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox.impl;

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

import org.osate.xtext.aadl2.sandbox.sandbox.Sandbox;
import org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sandbox</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxImpl#getSystemInstance <em>System Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SandboxImpl extends MinimalEObjectImpl.Container implements Sandbox
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
   * The cached value of the '{@link #getSystemInstance() <em>System Instance</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemInstance()
   * @generated
   * @ordered
   */
  protected EList<SystemConfiguration> systemInstance;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SandboxImpl()
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
    return SandboxPackage.Literals.SANDBOX;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SandboxPackage.SANDBOX__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SystemConfiguration> getSystemInstance()
  {
    if (systemInstance == null)
    {
      systemInstance = new EObjectContainmentEList<SystemConfiguration>(SystemConfiguration.class, this, SandboxPackage.SANDBOX__SYSTEM_INSTANCE);
    }
    return systemInstance;
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
      case SandboxPackage.SANDBOX__SYSTEM_INSTANCE:
        return ((InternalEList<?>)getSystemInstance()).basicRemove(otherEnd, msgs);
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
      case SandboxPackage.SANDBOX__NAME:
        return getName();
      case SandboxPackage.SANDBOX__SYSTEM_INSTANCE:
        return getSystemInstance();
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
      case SandboxPackage.SANDBOX__NAME:
        setName((String)newValue);
        return;
      case SandboxPackage.SANDBOX__SYSTEM_INSTANCE:
        getSystemInstance().clear();
        getSystemInstance().addAll((Collection<? extends SystemConfiguration>)newValue);
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
      case SandboxPackage.SANDBOX__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SandboxPackage.SANDBOX__SYSTEM_INSTANCE:
        getSystemInstance().clear();
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
      case SandboxPackage.SANDBOX__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SandboxPackage.SANDBOX__SYSTEM_INSTANCE:
        return systemInstance != null && !systemInstance.isEmpty();
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

} //SandboxImpl
