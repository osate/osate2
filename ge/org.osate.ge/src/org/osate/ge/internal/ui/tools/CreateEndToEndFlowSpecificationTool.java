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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.RefinableElement;
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
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.ui.util.DialogPlacementHelper;

public class CreateEndToEndFlowSpecificationTool {
	private ColoringService.Coloring coloring = null;
	private CreateFlowsToolsDialog dlg;
	private final List<BusinessObjectContext> userSelections = new ArrayList<>();

	@Activate
	public void activate(@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext selectedBoc,
			final AadlModificationService aadlModService, final UiService uiService,
			final ColoringService coloringService, final NamingService namingService) {
		try {
			// Check for existing errors or warnings
			final Set<Diagnostic> diagnostics = ToolUtil.getAllReferencedPackageDiagnostics(selectedBoc);
			if (!diagnostics.isEmpty()) {
				Display.getDefault()
				.asyncExec(() -> new FlowDialogUtil.ErrorDialog("The Create End-To-End",
						diagnostics).open());
			} else {
				coloring = coloringService.adjustColors(); // Create a coloring object that will allow adjustment of pictogram
				final Display display = Display.getCurrent();
				dlg = new CreateFlowsToolsDialog(display.getActiveShell(), namingService, uiService);
				// Create and update based on current selection
				dlg.create();
				update(new BusinessObjectContext[] { selectedBoc }, true);
				if (dlg.open() == Window.CANCEL) {
					return;
				}

				if (dlg != null) {
					dlg.getFlow().ifPresent(eteFlow -> {
						dlg.getOwnerComponentImplementation().ifPresent(ownerCi -> {
							aadlModService.modify(ownerCi, ci -> {
								ci.getOwnedEndToEndFlows().add(eteFlow);
								ci.setNoFlows(false);
							});
						});
					});
				}
			}
		} finally {
			uiService.deactivateActiveTool();
		}
	}

	@Deactivate
	public void deactivate() {
		// Dispose of the coloring object
		if (coloring != null) {
			coloring.dispose();
			coloring = null;
		}

		if (dlg != null) {
			dlg.close();
			dlg = null;
		}

		this.userSelections.clear();
	}

	@SelectionChanged
	public void onSelectionChanged(final @Named(Names.BUSINESS_OBJECT_CONTEXTS) BusinessObjectContext[] selectedBocs) {
		update(selectedBocs, false);
	}

	/**
	 * Update the diagram and tool dialog
	 * @param selectedBocs - the selected bocs
	 * @param isInit - whether the selected bocs are the inital selection when the tool was activated
	 */
	private void update(final BusinessObjectContext[] selectedBocs, final boolean isInit) {
		if (dlg != null && dlg.getShell() != null && !dlg.getShell().isDisposed() && dlg.flowSegmentComposite != null
				&& !dlg.flowSegmentComposite.isDisposed()) {
			// If the selection is a valid addition to the end to end flow specification, add it.
			if (selectedBocs.length > 1) {
				dlg.setErrorMessage("Multiple elements selected. Select a single element. " + " " + getDialogMessage());
			} else if (selectedBocs.length == 1) {
				// Get the selected boc
				final BusinessObjectContext selectedBoc = (BusinessObjectContext) selectedBocs[0];

				String error = null;
				if (!userSelections.contains(selectedBoc) && dlg.addSelectedElement(selectedBoc)) {
					// Set default name on first selection if one does not exist
					if (userSelections.isEmpty()) {
						dlg.findOwnerComponentImplementation(selectedBoc.getParent()).ifPresent(ci -> {
							dlg.setTitle("Creating End To End Flow in: " + ci.getQualifiedName());
							if (dlg.eTEFlow.getName().isEmpty()) {
								dlg.setEndToEndFlowName(ci);
							}
						});
					}

					if (selectedBoc instanceof DiagramElement) {
						final DiagramElement selectedDe = (DiagramElement) selectedBoc;
						if (selectedBoc.getBusinessObject() instanceof ModeFeature) {
							coloring.setForeground(selectedDe, Color.MAGENTA.brighter());
						} else if (dlg.eTEFlow != null && dlg.eTEFlow.getAllFlowSegments().size() == 1) {
							coloring.setForeground(selectedDe, Color.ORANGE.darker());
						} else {
							coloring.setForeground(selectedDe, Color.MAGENTA.darker());
						}
					}

					error = dlg.getNameErrorMessage().orElse(null);

					userSelections.add(selectedBoc);
				} else if (!isInit) {
					error = "Invalid element selected.  ";
				}

				final boolean isValid = dlg.isEndToEndFlowValid();
				if (!isValid) {
					error = Strings.emptyIfNull(error) + dlg.getValidFlowErrorMessage();
				}

				dlg.updateWidgets(isValid);

				if (error == null) {
					dlg.setErrorMessage(null);
					dlg.setMessage(getDialogMessage());
				} else {
					dlg.setErrorMessage(error + getDialogMessage());
				}
			}
		}
	}

