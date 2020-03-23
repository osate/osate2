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
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.RelationImpl#getFirstExpression <em>First Expression</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.RelationImpl#getSecondExpression <em>Second Expression</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.RelationImpl#getRelationalOperator <em>Relational Operator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends BehaviorElementImpl implements Relation
{
  /**
   * The cached value of the '{@link #getFirstExpression() <em>First Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstExpression()
   * @generated
   * @ordered
   */
  protected SimpleExpression firstExpression;

  /**
   * The cached value of the '{@link #getSecondExpression() <em>Second Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondExpression()
   * @generated
   * @ordered
   */
  protected SimpleExpression secondExpression;

  /**
   * The default value of the '{@link #getRelationalOperator() <em>Relational Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationalOperator()
   * @generated
   * @ordered
   */
  protected static final RelationalOperator RELATIONAL_OPERATOR_EDEFAULT = RelationalOperator.NONE;

  /**
   * The cached value of the '{@link #getRelationalOperator() <em>Relational Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationalOperator()
   * @generated
   * @ordered
   */
  protected RelationalOperator relationalOperator = RELATIONAL_OPERATOR_EDEFAULT;

  /**
   * This is true if the Relational Operator attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean relationalOperatorESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationImpl()
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
    return AadlBaPackage.Literals.RELATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SimpleExpression getFirstExpression()
  {
    return firstExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirstExpression(SimpleExpression newFirstExpression, NotificationChain msgs)
  {
    SimpleExpression oldFirstExpression = firstExpression;
    firstExpression = newFirstExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__FIRST_EXPRESSION, oldFirstExpression, newFirstExpression);
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
  public void setFirstExpression(SimpleExpression newFirstExpression)
  {
    if (newFirstExpression != firstExpression)
    {
      NotificationChain msgs = null;
      if (firstExpression != null)
        msgs = ((InternalEObject)firstExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__FIRST_EXPRESSION, null, msgs);
      if (newFirstExpression != null)
        msgs = ((InternalEObject)newFirstExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__FIRST_EXPRESSION, null, msgs);
      msgs = basicSetFirstExpression(newFirstExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__FIRST_EXPRESSION, newFirstExpression, newFirstExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SimpleExpression getSecondExpression()
  {
    return secondExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecondExpression(SimpleExpression newSecondExpression, NotificationChain msgs)
  {
    SimpleExpression oldSecondExpression = secondExpression;
    secondExpression = newSecondExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__SECOND_EXPRESSION, oldSecondExpression, newSecondExpression);
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
  public void setSecondExpression(SimpleExpression newSecondExpression)
  {
    if (newSecondExpression != secondExpression)
    {
      NotificationChain msgs = null;
      if (secondExpression != null)
        msgs = ((InternalEObject)secondExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__SECOND_EXPRESSION, null, msgs);
      if (newSecondExpression != null)
        msgs = ((InternalEObject)newSecondExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__SECOND_EXPRESSION, null, msgs);
      msgs = basicSetSecondExpression(newSecondExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__SECOND_EXPRESSION, newSecondExpression, newSecondExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RelationalOperator getRelationalOperator()
  {
    return relationalOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRelationalOperator(RelationalOperator newRelationalOperator)
  {
    RelationalOperator oldRelationalOperator = relationalOperator;
    relationalOperator = newRelationalOperator == null ? RELATIONAL_OPERATOR_EDEFAULT : newRelationalOperator;
    boolean oldRelationalOperatorESet = relationalOperatorESet;
    relationalOperatorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__RELATIONAL_OPERATOR, oldRelationalOperator, relationalOperator, !oldRelationalOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void unsetRelationalOperator()
  {
    RelationalOperator oldRelationalOperator = relationalOperator;
    boolean oldRelationalOperatorESet = relationalOperatorESet;
    relationalOperator = RELATIONAL_OPERATOR_EDEFAULT;
    relationalOperatorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.RELATION__RELATIONAL_OPERATOR, oldRelationalOperator, RELATIONAL_OPERATOR_EDEFAULT, oldRelationalOperatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSetRelationalOperator()
  {
    return relationalOperatorESet;
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
      case AadlBaPackage.RELATION__FIRST_EXPRESSION:
        return basicSetFirstExpression(null, msgs);
      case AadlBaPackage.RELATION__SECOND_EXPRESSION:
        return basicSetSecondExpression(null, msgs);
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
      case AadlBaPackage.RELATION__FIRST_EXPRESSION:
        return getFirstExpression();
      case AadlBaPackage.RELATION__SECOND_EXPRESSION:
        return getSecondExpression();
      case AadlBaPackage.RELATION__RELATIONAL_OPERATOR:
        return getRelationalOperator();
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
      case AadlBaPackage.RELATION__FIRST_EXPRESSION:
        setFirstExpression((SimpleExpression)newValue);
        return;
      case AadlBaPackage.RELATION__SECOND_EXPRESSION:
        setSecondExpression((SimpleExpression)newValue);
        return;
      case AadlBaPackage.RELATION__RELATIONAL_OPERATOR:
        setRelationalOperator((RelationalOperator)newValue);
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
      case AadlBaPackage.RELATION__FIRST_EXPRESSION:
        setFirstExpression((SimpleExpression)null);
        return;
      case AadlBaPackage.RELATION__SECOND_EXPRESSION:
        setSecondExpression((SimpleExpression)null);
        return;
      case AadlBaPackage.RELATION__RELATIONAL_OPERATOR:
        unsetRelationalOperator();
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
      case AadlBaPackage.RELATION__FIRST_EXPRESSION:
        return firstExpression != null;
      case AadlBaPackage.RELATION__SECOND_EXPRESSION:
        return secondExpression != null;
      case AadlBaPackage.RELATION__RELATIONAL_OPERATOR:
        return isSetRelationalOperator();
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
    result.append(" (relationalOperator: ");
    if (relationalOperatorESet) result.append(relationalOperator); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //RelationImpl
