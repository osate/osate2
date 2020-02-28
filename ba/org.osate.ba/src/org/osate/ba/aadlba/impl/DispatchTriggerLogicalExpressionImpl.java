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

import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.DispatchConjunction ;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Trigger Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.DispatchTriggerLogicalExpressionImpl#getDispatchConjunctions <em>Dispatch Conjunctions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DispatchTriggerLogicalExpressionImpl extends BehaviorElementImpl implements DispatchTriggerLogicalExpression
{
  /**
   * The cached value of the '{@link #getDispatchConjunctions() <em>Dispatch Conjunctions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDispatchConjunctions()
   * @generated
   * @ordered
   */
  protected EList<DispatchConjunction> dispatchConjunctions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DispatchTriggerLogicalExpressionImpl()
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
    return AadlBaPackage.Literals.DISPATCH_TRIGGER_LOGICAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DispatchConjunction> getDispatchConjunctions()
  {
    if (dispatchConjunctions == null)
    {
      dispatchConjunctions = new EObjectContainmentEList<DispatchConjunction>(DispatchConjunction.class, this, AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS);
    }
    return dispatchConjunctions;
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
      case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
        return ((InternalEList<?>)getDispatchConjunctions()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
        return getDispatchConjunctions();
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
      case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
        getDispatchConjunctions().clear();
        getDispatchConjunctions().addAll((Collection<? extends DispatchConjunction>)newValue);
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
      case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
        getDispatchConjunctions().clear();
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
      case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS:
        return dispatchConjunctions != null && !dispatchConjunctions.isEmpty();
    }
    return super.eIsSet(featureID);
  }
  
  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //DispatchTriggerLogicalExpressionImpl