	// Determine message based on currently selected element
	private String getDialogMessage() {
		String msg = "";
		if (!userSelections.isEmpty()) {
			final Object bo = userSelections.get(userSelections.size() - 1)
					.getBusinessObject();
			if (bo instanceof FlowSpecification || bo instanceof org.osate.aadl2.Connection) {
				if (bo instanceof FlowSpecification) {
					final FlowSpecification fs = (FlowSpecification) bo;
					if (fs.getKind() != FlowKind.SINK) {
						msg = "Select a connection.";
					}
				} else if (bo instanceof org.osate.aadl2.Connection) {
					msg = "Select a flow specification.";
				}
			} else {
				return dlg.getMessage();
			}
		} else {
			dlg.setDefaultTitle();
			msg = "Select a starting flow specification.";
		}

		if (msg.length() != 0) {
			msg += "\n";
		}
		msg += "Optionally, select a mode or mode transition.";

		return msg;
	}



	/**
	 * @param selectedEle - current element
	 * @param context - current context
	 * @return - true or false depending on if the selected element is a valid start element
	 */
	private boolean isValidFirstElement(final Element selectedEle, final Context context) {
		return selectedEle instanceof FlowSpecification
				&& ((FlowSpecification) selectedEle).getKind() == FlowKind.SOURCE && context instanceof Subcomponent;
	}

	private Element getRefinedElement(final Element ce) {
		if (ce instanceof RefinableElement) {
			final RefinableElement refinedElement = ((RefinableElement) ce).getRefinedElement();
			return refinedElement == null ? ce : getRefinedElement(refinedElement);
		}

		return ce;
	}

	private class CreateFlowsToolsDialog extends TitleAreaDialog {
		private final NamingService namingService;
		private final UiService uiService;
		private final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private final EndToEndFlow eTEFlow = (EndToEndFlow) pkg.getEFactoryInstance().create(pkg.getEndToEndFlow());
		private final List<String> segmentList = new ArrayList<String>();
		private final List<String> modeList = new ArrayList<String>();
		private final String invalidErrorMessage = "Invalid End-To-End Flow.  ";


		private EndToEndFlow flow;
		private Button undoButton;
		private Composite flowSegmentComposite;
		private TableViewer errorTableViewer;
		private StyledText flowSegmentLabel;
		private Text newETEFlowName;

