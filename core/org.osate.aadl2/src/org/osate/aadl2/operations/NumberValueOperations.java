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
package org.osate.aadl2.operations;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Number Value</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.NumberValue#getScaledValue(org.osate.aadl2.UnitLiteral) <em>Get Scaled Value</em>}</li>
 *   <li>{@link org.osate.aadl2.NumberValue#getScaledValue() <em>Get Scaled Value</em>}</li>
 *   <li>{@link org.osate.aadl2.NumberValue#getScaledValue(java.lang.String) <em>Get Scaled Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumberValueOperations extends ElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberValueOperations() {
		super();
	}

	private static double getValue(final NumberValue numberValue) {
		if (numberValue instanceof RealLiteral) {
			return ((RealLiteral) numberValue).getValue();
		}

		return ((IntegerLiteral) numberValue).getValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static double getScaledValue(NumberValue numberValue, UnitLiteral target) {
		final double value = getValue(numberValue);
		final UnitLiteral unit = numberValue.getUnit();
		final double factor = (unit == null) ? 1.0 : unit.getAbsoluteFactor(target);

		return value * factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static double getScaledValue(NumberValue numberValue) {
		final double value = getValue(numberValue);
		final UnitLiteral unit = numberValue.getUnit();
		final double factor = (unit == null) ? 1.0 : unit.getAbsoluteFactor();

		return value * factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static double getScaledValue(NumberValue numberValue, String target) {
		final UnitLiteral currentUnit = numberValue.getUnit();
		final UnitLiteral targetUnit;

		if (currentUnit == null) {
			targetUnit = null;
		} else {
			targetUnit = ((UnitsType) currentUnit.eContainer()).findLiteral(target);
		}

		return getScaledValue(numberValue, targetUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	// copied from org.osate.alisa.common.typing.InterpreterUtil
	public static UnitLiteral smallerUnit(UnitLiteral unit1, UnitLiteral unit2) {
		if (unit1 == null || unit2 == null) {
			return null;
		} else if (unit1 == unit2) {
			return unit1;
		} else {
			RealLiteral tester = Aadl2Factory.eINSTANCE.createRealLiteral();
			tester.setValue(1.0);
			tester.setUnit(unit1);
			if (tester.getScaledValue(unit2) < 1.0) {
				return unit1;
			} else {
				return unit2;
			}
		}
	}

} // NumberValueOperations