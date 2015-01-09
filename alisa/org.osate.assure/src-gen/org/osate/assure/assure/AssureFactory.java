/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage
 * @generated
 */
public interface AssureFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssureFactory eINSTANCE = org.osate.assure.assure.impl.AssureFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Case Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Case Result</em>'.
   * @generated
   */
  CaseResult createCaseResult();

  /**
   * Returns a new object of class '<em>Verification Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Result</em>'.
   * @generated
   */
  VerificationResult createVerificationResult();

  /**
   * Returns a new object of class '<em>Claim Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Claim Result</em>'.
   * @generated
   */
  ClaimResult createClaimResult();

  /**
   * Returns a new object of class '<em>Aggregate Result Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aggregate Result Data</em>'.
   * @generated
   */
  AggregateResultData createAggregateResultData();

  /**
   * Returns a new object of class '<em>Assurance Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assurance Result</em>'.
   * @generated
   */
  AssuranceResult createAssuranceResult();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AssurePackage getAssurePackage();

} //AssureFactory
