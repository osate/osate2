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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.ModeSwitchConjunction;
import org.osate.ba.aadlba.ModeSwitchTrigger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Switch Conjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.ModeSwitchConjunctionImpl#getModeSwitchTriggers <em>Mode Switch Triggers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeSwitchConjunctionImpl extends BehaviorElementImpl implements ModeSwitchConjunction
{
  /**
   * The cached value of the '{@link #getModeSwitchTriggers() <em>Mode Switch Triggers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModeSwitchTriggers()
   * @generated
   * @ordered
   */
  protected EList<ModeSwitchTrigger> modeSwitchTriggers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModeSwitchConjunctionImpl()
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
    return AadlBaPackage.Literals.MODE_SWITCH_CONJUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ModeSwitchTrigger> getModeSwitchTriggers()
  {
    if (modeSwitchTriggers == null)
    {
      modeSwitchTriggers = new EObjectContainmentEList.Unsettable<ModeSwitchTrigger>(ModeSwitchTrigger.class, this, AadlBaPackage.MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS);
    }
    return modeSwitchTriggers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetModeSwitchTriggers()
  {
    if (modeSwitchTriggers != null) ((InternalEList.Unsettable<?>)modeSwitchTriggers).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetModeSwitchTriggers()
  {
    return modeSwitchTriggers != null && ((InternalEList.Unsettable<?>)modeSwitchTriggers).isSet();
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
      case AadlBaPackage.MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS:
        return ((InternalEList<?>)getModeSwitchTriggers()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS:
        return getModeSwitchTriggers();
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
      case AadlBaPackage.MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS:
        getModeSwitchTriggers().clear();
        getModeSwitchTriggers().addAll((Collection<? extends ModeSwitchTrigger>)newValue);
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
      case AadlBaPackage.MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS:
        unsetModeSwitchTriggers();
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
      case AadlBaPackage.MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS:
        return isSetModeSwitchTriggers();
    }
    return super.eIsSet(featureID);
  }

} //ModeSwitchConjunctionImpl
