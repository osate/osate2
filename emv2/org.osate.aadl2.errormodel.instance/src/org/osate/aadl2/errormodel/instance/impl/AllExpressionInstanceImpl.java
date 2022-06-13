/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.errormodel.instance.AllExpressionInstance;
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All Expression Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.AllExpressionInstanceImpl#getMinusCount <em>Minus Count</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.AllExpressionInstanceImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllExpressionInstanceImpl extends EMV2InstanceObjectImpl implements AllExpressionInstance {
	/**
	 * The default value of the '{@link #getMinusCount() <em>Minus Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinusCount()
	 * @generated
	 * @ordered
	 */
	protected static final long MINUS_COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMinusCount() <em>Minus Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinusCount()
	 * @generated
	 * @ordered
	 */
	protected long minusCount = MINUS_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionExpressionInstance> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllExpressionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.ALL_EXPRESSION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMinusCount() {
		return minusCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinusCount(long newMinusCount) {
		long oldMinusCount = minusCount;
		minusCount = newMinusCount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__MINUS_COUNT, oldMinusCount, minusCount));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionExpressionInstance> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<>(ConditionExpressionInstance.class, this,
					EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__ELEMENTS:
			return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
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
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__MINUS_COUNT:
			return getMinusCount();
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__ELEMENTS:
			return getElements();
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
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__MINUS_COUNT:
			setMinusCount((Long) newValue);
			return;
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends ConditionExpressionInstance>) newValue);
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
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__MINUS_COUNT:
			setMinusCount(MINUS_COUNT_EDEFAULT);
			return;
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__ELEMENTS:
			getElements().clear();
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
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__MINUS_COUNT:
			return minusCount != MINUS_COUNT_EDEFAULT;
		case EMV2InstancePackage.ALL_EXPRESSION_INSTANCE__ELEMENTS:
			return elements != null && !elements.isEmpty();
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
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (minusCount: ");
		result.append(minusCount);
		result.append(')');
		return result.toString();
	}

} // AllExpressionInstanceImpl
