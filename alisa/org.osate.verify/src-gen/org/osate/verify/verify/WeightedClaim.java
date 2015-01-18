/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weighted Claim</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.WeightedClaim#getClaim <em>Claim</em>}</li>
 *   <li>{@link org.osate.verify.verify.WeightedClaim#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getWeightedClaim()
 * @model
 * @generated
 */
public interface WeightedClaim extends EObject
{
  /**
   * Returns the value of the '<em><b>Claim</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Claim</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Claim</em>' reference.
   * @see #setClaim(Claim)
   * @see org.osate.verify.verify.VerifyPackage#getWeightedClaim_Claim()
   * @model
   * @generated
   */
  Claim getClaim();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.WeightedClaim#getClaim <em>Claim</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Claim</em>' reference.
   * @see #getClaim()
   * @generated
   */
  void setClaim(Claim value);

  /**
   * Returns the value of the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Weight</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weight</em>' attribute.
   * @see #setWeight(int)
   * @see org.osate.verify.verify.VerifyPackage#getWeightedClaim_Weight()
   * @model
   * @generated
   */
  int getWeight();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.WeightedClaim#getWeight <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' attribute.
   * @see #getWeight()
   * @generated
   */
  void setWeight(int value);

} // WeightedClaim
