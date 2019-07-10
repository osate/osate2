/**
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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