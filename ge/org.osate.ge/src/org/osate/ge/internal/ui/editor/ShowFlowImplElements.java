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

import java.util.ArrayList;
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
import org.osate.aadl2.FeatureGroup;
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
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
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
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.dialogs.DiagramConfigurationDialog;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;

public class ShowFlowImplElements extends ControlContribution {
	private AgeDiagramEditor editor = null;
	private ProjectReferenceService referenceService;
	private List<BusinessObjectNode> enabledNodes = new ArrayList<>();
	private FlowContributionItem selectedFlowContributionItem;

	protected ShowFlowImplElements(String id, FlowContributionItem selectedFlowContributionItem) {
		super(id);
		this.selectedFlowContributionItem = selectedFlowContributionItem;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	protected Control createControl(final Composite parent) {
		final Button btn = new Button(parent, SWT.PUSH);
		btn.setText("Show");
		btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (editor != null) {
					final GraphitiService graphitiService = Objects.requireNonNull(
							Adapters.adapt(editor, GraphitiService.class), "Unable to retrieve graphiti service");
					referenceService = Objects.requireNonNull(Adapters.adapt(editor, ProjectReferenceService.class),
							"Unable to retrieve reference service");
					final AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
							.getFeatureProvider();
					final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
					final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();

					final BusinessObjectNode boTree = getBoTree(boTreeExpander);
					boTree.getAllDescendants().forEachOrdered(q -> enabledNodes.add((BusinessObjectNode) q));
					final Object firstSelection = selectedFlowContributionItem.getComboViewer().getStructuredSelection()
							.getFirstElement();

					@SuppressWarnings("unchecked")
					final Map.Entry<String, HighlightableFlowInfo> entry = (Map.Entry<String, HighlightableFlowInfo>) firstSelection;
					final HighlightableFlowInfo highlightableFlowInfo = entry.getValue();

					final BusinessObjectNode containerNode = boTree.getAllDescendants().filter(
							q -> q.getBusinessObject() == highlightableFlowInfo.getContainer().getBusinessObject())
							.findAny().map(BusinessObjectNode.class::cast)
							.orElseThrow(() -> new RuntimeException(
									"Cannot find container for highlightable flow: " + entry.getKey()));
					final Object component = getContainerComponent(highlightableFlowInfo.getContainer().getBusinessObject());
					final NamedElement flow = highlightableFlowInfo.getFlowSegment();
					if (component instanceof ComponentImplementation) {
						final ComponentImplementation ci = (ComponentImplementation) component;
						if (flow instanceof FlowSpecification) {
							ci.getAllFlowImplementations().stream()
							.filter(fi -> flow.getName().equalsIgnoreCase(fi.getSpecification().getName()))
							.findAny().ifPresent(flowImpl -> {
								final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(
										flowImpl.getSpecification(), containerNode);
								populateFlowSegments(findFlowSegments(flowSegmentRef));
							});
						} else {
							final String eteName = flow.getName();
							final Optional<EndToEndFlow> eteFlow = ci.getAllEndToEndFlows().stream()
									.filter(etef -> eteName.equalsIgnoreCase(etef.getName())).findAny();
							eteFlow.ifPresent(endToEndFlow -> {
								final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(endToEndFlow,
										containerNode);
								populateFlowSegments(findFlowSegments(flowSegmentRef));
							});
						}
					} else if (component instanceof ComponentInstance) {
						// ETE Flows only
						final EndToEndFlowInstance eteFlowInstance = (EndToEndFlowInstance) flow;
						final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(eteFlowInstance,
								containerNode);
						populateFlowSegments(findFlowSegments(flowSegmentRef));
					}

					final AgeDiagram diagram = editor.getAgeDiagram();
					final List<BusinessObjectNode> nodesToRemove = new ArrayList<>();
					determineNodesToRemove(boTree, nodesToRemove);
					nodesToRemove.forEach(BusinessObjectNode::remove);

					final DiagramConfigurationBuilder diagramConfigBuilder = new DiagramConfigurationBuilder(
							Objects.requireNonNull(editor.getAgeDiagram().getConfiguration(),
									"diagramConfig must not be null"));
					// TODO move results class out of dialog?
					DiagramConfigurationDialog.Result result = new DiagramConfigurationDialog.Result(
							diagramConfigBuilder.build(), boTree);
					if (result != null) {
						diagram.modify("Set Diagram Configuration", m -> {
							m.setDiagramConfiguration(result.getDiagramConfiguration());
							diagramUpdater.updateDiagram(diagram, result.getBusinessObjectTree());
						});
						// Clear ghosts triggered by this update to prevent them from being unghosted during the next update.
						diagramUpdater.clearGhosts();

						diagram.modify("Layout",
								m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, graphitiService));
					}
				}
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
		});

		return btn;
	}

	private void enableFlowEnd(FlowEnd flowEnd, final BusinessObjectNode containerNode) {
		// Enable parent if necessary
		if (flowEnd.getContext() != null) {
			if (containerNode.getChild(getRelativeBusinessObjectReference(flowEnd.getContext())) == null) {
				enabledNodes.add(new BusinessObjectNode(containerNode, UUID.randomUUID(),
						getRelativeBusinessObjectReference(flowEnd.getContext()), flowEnd.getContext(),
						Completeness.UNKNOWN, false));
			}
		}

		if (flowEnd.getFeature() instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup) flowEnd.getFeature();
			if (flowEnd.getContext() != null) {
				final BusinessObjectNode contextNode = containerNode
						.getChild(getRelativeBusinessObjectReference(flowEnd.getContext()));
				if (contextNode.getChild(getRelativeBusinessObjectReference(fg)) == null) {
					enabledNodes.add(new BusinessObjectNode(contextNode, UUID.randomUUID(),
							getRelativeBusinessObjectReference(fg), fg, Completeness.UNKNOWN, false));
				}
			} else if (containerNode.getChild(getRelativeBusinessObjectReference(fg)) == null) {
				enabledNodes.add(new BusinessObjectNode(containerNode, UUID.randomUUID(),
						getRelativeBusinessObjectReference(fg), fg, Completeness.UNKNOWN, false));
			}
		} else {
			final Feature feature = (Feature) flowEnd.getFeature();
			if (flowEnd.getContext() != null) {
				final BusinessObjectNode contextNode = containerNode
						.getChild(getRelativeBusinessObjectReference(flowEnd.getContext()));
				if (contextNode.getChild(getRelativeBusinessObjectReference(feature)) == null) {
					enabledNodes.add(new BusinessObjectNode(contextNode, UUID.randomUUID(),
							getRelativeBusinessObjectReference(feature), feature, Completeness.UNKNOWN, false));
				}
			} else if (containerNode.getChild(getRelativeBusinessObjectReference(feature)) == null) {
				enabledNodes.add(new BusinessObjectNode(containerNode, UUID.randomUUID(),
						getRelativeBusinessObjectReference(feature), feature, Completeness.UNKNOWN, false));
			}
		}
	}

	public List<FlowSegmentReference> findFlowSegments(final FlowSegmentReference flowElementRef) {
		if (flowElementRef.flowSegmentElement instanceof FlowSpecification) {
			// Check if flow specification has flow implementation(s)
			return AadlClassifierUtil
					.getComponentImplementation(
							flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllFlowImplementations().stream()
							.filter(cfi -> flowElementRef.flowSegmentElement == cfi.getSpecification())
							.flatMap(cfi -> cfi.getOwnedFlowSegments().stream())
							.map(flowSegment -> createFlowSegmentReference(flowSegment,
									(BusinessObjectNode) flowElementRef.container)))
					.orElse(Stream.empty()).collect(Collectors.toList());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlow) {
			return AadlClassifierUtil
					.getComponentImplementation(
							flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> ete.getAllFlowSegments().stream())
							.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
									(BusinessObjectNode) flowElementRef.container)))
					.orElse(Stream.empty()).collect(Collectors.toList());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlowInstance) {
			return AadlInstanceObjectUtil.getComponentInstance(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> {
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

	public FlowSegmentReference createFlowSegmentReference(final Object bo, BusinessObjectNode container) {
		if (bo instanceof FlowSegment) {
			final FlowSegment flowSegment = (FlowSegment) bo;
			final FlowElement flowElement = flowSegment.getFlowElement();
			if (flowSegment.getContext() == null) {
				return createFlowSegmentReference(flowElement, container);
			} else {
				ensurePopulatedChild(flowSegment.getContext(), container);
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
				ensurePopulatedChild(flowSegment.getContext(), container);
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
				final Map<Object, Queryable> allDescendants = container.getAllDescendants()
						.collect(Collectors.toMap(Queryable::getBusinessObject, Function.identity()));
				if (bo instanceof FlowSpecificationInstance) {
					final FlowSpecificationInstance fsi = (FlowSpecificationInstance) bo;
					populateFlowSpecificationInstanceNodes(allDescendants, fsi);
				}

				if (bo instanceof ConnectionReference) {
					final ConnectionReference cr = (ConnectionReference) bo;
					populateConnectionReferenceNodes(allDescendants, cr);
				}

				return new FlowSegmentReference(io, container);
			}
		} else if (bo instanceof NamedElement) {
			final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(bo);
			if (ref != null) {
				ensurePopulatedChild(bo, container);
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
				final RelativeBusinessObjectReference dstEndRef = getRelativeBusinessObjectReference(
						dstEnd);
				BusinessObjectNode ctxContainer = showContext(dstContext, container);
				if (ctxContainer.getChild(dstEndRef) == null) {
					enabledNodes.add(new BusinessObjectNode(ctxContainer, UUID.randomUUID(),
							dstEndRef, dstEnd, Completeness.UNKNOWN, false));
				}

				final ConnectionEnd srcEnd = connection.getAllSource();
				final Context srcContext = connection.getAllSourceContext();
				ctxContainer = showContext(srcContext, container);
				final RelativeBusinessObjectReference srcEndRef = getRelativeBusinessObjectReference(
						srcEnd);
				if (ctxContainer.getChild(srcEndRef) == null) {
					enabledNodes.add(new BusinessObjectNode(ctxContainer, UUID.randomUUID(),
							srcEndRef, srcEnd, Completeness.UNKNOWN, false));
				}
			}

			return new FlowSegmentReference((NamedElement) bo, container);
		} else {
			throw new RuntimeException("Unexpected business object: " + bo);
		}
	}

	private void populateFlowSpecificationInstanceNodes(final Map<Object, Queryable> allDescendants,
			final FlowSpecificationInstance fsi) {
		populateNodes(allDescendants, fsi);
		if (fsi.getDestination() != null) {
			populateNodes(allDescendants, fsi.getDestination());
		}

		if (fsi.getSource() != null) {
			populateNodes(allDescendants, fsi.getSource());
		}
	}

	private void populateConnectionReferenceNodes(final Map<Object, Queryable> descendants,
			final ConnectionReference cr) {
		Element tmpElement = cr;
		final Queue<Element> queue = Collections.asLifoQueue(new LinkedList<Element>());
		if (!descendants.containsKey(cr)) {
			queue.add(cr);
			// First owner of connection reference is connection instance
			tmpElement = tmpElement.getOwner().getOwner();
		}

		// Connection reference
		tmpElement = getFirstElementAncestor(descendants, queue, tmpElement);
		populateNodes(descendants, queue, tmpElement);

		// Populate source and destination nodes
		populateNodes(descendants, cr.getSource());
		populateNodes(descendants, cr.getDestination());
	}

	// Gets the first element ancestor that is populated
	private Element getFirstElementAncestor(final Map<Object, Queryable> descendants, final Queue<Element> queue,
			Element element) {
		while (!descendants.containsKey(element)) {
			queue.add(element);
			element = element.getOwner();
		}

		return element;
	}

	private void populateNodes(final Map<Object, Queryable> descendants, Element element) {
		final Queue<Element> queue = Collections.asLifoQueue(new LinkedList<Element>());
		element = getFirstElementAncestor(descendants, queue, element);
		populateNodes(descendants, queue, element);
	}

	private void populateNodes(final Map<Object, Queryable> descendants, final Queue<Element> queue,
			final Element element) {
		BusinessObjectNode node = (BusinessObjectNode) descendants.get(element);
		for (final Element enableElement : queue) {
			final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(enableElement);
			if (node.getChild(ref) == null) {
				node = new BusinessObjectNode(node, UUID.randomUUID(), ref,
						enableElement, Completeness.UNKNOWN, false);
				enabledNodes.add(node);
			}
		}
	}

	private void ensurePopulatedChild(Object bo, final BusinessObjectNode container) {
		final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(bo);
		final BusinessObjectNode segmentContextNode = container.getChild(ref);
		if (segmentContextNode == null) {
			enableNode(container, UUID.randomUUID(), ref, bo);
		}
	}

	private void enableNode(final BusinessObjectNode container, final UUID randomUUID,
			final RelativeBusinessObjectReference ref, final Object bo) {
		enabledNodes.add(new BusinessObjectNode(container, UUID.randomUUID(), ref, bo, Completeness.UNKNOWN, false));
	}

	private void populateFlowSegments(final List<FlowSegmentReference> highlightableFlowElements) {
		highlightableFlowElements.forEach(fs -> populateFlowSegments(findFlowSegments(fs)));
	}

	private void determineNodesToRemove(final BusinessObjectNode node, final List<BusinessObjectNode> nodesToRemove) {
		if (enabledNodes.contains(node)) {
			for (final BusinessObjectNode child : node.getChildren()) {
				determineNodesToRemove(child, nodesToRemove);
			}
		} else {
			nodesToRemove.add(node);
		}
	}

	public RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
		final RelativeBusinessObjectReference result = referenceService.getRelativeReference(bo);
		return result;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
			// Update the editor
			if (newEditor instanceof AgeDiagramEditor) {
				this.editor = (AgeDiagramEditor) newEditor;
			} else {
				this.editor = null;
			}

			refresh();
		}
	}

	private void refresh() {
		if (editor != null) {

		}
	}

	private BusinessObjectNode showContext(final Context dstContext, final BusinessObjectNode refContainer) {
		if (dstContext != null) {
			final RelativeBusinessObjectReference dstContextRef = getRelativeBusinessObjectReference(
					dstContext);
			if (refContainer.getChild(dstContextRef) == null) {
				// Show context
				enableNode(refContainer, UUID.randomUUID(), dstContextRef, dstContext);
			}

			return refContainer.getChild(dstContextRef);
		}

		return refContainer;
	}
}
