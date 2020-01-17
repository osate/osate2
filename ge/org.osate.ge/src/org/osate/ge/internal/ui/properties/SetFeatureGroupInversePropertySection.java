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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class SetFeatureGroupInversePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> {
				if(boc.getBusinessObject() instanceof FeatureGroup) {
					final FeatureGroup fg = (FeatureGroup) boc.getBusinessObject();
					final Classifier classifier = fg.getContainingClassifier();
					if ((classifier instanceof FeatureGroupType || classifier instanceof ComponentType)) {
						return AadlFeatureUtil.getFeatureGroupType(boc, fg) != null;
					}
				}

				return false;
			});
		}
	}

	public static final String setFeatureGroupInverseUniqueId = "org.osate.ge.SetFeatureGroupInverseButton";
	private BusinessObjectSelection selectedBos;
	private Button inverseBtn;

	private final SelectionListener inverseSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			final boolean isInverse = btn.getSelection();
			selectedBos.modify(FeatureGroup.class, fg -> fg.setInverse(isInverse));
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(),
				"Inverse:");

		inverseBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), container, SWT.NONE,
				inverseSelectionListener,
				"", SWT.CHECK);

		// Set data used for automated testing
		inverseBtn.setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, setFeatureGroupInverseUniqueId);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		inverseBtn.setLayoutData(fd);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<FeatureGroup> selectedFeatureGroups = selectedBos.boStream(FeatureGroup.class)
				.collect(Collectors.toSet());
		// Get refined state of selected elements
		final Boolean isInverse = isInverse(selectedFeatureGroups);
		// Grayed state set if elements are mixed inverse and not inverse
		inverseBtn.setGrayed(isInverse == null);
		// Set initial selection
		inverseBtn.setSelection(isInverse == Boolean.TRUE);
	}

	private static Boolean isInverse(final Set<FeatureGroup> selectedFeatureGroups) {
		final Iterator<FeatureGroup> it = selectedFeatureGroups.iterator();
		// Initial value of buttons
		final Boolean isInverse = it.next().isInverse();
		while (it.hasNext()) {
			// Check if all elements are inverse or not inverse
			if (isInverse != it.next().isInverse()) {
				return null;
			}
		}

		return isInverse;
	}
}
