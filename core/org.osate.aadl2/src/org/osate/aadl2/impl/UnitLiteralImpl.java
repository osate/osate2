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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.operations.UnitLiteralOperations;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Unit Literal</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.UnitLiteralImpl#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.UnitLiteralImpl#getFactor <em>Factor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitLiteralImpl extends EnumerationLiteralImpl implements UnitLiteral {
	/**
	 * The cached value of the '{@link #getBaseUnit() <em>Base Unit</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBaseUnit()
	 * @generated
	 * @ordered
	 */
	protected UnitLiteral baseUnit;

	/**
	 * The cached value of the '{@link #getFactor() <em>Factor</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected NumberValue factor;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getUnitLiteral();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLiteral getBaseUnit() {
		if (baseUnit != null && ((EObject) baseUnit).eIsProxy()) {
			InternalEObject oldBaseUnit = (InternalEObject) baseUnit;
			baseUnit = (UnitLiteral) eResolveProxy(oldBaseUnit);
			if (baseUnit != oldBaseUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.UNIT_LITERAL__BASE_UNIT,
							oldBaseUnit, baseUnit));
			}
		}
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLiteral basicGetBaseUnit() {
		return baseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseUnit(UnitLiteral newBaseUnit) {
		UnitLiteral oldBaseUnit = baseUnit;
		baseUnit = newBaseUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.UNIT_LITERAL__BASE_UNIT, oldBaseUnit,
					baseUnit));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NumberValue getFactor() {
		return factor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFactor(NumberValue newFactor, NotificationChain msgs) {
		NumberValue oldFactor = factor;
		factor = newFactor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.UNIT_LITERAL__FACTOR, oldFactor, newFactor);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactor(NumberValue newFactor) {
		if (newFactor != factor) {
			NotificationChain msgs = null;
			if (factor != null)
				msgs = ((InternalEObject) factor).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.UNIT_LITERAL__FACTOR, null, msgs);
			if (newFactor != null)
				msgs = ((InternalEObject) newFactor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.UNIT_LITERAL__FACTOR, null, msgs);
			msgs = basicSetFactor(newFactor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.UNIT_LITERAL__FACTOR, newFactor,
					newFactor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NumberValue createFactor(EClass eClass) {
		NumberValue newFactor = (NumberValue) create(eClass);
		setFactor(newFactor);
		return newFactor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			return basicSetFactor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			if (resolve)
				return getBaseUnit();
			return basicGetBaseUnit();
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			return getFactor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			setBaseUnit((UnitLiteral) newValue);
			return;
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			setFactor((NumberValue) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			setBaseUnit((UnitLiteral) null);
			return;
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			setFactor((NumberValue) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.UNIT_LITERAL__BASE_UNIT:
			return baseUnit != null;
		case Aadl2Package.UNIT_LITERAL__FACTOR:
			return factor != null;
		}
		return super.eIsSet(featureID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.UnitLiteral#getAbsoluteFactor()
	 */
	public final double getAbsoluteFactor() {
		double factor = 1.0;
		UnitLiteral current = this;
		while (current.getBaseUnit() != null) {
			double val = (current.getFactor() instanceof IntegerLiteral
					? (double) ((IntegerLiteral) current.getFactor()).getValue()
					: ((RealLiteral) current.getFactor()).getValue());
			if (val != 0) {
				factor *= val;
			}
			current = current.getBaseUnit();
		}
		return factor;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.UnitLiteral#getAbsoluteFactor(org.osate.aadl2.UnitLiteral)
	 */
	public final double getAbsoluteFactor(UnitLiteral target) {
		return UnitLiteralOperations.getAbsoluteFactor(this, target);
	}

} // UnitLiteralImpl
