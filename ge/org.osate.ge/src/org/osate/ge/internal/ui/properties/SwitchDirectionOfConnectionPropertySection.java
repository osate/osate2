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
package org.osate.ge.internal.ui.properties;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ParameterConnection;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class SwitchDirectionOfConnectionPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof Connection) {
					final Connection connection = getEditConnection((Connection) bo);
					final ComponentImplementation ci = connection.getSource().getContainingComponentImpl();
					return ci != null
							&& connection.getContainingClassifier() == ci;
				}

				return false;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button bidirectionalBtn;
	private Button unidirectionalBtn;
	private Button switchDirectionBtn;

	private final SelectionListener directionSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (btn.getSelection()) {
				final Boolean bidirectionalValue = (Boolean) e.widget.getData();
				selectedBos.modify(Connection.class, connection -> {
					connection = getEditConnection(connection);
					connection.setBidirectional(bidirectionalValue);
				});
			}
		}
	};

	private final SelectionListener switchDirectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			selectedBos.modify(Connection.class, connection -> {
				if (!(connection instanceof ParameterConnection)) {
					connection = getEditConnection(connection);
					// Swap source and destination
					final ConnectedElement ceSource = connection.getSource();
					connection.setSource(connection.getDestination());
					connection.setDestination(ceSource);
				}
			});
		};
	};

	private static Connection getEditConnection(final Connection connection) {
		return (Connection) AadlHelper.getRootRefinedElement(connection);
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);

		// Container for direction
		final Composite directionContainer = InternalPropertySectionUtil.createRowLayoutComposite(getWidgetFactory(),
				composite,
				STANDARD_LABEL_WIDTH);
		bidirectionalBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), directionContainer, true,
				directionSelectionListener,
				"Bidirectional", SWT.RADIO);
		unidirectionalBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), directionContainer, false,
				directionSelectionListener,
				"Unidirectional", SWT.RADIO);

		switchDirectionBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, null,
				switchDirectionListener, "Switch Direction", SWT.PUSH);
		final FormData ld = new FormData();
		ld.left = new FormAttachment(directionContainer, ITabbedPropertyConstants.HSPACE);
		ld.top = new FormAttachment(directionContainer, 0, SWT.CENTER);
		switchDirectionBtn.setLayoutData(ld);

		InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Direction:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<Connection> selectedConnections = selectedBos.boStream(Connection.class)
				.collect(Collectors.toList());

		boolean isEnabledSwitchDirection = false;
		final Iterator<Connection> it = selectedConnections.iterator();
		Connection connection = it.next();
		if (!(connection instanceof ParameterConnection)) {
			isEnabledSwitchDirection = true;
		}

		Boolean isBidirectional = connection.isAllBidirectional();
		while (it.hasNext()) {
			connection = it.next();
			// Check if connections selected are mixed bidirectional and unidirectional
			if (connection.isAllBidirectional() != isBidirectional) {
				// No selection on buttons
				isBidirectional = null;
				// Exit loop if obtained both initial control values
				if (isEnabledSwitchDirection) {
					break;
				}
			}

			if (!isEnabledSwitchDirection && !(connection instanceof ParameterConnection)) {
				isEnabledSwitchDirection = true;
			}
		}

		// Set initial selections
		bidirectionalBtn.setSelection(isBidirectional == Boolean.TRUE);
		unidirectionalBtn.setSelection(isBidirectional == Boolean.FALSE);
		switchDirectionBtn.setEnabled(isEnabledSwitchDirection);
	}
}
