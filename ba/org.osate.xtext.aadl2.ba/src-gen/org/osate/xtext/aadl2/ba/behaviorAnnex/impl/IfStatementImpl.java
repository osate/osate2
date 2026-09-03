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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl#getThenActions <em>Then Actions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl#getElseIfs <em>Else Ifs</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl#getElseActions <em>Else Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends BehaviorActionImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected ValueExpression condition;

  /**
   * The cached value of the '{@link #getThenActions() <em>Then Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenActions()
   * @generated
   * @ordered
   */
  protected BehaviorActions thenActions;

  /**
   * The cached value of the '{@link #getElseIfs() <em>Else Ifs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseIfs()
   * @generated
   * @ordered
   */
  protected EList<ElseIfClause> elseIfs;

  /**
   * The cached value of the '{@link #getElseActions() <em>Else Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseActions()
   * @generated
   * @ordered
   */
  protected BehaviorActions elseActions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return BehaviorAnnexPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(ValueExpression newCondition, NotificationChain msgs)
  {
    ValueExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.IF_STATEMENT__CONDITION, oldCondition, newCondition);
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
  public void setCondition(ValueExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.IF_STATEMENT__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.IF_STATEMENT__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.IF_STATEMENT__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActions getThenActions()
  {
    return thenActions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenActions(BehaviorActions newThenActions, NotificationChain msgs)
  {
    BehaviorActions oldThenActions = thenActions;
    thenActions = newThenActions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS, oldThenActions, newThenActions);
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
  public void setThenActions(BehaviorActions newThenActions)
  {
    if (newThenActions != thenActions)
    {
      NotificationChain msgs = null;
      if (thenActions != null)
        msgs = ((InternalEObject)thenActions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS, null, msgs);
      if (newThenActions != null)
        msgs = ((InternalEObject)newThenActions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS, null, msgs);
      msgs = basicSetThenActions(newThenActions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS, newThenActions, newThenActions));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ElseIfClause> getElseIfs()
  {
    if (elseIfs == null)
    {
      elseIfs = new EObjectContainmentEList<ElseIfClause>(ElseIfClause.class, this, BehaviorAnnexPackage.IF_STATEMENT__ELSE_IFS);
    }
    return elseIfs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActions getElseActions()
  {
    return elseActions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseActions(BehaviorActions newElseActions, NotificationChain msgs)
  {
    BehaviorActions oldElseActions = elseActions;
    elseActions = newElseActions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS, oldElseActions, newElseActions);
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
  public void setElseActions(BehaviorActions newElseActions)
  {
    if (newElseActions != elseActions)
    {
      NotificationChain msgs = null;
      if (elseActions != null)
        msgs = ((InternalEObject)elseActions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS, null, msgs);
      if (newElseActions != null)
        msgs = ((InternalEObject)newElseActions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS, null, msgs);
      msgs = basicSetElseActions(newElseActions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS, newElseActions, newElseActions));
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
      case BehaviorAnnexPackage.IF_STATEMENT__CONDITION:
        return basicSetCondition(null, msgs);
      case BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS:
        return basicSetThenActions(null, msgs);
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_IFS:
        return ((InternalEList<?>)getElseIfs()).basicRemove(otherEnd, msgs);
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS:
        return basicSetElseActions(null, msgs);
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
      case BehaviorAnnexPackage.IF_STATEMENT__CONDITION:
        return getCondition();
      case BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS:
        return getThenActions();
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_IFS:
        return getElseIfs();
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS:
        return getElseActions();
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
      case BehaviorAnnexPackage.IF_STATEMENT__CONDITION:
        setCondition((ValueExpression)newValue);
        return;
      case BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS:
        setThenActions((BehaviorActions)newValue);
        return;
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_IFS:
        getElseIfs().clear();
        getElseIfs().addAll((Collection<? extends ElseIfClause>)newValue);
        return;
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS:
        setElseActions((BehaviorActions)newValue);
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
      case BehaviorAnnexPackage.IF_STATEMENT__CONDITION:
        setCondition((ValueExpression)null);
        return;
      case BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS:
        setThenActions((BehaviorActions)null);
        return;
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_IFS:
        getElseIfs().clear();
        return;
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS:
        setElseActions((BehaviorActions)null);
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
      case BehaviorAnnexPackage.IF_STATEMENT__CONDITION:
        return condition != null;
      case BehaviorAnnexPackage.IF_STATEMENT__THEN_ACTIONS:
        return thenActions != null;
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_IFS:
        return elseIfs != null && !elseIfs.isEmpty();
      case BehaviorAnnexPackage.IF_STATEMENT__ELSE_ACTIONS:
        return elseActions != null;
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
