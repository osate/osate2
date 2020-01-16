/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.PropertyExpression;

import org.osate.aadl2.impl.PropertyExpressionImpl;

import org.osate.alisa.common.common.ARange;
import org.osate.alisa.common.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ARange</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.ARangeImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.ARangeImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.ARangeImpl#getDelta <em>Delta</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ARangeImpl extends PropertyExpressionImpl implements ARange
{
  /**
   * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinimum()
   * @generated
   * @ordered
   */
  protected PropertyExpression minimum;

  /**
   * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaximum()
   * @generated
   * @ordered
   */
  protected PropertyExpression maximum;

  /**
   * The cached value of the '{@link #getDelta() <em>Delta</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelta()
   * @generated
   * @ordered
   */
  protected PropertyExpression delta;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ARangeImpl()
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
    return CommonPackage.Literals.ARANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyExpression getMinimum()
  {
    return minimum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMinimum(PropertyExpression newMinimum, NotificationChain msgs)
  {
    PropertyExpression oldMinimum = minimum;
    minimum = newMinimum;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.ARANGE__MINIMUM, oldMinimum, newMinimum);
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
  public void setMinimum(PropertyExpression newMinimum)
  {
    if (newMinimum != minimum)
    {
      NotificationChain msgs = null;
      if (minimum != null)
        msgs = ((InternalEObject)minimum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.ARANGE__MINIMUM, null, msgs);
      if (newMinimum != null)
        msgs = ((InternalEObject)newMinimum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.ARANGE__MINIMUM, null, msgs);
      msgs = basicSetMinimum(newMinimum, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ARANGE__MINIMUM, newMinimum, newMinimum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyExpression getMaximum()
  {
    return maximum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMaximum(PropertyExpression newMaximum, NotificationChain msgs)
  {
    PropertyExpression oldMaximum = maximum;
    maximum = newMaximum;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.ARANGE__MAXIMUM, oldMaximum, newMaximum);
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
  public void setMaximum(PropertyExpression newMaximum)
  {
    if (newMaximum != maximum)
    {
      NotificationChain msgs = null;
      if (maximum != null)
        msgs = ((InternalEObject)maximum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.ARANGE__MAXIMUM, null, msgs);
      if (newMaximum != null)
        msgs = ((InternalEObject)newMaximum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.ARANGE__MAXIMUM, null, msgs);
      msgs = basicSetMaximum(newMaximum, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ARANGE__MAXIMUM, newMaximum, newMaximum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyExpression getDelta()
  {
    return delta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelta(PropertyExpression newDelta, NotificationChain msgs)
  {
    PropertyExpression oldDelta = delta;
    delta = newDelta;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.ARANGE__DELTA, oldDelta, newDelta);
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
  public void setDelta(PropertyExpression newDelta)
  {
    if (newDelta != delta)
    {
      NotificationChain msgs = null;
      if (delta != null)
        msgs = ((InternalEObject)delta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.ARANGE__DELTA, null, msgs);
      if (newDelta != null)
        msgs = ((InternalEObject)newDelta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.ARANGE__DELTA, null, msgs);
      msgs = basicSetDelta(newDelta, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ARANGE__DELTA, newDelta, newDelta));
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
      case CommonPackage.ARANGE__MINIMUM:
        return basicSetMinimum(null, msgs);
      case CommonPackage.ARANGE__MAXIMUM:
        return basicSetMaximum(null, msgs);
      case CommonPackage.ARANGE__DELTA:
        return basicSetDelta(null, msgs);
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
      case CommonPackage.ARANGE__MINIMUM:
        return getMinimum();
      case CommonPackage.ARANGE__MAXIMUM:
        return getMaximum();
      case CommonPackage.ARANGE__DELTA:
        return getDelta();
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
      case CommonPackage.ARANGE__MINIMUM:
        setMinimum((PropertyExpression)newValue);
        return;
      case CommonPackage.ARANGE__MAXIMUM:
        setMaximum((PropertyExpression)newValue);
        return;
      case CommonPackage.ARANGE__DELTA:
        setDelta((PropertyExpression)newValue);
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
      case CommonPackage.ARANGE__MINIMUM:
        setMinimum((PropertyExpression)null);
        return;
      case CommonPackage.ARANGE__MAXIMUM:
        setMaximum((PropertyExpression)null);
        return;
      case CommonPackage.ARANGE__DELTA:
        setDelta((PropertyExpression)null);
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
      case CommonPackage.ARANGE__MINIMUM:
        return minimum != null;
      case CommonPackage.ARANGE__MAXIMUM:
        return maximum != null;
      case CommonPackage.ARANGE__DELTA:
        return delta != null;
    }
    return super.eIsSet(featureID);
  }

} //ARangeImpl
