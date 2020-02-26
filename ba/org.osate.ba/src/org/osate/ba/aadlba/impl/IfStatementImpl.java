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
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.IfStatementImpl#getBehaviorActions <em>Behavior Actions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.IfStatementImpl#getLogicalValueExpression <em>Logical Value Expression</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.IfStatementImpl#isElif <em>Elif</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.IfStatementImpl#getElseStatement <em>Else Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends BehaviorElementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getBehaviorActions() <em>Behavior Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorActions()
   * @generated
   * @ordered
   */
  protected BehaviorActions behaviorActions;

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
   * The default value of the '{@link #isElif() <em>Elif</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isElif()
   * @generated
   * @ordered
   */
  protected static final boolean ELIF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isElif() <em>Elif</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isElif()
   * @generated
   * @ordered
   */
  protected boolean elif = ELIF_EDEFAULT;

  /**
   * The cached value of the '{@link #getElseStatement() <em>Else Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseStatement()
   * @generated
   * @ordered
   */
  protected ElseStatement elseStatement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return AadlBaPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActions getBehaviorActions()
  {
    return behaviorActions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviorActions(BehaviorActions newBehaviorActions, NotificationChain msgs)
  {
    BehaviorActions oldBehaviorActions = behaviorActions;
    behaviorActions = newBehaviorActions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS, oldBehaviorActions, newBehaviorActions);
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
  public void setBehaviorActions(BehaviorActions newBehaviorActions)
  {
    if (newBehaviorActions != behaviorActions)
    {
      NotificationChain msgs = null;
      if (behaviorActions != null)
        msgs = ((InternalEObject)behaviorActions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS, null, msgs);
      if (newBehaviorActions != null)
        msgs = ((InternalEObject)newBehaviorActions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS, null, msgs);
      msgs = basicSetBehaviorActions(newBehaviorActions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS, newBehaviorActions, newBehaviorActions));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION, oldLogicalValueExpression, newLogicalValueExpression);
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
        msgs = ((InternalEObject)logicalValueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION, null, msgs);
      if (newLogicalValueExpression != null)
        msgs = ((InternalEObject)newLogicalValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION, null, msgs);
      msgs = basicSetLogicalValueExpression(newLogicalValueExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION, newLogicalValueExpression, newLogicalValueExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isElif()
  {
    return elif;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setElif(boolean newElif)
  {
    boolean oldElif = elif;
    elif = newElif;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__ELIF, oldElif, elif));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElseStatement getElseStatement()
  {
    return elseStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseStatement(ElseStatement newElseStatement, NotificationChain msgs)
  {
    ElseStatement oldElseStatement = elseStatement;
    elseStatement = newElseStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT, oldElseStatement, newElseStatement);
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
  public void setElseStatement(ElseStatement newElseStatement)
  {
    if (newElseStatement != elseStatement)
    {
      NotificationChain msgs = null;
      if (elseStatement != null)
        msgs = ((InternalEObject)elseStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT, null, msgs);
      if (newElseStatement != null)
        msgs = ((InternalEObject)newElseStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT, null, msgs);
      msgs = basicSetElseStatement(newElseStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT, newElseStatement, newElseStatement));
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
      case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS:
        return basicSetBehaviorActions(null, msgs);
      case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        return basicSetLogicalValueExpression(null, msgs);
      case AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT:
        return basicSetElseStatement(null, msgs);
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
      case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS:
        return getBehaviorActions();
      case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        return getLogicalValueExpression();
      case AadlBaPackage.IF_STATEMENT__ELIF:
        return isElif();
      case AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT:
        return getElseStatement();
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
      case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS:
        setBehaviorActions((BehaviorActions)newValue);
        return;
      case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        setLogicalValueExpression((ValueExpression)newValue);
        return;
      case AadlBaPackage.IF_STATEMENT__ELIF:
        setElif((Boolean)newValue);
        return;
      case AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT:
        setElseStatement((ElseStatement)newValue);
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
      case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS:
        setBehaviorActions((BehaviorActions)null);
        return;
      case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        setLogicalValueExpression((ValueExpression)null);
        return;
      case AadlBaPackage.IF_STATEMENT__ELIF:
        setElif(ELIF_EDEFAULT);
        return;
      case AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT:
        setElseStatement((ElseStatement)null);
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
      case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS:
        return behaviorActions != null;
      case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSION:
        return logicalValueExpression != null;
      case AadlBaPackage.IF_STATEMENT__ELIF:
        return elif != ELIF_EDEFAULT;
      case AadlBaPackage.IF_STATEMENT__ELSE_STATEMENT:
        return elseStatement != null;
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
    result.append(" (elif: ");
    result.append(elif);
    result.append(')');
    return result.toString();
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //IfStatementImpl
