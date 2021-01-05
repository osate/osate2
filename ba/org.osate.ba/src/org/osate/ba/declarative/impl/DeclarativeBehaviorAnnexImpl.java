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
package org.osate.ba.declarative.impl ;

import java.util.Collection ;

import org.eclipse.emf.common.notify.NotificationChain ;

import org.eclipse.emf.common.util.EList ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.impl.EObjectImpl ;

import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;

import org.osate.ba.declarative.DeclarativeBehaviorAnnex ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePackage ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeBehaviorAnnexImpl#getDeclarativeBehaviorElements <em>Declarative Behavior Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativeBehaviorAnnexImpl extends EObjectImpl implements
                                          DeclarativeBehaviorAnnex
{
  /**
   * The cached value of the '{@link #getDeclarativeBehaviorElements() <em>Declarative Behavior Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarativeBehaviorElements()
   * @generated
   * @ordered
   */
  protected EList<DeclarativeBehaviorElement> declarativeBehaviorElements ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativeBehaviorAnnexImpl()
  {
    super() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DeclarativePackage.Literals.DECLARATIVE_BEHAVIOR_ANNEX ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DeclarativeBehaviorElement> getDeclarativeBehaviorElements()
  {
    if(declarativeBehaviorElements == null)
    {
      declarativeBehaviorElements =
                                  new EObjectContainmentEList<DeclarativeBehaviorElement>(DeclarativeBehaviorElement.class,
                                                                                          this,
                                                                                          DeclarativePackage.DECLARATIVE_BEHAVIOR_ANNEX__DECLARATIVE_BEHAVIOR_ELEMENTS) ;
    }
    return declarativeBehaviorElements ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd,
                                          int featureID, NotificationChain msgs)
  {
    switch ( featureID )
    {
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_ANNEX__DECLARATIVE_BEHAVIOR_ELEMENTS :
        return ((InternalEList<?>) getDeclarativeBehaviorElements()).basicRemove(otherEnd,
                                                                                 msgs) ;
    }
    return super.eInverseRemove(otherEnd, featureID, msgs) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch ( featureID )
    {
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_ANNEX__DECLARATIVE_BEHAVIOR_ELEMENTS :
        return getDeclarativeBehaviorElements() ;
    }
    return super.eGet(featureID, resolve, coreType) ;
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
    switch ( featureID )
    {
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_ANNEX__DECLARATIVE_BEHAVIOR_ELEMENTS :
        getDeclarativeBehaviorElements().clear() ;
        getDeclarativeBehaviorElements().addAll((Collection<? extends DeclarativeBehaviorElement>) newValue) ;
        return ;
    }
    super.eSet(featureID, newValue) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch ( featureID )
    {
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_ANNEX__DECLARATIVE_BEHAVIOR_ELEMENTS :
        getDeclarativeBehaviorElements().clear() ;
        return ;
    }
    super.eUnset(featureID) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch ( featureID )
    {
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_ANNEX__DECLARATIVE_BEHAVIOR_ELEMENTS :
        return declarativeBehaviorElements != null &&
               !declarativeBehaviorElements.isEmpty() ;
    }
    return super.eIsSet(featureID) ;
  }

} //DeclarativeBehaviorAnnexImpl
