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

import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.ArrayRange ;
import org.osate.aadl2.ContainmentPathElement ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.NamedElement ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.DispatchTrigger ;
import org.osate.ba.aadlba.DispatchTriggerCondition ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.ModeSwitchTrigger ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.impl.ActualPortHolderImpl ;
import org.osate.ba.declarative.ArrayableIdentifier ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.Reference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getArrayRanges <em>Array Range</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getNamedElement <em>Named Element</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.ReferenceImpl#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends ActualPortHolderImpl implements Reference
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
   * The cached value of the '{@link #getArrayRanges() <em>Array Range</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayRanges()
   * @generated
   * @ordered
   */
  protected EList<ArrayRange> arrayRanges ;

  /**
   * The cached value of the '{@link #getNamedElement() <em>Named Element</em>}' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getNamedElement()
   * @generated
   * @ordered
   */
  protected NamedElement namedElement ;

  /**
   * The default value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getAnnexName()
   * @generated
   * @ordered
   */
  protected static final String ANNEX_NAME_EDEFAULT = null ;

  /**
   * The cached value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getAnnexName()
   * @generated
   * @ordered
   */
  protected String annexName = ANNEX_NAME_EDEFAULT ;

  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected ContainmentPathElement path ;

  /**
   * The cached value of the '{@link #getIds() <em>Ids</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIds()
   * @generated
   * @ordered
   */
  protected EList<ArrayableIdentifier> ids ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceImpl()
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
    return DeclarativePackage.Literals.REFERENCE ;
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
                                        DeclarativePackage.REFERENCE__OSATE_REF,
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
                                    DeclarativePackage.REFERENCE__OSATE_REF,
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
                                        DeclarativePackage.REFERENCE__BA_REF,
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
                                    DeclarativePackage.REFERENCE__BA_REF,
                                    oldBaRef, baRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ArrayRange> getArrayRanges()
  {
    if(arrayRanges == null)
    {
      arrayRanges = new EObjectContainmentEList<ArrayRange>(ArrayRange.class,
                                                            this,
                                                            DeclarativePackage.REFERENCE__ARRAY_RANGE) ;
    }
    return arrayRanges ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElement getNamedElement()
  {
    if(namedElement != null && ((EObject) namedElement).eIsProxy())
    {
      InternalEObject oldNamedElement = (InternalEObject) namedElement ;
      namedElement = (NamedElement) eResolveProxy(oldNamedElement) ;
      if(namedElement != oldNamedElement)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.REFERENCE__NAMED_ELEMENT,
                                        oldNamedElement, namedElement)) ;
      }
    }
    return namedElement ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetNamedElement()
  {
    return namedElement ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNamedElement(NamedElement newNamedElement)
  {
    NamedElement oldNamedElement = namedElement ;
    namedElement = newNamedElement ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.REFERENCE__NAMED_ELEMENT,
                                    oldNamedElement, namedElement)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getAnnexName()
  {
    return annexName ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAnnexName(String newAnnexName)
  {
    String oldAnnexName = annexName ;
    annexName = newAnnexName ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.REFERENCE__ANNEX_NAME,
                                    oldAnnexName, annexName)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContainmentPathElement getPath()
  {
    return path ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(ContainmentPathElement newPath,
                                        NotificationChain msgs)
  {
    ContainmentPathElement oldPath = path ;
    path = newPath ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.REFERENCE__PATH,
                                                             oldPath, newPath) ;
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
  public void setPath(ContainmentPathElement newPath)
  {
    if(newPath != path)
    {
      NotificationChain msgs = null ;
      if(path != null)
        msgs = ((InternalEObject) path).eInverseRemove(this,
                                                       EOPPOSITE_FEATURE_BASE -
                                                             DeclarativePackage.REFERENCE__PATH,
                                                       null, msgs) ;
      if(newPath != null)
        msgs = ((InternalEObject) newPath).eInverseAdd(this,
                                                       EOPPOSITE_FEATURE_BASE -
                                                             DeclarativePackage.REFERENCE__PATH,
                                                       null, msgs) ;
      msgs = basicSetPath(newPath, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.REFERENCE__PATH, newPath,
                                    newPath)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ArrayableIdentifier> getIds()
  {
    if(ids == null)
    {
      ids = new EObjectContainmentEList<ArrayableIdentifier>(
                                                             ArrayableIdentifier.class,
                                                             this,
                                                             DeclarativePackage.REFERENCE__IDS) ;
    }
    return ids ;
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
      case DeclarativePackage.REFERENCE__ARRAY_RANGE :
        return ((InternalEList<?>) getArrayRanges()).basicRemove(otherEnd,
                                                                 msgs) ;
      case DeclarativePackage.REFERENCE__PATH :
        return basicSetPath(null, msgs) ;
      case DeclarativePackage.REFERENCE__IDS :
        return ((InternalEList<?>) getIds()).basicRemove(otherEnd, msgs) ;
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
      case DeclarativePackage.REFERENCE__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.REFERENCE__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.REFERENCE__ARRAY_RANGE :
        return getArrayRanges() ;
      case DeclarativePackage.REFERENCE__NAMED_ELEMENT :
        if(resolve)
          return getNamedElement() ;
        return basicGetNamedElement() ;
      case DeclarativePackage.REFERENCE__ANNEX_NAME :
        return getAnnexName() ;
      case DeclarativePackage.REFERENCE__PATH :
        return getPath() ;
      case DeclarativePackage.REFERENCE__IDS :
        return getIds() ;
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
      case DeclarativePackage.REFERENCE__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.REFERENCE__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.REFERENCE__ARRAY_RANGE :
        getArrayRanges().clear() ;
        getArrayRanges().addAll((Collection<? extends ArrayRange>) newValue) ;
        return ;
      case DeclarativePackage.REFERENCE__NAMED_ELEMENT :
        setNamedElement((NamedElement) newValue) ;
        return ;
      case DeclarativePackage.REFERENCE__ANNEX_NAME :
        setAnnexName((String) newValue) ;
        return ;
      case DeclarativePackage.REFERENCE__PATH :
        setPath((ContainmentPathElement) newValue) ;
        return ;
      case DeclarativePackage.REFERENCE__IDS :
        getIds().clear() ;
        getIds().addAll((Collection<? extends ArrayableIdentifier>) newValue) ;
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
      case DeclarativePackage.REFERENCE__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.REFERENCE__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.REFERENCE__ARRAY_RANGE :
        getArrayRanges().clear() ;
        return ;
      case DeclarativePackage.REFERENCE__NAMED_ELEMENT :
        setNamedElement((NamedElement) null) ;
        return ;
      case DeclarativePackage.REFERENCE__ANNEX_NAME :
        setAnnexName(ANNEX_NAME_EDEFAULT) ;
        return ;
      case DeclarativePackage.REFERENCE__PATH :
        setPath((ContainmentPathElement) null) ;
        return ;
      case DeclarativePackage.REFERENCE__IDS :
        getIds().clear() ;
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
      case DeclarativePackage.REFERENCE__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.REFERENCE__BA_REF :
        return baRef != null ;
      case DeclarativePackage.REFERENCE__ARRAY_RANGE :
        return arrayRanges != null && !arrayRanges.isEmpty() ;
      case DeclarativePackage.REFERENCE__NAMED_ELEMENT :
        return namedElement != null ;
      case DeclarativePackage.REFERENCE__ANNEX_NAME :
        return ANNEX_NAME_EDEFAULT == null ? annexName != null
                                           : !ANNEX_NAME_EDEFAULT.equals(annexName) ;
      case DeclarativePackage.REFERENCE__PATH :
        return path != null ;
      case DeclarativePackage.REFERENCE__IDS :
        return ids != null && !ids.isEmpty() ;
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
        case DeclarativePackage.REFERENCE__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.REFERENCE__BA_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;
        default :
          return -1 ;
      }
    }
    if(baseClass == ElementValues.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ParameterLabel.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == Target.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DispatchTriggerCondition.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DispatchTrigger.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ModeSwitchTrigger.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ContainmentPathElement.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.REFERENCE__ARRAY_RANGE :
          return Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE ;
        case DeclarativePackage.REFERENCE__NAMED_ELEMENT :
          return Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT ;
        case DeclarativePackage.REFERENCE__ANNEX_NAME :
          return Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME ;
        case DeclarativePackage.REFERENCE__PATH :
          return Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH ;
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
          return DeclarativePackage.REFERENCE__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.REFERENCE__BA_REF ;
        default :
          return -1 ;
      }
    }
    if(baseClass == ElementValues.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ParameterLabel.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == Target.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DispatchTriggerCondition.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == DispatchTrigger.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ModeSwitchTrigger.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ContainmentPathElement.class)
    {
      switch ( baseFeatureID )
      {
        case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ARRAY_RANGE :
          return DeclarativePackage.REFERENCE__ARRAY_RANGE ;
        case Aadl2Package.CONTAINMENT_PATH_ELEMENT__NAMED_ELEMENT :
          return DeclarativePackage.REFERENCE__NAMED_ELEMENT ;
        case Aadl2Package.CONTAINMENT_PATH_ELEMENT__ANNEX_NAME :
          return DeclarativePackage.REFERENCE__ANNEX_NAME ;
        case Aadl2Package.CONTAINMENT_PATH_ELEMENT__PATH :
          return DeclarativePackage.REFERENCE__PATH ;
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
    result.append(" (annexName: ") ;
    result.append(annexName) ;
    result.append(')') ;
    return result.toString() ;
  }

  @Override
  public ArrayRange createArrayRange()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public ContainmentPathElement createPath()
  {
    // TODO Auto-generated method stub
    return null ;
  }

} //ReferenceImpl
