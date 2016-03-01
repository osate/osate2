package org.osate.ge.diagrams.common.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.annotations.RefreshGraphics;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.ReferenceBuilderService;

// IUpdateFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerUpdateFeature extends AbstractUpdateFeature implements ICustomUndoRedoFeature {
	private final ExtensionService extService;
	private final ReferenceBuilderService refBuilder;
	private final GhostingService ghostingService;
	private final PictogramElementService peService;
	private final Object handler;
	
	public PictogramHandlerUpdateFeature(final ExtensionService extService, final ReferenceBuilderService refBuilder, final GhostingService ghostingService, final PictogramElementService peService, final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
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
	public IReason updateNeeded(final IUpdateContext context) {
		if(context.getPictogramElement() instanceof Diagram) {
			return Reason.createTrueReason();
		} else {
			return Reason.createFalseReason();
		}
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
		
		// Special handling for diagrams
		final boolean isDiagram = pe instanceof Diagram;
		if(isDiagram) {
			// Update the diagram's name
			final Diagram diagram = (Diagram)pe;
			final String newTitle = refBuilder.getTitle(bo);
			if(newTitle != null) {
				diagram.setName(newTitle);
			}
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
			if(pe instanceof ContainerShape) {
				ghostingService.ghostChildren((ContainerShape)pe);
			}
			
			ContextInjectionFactory.invoke(handler, RefreshShape.class, eclipseCtx, null);
			
			// Refresh Graphics Algorithm
			if(!isDiagram) {
				ContextInjectionFactory.invoke(handler, RefreshGraphics.class, eclipseCtx, null);
			}
			
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
	
	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
