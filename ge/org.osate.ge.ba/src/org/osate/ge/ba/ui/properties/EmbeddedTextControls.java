package org.osate.ge.ba.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.SwtUtil;

public class EmbeddedTextControls extends Composite {
	private StyledText styledText;
	private Button btn;
	private EmbeddedXtextAdapter xtextAdapter;
	private final int styledTextStyle;
	private final GridData styledTextLayoutData;

	public EmbeddedTextControls(final Composite parent, final int style, final int styledTextStyle,
			final GridData styledTextLayoutData) {
		super(parent, style);
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		this.styledTextStyle = styledTextStyle;
		this.styledTextLayoutData = styledTextLayoutData;
	}

	public void refresh() {
		// Create styled text
		styledText = new StyledText(this, styledTextStyle);
		styledText.setEditable(false);
		// Set empty caret so that the caret will not show.
		// Makes sure users know it is not editable.
		// Note: If caret is set to null, exception may occur
		// when used with the StyledTextXtextAdapter.
		final Caret emptyCaret = new Caret(getShell(), SWT.NONE);
		styledText.setCaret(emptyCaret);
		styledText.setLayoutData(styledTextLayoutData);
		styledText.addDisposeListener(e -> emptyCaret.dispose());

		btn = new Button(this, SWT.PUSH);
		btn.setText("Edit...");
	}

	public void setStyledTextTestId(final String id) {
		SwtUtil.setTestingId(styledText, id);
	}

	public void setButtonTestId(final String id) {
		SwtUtil.setTestingId(btn, id);
	}

	public void createXtextAdapter(final IProject project, final EmbeddedTextValue textValue) {
		disposeXtextAdapter();
		xtextAdapter = new EmbeddedXtextAdapter(project, textValue);
		// Adapt without content helper
		xtextAdapter.adapt(styledText, false);
	}

	public void disposeControls() {
		disposeXtextAdapter();
		disposeControl(styledText);
		disposeControl(btn);
	}

	private void disposeXtextAdapter() {
		if (xtextAdapter != null) {
			xtextAdapter.dispose();
			xtextAdapter = null;
		}
	}

	private void disposeControl(final Control control) {
		if (control != null && !control.isDisposed()) {
			// Dispose widgets for next selection
			control.dispose();
		}
	}

	public void addSelectionListener(final SelectionAdapter selectionAdapter) {
		btn.addSelectionListener(selectionAdapter);
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		super.setEnabled(isEnabled);
		styledText.setEnabled(isEnabled);
		btn.setEnabled(isEnabled);
	}

	public void setStyledTextText(final String text) {
		styledText.setText(text);
	}
}
