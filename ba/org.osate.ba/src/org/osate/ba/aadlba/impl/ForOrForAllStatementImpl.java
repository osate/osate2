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
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.ForOrForAllStatement ;
import org.osate.ba.aadlba.IterativeVariable ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Or For All Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.ForOrForAllStatementImpl#getIteratedValues <em>Iterated Values</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.ForOrForAllStatementImpl#isForAll <em>For All</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.ForOrForAllStatementImpl#getIterativeVariable <em>Iterative Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForOrForAllStatementImpl extends LoopStatementImpl implements ForOrForAllStatement
{
  /**
   * The cached value of the '{@link #getIteratedValues() <em>Iterated Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIteratedValues()
   * @generated
   * @ordered
   */
  protected ElementValues iteratedValues;

  /**
   * The default value of the '{@link #isForAll() <em>For All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForAll()
   * @generated
   * @ordered
   */
  protected static final boolean FOR_ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isForAll() <em>For All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isForAll()
   * @generated
   * @ordered
   */
  protected boolean forAll = FOR_ALL_EDEFAULT;

  /**
   * The cached value of the '{@link #getIterativeVariable() <em>Iterative Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIterativeVariable()
   * @generated
   * @ordered
   */
  protected IterativeVariable iterativeVariable;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForOrForAllStatementImpl()
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
    return AadlBaPackage.Literals.FOR_OR_FOR_ALL_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElementValues getIteratedValues()
  {
    return iteratedValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIteratedValues(ElementValues newIteratedValues, NotificationChain msgs)
  {
    ElementValues oldIteratedValues = iteratedValues;
    iteratedValues = newIteratedValues;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES, oldIteratedValues, newIteratedValues);
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
  public void setIteratedValues(ElementValues newIteratedValues)
  {
    if (newIteratedValues != iteratedValues)
    {
      NotificationChain msgs = null;
      if (iteratedValues != null)
        msgs = ((InternalEObject)iteratedValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES, null, msgs);
      if (newIteratedValues != null)
        msgs = ((InternalEObject)newIteratedValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES, null, msgs);
      msgs = basicSetIteratedValues(newIteratedValues, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES, newIteratedValues, newIteratedValues));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isForAll()
  {
    return forAll;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setForAll(boolean newForAll)
  {
    boolean oldForAll = forAll;
    forAll = newForAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL, oldForAll, forAll));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IterativeVariable getIterativeVariable()
  {
    return iterativeVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIterativeVariable(IterativeVariable newIterativeVariable, NotificationChain msgs)
  {
    IterativeVariable oldIterativeVariable = iterativeVariable;
    iterativeVariable = newIterativeVariable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE, oldIterativeVariable, newIterativeVariable);
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
  public void setIterativeVariable(IterativeVariable newIterativeVariable)
  {
    if (newIterativeVariable != iterativeVariable)
    {
      NotificationChain msgs = null;
      if (iterativeVariable != null)
        msgs = ((InternalEObject)iterativeVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE, null, msgs);
      if (newIterativeVariable != null)
        msgs = ((InternalEObject)newIterativeVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE, null, msgs);
      msgs = basicSetIterativeVariable(newIterativeVariable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE, newIterativeVariable, newIterativeVariable));
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
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES:
        return basicSetIteratedValues(null, msgs);
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE:
        return basicSetIterativeVariable(null, msgs);
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
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES:
        return getIteratedValues();
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
        return isForAll();
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE:
        return getIterativeVariable();
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
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES:
        setIteratedValues((ElementValues)newValue);
        return;
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
        setForAll((Boolean)newValue);
        return;
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE:
        setIterativeVariable((IterativeVariable)newValue);
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
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES:
        setIteratedValues((ElementValues)null);
        return;
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
        setForAll(FOR_ALL_EDEFAULT);
        return;
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE:
        setIterativeVariable((IterativeVariable)null);
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
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES:
        return iteratedValues != null;
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
        return forAll != FOR_ALL_EDEFAULT;
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE:
        return iterativeVariable != null;
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
    result.append(" (forAll: ");
    result.append(forAll);
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //ForOrForAllStatementImpl
