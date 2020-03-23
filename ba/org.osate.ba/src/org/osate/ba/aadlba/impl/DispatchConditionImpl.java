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


import java.util.Collection ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.ActualPortHolder ;
import org.osate.ba.aadlba.DispatchCondition ;
import org.osate.ba.aadlba.DispatchTriggerCondition ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.DispatchConditionImpl#getDispatchTriggerCondition <em>Dispatch Trigger Condition</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.DispatchConditionImpl#getFrozenPorts <em>Frozen Ports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DispatchConditionImpl extends BehaviorElementImpl implements DispatchCondition
{
  /**
   * The cached value of the '{@link #getDispatchTriggerCondition() <em>Dispatch Trigger Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDispatchTriggerCondition()
   * @generated
   * @ordered
   */
  protected DispatchTriggerCondition dispatchTriggerCondition;

  /**
   * The cached value of the '{@link #getFrozenPorts() <em>Frozen Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrozenPorts()
   * @generated
   * @ordered
   */
  protected EList<ActualPortHolder> frozenPorts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DispatchConditionImpl()
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
    return AadlBaPackage.Literals.DISPATCH_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchTriggerCondition getDispatchTriggerCondition()
  {
    return dispatchTriggerCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDispatchTriggerCondition(DispatchTriggerCondition newDispatchTriggerCondition, NotificationChain msgs)
  {
    DispatchTriggerCondition oldDispatchTriggerCondition = dispatchTriggerCondition;
    dispatchTriggerCondition = newDispatchTriggerCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION, oldDispatchTriggerCondition, newDispatchTriggerCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDispatchTriggerCondition(DispatchTriggerCondition newDispatchTriggerCondition)
  {
    if (newDispatchTriggerCondition != dispatchTriggerCondition)
    {
      NotificationChain msgs = null;
      if (dispatchTriggerCondition != null)
        msgs = ((InternalEObject)dispatchTriggerCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION, null, msgs);
      if (newDispatchTriggerCondition != null)
        msgs = ((InternalEObject)newDispatchTriggerCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION, null, msgs);
      msgs = basicSetDispatchTriggerCondition(newDispatchTriggerCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION, newDispatchTriggerCondition, newDispatchTriggerCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ActualPortHolder> getFrozenPorts()
  {
    if (frozenPorts == null)
    {
      frozenPorts = new EObjectContainmentEList.Unsettable<ActualPortHolder>(ActualPortHolder.class, this, AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS);
    }
    return frozenPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetFrozenPorts()
  {
    if (frozenPorts != null) ((InternalEList.Unsettable<?>)frozenPorts).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetFrozenPorts()
  {
    return frozenPorts != null && ((InternalEList.Unsettable<?>)frozenPorts).isSet();
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
      case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION:
        return basicSetDispatchTriggerCondition(null, msgs);
      case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
        return ((InternalEList<?>)getFrozenPorts()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION:
        return getDispatchTriggerCondition();
      case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
        return getFrozenPorts();
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
      case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION:
        setDispatchTriggerCondition((DispatchTriggerCondition)newValue);
        return;
      case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
        getFrozenPorts().clear();
        getFrozenPorts().addAll((Collection<? extends ActualPortHolder>)newValue);
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
      case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION:
        setDispatchTriggerCondition((DispatchTriggerCondition)null);
        return;
      case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
        unsetFrozenPorts();
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
      case AadlBaPackage.DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION:
        return dispatchTriggerCondition != null;
      case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
        return isSetFrozenPorts();
    }
    return super.eIsSet(featureID);
  }
  
  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //DispatchConditionImpl
