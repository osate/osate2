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
package org.osate.ge.aadl2.ui.internal.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.aadl2.ui.internal.tools.FlowDialogUtil.SegmentData;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.botree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.botree.Completeness;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.internal.ui.tools.ActivatedEvent;
import org.osate.ge.internal.ui.tools.DeactivatedEvent;
import org.osate.ge.internal.ui.tools.SelectionChangedEvent;
import org.osate.ge.internal.ui.tools.Tool;
import org.osate.ge.internal.ui.tools.ToolUtil;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.ui.util.DialogPlacementHelper;

public class CreateEndToEndFlowSpecificationTool implements Tool {
	private ColoringService.Coloring coloring = null;
	private CreateFlowsToolsDialog createFlowDialog;
	private final AgeDiagramEditor editor;

	// Flow segment selections
	private final List<SegmentData> segmentSelections = new ArrayList<>();
	// In mode feature selections
	private final ArrayList<BusinessObjectContext> modeFeatureSelections = new ArrayList<>();

	public CreateEndToEndFlowSpecificationTool(final AgeDiagramEditor editor, final DiagramElement container,
			final EndToEndFlow endToEndFlow) {
		this.editor = editor;
		final ReferenceService referenceService = Objects.requireNonNull(Adapters.adapt(editor, ReferenceService.class),
				"unable to retrieve reference service");

		final Display display = Display.getCurrent();
		final UiService uiService = Adapters.adapt(editor, UiService.class);
		createFlowDialog = new CreateFlowsToolsDialog(display.getActiveShell(), container, endToEndFlow, uiService);
		createFlowDialog.setEndToEndFlowName(endToEndFlow.getName());

		// Find segments in order
		endToEndFlow.getAllFlowSegments().stream().map(
				flowSegment -> FlowToolUtil.createSegmentData(referenceService, container, flowSegment))
		.forEachOrdered(segmentSelections::add);

		endToEndFlow.getInModeOrTransitions().stream().map(modeFeature -> FlowToolUtil
				.findOrCreateBusinessObjectContext(referenceService, container, modeFeature))
		.forEachOrdered(modeFeatureSelections::add);
	}

	public CreateEndToEndFlowSpecificationTool(final AgeDiagramEditor editor) {
		this.editor = editor;

		final Display display = Display.getCurrent();
		final UiService uiService = Adapters.adapt(editor, UiService.class);
		createFlowDialog = new CreateFlowsToolsDialog(display.getActiveShell(), null, null, uiService);
	}

	@Override
	public void activated(final ActivatedEvent ctx) {
		final UiService uiService = ctx.getUiService();
		try {
			ctx.getSelectedBoc().ifPresent(selectedBoc -> {
				final AadlModificationService aadlModService = ctx.getAadlModificatonService();
				final ColoringService coloringService = ctx.getColoringService();

				// Check for existing errors or warnings
				final Set<Diagnostic> diagnostics = ToolUtil.getAllReferencedPackageDiagnostics(selectedBoc);
				if (!diagnostics.isEmpty()) {
					Display.getDefault().asyncExec(
							() -> new FlowDialogUtil.ErrorDialog("The Create End-To-End", diagnostics).open());
				} else {
					coloring = coloringService.adjustColors(); // Create a coloring object that will allow adjustment of pictogram
					// Create and update based on current selection
					createFlowDialog.create();
					if (segmentSelections.isEmpty() && modeFeatureSelections.isEmpty()) {
						update(Collections.singletonList(selectedBoc), true);
					} else {
						final Iterator<SegmentData> segmentIt = segmentSelections.iterator();
						while (segmentIt.hasNext()) {
							final SegmentData segmentData = segmentIt.next();
							setColor(segmentData, Color.MAGENTA.darker());
						}

						for (Iterator<BusinessObjectContext> modeFeatureIt = modeFeatureSelections
								.iterator(); modeFeatureIt
								.hasNext(); setColor(modeFeatureIt.next(), Color.MAGENTA.brighter())) {
						}

						update();
					}

					if (createFlowDialog.open() == Window.OK && createFlowDialog != null) {
						createFlowDialog.getFlow().ifPresent(endToEndFlow -> {
							if (createFlowDialog.eteFlowToEdit != null) {
								// Editing end to end flow
								final EndToEndFlow endToEndFlowToEdit = (EndToEndFlow) createFlowDialog.eteFlowToEdit;
								aadlModService.modify(endToEndFlowToEdit, eTEFlowToEdit -> {
									eTEFlowToEdit.getAllFlowSegments().clear();
									eTEFlowToEdit.getAllFlowSegments().addAll(endToEndFlow.getAllFlowSegments());
									eTEFlowToEdit.setName(endToEndFlow.getName());
									eTEFlowToEdit.getInModeOrTransitions().clear();
									eTEFlowToEdit.getInModeOrTransitions()
									.addAll(endToEndFlow.getInModeOrTransitions());
								});
							} else {
								// Creating end to end flow
								createFlowDialog.getOwnerComponentImplementation().ifPresent(ownerCi -> {
									aadlModService.modify(ownerCi, ci -> {
										ci.getOwnedEndToEndFlows().add(endToEndFlow);
										ci.setNoFlows(false);
									});
								});
							}
						});
					}
				}
			});
		} finally {
			uiService.deactivateActiveTool();
		}
	}

	@Override
	public void deactivated(final DeactivatedEvent ctx) {
		// Dispose of the coloring object
		if (coloring != null) {
			coloring.dispose();
			coloring = null;
		}

		if (createFlowDialog != null) {
			if (createFlowDialog.elementSelectionDlg != null) {
				createFlowDialog.elementSelectionDlg.close();
				createFlowDialog.elementSelectionDlg = null;
			}

			createFlowDialog.close();
			createFlowDialog = null;
		}

		segmentSelections.clear();
		modeFeatureSelections.clear();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent ctx) {
		update(ctx.getSelectedBocs(), false);
	}

