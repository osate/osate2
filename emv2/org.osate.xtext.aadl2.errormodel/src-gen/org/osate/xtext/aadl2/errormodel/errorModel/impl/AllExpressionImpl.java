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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.AllExpressionImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.AllExpressionImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllExpressionImpl extends ConditionExpressionImpl implements AllExpression
{
  /**
   * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCount()
   * @generated
   * @ordered
   */
  protected static final long COUNT_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCount()
   * @generated
   * @ordered
   */
  protected long count = COUNT_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperands()
   * @generated
   * @ordered
   */
  protected EList<ConditionElement> operands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AllExpressionImpl()
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
    return ErrorModelPackage.Literals.ALL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getCount()
  {
    return count;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCount(long newCount)
  {
    long oldCount = count;
    count = newCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ALL_EXPRESSION__COUNT, oldCount, count));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConditionElement> getOperands()
  {
    if (operands == null)
    {
      operands = new EObjectContainmentEList<ConditionElement>(ConditionElement.class, this, ErrorModelPackage.ALL_EXPRESSION__OPERANDS);
    }
    return operands;
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
      case ErrorModelPackage.ALL_EXPRESSION__OPERANDS:
        return ((InternalEList<?>)getOperands()).basicRemove(otherEnd, msgs);
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
      case ErrorModelPackage.ALL_EXPRESSION__COUNT:
        return getCount();
      case ErrorModelPackage.ALL_EXPRESSION__OPERANDS:
        return getOperands();
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
      case ErrorModelPackage.ALL_EXPRESSION__COUNT:
        setCount((Long)newValue);
        return;
      case ErrorModelPackage.ALL_EXPRESSION__OPERANDS:
        getOperands().clear();
        getOperands().addAll((Collection<? extends ConditionElement>)newValue);
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
      case ErrorModelPackage.ALL_EXPRESSION__COUNT:
        setCount(COUNT_EDEFAULT);
        return;
      case ErrorModelPackage.ALL_EXPRESSION__OPERANDS:
        getOperands().clear();
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
      case ErrorModelPackage.ALL_EXPRESSION__COUNT:
        return count != COUNT_EDEFAULT;
      case ErrorModelPackage.ALL_EXPRESSION__OPERANDS:
        return operands != null && !operands.isEmpty();
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
    result.append(" (count: ");
    result.append(count);
    result.append(')');
    return result.toString();
  }

} //AllExpressionImpl
