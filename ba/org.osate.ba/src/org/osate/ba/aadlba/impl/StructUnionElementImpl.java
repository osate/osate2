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


import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.aadl2.DataClassifier ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.StructUnionElement ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Union Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.StructUnionElementImpl#getDataClassifier <em>Data Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructUnionElementImpl extends BehaviorNamedElementImpl implements StructUnionElement
{
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructUnionElementImpl()
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
    return AadlBaPackage.Literals.STRUCT_UNION_ELEMENT;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.STRUCT_UNION_ELEMENT__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.STRUCT_UNION_ELEMENT__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT__DATA_CLASSIFIER:
        if (resolve) return getDataClassifier();
        return basicGetDataClassifier();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AadlBaPackage.STRUCT_UNION_ELEMENT__DATA_CLASSIFIER:
        setDataClassifier((DataClassifier)newValue);
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT__DATA_CLASSIFIER:
        setDataClassifier((DataClassifier)null);
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
      case AadlBaPackage.STRUCT_UNION_ELEMENT__DATA_CLASSIFIER:
        return dataClassifier != null;
    }
    return super.eIsSet(featureID);
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }
} //StructUnionElementImpl
