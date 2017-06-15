package org.osate.ge.internal.util;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Helper class for invoking business object providers.
 *
 */
public class BusinessObjectProviderHelper implements AutoCloseable {
	private final ExtensionService extService;
	private final IEclipseContext ctx;
	
	public BusinessObjectProviderHelper(final ExtensionService extService) {
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ctx = extService.createChildContext();
	}
	
	@Override
	public void close() {
		ctx.dispose();
	}
	
	/**
	 * Returns the business objects from all the business object providers for the specified business object context.
	 * @param boc
	 * @return
	 */
	public Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc) {
		try {
			updateContextArguments(boc);
			
			// Use business object providers to determine the children
			Stream<Object> allChildren = Stream.empty();
			for(final Object bop : extService.getBusinessObjectProviders()) {
				final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(bop, Activate.class, ctx, null);
				if(childBos != null) {
					allChildren = Stream.concat(allChildren, childBos);
				}
			};
			
		
			return allChildren.distinct().collect(Collectors.toList());
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
