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

import org.osate.ba.aadlba.IntegerValueVariable ;
import org.osate.ba.aadlba.ValueVariable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.NamedValue#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.ba.declarative.NamedValue#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.ba.declarative.NamedValue#isFresh <em>Fresh</em>}</li>
 *   <li>{@link org.osate.ba.declarative.NamedValue#isCount <em>Count</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getNamedValue()
 * @model
 * @generated
 */
public interface NamedValue extends IntegerValueVariable, ValueVariable,
                            DeclarativeBehaviorElement
{
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
   * @see org.osate.ba.declarative.DeclarativePackage#getNamedValue_Reference()
   * @model containment="true" required="true"
   * @generated
   */
  Reference getReference() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.NamedValue#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Reference value) ;

  /**
   * Returns the value of the '<em><b>Dequeue</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dequeue</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dequeue</em>' attribute.
   * @see #setDequeue(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getNamedValue_Dequeue()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isDequeue() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.NamedValue#isDequeue <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dequeue</em>' attribute.
   * @see #isDequeue()
   * @generated
   */
  void setDequeue(boolean value) ;

  /**
   * Returns the value of the '<em><b>Fresh</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fresh</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fresh</em>' attribute.
   * @see #setFresh(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getNamedValue_Fresh()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isFresh() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.NamedValue#isFresh <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fresh</em>' attribute.
   * @see #isFresh()
   * @generated
   */
  void setFresh(boolean value) ;

  /**
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(boolean)
   * @see org.osate.ba.declarative.DeclarativePackage#getNamedValue_Count()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean"
   * @generated
   */
  boolean isCount() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.NamedValue#isCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #isCount()
   * @generated
   */
  void setCount(boolean value) ;

} // NamedValue
