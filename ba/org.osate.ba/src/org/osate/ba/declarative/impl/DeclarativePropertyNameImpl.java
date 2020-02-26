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
import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.impl.ENotificationImpl ;

import org.eclipse.emf.ecore.util.EObjectResolvingEList ;
import org.eclipse.emf.ecore.util.InternalEList ;

import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.PropertyNameField ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.DeclarativePropertyName ;
import org.osate.ba.declarative.Identifier ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyNameImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyNameImpl#getField <em>Field</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyNameImpl#getIndexes <em>Indexes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativePropertyNameImpl extends DeclarativeBehaviorElementImpl
                                         implements DeclarativePropertyName
{
  /**
   * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyName()
   * @generated
   * @ordered
   */
  protected Identifier propertyName ;

  /**
   * The cached value of the '{@link #getField() <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getField()
   * @generated
   * @ordered
   */
  protected PropertyNameField field ;

  /**
   * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getIndexes()
   * @generated
   * @ordered
   */
  protected EList<IntegerValue> indexes ;

  /**
   * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativePropertyNameImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_PROPERTY_NAME ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Identifier getPropertyName()
  {
    return propertyName ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPropertyName(Identifier newPropertyName,
                                                NotificationChain msgs)
  {
    Identifier oldPropertyName = propertyName ;
    propertyName = newPropertyName ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME,
                                                             oldPropertyName,
                                                             newPropertyName) ;
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
  public void setPropertyName(Identifier newPropertyName)
  {
    if(newPropertyName != propertyName)
    {
      NotificationChain msgs = null ;
      if(propertyName != null)
        msgs = ((InternalEObject) propertyName).eInverseRemove(this,
                                                               EOPPOSITE_FEATURE_BASE -
                                                                     DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME,
                                                               null, msgs) ;
      if(newPropertyName != null)
        msgs = ((InternalEObject) newPropertyName).eInverseAdd(this,
                                                               EOPPOSITE_FEATURE_BASE -
                                                                     DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME,
                                                               null, msgs) ;
      msgs = basicSetPropertyName(newPropertyName, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME,
                                    newPropertyName, newPropertyName)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyNameField getField()
  {
    return field ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetField(PropertyNameField newField,
                                         NotificationChain msgs)
  {
    PropertyNameField oldField = field ;
    field = newField ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD,
                                                             oldField,
                                                             newField) ;
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
  public void setField(PropertyNameField newField)
  {
    if(newField != field)
    {
      NotificationChain msgs = null ;
      if(field != null)
        msgs = ((InternalEObject) field).eInverseRemove(this,
                                                        EOPPOSITE_FEATURE_BASE -
                                                              DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD,
                                                        null, msgs) ;
      if(newField != null)
        msgs = ((InternalEObject) newField).eInverseAdd(this,
                                                        EOPPOSITE_FEATURE_BASE -
                                                              DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD,
                                                        null, msgs) ;
      msgs = basicSetField(newField, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD,
                                    newField, newField)) ;
  }

  /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegerValue> getIndexes()
  {
    if(indexes == null)
    {
      indexes = new EObjectResolvingEList.Unsettable<IntegerValue>(
                                                                   IntegerValue.class,
                                                                   this,
                                                                   DeclarativePackage.DECLARATIVE_PROPERTY_NAME__INDEXES) ;
    }
    return indexes ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetIndexes()
  {
    if(indexes != null)
      ((InternalEList.Unsettable<?>) indexes).unset() ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetIndexes()
  {
    return indexes != null && ((InternalEList.Unsettable<?>) indexes).isSet() ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME :
        return basicSetPropertyName(null, msgs) ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD :
        return basicSetField(null, msgs) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME :
        return getPropertyName() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD :
        return getField() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__INDEXES :
        return getIndexes() ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME :
        setPropertyName((Identifier) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD :
        setField((PropertyNameField) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__INDEXES :
        getIndexes().clear() ;
        getIndexes().addAll((Collection<? extends IntegerValue>) newValue) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME :
        setPropertyName((Identifier) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD :
        setField((PropertyNameField) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__INDEXES :
        unsetIndexes() ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__PROPERTY_NAME :
        return propertyName != null ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__FIELD :
        return field != null ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_NAME__INDEXES :
        return isSetIndexes() ;
    }
    return super.eIsSet(featureID) ;
  }

} //DeclarativePropertyNameImpl
