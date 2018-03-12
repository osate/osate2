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
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.Mode;
import org.osate.aadl2.PropertyExpression;

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.WhenCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>When Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.WhenConditionImpl#getInMode <em>In Mode</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.WhenConditionImpl#getInErrorState <em>In Error State</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.WhenConditionImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhenConditionImpl extends MinimalEObjectImpl.Container implements WhenCondition
{
  /**
   * The cached value of the '{@link #getInMode() <em>In Mode</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInMode()
   * @generated
   * @ordered
   */
  protected EList<Mode> inMode;

  /**
   * The cached value of the '{@link #getInErrorState() <em>In Error State</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInErrorState()
   * @generated
   * @ordered
   */
  protected EList<EObject> inErrorState;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected PropertyExpression condition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WhenConditionImpl()
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
    return ReqSpecPackage.Literals.WHEN_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mode> getInMode()
  {
    if (inMode == null)
    {
      inMode = new EObjectResolvingEList<Mode>(Mode.class, this, ReqSpecPackage.WHEN_CONDITION__IN_MODE);
    }
    return inMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getInErrorState()
  {
    if (inErrorState == null)
    {
      inErrorState = new EObjectResolvingEList<EObject>(EObject.class, this, ReqSpecPackage.WHEN_CONDITION__IN_ERROR_STATE);
    }
    return inErrorState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(PropertyExpression newCondition, NotificationChain msgs)
  {
    PropertyExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.WHEN_CONDITION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(PropertyExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.WHEN_CONDITION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.WHEN_CONDITION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.WHEN_CONDITION__CONDITION, newCondition, newCondition));
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
      case ReqSpecPackage.WHEN_CONDITION__CONDITION:
        return basicSetCondition(null, msgs);
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
      case ReqSpecPackage.WHEN_CONDITION__IN_MODE:
        return getInMode();
      case ReqSpecPackage.WHEN_CONDITION__IN_ERROR_STATE:
        return getInErrorState();
      case ReqSpecPackage.WHEN_CONDITION__CONDITION:
        return getCondition();
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
      case ReqSpecPackage.WHEN_CONDITION__IN_MODE:
        getInMode().clear();
        getInMode().addAll((Collection<? extends Mode>)newValue);
        return;
      case ReqSpecPackage.WHEN_CONDITION__IN_ERROR_STATE:
        getInErrorState().clear();
        getInErrorState().addAll((Collection<? extends EObject>)newValue);
        return;
      case ReqSpecPackage.WHEN_CONDITION__CONDITION:
        setCondition((PropertyExpression)newValue);
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
      case ReqSpecPackage.WHEN_CONDITION__IN_MODE:
        getInMode().clear();
        return;
      case ReqSpecPackage.WHEN_CONDITION__IN_ERROR_STATE:
        getInErrorState().clear();
        return;
      case ReqSpecPackage.WHEN_CONDITION__CONDITION:
        setCondition((PropertyExpression)null);
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
      case ReqSpecPackage.WHEN_CONDITION__IN_MODE:
        return inMode != null && !inMode.isEmpty();
      case ReqSpecPackage.WHEN_CONDITION__IN_ERROR_STATE:
        return inErrorState != null && !inErrorState.isEmpty();
      case ReqSpecPackage.WHEN_CONDITION__CONDITION:
        return condition != null;
    }
    return super.eIsSet(featureID);
  }

} //WhenConditionImpl
