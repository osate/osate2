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

import org.eclipse.emf.common.notify.Notification ;

import org.eclipse.emf.ecore.EClass ;

import org.eclipse.emf.ecore.impl.ENotificationImpl ;

import org.osate.aadl2.impl.BasicPropertyAssociationImpl ;

import org.osate.ba.declarative.DeclarativeBasicPropertyAssociation ;
import org.osate.ba.declarative.DeclarativePackage ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Property Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeBasicPropertyAssociationImpl#getBasicPropertyName <em>Basic Property Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativeBasicPropertyAssociationImpl extends
                                                     BasicPropertyAssociationImpl
                                                     implements
                                                     DeclarativeBasicPropertyAssociation
{
  /**
   * The default value of the '{@link #getBasicPropertyName() <em>Basic Property Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBasicPropertyName()
   * @generated
   * @ordered
   */
  protected static final String BASIC_PROPERTY_NAME_EDEFAULT = null ;

  /**
   * The cached value of the '{@link #getBasicPropertyName() <em>Basic Property Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBasicPropertyName()
   * @generated
   * @ordered
   */
  protected String basicPropertyName = BASIC_PROPERTY_NAME_EDEFAULT ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativeBasicPropertyAssociationImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getBasicPropertyName()
  {
    return basicPropertyName ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBasicPropertyName(String newBasicPropertyName)
  {
    String oldBasicPropertyName = basicPropertyName ;
    basicPropertyName = newBasicPropertyName ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME,
                                    oldBasicPropertyName, basicPropertyName)) ;
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
      case DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME :
        return getBasicPropertyName() ;
    }
    return super.eGet(featureID, resolve, coreType) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch ( featureID )
    {
      case DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME :
        setBasicPropertyName((String) newValue) ;
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
      case DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME :
        setBasicPropertyName(BASIC_PROPERTY_NAME_EDEFAULT) ;
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
      case DeclarativePackage.DECLARATIVE_BASIC_PROPERTY_ASSOCIATION__BASIC_PROPERTY_NAME :
        return BASIC_PROPERTY_NAME_EDEFAULT == null ? basicPropertyName != null
                                                    : !BASIC_PROPERTY_NAME_EDEFAULT.equals(basicPropertyName) ;
    }
    return super.eIsSet(featureID) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if(eIsProxy())
      return super.toString() ;

    StringBuilder result = new StringBuilder(super.toString()) ;
    result.append(" (basicPropertyName: ") ;
    result.append(basicPropertyName) ;
    result.append(')') ;
    return result.toString() ;
  }

} //DeclarativeBasicPropertyAssociationImpl
