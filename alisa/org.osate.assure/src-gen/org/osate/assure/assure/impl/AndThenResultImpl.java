/**
 */
package org.osate.assure.assure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.VerificationExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Then Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.AndThenResultImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.AndThenResultImpl#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndThenResultImpl extends VerificationExprImpl implements AndThenResult
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AndThenResultImpl()
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
    return AssurePackage.Literals.AND_THEN_RESULT;
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
      first = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.AND_THEN_RESULT__FIRST);
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
      second = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.AND_THEN_RESULT__SECOND);
    }
    return second;
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
      case AssurePackage.AND_THEN_RESULT__FIRST:
        return ((InternalEList<?>)getFirst()).basicRemove(otherEnd, msgs);
      case AssurePackage.AND_THEN_RESULT__SECOND:
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
      case AssurePackage.AND_THEN_RESULT__FIRST:
        return getFirst();
      case AssurePackage.AND_THEN_RESULT__SECOND:
        return getSecond();
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
      case AssurePackage.AND_THEN_RESULT__FIRST:
        getFirst().clear();
        getFirst().addAll((Collection<? extends VerificationExpr>)newValue);
        return;
      case AssurePackage.AND_THEN_RESULT__SECOND:
        getSecond().clear();
        getSecond().addAll((Collection<? extends VerificationExpr>)newValue);
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
      case AssurePackage.AND_THEN_RESULT__FIRST:
        getFirst().clear();
        return;
      case AssurePackage.AND_THEN_RESULT__SECOND:
        getSecond().clear();
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
      case AssurePackage.AND_THEN_RESULT__FIRST:
        return first != null && !first.isEmpty();
      case AssurePackage.AND_THEN_RESULT__SECOND:
        return second != null && !second.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AndThenResultImpl
