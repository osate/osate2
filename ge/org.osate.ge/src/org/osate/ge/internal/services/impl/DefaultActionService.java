package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.ChangeListener;

import com.google.common.collect.Lists;

/**
 * Implementation of the ActionService.
 *
 * If an action is executed while another action is running, then the action is grouped with the current action. When actions are
 * undone or redone, the behavior of the actions will not be interleaved. For this reason, it is recommended to not perform multiple actions
 * which provide a reverse action at the same time.
 *
 */
public class DefaultActionService implements ActionService {
	// Maximum number of top level action groups in each stack
	private final static int maxActionGroupsPerStack = 50;

	public static class ContextFunction extends SimpleServiceContextFunction<ActionService> {
		// Listener that will clear the action stack whenever the model is changed when the model is unlocked.
		private final ChangeListener modelChangeListener = new ChangeListener() {
			@Override
			public void modelChanged(boolean modelWasLocked) {
				final ActionService actionService = getService();
				if (actionService != null) {
					if (!modelWasLocked) {
						// Clear the action stack if the model was changed while it was not locked. This indicates that the graphical editor
						// did not perform the change and undo/redo actions could be invalid or unintentionally revert model changes.
						getService().clearActionStack();
					}
				}
			}
		};

		private ModelChangeNotifier modelChangeNotifier = null;

		@Override
		public ActionService createService(final IEclipseContext context) {
			final ActionService actionService = new DefaultActionService();

			// Register a change listener with the model change notifier. Ideally, the two would be completely decoupled but by making this part of the
			// context function, both are not explicitly coupled to one another.
			modelChangeNotifier = context.get(ModelChangeNotifier.class);
			if (modelChangeListener != null) {
				modelChangeNotifier.addChangeListener(modelChangeListener);
			}

			return actionService;
		}

		@Override
		protected void deactivate() {
			if (modelChangeNotifier != null) {
				modelChangeNotifier.removeChangeListener(modelChangeListener);
			}

			super.deactivate();
		}

	}

	private class ActionGroup implements AgeAction {
		private final String label;

		// Undo actions are the actions needed to undo the original action. Must be in the order
		// they were originally performed. An action group can be used for redoing as well. In that case, redo is treated as undoing the undo.
		private final List<AgeAction> undoActions;

		public ActionGroup(final String label) {
			this(label, new ArrayList<>());
		}

		public ActionGroup(final String label, List<AgeAction> actions) {
			this.label = Objects.requireNonNull(label, "label must not be null");
			this.undoActions = Objects.requireNonNull(actions, "actions must not be null");
		}

		public String getLabel() {
			return label;
		}

		@Override
		public boolean canExecute() {
			return undoActions.stream().allMatch(AgeAction::canExecute);
		}

		@Override
		public ActionGroup execute() {
			// Perform the actions in opposite order to undo
			final List<AgeAction> newUndoActions = Lists.reverse(undoActions).stream().sequential().map(AgeAction::execute)
					.filter(Objects::nonNull)
					.collect(Collectors.toCollection(ArrayList::new));

			return newUndoActions.size() == 0 ? null : new ActionGroup(label, newUndoActions);
		}

		@Override
		public boolean isValid() {
			return undoActions.stream().allMatch(AgeAction::isValid);
		}
	}

	private List<ActionStackChangeListener> changeListeners = new ArrayList<>();
	private ActionGroup currentActionGroup; // Action group that is currently being built.
	private LinkedList<ActionGroup> undoStack = new LinkedList<>();
	private LinkedList<ActionGroup> redoStack = new LinkedList<>();

	// Flag which indicates that an undo or redo is currently being performed.
	private boolean inUndoOrRedo = false;

	@Override
	public synchronized void addChangeListener(ActionStackChangeListener listener) {
		changeListeners.add(listener);
	}

	@Override
	public synchronized void removeChangeListener(ActionStackChangeListener listener) {
		changeListeners.remove(listener);
	}

	@Override
	public boolean isActionExecuting() {
		return currentActionGroup != null || inUndoOrRedo;
	}

	//
	// Undo
	//

	@Override
	public synchronized String getUndoLabel() {
		return getUndoActionGroup().map(ActionGroup::getLabel).orElse("");
	}


	@Override
	public synchronized boolean canUndo() {
		return getUndoActionGroup().map(ActionGroup::canExecute).orElse(false);
	}

