package org.osate.ge.internal.graphiti.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class UpdateDiagramCustomFeature extends AbstractCustomFeature implements ICustomUndoRedoFeature {
	@Inject
	public UpdateDiagramCustomFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Update Diagram";
	}

	@Override
	public String getDescription() {
		return "Updates the diagram";
	}

	@Override
	public boolean isAvailable(final IContext context) {
		return true;
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}

	@Override
	public void execute(final ICustomContext context) {
		getFeatureProvider().updateIfPossible(UpdateDiagramFeature.createUpdateContext(getDiagram(), true));
	}

	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}

	@Override
	public void preUndo(final IContext context) {
	}

	@Override
	public void postUndo(final IContext context) {
	}

	@Override
	public boolean canRedo(final IContext context) {
		return false;
	}

	@Override
	public void preRedo(final IContext context) {
	}

	@Override
	public void postRedo(final IContext context) {
	}
}