		public CreateFlowsToolsDialog(final Shell parentShell, final NamingService namingService,
				final UiService uiService) {
			super(parentShell);
			setHelpAvailable(true);
			this.namingService = Objects.requireNonNull(namingService, "naming service must not be null");
			this.uiService = Objects.requireNonNull(uiService, "ui service must not be null");
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		public void setEndToEndFlowName(final Namespace namespace) {
			final String eteName = namingService.buildUniqueIdentifier(namespace, "new_ete_flow");
			eTEFlow.setName(eteName);
			newETEFlowName.setText(eteName);
		}

		private Optional<EndToEndFlow> getFlow() {
			return Optional.ofNullable(flow);
		}

		/**
		 * Determines if the object selected is valid
		 * @param selectedBoc - current selected element
		 * @param context - current context
		 * @return - true or false depending if the object selected is valid
		 */
		private boolean addSelectedElement(final BusinessObjectContext selectedBoc) {
			final Object selectedBo = selectedBoc.getBusinessObject();

			if (selectedBo instanceof Element) {
				final Context context = ToolUtil.findContext(selectedBoc);
				final Element selectedEle = (Element) selectedBo;
				if (isValid(getRefinedElement(selectedEle), context)) {
					if (selectedEle instanceof org.osate.aadl2.Connection) {
						// Create flow segment with context = null because all valid connections belong to diagram
						return addFlowSegmentOrModeFeature(createEndToEndFlowSegments(selectedEle, null));
					} else if (selectedEle instanceof FlowSpecification) {
						return addFlowSegmentOrModeFeature(createEndToEndFlowSegments(selectedEle, context));
					} else {
						return addFlowSegmentOrModeFeature(selectedEle);
					}
				}
			}
			return false;
		}

		/**
		 * @param ctx - context of element
		 * @param flowElement - element added to flow segments
		 * @return - name of segment for dialog
		 */
		private String getSegmentName(final Context ctx, final NamedElement flowElement) {
			String name = "";
			if (ctx != null) {
				name += ctx.getName() == null ? "<unknown>" : ctx.getName();
				name += ".";
			}
			name += flowElement.getName() == null ? "<unknown>" : flowElement.getName();
			return name;
		}

		private EndToEndFlowSegment createEndToEndFlowSegments(final Element selectedEle, final Context context) {
			final EndToEndFlowSegment eteFlowSegment = eTEFlow.createOwnedEndToEndFlowSegment();
			eteFlowSegment.setFlowElement((EndToEndFlowElement) selectedEle);
			eteFlowSegment.setContext(context);
			eTEFlow.getOwnedEndToEndFlowSegments().add(eteFlowSegment);
			return eteFlowSegment;
		}

		/**
		 * @param object - Flow segment or mode feature added to End to End Flow
		 * @return - true or false depending on if the object was added to End to End Flow
		 */
		private boolean addFlowSegmentOrModeFeature(final Object object) {
			if (!flowSegmentComposite.isDisposed()) {
				flowSegmentLabel.setEnabled(true);
				if (object instanceof EndToEndFlowSegment) {
					final EndToEndFlowSegment eteFlowSegment = (EndToEndFlowSegment) object;
					if (eTEFlow.getAllFlowSegments().indexOf(eteFlowSegment) == 0) {
						segmentList.add(getSegmentName(eteFlowSegment.getContext(), eteFlowSegment.getFlowElement()));
					} else {
						segmentList.add("  ->  "
								+ getSegmentName(eteFlowSegment.getContext(), eteFlowSegment.getFlowElement()));
					}
				} else if (object instanceof ModeFeature) {
					final ModeFeature mf = (ModeFeature) object;
					eTEFlow.getInModeOrTransitions().add(mf);
					if (eTEFlow.getInModeOrTransitions().size() == 1) {
						modeList.add("  in modes  (" + mf.getName());
					} else {
						modeList.add(", " + mf.getName());
					}
				}

				setEndToEndFlowString();
				return true;
			}
			return false;
		}

		/**
		 * Sets the dialog text for segments
		 */
		private void setEndToEndFlowString() {
			String segmentString = "";
			for (final String string : segmentList) {
				segmentString += string;
			}
			final String modeString = getModeString();
			flowSegmentLabel.setText(segmentString + modeString);
			if (modeString != "") {
				flowSegmentLabel.setStyleRange(new StyleRange(segmentString.length(), 12,
						Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
			}
		}

		private String getModeString() {
			String modeString = "";
			for (final String string : modeList) {
				modeString += string;
			}
			return modeString == "" ? modeString : modeString + ")";
		}

		// Returns the component implementation that will own the end to end flow
		private Optional<ComponentImplementation> getOwnerComponentImplementation() {
			// The flow specification should be the first thing selected by the user
			if (userSelections.size() == 0) {
				return Optional.empty();
			}

			return findOwnerComponentImplementation(userSelections.get(0).getParent());
		}

		private Optional<ComponentImplementation> findOwnerComponentImplementation(
				final BusinessObjectContext boc) {
			BusinessObjectContext tmp = boc.getParent();
			while (tmp != null) {
				if (tmp.getBusinessObject() instanceof ComponentImplementation) {
					return Optional.of((ComponentImplementation) tmp.getBusinessObject());
				} else if (tmp.getBusinessObject() instanceof Subcomponent) {
					return Optional.ofNullable(((Subcomponent) tmp.getBusinessObject()).getComponentImplementation());
				} else if (!(tmp.getBusinessObject() instanceof NamedElement)) {
					return Optional.empty();
				}

				tmp = tmp.getParent();
			}

			return Optional.empty();
		}

		private boolean isEndToEndFlowValid() {
			final Set<Diagnostic> diagnostics;
			final Optional<ComponentImplementation> optCi = getOwnerComponentImplementation();
			if (!optCi.isPresent()) {
				diagnostics = Collections.emptySet();
			} else {
				final ComponentImplementation ci = optCi.get();
				diagnostics = ToolUtil.getModificationDiagnostics(ci, (testResourceSet) -> {
					// Make modification with test resource
					final ComponentImplementation objectToModify = (ComponentImplementation) testResourceSet
							.getEObject(EcoreUtil.getURI(ci), true);

					objectToModify.getOwnedEndToEndFlows().add(eTEFlow);
					objectToModify.setNoFlows(false);

					return objectToModify;
				});
			}

			FlowDialogUtil.setInput(errorTableViewer, diagnostics);

			final Optional<Diagnostic> errorDiagnostic = diagnostics.stream()
					.filter(diagnostic -> diagnostic.getSeverity() == Diagnostic.ERROR).findAny();
			return !errorDiagnostic.isPresent();
		}

		private void updateWidgets(final boolean isValid) {
			dlg.setMessage(getDialogMessage());
			setNavigationButtonsEnabled(isValid && eTEFlow.getName().length() != 0);
		}

		private void setNavigationButtonsEnabled(final boolean enabled) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			}
			if (undoButton != null) {
				undoButton.setEnabled(eTEFlow != null
						&& (eTEFlow.getInModeOrTransitions().size() > 0 || eTEFlow.getAllFlowSegments().size() > 0));
			}
		}

		private Element getPreviousSegmentElement() {
			return eTEFlow.getAllFlowSegments().size() > 0
					? getRefinedElement(
							eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size() - 1).getFlowElement())
							: null;
		}

