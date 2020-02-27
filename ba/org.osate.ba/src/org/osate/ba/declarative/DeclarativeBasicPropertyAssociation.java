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

import org.osate.aadl2.BasicPropertyAssociation ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Property Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativeBasicPropertyAssociation#getBasicPropertyName <em>Basic Property Name</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeBasicPropertyAssociation()
 * @model
 * @generated
 */
public interface DeclarativeBasicPropertyAssociation extends EObject,
                                                     BasicPropertyAssociation
{
  /**
   * Returns the value of the '<em><b>Basic Property Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Basic Property Name</em>' attribute.
   * @see #setBasicPropertyName(String)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeBasicPropertyAssociation_BasicPropertyName()
   * @model dataType="org.osate.aadl2.String" required="true"
   * @generated
   */
  String getBasicPropertyName() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativeBasicPropertyAssociation#getBasicPropertyName <em>Basic Property Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Basic Property Name</em>' attribute.
   * @see #getBasicPropertyName()
   * @generated
   */
  void setBasicPropertyName(String value) ;

} // DeclarativeBasicPropertyAssociation
