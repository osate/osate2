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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

import javax.inject.Named;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Element;
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
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.Modification;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.internal.ui.tools.FlowDialogUtil.SegmentData;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.ui.util.DialogPlacementHelper;
import org.osate.ge.internal.util.AadlHelper;

public class CreateFlowImplementationTool {
	private final ArrayList<SegmentData> segmentSelections = new ArrayList<>();
	private final ArrayList<BusinessObjectContext> modeFeatureSelections = new ArrayList<>();
	private ColoringService.Coloring coloring = null;
	private CreateFlowImplementationDialog createFlowImplDlg;

	public CreateFlowImplementationTool(final AgeDiagramEditor editor, final HighlightableFlowInfo selectedFlow,
			final Set<BusinessObjectNode> segmentNodes) {
		// Flow impl to edit
		final FlowImplementation flowImpl = (FlowImplementation) selectedFlow.getFlowSegment();
		final BusinessObjectNode container = (BusinessObjectNode) selectedFlow.getContainer();

		// Find ancestors of the end to end flow container
		final Queue<Element> ancestors = FlowUtil.getAncestors(container, Optional.empty());

		// Find container on diagram
		final BusinessObjectContext ancestor = FlowUtil.getAncestorDiagramElement(editor.getAgeDiagram(), ancestors)
				.orElseThrow(() -> new RuntimeException("Cannot find container: " + container.getBusinessObject()));

		final UiService uiService = Objects.requireNonNull(Adapters.adapt(editor, UiService.class),
				"ui service must not be null");
		final Display display = Display.getCurrent();
		createFlowImplDlg = new CreateFlowImplementationDialog(display.getActiveShell(),
				selectedFlow, uiService);

		// Convert BusinessObjectNodes to a map of NamedElement to BusinessObjectContexts
		// used for referencing elements on the diagram and outline
		final Map<NamedElement, BusinessObjectContext> segmentToBoc = FlowUtil.getSegmentToBocMap(segmentNodes,
				ancestor);

		// Populate segments
		final FlowSpecification flowSpec = flowImpl.getSpecification();
		final BusinessObjectContext boc = segmentToBoc.get(flowSpec);
		segmentSelections.add(new SegmentData(boc));

		final FlowEnd inEnd = flowImpl.getInEnd();
		if (inEnd != null) {
			final BusinessObjectContext inEndFeature = segmentToBoc.get(inEnd.getFeature());
			segmentSelections.add(new SegmentData(inEndFeature));
		}

		flowImpl.getOwnedFlowSegments().stream().map(seg -> AadlHelper.getRootRefinedElement(seg.getFlowElement()))
		.map(flowSegment -> new SegmentData(segmentToBoc.get(flowSegment))).forEach(segmentSelections::add);

		final FlowEnd outEnd = flowImpl.getOutEnd();
		if (outEnd != null) {
			final BusinessObjectContext outEndFeature = segmentToBoc.get(outEnd.getFeature());
			segmentSelections.add(new SegmentData(outEndFeature));
		}

		// Populate in mode features
		flowImpl.getInModeOrTransitions().stream()
		.forEach(modeFeature -> modeFeatureSelections.add(segmentToBoc.get(modeFeature)));
	}

	public CreateFlowImplementationTool(final AgeDiagramEditor editor) {
		final Display display = Display.getCurrent();
		final UiService uiService = Objects.requireNonNull(Adapters.adapt(editor, UiService.class),
				"ui service must not be null");
		createFlowImplDlg = new CreateFlowImplementationDialog(display.getActiveShell(),
				null, uiService);
	}

