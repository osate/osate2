package org.osate.ge.ui.properties;

import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.operations.Operation;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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

	/**
	 * Executes an operation in a context which is not associated with a diagram. As such, elements are not added to the diagram based on the hints provided by the step results.
	 * @param operation
	 */
	public static void execute(final Operation operation) {
		if (operation != null) {
			final OperationExecutor operationExecutor = new OperationExecutor(getAadlModificationService());
			operationExecutor.execute(operation, (results) -> {
			});
		}
	};

	private static AadlModificationService getAadlModificationService() {
		final Bundle bundle = FrameworkUtil.getBundle(PropertySectionUtil.class);
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		return Objects.requireNonNull(context.getActive(AadlModificationService.class),
				"Unable to retrieve AADL modification service");
	}
}
