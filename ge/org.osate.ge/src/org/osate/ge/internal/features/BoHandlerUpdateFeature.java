package org.osate.ge.internal.features;

import java.util.Objects;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;

// IUpdateFeature implementation that delegates behavior to a business object handler
public class BoHandlerUpdateFeature extends AbstractUpdateFeature implements ICustomUndoRedoFeature {
	public static final String nameShapeName = "name";
	private final InternalReferenceBuilderService refBuilder;
	private final BusinessObjectResolutionService bor;
	private final ConnectionService connectionService;
	private final BoRefreshHelper refreshHelper;
	private final Object handler;
	
	public BoHandlerUpdateFeature(final InternalReferenceBuilderService refBuilder, final BusinessObjectResolutionService bor, final ConnectionService connectionService,
			final BoRefreshHelper refreshHelper, final IFeatureProvider fp, final Object boHandler) {
		super(fp);
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.connectionService = Objects.requireNonNull(connectionService, "connectionService must not be null");
		this.refreshHelper = Objects.requireNonNull(refreshHelper, "refreshHelper must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		// Assumes that the feature was created after checking if the business object handler handles the context
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
	public boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		if(pe.getGraphicsAlgorithm() == null) {
			return false;
		}
			
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(bo == null) {
			return false;
		}
		
		// Store the current position of the graphics algorithm
		final int x = pe.getGraphicsAlgorithm().getX();
		final int y = pe.getGraphicsAlgorithm().getY();
		
		// Determine the source and destination anchors for connections
		final Anchor srcAnchor, dstAnchor;
		if(pe instanceof Connection) {
			final ContainerShape ownerShape = connectionService.getOwnerShape((Connection)pe);
			final Anchor[] anchors = ownerShape == null ? null : connectionService.getAnchors(ownerShape, bo);	
			srcAnchor = anchors == null ? null : anchors[0];
			dstAnchor = anchors == null ? null : anchors[1];
		} else {
			srcAnchor = null;
			dstAnchor = null;
		}
		
		refreshHelper.refresh(bo, handler, pe, x, y, null, srcAnchor, dstAnchor);
		
		// Special handling for diagrams
		if(pe instanceof Diagram) {
			// Update the diagram's name
			final Diagram diagram = (Diagram)pe;
			final String newTitle = refBuilder.getTitle(bo);
			if(newTitle != null) {
				diagram.setName(newTitle);
			}
			
			// Adjust positions of shapes that have not been positioned.
			final ICustomContext layoutCtx = LayoutDiagramFeature.createContext(false);
			for(ICustomFeature feature : this.getFeatureProvider().getCustomFeatures(layoutCtx)) {
				if(feature instanceof LayoutDiagramFeature) {
					feature.execute(layoutCtx);
					break;
				}
			}
		}

		return true;
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
