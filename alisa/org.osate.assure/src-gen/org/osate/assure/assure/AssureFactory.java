/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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
   * Returns a new object of class '<em>Assurance Case Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assurance Case Result</em>'.
   * @generated
   */
  AssuranceCaseResult createAssuranceCaseResult();

  /**
   * Returns a new object of class '<em>Model Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Result</em>'.
   * @generated
   */
  ModelResult createModelResult();

  /**
   * Returns a new object of class '<em>Subsystem Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subsystem Result</em>'.
   * @generated
   */
  SubsystemResult createSubsystemResult();

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
   * Returns a new object of class '<em>Qualified Verification Plan Element Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Verification Plan Element Reference</em>'.
   * @generated
   */
  QualifiedVerificationPlanElementReference createQualifiedVerificationPlanElementReference();

  /**
   * Returns a new object of class '<em>Qualified Claim Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Claim Reference</em>'.
   * @generated
   */
  QualifiedClaimReference createQualifiedClaimReference();

  /**
   * Returns a new object of class '<em>Qualified VA Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified VA Reference</em>'.
   * @generated
   */
  QualifiedVAReference createQualifiedVAReference();

  /**
   * Returns a new object of class '<em>Nested Claim Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested Claim Reference</em>'.
   * @generated
   */
  NestedClaimReference createNestedClaimReference();

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
   * Returns a new object of class '<em>Predicate Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Result</em>'.
   * @generated
   */
  PredicateResult createPredicateResult();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AssurePackage getAssurePackage();

} //AssureFactory
