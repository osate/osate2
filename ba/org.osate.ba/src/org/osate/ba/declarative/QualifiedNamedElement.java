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
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.declarative ;

import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.ProcessorClassifier ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.UnitLiteral ;
import org.osate.ba.aadlba.IntegerValueConstant ;
import org.osate.ba.aadlba.ValueConstant ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.QualifiedNamedElement#getBaNamespace <em>Ba Namespace</em>}</li>
 *   <li>{@link org.osate.ba.declarative.QualifiedNamedElement#getBaName <em>Ba Name</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getQualifiedNamedElement()
 * @model
 * @generated
 */
public interface QualifiedNamedElement extends DataClassifier, Classifier,
                                       DeclarativeBehaviorElement,
                                       ValueConstant, IntegerValueConstant,
                                       ProcessorClassifier, Property,
                                       UnitLiteral
{
  /**
   * Returns the value of the '<em><b>Ba Namespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ba Namespace</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ba Namespace</em>' containment reference.
   * @see #setBaNamespace(Identifier)
   * @see org.osate.ba.declarative.DeclarativePackage#getQualifiedNamedElement_BaNamespace()
   * @model containment="true"
   * @generated
   */
  Identifier getBaNamespace() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.QualifiedNamedElement#getBaNamespace <em>Ba Namespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ba Namespace</em>' containment reference.
   * @see #getBaNamespace()
   * @generated
   */
  void setBaNamespace(Identifier value) ;

  /**
   * Returns the value of the '<em><b>Ba Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ba Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ba Name</em>' containment reference.
   * @see #setBaName(Identifier)
   * @see org.osate.ba.declarative.DeclarativePackage#getQualifiedNamedElement_BaName()
   * @model containment="true" required="true"
   * @generated
   */
  Identifier getBaName() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.QualifiedNamedElement#getBaName <em>Ba Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ba Name</em>' containment reference.
   * @see #getBaName()
   * @generated
   */
  void setBaName(Identifier value) ;

} // QualifiedNamedElement
