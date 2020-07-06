package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
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
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.ui.tools.CreateEndToEndFlowSpecificationTool;
import org.osate.ge.internal.ui.tools.CreateFlowImplementationTool;
import org.osate.ge.internal.ui.tools.FlowDialogUtil;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlFlowSpecificationUtil.FlowSegmentReference;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.util.ProxyUtil;

import com.google.common.base.Predicates;

public class EditFlowContributionItem extends ControlContribution {
	final Set<BusinessObjectNode> segmentNodes = new HashSet<>();
	private AgeDiagramEditor editor = null;
	private Button editFlowBtn;
	private HighlightableFlowInfo selectedFlow;


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
		editFlowBtn.setText("Edit");
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
				final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();
				final BusinessObjectNode boTree = getBoTree(boTreeExpander);
				final Queryable container = selectedFlow.getContainer();
				final Element containerBo = (Element) container.getBusinessObject();
				final BusinessObjectNode containerNode = boTree.getAllDescendants()
						.filter(q -> q
								.getBusinessObject() == containerBo)
						.findAny()
						.map(BusinessObjectNode.class::cast)
						.orElseThrow(() -> new RuntimeException("Cannot find container for highlightable flow: "
								+ selectedFlow.getFlowSegment().getName()));
				final ComponentImplementation ci = getContainerComponent(containerBo);

