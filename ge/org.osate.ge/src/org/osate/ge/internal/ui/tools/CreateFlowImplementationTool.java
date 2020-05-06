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
package org.osate.ge.internal.ui.tools;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.ui.util.DialogPlacementHelper;

public class CreateFlowImplementationTool {
	private ColoringService.Coloring coloring = null;
	private CreateFlowImplementationDialog dlg;

	@Activate
	public void activate(@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext selectedBoc,
			final AadlModificationService aadlModService, final UiService uiService,
			final ColoringService coloringService) {
		try {
			// Check for existing errors or warnings
			final Set<Diagnostic> diagnostics = ToolUtil.getAllReferencedPackageDiagnostics(selectedBoc);
			if (!diagnostics.isEmpty()) {
				Display.getDefault()
				.asyncExec(
						() -> new FlowDialogUtil.ErrorDialog(
								"The Create Flow Implementation",
								diagnostics).open());
			} else {
				this.coloring = coloringService.adjustColors();

				dlg = new CreateFlowImplementationDialog(Display.getCurrent().getActiveShell(), uiService, coloring);
				// Create and update based on current selection
				dlg.create();
				update(new BusinessObjectContext[] { selectedBoc }, true);
				if (dlg.open() == Window.CANCEL) {
					return;
				}

				if (dlg != null) {
					CreateFlowImplementationDialog.getFlowComponentImplementation(dlg.getOwnerBoc().orElse(null)).ifPresent(ownerCi -> {
						aadlModService.modify(ownerCi, ci -> {
							ci.getOwnedFlowImplementations().add(dlg.createFlow());
							ci.setNoFlows(false);
						});
					});
				}
			}
		} finally {
			uiService.deactivateActiveTool();
		}
	}

	/**
	 * Update the diagram and tool dialog
	 * @param selectedBocs - the selected bocs
	 * @param isInit - whether the selected bocs are the inital selection when the tool was activated
	 */
	private void update(final BusinessObjectContext[] selectedBocs, final boolean isInit) {
		if (dlg != null && dlg.getShell() != null && !dlg.getShell().isDisposed()) {
			// If the selection is a valid addition to the flow implementation, add it
			if (selectedBocs.length > 1) {
				dlg.setMultipleElementsSelected(true);
			} else if (selectedBocs.length == 1) {
				dlg.setMultipleElementsSelected(false);
				dlg.setValid(false);
				dlg.addSelectedElement(selectedBocs[0], isInit);
			}
		}
	}

	@Deactivate
	public void deactivate() {
		// Dispose of the coloring object
		if (coloring != null) {
			coloring.dispose();
			coloring = null;
		}

		// Close the dialog
		if (dlg != null) {
			dlg.close();
			dlg = null;
		}
	}

	@SelectionChanged
	public void onSelectionChanged(@Named(Names.BUSINESS_OBJECT_CONTEXTS) final BusinessObjectContext[] selectedBocs) {
		update(selectedBocs, false);
	}

	/**
	 * Determine message based on currently selected element
	 * @return
	 */
	private static class CreateFlowImplementationDialog extends TitleAreaDialog {
		private final UiService uiService;
		private final ColoringService.Coloring coloring;
		private final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private TableViewer errorTableViewer;
		private Composite flowComposite;
		private StyledText flowLabel;
		private Button undoButton;
		private List<BusinessObjectContext> userSelections = new ArrayList<>(); // Include the flow specification, flow segments, features and modes. First item
		private boolean multipleElementsSelected = false;
		private boolean isValid = true;

