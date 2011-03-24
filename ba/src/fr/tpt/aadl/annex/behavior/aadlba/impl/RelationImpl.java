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
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Relation;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl#getSimpleExpressionOwned <em>Simple Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl#getSimpleExpressionSdOwned <em>Simple Expression Sd Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl#getRelationalOperatorOwned <em>Relational Operator Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImpl extends ElementImpl implements Relation {
	/**
	 * The cached value of the '{@link #getSimpleExpressionOwned() <em>Simple Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleExpressionOwned()
	 * @generated
	 * @ordered
	 */
	protected SimpleExpression simpleExpressionOwned;

	/**
	 * The cached value of the '{@link #getSimpleExpressionSdOwned() <em>Simple Expression Sd Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleExpressionSdOwned()
	 * @generated
	 * @ordered
	 */
	protected SimpleExpression simpleExpressionSdOwned;

	/**
	 * The default value of the '{@link #getRelationalOperatorOwned() <em>Relational Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationalOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected static final RelationalOperator RELATIONAL_OPERATOR_OWNED_EDEFAULT = RelationalOperator.NONE;

	/**
	 * The cached value of the '{@link #getRelationalOperatorOwned() <em>Relational Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationalOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected RelationalOperator relationalOperatorOwned = RELATIONAL_OPERATOR_OWNED_EDEFAULT;

	/**
	 * This is true if the Relational Operator Owned attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean relationalOperatorOwnedESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleExpression getSimpleExpressionOwned() {
		return simpleExpressionOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleExpressionOwned(SimpleExpression newSimpleExpressionOwned, NotificationChain msgs) {
		SimpleExpression oldSimpleExpressionOwned = simpleExpressionOwned;
		simpleExpressionOwned = newSimpleExpressionOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED, oldSimpleExpressionOwned, newSimpleExpressionOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleExpressionOwned(SimpleExpression newSimpleExpressionOwned) {
		if (newSimpleExpressionOwned != simpleExpressionOwned) {
			NotificationChain msgs = null;
			if (simpleExpressionOwned != null)
				msgs = ((InternalEObject)simpleExpressionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED, null, msgs);
			if (newSimpleExpressionOwned != null)
				msgs = ((InternalEObject)newSimpleExpressionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED, null, msgs);
			msgs = basicSetSimpleExpressionOwned(newSimpleExpressionOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED, newSimpleExpressionOwned, newSimpleExpressionOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleExpression getSimpleExpressionSdOwned() {
		return simpleExpressionSdOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleExpressionSdOwned(SimpleExpression newSimpleExpressionSdOwned, NotificationChain msgs) {
		SimpleExpression oldSimpleExpressionSdOwned = simpleExpressionSdOwned;
		simpleExpressionSdOwned = newSimpleExpressionSdOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED, oldSimpleExpressionSdOwned, newSimpleExpressionSdOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleExpressionSdOwned(SimpleExpression newSimpleExpressionSdOwned) {
		if (newSimpleExpressionSdOwned != simpleExpressionSdOwned) {
			NotificationChain msgs = null;
			if (simpleExpressionSdOwned != null)
				msgs = ((InternalEObject)simpleExpressionSdOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED, null, msgs);
			if (newSimpleExpressionSdOwned != null)
				msgs = ((InternalEObject)newSimpleExpressionSdOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED, null, msgs);
			msgs = basicSetSimpleExpressionSdOwned(newSimpleExpressionSdOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED, newSimpleExpressionSdOwned, newSimpleExpressionSdOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalOperator getRelationalOperatorOwned() {
		return relationalOperatorOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationalOperatorOwned(RelationalOperator newRelationalOperatorOwned) {
		RelationalOperator oldRelationalOperatorOwned = relationalOperatorOwned;
		relationalOperatorOwned = newRelationalOperatorOwned == null ? RELATIONAL_OPERATOR_OWNED_EDEFAULT : newRelationalOperatorOwned;
		boolean oldRelationalOperatorOwnedESet = relationalOperatorOwnedESet;
		relationalOperatorOwnedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.RELATION__RELATIONAL_OPERATOR_OWNED, oldRelationalOperatorOwned, relationalOperatorOwned, !oldRelationalOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelationalOperatorOwned() {
		RelationalOperator oldRelationalOperatorOwned = relationalOperatorOwned;
		boolean oldRelationalOperatorOwnedESet = relationalOperatorOwnedESet;
		relationalOperatorOwned = RELATIONAL_OPERATOR_OWNED_EDEFAULT;
		relationalOperatorOwnedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.RELATION__RELATIONAL_OPERATOR_OWNED, oldRelationalOperatorOwned, RELATIONAL_OPERATOR_OWNED_EDEFAULT, oldRelationalOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelationalOperatorOwned() {
		return relationalOperatorOwnedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED:
				return basicSetSimpleExpressionOwned(null, msgs);
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED:
				return basicSetSimpleExpressionSdOwned(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED:
				return getSimpleExpressionOwned();
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED:
				return getSimpleExpressionSdOwned();
			case AadlBaPackage.RELATION__RELATIONAL_OPERATOR_OWNED:
				return getRelationalOperatorOwned();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED:
				setSimpleExpressionOwned((SimpleExpression)newValue);
				return;
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED:
				setSimpleExpressionSdOwned((SimpleExpression)newValue);
				return;
			case AadlBaPackage.RELATION__RELATIONAL_OPERATOR_OWNED:
				setRelationalOperatorOwned((RelationalOperator)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED:
				setSimpleExpressionOwned((SimpleExpression)null);
				return;
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED:
				setSimpleExpressionSdOwned((SimpleExpression)null);
				return;
			case AadlBaPackage.RELATION__RELATIONAL_OPERATOR_OWNED:
				unsetRelationalOperatorOwned();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_OWNED:
				return simpleExpressionOwned != null;
			case AadlBaPackage.RELATION__SIMPLE_EXPRESSION_SD_OWNED:
				return simpleExpressionSdOwned != null;
			case AadlBaPackage.RELATION__RELATIONAL_OPERATOR_OWNED:
				return isSetRelationalOperatorOwned();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (relationalOperatorOwned: ");
		if (relationalOperatorOwnedESet) result.append(relationalOperatorOwned); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //RelationImpl
