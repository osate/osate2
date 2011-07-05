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
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ComponentPropertyValue#getPropertyIdentifier <em>Property Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ComponentPropertyValue#getElementListIdentifier <em>Element List Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getComponentPropertyValue()
 * @model abstract="true"
 * @generated
 */
public interface ComponentPropertyValue extends BehaviorNamedElement, ValueConstant {
	/**
	 * Returns the value of the '<em><b>Property Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Identifier</em>' containment reference.
	 * @see #setPropertyIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getComponentPropertyValue_PropertyIdentifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getPropertyIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ComponentPropertyValue#getPropertyIdentifier <em>Property Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Identifier</em>' containment reference.
	 * @see #getPropertyIdentifier()
	 * @generated
	 */
	void setPropertyIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>Element List Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element List Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element List Identifier</em>' containment reference.
	 * @see #setElementListIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getComponentPropertyValue_ElementListIdentifier()
	 * @model containment="true"
	 * @generated
	 */
	Identifier getElementListIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ComponentPropertyValue#getElementListIdentifier <em>Element List Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element List Identifier</em>' containment reference.
	 * @see #getElementListIdentifier()
	 * @generated
	 */
	void setElementListIdentifier(Identifier value);

} // ComponentPropertyValue
