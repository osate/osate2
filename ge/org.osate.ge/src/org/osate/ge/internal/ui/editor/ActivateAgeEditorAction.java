package org.osate.ge.internal.ui.editor;

import java.lang.ref.WeakReference;
import java.util.Objects;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchSite;
import org.osate.ge.internal.services.AgeAction;

/**
 * Action which activates the referenced editor. Returns itself as the undo action.
 *
 */
class ActivateAgeEditorAction implements AgeAction {
	private WeakReference<AgeDiagramEditor> weakEditor;

	public ActivateAgeEditorAction(final AgeDiagramEditor editor) {
		this.weakEditor = new WeakReference<>(Objects.requireNonNull(editor, "editor must not be null"));
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

		return this;
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
