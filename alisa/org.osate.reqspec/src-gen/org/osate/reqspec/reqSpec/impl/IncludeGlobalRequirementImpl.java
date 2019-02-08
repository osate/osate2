/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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
  public boolean isLocal()
  {
    return local;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
