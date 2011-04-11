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
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors <em>Factors</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Factors</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Factor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factors</em>' containment reference list.
	 * @see #isSetFactors()
	 * @see #unsetFactors()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm_Factors()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Factor> getFactors();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors <em>Factors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFactors()
	 * @see #getFactors()
	 * @generated
	 */
	void unsetFactors();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors <em>Factors</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Factors</em>' containment reference list is set.
	 * @see #unsetFactors()
	 * @see #getFactors()
	 * @generated
	 */
	boolean isSetFactors();

	/**
	 * Returns the value of the '<em><b>Multiplying Operators</b></em>' attribute list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator}.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplying Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplying Operators</em>' attribute list.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
	 * @see #isSetMultiplyingOperators()
	 * @see #unsetMultiplyingOperators()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm_MultiplyingOperators()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<MultiplyingOperator> getMultiplyingOperators();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMultiplyingOperators()
	 * @see #getMultiplyingOperators()
	 * @generated
	 */
	void unsetMultiplyingOperators();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multiplying Operators</em>' attribute list is set.
	 * @see #unsetMultiplyingOperators()
	 * @see #getMultiplyingOperators()
	 * @generated
	 */
	boolean isSetMultiplyingOperators();

} // Term
