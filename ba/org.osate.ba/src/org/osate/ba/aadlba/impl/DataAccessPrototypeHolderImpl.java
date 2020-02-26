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
import org.osate.aadl2.ClassifierFeature ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.ClassifierFeatureHolder ;
import org.osate.ba.aadlba.DataAccessPrototypeHolder ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.GroupHolder ;
import org.osate.ba.aadlba.GroupableElement ;
import org.osate.ba.aadlba.IndexableElement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.PrototypeHolder ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Access Prototype Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.DataAccessPrototypeHolderImpl#getArrayIndexes <em>Array Indexes</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.DataAccessPrototypeHolderImpl#getGroupHolders <em>Group Holders</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.DataAccessPrototypeHolderImpl#getPrototypeBinding <em>Prototype Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataAccessPrototypeHolderImpl extends DataHolderImpl implements DataAccessPrototypeHolder
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
   * The cached value of the '{@link #getGroupHolders() <em>Group Holders</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroupHolders()
   * @generated
   * @ordered
   */
  protected EList<GroupHolder> groupHolders;

  /**
   * The cached value of the '{@link #getPrototypeBinding() <em>Prototype Binding</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrototypeBinding()
   * @generated
   * @ordered
   */
  protected PrototypeBinding prototypeBinding;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataAccessPrototypeHolderImpl()
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
    return AadlBaPackage.Literals.DATA_ACCESS_PROTOTYPE_HOLDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PrototypeBinding getPrototypeBinding()
  {
    if (prototypeBinding != null && ((EObject)prototypeBinding).eIsProxy())
    {
      InternalEObject oldPrototypeBinding = (InternalEObject)prototypeBinding;
      prototypeBinding = (PrototypeBinding)eResolveProxy(oldPrototypeBinding);
      if (prototypeBinding != oldPrototypeBinding)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING, oldPrototypeBinding, prototypeBinding));
      }
    }
    return prototypeBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrototypeBinding basicGetPrototypeBinding()
  {
    return prototypeBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrototypeBinding(PrototypeBinding newPrototypeBinding)
  {
    PrototypeBinding oldPrototypeBinding = prototypeBinding;
    prototypeBinding = newPrototypeBinding;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING, oldPrototypeBinding, prototypeBinding));
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
      arrayIndexes = new EObjectContainmentEList.Unsettable<IntegerValue>(IntegerValue.class, this, AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES);
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
  public EList<GroupHolder> getGroupHolders()
  {
    if (groupHolders == null)
    {
      groupHolders = new EObjectContainmentEList.Unsettable<GroupHolder>(GroupHolder.class, this, AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS);
    }
    return groupHolders;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetGroupHolders()
  {
    if (groupHolders != null) ((InternalEList.Unsettable<?>)groupHolders).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetGroupHolders()
  {
    return groupHolders != null && ((InternalEList.Unsettable<?>)groupHolders).isSet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrototype(final Prototype prototype )
  {
    element = prototype ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Prototype getPrototype()
  {
    return (Prototype) element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setClassifierFeature(final ClassifierFeature classifierFeature)
  {
    element = classifierFeature ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClassifierFeature getClassifierFeature()
  {
    return (ClassifierFeature) element;
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
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES:
        return ((InternalEList<?>)getArrayIndexes()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS:
        return ((InternalEList<?>)getGroupHolders()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES:
        return getArrayIndexes();
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS:
        return getGroupHolders();
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING:
        if (resolve) return getPrototypeBinding();
        return basicGetPrototypeBinding();
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
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES:
        getArrayIndexes().clear();
        getArrayIndexes().addAll((Collection<? extends IntegerValue>)newValue);
        return;
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS:
        getGroupHolders().clear();
        getGroupHolders().addAll((Collection<? extends GroupHolder>)newValue);
        return;
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING:
        setPrototypeBinding((PrototypeBinding)newValue);
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
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES:
        unsetArrayIndexes();
        return;
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS:
        unsetGroupHolders();
        return;
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING:
        setPrototypeBinding((PrototypeBinding)null);
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
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES:
        return isSetArrayIndexes();
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS:
        return isSetGroupHolders();
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING:
        return prototypeBinding != null;
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
        case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES: return AadlBaPackage.INDEXABLE_ELEMENT__ARRAY_INDEXES;
        default: return -1;
      }
    }
    if (baseClass == GroupableElement.class)
    {
      switch (derivedFeatureID)
      {
        case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS: return AadlBaPackage.GROUPABLE_ELEMENT__GROUP_HOLDERS;
        default: return -1;
      }
    }
    if (baseClass == ClassifierFeatureHolder.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == PrototypeHolder.class)
    {
      switch (derivedFeatureID)
      {
        case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING: return AadlBaPackage.PROTOTYPE_HOLDER__PROTOTYPE_BINDING;
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
        case AadlBaPackage.INDEXABLE_ELEMENT__ARRAY_INDEXES: return AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES;
        default: return -1;
      }
    }
    if (baseClass == GroupableElement.class)
    {
      switch (baseFeatureID)
      {
        case AadlBaPackage.GROUPABLE_ELEMENT__GROUP_HOLDERS: return AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS;
        default: return -1;
      }
    }
    if (baseClass == ClassifierFeatureHolder.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == PrototypeHolder.class)
    {
      switch (baseFeatureID)
      {
        case AadlBaPackage.PROTOTYPE_HOLDER__PROTOTYPE_BINDING: return AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING;
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

} //DataAccessPrototypeHolderImpl
