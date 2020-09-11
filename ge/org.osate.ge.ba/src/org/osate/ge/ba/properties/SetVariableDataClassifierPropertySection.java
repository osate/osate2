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
package org.osate.ge.ba.properties;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.PackageSection;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ba.util.BehaviorAnnexUtil;
import org.osate.ge.ui.PropertySectionUtil;

/**
 * Property section for setting a {@link BehaviorVariable}'s data classifier.
 */
public class SetVariableDataClassifierPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BehaviorVariable);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Label curDataClassifier;
	private Button chooseBtn;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite container = getWidgetFactory().createComposite(composite);
		final Label sectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Data Classifier:");

		container.setLayout(new FormLayout());
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		container.setLayoutData(fd);

		curDataClassifier = getWidgetFactory().createLabel(container, new String());
		fd = new FormData();
		fd.left = new FormAttachment(0, 0);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		curDataClassifier.setLayoutData(fd);

		chooseBtn = PropertySectionUtil.createButton(getWidgetFactory(), container, null, setDataClassifierListener,
				"Choose...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(curDataClassifier, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(curDataClassifier, 0, SWT.CENTER);
		chooseBtn.setLayoutData(fd);
	}

	final SelectionListener setDataClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final BehaviorVariable behaviorVariable = selectedBos.boStream(BehaviorVariable.class).findAny()
					.orElseThrow(() -> new RuntimeException("Selected behavior variable cannot be found"));
			final Resource resource = behaviorVariable.eResource();
			final DataClassifier dataClassifier = BehaviorAnnexUtil.getDataClassifier(resource).orElse(null);
			if (dataClassifier == null) {
				return;
			}

			// Set the data classifier
			selectedBos.modify(BehaviorVariable.class, bv -> {
				setDataClassifier(bv, dataClassifier);
			});
		}
	};

	private void setDataClassifier(final BehaviorVariable behaviorVariable, final DataClassifier dataClassifier) {
		// Import its package if necessary
		final AadlPackage pkg = (AadlPackage) behaviorVariable.getElementRoot();
		if (dataClassifier instanceof Classifier && dataClassifier.getNamespace() != null && pkg != null) {
			final PackageSection section = pkg.getPublicSection();
			final AadlPackage selectedDataClassifierPkg = (AadlPackage) dataClassifier.getNamespace().getOwner();
			if (selectedDataClassifierPkg != null && pkg != selectedDataClassifierPkg) {
				BehaviorAnnexUtil.addImportIfNeeded(section, selectedDataClassifierPkg);
			}
		}

		behaviorVariable.setDataClassifier(dataClassifier);
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<BehaviorVariable> behaviorVariables = selectedBos.boStream(BehaviorVariable.class)
				.collect(Collectors.toList());
		curDataClassifier.setText(getDataClassifierLabel(behaviorVariables));
	}

	private static String getDataClassifierLabel(final List<BehaviorVariable> behaviorVariables) {
		final Iterator<BehaviorVariable> it = behaviorVariables.iterator();
		final DataClassifier dc = it.next().getDataClassifier();
		while (it.hasNext()) {
			// If variable data classifiers are not the same, set to multiple
			if (dc != it.next().getDataClassifier()) {
				return "<Multiple>";
			}
		}

		return dc.getQualifiedName();
	}
}
