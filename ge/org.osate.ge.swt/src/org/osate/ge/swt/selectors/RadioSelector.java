/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.swt.selectors;

import java.util.Objects;

import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.SwtUtil;

/**
 * Set of radio buttons which uses a {@link SingleSelectorModel}
 *
 * @param <T> See {@link SingleSelectorModel}
 * @since 1.1
 */
public final class RadioSelector<T> extends Composite {
	private final SingleSelectorModel<T> model;
	private final Runnable changeListener = this::refresh;

	/**
	 * Creates a new instance
	 * @param parent the widget which is the parent of the editor. Must not be null.
	 * @param model the model for the editor
	 */
	public RadioSelector(final Composite parent, final SingleSelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		SwtUtil.setColorsToMatchParent(this);
		this.setLayout(RowLayoutFactory.fillDefaults().wrap(false).create());

		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			for (final Control child : getChildren()) {
				child.dispose();
			}

			final Object value = model.getSelectedElement();

			// Create new buttons
			model.getElements().forEachOrdered(element -> {
				final Button btn = new Button(this, SWT.RADIO);
				SwtUtil.setColorsToMatchParent(btn);
				btn.setText(model.getLabel(element));
				btn.setData(element);
				btn.setSelection(element == value);
				btn.addSelectionListener(selectionListener);
			});

			setEnabled(model.isEnabled());
			requestLayout();
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);

		for (final Control c : getChildren()) {
			c.setEnabled(enabled);
		}
	}

	private final SelectionListener selectionListener = new SelectionAdapter() {
		@SuppressWarnings("unchecked")
		@Override
		public void widgetSelected(SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (btn.getSelection()) {
				model.setSelectedElement((T) e.widget.getData());
				refresh();
			}
		}
	};

	/**
	 * Entry point for an interactive test application.
	 * @param args command line arguments
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public static void main(String[] args) {
		SwtUtil.run(shell -> new RadioSelector<>(shell, new TestListEditorModel()));
	}
}
