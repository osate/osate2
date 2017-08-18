package org.osate.ge.internal.ui.properties;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Adapters;
import org.osate.ge.BusinessObjectContext;

public class PropertySectionUtil {
	public static boolean isBocCompatible(final Object toTest, final Predicate<BusinessObjectContext> predicate) {
		final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
		return boc != null && predicate.test(boc);
	}

	public static boolean isBoCompatible(final Object toTest, final Predicate<Object> predicate) {
		final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
		return boc != null && predicate.test(boc.getBusinessObject());
	}

	/**
	 * Returns the value provided by the specified function if it is the equal for all elements in the stream.
	 * @param f
	 * @return
	 */
	public static <A, T> Optional<T> resultIfAllEqual(final Stream<A> stream, final Function<A, T> f) {
		return stream.map(f).map(e -> Optional.ofNullable(e)).reduce(Optional.empty(), (e1, e2) -> {
			if (e1.isPresent() && e2.isPresent() && Objects.equals(e1.get(), e2.get())) {
				return e1;
			} else {
				return Optional.empty();
			}
		});
	}
}
