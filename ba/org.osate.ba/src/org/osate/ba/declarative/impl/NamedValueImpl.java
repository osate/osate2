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
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueVariable ;
import org.osate.ba.aadlba.impl.BehaviorElementImpl ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.NamedValue ;
import org.osate.ba.declarative.Reference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.NamedValueImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.NamedValueImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.NamedValueImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.NamedValueImpl#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.NamedValueImpl#isFresh <em>Fresh</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.NamedValueImpl#isCount <em>Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedValueImpl extends BehaviorElementImpl implements NamedValue
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
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected Reference reference ;

  /**
   * The default value of the '{@link #isDequeue() <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDequeue()
   * @generated
   * @ordered
   */
  protected static final boolean DEQUEUE_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isDequeue() <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDequeue()
   * @generated
   * @ordered
   */
  protected boolean dequeue = DEQUEUE_EDEFAULT ;

  /**
   * The default value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFresh()
   * @generated
   * @ordered
   */
  protected static final boolean FRESH_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFresh()
   * @generated
   * @ordered
   */
  protected boolean fresh = FRESH_EDEFAULT ;

  /**
   * The default value of the '{@link #isCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCount()
   * @generated
   * @ordered
   */
  protected static final boolean COUNT_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCount()
   * @generated
   * @ordered
   */
  protected boolean count = COUNT_EDEFAULT ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedValueImpl()
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
    return DeclarativePackage.Literals.NAMED_VALUE ;
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
                                        DeclarativePackage.NAMED_VALUE__OSATE_REF,
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
                                    DeclarativePackage.NAMED_VALUE__OSATE_REF,
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
                                        DeclarativePackage.NAMED_VALUE__BA_REF,
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
                                    DeclarativePackage.NAMED_VALUE__BA_REF,
                                    oldBaRef, baRef)) ;
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
                                                             DeclarativePackage.NAMED_VALUE__REFERENCE,
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
                                                                  DeclarativePackage.NAMED_VALUE__REFERENCE,
                                                            null, msgs) ;
      if(newReference != null)
        msgs = ((InternalEObject) newReference).eInverseAdd(this,
                                                            EOPPOSITE_FEATURE_BASE -
                                                                  DeclarativePackage.NAMED_VALUE__REFERENCE,
                                                            null, msgs) ;
      msgs = basicSetReference(newReference, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.NAMED_VALUE__REFERENCE,
                                    newReference, newReference)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDequeue()
  {
    return dequeue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDequeue(boolean newDequeue)
  {
    boolean oldDequeue = dequeue ;
    dequeue = newDequeue ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.NAMED_VALUE__DEQUEUE,
                                    oldDequeue, dequeue)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFresh()
  {
    return fresh ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFresh(boolean newFresh)
  {
    boolean oldFresh = fresh ;
    fresh = newFresh ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.NAMED_VALUE__FRESH,
                                    oldFresh, fresh)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isCount()
  {
    return count ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCount(boolean newCount)
  {
    boolean oldCount = count ;
    count = newCount ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.NAMED_VALUE__COUNT,
                                    oldCount, count)) ;
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
      case DeclarativePackage.NAMED_VALUE__REFERENCE :
        return basicSetReference(null, msgs) ;
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
      case DeclarativePackage.NAMED_VALUE__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.NAMED_VALUE__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.NAMED_VALUE__REFERENCE :
        return getReference() ;
      case DeclarativePackage.NAMED_VALUE__DEQUEUE :
        return isDequeue() ;
      case DeclarativePackage.NAMED_VALUE__FRESH :
        return isFresh() ;
      case DeclarativePackage.NAMED_VALUE__COUNT :
        return isCount() ;
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
      case DeclarativePackage.NAMED_VALUE__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__REFERENCE :
        setReference((Reference) newValue) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__DEQUEUE :
        setDequeue((Boolean) newValue) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__FRESH :
        setFresh((Boolean) newValue) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__COUNT :
        setCount((Boolean) newValue) ;
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
      case DeclarativePackage.NAMED_VALUE__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__REFERENCE :
        setReference((Reference) null) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__DEQUEUE :
        setDequeue(DEQUEUE_EDEFAULT) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__FRESH :
        setFresh(FRESH_EDEFAULT) ;
        return ;
      case DeclarativePackage.NAMED_VALUE__COUNT :
        setCount(COUNT_EDEFAULT) ;
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
      case DeclarativePackage.NAMED_VALUE__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.NAMED_VALUE__BA_REF :
        return baRef != null ;
      case DeclarativePackage.NAMED_VALUE__REFERENCE :
        return reference != null ;
      case DeclarativePackage.NAMED_VALUE__DEQUEUE :
        return dequeue != DEQUEUE_EDEFAULT ;
      case DeclarativePackage.NAMED_VALUE__FRESH :
        return fresh != FRESH_EDEFAULT ;
      case DeclarativePackage.NAMED_VALUE__COUNT :
        return count != COUNT_EDEFAULT ;
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
    if(baseClass == Value.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ValueVariable.class)
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
        case DeclarativePackage.NAMED_VALUE__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.NAMED_VALUE__BA_REF :
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
    if(baseClass == Value.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ValueVariable.class)
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
          return DeclarativePackage.NAMED_VALUE__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.NAMED_VALUE__BA_REF ;
        default :
          return -1 ;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass) ;
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
    result.append(" (dequeue: ") ;
    result.append(dequeue) ;
    result.append(", fresh: ") ;
    result.append(fresh) ;
    result.append(", count: ") ;
    result.append(count) ;
    result.append(')') ;
    return result.toString() ;
  }

} //NamedValueImpl
