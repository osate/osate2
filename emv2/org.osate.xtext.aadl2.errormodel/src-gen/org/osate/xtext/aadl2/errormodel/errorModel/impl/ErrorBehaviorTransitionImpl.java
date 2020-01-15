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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#isAllStates <em>All States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#isSteadyState <em>Steady State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl#getDestinationBranches <em>Destination Branches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorBehaviorTransitionImpl extends NamedElementImpl implements ErrorBehaviorTransition
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState source;

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
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState target;

  /**
   * The cached value of the '{@link #getTargetToken() <em>Target Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetToken()
   * @generated
   * @ordered
   */
  protected TypeSet targetToken;

  /**
   * The default value of the '{@link #isSteadyState() <em>Steady State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSteadyState()
   * @generated
   * @ordered
   */
  protected static final boolean STEADY_STATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSteadyState() <em>Steady State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSteadyState()
   * @generated
   * @ordered
   */
  protected boolean steadyState = STEADY_STATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDestinationBranches() <em>Destination Branches</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestinationBranches()
   * @generated
   * @ordered
   */
  protected EList<TransitionBranch> destinationBranches;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorBehaviorTransitionImpl()
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
    return ErrorModelPackage.Literals.ERROR_BEHAVIOR_TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (ErrorBehaviorState)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(ErrorBehaviorState newSource)
  {
    ErrorBehaviorState oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE, oldSource, source));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT, oldTypeTokenConstraint, newTypeTokenConstraint);
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
        msgs = ((InternalEObject)typeTokenConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT, null, msgs);
      if (newTypeTokenConstraint != null)
        msgs = ((InternalEObject)newTypeTokenConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT, null, msgs);
      msgs = basicSetTypeTokenConstraint(newTypeTokenConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT, newTypeTokenConstraint, newTypeTokenConstraint));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__ALL_STATES, oldAllStates, allStates));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ErrorBehaviorState)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ErrorBehaviorState newTarget)
  {
    ErrorBehaviorState oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTargetToken()
  {
    return targetToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetToken(TypeSet newTargetToken, NotificationChain msgs)
  {
    TypeSet oldTargetToken = targetToken;
    targetToken = newTargetToken;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN, oldTargetToken, newTargetToken);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetToken(TypeSet newTargetToken)
  {
    if (newTargetToken != targetToken)
    {
      NotificationChain msgs = null;
      if (targetToken != null)
        msgs = ((InternalEObject)targetToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN, null, msgs);
      if (newTargetToken != null)
        msgs = ((InternalEObject)newTargetToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN, null, msgs);
      msgs = basicSetTargetToken(newTargetToken, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN, newTargetToken, newTargetToken));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSteadyState()
  {
    return steadyState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSteadyState(boolean newSteadyState)
  {
    boolean oldSteadyState = steadyState;
    steadyState = newSteadyState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__STEADY_STATE, oldSteadyState, steadyState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransitionBranch> getDestinationBranches()
  {
    if (destinationBranches == null)
    {
      destinationBranches = new EObjectContainmentEList<TransitionBranch>(TransitionBranch.class, this, ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES);
    }
    return destinationBranches;
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT:
        return basicSetTypeTokenConstraint(null, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION:
        return basicSetCondition(null, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN:
        return basicSetTargetToken(null, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES:
        return ((InternalEList<?>)getDestinationBranches()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT:
        return getTypeTokenConstraint();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__ALL_STATES:
        return isAllStates();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION:
        return getCondition();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN:
        return getTargetToken();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__STEADY_STATE:
        return isSteadyState();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES:
        return getDestinationBranches();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        setSource((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT:
        setTypeTokenConstraint((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__ALL_STATES:
        setAllStates((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION:
        setCondition((ConditionExpression)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET:
        setTarget((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN:
        setTargetToken((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__STEADY_STATE:
        setSteadyState((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES:
        getDestinationBranches().clear();
        getDestinationBranches().addAll((Collection<? extends TransitionBranch>)newValue);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        setSource((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT:
        setTypeTokenConstraint((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__ALL_STATES:
        setAllStates(ALL_STATES_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION:
        setCondition((ConditionExpression)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET:
        setTarget((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN:
        setTargetToken((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__STEADY_STATE:
        setSteadyState(STEADY_STATE_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES:
        getDestinationBranches().clear();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__SOURCE:
        return source != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TYPE_TOKEN_CONSTRAINT:
        return typeTokenConstraint != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__ALL_STATES:
        return allStates != ALL_STATES_EDEFAULT;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__CONDITION:
        return condition != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET:
        return target != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__TARGET_TOKEN:
        return targetToken != null;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__STEADY_STATE:
        return steadyState != STEADY_STATE_EDEFAULT;
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION__DESTINATION_BRANCHES:
        return destinationBranches != null && !destinationBranches.isEmpty();
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
    result.append(", steadyState: ");
    result.append(steadyState);
    result.append(')');
    return result.toString();
  }

} //ErrorBehaviorTransitionImpl
