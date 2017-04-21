package org.osate.ge.internal.diagram.updating;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.services.ReferenceService;

/**
 * DiagramElementGraphicalConfigurationProvider implementation that uses business object handlers.
 *
 */
public class DefaultDiagramElementGraphicalConfigurationProvider implements DiagramElementInformationProvider {
	private final BusinessObjectHandlerProvider bohProvider;
	private final IEclipseContext baseCtx;
	private final IEclipseContext argCtx = EclipseContextFactory.create();
	
	public DefaultDiagramElementGraphicalConfigurationProvider(final ReferenceService refService,
			final BusinessObjectHandlerProvider bohProvider,
			final IEclipseContext baseCtx) {
		this.bohProvider = Objects.requireNonNull(bohProvider, "bohProvider must not be null");
		this.baseCtx = Objects.requireNonNull(baseCtx, "baseCtx must not be null");
	}
	
	@Override
	public String getName(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		try {
			updateArgumentContext(element);
	    	return (String)ContextInjectionFactory.invoke(boh, GetName.class, baseCtx, argCtx, null);
		} finally {
			clearArgumentContext();
		}
	}
	
	@Override
	public AgeGraphicalConfiguration getGraphicalConfiguration(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		try {
			updateArgumentContext(element);
			return Objects.requireNonNull((AgeGraphicalConfiguration)ContextInjectionFactory.invoke(boh, GetGraphicalConfiguration.class, baseCtx, argCtx, null), "Unable to retrieve graphical configuration using " + boh + ".");
		} finally {
			clearArgumentContext();
		}
	}
	
	private void updateArgumentContext(final DiagramElement element) {
		Objects.requireNonNull(element, "element must not be null");
		argCtx.set(Names.BUSINESS_OBJECT, element.getBusinessObject());
		argCtx.set(Names.BUSINESS_OBJECT_CONTEXT, element);
	}
	
	private void clearArgumentContext() {
		argCtx.remove(Names.BUSINESS_OBJECT);
		argCtx.remove(Names.BUSINESS_OBJECT_CONTEXT);
	}

	@Override
	public Object getApplicableBusinessObjectHandler(final Object bo) {
		return bohProvider.getApplicableBusinessObjectHandler(bo);
	}
}
