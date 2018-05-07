package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.emf.common.command.Command;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

/**
 * Custom feature for wrapping EMF commands into a Graphiti feature. Using the command stack directly can cause problems due to how Graphiti handles undo and redo.
 *
 */
public class EmfCommandCustomFeature extends AbstractCustomFeature implements ICustomUndoRedoFeature
{
	private final Command cmd;

	public EmfCommandCustomFeature(final Command cmd,
			final IFeatureProvider fp) {
		super(fp);
		this.cmd = Objects.requireNonNull(cmd, "cmd must not be null");
	}

	public Object getCommand() {
		return cmd;
	}

	@Override
	public String getName() {
		return cmd.getLabel();
	}

	@Override
	public boolean isAvailable(final IContext context) {
		return true;
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return cmd.canExecute();
	}

	@Override
	public void execute(final ICustomContext context) {
		cmd.execute();
	}

	@Override
	public boolean canUndo(final IContext context) {
		return cmd.canUndo();
	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}

	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
		cmd.undo();
	}

	@Override
	public boolean canRedo(IContext context) {
		return cmd.canExecute();
	}

	@Override
	public void preRedo(IContext context) {

	}

	@Override
	public void postRedo(IContext context) {
		cmd.redo();
	}
}
