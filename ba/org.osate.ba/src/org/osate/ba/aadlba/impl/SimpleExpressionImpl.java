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


import java.util.Collection ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.eclipse.emf.ecore.util.EDataTypeEList ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.SimpleExpressionImpl#getUnaryAddingOperator <em>Unary Adding Operator</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.SimpleExpressionImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.SimpleExpressionImpl#getBinaryAddingOperators <em>Binary Adding Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleExpressionImpl extends BehaviorElementImpl implements SimpleExpression
{
  /**
   * The default value of the '{@link #getUnaryAddingOperator() <em>Unary Adding Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryAddingOperator()
   * @generated
   * @ordered
   */
  protected static final UnaryAddingOperator UNARY_ADDING_OPERATOR_EDEFAULT = UnaryAddingOperator.NONE;

  /**
   * The cached value of the '{@link #getUnaryAddingOperator() <em>Unary Adding Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryAddingOperator()
   * @generated
   * @ordered
   */
  protected UnaryAddingOperator unaryAddingOperator = UNARY_ADDING_OPERATOR_EDEFAULT;

  /**
   * This is true if the Unary Adding Operator attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean unaryAddingOperatorESet;

  /**
   * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerms()
   * @generated
   * @ordered
   */
  protected EList<Term> terms;

  /**
   * The cached value of the '{@link #getBinaryAddingOperators() <em>Binary Adding Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBinaryAddingOperators()
   * @generated
   * @ordered
   */
  protected EList<BinaryAddingOperator> binaryAddingOperators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleExpressionImpl()
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
    return AadlBaPackage.Literals.SIMPLE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryAddingOperator getUnaryAddingOperator()
  {
    return unaryAddingOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUnaryAddingOperator(UnaryAddingOperator newUnaryAddingOperator)
  {
    UnaryAddingOperator oldUnaryAddingOperator = unaryAddingOperator;
    unaryAddingOperator = newUnaryAddingOperator == null ? UNARY_ADDING_OPERATOR_EDEFAULT : newUnaryAddingOperator;
    boolean oldUnaryAddingOperatorESet = unaryAddingOperatorESet;
    unaryAddingOperatorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR, oldUnaryAddingOperator, unaryAddingOperator, !oldUnaryAddingOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetUnaryAddingOperator()
  {
    UnaryAddingOperator oldUnaryAddingOperator = unaryAddingOperator;
    boolean oldUnaryAddingOperatorESet = unaryAddingOperatorESet;
    unaryAddingOperator = UNARY_ADDING_OPERATOR_EDEFAULT;
    unaryAddingOperatorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR, oldUnaryAddingOperator, UNARY_ADDING_OPERATOR_EDEFAULT, oldUnaryAddingOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetUnaryAddingOperator()
  {
    return unaryAddingOperatorESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Term> getTerms()
  {
    if (terms == null)
    {
      terms = new EObjectContainmentEList<Term>(Term.class, this, AadlBaPackage.SIMPLE_EXPRESSION__TERMS);
    }
    return terms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BinaryAddingOperator> getBinaryAddingOperators()
  {
    if (binaryAddingOperators == null)
    {
      binaryAddingOperators = new EDataTypeEList.Unsettable<BinaryAddingOperator>(BinaryAddingOperator.class, this, AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS);
    }
    return binaryAddingOperators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetBinaryAddingOperators()
  {
    if (binaryAddingOperators != null) ((InternalEList.Unsettable<?>)binaryAddingOperators).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetBinaryAddingOperators()
  {
    return binaryAddingOperators != null && ((InternalEList.Unsettable<?>)binaryAddingOperators).isSet();
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
      case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
        return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR:
        return getUnaryAddingOperator();
      case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
        return getTerms();
      case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
        return getBinaryAddingOperators();
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
      case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR:
        setUnaryAddingOperator((UnaryAddingOperator)newValue);
        return;
      case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
        getTerms().clear();
        getTerms().addAll((Collection<? extends Term>)newValue);
        return;
      case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
        getBinaryAddingOperators().clear();
        getBinaryAddingOperators().addAll((Collection<? extends BinaryAddingOperator>)newValue);
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
      case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR:
        unsetUnaryAddingOperator();
        return;
      case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
        getTerms().clear();
        return;
      case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
        unsetBinaryAddingOperators();
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
      case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR:
        return isSetUnaryAddingOperator();
      case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
        return terms != null && !terms.isEmpty();
      case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
        return isSetBinaryAddingOperators();
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
    result.append(" (unaryAddingOperator: ");
    if (unaryAddingOperatorESet) result.append(unaryAddingOperator); else result.append("<unset>");
    result.append(", binaryAddingOperators: ");
    result.append(binaryAddingOperators);
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //SimpleExpressionImpl
