package org.osate.ge.diagrams.common.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.Categorized;
import org.osate.ge.ext.ExtensionPaletteEntry;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanCreate;
import org.osate.ge.ext.annotations.CreateBusinessObject;
import org.osate.ge.ext.annotations.GetCreateOwningBusinessObject;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.annotations.RefreshGraphics;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

// IUpdateFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerUpdateFeature extends AbstractUpdateFeature {
	private final ExtensionService extService;
	private final GhostingService ghostingService;
	private final PictogramElementService peService;
	private final Object handler;
	
	public PictogramHandlerUpdateFeature(final ExtensionService extService, final GhostingService ghostingService, final PictogramElementService peService, final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.peService = Objects.requireNonNull(peService, "peService must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		// Assumes that the feature was created after checking if the pictogram handler handles the context
		return true;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createFalseReason();
	}

	@Override
	public boolean update(IUpdateContext context) {
		// TODO: Support connections
		final PictogramElement pe = context.getPictogramElement();
		final Shape container = ((Shape)pe).getContainer();
		final Object bo = peService.getBusinessObject(pe);
		
		if(pe.getGraphicsAlgorithm() == null) {
			return false;
		}
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			// Store the current position of the graphics algorithm
			final int x = pe.getGraphicsAlgorithm().getX();
			final int y = pe.getGraphicsAlgorithm().getY();
			
			// Assign  variables to context
			eclipseCtx.set(Names.CONTAINER, container);
			eclipseCtx.set(Names.PICTOGRAM_ELEMENT, pe);
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);

			// Unghost
			ghostingService.setIsGhost(pe, false);
			
			// Update Link
			getFeatureProvider().link(pe, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
			
			// Refresh the children
			ContextInjectionFactory.invoke(handler, RefreshShape.class, eclipseCtx, null);
			
			// Refresh Graphics Algorithm
			ContextInjectionFactory.invoke(handler, RefreshGraphics.class, eclipseCtx, null);
			
			// Set the position of the refreshed graphics algorithm
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if(ga != null) {
				ga.setX(x);
				ga.setY(y);
			}

			return true;
		} finally {
			eclipseCtx.dispose();
		}
	}
}
