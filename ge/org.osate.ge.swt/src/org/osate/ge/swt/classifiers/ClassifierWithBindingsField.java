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
package org.osate.ge.swt.classifiers;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.internal.InternalUtil;
import org.osate.ge.swt.util.SwtTestUtil;

/**
 * A component which allows selecting a classifier and bindings for a node provided by a {@link PrototypeBindingsModel}.
 *
 * @param <N> is the type of the node being edited.
 * @param <D> is the type of the direction options.
 * @param <T> is the type of the type options.
 * @param <C> is the type of the classifiers.
 */
public final class ClassifierWithBindingsField<N, D, T, C> extends Composite {
	private final PrototypeBindingsModel<N, D, T, C> model;
	private N node;
	private final CLabel selectedLbl;
	private final Button chooseBtn;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	/**
	 * Create a new instance.
	 * @param parent is the container for the new component.
	 * @param model provides the information for the component.
	 * @param initNode is the node from the model for which the component displays and sets values.
	 */
	public ClassifierWithBindingsField(final Composite parent, final PrototypeBindingsModel<N, D, T, C> model,
			final N initNode) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.node = initNode;
		InternalUtil.setColorsToMatchParent(this);

		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.selectedLbl = new CLabel(this, SWT.BORDER);
		this.selectedLbl
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER)
						.minSize(200, SWT.DEFAULT)
						.create());
		InternalUtil.setColorsToMatchParent(this.selectedLbl);

		this.chooseBtn = new Button(this, SWT.FLAT);
		this.chooseBtn
				.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.CENTER, SWT.CENTER).create());
		this.chooseBtn.setText("Choose...");
		this.chooseBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				ClassifierWithBindingsDialog.open(getShell(), "Select Classifier and Prototype Bindings", model, node);
			}
		});
		InternalUtil.setColorsToMatchParent(this.chooseBtn);

		model.changed().addListener(changeListener);

		refresh();
	}

	/**
	 * Sets the node which this control is editing.
	 * @param node the new node. May be null. Must be valid node as provided by the model.
	 */
	public void setNode(N node) {
		this.node = node;
	}

	/**
	 * Sets the testing ID of the label indicating the selected value
	 * @param value is the testing ID
	 */
	public void setLabelTestingId(final String value) {
		SwtTestUtil.setTestingId(selectedLbl, value);
	}

	/**
	 * Sets the testing ID of the button for choose button.
	 * @param value is the testing ID
	 */
	public void setChooseButtonTestingId(final String value) {
		SwtTestUtil.setTestingId(chooseBtn, value);
	}

	private void refresh() {
		if (!this.isDisposed()) {
			selectedLbl.setText(model.getValueLabel(node));
			chooseBtn.setEnabled(model.getClassifierOptions(node).limit(1).count() != 0);
		}
	}

	public static void main(String[] args) {
		InternalUtil.run(shell -> {
			new ClassifierWithBindingsField<>(shell, new TestPrototypeBindingsModel(), null);
		});
	}
}
