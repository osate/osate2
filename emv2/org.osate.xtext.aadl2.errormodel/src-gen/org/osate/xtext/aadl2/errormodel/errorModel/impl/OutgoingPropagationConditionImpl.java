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
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outgoing Propagation Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#isAllStates <em>All States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#isAllPropagations <em>All Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getTypeToken <em>Type Token</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutgoingPropagationConditionImpl extends NamedElementImpl implements OutgoingPropagationCondition
{
  /**
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState state;

  /**
   * The cached value of the '{@link #getTypeTokenConstraint() <em>Type Token Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeTokenConstraint()
   * @generated
   * @ordered
   */
  protected TypeSet typeTokenConstraint;

  /**
   * The default value of the '{@link #isAllStates() <em>All States</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllStates()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_STATES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllStates() <em>All States</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllStates()
   * @generated
   * @ordered
   */
  protected boolean allStates = ALL_STATES_EDEFAULT;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected ConditionExpression condition;

  /**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected ErrorPropagation outgoing;

  /**
   * The default value of the '{@link #isAllPropagations() <em>All Propagations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllPropagations()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_PROPAGATIONS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllPropagations() <em>All Propagations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllPropagations()
   * @generated
   * @ordered
   */
  protected boolean allPropagations = ALL_PROPAGATIONS_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeToken() <em>Type Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeToken()
   * @generated
   * @ordered
   */
  protected TypeSet typeToken;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutgoingPropagationConditionImpl()
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
    return ErrorModelPackage.Literals.OUTGOING_PROPAGATION_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (ErrorBehaviorState)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(ErrorBehaviorState newState)
  {
    ErrorBehaviorState oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE, oldState, state));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTypeTokenConstraint()
  {
    return typeTokenConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeTokenConstraint(TypeSet newTypeTokenConstraint, NotificationChain msgs)
  {
    TypeSet oldTypeTokenConstraint = typeTokenConstraint;
    typeTokenConstraint = newTypeTokenConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, oldTypeTokenConstraint, newTypeTokenConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeTokenConstraint(TypeSet newTypeTokenConstraint)
  {
    if (newTypeTokenConstraint != typeTokenConstraint)
    {
      NotificationChain msgs = null;
      if (typeTokenConstraint != null)
        msgs = ((InternalEObject)typeTokenConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, null, msgs);
      if (newTypeTokenConstraint != null)
        msgs = ((InternalEObject)newTypeTokenConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, null, msgs);
      msgs = basicSetTypeTokenConstraint(newTypeTokenConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, newTypeTokenConstraint, newTypeTokenConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllStates()
  {
    return allStates;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllStates(boolean newAllStates)
  {
    boolean oldAllStates = allStates;
    allStates = newAllStates;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_STATES, oldAllStates, allStates));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(ConditionExpression newCondition, NotificationChain msgs)
  {
    ConditionExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(ConditionExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation getOutgoing()
  {
    if (outgoing != null && outgoing.eIsProxy())
    {
      InternalEObject oldOutgoing = (InternalEObject)outgoing;
      outgoing = (ErrorPropagation)eResolveProxy(oldOutgoing);
      if (outgoing != oldOutgoing)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING, oldOutgoing, outgoing));
      }
    }
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation basicGetOutgoing()
  {
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutgoing(ErrorPropagation newOutgoing)
  {
    ErrorPropagation oldOutgoing = outgoing;
    outgoing = newOutgoing;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING, oldOutgoing, outgoing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllPropagations()
  {
    return allPropagations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllPropagations(boolean newAllPropagations)
  {
    boolean oldAllPropagations = allPropagations;
    allPropagations = newAllPropagations;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_PROPAGATIONS, oldAllPropagations, allPropagations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTypeToken()
  {
    return typeToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeToken(TypeSet newTypeToken, NotificationChain msgs)
  {
    TypeSet oldTypeToken = typeToken;
    typeToken = newTypeToken;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, oldTypeToken, newTypeToken);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeToken(TypeSet newTypeToken)
  {
    if (newTypeToken != typeToken)
    {
      NotificationChain msgs = null;
      if (typeToken != null)
        msgs = ((InternalEObject)typeToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, null, msgs);
      if (newTypeToken != null)
        msgs = ((InternalEObject)newTypeToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, null, msgs);
      msgs = basicSetTypeToken(newTypeToken, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, newTypeToken, newTypeToken));
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
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
        return basicSetTypeTokenConstraint(null, msgs);
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
        return basicSetCondition(null, msgs);
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
        return basicSetTypeToken(null, msgs);
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
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
        if (resolve) return getState();
        return basicGetState();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
        return getTypeTokenConstraint();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_STATES:
        return isAllStates();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
        return getCondition();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
        if (resolve) return getOutgoing();
        return basicGetOutgoing();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_PROPAGATIONS:
        return isAllPropagations();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
        return getTypeToken();
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
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
        setState((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
        setTypeTokenConstraint((TypeSet)newValue);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_STATES:
        setAllStates((Boolean)newValue);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
        setCondition((ConditionExpression)newValue);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
        setOutgoing((ErrorPropagation)newValue);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_PROPAGATIONS:
        setAllPropagations((Boolean)newValue);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
        setTypeToken((TypeSet)newValue);
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
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
        setState((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
        setTypeTokenConstraint((TypeSet)null);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_STATES:
        setAllStates(ALL_STATES_EDEFAULT);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
        setCondition((ConditionExpression)null);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
        setOutgoing((ErrorPropagation)null);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_PROPAGATIONS:
        setAllPropagations(ALL_PROPAGATIONS_EDEFAULT);
        return;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
        setTypeToken((TypeSet)null);
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
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
        return state != null;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
        return typeTokenConstraint != null;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_STATES:
        return allStates != ALL_STATES_EDEFAULT;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
        return condition != null;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
        return outgoing != null;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL_PROPAGATIONS:
        return allPropagations != ALL_PROPAGATIONS_EDEFAULT;
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
        return typeToken != null;
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
    result.append(" (allStates: ");
    result.append(allStates);
    result.append(", allPropagations: ");
    result.append(allPropagations);
    result.append(')');
    return result.toString();
  }

} //OutgoingPropagationConditionImpl
