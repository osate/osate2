package org.osate.ge.internal.util;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForUserInterface;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Helper class for invoking business object handler methods.
 * Only supports a subset of messages at this time.
 *
 */
public class BusinessObjectContextHelper implements AutoCloseable {
	private final IEclipseContext ctx;

	public BusinessObjectContextHelper(final ExtensionService extService) {
		this.ctx = Objects.requireNonNull(extService, "extService must not be null").createChildContext();
	}

	@Override
	public void close() {
		ctx.dispose();
	}

	/**
	 * Returns the name for the user interface provided by the business object handler. If it does not provide a name or provided null, then
	 * the label name is returned.
	 * @param boc
	 * @param boh
	 * @return
	 */
	public String getNameForUserInterface(final BusinessObjectContext boc, final Object boh) {
		try {
			updateContextArguments(boc);
			final String nameForUi = (String) ContextInjectionFactory.invoke(boh, GetNameForUserInterface.class, ctx,
					null);
			if (nameForUi != null) {
				return nameForUi;
			}
		} finally {
			clearContextArguments();
		}

		return getNameForLabel(boc, boh);
	}

	public String getNameForLabel(final BusinessObjectContext boc, final Object boh) {
		try {
			updateContextArguments(boc);
			return (String)ContextInjectionFactory.invoke(boh, GetName.class, ctx, null);
		} finally {
			clearContextArguments();
		}
	}

	public AgeGraphicalConfiguration getGraphicalConfiguration(final BusinessObjectContext boc, final Object boh) {
		try {
			updateContextArguments(boc);
			return (AgeGraphicalConfiguration)ContextInjectionFactory.invoke(boh, GetGraphicalConfiguration.class, ctx, null);
		} finally {
			clearContextArguments();
		}
	}

	private void updateContextArguments(final BusinessObjectContext boc) {
		Objects.requireNonNull(boc, "boc must not be null");
		ctx.set(Names.BUSINESS_OBJECT, boc.getBusinessObject());
		ctx.set(Names.BUSINESS_OBJECT_CONTEXT, boc);
	}

	private void clearContextArguments() {
		ctx.remove(Names.BUSINESS_OBJECT);
		ctx.remove(Names.BUSINESS_OBJECT_CONTEXT);
	}
}
