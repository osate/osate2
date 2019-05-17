/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.PropertyExpression;

import org.osate.reqspec.reqSpec.DesiredValue;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ValuePredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ValuePredicateImpl#getXpression <em>Xpression</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ValuePredicateImpl#getDesiredValue <em>Desired Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValuePredicateImpl extends ReqPredicateImpl implements ValuePredicate
{
  /**
   * The cached value of the '{@link #getXpression() <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXpression()
   * @generated
   * @ordered
   */
  protected PropertyExpression xpression;

  /**
   * The cached value of the '{@link #getDesiredValue() <em>Desired Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesiredValue()
   * @generated
   * @ordered
   */
  protected EList<DesiredValue> desiredValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValuePredicateImpl()
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
    return ReqSpecPackage.Literals.VALUE_PREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyExpression getXpression()
  {
    return xpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXpression(PropertyExpression newXpression, NotificationChain msgs)
  {
    PropertyExpression oldXpression = xpression;
    xpression = newXpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.VALUE_PREDICATE__XPRESSION, oldXpression, newXpression);
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
  public void setXpression(PropertyExpression newXpression)
  {
    if (newXpression != xpression)
    {
      NotificationChain msgs = null;
      if (xpression != null)
        msgs = ((InternalEObject)xpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.VALUE_PREDICATE__XPRESSION, null, msgs);
      if (newXpression != null)
        msgs = ((InternalEObject)newXpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.VALUE_PREDICATE__XPRESSION, null, msgs);
      msgs = basicSetXpression(newXpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.VALUE_PREDICATE__XPRESSION, newXpression, newXpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<DesiredValue> getDesiredValue()
  {
    if (desiredValue == null)
    {
      desiredValue = new EObjectContainmentEList<DesiredValue>(DesiredValue.class, this, ReqSpecPackage.VALUE_PREDICATE__DESIRED_VALUE);
    }
    return desiredValue;
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        return basicSetXpression(null, msgs);
      case ReqSpecPackage.VALUE_PREDICATE__DESIRED_VALUE:
        return ((InternalEList<?>)getDesiredValue()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        return getXpression();
      case ReqSpecPackage.VALUE_PREDICATE__DESIRED_VALUE:
        return getDesiredValue();
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        setXpression((PropertyExpression)newValue);
        return;
      case ReqSpecPackage.VALUE_PREDICATE__DESIRED_VALUE:
        getDesiredValue().clear();
        getDesiredValue().addAll((Collection<? extends DesiredValue>)newValue);
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        setXpression((PropertyExpression)null);
        return;
      case ReqSpecPackage.VALUE_PREDICATE__DESIRED_VALUE:
        getDesiredValue().clear();
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        return xpression != null;
      case ReqSpecPackage.VALUE_PREDICATE__DESIRED_VALUE:
        return desiredValue != null && !desiredValue.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ValuePredicateImpl
