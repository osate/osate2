package org.osate.ge.diagrams.common.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.HandleDoubleClick;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.ge.services.ExtensionService;

// ICustomFeature implementation that delegates behavior to a pictogram handler's double click functionality
public class PictogramHandlerDoubleClickFeature extends AbstractCustomFeature {
	private final ExtensionService extService;
	private final PictogramElementService peService;
	private final Object handler;
	
	public PictogramHandlerDoubleClickFeature(final ExtensionService extService, final PictogramElementService peService, final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.peService = Objects.requireNonNull(peService, "peService must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}

	public boolean canExecute(final ICustomContext context) {
		return true;
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			final PictogramElement pe = context.getPictogramElements()[0];
			eclipseCtx.set(Names.PICTOGRAM_ELEMENT, pe);
			eclipseCtx.set(Names.BUSINESS_OBJECT, peService.getBusinessObject(pe));

			// Call the double-click handler method
			ContextInjectionFactory.invoke(handler, HandleDoubleClick.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}

}
