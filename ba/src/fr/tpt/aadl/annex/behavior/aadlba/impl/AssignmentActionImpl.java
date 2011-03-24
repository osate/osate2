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
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl#getTargetOwned <em>Target Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl#isAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentActionImpl extends ElementImpl implements AssignmentAction {
	/**
	 * The cached value of the '{@link #getTargetOwned() <em>Target Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOwned()
	 * @generated
	 * @ordered
	 */
	protected Target targetOwned;

	/**
	 * The cached value of the '{@link #getValueExpressionOwned() <em>Value Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpressionOwned()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression valueExpressionOwned;

	/**
	 * The default value of the '{@link #isAny() <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAny()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAny() <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAny()
	 * @generated
	 * @ordered
	 */
	protected boolean any = ANY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.ASSIGNMENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target getTargetOwned() {
		return targetOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetOwned(Target newTargetOwned, NotificationChain msgs) {
		Target oldTargetOwned = targetOwned;
		targetOwned = newTargetOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED, oldTargetOwned, newTargetOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetOwned(Target newTargetOwned) {
		if (newTargetOwned != targetOwned) {
			NotificationChain msgs = null;
			if (targetOwned != null)
				msgs = ((InternalEObject)targetOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED, null, msgs);
			if (newTargetOwned != null)
				msgs = ((InternalEObject)newTargetOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED, null, msgs);
			msgs = basicSetTargetOwned(newTargetOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED, newTargetOwned, newTargetOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getValueExpressionOwned() {
		return valueExpressionOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExpressionOwned(ValueExpression newValueExpressionOwned, NotificationChain msgs) {
		ValueExpression oldValueExpressionOwned = valueExpressionOwned;
		valueExpressionOwned = newValueExpressionOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED, oldValueExpressionOwned, newValueExpressionOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueExpressionOwned(ValueExpression newValueExpressionOwned) {
		if (newValueExpressionOwned != valueExpressionOwned) {
			NotificationChain msgs = null;
			if (valueExpressionOwned != null)
				msgs = ((InternalEObject)valueExpressionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED, null, msgs);
			if (newValueExpressionOwned != null)
				msgs = ((InternalEObject)newValueExpressionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED, null, msgs);
			msgs = basicSetValueExpressionOwned(newValueExpressionOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED, newValueExpressionOwned, newValueExpressionOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAny() {
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAny(boolean newAny) {
		boolean oldAny = any;
		any = newAny;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ASSIGNMENT_ACTION__ANY, oldAny, any));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED:
				return basicSetTargetOwned(null, msgs);
			case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED:
				return basicSetValueExpressionOwned(null, msgs);
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
			case AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED:
				return getTargetOwned();
			case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED:
				return getValueExpressionOwned();
			case AadlBaPackage.ASSIGNMENT_ACTION__ANY:
				return isAny();
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
			case AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED:
				setTargetOwned((Target)newValue);
				return;
			case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED:
				setValueExpressionOwned((ValueExpression)newValue);
				return;
			case AadlBaPackage.ASSIGNMENT_ACTION__ANY:
				setAny((Boolean)newValue);
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
			case AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED:
				setTargetOwned((Target)null);
				return;
			case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED:
				setValueExpressionOwned((ValueExpression)null);
				return;
			case AadlBaPackage.ASSIGNMENT_ACTION__ANY:
				setAny(ANY_EDEFAULT);
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
			case AadlBaPackage.ASSIGNMENT_ACTION__TARGET_OWNED:
				return targetOwned != null;
			case AadlBaPackage.ASSIGNMENT_ACTION__VALUE_EXPRESSION_OWNED:
				return valueExpressionOwned != null;
			case AadlBaPackage.ASSIGNMENT_ACTION__ANY:
				return any != ANY_EDEFAULT;
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
		result.append(" (any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //AssignmentActionImpl
