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

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RefinableElement;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.FlowContributionItem.FlowSegmentState;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.ui.editor.FlowContributionItemUtil.FlowImplementationSelectionDialog;
import org.osate.ge.internal.ui.tools.CreateEndToEndFlowSpecificationTool;
import org.osate.ge.internal.ui.tools.CreateFlowImplementationTool;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ProxyUtil;

import com.google.common.base.Predicates;

public class EditFlowContributionItem extends ControlContribution {
	private final static ImageDescriptor editIcon = Activator.getImageDescriptor("icons/flow_edit.png");
	private final Set<BusinessObjectNode> segmentNodes = new HashSet<>();
	private AgeDiagramEditor editor = null;
	private Button editFlowBtn;
	private HighlightableFlowInfo selectedHighlightableFlow;

	protected EditFlowContributionItem(final String id) {
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
			private ProjectReferenceService referenceService;

			@Override
			public void widgetSelected(final SelectionEvent e) {
				segmentNodes.clear();
				referenceService = Objects.requireNonNull(Adapters.adapt(editor, ProjectReferenceService.class),
						"Unable to retrieve reference service");
				final AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
						.getFeatureProvider();
				// Populate flow segment and in mode feature nodes.
				// Needed so segments that do not exist on the diagram are editable
				// when the tool is activated.
				final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();
				final BusinessObjectNode boTree = getBoTree(boTreeExpander);
				final NamedElement flowSegment = AadlHelper
						.getRootRefinedElement(selectedHighlightableFlow.getFlowSegment());
				final Queryable container = selectedHighlightableFlow.getContainer();
				final FlowSegmentState flowState = selectedHighlightableFlow.getState();
				final Element containerBo = (Element) container.getBusinessObject();
				final BusinessObjectNode containerNode = boTree.getAllDescendants()
						.filter(descendant -> descendant
								.getBusinessObject() == containerBo)
						.findAny()
						.map(BusinessObjectNode.class::cast)
						.orElseThrow(() -> new RuntimeException("Cannot find container for highlightable flow: "
								+ flowSegment.getName()));
				final ComponentImplementation ci = FlowContributionItemUtil.getComponentImplementation(containerBo);
				editor.getAgeDiagram().getDiagramElements().stream().findAny().ifPresent(de -> {
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
						// Create end to end flow segments and mode features if necessary
						ensureEndToEndFlowSegmentsExist(endToEndFlow, containerNode);
						ensureInModeOrTransitionsExist(endToEndFlow, containerNode);

						// Activate tool
						uiService.activateTool(
								new CreateEndToEndFlowSpecificationTool(editor,
										new HighlightableFlowInfo(
												new FlowSegmentReference(
														endToEndFlow,
														containerNode),
												flowState),
										segmentNodes));
					} else if (flowSegment instanceof FlowSpecification) {
						final FlowSpecification fs = ProxyUtil.resolveOrNull(
								flowSegment,
								FlowSpecification.class, ci.eResource().getResourceSet());
						getFlowImplementation(ci, fs).ifPresent(fi -> {
							// Create end to end flow segments and mode features if necessary
							ensureFlowImplSegmentsExist(fi, containerNode);
							ensureInModeOrTransitionsExist(fi, containerNode);

							// Activate tool
							uiService.activateTool(new CreateFlowImplementationTool(editor, new HighlightableFlowInfo(
									new FlowSegmentReference(fi, containerNode), flowState), segmentNodes));
						});
					} else {
						throw new RuntimeException("Unsupported flow type.");
					}
				});
			}


