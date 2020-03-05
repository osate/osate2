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
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.AssignmentActionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.AssignmentActionImpl#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentActionImpl extends BehaviorElementImpl implements AssignmentAction
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Target target;

  /**
   * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueExpression()
   * @generated
   * @ordered
   */
  protected ValueExpression valueExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentActionImpl()
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
    return AadlBaPackage.Literals.ASSIGNMENT_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Target getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(Target newTarget, NotificationChain msgs)
  {
    Target oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__TARGET, oldTarget, newTarget);
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
  public void setTarget(Target newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueExpression getValueExpression()
  {
    return valueExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueExpression(ValueExpression newValueExpression, NotificationChain msgs)
  {
    ValueExpression oldValueExpression = valueExpression;
    valueExpression = newValueExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
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
  public void setValueExpression(ValueExpression newValueExpression)
  {
    if (newValueExpression != valueExpression)
    {
      NotificationChain msgs = null;
      if (valueExpression != null)
        msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION, null, msgs);
      if (newValueExpression != null)
        msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION, null, msgs);
      msgs = basicSetValueExpression(newValueExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION, newValueExpression, newValueExpression));
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
      case AadlBaPackage.ASSIGNMENT_ACTION__TARGET:
        return basicSetTarget(null, msgs);
      case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION:
        return basicSetValueExpression(null, msgs);
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
      case AadlBaPackage.ASSIGNMENT_ACTION__TARGET:
        return getTarget();
      case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION:
        return getValueExpression();
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
      case AadlBaPackage.ASSIGNMENT_ACTION__TARGET:
        setTarget((Target)newValue);
        return;
      case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION:
        setValueExpression((ValueExpression)newValue);
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
      case AadlBaPackage.ASSIGNMENT_ACTION__TARGET:
        setTarget((Target)null);
        return;
      case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION:
        setValueExpression((ValueExpression)null);
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
      case AadlBaPackage.ASSIGNMENT_ACTION__TARGET:
        return target != null;
      case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION:
        return valueExpression != null;
    }
    return super.eIsSet(featureID);
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }

} //AssignmentActionImpl
