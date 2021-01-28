/**
 * *
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.Uncertainty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uncertainty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getVolatility <em>Volatility</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.UncertaintyImpl#getImpact <em>Impact</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UncertaintyImpl extends MinimalEObjectImpl.Container implements Uncertainty
{
  /**
   * The default value of the '{@link #getVolatility() <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatility()
   * @generated
   * @ordered
   */
  protected static final int VOLATILITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getVolatility() <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVolatility()
   * @generated
   * @ordered
   */
  protected int volatility = VOLATILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getPrecedence() <em>Precedence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecedence()
   * @generated
   * @ordered
   */
  protected static final int PRECEDENCE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPrecedence() <em>Precedence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecedence()
   * @generated
   * @ordered
   */
  protected int precedence = PRECEDENCE_EDEFAULT;

  /**
   * The default value of the '{@link #getImpact() <em>Impact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpact()
   * @generated
   * @ordered
   */
  protected static final int IMPACT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getImpact() <em>Impact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpact()
   * @generated
   * @ordered
   */
  protected int impact = IMPACT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UncertaintyImpl()
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
    return CommonPackage.Literals.UNCERTAINTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getVolatility()
  {
    return volatility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVolatility(int newVolatility)
  {
    int oldVolatility = volatility;
    volatility = newVolatility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__VOLATILITY, oldVolatility, volatility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getPrecedence()
  {
    return precedence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPrecedence(int newPrecedence)
  {
    int oldPrecedence = precedence;
    precedence = newPrecedence;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__PRECEDENCE, oldPrecedence, precedence));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getImpact()
  {
    return impact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImpact(int newImpact)
  {
    int oldImpact = impact;
    impact = newImpact;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.UNCERTAINTY__IMPACT, oldImpact, impact));
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
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        return getVolatility();
      case CommonPackage.UNCERTAINTY__PRECEDENCE:
        return getPrecedence();
      case CommonPackage.UNCERTAINTY__IMPACT:
        return getImpact();
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
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        setVolatility((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__PRECEDENCE:
        setPrecedence((Integer)newValue);
        return;
      case CommonPackage.UNCERTAINTY__IMPACT:
        setImpact((Integer)newValue);
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
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        setVolatility(VOLATILITY_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__PRECEDENCE:
        setPrecedence(PRECEDENCE_EDEFAULT);
        return;
      case CommonPackage.UNCERTAINTY__IMPACT:
        setImpact(IMPACT_EDEFAULT);
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
      case CommonPackage.UNCERTAINTY__VOLATILITY:
        return volatility != VOLATILITY_EDEFAULT;
      case CommonPackage.UNCERTAINTY__PRECEDENCE:
        return precedence != PRECEDENCE_EDEFAULT;
      case CommonPackage.UNCERTAINTY__IMPACT:
        return impact != IMPACT_EDEFAULT;
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
    result.append(" (volatility: ");
    result.append(volatility);
    result.append(", precedence: ");
    result.append(precedence);
    result.append(", impact: ");
    result.append(impact);
    result.append(')');
    return result.toString();
  }

} //UncertaintyImpl
