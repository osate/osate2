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
   * Returns a new object of class '<em>RSAL Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RSAL Container</em>'.
   * @generated
   */
  RSALContainer createRSALContainer();

  /**
   * Returns a new object of class '<em>Verification Activity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Activity</em>'.
   * @generated
   */
  VerificationActivity createVerificationActivity();

  /**
   * Returns a new object of class '<em>Verification Assumption</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Assumption</em>'.
   * @generated
   */
  VerificationAssumption createVerificationAssumption();

  /**
   * Returns a new object of class '<em>Assurance Plan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assurance Plan</em>'.
   * @generated
   */
  AssurancePlan createAssurancePlan();

  /**
   * Returns a new object of class '<em>Argument Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Expr</em>'.
   * @generated
   */
  ArgumentExpr createArgumentExpr();

  /**
   * Returns a new object of class '<em>Argument Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Reference</em>'.
   * @generated
   */
  ArgumentReference createArgumentReference();

  /**
   * Returns a new object of class '<em>Verification Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Method</em>'.
   * @generated
   */
  VerificationMethod createVerificationMethod();

  /**
   * Returns a new object of class '<em>Binary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Expr</em>'.
   * @generated
   */
  BinaryExpr createBinaryExpr();

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
