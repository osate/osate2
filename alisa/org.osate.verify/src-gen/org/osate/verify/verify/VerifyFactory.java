/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.verify.verify.VerifyPackage
 * @generated
 */
public interface VerifyFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VerifyFactory eINSTANCE = org.osate.verify.verify.impl.VerifyFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Verification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification</em>'.
   * @generated
   */
  Verification createVerification();

  /**
   * Returns a new object of class '<em>Verification Plan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Plan</em>'.
   * @generated
   */
  VerificationPlan createVerificationPlan();

  /**
   * Returns a new object of class '<em>Claim</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Claim</em>'.
   * @generated
   */
  Claim createClaim();

  /**
   * Returns a new object of class '<em>Weighted Claim</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Weighted Claim</em>'.
   * @generated
   */
  WeightedClaim createWeightedClaim();

  /**
   * Returns a new object of class '<em>Verification Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Library</em>'.
   * @generated
   */
  VerificationLibrary createVerificationLibrary();

  /**
   * Returns a new object of class '<em>Verification Folder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Folder</em>'.
   * @generated
   */
  VerificationFolder createVerificationFolder();

  /**
   * Returns a new object of class '<em>Verification Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Container</em>'.
   * @generated
   */
  VerificationContainer createVerificationContainer();

  /**
   * Returns a new object of class '<em>Verification Activity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Activity</em>'.
   * @generated
   */
  VerificationActivity createVerificationActivity();

  /**
   * Returns a new object of class '<em>Verification Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Condition</em>'.
   * @generated
   */
  VerificationCondition createVerificationCondition();

  /**
   * Returns a new object of class '<em>Argument Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Expr</em>'.
   * @generated
   */
  ArgumentExpr createArgumentExpr();

  /**
   * Returns a new object of class '<em>Verification Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Action</em>'.
   * @generated
   */
  VerificationAction createVerificationAction();

  /**
   * Returns a new object of class '<em>Verification Method Registry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Method Registry</em>'.
   * @generated
   */
  VerificationMethodRegistry createVerificationMethodRegistry();

  /**
   * Returns a new object of class '<em>Verification Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Method</em>'.
   * @generated
   */
  VerificationMethod createVerificationMethod();

  /**
   * Returns a new object of class '<em>Verification Assumption</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Assumption</em>'.
   * @generated
   */
  VerificationAssumption createVerificationAssumption();

  /**
   * Returns a new object of class '<em>Verification Precondition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Precondition</em>'.
   * @generated
   */
  VerificationPrecondition createVerificationPrecondition();

  /**
   * Returns a new object of class '<em>All Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>All Expr</em>'.
   * @generated
   */
  AllExpr createAllExpr();

  /**
   * Returns a new object of class '<em>And Then Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Then Expr</em>'.
   * @generated
   */
  AndThenExpr createAndThenExpr();

  /**
   * Returns a new object of class '<em>Fail Then Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fail Then Expr</em>'.
   * @generated
   */
  FailThenExpr createFailThenExpr();

  /**
   * Returns a new object of class '<em>When Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>When Expr</em>'.
   * @generated
   */
  WhenExpr createWhenExpr();

  /**
   * Returns a new object of class '<em>Ref Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref Expr</em>'.
   * @generated
   */
  RefExpr createRefExpr();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  VerifyPackage getVerifyPackage();

} //VerifyFactory
