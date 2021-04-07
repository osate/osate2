package org.osate.ge.ba.ui.properties;

import java.util.Stack;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class UndoRedoHelper extends KeyAdapter implements ExtendedModifyListener {
	private static class UndoRedoStack {
		private final static int MAX_STACK_SIZE = 50;
		private final Stack<ExtendedModifyEvent> undo;
		private final Stack<ExtendedModifyEvent> redo;

		public UndoRedoStack() {
			undo = new Stack<ExtendedModifyEvent>();
			redo = new Stack<ExtendedModifyEvent>();
		}

		public void pushUndo(final ExtendedModifyEvent undoEvent) {
			if (undo.size() > MAX_STACK_SIZE) {
				undo.remove(0);
			}
			undo.add(undoEvent);
		}

		public void pushRedo(final ExtendedModifyEvent redoEvent) {
			if (redo.size() > MAX_STACK_SIZE) {
				redo.remove(0);
			}
			redo.add(redoEvent);
		}

		public ExtendedModifyEvent popUndo() {
			return undo.pop();
		}

		public ExtendedModifyEvent popRedo() {
			return redo.pop();
		}

		public void clearRedo() {
			redo.clear();
		}

		public boolean hasUndo() {
			return !undo.isEmpty();
		}

		public boolean hasRedo() {
			return !redo.isEmpty();
		}
	}

	private final StyledText styledText;
	private final UndoRedoStack undoRedoStack;
	private boolean isUndo;
	private boolean isRedo;

	UndoRedoHelper(final StyledText styledText) {
		this.styledText = styledText;
		styledText.addKeyListener(this);
		styledText.addExtendedModifyListener(this);
		undoRedoStack = new UndoRedoStack();
	}

	@Override
	public void keyPressed(final KeyEvent event) {
		// Listen for editing keys
		final boolean isCtrl = (event.stateMask & SWT.CTRL) == SWT.CTRL;
		final boolean isAlt = (event.stateMask & SWT.ALT) == SWT.ALT;
		final boolean isShift = (event.stateMask & SWT.SHIFT) == SWT.SHIFT;

		if (isCtrl && !isAlt && !isShift) {
			final int keyCode = event.keyCode;
			if (keyCode == 'z') {
				undo();
			} else if (keyCode == 'y') {
				redo();
			}
		}
	}

	/**
	 * Creates a corresponding Undo or Redo step from the given event and pushes
	 * it to the stack. The Redo stack is emptied if the event comes
	 * from key input.
	 */
	@Override
	public void modifyText(final ExtendedModifyEvent event) {
		if (isUndo) {
			undoRedoStack.pushRedo(event);
		} else { // is redo or key input
			undoRedoStack.pushUndo(event);
			if (!isRedo) {
				undoRedoStack.clearRedo();
			}
		}
	}

	private void undo() {
		if (undoRedoStack.hasUndo()) {
			isUndo = true;
			revertEvent(undoRedoStack.popUndo());
			isUndo = false;
		}
	}

	private void redo() {
		if (undoRedoStack.hasRedo()) {
			isRedo = true;
			revertEvent(undoRedoStack.popRedo());
			isRedo = false;
		}
	}

	/**
	 * Reverts the given modify event
	 */
	private void revertEvent(final ExtendedModifyEvent event) {
		styledText.replaceTextRange(event.start, event.length, event.replacedText);
		styledText.setSelectionRange(event.start, event.replacedText.length());
	}
}