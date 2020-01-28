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
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.aadlba.WhileOrDoUntilStatement ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Or Do Until Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.WhileOrDoUntilStatementImpl#getLogicalValueExpression <em>Logical Value Expression</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.WhileOrDoUntilStatementImpl#isDoUntil <em>Do Until</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhileOrDoUntilStatementImpl extends LoopStatementImpl implements WhileOrDoUntilStatement
{
  /**
   * The cached value of the '{@link #getLogicalValueExpression() <em>Logical Value Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicalValueExpression()
   * @generated
   * @ordered
   */
  protected ValueExpression logicalValueExpression;

  /**
   * The default value of the '{@link #isDoUntil() <em>Do Until</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDoUntil()
   * @generated
   * @ordered
   */
  protected static final boolean DO_UNTIL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDoUntil() <em>Do Until</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDoUntil()
   * @generated
   * @ordered
   */
  protected boolean doUntil = DO_UNTIL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WhileOrDoUntilStatementImpl()
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
    return AadlBaPackage.Literals.WHILE_OR_DO_UNTIL_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueExpression getLogicalValueExpression()
  {
    return logicalValueExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLogicalValueExpression(ValueExpression newLogicalValueExpression, NotificationChain msgs)
  {
    ValueExpression oldLogicalValueExpression = logicalValueExpression;
    logicalValueExpression = newLogicalValueExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, oldLogicalValueExpression, newLogicalValueExpression);
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
  public void setLogicalValueExpression(ValueExpression newLogicalValueExpression)
  {
    if (newLogicalValueExpression != logicalValueExpression)
    {
      NotificationChain msgs = null;
      if (logicalValueExpression != null)
        msgs = ((InternalEObject)logicalValueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, null, msgs);
      if (newLogicalValueExpression != null)
        msgs = ((InternalEObject)newLogicalValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, null, msgs);
      msgs = basicSetLogicalValueExpression(newLogicalValueExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION, newLogicalValueExpression, newLogicalValueExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDoUntil()
  {
    return doUntil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDoUntil(boolean newDoUntil)
  {
    boolean oldDoUntil = doUntil;
    doUntil = newDoUntil;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL, oldDoUntil, doUntil));
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
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        return basicSetLogicalValueExpression(null, msgs);
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
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        return getLogicalValueExpression();
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
        return isDoUntil();
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
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        setLogicalValueExpression((ValueExpression)newValue);
        return;
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
        setDoUntil((Boolean)newValue);
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
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        setLogicalValueExpression((ValueExpression)null);
        return;
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
        setDoUntil(DO_UNTIL_EDEFAULT);
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
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        return logicalValueExpression != null;
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL:
        return doUntil != DO_UNTIL_EDEFAULT;
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
    result.append(" (doUntil: ");
    result.append(doUntil);
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }
} //WhileOrDoUntilStatementImpl
