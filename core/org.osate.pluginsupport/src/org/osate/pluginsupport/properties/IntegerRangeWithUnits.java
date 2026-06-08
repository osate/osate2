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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;

/**
 * @since 5.0
 */
public class IntegerRangeWithUnits<U extends Enum<U> & GeneratedUnits<U>>
		implements RangeWithUnits<U, IntegerWithUnits<U>> {
	private final IntegerWithUnits<U> minimum;
	private final IntegerWithUnits<U> maximum;
	private final Optional<IntegerWithUnits<U>> delta;

	public IntegerRangeWithUnits(IntegerWithUnits<U> minimum, IntegerWithUnits<U> maximum) {
		this(minimum, maximum, Optional.empty());
	}

	public IntegerRangeWithUnits(IntegerWithUnits<U> minimum, IntegerWithUnits<U> maximum, IntegerWithUnits<U> delta) {
		this(minimum, maximum, Optional.of(delta));
	}

	public IntegerRangeWithUnits(IntegerWithUnits<U> minimum, IntegerWithUnits<U> maximum,
			Optional<IntegerWithUnits<U>> delta) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.delta = delta;
	}

	/**
	 * This constructor is meant only to be called by generated Java property getters when looking up the value of a
	 * property.
	 */
	public IntegerRangeWithUnits(PropertyExpression propertyExpression, Class<U> unitsType,
			NamedElement lookupContext, Optional<Mode> mode) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new IntegerWithUnits<>(resolveNamedValue(rangeValue.getMinimum(), lookupContext, mode), unitsType);
		maximum = new IntegerWithUnits<>(resolveNamedValue(rangeValue.getMaximum(), lookupContext, mode), unitsType);
		delta = Optional.ofNullable(resolveNamedValue(rangeValue.getDelta(), lookupContext, mode))
				.map(it -> new IntegerWithUnits<>(it, unitsType));
	}

	/**
	 * This constructor is meant only to be called by generated Java property getters when looking up the value of a
	 * property constant.
	 *
	 * @since 7.1
	 */
	public IntegerRangeWithUnits(PropertyExpression propertyExpression, Class<U> unitsType) {
		RangeValue rangeValue = (RangeValue) propertyExpression;
		minimum = new IntegerWithUnits<>(resolveNamedValue(rangeValue.getMinimum()), unitsType);
		maximum = new IntegerWithUnits<>(resolveNamedValue(rangeValue.getMaximum()), unitsType);
		delta = Optional.ofNullable(resolveNamedValue(rangeValue.getDelta()))
				.map(it -> new IntegerWithUnits<>(it, unitsType));
	}

	@Override
	public IntegerWithUnits<U> getMinimum() {
		return minimum;
	}

	@Override
	public IntegerWithUnits<U> getMaximum() {
		return maximum;
	}

	@Override
	public Optional<IntegerWithUnits<U>> getDelta() {
		return delta;
	}

	public RangeValue toPropertyExpression(ResourceSet resourceSet) {
		RangeValue rangeValue = Aadl2Factory.eINSTANCE.createRangeValue();
		rangeValue.setMinimum(minimum.toPropertyExpression(resourceSet));
		rangeValue.setMaximum(maximum.toPropertyExpression(resourceSet));
		delta.ifPresent(delta -> rangeValue.setDelta(delta.toPropertyExpression(resourceSet)));
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
		if (!(obj instanceof IntegerRangeWithUnits)) {
			return false;
		}
		IntegerRangeWithUnits<?> other = (IntegerRangeWithUnits<?>) obj;
		return Objects.equals(minimum, other.minimum) && Objects.equals(maximum, other.maximum)
				&& Objects.equals(delta, other.delta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(minimum + " .. " + maximum);
		delta.ifPresent(it -> builder.append(" delta " + it));
		return builder.toString();
	}
}