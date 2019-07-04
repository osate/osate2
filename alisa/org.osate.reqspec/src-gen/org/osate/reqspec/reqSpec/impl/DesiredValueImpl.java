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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.aadl2.PropertyExpression;

import org.osate.alisa.common.common.AExpression;

import org.osate.reqspec.reqSpec.DesiredValue;
import org.osate.reqspec.reqSpec.ReqSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Desired Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.DesiredValueImpl#getDesired <em>Desired</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.DesiredValueImpl#isUpto <em>Upto</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.DesiredValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DesiredValueImpl extends MinimalEObjectImpl.Container implements DesiredValue
{
  /**
   * The cached value of the '{@link #getDesired() <em>Desired</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesired()
   * @generated
   * @ordered
   */
  protected AExpression desired;

  /**
   * The default value of the '{@link #isUpto() <em>Upto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUpto()
   * @generated
   * @ordered
   */
  protected static final boolean UPTO_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUpto() <em>Upto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUpto()
   * @generated
   * @ordered
   */
  protected boolean upto = UPTO_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected PropertyExpression value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DesiredValueImpl()
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
    return ReqSpecPackage.Literals.DESIRED_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AExpression getDesired()
  {
    return desired;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDesired(AExpression newDesired, NotificationChain msgs)
  {
    AExpression oldDesired = desired;
    desired = newDesired;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.DESIRED_VALUE__DESIRED, oldDesired, newDesired);
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
  public void setDesired(AExpression newDesired)
  {
    if (newDesired != desired)
    {
      NotificationChain msgs = null;
      if (desired != null)
        msgs = ((InternalEObject)desired).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.DESIRED_VALUE__DESIRED, null, msgs);
      if (newDesired != null)
        msgs = ((InternalEObject)newDesired).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.DESIRED_VALUE__DESIRED, null, msgs);
      msgs = basicSetDesired(newDesired, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.DESIRED_VALUE__DESIRED, newDesired, newDesired));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isUpto()
  {
    return upto;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUpto(boolean newUpto)
  {
    boolean oldUpto = upto;
    upto = newUpto;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.DESIRED_VALUE__UPTO, oldUpto, upto));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyExpression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(PropertyExpression newValue, NotificationChain msgs)
  {
    PropertyExpression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.DESIRED_VALUE__VALUE, oldValue, newValue);
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
  public void setValue(PropertyExpression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.DESIRED_VALUE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.DESIRED_VALUE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.DESIRED_VALUE__VALUE, newValue, newValue));
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
      case ReqSpecPackage.DESIRED_VALUE__DESIRED:
        return basicSetDesired(null, msgs);
      case ReqSpecPackage.DESIRED_VALUE__VALUE:
        return basicSetValue(null, msgs);
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
      case ReqSpecPackage.DESIRED_VALUE__DESIRED:
        return getDesired();
      case ReqSpecPackage.DESIRED_VALUE__UPTO:
        return isUpto();
      case ReqSpecPackage.DESIRED_VALUE__VALUE:
        return getValue();
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
      case ReqSpecPackage.DESIRED_VALUE__DESIRED:
        setDesired((AExpression)newValue);
        return;
      case ReqSpecPackage.DESIRED_VALUE__UPTO:
        setUpto((Boolean)newValue);
        return;
      case ReqSpecPackage.DESIRED_VALUE__VALUE:
        setValue((PropertyExpression)newValue);
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
      case ReqSpecPackage.DESIRED_VALUE__DESIRED:
        setDesired((AExpression)null);
        return;
      case ReqSpecPackage.DESIRED_VALUE__UPTO:
        setUpto(UPTO_EDEFAULT);
        return;
      case ReqSpecPackage.DESIRED_VALUE__VALUE:
        setValue((PropertyExpression)null);
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
      case ReqSpecPackage.DESIRED_VALUE__DESIRED:
        return desired != null;
      case ReqSpecPackage.DESIRED_VALUE__UPTO:
        return upto != UPTO_EDEFAULT;
      case ReqSpecPackage.DESIRED_VALUE__VALUE:
        return value != null;
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
    result.append(" (upto: ");
    result.append(upto);
    result.append(')');
    return result.toString();
  }

} //DesiredValueImpl
