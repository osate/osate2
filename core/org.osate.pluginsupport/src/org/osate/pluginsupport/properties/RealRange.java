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

import static org.osate.pluginsupport.properties.CodeGenUtil.resolveNamedValue;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;

/**
 * @since 5.0
 */
public class RealRange {
	/**
	 * @since 7.0
	 */
	public static final RealRange ZEROED = new RealRange(0.0, 0.0, 0.0);

	private final double minimum;
	private final double maximum;
	private final OptionalDouble delta;

	public RealRange(double minimum, double maximum) {
		this(minimum, maximum, OptionalDouble.empty());
	}

	public RealRange(double minimum, double maximum, double delta) {
		this(minimum, maximum, OptionalDouble.of(delta));
	}

	public RealRange(double minimum, double maximum, OptionalDouble delta) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.delta = delta;
	}

	/**
	 * This constructor is meant only to be called by generated Java property getters when looking up the value of a
	 * property.
	 */
	public RealRange(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((RealLiteral) resolveNamedValue(rangeValue.getMinimum(), lookupContext, mode)).getValue();
		maximum = ((RealLiteral) resolveNamedValue(rangeValue.getMaximum(), lookupContext, mode)).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalDouble.empty();
		} else {
			PropertyExpression resolvedDelta = resolveNamedValue(rangeValue.getDelta(), lookupContext, mode);
			delta = OptionalDouble.of(((RealLiteral) resolvedDelta).getValue());
		}
	}

	/**
	 * This constructor is meant only to be called by generated Java property getters when looking up the value of a
	 * property constant.
	 *
	 * @since 7.1
	 */
	public RealRange(PropertyExpression propertyExpression) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = ((RealLiteral) resolveNamedValue(rangeValue.getMinimum())).getValue();
		maximum = ((RealLiteral) resolveNamedValue(rangeValue.getMaximum())).getValue();
		if (rangeValue.getDelta() == null) {
			delta = OptionalDouble.empty();
		} else {
			delta = OptionalDouble.of(((RealLiteral) resolveNamedValue(rangeValue.getDelta())).getValue());
		}
	}

	public double getMinimum() {
		return minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public OptionalDouble getDelta() {
		return delta;
	}

	public RangeValue toPropertyExpression() {
		RangeValue rangeValue = Aadl2Factory.eINSTANCE.createRangeValue();

		RealLiteral minimumValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		minimumValue.setValue(minimum);
		rangeValue.setMinimum(minimumValue);

		RealLiteral maximumValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		maximumValue.setValue(maximum);
		rangeValue.setMaximum(maximumValue);

		delta.ifPresent(delta -> {
			RealLiteral deltaValue = Aadl2Factory.eINSTANCE.createRealLiteral();
			deltaValue.setValue(delta);
			rangeValue.setDelta(deltaValue);
		});

		return rangeValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(minimum, maximum, delta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RealRange)) {
			return false;
		}
		RealRange other = (RealRange) obj;
		return Double.doubleToLongBits(minimum) == Double.doubleToLongBits(other.minimum)
				&& Double.doubleToLongBits(maximum) == Double.doubleToLongBits(other.maximum)
				&& Objects.equals(delta, other.delta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
		delta.ifPresent(it -> builder.append(" delta " + it));
		return builder.toString();
	}
}