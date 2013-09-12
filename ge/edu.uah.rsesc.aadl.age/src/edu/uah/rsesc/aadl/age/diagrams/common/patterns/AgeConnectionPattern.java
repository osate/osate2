package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.osate.aadl2.ModeTransition;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;

/**
 * Base class for all connection Patterns for AGE. Contains logic shared between all connection patterns.
 * @author philip.alldredge
 *
 */
public abstract class AgeConnectionPattern extends AbstractConnectionPattern implements IConnectionPattern, ICustomUndoablePattern, IUpdate {
	public abstract boolean isMainBusinessObjectApplicable(final Object mainBusinessObject);
	
	@Override
	public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext && isMainBusinessObjectApplicable(context.getNewObject());
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
	protected void onAfterUpdate(final Connection connection) {}
	
	/**
	 * Helper function that allows customizing the recreation of a graphics algorithm during updating. Needed
	 * to work around issue with generalizations
	 * @param connection
	 */
	protected void createGraphicsAlgorithmOnUpdate(final Connection connection)	{ 
		createGraphicsAlgorithm(connection);
	};
	
	@Override
	public boolean update(final IUpdateContext context) {
		// Rebuild the graphics algorithm and the decorators to ensure they are up to date
		final Connection connection = (Connection)context.getPictogramElement();
		final Anchor[] anchors = getAnchors(connection);

		// Update anchors
		if(anchors == null) {
			connection.setStart(null);
			connection.setEnd(null);
			EcoreUtil.remove(connection);
		}
		else {
			connection.setStart(anchors[0]);
			connection.setEnd(anchors[1]);
			UpdateHelper.updateVisibility(connection);
			
			createGraphicsAlgorithmOnUpdate(connection);
			createDecorators(connection);
			onAfterUpdate(connection);
		}
		
		return true;
	}
}
