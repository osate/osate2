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
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.ecore.EClass ;

import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.ba.aadlba.impl.BehaviorElementImpl ;

import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.DeclarativePropertyAssociation ;
import org.osate.ba.declarative.DeclarativePropertyExpression ;
import org.osate.ba.declarative.QualifiedNamedElement ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyAssociationImpl#getOwnedValue <em>Owned Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativePropertyAssociationImpl extends
                                                DeclarativeBehaviorElementImpl
                                                implements
                                                DeclarativePropertyAssociation
{
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected QualifiedNamedElement property ;
  /**
   * The cached value of the '{@link #getOwnedValue() <em>Owned Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedValue()
   * @generated
   * @ordered
   */
  protected DeclarativePropertyExpression ownedValue ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativePropertyAssociationImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_PROPERTY_ASSOCIATION ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNamedElement getProperty()
  {
    if(property != null && property.eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject) property ;
      property = (QualifiedNamedElement) eResolveProxy(oldProperty) ;
      if(property != oldProperty)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY,
                                        oldProperty, property)) ;
      }
    }
    return property ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNamedElement basicGetProperty()
  {
    return property ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(QualifiedNamedElement newProperty)
  {
    QualifiedNamedElement oldProperty = property ;
    property = newProperty ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY,
                                    oldProperty, property)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclarativePropertyExpression getOwnedValue()
  {
    return ownedValue ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedValue(
                                              DeclarativePropertyExpression newOwnedValue,
                                              NotificationChain msgs)
  {
    DeclarativePropertyExpression oldOwnedValue = ownedValue ;
    ownedValue = newOwnedValue ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE,
                                                             oldOwnedValue,
                                                             newOwnedValue) ;
      if(msgs == null)
        msgs = notification ;
      else
        msgs.add(notification) ;
    }
    return msgs ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOwnedValue(DeclarativePropertyExpression newOwnedValue)
  {
    if(newOwnedValue != ownedValue)
    {
      NotificationChain msgs = null ;
      if(ownedValue != null)
        msgs = ((InternalEObject) ownedValue).eInverseRemove(this,
                                                             EOPPOSITE_FEATURE_BASE -
                                                                   DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE,
                                                             null, msgs) ;
      if(newOwnedValue != null)
        msgs = ((InternalEObject) newOwnedValue).eInverseAdd(this,
                                                             EOPPOSITE_FEATURE_BASE -
                                                                   DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE,
                                                             null, msgs) ;
      msgs = basicSetOwnedValue(newOwnedValue, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE,
                                    newOwnedValue, newOwnedValue)) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE :
        return basicSetOwnedValue(null, msgs) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY :
        if(resolve)
          return getProperty() ;
        return basicGetProperty() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE :
        return getOwnedValue() ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY :
        setProperty((QualifiedNamedElement) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE :
        setOwnedValue((DeclarativePropertyExpression) newValue) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY :
        setProperty((QualifiedNamedElement) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE :
        setOwnedValue((DeclarativePropertyExpression) null) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__PROPERTY :
        return property != null ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_ASSOCIATION__OWNED_VALUE :
        return ownedValue != null ;
    }
    return super.eIsSet(featureID) ;
  }

} //DeclarativePropertyAssociationImpl
