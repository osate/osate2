/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.pluginsupport.properties;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;

/**
 * @since 5.0
 */
public class RealWithUnits<U extends Enum<U> & GeneratedUnits<U>> implements Scalable<U>, Comparable<RealWithUnits<U>> {
	private final double value;
	private final U unit;

	public RealWithUnits(double value, U unit) {
		this.value = value;
		this.unit = unit;
	}

	public RealWithUnits(PropertyExpression propertyExpression, Class<U> unitsType) {
		RealLiteral numberValue = (RealLiteral) propertyExpression;
		value = numberValue.getValue();
		unit = Enum.valueOf(unitsType, numberValue.getUnit().getName().toUpperCase());
	}

	public double getValue() {
		return value;
	}

	public U getUnit() {
		return unit;
	}

	@Override
	public double getValue(U targetUnit) {
		return value * unit.getFactorToBase() / targetUnit.getFactorToBase();
	}

	public RealLiteral toPropertyExpression(ResourceSet resourceSet) {
		RealLiteral numberValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		numberValue.setValue(value);
		numberValue.setUnit(unit.toUnitLiteral(resourceSet));
		return numberValue;
	}

	@Override
	public int hashCode() {
		return Double.hashCode(value * unit.getFactorToBase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RealWithUnits)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		RealWithUnits<U> other = (RealWithUnits<U>) obj;
		if (!unit.getClass().equals(other.unit.getClass())) {
			return false;
		}
		if (unit == other.unit) {
			return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
		} else {
			return compareTo(other) == 0;
		}
	}

	@Override
	public int compareTo(RealWithUnits<U> o) {
		return Double.compare(value * unit.getFactorToBase(), o.value * o.unit.getFactorToBase());
	}

	@Override
	public String toString() {
		return value + unit.toString();
	}
}