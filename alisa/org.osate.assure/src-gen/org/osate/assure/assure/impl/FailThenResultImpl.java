/**
 */
package org.osate.assure.assure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.VerificationExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fail Then Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.FailThenResultImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.FailThenResultImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.FailThenResultImpl#isDidFailThenFail <em>Did Fail Then Fail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailThenResultImpl extends VerificationExprImpl implements FailThenResult
{
  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected EList<VerificationExpr> first;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected EList<VerificationExpr> second;

  /**
   * The default value of the '{@link #isDidFailThenFail() <em>Did Fail Then Fail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDidFailThenFail()
   * @generated
   * @ordered
   */
  protected static final boolean DID_FAIL_THEN_FAIL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDidFailThenFail() <em>Did Fail Then Fail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDidFailThenFail()
   * @generated
   * @ordered
   */
  protected boolean didFailThenFail = DID_FAIL_THEN_FAIL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FailThenResultImpl()
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
    return AssurePackage.Literals.FAIL_THEN_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationExpr> getFirst()
  {
    if (first == null)
    {
      first = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.FAIL_THEN_RESULT__FIRST);
    }
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VerificationExpr> getSecond()
  {
    if (second == null)
    {
      second = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.FAIL_THEN_RESULT__SECOND);
    }
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDidFailThenFail()
  {
    return didFailThenFail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDidFailThenFail(boolean newDidFailThenFail)
  {
    boolean oldDidFailThenFail = didFailThenFail;
    didFailThenFail = newDidFailThenFail;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL, oldDidFailThenFail, didFailThenFail));
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
      case AssurePackage.FAIL_THEN_RESULT__FIRST:
        return ((InternalEList<?>)getFirst()).basicRemove(otherEnd, msgs);
      case AssurePackage.FAIL_THEN_RESULT__SECOND:
        return ((InternalEList<?>)getSecond()).basicRemove(otherEnd, msgs);
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
      case AssurePackage.FAIL_THEN_RESULT__FIRST:
        return getFirst();
      case AssurePackage.FAIL_THEN_RESULT__SECOND:
        return getSecond();
      case AssurePackage.FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL:
        return isDidFailThenFail();
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
      case AssurePackage.FAIL_THEN_RESULT__FIRST:
        getFirst().clear();
        getFirst().addAll((Collection<? extends VerificationExpr>)newValue);
        return;
      case AssurePackage.FAIL_THEN_RESULT__SECOND:
        getSecond().clear();
        getSecond().addAll((Collection<? extends VerificationExpr>)newValue);
        return;
      case AssurePackage.FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL:
        setDidFailThenFail((Boolean)newValue);
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
      case AssurePackage.FAIL_THEN_RESULT__FIRST:
        getFirst().clear();
        return;
      case AssurePackage.FAIL_THEN_RESULT__SECOND:
        getSecond().clear();
        return;
      case AssurePackage.FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL:
        setDidFailThenFail(DID_FAIL_THEN_FAIL_EDEFAULT);
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
      case AssurePackage.FAIL_THEN_RESULT__FIRST:
        return first != null && !first.isEmpty();
      case AssurePackage.FAIL_THEN_RESULT__SECOND:
        return second != null && !second.isEmpty();
      case AssurePackage.FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL:
        return didFailThenFail != DID_FAIL_THEN_FAIL_EDEFAULT;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (didFailThenFail: ");
    result.append(didFailThenFail);
    result.append(')');
    return result.toString();
  }

} //FailThenResultImpl
