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
package org.osate.ba.aadlba.impl;

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
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.IndexableElement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.PropertyElementHolder ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Element Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.PropertyElementHolderImpl#getArrayIndexes <em>Array Indexes</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.PropertyElementHolderImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyElementHolderImpl extends BehaviorElementImpl implements PropertyElementHolder
{
  /**
   * The cached value of the '{@link #getArrayIndexes() <em>Array Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayIndexes()
   * @generated
   * @ordered
   */
  protected EList<IntegerValue> arrayIndexes;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected Element element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyElementHolderImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AadlBaPackage.Literals.PROPERTY_ELEMENT_HOLDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IntegerValue> getArrayIndexes()
  {
    if (arrayIndexes == null)
    {
      arrayIndexes = new EObjectContainmentEList.Unsettable<IntegerValue>(IntegerValue.class, this, AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES);
    }
    return arrayIndexes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetArrayIndexes()
  {
    if (arrayIndexes != null) ((InternalEList.Unsettable<?>)arrayIndexes).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetArrayIndexes()
  {
    return arrayIndexes != null && ((InternalEList.Unsettable<?>)arrayIndexes).isSet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Element getElement()
  {
    if (element != null && ((EObject)element).eIsProxy())
    {
      InternalEObject oldElement = (InternalEObject)element;
      element = (Element)eResolveProxy(oldElement);
      if (element != oldElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ELEMENT, oldElement, element));
      }
    }
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element basicGetElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setElement(Element newElement)
  {
    Element oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES:
        return ((InternalEList<?>)getArrayIndexes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES:
        return getArrayIndexes();
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ELEMENT:
        if (resolve) return getElement();
        return basicGetElement();
    }
    return super.eGet(featureID, resolve, coreType);
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
    switch (featureID)
    {
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES:
        getArrayIndexes().clear();
        getArrayIndexes().addAll((Collection<? extends IntegerValue>)newValue);
        return;
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ELEMENT:
        setElement((Element)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES:
        unsetArrayIndexes();
        return;
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ELEMENT:
        setElement((Element)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES:
        return isSetArrayIndexes();
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == IndexableElement.class)
    {
      switch (derivedFeatureID)
      {
        case AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES: return AadlBaPackage.INDEXABLE_ELEMENT__ARRAY_INDEXES;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == IndexableElement.class)
    {
      switch (baseFeatureID)
      {
        case AadlBaPackage.INDEXABLE_ELEMENT__ARRAY_INDEXES: return AadlBaPackage.PROPERTY_ELEMENT_HOLDER__ARRAY_INDEXES;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //PropertyElementHolderImpl
