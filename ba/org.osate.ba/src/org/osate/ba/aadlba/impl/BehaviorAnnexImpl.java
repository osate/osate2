/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.impl;

import java.util.Collection ;
import java.util.Map ;
import java.util.WeakHashMap ;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.impl.AnnexSubclauseImpl ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorCondition ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.texteditor.AadlBaHighlighter ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitor ;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorAnnexImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorAnnexImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorAnnexImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorAnnexImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorAnnexImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorAnnexImpl#getInitialState <em>Initial State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorAnnexImpl extends AnnexSubclauseImpl implements BehaviorAnnex
{
  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<BehaviorVariable> variables;

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
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<BehaviorTransition> transitions;

  /**
   * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActions()
   * @generated
   * @ordered
   */
  protected EList<BehaviorActionBlock> actions;

  /**
   * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditions()
   * @generated
   * @ordered
   */
  protected EList<BehaviorCondition> conditions;

  /**
   * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialState()
   * @generated
   * @ordered
   */
  protected BehaviorState initialState;

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
    return AadlBaPackage.Literals.BEHAVIOR_ANNEX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorVariable> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList.Unsettable<BehaviorVariable>(BehaviorVariable.class, this, AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetVariables()
  {
    if (variables != null)
    {
      ((InternalEList.Unsettable<?>)variables).unset();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetVariables()
  {
    return variables != null && ((InternalEList.Unsettable<?>)variables).isSet();
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
      states = new EObjectContainmentEList.Unsettable<BehaviorState>(BehaviorState.class, this, AadlBaPackage.BEHAVIOR_ANNEX__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetStates()
  {
    if (states != null)
    {
      ((InternalEList.Unsettable<?>)states).unset();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetStates()
  {
    return states != null && ((InternalEList.Unsettable<?>)states).isSet();
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
      transitions = new EObjectContainmentEList.Unsettable<BehaviorTransition>(BehaviorTransition.class, this, AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS);
    }
    return transitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetTransitions()
  {
    if (transitions != null)
    {
      ((InternalEList.Unsettable<?>)transitions).unset();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetTransitions()
  {
    return transitions != null && ((InternalEList.Unsettable<?>)transitions).isSet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorActionBlock> getActions()
  {
    if (actions == null)
    {
      actions = new EObjectContainmentEList<BehaviorActionBlock>(BehaviorActionBlock.class, this, AadlBaPackage.BEHAVIOR_ANNEX__ACTIONS);
    }
    return actions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorCondition> getConditions()
  {
    if (conditions == null)
    {
      conditions = new EObjectContainmentEList<BehaviorCondition>(BehaviorCondition.class, this, AadlBaPackage.BEHAVIOR_ANNEX__CONDITIONS);
    }
    return conditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorState getInitialState()
  {
    if (initialState != null && ((EObject)initialState).eIsProxy())
    {
      InternalEObject oldInitialState = (InternalEObject)initialState;
      initialState = (BehaviorState)eResolveProxy(oldInitialState);
      if (initialState != oldInitialState)
      {
        if (eNotificationRequired())
        {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ANNEX__INITIAL_STATE, oldInitialState, initialState));
        }
      }
    }
    return initialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorState basicGetInitialState()
  {
    return initialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInitialState(BehaviorState newInitialState)
  {
    BehaviorState oldInitialState = initialState;
    initialState = newInitialState;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ANNEX__INITIAL_STATE, oldInitialState, initialState));
    }
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
      case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_ANNEX__ACTIONS:
        return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_ANNEX__CONDITIONS:
        return ((InternalEList<?>)getConditions()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
        return getVariables();
      case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
        return getStates();
      case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        return getTransitions();
      case AadlBaPackage.BEHAVIOR_ANNEX__ACTIONS:
        return getActions();
      case AadlBaPackage.BEHAVIOR_ANNEX__CONDITIONS:
        return getConditions();
      case AadlBaPackage.BEHAVIOR_ANNEX__INITIAL_STATE:
        if (resolve)
        {
          return getInitialState();
        }
        return basicGetInitialState();
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
      case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends BehaviorVariable>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends BehaviorState>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends BehaviorTransition>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__ACTIONS:
        getActions().clear();
        getActions().addAll((Collection<? extends BehaviorActionBlock>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__CONDITIONS:
        getConditions().clear();
        getConditions().addAll((Collection<? extends BehaviorCondition>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__INITIAL_STATE:
        setInitialState((BehaviorState)newValue);
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
      case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
        unsetVariables();
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
        unsetStates();
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        unsetTransitions();
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__ACTIONS:
        getActions().clear();
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__CONDITIONS:
        getConditions().clear();
        return;
      case AadlBaPackage.BEHAVIOR_ANNEX__INITIAL_STATE:
        setInitialState((BehaviorState)null);
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
      case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
        return isSetVariables();
      case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
        return isSetStates();
      case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
        return isSetTransitions();
      case AadlBaPackage.BEHAVIOR_ANNEX__ACTIONS:
        return actions != null && !actions.isEmpty();
      case AadlBaPackage.BEHAVIOR_ANNEX__CONDITIONS:
        return conditions != null && !conditions.isEmpty();
      case AadlBaPackage.BEHAVIOR_ANNEX__INITIAL_STATE:
        return initialState != null;
    }
    return super.eIsSet(featureID);
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }
  
  /**
   * @generated NOT
   */
  
  private Map<AadlBaLocationReference, Element> _links = new WeakHashMap
          <AadlBaLocationReference, Element>() ;
  
  @Override
  public Map<AadlBaLocationReference, Element> getLinks()
  {
    return _links;
  }
  
  private Map<BehaviorAnnex, AadlBaHighlighter> _annexHighlighters = 
       new WeakHashMap<BehaviorAnnex, AadlBaHighlighter>();
 
  public Map<BehaviorAnnex, AadlBaHighlighter> getHighlighters()
  {
    return _annexHighlighters;
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }
} //BehaviorAnnexImpl