		CreateFlowImplementationDialog(final Shell parentShell, final UiService uiService,
				final ColoringService.Coloring coloring) {
			super(parentShell);
			this.uiService = Objects.requireNonNull(uiService, "ui service must not be null");
			this.coloring = Objects.requireNonNull(coloring, "coloring must not be null");
			this.setHelpAvailable(true);
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		private void setValid(final boolean isValid) {
			this.isValid = isValid;
		}

		private void setMultipleElementsSelected(final boolean value) {
			multipleElementsSelected = value;
			updateMessage();
		}

		private boolean needsStartingFeature() {
			final FlowSpecification fs = getFlowSpecification();
			return fs == null ? false : (fs.getKind() == FlowKind.PATH || fs.getKind() == FlowKind.SINK);
		}

		private boolean needsEndingFeature() {
			final FlowSpecification fs = getFlowSpecification();
			return fs == null ? false : fs.getKind() == FlowKind.PATH || fs.getKind() == FlowKind.SOURCE;
		}

		private boolean needsEndingFlowSink() {
			final FlowSpecification fs = getFlowSpecification();
			return fs == null ? false : fs.getKind() == FlowKind.SINK;
		}

		private String getDirectionMessage() {
			String msg;
			if (userSelections.isEmpty()) {
				msg = "Select a flow specification to implement.";
			} else if (selectingFlowIn()) {
				msg = "Select a starting feature.";
			} else if (isValid) {
				msg = "Select the OK button to create the flow implementation. Optionally, select a mode or mode transition.";
			} else if (needsEndingFeature()) {
				if (selectingFlowEnd()) {
					msg = "Select a flow element or ending feature. Optionally, select a mode or mode transition.";
				} else {
					msg = "Select a flow element. Optionally, select a mode or mode transition.";
				}
			} else if (needsEndingFlowSink()) {
				msg = "Select a flow element or ending flow sink specification. Optionally, select a mode or mode transition.";
			} else {
				msg = ""; // Intended to be unreachable
			}
			return msg;
		}

		private void updateMessage() {
			final String msg = getDirectionMessage();
			String error = null;

			if (multipleElementsSelected) {
				error = "Multiple elements selected. Select a single element.";
			} else if (!isValid) {
				error = "Invalid Flow Implemenation.";
			}

			if (error == null) {
				setErrorMessage(null);
				setMessage(msg);
			} else {
				setErrorMessage(error + " " + msg);
			}
		}

		private List<BusinessObjectContext> getSelectedBocsOtherThanFirst() {
			return userSelections.subList(1, userSelections.size());
		}

		private FlowImplementation createFlow() {
			// Create a flow implementation based on the state of the dialog
			final FlowImplementation flowImpl = (FlowImplementation) pkg.getEFactoryInstance()
					.create(pkg.getFlowImplementation());
			flowImpl.setSpecification(getFlowSpecification());

			if (flowImpl.getSpecification() != null) {
				flowImpl.setKind(flowImpl.getSpecification().getKind());
			}

			getFlowComponentImplementationBoc(getOwnerBoc().orElse(null)).ifPresent(flowImplOwnerBoc -> {
				if (userSelections.size() > 1) {
					final List<BusinessObjectContext> modesAndSegmentBocs = getSelectedBocsOtherThanFirst();
					final List<BusinessObjectContext> featureBocs = modesAndSegmentBocs.stream()
							.filter(boc -> boc.getBusinessObject() instanceof Feature)
							.collect(Collectors.toCollection(ArrayList::new));
					final List<BusinessObjectContext> flowElementBocs = modesAndSegmentBocs.stream()
							.filter(boc -> boc.getBusinessObject() instanceof FlowElement)
							.collect(Collectors.toCollection(ArrayList::new));
					final List<BusinessObjectContext> modeFeatureBocs = modesAndSegmentBocs.stream()
							.filter(boc -> boc.getBusinessObject() instanceof ModeFeature)
							.collect(Collectors.toCollection(ArrayList::new));

					int nextFeatureIndex = 0;
					BusinessObjectContext inBoc = null;
					if (needsStartingFeature() && featureBocs.size() > nextFeatureIndex) {
						final FlowEnd inEnd = flowImpl.createInEnd();
						inBoc = featureBocs.get(nextFeatureIndex);
						inEnd.setContext(ToolUtil.findContextExcludeOwner(inBoc, flowImplOwnerBoc));
						inEnd.setFeature((Feature) inBoc.getBusinessObject());
						nextFeatureIndex++;
					}

					BusinessObjectContext outBoc = null;
					if (needsEndingFeature() && featureBocs.size() > nextFeatureIndex) {
						final FlowEnd outEnd = flowImpl.createOutEnd();
						outBoc = featureBocs.get(nextFeatureIndex);
						outEnd.setContext(ToolUtil.findContextExcludeOwner(outBoc, flowImplOwnerBoc));
						outEnd.setFeature((Feature) outBoc.getBusinessObject());
						nextFeatureIndex++;
					}

					for (final BusinessObjectContext tmpBoc : flowElementBocs) {
						if (!(tmpBoc.getBusinessObject() instanceof DataAccess)
								|| (tmpBoc != outBoc && tmpBoc != inBoc)) {
							final FlowSegment newFlowSegment = flowImpl.createOwnedFlowSegment();
							newFlowSegment.setContext(ToolUtil.findContextExcludeOwner(tmpBoc, flowImplOwnerBoc));
							newFlowSegment.setFlowElement((FlowElement) tmpBoc.getBusinessObject());
						}
					}

					for (final BusinessObjectContext tmpModeFeature : modeFeatureBocs) {
						flowImpl.getInModeOrTransitions().add((ModeFeature) tmpModeFeature.getBusinessObject());
					}
				}
			});

			return flowImpl;
		}

		private boolean selectingFlowSpecificationToImplement() {
			return userSelections.isEmpty();
		}

		private boolean selectingFlowIn() {
			return needsStartingFeature() && userSelections.size() == 1;
		}

		private boolean selectingSubcomponentFlow() {
			if (selectingFlowSpecificationToImplement() || selectingFlowIn()) {
				return false;
			}

			final FlowImplementation flowImpl = createFlow();
			if (flowImpl.getKind() == FlowKind.SOURCE && (flowImpl.getOwnedFlowSegments().size() % 2) == 0) {
				return true;
			} else if ((flowImpl.getKind() == FlowKind.SINK || flowImpl.getKind() == FlowKind.PATH)
					&& (flowImpl.getOwnedFlowSegments().size() % 2) == 1) {
				return true;
			}

			return false;
		}

		private boolean selectingConnectionFlow() {
			if (selectingFlowSpecificationToImplement() || selectingFlowIn()) {
				return false;
			}

			final FlowImplementation flowImpl = createFlow();
			if (flowImpl.getKind() == FlowKind.SOURCE && (flowImpl.getOwnedFlowSegments().size() % 2) == 1) {
				return true;
			} else if ((flowImpl.getKind() == FlowKind.SINK || flowImpl.getKind() == FlowKind.PATH)
					&& (flowImpl.getOwnedFlowSegments().size() % 2) == 0) {
				return true;
			}

			return false;
		}

		private boolean selectingFlowEnd() {
			if (selectingFlowSpecificationToImplement() || selectingFlowIn() || !needsEndingFeature()) {
				return false;
			}

			final FlowImplementation flowImpl = createFlow();

			if ((flowImpl.getKind() == FlowKind.SOURCE || flowImpl.getKind() == FlowKind.SINK)
					&& (flowImpl.getOwnedFlowSegments().size() % 2) == 0) {
				return true;
			} else if (flowImpl.getKind() == FlowKind.PATH && (flowImpl.getOwnedFlowSegments().isEmpty()
					|| (flowImpl.getOwnedFlowSegments().size() % 2) == 1)) {
				// For flow paths, require an odd number of flow segments if there are any flow segments
				return true;
			}

			return false;
		}

		/**
		 * @param boc - the business object context for the selected element
		 * @param isInit - whether the boc is the initial selection when tool is activated
		 */
		private void addSelectedElement(final BusinessObjectContext boc, final boolean isInit) {
			if (!userSelections.contains(boc)) {
				// Decide whether to add the element to the selection list
				boolean add = false;
				final Object bo = boc.getBusinessObject();
				if (selectingFlowSpecificationToImplement()) {
					if (bo instanceof FlowSpecification) {
						add = true;
					}
				} else if (selectingFlowIn()) {
					if (bo instanceof Feature) {
						add = true;
					}
				} else { // Selecting flow segments and modes
					if (bo instanceof ModeFeature) {
						add = true;
					} else {
						if (selectingFlowEnd() && bo instanceof Feature) {
							add = true;
						} else if (selectingConnectionFlow() && bo instanceof Connection) {
							add = true;
						} else if (selectingSubcomponentFlow() && bo instanceof FlowElement) {
							add = true;
						}
					}
				}

				if (add) {
					setErrorMessage(null);

					userSelections.add(boc);

					// Update the UI
					updateWidgets();
				}
			} else if (!isInit) {
				setErrorMessage("Invalid element selected. " + getDirectionMessage());
			}
		}

		private static String getName(final NamedElement ne) {
			return ne.getName() == null ? "<unknown>" : ne.getName();
		}

		private static String flowEndToString(final FlowEnd flowEnd) {
			final StringBuilder sb = new StringBuilder();
			if (flowEnd.getContext() != null) {
				sb.append(getName(flowEnd.getContext()));
				sb.append('.');
			}

			if (flowEnd.getFeature() != null) {
				sb.append(getName(flowEnd.getFeature()));
			}

			return sb.toString();
		}

		private static String flowSegmentToString(final FlowSegment flowSegment) {
			final StringBuilder sb = new StringBuilder();
			if (flowSegment.getContext() != null) {
				sb.append(getName(flowSegment.getContext()));
				sb.append('.');
			}

			if (flowSegment.getFlowElement() != null) {
				sb.append(getName(flowSegment.getFlowElement()));
			}

			return sb.toString();
		}

		private boolean isFlowImplValid(final FlowImplementation fi) {
			final Set<Diagnostic> diagnostics;
			final Optional<ComponentImplementation> optCi = getFlowComponentImplementation(getOwnerBoc().orElse(null));
			if (!optCi.isPresent()) {
				diagnostics = Collections.emptySet();
				setDefaultTitle();
			} else {
				final ComponentImplementation ci = optCi.get();

				// Update title
				setTitle("Creating Flow Implementation in: " + ci.getQualifiedName());
				diagnostics = ToolUtil.getModificationDiagnostics(ci, (resourceSet) -> {
					final ComponentImplementation objectToModify = (ComponentImplementation) resourceSet
							.getEObject(EcoreUtil.getURI(ci), true);
					objectToModify.setNoFlows(false);
					objectToModify.getOwnedFlowImplementations().add(fi);
					return objectToModify;
				});
			}

			// Update error table
			FlowDialogUtil.setInput(errorTableViewer, diagnostics);

			final Optional<Diagnostic> errorDiagnostic = diagnostics.stream()
					.filter(diagnostic -> diagnostic.getSeverity() == Diagnostic.ERROR).findAny();
			return !errorDiagnostic.isPresent();
		}

		private static Optional<ComponentImplementation> getFlowComponentImplementation(
				final BusinessObjectContext owner) {
			return getFlowBocToComponentImplementation(owner).map(entry -> entry.getValue());
		}

		private static Optional<BusinessObjectContext> getFlowComponentImplementationBoc(
				final BusinessObjectContext owner) {
			return getFlowBocToComponentImplementation(owner).map(entry -> entry.getKey());
		}

		private static Optional<SimpleEntry<BusinessObjectContext, ComponentImplementation>> getFlowBocToComponentImplementation(
				final BusinessObjectContext owner) {
			if (owner == null) {
				return Optional.empty();
			}

			final Object bo = owner.getBusinessObject();
			final ComponentImplementation ci;
			if (bo instanceof ComponentImplementation) {
				ci = ComponentImplementation.class.cast(bo);
			} else if (bo instanceof Subcomponent) {
				ci = Subcomponent.class.cast(bo).getComponentImplementation();
			} else {
				return Optional.empty();
			}

			return Optional.of(new SimpleEntry<BusinessObjectContext, ComponentImplementation>(owner, ci));
		}

		/**
		 * Updates the UI
		 */
		private void updateWidgets() {
			undoButton.setEnabled(!userSelections.isEmpty());

			final FlowImplementation fi = createFlow();
			isValid = isFlowImplValid(fi);

			updateMessage();

			getButton(IDialogConstants.OK_ID).setEnabled(isValid);

			// Update the flow implementation string
			if (fi.getSpecification() == null) {
				flowLabel.setStyleRange(null);
				flowLabel.setText("");
			} else {
				final FlowSpecification flowSpec = fi.getSpecification();
				String flowStr = flowSpec.getName() + ":";
				final int kindStartIndex = flowStr.length();
				flowStr += "  flow " + fi.getKind() + " ";
				final int kindEndIndex = flowStr.length();

				final List<String> flowSegmentStrings = new ArrayList<>();
				if (needsStartingFeature() && fi.getInEnd() != null) {
					flowSegmentStrings.add(flowEndToString(fi.getInEnd()));
				}

				for (final FlowSegment seg : fi.getOwnedFlowSegments()) {
					flowSegmentStrings.add(flowSegmentToString(seg));
				}

				if (needsEndingFeature() && fi.getOutEnd() != null) {
					flowSegmentStrings.add(flowEndToString(fi.getOutEnd()));
				}

				flowStr += flowSegmentStrings.stream().collect(Collectors.joining(" -> "));

				final int modeStartIndex = flowStr.length();
				if (!fi.getInModeOrTransitions().isEmpty()) {
					flowStr += " in modes (" + fi.getInModeOrTransitions().stream().map(mf -> mf.getName())
							.collect(Collectors.joining(", ")) + ")";
				}
				final int modeEndIndex = flowStr.length();

				flowStr += ";";

				flowLabel.setText(flowStr);

				// Adjust style of label
				flowLabel.setStyleRange(new StyleRange(kindStartIndex, kindEndIndex - kindStartIndex,
						Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				if (modeStartIndex != modeEndIndex) {
					flowLabel.setStyleRange(new StyleRange(modeStartIndex, 10,
							Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				}
			}

			coloring.clear();
			for (int i = 0; i < userSelections.size(); i++) {
				final BusinessObjectContext boc = userSelections.get(i);
				if (boc instanceof DiagramElement) {
					// Update diagram element highlighting
					final DiagramElement de = (DiagramElement) boc;
					if (i == 0) {
						coloring.setForeground(de, Color.ORANGE.darker());
					} else if (de instanceof ModeFeature) {
						coloring.setForeground(de, Color.MAGENTA.brighter());
					} else {
						coloring.setForeground(de, Color.MAGENTA.darker());
					}
				}
			}
		}

		private FlowSpecification getFlowSpecification() {
			// The flow specification should be the first thing selected by the user
			if (userSelections.isEmpty()) {
				return null;
			}

			return FlowSpecification.class.cast(userSelections.get(0).getBusinessObject());
		}

		/**
		 * Returns the business object context for the owner of the new flow implementation
		 * @return
		 */
		private Optional<BusinessObjectContext> getOwnerBoc() {
			// The flow specification should be the first thing selected by the user
			if (userSelections.isEmpty()) {
				return Optional.empty();
			}

			return Optional.of(userSelections.get(0).getParent());
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Flow Implementation Tool");
			newShell.setLocation(DialogPlacementHelper
					.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(800, 400);
			newShell.setMinimumSize(300, 215);
		}

		@Override
		public void create() {
			super.create();
			setDefaultTitle();
			ContextHelpUtil.setHelp(getShell(), ContextHelpUtil.FLOW_IMPL_TOOL);
			updateWidgets();
		}

		private void setDefaultTitle() {
			setTitle("Creating Flow Implementation");
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = FlowDialogUtil.createFlowArea(parent);
			flowComposite = FlowDialogUtil.createSegmentComposite(area);
			flowLabel = FlowDialogUtil.createFlowSegmentLabel(flowComposite);
			errorTableViewer = FlowDialogUtil.createErrorTableViewer(new Composite(area, SWT.NONE));

			return flowComposite;
		}

		@Override
		protected Control createButtonBar(final Composite parent) {
			final Composite buttonBar = new Composite(parent, SWT.NONE);
			final GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.numColumns = 2;
			buttonBar.setLayout(buttonBarLayout);
			final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
			buttonBar.setLayoutData(buttonBarData);
			buttonBar.setFont(parent.getFont());

			undoButton = new Button(buttonBar, SWT.PUSH);
			undoButton.setEnabled(false);
			undoButton.setText("Undo");
			undoButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					if (!userSelections.isEmpty()) {
						userSelections.remove(userSelections.size() - 1);
						uiService.clearSelection();
						updateWidgets();
					}
				}
			});

			final GridData removeBtnData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
			removeBtnData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			undoButton.setLayoutData(removeBtnData);

			final Control buttonControl = super.createButtonBar(buttonBar);
			buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
			return buttonBar;
		}
	}


}
