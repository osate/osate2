/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.alisa.common.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CommonFactory eINSTANCE = org.osate.alisa.common.common.impl.CommonFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Description</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Description</em>'.
   * @generated
   */
  Description createDescription();

  /**
   * Returns a new object of class '<em>Description Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Description Element</em>'.
   * @generated
   */
  DescriptionElement createDescriptionElement();

  /**
   * Returns a new object of class '<em>Rationale</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rationale</em>'.
   * @generated
   */
  Rationale createRationale();

  /**
   * Returns a new object of class '<em>Uncertainty</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Uncertainty</em>'.
   * @generated
   */
  Uncertainty createUncertainty();

  /**
   * Returns a new object of class '<em>AVariable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AVariable Declaration</em>'.
   * @generated
   */
  AVariableDeclaration createAVariableDeclaration();

  /**
   * Returns a new object of class '<em>AExpression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AExpression</em>'.
   * @generated
   */
  AExpression createAExpression();

  /**
   * Returns a new object of class '<em>Show Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Show Value</em>'.
   * @generated
   */
  ShowValue createShowValue();

  /**
   * Returns a new object of class '<em>Image Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Image Reference</em>'.
   * @generated
   */
  ImageReference createImageReference();

  /**
   * Returns a new object of class '<em>Val Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Val Declaration</em>'.
   * @generated
   */
  ValDeclaration createValDeclaration();

  /**
   * Returns a new object of class '<em>Compute Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compute Declaration</em>'.
   * @generated
   */
  ComputeDeclaration createComputeDeclaration();

  /**
   * Returns a new object of class '<em>AProperty Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AProperty Reference</em>'.
   * @generated
   */
  APropertyReference createAPropertyReference();

  /**
   * Returns a new object of class '<em>AVariable Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AVariable Reference</em>'.
   * @generated
   */
  AVariableReference createAVariableReference();

  /**
   * Returns a new object of class '<em>ABinary Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ABinary Operation</em>'.
   * @generated
   */
  ABinaryOperation createABinaryOperation();

  /**
   * Returns a new object of class '<em>AUnary Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AUnary Operation</em>'.
   * @generated
   */
  AUnaryOperation createAUnaryOperation();

  /**
   * Returns a new object of class '<em>ASet Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASet Literal</em>'.
   * @generated
   */
  ASetLiteral createASetLiteral();

  /**
   * Returns a new object of class '<em>AList Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AList Term</em>'.
   * @generated
   */
  AListTerm createAListTerm();

  /**
   * Returns a new object of class '<em>ANull Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ANull Literal</em>'.
   * @generated
   */
  ANullLiteral createANullLiteral();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CommonPackage getCommonPackage();

} //CommonFactory
