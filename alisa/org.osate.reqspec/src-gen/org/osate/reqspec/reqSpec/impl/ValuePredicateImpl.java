/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

<<<<<<< HEAD
import org.osate.aadl2.PropertyExpression;
=======
import org.osate.alisa.common.common.AExpression;
>>>>>>> refs/remotes/origin/PeterWork

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ValuePredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ValuePredicateImpl#getXpression <em>Xpression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValuePredicateImpl extends ReqPredicateImpl implements ValuePredicate
{
  /**
   * The cached value of the '{@link #getXpression() <em>Xpression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXpression()
   * @generated
   * @ordered
   */
<<<<<<< HEAD
  protected PropertyExpression xpression;
=======
  protected AExpression xpression;
>>>>>>> refs/remotes/origin/PeterWork

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValuePredicateImpl()
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
    return ReqSpecPackage.Literals.VALUE_PREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
<<<<<<< HEAD
  public PropertyExpression getXpression()
=======
  public AExpression getXpression()
>>>>>>> refs/remotes/origin/PeterWork
  {
    return xpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
<<<<<<< HEAD
  public NotificationChain basicSetXpression(PropertyExpression newXpression, NotificationChain msgs)
=======
  public NotificationChain basicSetXpression(AExpression newXpression, NotificationChain msgs)
>>>>>>> refs/remotes/origin/PeterWork
  {
<<<<<<< HEAD
    PropertyExpression oldXpression = xpression;
=======
    AExpression oldXpression = xpression;
>>>>>>> refs/remotes/origin/PeterWork
    xpression = newXpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.VALUE_PREDICATE__XPRESSION, oldXpression, newXpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
<<<<<<< HEAD
  public void setXpression(PropertyExpression newXpression)
=======
  public void setXpression(AExpression newXpression)
>>>>>>> refs/remotes/origin/PeterWork
  {
    if (newXpression != xpression)
    {
      NotificationChain msgs = null;
      if (xpression != null)
        msgs = ((InternalEObject)xpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.VALUE_PREDICATE__XPRESSION, null, msgs);
      if (newXpression != null)
        msgs = ((InternalEObject)newXpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.VALUE_PREDICATE__XPRESSION, null, msgs);
      msgs = basicSetXpression(newXpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.VALUE_PREDICATE__XPRESSION, newXpression, newXpression));
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        return basicSetXpression(null, msgs);
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        return getXpression();
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
<<<<<<< HEAD
        setXpression((PropertyExpression)newValue);
=======
        setXpression((AExpression)newValue);
>>>>>>> refs/remotes/origin/PeterWork
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
<<<<<<< HEAD
        setXpression((PropertyExpression)null);
=======
        setXpression((AExpression)null);
>>>>>>> refs/remotes/origin/PeterWork
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
      case ReqSpecPackage.VALUE_PREDICATE__XPRESSION:
        return xpression != null;
    }
    return super.eIsSet(featureID);
  }

} //ValuePredicateImpl
