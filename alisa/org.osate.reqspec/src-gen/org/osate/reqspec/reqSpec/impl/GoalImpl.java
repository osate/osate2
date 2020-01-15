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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.organization.organization.Stakeholder;

import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getConflictsReference <em>Conflicts Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.GoalImpl#getStakeholderReference <em>Stakeholder Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends ContractualElementImpl implements Goal
{
  /**
   * The cached value of the '{@link #getRefinesReference() <em>Refines Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinesReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> refinesReference;

  /**
   * The cached value of the '{@link #getConflictsReference() <em>Conflicts Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConflictsReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> conflictsReference;

  /**
   * The cached value of the '{@link #getStakeholderReference() <em>Stakeholder Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStakeholderReference()
   * @generated
   * @ordered
   */
  protected EList<Stakeholder> stakeholderReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GoalImpl()
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
    return ReqSpecPackage.Literals.GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Goal> getRefinesReference()
  {
    if (refinesReference == null)
    {
      refinesReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__REFINES_REFERENCE);
    }
    return refinesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Goal> getConflictsReference()
  {
    if (conflictsReference == null)
    {
      conflictsReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.GOAL__CONFLICTS_REFERENCE);
    }
    return conflictsReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Stakeholder> getStakeholderReference()
  {
    if (stakeholderReference == null)
    {
      stakeholderReference = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE);
    }
    return stakeholderReference;
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        return getRefinesReference();
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        return getConflictsReference();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        return getStakeholderReference();
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        getRefinesReference().clear();
        getRefinesReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        getConflictsReference().clear();
        getConflictsReference().addAll((Collection<? extends Goal>)newValue);
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        getStakeholderReference().clear();
        getStakeholderReference().addAll((Collection<? extends Stakeholder>)newValue);
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        getRefinesReference().clear();
        return;
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        getConflictsReference().clear();
        return;
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        getStakeholderReference().clear();
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
      case ReqSpecPackage.GOAL__REFINES_REFERENCE:
        return refinesReference != null && !refinesReference.isEmpty();
      case ReqSpecPackage.GOAL__CONFLICTS_REFERENCE:
        return conflictsReference != null && !conflictsReference.isEmpty();
      case ReqSpecPackage.GOAL__STAKEHOLDER_REFERENCE:
        return stakeholderReference != null && !stakeholderReference.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GoalImpl
