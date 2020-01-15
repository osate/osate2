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

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Error Behavior State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedErrorBehaviorStateImpl#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedErrorBehaviorStateImpl#getNext <em>Next</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.QualifiedErrorBehaviorStateImpl#getState <em>State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedErrorBehaviorStateImpl extends ElementImpl implements QualifiedErrorBehaviorState
{
  /**
   * The cached value of the '{@link #getSubcomponent() <em>Subcomponent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcomponent()
   * @generated
   * @ordered
   */
  protected SubcomponentElement subcomponent;

  /**
   * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNext()
   * @generated
   * @ordered
   */
  protected QualifiedErrorBehaviorState next;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedErrorBehaviorStateImpl()
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
    return ErrorModelPackage.Literals.QUALIFIED_ERROR_BEHAVIOR_STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubcomponentElement getSubcomponent()
  {
    return subcomponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubcomponent(SubcomponentElement newSubcomponent, NotificationChain msgs)
  {
    SubcomponentElement oldSubcomponent = subcomponent;
    subcomponent = newSubcomponent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT, oldSubcomponent, newSubcomponent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubcomponent(SubcomponentElement newSubcomponent)
  {
    if (newSubcomponent != subcomponent)
    {
      NotificationChain msgs = null;
      if (subcomponent != null)
        msgs = ((InternalEObject)subcomponent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT, null, msgs);
      if (newSubcomponent != null)
        msgs = ((InternalEObject)newSubcomponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT, null, msgs);
      msgs = basicSetSubcomponent(newSubcomponent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT, newSubcomponent, newSubcomponent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedErrorBehaviorState getNext()
  {
    return next;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNext(QualifiedErrorBehaviorState newNext, NotificationChain msgs)
  {
    QualifiedErrorBehaviorState oldNext = next;
    next = newNext;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT, oldNext, newNext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNext(QualifiedErrorBehaviorState newNext)
  {
    if (newNext != next)
    {
      NotificationChain msgs = null;
      if (next != null)
        msgs = ((InternalEObject)next).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT, null, msgs);
      if (newNext != null)
        msgs = ((InternalEObject)newNext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT, null, msgs);
      msgs = basicSetNext(newNext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT, newNext, newNext));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__STATE, oldState, state));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__STATE, oldState, state));
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
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT:
        return basicSetSubcomponent(null, msgs);
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT:
        return basicSetNext(null, msgs);
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
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT:
        return getSubcomponent();
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT:
        return getNext();
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__STATE:
        if (resolve) return getState();
        return basicGetState();
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
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT:
        setSubcomponent((SubcomponentElement)newValue);
        return;
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT:
        setNext((QualifiedErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__STATE:
        setState((ErrorBehaviorState)newValue);
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
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT:
        setSubcomponent((SubcomponentElement)null);
        return;
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT:
        setNext((QualifiedErrorBehaviorState)null);
        return;
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__STATE:
        setState((ErrorBehaviorState)null);
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
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__SUBCOMPONENT:
        return subcomponent != null;
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__NEXT:
        return next != null;
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE__STATE:
        return state != null;
    }
    return super.eIsSet(featureID);
  }

} //QualifiedErrorBehaviorStateImpl