	/**
	 * Update the diagram and tool dialog
	 */
	public void update() {
		if (createFlowDialog != null) {
			if (createFlowDialog.getShell() != null && !createFlowDialog.getShell().isDisposed()
					&& createFlowDialog.flowComposite != null && !createFlowDialog.flowComposite.isDisposed()) {
				// Set the name field to the flow being edited
				if (createFlowDialog.newETEFlowName.getText().isEmpty()) {
					createFlowDialog.setFlowNameText(AgeAadlUtil.getRootName(createFlowDialog.eteFlowToEdit));
				}

				final EndToEndFlow endToEndFlow = createEndToEndFlow();
				String error = null;
				final boolean isValid = createFlowDialog.isEndToEndFlowValid(endToEndFlow);
				if (!isValid) {
					error = createFlowDialog.getValidFlowErrorMessage();
				}

				createFlowDialog.updateSegments();
				createFlowDialog.updateWidgets(isValid);

				if (error == null) {
					createFlowDialog.setErrorMessage(null);
					createFlowDialog.setMessage(getDialogMessage());
				} else {
					createFlowDialog.setErrorMessage(error + getDialogMessage());
				}
			}
		}
	}

	/**
	 * Create an EndToEndFlow based on user selections
	 */
	private EndToEndFlow createEndToEndFlow() {
		final EndToEndFlow endToEndFlow = (EndToEndFlow) createFlowDialog.pkg.getEFactoryInstance()
				.create(createFlowDialog.pkg.getEndToEndFlow());
		endToEndFlow.setName(createFlowDialog.endToEndFlowName);
		segmentSelections.forEach(entry -> {
			final BusinessObjectContext boc = entry.getBoc();
			final EndToEndFlowSegment eTEFlowSegment = endToEndFlow.createOwnedEndToEndFlowSegment();
			final EndToEndFlowElement eTEFlowElement = (EndToEndFlowElement) boc.getBusinessObject();
			if (!(boc.getBusinessObject() instanceof Connection)
					&& !(boc.getBusinessObject() instanceof DataSubcomponent)
					&& !(boc.getBusinessObject() instanceof EndToEndFlow)) {
				final Context context = ToolUtil.findContext(boc);
				eTEFlowSegment.setContext(context);
			}
			eTEFlowSegment.setFlowElement(eTEFlowElement);
			endToEndFlow.getOwnedEndToEndFlowSegments().add(eTEFlowSegment);
		});

		modeFeatureSelections.forEach(modeFeatureBoc -> endToEndFlow.getInModeOrTransitions()
				.add((ModeFeature) modeFeatureBoc.getBusinessObject()));

		return endToEndFlow;
	}

	/**
	 * Update the diagram and tool dialog
	 * @param selectedBocs - the selected bocs
	 * @param isInit - whether the selected bocs are the initial selection when the tool was activated
	 */
	private void update(final List<BusinessObjectContext> selectedBocs, final boolean isInit) {
		if (createFlowDialog != null) {
			if (createFlowDialog.getShell() != null && !createFlowDialog.getShell().isDisposed()
					&& createFlowDialog.elementSelectionDlg == null) {
				// If the selection is qualified, add it
				if (selectedBocs.size() > 1) {
					createFlowDialog.setErrorMessage(
							"Multiple elements selected. Select a single element. " + " " + getDialogMessage());
				} else if (selectedBocs.size() == 1) {
					// Get the selected boc
					final BusinessObjectContext selectedBoc = (BusinessObjectContext) selectedBocs.get(0);
					String error = null;
					if (!modeFeatureSelections.contains(selectedBoc)
							&& createFlowDialog.addSelectedElement(selectedBoc)) {
						// Insert flow segments before first mode feature
						final Color color;
						if (selectedBoc.getBusinessObject() instanceof ModeFeature) {
							modeFeatureSelections.add(selectedBoc);
							color = Color.MAGENTA.brighter();
						} else {
							segmentSelections.add(new SegmentData(selectedBoc, new ArrayList<>()));
							if (segmentSelections.size() == 1) {
								// Set default name on first selection if one does not exist
								createFlowDialog.getOwnerComponentImplementation().ifPresent(ci -> {
									createFlowDialog.setTitle("Creating End To End Flow in: " + ci.getQualifiedName());
									if (createFlowDialog.endToEndFlowName.isEmpty()) {
										createFlowDialog.setEndToEndFlowName(ci);
									}
								});

								color = Color.ORANGE.darker();
							} else {
								color = Color.MAGENTA.darker();
							}
						}

						setColor(selectedBoc, color);
					} else if (!isInit) {
						error = "Invalid element selected.  ";
					}

					createFlowDialog.updateSegments();
					final boolean isValid = createFlowDialog.isEndToEndFlowValid(createEndToEndFlow());
					if (!isValid) {
						error = Strings.emptyIfNull(error) + createFlowDialog.getValidFlowErrorMessage();
					}

					createFlowDialog.updateWidgets(isValid);

					if (error == null) {
						createFlowDialog.setErrorMessage(null);
						createFlowDialog.setMessage(getDialogMessage());
					} else {
						createFlowDialog.setErrorMessage(error + getDialogMessage());
					}
				} else {
					createFlowDialog.updateSegments();
				}
			} else if (createFlowDialog.elementSelectionDlg != null
					&& createFlowDialog.elementSelectionDlg.getShell() != null
					&& !createFlowDialog.elementSelectionDlg.getShell().isDisposed()
					&& createFlowDialog.elementSelectionDlg.getShell().isVisible()) {
				final CreateFlowsToolsDialog.ElementSelectionDialog elementSelectionDlg = createFlowDialog.elementSelectionDlg;
				// Selecting an element for editing end to end flows
				if (selectedBocs.size() > 1) {
					elementSelectionDlg
					.setErrorMessage("Multiple elements are selected.\n " + elementSelectionDlg.getMessage());
					elementSelectionDlg.setSelection(null);
				} else if (selectedBocs.size() == 1) {
					elementSelectionDlg.setErrorMessage(null);
					final BusinessObjectContext selectedBoc = selectedBocs.get(0);
					elementSelectionDlg.setSelection(selectedBoc);
				}
			}
		}
	}

