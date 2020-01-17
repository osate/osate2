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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.Mode;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error State To Mode Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorStateToModeMappingImpl#getErrorState <em>Error State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorStateToModeMappingImpl#getTypeToken <em>Type Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorStateToModeMappingImpl#getMappedModes <em>Mapped Modes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorStateToModeMappingImpl extends ElementImpl implements ErrorStateToModeMapping
{
  /**
   * The cached value of the '{@link #getErrorState() <em>Error State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorState()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorState errorState;

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
   * The cached value of the '{@link #getMappedModes() <em>Mapped Modes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMappedModes()
   * @generated
   * @ordered
   */
  protected EList<Mode> mappedModes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorStateToModeMappingImpl()
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
    return ErrorModelPackage.Literals.ERROR_STATE_TO_MODE_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState getErrorState()
  {
    if (errorState != null && errorState.eIsProxy())
    {
      InternalEObject oldErrorState = (InternalEObject)errorState;
      errorState = (ErrorBehaviorState)eResolveProxy(oldErrorState);
      if (errorState != oldErrorState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE, oldErrorState, errorState));
      }
    }
    return errorState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState basicGetErrorState()
  {
    return errorState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorState(ErrorBehaviorState newErrorState)
  {
    ErrorBehaviorState oldErrorState = errorState;
    errorState = newErrorState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE, oldErrorState, errorState));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN, oldTypeToken, newTypeToken);
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
        msgs = ((InternalEObject)typeToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN, null, msgs);
      if (newTypeToken != null)
        msgs = ((InternalEObject)newTypeToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN, null, msgs);
      msgs = basicSetTypeToken(newTypeToken, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN, newTypeToken, newTypeToken));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mode> getMappedModes()
  {
    if (mappedModes == null)
    {
      mappedModes = new EObjectResolvingEList<Mode>(Mode.class, this, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES);
    }
    return mappedModes;
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
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN:
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
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
        if (resolve) return getErrorState();
        return basicGetErrorState();
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN:
        return getTypeToken();
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
        return getMappedModes();
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
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
        setErrorState((ErrorBehaviorState)newValue);
        return;
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN:
        setTypeToken((TypeSet)newValue);
        return;
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
        getMappedModes().clear();
        getMappedModes().addAll((Collection<? extends Mode>)newValue);
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
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
        setErrorState((ErrorBehaviorState)null);
        return;
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN:
        setTypeToken((TypeSet)null);
        return;
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
        getMappedModes().clear();
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
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
        return errorState != null;
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__TYPE_TOKEN:
        return typeToken != null;
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
        return mappedModes != null && !mappedModes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ErrorStateToModeMappingImpl
