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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl#getDispatch <em>Dispatch</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl#getModeSwitch <em>Mode Switch</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl#getExecute <em>Execute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorConditionImpl extends MinimalEObjectImpl.Container implements BehaviorCondition
{
  /**
   * The cached value of the '{@link #getDispatch() <em>Dispatch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDispatch()
   * @generated
   * @ordered
   */
  protected DispatchCondition dispatch;

  /**
   * The cached value of the '{@link #getModeSwitch() <em>Mode Switch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModeSwitch()
   * @generated
   * @ordered
   */
  protected ModeSwitchCondition modeSwitch;

  /**
   * The cached value of the '{@link #getExecute() <em>Execute</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecute()
   * @generated
   * @ordered
   */
  protected ExecuteCondition execute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorConditionImpl()
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
    return BehaviorAnnexPackage.Literals.BEHAVIOR_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchCondition getDispatch()
  {
    return dispatch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDispatch(DispatchCondition newDispatch, NotificationChain msgs)
  {
    DispatchCondition oldDispatch = dispatch;
    dispatch = newDispatch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH, oldDispatch, newDispatch);
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
  public void setDispatch(DispatchCondition newDispatch)
  {
    if (newDispatch != dispatch)
    {
      NotificationChain msgs = null;
      if (dispatch != null)
        msgs = ((InternalEObject)dispatch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH, null, msgs);
      if (newDispatch != null)
        msgs = ((InternalEObject)newDispatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH, null, msgs);
      msgs = basicSetDispatch(newDispatch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH, newDispatch, newDispatch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModeSwitchCondition getModeSwitch()
  {
    return modeSwitch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModeSwitch(ModeSwitchCondition newModeSwitch, NotificationChain msgs)
  {
    ModeSwitchCondition oldModeSwitch = modeSwitch;
    modeSwitch = newModeSwitch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH, oldModeSwitch, newModeSwitch);
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
  public void setModeSwitch(ModeSwitchCondition newModeSwitch)
  {
    if (newModeSwitch != modeSwitch)
    {
      NotificationChain msgs = null;
      if (modeSwitch != null)
        msgs = ((InternalEObject)modeSwitch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH, null, msgs);
      if (newModeSwitch != null)
        msgs = ((InternalEObject)newModeSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH, null, msgs);
      msgs = basicSetModeSwitch(newModeSwitch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH, newModeSwitch, newModeSwitch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExecuteCondition getExecute()
  {
    return execute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExecute(ExecuteCondition newExecute, NotificationChain msgs)
  {
    ExecuteCondition oldExecute = execute;
    execute = newExecute;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE, oldExecute, newExecute);
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
  public void setExecute(ExecuteCondition newExecute)
  {
    if (newExecute != execute)
    {
      NotificationChain msgs = null;
      if (execute != null)
        msgs = ((InternalEObject)execute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE, null, msgs);
      if (newExecute != null)
        msgs = ((InternalEObject)newExecute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE, null, msgs);
      msgs = basicSetExecute(newExecute, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE, newExecute, newExecute));
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
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH:
        return basicSetDispatch(null, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH:
        return basicSetModeSwitch(null, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE:
        return basicSetExecute(null, msgs);
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
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH:
        return getDispatch();
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH:
        return getModeSwitch();
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE:
        return getExecute();
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
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH:
        setDispatch((DispatchCondition)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH:
        setModeSwitch((ModeSwitchCondition)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE:
        setExecute((ExecuteCondition)newValue);
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
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH:
        setDispatch((DispatchCondition)null);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH:
        setModeSwitch((ModeSwitchCondition)null);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE:
        setExecute((ExecuteCondition)null);
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
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__DISPATCH:
        return dispatch != null;
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__MODE_SWITCH:
        return modeSwitch != null;
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION__EXECUTE:
        return execute != null;
    }
    return super.eIsSet(featureID);
  }

} //BehaviorConditionImpl
