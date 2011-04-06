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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Or For All Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementIdentifier <em>Element Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementValuesOwned <em>Element Values Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll <em>For All</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement()
 * @model
 * @generated
 */
public interface ForOrForAllStatement extends LoopStatement {
	/**
	 * Returns the value of the '<em><b>Element Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Identifier</em>' containment reference.
	 * @see #setElementIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_ElementIdentifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getElementIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementIdentifier <em>Element Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Identifier</em>' containment reference.
	 * @see #getElementIdentifier()
	 * @generated
	 */
	void setElementIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Unique Component Classifier Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Unique Component Classifier Reference</em>' containment reference.
	 * @see #setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_DataUniqueComponentClassifierReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UniqueComponentClassifierReference getDataUniqueComponentClassifierReference();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Unique Component Classifier Reference</em>' containment reference.
	 * @see #getDataUniqueComponentClassifierReference()
	 * @generated
	 */
	void setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference value);

	/**
	 * Returns the value of the '<em><b>Element Values Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Values Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Values Owned</em>' containment reference.
	 * @see #setElementValuesOwned(ElementValues)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_ElementValuesOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ElementValues getElementValuesOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementValuesOwned <em>Element Values Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Values Owned</em>' containment reference.
	 * @see #getElementValuesOwned()
	 * @generated
	 */
	void setElementValuesOwned(ElementValues value);

	/**
	 * Returns the value of the '<em><b>For All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For All</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For All</em>' attribute.
	 * @see #setForAll(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_ForAll()
	 * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
	boolean isForAll();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll <em>For All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For All</em>' attribute.
	 * @see #isForAll()
	 * @generated
	 */
	void setForAll(boolean value);

} // ForOrForAllStatement
