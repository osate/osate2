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

import org.eclipse.emf.common.util.EList ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.PropertyNameField ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyName#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyName#getField <em>Field</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyName#getIndexes <em>Indexes</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyName()
 * @model
 * @generated
 */
public interface DeclarativePropertyName extends DeclarativeBehaviorElement
{
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

  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference.
   * @see #setField(PropertyNameField)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyName_Field()
   * @model containment="true"
   * @generated
   */
  PropertyNameField getField() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyName#getField <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' containment reference.
   * @see #getField()
   * @generated
   */
  void setField(PropertyNameField value) ;

  /**
   * Returns the value of the '<em><b>Indexes</b></em>' reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.IntegerValue}.
   * <!-- begin-user-doc -->
    	 * <p>
    	 * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
    	 * there really should be more of a description here...
    	 * </p>
    	 * <!-- end-user-doc -->
   * @return the value of the '<em>Indexes</em>' reference list.
   * @see #isSetIndexes()
   * @see #unsetIndexes()
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyName_Indexes()
   * @model unsettable="true"
   * @generated
   */
  EList<IntegerValue> getIndexes() ;

  /**
   * Unsets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyName#getIndexes <em>Indexes</em>}' reference list.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @see #isSetIndexes()
   * @see #getIndexes()
   * @generated
   */
  void unsetIndexes() ;

  /**
   * Returns whether the value of the '{@link org.osate.ba.declarative.DeclarativePropertyName#getIndexes <em>Indexes</em>}' reference list is set.
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @return whether the value of the '<em>Indexes</em>' reference list is set.
   * @see #unsetIndexes()
   * @see #getIndexes()
   * @generated
   */
  boolean isSetIndexes() ;

} // DeclarativePropertyName
