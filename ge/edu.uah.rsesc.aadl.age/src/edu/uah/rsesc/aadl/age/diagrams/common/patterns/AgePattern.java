package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;
import org.eclipse.graphiti.pattern.IPattern;

/**
 * Base class for all shape patterns for AGE. Contains logic shared between all shape patterns.
 * @author philip.alldredge
 *
 */
public abstract class AgePattern extends AbstractPattern implements IPattern, ICustomUndoablePattern {
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
}
