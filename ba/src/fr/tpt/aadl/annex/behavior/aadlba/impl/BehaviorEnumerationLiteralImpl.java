/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.StringLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorEnumerationLiteralImpl#getEnumLiteral <em>Enum Literal</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorEnumerationLiteralImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorEnumerationLiteralImpl extends BehaviorElementImpl implements BehaviorEnumerationLiteral
{
  /**
   * The cached value of the '{@link #getEnumLiteral() <em>Enum Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumLiteral()
   * @generated
   * @ordered
   */
  protected StringLiteral enumLiteral;

  /**
   * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponent()
   * @generated
   * @ordered
   */
  protected ComponentClassifier component;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorEnumerationLiteralImpl()
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
    return AadlBaPackage.Literals.BEHAVIOR_ENUMERATION_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral getEnumLiteral()
  {
    if (enumLiteral != null && ((EObject)enumLiteral).eIsProxy())
    {
      InternalEObject oldEnumLiteral = (InternalEObject)enumLiteral;
      enumLiteral = (StringLiteral)eResolveProxy(oldEnumLiteral);
      if (enumLiteral != oldEnumLiteral)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL, oldEnumLiteral, enumLiteral));
      }
    }
    return enumLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral basicGetEnumLiteral()
  {
    return enumLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumLiteral(StringLiteral newEnumLiteral)
  {
    StringLiteral oldEnumLiteral = enumLiteral;
    enumLiteral = newEnumLiteral;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL, oldEnumLiteral, enumLiteral));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier getComponent()
  {
    if (component != null && ((EObject)component).eIsProxy())
    {
      InternalEObject oldComponent = (InternalEObject)component;
      component = (ComponentClassifier)eResolveProxy(oldComponent);
      if (component != oldComponent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__COMPONENT, oldComponent, component));
      }
    }
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier basicGetComponent()
  {
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponent(ComponentClassifier newComponent)
  {
    ComponentClassifier oldComponent = component;
    component = newComponent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__COMPONENT, oldComponent, component));
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
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL:
        if (resolve) return getEnumLiteral();
        return basicGetEnumLiteral();
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__COMPONENT:
        if (resolve) return getComponent();
        return basicGetComponent();
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
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL:
        setEnumLiteral((StringLiteral)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__COMPONENT:
        setComponent((ComponentClassifier)newValue);
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
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL:
        setEnumLiteral((StringLiteral)null);
        return;
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__COMPONENT:
        setComponent((ComponentClassifier)null);
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
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL:
        return enumLiteral != null;
      case AadlBaPackage.BEHAVIOR_ENUMERATION_LITERAL__COMPONENT:
        return component != null;
    }
    return super.eIsSet(featureID);
  }

} //BehaviorEnumerationLiteralImpl
