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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Behavior State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getUseTransformation <em>Use Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorBehaviorStateMachineImpl extends NamedElementImpl implements ErrorBehaviorStateMachine
{
  /**
   * The cached value of the '{@link #getUseTypes() <em>Use Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseTypes()
   * @generated
   * @ordered
   */
  protected EList<ErrorModelLibrary> useTypes;

  /**
   * The cached value of the '{@link #getUseTransformation() <em>Use Transformation</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseTransformation()
   * @generated
   * @ordered
   */
  protected EList<TypeTransformationSet> useTransformation;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorEvent> events;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorState> states;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorTransition> transitions;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<EMV2PropertyAssociation> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorBehaviorStateMachineImpl()
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
    return ErrorModelPackage.Literals.ERROR_BEHAVIOR_STATE_MACHINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorModelLibrary> getUseTypes()
  {
    if (useTypes == null)
    {
      useTypes = new EObjectResolvingEList<ErrorModelLibrary>(ErrorModelLibrary.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES);
    }
    return useTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeTransformationSet> getUseTransformation()
  {
    if (useTransformation == null)
    {
      useTransformation = new EObjectResolvingEList<TypeTransformationSet>(TypeTransformationSet.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION);
    }
    return useTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorEvent> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<ErrorBehaviorEvent>(ErrorBehaviorEvent.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS);
    }
    return events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorState> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<ErrorBehaviorState>(ErrorBehaviorState.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorTransition> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<ErrorBehaviorTransition>(ErrorBehaviorTransition.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS);
    }
    return transitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EMV2PropertyAssociation> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<EMV2PropertyAssociation>(EMV2PropertyAssociation.class, this, ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES);
    }
    return properties;
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES:
        return getUseTypes();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION:
        return getUseTransformation();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        return getEvents();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        return getStates();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        return getTransitions();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES:
        return getProperties();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES:
        getUseTypes().clear();
        getUseTypes().addAll((Collection<? extends ErrorModelLibrary>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION:
        getUseTransformation().clear();
        getUseTransformation().addAll((Collection<? extends TypeTransformationSet>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends ErrorBehaviorEvent>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends ErrorBehaviorState>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends ErrorBehaviorTransition>)newValue);
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends EMV2PropertyAssociation>)newValue);
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES:
        getUseTypes().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION:
        getUseTransformation().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        getEvents().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        getStates().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        getTransitions().clear();
        return;
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES:
        getProperties().clear();
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
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TYPES:
        return useTypes != null && !useTypes.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__USE_TRANSFORMATION:
        return useTransformation != null && !useTransformation.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__EVENTS:
        return events != null && !events.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__STATES:
        return states != null && !states.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE__PROPERTIES:
        return properties != null && !properties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ErrorBehaviorStateMachineImpl
