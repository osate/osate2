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
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;

import org.osate.aadl2.impl.PropertyExpressionImpl;

import org.osate.alisa.common.common.AUnitExpression;
import org.osate.alisa.common.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AUnit Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.AUnitExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.AUnitExpressionImpl#isConvert <em>Convert</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.AUnitExpressionImpl#isDrop <em>Drop</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.impl.AUnitExpressionImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AUnitExpressionImpl extends PropertyExpressionImpl implements AUnitExpression
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected PropertyExpression expression;

  /**
   * The default value of the '{@link #isConvert() <em>Convert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isConvert()
   * @generated
   * @ordered
   */
  protected static final boolean CONVERT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isConvert() <em>Convert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isConvert()
   * @generated
   * @ordered
   */
  protected boolean convert = CONVERT_EDEFAULT;

  /**
   * The default value of the '{@link #isDrop() <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDrop()
   * @generated
   * @ordered
   */
  protected static final boolean DROP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDrop() <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDrop()
   * @generated
   * @ordered
   */
  protected boolean drop = DROP_EDEFAULT;

  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected UnitLiteral unit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AUnitExpressionImpl()
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
    return CommonPackage.Literals.AUNIT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyExpression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(PropertyExpression newExpression, NotificationChain msgs)
  {
    PropertyExpression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.AUNIT_EXPRESSION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(PropertyExpression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.AUNIT_EXPRESSION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.AUNIT_EXPRESSION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.AUNIT_EXPRESSION__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isConvert()
  {
    return convert;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConvert(boolean newConvert)
  {
    boolean oldConvert = convert;
    convert = newConvert;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.AUNIT_EXPRESSION__CONVERT, oldConvert, convert));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDrop()
  {
    return drop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDrop(boolean newDrop)
  {
    boolean oldDrop = drop;
    drop = newDrop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.AUNIT_EXPRESSION__DROP, oldDrop, drop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitLiteral getUnit()
  {
    if (unit != null && ((EObject)unit).eIsProxy())
    {
      InternalEObject oldUnit = (InternalEObject)unit;
      unit = (UnitLiteral)eResolveProxy(oldUnit);
      if (unit != oldUnit)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonPackage.AUNIT_EXPRESSION__UNIT, oldUnit, unit));
      }
    }
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitLiteral basicGetUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(UnitLiteral newUnit)
  {
    UnitLiteral oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.AUNIT_EXPRESSION__UNIT, oldUnit, unit));
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
      case CommonPackage.AUNIT_EXPRESSION__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case CommonPackage.AUNIT_EXPRESSION__EXPRESSION:
        return getExpression();
      case CommonPackage.AUNIT_EXPRESSION__CONVERT:
        return isConvert();
      case CommonPackage.AUNIT_EXPRESSION__DROP:
        return isDrop();
      case CommonPackage.AUNIT_EXPRESSION__UNIT:
        if (resolve) return getUnit();
        return basicGetUnit();
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
      case CommonPackage.AUNIT_EXPRESSION__EXPRESSION:
        setExpression((PropertyExpression)newValue);
        return;
      case CommonPackage.AUNIT_EXPRESSION__CONVERT:
        setConvert((Boolean)newValue);
        return;
      case CommonPackage.AUNIT_EXPRESSION__DROP:
        setDrop((Boolean)newValue);
        return;
      case CommonPackage.AUNIT_EXPRESSION__UNIT:
        setUnit((UnitLiteral)newValue);
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
      case CommonPackage.AUNIT_EXPRESSION__EXPRESSION:
        setExpression((PropertyExpression)null);
        return;
      case CommonPackage.AUNIT_EXPRESSION__CONVERT:
        setConvert(CONVERT_EDEFAULT);
        return;
      case CommonPackage.AUNIT_EXPRESSION__DROP:
        setDrop(DROP_EDEFAULT);
        return;
      case CommonPackage.AUNIT_EXPRESSION__UNIT:
        setUnit((UnitLiteral)null);
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
      case CommonPackage.AUNIT_EXPRESSION__EXPRESSION:
        return expression != null;
      case CommonPackage.AUNIT_EXPRESSION__CONVERT:
        return convert != CONVERT_EDEFAULT;
      case CommonPackage.AUNIT_EXPRESSION__DROP:
        return drop != DROP_EDEFAULT;
      case CommonPackage.AUNIT_EXPRESSION__UNIT:
        return unit != null;
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
    result.append(" (convert: ");
    result.append(convert);
    result.append(", drop: ");
    result.append(drop);
    result.append(')');
    return result.toString();
  }

} //AUnitExpressionImpl