		/**
		 * Determines if the selected element is valid to be added to End to End Flow
		 * @param selectedEle - selected element
		 * @param context - context of element
		 */
		private boolean isValid(final Element selectedEle, final Context context) {
			if ((eTEFlow.getAllFlowSegments().size() == 0 && selectedEle instanceof FlowSpecification)) {
				return isValidFirstElement(selectedEle, context);
			} else if (selectedEle instanceof ModeFeature) {
				return true;
			} else {
				final Element prevEle = getRefinedElement(getPreviousSegmentElement());
				if (prevEle != null) {
					if ((prevEle instanceof org.osate.aadl2.Connection) && (selectedEle instanceof FlowSpecification)) {
						return true;
					} else if ((prevEle instanceof FlowSpecification)
							&& (selectedEle instanceof org.osate.aadl2.Connection)) {
						final FlowSpecification segFs = (FlowSpecification) prevEle;
						return segFs.getKind() != FlowKind.SINK;
					}
				}
			}

			return false;
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("End To End Flow Specification Tool");
			newShell.setLocation(DialogPlacementHelper
					.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(800, 400);
			newShell.setMinimumSize(460, 215);
		}

		@Override
		public void create() {
			super.create();
			setDefaultTitle();
			setMessage(CreateEndToEndFlowSpecificationTool.this.getDialogMessage());
			ContextHelpUtil.setHelp(getShell(), ContextHelpUtil.END_TO_END_TOOL);
		}

		private void setDefaultTitle() {
			setTitle("Creating End To End Flow Specification");
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = FlowDialogUtil.createFlowArea(parent);
			flowSegmentComposite = FlowDialogUtil.createSegmentComposite(area);
			flowSegmentLabel = FlowDialogUtil.createFlowSegmentLabel(flowSegmentComposite);
			errorTableViewer = FlowDialogUtil.createErrorTableViewer(new Composite(area, SWT.NONE));

			return flowSegmentComposite;
		}

		@Override
		protected Control createButtonBar(final Composite parent) {
			final Composite buttonBar = new Composite(parent, SWT.NONE);
			final GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.horizontalSpacing = 0;
			buttonBarLayout.numColumns = 4;
			buttonBar.setLayout(buttonBarLayout);
			final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
			buttonBar.setLayoutData(buttonBarData);
			buttonBar.setFont(parent.getFont());

			final Label nameLabel = new Label(buttonBar, SWT.NONE);
			nameLabel.setText("Name: ");
			final GridData nameLabelData = new GridData(SWT.LEFT, SWT.CENTER, false, true);
			nameLabelData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			nameLabel.setLayoutData(nameLabelData);

			newETEFlowName = new Text(buttonBar, SWT.SINGLE | SWT.LEFT | SWT.BORDER);
			final GridData nameTextData = new GridData(SWT.FILL, SWT.CENTER, true, false);
			newETEFlowName.setLayoutData(nameTextData);
			newETEFlowName.setEditable(true);
			newETEFlowName.setOrientation(SWT.LEFT_TO_RIGHT);

			newETEFlowName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(final KeyEvent e) {
					eTEFlow.setName(newETEFlowName.getText());
					final boolean isValid = isEndToEndFlowValid();
					final String error = getFlowErrorMessage(isValid).orElse(null);
					setErrorMessage(error);
					updateWidgets(isValid);
				}
			});

