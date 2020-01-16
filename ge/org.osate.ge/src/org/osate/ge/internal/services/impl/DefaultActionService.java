/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
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

	private class DefaultActionGroup implements AgeAction, ActionGroup {
		private final String label;
		private final ExecutionMode mode;
		private final Set<Consumer<Runnable>> undoWrappers; // Consumers which will wrap the execution of the undo actions
		// Undo actions are the actions needed to undo the original action. Must be in the order
		// they were originally performed. An action group can be used for redoing as well. In that case, redo is treated as undoing the undo.
		private final List<AgeAction> undoActions;

		public DefaultActionGroup(final String label, final ExecutionMode mode) {
			this(label, mode, new HashSet<>(), new ArrayList<>());
		}

		public DefaultActionGroup(final String label, final ExecutionMode mode, final Set<Consumer<Runnable>> wrappers,
				List<AgeAction> actions) {
			this.label = Objects.requireNonNull(label, "label must not be null");
			this.mode = Objects.requireNonNull(mode, "mode must not be null");
			this.undoWrappers = Objects.requireNonNull(wrappers, "wrappers must not be null");
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
		public DefaultActionGroup execute() {
			return execute(undoWrappers.iterator());
		}

		private DefaultActionGroup execute(final Iterator<Consumer<Runnable>> it) {
			if(it.hasNext()) {
				final AtomicReference<DefaultActionGroup> result = new AtomicReference<>();
				final Consumer<Runnable> wrapper = it.next();
				wrapper.accept(() -> result.set(execute(it)));
				return result.get();
			} else {
				// Perform the actions in opposite order to undo
				final List<AgeAction> newUndoActions = Lists.reverse(undoActions).stream().sequential()
						.map(AgeAction::execute).filter(Objects::nonNull)
						.collect(Collectors.toCollection(ArrayList::new));

				return newUndoActions.size() == 0 ? null : new DefaultActionGroup(label, mode, undoWrappers, newUndoActions);
			}
		}

		@Override
		public boolean isValid() {
			return undoActions.stream().allMatch(AgeAction::isValid);
		}
	}

	private List<ActionStackChangeListener> changeListeners = new ArrayList<>();
	private DefaultActionGroup currentActionGroup; // Action group that is currently being built.
	private LinkedList<DefaultActionGroup> undoStack = new LinkedList<>();
	private LinkedList<DefaultActionGroup> redoStack = new LinkedList<>();

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
		return getUndoActionGroup().map(DefaultActionGroup::getLabel).orElse("");
	}

	@Override
	public synchronized boolean canUndo() {
		return getUndoActionGroup().map(DefaultActionGroup::canExecute).orElse(false);
	}

	@Override
	public synchronized void undo() {
		if (inUndoOrRedo) {
			throw new RuntimeException("Undo/Redo already in process");
		}

		try {
			inUndoOrRedo = true;
			final DefaultActionGroup undoAction = undoStack.pop();
			final DefaultActionGroup redoAction = undoAction.execute();

			if (redoAction != null) {
				pushToStack(redoStack, redoAction);
			}

			notifyChangeListeners();
		} finally {
			inUndoOrRedo = false;
		}
	}

	private Optional<DefaultActionGroup> getUndoActionGroup() {
		return undoStack.isEmpty() ? Optional.empty() : Optional.of(undoStack.peekFirst());
	}

	//
	// Redo
	//
	@Override
	public synchronized String getRedoLabel() {
		return getRedoActionGroup().map(DefaultActionGroup::getLabel).orElse("");
	}

	@Override
	public synchronized boolean canRedo() {
		return getRedoActionGroup().map(DefaultActionGroup::canExecute).orElse(false);
	}

	@Override
	public synchronized void redo() {
		if (inUndoOrRedo) {
			throw new RuntimeException("Undo/Redo already in process");
		}

		try {
			inUndoOrRedo = true;
			final DefaultActionGroup redoAction = redoStack.pop();
			final DefaultActionGroup undoAction = redoAction.execute();

			if (undoAction != null) {
				pushToStack(undoStack, undoAction);
			}

			notifyChangeListeners();
		} finally {
			inUndoOrRedo = false;
		}
	}

	private Optional<DefaultActionGroup> getRedoActionGroup() {
		return redoStack.isEmpty() ? Optional.empty() : Optional.of(redoStack.peekFirst());
	}

	@Override
	public synchronized void removeInvalidActions() {
		removeInvalidActions(undoStack);
		removeInvalidActions(redoStack);
		notifyChangeListeners();
	}

	private static void removeInvalidActions(final LinkedList<DefaultActionGroup> stack) {
		final Iterator<DefaultActionGroup> it = stack.iterator();
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
				final ActionGroup actionGroup = beginExecuteGroup(label, mode);

				try {
					// Run the runnable that is expected to call the executor to perform additional actions.
					execute(label, mode, action);
					return currentActionGroup.undoActions.size() > 0;
				} finally {
					endExecuteGroup(actionGroup);
				}
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

	@Override
	public synchronized ActionGroup beginExecuteGroup(final String label, ExecutionMode mode) {
		if (currentActionGroup == null) {
			currentActionGroup = new DefaultActionGroup(label, mode);
			return currentActionGroup;
		} else {
			return null;
		}
	}

	@Override
	public synchronized boolean endExecuteGroup(final ActionGroup actionGroup) {
		if (actionGroup != currentActionGroup) {
			return false;
		}

		try {
			return currentActionGroup.undoActions.size() > 0;
		} finally {
			// If the action group has reversible actions, add it to the action stack even if other actions threw an exception.
			if (currentActionGroup.undoActions.size() > 0) {
				ExecutionMode mode = currentActionGroup.mode;

				// Switch to hide mode if appropriate.
				if (mode == ExecutionMode.APPEND_ELSE_HIDE && undoStack.size() == 0) {
					mode = ExecutionMode.HIDE;
				}

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

				case HIDE:
					break;

				default:
					throw new RuntimeException("Unexpected case: " + mode);
				}

				notifyChangeListeners();
			}

			currentActionGroup = null;
		}

	}

	@Override
	public void addUndoWrapper(final Consumer<Runnable> wrapper) {
		Objects.requireNonNull(currentActionGroup, "An active action group is required");
		currentActionGroup.undoWrappers.add(wrapper);
	}

	private void notifyChangeListeners() {
		for (final ActionStackChangeListener listener : changeListeners) {
			listener.actionStackChanged();
		}
	}

	private static void pushToStack(final LinkedList<DefaultActionGroup> stack, final DefaultActionGroup actionGroup) {
		if (stack.size() == maxActionGroupsPerStack) {
			stack.removeLast();
		}

		stack.push(actionGroup);
	}
}
