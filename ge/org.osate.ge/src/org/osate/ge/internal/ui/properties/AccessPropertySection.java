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
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class AccessPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof Access);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button providesBtn;
	private Button requiresBtn;

	private final SelectionListener accessSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (btn.getSelection()) {
				final AccessType newType = (AccessType) e.widget.getData();
				selectedBos.modify(Access.class, a -> a.setKind(newType));
			}
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite directionContainer = InternalPropertySectionUtil.createRowLayoutComposite(getWidgetFactory(),
				composite,
				STANDARD_LABEL_WIDTH);

		providesBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), directionContainer,
				AccessType.PROVIDES,
				accessSelectionListener, "Provides", SWT.RADIO);
		requiresBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), directionContainer,
				AccessType.REQUIRES,
				accessSelectionListener, "Requires", SWT.RADIO);

		InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Access Type:");
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
		final Set<Access> selectedAccesses = selectedBos.boStream(Access.class).collect(Collectors.toSet());

		// Get initial value for buttons
		final AccessType accessType = getAccessType(selectedAccesses);

		// Set selection
		providesBtn.setSelection(accessType == AccessType.PROVIDES);
		requiresBtn.setSelection(accessType == AccessType.REQUIRES);
	}

	private static AccessType getAccessType(final Set<Access> selectedAccesses) {
		final Iterator<Access> it = selectedAccesses.iterator();
		// Initial value of buttons
		final AccessType accessType = it.next().getKind();

		while (it.hasNext()) {
			// Check if all elements are of same access type
			if (accessType != it.next().getKind()) {
				return null;
			}
		}

		return accessType;
	}
}
