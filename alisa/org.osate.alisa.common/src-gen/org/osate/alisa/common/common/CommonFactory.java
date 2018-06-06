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
   * Returns a new object of class '<em>AModel Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AModel Reference</em>'.
   * @generated
   */
  AModelReference createAModelReference();

  /**
   * Returns a new object of class '<em>AProperty Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AProperty Reference</em>'.
   * @generated
   */
  APropertyReference createAPropertyReference();

  /**
   * Returns a new object of class '<em>AUnit Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AUnit Expression</em>'.
   * @generated
   */
  AUnitExpression createAUnitExpression();

  /**
   * Returns a new object of class '<em>Image Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Image Reference</em>'.
   * @generated
   */
  ImageReference createImageReference();

  /**
   * Returns a new object of class '<em>Model Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Ref</em>'.
   * @generated
   */
  ModelRef createModelRef();

  /**
   * Returns a new object of class '<em>Type Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Ref</em>'.
   * @generated
   */
  TypeRef createTypeRef();

  /**
   * Returns a new object of class '<em>Property Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Ref</em>'.
   * @generated
   */
  PropertyRef createPropertyRef();

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
   * Returns a new object of class '<em>AFunction Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AFunction Call</em>'.
   * @generated
   */
  AFunctionCall createAFunctionCall();

  /**
   * Returns a new object of class '<em>ARange</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ARange</em>'.
   * @generated
   */
  ARange createARange();

  /**
   * Returns a new object of class '<em>AConditional</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AConditional</em>'.
   * @generated
   */
  AConditional createAConditional();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CommonPackage getCommonPackage();

} //CommonFactory
