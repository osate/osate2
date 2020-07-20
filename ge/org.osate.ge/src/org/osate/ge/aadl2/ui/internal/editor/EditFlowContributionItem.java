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
package org.osate.ge.aadl2.ui.internal.editor;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RefinableElement;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.aadl2.ui.internal.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.aadl2.ui.internal.editor.FlowContributionItemUtil.FlowImplementationSelectionDialog;
import org.osate.ge.aadl2.ui.internal.tools.CreateEndToEndFlowSpecificationTool;
import org.osate.ge.aadl2.ui.internal.tools.CreateFlowImplementationTool;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.botree.BusinessObjectNode;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.ProxyUtil;

public class EditFlowContributionItem extends ControlContribution {
	private final static ImageDescriptor editIcon = Activator.getImageDescriptor("icons/flow_edit.png");
	private final Set<BusinessObjectNode> segmentNodes = new HashSet<>();
	private AgeDiagramEditor editor = null;
	private Button editFlowBtn;
	private HighlightableFlowInfo selectedHighlightableFlow;

	public EditFlowContributionItem(final String id) {
		super(id);
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	protected Control createControl(final Composite parent) {
		editFlowBtn = new Button(parent, SWT.PUSH);
		editFlowBtn.setImage(editIcon.createImage());
		editFlowBtn.setToolTipText("Edit...");
		updateButton();
		editFlowBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				segmentNodes.clear();

				final DiagramElement container = selectedHighlightableFlow.getDiagramElementContainer();
				final NamedElement flowSegment = AgeAadlUtil
						.getRootRefinedElement(selectedHighlightableFlow.getFlowSegment());
				final ComponentImplementation ci = FlowContributionItemUtil
						.getComponentImplementation(container.getBusinessObject());
				editor.getDiagram().getDiagramElements().stream().findAny().ifPresent(de -> {
					// Set focus to editor for activating create flow tool
					editor.setFocus();
					editor.selectDiagramElementsForBusinessObject(de.getBusinessObject());

					final UiService uiService = Adapters.adapt(editor, UiService.class);
					// Create dialog and activate appropriate flow tool
					if (flowSegment instanceof EndToEndFlow) {
						final EndToEndFlow endToEndFlow = ProxyUtil
								.resolveOrNull(
										flowSegment,
										EndToEndFlow.class,
										ci.eResource().getResourceSet());

						// Activate tool
						uiService.activateTool(
								new CreateEndToEndFlowSpecificationTool(editor, container, endToEndFlow));
					} else if (flowSegment instanceof FlowSpecification) {
						final FlowSpecification fs = ProxyUtil.resolveOrNull(
								flowSegment,
								FlowSpecification.class, ci.eResource().getResourceSet());
						getFlowImplementation(ci, fs).ifPresent(fi -> {
							uiService.activateTool(new CreateFlowImplementationTool(editor, container, fi));
						});
					} else {
						throw new RuntimeException("Unsupported flow type.");
					}
				});
			}

			private Optional<FlowImplementation> getFlowImplementation(final ComponentImplementation ci,
					final FlowSpecification flowSpec) {
				final List<FlowImplementation> flowImpls = ci.getAllFlowImplementations().stream()
						.filter(fi -> fi.getSpecification() == flowSpec).collect(Collectors.toList());
				if (flowImpls.size() == 1) {
					return Optional.of(flowImpls.get(0));
				} else {
					final FlowImplementationSelectionDialog dlg = new FlowImplementationSelectionDialog(
							Display.getCurrent().getActiveShell(), flowImpls, "Select",
							"Choose the flow implementation to edit.");
					if (dlg.open() == Window.OK) {
						return Optional.ofNullable(dlg.getSelectedFlowImplementation());
					}
				}

				return Optional.empty();
			}
		});

		return editFlowBtn;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (this.editor != newEditor) {
			// Update the editor
			if (newEditor instanceof AgeDiagramEditor) {
				this.editor = (AgeDiagramEditor) newEditor;
			} else {
				this.editor = null;
			}
		} else {
			updateButton();
		}
	}

	/**
	 * Updates the enabled state of the edit flow button based on selection
	 */
	public void updateEditFlowItem(final HighlightableFlowInfo selectedHighlightableFlow) {
		this.selectedHighlightableFlow = selectedHighlightableFlow;
		updateButton();
	}

	private void updateButton() {
		if (editFlowBtn != null && !editFlowBtn.isDisposed()) {
			editFlowBtn.setEnabled(selectedHighlightableFlow == null ? false
					: (selectedHighlightableFlow.getFlowSegment() != null
					&& !isRefined(selectedHighlightableFlow.getFlowSegment())));
		}
	}

	private boolean isRefined(final NamedElement flowSegment) {
		if (flowSegment instanceof RefinableElement) {
			return ((RefinableElement) flowSegment).getRefinedElement() != null;
		}

		return false;
	}
}
