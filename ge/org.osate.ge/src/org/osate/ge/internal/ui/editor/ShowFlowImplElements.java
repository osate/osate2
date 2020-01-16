package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
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
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
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
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.util.BusinessObjectContextHelper;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;

import com.google.common.base.Predicates;

public class ShowFlowImplElements extends ControlContribution {
	private AgeDiagramEditor editor = null;
	private BusinessObjectProviderHelper bopHelper;
	private ProjectReferenceService referenceService;
	private List<BusinessObjectNode> populatedNodes = new ArrayList<>();
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
					final ExtensionService extService = Objects.requireNonNull(
							Adapters.adapt(editor, ExtensionService.class), "Unable to retrieve extension service");
					final GraphitiService graphitiService = Objects.requireNonNull(
							Adapters.adapt(editor, GraphitiService.class), "Unable to retrieve graphiti service");
					referenceService = Objects.requireNonNull(Adapters.adapt(editor, ProjectReferenceService.class),
							"Unable to retrieve reference service");
					bopHelper = new BusinessObjectProviderHelper(extService);
					BusinessObjectContextHelper bocHelper = new BusinessObjectContextHelper(extService);

					AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
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
							.findAny().map(BusinessObjectNode.class::cast).orElseThrow(() -> new RuntimeException("")); // TODO look into order of findany then
					Object container = highlightableFlowInfo.getContainer().getBusinessObject();
					if (container instanceof Subcomponent) {
						final Subcomponent sc = (Subcomponent) container;
						container = sc.getComponentImplementation();
					}

					// final Set<BusinessObjectNode> flowSegmentHighlights = new HashSet<>();

					final NamedElement flow = highlightableFlowInfo.getFlowSegment();
					if (container instanceof ComponentImplementation) {
						final ComponentImplementation ci = (ComponentImplementation) container;
						// ETE or Impl
						if (flow instanceof FlowSpecification) {
							System.err.println("Flow Impl: " + flow.getName());
							ci.getAllFlowImplementations().stream()
							.filter(fi -> flow.getName().equalsIgnoreCase(fi.getSpecification().getName()))
							.findAny().ifPresent(flowImpl -> {
								final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(
										flowImpl.getSpecification(), containerNode);
								// Add initial segment and children
								final Stream<FlowSegmentReference> allFlowSegmentsRefs = Stream
										.concat(Stream.of(flowSegmentRef), getAllChildren(
												findChildren(flowSegmentRef).filter(Predicates.notNull())));
								final List<FlowSegmentReference> refs = allFlowSegmentsRefs
										.collect(Collectors.toList());
								for (final FlowSegmentReference ref : refs) {
									System.err.println(ref.flowSegmentElement + " flowSegmentElementIMpl");
								}
								// findAndAddDiagramElements(allFlowSegmentsRefs, flowSegmentHighlights);
							});
						} else {
							System.err.println("EndToEndFlow");
							final String eteName = flow.getName();
							final Optional<EndToEndFlow> eteFlow = ci.getAllEndToEndFlows().stream()
									.filter(etef -> eteName.equalsIgnoreCase(etef.getName())).findAny();
							eteFlow.ifPresent(endToEndFlow -> {
								final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(endToEndFlow,
										containerNode);
								final Stream<FlowSegmentReference> allFlowSegmentsRefs = getAllChildren(
										findChildren(flowSegmentRef).filter(Predicates.notNull()));
								final List<FlowSegmentReference> refs = allFlowSegmentsRefs
										.collect(Collectors.toList());
								for (final FlowSegmentReference ref : refs) {
									final NamedElement flowSegment = ref.flowSegmentElement;
									final BusinessObjectNode refContainer = (BusinessObjectNode) ref.container;
									if (flowSegment instanceof FlowSpecification) {
										final FlowSpecification fs = (FlowSpecification) flowSegment;
										if (fs.getAllInEnd() != null) {
											enableFlowEnd(fs.getAllInEnd(), refContainer);
										}

										if (fs.getAllOutEnd() != null) {
											enableFlowEnd(fs.getAllOutEnd(), refContainer);
										}
									} else if (flowSegment instanceof Connection) {
										// TODO do i need to do anything? show port for src and dest? flow specs already show them
										final Connection connection = (Connection) flowSegment;
										final ConnectionEnd dstEnd = connection.getAllDestination();
										final Context dstContext = connection.getAllDestinationContext();
										// System.err.println(dstEnd + " dstEnd");
										// System.err.println(dstContext + " dstcontext");

										final ConnectionEnd srcEnd = connection.getAllSource();
										final Context srcContext = connection.getAllSourceContext();
										// System.err.println(srcEnd + " srcEnd");
										// System.err.println(srcContext + " srccontext");
									}
								}
							});
						}
					} else if (container instanceof ComponentInstance) {
						final ComponentInstance ci = (ComponentInstance) container;
						// ETE Flows only
						final EndToEndFlow eteFlow = (EndToEndFlow) flow;
					}

