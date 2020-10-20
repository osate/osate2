/**
 * *
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *  *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *  *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *  *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *  *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.expr.expr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.AbstractNamedValue;

import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.Expression;
import org.osate.expr.expr.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.impl.PropertyExpressionImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.expr.expr.impl.PropertyExpressionImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyExpressionImpl extends ExpressionImpl implements PropertyExpression
{
  /**
   * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelElement()
   * @generated
   * @ordered
   */
  protected Expression modelElement;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected AbstractNamedValue property;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyExpressionImpl()
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
    return ExprPackage.Literals.PROPERTY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getModelElement()
  {
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelElement(Expression newModelElement, NotificationChain msgs)
  {
    Expression oldModelElement = modelElement;
    modelElement = newModelElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT, oldModelElement, newModelElement);
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
  public void setModelElement(Expression newModelElement)
  {
    if (newModelElement != modelElement)
    {
      NotificationChain msgs = null;
      if (modelElement != null)
        msgs = ((InternalEObject)modelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT, null, msgs);
      if (newModelElement != null)
        msgs = ((InternalEObject)newModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT, null, msgs);
      msgs = basicSetModelElement(newModelElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT, newModelElement, newModelElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractNamedValue getProperty()
  {
    if (property != null && ((EObject)property).eIsProxy())
    {
      InternalEObject oldProperty = (InternalEObject)property;
      property = (AbstractNamedValue)eResolveProxy(oldProperty);
      if (property != oldProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExprPackage.PROPERTY_EXPRESSION__PROPERTY, oldProperty, property));
      }
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractNamedValue basicGetProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(AbstractNamedValue newProperty)
  {
    AbstractNamedValue oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.PROPERTY_EXPRESSION__PROPERTY, oldProperty, property));
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
      case ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT:
        return basicSetModelElement(null, msgs);
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
      case ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT:
        return getModelElement();
      case ExprPackage.PROPERTY_EXPRESSION__PROPERTY:
        if (resolve) return getProperty();
        return basicGetProperty();
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
      case ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT:
        setModelElement((Expression)newValue);
        return;
      case ExprPackage.PROPERTY_EXPRESSION__PROPERTY:
        setProperty((AbstractNamedValue)newValue);
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
      case ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT:
        setModelElement((Expression)null);
        return;
      case ExprPackage.PROPERTY_EXPRESSION__PROPERTY:
        setProperty((AbstractNamedValue)null);
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
      case ExprPackage.PROPERTY_EXPRESSION__MODEL_ELEMENT:
        return modelElement != null;
      case ExprPackage.PROPERTY_EXPRESSION__PROPERTY:
        return property != null;
    }
    return super.eIsSet(featureID);
  }

} //PropertyExpressionImpl
