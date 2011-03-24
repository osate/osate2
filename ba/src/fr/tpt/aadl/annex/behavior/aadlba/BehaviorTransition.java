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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTransitionIdentifier <em>Transition Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationStateIdentifier <em>Destination State Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionBlockOwned <em>Behavior Action Block Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition()
 * @model
 * @generated
 */
public interface BehaviorTransition extends Element {
	/**
	 * Returns the value of the '<em><b>Transition Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Identifier</em>' containment reference.
	 * @see #setTransitionIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_TransitionIdentifier()
	 * @model containment="true"
	 * @generated
	 */
	Identifier getTransitionIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTransitionIdentifier <em>Transition Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Identifier</em>' containment reference.
	 * @see #getTransitionIdentifier()
	 * @generated
	 */
	void setTransitionIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>Source State Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source State Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source State Identifiers</em>' containment reference list.
	 * @see #isSetSourceStateIdentifiers()
	 * @see #unsetSourceStateIdentifiers()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_SourceStateIdentifiers()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Identifier> getSourceStateIdentifiers();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSourceStateIdentifiers()
	 * @see #getSourceStateIdentifiers()
	 * @generated
	 */
	void unsetSourceStateIdentifiers();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Source State Identifiers</em>' containment reference list is set.
	 * @see #unsetSourceStateIdentifiers()
	 * @see #getSourceStateIdentifiers()
	 * @generated
	 */
	boolean isSetSourceStateIdentifiers();

	/**
	 * Returns the value of the '<em><b>Behavior Condition Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Condition Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Condition Owned</em>' containment reference.
	 * @see #setBehaviorConditionOwned(BehaviorCondition)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_BehaviorConditionOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BehaviorCondition getBehaviorConditionOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Condition Owned</em>' containment reference.
	 * @see #getBehaviorConditionOwned()
	 * @generated
	 */
	void setBehaviorConditionOwned(BehaviorCondition value);

	/**
	 * Returns the value of the '<em><b>Destination State Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination State Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination State Identifier</em>' containment reference.
	 * @see #setDestinationStateIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_DestinationStateIdentifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getDestinationStateIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationStateIdentifier <em>Destination State Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination State Identifier</em>' containment reference.
	 * @see #getDestinationStateIdentifier()
	 * @generated
	 */
	void setDestinationStateIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>Behavior Action Block Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Action Block Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Action Block Owned</em>' containment reference.
	 * @see #setBehaviorActionBlockOwned(BehaviorActionBlock)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_BehaviorActionBlockOwned()
	 * @model containment="true"
	 * @generated
	 */
	BehaviorActionBlock getBehaviorActionBlockOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionBlockOwned <em>Behavior Action Block Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Action Block Owned</em>' containment reference.
	 * @see #getBehaviorActionBlockOwned()
	 * @generated
	 */
	void setBehaviorActionBlockOwned(BehaviorActionBlock value);

	/**
	 * Returns the value of the '<em><b>Behavior Transition Priority</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Transition Priority</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Transition Priority</em>' reference.
	 * @see #setBehaviorTransitionPriority(Numeral)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_BehaviorTransitionPriority()
	 * @model
	 * @generated
	 */
	Numeral getBehaviorTransitionPriority();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Transition Priority</em>' reference.
	 * @see #getBehaviorTransitionPriority()
	 * @generated
	 */
	void setBehaviorTransitionPriority(Numeral value);

} // BehaviorTransition
