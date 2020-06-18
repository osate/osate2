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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
import org.osate.aadl2.Mode;
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
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.ui.util.DialogPlacementHelper;
import org.osate.ge.internal.util.AadlHelper;

import com.google.common.base.Function;

public class CreateFlowImplementationTool {
	private ColoringService.Coloring coloring = null;
	private CreateFlowImplementationDialog dlg;

	private final Map<BusinessObjectContext, SegmentData> userSelections = new LinkedHashMap<BusinessObjectContext, SegmentData>();

	public CreateFlowImplementationTool(final AgeDiagramEditor editor, final HighlightableFlowInfo selectedFlow,
			final List<BusinessObjectNode> nodes) {
		final FlowImplementation fi = (FlowImplementation) selectedFlow.getFlowSegment();
		final BusinessObjectNode container = (BusinessObjectNode) selectedFlow.getContainer();

		// Find ancestors of the end to end flow container
		final Queue<Element> ancestors = FlowUtil.getAncestors(container, Optional.empty());
		// Find the diagram element of the container
		final BusinessObjectContext ancestor = FlowUtil.getAncestorDiagramElement(editor.getAgeDiagram(), ancestors)
				.orElseThrow(() -> new RuntimeException("Cannot find container: " + container.getBusinessObject()));

		final Display display = Display.getCurrent();
		final NamingService namingService = Adapters.adapt(editor, NamingService.class);
		final UiService uiService = Adapters.adapt(editor, UiService.class);
		dlg = new CreateFlowImplementationDialog(display.getActiveShell(), selectedFlow, namingService, uiService);

		final Map<NamedElement, BusinessObjectContext> segmentToBoc = FlowUtil.getSegmentToBocMap(nodes, ancestor);

		// Needed to find segments in order.
		final ProjectReferenceService referenceService = Objects.requireNonNull(
				Adapters.adapt(editor, ProjectReferenceService.class), "Unable to retrieve reference service");

		final FlowSpecification fs = fi.getSpecification();
		if (fs != null) {
			final BusinessObjectContext boc = segmentToBoc.get(fs);
			final SegmentData sd = new SegmentData();
			userSelections.put(boc, sd);
		}

		if (fi.getInEnd() != null) {
			final BusinessObjectContext boc = segmentToBoc.get(fi.getInEnd().getFeature());
			final SegmentData sd = new SegmentData();
			userSelections.put(boc, sd);
		}

		fi.getOwnedFlowSegments().stream().map(seg -> AadlHelper.getRootRefinedElement(seg.getFlowElement()))
		.forEach(ele -> {
			BusinessObjectContext boc = segmentToBoc.get(ele);
			final SegmentData sd = new SegmentData();
			userSelections.put(boc, sd);
		});

		if (fi.getOutEnd() != null) {
			final BusinessObjectContext boc = segmentToBoc.get(fi.getOutEnd().getFeature());
			final SegmentData sd = new SegmentData();
			userSelections.put(boc, sd);
		}

		final Map<ModeFeature, BusinessObjectContext> mfs = ancestor.getChildren().stream()
				.filter(q -> q
						.getBusinessObject() instanceof ModeFeature)
				.collect(Collectors.toMap(q -> (ModeFeature) q.getBusinessObject(), q -> (BusinessObjectContext) q));

		fi.getInModeOrTransitions().stream().forEach(mf -> {
			BusinessObjectContext boc = mfs.get(mf);
			if (boc == null) {
				final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(mf,
						referenceService);
				boc = new BusinessObjectNode((BusinessObjectNode) selectedFlow.getContainer(), UUID.randomUUID(),
						childRef, mf, Completeness.UNKNOWN, false);
			}

			userSelections.put(boc, new SegmentData());
		});
	}

