package org.osate.ge.ui.properties;

import java.util.function.Predicate;

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
}
