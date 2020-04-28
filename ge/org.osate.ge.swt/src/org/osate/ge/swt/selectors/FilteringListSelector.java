/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.internal.InternalUtil;

/**
 * A selector which combines a text field for user specified filtering with a {@link ListSelector}
 *
 */
public final class FilteringListSelector<T> extends Composite implements SelectionDoubleClickedEventGenerator {
	private final FilteringSelectorModel<T> model;
	private final Text filterField;
	private final ListSelector<T> listViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public FilteringListSelector(final Composite parent, final FilteringSelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		InternalUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		// Field field to specify filter
		filterField = new Text(this, SWT.SINGLE | SWT.BORDER);
		filterField.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).create());
		filterField.addModifyListener(e -> {
			model.setFilter(filterField.getText());
		});

		// List of options
		this.listViewer = new ListSelector<>(this, model);
		this.listViewer
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).create());

		model.changed().addListener(changeListener);

		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			// Update the UI. The inner list viewer handles its own refresh
			if (!Objects.equals(filterField.getText(), model.getFilter())) {
				filterField.setText(model.getFilter());
			}
		}
	}

	public static void main(String[] args) {
		InternalUtil.run(shell -> {
			new FilteringListSelector<>(shell, new LabelFilteringListSelectorModel<>(new TestListEditorModel()));
		});
	}

	@Override
	public EventSource<SelectionDoubleClickedEvent> selectionDoubleClicked() {
		return listViewer.selectionDoubleClicked();
	}
}