	@Override
	public synchronized void undo() {
		if (inUndoOrRedo) {
			throw new RuntimeException("Undo/Redo already in process");
		}

		try {
			inUndoOrRedo = true;
			final ActionGroup undoAction = undoStack.pop();
			final ActionGroup redoAction = undoAction.execute();

			if (redoAction != null) {
				pushToStack(redoStack, redoAction);
			}

			notifyChangeListeners();
		} finally {
			inUndoOrRedo = false;
		}
	}

	private Optional<ActionGroup> getUndoActionGroup() {
		return undoStack.isEmpty() ? Optional.empty() : Optional.of(undoStack.peekFirst());
	}

	//
	// Redo
	//
	@Override
	public synchronized String getRedoLabel() {
		return getRedoActionGroup().map(ActionGroup::getLabel).orElse("");
	}

	@Override
	public synchronized boolean canRedo() {
		return getRedoActionGroup().map(ActionGroup::canExecute).orElse(false);
	}

	@Override
	public synchronized void redo() {
		if (inUndoOrRedo) {
			throw new RuntimeException("Undo/Redo already in process");
		}

		try {
			inUndoOrRedo = true;
			final ActionGroup redoAction = redoStack.pop();
			final ActionGroup undoAction = redoAction.execute();

			if (undoAction != null) {
				pushToStack(undoStack, undoAction);
			}

			notifyChangeListeners();
		} finally {
			inUndoOrRedo = false;
		}
	}

	private Optional<ActionGroup> getRedoActionGroup() {
		return redoStack.isEmpty() ? Optional.empty() : Optional.of(redoStack.peekFirst());
	}

	@Override
	public synchronized void removeInvalidActions() {
		removeInvalidActions(undoStack);
		removeInvalidActions(redoStack);
		notifyChangeListeners();
	}

	private static void removeInvalidActions(final LinkedList<ActionGroup> stack) {
		final Iterator<ActionGroup> it = stack.iterator();
		while (it.hasNext()) {
			if (!it.next().isValid()) {
				it.remove();
				break;
			}
		}

		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	@Override
	public synchronized void clearActionStack() {
		undoStack.clear();
		redoStack.clear();
		notifyChangeListeners();
	}

	//
	// ActionExecutor
	//

	@Override
	public synchronized boolean execute(final String label, final ExecutionMode mode, final AgeAction action) {
		if (inUndoOrRedo) {
			return action.execute() != null;
		} else {
			if (currentActionGroup == null) {
				return executeGroup(label, mode, () -> execute(label, mode, action));
			} else {
				final AgeAction reverseAction = action.execute();

				// If the reverse action is null, then there is nothing to reverse.
				if (reverseAction != null) {
					currentActionGroup.undoActions.add(reverseAction);
				}

				return reverseAction != null;
			}
		}
	}

	/**
	 * Executes a group of actions.
	 * @param label
	 * @param mode
	 * @param runnable
	 * @return
	 */
	private boolean executeGroup(final String label, ExecutionMode mode, final Runnable runnable) {
		if (inUndoOrRedo) {
			runnable.run();
			return false;
		} else {
			currentActionGroup = new ActionGroup(label);
			try {
				// Run the runnable that is expected to call the executor to perform additional actions.
				runnable.run();

				return currentActionGroup.undoActions.size() > 0;
			} finally {
				// If the action group has reversible actions, add it to the action stack even if other actions threw an exception.
				if (currentActionGroup.undoActions.size() > 0) {
					// Hide append actions if there isn't an action to which to append.
					boolean hide = mode == ExecutionMode.APPEND_ELSE_HIDE && undoStack.size() == 0;
					if (!hide) {
						switch (mode) {
						case NORMAL:
							// Remove all actions that could be redone
							redoStack.clear();

							// Add to undo stack
							pushToStack(undoStack, currentActionGroup);
							break;

						case APPEND_ELSE_HIDE:
							undoStack.peekFirst().undoActions.add(currentActionGroup);
							break;

						default:
							throw new RuntimeException("Unexpected case: " + mode);
						}

						notifyChangeListeners();
					}
				}

				currentActionGroup = null;
			}
		}
	}

	private void notifyChangeListeners() {
		for (final ActionStackChangeListener listener : changeListeners) {
			listener.actionStackChanged();
		}
	}

	private static void pushToStack(final LinkedList<ActionGroup> stack, final ActionGroup actionGroup) {
		if (stack.size() == maxActionGroupsPerStack) {
			stack.removeLast();
		}

		stack.push(actionGroup);
	}
}
