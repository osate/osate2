/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.impl;


import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.aadl2.PropertyConstant ;
import org.osate.aadl2.PropertySet ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorPropertyConstant ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Property Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorPropertyConstantImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorPropertyConstantImpl#getPropertySet <em>Property Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorPropertyConstantImpl extends BehaviorElementImpl implements BehaviorPropertyConstant
{
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected PropertyConstant property;

  /**
   * The cached value of the '{@link #getPropertySet() <em>Property Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertySet()
   * @generated
   * @ordered
   */
  protected PropertySet propertySet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorPropertyConstantImpl()
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
    return AadlBaPackage.Literals.BEHAVIOR_PROPERTY_CONSTANT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyConstant getProperty()
  {
    if (property != null && ((EObject)property).eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (PropertyConstant)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyConstant basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(PropertyConstant newProperty)
  {
    PropertyConstant oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY, oldProperty, property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertySet getPropertySet()
  {
    if (propertySet != null && ((EObject)propertySet).eIsProxy())
    {
      InternalEObject oldPropertySet = (InternalEObject)propertySet;
      propertySet = (PropertySet)eResolveProxy(oldPropertySet);
      if (propertySet != oldPropertySet)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET, oldPropertySet, propertySet));
      }
    }
    return propertySet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertySet basicGetPropertySet()
  {
    return propertySet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPropertySet(PropertySet newPropertySet)
  {
    PropertySet oldPropertySet = propertySet;
    propertySet = newPropertySet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET, oldPropertySet, propertySet));
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
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET:
        if (resolve) return getPropertySet();
        return basicGetPropertySet();
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
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY:
        setProperty((PropertyConstant)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET:
        setPropertySet((PropertySet)newValue);
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
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY:
        setProperty((PropertyConstant)null);
        return;
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET:
        setPropertySet((PropertySet)null);
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
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY:
        return property != null;
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET:
        return propertySet != null;
    }
    return super.eIsSet(featureID);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //BehaviorPropertyConstantImpl
