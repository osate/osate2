/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.verify.verify.Claim;
import org.osate.verify.verify.VerifyPackage;
import org.osate.verify.verify.WeightedClaim;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weighted Claim</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.WeightedClaimImpl#getClaim <em>Claim</em>}</li>
 *   <li>{@link org.osate.verify.verify.impl.WeightedClaimImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WeightedClaimImpl extends MinimalEObjectImpl.Container implements WeightedClaim
{
  /**
   * The cached value of the '{@link #getClaim() <em>Claim</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaim()
   * @generated
   * @ordered
   */
  protected Claim claim;

  /**
   * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected static final int WEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWeight()
   * @generated
   * @ordered
   */
  protected int weight = WEIGHT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WeightedClaimImpl()
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
    return VerifyPackage.Literals.WEIGHTED_CLAIM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Claim getClaim()
  {
    if (claim != null && claim.eIsProxy())
    {
      InternalEObject oldClaim = (InternalEObject)claim;
      claim = (Claim)eResolveProxy(oldClaim);
      if (claim != oldClaim)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.WEIGHTED_CLAIM__CLAIM, oldClaim, claim));
      }
    }
    return claim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Claim basicGetClaim()
  {
    return claim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClaim(Claim newClaim)
  {
    Claim oldClaim = claim;
    claim = newClaim;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.WEIGHTED_CLAIM__CLAIM, oldClaim, claim));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWeight()
  {
    return weight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWeight(int newWeight)
  {
    int oldWeight = weight;
    weight = newWeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.WEIGHTED_CLAIM__WEIGHT, oldWeight, weight));
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
      case VerifyPackage.WEIGHTED_CLAIM__CLAIM:
        if (resolve) return getClaim();
        return basicGetClaim();
      case VerifyPackage.WEIGHTED_CLAIM__WEIGHT:
        return getWeight();
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
      case VerifyPackage.WEIGHTED_CLAIM__CLAIM:
        setClaim((Claim)newValue);
        return;
      case VerifyPackage.WEIGHTED_CLAIM__WEIGHT:
        setWeight((Integer)newValue);
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
      case VerifyPackage.WEIGHTED_CLAIM__CLAIM:
        setClaim((Claim)null);
        return;
      case VerifyPackage.WEIGHTED_CLAIM__WEIGHT:
        setWeight(WEIGHT_EDEFAULT);
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
      case VerifyPackage.WEIGHTED_CLAIM__CLAIM:
        return claim != null;
      case VerifyPackage.WEIGHTED_CLAIM__WEIGHT:
        return weight != WEIGHT_EDEFAULT;
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
    result.append(" (weight: ");
    result.append(weight);
    result.append(')');
    return result.toString();
  }

} //WeightedClaimImpl