				final Optional<DiagramElement> de = editor.getAgeDiagram().getDiagramElements().stream().findAny();
				if (de.isPresent()) {
					// TODO select does not set focus, it is needed for activating tool
					editor.setFocus();
					editor.selectDiagramElementsForBusinessObject(de.get().getBusinessObject());

					final UiService uiService = Adapters.adapt(editor, UiService.class);
					if (selectedFlow.getFlowSegment() instanceof EndToEndFlow) {
						final EndToEndFlow resolvedEndToEndFlow = ProxyUtil
								.resolveOrNull(AadlHelper.getRootRefinedElement(selectedFlow
										.getFlowSegment()),
										EndToEndFlow.class,
										ci.eResource().getResourceSet());
						getEndToEndFlow(resolvedEndToEndFlow, ci).ifPresent(endToEndFlow -> {
							ensureFlowSegmentsExist(endToEndFlow, containerNode);
							ensureInModeOrTransitionsExist(endToEndFlow, containerNode);
							uiService.activateTool(
									new CreateEndToEndFlowSpecificationTool(editor,
											new HighlightableFlowInfo(
													new FlowSegmentReference(
															endToEndFlow,
															containerNode),
													selectedFlow.getState()),
											segmentNodes));
						});
					} else if (selectedFlow.getFlowSegment() instanceof FlowSpecification) {
						final FlowSpecification fs = ProxyUtil.resolveOrNull(selectedFlow
								.getFlowSegment(),
								FlowSpecification.class, ci.eResource().getResourceSet());
						getFlowImplementation(ci, fs).ifPresent(fi -> {
							ensureFlow(fi, containerNode);
							ensureInModeFeatures(fi, containerNode);
							uiService.activateTool(new CreateFlowImplementationTool(editor, new HighlightableFlowInfo(
									new FlowSegmentReference(fi, containerNode), selectedFlow.getState()), segmentNodes));
						});
					} else {
						throw new RuntimeException("Unsupported flow type.");
					}
				}
			}

			private Optional<EndToEndFlow> getEndToEndFlow(final EndToEndFlow resolvedEndToEndFlow,
					final ComponentImplementation ci) {
				for (final EndToEndFlow et : ci.getAllEndToEndFlows()) {
					if (((NamedElement) AadlHelper.getRootRefinedElement(et)).getName().equalsIgnoreCase(
							((NamedElement) AadlHelper.getRootRefinedElement(resolvedEndToEndFlow)).getName())) {
						return Optional.of(et);
					}
				}

				return Optional.empty();
			}

			private void ensureFlow(FlowImplementation fi, BusinessObjectNode containerNode) {
				final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(
						fi.getSpecification());
				BusinessObjectNode child = containerNode.getChild(childRef);
				if (child == null) {
					child = createNode(containerNode, childRef, fi.getSpecification());
				}
				segmentNodes.add(child);

				if (fi.getInEnd() != null) {
					final FlowEnd inEnd = fi.getInEnd();
					BusinessObjectNode contextNode = containerNode;
					if (inEnd.getContext() != null) {
						final RelativeBusinessObjectReference inEndContextRef = getRelativeBusinessObjectReference(
								inEnd.getContext());
						BusinessObjectNode inEndNode = contextNode.getChild(inEndContextRef);
						if (inEndNode == null) {
							inEndNode = createNode(contextNode, inEndContextRef, inEnd.getContext());
						}

						contextNode = inEndNode;
					}
					final RelativeBusinessObjectReference inEndFeatureRef = getRelativeBusinessObjectReference(
							inEnd.getFeature());
					BusinessObjectNode inEndFeature = contextNode.getChild(inEndFeatureRef);
					if (inEndFeature == null) {
						inEndFeature = createNode(contextNode, inEndFeatureRef, inEnd.getFeature());
					}

					segmentNodes.add(inEndFeature);
				}

				if (fi.getOutEnd() != null) {
					final FlowEnd outEnd = fi.getOutEnd();
					BusinessObjectNode contextNode = containerNode;
					if (outEnd.getContext() != null) {
						final RelativeBusinessObjectReference outEndContextRef = getRelativeBusinessObjectReference(
								outEnd.getContext());
						BusinessObjectNode outEndNode = contextNode.getChild(outEndContextRef);
						if (outEndNode == null) {
							outEndNode = createNode(contextNode, outEndContextRef, outEnd.getContext());
						}

						contextNode = outEndNode;
					}
					final RelativeBusinessObjectReference outEndFeatureRef = getRelativeBusinessObjectReference(
							outEnd.getFeature());
					BusinessObjectNode outEndFeature = contextNode.getChild(outEndFeatureRef);
					if (outEndFeature == null) {
						outEndFeature = createNode(contextNode, outEndFeatureRef, outEnd.getFeature());
					}
					segmentNodes.add(outEndFeature);
				}

				enableFlowSegments(fi.getOwnedFlowSegments().stream()
						.map(seg -> createFlowSegmentReference(seg, containerNode))
						.collect(Collectors.toList()));
			}

			private void ensureInModeFeatures(FlowImplementation fi, BusinessObjectNode containerNode) {
				fi.getInModeOrTransitions().forEach(modeFeature -> {
					final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(modeFeature);
					BusinessObjectNode child = containerNode.getChild(ref);
					if (child == null) {
						child = createNode(containerNode, ref, modeFeature);
					}

					segmentNodes.add(child);
				});

			}

			private Optional<FlowImplementation> getFlowImplementation(final ComponentImplementation ci,
					final FlowSpecification flowSpec) {
				final List<FlowImplementation> impls = ci.getAllFlowImplementations().stream()
						.filter(fi -> fi.getSpecification() == flowSpec).collect(Collectors.toList());

				if (impls.size() == 1) {
					return Optional.of(impls.get(0));
				} else {
					final M dlg = new M(Display.getCurrent().getActiveShell(), impls, "Select", null,
							"Choose the flow implementation to delete.", MessageDialog.CONFIRM, 0, "OK", "Cancel");
					if (dlg.open() == Window.OK) {
						return Optional.of(dlg.selectedFi);
					}
				}

				return Optional.empty();
			}

			private ComponentImplementation getContainerComponent(final Element container) {
				if (container instanceof Subcomponent) {
					final Subcomponent sc = (Subcomponent) AadlHelper.getRootRefinedElement((NamedElement) container);
					return sc.getComponentImplementation();
				}

				return (ComponentImplementation) container;
			}

			private void ensureFlowSegmentsExist(
					final NamedElement flow,
					final BusinessObjectNode containerNode) {
				final EndToEndFlow eteFlow = (EndToEndFlow) flow;
				final FlowSegmentReference flowSegmentRef = createFlowSegmentReference(
						eteFlow,
						containerNode);
				enableFlowSegments(findFlowSegments(flowSegmentRef));
			}

			private void ensureInModeOrTransitionsExist(EndToEndFlow flow, BusinessObjectNode containerNode) {
				final EndToEndFlow endToEndFlow = (EndToEndFlow) flow;
				endToEndFlow.getInModeOrTransitions().forEach(modeFeature -> {
					final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(modeFeature);
					BusinessObjectNode child = containerNode.getChild(ref);
					if (child == null) {
						child = createNode(containerNode, ref, modeFeature);
					}

					segmentNodes.add(child);
				});
			}

			private List<FlowSegmentReference> findFlowSegments(final FlowSegmentReference flowElementRef) {
				if (flowElementRef.flowSegmentElement instanceof EndToEndFlow) {
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

			private void enableFlowSegments(final List<FlowSegmentReference> highlightableFlowElements) {
				highlightableFlowElements.stream().filter(Predicates.notNull())
				.forEach(fs -> enableFlowSegments(findFlowSegments(fs)));
			}

			private Optional<BusinessObjectNode> ensureEnabledChild(final Object childBo,
					final BusinessObjectNode parent) {
				if (childBo != null) {
					final RelativeBusinessObjectReference childRef = getRelativeBusinessObjectReference(childBo);
					if (childRef != null) {
						BusinessObjectNode childNode = parent.getChild(childRef);
						if (childNode == null) {
							childNode = createNode(parent, childRef, childBo);
						}

						return Optional.of(childNode);
						// nodes.add(childNode);
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
						segmentNodes.add(new BusinessObjectNode(context, UUID.randomUUID(),
								new RelativeBusinessObjectReference(getRefinedName(flowSegment.getFlowElement())),
								flowSegment.getFlowElement(), Completeness.UNKNOWN, false));

						return null;
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

			private String getRefinedName(final Element e) {
				return AadlHelper.getRootRefinedElement((NamedElement) e).getName();
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
					final Queue<Element> ancestors, Element ancestor) {
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
					final RelativeBusinessObjectReference ancestorRef = getRelativeBusinessObjectReference(
							ancestorToEnable);
					if (ancestorNode.getChild(ancestorRef) == null) {
						ancestorNode = createNode(ancestorNode, ancestorRef, ancestorToEnable);
					}
				}
			}
		});

		return editFlowBtn;
	}

	private class M extends MessageDialog {
		private ComboViewer comboViewer;
		private final List<FlowImplementation> input;
		private FlowImplementation selectedFi;

		public M(Shell parentShell, final List<FlowImplementation> input, String dialogTitle, Image dialogTitleImage,
				String dialogMessage, int dialogImageType, int defaultIndex, String... dialogButtonLabels) {
			super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, defaultIndex,
					dialogButtonLabels);
			setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			this.input = input;
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(new Point(550, 275));
		}

		@Override
		protected Control createCustomArea(final Composite parent) {
			final Composite composite = new Composite(parent, SWT.BORDER);
			final GridLayout layout = new GridLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.verticalSpacing = 0;
			layout.horizontalSpacing = 0;
			layout.numColumns = 2;
			composite.setLayout(layout);

			composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			composite.setFont(parent.getFont());

			new Label(composite, SWT.NONE).setText("Flow Implementation: ");
			comboViewer = new ComboViewer(composite, SWT.READ_ONLY);

			final StyledText flowSegmentLabels = FlowDialogUtil.createFlowSegmentLabel(composite);
			flowSegmentLabels.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());
			comboViewer.setContentProvider(ArrayContentProvider.getInstance());
			comboViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					final FlowImplementation fi = (FlowImplementation) element;
					return fi.getSpecification().getName();
				}
			});

			comboViewer.addSelectionChangedListener(event -> {
				selectedFi = (FlowImplementation) event.getStructuredSelection().getFirstElement();
				String flowStr = "";
				final List<String> flowSegmentStrings = new ArrayList<>();
				if (selectedFi.getInEnd() != null) {
					flowSegmentStrings.add(flowEndToString(selectedFi.getInEnd()));
				}

				for (final FlowSegment seg : selectedFi.getOwnedFlowSegments()) {
					flowSegmentStrings.add(flowSegmentToString(seg));
				}

				if (selectedFi.getOutEnd() != null) {
					flowSegmentStrings.add(flowEndToString(selectedFi.getOutEnd()));
				}

				flowStr += flowSegmentStrings.stream().collect(Collectors.joining(" -> "));

				final int modeStartIndex = flowStr.length();
				if (!selectedFi.getInModeOrTransitions().isEmpty()) {
					flowStr += " in modes (" + selectedFi.getInModeOrTransitions().stream().map(mf -> mf.getName())
							.collect(Collectors.joining(", ")) + ")";
				}
				final int modeEndIndex = flowStr.length();

				flowStr += ";";

				flowSegmentLabels.setText(flowStr);

				if (modeStartIndex != modeEndIndex) {
					flowSegmentLabels.setStyleRange(new StyleRange(modeStartIndex, 10,
							Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				}
			});

			comboViewer.setInput(input);
			comboViewer.setSelection(new StructuredSelection(input.get(0)));

			return composite;
		}

		// TODO Flow segments may be refined, make sure to use getrootelement before getting names for segments

		private String flowEndToString(final FlowEnd flowEnd) {
			final StringBuilder sb = new StringBuilder();
			if (flowEnd.getContext() != null) {
				sb.append(getName(flowEnd.getContext()));
				sb.append('.');
			}

			if (flowEnd.getFeature() != null) {
				sb.append(getName(flowEnd.getFeature()));
			}

			return sb.toString();
		}

		private String flowSegmentToString(final FlowSegment flowSegment) {
			final StringBuilder sb = new StringBuilder();
			if (flowSegment.getContext() != null) {
				sb.append(getName(flowSegment.getContext()));
				sb.append('.');
			}

			if (flowSegment.getFlowElement() != null) {
				sb.append(getName(flowSegment.getFlowElement()));
			}

			return sb.toString();
		}
	}

	private String getName(NamedElement ne) {
		ne = (NamedElement) AadlHelper.getRootRefinedElement(ne);
		return ne.getName() == null ? "<unknown>" : ne.getName();
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
	 * Updates the enabled state of the show flow button determined by the state of the selected flow
	 */
	public void updateEditFlowItem(final HighlightableFlowInfo selectedFlow) {
		this.selectedFlow = selectedFlow;
		updateButton();
	}

	private void updateButton() {
		if (editFlowBtn != null && !editFlowBtn.isDisposed()) {
			editFlowBtn.setEnabled(selectedFlow == null ? false
					: (selectedFlow.getFlowSegment() != null && !isRefined(selectedFlow.getFlowSegment())));
		}
	}

	private boolean isRefined(final NamedElement flowSegment) {
		if (flowSegment instanceof RefinableElement) {
			return ((RefinableElement) flowSegment).getRefinedElement() != null;
		}

		return false;
	}
}
