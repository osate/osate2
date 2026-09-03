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
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Trigger Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl#isTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl#isStop <em>Stop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DispatchTriggerConditionImpl extends MinimalEObjectImpl.Container implements DispatchTriggerCondition
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected DispatchTriggerLogicalExpression expression;

  /**
   * The default value of the '{@link #isTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTimeout()
   * @generated
   * @ordered
   */
  protected static final boolean TIMEOUT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTimeout()
   * @generated
   * @ordered
   */
  protected boolean timeout = TIMEOUT_EDEFAULT;

  /**
   * The cached value of the '{@link #getTime() <em>Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected BehaviorTime time;

  /**
   * The default value of the '{@link #isStop() <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStop()
   * @generated
   * @ordered
   */
  protected static final boolean STOP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStop() <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStop()
   * @generated
   * @ordered
   */
  protected boolean stop = STOP_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DispatchTriggerConditionImpl()
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
    return BehaviorAnnexPackage.Literals.DISPATCH_TRIGGER_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchTriggerLogicalExpression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(DispatchTriggerLogicalExpression newExpression, NotificationChain msgs)
  {
    DispatchTriggerLogicalExpression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION, oldExpression, newExpression);
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
  public void setExpression(DispatchTriggerLogicalExpression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isTimeout()
  {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTimeout(boolean newTimeout)
  {
    boolean oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIMEOUT, oldTimeout, timeout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorTime getTime()
  {
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTime(BehaviorTime newTime, NotificationChain msgs)
  {
    BehaviorTime oldTime = time;
    time = newTime;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME, oldTime, newTime);
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
  public void setTime(BehaviorTime newTime)
  {
    if (newTime != time)
    {
      NotificationChain msgs = null;
      if (time != null)
        msgs = ((InternalEObject)time).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME, null, msgs);
      if (newTime != null)
        msgs = ((InternalEObject)newTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME, null, msgs);
      msgs = basicSetTime(newTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME, newTime, newTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStop()
  {
    return stop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStop(boolean newStop)
  {
    boolean oldStop = stop;
    stop = newStop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__STOP, oldStop, stop));
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
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION:
        return basicSetExpression(null, msgs);
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME:
        return basicSetTime(null, msgs);
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
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION:
        return getExpression();
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIMEOUT:
        return isTimeout();
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME:
        return getTime();
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__STOP:
        return isStop();
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
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION:
        setExpression((DispatchTriggerLogicalExpression)newValue);
        return;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIMEOUT:
        setTimeout((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME:
        setTime((BehaviorTime)newValue);
        return;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__STOP:
        setStop((Boolean)newValue);
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
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION:
        setExpression((DispatchTriggerLogicalExpression)null);
        return;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIMEOUT:
        setTimeout(TIMEOUT_EDEFAULT);
        return;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME:
        setTime((BehaviorTime)null);
        return;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__STOP:
        setStop(STOP_EDEFAULT);
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
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__EXPRESSION:
        return expression != null;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIMEOUT:
        return timeout != TIMEOUT_EDEFAULT;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__TIME:
        return time != null;
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION__STOP:
        return stop != STOP_EDEFAULT;
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
    result.append(" (timeout: ");
    result.append(timeout);
    result.append(", stop: ");
    result.append(stop);
    result.append(')');
    return result.toString();
  }

} //DispatchTriggerConditionImpl
