/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package org.osate.ba.declarative ;

import org.osate.ba.aadlba.PropertyField ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyName#getField <em>Field</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyName#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyName()
 * @model
 * @generated
 */
public interface DeclarativePropertyName extends DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference.
   * @see #setField(PropertyField)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyName_Field()
   * @model containment="true"
   * @generated
   */
  PropertyField getField() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyName#getField <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' containment reference.
   * @see #getField()
   * @generated
   */
  void setField(PropertyField value) ;

  /**
   * Returns the value of the '<em><b>Property Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Name</em>' containment reference.
   * @see #setPropertyName(Identifier)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyName_PropertyName()
   * @model containment="true" required="true"
   * @generated
   */
  Identifier getPropertyName() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyName#getPropertyName <em>Property Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Name</em>' containment reference.
   * @see #getPropertyName()
   * @generated
   */
  void setPropertyName(Identifier value) ;

} // DeclarativePropertyName
