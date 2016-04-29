package org.osate.ge.internal.features;

import java.lang.reflect.Method;
import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;

// ICustomFeature implementation that delegates behavior to a pictogram handler's double click functionality
public class PictogramHandlerDoubleClickFeature extends AbstractCustomFeature {
	private final ExtensionService extService;
	private final BusinessObjectResolutionService bor;
	
	public PictogramHandlerDoubleClickFeature(final ExtensionService extService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
	}

	public boolean canExecute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		if(pe instanceof Diagram) {
			return false;			
		}
		
		final Object pictogramHandler = extService.getApplicablePictogramHandler(bor.getBusinessObjectForPictogramElement(pe));
		if(pictogramHandler != null) {
			for(final Method m : pictogramHandler.getClass().getMethods()) {
				if(m.isAnnotationPresent(HandleDoubleClick.class)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final PictogramElement pe = context.getPictogramElements()[0];
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final Object pictogramHandler = extService.getApplicablePictogramHandler(bo);
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
			
			// Call the double-click handler method
			ContextInjectionFactory.invoke(pictogramHandler, HandleDoubleClick.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}

}
