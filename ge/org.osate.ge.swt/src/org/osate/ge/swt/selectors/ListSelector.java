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

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.DefaultEventSource;
import org.osate.ge.swt.EventSource;
import org.osate.ge.swt.SwtUtil;

/**
 * Wrapper around JFace's {@link org.eclipse.jface.viewers.ListViewer} which uses a {@link SingleSelectorModel}
 *
 * Allows selecting a single element. Sorts items provided by model.
 * @since 1.1
 */
public final class ListSelector<T> extends Composite implements SelectionDoubleClickedEventGenerator {
	private final SelectorModel<Object> wrappedModel;
	private final org.eclipse.jface.viewers.ListViewer listViewer;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();
	private final DefaultEventSource<SelectionDoubleClickedEvent> selectionDoubleClickedEventSrc = new DefaultEventSource<>();

	/**
	 * Creates a {@link ListSelector}.
	 * @param parent the container to which to add the widget.
	 * @param model the view model for the widget.
	 */
	@SuppressWarnings("unchecked")
	public ListSelector(final Composite parent, final SelectorModel<T> model) {
		super(parent, SWT.NONE);
		this.wrappedModel = new NullRemovingSelectorModel(Objects.requireNonNull(model, "model must not be null"));
		SwtUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).create());

		this.listViewer = new org.eclipse.jface.viewers.ListViewer(this,
				(model.supportsMultiSelect() ? SWT.MULTI : SWT.SINGLE) | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.listViewer.getControl().setLayoutData(
				GridDataFactory.swtDefaults().span(2, 1).grab(true, true).align(SWT.FILL, SWT.FILL).create());
		this.listViewer.setComparator(new ViewerComparator());
		this.listViewer
				.setContentProvider((IStructuredContentProvider) inputElement -> wrappedModel.getElements().toArray());
		this.listViewer.setInput(this.wrappedModel);
		this.listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return wrappedModel.getLabel(element);
			}
		});

		this.listViewer.addSelectionChangedListener(event -> {
			wrappedModel.setSelectedElements(this.listViewer.getStructuredSelection().toList().stream());
		});

		this.listViewer.addDoubleClickListener(
				event -> selectionDoubleClickedEventSrc.triggerEvent(new SelectionDoubleClickedEvent()));

		wrappedModel.changed().addListener(changeListener);
		refresh();
	}

	@Override
	public EventSource<SelectionDoubleClickedEvent> selectionDoubleClicked() {
		return selectionDoubleClickedEventSrc;
	}

	/**
	 * Sets the testing ID of the SWT List
	 * @param value is the testing ID
	 */
	public void setListTestingId(final String value) {
		SwtUtil.setTestingId(this.listViewer.getControl(), value);
	}

	private void refresh() {
		if (!this.isDisposed()) {
			this.listViewer.refresh();

			// Avoid attempting to select an element that is not in the selector. Will result in a stack overflow while trying to synchronize the selection with
			// the model.
			final Collection<Object> all = wrappedModel.getElements().collect(Collectors.toList());
			final Set<Object> selected = wrappedModel.getSelectedElements().collect(Collectors.toCollection(() -> new HashSet<Object>()));
			selected.retainAll(all);

			this.listViewer.setSelection(selected.isEmpty() ? null : new StructuredSelection(selected.toArray()));

			setEnabled(wrappedModel.isEnabled());
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		listViewer.getControl().setEnabled(enabled);
	}

	public static void main(String[] args) {
		SwtUtil.run(shell -> {
			new ListSelector<>(shell,
					new TestSelectorModel());
		});
	}

}
