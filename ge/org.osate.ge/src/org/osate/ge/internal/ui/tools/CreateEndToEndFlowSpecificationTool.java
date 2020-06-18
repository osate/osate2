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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.RowDataFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
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
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowElement;
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
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.query.Queryable;
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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;

public class CreateEndToEndFlowSpecificationTool {
	private ColoringService.Coloring coloring = null;
	private CreateFlowsToolsDialog dlg;
	private SelectElementDialog selectionDlg;
	private final AgeDiagramEditor editor;

	private final Map<BusinessObjectContext, SegmentData> segmentSelections = new LinkedHashMap<>();
	private final Map<BusinessObjectContext, SegmentData> modeFeatureSelections = new LinkedHashMap<>();
	// private final Map<BusinessObjectContext, SegmentData> userSelections = new LinkedHashMap<BusinessObjectContext, SegmentData>();

	private final ImmutableList<BusinessObjectNode> segmentNodes;

	public CreateEndToEndFlowSpecificationTool(final AgeDiagramEditor editor,
			final HighlightableFlowInfo selectedFlow, final List<BusinessObjectNode> segmentNodes) {
		this.editor = editor;
		this.segmentNodes = ImmutableList.copyOf(segmentNodes);
		final BusinessObjectNode container = (BusinessObjectNode) selectedFlow.getContainer();

		// Find ancestors of the end to end flow container
		final Queue<Element> ancestors = FlowUtil.getAncestors(container, Optional.empty());
		// Find the diagram element of the container
		final BusinessObjectContext ancestor = FlowUtil
				.getAncestorDiagramElement(
						editor
						.getAgeDiagram(),
						ancestors)
				.orElseThrow(() -> new RuntimeException(
						"Cannot find container: " + container.getBusinessObject()));

		final Display display = Display.getCurrent();
		final NamingService namingService = Adapters.adapt(editor, NamingService.class);
		final UiService uiService = Adapters.adapt(editor, UiService.class);

		dlg = new CreateFlowsToolsDialog(display.getActiveShell(),
				selectedFlow,
				namingService, uiService);
		dlg.setEndToEndFlowName(selectedFlow.getFlowSegment().getName());

		final Map<NamedElement, BusinessObjectContext> segmentToBoc = FlowUtil.getSegmentToBocMap(segmentNodes,
				ancestor);
		final ProjectReferenceService referenceService = Objects.requireNonNull(
				Adapters.adapt(editor, ProjectReferenceService.class), "Unable to retrieve reference service");

		final EndToEndFlow eTEFlow = (EndToEndFlow) selectedFlow.getFlowSegment();

		// Find segments in order
		eTEFlow.getAllFlowSegments()
		.stream()
		.map(flowSegment -> AadlHelper.getRootRefinedElement(flowSegment.getFlowElement()))
		.forEach(flowElement -> {
			final BusinessObjectContext boc = segmentToBoc.get(flowElement);
			final SegmentData sd = new SegmentData();
			segmentSelections.put(boc, sd);
			if (boc.getBusinessObject() instanceof EndToEndFlow && ancestor instanceof DiagramElement) {
				findSegments((EndToEndFlow) boc.getBusinessObject(), ancestor, sd);
			}
		});

		final Map<ModeFeature, BusinessObjectContext> modeFeatures = ancestor
				.getChildren()
				.stream()
				.filter(
						q -> q.getBusinessObject() instanceof ModeFeature)
				.collect(Collectors.toMap(q -> (ModeFeature) q.getBusinessObject(),
						q -> (BusinessObjectContext) q));

		eTEFlow.getInModeOrTransitions().stream().forEach(modeFeature -> {
			BusinessObjectContext boc = modeFeatures.get(modeFeature);
			if (boc == null) {
				final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(
						modeFeature,
						referenceService);
				boc = new BusinessObjectNode((BusinessObjectNode) container,
						UUID.randomUUID(),
						childRef,
						modeFeature,
						Completeness.UNKNOWN, false);
			}

			modeFeatureSelections.put(boc, new SegmentData());
		});
	}

	private void findSegments(final EndToEndFlow eTEFlow, final BusinessObjectContext ancestor,
			final SegmentData segmentData) {
		final DiagramElement parentDe = (DiagramElement) ancestor;

		for (final EndToEndFlowSegment segment : eTEFlow.getOwnedEndToEndFlowSegments().stream()
				.filter(eTEFlowSegment -> eTEFlowSegment.getFlowElement() != eTEFlow).collect(Collectors.toList())) {
			if (segment.getFlowElement() instanceof EndToEndFlow) {
				findSegments((EndToEndFlow) segment.getFlowElement(), ancestor, segmentData);
			}
			Queryable context = parentDe;
			if (segment.getContext() != null) {
				context = parentDe.getChildren().stream()
						.filter(child -> child.getBusinessObject() == segment.getContext()).findAny().orElse(null);
				if (context == null) {
					continue;
				}
			}

			if (segment.getFlowElement() instanceof FlowElement) {
				context.getChildren().stream().filter(child -> child.getBusinessObject() == segment.getFlowElement())
				.map(DiagramElement.class::cast).findAny().ifPresent(de -> segmentData.segments.add(de));
			}
		}
	}



