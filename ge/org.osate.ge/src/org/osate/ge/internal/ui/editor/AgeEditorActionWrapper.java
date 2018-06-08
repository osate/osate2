package org.osate.ge.internal.ui.editor;

import java.lang.ref.WeakReference;
import java.util.Objects;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchSite;
import org.osate.ge.internal.services.AgeAction;

/**
 * Wrapper action that activates the referenced editor before executing the underlying action.
 *
 */
class AgeEditorActionWrapper implements AgeAction {
	private AgeAction action;
	private WeakReference<AgeDiagramEditor> weakEditor;

	public AgeEditorActionWrapper(final AgeAction action, final AgeDiagramEditor editor) {
		this.action = Objects.requireNonNull(action, "action must not be null");
		this.weakEditor = new WeakReference<>(Objects.requireNonNull(editor, "editor must not be null"));
	}

	@Override
	public String getLabel() {
		return action.getLabel();
	}

	@Override
	public boolean canExecute() {
		return action.canExecute();
	}

	@Override
	public AgeAction execute() {
		// Activate the stored editor
		final AgeDiagramEditor editor = weakEditor.get();
		if (editor != null) {
			final IWorkbenchSite site = editor.getSite();
			if (site != null) {
				final IWorkbenchPage page = site.getPage();
				if (page != null) {
					page.activate(editor);
				}
			}
		}

		// Create a wrapper for the reverse action
		final AgeAction reverseAction = action.execute();
		return reverseAction == null ? null : new AgeEditorActionWrapper(reverseAction, editor);
	}

	@Override
	public boolean isValid() {
		final AgeDiagramEditor editor = weakEditor.get();
		if (editor == null) {
			return false;
		}

		if (editor.isDisposed()) {
			return false;
		}

		return true;
	}
}