			private void ensureFlowImplSegmentsExist(final FlowImplementation fi,
					final BusinessObjectNode containerNode) {
				final BusinessObjectNode flowSpecNode = ensureChildNodeExists(containerNode, fi.getSpecification());
				segmentNodes.add(flowSpecNode);

				if (fi.getInEnd() != null) {
					final FlowEnd inEnd = fi.getInEnd();
					BusinessObjectNode contextNode = containerNode;
					if (inEnd.getContext() != null) {
						contextNode = ensureChildNodeExists(contextNode, inEnd.getContext());
					}

					final BusinessObjectNode inEndFeature = ensureChildNodeExists(contextNode, inEnd.getFeature());
					segmentNodes.add(inEndFeature);
				}

				if (fi.getOutEnd() != null) {
					final FlowEnd outEnd = fi.getOutEnd();
					BusinessObjectNode contextNode = containerNode;
					if (outEnd.getContext() != null) {
						contextNode = ensureChildNodeExists(contextNode, outEnd.getContext());
					}

					final BusinessObjectNode outEndFeature = ensureChildNodeExists(contextNode, outEnd.getFeature());
					segmentNodes.add(outEndFeature);
				}

				enableFlowSegments(fi.getOwnedFlowSegments().stream()
						.map(segment -> createFlowSegmentReference(segment, containerNode))
						.collect(Collectors.toList()));
			}

			private void ensureInModeOrTransitionsExist(final ModalPath modalPath,
					final BusinessObjectNode containerNode) {
				modalPath.getInModeOrTransitions().forEach(modeFeature -> {
					segmentNodes.add(ensureChildNodeExists(containerNode, modeFeature));
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

			private void ensureEndToEndFlowSegmentsExist(
					final NamedElement flow,
					final BusinessObjectNode containerNode) {
				final EndToEndFlow eteFlow = (EndToEndFlow) flow;
				final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(
						eteFlow,
						containerNode);
				enableFlowSegments(findFlowSegments(flowSegmentRef));
			}

			private List<FlowSegmentReference> findFlowSegments(final FlowSegmentReference flowElementRef) {
				final Queryable container = flowElementRef.container;
				return AadlClassifierUtil.getComponentImplementation(container
						.getBusinessObject())
						.map(ci -> ci.getAllEndToEndFlows().stream()
								.filter(ete -> ete == flowElementRef.flowSegmentElement)
								.flatMap(ete -> ete.getAllFlowSegments().stream())
								.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
										(BusinessObjectNode) container)))
						.orElse(Stream.empty()).collect(Collectors.toList());
			}

			private void enableFlowSegments(final List<FlowSegmentReference> highlightableFlowElements) {
				highlightableFlowElements.stream().filter(Predicates.notNull())
				.forEach(fs -> enableFlowSegments(findFlowSegments(fs)));
			}

			private Optional<BusinessObjectNode> ensureEnabledChild(final Object childBo,
					final BusinessObjectNode parent) {
				if (childBo != null) {
					final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(childBo);
					if (childRef != null) {
						final BusinessObjectNode childNode = parent.getChild(childRef);
						return Optional.of(childNode == null ? createNode(parent, childRef, childBo) : childNode);
					}
				}

				return Optional.empty();
			}

			private BusinessObjectNode createNode(final BusinessObjectNode parent,
					final RelativeBusinessObjectReference childRef, final Object childBo) {
				return new BusinessObjectNode(parent, UUID.randomUUID(), childRef, childBo, Completeness.UNKNOWN,
						false);
			}

			private RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
				final RelativeBusinessObjectReference result = referenceService.getRelativeReference(bo);
				return result;
			}