			undoButton = new Button(buttonBar, SWT.PUSH);
			undoButton.setEnabled(false);
			undoButton.setText("Undo");
			undoButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int prevBocsSize = userSelections.size();
					if (prevBocsSize > 0) {
						final BusinessObjectContext removedBoc = userSelections
								.get(prevBocsSize - 1);
						userSelections.remove(prevBocsSize - 1);
						if (removedBoc instanceof DiagramElement) {
							coloring.setForeground((DiagramElement) removedBoc, null);
						}

						final Object removedBo = removedBoc.getBusinessObject();
						if (removedBo instanceof ModeFeature) {
							eTEFlow.getInModeOrTransitions().remove(eTEFlow.getInModeOrTransitions().size() - 1);
						} else {
							final EndToEndFlowSegment flowSegment = eTEFlow.getAllFlowSegments()
									.get(eTEFlow.getAllFlowSegments().size() - 1);
							eTEFlow.getAllFlowSegments().remove(flowSegment);
							EcoreUtil.remove(flowSegment);
						}

						// Clear strings for refresh
						segmentList.clear();
						modeList.clear();
						flowSegmentLabel.setText("");
						for (final EndToEndFlowSegment segment : eTEFlow.getAllFlowSegments()) {
							addFlowSegmentOrModeFeature(segment);
						}
						for (final ModeFeature mf : eTEFlow.getInModeOrTransitions()) {
							addFlowSegmentOrModeFeature(mf);
						}

						uiService.clearSelection();

						final boolean isValid = isEndToEndFlowValid();
						String error = getFlowErrorMessage(isValid).orElse(null);

						if (error == null) {
							dlg.setErrorMessage(null);
							dlg.setMessage(getDialogMessage());
						} else {
							dlg.setErrorMessage(error + getDialogMessage());
						}

						updateWidgets(isValid);
					}
				}
			});

			final GridData removeBtnData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
			undoButton.setLayoutData(removeBtnData);

			super.createButtonBar(buttonBar);
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
			okBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					flow = eTEFlow;
				}
			});

			return buttonBar;
		}

		private Optional<String> getNameErrorMessage() {
			final String errorMsg;
			final Optional<ComponentImplementation> optCi = getOwnerComponentImplementation();
			if (optCi.isPresent() && namingService.isNameInUse(optCi.get(), newETEFlowName.getText())) {
				errorMsg = "The specified name is already is use.  ";
			} else if (!namingService.isValidIdentifier(newETEFlowName.getText())) {
				errorMsg = "Name is not a valid identifier.  ";
			} else {
				errorMsg = null;
			}

			return Optional.ofNullable(errorMsg);
		}

		private Optional<String> getFlowErrorMessage(final boolean isValid) {
			String error = getNameErrorMessage().orElse(null);
			if (!isValid) {
				return Optional.of(Strings.emptyIfNull(error) + getValidFlowErrorMessage());
			}

			return Optional.ofNullable(error);
		}

		private String getValidFlowErrorMessage() {
			return invalidErrorMessage;
		}
	}
}
