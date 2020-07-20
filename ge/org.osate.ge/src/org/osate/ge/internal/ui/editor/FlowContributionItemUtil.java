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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.ui.tools.FlowDialogUtil;
import org.osate.ge.internal.util.AadlHelper;

public class FlowContributionItemUtil {
	private FlowContributionItemUtil() {
	}
	/**
	 * Allows a specific flow implementation to be selected
	 * when a flow specification has multiple flow implementations
	 */
	static class FlowImplementationSelectionDialog extends MessageDialog {
		private ComboViewer comboViewer;
		private final List<FlowImplementation> input;
		private FlowImplementation selectedFlowImpl;

		public FlowImplementationSelectionDialog(final Shell parentShell, final List<FlowImplementation> input,
				final String dialogTitle, final String dialogMessage) {
			super(parentShell, dialogTitle, null, dialogMessage, MessageDialog.CONFIRM, 0, "OK", "Cancel");
			setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			this.input = input;
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(new Point(550, 275));
		}

		@Override
		protected Control createCustomArea(final Composite parent) {
			final Composite composite = new Composite(parent, SWT.BORDER);
			final GridLayout layout = new GridLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.verticalSpacing = 0;
			layout.horizontalSpacing = 0;
			layout.numColumns = 2;
			composite.setLayout(layout);

			composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			composite.setFont(parent.getFont());

			new Label(composite, SWT.NONE).setText("Flow Implementation: ");

			// List of flow implementations to choose from
			comboViewer = new ComboViewer(composite, SWT.READ_ONLY);

			final StyledText flowSegmentLabels = FlowDialogUtil.createFlowSegmentLabel(composite);
			flowSegmentLabels.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());
			comboViewer.setContentProvider(ArrayContentProvider.getInstance());
			comboViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					final FlowImplementation fi = (FlowImplementation) element;
					final StringBuilder sb = new StringBuilder(getName(fi.getSpecification()));
					// Add index label
					if (input.size() > 1) {
						final int index = input.indexOf(fi) + 1;
						sb.append(" #");
						sb.append(index);
					}

					return sb.toString();
				}
			});

			// Show segments for selected flow implementation
			comboViewer.addSelectionChangedListener(event -> {
				selectedFlowImpl = (FlowImplementation) event.getStructuredSelection().getFirstElement();
				String flowStr = "";
				final List<String> flowSegmentStrings = new ArrayList<>();
				final FlowEnd inEnd = selectedFlowImpl.getInEnd();
				if (inEnd != null) {
					flowSegmentStrings.add(flowEndToString(inEnd));
				}

				for (final FlowSegment flowSegment : selectedFlowImpl.getOwnedFlowSegments()) {
					flowSegmentStrings.add(flowSegmentToString(flowSegment));
				}

				final FlowEnd outEnd = selectedFlowImpl.getOutEnd();
				if (outEnd != null) {
					flowSegmentStrings.add(flowEndToString(outEnd));
				}

				flowStr += flowSegmentStrings.stream().collect(Collectors.joining(" -> "));

				final int modeStartIndex = flowStr.length();
				if (!selectedFlowImpl.getInModeOrTransitions().isEmpty()) {
					flowStr += " in modes (" + selectedFlowImpl.getInModeOrTransitions().stream()
							.map(mf -> mf.getName()).collect(Collectors.joining(", ")) + ")";
				}
				final int modeEndIndex = flowStr.length();

				flowStr += ";";

				flowSegmentLabels.setText(flowStr);

				if (modeStartIndex != modeEndIndex) {
					flowSegmentLabels.setStyleRange(new StyleRange(modeStartIndex, 10,
							Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				}
			});

			comboViewer.setInput(input);
			comboViewer.setSelection(new StructuredSelection(input.get(0)));

			return composite;
		}

		private static String flowEndToString(final FlowEnd flowEnd) {
			final StringBuilder sb = new StringBuilder();
			if (flowEnd.getContext() != null) {
				sb.append(getName(flowEnd.getContext()));
				sb.append('.');
			}

			if (flowEnd.getFeature() != null) {
				sb.append(getName(flowEnd.getFeature()));
			}

			return sb.toString();
		}

		private static String flowSegmentToString(final FlowSegment flowSegment) {
			final StringBuilder sb = new StringBuilder();
			if (flowSegment.getContext() != null) {
				sb.append(getName(flowSegment.getContext()));
				sb.append('.');
			}

			if (flowSegment.getFlowElement() != null) {
				sb.append(getName(flowSegment.getFlowElement()));
			}

			return sb.toString();
		}

		public FlowImplementation getSelectedFlowImplementation() {
			return selectedFlowImpl;
		}
	}

	static String getName(NamedElement ne) {
		ne = (NamedElement) AadlHelper.getRootRefinedElement(ne);
		return ne.getName() == null ? "<unknown>" : ne.getName();
	}

	static ComponentImplementation getComponentImplementation(final Object container) {
		if (container instanceof Queryable) {
			return getComponentImplementation(((Queryable) container).getBusinessObject());
		} else if (container instanceof ComponentImplementation) {
			return (ComponentImplementation) container;
		} else if (container instanceof Subcomponent) {
			final Subcomponent sc = (Subcomponent) AadlHelper.getRootRefinedElement((NamedElement) container);
			return sc.getComponentImplementation();
		} else {
			throw new RuntimeException("Invalid flow container: " + container);
		}
	}
}
