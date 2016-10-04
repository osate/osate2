/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.func.IDelete;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Element;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.PropertyService;

/**
 * Base class for all connection Patterns for AGE. Contains logic shared between all connection patterns.
 *
 */
public abstract class AgeConnectionPattern extends AbstractConnectionPattern implements IConnectionPattern, ICustomUndoablePattern, IUpdate, IDelete {
	private final ColoringService coloringService;
	private final GhostingService ghostingService;
	protected final ConnectionService connectionService;
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public AgeConnectionPattern(final ColoringService coloringService, final GhostingService ghostingService, final ConnectionService connectionService, 
			final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		this.coloringService = coloringService;
		this.ghostingService = ghostingService;
		this.connectionService = connectionService;
		this.propertyService = propertyService;
		this.bor = bor;
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext && isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		final Object bo = this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return context.getPictogramElement() instanceof Connection && isMainBusinessObjectApplicable(bo) && getAnchors((Connection)context.getPictogramElement()) != null;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createFalseReason();
	}
	
	@Override
	public boolean canUndo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void undo(final IFeature feature, final IContext context) {
	}

	@Override
	public boolean canRedo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void redo(final IFeature feature, final IContext context) {
	}
	
	protected Anchor[] getAnchors(Connection connection) {
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		final ContainerShape ownerShape = connectionService.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionService.getAnchors(ownerShape, bo);	
	}
	
	protected abstract boolean isMainBusinessObjectApplicable(final Object mainBusinessObject);
	
	protected abstract void createGraphicsAlgorithm(final Connection connection);
	protected abstract void createDecorators(final Connection connection);
	
	private void finishRefresh(final Connection connection) {
		propertyService.setIsLogicalTreeNode(connection, true);
		onAfterRefresh(connection);
	}
	
	/**
	 * Called after the connection has been initially created or updated.
	 * @param connection
	 */
	protected void onAfterRefresh(final Connection connection) {}
	
	/**
	 * Helper function that allows customizing the recreation of a graphics algorithm during updating. Needed
	 * to work around issue with generalizations
	 * @param connection
	 */
	protected void createGraphicsAlgorithmOnUpdate(final Connection connection)	{ 
		createGraphicsAlgorithm(connection);
	};
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final IAddConnectionContext addConContext = (IAddConnectionContext)context;
        final Object bo = AadlElementWrapper.unwrap(context.getNewObject());
        Graphiti.getPeCreateService();
        final Diagram diagram = getDiagram();
        
        // Create the connection
        final Connection connection = createConnection(diagram);
        link(connection, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);

        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        createGraphicsAlgorithm(connection);
        createDecorators(connection);
        coloringService.applyColoring(connection);
        finishRefresh(connection);
        
		return connection;
	}
	
	/**
	 * Called to create the connection object during the add process. Can be overridden to change the connection type, etc
	 * @param diagram
	 * @return
	 */
	protected Connection createConnection(final Diagram diagram) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		return peCreateService.createFreeFormConnection(diagram);
	}
	
	@Override
	public final boolean update(final IUpdateContext context) {
		// Rebuild the graphics algorithm and the decorators to ensure they are up to date
		final Connection connection = (Connection)context.getPictogramElement();
		final Anchor[] anchors = getAnchors(connection);

		if(anchors == null) {
			connection.setStart(null);
			connection.setEnd(null);
			ghostingService.setIsGhost(connection, true);
		}
		else {
			connection.setStart(anchors[0]);
			connection.setEnd(anchors[1]);
			ghostingService.setIsGhost(connection, false);
		
			createGraphicsAlgorithmOnUpdate(connection);
			createDecorators(connection);
			coloringService.applyColoring(connection);
			finishRefresh(connection);
		}
			
		return true;
	}
	
	// IDelete	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return false;
	}
	
	@Override
	public void preDelete(final IDeleteContext context) {	
	}	

	//@Override - Method added in Mars release of Graphiti. Annotation not included to maintain Luna compatibility.
	public boolean isDeleteAbort() {
		return false;
	}
	
	@Override
	public void delete(final IDeleteContext context) {		
	}
	
	@Override
	public void postDelete(final IDeleteContext context) {
	}
	
	public abstract boolean isPaletteApplicable();
}
