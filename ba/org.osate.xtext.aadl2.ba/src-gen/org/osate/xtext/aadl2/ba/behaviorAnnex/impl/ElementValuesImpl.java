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
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Values</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElementValuesImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElementValuesImpl#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementValuesImpl extends MinimalEObjectImpl.Container implements ElementValues
{
  /**
   * The cached value of the '{@link #getLower() <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected IntegerValue lower;

  /**
   * The cached value of the '{@link #getUpper() <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected IntegerValue upper;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementValuesImpl()
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
    return BehaviorAnnexPackage.Literals.ELEMENT_VALUES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegerValue getLower()
  {
    return lower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLower(IntegerValue newLower, NotificationChain msgs)
  {
    IntegerValue oldLower = lower;
    lower = newLower;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.ELEMENT_VALUES__LOWER, oldLower, newLower);
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
  public void setLower(IntegerValue newLower)
  {
    if (newLower != lower)
    {
      NotificationChain msgs = null;
      if (lower != null)
        msgs = ((InternalEObject)lower).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.ELEMENT_VALUES__LOWER, null, msgs);
      if (newLower != null)
        msgs = ((InternalEObject)newLower).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.ELEMENT_VALUES__LOWER, null, msgs);
      msgs = basicSetLower(newLower, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.ELEMENT_VALUES__LOWER, newLower, newLower));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegerValue getUpper()
  {
    return upper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpper(IntegerValue newUpper, NotificationChain msgs)
  {
    IntegerValue oldUpper = upper;
    upper = newUpper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.ELEMENT_VALUES__UPPER, oldUpper, newUpper);
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
  public void setUpper(IntegerValue newUpper)
  {
    if (newUpper != upper)
    {
      NotificationChain msgs = null;
      if (upper != null)
        msgs = ((InternalEObject)upper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.ELEMENT_VALUES__UPPER, null, msgs);
      if (newUpper != null)
        msgs = ((InternalEObject)newUpper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.ELEMENT_VALUES__UPPER, null, msgs);
      msgs = basicSetUpper(newUpper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.ELEMENT_VALUES__UPPER, newUpper, newUpper));
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
      case BehaviorAnnexPackage.ELEMENT_VALUES__LOWER:
        return basicSetLower(null, msgs);
      case BehaviorAnnexPackage.ELEMENT_VALUES__UPPER:
        return basicSetUpper(null, msgs);
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
      case BehaviorAnnexPackage.ELEMENT_VALUES__LOWER:
        return getLower();
      case BehaviorAnnexPackage.ELEMENT_VALUES__UPPER:
        return getUpper();
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
      case BehaviorAnnexPackage.ELEMENT_VALUES__LOWER:
        setLower((IntegerValue)newValue);
        return;
      case BehaviorAnnexPackage.ELEMENT_VALUES__UPPER:
        setUpper((IntegerValue)newValue);
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
      case BehaviorAnnexPackage.ELEMENT_VALUES__LOWER:
        setLower((IntegerValue)null);
        return;
      case BehaviorAnnexPackage.ELEMENT_VALUES__UPPER:
        setUpper((IntegerValue)null);
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
      case BehaviorAnnexPackage.ELEMENT_VALUES__LOWER:
        return lower != null;
      case BehaviorAnnexPackage.ELEMENT_VALUES__UPPER:
        return upper != null;
    }
    return super.eIsSet(featureID);
  }

} //ElementValuesImpl
