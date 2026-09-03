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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior State Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl#isComplete <em>Complete</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl#isFinal <em>Final</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorStateGroupImpl extends MinimalEObjectImpl.Container implements BehaviorStateGroup
{
  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<BehaviorState> states;

  /**
   * The default value of the '{@link #isInitial() <em>Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInitial()
   * @generated
   * @ordered
   */
  protected static final boolean INITIAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInitial() <em>Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInitial()
   * @generated
   * @ordered
   */
  protected boolean initial = INITIAL_EDEFAULT;

  /**
   * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isComplete()
   * @generated
   * @ordered
   */
  protected static final boolean COMPLETE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isComplete() <em>Complete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isComplete()
   * @generated
   * @ordered
   */
  protected boolean complete = COMPLETE_EDEFAULT;

  /**
   * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected static final boolean FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected boolean final_ = FINAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorStateGroupImpl()
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
    return BehaviorAnnexPackage.Literals.BEHAVIOR_STATE_GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorState> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<BehaviorState>(BehaviorState.class, this, BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isInitial()
  {
    return initial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInitial(boolean newInitial)
  {
    boolean oldInitial = initial;
    initial = newInitial;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__INITIAL, oldInitial, initial));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isComplete()
  {
    return complete;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setComplete(boolean newComplete)
  {
    boolean oldComplete = complete;
    complete = newComplete;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__COMPLETE, oldComplete, complete));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFinal()
  {
    return final_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFinal(boolean newFinal)
  {
    boolean oldFinal = final_;
    final_ = newFinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__FINAL, oldFinal, final_));
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
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__STATES:
        return getStates();
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__INITIAL:
        return isInitial();
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__COMPLETE:
        return isComplete();
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__FINAL:
        return isFinal();
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
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends BehaviorState>)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__INITIAL:
        setInitial((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__COMPLETE:
        setComplete((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__FINAL:
        setFinal((Boolean)newValue);
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
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__STATES:
        getStates().clear();
        return;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__INITIAL:
        setInitial(INITIAL_EDEFAULT);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__COMPLETE:
        setComplete(COMPLETE_EDEFAULT);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__FINAL:
        setFinal(FINAL_EDEFAULT);
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
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__STATES:
        return states != null && !states.isEmpty();
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__INITIAL:
        return initial != INITIAL_EDEFAULT;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__COMPLETE:
        return complete != COMPLETE_EDEFAULT;
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP__FINAL:
        return final_ != FINAL_EDEFAULT;
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
    result.append(" (initial: ");
    result.append(initial);
    result.append(", complete: ");
    result.append(complete);
    result.append(", final: ");
    result.append(final_);
    result.append(')');
    return result.toString();
  }

} //BehaviorStateGroupImpl
