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
	 * Get the value of a property association whose type is {@link IntegerWithUnits} or {@link RealWithUnits}, and
	 * scale the value to the given unit.
	 *
	 * @param <U> The enumeration type of the unit.
	 * @param getProperty The handle of a generated property getter function.
	 * @param ne The element to get the property association from.
	 * @param unit The unit to scale the associated property value to.
	 * @return An {@link Optional} containing the scale property value if the property association exists; {@link Optional#empty()} otherwise.
	 */
	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<Double> getScaled(
			final Function<NamedElement, Optional<? extends Scalable<U>>> getProperty, final NamedElement ne, final U unit) {
		return scale(getProperty.apply(ne), unit);
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

	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<RealRange> scaleRange(
			final Optional<? extends RangeWithUnits<U, ? extends Scalable<U>>> rangeWithUnits, final U unit) {
		return rangeWithUnits.map(range -> scaleRange(range, unit));
	}

	/**
	 * Given a {@link IntegerRangeWithUnits} or {@link RealRangeWithUnits}, use a unitless {@link RealRange} to return the range scaled to the given unit.
	 *
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

	public static <U extends Enum<U> & GeneratedUnits<U>> Optional<Double> scale(
			final Optional<? extends Scalable<U>> value,
			final U unit) {
		return value.map(rwu -> rwu.getValue(unit));
	}

	public static <U extends Enum<U> & GeneratedUnits<U>, T extends Scalable<U>, R extends RangeWithUnits<U, T>> Optional<Double> getScaled(
			final Function<NamedElement, Optional<R>> getProperty, final NamedElement ne, final Function<R, T> f2, final U unit) {
		return getProperty.apply(ne).map(rrwu -> f2.apply(rrwu).getValue(unit));
	}

}