			private FlowSegmentReference createFlowSegmentReference(final Object bo,
					final BusinessObjectNode container) {
				if (bo instanceof FlowSegment) {
					final FlowSegment flowSegment = (FlowSegment) bo;
					final FlowElement flowElement = flowSegment.getFlowElement();
					if (flowSegment.getContext() == null) {
						return createFlowSegmentReference(flowElement, container);
					} else {
						ensureEnabledChild(flowSegment.getContext(), container);
						return container.getChildren().stream()
								.filter(child -> {
									if (child.getBusinessObject() instanceof NamedElement) {
										final NamedElement ne = (NamedElement) child.getBusinessObject();
										return AadlHelper.getRootRefinedElement(ne) == AadlHelper
												.getRootRefinedElement(flowSegment.getContext());
									}
									return false;
								}).findAny()
								.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
								.orElse(null);
					}
				} else if (bo instanceof EndToEndFlowSegment) {
					final EndToEndFlowSegment flowSegment = (EndToEndFlowSegment) bo;
					if (flowSegment.getFlowElement() instanceof FlowElement) {
						final FlowElement flowElement = (FlowElement) flowSegment.getFlowElement();
						if (flowSegment.getContext() == null) {
							return createFlowSegmentReference(flowElement, container);
						} else {
							ensureEnabledChild(flowSegment.getContext(), container);
							return container.getChildren().stream()
									.filter(child -> {
										if (child.getBusinessObject() instanceof NamedElement) {
											final NamedElement ne = (NamedElement) child.getBusinessObject();
											return AadlHelper.getRootRefinedElement(ne) == AadlHelper
													.getRootRefinedElement(flowSegment.getContext());
										}
										return false;
									}).findAny()
									.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
									.orElse(null);
						}
					} else {
						final BusinessObjectNode context = ensureEnabledChild(flowSegment.getContext(), container)
								.orElse(container);
						segmentNodes.add(createNode(context,
								new RelativeBusinessObjectReference(getRefinedName(flowSegment
										.getFlowElement())),
								flowSegment.getFlowElement()));
						return null;
					}
				} else if (bo instanceof NamedElement) {
					ensureEnabledChild(bo, container).ifPresent(segmentNodes::add);

					if (bo instanceof FlowSpecification) {
						final FlowSpecification fs = (FlowSpecification) bo;
						if (fs.getAllInEnd() != null) {
							enableFlowEnd(fs.getAllInEnd(), container);
						}

						if (fs.getAllOutEnd() != null) {
							enableFlowEnd(fs.getAllOutEnd(), container);
						}
					} else if (bo instanceof Connection) {
						final Connection connection = (Connection) bo;
						final ConnectionEnd dstEnd = connection.getAllDestination();
						final Context dstContext = connection.getAllDestinationContext();
						// Destination context
						BusinessObjectNode ctxContainer = getContextContainer(dstContext, container);
						ensureChildNodeExists(ctxContainer, dstEnd);

						final ConnectionEnd srcEnd = connection.getAllSource();
						final Context srcContext = connection.getAllSourceContext();
						// Source context
						ctxContainer = getContextContainer(srcContext, container);
						ensureChildNodeExists(ctxContainer, srcEnd);
					}

					return new FlowSegmentReference((NamedElement) bo, container);
				} else {
					throw new RuntimeException("Unexpected business object: " + bo);
				}
			}

			private String getRefinedName(final NamedElement ne) {
				return AadlHelper.getRootRefinedElement(ne).getName();
			}

			private void enableFlowEnd(final FlowEnd flowEnd, final BusinessObjectNode containerNode) {
				final Feature feature = (Feature) flowEnd.getFeature();
				final RelativeBusinessObjectReference featureRef = getRelativeBusinessObjectReference(feature);
				if (flowEnd.getContext() != null) {
					final Context context = flowEnd.getContext();
					ensureChildNodeExists(containerNode, context);
					final BusinessObjectNode contextNode = containerNode
							.getChild(getRelativeBusinessObjectReference(flowEnd.getContext()));
					ensureChildNodeExists(contextNode, featureRef, feature);
				} else if (containerNode.getChild(featureRef) == null) {
					ensureChildNodeExists(containerNode, featureRef, feature);
				}
			}

			private BusinessObjectNode getContextContainer(final Context context,
					final BusinessObjectNode contextContainer) {
				if (context != null) {
					// Ensure context container is created
					return ensureChildNodeExists(contextContainer, context);
				}

				return contextContainer;
			}

			private BusinessObjectNode ensureChildNodeExists(final BusinessObjectNode parent, final Object child) {
				final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(child);
				return ensureChildNodeExists(parent, childRef, child);
			}

			private BusinessObjectNode ensureChildNodeExists(final BusinessObjectNode parent,
					final RelativeBusinessObjectReference childRef, final Object child) {
				final BusinessObjectNode node = parent.getChild(childRef);
				return node == null ? createNode(parent, childRef, child) : node;
			}
		});

		return editFlowBtn;
	}


	private BusinessObjectNode getBoTree(final TreeUpdater boTreeExpander) {
		BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter
				.createBusinessObjectNode(editor.getAgeDiagram());
		return boTreeExpander.expandTree(editor.getAgeDiagram().getConfiguration(), boTree);
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
