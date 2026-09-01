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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.ComponentClassifier;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl#getLowerTime <em>Lower Time</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl#getUpperTime <em>Upper Time</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl#getProcessors <em>Processors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimedActionImpl extends BehaviorActionImpl implements TimedAction
{
  /**
   * The cached value of the '{@link #getLowerTime() <em>Lower Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerTime()
   * @generated
   * @ordered
   */
  protected BehaviorTime lowerTime;

  /**
   * The cached value of the '{@link #getUpperTime() <em>Upper Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperTime()
   * @generated
   * @ordered
   */
  protected BehaviorTime upperTime;

  /**
   * The cached value of the '{@link #getProcessors() <em>Processors</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessors()
   * @generated
   * @ordered
   */
  protected EList<ComponentClassifier> processors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimedActionImpl()
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
    return BehaviorAnnexPackage.Literals.TIMED_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorTime getLowerTime()
  {
    return lowerTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLowerTime(BehaviorTime newLowerTime, NotificationChain msgs)
  {
    BehaviorTime oldLowerTime = lowerTime;
    lowerTime = newLowerTime;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME, oldLowerTime, newLowerTime);
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
  public void setLowerTime(BehaviorTime newLowerTime)
  {
    if (newLowerTime != lowerTime)
    {
      NotificationChain msgs = null;
      if (lowerTime != null)
        msgs = ((InternalEObject)lowerTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME, null, msgs);
      if (newLowerTime != null)
        msgs = ((InternalEObject)newLowerTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME, null, msgs);
      msgs = basicSetLowerTime(newLowerTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME, newLowerTime, newLowerTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorTime getUpperTime()
  {
    return upperTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpperTime(BehaviorTime newUpperTime, NotificationChain msgs)
  {
    BehaviorTime oldUpperTime = upperTime;
    upperTime = newUpperTime;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME, oldUpperTime, newUpperTime);
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
  public void setUpperTime(BehaviorTime newUpperTime)
  {
    if (newUpperTime != upperTime)
    {
      NotificationChain msgs = null;
      if (upperTime != null)
        msgs = ((InternalEObject)upperTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME, null, msgs);
      if (newUpperTime != null)
        msgs = ((InternalEObject)newUpperTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME, null, msgs);
      msgs = basicSetUpperTime(newUpperTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME, newUpperTime, newUpperTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ComponentClassifier> getProcessors()
  {
    if (processors == null)
    {
      processors = new EObjectResolvingEList<ComponentClassifier>(ComponentClassifier.class, this, BehaviorAnnexPackage.TIMED_ACTION__PROCESSORS);
    }
    return processors;
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
      case BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME:
        return basicSetLowerTime(null, msgs);
      case BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME:
        return basicSetUpperTime(null, msgs);
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
      case BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME:
        return getLowerTime();
      case BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME:
        return getUpperTime();
      case BehaviorAnnexPackage.TIMED_ACTION__PROCESSORS:
        return getProcessors();
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
      case BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME:
        setLowerTime((BehaviorTime)newValue);
        return;
      case BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME:
        setUpperTime((BehaviorTime)newValue);
        return;
      case BehaviorAnnexPackage.TIMED_ACTION__PROCESSORS:
        getProcessors().clear();
        getProcessors().addAll((Collection<? extends ComponentClassifier>)newValue);
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
      case BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME:
        setLowerTime((BehaviorTime)null);
        return;
      case BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME:
        setUpperTime((BehaviorTime)null);
        return;
      case BehaviorAnnexPackage.TIMED_ACTION__PROCESSORS:
        getProcessors().clear();
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
      case BehaviorAnnexPackage.TIMED_ACTION__LOWER_TIME:
        return lowerTime != null;
      case BehaviorAnnexPackage.TIMED_ACTION__UPPER_TIME:
        return upperTime != null;
      case BehaviorAnnexPackage.TIMED_ACTION__PROCESSORS:
        return processors != null && !processors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TimedActionImpl
