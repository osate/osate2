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
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.Term;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl#getBinaryAddingOperators <em>Binary Adding Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleExpressionImpl extends ElementImpl implements SimpleExpression {
	/**
	 * The default value of the '{@link #getUnaryAddingOperatorOwned() <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnaryAddingOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected static final UnaryAddingOperator UNARY_ADDING_OPERATOR_OWNED_EDEFAULT = UnaryAddingOperator.NONE;

	/**
	 * The cached value of the '{@link #getUnaryAddingOperatorOwned() <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnaryAddingOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected UnaryAddingOperator unaryAddingOperatorOwned = UNARY_ADDING_OPERATOR_OWNED_EDEFAULT;

	/**
	 * This is true if the Unary Adding Operator Owned attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unaryAddingOperatorOwnedESet;

	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<Term> terms;

	/**
	 * The cached value of the '{@link #getBinaryAddingOperators() <em>Binary Adding Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryAddingOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<BinaryAddingOperator> binaryAddingOperators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.SIMPLE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryAddingOperator getUnaryAddingOperatorOwned() {
		return unaryAddingOperatorOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnaryAddingOperatorOwned(UnaryAddingOperator newUnaryAddingOperatorOwned) {
		UnaryAddingOperator oldUnaryAddingOperatorOwned = unaryAddingOperatorOwned;
		unaryAddingOperatorOwned = newUnaryAddingOperatorOwned == null ? UNARY_ADDING_OPERATOR_OWNED_EDEFAULT : newUnaryAddingOperatorOwned;
		boolean oldUnaryAddingOperatorOwnedESet = unaryAddingOperatorOwnedESet;
		unaryAddingOperatorOwnedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED, oldUnaryAddingOperatorOwned, unaryAddingOperatorOwned, !oldUnaryAddingOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnaryAddingOperatorOwned() {
		UnaryAddingOperator oldUnaryAddingOperatorOwned = unaryAddingOperatorOwned;
		boolean oldUnaryAddingOperatorOwnedESet = unaryAddingOperatorOwnedESet;
		unaryAddingOperatorOwned = UNARY_ADDING_OPERATOR_OWNED_EDEFAULT;
		unaryAddingOperatorOwnedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED, oldUnaryAddingOperatorOwned, UNARY_ADDING_OPERATOR_OWNED_EDEFAULT, oldUnaryAddingOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnaryAddingOperatorOwned() {
		return unaryAddingOperatorOwnedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Term> getTerms() {
		if (terms == null) {
			terms = new EObjectContainmentEList.Unsettable<Term>(Term.class, this, AadlBaPackage.SIMPLE_EXPRESSION__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTerms() {
		if (terms != null) ((InternalEList.Unsettable<?>)terms).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTerms() {
		return terms != null && ((InternalEList.Unsettable<?>)terms).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BinaryAddingOperator> getBinaryAddingOperators() {
		if (binaryAddingOperators == null) {
			binaryAddingOperators = new EDataTypeEList.Unsettable<BinaryAddingOperator>(BinaryAddingOperator.class, this, AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS);
		}
		return binaryAddingOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBinaryAddingOperators() {
		if (binaryAddingOperators != null) ((InternalEList.Unsettable<?>)binaryAddingOperators).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBinaryAddingOperators() {
		return binaryAddingOperators != null && ((InternalEList.Unsettable<?>)binaryAddingOperators).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
				return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				return getUnaryAddingOperatorOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
				return getTerms();
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
				return getBinaryAddingOperators();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				setUnaryAddingOperatorOwned((UnaryAddingOperator)newValue);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends Term>)newValue);
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
				getBinaryAddingOperators().clear();
				getBinaryAddingOperators().addAll((Collection<? extends BinaryAddingOperator>)newValue);
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
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				unsetUnaryAddingOperatorOwned();
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
				unsetTerms();
				return;
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
				unsetBinaryAddingOperators();
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
			case AadlBaPackage.SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR_OWNED:
				return isSetUnaryAddingOperatorOwned();
			case AadlBaPackage.SIMPLE_EXPRESSION__TERMS:
				return isSetTerms();
			case AadlBaPackage.SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS:
				return isSetBinaryAddingOperators();
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
		result.append(" (unaryAddingOperatorOwned: ");
		if (unaryAddingOperatorOwnedESet) result.append(unaryAddingOperatorOwned); else result.append("<unset>");
		result.append(", binaryAddingOperators: ");
		result.append(binaryAddingOperators);
		result.append(')');
		return result.toString();
	}

} //SimpleExpressionImpl
