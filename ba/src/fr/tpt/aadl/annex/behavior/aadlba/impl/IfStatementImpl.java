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
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl#isHasElse <em>Has Else</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl#getLogicalValueExpressions <em>Logical Value Expressions</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementImpl extends ElementImpl implements IfStatement {
	/**
	 * The default value of the '{@link #isHasElse() <em>Has Else</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasElse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_ELSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasElse() <em>Has Else</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasElse()
	 * @generated
	 * @ordered
	 */
	protected boolean hasElse = HAS_ELSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLogicalValueExpressions() <em>Logical Value Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalValueExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueExpression> logicalValueExpressions;

	/**
	 * The cached value of the '{@link #getBehaviorActionsOwned() <em>Behavior Actions Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorActions> behaviorActionsOwned;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.IF_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasElse() {
		return hasElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasElse(boolean newHasElse) {
		boolean oldHasElse = hasElse;
		hasElse = newHasElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.IF_STATEMENT__HAS_ELSE, oldHasElse, hasElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValueExpression> getLogicalValueExpressions() {
		if (logicalValueExpressions == null) {
			logicalValueExpressions = new EObjectContainmentEList.Unsettable<ValueExpression>(ValueExpression.class, this, AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS);
		}
		return logicalValueExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLogicalValueExpressions() {
		if (logicalValueExpressions != null) ((InternalEList.Unsettable<?>)logicalValueExpressions).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLogicalValueExpressions() {
		return logicalValueExpressions != null && ((InternalEList.Unsettable<?>)logicalValueExpressions).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorActions> getBehaviorActionsOwned() {
		if (behaviorActionsOwned == null) {
			behaviorActionsOwned = new EObjectContainmentEList.Unsettable<BehaviorActions>(BehaviorActions.class, this, AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED);
		}
		return behaviorActionsOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBehaviorActionsOwned() {
		if (behaviorActionsOwned != null) ((InternalEList.Unsettable<?>)behaviorActionsOwned).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehaviorActionsOwned() {
		return behaviorActionsOwned != null && ((InternalEList.Unsettable<?>)behaviorActionsOwned).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS:
				return ((InternalEList<?>)getLogicalValueExpressions()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return ((InternalEList<?>)getBehaviorActionsOwned()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				return isHasElse();
			case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS:
				return getLogicalValueExpressions();
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return getBehaviorActionsOwned();
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				setHasElse((Boolean)newValue);
				return;
			case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS:
				getLogicalValueExpressions().clear();
				getLogicalValueExpressions().addAll((Collection<? extends ValueExpression>)newValue);
				return;
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				getBehaviorActionsOwned().clear();
				getBehaviorActionsOwned().addAll((Collection<? extends BehaviorActions>)newValue);
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				setHasElse(HAS_ELSE_EDEFAULT);
				return;
			case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS:
				unsetLogicalValueExpressions();
				return;
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				unsetBehaviorActionsOwned();
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
			case AadlBaPackage.IF_STATEMENT__HAS_ELSE:
				return hasElse != HAS_ELSE_EDEFAULT;
			case AadlBaPackage.IF_STATEMENT__LOGICAL_VALUE_EXPRESSIONS:
				return isSetLogicalValueExpressions();
			case AadlBaPackage.IF_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return isSetBehaviorActionsOwned();
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
		result.append(" (hasElse: ");
		result.append(hasElse);
		result.append(')');
		return result.toString();
	}

} //IfStatementImpl
