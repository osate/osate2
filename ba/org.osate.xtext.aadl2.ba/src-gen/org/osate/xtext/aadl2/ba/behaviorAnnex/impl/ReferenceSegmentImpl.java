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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceSegmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceSegmentImpl#getIndexes <em>Indexes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceSegmentImpl extends MinimalEObjectImpl.Container implements ReferenceSegment
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected EObject name;

  /**
   * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexes()
   * @generated
   * @ordered
   */
  protected EList<ArrayIndex> indexes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceSegmentImpl()
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
    return BehaviorAnnexPackage.Literals.REFERENCE_SEGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getName()
  {
    if (name != null && name.eIsProxy())
    {
      InternalEObject oldName = (InternalEObject)name;
      name = eResolveProxy(oldName);
      if (name != oldName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorAnnexPackage.REFERENCE_SEGMENT__NAME, oldName, name));
      }
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(EObject newName)
  {
    EObject oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.REFERENCE_SEGMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ArrayIndex> getIndexes()
  {
    if (indexes == null)
    {
      indexes = new EObjectContainmentEList<ArrayIndex>(ArrayIndex.class, this, BehaviorAnnexPackage.REFERENCE_SEGMENT__INDEXES);
    }
    return indexes;
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
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__INDEXES:
        return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
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
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__NAME:
        if (resolve) return getName();
        return basicGetName();
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__INDEXES:
        return getIndexes();
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
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__NAME:
        setName((EObject)newValue);
        return;
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__INDEXES:
        getIndexes().clear();
        getIndexes().addAll((Collection<? extends ArrayIndex>)newValue);
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
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__NAME:
        setName((EObject)null);
        return;
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__INDEXES:
        getIndexes().clear();
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
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__NAME:
        return name != null;
      case BehaviorAnnexPackage.REFERENCE_SEGMENT__INDEXES:
        return indexes != null && !indexes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ReferenceSegmentImpl
