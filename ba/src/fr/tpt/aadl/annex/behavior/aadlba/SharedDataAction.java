/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
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
 * A representation of the model object '<em><b>Shared Data Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccessName <em>Data Access Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSharedDataAction()
 * @model abstract="true"
 * @generated
 */
public interface SharedDataAction extends CommunicationAction {
	/**
	 * Returns the value of the '<em><b>Data Access Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Access Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Access Name</em>' containment reference.
	 * @see #setDataAccessName(Name)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSharedDataAction_DataAccessName()
	 * @model containment="true"
	 * @generated
	 */
	Name getDataAccessName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccessName <em>Data Access Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Access Name</em>' containment reference.
	 * @see #getDataAccessName()
	 * @generated
	 */
	void setDataAccessName(Name value);

} // SharedDataAction
