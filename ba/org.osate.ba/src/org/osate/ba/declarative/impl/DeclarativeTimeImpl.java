/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.declarative.impl ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.impl.ENotificationImpl ;

import org.osate.aadl2.Element ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;
import org.osate.ba.aadlba.DispatchRelativeTimeout ;
import org.osate.ba.aadlba.DispatchTriggerCondition ;
import org.osate.ba.aadlba.impl.BehaviorTimeImpl ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.DeclarativeTime ;
import org.osate.ba.declarative.Identifier ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeTimeImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeTimeImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeTimeImpl#getUnitId <em>Unit Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativeTimeImpl extends BehaviorTimeImpl implements
                                 DeclarativeTime
{
  /**
   * The cached value of the '{@link #getOsateRef() <em>Osate Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOsateRef()
   * @generated
   * @ordered
   */
  protected Element osateRef ;

  /**
   * The cached value of the '{@link #getBaRef() <em>Ba Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaRef()
   * @generated
   * @ordered
   */
  protected BehaviorElement baRef ;

  /**
   * The cached value of the '{@link #getUnitId() <em>Unit Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnitId()
   * @generated
   * @ordered
   */
  protected Identifier unitId ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativeTimeImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_TIME ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Element getOsateRef()
  {
    if(osateRef != null && ((EObject) osateRef).eIsProxy())
    {
      InternalEObject oldOsateRef = (InternalEObject) osateRef ;
      osateRef = (Element) eResolveProxy(oldOsateRef) ;
      if(osateRef != oldOsateRef)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.DECLARATIVE_TIME__OSATE_REF,
                                        oldOsateRef, osateRef)) ;
      }
    }
    return osateRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element basicGetOsateRef()
  {
    return osateRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOsateRef(Element newOsateRef)
  {
    Element oldOsateRef = osateRef ;
    osateRef = newOsateRef ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_TIME__OSATE_REF,
                                    oldOsateRef, osateRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorElement getBaRef()
  {
    if(baRef != null && ((EObject) baRef).eIsProxy())
    {
      InternalEObject oldBaRef = (InternalEObject) baRef ;
      baRef = (BehaviorElement) eResolveProxy(oldBaRef) ;
      if(baRef != oldBaRef)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.DECLARATIVE_TIME__BA_REF,
                                        oldBaRef, baRef)) ;
      }
    }
    return baRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorElement basicGetBaRef()
  {
    return baRef ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBaRef(BehaviorElement newBaRef)
  {
    BehaviorElement oldBaRef = baRef ;
    baRef = newBaRef ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_TIME__BA_REF,
                                    oldBaRef, baRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Identifier getUnitId()
  {
    return unitId ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnitId(Identifier newUnitId,
                                          NotificationChain msgs)
  {
    Identifier oldUnitId = unitId ;
    unitId = newUnitId ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_TIME__UNIT_ID,
                                                             oldUnitId,
                                                             newUnitId) ;
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
  public void setUnitId(Identifier newUnitId)
  {
    if(newUnitId != unitId)
    {
      NotificationChain msgs = null ;
      if(unitId != null)
        msgs = ((InternalEObject) unitId).eInverseRemove(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.DECLARATIVE_TIME__UNIT_ID,
                                                         null, msgs) ;
      if(newUnitId != null)
        msgs = ((InternalEObject) newUnitId).eInverseAdd(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.DECLARATIVE_TIME__UNIT_ID,
                                                         null, msgs) ;
      msgs = basicSetUnitId(newUnitId, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_TIME__UNIT_ID,
                                    newUnitId, newUnitId)) ;
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
      case DeclarativePackage.DECLARATIVE_TIME__UNIT_ID :
        return basicSetUnitId(null, msgs) ;
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
      case DeclarativePackage.DECLARATIVE_TIME__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.DECLARATIVE_TIME__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.DECLARATIVE_TIME__UNIT_ID :
        return getUnitId() ;
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
      case DeclarativePackage.DECLARATIVE_TIME__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_TIME__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_TIME__UNIT_ID :
        setUnitId((Identifier) newValue) ;
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
      case DeclarativePackage.DECLARATIVE_TIME__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_TIME__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_TIME__UNIT_ID :
        setUnitId((Identifier) null) ;
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
      case DeclarativePackage.DECLARATIVE_TIME__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.DECLARATIVE_TIME__BA_REF :
        return baRef != null ;
      case DeclarativePackage.DECLARATIVE_TIME__UNIT_ID :
        return unitId != null ;
    }
    return super.eIsSet(featureID) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if(baseClass == DispatchTriggerCondition.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DispatchRelativeTimeout.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == CompletionRelativeTimeout.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DeclarativeBehaviorElement.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.DECLARATIVE_TIME__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_TIME__BA_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;
        default :
          return -1 ;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if(baseClass == DispatchTriggerCondition.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DispatchRelativeTimeout.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == CompletionRelativeTimeout.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DeclarativeBehaviorElement.class)
    {
      switch ( baseFeatureID )
      {
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_TIME__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.DECLARATIVE_TIME__BA_REF ;
        default :
          return -1 ;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass) ;
  }

} //DeclarativeTimeImpl
