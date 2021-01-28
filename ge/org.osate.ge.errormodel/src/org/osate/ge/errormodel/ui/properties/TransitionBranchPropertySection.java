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
package org.osate.ge.errormodel.ui.properties;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

import com.google.common.base.Objects;

public class TransitionBranchPropertySection extends AbstractPropertySection {
	/**
	 * Testing ID for the value text field
	 */
	public static final String WIDGET_ID_PROBABILITY = "org.osate.ge.errormodel.ui.properties.transitionBranch.probability";

	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof TransitionBranch;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Text valueField;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite container = getWidgetFactory().createFlatFormComposite(parent);

		final Label label = PropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Probability:");

		valueField = getWidgetFactory().createText(container, "", SWT.SINGLE);
		SwtUtil.setTestingId(valueField, WIDGET_ID_PROBABILITY);

		FormData fd = new FormData();
		fd.width = 150;
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(label, 0, SWT.CENTER);
		valueField.setLayoutData(fd);

		valueField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (valueField.isEnabled()) {
					String value = valueField.getText();
					if (value.startsWith(".")) {
						value = "0" + value;
					}

					final String newValueStr = value;

					selectedBos.modify(TransitionBranch.class, branch -> {
						final BranchValue newValue = ErrorModelFactory.eINSTANCE.createBranchValue();
						newValue.setRealvalue(newValueStr);
						branch.setValue(newValue);
					});
				}
			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<TransitionBranch> branches = selectedBos.boStream(TransitionBranch.class)
				.collect(Collectors.toList());
		boolean editable = true;
		if (branches.size() == 0) {
			editable = false;
			valueField.setText("");
		} else {
			final TransitionBranch firstBranch = branches.get(0);
			final String firstDisplayValue = getDisplayValue(firstBranch);
			boolean displayFirstValue = firstDisplayValue != null
					&& branches.stream().allMatch(b -> Objects.equal(firstDisplayValue, getDisplayValue(b)));
			editable = displayFirstValue && hasRealValueOrNull(firstBranch);
			if (displayFirstValue) {
				valueField.setText(firstDisplayValue);
			} else {
				valueField.setText("<Multiple Values>");
			}
		}

		valueField.setEnabled(editable);
	}

	private static boolean hasRealValueOrNull(final TransitionBranch branch) {
		final BranchValue value = branch.getValue();
		if (value == null) {
			return true;
		}

		return value.getRealvalue() != null;
	}

	private static String getDisplayValue(final TransitionBranch branch) {
		final BranchValue value = branch.getValue();
		if (value == null) {
			return "";
		}

		if (value.getRealvalue() != null) {
			return value.getRealvalue();
		} else if (value.getSymboliclabel() != null) {
			return value.getSymboliclabel().getQualifiedName();
		} else if (value.isOthers()) {
			return "<Others>";
		} else {
			return "<Unsupported Value>";
		}
	}
}
