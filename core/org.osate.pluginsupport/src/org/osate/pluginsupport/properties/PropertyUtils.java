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

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;

import org.osate.aadl2.NamedElement;

/**
 * @since 7.0
 */
public final class PropertyUtils {
	private PropertyUtils() {
		// Utility class
	}

	/**
	 * Given an optional {@link Scalable} value, return an optional that scales the value to the given unit.
	 *
	 * @param <U> The enumeration type of the unit.
	 * @param value The optional {@link Scalable} value
	 * @param unit The unit to scale the value to.
	 * @return An {@link Optional} containing the scaled value if the original value exists; {@link Optional#empty()} otherwise.
	 */
	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<Double> scale(
			final Optional<? extends Scalable<U>> value,
			final U unit) {
		return value.map(rwu -> rwu.getValue(unit));
	}

	/**
	 * Get the value of a property association whose type is {@link IntegerWithUnits} or {@link RealWithUnits}, and
	 * scale the value to the given unit.
	 *
	 * @param <U> The enumeration type of the unit.
	 * @param getProperty The handle of a generated property getter function.
	 * @param ne The element to get the property association from.
	 * @param unit The unit to scale the associated property value to.
	 * @return An {@link Optional} containing the scaled property value if the property association exists; {@link Optional#empty()} otherwise.
	 */
	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<Double> getScaled(
			final Function<NamedElement, Optional<? extends Scalable<U>>> getProperty, final NamedElement ne, final U unit) {
		return scale(getProperty.apply(ne), unit);
	}

	/**
	 * Given a {@link IntegerRangeWithUnits} or {@link RealRangeWithUnits}, use a unitless {@link RealRange} to return the range scaled to the given unit.
	 *
	 * @param <U> The enumeration type of the unit.
	 * @param rangeWithUnits The range with units value to scale.
	 * @param unit The unit to scale the associated property value to.
	 * @return A {@link RealRange} containing the scaled range.  If the optional delta is present in the original,
	 * it is scaled, otherwise the delta is equal to {@link OptionalDouble#empty()}.
	 */
	public static <U extends Enum<U> & GeneratedUnits<U>> RealRange scaleRange(
			final RangeWithUnits<U, ? extends Scalable<U>> rangeWithUnits, final U unit) {
		final double min = rangeWithUnits.getMinimum().getValue(unit);
		final double max = rangeWithUnits.getMaximum().getValue(unit);
		final OptionalDouble delta = rangeWithUnits.getDelta().map(d -> OptionalDouble.of(d.getValue(unit)))
				.orElse(OptionalDouble.empty());
		return new RealRange(min, max, delta);
	}

	/**
	 * Given an Optional {@link IntegerRangeWithUnits} or {@link RealRangeWithUnits}, return an optional that may contain a unitless {@link RealRange} to return the range scaled to the given unit.
	 *
	 * @param <U> The enumeration type of the unit.
	 * @param rangeWithUnits The optional range with units value to scale.
	 * @param unit The unit to scale the associated property value to.
	 * @return An optional {@link RealRange} containing the scaled range.  If the optional delta is present in the original,
	 * it is scaled, otherwise the delta is equal to {@link OptionalDouble#empty()}.  If the original optional is empty, then the returned
	 * optional is empty.
	 */
	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<RealRange> scaleRange(
			final Optional<? extends RangeWithUnits<U, ? extends Scalable<U>>> rangeWithUnits, final U unit) {
		return rangeWithUnits.map(range -> scaleRange(range, unit));
	}

	/**
	 * Get the value of a property association whose type is {@link IntegerRangeWithUnits} or {@link RealRangeWithUnits}, and
	 * scale the range to the given unit using {@link #scaleRange(RangeWithUnits, Enum)}.
	 *
	 * @param <U> The enumeration type of the unit.
	 * @param getProperty The handle of a generated property getter function.
	 * @param ne The element to get the property association from.
	 * @param unit The unit to scale the associated property value to.
	 * @return An {@link Optional} containing the scaled range property value if the property association exists; {@link Optional#empty()} otherwise.
	 */
	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<RealRange> getScaledRange(
			final Function<NamedElement, Optional<? extends RangeWithUnits<U, ? extends Scalable<U>>>> getProperty,
			final NamedElement ne, final U unit) {
		return scaleRange(getProperty.apply(ne), unit);
	}

	/**
	 * Returns whether the Optional value equals the given value.
	 *
	 * @param <V> The type of the property value.
	 * @param optValue The optional to test
	 * @param value The value to test against.
	 * @param orElse The value return if the optional has no value.
	 *
	 * @return {@code true} if the optional value exists and the value {@link #equals(Object)} {@code value};
	 * the value of {@code orElse} if the optional does not exist.
	 */
	public static <V> boolean equals(final Optional<V> optValue, final V value, final boolean orElse) {
		return optValue.map(x -> x.equals(value)).orElse(orElse);
	}

	/**
	 * Returns whether the property value associated with the given element, if present, equals the given value.
	 *
	 * @param <V> The type of the property value.
	 * @param getProperty The handle of a generated property getter function.
	 * @param ne The element to get the property association from.
	 * @param value The value to test against.
	 *
	 * @return {@code true} if the property association exists and the value {@link #equals(Object)} {@code value}.
	 * If the property association doesn't exist then the value {@code false} is returned.
	 */
	public static <V> boolean propertyEquals(final Function<NamedElement, Optional<V>> getProperty,
			final NamedElement ne,
			final V value) {
		return equals(getProperty.apply(ne), value, false);
	}

}
