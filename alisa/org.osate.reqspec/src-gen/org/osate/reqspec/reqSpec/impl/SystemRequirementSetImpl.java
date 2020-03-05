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
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentClassifier;

import org.osate.reqspec.reqSpec.IncludeGlobalRequirement;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.SystemRequirementSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Requirement Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.SystemRequirementSetImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.SystemRequirementSetImpl#getInclude <em>Include</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemRequirementSetImpl extends RequirementSetImpl implements SystemRequirementSet
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected ComponentClassifier target;

  /**
   * The cached value of the '{@link #getInclude() <em>Include</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInclude()
   * @generated
   * @ordered
   */
  protected EList<IncludeGlobalRequirement> include;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemRequirementSetImpl()
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
    return ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComponentClassifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentClassifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.SYSTEM_REQUIREMENT_SET__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(ComponentClassifier newTarget)
  {
    ComponentClassifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.SYSTEM_REQUIREMENT_SET__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IncludeGlobalRequirement> getInclude()
  {
    if (include == null)
    {
      include = new EObjectContainmentEList<IncludeGlobalRequirement>(IncludeGlobalRequirement.class, this, ReqSpecPackage.SYSTEM_REQUIREMENT_SET__INCLUDE);
    }
    return include;
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
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__INCLUDE:
        return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__INCLUDE:
        return getInclude();
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
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__TARGET:
        setTarget((ComponentClassifier)newValue);
        return;
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__INCLUDE:
        getInclude().clear();
        getInclude().addAll((Collection<? extends IncludeGlobalRequirement>)newValue);
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
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__TARGET:
        setTarget((ComponentClassifier)null);
        return;
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__INCLUDE:
        getInclude().clear();
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
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__TARGET:
        return target != null;
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET__INCLUDE:
        return include != null && !include.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SystemRequirementSetImpl