	private void setColor(final Object o, final Color color) {
		if (o instanceof DiagramElement) {
			final DiagramElement de = (DiagramElement) o;
			coloring.setForeground(de, color);
		} else if (o instanceof SegmentData) {
			final SegmentData segmentData = (SegmentData) o;
			final BusinessObjectContext boc = segmentData.getBoc();
			// Do not remove color from duplicate segments
			if (color == null) {
				for (final SegmentData sd : segmentSelections) {
					if (sd.getBoc() == boc) {
						return;
					}
				}
			}

			setColor(boc, color);
			segmentData.getOwnedSegments().forEach(de -> setColor(de, color));
		}
	}

	// Determine message based on currently selected element
	private String getDialogMessage() {
		String msg = "";
		if (!segmentSelections.isEmpty()) {
			msg = "Select a flow segment.";
		} else {
			createFlowDialog.setDefaultTitle();
			msg = "Select a starting flow specification.";
		}
		msg += "\nOptionally, select a mode or mode transition.";

		return msg;
	}

	private class CreateFlowsToolsDialog extends TitleAreaDialog {
		private final UiService uiService;
		private final Aadl2Package pkg = Aadl2Package.eINSTANCE;
		private final String invalidErrorMessage = "Invalid End-To-End Flow.  ";
		private DiagramElement eteFlowToEditContainer;
		private final EndToEndFlow eteFlowToEdit;
		private String endToEndFlowName = "";
		private EndToEndFlow flow;
		private Composite flowComposite;
		private TableViewer errorTableViewer;
		private Text newETEFlowName;

		private ElementSelectionDialog elementSelectionDlg;

		public CreateFlowsToolsDialog(final Shell parentShell, final DiagramElement eteFlowToEditContainer,
				final EndToEndFlow eteFlowToEdit,
				final UiService uiService) {
			super(parentShell);
			setHelpAvailable(true);
			this.eteFlowToEditContainer = eteFlowToEditContainer;
			this.eteFlowToEdit = eteFlowToEdit;
			this.uiService = Objects.requireNonNull(uiService, "ui service must not be null");
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		// Creates a name based on namespace, sets the end to end flow name and text field
		public void setEndToEndFlowName(final Namespace namespace) {
			final String eteName = AadlNamingUtil.buildUniqueIdentifier(namespace, "new_ete_flow");
			setEndToEndFlowName(eteName);
			setFlowNameText(eteName);
		}

		// Set end to end flow name
		public void setEndToEndFlowName(final String name) {
			endToEndFlowName = name;
		}

		// Set end to end flow name text field
		public void setFlowNameText(final String name) {
			newETEFlowName.setText(name);
		}

		private Optional<EndToEndFlow> getFlow() {
			return Optional.ofNullable(flow);
		}

		/**
		 * Determines if the object selected is valid
		 * @param selectedBoc - current selected element
		 * @return - true or false depending if the object selected is valid
		 */
		private boolean addSelectedElement(final BusinessObjectContext selectedBoc) {
			final Object selectedBo = selectedBoc.getBusinessObject();
			if (selectedBo instanceof NamedElement) {
				final Context context = ToolUtil.findContext(selectedBoc);
				final NamedElement selectedEle = (NamedElement) selectedBo;
				return isValid(AgeAadlUtil.getRootRefinedElement(selectedEle),
						(Context) AgeAadlUtil.getRootRefinedElement(context));
			}

			return false;
		}

		// Returns the component implementation that will own the end to end flow
		private Optional<ComponentImplementation> getOwnerComponentImplementation() {
			if (eteFlowToEditContainer != null) {
				// Get owner from end to end flow being edited
				return findOwnerComponentImplementation(eteFlowToEditContainer);
			}

			if (segmentSelections.size() == 0) {
				return Optional.empty();
			}

			final BusinessObjectContext firstSelection = segmentSelections.iterator().next().getBoc();
			final Object bo = firstSelection.getBusinessObject();
			if (bo instanceof EndToEndFlow) {
				final EndToEndFlow eTEFlow = (EndToEndFlow) bo;
				return Optional.of(eTEFlow.getContainingComponentImpl());
			}

			final BusinessObjectContext parent = firstSelection.getParent();
			// If parent of selection is subcomponent, get component impl from parent
			if (parent.getBusinessObject() instanceof Subcomponent) {
				return findOwnerComponentImplementation(parent.getParent());
			}

			// Return first component implementation found
			return findOwnerComponentImplementation(parent);
		}

		private Optional<ComponentImplementation> findOwnerComponentImplementation(final BusinessObjectContext boc) {
			BusinessObjectContext tmp = boc;
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

		private boolean isEndToEndFlowValid(final EndToEndFlow endToEndFlow) {
			final Set<Diagnostic> diagnostics;
			final Optional<ComponentImplementation> optCi = getOwnerComponentImplementation();
			if (!optCi.isPresent()) {
				if (!segmentSelections.isEmpty()) {
					return false;
				} else {
					diagnostics = Collections.emptySet();
				}
			} else {
				final ComponentImplementation ci = optCi.get();
				diagnostics = ToolUtil.getModificationDiagnostics(ci, modifyObject(endToEndFlow, ci));
			}

			FlowDialogUtil.setInput(errorTableViewer, diagnostics);

			final Optional<Diagnostic> errorDiagnostic = diagnostics.stream()
					.filter(diagnostic -> diagnostic.getSeverity() == Diagnostic.ERROR).findAny();
			return !errorDiagnostic.isPresent();
		}

		private Function<ResourceSet, EObject> modifyObject(final EndToEndFlow endToEndFlow,
				final ComponentImplementation ci) {
			return resourceSet -> {
				// Make modification with test resource
				ComponentImplementation objectToModify = (ComponentImplementation) resourceSet
						.getEObject(EcoreUtil.getURI(ci), true);
				if (eteFlowToEdit != null) {
					final EndToEndFlow endToEndFlowToEdit = getFlowToEdit(objectToModify);
					objectToModify = (ComponentImplementation) resourceSet
							.getEObject(EcoreUtil.getURI(eteFlowToEdit.getContainingComponentImpl()), true);

					endToEndFlowToEdit.getAllFlowSegments().clear();
					endToEndFlowToEdit.getAllFlowSegments().addAll(endToEndFlow.getAllFlowSegments());
					endToEndFlowToEdit.setName(endToEndFlow.getName());
					endToEndFlowToEdit.getInModeOrTransitions().clear();
					endToEndFlow.getInModeOrTransitions().forEach(mf -> endToEndFlowToEdit.getInModeOrTransitions()
							.add((ModeFeature) resourceSet.getEObject(EcoreUtil.getURI(mf), true)));
				} else {
					objectToModify.getOwnedEndToEndFlows().add(endToEndFlow);
					objectToModify.setNoFlows(false);
				}
				return objectToModify;
			};
		}

		// Get flow to edit from resource set
		private EndToEndFlow getFlowToEdit(final ComponentImplementation objectToModify) {
			final String name = AgeAadlUtil.getRootName(eteFlowToEdit);
			for (final EndToEndFlow flow : objectToModify.getAllEndToEndFlows()) {
				if (AgeAadlUtil.getRootName(flow).equalsIgnoreCase(name)) {
					return flow;
				}
			}

			throw new RuntimeException("Cannot find end to end flow: " + name);
		}

		private void updateWidgets(final boolean isValid) {
			createFlowDialog.setMessage(getDialogMessage());
			setNavigationButtonsEnabled(isValid && createFlowDialog.endToEndFlowName.length() != 0);
		}

		private void updateSegments() {
			// Clear existing controls
			for (final Control child : flowComposite.getChildren()) {
				child.dispose();
			}

			if (segmentSelections.isEmpty()) {
				// Button to start with ETEFlow segment
				final Button emptySegmentsButton = new Button(flowComposite, SWT.PUSH);
				emptySegmentsButton.setText("Insert End to End Flow");
				emptySegmentsButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						elementSelectionDlg = new SelectEndToEndFlowDialog(createFlowDialog.getShell(),
								EndToEndFlow.class, "Select End to End Flow");
						createFlowDialog.addSegment(() -> emptySegmentsButton.dispose());
					}
				});
			} else {
				final Iterator<SegmentData> segmentsIt = segmentSelections.iterator();
				while (segmentsIt.hasNext()) {
					final SegmentData flowSegment = segmentsIt.next();
					final BusinessObjectContext boc = flowSegment.getBoc();
					final StringBuilder segmentNameBuilder = new StringBuilder();
					final Context context = ToolUtil.findContext(boc);
					if (context != null) {
						segmentNameBuilder.append(AgeAadlUtil.getRootName(context));
						segmentNameBuilder.append(".");
					}

					segmentNameBuilder.append(AgeAadlUtil.getRootName((NamedElement) boc.getBusinessObject()));

					createSegmentButton(flowComposite,
							segmentNameBuilder.toString(),
							flowSegment);

					// If segment is not last, add an arrow
					if (segmentsIt.hasNext()) {
						FlowDialogUtil.createArrowText(flowComposite);
					}
				}
			}