					final AgeDiagram diagram = editor.getAgeDiagram();
					final List<BusinessObjectNode> nodesToRemove = new ArrayList<>();
					determineNodesToRemove(boTree, nodesToRemove);
					nodesToRemove.forEach(BusinessObjectNode::remove);

					final DiagramConfigurationBuilder diagramConfigBuilder = new DiagramConfigurationBuilder(
							Objects.requireNonNull(editor.getAgeDiagram().getConfiguration(),
									"diagramConfig must not be null"));
					Result result = new Result(diagramConfigBuilder.build(), boTree);
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

			private void enableFlowEnd(FlowEnd flowEnd, final BusinessObjectNode containerNode) {
				if (containerNode.getChild(getRelativeBusinessObjectReference(flowEnd.getContext())) == null) {
					enabledNodes.add(new BusinessObjectNode(containerNode, UUID.randomUUID(),
							getRelativeBusinessObjectReference(flowEnd.getContext()), flowEnd.getContext(),
							Completeness.UNKNOWN, false));
				}

				if (flowEnd.getFeature() instanceof FeatureGroup) {
					final FeatureGroup fg = (FeatureGroup) flowEnd.getFeature();
					final BusinessObjectNode contextNode = containerNode
							.getChild(getRelativeBusinessObjectReference(flowEnd.getContext()));
					if (contextNode.getChild(getRelativeBusinessObjectReference(fg)) == null) {
						enabledNodes.add(new BusinessObjectNode(contextNode, UUID.randomUUID(),
								getRelativeBusinessObjectReference(fg), fg, Completeness.UNKNOWN, false));
					}
				} else {
					final Feature feature = (Feature) flowEnd.getFeature();
					final BusinessObjectNode contextNode = containerNode
							.getChild(getRelativeBusinessObjectReference(flowEnd.getContext()));
					if (contextNode.getChild(getRelativeBusinessObjectReference(feature)) == null) {
						enabledNodes.add(new BusinessObjectNode(contextNode, UUID.randomUUID(),
								getRelativeBusinessObjectReference(feature), feature, Completeness.UNKNOWN, false));
					}
				}
			}

