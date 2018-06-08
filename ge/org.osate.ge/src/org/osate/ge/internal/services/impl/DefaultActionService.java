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

import com.google.common.collect.Lists;

public class DefaultActionService implements ActionService {
	// Maximum number of top level action groups in each stack
	private final static int maxActionGroupsPerStack = 50;

	public static class ContextFunction extends SimpleServiceContextFunction<ActionService> {
		@Override
		public ActionService createService(final IEclipseContext context) {
			return new DefaultActionService();
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

		@Override
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
	//
	// ActionExecutor
	//

	@Override
	public synchronized void execute(final AgeAction action) {
		if (inUndoOrRedo) {
			action.execute();
		} else {
			if (currentActionGroup == null) {
				executeGroup(action.getLabel(), () -> execute(action));
			} else {
				final AgeAction reverseAction = action.execute();

				// If the reverse action is null, then there is nothing to reverse.
				if (reverseAction != null) {
					currentActionGroup.undoActions.add(reverseAction);
				}
			}
		}
	}

	@Override
	public synchronized void executeGroup(final String label, final Runnable runnable) {
		if (inUndoOrRedo) {
			runnable.run();
		} else {
			ActionGroup newActionGroup = new ActionGroup(label);
			ActionGroup parentActionGroup = currentActionGroup;
			try {
				if (parentActionGroup == null) {
					currentActionGroup = newActionGroup;
				}

				// Run the runnable that is expected to call the executor to perform additional actions.
				runnable.run();

			} finally {
				if (currentActionGroup == newActionGroup) {
					if (newActionGroup.undoActions.size() > 0) {
						// Remove all actions that could be redone
						redoStack.clear();

						// Add to undo stack
						pushToStack(undoStack, newActionGroup);

						notifyChangeListeners();
					}

					currentActionGroup = null;
				} else if (parentActionGroup != null) {
					// Not top level
					if (newActionGroup.undoActions.size() > 0) {
						parentActionGroup.undoActions.add(newActionGroup);
					}
				} else {
					throw new RuntimeException("Unexpected case");
				}
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
