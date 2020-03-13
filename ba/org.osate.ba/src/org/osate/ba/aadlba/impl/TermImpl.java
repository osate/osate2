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

import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.util.EDataTypeEList ;
import org.eclipse.emf.ecore.util.EObjectContainmentEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.TermImpl#getFactors <em>Factors</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.TermImpl#getMultiplyingOperators <em>Multiplying Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TermImpl extends BehaviorElementImpl implements Term
{
  /**
   * The cached value of the '{@link #getFactors() <em>Factors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactors()
   * @generated
   * @ordered
   */
  protected EList<Factor> factors;

  /**
   * The cached value of the '{@link #getMultiplyingOperators() <em>Multiplying Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplyingOperators()
   * @generated
   * @ordered
   */
  protected EList<MultiplyingOperator> multiplyingOperators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TermImpl()
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
    return AadlBaPackage.Literals.TERM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Factor> getFactors()
  {
    if (factors == null)
    {
      factors = new EObjectContainmentEList<Factor>(Factor.class, this, AadlBaPackage.TERM__FACTORS);
    }
    return factors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MultiplyingOperator> getMultiplyingOperators()
  {
    if (multiplyingOperators == null)
    {
      multiplyingOperators = new EDataTypeEList.Unsettable<MultiplyingOperator>(MultiplyingOperator.class, this, AadlBaPackage.TERM__MULTIPLYING_OPERATORS);
    }
    return multiplyingOperators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetMultiplyingOperators()
  {
    if (multiplyingOperators != null) ((InternalEList.Unsettable<?>)multiplyingOperators).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetMultiplyingOperators()
  {
    return multiplyingOperators != null && ((InternalEList.Unsettable<?>)multiplyingOperators).isSet();
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
      case AadlBaPackage.TERM__FACTORS:
        return ((InternalEList<?>)getFactors()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.TERM__FACTORS:
        return getFactors();
      case AadlBaPackage.TERM__MULTIPLYING_OPERATORS:
        return getMultiplyingOperators();
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
      case AadlBaPackage.TERM__FACTORS:
        getFactors().clear();
        getFactors().addAll((Collection<? extends Factor>)newValue);
        return;
      case AadlBaPackage.TERM__MULTIPLYING_OPERATORS:
        getMultiplyingOperators().clear();
        getMultiplyingOperators().addAll((Collection<? extends MultiplyingOperator>)newValue);
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
      case AadlBaPackage.TERM__FACTORS:
        getFactors().clear();
        return;
      case AadlBaPackage.TERM__MULTIPLYING_OPERATORS:
        unsetMultiplyingOperators();
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
      case AadlBaPackage.TERM__FACTORS:
        return factors != null && !factors.isEmpty();
      case AadlBaPackage.TERM__MULTIPLYING_OPERATORS:
        return isSetMultiplyingOperators();
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
    result.append(" (multiplyingOperators: ");
    result.append(multiplyingOperators);
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //TermImpl