			private BusinessObjectNode getBoTree(final TreeUpdater boTreeExpander) {
				BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter
						.createBusinessObjectNode(editor.getAgeDiagram());
				return boTreeExpander.expandTree(editor.getAgeDiagram().getConfiguration(), boTree);
			}
		});

		return btn;
	}

	/**
	 * Returns a stream of flow elements that are referred to by a specified flow element.
	 * Returns an empty stream for all flow element references which are not a flow specification or end to end flow.
	 * @param flowElementRef
	 * @return
	 */
	// TODO just add business object nodes as they are found, possible way to not copy and paste so much.
	// TODO pass in lambda (method) to create bno
	public Stream<FlowSegmentReference> findChildren(final FlowSegmentReference flowElementRef) {
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
					.orElse(Stream.empty());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlow) {
			return AadlClassifierUtil
					.getComponentImplementation(
							flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> ete.getAllFlowSegments().stream())
							.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
									(BusinessObjectNode) flowElementRef.container)))
					.orElse(Stream.empty());
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
					.orElse(Stream.empty());
		} else {
			return Stream.empty();
		}
	}

	// TODO just add business object nodes as they are found, possible way to not copy and paste so much.
	// TODO pass in lambda (method) to create bno
	public FlowSegmentReference createFlowSegmentReference(final Object bo, final BusinessObjectNode container) {
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
				return container.getAllDescendants().filter(q -> q.getBusinessObject() == io).findAny()
						.map(q -> new FlowSegmentReference(io, q.getParent())).orElse(null);
			}
		} else if (bo instanceof NamedElement) {
			final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(bo);
			if (ref != null) {
				ensurePopulatedChild(bo, container);
			}
			return new FlowSegmentReference((NamedElement) bo, container);
		} else {
			throw new RuntimeException("Unexpected business object: " + bo);
		}
	}

	private void ensurePopulatedChild(Object bo, final BusinessObjectNode container) {
		final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(bo);
		final BusinessObjectNode segmentContextNode = container.getChild(ref);
		if (segmentContextNode == null) {
			enableNode(container, UUID.randomUUID(), ref, bo);
		}
	}

	private void enableNode(final BusinessObjectNode container, UUID randomUUID, RelativeBusinessObjectReference ref,
			Object bo) {
		enabledNodes.add(new BusinessObjectNode(container, UUID.randomUUID(), ref, bo, Completeness.UNKNOWN, false));
	}

	// TODO just add business object nodes as they are found, possible way to not copy and paste so much
	private Stream<FlowSegmentReference> getAllChildren(final Stream<FlowSegmentReference> highlightableFlowElements) {
		return highlightableFlowElements.flatMap(fsr -> {
			return Stream.concat(Stream.of(fsr),
					getAllChildren(findChildren(fsr).filter(Predicates.notNull())));
		});

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

	public class Result {
		private final DiagramConfiguration diagramConfiguration;
		private final BusinessObjectNode businessObjectTree;

		public Result(final DiagramConfiguration diagramConfiguration, final BusinessObjectNode businessObjectTree) {
			this.diagramConfiguration = Objects.requireNonNull(diagramConfiguration,
					"diagramConfiguration must not be null");
			this.businessObjectTree = Objects.requireNonNull(businessObjectTree, "businessObjectTree must not be null");
		}

		public DiagramConfiguration getDiagramConfiguration() {
			return diagramConfiguration;
		}

		public BusinessObjectNode getBusinessObjectTree() {
			return businessObjectTree;
		}
	}

	public boolean isProxy(final Object bo) {
		return bo instanceof BusinessObjectProxy;
	}

	public Object resolve(final Object bo) {
		if (bo instanceof BusinessObjectProxy) {
			return ((BusinessObjectProxy) bo).resolve(referenceService);
		}

		return bo;
	}

	public Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc) {
		return bopHelper.getChildBusinessObjects(boc);
	}

	public RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
		final RelativeBusinessObjectReference result = referenceService.getRelativeReference(bo);
		return result;
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
			// saveFlowSelection();

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
			/*
			 * System.err.println("refresh");
			 * System.err.println(editor + " editor");
			 * System.err.println(editor.getDiagramBehavior() + " behavior");
			 * System.err.println(editor.getDiagramTypeProvider() + " dtp");
			 * // Diagram is PE can get children?
			 * System.err.println(editor.getDiagramTypeProvider().getDiagram() + " getDiagram");
			 * AgeDiagramTypeProvider a = (AgeDiagramTypeProvider) editor.getDiagramTypeProvider();
			 * System.err.println(editor.getDiagramBehavior().getGraphitiAgeDiagram().getAgeDiagram().getAllDescendants()
			 * .collect(Collectors.toList()).size() + " size");
			 */
		}
	}
}
