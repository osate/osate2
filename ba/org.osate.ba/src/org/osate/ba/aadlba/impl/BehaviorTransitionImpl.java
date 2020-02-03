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
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorCondition ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorTransitionImpl#getSourceState <em>Source State</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorTransitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorTransitionImpl#getDestinationState <em>Destination State</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorTransitionImpl#getActionBlock <em>Action Block</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorTransitionImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorTransitionImpl extends BehaviorNamedElementImpl implements BehaviorTransition
{
  /**
   * The cached value of the '{@link #getSourceState() <em>Source State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceState()
   * @generated
   * @ordered
   */
  protected BehaviorState sourceState;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected BehaviorCondition condition;

  /**
   * The cached value of the '{@link #getDestinationState() <em>Destination State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestinationState()
   * @generated
   * @ordered
   */
  protected BehaviorState destinationState;

  /**
   * The cached value of the '{@link #getActionBlock() <em>Action Block</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActionBlock()
   * @generated
   * @ordered
   */
  protected BehaviorActionBlock actionBlock;

  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final long PRIORITY_EDEFAULT = -1L;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected long priority = PRIORITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorTransitionImpl()
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
    return AadlBaPackage.Literals.BEHAVIOR_TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorState getSourceState()
  {
    if (sourceState != null && ((EObject)sourceState).eIsProxy())
    {
      InternalEObject oldSourceState = (InternalEObject)sourceState;
      sourceState = (BehaviorState)eResolveProxy(oldSourceState);
      if (sourceState != oldSourceState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE, oldSourceState, sourceState));
      }
    }
    return sourceState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorState basicGetSourceState()
  {
    return sourceState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSourceState(BehaviorState newSourceState, NotificationChain msgs)
  {
    BehaviorState oldSourceState = sourceState;
    sourceState = newSourceState;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE, oldSourceState, newSourceState);
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
  public void setSourceState(BehaviorState newSourceState)
  {
    if (newSourceState != sourceState)
    {
      NotificationChain msgs = null;
      if (sourceState != null)
        msgs = ((InternalEObject)sourceState).eInverseRemove(this, AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS, BehaviorState.class, msgs);
      if (newSourceState != null)
        msgs = ((InternalEObject)newSourceState).eInverseAdd(this, AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS, BehaviorState.class, msgs);
      msgs = basicSetSourceState(newSourceState, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE, newSourceState, newSourceState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorCondition getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(BehaviorCondition newCondition, NotificationChain msgs)
  {
    BehaviorCondition oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION, oldCondition, newCondition);
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
  public void setCondition(BehaviorCondition newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorState getDestinationState()
  {
    if (destinationState != null && ((EObject)destinationState).eIsProxy())
    {
      InternalEObject oldDestinationState = (InternalEObject)destinationState;
      destinationState = (BehaviorState)eResolveProxy(oldDestinationState);
      if (destinationState != oldDestinationState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, oldDestinationState, destinationState));
      }
    }
    return destinationState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorState basicGetDestinationState()
  {
    return destinationState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDestinationState(BehaviorState newDestinationState, NotificationChain msgs)
  {
    BehaviorState oldDestinationState = destinationState;
    destinationState = newDestinationState;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, oldDestinationState, newDestinationState);
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
  public void setDestinationState(BehaviorState newDestinationState)
  {
    if (newDestinationState != destinationState)
    {
      NotificationChain msgs = null;
      if (destinationState != null)
        msgs = ((InternalEObject)destinationState).eInverseRemove(this, AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS, BehaviorState.class, msgs);
      if (newDestinationState != null)
        msgs = ((InternalEObject)newDestinationState).eInverseAdd(this, AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS, BehaviorState.class, msgs);
      msgs = basicSetDestinationState(newDestinationState, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, newDestinationState, newDestinationState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActionBlock getActionBlock()
  {
    if (actionBlock != null && ((EObject)actionBlock).eIsProxy())
    {
      InternalEObject oldActionBlock = (InternalEObject)actionBlock;
      actionBlock = (BehaviorActionBlock)eResolveProxy(oldActionBlock);
      if (actionBlock != oldActionBlock)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, oldActionBlock, actionBlock));
      }
    }
    return actionBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorActionBlock basicGetActionBlock()
  {
    return actionBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setActionBlock(BehaviorActionBlock newActionBlock)
  {
    BehaviorActionBlock oldActionBlock = actionBlock;
    actionBlock = newActionBlock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, oldActionBlock, actionBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public long getPriority()
  {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPriority(long newPriority)
  {
    long oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
        if (sourceState != null)
          msgs = ((InternalEObject)sourceState).eInverseRemove(this, AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS, BehaviorState.class, msgs);
        return basicSetSourceState((BehaviorState)otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        if (destinationState != null)
          msgs = ((InternalEObject)destinationState).eInverseRemove(this, AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS, BehaviorState.class, msgs);
        return basicSetDestinationState((BehaviorState)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
        return basicSetSourceState(null, msgs);
      case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
        return basicSetCondition(null, msgs);
      case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        return basicSetDestinationState(null, msgs);
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
      case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
        if (resolve) return getSourceState();
        return basicGetSourceState();
      case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
        return getCondition();
      case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        if (resolve) return getDestinationState();
        return basicGetDestinationState();
      case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        if (resolve) return getActionBlock();
        return basicGetActionBlock();
      case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
        return getPriority();
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
      case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
        setSourceState((BehaviorState)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
        setCondition((BehaviorCondition)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        setDestinationState((BehaviorState)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        setActionBlock((BehaviorActionBlock)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
        setPriority((Long)newValue);
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
      case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
        setSourceState((BehaviorState)null);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
        setCondition((BehaviorCondition)null);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        setDestinationState((BehaviorState)null);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        setActionBlock((BehaviorActionBlock)null);
        return;
      case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
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
      case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
        return sourceState != null;
      case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
        return condition != null;
      case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        return destinationState != null;
      case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        return actionBlock != null;
      case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }
} //BehaviorTransitionImpl
