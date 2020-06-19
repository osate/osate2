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
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.operations.NumberValueOperations;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.IntegerLiteralImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.IntegerLiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegerLiteralImpl extends NumberValueImpl implements IntegerLiteral {
	/**
	 * The default value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected static final long BASE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected long base = BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final long VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected long value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getIntegerLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(long newBase) {
		long oldBase = base;
		base = newBase;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.INTEGER_LITERAL__BASE, oldBase, base));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(long newValue) {
		long oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.INTEGER_LITERAL__VALUE, oldValue,
					value));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.INTEGER_LITERAL__BASE:
			return getBase();
		case Aadl2Package.INTEGER_LITERAL__VALUE:
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
		case Aadl2Package.INTEGER_LITERAL__BASE:
			setBase((Long) newValue);
			return;
		case Aadl2Package.INTEGER_LITERAL__VALUE:
			setValue((Long) newValue);
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
		case Aadl2Package.INTEGER_LITERAL__BASE:
			setBase(BASE_EDEFAULT);
			return;
		case Aadl2Package.INTEGER_LITERAL__VALUE:
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
		case Aadl2Package.INTEGER_LITERAL__BASE:
			return base != BASE_EDEFAULT;
		case Aadl2Package.INTEGER_LITERAL__VALUE:
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
	 * set the value by parsing the string. This can contain the a base part and an exponent
	 * e.g. "base#number#exponent" as well as underscore separators, e.g. "12_345"
	 *
	 * @param s string with number to parse
	 */
	public static int parseInt(String s) {
		// first remove all the underscores
		int underscorePosition = s.indexOf('_');
		while (underscorePosition != -1) {
			s = s.substring(0, underscorePosition) + s.substring(underscorePosition + 1, s.length());
			underscorePosition = s.indexOf('_');
		}

		int base = 10; // default base
		int exponent = 0; // default exponent
		int number = 0;
		// do we have base?
		int firstHashPosition = s.indexOf('#');
		if (firstHashPosition != -1) {
			// parse base
			String strBase = s.substring(0, firstHashPosition);
			base = Integer.parseInt(strBase);

			// parse number
			s = s.substring(firstHashPosition + 1, s.length());
			firstHashPosition = s.indexOf('#');
			String strNumber = s.substring(0, firstHashPosition);
			number = Integer.parseInt(strNumber, base);

			// parse exponent
			if (firstHashPosition < s.length() - 1) {
				s = s.substring(firstHashPosition + 1, s.length());

				// substring from 1 to skip the 'e' of the exponent
				String strExponent = s.substring(1, s.length());
				exponent = Integer.parseInt(strExponent);

				// apply the exponent
				number = (int) (number * Math.pow(10, exponent));
			}
		} else {
			number = Integer.parseInt(s);
		}
		return number;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.NumberValue#setValue(java.lang.String)
	 */
	public void setValue(String s) {
		long[] res = ParseUtil.parseAadlInteger(s);
		Long.valueOf(res[1]);
		setBase(Long.valueOf(res[0]));
		setValue(Long.valueOf(res[1]));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.NumberValue#cloneAndInvert()
	 */
	public NumberValue cloneAndInvert() {
		final IntegerLiteral newVal = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		newVal.setLocationReference(getLocationReference());
		// Copy the unit information
		newVal.setUnit(getUnit());
		// copy base information
		newVal.setBase(getBase());
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
		final IntegerLiteral newVal = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		newVal.setLocationReference(getLocationReference());
		// Copy the unit information
		newVal.setUnit(getUnit());
		newVal.setBase(getBase());
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
		IntegerLiteralImpl other = (IntegerLiteralImpl) pe;

		// N.B. the `base` attribute of IntegerLiteral doesn't seem to be used
		final UnitLiteral myUnit = getUnit();
		final UnitLiteral otherUnit = other.getUnit();
		final UnitLiteral smallerUnit = NumberValueOperations.smallerUnit(myUnit, otherUnit);
		if (smallerUnit == null) { // no units at all
			return value == other.value;
		} else {
			return NumberValueOperations.getScaledValue(this, smallerUnit) == NumberValueOperations
					.getScaledValue(other, smallerUnit);
		}
	}

} // IntegerLiteralImpl