	private RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo,
			final ProjectReferenceService referenceService) {
		return referenceService.getRelativeReference(bo);
	}

	private EndToEndFlow getEndToEndFlow(final ComponentImplementation ownerCi, final EndToEndFlow eTEFlow) {
		final String eTEFlowName = AadlHelper.getRootRefinedElement(eTEFlow).getName();
		for (final EndToEndFlow ownedEteFlow : ownerCi.getOwnedEndToEndFlows()) {
			if (AadlHelper.getRootRefinedElement(ownedEteFlow).getName().equalsIgnoreCase(eTEFlowName)) {
				return ownedEteFlow;
			}
		}

		throw new RuntimeException("cannot find end to end flow");
	}

	public CreateEndToEndFlowSpecificationTool(final AgeDiagramEditor editor) {
		this.editor = editor;
		this.segmentNodes = ImmutableList.of();

		final Display display = Display.getCurrent();
		final NamingService namingService = Adapters.adapt(editor, NamingService.class);
		final UiService uiService = Adapters.adapt(editor, UiService.class);
		dlg = new CreateFlowsToolsDialog(display.getActiveShell(), null, namingService, uiService);
	}

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
				// Create and update based on current selection
				dlg.create();
				if (segmentSelections.isEmpty() && modeFeatureSelections.isEmpty()) {
					update(new BusinessObjectContext[] { selectedBoc }, true);
				} else {
					update();
				}

				if (dlg.open() != Window.OK) {
					return;
				}

				if (dlg != null) {
					dlg.getFlow().ifPresent(eteFlow -> {
						if (dlg.flowSegmentToEdit != null) {
							// Editing end to end flow
							final EndToEndFlow endToEndFlowToEdit = (EndToEndFlow) dlg.flowSegmentToEdit
									.getFlowSegment();

							final boolean isRefined = eteFlow.getRefined() != null;
							final boolean removeRefine = endToEndFlowToEdit.getRefined() != null
									&& !isRefined;
							if (removeRefine) {
								aadlModService.modify(endToEndFlowToEdit.getContainingComponentImpl(), ci -> {
									// Remove Refinement
									final EndToEndFlow eTEFlowToRemove = getEndToEndFlow(ci, endToEndFlowToEdit);
									ci.getOwnedEndToEndFlows().remove(eTEFlowToRemove);
								});
							} else if (!isRefined) {
								// Editing existing end to end flow
								aadlModService.modify(endToEndFlowToEdit, ete -> {
									ete.getAllFlowSegments().clear();
									ete.getAllFlowSegments().addAll(eteFlow.getAllFlowSegments());
									ete.setName(eteFlow.getName());
									ete.getInModeOrTransitions().clear();
									ete.getInModeOrTransitions().addAll(eteFlow.getInModeOrTransitions());
								});
							} else {
								// Setting refined
								final ComponentImplementation ownerCi = dlg.getOwnerComponentImplementation()
										.orElseThrow(() -> new RuntimeException("cannot find owner"));
								aadlModService.modify(ownerCi, ci -> {
									final EndToEndFlow ete = getOrCreate(ci, eteFlow);
									ete.setRefined(eteFlow.getRefined());
									ete.getInModeOrTransitions().clear();
									ete.getInModeOrTransitions().addAll(eteFlow.getInModeOrTransitions());
								});
							}
						} else {
							// Creating end to end flow
							dlg.getOwnerComponentImplementation().ifPresent(ownerCi -> {
								aadlModService.modify(ownerCi, ci -> {
									ci.getOwnedEndToEndFlows().add(eteFlow);
									ci.setNoFlows(false);
								});
							});
						}
					});
				}
			}
		} finally {
			uiService.deactivateActiveTool();
		}
	}

	private EndToEndFlow getOrCreate(final ComponentImplementation ci, EndToEndFlow eteFlow) {
		for (final EndToEndFlow ownedEndToEndFlow : ci.getOwnedEndToEndFlows()) {
			if (getRefinedName(ownedEndToEndFlow).equalsIgnoreCase(getRefinedName(eteFlow))) {
				return ownedEndToEndFlow;
			}
		}
		return ci.createOwnedEndToEndFlow();
	}

	private String getRefinedName(final NamedElement ne) {
		return AadlHelper.getRootRefinedElement(ne).getName();
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

		this.segmentSelections.clear();
		this.modeFeatureSelections.clear();
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
	public void update() {
		System.err.println("update");
		if (dlg != null && dlg.getShell() != null && !dlg.getShell().isDisposed() && dlg.flowComposite != null
				&& !dlg.flowComposite.isDisposed()) {
			// Get the selected boc
			if (dlg.newETEFlowName.getText().isEmpty()) {
				dlg.setFlowNameText(dlg.flowSegmentToEdit.getFlowSegment().getName());
			}

			final EndToEndFlow endToEndFlow = createEndToEndFlow();

			for (final Entry<BusinessObjectContext, SegmentData> entry : segmentSelections.entrySet()) {
				final BusinessObjectContext selectedBoc = entry.getKey();
				if (selectedBoc.getBusinessObject() instanceof EndToEndFlow) {
					entry.getValue().segments.forEach(de -> {
						coloring.setForeground(de, Color.MAGENTA.darker());
					});
				}

				if (selectedBoc instanceof DiagramElement) {
					final DiagramElement selectedDe = (DiagramElement) selectedBoc;
					if (selectedBoc.getBusinessObject() instanceof ModeFeature) {
						coloring.setForeground(selectedDe, Color.MAGENTA.brighter());
					} else {
						coloring.setForeground(selectedDe, Color.MAGENTA.darker());
					}
				}
			}

			for (final Entry<BusinessObjectContext, SegmentData> entry : modeFeatureSelections.entrySet()) {
				final BusinessObjectContext selectedBoc = entry.getKey();
				if (selectedBoc instanceof DiagramElement) {
					coloring.setForeground((DiagramElement) selectedBoc, Color.MAGENTA.brighter());
				}
			}

			String error = null;
			final boolean isValid = dlg.isEndToEndFlowValid(endToEndFlow);
			if (!isValid) {
				error = dlg.getValidFlowErrorMessage();
			}

			dlg.updateSegments(true);
			dlg.updateWidgets(isValid);

			if (error == null) {
				dlg.setErrorMessage(null);
				dlg.setMessage(getDialogMessage());
			} else {
				dlg.setErrorMessage(error + getDialogMessage());
			}

		}
	}

	private EndToEndFlow createEndToEndFlow() {
		final EndToEndFlow endToEndFlow = (EndToEndFlow) dlg.pkg.getEFactoryInstance()
				.create(dlg.pkg.getEndToEndFlow());
		// final List<BusinessObjectContext> flowSegments = new ArrayList<>();

		if (dlg.isRefined) {
			endToEndFlow.setRefined(
					(EndToEndFlow) AadlHelper.getRootRefinedElement(dlg.flowSegmentToEdit.getFlowSegment()));
		} else {
			endToEndFlow.setName(dlg.endToEndFlowName);
			// flowSegments.forEach(boc -> {
			segmentSelections.keySet().forEach(boc -> {
				final EndToEndFlowSegment eteFlowSegment = endToEndFlow.createOwnedEndToEndFlowSegment();
				if (!(boc.getBusinessObject() instanceof Connection)
						&& !(boc.getBusinessObject() instanceof DataSubcomponent)
						&& !(boc.getBusinessObject() instanceof EndToEndFlow)) {
					final Context context = ToolUtil.findContext(boc);
					eteFlowSegment.setContext(context);
				}
				eteFlowSegment.setFlowElement((EndToEndFlowElement) boc.getBusinessObject());
				endToEndFlow.getOwnedEndToEndFlowSegments().add(eteFlowSegment);
			});
		}

//		segmentSelections.keySet().forEach(boc -> {
//
//			final Object bo = boc.getBusinessObject();
//			if (bo instanceof EndToEndFlowElement) {
//				flowSegments.add(boc);
//			} else if (bo instanceof ModeFeature) {
//				endToEndFlow.getInModeOrTransitions().add((ModeFeature) bo);
//			} else {
//				throw new RuntimeException("Unsupported type: " + bo);
//			}
//		});
//
//
//		segmentSelections.keySet().forEach(boc -> {
//			final Object bo = boc.getBusinessObject();
//			if (bo instanceof EndToEndFlowElement) {
//				flowSegments.add(boc);
//			} else if (bo instanceof ModeFeature) {
//				endToEndFlow.getInModeOrTransitions().add((ModeFeature) bo);
//			} else {
//				throw new RuntimeException("Unsupported type: " + bo);
//			}
//		});

		modeFeatureSelections.keySet()
		.forEach(boc -> endToEndFlow.getInModeOrTransitions().add((ModeFeature) boc.getBusinessObject()));

//		if (dlg.isRefined) {
//			endToEndFlow.setRefined(
//					(EndToEndFlow) AadlHelper.getRootRefinedElement(dlg.flowSegmentToEdit.getFlowSegment()));
//		} else {
//			endToEndFlow.setName(dlg.endToEndFlowName);
//			flowSegments.forEach(boc -> {
//				final EndToEndFlowSegment eteFlowSegment = endToEndFlow.createOwnedEndToEndFlowSegment();
//				if (!(boc.getBusinessObject() instanceof Connection)
//						&& !(boc.getBusinessObject() instanceof DataSubcomponent)
//						&& !(boc.getBusinessObject() instanceof EndToEndFlow)) {
//					final Context context = ToolUtil.findContext(boc);
//					eteFlowSegment.setContext(context);
//				}
//				eteFlowSegment.setFlowElement((EndToEndFlowElement) boc.getBusinessObject());
//				endToEndFlow.getOwnedEndToEndFlowSegments().add(eteFlowSegment);
//			});
//		}

		return endToEndFlow;
	}

	/**
	 * Update the diagram and tool dialog
	 * @param selectedBocs - the selected bocs
	 * @param isInit - whether the selected bocs are the inital selection when the tool was activated
	 */
	private void update(final BusinessObjectContext[] selectedBocs, final boolean isInit) {
		if (dlg != null && dlg.getShell() != null && !dlg.getShell().isDisposed()
				&& selectionDlg == null
				&& dlg.flowComposite != null
				&& !dlg.flowComposite.isDisposed()) {
			// If the selection is a valid addition to the end to end flow specification, add it.
			if (selectedBocs.length > 1) {
				dlg.setErrorMessage("Multiple elements selected. Select a single element. " + " " + getDialogMessage());
			} else if (selectedBocs.length == 1) {
				// Get the selected boc
				final BusinessObjectContext selectedBoc = (BusinessObjectContext) selectedBocs[0];
				String error = null;
				if (!segmentSelections.containsKey(selectedBoc) && !modeFeatureSelections.containsKey(selectedBoc)
						&& dlg.addSelectedElement(selectedBoc)) {
					// Insert flow segments before first mode feature
					if (selectedBoc.getBusinessObject() instanceof ModeFeature) {
//						int i = 0;
//						for (final BusinessObjectContext key : userSelections.keySet()) {
//							if (key.getBusinessObject() instanceof ModeFeature) {
//								break;
//							}
//							i++;
//						}

//						dlg.insert(userSelections.keySet().stream().findAny().orElse(null), selectedBoc,
//								new SegmentData());
						modeFeatureSelections.put(
								selectedBoc,
								new SegmentData());
					} else {
						segmentSelections.put(
								selectedBoc,
								new SegmentData());
					}
					// Set default name on first selection if one does not exist
					if (segmentSelections.size() == 1) {
						dlg.getOwnerComponentImplementation().ifPresent(ci -> {
							dlg.setTitle("Creating End To End Flow in: " + ci.getQualifiedName());
							if (dlg.endToEndFlowName.isEmpty()) {
								dlg.setEndToEndFlowName(ci);
							}
						});
					}
					dlg.updateSegments(false);
				} else if (!isInit) {
					error = "Invalid element selected.  ";
				}

				final boolean isValid = dlg.isEndToEndFlowValid(createEndToEndFlow());
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
		} else if (selectionDlg != null && selectionDlg.getShell() != null && !selectionDlg.getShell().isDisposed()
				&& selectionDlg.getShell().isVisible()) {
			if (selectedBocs.length > 1) {
				selectionDlg.setErrorMessage("Multiple elements are selected.  ");
			} else if (selectedBocs.length == 1) {
				selectionDlg.setErrorMessage(null);
				final BusinessObjectContext selectedBoc = selectedBocs[0];
				selectionDlg.setInput(selectedBoc);
			}
		}
	}

	// Determine message based on currently selected element
	private String getDialogMessage() {
		String msg = "";
		if (!segmentSelections.isEmpty()) {
			msg = "Select a flow segment.";
		} else {
			dlg.setDefaultTitle();
			msg = "Select a starting flow specification.";
		}
		msg += "\nOptionally, select a mode or mode transition.";

		return msg;
	}

	/**
	 * @param selectedEle - current element
	 * @param context - current context
	 * @return - true or false depending on if the selected element is a valid start element
	 */
	private boolean isValidFirstElement(final Element selectedEle, final Context context) {
		return (selectedEle instanceof FlowSpecification
				&& ((FlowSpecification) selectedEle).getKind() == FlowKind.SOURCE && context instanceof Subcomponent)
				|| selectedEle instanceof DataSubcomponent;
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
		final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private String endToEndFlowName = "";
		private boolean isRefined = false;
		private final String invalidErrorMessage = "Invalid End-To-End Flow.  ";
		private final HighlightableFlowInfo flowSegmentToEdit;

		private EndToEndFlow flow;
		private Composite flowComposite;
		private TableViewer errorTableViewer;
		private Text newETEFlowName;
		private Button replaceBtn;
		private Button removeBtn;
		private Button insertBtn;

		public CreateFlowsToolsDialog(final Shell parentShell, final HighlightableFlowInfo selectedFlow,
				final NamingService namingService,
				final UiService uiService) {
			super(parentShell);
			setHelpAvailable(true);
			this.flowSegmentToEdit = selectedFlow;
			this.namingService = Objects.requireNonNull(namingService, "naming service must not be null");
			this.uiService = Objects.requireNonNull(uiService, "ui service must not be null");
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		public void setEndToEndFlowName(final Namespace namespace) {
			final String eteName = namingService.buildUniqueIdentifier(namespace, "new_ete_flow");
			setEndToEndFlowName(eteName);
			setFlowNameText(eteName);
		}

		public void setEndToEndFlowName(final String endToEndFlowName) {
			this.endToEndFlowName = endToEndFlowName;
		}

		public void setFlowNameText(final String eteName) {
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
			System.err.println("ADD");
			final Object selectedBo = selectedBoc.getBusinessObject();

			if (selectedBo instanceof Element) {
				final Context context = ToolUtil.findContext(selectedBoc);
				final Element selectedEle = (Element) selectedBo;
				if (isValid(getRefinedElement(selectedEle), (Context) getRefinedElement(context))) {
					if (selectedEle instanceof org.osate.aadl2.Connection) {
						// Create flow segment with context = null because all valid connections belong to diagram
						return addFlowSegmentOrModeFeature();
					} else if (selectedEle instanceof FlowSpecification) {
						return addFlowSegmentOrModeFeature();
					} else {
						return addFlowSegmentOrModeFeature();
					}
				}
			}

			System.err.println("return false");
			return false;
		}

		/**
		 * @param object - Flow segment or mode feature added to End to End Flow
		 * @return - true or false depending on if the object was added to End to End Flow
		 */
		private boolean addFlowSegmentOrModeFeature() {
			if (!flowComposite.isDisposed()) {
				System.err.println("AAA");
				return true;
			}
			return false;
		}

		// Returns the component implementation that will own the end to end flow
		private Optional<ComponentImplementation> getOwnerComponentImplementation() {
			if (flowSegmentToEdit != null && !isRefined) {
				return findOwnerComponentImplementation(flowSegmentToEdit.getContainer());
			}

			// The flow specification should be the first thing selected by the user
			if (segmentSelections.size() == 0) {
				return Optional.empty();
			}

			final BusinessObjectContext firstSelection = segmentSelections.keySet().iterator().next();
			if (firstSelection.getBusinessObject() instanceof Subcomponent
					|| firstSelection.getBusinessObject() instanceof EndToEndFlow) {
				return findOwnerComponentImplementation(
						segmentSelections.keySet().iterator().next().getParent());
			}

			return findOwnerComponentImplementation(
					segmentSelections.keySet().iterator().next().getParent().getParent());
		}

		private Optional<ComponentImplementation> findOwnerComponentImplementation(
				final Queryable boc) {
			Queryable tmp = boc;
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
				diagnostics = Collections.emptySet();
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
				if (flowSegmentToEdit != null) {
					EndToEndFlow endToEndFlowToEdit = getFlowToEdit(objectToModify);
					final boolean isRefined = endToEndFlow.getRefined() != null;
					final boolean removeRefine = endToEndFlowToEdit.getRefined() != null && !isRefined;
					if (removeRefine) {
						System.err.println("remove refine teest");
						objectToModify.getOwnedEndToEndFlows().remove(endToEndFlowToEdit);
						objectToModify.setNoFlows(objectToModify.getOwnedEndToEndFlows().isEmpty());

						final EndToEndFlow rootEndToEndFlowToEdit = (EndToEndFlow) AadlHelper
								.getRootRefinedElement(endToEndFlowToEdit);
						rootEndToEndFlowToEdit.getAllFlowSegments().clear();
						for (final EndToEndFlowSegment e : endToEndFlow.getAllFlowSegments()) {
							final EndToEndFlowSegment segment = rootEndToEndFlowToEdit.createOwnedEndToEndFlowSegment();
							if (e.getContext() != null) {
								if (!(e.getFlowElement() instanceof Connection)) {
									System.err.println("setting context");
									segment.setContext(
											(Context) resourceSet.getEObject(EcoreUtil.getURI(e.getContext()), true));
								}
							}
							segment.setFlowElement((EndToEndFlowElement) resourceSet
									.getEObject(EcoreUtil.getURI(e.getFlowElement()), true));
						}

						rootEndToEndFlowToEdit.getInModeOrTransitions().clear();
						endToEndFlow.getInModeOrTransitions()
						.forEach(mf -> rootEndToEndFlowToEdit.getInModeOrTransitions()
								.add((ModeFeature) resourceSet.getEObject(EcoreUtil.getURI(mf), true)));
					} else if (!isRefined) {
						objectToModify = (ComponentImplementation) resourceSet.getEObject(
								EcoreUtil.getURI(flowSegmentToEdit.getFlowSegment().getContainingComponentImpl()),
								true);

						endToEndFlowToEdit.getAllFlowSegments().clear();
						endToEndFlowToEdit.getAllFlowSegments().addAll(endToEndFlow.getAllFlowSegments());
						endToEndFlowToEdit.setName(endToEndFlow.getName());
						endToEndFlowToEdit.getInModeOrTransitions().clear();
						endToEndFlow.getInModeOrTransitions().forEach(mf -> endToEndFlowToEdit.getInModeOrTransitions()
								.add((ModeFeature) resourceSet.getEObject(EcoreUtil.getURI(mf), true)));
					} else {
						final EndToEndFlow et = getOrCreate(objectToModify, endToEndFlow);
						et.setRefined(endToEndFlow.getRefined());
						et.getInModeOrTransitions().clear();
						et.getInModeOrTransitions().addAll(endToEndFlow.getInModeOrTransitions());
					}
				} else {
					objectToModify.getOwnedEndToEndFlows().add(endToEndFlow);
					objectToModify.setNoFlows(false);
				}
				return objectToModify;
			};
		}

		private EndToEndFlow getFlowToEdit(final ComponentImplementation objectToModify) {
			final String name = getRefinedName(flowSegmentToEdit.getFlowSegment());
			for (final EndToEndFlow flow : objectToModify.getAllEndToEndFlows()) {
				if (getRefinedName(flow).equalsIgnoreCase(name)) {
					return flow;
				}
			}
			throw new RuntimeException("cannot find ete flow");
		}

		private void updateWidgets(final boolean isValid) {
			dlg.setMessage(getDialogMessage());
			setNavigationButtonsEnabled(isValid && dlg.endToEndFlowName.length() != 0);
			// updateButtons();
		}

		private void updateSegments(final boolean clearColoring) {
			System.err.println("update segments");
			if (clearColoring) {
				coloring.clear();
			}

			segmentSelections.values().forEach(sd -> {
				sd.dispose();
			});

			modeFeatureSelections.values().forEach(sd -> {
				sd.dispose();
			});

			// final List<Entry<BusinessObjectContext, SegmentData>> inModes = new ArrayList<>();
			// final List<Entry<BusinessObjectContext, SegmentData>> segments = new ArrayList<>();
			final boolean enable = flowSegmentToEdit == null || !isRefined;
			final Iterator<Entry<BusinessObjectContext, SegmentData>> userSelectionEntry = segmentSelections
					.entrySet()
					.iterator();

//			while (userSelectionEntry.hasNext()) {
//				// Flow spec data
//				final Entry<BusinessObjectContext, SegmentData> flowSpecSD = userSelectionEntry.next();
//				final BusinessObjectContext key = flowSpecSD.getKey();
//				if (key.getBusinessObject() instanceof ModeFeature) {
//					inModes.add(flowSpecSD);
//				} else {
//					segments.add(flowSpecSD);
//				}
//			}

			final Iterator<Entry<BusinessObjectContext, SegmentData>> segmentsIt = segmentSelections.entrySet()
					.iterator();
			while (segmentsIt.hasNext()) {
				final Entry<BusinessObjectContext, SegmentData> flowSegment = segmentsIt.next();
				final SegmentData sd = flowSegment.getValue();
				sd.setButton(flowComposite, AadlHelper
						.getRootRefinedElement((NamedElement) flowSegment.getKey().getBusinessObject()).getName(),
						enable, flowSegment.getKey());

				if (flowSegment.getKey() instanceof DiagramElement) {
					coloring.setForeground((DiagramElement) flowSegment.getKey(), Color.MAGENTA.darker());
				}

				if (flowSegment.getKey().getBusinessObject() instanceof EndToEndFlow) {
					flowSegment
					.getValue().segments
					.forEach(de -> coloring.setForeground(de, Color.MAGENTA.darker()));
				}

				// If segment is not last, add an arrow
				if (segmentsIt.hasNext()) {
					final StyledText segmentLabel = new StyledText(flowComposite, SWT.BOTTOM);
					segmentLabel.setLayoutData(new RowData());
					segmentLabel.setText("-> ");
					segmentLabel.setBackground(flowComposite.getBackground());
					sd.setLabel(segmentLabel);
				}
			}

			if (!modeFeatureSelections.isEmpty()) {
				final StyledText inModesText = new StyledText(flowComposite, SWT.NONE);
				inModesText.setText("in modes ");
				inModesText.setStyleRange(
						new StyleRange(0, 8, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				inModesText.setBackground(flowComposite.getBackground());

				final Iterator<Entry<BusinessObjectContext, SegmentData>> it = modeFeatureSelections.entrySet()
						.iterator();
				final Entry<BusinessObjectContext, SegmentData> boc = it.next();
				if (boc.getKey() instanceof DiagramElement) {
					coloring.setForeground((DiagramElement) boc.getKey(), Color.MAGENTA.brighter());
				}

				SegmentData sd = boc.getValue();
				sd.setLabel(inModesText);
				sd.setButton(flowComposite,
						"(" + ((NamedElement) boc.getKey().getBusinessObject()).getName() + (it.hasNext() ? "," : ")"),
						true,
						boc.getKey());

				while (it.hasNext()) {
					final Entry<BusinessObjectContext, SegmentData> mode = it.next();
					sd = mode.getValue();
					sd.setButton(flowComposite,
							((NamedElement) mode.getKey().getBusinessObject()).getName() + (it.hasNext() ? "," : ")"),
							true, boc.getKey());
					if (mode.getKey() instanceof DiagramElement) {
						coloring.setForeground((DiagramElement) mode.getKey(), Color.MAGENTA.brighter());
					}
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

		/**
		 * Determines if the selected element is valid to be added to End to End Flow
		 * @param selectedEle - selected element
		 * @param context - context of element
		 */
		private boolean isValid(final Element selectedEle, final Context context) {
			if ((segmentSelections
					.isEmpty()
					&& (selectedEle instanceof FlowSpecification || (selectedEle instanceof DataSubcomponent)))) {
				return isValidFirstElement(selectedEle, context);
			} else if (selectedEle instanceof ModeFeature) {
				return true;
			} else {
				if (selectedEle instanceof FlowSpecification || selectedEle instanceof Connection) {
					return true;
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
			final Composite area = FlowDialogUtil.createFlowArea(parent, SWT.NONE);
			final Composite parentComposite = FlowDialogUtil.createFlowArea(area, SWT.BORDER);

			final ScrolledComposite scrollComposite = new ScrolledComposite(parentComposite,
					SWT.V_SCROLL | SWT.BORDER);

			scrollComposite.setAlwaysShowScrollBars(true);
			scrollComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
			flowComposite = new Composite(scrollComposite, SWT.NONE);
			final RowLayout flowCompLayout = RowLayoutFactory.fillDefaults().type(SWT.HORIZONTAL).create();
			flowCompLayout.center = true;
			flowComposite.setLayout(flowCompLayout);
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

			final Composite buttonComposite = new Composite(parentComposite, SWT.NONE);
			final RowLayout rowLayout = new RowLayout();
			rowLayout.center = true;
			rowLayout.spacing = 5;
			rowLayout.fill = false;
			rowLayout.marginLeft = 10;
			buttonComposite.setLayout(rowLayout);


			final Label editLabel = new Label(buttonComposite, SWT.NONE);
			editLabel.setText("Edit:");
			editLabel.setAlignment(SWT.CENTER);
			final RowData rowData = RowDataFactory.swtDefaults().hint(125, SWT.DEFAULT).create();

			replaceBtn = new Button(buttonComposite, SWT.PUSH);
			replaceBtn.setEnabled(false);
			// replaceBtn.setText("Replace");
			replaceBtn.setText("Add End to End Flow");

			replaceBtn.setLayoutData(rowData);

			replaceBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
//					setReplacementSegment("Replace", (bocToReplace) -> {
//						userSelections.remove(bocToReplace);
//						if (bocToReplace instanceof DiagramElement) {
//							coloring.setForeground((DiagramElement) bocToReplace, null);
//						}
//					});
				}
			});

//			insertBtn = new Button(buttonComposite, SWT.PUSH);
//			insertBtn.setText("Insert");
//			insertBtn.setEnabled(false);
//			insertBtn.setLayoutData(rowData);
//			insertBtn.addSelectionListener(new SelectionAdapter() {
//				@Override
//				public void widgetSelected(final SelectionEvent e) {
////					setReplacementSegment("Insert before", (boc) -> {
////					});
//				}
//			});

//			removeBtn = new Button(buttonComposite, SWT.PUSH);
//			removeBtn.setText("Remove");
//			removeBtn.setEnabled(false);
//			removeBtn.setLayoutData(rowData);
//			removeBtn.addSelectionListener(new SelectionAdapter() {
//				@Override
//				public void widgetSelected(final SelectionEvent e) {
//					// removeSegments();
//
//					uiService.clearSelection();
//
//					final EndToEndFlow endToEndFlow = createEndToEndFlow();
//					final boolean isValid = isEndToEndFlowValid(endToEndFlow);
//
//					updateSegments(false);
//
//					final String error = getFlowErrorMessage(isValid).orElse(null);
//
//					if (error == null) {
//						setErrorMessage(null);
//						setMessage(getDialogMessage());
//					} else {
//						setErrorMessage(error + getDialogMessage());
//					}
//
//					updateWidgets(isValid);
//				}
//			});

			errorTableViewer = FlowDialogUtil.createErrorTableViewer(new Composite(area, SWT.NONE));

			return flowComposite;
		}

		protected void setReplacementSegment(final String dialogMessage,
				final Consumer<BusinessObjectContext> consumer, final BusinessObjectContext boc) {
			// getShell().setVisible(false);
			dlg.getShell().setVisible(false);
			// final int[] index = { 0 };
			System.err.println("calling?");

			// final Optional<Entry<BusinessObjectContext, SegmentData>> selectedBocToSegmentDataOpt = getSelectedSegment(
			// index, boc);
			// selectedBocToSegmentDataOpt.ifPresent(selectedBocToSegmentData -> {
			final String msg = boc
					.getBusinessObject() instanceof ModeFeature
					? " mode feature: "
							: " flow segment: ";

			selectionDlg = new SelectElementDialog(dlg
					.getShell(),
					boc
					.getBusinessObject(),
					dialogMessage + msg + getRefinedName(
							(NamedElement) boc
							.getBusinessObject()));

			int i = selectionDlg.open();

			if (i == Window.OK) {
				final Optional<BusinessObjectContext> optBoc = getReplacementBoc();
				if (optBoc.isPresent()) {
					final BusinessObjectContext selectedBoc = optBoc.get();
					if (selectedBoc.getBusinessObject() instanceof ModeFeature) {
						final SegmentData segmentData = modeFeatureSelections.get(selectedBoc);
						consumer.accept(boc);
						insert(boc, selectedBoc, segmentData, modeFeatureSelections);

					} else {
						final SegmentData segmentData = segmentSelections.get(boc);
						consumer.accept(boc);
						insert(boc, selectedBoc, segmentData, segmentSelections);

						if (selectedBoc.getBusinessObject() instanceof EndToEndFlow) {
							final BusinessObjectContext selectedCi = AgeHandlerUtil
									.getSelectedBusinessObjectContexts().get(0);
							// Find ancestors of the end to end flow container
							final Queue<Element> ancestors = FlowUtil.getAncestors(selectedCi, Optional.empty());
							// Find the diagram element of the container
							final BusinessObjectContext ancestor = FlowUtil
									.getAncestorDiagramElement(editor.getAgeDiagram(), ancestors)
									.orElseThrow(() -> new RuntimeException(
											"Cannot find container: " + selectedCi.getBusinessObject()));

							findSegments((EndToEndFlow) selectedBoc.getBusinessObject(), ancestor,
									segmentSelections.get(boc));
						}
					}

//					if (selectedBoc.getBusinessObject() instanceof NamedElement) {
//						final SegmentData segmentData = userSelections.get(boc);
//						consumer.accept(boc);
//						insert(boc, selectedBoc, segmentData, userSelections);
//
//						if (selectedBoc.getBusinessObject() instanceof EndToEndFlow) {
//							final BusinessObjectContext selectedCi = AgeHandlerUtil
//									.getSelectedBusinessObjectContexts().get(0);
//							// Find ancestors of the end to end flow container
//							final Queue<Element> ancestors = FlowUtil.getAncestors(selectedCi, Optional.empty());
//							// Find the diagram element of the container
//							final BusinessObjectContext ancestor = FlowUtil
//									.getAncestorDiagramElement(editor.getAgeDiagram(), ancestors)
//									.orElseThrow(() -> new RuntimeException(
//											"Cannot find container: " + selectedCi.getBusinessObject()));
//
//							findSegments((EndToEndFlow) selectedBoc.getBusinessObject(), ancestor,
//									userSelections.get(boc));
//						}
//					}
				}

				updateSegments(false);

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

			selectionDlg = null;
			dlg.getShell().setVisible(true);
			// });
		}

//		private Optional<Entry<BusinessObjectContext, SegmentData>> getSelectedSegment(final int[] index) {
//			for (final Entry<BusinessObjectContext, SegmentData> entry : userSelections.entrySet()) {
//				final Button btn = entry.getValue().getButton();
//				if (btn.getSelection()) {
//					return Optional.of(entry);
//				}
//				index[0]++;
//			}
//
//			return Optional.empty();
//		}

//		private void removeSegments() {
//			final Iterator<Entry<BusinessObjectContext, SegmentData>> it = userSelections.entrySet().iterator();
//			while (it.hasNext()) {
//				final Entry<BusinessObjectContext, SegmentData> entry = it.next();
//				final SegmentData segmentData = entry.getValue();
//				if (segmentData.getButton().getSelection()) {
//					if (entry.getKey() instanceof DiagramElement) {
//						coloring.setForeground((DiagramElement) entry.getKey(), null);
//					}
//
//					segmentData.segments.forEach(de -> coloring.setForeground(de, null));
//					segmentData.dispose();
//					it.remove();
//				}
//			}
//		}

		private Optional<BusinessObjectContext> getReplacementBoc() {
			if (selectionDlg.selection instanceof BusinessObjectContext) {
				return Optional.of((BusinessObjectContext) selectionDlg.selection);
			}

			if (selectionDlg.selection instanceof EndToEndFlow) {
				return Optional.of(new BusinessObjectNode(null, UUID.randomUUID(), null,
						selectionDlg.selection,
						Completeness.UNKNOWN, false));
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
			newETEFlowName.setEnabled(flowSegmentToEdit == null
					|| ((RefinableElement) flowSegmentToEdit.getFlowSegment()).getRefinedElement() == null);
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

			final Button refineBtn = new Button(buttonBar, SWT.CHECK);
			refineBtn.setText("Refine");
			refineBtn.setLayoutData(GridDataFactory.fillDefaults().indent(5, 2).align(SWT.CENTER, SWT.CENTER).create());

			if (flowSegmentToEdit != null) {
				final EndToEndFlow endToEndFlowToEdit = (EndToEndFlow) flowSegmentToEdit.getFlowSegment();
				if (endToEndFlowToEdit.getRefined() != null) {
					refineBtn.setSelection(true);
					isRefined = true;
				}
			} else {
				refineBtn.setEnabled(false);
			}

			refineBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					isRefined = refineBtn.getSelection();
					if (isRefined) {
						segmentSelections.values().forEach(SegmentData::dispose);
						modeFeatureSelections.values().forEach(SegmentData::dispose);
						segmentSelections.clear();
						modeFeatureSelections.clear();

						final BusinessObjectNode container = (BusinessObjectNode) flowSegmentToEdit.getContainer();

						// Find ancestors of the end to end flow container
						final Queue<Element> ancestors = FlowUtil.getAncestors(container, Optional.empty());
						// Find the diagram element of the container
						final BusinessObjectContext ancestor = FlowUtil
								.getAncestorDiagramElement(editor.getAgeDiagram(), ancestors)
								.orElseThrow(() -> new RuntimeException(
										"Cannot find container: " + container.getBusinessObject()));

						final EndToEndFlow eTEFlow = (EndToEndFlow) flowSegmentToEdit.getFlowSegment();
						dlg.setEndToEndFlowName(eTEFlow.getName());

						final Map<NamedElement, BusinessObjectContext> segmentToBoc = FlowUtil
								.getSegmentToBocMap(segmentNodes, ancestor);
						final ProjectReferenceService referenceService = Objects.requireNonNull(
								Adapters.adapt(editor, ProjectReferenceService.class),
								"Unable to retrieve reference service");

						// Find segments in order
						eTEFlow.getAllFlowSegments().stream()
						.map(flowSegment -> AadlHelper.getRootRefinedElement(flowSegment.getFlowElement()))
						.forEach(flowElement -> {
							final BusinessObjectContext boc = segmentToBoc.get(flowElement);
							final SegmentData sd = new SegmentData();
							segmentSelections.put(boc, sd);
							if (boc.getBusinessObject() instanceof EndToEndFlow
									&& ancestor instanceof DiagramElement) {
								findSegments((EndToEndFlow) boc.getBusinessObject(), ancestor, sd);
							}
						});

						final Map<ModeFeature, BusinessObjectContext> modeFeatures = ancestor
								.getChildren()
								.stream()
								.filter(q -> q
										.getBusinessObject() instanceof ModeFeature)
								.collect(Collectors.toMap(q -> (ModeFeature) q.getBusinessObject(),
										q -> (BusinessObjectContext) q));

						eTEFlow.getInModeOrTransitions().stream().forEach(modeFeature -> {
							BusinessObjectContext boc = modeFeatures.get(modeFeature);
							if (boc == null) {
								final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(
										modeFeature,
										referenceService);
								boc = container.getChild(childRef);
							}

							modeFeatureSelections.put(boc, new SegmentData());
						});

						updateSegments(true);
					} else {
						dlg.newETEFlowName.setEnabled(true);
						enableSegmentButtons();
					}

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

				private void enableSegmentButtons() {
					//userSelections.values().forEach(segmentData -> segmentData.getButton().setEnabled(true));
					Streams.concat(segmentSelections.values().stream(), modeFeatureSelections.values().stream())
					.forEach(sd -> sd.getButton().setEnabled(true));
				}
			});

			final boolean editing = flowSegmentToEdit != null;
			if (editing) {
				refineBtn.setSelection(((EndToEndFlow) flowSegmentToEdit.getFlowSegment()).getRefined() != null);
			}

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

		public <K extends BusinessObjectContext, V extends SegmentData> void insert(final K insertBefore,
				final K boc,
				final V segmentData, final Map<K, V> userSelections) {
			final List<Entry<K, V>> rest = new ArrayList<>();
			boolean encountered = false;
			for (final Entry<K, V> entry : userSelections.entrySet()) {
				if (encountered) {
					rest.add(entry);
				} else if (entry.getKey() == insertBefore) {
					encountered = true;
					rest.add(entry);
				}
			}

			userSelections.put(boc, segmentData);

			for (int j = 0; j < rest.size(); j++) {
				final Entry<K, V> entry = rest.get(j);
				// entry.getValue().dispose();
				userSelections.remove(entry.getKey());
				// final V v = new SegmentData();
				// final SegmentData sd = new SegmentData();
				// sd.segments.addAll(entry.getValue().segments);
				System.err.println(entry.getValue() + " getValue");
				userSelections.put(entry.getKey(), entry.getValue());
			}
		}

//		public void updateButtons() {
//
//			final long size = userSelections.values().stream().filter(sd -> sd.getButton().getSelection()).limit(2)
//					.count();
//			final boolean isSingleSelection = size == 1;
//			dlg.insertBtn.setEnabled(isSingleSelection);
//			dlg.replaceBtn.setEnabled(isSingleSelection);
//			dlg.removeBtn.setEnabled(size > 0);
//		}
	}

	private class SelectElementDialog extends TitleAreaDialog {
		private ComboViewer comboViewer;
		private Object selection;
		private final String none = "<None>";
		private final Class<?> type;
		private final String dialogMessage;
		private final boolean comboEnabled;

		public SelectElementDialog(Shell parentShell, Object type, String dialogMessage) {
			super(parentShell);
			this.dialogMessage = dialogMessage;
			if (type instanceof EndToEndFlowElement) {
				this.type = EndToEndFlowElement.class;
				comboEnabled = true;
			} else if (type instanceof ModeFeature) {
				this.type = ModeFeature.class;
				comboEnabled = false;
			} else {
				throw new RuntimeException("Unsupported type: " + type);
			}

			setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select Replacement Segment");
			setMessage(dialogMessage);
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Flow Segment Selection");
			newShell.setLocation(DialogPlacementHelper
					.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(400, 200);
			newShell.setMinimumSize(400, 200);
		}

		public void setInput(final BusinessObjectContext selection) {
			comboViewer.setInput(getInput(findComponentImplementation(selection)));
			comboViewer.setSelection(new StructuredSelection(none));
			updateDialog(selection.getBusinessObject());
			this.selection = selection;
			getShell().layout(true, true);
		}

		private void updateDialog(final Object bo) {
			final boolean isInstance = type.isInstance(bo) || bo instanceof EndToEndFlow;
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				okBtn.setEnabled(isInstance);
			}

			setMessage(dialogMessage + (isInstance ? "\nSelected: " + getRefinedName((NamedElement) bo) : ""));
		}

		private Optional<ComponentImplementation> findComponentImplementation(final Object bo) {
			if (bo instanceof BusinessObjectContext) {
				return findComponentImplementation(((BusinessObjectContext) bo).getBusinessObject());
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
			comboViewer.getCombo().setEnabled(comboEnabled);
			comboViewer.getCombo().setLayoutData(
					GridDataFactory.fillDefaults().grab(true, true).align(SWT.CENTER, SWT.CENTER).create());

			comboViewer.setContentProvider(ArrayContentProvider.getInstance());
			comboViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					if (element instanceof String) {
						return (String) element;
					}

					return getRefinedName((NamedElement) element);
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
				comboViewer.setInput(getInput(findComponentImplementation(selectedBocs.get(0))));
			}

			comboViewer.setSelection(new StructuredSelection(none));

			return composite;
		}

		private List<Object> getInput(final Optional<ComponentImplementation> optCi) {
			final List<Object> input = new ArrayList<>();
			input.add("<None>");
			final List<EndToEndFlow> eTEFlows = optCi
					.map(ci -> ci.getAllEndToEndFlows().stream().collect(Collectors.toList()))
					.orElse(new ArrayList<>());
			input.addAll(eTEFlows);
			return input;
		}
	}

//	public BusinessObjectContext getLastKey() {
//		System.err.println(userSelections.size() + " size");
//		return Iterables.getLast(userSelections.keySet().stream()
//				.filter(boc -> !(boc.getBusinessObject() instanceof ModeFeature)).collect(Collectors.toList()));
//	}

	private class SegmentData {
		final List<DiagramElement> segments = new ArrayList<>();
		private Button btn;
		private StyledText label;

		public void setLabel(final StyledText label) {
			this.label = label;
			this.label.setCaret(null);
			// this.label.setAlignment(SWT.BOTTOM);
		}

		public void setButton(final Composite parent, final String text, final boolean enabled,
				final BusinessObjectContext boc) {
			btn = createSegmentButton(parent, text, enabled, boc);
		}

		public Button getButton() {
			return btn;
		}

		protected Button createSegmentButton(final Composite parent, final String text, final boolean enabled,
				final BusinessObjectContext boc) {
			final Button btn = new Button(parent, SWT.FLAT);
			btn.setText(text);
			btn.setEnabled(enabled);
			btn.setLayoutData(new RowData());

			final Menu newMenu = new Menu(btn);
			final MenuItem newItem1 = new MenuItem(newMenu, SWT.NONE);
			newItem1.setText("Replace");
			newItem1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					System.err.println("what");
					// remove boc to replace param? justs use boc?
					dlg.setReplacementSegment("Replace", (bocToReplace) -> {
						// userSelections.remove(boc);
						if (boc.getBusinessObject() instanceof ModeFeature) {
							modeFeatureSelections.remove(boc);
						} else {
							segmentSelections.remove(boc);
						}
						if (bocToReplace instanceof DiagramElement) {
							coloring.setForeground((DiagramElement) bocToReplace, null);
						}
					}, boc);
				}
			});

			final MenuItem newItem2 = new MenuItem(newMenu, SWT.NONE);
			newItem2.setText("Insert");
			newItem2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					dlg.setReplacementSegment("Insert before", (boc) -> {
					}, boc);
				}
			});

			final MenuItem newItem3 = new MenuItem(newMenu, SWT.NONE);
			newItem3.setText("Remove");
			newItem3.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// final SegmentData sd = userSelections.get(boc);
					final SegmentData sd;
					if (boc.getBusinessObject() instanceof ModeFeature) {
						sd = modeFeatureSelections.get(boc);
						modeFeatureSelections.remove(boc);
					} else {
						sd = segmentSelections.get(boc);
						segmentSelections.remove(boc);
					}
					if (boc instanceof DiagramElement) {
						coloring.setForeground((DiagramElement) boc, null);
					}

					sd.segments.forEach(de -> coloring.setForeground(de, null));
					sd.dispose();
					// userSelections.remove(boc);

					dlg.uiService.clearSelection();

					final EndToEndFlow endToEndFlow = createEndToEndFlow();
					final boolean isValid = dlg.isEndToEndFlowValid(endToEndFlow);

					dlg.updateSegments(false);

					final String error = dlg.getFlowErrorMessage(isValid).orElse(null);

					if (error == null) {
						dlg.setErrorMessage(null);
						dlg.setMessage(getDialogMessage());
					} else {
						dlg.setErrorMessage(error + getDialogMessage());
					}

					dlg.updateWidgets(isValid);
				}
			});

			final MenuItem newItem4 = new MenuItem(newMenu, SWT.NONE);
			newItem4.setText("Insert End to End Flow");
			newItem4.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {

				}
			});

			btn.setMenu(newMenu);
			btn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final Point location = btn.getLocation();
					newMenu.setLocation(Display.getCurrent().map(dlg.flowComposite, null,
							new Point(location.x, location.y + btn.getSize().y)));
					newMenu.setVisible(true);

					// dlg.updateButtons();
				};
			});

			return btn;
		}

		public void dispose() {
			if (btn != null) {
				btn.dispose();
			}

			if (label != null) {
				label.dispose();
			}
		}
	}
}
