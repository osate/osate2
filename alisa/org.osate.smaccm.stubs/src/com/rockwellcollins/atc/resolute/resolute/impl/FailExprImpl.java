/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.ClaimText;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FailExpr;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fail Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.FailExprImpl#getVal <em>Val</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.FailExprImpl#getFailmsg <em>Failmsg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FailExprImpl extends ExprImpl implements FailExpr
{
  /**
   * The cached value of the '{@link #getVal() <em>Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected Expr val;

  /**
   * The cached value of the '{@link #getFailmsg() <em>Failmsg</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailmsg()
   * @generated
   * @ordered
   */
  protected EList<ClaimText> failmsg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FailExprImpl()
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
    return ResolutePackage.Literals.FAIL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getVal()
  {
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVal(Expr newVal, NotificationChain msgs)
  {
    Expr oldVal = val;
    val = newVal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResolutePackage.FAIL_EXPR__VAL, oldVal, newVal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal(Expr newVal)
  {
    if (newVal != val)
    {
      NotificationChain msgs = null;
      if (val != null)
        msgs = ((InternalEObject)val).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResolutePackage.FAIL_EXPR__VAL, null, msgs);
      if (newVal != null)
        msgs = ((InternalEObject)newVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResolutePackage.FAIL_EXPR__VAL, null, msgs);
      msgs = basicSetVal(newVal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResolutePackage.FAIL_EXPR__VAL, newVal, newVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClaimText> getFailmsg()
  {
    if (failmsg == null)
    {
      failmsg = new EObjectContainmentEList<ClaimText>(ClaimText.class, this, ResolutePackage.FAIL_EXPR__FAILMSG);
    }
    return failmsg;
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
      case ResolutePackage.FAIL_EXPR__VAL:
        return basicSetVal(null, msgs);
      case ResolutePackage.FAIL_EXPR__FAILMSG:
        return ((InternalEList<?>)getFailmsg()).basicRemove(otherEnd, msgs);
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
      case ResolutePackage.FAIL_EXPR__VAL:
        return getVal();
      case ResolutePackage.FAIL_EXPR__FAILMSG:
        return getFailmsg();
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
      case ResolutePackage.FAIL_EXPR__VAL:
        setVal((Expr)newValue);
        return;
      case ResolutePackage.FAIL_EXPR__FAILMSG:
        getFailmsg().clear();
        getFailmsg().addAll((Collection<? extends ClaimText>)newValue);
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
      case ResolutePackage.FAIL_EXPR__VAL:
        setVal((Expr)null);
        return;
      case ResolutePackage.FAIL_EXPR__FAILMSG:
        getFailmsg().clear();
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
      case ResolutePackage.FAIL_EXPR__VAL:
        return val != null;
      case ResolutePackage.FAIL_EXPR__FAILMSG:
        return failmsg != null && !failmsg.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FailExprImpl
