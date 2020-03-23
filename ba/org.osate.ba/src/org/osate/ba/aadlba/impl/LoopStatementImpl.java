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
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.LoopStatement ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.LoopStatementImpl#getBehaviorActions <em>Behavior Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LoopStatementImpl extends BehaviorElementImpl implements LoopStatement
{
  /**
   * The cached value of the '{@link #getBehaviorActions() <em>Behavior Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorActions()
   * @generated
   * @ordered
   */
  protected BehaviorActions behaviorActions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LoopStatementImpl()
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
    return AadlBaPackage.Literals.LOOP_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActions getBehaviorActions()
  {
    return behaviorActions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviorActions(BehaviorActions newBehaviorActions, NotificationChain msgs)
  {
    BehaviorActions oldBehaviorActions = behaviorActions;
    behaviorActions = newBehaviorActions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS, oldBehaviorActions, newBehaviorActions);
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
  public void setBehaviorActions(BehaviorActions newBehaviorActions)
  {
    if (newBehaviorActions != behaviorActions)
    {
      NotificationChain msgs = null;
      if (behaviorActions != null)
        msgs = ((InternalEObject)behaviorActions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS, null, msgs);
      if (newBehaviorActions != null)
        msgs = ((InternalEObject)newBehaviorActions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS, null, msgs);
      msgs = basicSetBehaviorActions(newBehaviorActions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS, newBehaviorActions, newBehaviorActions));
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
      case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS:
        return basicSetBehaviorActions(null, msgs);
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
      case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS:
        return getBehaviorActions();
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
      case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS:
        setBehaviorActions((BehaviorActions)newValue);
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
      case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS:
        setBehaviorActions((BehaviorActions)null);
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
      case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS:
        return behaviorActions != null;
    }
    return super.eIsSet(featureID);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //LoopStatementImpl
