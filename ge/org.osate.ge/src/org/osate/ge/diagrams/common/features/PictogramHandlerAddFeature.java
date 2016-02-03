package org.osate.ge.diagrams.common.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.Categorized;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanCreate;
import org.osate.ge.ext.annotations.CreateBusinessObject;
import org.osate.ge.ext.annotations.GetCreateOwningBusinessObject;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.annotations.RefreshGraphics;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

// IAddFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerAddFeature extends AbstractAddFeature {
	private final BusinessObjectResolutionService bor; // TODO: Remove if not needed
	private final ExtensionService extService;
	private final GhostingService ghostingService; 
	private final Object handler;
	
	public PictogramHandlerAddFeature(final BusinessObjectResolutionService bor, final ExtensionService extService, final GhostingService ghostingService, final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		// Assumes that the feature was created after checking if the pictogram handler handles the context
		return true;
	}
	
	@Override
	public PictogramElement add(final IAddContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.CONTAINER, context.getTargetContainer());
			eclipseCtx.set(Names.PICTOGRAM_ELEMENT, null);
			eclipseCtx.set(Names.BUSINESS_OBJECT, AadlElementWrapper.unwrap(context.getNewObject()));
			
			final PictogramElement pe = (PictogramElement)ContextInjectionFactory.invoke(handler, RefreshShape.class, eclipseCtx, null);
			
			if(pe != null) {
				eclipseCtx.set(Names.PICTOGRAM_ELEMENT, pe);
				getFeatureProvider().link(pe, context.getNewObject());
				ghostingService.setIsGhost(pe, false);
				
				// Refresh Graphics Algorithm
				ContextInjectionFactory.invoke(handler, RefreshGraphics.class, eclipseCtx, null);
			}
			
			return pe;
		} finally {
			eclipseCtx.dispose();
		}
	}
}
