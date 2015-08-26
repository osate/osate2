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
   * Returns a new object of class '<em>Assurance Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assurance Case</em>'.
   * @generated
   */
  AssuranceCase createAssuranceCase();

  /**
   * Returns a new object of class '<em>Claim Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Claim Result</em>'.
   * @generated
   */
  ClaimResult createClaimResult();

  /**
   * Returns a new object of class '<em>Verification Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Result</em>'.
   * @generated
   */
  VerificationResult createVerificationResult();

  /**
   * Returns a new object of class '<em>Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result</em>'.
   * @generated
   */
  AssureResult createAssureResult();

  /**
   * Returns a new object of class '<em>Verification Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Expr</em>'.
   * @generated
   */
  VerificationExpr createVerificationExpr();

  /**
   * Returns a new object of class '<em>Else Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else Result</em>'.
   * @generated
   */
  ElseResult createElseResult();

  /**
   * Returns a new object of class '<em>Then Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Then Result</em>'.
   * @generated
   */
  ThenResult createThenResult();

  /**
   * Returns a new object of class '<em>Metrics</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metrics</em>'.
   * @generated
   */
  Metrics createMetrics();

  /**
   * Returns a new object of class '<em>Result Issue</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Issue</em>'.
   * @generated
   */
  ResultIssue createResultIssue();

  /**
   * Returns a new object of class '<em>Precondition Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Precondition Result</em>'.
   * @generated
   */
  PreconditionResult createPreconditionResult();

  /**
   * Returns a new object of class '<em>Validation Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Validation Result</em>'.
   * @generated
   */
  ValidationResult createValidationResult();

  /**
   * Returns a new object of class '<em>Verification Activity Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Activity Result</em>'.
   * @generated
   */
  VerificationActivityResult createVerificationActivityResult();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AssurePackage getAssurePackage();

} //AssureFactory
