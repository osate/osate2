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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.operations.NumberValueOperations;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RealLiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealLiteralImpl extends NumberValueImpl implements RealLiteral {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final double VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected double value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRealLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.REAL_LITERAL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.REAL_LITERAL__VALUE:
			return getValue();
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
		case Aadl2Package.REAL_LITERAL__VALUE:
			setValue((Double) newValue);
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
		case Aadl2Package.REAL_LITERAL__VALUE:
			setValue(VALUE_EDEFAULT);
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
		case Aadl2Package.REAL_LITERAL__VALUE:
			return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer();
		result.append(value);
		if (unit != null) {
			result.append(' ');
			result.append(unit.getName());
		}
		return result.toString();
	}

	/**
	 * @author dionisio
	 *
	 * set the value by parsing the string. 	 *
	 * @param s string with number to parse
	 */

	public void setValue(String s) {
		setValue(ParseUtil.parseAadlReal(s));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.NumberValue#cloneAndInvert()
	 */
	public NumberValue cloneAndInvert() {
		final RealLiteral newVal = Aadl2Factory.eINSTANCE.createRealLiteral();
		newVal.setLocationReference(getLocationReference());
		// Copy the unit information
		newVal.setUnit(getUnit());
		// invert the value
		newVal.setValue(-getValue());
		return newVal;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.NumberValue#cloneNumber()
	 */
	public final NumberValue cloneNumber() {
		final RealLiteral newVal = Aadl2Factory.eINSTANCE.createRealLiteral();
		newVal.setLocationReference(getLocationReference());
		// Copy the unit information
		newVal.setUnit(getUnit());
		newVal.setValue(getValue());
		return newVal;
	}

	public boolean sameAs(PropertyExpression pe) {
		if (this == pe) {
			return true;
		}
		if (pe == null || getClass() != pe.getClass()) {
			return false;
		}
		RealLiteralImpl other = (RealLiteralImpl) pe;

		final UnitLiteral myUnit = getUnit();
		final UnitLiteral otherUnit = other.getUnit();
		final UnitLiteral smallerUnit = NumberValueOperations.smallerUnit(myUnit, otherUnit);
		if (smallerUnit == null) { // no units at all
			return value == other.value;
		} else {
			/*
			 * Concerned about having problems due to floating point loosing precision, but so far
			 * things are okay.
			 */
			return NumberValueOperations.getScaledValue(this, smallerUnit) == NumberValueOperations
					.getScaledValue(other, smallerUnit);
		}
	}

} // RealLiteralImpl
