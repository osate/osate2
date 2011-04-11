/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms <em>Terms</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression()
 * @model
 * @generated
 */
public interface SimpleExpression extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Unary Adding Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unary Adding Operator Owned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unary Adding Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
	 * @see #isSetUnaryAddingOperatorOwned()
	 * @see #unsetUnaryAddingOperatorOwned()
	 * @see #setUnaryAddingOperatorOwned(UnaryAddingOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_UnaryAddingOperatorOwned()
	 * @model unsettable="true"
	 * @generated
	 */
	UnaryAddingOperator getUnaryAddingOperatorOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Adding Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
	 * @see #isSetUnaryAddingOperatorOwned()
	 * @see #unsetUnaryAddingOperatorOwned()
	 * @see #getUnaryAddingOperatorOwned()
	 * @generated
	 */
	void setUnaryAddingOperatorOwned(UnaryAddingOperator value);

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnaryAddingOperatorOwned()
	 * @see #getUnaryAddingOperatorOwned()
	 * @see #setUnaryAddingOperatorOwned(UnaryAddingOperator)
	 * @generated
	 */
	void unsetUnaryAddingOperatorOwned();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unary Adding Operator Owned</em>' attribute is set.
	 * @see #unsetUnaryAddingOperatorOwned()
	 * @see #getUnaryAddingOperatorOwned()
	 * @see #setUnaryAddingOperatorOwned(UnaryAddingOperator)
	 * @generated
	 */
	boolean isSetUnaryAddingOperatorOwned();

	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Term}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see #isSetTerms()
	 * @see #unsetTerms()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_Terms()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Term> getTerms();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTerms()
	 * @see #getTerms()
	 * @generated
	 */
	void unsetTerms();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms <em>Terms</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Terms</em>' containment reference list is set.
	 * @see #unsetTerms()
	 * @see #getTerms()
	 * @generated
	 */
	boolean isSetTerms();

	/**
	 * Returns the value of the '<em><b>Binary Adding Operators</b></em>' attribute list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator}.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binary Adding Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary Adding Operators</em>' attribute list.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
	 * @see #isSetBinaryAddingOperators()
	 * @see #unsetBinaryAddingOperators()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_BinaryAddingOperators()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<BinaryAddingOperator> getBinaryAddingOperators();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBinaryAddingOperators()
	 * @see #getBinaryAddingOperators()
	 * @generated
	 */
	void unsetBinaryAddingOperators();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Binary Adding Operators</em>' attribute list is set.
	 * @see #unsetBinaryAddingOperators()
	 * @see #getBinaryAddingOperators()
	 * @generated
	 */
	boolean isSetBinaryAddingOperators();

} // SimpleExpression
