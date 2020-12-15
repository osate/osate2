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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osate.ge.swt.BorderedCLabel;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.ObservableModel;
import org.osate.ge.swt.SwtUtil;

/**
 * Abstract SWT widget that displays a value and provides a button to modify the value.
 * The behavior of the modify button is defined by the concrete implementation.
 *
 * @param <M>
 * @since 1.1
 */
public abstract class BaseField<M extends ObservableModel> extends Composite {
	private final M model;
	private final BorderedCLabel valueLbl;
	private final Button modifyBtn;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	/**
	 * Create a new instance.
	 * @param parent is the container for the new component.
	 * @param model provides the information for the component.
	 */
	public BaseField(final Composite parent, final M model) {
		this(parent, model, "Choose...");
	}

	/**
	 * Create a new instance.
	 * @param parent is the container for the new component.
	 * @param model provides the information for the component.
	 * @param modifyBtnLabel the label to use for the modify button
	 */
	public BaseField(final Composite parent, final M model, final String modifyBtnLabel) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");

		SwtUtil.setColorsToMatchParent(this);

		this.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());

		this.valueLbl = new BorderedCLabel(this);
		this.valueLbl.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER)
				.minSize(200, SWT.DEFAULT).create());
		SwtUtil.setColorsToMatchParent(this.valueLbl);

		this.modifyBtn = new Button(this, SWT.FLAT);
		this.modifyBtn
				.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.CENTER, SWT.CENTER).create());
		this.modifyBtn.setText(modifyBtnLabel);
		this.modifyBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				onModify();
			}
		});
		SwtUtil.setColorsToMatchParent(this.modifyBtn);

		model.changed().addListener(changeListener);

		refresh();
	}

	/**
	 * Sets the testing ID of the label indicating the selected value
	 * @param value is the testing ID
	 */
	public void setValueLabelTestingId(final String value) {
		SwtUtil.setTestingId(valueLbl, value);
	}

	/**
	 * Sets the testing ID of the button for modify button.
	 * @param value is the testing ID
	 */
	public void setModifyButtonTestingId(final String value) {
		SwtUtil.setTestingId(modifyBtn, value);
	}

	private void refresh() {
		if (!this.isDisposed()) {
			valueLbl.setText(getValueLabel());
			setEnabled(isModifyButtonEnabled());
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		super.setEnabled(enabled);
		modifyBtn.setEnabled(enabled);
	}

	protected final M getModel() {
		return model;
	}

	/**
	 * Provides the value to be displayed in the value label
	 * @return the value to be displayed in the value label.
	 */
	protected abstract String getValueLabel();

	/**
	 * Returns whether the button used to modify the value should be enabled.
	 * @return whether the modify button should be enabled.
	 */
	protected abstract boolean isModifyButtonEnabled();

	/**
	 * Called when the modify button is activated.
	 * In most cases, this method should open a dialog to prompt the user for an updated value.
	 */
	protected abstract void onModify();
}
