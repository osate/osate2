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

import javax.inject.Named;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.InternalNames;
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
	private BusinessObjectContext ciBoc;
	private ComponentImplementation ci;
	private final List<DiagramElement> previouslySelectedDiagramElements = new ArrayList<>();

	@Activate
	public void activate(@Named(InternalNames.SELECTED_DIAGRAM_ELEMENT) final BusinessObjectContext selectedBoc,
			final AadlModificationService aadlModService, final UiService uiService,
			final ColoringService coloringService, final NamingService namingService) {

		try {
			ciBoc = ToolUtil.findComponentImplementationBoc(selectedBoc);
			if (ciBoc != null) {
				this.ci = (ComponentImplementation) ciBoc.getBusinessObject();
				coloring = coloringService.adjustColors(); // Create a coloring object that will allow adjustment of pictogram

				uiService.clearSelection();
				final Display display = Display.getCurrent();
				dlg = new CreateFlowsToolsDialog(display.getActiveShell(), namingService, uiService);
				if (dlg.open() == Window.CANCEL) {
					return;
				}

				if (dlg != null && !dlg.getFlows().isEmpty()) {
					aadlModService.modify(ci, ci -> {
						for (EndToEndFlow eteFlow : dlg.getFlows()) {
							ci.getOwnedEndToEndFlows().add(eteFlow);
							ci.setNoFlows(false);
						}
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

		this.ciBoc = null;
		this.ci = null;
		this.previouslySelectedDiagramElements.clear();
	}

	@SelectionChanged
	public void onSelectionChanged(
			@Named(InternalNames.SELECTED_DIAGRAM_ELEMENTS) final DiagramElement[] selectedDiagramElements) {
		if (dlg != null && dlg.getShell() != null && dlg.getShell().isVisible()) {
			// If the selection is a valid addition to the end to end flow specification, add it.
			if (dlg.flowSegmentComposite != null && !dlg.flowSegmentComposite.isDisposed()) {
				if (selectedDiagramElements.length > 1) {
					dlg.setErrorMessage("Multiple diagram elements selected. Select a single diagram element. " + " "
							+ getDialogMessage());
				} else if (selectedDiagramElements.length == 1) {
					// Get the selected diagram element
					final DiagramElement selectedDiagramElement = selectedDiagramElements[0];

					final Object bo = selectedDiagramElement.getBusinessObject();
					final Context context = ToolUtil.findContext(selectedDiagramElement);

					if (bo instanceof Element) {
						String error = null;
						if (dlg.addSelectedElement((Element) bo, context)) {
							if (bo instanceof ModeFeature) {
								coloring.setForeground(selectedDiagramElement, Color.MAGENTA.brighter());
							} else if (dlg.eTEFlow != null && dlg.eTEFlow.getAllFlowSegments().size() == 1) {
								coloring.setForeground(selectedDiagramElement, Color.ORANGE.darker());
							} else {
								coloring.setForeground(selectedDiagramElement, Color.MAGENTA.darker());
							}
							previouslySelectedDiagramElements.add(selectedDiagramElement);
						} else {
							error = "Invalid element selected. ";
						}

						if (error == null) {
							dlg.setErrorMessage(null);
							dlg.setMessage(getDialogMessage());
						} else {
							dlg.setErrorMessage(error + " " + getDialogMessage());
						}
					}
				}
			}
		}
	}

	// Determine message based on currently selected element
	private String getDialogMessage() {
		String msg = "";
		if (previouslySelectedDiagramElements.size() > 0) {
			final Object bo = previouslySelectedDiagramElements.get(previouslySelectedDiagramElements.size() - 1)
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
			msg = "Select a starting flow specification.";
		}

		if (msg.length() != 0) {
			msg += "\n";
		}
		msg += "Optionally, select a mode or mode transition.";

		return msg;
	}

	private class CreateFlowsToolsDialog extends TitleAreaDialog {
		private final List<EndToEndFlow> flows = new ArrayList<EndToEndFlow>();
		private Button undoButton;
		private Composite flowSegmentComposite;
		private StyledText flowSegmentLabel;
		private Text newETEFlowName;
		private final NamingService namingService;
		private final UiService uiService;
		private final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		final List<String> segmentList = new ArrayList<String>();
		final List<String> modeList = new ArrayList<String>();
		private final EndToEndFlow eTEFlow = (EndToEndFlow) pkg.getEFactoryInstance().create(pkg.getEndToEndFlow());

		public CreateFlowsToolsDialog(final Shell parentShell, final NamingService namingService,
				final UiService uiService) {
			super(parentShell);
			setHelpAvailable(true);
			this.namingService = Objects.requireNonNull(namingService, "namingService must not be null");
			this.uiService = Objects.requireNonNull(uiService, "uiService must not be null");
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		private List<EndToEndFlow> getFlows() {
			return Collections.unmodifiableList(flows);
		}

		/**
		 * Determines if the object selected is valid
		 * @param selectedEle - current selected element
		 * @param context - current context
		 * @return - true or false depending if the object selected is valid
		 */
		private boolean addSelectedElement(final Element selectedEle, final Context context) {
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
			return false;
		}

		/**
		 * @param selectedEle - current element
		 * @param context - current context
		 * @return - true or false depending on if the selected element is a valid start element
		 */
		private boolean isValidFirstElement(final Element selectedEle, final Context context) {
			return selectedEle instanceof FlowSpecification
					&& ((FlowSpecification) selectedEle).getKind() == FlowKind.SOURCE
					&& isValidSubcomponent((Context) getRefinedElement(context));
		}

		/**
		 * Determines if subcomponent is valid context
		 * @param context - context of the selected element
		 */
		private boolean isValidSubcomponent(final Context context) {
			for (final Subcomponent subC : ci.getAllSubcomponents()) {
				if (areEquivalent(subC, context)) {
					return true;
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
					if (eTEFlow.getInModeOrTransitions().indexOf(mf) == 0) {
						modeList.add("  in modes  (" + mf.getName());
					} else {
						modeList.add(", " + mf.getName());
					}
				}

				setEndToEndFlowString();
				updateWidgets();
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

		private void updateWidgets() {
			dlg.setMessage(CreateEndToEndFlowSpecificationTool.this.getDialogMessage());
			setNavigationButtonsEnabled(isCompleteAndValid() && eTEFlow.getName().length() != 0);
		}

		private boolean isCompleteAndValid() {
			return (eTEFlow.getAllFlowSegments().size() > 2 && eTEFlow.getAllFlowSegments().size() % 2 == 1
					&& eTEFlow.getAllFlowSegments().get(0).getFlowElement() instanceof FlowSpecification
					&& eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size() - 1)
					.getFlowElement() instanceof FlowSpecification);
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
		 * Determines if the selected element is valid to be added to Flow Implementation
		 * @param selectedEle - selected element
		 * @param context - context of element
		 * @return
		 */
		private boolean isValid(final Element selectedEle, final Context context) {
			if ((eTEFlow.getAllFlowSegments().size() == 0 && selectedEle instanceof FlowSpecification)) {
				return isValidFirstElement(selectedEle, context);
			} else if (selectedEle instanceof ModeFeature) {
				return context == null;
			} else {
				final Element prevEle = getRefinedElement(getPreviousSegmentElement());
				if (prevEle != null) {
					if ((prevEle instanceof org.osate.aadl2.Connection) && (selectedEle instanceof FlowSpecification)
							&& isValidSubcomponent((Context) getRefinedElement(context))) {
						return true;
					} else if ((prevEle instanceof FlowSpecification)
							&& (selectedEle instanceof org.osate.aadl2.Connection)) {
						final FlowSpecification segFs = (FlowSpecification) prevEle;
						if (segFs.getKind() == FlowKind.SOURCE || segFs.getKind() == FlowKind.PATH) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection) selectedEle;
							return isValidConnection(segFs, con, context);
						}
					}
				}
			}
			return false;
		}

		private Element getRefinedElement(final Element ce) {
			if (ce instanceof RefinableElement) {
				final RefinableElement refinedElement = ((RefinableElement) ce).getRefinedElement();
				return refinedElement == null ? ce : getRefinedElement(refinedElement);
			}

			return ce;
		}

		/**
		 * Check the connections validity
		 * @param fs - previous FlowSpecification selected
		 * @param connection - current selected connection
		 * @param context - context of the connection
		 */
		private boolean isValidConnection(final FlowSpecification fs, final org.osate.aadl2.Connection connection,
				final Context context) {
			if (context != null && !isValidSubcomponent((Context) getRefinedElement(context))) {
				return false;
			}

			if (connection.getDestination().getContext() != null && connection.getSource().getContext() != null) {
				return true;
			}

			return false;
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Create End To End Flow Specification");
			newShell.setLocation(DialogPlacementHelper
					.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(800, 400);
			newShell.setMinimumSize(460, 215);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select Elements");
			setMessage(CreateEndToEndFlowSpecificationTool.this.getDialogMessage());
			ContextHelpUtil.setHelp(getShell(), ContextHelpUtil.END_TO_END_TOOL);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			flowSegmentComposite = (Composite) super.createDialogArea(parent);
			GridLayout layout = (GridLayout) flowSegmentComposite.getLayout();
			layout.marginLeft = 10;
			layout.marginTop = 5;

			flowSegmentLabel = new StyledText(flowSegmentComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
			flowSegmentLabel.setEditable(false);
			flowSegmentLabel.setEnabled(false);
			flowSegmentLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			flowSegmentLabel.setMargins(5, 5, 5, 5);
			flowSegmentLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

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
					final String errorMsg;
					if (!namingService.isValidIdentifier(newETEFlowName.getText())) {
						errorMsg = "Name is not a valid identifier";
					} else if (namingService.isNameInUse(ci, newETEFlowName.getText())) {
						errorMsg = "The specified name is already is use.";
					} else {
						errorMsg = null;
					}

					dlg.setErrorMessage(errorMsg);
					eTEFlow.setName(newETEFlowName.getText());
					updateWidgets();
				}
			});

			undoButton = new Button(buttonBar, SWT.PUSH);
			undoButton.setEnabled(false);
			undoButton.setText("Undo");
			undoButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int prevDiagramElementsSize = previouslySelectedDiagramElements.size();
					if (prevDiagramElementsSize > 0) {
						final DiagramElement removedDiagramElement = previouslySelectedDiagramElements
								.get(prevDiagramElementsSize - 1);
						previouslySelectedDiagramElements.remove(prevDiagramElementsSize - 1);
						coloring.setForeground(removedDiagramElement, null);

						final Object removedDiagramElementBo = removedDiagramElement.getBusinessObject();
						if (removedDiagramElementBo instanceof ModeFeature) {
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
						for (EndToEndFlowSegment c : eTEFlow.getAllFlowSegments()) {
							addFlowSegmentOrModeFeature(c);
						}
						for (ModeFeature m : eTEFlow.getInModeOrTransitions()) {
							addFlowSegmentOrModeFeature(m);
						}

						uiService.clearSelection();
						updateWidgets();
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
					flows.add(eTEFlow);
				}
			});

			return buttonBar;
		}
	}

	private static boolean areEquivalent(final Object bo1, final Object bo2) {
		if (!(bo1 instanceof NamedElement && bo2 instanceof NamedElement)) {
			return false;
		}

		final String n1 = ((NamedElement) bo1).getName();
		final String n2 = ((NamedElement) bo2).getName();
		return n1 != null && n1.equalsIgnoreCase(n2);
	}
}
