/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Transformation Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTransformationSetImpl#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTransformationSetImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeTransformationSetImpl extends NamedElementImpl implements TypeTransformationSet
{
  /**
   * The cached value of the '{@link #getUseTypes() <em>Use Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseTypes()
   * @generated
   * @ordered
   */
  protected EList<ErrorModelLibrary> useTypes;

  /**
   * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformation()
   * @generated
   * @ordered
   */
  protected EList<TypeTransformation> transformation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeTransformationSetImpl()
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
    return ErrorModelPackage.Literals.TYPE_TRANSFORMATION_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorModelLibrary> getUseTypes()
  {
    if (useTypes == null)
    {
      useTypes = new EObjectResolvingEList<ErrorModelLibrary>(ErrorModelLibrary.class, this, ErrorModelPackage.TYPE_TRANSFORMATION_SET__USE_TYPES);
    }
    return useTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeTransformation> getTransformation()
  {
    if (transformation == null)
    {
      transformation = new EObjectContainmentEList<TypeTransformation>(TypeTransformation.class, this, ErrorModelPackage.TYPE_TRANSFORMATION_SET__TRANSFORMATION);
    }
    return transformation;
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
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__TRANSFORMATION:
        return ((InternalEList<?>)getTransformation()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__USE_TYPES:
        return getUseTypes();
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__TRANSFORMATION:
        return getTransformation();
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
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__USE_TYPES:
        getUseTypes().clear();
        getUseTypes().addAll((Collection<? extends ErrorModelLibrary>)newValue);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__TRANSFORMATION:
        getTransformation().clear();
        getTransformation().addAll((Collection<? extends TypeTransformation>)newValue);
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
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__USE_TYPES:
        getUseTypes().clear();
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__TRANSFORMATION:
        getTransformation().clear();
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
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__USE_TYPES:
        return useTypes != null && !useTypes.isEmpty();
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET__TRANSFORMATION:
        return transformation != null && !transformation.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TypeTransformationSetImpl
