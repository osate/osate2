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
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.impl.BehaviorElementImpl ;
import org.osate.ba.declarative.CommAction ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.QualifiedNamedElement ;
import org.osate.ba.declarative.Reference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comm Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#isPortFreeze <em>Port Freeze</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#isPortDequeue <em>Port Dequeue</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#isLock <em>Lock</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#isUnlock <em>Unlock</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.CommActionImpl#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommActionImpl extends BehaviorElementImpl implements CommAction
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
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ParameterLabel> parameters ;

  /**
   * The default value of the '{@link #isPortFreeze() <em>Port Freeze</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPortFreeze()
   * @generated
   * @ordered
   */
  protected static final boolean PORT_FREEZE_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isPortFreeze() <em>Port Freeze</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPortFreeze()
   * @generated
   * @ordered
   */
  protected boolean portFreeze = PORT_FREEZE_EDEFAULT ;

  /**
   * The default value of the '{@link #isPortDequeue() <em>Port Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPortDequeue()
   * @generated
   * @ordered
   */
  protected static final boolean PORT_DEQUEUE_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isPortDequeue() <em>Port Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPortDequeue()
   * @generated
   * @ordered
   */
  protected boolean portDequeue = PORT_DEQUEUE_EDEFAULT ;

  /**
   * The default value of the '{@link #isLock() <em>Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLock()
   * @generated
   * @ordered
   */
  protected static final boolean LOCK_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isLock() <em>Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLock()
   * @generated
   * @ordered
   */
  protected boolean lock = LOCK_EDEFAULT ;

  /**
   * The default value of the '{@link #isUnlock() <em>Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnlock()
   * @generated
   * @ordered
   */
  protected static final boolean UNLOCK_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isUnlock() <em>Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnlock()
   * @generated
   * @ordered
   */
  protected boolean unlock = UNLOCK_EDEFAULT ;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Target target ;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommActionImpl()
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
    return DeclarativePackage.Literals.COMM_ACTION ;
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
                                        DeclarativePackage.COMM_ACTION__OSATE_REF,
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
                                    DeclarativePackage.COMM_ACTION__OSATE_REF,
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
                                        DeclarativePackage.COMM_ACTION__BA_REF,
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
                                    DeclarativePackage.COMM_ACTION__BA_REF,
                                    oldBaRef, baRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ParameterLabel> getParameters()
  {
    if(parameters == null)
    {
      parameters = new EObjectContainmentEList.Unsettable<ParameterLabel>(
                                                                          ParameterLabel.class,
                                                                          this,
                                                                          DeclarativePackage.COMM_ACTION__PARAMETERS) ;
    }
    return parameters ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetParameters()
  {
    if(parameters != null)
      ((InternalEList.Unsettable<?>) parameters).unset() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetParameters()
  {
    return parameters != null && ((InternalEList.Unsettable<?>) parameters)
                                                                           .isSet() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isPortFreeze()
  {
    return portFreeze ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPortFreeze(boolean newPortFreeze)
  {
    boolean oldPortFreeze = portFreeze ;
    portFreeze = newPortFreeze ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__PORT_FREEZE,
                                    oldPortFreeze, portFreeze)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isPortDequeue()
  {
    return portDequeue ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPortDequeue(boolean newPortDequeue)
  {
    boolean oldPortDequeue = portDequeue ;
    portDequeue = newPortDequeue ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__PORT_DEQUEUE,
                                    oldPortDequeue, portDequeue)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isLock()
  {
    return lock ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLock(boolean newLock)
  {
    boolean oldLock = lock ;
    lock = newLock ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__LOCK,
                                    oldLock, lock)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isUnlock()
  {
    return unlock ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUnlock(boolean newUnlock)
  {
    boolean oldUnlock = unlock ;
    unlock = newUnlock ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__UNLOCK,
                                    oldUnlock, unlock)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Target getTarget()
  {
    return target ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(Target newTarget,
                                          NotificationChain msgs)
  {
    Target oldTarget = target ;
    target = newTarget ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.COMM_ACTION__TARGET,
                                                             oldTarget,
                                                             newTarget) ;
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
  public void setTarget(Target newTarget)
  {
    if(newTarget != target)
    {
      NotificationChain msgs = null ;
      if(target != null)
        msgs = ((InternalEObject) target).eInverseRemove(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.COMM_ACTION__TARGET,
                                                         null, msgs) ;
      if(newTarget != null)
        msgs = ((InternalEObject) newTarget).eInverseAdd(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.COMM_ACTION__TARGET,
                                                         null, msgs) ;
      msgs = basicSetTarget(newTarget, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__TARGET,
                                    newTarget, newTarget)) ;
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
                                                             DeclarativePackage.COMM_ACTION__QUALIFIED_NAME,
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
                                                                      DeclarativePackage.COMM_ACTION__QUALIFIED_NAME,
                                                                null, msgs) ;
      if(newQualifiedName != null)
        msgs = ((InternalEObject) newQualifiedName).eInverseAdd(this,
                                                                EOPPOSITE_FEATURE_BASE -
                                                                      DeclarativePackage.COMM_ACTION__QUALIFIED_NAME,
                                                                null, msgs) ;
      msgs = basicSetQualifiedName(newQualifiedName, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__QUALIFIED_NAME,
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
                                                             DeclarativePackage.COMM_ACTION__REFERENCE,
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
                                                                  DeclarativePackage.COMM_ACTION__REFERENCE,
                                                            null, msgs) ;
      if(newReference != null)
        msgs = ((InternalEObject) newReference).eInverseAdd(this,
                                                            EOPPOSITE_FEATURE_BASE -
                                                                  DeclarativePackage.COMM_ACTION__REFERENCE,
                                                            null, msgs) ;
      msgs = basicSetReference(newReference, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.COMM_ACTION__REFERENCE,
                                    newReference, newReference)) ;
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
      case DeclarativePackage.COMM_ACTION__PARAMETERS :
        return ((InternalEList<?>) getParameters()).basicRemove(otherEnd,
                                                                msgs) ;
      case DeclarativePackage.COMM_ACTION__TARGET :
        return basicSetTarget(null, msgs) ;
      case DeclarativePackage.COMM_ACTION__QUALIFIED_NAME :
        return basicSetQualifiedName(null, msgs) ;
      case DeclarativePackage.COMM_ACTION__REFERENCE :
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
      case DeclarativePackage.COMM_ACTION__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.COMM_ACTION__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.COMM_ACTION__PARAMETERS :
        return getParameters() ;
      case DeclarativePackage.COMM_ACTION__PORT_FREEZE :
        return isPortFreeze() ;
      case DeclarativePackage.COMM_ACTION__PORT_DEQUEUE :
        return isPortDequeue() ;
      case DeclarativePackage.COMM_ACTION__LOCK :
        return isLock() ;
      case DeclarativePackage.COMM_ACTION__UNLOCK :
        return isUnlock() ;
      case DeclarativePackage.COMM_ACTION__TARGET :
        return getTarget() ;
      case DeclarativePackage.COMM_ACTION__QUALIFIED_NAME :
        return getQualifiedName() ;
      case DeclarativePackage.COMM_ACTION__REFERENCE :
        return getReference() ;
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
      case DeclarativePackage.COMM_ACTION__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__PARAMETERS :
        getParameters().clear() ;
        getParameters().addAll((Collection<? extends ParameterLabel>) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__PORT_FREEZE :
        setPortFreeze((Boolean) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__PORT_DEQUEUE :
        setPortDequeue((Boolean) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__LOCK :
        setLock((Boolean) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__UNLOCK :
        setUnlock((Boolean) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__TARGET :
        setTarget((Target) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__QUALIFIED_NAME :
        setQualifiedName((QualifiedNamedElement) newValue) ;
        return ;
      case DeclarativePackage.COMM_ACTION__REFERENCE :
        setReference((Reference) newValue) ;
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
      case DeclarativePackage.COMM_ACTION__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.COMM_ACTION__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.COMM_ACTION__PARAMETERS :
        unsetParameters() ;
        return ;
      case DeclarativePackage.COMM_ACTION__PORT_FREEZE :
        setPortFreeze(PORT_FREEZE_EDEFAULT) ;
        return ;
      case DeclarativePackage.COMM_ACTION__PORT_DEQUEUE :
        setPortDequeue(PORT_DEQUEUE_EDEFAULT) ;
        return ;
      case DeclarativePackage.COMM_ACTION__LOCK :
        setLock(LOCK_EDEFAULT) ;
        return ;
      case DeclarativePackage.COMM_ACTION__UNLOCK :
        setUnlock(UNLOCK_EDEFAULT) ;
        return ;
      case DeclarativePackage.COMM_ACTION__TARGET :
        setTarget((Target) null) ;
        return ;
      case DeclarativePackage.COMM_ACTION__QUALIFIED_NAME :
        setQualifiedName((QualifiedNamedElement) null) ;
        return ;
      case DeclarativePackage.COMM_ACTION__REFERENCE :
        setReference((Reference) null) ;
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
      case DeclarativePackage.COMM_ACTION__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.COMM_ACTION__BA_REF :
        return baRef != null ;
      case DeclarativePackage.COMM_ACTION__PARAMETERS :
        return isSetParameters() ;
      case DeclarativePackage.COMM_ACTION__PORT_FREEZE :
        return portFreeze != PORT_FREEZE_EDEFAULT ;
      case DeclarativePackage.COMM_ACTION__PORT_DEQUEUE :
        return portDequeue != PORT_DEQUEUE_EDEFAULT ;
      case DeclarativePackage.COMM_ACTION__LOCK :
        return lock != LOCK_EDEFAULT ;
      case DeclarativePackage.COMM_ACTION__UNLOCK :
        return unlock != UNLOCK_EDEFAULT ;
      case DeclarativePackage.COMM_ACTION__TARGET :
        return target != null ;
      case DeclarativePackage.COMM_ACTION__QUALIFIED_NAME :
        return qualifiedName != null ;
      case DeclarativePackage.COMM_ACTION__REFERENCE :
        return reference != null ;
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
        case DeclarativePackage.COMM_ACTION__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.COMM_ACTION__BA_REF :
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
          return DeclarativePackage.COMM_ACTION__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.COMM_ACTION__BA_REF ;
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
    result.append(" (portFreeze: ") ;
    result.append(portFreeze) ;
    result.append(", portDequeue: ") ;
    result.append(portDequeue) ;
    result.append(", lock: ") ;
    result.append(lock) ;
    result.append(", unlock: ") ;
    result.append(unlock) ;
    result.append(')') ;
    return result.toString() ;
  }

} //CommActionImpl
