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
package org.osate.ba.aadlba;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.StringLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorEnumerationLiteral#getEnumLiteral <em>Enum Literal</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorEnumerationLiteral#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorEnumerationLiteral()
 * @model
 * @generated
 */
public interface BehaviorEnumerationLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Enum Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum Literal</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Literal</em>' reference.
   * @see #setEnumLiteral(StringLiteral)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorEnumerationLiteral_EnumLiteral()
   * @model required="true"
   * @generated
   */
  StringLiteral getEnumLiteral();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorEnumerationLiteral#getEnumLiteral <em>Enum Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Literal</em>' reference.
   * @see #getEnumLiteral()
   * @generated
   */
  void setEnumLiteral(StringLiteral value);

  /**
   * Returns the value of the '<em><b>Component</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component</em>' reference.
   * @see #setComponent(ComponentClassifier)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorEnumerationLiteral_Component()
   * @model required="true"
   * @generated
   */
  ComponentClassifier getComponent();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorEnumerationLiteral#getComponent <em>Component</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' reference.
   * @see #getComponent()
   * @generated
   */
  void setComponent(ComponentClassifier value);

} // BehaviorEnumerationLiteral
