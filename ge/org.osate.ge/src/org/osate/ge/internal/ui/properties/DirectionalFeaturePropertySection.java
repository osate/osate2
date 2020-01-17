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
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.RowLayoutFactory;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroup;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class DirectionalFeaturePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof DirectedFeature);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button inBtn;
	private Button outBtn;
	private Button inOutBtn;

	private final SelectionListener directionSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (btn.getSelection()) {
				final DirectionType newDirection = (DirectionType) e.widget.getData();
				selectedBos.modify(DirectedFeature.class, df -> setDirection(df, newDirection));
			}
		}

		private void setDirection(final DirectedFeature feature, final DirectionType newDirection) {
			if (feature instanceof AbstractFeature || feature instanceof FeatureGroup) {
				feature.setIn(newDirection != DirectionType.IN_OUT && newDirection == DirectionType.IN);
				feature.setOut(newDirection != DirectionType.IN_OUT && newDirection == DirectionType.OUT);
			} else {
				feature.setIn(newDirection == DirectionType.IN_OUT || newDirection == DirectionType.IN);
				feature.setOut(newDirection == DirectionType.IN_OUT || newDirection == DirectionType.OUT);
			}
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);

		FormData ld;
		final Composite directionContainer = getWidgetFactory().createComposite(composite);
		directionContainer.setLayout(RowLayoutFactory.fillDefaults().wrap(false).create());
		ld = new FormData();
		ld.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		ld.right = new FormAttachment(100, 0);
		ld.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		directionContainer.setLayoutData(ld);

		inBtn = getWidgetFactory().createButton(directionContainer, "Input", SWT.RADIO);
		inBtn.setData(DirectionType.IN);
		inBtn.addSelectionListener(directionSelectionListener);

		outBtn = getWidgetFactory().createButton(directionContainer, "Output", SWT.RADIO);
		outBtn.setData(DirectionType.OUT);
		outBtn.addSelectionListener(directionSelectionListener);

		inOutBtn = getWidgetFactory().createButton(directionContainer, "Bidirectional", SWT.RADIO);
		inOutBtn.setData(DirectionType.IN_OUT);
		inOutBtn.addSelectionListener(directionSelectionListener);

		final Label label = getWidgetFactory().createLabel(composite, "Direction:");
		ld = new FormData();
		ld.left = new FormAttachment(0, 0);
		ld.right = new FormAttachment(directionContainer, -ITabbedPropertyConstants.HSPACE);
		ld.top = new FormAttachment(directionContainer, 0, SWT.CENTER);
		label.setLayoutData(ld);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part,
			final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<DirectedFeature> selectedDirections = selectedBos.boStream(DirectedFeature.class)
				.collect(Collectors.toSet());
		// Get initial button value
		final DirectionType directionType = getDirectionType(selectedDirections);
		// Set selection
		inBtn.setSelection(directionType == DirectionType.IN);
		outBtn.setSelection(directionType == DirectionType.OUT);
		inOutBtn.setSelection(directionType == DirectionType.IN_OUT);
	}

	private static DirectionType getDirectionType(final Set<DirectedFeature> selectedDirections) {
		final Iterator<DirectedFeature> it = selectedDirections.iterator();
		// Initial value of buttons
		final DirectionType directionType = it.next().getDirection();

		while (it.hasNext()) {
			// Check if all elements are of same direction type
			if (directionType != it.next().getDirection()) {
				return null;
			}
		}

		return directionType;
	}
}
