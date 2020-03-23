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
package org.osate.ge.internal.ui.editor;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.NamedElement;

public class ComboContributionItem extends ControlContribution {
	private ComboViewer combo;
	private final Object nullValue = new Object();

	protected ComboContributionItem(final String id) {
		super(id);
	}

	protected final Object getNullValue() {
		return nullValue;
	}

	@Override
	protected Control createControl(final Composite parent) {
		combo = new ComboViewer(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setContentProvider(ArrayContentProvider.getInstance());
		combo.getCombo().addDisposeListener(e -> onControlDisposed());

		combo.getCombo().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final StructuredSelection sel = (StructuredSelection)combo.getSelection();
				onSelection(sel.getFirstElement());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		combo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if(element == nullValue) {
					return getNullValueString();
				} else if (element instanceof NamedElement) {
					return getQualifiedName((NamedElement) element);
				}
				return super.getText(element);
			}
		});

		return combo.getControl();
	}

	// Gets qualified name. For flow implementations, it returns the qualified name of the specification
	protected String getQualifiedName(final NamedElement element) {
		if(element instanceof FlowImplementation) {
			return ((FlowImplementation) element).getSpecification().getQualifiedName();
		}

		return element.getQualifiedName();
	}

	public ComboViewer getComboViewer() {
		if(combo == null || combo.getCombo() == null || combo.getCombo().isDisposed()) {
			return null;
		}

		return combo;
	}

	protected void onControlDisposed() {

	}

	protected void onSelection(final Object value) {

	}

	protected String getNullValueString() {
		return "";
	}

	// Force a fixed width for the combo contribution items. Otherwise the sizes are often incorrect due to the dynamic nature of the control.
	@Override
	protected int computeWidth(Control control) {
		return 310;
	}
}
