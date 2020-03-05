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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class SetDerivedModesPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof ComponentType) {
					final ComponentType ct = (ComponentType) bo;
					return ct.getOwnedModeTransitions().size() == 0
							&& ct.getOwnedModes().size() > 0
							&& ct.getAllModes().size() == ct.getOwnedModes().size()
							&& ct.getAllModeTransitions().size() == ct.getOwnedModeTransitions().size();
				}

				return false;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button derivedModesBtn;

	private final SelectionListener derivedListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			final boolean isDerived = btn.getSelection();
			selectedBos.modify(ComponentType.class, ct -> ct.setDerivedModes(isDerived));
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Derived\nModes:");

		derivedModesBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				derivedListener, "",
				SWT.CHECK);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.bottom = new FormAttachment(sectionLabel, 0, SWT.BOTTOM);
		derivedModesBtn.setLayoutData(fd);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<ComponentType> componentTypes = selectedBos.boStream(ComponentType.class).collect(Collectors.toSet());
		// Get derived state of selected elements
		final Boolean isDerived = isDerived(componentTypes);
		// Grayed state set if elements are mixed derived and not not derived
		derivedModesBtn.setGrayed(isDerived == null);
		// Set initial selection
		derivedModesBtn.setSelection(isDerived == Boolean.TRUE);
	}

	private static Boolean isDerived(final Set<ComponentType> componentTypes) {
		final Iterator<ComponentType> it = componentTypes.iterator();
		// Initial value of buttons
		final Boolean isDerived = it.next().isDerivedModes();
		while (it.hasNext()) {
			// Check if all elements are derived or not derived
			if (isDerived != (it.next().isDerivedModes())) {
				return null;
			}
		}

		return isDerived;
	}
}
