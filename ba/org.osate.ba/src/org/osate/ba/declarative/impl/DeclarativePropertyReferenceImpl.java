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

import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;

import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.DeclarativePropertyName ;
import org.osate.ba.declarative.DeclarativePropertyReference ;
import org.osate.ba.declarative.QualifiedNamedElement ;
import org.osate.ba.declarative.Reference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl#getPropertyNames <em>Property Names</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativePropertyReferenceImpl#isPropertySet <em>Property Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativePropertyReferenceImpl extends
                                              DeclarativeBehaviorElementImpl
                                              implements
                                              DeclarativePropertyReference
{
  /**
   * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected QualifiedNamedElement qualifiedName ;

  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected Reference reference ;

  /**
   * The cached value of the '{@link #getPropertyNames() <em>Property Names</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyNames()
   * @generated
   * @ordered
   */
  protected EList<DeclarativePropertyName> propertyNames ;

  /**
   * The default value of the '{@link #isPropertySet() <em>Property Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPropertySet()
   * @generated
   * @ordered
   */
  protected static final boolean PROPERTY_SET_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isPropertySet() <em>Property Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPropertySet()
   * @generated
   * @ordered
   */
  protected boolean propertySet = PROPERTY_SET_EDEFAULT ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativePropertyReferenceImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_PROPERTY_REFERENCE ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNamedElement getQualifiedName()
  {
    return qualifiedName ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedName(
                                                 QualifiedNamedElement newQualifiedName,
                                                 NotificationChain msgs)
  {
    QualifiedNamedElement oldQualifiedName = qualifiedName ;
    qualifiedName = newQualifiedName ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME,
                                                             oldQualifiedName,
                                                             newQualifiedName) ;
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
  public void setQualifiedName(QualifiedNamedElement newQualifiedName)
  {
    if(newQualifiedName != qualifiedName)
    {
      NotificationChain msgs = null ;
      if(qualifiedName != null)
        msgs = ((InternalEObject) qualifiedName).eInverseRemove(this,
                                                                EOPPOSITE_FEATURE_BASE -
                                                                      DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME,
                                                                null, msgs) ;
      if(newQualifiedName != null)
        msgs = ((InternalEObject) newQualifiedName).eInverseAdd(this,
                                                                EOPPOSITE_FEATURE_BASE -
                                                                      DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME,
                                                                null, msgs) ;
      msgs = basicSetQualifiedName(newQualifiedName, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME,
                                    newQualifiedName, newQualifiedName)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference getReference()
  {
    return reference ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReference(Reference newReference,
                                             NotificationChain msgs)
  {
    Reference oldReference = reference ;
    reference = newReference ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE,
                                                             oldReference,
                                                             newReference) ;
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
  public void setReference(Reference newReference)
  {
    if(newReference != reference)
    {
      NotificationChain msgs = null ;
      if(reference != null)
        msgs = ((InternalEObject) reference).eInverseRemove(this,
                                                            EOPPOSITE_FEATURE_BASE -
                                                                  DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE,
                                                            null, msgs) ;
      if(newReference != null)
        msgs = ((InternalEObject) newReference).eInverseAdd(this,
                                                            EOPPOSITE_FEATURE_BASE -
                                                                  DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE,
                                                            null, msgs) ;
      msgs = basicSetReference(newReference, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE,
                                    newReference, newReference)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DeclarativePropertyName> getPropertyNames()
  {
    if(propertyNames == null)
    {
      propertyNames = new EObjectContainmentEList<DeclarativePropertyName>(
                                                                           DeclarativePropertyName.class,
                                                                           this,
                                                                           DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES) ;
    }
    return propertyNames ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isPropertySet()
  {
    return propertySet ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPropertySet(boolean newPropertySet)
  {
    boolean oldPropertySet = propertySet ;
    propertySet = newPropertySet ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET,
                                    oldPropertySet, propertySet)) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME :
        return basicSetQualifiedName(null, msgs) ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE :
        return basicSetReference(null, msgs) ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES :
        return ((InternalEList<?>) getPropertyNames()).basicRemove(otherEnd,
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME :
        return getQualifiedName() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE :
        return getReference() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES :
        return getPropertyNames() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET :
        return isPropertySet() ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME :
        setQualifiedName((QualifiedNamedElement) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE :
        setReference((Reference) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES :
        getPropertyNames().clear() ;
        getPropertyNames().addAll((Collection<? extends DeclarativePropertyName>) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET :
        setPropertySet((Boolean) newValue) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME :
        setQualifiedName((QualifiedNamedElement) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE :
        setReference((Reference) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES :
        getPropertyNames().clear() ;
        return ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET :
        setPropertySet(PROPERTY_SET_EDEFAULT) ;
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
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__QUALIFIED_NAME :
        return qualifiedName != null ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__REFERENCE :
        return reference != null ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_NAMES :
        return propertyNames != null && !propertyNames.isEmpty() ;
      case DeclarativePackage.DECLARATIVE_PROPERTY_REFERENCE__PROPERTY_SET :
        return propertySet != PROPERTY_SET_EDEFAULT ;
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
    result.append(" (propertySet: ") ;
    result.append(propertySet) ;
    result.append(')') ;
    return result.toString() ;
  }

} //DeclarativePropertyReferenceImpl
