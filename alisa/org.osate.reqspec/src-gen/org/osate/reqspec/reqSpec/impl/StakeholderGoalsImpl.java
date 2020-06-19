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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;

import org.osate.alisa.common.common.ValDeclaration;

import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.StakeholderGoals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Goals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getImportConstants <em>Import Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl#getGoals <em>Goals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StakeholderGoalsImpl extends ReqRootImpl implements StakeholderGoals
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
   * The cached value of the '{@link #getComponentCategory() <em>Component Category</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentCategory()
   * @generated
   * @ordered
   */
  protected EList<ComponentCategory> componentCategory;

  /**
   * The cached value of the '{@link #getImportConstants() <em>Import Constants</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportConstants()
   * @generated
   * @ordered
   */
  protected EList<GlobalConstants> importConstants;

  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<ValDeclaration> constants;

  /**
   * The cached value of the '{@link #getGoals() <em>Goals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGoals()
   * @generated
   * @ordered
   */
  protected EList<Goal> goals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StakeholderGoalsImpl()
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
    return ReqSpecPackage.Literals.STAKEHOLDER_GOALS;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.STAKEHOLDER_GOALS__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.STAKEHOLDER_GOALS__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ComponentCategory> getComponentCategory()
  {
    if (componentCategory == null)
    {
      componentCategory = new EDataTypeEList<ComponentCategory>(ComponentCategory.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY);
    }
    return componentCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<GlobalConstants> getImportConstants()
  {
    if (importConstants == null)
    {
      importConstants = new EObjectResolvingEList<GlobalConstants>(GlobalConstants.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS);
    }
    return importConstants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ValDeclaration> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<ValDeclaration>(ValDeclaration.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Goal> getGoals()
  {
    if (goals == null)
    {
      goals = new EObjectContainmentEList<Goal>(Goal.class, this, ReqSpecPackage.STAKEHOLDER_GOALS__GOALS);
    }
    return goals;
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.STAKEHOLDER_GOALS__GOALS:
        return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        return getComponentCategory();
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        return getImportConstants();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        return getConstants();
      case ReqSpecPackage.STAKEHOLDER_GOALS__GOALS:
        return getGoals();
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        setTarget((ComponentClassifier)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        getComponentCategory().addAll((Collection<? extends ComponentCategory>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        getImportConstants().clear();
        getImportConstants().addAll((Collection<? extends GlobalConstants>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends ValDeclaration>)newValue);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__GOALS:
        getGoals().clear();
        getGoals().addAll((Collection<? extends Goal>)newValue);
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        setTarget((ComponentClassifier)null);
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        getComponentCategory().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        getImportConstants().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        getConstants().clear();
        return;
      case ReqSpecPackage.STAKEHOLDER_GOALS__GOALS:
        getGoals().clear();
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
      case ReqSpecPackage.STAKEHOLDER_GOALS__TARGET:
        return target != null;
      case ReqSpecPackage.STAKEHOLDER_GOALS__COMPONENT_CATEGORY:
        return componentCategory != null && !componentCategory.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__IMPORT_CONSTANTS:
        return importConstants != null && !importConstants.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case ReqSpecPackage.STAKEHOLDER_GOALS__GOALS:
        return goals != null && !goals.isEmpty();
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
    result.append(" (componentCategory: ");
    result.append(componentCategory);
    result.append(')');
    return result.toString();
  }

} //StakeholderGoalsImpl
