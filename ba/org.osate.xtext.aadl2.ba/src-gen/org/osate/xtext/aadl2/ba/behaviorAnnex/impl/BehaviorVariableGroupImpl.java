/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentClassifier;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Variable Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl#getDataClassifier <em>Data Classifier</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl#getPropertyAssociations <em>Property Associations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorVariableGroupImpl extends MinimalEObjectImpl.Container implements BehaviorVariableGroup
{
  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<BehaviorVariable> variables;

  /**
   * The cached value of the '{@link #getDataClassifier() <em>Data Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataClassifier()
   * @generated
   * @ordered
   */
  protected ComponentClassifier dataClassifier;

  /**
   * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected ValueConstant initialValue;

  /**
   * The cached value of the '{@link #getPropertyAssociations() <em>Property Associations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyAssociations()
   * @generated
   * @ordered
   */
  protected EList<BehaviorPropertyAssociation> propertyAssociations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BehaviorVariableGroupImpl()
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
    return BehaviorAnnexPackage.Literals.BEHAVIOR_VARIABLE_GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorVariable> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<BehaviorVariable>(BehaviorVariable.class, this, BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComponentClassifier getDataClassifier()
  {
    if (dataClassifier != null && ((EObject)dataClassifier).eIsProxy())
    {
      InternalEObject oldDataClassifier = (InternalEObject)dataClassifier;
      dataClassifier = (ComponentClassifier)eResolveProxy(oldDataClassifier);
      if (dataClassifier != oldDataClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
      }
    }
    return dataClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier basicGetDataClassifier()
  {
    return dataClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDataClassifier(ComponentClassifier newDataClassifier)
  {
    ComponentClassifier oldDataClassifier = dataClassifier;
    dataClassifier = newDataClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER, oldDataClassifier, dataClassifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueConstant getInitialValue()
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialValue(ValueConstant newInitialValue, NotificationChain msgs)
  {
    ValueConstant oldInitialValue = initialValue;
    initialValue = newInitialValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE, oldInitialValue, newInitialValue);
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
  public void setInitialValue(ValueConstant newInitialValue)
  {
    if (newInitialValue != initialValue)
    {
      NotificationChain msgs = null;
      if (initialValue != null)
        msgs = ((InternalEObject)initialValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE, null, msgs);
      if (newInitialValue != null)
        msgs = ((InternalEObject)newInitialValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE, null, msgs);
      msgs = basicSetInitialValue(newInitialValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE, newInitialValue, newInitialValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorPropertyAssociation> getPropertyAssociations()
  {
    if (propertyAssociations == null)
    {
      propertyAssociations = new EObjectContainmentEList<BehaviorPropertyAssociation>(BehaviorPropertyAssociation.class, this, BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS);
    }
    return propertyAssociations;
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
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE:
        return basicSetInitialValue(null, msgs);
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS:
        return ((InternalEList<?>)getPropertyAssociations()).basicRemove(otherEnd, msgs);
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
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__VARIABLES:
        return getVariables();
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER:
        if (resolve) return getDataClassifier();
        return basicGetDataClassifier();
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE:
        return getInitialValue();
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS:
        return getPropertyAssociations();
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
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends BehaviorVariable>)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER:
        setDataClassifier((ComponentClassifier)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE:
        setInitialValue((ValueConstant)newValue);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS:
        getPropertyAssociations().clear();
        getPropertyAssociations().addAll((Collection<? extends BehaviorPropertyAssociation>)newValue);
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
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__VARIABLES:
        getVariables().clear();
        return;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER:
        setDataClassifier((ComponentClassifier)null);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE:
        setInitialValue((ValueConstant)null);
        return;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS:
        getPropertyAssociations().clear();
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
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__VARIABLES:
        return variables != null && !variables.isEmpty();
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER:
        return dataClassifier != null;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE:
        return initialValue != null;
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS:
        return propertyAssociations != null && !propertyAssociations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BehaviorVariableGroupImpl
