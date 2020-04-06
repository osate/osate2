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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.editor.FlowContributionItem.FlowSegmentState;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;

/**
 * Finds the flow segments of the flow that is currently selected in the FlowComboContributionItem
 * and adds them to the diagram if necessary.
 */
public class ShowFlowContributionItem extends ControlContribution {
	private AgeDiagramEditor editor = null;
	private Button showFlowBtn;
	private HighlightableFlowInfo selectedFlow;

	protected ShowFlowContributionItem(final String id) {
		super(id);
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	protected Control createControl(final Composite parent) {
		showFlowBtn = new Button(parent, SWT.PUSH);
		showFlowBtn.setText("Show");
		updateButton();
		showFlowBtn.addSelectionListener(new SelectionAdapter() {
			private ProjectReferenceService referenceService;

			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (editor != null && selectedFlow != null) {
					referenceService = Objects.requireNonNull(Adapters.adapt(editor, ProjectReferenceService.class),
							"Unable to retrieve reference service");
					final AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
							.getFeatureProvider();
					final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
					final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();
					final BusinessObjectNode boTree = getBoTree(boTreeExpander);
					final BusinessObjectNode containerNode = boTree.getAllDescendants().filter(
							q -> q.getBusinessObject() == selectedFlow.getContainer().getBusinessObject())
							.findAny().map(BusinessObjectNode.class::cast)
							.orElseThrow(() -> new RuntimeException(
									"Cannot find container for highlightable flow: "
											+ selectedFlow.getFlowSegment()));
					final Object component = getContainerComponent(selectedFlow.getContainer().getBusinessObject());
					ensureFlowSegmentsExist(component, selectedFlow.getFlowSegment(), containerNode);

					final AgeDiagram diagram = editor.getAgeDiagram();
					final ActionService actionService = Objects.requireNonNull(
							Adapters.adapt(editor, ActionService.class), "Unable to retrieve action service");
					final GraphitiService graphitiService = Objects.requireNonNull(
							Adapters.adapt(editor, GraphitiService.class), "Unable to retrieve graphiti service");
					actionService.execute("Show Flow Elements", ExecutionMode.NORMAL, () -> {
						// Update the diagram
						diagramUpdater.updateDiagram(diagram, boTree);

						// Update layout
						diagram.modify("Layout Incrementally",
								m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, graphitiService));

						return null;
					});
				}
			}

			private List<FlowSegmentReference> findFlowSegments(final FlowSegmentReference flowElementRef) {
				if (flowElementRef.flowSegmentElement instanceof FlowSpecification) {
					// Check if flow specification has flow implementation(s)
					return AadlClassifierUtil.getComponentImplementation(flowElementRef.container.getBusinessObject())
							.map(ci -> ci.getAllFlowImplementations().stream()
									.filter(cfi -> flowElementRef.flowSegmentElement == cfi.getSpecification())
									.flatMap(cfi -> cfi.getOwnedFlowSegments().stream())
									.map(flowSegment -> createFlowSegmentReference(flowSegment,
											(BusinessObjectNode) flowElementRef.container)))
							.orElse(Stream.empty()).collect(Collectors.toList());
				} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlow) {
					return AadlClassifierUtil.getComponentImplementation(flowElementRef.container.getBusinessObject())
							.map(ci -> ci.getAllEndToEndFlows().stream()
									.filter(ete -> ete == flowElementRef.flowSegmentElement)
									.flatMap(ete -> ete.getAllFlowSegments().stream())
									.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
											(BusinessObjectNode) flowElementRef.container)))
							.orElse(Stream.empty()).collect(Collectors.toList());
				} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlowInstance) {
					return AadlInstanceObjectUtil.getComponentInstance(flowElementRef.container.getBusinessObject())
							.map(ci -> ci.getEndToEndFlows().stream()
									.filter(ete -> ete == flowElementRef.flowSegmentElement).flatMap(ete -> {
										return ete.getFlowElements().stream().flatMap(fei -> {
											if (fei instanceof ConnectionInstance) {
												return ((ConnectionInstance) fei).getConnectionReferences().stream()
														.map(cr -> createFlowSegmentReference(cr,
																(BusinessObjectNode) flowElementRef.container));
											} else {
												return Stream.of(createFlowSegmentReference(fei,
														(BusinessObjectNode) flowElementRef.container));
											}
										});
									}))
							.orElse(Stream.empty()).collect(Collectors.toList());
				} else {
					return Collections.emptyList();
				}
			}

			private void ensureFlowSegmentsExist(final Object component, final NamedElement flow,
					final BusinessObjectNode containerNode) {
				if (component instanceof ComponentImplementation) {
					final ComponentImplementation ci = (ComponentImplementation) component;
					if (flow instanceof FlowSpecification) {
						ci.getAllFlowImplementations().stream()
						.filter(fi -> flow.getName().equalsIgnoreCase(fi.getSpecification().getName()))
						.findAny().ifPresent(flowImpl -> {
							final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(
									flowImpl.getSpecification(), containerNode);
							enableFlowSegments(findFlowSegments(flowSegmentRef));
						});
					} else {
						final String eteName = flow.getName();
						final Optional<EndToEndFlow> eteFlow = ci.getAllEndToEndFlows().stream()
								.filter(etef -> eteName.equalsIgnoreCase(etef.getName())).findAny();
						eteFlow.ifPresent(endToEndFlow -> {
							final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(endToEndFlow,
									containerNode);
							enableFlowSegments(findFlowSegments(flowSegmentRef));
						});
					}
				} else if (component instanceof ComponentInstance) {
					// ETE Flows only
					final EndToEndFlowInstance eteFlowInstance = (EndToEndFlowInstance) flow;
					final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(eteFlowInstance,
							containerNode);
					enableFlowSegments(findFlowSegments(flowSegmentRef));
				}
			}

			private void enableFlowSegments(final List<FlowSegmentReference> highlightableFlowElements) {
				highlightableFlowElements.forEach(fs -> enableFlowSegments(findFlowSegments(fs)));
			}

			private Object getContainerComponent(final Object container) {
				if (container instanceof Subcomponent) {
					final Subcomponent sc = (Subcomponent) container;
					return sc.getComponentImplementation();
				}

				return container;
			}

			private BusinessObjectNode getBoTree(final TreeUpdater boTreeExpander) {
				BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter
						.createBusinessObjectNode(editor.getAgeDiagram());
				return boTreeExpander.expandTree(editor.getAgeDiagram().getConfiguration(), boTree);
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
								.filter(child -> child.getBusinessObject() == flowSegment.getContext()).findAny()
								.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
								.orElse(null);
					}
				} else if (bo instanceof EndToEndFlowSegment) {
					final EndToEndFlowSegment flowSegment = (EndToEndFlowSegment) bo;
					final FlowElement flowElement = (FlowElement) flowSegment.getFlowElement();
					if (flowSegment.getContext() == null) {
						return createFlowSegmentReference(flowElement, container);
					} else {
						ensureEnabledChild(flowSegment.getContext(), container);
						return container.getChildren().stream()
								.filter(child -> child.getBusinessObject() == flowSegment.getContext()).findAny()
								.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
								.orElse(null);
					}
				} else if (bo instanceof InstanceObject) {
					final InstanceObject io = (InstanceObject) bo;
					if (bo instanceof EndToEndFlowInstance) {
						return new FlowSegmentReference(io, container);
					} else {
						final Map<Object, Queryable> descendantBoToQueryable = container.getAllDescendants()
								.collect(Collectors.toMap(Queryable::getBusinessObject, Function.identity()));
						if (bo instanceof FlowSpecificationInstance) {
							final FlowSpecificationInstance fsi = (FlowSpecificationInstance) bo;
							enableFlowSpecificationInstanceNodes(descendantBoToQueryable, fsi);
						}

						if (bo instanceof ConnectionReference) {
							final ConnectionReference cr = (ConnectionReference) bo;
							enableConnectionReferenceNodes(descendantBoToQueryable, cr);
						}

						return new FlowSegmentReference(io, container);
					}
				} else if (bo instanceof NamedElement) {
					final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(bo);
					if (ref != null) {
						ensureEnabledChild(bo, container);
					}

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
						final RelativeBusinessObjectReference dstEndRef = getRelativeBusinessObjectReference(dstEnd);
						// Destination context
						BusinessObjectNode ctxContainer = getContextContainer(dstContext, container);
						if (ctxContainer.getChild(dstEndRef) == null) {
							createNode(ctxContainer, dstEndRef, dstEnd);
						}

						final ConnectionEnd srcEnd = connection.getAllSource();
						final Context srcContext = connection.getAllSourceContext();
						// Source context
						ctxContainer = getContextContainer(srcContext, container);
						final RelativeBusinessObjectReference srcEndRef = getRelativeBusinessObjectReference(srcEnd);
						if (ctxContainer.getChild(srcEndRef) == null) {
							createNode(ctxContainer, srcEndRef, srcEnd);
						}
					}

					return new FlowSegmentReference((NamedElement) bo, container);
				} else {
					throw new RuntimeException("Unexpected business object: " + bo);
				}
			}

			private BusinessObjectNode getContextContainer(final Context context,
					final BusinessObjectNode contextContainer) {
				if (context != null) {
					// Ensure context container is created
					final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(context);
					if (contextContainer.getChild(contextRef) == null) {
						// Show context
						createNode(contextContainer, contextRef, context);
					}

					return contextContainer.getChild(contextRef);
				}

				return contextContainer;
			}

			private void enableFlowEnd(final FlowEnd flowEnd, final BusinessObjectNode containerNode) {
				final Feature feature = (Feature) flowEnd.getFeature();
				final RelativeBusinessObjectReference featureRef = getRelativeBusinessObjectReference(feature);
				if (flowEnd.getContext() != null) {
					final Context context = flowEnd.getContext();
					final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(context);
					if (containerNode.getChild(contextRef) == null) {
						createNode(containerNode, contextRef, context);
					}

					final BusinessObjectNode contextNode = containerNode
							.getChild(getRelativeBusinessObjectReference(flowEnd.getContext()));
					if (contextNode.getChild(featureRef) == null) {
						createNode(contextNode, featureRef, feature);
					}
				} else if (containerNode.getChild(featureRef) == null) {
					createNode(containerNode, featureRef, feature);
				}
			}

			private void enableFlowSpecificationInstanceNodes(final Map<Object, Queryable> descendantBoToQueryable,
					final FlowSpecificationInstance fsi) {
				enableAncestorNodes(descendantBoToQueryable, fsi);
				if (fsi.getDestination() != null) {
					enableAncestorNodes(descendantBoToQueryable, fsi.getDestination());
				}

				if (fsi.getSource() != null) {
					enableAncestorNodes(descendantBoToQueryable, fsi.getSource());
				}
			}

			private void enableConnectionReferenceNodes(final Map<Object, Queryable> descendantBoToQueryable,
					final ConnectionReference cr) {
				Element tmpElement = cr;
				// Ancestors to ensure are enabled on the diagram
				final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<Element>());
				if (!descendantBoToQueryable.containsKey(tmpElement)) {
					ancestors.add(tmpElement);
					tmpElement = tmpElement.getOwner();
					// First owner of connection reference is connection instance
					if (tmpElement instanceof ConnectionInstance) {
						tmpElement = tmpElement.getOwner();
					}
				}

				// Connection reference
				populateAncestorsQueue(descendantBoToQueryable, ancestors, tmpElement);
				enableAncestorNodes(descendantBoToQueryable, ancestors, ancestors.poll());

				// Enable source and destination nodes
				enableAncestorNodes(descendantBoToQueryable, cr.getSource());
				enableAncestorNodes(descendantBoToQueryable, cr.getDestination());
			}

			// Gets the first element ancestor that is enabled
			private void populateAncestorsQueue(final Map<Object, Queryable> descendantBoToQueryable,
					final Queue<Element> ancestors,
					Element ancestor) {
				while (!descendantBoToQueryable.containsKey(ancestor)) {
					ancestors.add(ancestor);
					ancestor = ancestor.getOwner();
				}

				ancestors.add(ancestor);
			}

			// Find ancestors and create if necessary
			private void enableAncestorNodes(final Map<Object, Queryable> descendantBoToQueryable,
					final Element ancestor) {
				final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<Element>());
				populateAncestorsQueue(descendantBoToQueryable, ancestors, ancestor);
				enableAncestorNodes(descendantBoToQueryable, ancestors, ancestors.poll());
			}

			// Create ancestor nodes
			private void enableAncestorNodes(final Map<Object, Queryable> descendantBoToQueryable,
					final Queue<Element> ancestors, final Element ancestor) {
				BusinessObjectNode ancestorNode = (BusinessObjectNode) descendantBoToQueryable.get(ancestor);
				for (final Element ancestorToEnable : ancestors) {
					final RelativeBusinessObjectReference ancestorRef = getRelativeBusinessObjectReference(ancestorToEnable);
					if (ancestorNode.getChild(ancestorRef) == null) {
						ancestorNode = createNode(ancestorNode, ancestorRef, ancestorToEnable);
					}
				}
			}

			private void ensureEnabledChild(final Object childBo, final BusinessObjectNode parent) {
				final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(childBo);
				final BusinessObjectNode childNode = parent.getChild(childRef);
				if (childNode == null) {
					createNode(parent, childRef, childBo);
				}
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
		});

		return showFlowBtn;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
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
	 * Updates the enabled state of the show flow button determined by the state of the selected flow
	 */
	public void updateShowFlowItem(final HighlightableFlowInfo selectedFlow) {
		this.selectedFlow = selectedFlow;
		updateButton();
	}

	private void updateButton() {
		if (showFlowBtn != null && !showFlowBtn.isDisposed()) {
			showFlowBtn.setEnabled(selectedFlow == null ? false : selectedFlow.getState() != FlowSegmentState.COMPLETE);
		}
	}
}
