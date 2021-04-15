/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

	public EmbeddedTextControls(final Composite parent, final int style, final int styledTextStyle, final int btnStyle,
			final String editBtnText) {
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
		btn.setText(editBtnText);
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
