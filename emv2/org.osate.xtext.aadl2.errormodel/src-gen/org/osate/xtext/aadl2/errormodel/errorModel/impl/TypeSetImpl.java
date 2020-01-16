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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeSetImpl#getTypeTokens <em>Type Tokens</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeSetImpl#getAliasedType <em>Aliased Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeSetImpl extends ErrorTypesImpl implements TypeSet
{
  /**
   * The cached value of the '{@link #getTypeTokens() <em>Type Tokens</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeTokens()
   * @generated
   * @ordered
   */
  protected EList<TypeToken> typeTokens;

  /**
   * The cached value of the '{@link #getAliasedType() <em>Aliased Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAliasedType()
   * @generated
   * @ordered
   */
  protected TypeSet aliasedType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeSetImpl()
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
    return ErrorModelPackage.Literals.TYPE_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeToken> getTypeTokens()
  {
    if (typeTokens == null)
    {
      typeTokens = new EObjectContainmentEList<TypeToken>(TypeToken.class, this, ErrorModelPackage.TYPE_SET__TYPE_TOKENS);
    }
    return typeTokens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getAliasedType()
  {
    if (aliasedType != null && aliasedType.eIsProxy())
    {
      InternalEObject oldAliasedType = (InternalEObject)aliasedType;
      aliasedType = (TypeSet)eResolveProxy(oldAliasedType);
      if (aliasedType != oldAliasedType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.TYPE_SET__ALIASED_TYPE, oldAliasedType, aliasedType));
      }
    }
    return aliasedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet basicGetAliasedType()
  {
    return aliasedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAliasedType(TypeSet newAliasedType)
  {
    TypeSet oldAliasedType = aliasedType;
    aliasedType = newAliasedType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_SET__ALIASED_TYPE, oldAliasedType, aliasedType));
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
      case ErrorModelPackage.TYPE_SET__TYPE_TOKENS:
        return ((InternalEList<?>)getTypeTokens()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.TYPE_SET__TYPE_TOKENS:
        return getTypeTokens();
      case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
        if (resolve) return getAliasedType();
        return basicGetAliasedType();
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
      case ErrorModelPackage.TYPE_SET__TYPE_TOKENS:
        getTypeTokens().clear();
        getTypeTokens().addAll((Collection<? extends TypeToken>)newValue);
        return;
      case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
        setAliasedType((TypeSet)newValue);
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
      case ErrorModelPackage.TYPE_SET__TYPE_TOKENS:
        getTypeTokens().clear();
        return;
      case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
        setAliasedType((TypeSet)null);
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
      case ErrorModelPackage.TYPE_SET__TYPE_TOKENS:
        return typeTokens != null && !typeTokens.isEmpty();
      case ErrorModelPackage.TYPE_SET__ALIASED_TYPE:
        return aliasedType != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeSetImpl
