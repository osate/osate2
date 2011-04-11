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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionOwned <em>Simple Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionSdOwned <em>Simple Expression Sd Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Simple Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Expression Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Expression Owned</em>' containment reference.
	 * @see #setSimpleExpressionOwned(SimpleExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_SimpleExpressionOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SimpleExpression getSimpleExpressionOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionOwned <em>Simple Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Expression Owned</em>' containment reference.
	 * @see #getSimpleExpressionOwned()
	 * @generated
	 */
	void setSimpleExpressionOwned(SimpleExpression value);

	/**
	 * Returns the value of the '<em><b>Simple Expression Sd Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Expression Sd Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Expression Sd Owned</em>' containment reference.
	 * @see #setSimpleExpressionSdOwned(SimpleExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_SimpleExpressionSdOwned()
	 * @model containment="true"
	 * @generated
	 */
	SimpleExpression getSimpleExpressionSdOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionSdOwned <em>Simple Expression Sd Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Expression Sd Owned</em>' containment reference.
	 * @see #getSimpleExpressionSdOwned()
	 * @generated
	 */
	void setSimpleExpressionSdOwned(SimpleExpression value);

	/**
	 * Returns the value of the '<em><b>Relational Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relational Operator Owned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relational Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
	 * @see #isSetRelationalOperatorOwned()
	 * @see #unsetRelationalOperatorOwned()
	 * @see #setRelationalOperatorOwned(RelationalOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_RelationalOperatorOwned()
	 * @model unsettable="true"
	 * @generated
	 */
	RelationalOperator getRelationalOperatorOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relational Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
	 * @see #isSetRelationalOperatorOwned()
	 * @see #unsetRelationalOperatorOwned()
	 * @see #getRelationalOperatorOwned()
	 * @generated
	 */
	void setRelationalOperatorOwned(RelationalOperator value);

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelationalOperatorOwned()
	 * @see #getRelationalOperatorOwned()
	 * @see #setRelationalOperatorOwned(RelationalOperator)
	 * @generated
	 */
	void unsetRelationalOperatorOwned();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relational Operator Owned</em>' attribute is set.
	 * @see #unsetRelationalOperatorOwned()
	 * @see #getRelationalOperatorOwned()
	 * @see #setRelationalOperatorOwned(RelationalOperator)
	 * @generated
	 */
	boolean isSetRelationalOperatorOwned();

} // Relation
