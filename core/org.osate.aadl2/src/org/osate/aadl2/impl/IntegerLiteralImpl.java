/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: IntegerLiteralImpl.java,v 1.15 2010-06-15 20:46:20 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.IntegerLiteralImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.IntegerLiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getIntegerLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public long getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(long newValue) {
		long oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.INTEGER_LITERAL__VALUE, oldValue, value));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (base: ");
		result.append(base);
		result.append(", value: ");
		result.append(value);
		result.append(')');
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
	@Override
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
	@Override
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
	@Override
	public final NumberValue cloneNumber() {
		final IntegerLiteral newVal = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		newVal.setLocationReference(getLocationReference());
		// Copy the unit information
		newVal.setUnit(getUnit());
		newVal.setBase(getBase());
		newVal.setValue(getValue());
		return newVal;
	}

	@Override
	public boolean sameAs(PropertyValue pv) {
		if (this == pv) {
			return true;
		}
		if (pv == null || getClass() != pv.getClass()) {
			return false;
		}
		IntegerLiteralImpl other = (IntegerLiteralImpl) pv;
		return base == other.base && value == other.value;
	}

} // IntegerLiteralImpl
