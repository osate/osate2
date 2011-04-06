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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifierOwned <em>Identifier Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexes <em>Array Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getName_()
 * @model
 * @generated
 */
public interface Name extends ElementValues, Target, ValueVariable {
	/**
	 * Returns the value of the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Owned</em>' containment reference.
	 * @see #setIdentifierOwned(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getName_IdentifierOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getIdentifierOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifierOwned <em>Identifier Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier Owned</em>' containment reference.
	 * @see #getIdentifierOwned()
	 * @generated
	 */
	void setIdentifierOwned(Identifier value);

	/**
	 * Returns the value of the '<em><b>Array Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Indexes</em>' containment reference list.
	 * @see #isSetArrayIndexes()
	 * @see #unsetArrayIndexes()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getName_ArrayIndexes()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<IntegerValueVariable> getArrayIndexes();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexes <em>Array Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArrayIndexes()
	 * @see #getArrayIndexes()
	 * @generated
	 */
	void unsetArrayIndexes();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexes <em>Array Indexes</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Array Indexes</em>' containment reference list is set.
	 * @see #unsetArrayIndexes()
	 * @see #getArrayIndexes()
	 * @generated
	 */
	boolean isSetArrayIndexes();

} // Name
