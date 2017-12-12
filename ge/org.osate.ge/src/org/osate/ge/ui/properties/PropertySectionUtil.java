package org.osate.ge.ui.properties;

import java.util.function.Predicate;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectContext;

public class PropertySectionUtil {
	public static boolean isBocCompatible(final Object toTest, final Predicate<BusinessObjectContext> predicate) {
		final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
		final Object bo = boc == null ? null : boc.getBusinessObject();
		return boc != null && (!(bo instanceof EObject) || !((EObject) bo).eIsProxy()) && predicate.test(boc);
	}

	public static boolean isBoCompatible(final Object toTest, final Predicate<Object> predicate) {
		final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
		final Object bo = boc == null ? null : boc.getBusinessObject();
		return bo != null && (!(bo instanceof EObject) || !((EObject) bo).eIsProxy())
				&& predicate.test(boc.getBusinessObject());
	}
}
