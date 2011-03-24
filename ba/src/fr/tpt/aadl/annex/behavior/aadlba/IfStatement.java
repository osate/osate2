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
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isHasElse <em>Has Else</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpressions <em>Logical Value Expressions</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends CondStatement {
	/**
	 * Returns the value of the '<em><b>Has Else</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Else</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Else</em>' attribute.
	 * @see #setHasElse(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement_HasElse()
	 * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
	boolean isHasElse();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isHasElse <em>Has Else</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Else</em>' attribute.
	 * @see #isHasElse()
	 * @generated
	 */
	void setHasElse(boolean value);

	/**
	 * Returns the value of the '<em><b>Logical Value Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical Value Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical Value Expressions</em>' containment reference list.
	 * @see #isSetLogicalValueExpressions()
	 * @see #unsetLogicalValueExpressions()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement_LogicalValueExpressions()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<ValueExpression> getLogicalValueExpressions();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpressions <em>Logical Value Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLogicalValueExpressions()
	 * @see #getLogicalValueExpressions()
	 * @generated
	 */
	void unsetLogicalValueExpressions();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpressions <em>Logical Value Expressions</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Logical Value Expressions</em>' containment reference list is set.
	 * @see #unsetLogicalValueExpressions()
	 * @see #getLogicalValueExpressions()
	 * @generated
	 */
	boolean isSetLogicalValueExpressions();

	/**
	 * Returns the value of the '<em><b>Behavior Actions Owned</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Actions Owned</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Actions Owned</em>' containment reference list.
	 * @see #isSetBehaviorActionsOwned()
	 * @see #unsetBehaviorActionsOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIfStatement_BehaviorActionsOwned()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<BehaviorActions> getBehaviorActionsOwned();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBehaviorActionsOwned()
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 */
	void unsetBehaviorActionsOwned();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior Actions Owned</em>' containment reference list is set.
	 * @see #unsetBehaviorActionsOwned()
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 */
	boolean isSetBehaviorActionsOwned();

} // IfStatement
