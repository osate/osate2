/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
