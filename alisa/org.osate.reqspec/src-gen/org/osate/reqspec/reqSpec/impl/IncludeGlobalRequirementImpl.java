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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.NamedElement;

import org.osate.reqspec.reqSpec.IncludeGlobalRequirement;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include Global Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IncludeGlobalRequirementImpl extends MinimalEObjectImpl.Container implements IncludeGlobalRequirement
{
  /**
   * The cached value of the '{@link #getInclude() <em>Include</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInclude()
   * @generated
   * @ordered
   */
  protected EObject include;

  /**
   * The default value of the '{@link #isLocal() <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocal()
   * @generated
   * @ordered
   */
  protected static final boolean LOCAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLocal() <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocal()
   * @generated
   * @ordered
   */
  protected boolean local = LOCAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetElement()
   * @generated
   * @ordered
   */
  protected NamedElement targetElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IncludeGlobalRequirementImpl()
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
    return ReqSpecPackage.Literals.INCLUDE_GLOBAL_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getInclude()
  {
    if (include != null && include.eIsProxy())
    {
      InternalEObject oldInclude = (InternalEObject)include;
      include = eResolveProxy(oldInclude);
      if (include != oldInclude)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE, oldInclude, include));
      }
    }
    return include;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetInclude()
  {
    return include;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInclude(EObject newInclude)
  {
    EObject oldInclude = include;
    include = newInclude;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE, oldInclude, include));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isLocal()
  {
    return local;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLocal(boolean newLocal)
  {
    boolean oldLocal = local;
    local = newLocal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__LOCAL, oldLocal, local));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElement getTargetElement()
  {
    if (targetElement != null && ((EObject)targetElement).eIsProxy())
    {
      InternalEObject oldTargetElement = (InternalEObject)targetElement;
      targetElement = (NamedElement)eResolveProxy(oldTargetElement);
      if (targetElement != oldTargetElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT, oldTargetElement, targetElement));
      }
    }
    return targetElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetTargetElement()
  {
    return targetElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTargetElement(NamedElement newTargetElement)
  {
    NamedElement oldTargetElement = targetElement;
    targetElement = newTargetElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT, oldTargetElement, targetElement));
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE:
        if (resolve) return getInclude();
        return basicGetInclude();
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__LOCAL:
        return isLocal();
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT:
        if (resolve) return getTargetElement();
        return basicGetTargetElement();
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE:
        setInclude((EObject)newValue);
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__LOCAL:
        setLocal((Boolean)newValue);
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT:
        setTargetElement((NamedElement)newValue);
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE:
        setInclude((EObject)null);
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__LOCAL:
        setLocal(LOCAL_EDEFAULT);
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT:
        setTargetElement((NamedElement)null);
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE:
        return include != null;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__LOCAL:
        return local != LOCAL_EDEFAULT;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT:
        return targetElement != null;
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
    result.append(" (local: ");
    result.append(local);
    result.append(')');
    return result.toString();
  }

} //IncludeGlobalRequirementImpl
