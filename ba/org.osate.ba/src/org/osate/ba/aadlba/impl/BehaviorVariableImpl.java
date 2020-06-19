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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Data;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.PropertyAssociation;

import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.ValueConstant;
import org.osate.ba.utils.AadlBaLocationReference ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorVariableImpl#getArrayDimensions <em>Array Dimension</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorVariableImpl#getDataClassifier <em>Data Classifier</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorVariableImpl#getOwnedPropertyAssociations <em>Owned Property Associations</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorVariableImpl#getOwnedValueConstant <em>Owned Value Constant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorVariableImpl extends BehaviorNamedElementImpl implements BehaviorVariable
{
  /**
   * The cached value of the '{@link #getArrayDimensions() <em>Array Dimension</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayDimensions()
   * @generated
   * @ordered
   */
  protected EList<ArrayDimension> arrayDimensions;

  /**
   * The cached value of the '{@link #getDataClassifier() <em>Data Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataClassifier()
   * @generated
   * @ordered
   */
  protected DataClassifier dataClassifier;

  /**
   * The cached value of the '{@link #getOwnedPropertyAssociations() <em>Owned Property Associations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedPropertyAssociations()
   * @generated
   * @ordered
   */
  protected EList<PropertyAssociation> ownedPropertyAssociations;

  /**
   * The cached value of the '{@link #getOwnedValueConstant() <em>Owned Value Constant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedValueConstant()
   * @generated
   * @ordered
   */
  protected ValueConstant ownedValueConstant;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorVariableImpl()
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
    return AadlBaPackage.Literals.BEHAVIOR_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ArrayDimension> getArrayDimensions()
  {
    if (arrayDimensions == null)
    {
      arrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION);
    }
    return arrayDimensions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DataClassifier getDataClassifier()
  {
    if (dataClassifier != null && ((EObject)dataClassifier).eIsProxy())
    {
      InternalEObject oldDataClassifier = (InternalEObject)dataClassifier;
      dataClassifier = (DataClassifier)eResolveProxy(oldDataClassifier);
      if (dataClassifier != oldDataClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_VARIABLE__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
      }
    }
    return dataClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataClassifier basicGetDataClassifier()
  {
    return dataClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDataClassifier(DataClassifier newDataClassifier)
  {
    DataClassifier oldDataClassifier = dataClassifier;
    dataClassifier = newDataClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_VARIABLE__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PropertyAssociation> getOwnedPropertyAssociations()
  {
    if (ownedPropertyAssociations == null)
    {
      ownedPropertyAssociations = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class, this, AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS);
    }
    return ownedPropertyAssociations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueConstant getOwnedValueConstant()
  {
    return ownedValueConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedValueConstant(ValueConstant newOwnedValueConstant, NotificationChain msgs)
  {
    ValueConstant oldOwnedValueConstant = ownedValueConstant;
    ownedValueConstant = newOwnedValueConstant;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT, oldOwnedValueConstant, newOwnedValueConstant);
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
  public void setOwnedValueConstant(ValueConstant newOwnedValueConstant)
  {
    if (newOwnedValueConstant != ownedValueConstant)
    {
      NotificationChain msgs = null;
      if (ownedValueConstant != null)
        msgs = ((InternalEObject)ownedValueConstant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT, null, msgs);
      if (newOwnedValueConstant != null)
        msgs = ((InternalEObject)newOwnedValueConstant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT, null, msgs);
      msgs = basicSetOwnedValueConstant(newOwnedValueConstant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT, newOwnedValueConstant, newOwnedValueConstant));
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
      case AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION:
        return ((InternalEList<?>)getArrayDimensions()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS:
        return ((InternalEList<?>)getOwnedPropertyAssociations()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT:
        return basicSetOwnedValueConstant(null, msgs);
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
      case AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION:
        return getArrayDimensions();
      case AadlBaPackage.BEHAVIOR_VARIABLE__DATA_CLASSIFIER:
        if (resolve) return getDataClassifier();
        return basicGetDataClassifier();
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS:
        return getOwnedPropertyAssociations();
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT:
        return getOwnedValueConstant();
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
      case AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION:
        getArrayDimensions().clear();
        getArrayDimensions().addAll((Collection<? extends ArrayDimension>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_VARIABLE__DATA_CLASSIFIER:
        setDataClassifier((DataClassifier)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS:
        getOwnedPropertyAssociations().clear();
        getOwnedPropertyAssociations().addAll((Collection<? extends PropertyAssociation>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT:
        setOwnedValueConstant((ValueConstant)newValue);
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
      case AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION:
        getArrayDimensions().clear();
        return;
      case AadlBaPackage.BEHAVIOR_VARIABLE__DATA_CLASSIFIER:
        setDataClassifier((DataClassifier)null);
        return;
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS:
        getOwnedPropertyAssociations().clear();
        return;
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT:
        setOwnedValueConstant((ValueConstant)null);
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
      case AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION:
        return arrayDimensions != null && !arrayDimensions.isEmpty();
      case AadlBaPackage.BEHAVIOR_VARIABLE__DATA_CLASSIFIER:
        return dataClassifier != null;
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS:
        return ownedPropertyAssociations != null && !ownedPropertyAssociations.isEmpty();
      case AadlBaPackage.BEHAVIOR_VARIABLE__OWNED_VALUE_CONSTANT:
        return ownedValueConstant != null;
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
    if (baseClass == ArrayableElement.class)
    {
      switch (derivedFeatureID)
      {
        case AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION: return Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_DIMENSION;
        default: return -1;
      }
    }
    if (baseClass == Data.class)
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
    if (baseClass == ArrayableElement.class)
    {
      switch (baseFeatureID)
      {
        case Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_DIMENSION: return AadlBaPackage.BEHAVIOR_VARIABLE__ARRAY_DIMENSION;
        default: return -1;
      }
    }
    if (baseClass == Data.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }
  
    
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  public ArrayDimension createArrayDimension() {
    ArrayDimension newArrayDimension = (ArrayDimension) create(Aadl2Package.eINSTANCE.getArrayDimension());
    getArrayDimensions().add(newArrayDimension);
    return newArrayDimension;
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }

} //BehaviorVariableImpl
