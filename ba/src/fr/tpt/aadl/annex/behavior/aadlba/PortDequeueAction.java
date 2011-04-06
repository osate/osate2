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
 * A representation of the model object '<em><b>Port Dequeue Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPortName <em>Port Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTargetOwned <em>Target Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortDequeueAction()
 * @model
 * @generated
 */
public interface PortDequeueAction extends CommunicationAction {
	/**
	 * Returns the value of the '<em><b>Port Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Name</em>' containment reference.
	 * @see #setPortName(Name)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortDequeueAction_PortName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Name getPortName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPortName <em>Port Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Name</em>' containment reference.
	 * @see #getPortName()
	 * @generated
	 */
	void setPortName(Name value);

	/**
	 * Returns the value of the '<em><b>Target Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Owned</em>' containment reference.
	 * @see #setTargetOwned(Target)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getPortDequeueAction_TargetOwned()
	 * @model containment="true"
	 * @generated
	 */
	Target getTargetOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTargetOwned <em>Target Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Owned</em>' containment reference.
	 * @see #getTargetOwned()
	 * @generated
	 */
	void setTargetOwned(Target value);

} // PortDequeueAction
