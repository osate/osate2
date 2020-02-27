/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.declarative ;

import org.eclipse.emf.ecore.EObject ;

import org.osate.ba.aadlba.BehaviorElement ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyAssociation#getOwnedValue <em>Owned Value</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyAssociation()
 * @model
 * @generated
 */
public interface DeclarativePropertyAssociation extends
                                                DeclarativeBehaviorElement
{

  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(QualifiedNamedElement)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyAssociation_Property()
   * @model required="true"
   * @generated
   */
  QualifiedNamedElement getProperty() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyAssociation#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(QualifiedNamedElement value) ;

  /**
   * Returns the value of the '<em><b>Owned Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Value</em>' containment reference.
   * @see #setOwnedValue(DeclarativePropertyExpression)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyAssociation_OwnedValue()
   * @model containment="true" required="true"
   * @generated
   */
  DeclarativePropertyExpression getOwnedValue() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyAssociation#getOwnedValue <em>Owned Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Value</em>' containment reference.
   * @see #getOwnedValue()
   * @generated
   */
  void setOwnedValue(DeclarativePropertyExpression value) ;
} // DeclarativePropertyAssociation
