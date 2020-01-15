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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.IfCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl#getTypeSet <em>Type Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl#getEventcondition <em>Eventcondition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorEventImpl extends ErrorBehaviorEventImpl implements ErrorEvent
{
  /**
   * The cached value of the '{@link #getTypeSet() <em>Type Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeSet()
   * @generated
   * @ordered
   */
  protected TypeSet typeSet;

  /**
   * The cached value of the '{@link #getEventcondition() <em>Eventcondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventcondition()
   * @generated
   * @ordered
   */
  protected IfCondition eventcondition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorEventImpl()
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
    return ErrorModelPackage.Literals.ERROR_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTypeSet()
  {
    return typeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeSet(TypeSet newTypeSet, NotificationChain msgs)
  {
    TypeSet oldTypeSet = typeSet;
    typeSet = newTypeSet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__TYPE_SET, oldTypeSet, newTypeSet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeSet(TypeSet newTypeSet)
  {
    if (newTypeSet != typeSet)
    {
      NotificationChain msgs = null;
      if (typeSet != null)
        msgs = ((InternalEObject)typeSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_EVENT__TYPE_SET, null, msgs);
      if (newTypeSet != null)
        msgs = ((InternalEObject)newTypeSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_EVENT__TYPE_SET, null, msgs);
      msgs = basicSetTypeSet(newTypeSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__TYPE_SET, newTypeSet, newTypeSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfCondition getEventcondition()
  {
    return eventcondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEventcondition(IfCondition newEventcondition, NotificationChain msgs)
  {
    IfCondition oldEventcondition = eventcondition;
    eventcondition = newEventcondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__EVENTCONDITION, oldEventcondition, newEventcondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEventcondition(IfCondition newEventcondition)
  {
    if (newEventcondition != eventcondition)
    {
      NotificationChain msgs = null;
      if (eventcondition != null)
        msgs = ((InternalEObject)eventcondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_EVENT__EVENTCONDITION, null, msgs);
      if (newEventcondition != null)
        msgs = ((InternalEObject)newEventcondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_EVENT__EVENTCONDITION, null, msgs);
      msgs = basicSetEventcondition(newEventcondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_EVENT__EVENTCONDITION, newEventcondition, newEventcondition));
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        return basicSetTypeSet(null, msgs);
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        return basicSetEventcondition(null, msgs);
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        return getTypeSet();
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        return getEventcondition();
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        setTypeSet((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        setEventcondition((IfCondition)newValue);
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        setTypeSet((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        setEventcondition((IfCondition)null);
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
      case ErrorModelPackage.ERROR_EVENT__TYPE_SET:
        return typeSet != null;
      case ErrorModelPackage.ERROR_EVENT__EVENTCONDITION:
        return eventcondition != null;
    }
    return super.eIsSet(featureID);
  }

} //ErrorEventImpl
