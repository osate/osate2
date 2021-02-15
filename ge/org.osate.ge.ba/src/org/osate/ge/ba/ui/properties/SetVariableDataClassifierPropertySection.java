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
package org.osate.ge.ba.ui.properties;

import static org.osate.ge.ba.util.BehaviorAnnexUtil.getPackage;
import static org.osate.ge.ba.util.BehaviorAnnexUtil.getVariableBuildOperation;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.PublicPackageSection;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.declarative.Identifier;
import org.osate.ba.declarative.QualifiedNamedElement;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ba.util.BehaviorAnnexUtil;
import org.osate.ge.ba.util.BehaviorAnnexUtil.VariableOperation;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;
import org.osate.ge.swt.SwtUtil;
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

	public static final String WIDGET_ID_DATA_CLASSIFIER_LABEL = "org.osate.ge.ba.ui.properties.setVariableDataClassifierPropertySection.label";
	private BusinessObjectSelection selectedBos;
	private Label curDataClassifier;
	private Button chooseBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
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
		SwtUtil.setTestingId(curDataClassifier, WIDGET_ID_DATA_CLASSIFIER_LABEL);

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
			final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorVariable.getOwner();
			final PublicPackageSection section = getPackage(behaviorAnnex)
					.map(AadlPackage::getPublicSection).orElse(null);
			if (section == null) {
				return;
			}

			// Set data classifier
			final Operation op = Operation.createWithBuilder(builder -> {
				builder.supply(() -> {
					final Optional<VariableOperation> variableOperation = getVariableBuildOperation(section, behaviorAnnex);
					return !variableOperation.isPresent() ? StepResult.abort()
							: StepResult.forValue(variableOperation.get());
				}).executeOperation(variableOp -> Operation.createWithBuilder(innerBuilder -> {
					final OperationBuilder<VariableOperation> opBuilder = innerBuilder.modifyModel(
							variableOp.getPublicSection(), (tag, prevResult) -> tag,
							(tag, sectionToModify, prevResult) -> {
								// Import package if needed
								BehaviorAnnexUtil.addImportIfNeeded(sectionToModify,
										variableOp.getDataClassifierPackage());
								return StepResult.forValue(variableOp);
							});

					selectedBos.modifyWithOperation(opBuilder, BehaviorVariable.class,
							(bv, varOp) -> bv.setDataClassifier(varOp.getDataClassifier()));
				}));
			});

			PropertySectionUtil.execute(op);
		}
	};

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
		BehaviorVariable bv = it.next();
		final DataClassifier dc = bv.getDataClassifier();
		while (it.hasNext()) {
			bv = it.next();
			// If variable data classifiers are not the same, set to multiple
			if (dc != bv.getDataClassifier()) {
				return "<Multiple>";
			}
		}

		if (dc instanceof QualifiedNamedElement) {
			final QualifiedNamedElement qualNamedElement = (QualifiedNamedElement) dc;
			final Identifier baNamespace = qualNamedElement.getBaNamespace();
			final Identifier baName = qualNamedElement.getBaName();
			return new StringBuilder(baNamespace == null ? "" : baNamespace.getId()).append("::")
					.append(baName == null ? "" : baName.getId()).toString();
		}

		return dc.getQualifiedName();
	}
}