	@Activate
	public void activate(@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext selectedBoc,
			final AadlModificationService aadlModService, final ColoringService coloringService,
			final UiService uiService) {
		try {
			// Check for existing errors or warnings
			final Set<Diagnostic> diagnostics = ToolUtil.getAllReferencedPackageDiagnostics(selectedBoc);
			if (!diagnostics.isEmpty()) {
				Display.getDefault().asyncExec(
						() -> new FlowDialogUtil.ErrorDialog("The Create Flow Implementation", diagnostics).open());
			} else {
				coloring = coloringService.adjustColors();

				// Create and update based on current selection
				createFlowImplDlg.create();
				if (segmentSelections.isEmpty() && modeFeatureSelections.isEmpty()) {
					update(new BusinessObjectContext[] { selectedBoc }, true);
				} else {
					final Iterator<SegmentData> segmentIt = segmentSelections.iterator();
					if (segmentIt.hasNext()) {
						// Set color for flow spec
						setColor(segmentIt.next().getBoc(), Color.ORANGE.darker());

						// Set color for flow segments
						for (; segmentIt.hasNext(); setColor(segmentIt.next().getBoc(), Color.MAGENTA.darker())) {
						}
					}

					// Set color for in mode and mode transitions
					for (Iterator<BusinessObjectContext> modeFeatureIt = modeFeatureSelections.iterator(); modeFeatureIt
							.hasNext(); setColor(modeFeatureIt.next(), Color.MAGENTA.brighter())) {
					}
				}

				if (createFlowImplDlg.open() == Window.OK && createFlowImplDlg != null) {
					// Create a new flow impl based on selections
					final FlowImplementation flowImpl = createFlowImplDlg.createFlow();

					createFlowImplDlg.getFlowComponentImplementation(createFlowImplDlg.getOwnerBoc().orElse(null))
					.ifPresent(ownerCi -> {
						// Modifications to perform
						final List<AadlModificationService.Modification<? extends NamedElement, ? extends NamedElement>> modifications = new ArrayList<>();
						if (createFlowImplDlg.flowSegmentToEdit != null) {
							// Editing existing flow impl
							final FlowImplementation flowImplToEdit = (FlowImplementation) createFlowImplDlg.flowSegmentToEdit
									.getFlowSegment();

							// Copy owned property associations from old flow impl to new flow impl and remove old flow impl
							modifications.add(Modification.create(flowImplToEdit, fi -> {
								flowImpl.getOwnedPropertyAssociations()
								.addAll(EcoreUtil.copyAll(fi.getOwnedPropertyAssociations()));
								EcoreUtil.remove(fi);
							}));
						}

						// Add new flow impl
						modifications.add(Modification.create(ownerCi, ci -> {
							ci.getOwnedFlowImplementations().add(flowImpl);
							ci.setNoFlows(false);
						}));

						// Perform modifications
						aadlModService.modify(modifications);
					});
				}
			}
		} finally {
			uiService.deactivateActiveTool();
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
		}
	}

