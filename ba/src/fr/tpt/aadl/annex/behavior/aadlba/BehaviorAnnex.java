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

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorVariables <em>Behavior Variables</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorStates <em>Behavior States</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorTransitions <em>Behavior Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex()
 * @model
 * @generated
 */
public interface BehaviorAnnex extends AnnexSubclause, Element {
	/**
	 * Returns the value of the '<em><b>Behavior Variables</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Variables</em>' containment reference list.
	 * @see #isSetBehaviorVariables()
	 * @see #unsetBehaviorVariables()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex_BehaviorVariables()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<BehaviorVariable> getBehaviorVariables();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorVariables <em>Behavior Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBehaviorVariables()
	 * @see #getBehaviorVariables()
	 * @generated
	 */
	void unsetBehaviorVariables();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorVariables <em>Behavior Variables</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior Variables</em>' containment reference list is set.
	 * @see #unsetBehaviorVariables()
	 * @see #getBehaviorVariables()
	 * @generated
	 */
	boolean isSetBehaviorVariables();

	/**
	 * Returns the value of the '<em><b>Behavior States</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior States</em>' containment reference list.
	 * @see #isSetBehaviorStates()
	 * @see #unsetBehaviorStates()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex_BehaviorStates()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<BehaviorState> getBehaviorStates();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorStates <em>Behavior States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBehaviorStates()
	 * @see #getBehaviorStates()
	 * @generated
	 */
	void unsetBehaviorStates();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorStates <em>Behavior States</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior States</em>' containment reference list is set.
	 * @see #unsetBehaviorStates()
	 * @see #getBehaviorStates()
	 * @generated
	 */
	boolean isSetBehaviorStates();

	/**
	 * Returns the value of the '<em><b>Behavior Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Transitions</em>' containment reference list.
	 * @see #isSetBehaviorTransitions()
	 * @see #unsetBehaviorTransitions()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAnnex_BehaviorTransitions()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<BehaviorTransition> getBehaviorTransitions();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorTransitions <em>Behavior Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBehaviorTransitions()
	 * @see #getBehaviorTransitions()
	 * @generated
	 */
	void unsetBehaviorTransitions();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getBehaviorTransitions <em>Behavior Transitions</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior Transitions</em>' containment reference list is set.
	 * @see #unsetBehaviorTransitions()
	 * @see #getBehaviorTransitions()
	 * @generated
	 */
	boolean isSetBehaviorTransitions();

} // BehaviorAnnex
