package org.osate.ge.internal.diagram.updating;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.GetDestination;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetSource;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.di.GetDefaultDockingPosition;
import org.osate.ge.internal.di.GetDefaultLabelConfiguration;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;

/**
 * DiagramElementInfoProvider implementation that uses business object handlers.
 *
 */
public class DefaultDiagramElementInfoProvider implements DiagramElementInfoProvider {
	private final static LabelConfiguration defaultLabelConfiguration = LabelConfigurationBuilder.create().build();	
	private final IEclipseContext baseCtx;
	private final IEclipseContext argCtx = EclipseContextFactory.create();
	
	public DefaultDiagramElementInfoProvider(final IEclipseContext baseCtx) {
		this.baseCtx = Objects.requireNonNull(baseCtx, "baseCtx must not be null");
	}
	
	@Override
	public Graphic getGraphic(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		try {
			updateArgumentContext(element);
			return Objects.requireNonNull((Graphic)ContextInjectionFactory.invoke(boh, GetGraphic.class, baseCtx, argCtx, null), "Unable to retrieve graphic using " + boh + ".");
		} finally {
			clearArgumentContext();
		}
	}

	@Override
	public DockingPosition getDefaultDockingPosition(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		try {
			updateArgumentContext(element);
			return Objects.requireNonNull((DockingPosition)ContextInjectionFactory.invoke(boh, GetDefaultDockingPosition.class, baseCtx, argCtx, DockingPosition.NOT_DOCKABLE), "Business object handler: " + boh + " returned a null docking position.");
		} finally {
			clearArgumentContext();
		}
	}

	@Override
	public AgeLabelConfiguration getDefaultLabelConfiguration(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		try {
			updateArgumentContext(element);
			return Objects.requireNonNull((AgeLabelConfiguration)ContextInjectionFactory.invoke(boh, GetDefaultLabelConfiguration.class, baseCtx, argCtx, defaultLabelConfiguration), "Business object handler: " + boh + " returned a null label configuration.");
		} finally {
			clearArgumentContext();
		}
	}

	@Override
	public DiagramElement getConnectionStart(final DiagramElement element) {
		try {
			updateArgumentContext(element);
			return (DiagramElement)ContextInjectionFactory.invoke(element.getBusinessObjectHandler(), GetSource.class, baseCtx, argCtx, null);
		} finally {
			clearArgumentContext();
		}
	}

	@Override
	public DiagramElement getConnectionEnd(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		try {
			updateArgumentContext(element);
			return (DiagramElement)ContextInjectionFactory.invoke(boh, GetDestination.class, baseCtx, argCtx, null);
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
}
