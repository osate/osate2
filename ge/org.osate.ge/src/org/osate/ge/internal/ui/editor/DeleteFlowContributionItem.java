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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.ui.editor.FlowContributionItemUtil.FlowImplementationSelectionDialog;
import org.osate.ge.internal.util.ProxyUtil;

public class DeleteFlowContributionItem extends ControlContribution {
	private final static Image deleteImage = PlatformUI.getWorkbench().getSharedImages()
			.getImage(ISharedImages.IMG_TOOL_DELETE);
	private AgeDiagramEditor editor = null;
	private Button deleteFlowBtn;
	private HighlightableFlowInfo selectedFlow;

	protected DeleteFlowContributionItem(final String id) {
		super(id);
	}


	@Override
	protected Control createControl(final Composite parent) {
		deleteFlowBtn = new Button(parent, SWT.PUSH);
		deleteFlowBtn.setImage(deleteImage);
		deleteFlowBtn.setToolTipText("Delete");

		updateButton();
		deleteFlowBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (editor != null && selectedFlow != null) {
					final AadlModificationService aadlModificationService = Objects.requireNonNull(
							(AadlModificationService) editor.getAdapter(AadlModificationService.class),
							"Unable to retrieve modification service");
					getFlowToRemove().ifPresent(ne -> aadlModificationService.modify(ne, EcoreUtil::remove));
				}
			}

			/**
			 * Get the flow to modify/remove
			 * @return the flow to modify/remove
			 */
			private Optional<NamedElement> getFlowToRemove() {
				final NamedElement selectedFlowSegment = selectedFlow.getFlowSegment();
				final Queryable container = selectedFlow.getContainer();
				final ComponentImplementation componentImpl = FlowContributionItemUtil
						.getComponentImplementation(container);
				if (selectedFlowSegment instanceof EndToEndFlow) {
					final ComponentImplementation endToEndFlowContainer = ProxyUtil
							.resolveOrNull(
									selectedFlowSegment.getContainingComponentImpl(), ComponentImplementation.class,
									componentImpl.eResource().getResourceSet());
					return Optional.of(ProxyUtil.resolveOrNull(selectedFlowSegment, EndToEndFlow.class,
							endToEndFlowContainer.eResource().getResourceSet()));
				} else if (selectedFlowSegment instanceof FlowSpecification) {
					final FlowSpecification flowSpecification = ProxyUtil.resolveOrNull(selectedFlowSegment,
							FlowSpecification.class, componentImpl.eResource().getResourceSet());
					// If there are multiple flow implementations for the flow spec, choose desired one.
					final List<FlowImplementation> flowImpls = componentImpl.getOwnedFlowImplementations().stream()
							.filter(fi -> fi.getSpecification() == flowSpecification).collect(Collectors.toList());
					return getFlowImplementation(flowImpls);
				} else {
					throw new RuntimeException("Unexpected flow type: " + selectedFlow.getFlowSegment());
				}
			}

			private Optional<NamedElement> getFlowImplementation(final List<FlowImplementation> flowImpls) {
				if (flowImpls.size() == 1) {
					return Optional.of(flowImpls.get(0));
				} else {
					final FlowImplementationSelectionDialog dlg = new FlowImplementationSelectionDialog(
							Display.getCurrent().getActiveShell(), flowImpls, "Select",
							"Choose the flow implementation to delete.");
					if (dlg.open() == Window.OK) {
						return Optional.ofNullable(dlg.getSelectedFlowImplementation());
					}
				}

				return Optional.empty();
			}
		});

		return deleteFlowBtn;
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
	 * Updates the enabled state of the delete flow button based on selection
	 */
	public void updateDeleteFlowItem(final HighlightableFlowInfo selectedFlow) {
		this.selectedFlow = selectedFlow;
		updateButton();
	}

	private void updateButton() {
		if (deleteFlowBtn != null && !deleteFlowBtn.isDisposed()) {
			deleteFlowBtn.setEnabled(selectedFlow == null ? false : selectedFlow.getFlowSegment() != null);
		}
	}
}
