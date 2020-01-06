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
package org.osate.verify.verify.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

import org.osate.categories.categories.Category;

import org.osate.verify.verify.ComputeRef;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getActuals <em>Actuals</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.VerificationActivityImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerificationActivityImpl extends MinimalEObjectImpl.Container implements VerificationActivity
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getComputes() <em>Computes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComputes()
   * @generated
   * @ordered
   */
  protected EList<ComputeRef> computes;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected VerificationMethod method;

  /**
   * The cached value of the '{@link #getActuals() <em>Actuals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActuals()
   * @generated
   * @ordered
   */
  protected EList<PropertyExpression> actuals;

  /**
   * The cached value of the '{@link #getPropertyValues() <em>Property Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyValues()
   * @generated
   * @ordered
   */
  protected EList<PropertyExpression> propertyValues;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected EList<Category> category;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected IntegerLiteral timeout;

  /**
   * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected static final int WEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected int weight = WEIGHT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationActivityImpl()
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
    return VerifyPackage.Literals.VERIFICATION_ACTIVITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ComputeRef> getComputes()
  {
    if (computes == null)
    {
      computes = new EObjectContainmentEList<ComputeRef>(ComputeRef.class, this, VerifyPackage.VERIFICATION_ACTIVITY__COMPUTES);
    }
    return computes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VerificationMethod getMethod()
  {
    if (method != null && method.eIsProxy())
    {
      InternalEObject oldMethod = (InternalEObject)method;
      method = (VerificationMethod)eResolveProxy(oldMethod);
      if (method != oldMethod)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.VERIFICATION_ACTIVITY__METHOD, oldMethod, method));
      }
    }
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationMethod basicGetMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMethod(VerificationMethod newMethod)
  {
    VerificationMethod oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PropertyExpression> getActuals()
  {
    if (actuals == null)
    {
      actuals = new EObjectContainmentEList<PropertyExpression>(PropertyExpression.class, this, VerifyPackage.VERIFICATION_ACTIVITY__ACTUALS);
    }
    return actuals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PropertyExpression> getPropertyValues()
  {
    if (propertyValues == null)
    {
      propertyValues = new EObjectContainmentEList<PropertyExpression>(PropertyExpression.class, this, VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES);
    }
    return propertyValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Category> getCategory()
  {
    if (category == null)
    {
      category = new EObjectResolvingEList<Category>(Category.class, this, VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY);
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegerLiteral getTimeout()
  {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTimeout(IntegerLiteral newTimeout, NotificationChain msgs)
  {
    IntegerLiteral oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT, oldTimeout, newTimeout);
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
  public void setTimeout(IntegerLiteral newTimeout)
  {
    if (newTimeout != timeout)
    {
      NotificationChain msgs = null;
      if (timeout != null)
        msgs = ((InternalEObject)timeout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT, null, msgs);
      if (newTimeout != null)
        msgs = ((InternalEObject)newTimeout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT, null, msgs);
      msgs = basicSetTimeout(newTimeout, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT, newTimeout, newTimeout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getWeight()
  {
    return weight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWeight(int newWeight)
  {
    int oldWeight = weight;
    weight = newWeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.VERIFICATION_ACTIVITY__WEIGHT, oldWeight, weight));
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
      case VerifyPackage.VERIFICATION_ACTIVITY__COMPUTES:
        return ((InternalEList<?>)getComputes()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_ACTIVITY__ACTUALS:
        return ((InternalEList<?>)getActuals()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        return ((InternalEList<?>)getPropertyValues()).basicRemove(otherEnd, msgs);
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return basicSetTimeout(null, msgs);
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        return getName();
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        return getTitle();
      case VerifyPackage.VERIFICATION_ACTIVITY__COMPUTES:
        return getComputes();
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        if (resolve) return getMethod();
        return basicGetMethod();
      case VerifyPackage.VERIFICATION_ACTIVITY__ACTUALS:
        return getActuals();
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        return getPropertyValues();
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        return getCategory();
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return getTimeout();
      case VerifyPackage.VERIFICATION_ACTIVITY__WEIGHT:
        return getWeight();
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        setName((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        setTitle((String)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__COMPUTES:
        getComputes().clear();
        getComputes().addAll((Collection<? extends ComputeRef>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        setMethod((VerificationMethod)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__ACTUALS:
        getActuals().clear();
        getActuals().addAll((Collection<? extends PropertyExpression>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        getPropertyValues().clear();
        getPropertyValues().addAll((Collection<? extends PropertyExpression>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        getCategory().clear();
        getCategory().addAll((Collection<? extends Category>)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        setTimeout((IntegerLiteral)newValue);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__WEIGHT:
        setWeight((Integer)newValue);
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__COMPUTES:
        getComputes().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        setMethod((VerificationMethod)null);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__ACTUALS:
        getActuals().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        getPropertyValues().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        getCategory().clear();
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        setTimeout((IntegerLiteral)null);
        return;
      case VerifyPackage.VERIFICATION_ACTIVITY__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
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
      case VerifyPackage.VERIFICATION_ACTIVITY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VerifyPackage.VERIFICATION_ACTIVITY__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case VerifyPackage.VERIFICATION_ACTIVITY__COMPUTES:
        return computes != null && !computes.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__METHOD:
        return method != null;
      case VerifyPackage.VERIFICATION_ACTIVITY__ACTUALS:
        return actuals != null && !actuals.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__PROPERTY_VALUES:
        return propertyValues != null && !propertyValues.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__CATEGORY:
        return category != null && !category.isEmpty();
      case VerifyPackage.VERIFICATION_ACTIVITY__TIMEOUT:
        return timeout != null;
      case VerifyPackage.VERIFICATION_ACTIVITY__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", title: ");
    result.append(title);
    result.append(", weight: ");
    result.append(weight);
    result.append(')');
    return result.toString();
  }

} //VerificationActivityImpl
