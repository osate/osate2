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
package org.osate.ba.aadlba;

import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.Relation#getFirstExpression <em>First Expression</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Relation#getSecondExpression <em>Second Expression</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Relation#getRelationalOperator <em>Relational Operator</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>First Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Expression</em>' containment reference.
   * @see #setFirstExpression(SimpleExpression)
   * @see org.osate.ba.aadlba.AadlBaPackage#getRelation_FirstExpression()
   * @model containment="true" required="true"
   * @generated
   */
  SimpleExpression getFirstExpression();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Relation#getFirstExpression <em>First Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Expression</em>' containment reference.
   * @see #getFirstExpression()
   * @generated
   */
  void setFirstExpression(SimpleExpression value);

  /**
   * Returns the value of the '<em><b>Second Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Expression</em>' containment reference.
   * @see #setSecondExpression(SimpleExpression)
   * @see org.osate.ba.aadlba.AadlBaPackage#getRelation_SecondExpression()
   * @model containment="true"
   * @generated
   */
  SimpleExpression getSecondExpression();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Relation#getSecondExpression <em>Second Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second Expression</em>' containment reference.
   * @see #getSecondExpression()
   * @generated
   */
  void setSecondExpression(SimpleExpression value);

  /**
   * Returns the value of the '<em><b>Relational Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.RelationalOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relational Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relational Operator</em>' attribute.
   * @see org.osate.ba.aadlba.RelationalOperator
   * @see #isSetRelationalOperator()
   * @see #unsetRelationalOperator()
   * @see #setRelationalOperator(RelationalOperator)
   * @see org.osate.ba.aadlba.AadlBaPackage#getRelation_RelationalOperator()
   * @model unique="false" unsettable="true"
   * @generated
   */
  RelationalOperator getRelationalOperator();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Relation#getRelationalOperator <em>Relational Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relational Operator</em>' attribute.
   * @see org.osate.ba.aadlba.RelationalOperator
   * @see #isSetRelationalOperator()
   * @see #unsetRelationalOperator()
   * @see #getRelationalOperator()
   * @generated
   */
  void setRelationalOperator(RelationalOperator value);

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.Relation#getRelationalOperator <em>Relational Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRelationalOperator()
   * @see #getRelationalOperator()
   * @see #setRelationalOperator(RelationalOperator)
   * @generated
   */
  void unsetRelationalOperator();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.Relation#getRelationalOperator <em>Relational Operator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Relational Operator</em>' attribute is set.
   * @see #unsetRelationalOperator()
   * @see #getRelationalOperator()
   * @see #setRelationalOperator(RelationalOperator)
   * @generated
   */
  boolean isSetRelationalOperator();

} // Relation
