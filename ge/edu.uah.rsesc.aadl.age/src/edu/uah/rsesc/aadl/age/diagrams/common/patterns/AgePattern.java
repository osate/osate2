package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.Element;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;

/**
 * Base class for all shape patterns for AGE. Contains logic shared between all shape patterns.
 * @author philip.alldredge
 *
 */
public abstract class AgePattern extends AbstractPattern implements IPattern, ICustomUndoablePattern {
	public static final String chopboxAnchorName = "chopbox";
	
	public AgePattern() {
		super(null);
	}
	
	@Override
	protected boolean isPatternControlled(final PictogramElement pictogramElement) {
		final Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	protected boolean isPatternRoot(final PictogramElement pictogramElement) {
		final Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}
		
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
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
	
	@Override
	public boolean canRemove(final IRemoveContext context) {
		return false;
	}	
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return false;
	}
}