	/**
	 * Update the diagram and tool dialog
	 * @param selectedBocs - the selected bocs
	 * @param isInit - whether the selected bocs are the inital selection when the tool was activated
	 */
	private void update(final BusinessObjectContext[] selectedBocs, final boolean isInit) {
		if (createFlowImplDlg != null) {
			if (createFlowImplDlg.getShell() != null && !createFlowImplDlg.getShell().isDisposed()
					&& createFlowImplDlg.elementSelectionDlg == null) {
				// Handle selection for creating flow segments and mode features
				if (selectedBocs.length > 1) {
					createFlowImplDlg.setMultipleElementsSelected(true, isInit);
				} else if (selectedBocs.length == 1) {
					createFlowImplDlg.setMultipleElementsSelected(false, isInit);
					createFlowImplDlg.addSelectedElement(selectedBocs[0], isInit);
				}
			} else if (createFlowImplDlg.elementSelectionDlg != null
					&& createFlowImplDlg.elementSelectionDlg
					.getShell() != null
					&& !createFlowImplDlg.elementSelectionDlg.getShell().isDisposed()
					&& createFlowImplDlg.elementSelectionDlg.getShell().isVisible()) {
				// Handle selection for editing flow segments and mode features
				final CreateFlowImplementationDialog.SelectSegmentOrModeFeatureDialog elementSelectionDlg = createFlowImplDlg.elementSelectionDlg;
				if (selectedBocs.length > 1) {
					elementSelectionDlg
					.setErrorMessage("Multiple elements are selected. " + elementSelectionDlg.getMessage());
					elementSelectionDlg.setSelection(null);
				} else if (selectedBocs.length == 1) {
					final BusinessObjectContext selectedBoc = selectedBocs[0];
					elementSelectionDlg.setErrorMessage(null);
					elementSelectionDlg.setSelection(selectedBoc);
				}
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
		if (createFlowImplDlg != null) {
			if (createFlowImplDlg.elementSelectionDlg != null) {
				createFlowImplDlg.elementSelectionDlg.close();
				createFlowImplDlg.elementSelectionDlg = null;
			}
			createFlowImplDlg.close();
			createFlowImplDlg = null;
		}

		segmentSelections.clear();
		modeFeatureSelections.clear();
	}

	@SelectionChanged
	public void onSelectionChanged(@Named(Names.BUSINESS_OBJECT_CONTEXTS) final BusinessObjectContext[] selectedBocs) {
		update(selectedBocs, false);
	}

	private class CreateFlowImplementationDialog extends TitleAreaDialog {
		private final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private final HighlightableFlowInfo flowSegmentToEdit;
		private final UiService uiService;
		private TableViewer errorTableViewer;
		private Composite flowComposite;
		private FlowImplementation flowImpl;

		private SelectSegmentOrModeFeatureDialog elementSelectionDlg;

		private boolean multipleElementsSelected = false;
		private boolean isValid = true;

		CreateFlowImplementationDialog(final Shell parentShell, final HighlightableFlowInfo flowSegmentToEdit,
				final UiService uiService) {
			super(parentShell);
			this.flowSegmentToEdit = flowSegmentToEdit;
			this.uiService = uiService;
			this.setHelpAvailable(true);
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		private void setMultipleElementsSelected(final boolean multipleElementsSelected, final boolean isInit) {
			this.multipleElementsSelected = multipleElementsSelected;
			updateMessage();
		}

		/**
		 * Determine message based on currently selected element
		 */
		private String getDirectionMessage() {
			String msg = "";
			final FlowSpecification fs = flowImpl.getSpecification();
			if (fs == null) {
				msg = "Select the flow specification to implement.";
			} else if (isValid) {
				msg = "Continue selecting flow segments or select the OK button to create the flow implementation.";
			} else {
				final FlowKind kind = fs.getKind();
				if (kind == FlowKind.SOURCE) {
					if (flowImpl.getOutEnd() == null) {
						msg = "Select a ending feature or flow segment.";
					} else {
						msg = "Select a flow segment.";
					}
				} else if (kind == FlowKind.SINK) {
					if (flowImpl.getInEnd() == null) {
						msg = "Select a starting feature or flow segment.";
					} else {
						msg = "Select a flow segment.";
					}
				} else {
					if (flowImpl.getInEnd() == null) {
						msg = "Select a starting feature";
					} else if (flowImpl.getOutEnd() == null) {
						msg = "Select a ending feature";
					}

					msg += " or flow segment.";
				}
			}

			return msg += "\nOptionally, select in modes or mode transitions.";
		}

		private void updateMessage() {
			final String msg = getDirectionMessage();
			String error = null;

			if (multipleElementsSelected) {
				error = "Multiple elements selected.  Select a single element. ";
			} else if (!segmentSelections.isEmpty() && !isValid) {
				error = "Invalid Flow Implementation.  ";
			}

			if (error == null) {
				setErrorMessage(null);
				setMessage(msg);
			} else {
				setErrorMessage(error + " " + msg);
			}
		}

		/**
		 * Create a Flow Implementation based on user selections
		 */
		private FlowImplementation createFlow() {
			// Create a flow implementation based on the state of the dialog
			final FlowImplementation flowImpl = (FlowImplementation) pkg.getEFactoryInstance()
					.create(pkg.getFlowImplementation());
			getFlowComponentImplementationBoc(getOwnerBoc().orElse(null)).ifPresent(flowImplOwnerBoc -> {
				final Iterator<SegmentData> it = segmentSelections.iterator();
				if (it.hasNext()) {
					final FlowSpecification fs = (FlowSpecification) it.next().getBoc().getBusinessObject();
					flowImpl.setSpecification(fs);
					flowImpl.setKind(fs.getKind());

					while (it.hasNext()) {
						final BusinessObjectContext segment = it.next().getBoc();
						final Object bo = segment.getBusinessObject();
						if (bo instanceof Feature) {
							if ((fs.getKind() == FlowKind.PATH || fs.getKind() == FlowKind.SINK)
									&& flowImpl.getInEnd() == null) {
								final FlowEnd inEnd = flowImpl.createInEnd();
								inEnd.setContext(ToolUtil.findContext(segment.getParent()));
								inEnd.setFeature((Feature) bo);
							} else if (flowImpl.getOutEnd() == null) {
								final FlowEnd outEnd = flowImpl.createOutEnd();
								outEnd.setContext(ToolUtil.findContext(segment.getParent()));
								outEnd.setFeature((Feature) bo);
							}
						} else if (!(bo instanceof DataAccess)) {
							final FlowSegment newFlowSegment = flowImpl.createOwnedFlowSegment();
							if (!(bo instanceof Connection)) {
								newFlowSegment.setContext(ToolUtil.findContextExcludeOwner(segment, flowImplOwnerBoc));
							}
							newFlowSegment.setFlowElement((FlowElement) bo);
						}
					}
				}
			});

			modeFeatureSelections.forEach(modeFeatureBoc -> flowImpl.getInModeOrTransitions()
					.add((ModeFeature) modeFeatureBoc.getBusinessObject()));

			return flowImpl;
		}

		/**
		 * Add qualified element to build flow implementation
		 * @param boc - the business object context for the selected element
		 * @param isInit - whether the boc is the initial selection when tool is activated
		 */
		private void addSelectedElement(final BusinessObjectContext boc, final boolean isInit) {
			if (!modeFeatureSelections.contains(boc) && boc.getBusinessObject() instanceof NamedElement) {
				if (getShell().isVisible() || isInit) {
					// Decide whether to add the element to the selection list
					final Object bo = boc.getBusinessObject();
					if (bo instanceof ModeFeature) {
						addModeSelection(boc, Color.MAGENTA.brighter());
					} else if (flowImpl.getSpecification() == null && bo instanceof FlowSpecification) {
						addSegmentSelection(new SegmentData(boc), segmentSelections.size(), Color.ORANGE.darker());
					} else {
						final FlowSpecification fs = flowImpl.getSpecification();
						if (fs != null) {
							final int size = segmentSelections.size();
							if (fs.getKind() == FlowKind.PATH) {
								if (bo instanceof Feature) {
									if (flowImpl.getInEnd() == null) {
										addSegmentSelection(new SegmentData(boc), 1, Color.MAGENTA.darker());
									} else if (flowImpl.getOutEnd() == null) {
										addSegmentSelection(new SegmentData(boc),
												size,
												Color.MAGENTA.darker());
									}
								} else if (bo instanceof FlowElement) {
									int insertIndex = flowImpl.getOutEnd() == null ? size : (size - 1);
									addSegmentSelection(new SegmentData(boc), insertIndex, Color.MAGENTA.darker());
								}
							} else if (fs.getKind() == FlowKind.SINK) {
								if (bo instanceof Feature) {
									if (flowImpl.getInEnd() == null) {
										addSegmentSelection(new SegmentData(boc), 1, Color.MAGENTA.darker());
									}
								} else if (bo instanceof FlowElement) {
									addSegmentSelection(new SegmentData(boc),
											size,
											Color.MAGENTA.darker());
								}
							} else {
								if (bo instanceof Feature && flowImpl.getOutEnd() == null) {
									addSegmentSelection(new SegmentData(boc),
											size,
											Color.MAGENTA.darker());
								} else if (bo instanceof FlowElement) {
									final int insertIndex = flowImpl.getOutEnd() == null ? size : (size - 1);
									addSegmentSelection(new SegmentData(boc), insertIndex, Color.MAGENTA.darker());
								}
							}
						}
					}
				}
			} else if (!isInit) {
				setErrorMessage("Invalid element selected. " + getDirectionMessage());
			}
		}

		private void addModeSelection(final BusinessObjectContext boc, final Color color) {
			modeFeatureSelections.add(boc);
			setColor(boc, color);
			updateDialog();
		}

		/**
		 * Add the segment to the list of segments
		 * @param segmentData the segment to add
		 * @param index the index to insert the segment into the segment list
		 * @param color the color to set the diagram element
		 */
		private void addSegmentSelection(final SegmentData segmentData, final int index, final Color color) {
			segmentSelections.add(index, segmentData);
			setColor(segmentData.getBoc(), color);
			updateDialog();
		}

		private void updateDialog() {
			setErrorMessage(null);
			// Update the UI
			updateWidgets();
		}


		private boolean isFlowImplValid(final FlowImplementation fi) {
			if (fi.getSpecification() == null) {
				return false;
			}

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

		private Optional<ComponentImplementation> getFlowComponentImplementation(final BusinessObjectContext owner) {
			return getFlowBocToComponentImplementation(owner).map(entry -> entry.getValue());
		}

		private Optional<BusinessObjectContext> getFlowComponentImplementationBoc(final BusinessObjectContext owner) {
			return getFlowBocToComponentImplementation(owner).map(entry -> entry.getKey());
		}

		private Optional<SimpleEntry<BusinessObjectContext, ComponentImplementation>> getFlowBocToComponentImplementation(
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

		private void updateWidgets() {
			for (final Control child : flowComposite.getChildren()) {
				child.dispose();
			}

			flowImpl = createFlow();

			isValid = isFlowImplValid(flowImpl);
			getButton(IDialogConstants.OK_ID).setEnabled(isValid);

			final Iterator<SegmentData> segmentIt = segmentSelections.iterator();
			if (segmentIt.hasNext()) {
				SegmentData segmentData = segmentIt.next();
				BusinessObjectContext boc = segmentData.getBoc();
				if (flowSegmentToEdit != null) {
					createFlowSpecLabel((NamedElement) boc.getBusinessObject());
				} else {
					createSegmentButton(FlowUtil.getRefinedName((NamedElement) boc.getBusinessObject()), segmentData);
					createFlowText();
				}

				while (segmentIt.hasNext()) {
					segmentData = segmentIt.next();
					boc = segmentData.getBoc();
					createSegmentButton(FlowUtil.getRefinedName((NamedElement) boc.getBusinessObject()), segmentData);
					if (segmentIt.hasNext()) {
						// If segment is not last, add an arrow
						FlowDialogUtil.createArrowText(flowComposite);
					}
				}
			}

			if (!modeFeatureSelections.isEmpty()) {
				FlowDialogUtil.createInModeText(flowComposite);
				final Iterator<BusinessObjectContext> modeFeatureIt = modeFeatureSelections.iterator();
				final BusinessObjectContext boc = modeFeatureIt.next();

				createModeFeatureButton("(" + ((NamedElement) boc.getBusinessObject())
						.getName()
						+ (modeFeatureIt.hasNext() ? "," : ")"), boc);

				while (modeFeatureIt.hasNext()) {
					final BusinessObjectContext mode = modeFeatureIt.next();
					createModeFeatureButton(
							((NamedElement) mode.getBusinessObject()).getName() + (modeFeatureIt.hasNext() ? "," : ")"),
							mode);
				}
			}

			flowComposite.layout(true, true);
			updateMessage();
		}

		private void createFlowSpecLabel(final NamedElement ne) {
			final StyledText flowSpecLabel = new StyledText(flowComposite, SWT.NONE);
			flowSpecLabel.setBackground(flowComposite.getBackground());
			flowSpecLabel.setLayoutData(new RowData());
			final String flowSpecName = FlowUtil.getRefinedName(ne);
			flowSpecLabel.setText(flowSpecName + " :  flow");
			flowSpecLabel.setStyleRange(new StyleRange(flowSpecName.length() + 4, 4,
					Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
		}

		private void createFlowText() {
			final StyledText label = new StyledText(flowComposite, SWT.NONE);
			label.setBackground(flowComposite.getBackground());
			label.setLayoutData(new RowData());
			label.setText(" :  flow");
			label.setStyleRange(
					new StyleRange(4, 4, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
		}

		private void createSegmentButton(final String name, final SegmentData segmentData) {
			final Button segmentBtn = new Button(flowComposite, SWT.FLAT);
			segmentBtn.setText(name);
			segmentBtn.setLayoutData(new RowData());
			final Menu editMenu = new Menu(segmentBtn);

			createSegmentReplaceButton(editMenu, segmentData);
			final MenuItem insertBeforeMenuItem = createInsertSegmentButton(editMenu, "Insert Before", segmentData,
					false);
			final MenuItem insertAfterMenuItem = createInsertSegmentButton(editMenu, "Insert After", segmentData, true);

			final MenuItem remove = new MenuItem(editMenu, SWT.NONE);
			remove.setText("Remove");
			remove.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					segmentSelections.remove(segmentData);
					setColor(segmentData, null);
					uiService.clearSelection();
					createFlowImplDlg.updateWidgets();
				}
			});

			segmentBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final Point location = segmentBtn.getLocation();
					editMenu.setLocation(Display.getCurrent().map(createFlowImplDlg.flowComposite,
							null,
							new Point(location.x, location.y + segmentBtn.getSize().y)));
					// Can only replace flow spec or in/out end features
					if (getFirstSelection().filter(selection -> selection == segmentData.getBoc()).isPresent()) {
						insertBeforeMenuItem.setEnabled(false);
						insertAfterMenuItem.setEnabled(false);
						remove.setEnabled(false);
					} else {
						final FlowEnd inEnd = flowImpl.getInEnd();
						if (inEnd != null && inEnd.getFeature() == segmentData.getBoc().getBusinessObject()) {
							insertBeforeMenuItem.setEnabled(false);
							insertAfterMenuItem.setEnabled(false);
						}

						final FlowEnd outEnd = flowImpl.getOutEnd();
						if (outEnd != null && outEnd.getFeature() == segmentData.getBoc().getBusinessObject()) {
							insertBeforeMenuItem.setEnabled(false);
							insertAfterMenuItem.setEnabled(false);
						}
					}

					editMenu.setVisible(true);
				};
			});
		}

		private MenuItem createInsertSegmentButton(Menu newMenu, final String text, SegmentData segmentData,
				boolean isInsertAfter) {
			final MenuItem insertMenuItem = new MenuItem(newMenu, SWT.PUSH);
			insertMenuItem.setText(text);
			insertMenuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					elementSelectionDlg = new SelectSegmentOrModeFeatureDialog(createFlowImplDlg.getShell(),
							segmentData.getBoc(), "Select Element to Insert");
					createFlowImplDlg.setSegment(segmentData, isInsertAfter);
				}
			});

			return insertMenuItem;
		}

		private void createSegmentReplaceButton(final Menu menu, final SegmentData segmentData) {
			final MenuItem replace = new MenuItem(menu, SWT.NONE);
			replace.setText("Replace");
			replace.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					elementSelectionDlg = new SelectSegmentOrModeFeatureDialog(createFlowImplDlg.getShell(),
							segmentData.getBoc(), "Select Replacement Element");
					createFlowImplDlg.setSegment(Optional.of(() -> {
						segmentSelections.remove(segmentData);
						setColor(segmentData, null);
					}), segmentData, false);
				}
			});
		}

		private void createModeFeatureButton(final String text, final BusinessObjectContext boc) {
			final Button createModeFeatureBtn = new Button(flowComposite, SWT.FLAT);
			createModeFeatureBtn.setText(text);
			createModeFeatureBtn.setEnabled(true);
			createModeFeatureBtn.setLayoutData(new RowData());

			final Menu menu = new Menu(createModeFeatureBtn);
			final MenuItem replaceMenuItem = new MenuItem(menu, SWT.PUSH);
			replaceMenuItem.setText("Replace");

			replaceMenuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					elementSelectionDlg = new SelectSegmentOrModeFeatureDialog(createFlowImplDlg.getShell(), boc,
							"Select Replacement Element");
					createFlowImplDlg.setSegment(Optional.of(() -> {
						modeFeatureSelections.remove(boc);
						if (boc instanceof DiagramElement) {
							coloring.setForeground((DiagramElement) boc, null);
						}
					}), boc, false);
				}
			});

			createInsertModeFeatureMenuItem(menu, "Insert Before", boc, false);
			createInsertModeFeatureMenuItem(menu, "Insert After", boc, true);

			final MenuItem removeMenuItem = new MenuItem(menu, SWT.PUSH);
			removeMenuItem.setText("Remove");
			removeMenuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					modeFeatureSelections.remove(boc);
					if (boc instanceof DiagramElement) {
						coloring.setForeground((DiagramElement) boc, null);
					}

					createFlowImplDlg.updateWidgets();
				}

			});

			createModeFeatureBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final Point location = createModeFeatureBtn.getLocation();
					menu.setLocation(Display.getCurrent().map(
							createFlowImplDlg.flowComposite,
							null,
							new Point(location.x, location.y + createModeFeatureBtn.getSize().y)));
					menu.setVisible(true);
				};
			});
		}

		private void createInsertModeFeatureMenuItem(Menu menu, String text, BusinessObjectContext boc,
				boolean isInsertAfter) {
			final MenuItem insertMenuItem = new MenuItem(menu, SWT.PUSH);
			insertMenuItem.setText(text);
			insertMenuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					elementSelectionDlg = new SelectSegmentOrModeFeatureDialog(createFlowImplDlg.getShell(), boc,
							"Select Element to Insert");
					createFlowImplDlg.setSegment(boc, isInsertAfter);
				}
			});
		}

		private void setSegment(
				final SegmentData segmentData,
				final boolean isInsertAfter) {
			setSegment(Optional.empty(), segmentData, isInsertAfter);
		}

		private void setSegment(
				final Optional<Runnable> opRunnable,
				final SegmentData segmentData, final boolean isInsertAfter) {
			try {
				createFlowImplDlg.getShell().setVisible(false);
				if (elementSelectionDlg.open() == Window.OK && elementSelectionDlg != null && createFlowImplDlg != null) {
					final Optional<BusinessObjectContext> optBoc = getReplacementBoc();
					if (optBoc.isPresent()) {
						final BusinessObjectContext selectedBoc = optBoc.get();
						int insertIndex = segmentSelections.indexOf(segmentData);
						if (isInsertAfter) {
							insertIndex++;
						}

						if (insertIndex == 0) {
							// Replacing flow specification
							final FlowSpecification fs = (FlowSpecification) segmentData.getBoc().getBusinessObject();
							final FlowKind flowKind = fs.getKind();
							final FlowSpecification replacementFlowSpec = (FlowSpecification) selectedBoc
									.getBusinessObject();
							final FlowKind replacementFlowKind = replacementFlowSpec.getKind();
							if (flowKind != replacementFlowKind) {
								// Move in/out features based on replacement kind
								if (flowKind == FlowKind.SINK) {
									if (replacementFlowKind == FlowKind.SOURCE && flowImpl.getInEnd() != null) {
										// Move in feature to out feature
										moveFeature(1, segmentSelections.size());
									}
								} else if (flowKind == FlowKind.SOURCE) {
									if (flowImpl.getOutEnd() != null) {
										// Move out feature to in feature
										moveFeature(segmentSelections.size() - 1, 1);
									}
								} else { // Path
									if (replacementFlowKind == FlowKind.SINK) {
										if (flowImpl.getOutEnd() != null) {
											// Remove out end feature
											removeFeature(segmentSelections.size() - 1);
										}
									} else { // Source
										if (flowImpl.getInEnd() != null) {
											// Remove in end feature
											removeFeature(1);
										}
									}
								}
							}

							// Set color for flow spec
							setColor(selectedBoc, Color.ORANGE.darker());
						} else {
							// Set color for segments
							setColor(selectedBoc, Color.MAGENTA.darker());
						}

						// Add new segment
						segmentSelections.add(insertIndex, new SegmentData(selectedBoc));

						opRunnable.ifPresent(runnable -> runnable.run());
					}

					updateWidgets();
				}
			} finally {
				elementSelectionDlg = null;
				createFlowImplDlg.getShell().setVisible(true);
			}
		}

		private void removeFeature(final int featureIndex) {
			final SegmentData featureToRemove = segmentSelections.get(featureIndex);
			if (featureToRemove.getBoc() instanceof DiagramElement) {
				coloring.setForeground((DiagramElement) featureToRemove.getBoc(), null);
			}
			segmentSelections.remove(featureToRemove);
		}

		private void moveFeature(final int movingFrom, final int movingTo) {
			final SegmentData bocToMove = segmentSelections.get(movingFrom);
			segmentSelections.remove(bocToMove);
			segmentSelections.add(movingTo, bocToMove);
		}

		private void setSegment(
				final BusinessObjectContext boc,
				final boolean isInsertAfter) {
			setSegment(Optional.empty(), boc, isInsertAfter);
		}

		private void setSegment(
				final Optional<Runnable> consumer,
				final BusinessObjectContext boc, final boolean isInsertAfter) {
			try {
				createFlowImplDlg.getShell().setVisible(false);
				if (elementSelectionDlg.open() == Window.OK && elementSelectionDlg != null && createFlowImplDlg != null) {
					final Optional<BusinessObjectContext> optBoc = getReplacementBoc();
					if (optBoc.isPresent()) {
						final BusinessObjectContext selectedBoc = optBoc.get();
						int insertIndex = modeFeatureSelections.indexOf(boc);
						if (isInsertAfter) {
							insertIndex++;
						}
						modeFeatureSelections.add(insertIndex, selectedBoc);
						setColor(selectedBoc, Color.MAGENTA.brighter());
						consumer.ifPresent(con -> con.run());
					}

					updateWidgets();
				}
			} finally {
				elementSelectionDlg = null;
				createFlowImplDlg.getShell().setVisible(true);
			}
		}

		private class SelectSegmentOrModeFeatureDialog extends TitleAreaDialog {
			private final String title;
			private final Function<Object, Boolean> isQualifiedType;
			private Label selectionLabel;

			public SelectSegmentOrModeFeatureDialog(final Shell parentShell, final BusinessObjectContext boc,
					final String title) {
				super(parentShell);
				this.isQualifiedType = getType(boc.getBusinessObject());
				this.title = title;
				setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			}

			private Function<Object, Boolean> getType(final Object bo) {
				final Function<Object, Boolean> isQualifiedType;
				if (bo instanceof ModeFeature) {
					isQualifiedType = (selectedBo) -> selectedBo instanceof ModeFeature;
				} else if (bo instanceof Feature) {
					isQualifiedType = (selectedBo) -> selectedBo instanceof Feature;
				} else {
					isQualifiedType = (selectedBo) -> selectedBo instanceof FlowElement;
				}

				return isQualifiedType;
			}

			@Override
			public void create() {
				super.create();
				setTitle(title);
				setMessage("Select element from diagram or outline view.");
				final Button okBtn = getButton(IDialogConstants.OK_ID);

				final List<BusinessObjectContext> bocs = AgeHandlerUtil.getSelectedBusinessObjectContexts();
				if (bocs.size() == 1 && bocs.get(0).getBusinessObject() instanceof NamedElement) {
					final NamedElement selectedElement = (NamedElement) bocs.get(0).getBusinessObject();
					okBtn.setEnabled(isQualifiedType.apply(selectedElement));
					selectionLabel.setText(FlowUtil.getRefinedName(selectedElement));
					setErrorMessage(null);
				} else {
					okBtn.setEnabled(false);
					setErrorMessage("Invalid selection.\n " + getMessage());
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

			public void setSelection(final BusinessObjectContext selection) {
				updateDialog(selection);
				getShell().layout(true, true);
			}

			private void updateDialog(final BusinessObjectContext boc) {
				final Object bo = boc.getBusinessObject();
				final boolean isEnabled = !modeFeatureSelections.contains(boc)
						&& isQualifiedType.apply(boc.getBusinessObject());
				final Button okBtn = getButton(IDialogConstants.OK_ID);
				if (okBtn != null) {
					okBtn.setEnabled(isEnabled);
				}

				if (bo instanceof NamedElement) {
					selectionLabel.setText(FlowUtil.getRefinedName((NamedElement) bo));
					setErrorMessage(null);
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
					selectionLabel.setText(FlowUtil.getRefinedName((NamedElement) bocs.get(0).getBusinessObject()));
				} else {
					selectionLabel.setText("<Invalid>");
				}

				selectionLabel.setLayoutData(
						GridDataFactory.fillDefaults().grab(false, true).align(SWT.CENTER, SWT.CENTER).create());

				return composite;
			}
		}

		private Optional<BusinessObjectContext> getFirstSelection() {
			if (segmentSelections.size() == 0) {
				return Optional.empty();
			}

			return Optional.ofNullable(segmentSelections.get(0).getBoc());
		}

		/**
		 * Returns the business object context for the owner of the new flow implementation
		 * @return
		 */
		private Optional<BusinessObjectContext> getOwnerBoc() {
			return getFirstSelection().map(boc -> boc.getParent());
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
			final Composite area = FlowDialogUtil.createFlowArea(parent, SWT.NONE);
			flowComposite = FlowDialogUtil.createFlowComposite(area);
			errorTableViewer = FlowDialogUtil.createErrorTableViewer(new Composite(area, SWT.NONE));
			return flowComposite;
		}

		@Override
		protected Control createButtonBar(final Composite parent) {
			final Composite buttonBar = new Composite(parent, SWT.NONE);
			final GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.numColumns = 3;
			buttonBar.setLayout(buttonBarLayout);
			final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
			buttonBar.setLayoutData(buttonBarData);
			buttonBar.setFont(parent.getFont());

			final Composite editButtonBar = new Composite(buttonBar, SWT.NONE);
			editButtonBar.setFont(parent.getFont());
			editButtonBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			final GridLayout editButtonBarLayout = new GridLayout();
			editButtonBarLayout.numColumns = 3;
			editButtonBar.setLayout(editButtonBarLayout);

			final Control buttonControl = super.createButtonBar(buttonBar);
			buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
			return buttonBar;
		}

		private Optional<BusinessObjectContext> getReplacementBoc() {
			final List<BusinessObjectContext> selectedBocs = AgeHandlerUtil.getSelectedBusinessObjectContexts();
			if (selectedBocs.size() == 1) {
				return selectedBocs.stream().filter(boc -> boc.getBusinessObject() instanceof NamedElement).findAny();
			}

			return Optional.empty();
		}
	}
}
