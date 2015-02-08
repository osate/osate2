/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.XPredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XPredicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.XPredicateImpl#getXlambda <em>Xlambda</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XPredicateImpl extends ReqPredicateImpl implements XPredicate
{
  /**
   * The cached value of the '{@link #getXlambda() <em>Xlambda</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXlambda()
   * @generated
   * @ordered
   */
  protected XExpression xlambda;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XPredicateImpl()
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
    return ReqSpecPackage.Literals.XPREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getXlambda()
  {
    return xlambda;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXlambda(XExpression newXlambda, NotificationChain msgs)
  {
    XExpression oldXlambda = xlambda;
    xlambda = newXlambda;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.XPREDICATE__XLAMBDA, oldXlambda, newXlambda);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXlambda(XExpression newXlambda)
  {
    if (newXlambda != xlambda)
    {
      NotificationChain msgs = null;
      if (xlambda != null)
        msgs = ((InternalEObject)xlambda).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.XPREDICATE__XLAMBDA, null, msgs);
      if (newXlambda != null)
        msgs = ((InternalEObject)newXlambda).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.XPREDICATE__XLAMBDA, null, msgs);
      msgs = basicSetXlambda(newXlambda, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.XPREDICATE__XLAMBDA, newXlambda, newXlambda));
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
      case ReqSpecPackage.XPREDICATE__XLAMBDA:
        return basicSetXlambda(null, msgs);
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
      case ReqSpecPackage.XPREDICATE__XLAMBDA:
        return getXlambda();
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
      case ReqSpecPackage.XPREDICATE__XLAMBDA:
        setXlambda((XExpression)newValue);
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
      case ReqSpecPackage.XPREDICATE__XLAMBDA:
        setXlambda((XExpression)null);
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
      case ReqSpecPackage.XPREDICATE__XLAMBDA:
        return xlambda != null;
    }
    return super.eIsSet(featureID);
  }

} //XPredicateImpl
