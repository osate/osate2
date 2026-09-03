/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl#getSourceStates <em>Source States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl#getDestinationState <em>Destination State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl#getActionBlock <em>Action Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorTransitionImpl extends MinimalEObjectImpl.Container implements BehaviorTransition
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
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final String PRIORITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected String priority = PRIORITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getSourceStates() <em>Source States</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceStates()
   * @generated
   * @ordered
   */
  protected EList<BehaviorState> sourceStates;

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
   * The cached value of the '{@link #getActionBlock() <em>Action Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActionBlock()
   * @generated
   * @ordered
   */
  protected BehaviorActionBlock actionBlock;

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
    return BehaviorAnnexPackage.Literals.BEHAVIOR_TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPriority()
  {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPriority(String newPriority)
  {
    String oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorState> getSourceStates()
  {
    if (sourceStates == null)
    {
      sourceStates = new EObjectResolvingEList<BehaviorState>(BehaviorState.class, this, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__SOURCE_STATES);
    }
    return sourceStates;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorState getDestinationState()
  {
    if (destinationState != null && destinationState.eIsProxy())
    {
      InternalEObject oldDestinationState = (InternalEObject)destinationState;
      destinationState = (BehaviorState)eResolveProxy(oldDestinationState);
      if (destinationState != oldDestinationState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, oldDestinationState, destinationState));
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
  @Override
  public void setDestinationState(BehaviorState newDestinationState)
  {
    BehaviorState oldDestinationState = destinationState;
    destinationState = newDestinationState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, oldDestinationState, destinationState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActionBlock getActionBlock()
  {
    return actionBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActionBlock(BehaviorActionBlock newActionBlock, NotificationChain msgs)
  {
    BehaviorActionBlock oldActionBlock = actionBlock;
    actionBlock = newActionBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, oldActionBlock, newActionBlock);
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
  public void setActionBlock(BehaviorActionBlock newActionBlock)
  {
    if (newActionBlock != actionBlock)
    {
      NotificationChain msgs = null;
      if (actionBlock != null)
        msgs = ((InternalEObject)actionBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, null, msgs);
      if (newActionBlock != null)
        msgs = ((InternalEObject)newActionBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, null, msgs);
      msgs = basicSetActionBlock(newActionBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, newActionBlock, newActionBlock));
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
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION:
        return basicSetCondition(null, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        return basicSetActionBlock(null, msgs);
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
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__NAME:
        return getName();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__PRIORITY:
        return getPriority();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__SOURCE_STATES:
        return getSourceStates();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION:
        return getCondition();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        if (resolve) return getDestinationState();
        return basicGetDestinationState();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        return getActionBlock();
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
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__NAME:
        setName((String)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__PRIORITY:
        setPriority((String)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__SOURCE_STATES:
        getSourceStates().clear();
        getSourceStates().addAll((Collection<? extends BehaviorState>)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION:
        setCondition((BehaviorCondition)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        setDestinationState((BehaviorState)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        setActionBlock((BehaviorActionBlock)newValue);
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
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__SOURCE_STATES:
        getSourceStates().clear();
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION:
        setCondition((BehaviorCondition)null);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        setDestinationState((BehaviorState)null);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        setActionBlock((BehaviorActionBlock)null);
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
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__PRIORITY:
        return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__SOURCE_STATES:
        return sourceStates != null && !sourceStates.isEmpty();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__CONDITION:
        return condition != null;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
        return destinationState != null;
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
        return actionBlock != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

} //BehaviorTransitionImpl
