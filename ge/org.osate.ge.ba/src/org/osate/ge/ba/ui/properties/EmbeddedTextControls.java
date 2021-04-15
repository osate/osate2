package org.osate.ge.ba.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.SwtUtil;

public class EmbeddedTextControls extends Composite {
	private final StyledText styledText;
	private final Button btn;
	private EmbeddedXtextAdapter xtextAdapter;

	public EmbeddedTextControls(final Composite parent, final int style, final int styledTextStyle,
			final int btnStyle) {
		super(parent, style);
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		this.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.hint(SWT.DEFAULT, SWT.DEFAULT).create());

		// Create styled text
		styledText = new StyledText(this, styledTextStyle);
		styledText.setEditable(false);
		// Set caret to null to make sure users know it is not editable
		styledText.setCaret(null);

		btn = new Button(this, btnStyle);
	}

	public void setStyledTextLayoutData(final Object layoutData) {
		styledText.setLayoutData(layoutData);
	}

	public void setButtonText(final String text) {
		btn.setText(text);
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

	@Override
	public void dispose() {
		super.dispose();
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
