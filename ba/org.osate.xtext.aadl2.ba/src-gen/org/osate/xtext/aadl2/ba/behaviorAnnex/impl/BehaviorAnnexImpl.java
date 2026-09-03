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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl#getVariableGroups <em>Variable Groups</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl#getStateGroups <em>State Groups</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorAnnexImpl extends AnnexSubclauseImpl implements BehaviorAnnex
{
  /**
   * The cached value of the '{@link #getVariableGroups() <em>Variable Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableGroups()
   * @generated
   * @ordered
   */
  protected EList<BehaviorVariableGroup> variableGroups;

  /**
   * The cached value of the '{@link #getStateGroups() <em>State Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateGroups()
   * @generated
   * @ordered
   */
  protected EList<BehaviorStateGroup> stateGroups;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<BehaviorTransition> transitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorAnnexImpl()
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
    return BehaviorAnnexPackage.Literals.BEHAVIOR_ANNEX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorVariableGroup> getVariableGroups()
  {
    if (variableGroups == null)
    {
      variableGroups = new EObjectContainmentEList<BehaviorVariableGroup>(BehaviorVariableGroup.class, this, BehaviorAnnexPackage.BEHAVIOR_ANNEX__VARIABLE_GROUPS);
    }
    return variableGroups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorStateGroup> getStateGroups()
  {
    if (stateGroups == null)
    {
      stateGroups = new EObjectContainmentEList<BehaviorStateGroup>(BehaviorStateGroup.class, this, BehaviorAnnexPackage.BEHAVIOR_ANNEX__STATE_GROUPS);
    }
    return stateGroups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorTransition> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<BehaviorTransition>(BehaviorTransition.class, this, BehaviorAnnexPackage.BEHAVIOR_ANNEX__TRANSITIONS);
    }
    return transitions;
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
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__VARIABLE_GROUPS:
        return ((InternalEList<?>)getVariableGroups()).basicRemove(otherEnd, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__STATE_GROUPS:
        return ((InternalEList<?>)getStateGroups()).basicRemove(otherEnd, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__VARIABLE_GROUPS:
        return getVariableGroups();
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__STATE_GROUPS:
        return getStateGroups();
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        return getTransitions();
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
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__VARIABLE_GROUPS:
        getVariableGroups().clear();
        getVariableGroups().addAll((Collection<? extends BehaviorVariableGroup>)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__STATE_GROUPS:
        getStateGroups().clear();
        getStateGroups().addAll((Collection<? extends BehaviorStateGroup>)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends BehaviorTransition>)newValue);
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
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__VARIABLE_GROUPS:
        getVariableGroups().clear();
        return;
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__STATE_GROUPS:
        getStateGroups().clear();
        return;
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        getTransitions().clear();
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
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__VARIABLE_GROUPS:
        return variableGroups != null && !variableGroups.isEmpty();
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__STATE_GROUPS:
        return stateGroups != null && !stateGroups.isEmpty();
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BehaviorAnnexImpl
