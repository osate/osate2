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
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.NumericRangeImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumericRangeImpl#getLowerBound <em>Lower Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericRangeImpl extends ElementImpl implements NumericRange {
	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression upperBound;
	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression lowerBound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getNumericRange();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperBound(PropertyExpression newUpperBound, NotificationChain msgs) {
		PropertyExpression oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.NUMERIC_RANGE__UPPER_BOUND, oldUpperBound, newUpperBound);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(PropertyExpression newUpperBound) {
		if (newUpperBound != upperBound) {
			NotificationChain msgs = null;
			if (upperBound != null) {
				msgs = ((InternalEObject) upperBound).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMERIC_RANGE__UPPER_BOUND, null, msgs);
			}
			if (newUpperBound != null) {
				msgs = ((InternalEObject) newUpperBound).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMERIC_RANGE__UPPER_BOUND, null, msgs);
			}
			msgs = basicSetUpperBound(newUpperBound, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMERIC_RANGE__UPPER_BOUND,
					newUpperBound, newUpperBound));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createUpperBound(EClass eClass) {
		PropertyExpression newUpperBound = (PropertyExpression) create(eClass);
		setUpperBound(newUpperBound);
		return newUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerBound(PropertyExpression newLowerBound, NotificationChain msgs) {
		PropertyExpression oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.NUMERIC_RANGE__LOWER_BOUND, oldLowerBound, newLowerBound);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(PropertyExpression newLowerBound) {
		if (newLowerBound != lowerBound) {
			NotificationChain msgs = null;
			if (lowerBound != null) {
				msgs = ((InternalEObject) lowerBound).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMERIC_RANGE__LOWER_BOUND, null, msgs);
			}
			if (newLowerBound != null) {
				msgs = ((InternalEObject) newLowerBound).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMERIC_RANGE__LOWER_BOUND, null, msgs);
			}
			msgs = basicSetLowerBound(newLowerBound, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMERIC_RANGE__LOWER_BOUND,
					newLowerBound, newLowerBound));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createLowerBound(EClass eClass) {
		PropertyExpression newLowerBound = (PropertyExpression) create(eClass);
		setLowerBound(newLowerBound);
		return newLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.NUMERIC_RANGE__UPPER_BOUND:
			return basicSetUpperBound(null, msgs);
		case Aadl2Package.NUMERIC_RANGE__LOWER_BOUND:
			return basicSetLowerBound(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.NUMERIC_RANGE__UPPER_BOUND:
			return getUpperBound();
		case Aadl2Package.NUMERIC_RANGE__LOWER_BOUND:
			return getLowerBound();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.NUMERIC_RANGE__UPPER_BOUND:
			setUpperBound((PropertyExpression) newValue);
			return;
		case Aadl2Package.NUMERIC_RANGE__LOWER_BOUND:
			setLowerBound((PropertyExpression) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.NUMERIC_RANGE__UPPER_BOUND:
			setUpperBound((PropertyExpression) null);
			return;
		case Aadl2Package.NUMERIC_RANGE__LOWER_BOUND:
			setLowerBound((PropertyExpression) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.NUMERIC_RANGE__UPPER_BOUND:
			return upperBound != null;
		case Aadl2Package.NUMERIC_RANGE__LOWER_BOUND:
			return lowerBound != null;
		}
		return super.eIsSet(featureID);
	}

} // NumericRangeImpl
