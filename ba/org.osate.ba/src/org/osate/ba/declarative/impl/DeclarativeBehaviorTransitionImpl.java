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

import java.util.Collection ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;

import org.eclipse.emf.common.util.EList ;

import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;

import org.eclipse.emf.ecore.impl.ENotificationImpl ;

import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;

import org.osate.aadl2.Element ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.impl.BehaviorTransitionImpl ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativeBehaviorTransition ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.Identifier ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl#getSrcStates <em>Src States</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.DeclarativeBehaviorTransitionImpl#getDestState <em>Dest State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarativeBehaviorTransitionImpl extends BehaviorTransitionImpl
                                               implements
                                               DeclarativeBehaviorTransition
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
   * The cached value of the '{@link #getSrcStates() <em>Src States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrcStates()
   * @generated
   * @ordered
   */
  protected EList<Identifier> srcStates ;

  /**
   * The cached value of the '{@link #getDestState() <em>Dest State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestState()
   * @generated
   * @ordered
   */
  protected Identifier destState ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclarativeBehaviorTransitionImpl()
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
    return DeclarativePackage.Literals.DECLARATIVE_BEHAVIOR_TRANSITION ;
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
                                        DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF,
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
                                    DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF,
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
                                        DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF,
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
                                    DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF,
                                    oldBaRef, baRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Identifier> getSrcStates()
  {
    if(srcStates == null)
    {
      srcStates = new EObjectContainmentEList<Identifier>(Identifier.class,
                                                          this,
                                                          DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES) ;
    }
    return srcStates ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Identifier getDestState()
  {
    return destState ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDestState(Identifier newDestState,
                                             NotificationChain msgs)
  {
    Identifier oldDestState = destState ;
    destState = newDestState ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE,
                                                             oldDestState,
                                                             newDestState) ;
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
  public void setDestState(Identifier newDestState)
  {
    if(newDestState != destState)
    {
      NotificationChain msgs = null ;
      if(destState != null)
        msgs = ((InternalEObject) destState).eInverseRemove(this,
                                                            EOPPOSITE_FEATURE_BASE -
                                                                  DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE,
                                                            null, msgs) ;
      if(newDestState != null)
        msgs = ((InternalEObject) newDestState).eInverseAdd(this,
                                                            EOPPOSITE_FEATURE_BASE -
                                                                  DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE,
                                                            null, msgs) ;
      msgs = basicSetDestState(newDestState, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE,
                                    newDestState, newDestState)) ;
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
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES :
        return ((InternalEList<?>) getSrcStates()).basicRemove(otherEnd, msgs) ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE :
        return basicSetDestState(null, msgs) ;
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
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES :
        return getSrcStates() ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE :
        return getDestState() ;
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
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES :
        getSrcStates().clear() ;
        getSrcStates().addAll((Collection<? extends Identifier>) newValue) ;
        return ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE :
        setDestState((Identifier) newValue) ;
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
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES :
        getSrcStates().clear() ;
        return ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE :
        setDestState((Identifier) null) ;
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
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF :
        return baRef != null ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__SRC_STATES :
        return srcStates != null && !srcStates.isEmpty() ;
      case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__DEST_STATE :
        return destState != null ;
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
    if(baseClass == DeclarativeBehaviorElement.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF :
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
    if(baseClass == DeclarativeBehaviorElement.class)
    {
      switch ( baseFeatureID )
      {
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_TRANSITION__BA_REF ;
        default :
          return -1 ;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass) ;
  }

} //DeclarativeBehaviorTransitionImpl
