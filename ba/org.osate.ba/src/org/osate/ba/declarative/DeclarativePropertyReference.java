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

import org.osate.ba.aadlba.IntegerValueConstant ;
import org.osate.ba.aadlba.ValueConstant ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyReference#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyReference#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyReference#getPropertyNames <em>Property Names</em>}</li>
 *   <li>{@link org.osate.ba.declarative.DeclarativePropertyReference#isPropertySet <em>Property Set</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyReference()
 * @model
 * @generated
 */
public interface DeclarativePropertyReference extends
                                              DeclarativeBehaviorElement,
                                              IntegerValueConstant,
                                              ValueConstant
{
  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' containment reference.
   * @see #setQualifiedName(QualifiedNamedElement)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyReference_QualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedNamedElement getQualifiedName() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyReference#getQualifiedName <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' containment reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(QualifiedNamedElement value) ;

  /**
   * Returns the value of the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' containment reference.
   * @see #setReference(Reference)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyReference_Reference()
   * @model containment="true"
   * @generated
   */
  Reference getReference() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyReference#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Reference value) ;

  /**
   * Returns the value of the '<em><b>Property Names</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.declarative.DeclarativePropertyName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Names</em>' containment reference list.
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyReference_PropertyNames()
   * @model containment="true" required="true"
   * @generated
   */
  EList<DeclarativePropertyName> getPropertyNames() ;

  /**
   * Returns the value of the '<em><b>Property Set</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Set</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Set</em>' attribute.
   * @see #setPropertySet(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativePropertyReference_PropertySet()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isPropertySet() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativePropertyReference#isPropertySet <em>Property Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Set</em>' attribute.
   * @see #isPropertySet()
   * @generated
   */
  void setPropertySet(boolean value) ;

} // DeclarativePropertyReference
