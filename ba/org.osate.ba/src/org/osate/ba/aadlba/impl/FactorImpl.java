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
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.FactorImpl#getFirstValue <em>First Value</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.FactorImpl#getSecondValue <em>Second Value</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.FactorImpl#getBinaryNumericOperator <em>Binary Numeric Operator</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.FactorImpl#getUnaryNumericOperator <em>Unary Numeric Operator</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.FactorImpl#getUnaryBooleanOperator <em>Unary Boolean Operator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FactorImpl extends BehaviorElementImpl implements Factor
{
  /**
   * The cached value of the '{@link #getFirstValue() <em>First Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstValue()
   * @generated
   * @ordered
   */
  protected Value firstValue;

  /**
   * The cached value of the '{@link #getSecondValue() <em>Second Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondValue()
   * @generated
   * @ordered
   */
  protected Value secondValue;

  /**
   * The default value of the '{@link #getBinaryNumericOperator() <em>Binary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinaryNumericOperator()
   * @generated
   * @ordered
   */
  protected static final BinaryNumericOperator BINARY_NUMERIC_OPERATOR_EDEFAULT = BinaryNumericOperator.NONE;

  /**
   * The cached value of the '{@link #getBinaryNumericOperator() <em>Binary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinaryNumericOperator()
   * @generated
   * @ordered
   */
  protected BinaryNumericOperator binaryNumericOperator = BINARY_NUMERIC_OPERATOR_EDEFAULT;

  /**
   * This is true if the Binary Numeric Operator attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean binaryNumericOperatorESet;

  /**
   * The default value of the '{@link #getUnaryNumericOperator() <em>Unary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryNumericOperator()
   * @generated
   * @ordered
   */
  protected static final UnaryNumericOperator UNARY_NUMERIC_OPERATOR_EDEFAULT = UnaryNumericOperator.NONE;

  /**
   * The cached value of the '{@link #getUnaryNumericOperator() <em>Unary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryNumericOperator()
   * @generated
   * @ordered
   */
  protected UnaryNumericOperator unaryNumericOperator = UNARY_NUMERIC_OPERATOR_EDEFAULT;

  /**
   * This is true if the Unary Numeric Operator attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean unaryNumericOperatorESet;

  /**
   * The default value of the '{@link #getUnaryBooleanOperator() <em>Unary Boolean Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryBooleanOperator()
   * @generated
   * @ordered
   */
  protected static final UnaryBooleanOperator UNARY_BOOLEAN_OPERATOR_EDEFAULT = UnaryBooleanOperator.NONE;

  /**
   * The cached value of the '{@link #getUnaryBooleanOperator() <em>Unary Boolean Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryBooleanOperator()
   * @generated
   * @ordered
   */
  protected UnaryBooleanOperator unaryBooleanOperator = UNARY_BOOLEAN_OPERATOR_EDEFAULT;

  /**
   * This is true if the Unary Boolean Operator attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean unaryBooleanOperatorESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FactorImpl()
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
    return AadlBaPackage.Literals.FACTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Value getFirstValue()
  {
    return firstValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirstValue(Value newFirstValue, NotificationChain msgs)
  {
    Value oldFirstValue = firstValue;
    firstValue = newFirstValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__FIRST_VALUE, oldFirstValue, newFirstValue);
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
  public void setFirstValue(Value newFirstValue)
  {
    if (newFirstValue != firstValue)
    {
      NotificationChain msgs = null;
      if (firstValue != null)
        msgs = ((InternalEObject)firstValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__FIRST_VALUE, null, msgs);
      if (newFirstValue != null)
        msgs = ((InternalEObject)newFirstValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__FIRST_VALUE, null, msgs);
      msgs = basicSetFirstValue(newFirstValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__FIRST_VALUE, newFirstValue, newFirstValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Value getSecondValue()
  {
    return secondValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecondValue(Value newSecondValue, NotificationChain msgs)
  {
    Value oldSecondValue = secondValue;
    secondValue = newSecondValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__SECOND_VALUE, oldSecondValue, newSecondValue);
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
  public void setSecondValue(Value newSecondValue)
  {
    if (newSecondValue != secondValue)
    {
      NotificationChain msgs = null;
      if (secondValue != null)
        msgs = ((InternalEObject)secondValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__SECOND_VALUE, null, msgs);
      if (newSecondValue != null)
        msgs = ((InternalEObject)newSecondValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__SECOND_VALUE, null, msgs);
      msgs = basicSetSecondValue(newSecondValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__SECOND_VALUE, newSecondValue, newSecondValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BinaryNumericOperator getBinaryNumericOperator()
  {
    return binaryNumericOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBinaryNumericOperator(BinaryNumericOperator newBinaryNumericOperator)
  {
    BinaryNumericOperator oldBinaryNumericOperator = binaryNumericOperator;
    binaryNumericOperator = newBinaryNumericOperator == null ? BINARY_NUMERIC_OPERATOR_EDEFAULT : newBinaryNumericOperator;
    boolean oldBinaryNumericOperatorESet = binaryNumericOperatorESet;
    binaryNumericOperatorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR, oldBinaryNumericOperator, binaryNumericOperator, !oldBinaryNumericOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetBinaryNumericOperator()
  {
    BinaryNumericOperator oldBinaryNumericOperator = binaryNumericOperator;
    boolean oldBinaryNumericOperatorESet = binaryNumericOperatorESet;
    binaryNumericOperator = BINARY_NUMERIC_OPERATOR_EDEFAULT;
    binaryNumericOperatorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR, oldBinaryNumericOperator, BINARY_NUMERIC_OPERATOR_EDEFAULT, oldBinaryNumericOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetBinaryNumericOperator()
  {
    return binaryNumericOperatorESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryNumericOperator getUnaryNumericOperator()
  {
    return unaryNumericOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUnaryNumericOperator(UnaryNumericOperator newUnaryNumericOperator)
  {
    UnaryNumericOperator oldUnaryNumericOperator = unaryNumericOperator;
    unaryNumericOperator = newUnaryNumericOperator == null ? UNARY_NUMERIC_OPERATOR_EDEFAULT : newUnaryNumericOperator;
    boolean oldUnaryNumericOperatorESet = unaryNumericOperatorESet;
    unaryNumericOperatorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR, oldUnaryNumericOperator, unaryNumericOperator, !oldUnaryNumericOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetUnaryNumericOperator()
  {
    UnaryNumericOperator oldUnaryNumericOperator = unaryNumericOperator;
    boolean oldUnaryNumericOperatorESet = unaryNumericOperatorESet;
    unaryNumericOperator = UNARY_NUMERIC_OPERATOR_EDEFAULT;
    unaryNumericOperatorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR, oldUnaryNumericOperator, UNARY_NUMERIC_OPERATOR_EDEFAULT, oldUnaryNumericOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetUnaryNumericOperator()
  {
    return unaryNumericOperatorESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryBooleanOperator getUnaryBooleanOperator()
  {
    return unaryBooleanOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUnaryBooleanOperator(UnaryBooleanOperator newUnaryBooleanOperator)
  {
    UnaryBooleanOperator oldUnaryBooleanOperator = unaryBooleanOperator;
    unaryBooleanOperator = newUnaryBooleanOperator == null ? UNARY_BOOLEAN_OPERATOR_EDEFAULT : newUnaryBooleanOperator;
    boolean oldUnaryBooleanOperatorESet = unaryBooleanOperatorESet;
    unaryBooleanOperatorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR, oldUnaryBooleanOperator, unaryBooleanOperator, !oldUnaryBooleanOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetUnaryBooleanOperator()
  {
    UnaryBooleanOperator oldUnaryBooleanOperator = unaryBooleanOperator;
    boolean oldUnaryBooleanOperatorESet = unaryBooleanOperatorESet;
    unaryBooleanOperator = UNARY_BOOLEAN_OPERATOR_EDEFAULT;
    unaryBooleanOperatorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR, oldUnaryBooleanOperator, UNARY_BOOLEAN_OPERATOR_EDEFAULT, oldUnaryBooleanOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetUnaryBooleanOperator()
  {
    return unaryBooleanOperatorESet;
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
      case AadlBaPackage.FACTOR__FIRST_VALUE:
        return basicSetFirstValue(null, msgs);
      case AadlBaPackage.FACTOR__SECOND_VALUE:
        return basicSetSecondValue(null, msgs);
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
      case AadlBaPackage.FACTOR__FIRST_VALUE:
        return getFirstValue();
      case AadlBaPackage.FACTOR__SECOND_VALUE:
        return getSecondValue();
      case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR:
        return getBinaryNumericOperator();
      case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR:
        return getUnaryNumericOperator();
      case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR:
        return getUnaryBooleanOperator();
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
      case AadlBaPackage.FACTOR__FIRST_VALUE:
        setFirstValue((Value)newValue);
        return;
      case AadlBaPackage.FACTOR__SECOND_VALUE:
        setSecondValue((Value)newValue);
        return;
      case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR:
        setBinaryNumericOperator((BinaryNumericOperator)newValue);
        return;
      case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR:
        setUnaryNumericOperator((UnaryNumericOperator)newValue);
        return;
      case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR:
        setUnaryBooleanOperator((UnaryBooleanOperator)newValue);
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
      case AadlBaPackage.FACTOR__FIRST_VALUE:
        setFirstValue((Value)null);
        return;
      case AadlBaPackage.FACTOR__SECOND_VALUE:
        setSecondValue((Value)null);
        return;
      case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR:
        unsetBinaryNumericOperator();
        return;
      case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR:
        unsetUnaryNumericOperator();
        return;
      case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR:
        unsetUnaryBooleanOperator();
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
      case AadlBaPackage.FACTOR__FIRST_VALUE:
        return firstValue != null;
      case AadlBaPackage.FACTOR__SECOND_VALUE:
        return secondValue != null;
      case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR:
        return isSetBinaryNumericOperator();
      case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR:
        return isSetUnaryNumericOperator();
      case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR:
        return isSetUnaryBooleanOperator();
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
    result.append(" (binaryNumericOperator: ");
    if (binaryNumericOperatorESet) result.append(binaryNumericOperator); else result.append("<unset>");
    result.append(", unaryNumericOperator: ");
    if (unaryNumericOperatorESet) result.append(unaryNumericOperator); else result.append("<unset>");
    result.append(", unaryBooleanOperator: ");
    if (unaryBooleanOperatorESet) result.append(unaryBooleanOperator); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //FactorImpl
