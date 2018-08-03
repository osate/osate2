/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package org.osate.ba.declarative ;

import org.eclipse.emf.ecore.EFactory ;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.ba.declarative.DeclarativePackage
 * @generated
 */
public interface DeclarativeFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DeclarativeFactory eINSTANCE =
        org.osate.ba.declarative.impl.DeclarativeFactoryImpl.init() ;

  /**
   * Returns a new object of class '<em>Arrayable Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arrayable Identifier</em>'.
   * @generated
   */
  ArrayableIdentifier createArrayableIdentifier() ;

  /**
   * Returns a new object of class '<em>Comm Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comm Action</em>'.
   * @generated
   */
  CommAction createCommAction() ;

  /**
   * Returns a new object of class '<em>Array Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Dimension</em>'.
   * @generated
   */
  DeclarativeArrayDimension createDeclarativeArrayDimension() ;

  /**
   * Returns a new object of class '<em>Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Transition</em>'.
   * @generated
   */
  DeclarativeBehaviorTransition createDeclarativeBehaviorTransition() ;

  /**
   * Returns a new object of class '<em>Property Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Name</em>'.
   * @generated
   */
  DeclarativePropertyName createDeclarativePropertyName() ;

  /**
   * Returns a new object of class '<em>Property Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Reference</em>'.
   * @generated
   */
  DeclarativePropertyReference createDeclarativePropertyReference() ;

  /**
   * Returns a new object of class '<em>Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time</em>'.
   * @generated
   */
  DeclarativeTime createDeclarativeTime() ;

  /**
   * Returns a new object of class '<em>Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Identifier</em>'.
   * @generated
   */
  Identifier createIdentifier() ;

  /**
   * Returns a new object of class '<em>Named Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Value</em>'.
   * @generated
   */
  NamedValue createNamedValue() ;

  /**
   * Returns a new object of class '<em>Qualified Named Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Named Element</em>'.
   * @generated
   */
  QualifiedNamedElement createQualifiedNamedElement() ;

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference() ;

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DeclarativePackage getDeclarativePackage() ;

} //DeclarativeFactory
