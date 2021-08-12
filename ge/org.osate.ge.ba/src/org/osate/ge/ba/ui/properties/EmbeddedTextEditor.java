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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.SwtUtil;

public class EmbeddedTextEditor extends Composite {
	private StyledText styledText;
	private Button btn;
	private EmbeddedXtextAdapter xtextAdapter;
	private final int styledTextStyle;
	private String styledTextTestId;
	private String editBtnTestId;

	/**
	 * @since 2.0
	 */
	public EmbeddedTextEditor(final Composite parent, final int styledTextStyle,
			final Runnable modify) {
		super(parent, SWT.NONE);
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		this.styledTextStyle = styledTextStyle;

		createControls(modify);
	}

	/**
	 * @since 2.0
	 */
	public EmbeddedXtextAdapter getAdapter() {
		return xtextAdapter;
	}

	/**
	 * @since 2.0
	 */
	public EmbeddedTextValue getValue() {
		return xtextAdapter.getTextValue();
	}

	/**
	 * @since 2.0
	 */
	public static EmbeddedTextEditor createSingleline(final Composite parent, final Runnable modify) {
		return new EmbeddedTextEditor(parent, SWT.BORDER | SWT.SINGLE, modify);
	}

	/**
	 * @since 2.0
	 */
	public static EmbeddedTextEditor createMultiLine(final Composite parent,
			final Runnable modify) {
		return new EmbeddedTextEditor(parent, SWT.BORDER | SWT.V_SCROLL | SWT.WRAP | SWT.MULTI, modify);
	}

	private void createControls(final Runnable modify) {
		// Create styled text
		styledText = new StyledText(this, styledTextStyle);
		styledText.setEditable(false);
		// Set empty caret so that the caret will not show.
		// Makes sure users know it is not editable.
		// Note: If caret is set to null, exception may occur
		// when used with the StyledTextXtextAdapter.
		final Caret emptyCaret = new Caret(getShell(), SWT.NONE);
		styledText.setCaret(emptyCaret);
		styledText.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.hint(SWT.DEFAULT, SWT.DEFAULT).create());
		styledText.addDisposeListener(e -> emptyCaret.dispose());
		SwtUtil.setTestingId(styledText, styledTextTestId);

		btn = new Button(this, SWT.PUSH);
		btn.setText("Edit...");
		SwtUtil.setTestingId(btn, editBtnTestId);
		btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				modify.run();
			}
		});
	}

	/**
	 * @since 2.0
	 */
	public void setEditorTextValue(final IProject project, final EmbeddedTextValue textValue) {
		disposeXtextAdapter();
		xtextAdapter = new EmbeddedXtextAdapter(project, textValue);
		// Adapt without content helper
		xtextAdapter.adapt(styledText, false);
	}

	public void setStyledTextTestId(final String styledTextTestId) {
		this.styledTextTestId = styledTextTestId;
	}

	public void setEditButtonTestId(final String editBtnTestId) {
		this.editBtnTestId = editBtnTestId;
	}

	private void disposeXtextAdapter() {
		if (xtextAdapter != null) {
			xtextAdapter.dispose();
			xtextAdapter = null;
		}
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

	/**
	 * @since 2.0
	 */
	public String getModifiedSource(final EObject rootElement) {
		return xtextAdapter.serialize(rootElement);
	}
}
