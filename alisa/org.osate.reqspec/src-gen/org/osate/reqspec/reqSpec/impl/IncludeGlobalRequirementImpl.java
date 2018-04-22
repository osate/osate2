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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.osate.aadl2.ComponentCategory;
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
 *   <li>{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl#isSelf <em>Self</em>}</li>
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
   * The cached value of the '{@link #getComponentCategory() <em>Component Category</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentCategory()
   * @generated
   * @ordered
   */
  protected EList<ComponentCategory> componentCategory;

  /**
   * The default value of the '{@link #isSelf() <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelf()
   * @generated
   * @ordered
   */
  protected static final boolean SELF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSelf() <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelf()
   * @generated
   * @ordered
   */
  protected boolean self = SELF_EDEFAULT;

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
  public EList<ComponentCategory> getComponentCategory()
  {
    if (componentCategory == null)
    {
      componentCategory = new EDataTypeEList<ComponentCategory>(ComponentCategory.class, this, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__COMPONENT_CATEGORY);
    }
    return componentCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSelf()
  {
    return self;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelf(boolean newSelf)
  {
    boolean oldSelf = self;
    self = newSelf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__SELF, oldSelf, self));
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__COMPONENT_CATEGORY:
        return getComponentCategory();
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__SELF:
        return isSelf();
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE:
        setInclude((EObject)newValue);
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        getComponentCategory().addAll((Collection<? extends ComponentCategory>)newValue);
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__SELF:
        setSelf((Boolean)newValue);
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        return;
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__SELF:
        setSelf(SELF_EDEFAULT);
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
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__COMPONENT_CATEGORY:
        return componentCategory != null && !componentCategory.isEmpty();
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT__SELF:
        return self != SELF_EDEFAULT;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (componentCategory: ");
    result.append(componentCategory);
    result.append(", self: ");
    result.append(self);
    result.append(')');
    return result.toString();
  }

} //IncludeGlobalRequirementImpl