			if (!modeFeatureSelections.isEmpty()) {
				FlowDialogUtil.createInModeText(flowComposite);

				final Iterator<BusinessObjectContext> it = modeFeatureSelections.iterator();
				final BusinessObjectContext boc = it.next();
				createSegmentButton(flowComposite,
						"(" + ((NamedElement) boc.getBusinessObject()).getName() + (it.hasNext() ? "," : ")"), boc);

				while (it.hasNext()) {
					final BusinessObjectContext mode = it.next();
					createSegmentButton(flowComposite,
							((NamedElement) mode.getBusinessObject()).getName() + (it.hasNext() ? "," : ")"), mode);
				}
			}

			flowComposite.layout(true, true);
		}

		private void setNavigationButtonsEnabled(final boolean enabled) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			}
		}

		private Button createSegmentButton(final Composite parent, final String text, final SegmentData flowSegment) {
			final Button segmentButton = new Button(parent, SWT.FLAT);
			segmentButton.setText(text);
			segmentButton.setEnabled(true);
			segmentButton.setLayoutData(new RowData());

			// Create cascading popup menu for editing flow
			final Menu editMenu = new Menu(segmentButton);
			MenuItem cascadeItem = new MenuItem(editMenu, SWT.CASCADE);
			cascadeItem.setText("Replace With");
			Menu subMenu = new Menu(editMenu);
			cascadeItem.setMenu(subMenu);

			Runnable replace = () -> createFlowDialog.addSegment(Optional.of(() -> {
				segmentSelections.remove(flowSegment);
				setColor(flowSegment, null);
			}), flowSegment, false);

			createElementButton(subMenu, "Element", EndToEndFlowElement.class, replace);
			createETEFlowButton(subMenu, "End To End Flow", replace);

			cascadeItem = new MenuItem(editMenu, SWT.CASCADE);
			cascadeItem.setText("Insert");
			subMenu = new Menu(editMenu);
			cascadeItem.setMenu(subMenu);

			MenuItem insertCascadeItem = new MenuItem(subMenu, SWT.CASCADE);
			insertCascadeItem.setText("Element");
			Menu insertSubmenu = new Menu(editMenu);
			insertCascadeItem.setMenu(insertSubmenu);

			final Runnable insertBefore = () -> createFlowDialog.addSegment(flowSegment, false);
			final Runnable insertAfter = () -> createFlowDialog.addSegment(flowSegment, true);

			createElementButton(insertSubmenu, "Before", EndToEndFlowElement.class, insertBefore);
			createElementButton(insertSubmenu, "After", EndToEndFlowElement.class, insertAfter);

			insertCascadeItem = new MenuItem(subMenu, SWT.CASCADE);
			insertCascadeItem.setText("End to End Flow");
			insertSubmenu = new Menu(editMenu);
			insertCascadeItem.setMenu(insertSubmenu);

			createETEFlowButton(insertSubmenu, "Before", insertBefore);
			createETEFlowButton(insertSubmenu, "After", insertAfter);

			createRemoveButton(editMenu, () -> {
				segmentSelections.remove(flowSegment);
				setColor(flowSegment, null);
				if (!segmentSelections.isEmpty()) {
					// Update color for first segment
					final SegmentData newStartSegment = segmentSelections.get(0);
					setColor(newStartSegment, Color.ORANGE.darker());
				}

				uiService.clearSelection();
			});

			segmentButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// Show menu at bottom of button
					final Point location = segmentButton.getLocation();
					editMenu.setLocation(Display.getCurrent().map(createFlowDialog.flowComposite, null,
							new Point(location.x, location.y + segmentButton.getSize().y)));
					editMenu.setVisible(true);
				};
			});

			return segmentButton;
		}

		private void createETEFlowButton(final Menu subMenu, final String text, final Runnable runnable) {
			final MenuItem replaceWithETEFlow = new MenuItem(subMenu, SWT.PUSH);
			replaceWithETEFlow.setText(text);
			replaceWithETEFlow.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					elementSelectionDlg = new SelectEndToEndFlowDialog(createFlowDialog.getShell(), EndToEndFlow.class,
							"Select Replacement End to End Flow");
					runnable.run();
				}
			});
		}

		private void createElementButton(final Menu menu, final String text, final Class<?> clazz,
				final Runnable runnable) {
			final MenuItem insertAfter = new MenuItem(menu, SWT.PUSH);
			insertAfter.setText(text);
			insertAfter.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					elementSelectionDlg = new SelectSegmentOrModeFeatureDialog(createFlowDialog.getShell(), clazz,
							"Select Replacement Element");
					runnable.run();
				}
			});
		}

		private void createRemoveButton(final Menu menu, final Runnable runnable) {
			final MenuItem remove = new MenuItem(menu, SWT.PUSH);
			remove.setText("Remove");
			remove.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					runnable.run();

					final EndToEndFlow endToEndFlow = createEndToEndFlow();
					final boolean isValid = createFlowDialog.isEndToEndFlowValid(endToEndFlow);

					createFlowDialog.updateSegments();

					final String error = createFlowDialog.getFlowErrorMessage(isValid).orElse(null);

					if (error == null) {
						createFlowDialog.setErrorMessage(null);
						createFlowDialog.setMessage(getDialogMessage());
					} else {
						createFlowDialog.setErrorMessage(error + getDialogMessage());
					}

					createFlowDialog.updateWidgets(isValid);
				}
			});
		}

		private Button createSegmentButton(final Composite parent, final String text, final BusinessObjectContext boc) {
			final Button segmentButton = new Button(parent, SWT.FLAT);
			segmentButton.setText(text);
			segmentButton.setEnabled(true);
			segmentButton.setLayoutData(new RowData());

			final Menu menu = new Menu(getShell(), SWT.POP_UP);
			createElementButton(menu, "Replace", ModeFeature.class, () -> {
				createFlowDialog.addInModeFeature(Optional.of(() -> {
					modeFeatureSelections.remove(boc);
					setColor(boc, null);
				}), boc, false);
			});

			final MenuItem cascadeItem = new MenuItem(menu, SWT.CASCADE);
			cascadeItem.setText("Insert");
			final Menu subMenu = new Menu(menu);
			cascadeItem.setMenu(subMenu);

			createElementButton(subMenu, "Before", ModeFeature.class, () -> {
				createFlowDialog.addInModeFeature(boc, false);
			});

			createElementButton(subMenu, "After", ModeFeature.class, () -> {
				createFlowDialog.addInModeFeature(boc, true);
			});

			createRemoveButton(menu, () -> {
				modeFeatureSelections.remove(boc);
				setColor(boc, null);
			});

			segmentButton.setMenu(menu);
			segmentButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final Point location = segmentButton.getLocation();
					menu.setLocation(Display.getCurrent().map(createFlowDialog.flowComposite, null,
							new Point(location.x, location.y + segmentButton.getSize().y)));
					menu.setVisible(true);
				};
			});

			return segmentButton;
		}

		/**
		 * Determines if the selected element is valid to be added to End to End Flow
		 * @param selectedEle - selected element
		 * @param context - context of element
		 */
		private boolean isValid(final Element selectedEle, final Context context) {
			if (selectedEle instanceof ModeFeature) {
				return true;
			}

			// First selection qualifications
			if (segmentSelections.isEmpty()) {
				if (selectedEle instanceof FlowSpecification || selectedEle instanceof Subcomponent) {
					return isValidFirstElement(selectedEle, context);
				}

				return false;
			}

			return selectedEle instanceof EndToEndFlowElement;
		}

		/**
		 * @param selectedEle - current element
		 * @param context - current context
		 * @return - true or false depending on if the selected element is a valid start element
		 */
		private boolean isValidFirstElement(final Element selectedEle, final Context context) {
			return (selectedEle instanceof FlowSpecification
					&& ((FlowSpecification) selectedEle).getKind() == FlowKind.SOURCE
					&& context instanceof Subcomponent) || selectedEle instanceof Subcomponent;
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
			final Composite area = FlowDialogUtil.createFlowArea(parent, SWT.NONE);
			final Composite parentComposite = FlowDialogUtil.createFlowArea(area, SWT.BORDER);
			flowComposite = FlowDialogUtil.createFlowComposite(parentComposite);

			createButtonComposite(parentComposite);
			errorTableViewer = FlowDialogUtil.createErrorTableViewer(new Composite(area, SWT.NONE));
			return flowComposite;
		}

		private void createButtonComposite(final Composite parent) {
			final Composite buttonComposite = new Composite(parent, SWT.NONE);
			final RowLayout rowLayout = new RowLayout();
			rowLayout.center = true;
			rowLayout.spacing = 5;
			rowLayout.fill = false;
			rowLayout.marginLeft = 10;
			buttonComposite.setLayout(rowLayout);
		}

		private void addSegment(final Runnable runnable) {
			try {
				createFlowDialog.getShell().setVisible(false);
				if (elementSelectionDlg.open() == Window.OK && elementSelectionDlg != null) {
					final BusinessObjectContext selectedBoc = getReplacementBoc()
							.orElseThrow(() -> new RuntimeException("Starting segment not selected."));
					final List<DiagramElement> highlightableSegments = new ArrayList<>();
					final BusinessObjectContext selectedCi = AgeHandlerUtil.getSelectedBusinessObjectContexts().get(0);
					// Find ancestors of the end to end flow container
					final Queue<Element> ancestors = FlowToolUtil.getAncestors(selectedCi, Optional.empty());
					// Find the diagram element of the container
					final BusinessObjectContext ancestor = FlowToolUtil
							.getAncestorDiagramElement(editor.getDiagram(), ancestors)
							.orElseThrow(() -> new RuntimeException(
									"Cannot find container: " + selectedCi.getBusinessObject()));
					final EndToEndFlow selectedETEFlow = (EndToEndFlow) AgeAadlUtil
							.getRootRefinedElement((NamedElement) selectedBoc.getBusinessObject());
					if (createFlowDialog.newETEFlowName.getText().isEmpty()) {
						createFlowDialog.setEndToEndFlowName((Namespace) selectedCi.getBusinessObject());
					}
					FlowToolUtil.findSegmentDiagramElements(selectedETEFlow, ancestor, highlightableSegments);

					segmentSelections.add(new SegmentData(selectedBoc, highlightableSegments));
					highlightableSegments.forEach(de -> setColor(de, Color.ORANGE.darker()));

					updateSegments();

					final EndToEndFlow endToEndFlow = createEndToEndFlow();
					final boolean isValid = isEndToEndFlowValid(endToEndFlow);
					final String error = getFlowErrorMessage(isValid).orElse(null);
					if (error == null) {
						setErrorMessage(null);
						setMessage(getDialogMessage());
					} else {
						setErrorMessage(error + getDialogMessage());
					}

					updateWidgets(isValid);
				}
			} finally {
				elementSelectionDlg = null;
				createFlowDialog.getShell().setVisible(true);
			}
		}

		private void addSegment(final SegmentData segmentData, final boolean isInsertAfter) {
			addSegment(Optional.empty(), segmentData, isInsertAfter);
		}

		private void addInModeFeature(final BusinessObjectContext boc, final boolean isInsertAfter) {
			addInModeFeature(Optional.empty(), boc, isInsertAfter);
		}

		private void addSegment(final Optional<Runnable> opRunnable, final SegmentData segmentData,
				final boolean isInsertAfter) {
			createFlowDialog.getShell().setVisible(false);
			if (elementSelectionDlg.open() == Window.OK && elementSelectionDlg != null) {
				final Optional<BusinessObjectContext> optBoc = getReplacementBoc();
				if (optBoc.isPresent()) {
					final BusinessObjectContext selectedBoc = optBoc.get();
					final List<DiagramElement> highlightableSegments = new ArrayList<>();
					if (selectedBoc.getBusinessObject() instanceof EndToEndFlow) {
						final BusinessObjectContext selectedCi = AgeHandlerUtil.getSelectedBusinessObjectContexts()
								.get(0);
						// Find ancestors of the end to end flow container
						final Queue<Element> ancestors = FlowToolUtil.getAncestors(selectedCi, Optional.empty());
						// Find the diagram element of the container
						final BusinessObjectContext ancestor = FlowToolUtil
								.getAncestorDiagramElement(editor.getDiagram(), ancestors)
								.orElseThrow(() -> new RuntimeException(
										"Cannot find container: " + selectedCi.getBusinessObject()));
						FlowToolUtil.findSegmentDiagramElements(
								(EndToEndFlow) selectedBoc.getBusinessObject(),
								ancestor, highlightableSegments);
					}

					int insertIndex = segmentSelections.indexOf(segmentData);
					if (isInsertAfter) {
						insertIndex++;
					}

					final SegmentData segmentDataToAdd = new SegmentData(selectedBoc, highlightableSegments);
					segmentSelections.add(insertIndex, segmentDataToAdd);

					opRunnable.ifPresent(runnable -> runnable.run());

					// Update new and existing segment colors based on index
					final Color newSegmentColor = segmentSelections.indexOf(segmentDataToAdd) == 0
							? Color.ORANGE.darker()
									: Color.MAGENTA.darker();
							setColor(segmentDataToAdd, newSegmentColor);

							final Color updateSegmentColor = segmentSelections.indexOf(segmentData) == 0 ? Color.ORANGE.darker()
									: Color.MAGENTA.darker();
							setColor(segmentDataToAdd, updateSegmentColor);
				}

				updateSegments();

				final EndToEndFlow endToEndFlow = createEndToEndFlow();
				final boolean isValid = isEndToEndFlowValid(endToEndFlow);
				final String error = getFlowErrorMessage(isValid).orElse(null);
				if (error == null) {
					setErrorMessage(null);
					setMessage(getDialogMessage());
				} else {
					setErrorMessage(error + getDialogMessage());
				}

				updateWidgets(isValid);
			}

			elementSelectionDlg = null;
			createFlowDialog.getShell().setVisible(true);
		}

		private void addInModeFeature(final Optional<Runnable> opRunnable, final BusinessObjectContext boc,
				final boolean isInsertAfter) {
			createFlowDialog.getShell().setVisible(false);
			if (elementSelectionDlg.open() == Window.OK && elementSelectionDlg != null) {
				final Optional<BusinessObjectContext> optBoc = getReplacementBoc();
				if (optBoc.isPresent()) {
					final BusinessObjectContext selectedBoc = optBoc.get();
					int insertIndex = modeFeatureSelections.indexOf(boc);
					if (isInsertAfter) {
						insertIndex++;
					}
					modeFeatureSelections.add(insertIndex, selectedBoc);
					setColor(selectedBoc, Color.MAGENTA.brighter());

					opRunnable.ifPresent(runnable -> runnable.run());
				}

				updateSegments();

				final EndToEndFlow endToEndFlow = createEndToEndFlow();
				final boolean isValid = isEndToEndFlowValid(endToEndFlow);
				final String error = getFlowErrorMessage(isValid).orElse(null);
				if (error == null) {
					setErrorMessage(null);
					setMessage(getDialogMessage());
				} else {
					setErrorMessage(error + getDialogMessage());
				}

				updateWidgets(isValid);
			}

			elementSelectionDlg = null;
			createFlowDialog.getShell().setVisible(true);
		}

		private Optional<BusinessObjectContext> getReplacementBoc() {
			if (elementSelectionDlg.getSelection() instanceof BusinessObjectContext) {
				return Optional.of((BusinessObjectContext) elementSelectionDlg.getSelection());
			} else if (elementSelectionDlg.getSelection() instanceof EndToEndFlow) {
				return Optional.of(new BusinessObjectNode(null, UUID.randomUUID(), null,
						elementSelectionDlg.getSelection(), Completeness.UNKNOWN, false));
			}

			return Optional.empty();
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
			newETEFlowName.setEnabled(true);
			final GridData nameTextData = new GridData(SWT.FILL, SWT.CENTER, true, false);
			newETEFlowName.setLayoutData(nameTextData);
			newETEFlowName.setEditable(true);
			newETEFlowName.setOrientation(SWT.LEFT_TO_RIGHT);

			newETEFlowName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(final KeyEvent e) {
					endToEndFlowName = newETEFlowName.getText();
					final EndToEndFlow endToEndFlow = createEndToEndFlow();
					final boolean isValid = isEndToEndFlowValid(endToEndFlow);
					final String error = getFlowErrorMessage(isValid).orElse(null);
					if (error == null) {
						setErrorMessage(null);
						setMessage(getDialogMessage());
					} else {
						setErrorMessage(error + getDialogMessage());
					}

					updateWidgets(isValid);
				}
			});

			super.createButtonBar(buttonBar);
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
			okBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					flow = createEndToEndFlow();
				}
			});

			return buttonBar;
		}

		private Optional<String> getFlowErrorMessage(final boolean isValid) {
			if (!isValid) {
				return Optional.of(getValidFlowErrorMessage());
			}

			return Optional.ofNullable(null);
		}

		private String getValidFlowErrorMessage() {
			return invalidErrorMessage;
		}

		private abstract class ElementSelectionDialog extends TitleAreaDialog {
			private final String title;
			protected Object selection;
			protected final Class<?> qualifiedType;
			protected final String dialogMessage;

			public ElementSelectionDialog(final Shell parentShell, final String title, final Class<?> type,
					final String dialogMessage) {
				super(parentShell);
				this.title = title;
				this.dialogMessage = dialogMessage;
				this.qualifiedType = type;
				setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			}

			@Override
			public void create() {
				super.create();
				setTitle(title);
			}

			public Object getSelection() {
				return selection;
			}

			public void setSelection(final BusinessObjectContext selection) {
				this.selection = selection;
			}
		}

		/**
		 * Dialog for selecting end to end flow segments from diagram or outline
		 */
		private class SelectSegmentOrModeFeatureDialog extends ElementSelectionDialog {
			private Label selectionLabel;

			public SelectSegmentOrModeFeatureDialog(final Shell parentShell, final Class<?> qualifiedType,
					final String title) {
				super(parentShell, title, qualifiedType, "Select element from diagram or outline view.");
				setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			}

			@Override
			public void create() {
				super.create();
				setMessage(dialogMessage);
				final Button okBtn = getButton(IDialogConstants.OK_ID);

				final List<BusinessObjectContext> bocs = AgeHandlerUtil.getSelectedBusinessObjectContexts();
				if (bocs.size() == 1 && bocs.get(0).getBusinessObject() instanceof NamedElement) {
					final NamedElement selectedElement = (NamedElement) bocs.get(0).getBusinessObject();
					okBtn.setEnabled(qualifiedType.isInstance(selectedElement));
					selectionLabel.setText(AgeAadlUtil.getRootName(selectedElement));
					setErrorMessage(null);
				} else {
					okBtn.setEnabled(false);
					setErrorMessage("Invalid selection.\n " + dialogMessage);
					selectionLabel.setText("<Invalid>");
				}
			}

			@Override
			protected void configureShell(final Shell newShell) {
				super.configureShell(newShell);
				newShell.setText("Element Selection");
				newShell.setLocation(DialogPlacementHelper
						.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
				newShell.setSize(400, 200);
				newShell.setMinimumSize(400, 200);
			}

			@Override
			public void setSelection(final BusinessObjectContext selection) {
				super.setSelection(selection);
				updateDialog(selection);
				getShell().layout(true, true);
			}

			private void updateDialog(final BusinessObjectContext boc) {
				final Object bo = boc.getBusinessObject();
				final Button okBtn = getButton(IDialogConstants.OK_ID);
				if (okBtn != null) {
					final boolean isEnabled = !modeFeatureSelections.contains(boc) && qualifiedType.isInstance(bo);
					okBtn.setEnabled(isEnabled);
				}

				if (bo instanceof NamedElement) {
					selectionLabel.setText(AgeAadlUtil.getRootName((NamedElement) bo));
					setErrorMessage(null);
				} else {
					setErrorMessage("Invalid selection.\n " + dialogMessage);
					selectionLabel.setText("<Invalid>");
				}
			}

			@Override
			protected Control createDialogArea(final Composite parent) {
				final Composite composite = new Composite(parent, SWT.NONE);
				final GridLayout layout = new GridLayout();
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.verticalSpacing = 0;
				layout.horizontalSpacing = 5;
				layout.numColumns = 2;
				layout.marginLeft = 10;
				layout.marginTop = 8;
				composite.setLayout(layout);

				composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
				composite.setFont(parent.getFont());

				final Label label = new Label(composite, SWT.NONE);
				label.setText("Selected Element: ");
				label.setLayoutData(
						GridDataFactory.fillDefaults().grab(false, true).align(SWT.CENTER, SWT.CENTER).create());

				selectionLabel = new Label(composite, SWT.NONE);
				final List<BusinessObjectContext> bocs = AgeHandlerUtil.getSelectedBusinessObjectContexts();
				if (bocs.size() == 1 && bocs.get(0).getBusinessObject() instanceof NamedElement) {
					final String text = AgeAadlUtil
							.getRootRefinedElement((NamedElement) bocs.get(0).getBusinessObject()).getName();
					selectionLabel.setText(text);
				} else {
					selectionLabel.setText("<Invalid>");
				}

				selectionLabel.setLayoutData(
						GridDataFactory.fillDefaults().grab(false, true).align(SWT.CENTER, SWT.CENTER).create());

				return composite;
			}
		}

		/**
		 * Dialog for selecting end to end flows as segments
		 */
		private class SelectEndToEndFlowDialog extends ElementSelectionDialog {
			private ComboViewer comboViewer;
			private final String none = "<None>";

			public SelectEndToEndFlowDialog(final Shell parentShell, final Class<?> type, final String title) {
				super(parentShell, title, type, "Select an end to end flow container to populate the drop-down.");
				setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			}

			@Override
			public void create() {
				super.create();
				setMessage(dialogMessage);
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}

			@Override
			protected void configureShell(final Shell newShell) {
				super.configureShell(newShell);
				newShell.setText("Element Selection");
				newShell.setLocation(DialogPlacementHelper
						.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
				newShell.setSize(400, 200);
				newShell.setMinimumSize(400, 200);
			}

			@Override
			public void setSelection(final BusinessObjectContext selection) {
				comboViewer.setInput(getOwnedEndToEndFlows(getComponentImplementation(selection)));
				comboViewer.setSelection(new StructuredSelection(none));
				updateDialog(selection.getBusinessObject());
				this.selection = selection;
				getShell().layout(true, true);
			}

			private void updateDialog(final Object bo) {
				final boolean isInstance = qualifiedType.isInstance(bo) || bo instanceof EndToEndFlow;
				final Button okBtn = getButton(IDialogConstants.OK_ID);
				if (okBtn != null) {
					okBtn.setEnabled(isInstance);
				}

				setMessage(dialogMessage
						+ (isInstance ? "\nSelected: " + AgeAadlUtil.getRootName((NamedElement) bo) : ""));
			}

			// Get component implementation from selection
			private Optional<ComponentImplementation> getComponentImplementation(final Object bo) {
				if (bo instanceof BusinessObjectContext) {
					return getComponentImplementation(((BusinessObjectContext) bo).getBusinessObject());
				} else if (bo instanceof ComponentImplementation) {
					return Optional.of((ComponentImplementation) bo);
				} else if (bo instanceof Subcomponent) {
					return Optional.ofNullable(((Subcomponent) bo).getComponentImplementation());
				}

				return Optional.empty();
			}

			@Override
			protected Control createDialogArea(final Composite parent) {
				final Composite composite = new Composite(parent, SWT.NONE);
				final GridLayout layout = new GridLayout();
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.verticalSpacing = 0;
				layout.horizontalSpacing = 5;
				layout.numColumns = 2;
				layout.marginLeft = 10;
				layout.marginTop = 8;
				composite.setLayout(layout);

				composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
				composite.setFont(parent.getFont());

				final Label label = new Label(composite, SWT.NONE);
				label.setText("End to End Flow: ");
				label.setLayoutData(
						GridDataFactory.fillDefaults().grab(false, true).align(SWT.CENTER, SWT.CENTER).create());

				comboViewer = new ComboViewer(composite, SWT.READ_ONLY);
				comboViewer.getCombo().setLayoutData(
						GridDataFactory.fillDefaults().grab(true, true).align(SWT.CENTER, SWT.CENTER).create());

				comboViewer.setContentProvider(ArrayContentProvider.getInstance());
				comboViewer.setLabelProvider(new LabelProvider() {
					@Override
					public String getText(final Object element) {
						if (element instanceof String) {
							return (String) element;
						}

						return AgeAadlUtil.getRootName((NamedElement) element);
					}
				});

				comboViewer.addSelectionChangedListener(event -> {
					final Object selectedElement = event.getStructuredSelection().getFirstElement();
					if (selection != selectedElement) {
						updateDialog(selectedElement);
						selection = selectedElement;
					}
				});

				final List<BusinessObjectContext> selectedBocs = AgeHandlerUtil.getSelectedBusinessObjectContexts();
				if (selectedBocs.size() == 1) {
					comboViewer.setInput(getOwnedEndToEndFlows(getComponentImplementation(selectedBocs.get(0))));
				}

				comboViewer.setSelection(new StructuredSelection(none));

				return composite;
			}

			private List<Object> getOwnedEndToEndFlows(final Optional<ComponentImplementation> optCi) {
				final List<Object> input = new ArrayList<>();
				input.add("<None>");
				final List<EndToEndFlow> eTEFlows = optCi
						.map(ci -> ci.getAllEndToEndFlows().stream().collect(Collectors.toList()))
						.orElse(new ArrayList<>());
				input.addAll(eTEFlows);
				return input;
			}
		}
	}
}
