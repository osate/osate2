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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.aadl2.NamedElement ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.IndexableElement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.StructUnionElement ;
import org.osate.ba.aadlba.StructUnionElementHolder ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Union Element Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.StructUnionElementHolderImpl#getArrayIndexes <em>Array Indexes</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.StructUnionElementHolderImpl#getStructUnionElement <em>Struct Union Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructUnionElementHolderImpl extends DataHolderImpl implements StructUnionElementHolder
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
   * The cached value of the '{@link #getStructUnionElement() <em>Struct Union Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructUnionElement()
   * @generated
   * @ordered
   */
  protected StructUnionElement structUnionElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructUnionElementHolderImpl()
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
    return AadlBaPackage.Literals.STRUCT_UNION_ELEMENT_HOLDER;
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
      arrayIndexes = new EObjectContainmentEList.Unsettable<IntegerValue>(IntegerValue.class, this, AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES);
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
  public void setStructUnionElement(StructUnionElement newStructUnionElement )
  {
    if (newStructUnionElement != structUnionElement)
    {
      NotificationChain msgs = null;
      if (structUnionElement != null)
        msgs = ((InternalEObject)structUnionElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT, null, msgs);
      if (newStructUnionElement != null)
        msgs = ((InternalEObject)newStructUnionElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT, null, msgs);
      msgs = basicSetStructUnionElement(newStructUnionElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT, newStructUnionElement, newStructUnionElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StructUnionElement getStructUnionElement()
  {
    return structUnionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public NotificationChain basicSetStructUnionElement(StructUnionElement newStructUnionElement, NotificationChain msgs)
  {
    super.setElement(newStructUnionElement);
    StructUnionElement oldStructUnionElement = structUnionElement;
    structUnionElement = newStructUnionElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT, oldStructUnionElement, newStructUnionElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES:
        return ((InternalEList<?>)getArrayIndexes()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT:
        return basicSetStructUnionElement(null, msgs);
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES:
        return getArrayIndexes();
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT:
        return getStructUnionElement();
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES:
        getArrayIndexes().clear();
        getArrayIndexes().addAll((Collection<? extends IntegerValue>)newValue);
        return;
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT:
        setStructUnionElement((StructUnionElement)newValue);
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES:
        unsetArrayIndexes();
        return;
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT:
        setStructUnionElement((StructUnionElement)null);
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES:
        return isSetArrayIndexes();
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__STRUCT_UNION_ELEMENT:
        return structUnionElement != null;
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
        case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES: return AadlBaPackage.INDEXABLE_ELEMENT__ARRAY_INDEXES;
        default: return -1;
      }
    }
    if (baseClass == ParameterLabel.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == Target.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ElementValues.class)
    {
      switch (derivedFeatureID)
      {
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
        case AadlBaPackage.INDEXABLE_ELEMENT__ARRAY_INDEXES: return AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES;
        default: return -1;
      }
    }
    if (baseClass == ParameterLabel.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == Target.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ElementValues.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }
  
  @Override
  public void setElement(NamedElement elt)
  {
    if(elt instanceof StructUnionElement)
      setStructUnionElement((StructUnionElement) elt);
    else
      super.setElement(elt);
  }
  
} //StructUnionElementHolderImpl
