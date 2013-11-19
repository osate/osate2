package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Element;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

/**
 * Base class for all connection Patterns for AGE. Contains logic shared between all connection patterns.
 * @author philip.alldredge
 *
 */
public abstract class AgeConnectionPattern extends AbstractConnectionPattern implements IConnectionPattern, ICustomUndoablePattern, IUpdate, IDelete {
	public abstract boolean isMainBusinessObjectApplicable(final Object mainBusinessObject);
	private final VisibilityService visibilityHelper;
	
	@Inject
	public AgeConnectionPattern(final VisibilityService visibilityHelper) {
		this.visibilityHelper = visibilityHelper;
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext && isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		final Object bo = this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return context.getPictogramElement() instanceof Connection && isMainBusinessObjectApplicable(bo);
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
	
	protected abstract Anchor[] getAnchors(Connection connection);
	protected abstract void createGraphicsAlgorithm(final Connection connection);
	protected abstract void createDecorators(final Connection connection);
	
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
        final Element element = (Element)AadlElementWrapper.unwrap(context.getNewObject());
        Graphiti.getPeCreateService();
        final Diagram diagram = getDiagram();
        
        // Create the connection
        final Connection connection = createConnection(diagram);
        link(connection, new AadlElementWrapper(element));

        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        createGraphicsAlgorithm(connection);
        createDecorators(connection);
        onAfterRefresh(connection);
        
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

		// Update anchors
		if(anchors == null) {
			connection.setStart(null);
			connection.setEnd(null);
			visibilityHelper.setIsGhost(connection, true);
		}
		else {
			connection.setStart(anchors[0]);
			connection.setEnd(anchors[1]);
			visibilityHelper.setIsGhost(connection, false);

			createGraphicsAlgorithmOnUpdate(connection);
			createDecorators(connection);
			onAfterRefresh(connection);
		}
		
		return true;
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return false;
	}
	
	@Override
	public void preDelete(final IDeleteContext context) {	
	}	
	
	@Override
	public void delete(final IDeleteContext context) {		
	}
	
	@Override
	public void postDelete(final IDeleteContext context) {
	}
}
