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

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class InheritedElementNoticePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest,
					bo -> bo instanceof Element);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Composite composite;
	private Composite warningComposite;
	private Font boldFont;
	private TabbedPropertySheetPage propertySheetPage;

	@Override
	public void dispose() {
		if (boldFont != null) {
			boldFont.dispose();
			boldFont = null;
		}
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.propertySheetPage = aTabbedPropertySheetPage;

		composite = getWidgetFactory().createComposite(parent);
		composite.setLayout(GridLayoutFactory.fillDefaults().create());
		warningComposite = getWidgetFactory().createFlatFormComposite(composite);
		warningComposite.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

		final Label lbl = getWidgetFactory().createLabel(warningComposite,
				"One or more of the selected elements is an inherited element. Modifications will update the declared model element. See OSATE Graphical Editor User Guide for details.");

		warningComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		lbl.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		lbl.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_FOREGROUND));

		final FontDescriptor boldDescriptor = FontDescriptor.createFrom(lbl.getFont()).setStyle(SWT.BOLD);
		boldFont = boldDescriptor.createFont(lbl.getDisplay());
		lbl.setFont(boldFont);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final boolean visible = selectedBos.bocStream()
				.anyMatch(boc -> !(boc.getBusinessObject() instanceof Classifier
						|| boc.getBusinessObject() instanceof InstanceObject) && boc.getParent() != null
						&& ((Element) boc.getBusinessObject()).getContainingClassifier() != null
						&& boc.getParent().getBusinessObject() != ((Element) boc.getBusinessObject())
						.getContainingClassifier());

		warningComposite.setVisible(visible);
		warningComposite.setLayoutData(
				GridDataFactory.createFrom((GridData) warningComposite.getLayoutData()).exclude(!visible).create());
		propertySheetPage.getControl().pack(true);
		propertySheetPage.getControl().requestLayout();

	}
}
