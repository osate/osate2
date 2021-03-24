package org.osate.ge.ba.ui.properties;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

class EmbeddedEditingControls {
	private final Composite container;
	private StyledText styledText;
	private Button saveBtn;
	private OsateEmbeddedXtextAdapter xtextAdapter;

	EmbeddedEditingControls(final Composite container) {
		this.container = Objects.requireNonNull(container, "container cannot be null");
	}

	OsateEmbeddedXtextAdapter getXtextAdapter() {
		return xtextAdapter;
	}

	void dispose() {
		if (xtextAdapter != null) {
			xtextAdapter.dispose();
		}

		disposeControl(styledText);
		disposeControl(saveBtn);
	}

	private void disposeControl(final Control control) {
		// Dispose widgets for next selection
		if (control != null && !control.isDisposed()) {
			control.dispose();
		}
	}

	/**
	 * Creates a styled text using the container's layout with the specified style and key adapter
	 */
	void createStyledText(final int style, final boolean isEnabled, final KeyAdapter keyAdapter) {
		createStyledText(style, isEnabled, container.getLayoutData(), keyAdapter);
	}

	void createStyledText(final int style, final boolean isEnabled, final Object layoutData,
			final KeyAdapter keyAdapter) {
		// Create styled text
		styledText = new StyledText(container, style);
		styledText.setEnabled(isEnabled);
		styledText.setLayoutData(layoutData);
		styledText.addKeyListener(keyAdapter);
	}

	StyledText getStyledText() {
		return styledText;
	}

	void createSaveButton(final SelectionAdapter adapter) {
		saveBtn = new Button(container, SWT.PUSH);
		saveBtn.setText("Save");
		saveBtn.setEnabled(false);
		saveBtn.addSelectionListener(adapter);
	}

	Button getSaveButton() {
		return saveBtn;
	}

	void updateAdapterDocument(final TextValue val) {
		final XtextDocument xtextDoc = xtextAdapter.getXtextDocument();
		final SourceViewer srcViewer = xtextAdapter.getSourceviewer();
		xtextDoc.set(val.getWholeText());
		srcViewer.setDocument(xtextDoc, srcViewer.getAnnotationModel(), val.getEditableTextOffset(),
				val.getEditableText().length());
	}

	void setXtextAdapter(final IProject project) {
		if (xtextAdapter != null) {
			xtextAdapter.dispose();
		}

		xtextAdapter = new OsateEmbeddedXtextAdapter(project);
		xtextAdapter.adapt(styledText);
	}

	void requestLayout() {
		container.requestLayout();
	}

	void setModificationState(final String modifiedSrc) {
		saveBtn.setEnabled(modifiedSrc == null ? false : true);
		xtextAdapter.setModifiedSource(modifiedSrc);
	}
}
