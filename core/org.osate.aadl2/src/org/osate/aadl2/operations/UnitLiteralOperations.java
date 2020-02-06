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

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.util.Aadl2Util;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Unit Literal</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.UnitLiteral#getAbsoluteFactor(org.osate.aadl2.UnitLiteral) <em>Get Absolute Factor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitLiteralOperations extends NamedElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitLiteralOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static double getAbsoluteFactor(UnitLiteral unitLiteral, UnitLiteral target) {
		double factor = 1.0;
		if (Aadl2Util.sameUnit(unitLiteral, target)) {
			return factor;
		}
		UnitLiteral current = unitLiteral;
		while (current.getBaseUnit() != null && !Aadl2Util.sameUnit(current.getBaseUnit(), current)) {
			double val = (current.getFactor() instanceof IntegerLiteral
					? (double) ((IntegerLiteral) current.getFactor()).getValue()
					: ((RealLiteral) current.getFactor()).getValue());
			factor *= val;
			current = current.getBaseUnit();
			if (Aadl2Util.sameUnit(current, target)) {
				return factor;
			}
		}
		// did not find target. Let's go in opposite direction
		factor = 1.0;
		current = target;
		while (current.getBaseUnit() != null && !Aadl2Util.sameUnit(current.getBaseUnit(), current)) {
			double val = (current.getFactor() instanceof IntegerLiteral
					? (double) ((IntegerLiteral) current.getFactor()).getValue()
					: ((RealLiteral) current.getFactor()).getValue());
			factor /= val;
			current = current.getBaseUnit();
			if (Aadl2Util.sameUnit(current, unitLiteral)) {
				return factor;
			}
		}
		return 1.0;
	}

	public static UnitLiteral getAbsoluteUnit(UnitLiteral lit) {
		if (lit == null) {
			return lit;
		}
		while (lit.getBaseUnit() != null) {
			lit = lit.getBaseUnit();
		}
		return lit;
	}

} // UnitLiteralOperations