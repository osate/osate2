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
import org.osate.aadl2.AbstractNamedValue ;
import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.ContainedNamedElement ;
import org.osate.aadl2.ContainmentPathElement ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.FeatureClassifier ;
import org.osate.aadl2.MetaclassReference ;
import org.osate.aadl2.Mode ;
import org.osate.aadl2.ModeTransition ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.Processor ;
import org.osate.aadl2.ProcessorClassifier ;
import org.osate.aadl2.ProcessorSubcomponentType ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.PropertyOwner ;
import org.osate.aadl2.PropertyType ;
import org.osate.aadl2.PropertyValue ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.SubcomponentType ;
import org.osate.aadl2.Type ;
import org.osate.aadl2.TypedElement ;
import org.osate.aadl2.UnitLiteral ;
import org.osate.aadl2.impl.ClassifierImpl ;
import org.osate.aadl2.impl.DataClassifierImpl ;
import org.osate.aadl2.properties.EvaluatedProperty ;
import org.osate.aadl2.properties.EvaluationContext ;
import org.osate.aadl2.properties.PropertyEvaluationResult ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.IntegerValueConstant ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueConstant ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePackage ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.declarative.QualifiedNamedElement ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitable ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getReferencedPropertyType <em>Referenced Property Type</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getOwnedPropertyType <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getPropertyType <em>Property Type</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#isInherit <em>Inherit</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getAppliesToMetaclasses <em>Applies To Metaclass</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getAppliesToClassifiers <em>Applies To Classifier</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#isEmptyListDefault <em>Empty List Default</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getBaNamespace <em>Ba Namespace</em>}</li>
 *   <li>{@link org.osate.ba.declarative.impl.QualifiedNamedElementImpl#getBaName <em>Ba Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNamedElementImpl extends DataClassifierImpl implements
                                       QualifiedNamedElement, IBAVisitable
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
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type ;

  /**
   * The cached value of the '{@link #getReferencedPropertyType() <em>Referenced Property Type</em>}' reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getReferencedPropertyType()
   * @generated
   * @ordered
   */
  protected PropertyType referencedPropertyType ;

  /**
   * The cached value of the '{@link #getOwnedPropertyType() <em>Owned Property Type</em>}' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getOwnedPropertyType()
   * @generated
   * @ordered
   */
  protected PropertyType ownedPropertyType ;

  /**
   * The default value of the '{@link #isInherit() <em>Inherit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInherit()
   * @generated
   * @ordered
   */
  protected static final boolean INHERIT_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isInherit() <em>Inherit</em>}' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #isInherit()
   * @generated
   * @ordered
   */
  protected boolean inherit = INHERIT_EDEFAULT ;

  /**
   * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getDefaultValue()
   * @generated
   * @ordered
   */
  protected PropertyExpression defaultValue ;

  /**
   * The cached value of the '{@link #getAppliesTos() <em>Applies To</em>}' containment reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getAppliesTos()
   * @generated
   * @ordered
   */
  protected EList<PropertyOwner> appliesTos ;

  /**
   * The default value of the '{@link #isEmptyListDefault() <em>Empty List Default</em>}' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #isEmptyListDefault()
   * @generated
   * @ordered
   */
  protected static final boolean EMPTY_LIST_DEFAULT_EDEFAULT = false ;

  /**
   * The cached value of the '{@link #isEmptyListDefault() <em>Empty List Default</em>}' attribute.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #isEmptyListDefault()
   * @generated
   * @ordered
   */
  protected boolean emptyListDefault = EMPTY_LIST_DEFAULT_EDEFAULT ;

  /**
   * The cached value of the '{@link #getBaseUnit() <em>Base Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseUnit()
   * @generated
   * @ordered
   */
  protected UnitLiteral baseUnit ;

  /**
   * The cached value of the '{@link #getFactor() <em>Factor</em>}' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #getFactor()
   * @generated
   * @ordered
   */
  protected NumberValue factor ;

  /**
   * The cached value of the '{@link #getBaNamespace() <em>Ba Namespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaNamespace()
   * @generated
   * @ordered
   */
  protected Identifier baNamespace ;

  /**
   * The cached value of the '{@link #getBaName() <em>Ba Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaName()
   * @generated
   * @ordered
   */
  protected Identifier baName ;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNamedElementImpl()
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
    return DeclarativePackage.Literals.QUALIFIED_NAMED_ELEMENT ;
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
                                        DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF,
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
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF,
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
                                        DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF,
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
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF,
                                    oldBaRef, baRef)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type getType()
  {
    if(type != null && ((EObject) type).eIsProxy())
    {
      InternalEObject oldType = (InternalEObject) type ;
      type = (Type) eResolveProxy(oldType) ;
      if(type != oldType)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE,
                                        oldType, type)) ;
      }
    }
    return type ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetType()
  {
    return type ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(Type newType)
  {
    Type oldType = type ;
    type = newType ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE,
                                    oldType, type)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyType getReferencedPropertyType()
  {
    if(referencedPropertyType != null && ((EObject) referencedPropertyType)
                                                                           .eIsProxy())
    {
      InternalEObject oldReferencedPropertyType =
                                                (InternalEObject) referencedPropertyType ;
      referencedPropertyType = (PropertyType) eResolveProxy(
                                                            oldReferencedPropertyType) ;
      if(referencedPropertyType != oldReferencedPropertyType)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE,
                                        oldReferencedPropertyType,
                                        referencedPropertyType)) ;
      }
    }
    return referencedPropertyType ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public PropertyType basicGetReferencedPropertyType()
  {
    return referencedPropertyType ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReferencedPropertyType(PropertyType newReferencedPropertyType)
  {
    PropertyType oldReferencedPropertyType = referencedPropertyType ;
    referencedPropertyType = newReferencedPropertyType ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE,
                                    oldReferencedPropertyType,
                                    referencedPropertyType)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyType getOwnedPropertyType()
  {
    return ownedPropertyType ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedPropertyType(
                                                     PropertyType newOwnedPropertyType,
                                                     NotificationChain msgs)
  {
    PropertyType oldOwnedPropertyType = ownedPropertyType ;
    ownedPropertyType = newOwnedPropertyType ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE,
                                                             oldOwnedPropertyType,
                                                             newOwnedPropertyType) ;
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
  public void setOwnedPropertyType(PropertyType newOwnedPropertyType)
  {
    if(newOwnedPropertyType != ownedPropertyType)
    {
      NotificationChain msgs = null ;
      if(ownedPropertyType != null)
        msgs = ((InternalEObject) ownedPropertyType).eInverseRemove(this,
                                                                    EOPPOSITE_FEATURE_BASE -
                                                                          DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE,
                                                                    null,
                                                                    msgs) ;
      if(newOwnedPropertyType != null)
        msgs = ((InternalEObject) newOwnedPropertyType).eInverseAdd(this,
                                                                    EOPPOSITE_FEATURE_BASE -
                                                                          DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE,
                                                                    null,
                                                                    msgs) ;
      msgs = basicSetOwnedPropertyType(newOwnedPropertyType, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE,
                                    newOwnedPropertyType,
                                    newOwnedPropertyType)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyType getPropertyType()
  {
    PropertyType propertyType = basicGetPropertyType() ;
    return propertyType != null && ((EObject) propertyType).eIsProxy()
                                                                       ? (PropertyType) eResolveProxy((InternalEObject) propertyType)
                                                                       : propertyType ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public PropertyType basicGetPropertyType()
  {
    // TODO: implement this method to return the 'Property Type' reference
    // -> do not perform proxy resolution
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException() ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Identifier getBaNamespace()
  {
    return baNamespace ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaNamespace(Identifier newBaNamespace,
                                               NotificationChain msgs)
  {
    Identifier oldBaNamespace = baNamespace ;
    baNamespace = newBaNamespace ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                                                             oldBaNamespace,
                                                             newBaNamespace) ;
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
  public void setBaNamespace(Identifier newBaNamespace)
  {
    if(newBaNamespace != baNamespace)
    {
      NotificationChain msgs = null ;
      if(baNamespace != null)
        msgs = ((InternalEObject) baNamespace).eInverseRemove(this,
                                                              EOPPOSITE_FEATURE_BASE -
                                                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                                                              null, msgs) ;
      if(newBaNamespace != null)
        msgs = ((InternalEObject) newBaNamespace).eInverseAdd(this,
                                                              EOPPOSITE_FEATURE_BASE -
                                                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                                                              null, msgs) ;
      msgs = basicSetBaNamespace(newBaNamespace, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE,
                                    newBaNamespace, newBaNamespace)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Identifier getBaName()
  {
    return baName ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaName(Identifier newBaName,
                                          NotificationChain msgs)
  {
    Identifier oldBaName = baName ;
    baName = newBaName ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                                                             oldBaName,
                                                             newBaName) ;
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
  public void setBaName(Identifier newBaName)
  {
    if(newBaName != baName)
    {
      NotificationChain msgs = null ;
      if(baName != null)
        msgs = ((InternalEObject) baName).eInverseRemove(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                                                         null, msgs) ;
      if(newBaName != null)
        msgs = ((InternalEObject) newBaName).eInverseAdd(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                                                         null, msgs) ;
      msgs = basicSetBaName(newBaName, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME,
                                    newBaName, newBaName)) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public double getAbsoluteFactor(UnitLiteral target)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException() ;
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
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE :
        return basicSetOwnedPropertyType(null, msgs) ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE :
        return basicSetDefaultValue(null, msgs) ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO :
        return ((InternalEList<?>) getAppliesTos()).basicRemove(otherEnd,
                                                                msgs) ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR :
        return basicSetFactor(null, msgs) ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        return basicSetBaNamespace(null, msgs) ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        return basicSetBaName(null, msgs) ;
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
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        if(resolve)
          return getOsateRef() ;
        return basicGetOsateRef() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        if(resolve)
          return getBaRef() ;
        return basicGetBaRef() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE :
        if(resolve)
          return getType() ;
        return basicGetType() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE :
        if(resolve)
          return getReferencedPropertyType() ;
        return basicGetReferencedPropertyType() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE :
        return getOwnedPropertyType() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__PROPERTY_TYPE :
        if(resolve)
          return getPropertyType() ;
        return basicGetPropertyType() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__INHERIT :
        return isInherit() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE :
        return getDefaultValue() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS :
        return getAppliesToMetaclasses() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER :
        return getAppliesToClassifiers() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO :
        return getAppliesTos() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT :
        return isEmptyListDefault() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT :
        if(resolve)
          return getBaseUnit() ;
        return basicGetBaseUnit() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR :
        return getFactor() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        return getBaNamespace() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        return getBaName() ;
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
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        setOsateRef((Element) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        setBaRef((BehaviorElement) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE :
        setType((Type) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE :
        setReferencedPropertyType((PropertyType) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE :
        setOwnedPropertyType((PropertyType) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__INHERIT :
        setInherit((Boolean) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE :
        setDefaultValue((PropertyExpression) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS :
        getAppliesToMetaclasses().clear() ;
        getAppliesToMetaclasses().addAll((Collection<? extends MetaclassReference>) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER :
        getAppliesToClassifiers().clear() ;
        getAppliesToClassifiers().addAll((Collection<? extends Classifier>) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO :
        getAppliesTos().clear() ;
        getAppliesTos().addAll((Collection<? extends PropertyOwner>) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT :
        setEmptyListDefault((Boolean) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT :
        setBaseUnit((UnitLiteral) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR :
        setFactor((NumberValue) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        setBaNamespace((Identifier) newValue) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        setBaName((Identifier) newValue) ;
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
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        setOsateRef((Element) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        setBaRef((BehaviorElement) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE :
        setType((Type) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE :
        setReferencedPropertyType((PropertyType) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE :
        setOwnedPropertyType((PropertyType) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__INHERIT :
        setInherit(INHERIT_EDEFAULT) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE :
        setDefaultValue((PropertyExpression) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS :
        getAppliesToMetaclasses().clear() ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER :
        getAppliesToClassifiers().clear() ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO :
        getAppliesTos().clear() ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT :
        setEmptyListDefault(EMPTY_LIST_DEFAULT_EDEFAULT) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT :
        setBaseUnit((UnitLiteral) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR :
        setFactor((NumberValue) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        setBaNamespace((Identifier) null) ;
        return ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        setBaName((Identifier) null) ;
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
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
        return osateRef != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
        return baRef != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE :
        return type != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE :
        return referencedPropertyType != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE :
        return ownedPropertyType != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__PROPERTY_TYPE :
        return basicGetPropertyType() != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__INHERIT :
        return inherit != INHERIT_EDEFAULT ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE :
        return defaultValue != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS :
        return !getAppliesToMetaclasses().isEmpty() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER :
        return !getAppliesToClassifiers().isEmpty() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO :
        return appliesTos != null && !appliesTos.isEmpty() ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT :
        return emptyListDefault != EMPTY_LIST_DEFAULT_EDEFAULT ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT :
        return baseUnit != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR :
        return factor != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAMESPACE :
        return baNamespace != null ;
      case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_NAME :
        return baName != null ;
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
    if(baseClass == BehaviorElement.class)
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
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__OSATE_REF ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF :
          return DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF ;
        default :
          return -1 ;
      }
    }
    if(baseClass == Value.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ValueConstant.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValue.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValueConstant.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == Processor.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ProcessorSubcomponentType.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ProcessorClassifier.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == TypedElement.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE :
          return Aadl2Package.TYPED_ELEMENT__TYPE ;
        default :
          return -1 ;
      }
    }
    if(baseClass == BasicProperty.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE :
          return Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE :
          return Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__PROPERTY_TYPE :
          return Aadl2Package.BASIC_PROPERTY__PROPERTY_TYPE ;
        default :
          return -1 ;
      }
    }
    if(baseClass == AbstractNamedValue.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == Property.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__INHERIT :
          return Aadl2Package.PROPERTY__INHERIT ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE :
          return Aadl2Package.PROPERTY__DEFAULT_VALUE ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS :
          return Aadl2Package.PROPERTY__APPLIES_TO_METACLASS ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER :
          return Aadl2Package.PROPERTY__APPLIES_TO_CLASSIFIER ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO :
          return Aadl2Package.PROPERTY__APPLIES_TO ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT :
          return Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT ;
        default :
          return -1 ;
      }
    }
    if(baseClass == EnumerationLiteral.class)
    {
      switch ( derivedFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == UnitLiteral.class)
    {
      switch ( derivedFeatureID )
      {
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT :
          return Aadl2Package.UNIT_LITERAL__BASE_UNIT ;
        case DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR :
          return Aadl2Package.UNIT_LITERAL__FACTOR ;
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
    if(baseClass == BehaviorElement.class)
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
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OSATE_REF ;
        case DeclarativePackage.DECLARATIVE_BEHAVIOR_ELEMENT__BA_REF :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BA_REF ;
        default :
          return -1 ;
      }
    }
    if(baseClass == Value.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ValueConstant.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValue.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == IntegerValueConstant.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == Processor.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ProcessorSubcomponentType.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == ProcessorClassifier.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == TypedElement.class)
    {
      switch ( baseFeatureID )
      {
        case Aadl2Package.TYPED_ELEMENT__TYPE :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__TYPE ;
        default :
          return -1 ;
      }
    }
    if(baseClass == BasicProperty.class)
    {
      switch ( baseFeatureID )
      {
        case Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__REFERENCED_PROPERTY_TYPE ;
        case Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__OWNED_PROPERTY_TYPE ;
        case Aadl2Package.BASIC_PROPERTY__PROPERTY_TYPE :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__PROPERTY_TYPE ;
        default :
          return -1 ;
      }
    }
    if(baseClass == AbstractNamedValue.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == Property.class)
    {
      switch ( baseFeatureID )
      {
        case Aadl2Package.PROPERTY__INHERIT :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__INHERIT ;
        case Aadl2Package.PROPERTY__DEFAULT_VALUE :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE ;
        case Aadl2Package.PROPERTY__APPLIES_TO_METACLASS :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_METACLASS ;
        case Aadl2Package.PROPERTY__APPLIES_TO_CLASSIFIER :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO_CLASSIFIER ;
        case Aadl2Package.PROPERTY__APPLIES_TO :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__APPLIES_TO ;
        case Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__EMPTY_LIST_DEFAULT ;
        default :
          return -1 ;
      }
    }
    if(baseClass == EnumerationLiteral.class)
    {
      switch ( baseFeatureID )
      {
        default :
          return -1 ;
      }
    }
    if(baseClass == UnitLiteral.class)
    {
      switch ( baseFeatureID )
      {
        case Aadl2Package.UNIT_LITERAL__BASE_UNIT :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT ;
        case Aadl2Package.UNIT_LITERAL__FACTOR :
          return DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR ;
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
    result.append(" (inherit: ") ;
    result.append(inherit) ;
    result.append(", emptyListDefault: ") ;
    result.append(emptyListDefault) ;
    result.append(')') ;
    return result.toString() ;
  }

  @Override
  public ComponentCategory getCategory()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Mode> getAllModes()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<ModeTransition> getAllModeTransitions()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Prototype> getAllPrototypes()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public Classifier getExtended()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Feature> getAllFeatures()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public boolean isDescendentOf(Classifier c)
  {
    // TODO Auto-generated method stub
    return false ;
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }

  @Override
  public void accept(IBAVisitor visitor)
  {
    visitor.visit(this) ;
  }

  @Override
  public boolean isInherit()
  {
    // TODO Auto-generated method stub
    return false ;
  }

  @Override
  public void setInherit(boolean value)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public PropertyExpression getDefaultValue()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefaultValue(
                                                PropertyExpression newDefaultValue,
                                                NotificationChain msgs)
  {
    PropertyExpression oldDefaultValue = defaultValue ;
    defaultValue = newDefaultValue ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.QUALIFIED_NAMED_ELEMENT__DEFAULT_VALUE,
                                                             oldDefaultValue,
                                                             newDefaultValue) ;
      if(msgs == null)
        msgs = notification ;
      else
        msgs.add(notification) ;
    }
    return msgs ;
  }

  @Override
  public void setDefaultValue(PropertyExpression value)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public EList<PropertyOwner> getAppliesTos()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public PropertyOwner createAppliesTo(EClass eClass)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public boolean isEmptyListDefault()
  {
    // TODO Auto-generated method stub
    return false ;
  }

  @Override
  public void setEmptyListDefault(boolean value)
  {
    // TODO Auto-generated method stub

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnitLiteral getBaseUnit()
  {
    if(baseUnit != null && ((EObject) baseUnit).eIsProxy())
    {
      InternalEObject oldBaseUnit = (InternalEObject) baseUnit ;
      baseUnit = (UnitLiteral) eResolveProxy(oldBaseUnit) ;
      if(baseUnit != oldBaseUnit)
      {
        if(eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                                        DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT,
                                        oldBaseUnit, baseUnit)) ;
      }
    }
    return baseUnit ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public UnitLiteral basicGetBaseUnit()
  {
    return baseUnit ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBaseUnit(UnitLiteral newBaseUnit)
  {
    UnitLiteral oldBaseUnit = baseUnit ;
    baseUnit = newBaseUnit ;
    if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__BASE_UNIT,
                                    oldBaseUnit, baseUnit)) ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NumberValue getFactor()
  {
    return factor ;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFactor(NumberValue newFactor,
                                          NotificationChain msgs)
  {
    NumberValue oldFactor = factor ;
    factor = newFactor ;
    if(eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this,
                                                             Notification.SET,
                                                             DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR,
                                                             oldFactor,
                                                             newFactor) ;
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
  public void setFactor(NumberValue newFactor)
  {
    if(newFactor != factor)
    {
      NotificationChain msgs = null ;
      if(factor != null)
        msgs = ((InternalEObject) factor).eInverseRemove(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR,
                                                         null, msgs) ;
      if(newFactor != null)
        msgs = ((InternalEObject) newFactor).eInverseAdd(this,
                                                         EOPPOSITE_FEATURE_BASE -
                                                               DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR,
                                                         null, msgs) ;
      msgs = basicSetFactor(newFactor, msgs) ;
      if(msgs != null)
        msgs.dispatch() ;
    }
    else if(eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
                                    DeclarativePackage.QUALIFIED_NAMED_ELEMENT__FACTOR,
                                    newFactor, newFactor)) ;
  }

  @Override
  public PropertyExpression createDefaultValue(EClass eClass)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<MetaclassReference> getAppliesToMetaclasses()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EList<Classifier> getAppliesToClassifiers()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public PropertyEvaluationResult evaluate(EvaluationContext ctx, int depth)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public EvaluatedProperty evaluateDefault(EvaluationContext ctx)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public PropertyType createOwnedPropertyType(EClass eClass)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public boolean isList()
  {
    // TODO Auto-generated method stub
    return false ;
  }

  @Override
  public boolean sameAs(AbstractNamedValue namedValue)
  {
    // TODO Auto-generated method stub
    return false ;
  }

  @Override
  public NumberValue createFactor(EClass eClass)
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public double getAbsoluteFactor()
  {
    // TODO Auto-generated method stub
    return 0 ;
  }

  @Override
  public Mode createOwnedMode()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public ModeTransition createOwnedModeTransition()
  {
    // TODO Auto-generated method stub
    return null ;
  }
} //QualifiedNamedElementImpl