	private RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo,
			final ProjectReferenceService referenceService) {
		return referenceService.getRelativeReference(bo);
	}

	public CreateFlowImplementationTool(final AgeDiagramEditor editor) {
		final Display display = Display.getCurrent();
		final NamingService namingService = Adapters.adapt(editor, NamingService.class);
		final UiService uiService = Adapters.adapt(editor, UiService.class);
		dlg = new CreateFlowImplementationDialog(display.getActiveShell(), null, namingService, uiService);
	}

	@Activate
	public void activate(@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext selectedBoc,
			final AadlModificationService aadlModService, final UiService uiService,
			final NamingService namingService,
			final ColoringService coloringService) {
		try {
			// Check for existing errors or warnings
			final Set<Diagnostic> diagnostics = ToolUtil.getAllReferencedPackageDiagnostics(selectedBoc);
			if (!diagnostics.isEmpty()) {
				Display.getDefault().asyncExec(
						() -> new FlowDialogUtil.ErrorDialog("The Create Flow Implementation", diagnostics).open());
			} else {
				this.coloring = coloringService.adjustColors();

				// Create and update based on current selection
				dlg.create();
				if (userSelections.isEmpty()) {
					update(new BusinessObjectContext[] { selectedBoc }, true);
				} else {
					dlg.updateWidgets(false, true, false);
				}

				if (dlg.open() != Window.OK) {
					return;
				}

				if (dlg != null) {
					final FlowImplementation flowImpl = dlg.createFlow();
					if (dlg.flowSegmentToEdit != null) {
						final FlowImplementation flowImplToEdit = (FlowImplementation) dlg.flowSegmentToEdit
								.getFlowSegment();
						dlg.getFlowComponentImplementation(dlg.getOwnerBoc().orElse(null)).ifPresent(ownerCi -> {
							aadlModService.modify(flowImplToEdit, fi -> {
								flowImpl.getOwnedPropertyAssociations().addAll(fi.getOwnedPropertyAssociations());
								EcoreUtil.remove(fi);
							});

							aadlModService.modify(ownerCi, ci -> {
								ci.getOwnedFlowImplementations().add(flowImpl);
							});
						});
					} else {
						dlg.getFlowComponentImplementation(dlg.getOwnerBoc().orElse(null)).ifPresent(ownerCi -> {
							aadlModService.modify(ownerCi, ci -> {
								ci.getOwnedFlowImplementations().add(flowImpl);
								ci.setNoFlows(false);
							});
						});
					}
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


	/**
	 * Update the diagram and tool dialog
	 * @param selectedBocs - the selected bocs
	 * @param isInit - whether the selected bocs are the inital selection when the tool was activated
	 */
	private void update(final BusinessObjectContext[] selectedBocs, final boolean isInit) {
		// TODO add dlg is visible to ignore while replace or insert is active?
		if (dlg != null) {
			if (dlg.getShell() != null && !dlg.getShell().isDisposed() && dlg.selectionDlg == null) {
				// If the selection is a valid addition to the flow implementation, add it
				if (selectedBocs.length > 1) {
					dlg.setMultipleElementsSelected(true);
				} else if (selectedBocs.length == 1) {
					dlg.setMultipleElementsSelected(false);
					dlg.setValid(false);
					dlg.addSelectedElement(selectedBocs[0], isInit);
				}
			} else if (dlg.selectionDlg != null && dlg.selectionDlg
					.getShell() != null
					&& !dlg.selectionDlg.getShell().isDisposed() && dlg.selectionDlg.getShell().isVisible()) {
				if (selectedBocs.length > 1) {
					dlg.selectionDlg.setErrorMessage("Multiple elements are selected. ");
					dlg.selectionDlg.setSelection(null);
				} else if (selectedBocs.length == 1) {
					final BusinessObjectContext selectedBoc = selectedBocs[0];
					dlg.selectionDlg.setErrorMessage(null);
					dlg.selectionDlg.setSelection(selectedBoc);
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
	private class CreateFlowImplementationDialog extends TitleAreaDialog {
		private final UiService uiService;
		private final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private TableViewer errorTableViewer;
		private Composite flowComposite;
		private final HighlightableFlowInfo flowSegmentToEdit;
		private FlowImplementation fi;

		private SelectElementDialog selectionDlg;

		private boolean multipleElementsSelected = false;
		private boolean isValid = true;

		private Button removeBtn;
		private Button replaceBtn;
		private Button insertBtn;

		CreateFlowImplementationDialog(final Shell parentShell, final HighlightableFlowInfo selectedFlow,
				final NamingService namingService, final UiService uiService) {
			super(parentShell);
			this.uiService = Objects.requireNonNull(uiService, "ui service must not be null");
			this.flowSegmentToEdit = selectedFlow;
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

		private String getDirectionMessage() {
			String msg = "";
			final FlowSpecification fs = fi.getSpecification();
			if (fs == null) {
				msg = "Select the starting flow specification.";
			} else if (isValid) {
				msg = "Continue selecting flow segments or select the OK button to create the flow implementation.";
			} else {
				final FlowKind kind = fs.getKind();
				if (kind == FlowKind.SOURCE) {
					if (fi.getOutEnd() == null) {
						msg = "Select ending feature or flow segment.";
					} else {
						msg = "Select flow segment.";
					}
				} else if (kind == FlowKind.SINK) {
					if (fi.getInEnd() == null) {
						msg = "Select starting feature or flow segment.";
					} else {
						msg = "Select flow segment.";
					}
				} else {
					if (fi.getInEnd() == null) {
						msg = "Select starting feature";
					} else if (fi.getOutEnd() == null) {
						msg = "Select ending feature";
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
			return userSelections.keySet().stream().collect(Collectors.toList()).subList(1, userSelections.size());
		}

		private FlowImplementation createFlow() {
			// Create a flow implementation based on the state of the dialog
			final FlowImplementation flowImpl = (FlowImplementation) pkg.getEFactoryInstance()
					.create(pkg.getFlowImplementation());
			final FlowSpecification fs = getFlowSpecification().orElse(null);

			if (fs != null) {
				flowImpl.setSpecification(fs);
				flowImpl.setKind(fs.getKind());
			}

			getFlowComponentImplementationBoc(getOwnerBoc().orElse(null)).ifPresent(flowImplOwnerBoc -> {
				if (userSelections.size() > 1) {
					final List<BusinessObjectContext> segmentBocs = new ArrayList<>();
					final List<BusinessObjectContext> modeFeatureBocs = new ArrayList<>();
					populateSegmentsAndModeFeatures(fs, segmentBocs, modeFeatureBocs);

					final Iterator<BusinessObjectContext> it = segmentBocs.iterator();
					boolean firstSegment = true;
					while (it.hasNext()) {
						final BusinessObjectContext segment = it.next();
						final Object bo = segment.getBusinessObject();
						if (bo instanceof Feature) {
							if (firstSegment && fs != null
									&& (fs.getKind() == FlowKind.PATH || fs.getKind() == FlowKind.SINK)) {
								final FlowEnd inEnd = flowImpl.createInEnd();
								inEnd.setContext(ToolUtil.findContext(segment.getParent()));
								inEnd.setFeature((Feature) bo);
							} else {
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

						firstSegment = false;
					}

					for (final BusinessObjectContext tmpModeFeature : modeFeatureBocs) {
						flowImpl.getInModeOrTransitions().add((ModeFeature) tmpModeFeature.getBusinessObject());
					}
				}
			});

			return flowImpl;
		}

		private void populateSegmentsAndModeFeatures(final FlowSpecification fs,
				List<BusinessObjectContext> segmentBocs, List<BusinessObjectContext> modeFeatureBocs) {
			if (fs == null) {
				userSelections.keySet().forEach(boc -> {
					if (boc.getBusinessObject() instanceof ModeFeature) {
						modeFeatureBocs.add(boc);
					} else {
						segmentBocs.add(boc);
					}
				});
			} else {
				getSelectedBocsOtherThanFirst().forEach(boc -> {
					if (boc.getBusinessObject() instanceof ModeFeature) {
						modeFeatureBocs.add(boc);
					} else {
						segmentBocs.add(boc);
					}
				});
			}
		}

		/**
		 * @param boc - the business object context for the selected element
		 * @param isInit - whether the boc is the initial selection when tool is activated
		 */
		private void addSelectedElement(final BusinessObjectContext boc, final boolean isInit) {
			if (boc.getBusinessObject() instanceof NamedElement) {
				if ((getShell().isVisible() || isInit) && !userSelections.containsKey(boc)) {
					// Decide whether to add the element to the selection list
					final Object bo = boc.getBusinessObject();
					if (bo instanceof ModeFeature) {
						addSelection(boc);
					} else if (fi.getSpecification() == null && bo instanceof FlowSpecification) {
						insert(0, boc, new SegmentData());
						setErrorMessage(null);
						updateWidgets(false, false, true);
					} else {
						final FlowSpecification fs = fi.getSpecification();
						if (fs != null) {
							if (fs.getKind() == FlowKind.PATH) {
								if (bo instanceof Feature) {
									if (fi.getInEnd() == null) {
										if (userSelections.size() == 1) {
											addSelection(boc);
										} else {
											insert(1, boc, new SegmentData());
											setErrorMessage(null);
											updateWidgets(false, false, true);
										}
									} else if (fi.getOutEnd() == null) {
										addSelection(boc);
									}
								} else if (bo instanceof Connection || bo instanceof FlowElement) {
									if (fi.getOutEnd() == null) {
										addSelection(boc);
									} else {
										insert(getInsertIndex(), boc, new SegmentData());
										setErrorMessage(null);
										updateWidgets(false, false, true);
									}
								}
							} else if (fs.getKind() == FlowKind.SINK) {
								if (bo instanceof Feature) {
									if (fi.getInEnd() == null) {
										if (userSelections.size() == 1) {
											addSelection(boc);
										} else {
											insert(1, boc, new SegmentData());
											setErrorMessage(null);
											updateWidgets(false, false, true);
										}
									}
								} else if (bo instanceof Connection || bo instanceof FlowElement) {
									addSelection(boc);
								}
							} else {
								if (bo instanceof Feature && fi.getOutEnd() == null) {
									addSelection(boc);
								} else if (bo instanceof Connection || bo instanceof FlowElement) {
									if (fi.getOutEnd() == null) {
										addSelection(boc);
									} else {
										insert(getInsertIndex(), boc, new SegmentData());
										setErrorMessage(null);
										updateWidgets(false, false, true);
									}
								}
							}
						}
					}
				} else if (!isInit) {
					setErrorMessage("Invalid element selected. " + getDirectionMessage());
				}
			}
		}

		private void addSelection(final BusinessObjectContext boc) {
			setErrorMessage(null);
			final SegmentData sd = new SegmentData();
			userSelections.put(boc, sd);

			// Update the UI
			updateWidgets(false, false, true);
		}

		private int getInsertIndex() {
			final List<BusinessObjectContext> keys = userSelections.keySet().stream().collect(Collectors.toList());
			int i = keys.size() - 1;
			for (; i > 0; i--) {
				if (keys.get(i).getBusinessObject() instanceof Feature) {
					break;
				}
			}

			return i;
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

		private void updateWidgets(final boolean clearColor, final boolean updateEditBtns, final boolean updateSegments) {
			fi = createFlow();

			isValid = isFlowImplValid(fi);
			getButton(IDialogConstants.OK_ID).setEnabled(isValid);

			if(clearColor) {
				coloring.clear();
			}

			if (updateSegments) {
				userSelections.values().forEach(sd -> {
					sd.dispose();
				});

				// TODO this iterator and other can be merged?
				final Iterator<Entry<BusinessObjectContext, SegmentData>> userSelectionEntry = userSelections.entrySet()
						.iterator();

				if (userSelectionEntry.hasNext()) {
					Entry<BusinessObjectContext, SegmentData> flowSpecSD = userSelectionEntry.next();
					if (flowSpecSD.getKey() instanceof DiagramElement) {
						coloring.setForeground((DiagramElement) flowSpecSD.getKey(),
								flowSpecSD.getKey().getBusinessObject() instanceof ModeFeature
								? Color.MAGENTA
										.brighter()
										: Color.ORANGE.darker());
					}

					final List<BusinessObjectContext> inModes = new ArrayList<>();
					if (flowSpecSD.getKey().getBusinessObject() instanceof ModeFeature) {
						inModes.add(flowSpecSD.getKey());
					} else {
						// Flow spec data
						flowSpecSD.getValue().createSegmentButton(flowComposite,
								getRefinedName((NamedElement) flowSpecSD.getKey().getBusinessObject()),
								flowSegmentToEdit == null);
						final StyledText lbl = new StyledText(flowComposite, SWT.NONE);
						lbl.setBackground(flowComposite.getBackground());
						lbl.setLayoutData(new RowData());

						lbl.setText(":  flow ");
						lbl.setStyleRange(new StyleRange(3, 4, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED),
								null, SWT.BOLD));

						flowSpecSD.getValue().setLabel(lbl);

						final List<BusinessObjectContext> flowSegments = new ArrayList<>();
						while (userSelectionEntry.hasNext()) {
							final Entry<BusinessObjectContext, SegmentData> sd = userSelectionEntry.next();
							final BusinessObjectContext boc = sd.getKey();
							if (boc.getBusinessObject() instanceof ModeFeature) {
								inModes.add(boc);
								setColor(boc, Color.MAGENTA.brighter());
							} else {
								flowSegments.add(boc);
								setColor(boc, Color.MAGENTA.darker());
							}
						}

						final Iterator<BusinessObjectContext> flowSegmentIt = flowSegments.iterator();
						while (flowSegmentIt.hasNext()) {
							final BusinessObjectContext flowSegment = flowSegmentIt.next();
							userSelections.get(flowSegment).createSegmentButton(flowComposite,
									getRefinedName((NamedElement) flowSegment.getBusinessObject()), true);
							if (flowSegmentIt.hasNext()) {
								System.err.println("create label");
								// If segment is not last, add an arrow
								final StyledText labl = new StyledText(flowComposite, SWT.NONE);
								labl.setLayoutData(new RowData());
								labl.setText("-> ");
								labl.setBackground(flowComposite.getBackground());
								userSelections.get(flowSegment).setLabel(labl);
							}
						}
					}

					if (!inModes.isEmpty()) {
						final StyledText inModesText = new StyledText(flowComposite, SWT.NONE);
						inModesText.setText("in modes (");
						inModesText.setStyleRange(new StyleRange(0, 8,
								Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
						inModesText.setBackground(flowComposite.getBackground());

						final Iterator<BusinessObjectContext> it = inModes.iterator();
						final BusinessObjectContext boc = it.next();
						SegmentData segmentData = userSelections.get(boc);
						segmentData.setLabel(inModesText);
						segmentData.createSegmentButton(
								flowComposite,
								((NamedElement) boc.getBusinessObject()).getName() + (it.hasNext() ? "," : ")"), true);

						while (it.hasNext()) {
							final BusinessObjectContext mode = it.next();
							segmentData = userSelections.get(mode);
							segmentData.createSegmentButton(
									flowComposite,
									((NamedElement) mode.getBusinessObject()).getName() + (it.hasNext() ? "," : ")"),
									true);
						}
					}
				}

				flowComposite.layout(true, true);
				updateMessage();
			}

			if (updateEditBtns) {
				final List<Entry<BusinessObjectContext, SegmentData>> selections = userSelections.entrySet().stream()
						.filter(entry -> entry.getValue().btn.getSelection()).collect(Collectors.toList());
				replaceBtn.setEnabled(false);
				insertBtn.setEnabled(false);
				removeBtn.setEnabled(false);

				if (!selections.isEmpty()) {
					final FlowSpecification fs = fi.getSpecification();
					if (selections.size() == 1) {
						final Entry<BusinessObjectContext, SegmentData> selection = selections.get(0);
						final Object bo = selection.getKey().getBusinessObject();
						if (fs != null) {
							final boolean isFS = bo == fs;
							removeBtn.setEnabled(isFS ? fi.getOwnedFlowSegments().isEmpty() : true);
							insertBtn.setEnabled(!isFS && !(fi
									.getInEnd() != null
									&& fi
									.getInEnd()
									.getFeature() == bo
									|| fi.getOutEnd() != null && fi.getOutEnd().getFeature() == bo));
						} else {
							insertBtn.setEnabled(
									!((!fi.getOwnedFlowSegments()
											.isEmpty()
											&& fi.getOwnedFlowSegments().get(0).getFlowElement() == bo)
											|| (fi.getInEnd() != null && fi.getInEnd().getFeature() == bo)));
							removeBtn.setEnabled(true);
						}
						replaceBtn.setEnabled(true);
					} else {
						removeBtn.setEnabled(selections.size() == userSelections.size() || selections
								.stream().map(entry -> entry.getKey().getBusinessObject())
								.filter(bo -> !(bo instanceof ModeFeature)).findFirst().map(bo -> bo != fs).orElse(true));
					}
				}
			}
		}

		private Optional<FlowSpecification> getFlowSpecification() {
			// The flow specification should be the first thing selected by the user
			if (userSelections.size() == 0) {
				return Optional.empty();
			}

			final Iterator<BusinessObjectContext> firstSelection = userSelections.keySet().stream()
					.filter(boc -> !(boc.getBusinessObject() instanceof ModeFeature)).iterator();
			if (firstSelection.hasNext()) {
				final Object bo = firstSelection.next().getBusinessObject();
				return Optional.ofNullable(bo instanceof FlowSpecification ? (FlowSpecification) bo : null);
			}

			return Optional.empty();
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

			final List<BusinessObjectContext> segmentSelections = userSelections.keySet().stream()
					.filter(boc -> !(boc.getBusinessObject() instanceof ModeFeature)).collect(Collectors.toList());
			if (!segmentSelections.isEmpty()) {
				return Optional.ofNullable(segmentSelections.iterator().next().getParent());
			}

			return Optional.empty();
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
			updateWidgets(false, false, true);
		}

		private void setDefaultTitle() {
			setTitle("Creating Flow Implementation");
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = FlowDialogUtil.createFlowArea(parent, SWT.NONE);
			final ScrolledComposite scrollComposite = new ScrolledComposite(area, SWT.V_SCROLL | SWT.BORDER);

			scrollComposite.setAlwaysShowScrollBars(true); // TODO try false
			scrollComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
			flowComposite = new Composite(scrollComposite, SWT.NONE);
			flowComposite.setLayout(new RowLayout(SWT.HORIZONTAL));

			scrollComposite.setContent(flowComposite);
			scrollComposite.setExpandVertical(true);
			scrollComposite.setExpandHorizontal(true);
			scrollComposite.addControlListener(new ControlAdapter() {
				@Override
				public void controlResized(final ControlEvent e) {
					final Rectangle r = scrollComposite.getClientArea();
					scrollComposite.setMinSize(flowComposite.computeSize(r.width, SWT.DEFAULT));
				}
			});

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

			removeBtn = new Button(editButtonBar, SWT.PUSH);
			final String removeText = "Remove";
			removeBtn.setText(removeText);

			removeBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					removeSegments();
					uiService.clearSelection();
					updateWidgets(true, true, true);
				}
			});

			replaceBtn = new Button(editButtonBar, SWT.PUSH);
			replaceBtn.setText("Replace");
			replaceBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					getShell().setVisible(false);

					int[] mutableInt = { 0 };

					Optional<Entry<BusinessObjectContext, SegmentData>> selectedBocToSegmentDataOpt = getSelectedSegment(
							mutableInt);
					selectedBocToSegmentDataOpt.ifPresent(selectedBocToSegmentData -> {
						final BusinessObjectContext boc = selectedBocToSegmentData.getKey();
						final Object bo = boc.getBusinessObject();

						selectionDlg = getReplacementSelectionDialog(bo);
						int i = selectionDlg.open();
						if (selectionDlg != null && i == Window.OK) {

							final BusinessObjectContext selectedBoc = selectionDlg.selection;
							if (selectedBoc.getBusinessObject() instanceof NamedElement) {
								userSelections.remove(boc);
								// TODO set color for new boc
								if (boc instanceof DiagramElement) {
									coloring.setForeground((DiagramElement) boc, null);
								}
								insert(mutableInt[0], selectedBoc, selectedBocToSegmentData.getValue());
							}

							updateWidgets(false, false, true);
						}

						selectionDlg = null;
						getShell().setVisible(true);
					});
				}

				private SelectElementDialog getReplacementSelectionDialog(final Object bo) {
					final String message;
					final Function<BusinessObjectContext, Boolean> validSelection;
					final String title;
					if (fi.getSpecification() == bo) {
						final FlowSpecification fs = fi.getSpecification();
						message = "Replace flow specification: " + fs.getName() + "\nReplacement must be of kind: "
								+ fs.getKind().getName();
						validSelection = (boc) -> boc.getBusinessObject() instanceof FlowSpecification
								&& fs.getKind() == ((FlowSpecification) boc.getBusinessObject())
								.getKind();
						title = "Select Replacement Flow Specification";
					} else {
						if (bo instanceof ModeFeature) {
							message = "Replace " + (bo instanceof Mode
									? "mode: "
											: "mode transition: ")
									+ ((ModeFeature) bo).getName();
							validSelection = (boc) -> boc.getBusinessObject() instanceof ModeFeature;
							title = "Select Replacement Mode or Mode Transition";
						} else if (bo instanceof Feature) {
							message = "Replace feature: " + ((Feature) bo).getName();
							validSelection = (boc) -> boc.getBusinessObject() instanceof Feature;
							title = "Select Replacement Feature";
						} else if (bo instanceof FlowElement) {
							message = "Replace flow segment: " + getRefinedName((FlowElement) bo);
							validSelection = (boc) -> boc.getBusinessObject() instanceof FlowElement;
							title = "Select Replacement Flow Segment";
						} else {
							throw new RuntimeException("Unsupported type: " + bo);
						}
					}

					return new SelectElementDialog(getShell(), validSelection, message, title);
				}
			});

			insertBtn = new Button(editButtonBar, SWT.PUSH);
			insertBtn.setText("Insert");
			insertBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					try {
						getShell().setVisible(false);
						int[] mutableInt = { 0 };
						Optional<Entry<BusinessObjectContext, SegmentData>> selectedBocToSegmentDataOpt = getSelectedSegment(
								mutableInt);
						selectedBocToSegmentDataOpt.ifPresent(selectedBocToSegmentData -> {
							final Shell shell = getShell();
							final NamedElement ne = (NamedElement) selectedBocToSegmentData.getKey().getBusinessObject();

							if (ne instanceof ModeFeature) {
								selectionDlg = new SelectElementDialog(shell, (boc) -> boc
										.getBusinessObject() instanceof ModeFeature,
										"Insert mode or mode transition before: "
												+ getRefinedName(
														ne),
										"Select Mode or Mode Transition");
							} else {
								selectionDlg = new SelectElementDialog(shell, (boc) -> boc
										.getBusinessObject() instanceof FlowElement,
										"Insert flow segment before: "
												+ getRefinedName(
														ne),
										"Select Flow Segment");
							}

							if (selectionDlg != null && selectionDlg.open() == Window.OK) {
								final Optional<BusinessObjectContext> optBoc = getReplacementBoc();
								if (optBoc.isPresent()) {
									final BusinessObjectContext selectedBoc = optBoc.get();
									insert(mutableInt[0], selectedBoc, selectedBocToSegmentData.getValue());
								}

								updateWidgets(false, true, false);
							}
						});
					} finally {
						selectionDlg = null;
						dlg.getShell().setVisible(true);
					}
				}
			});

			final GridData removeBtnData = new GridData(SWT.LEFT, SWT.CENTER, false, true);
			removeBtnData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			removeBtnData.widthHint = 75;
			removeBtn.setLayoutData(removeBtnData);

			final GridData undoBtnData = new GridData(SWT.LEFT, SWT.CENTER, false, true);
			undoBtnData.widthHint = 75;

			replaceBtn.setLayoutData(undoBtnData);
			insertBtn.setLayoutData(undoBtnData);

			final Control buttonControl = super.createButtonBar(buttonBar);
			buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
			return buttonBar;
		}

		private Optional<Entry<BusinessObjectContext, SegmentData>> getSelectedSegment(final int[] mutableInt) {
			for (final Entry<BusinessObjectContext, SegmentData> entry : userSelections.entrySet()) {
				final Button btn = entry.getValue().getButton();
				if (btn.getSelection()) {

					return Optional.of(entry);
				}

				mutableInt[0]++;
			}

			return Optional.empty();
		}

		private Optional<BusinessObjectContext> getReplacementBoc() {
			final List<BusinessObjectContext> selectedBocs = AgeHandlerUtil.getSelectedBusinessObjectContexts();
			if (selectedBocs.size() == 1) {
				return selectedBocs.stream().filter(boc -> boc.getBusinessObject() instanceof NamedElement).findAny();
			}

			return Optional.empty();
		}

		public void insert(final int insertIndex, final BusinessObjectContext boc, final SegmentData segmentData) {
			final List<Entry<BusinessObjectContext, SegmentData>> rest = new ArrayList<>();
			int i = 0;
			for (final Entry<BusinessObjectContext, SegmentData> entry : userSelections.entrySet()) {
				if (i++ >= insertIndex) {
					rest.add(entry);
				}
			}

			userSelections.put(boc, segmentData);

			for (int j = 0; j < rest.size(); j++) {
				final Entry<BusinessObjectContext, SegmentData> entry = rest.get(j);
				entry.getValue().dispose();
				userSelections.remove(entry.getKey());
				if (entry.getKey() instanceof DiagramElement) {
					coloring.setForeground((DiagramElement) entry.getKey(), null);
				}

				userSelections.put(entry.getKey(), new SegmentData());
			}
		}

		private void removeSegments() {
			final Iterator<Entry<BusinessObjectContext, SegmentData>> it = userSelections.entrySet().iterator();
			while (it.hasNext()) {
				final Entry<BusinessObjectContext, SegmentData> entry = it.next();
				final SegmentData segmentData = entry.getValue();
				if (segmentData.getButton().getSelection()) {
					if (entry.getKey() instanceof DiagramElement) {
						coloring.setForeground((DiagramElement) entry.getKey(), null);
					}
					segmentData.dispose();
					it.remove();
				}
			}
		}
	}

	private void setColor(final BusinessObjectContext boc, final Color color) {
		if (boc instanceof DiagramElement) {
			setColor((DiagramElement) boc, color);
		}
	}

	private void setColor(final DiagramElement boc, final Color color) {
		coloring.setForeground((DiagramElement) boc, color);
	}

	private class SegmentData {
		private Button btn;
		private StyledText label;

		public Button getButton() {
			return btn;
		}

		public void setLabel(final StyledText label) {
			this.label = label;
			this.label.setCaret(null);
		}

		private void createSegmentButton(final Composite parent, final String text, final boolean enabled) {
			btn = new Button(parent, SWT.CHECK);
			btn.setText(text);
			btn.setEnabled(enabled);
			btn.setLayoutData(new RowData());
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					dlg.updateWidgets(false, true, false);
				};
			});
		}

		public void dispose() {
			if (btn != null) {
				this.btn.dispose();
			}

			if (label != null) {
				this.label.dispose();
			}
		}
	}

	private String getRefinedName(final NamedElement ne) {
		return AadlHelper.getRootRefinedElement(ne).getName();
	}


	private class SelectElementDialog extends TitleAreaDialog {
		private BusinessObjectContext selection;
		private final String dialogMessage;
		private Label selectionLabel;
		private final String title;
		private final Function<BusinessObjectContext, Boolean> test;

		public SelectElementDialog(final Shell parentShell, Function<BusinessObjectContext, Boolean> test,
				final String dialogMessage,
				final String title) {
			super(parentShell);
			this.dialogMessage = dialogMessage;
			this.title = title;
			this.test = test;
			setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}


		@Override
		public void create() {
			super.create();
			setTitle(title);
			setMessage(dialogMessage);

			getButton(IDialogConstants.OK_ID).setEnabled(false);

			final List<BusinessObjectContext> selectedElements = AgeHandlerUtil.getSelectedBusinessObjectContexts()
					.stream().limit(2).filter(boc -> boc.getBusinessObject() instanceof NamedElement)
					.collect(Collectors.toList());
			if (selectedElements.size() == 1) {
				updateDialog(selectedElements.get(0));
			}
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Select Element");
			newShell.setLocation(DialogPlacementHelper
					.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(400, 200);
			newShell.setMinimumSize(400, 200);
		}

		public void setSelection(final BusinessObjectContext selection) {
			this.selection = selection;
			updateDialog(selection);
			getShell().layout(true, true);
		}

		private void updateDialog(final BusinessObjectContext boc) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null && boc != null) {
				final Object bo = boc.getBusinessObject();
				okBtn.setEnabled(test.apply(boc) && !userSelections.containsKey(boc));
				selectionLabel.setText("Selected Element: " + (getRefinedName((NamedElement) bo)));
			} else {
				setErrorMessage("Multiple elements are selected.");
				selectionLabel.setText("Selected Element: ");
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

			selectionLabel = new Label(composite, SWT.NONE);
			selectionLabel.setLayoutData(
					GridDataFactory.fillDefaults().grab(false, true).align(SWT.CENTER, SWT.CENTER).create());

			return composite;
		}
	}
}
