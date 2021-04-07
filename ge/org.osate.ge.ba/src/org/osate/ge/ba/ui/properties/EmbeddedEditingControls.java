package org.osate.ge.ba.ui.properties;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

class EmbeddedEditingControls {
	private final Composite container;
	private StyledText styledText;
	private Button editBtn;
	private EmbeddedXtextAdapter xtextAdapter;

	EmbeddedEditingControls(final Composite container) {
		this.container = Objects.requireNonNull(container, "container cannot be null");
	}

	EmbeddedXtextAdapter getXtextAdapter() {
		return xtextAdapter;
	}

	void dispose() {
		if (xtextAdapter != null) {
			xtextAdapter.dispose();
		}

		disposeControls();
	}

	void disposeControls() {
		disposeControl(styledText);
		disposeControl(editBtn);
	}

	private void disposeControl(final Control control) {
		// Dispose widgets for next selection
		if (control != null && !control.isDisposed()) {
			control.dispose();
		}
	}

	/**
	 * Creates a uneditable styled text using the container's layout
	 */
	void createStyledText(final int style, final boolean isEnabled) {
		createStyledText(style, isEnabled, container.getLayoutData());
	}

	void createStyledText(final int style, final boolean isEnabled, final Object layoutData) {
		// Create styled text
		styledText = new StyledText(container, style);
		styledText.setEnabled(isEnabled);
		styledText.setEditable(false);
		styledText.setLayoutData(layoutData);
		styledText.setCaret(null);
	}

	StyledText getStyledText() {
		return styledText;
	}

	void createEditButton(final SelectionAdapter selectionAdapter, final boolean isEnabled) {
		editBtn = new Button(container, SWT.PUSH);
		editBtn.setText("Edit...");
		editBtn.setEnabled(isEnabled);
		editBtn.addSelectionListener(selectionAdapter);
	}

	Button getEditButton() {
		return editBtn;
	}

	void createXtextAdapter(final IProject project, final EmbeddedTextValue textValue) {
		xtextAdapter = new EmbeddedXtextAdapter(project, textValue);
		// Adapt without content helper
		xtextAdapter.adapt(styledText, false);
	}

	void requestLayout() {
		container.requestLayout();
	}
}
