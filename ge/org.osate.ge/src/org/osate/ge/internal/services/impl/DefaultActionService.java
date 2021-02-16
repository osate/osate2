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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.UndoContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.PlatformUI;
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
	public static final IUndoContext CONTEXT = new UndoContext();
	private final IOperationHistory history = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();

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
		// Undo actions are the actions needed to undo the original action. Must be in the order
		// they were originally performed. An action group can be used for redoing as well. In that case, redo is treated as undoing the undo.
		private final List<AgeAction> undoActions;

		public DefaultActionGroup(final String label, final ExecutionMode mode) {
			this(label, mode, new ArrayList<>());
		}

		public DefaultActionGroup(final String label, final ExecutionMode mode, final List<AgeAction> actions) {
			this.label = Objects.requireNonNull(label, "label must not be null");
			this.mode = Objects.requireNonNull(mode, "mode must not be null");
			this.undoActions = Objects.requireNonNull(actions, "actions must not be null");
		}

		@Override
		public boolean canExecute() {
			return isValid() && undoActions.stream().allMatch(AgeAction::canExecute);
		}

		@Override
		public DefaultActionGroup execute() {
			// Perform the actions in opposite order to undo
			final List<AgeAction> newUndoActions = Lists.reverse(undoActions).stream().sequential()
					.map(AgeAction::execute).filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));

			return newUndoActions.size() == 0 ? null : new DefaultActionGroup(label, mode, newUndoActions);
		}

		@Override
		public boolean isValid() {
			return undoActions.stream().allMatch(AgeAction::isValid);
		}
	}

	private class AgeUndoableOperation extends AbstractOperation {
		DefaultActionGroup actionGroup;

		public AgeUndoableOperation(final DefaultActionGroup actionGroup) {
			super(actionGroup.label);
			this.actionGroup = actionGroup;
			addContext(CONTEXT);
		}

		@Override
		public boolean canExecute() {
			return false;
		}

		@Override
		public IStatus execute(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
			// Shouldn't be called
			return Status.OK_STATUS;
		}

		@Override
		public boolean canUndo() {
			return actionGroup != null && actionGroup.canExecute();
		}

		@Override
		public IStatus undo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
			try {
				inUndoOrRedo = true;
				actionGroup = actionGroup.execute(); // Swap the action to redo. Undo should not be called twice without calling redo first.
				return Status.OK_STATUS;
			} finally {
				inUndoOrRedo = false;
			}
		}

		@Override
		public boolean canRedo() {
			return actionGroup != null && actionGroup.canExecute();
		}

		@Override
		public IStatus redo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
			try {
				inUndoOrRedo = true;
				actionGroup = actionGroup.execute(); // Swap the action to undo. Redo should not be called twice without calling undo first.
				return Status.OK_STATUS;
			} finally {
				inUndoOrRedo = false;
			}
		}

		// Invalidates the operation
		void invalidate() {
			if (actionGroup != null) {
				actionGroup = null;
				history.operationChanged(this);
			}
		}
	};

	private DefaultActionGroup currentActionGroup; // Action group that is currently being built.

	// Flag which indicates that an undo or redo is currently being performed.
	private boolean inUndoOrRedo = false;

	@Override
	public boolean isActionExecuting() {
		return currentActionGroup != null || inUndoOrRedo;
	}

	@Override
	public synchronized void invalidateInvalidActions() {
		invalidateInvalidActions(history.getUndoHistory(CONTEXT));
		invalidateInvalidActions(history.getRedoHistory(CONTEXT));
	}

	private static void invalidateInvalidActions(final IUndoableOperation[] ops) {
		boolean invalidFound = false;
		for (int i = ops.length - 1; i >= 0; i--) {
			if (ops[i] instanceof AgeUndoableOperation) {
				final AgeUndoableOperation op = (AgeUndoableOperation) ops[i];
				if (op.actionGroup != null && (invalidFound || !op.actionGroup.isValid())) {
					op.invalidate();
					invalidFound = true; // Invalidate remaining
				}
			}
		}
	}

	@Override
	public synchronized void clearActionStack() {
		history.dispose(CONTEXT, true, true, false);
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

				switch (mode) {
				case NORMAL:
					history.add(new AgeUndoableOperation(currentActionGroup));
					break;

				case APPEND_ELSE_HIDE:
					// Ignore if there isn't at least one operation on the undo stack
					final IUndoableOperation[] undoHistory = history.getUndoHistory(CONTEXT);
					if (undoHistory.length > 0) {
						final IUndoableOperation lastOp = undoHistory[undoHistory.length - 1];
						if (lastOp instanceof AgeUndoableOperation) {
							final AgeUndoableOperation last = (AgeUndoableOperation) lastOp;
							last.actionGroup.undoActions.add(currentActionGroup);

						}
					}

					break;

				case HIDE:
					break;

				default:
					throw new RuntimeException("Unexpected case: " + mode);
				}
			}

			currentActionGroup = null;
		}

	}
}
