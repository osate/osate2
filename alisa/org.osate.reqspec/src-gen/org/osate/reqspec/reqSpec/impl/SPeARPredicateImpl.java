/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.SPeARPredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPe AR Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.SPeARPredicateImpl#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SPeARPredicateImpl extends ReqPredicateImpl implements SPeARPredicate
{
  /**
   * The default value of the '{@link #getPredicate() <em>Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected static final String PREDICATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected String predicate = PREDICATE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SPeARPredicateImpl()
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
    return ReqSpecPackage.Literals.SPE_AR_PREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPredicate()
  {
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPredicate(String newPredicate)
  {
    String oldPredicate = predicate;
    predicate = newPredicate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.SPE_AR_PREDICATE__PREDICATE, oldPredicate, predicate));
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
      case ReqSpecPackage.SPE_AR_PREDICATE__PREDICATE:
        return getPredicate();
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
      case ReqSpecPackage.SPE_AR_PREDICATE__PREDICATE:
        setPredicate((String)newValue);
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
      case ReqSpecPackage.SPE_AR_PREDICATE__PREDICATE:
        setPredicate(PREDICATE_EDEFAULT);
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
      case ReqSpecPackage.SPE_AR_PREDICATE__PREDICATE:
        return PREDICATE_EDEFAULT == null ? predicate != null : !PREDICATE_EDEFAULT.equals(predicate);
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
    result.append(" (predicate: ");
    result.append(predicate);
    result.append(')');
    return result.toString();
  }

} //SPeARPredicateImpl
