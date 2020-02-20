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
package org.osate.ge.internal.ui.handlers;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.BusinessObjectContext;
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
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.dialogs.DiagramConfigurationDialog;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;

public class ShowConnectedElementsHandler extends AbstractHandler {
	private ProjectReferenceService referenceService;

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedBusinessObjectContexts().stream()
				.filter(boc -> isSubcomponentOrConnectionEnd(boc))
				.findAny().isPresent());
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Feature selected, go up until componentImpl.hasconnections go down
		final AgeDiagramEditor editor = getAgeDiagramEditor(event);
		// Worth casting to bos? and just use object nodes
		final List<BusinessObjectContext> selectedElements = AgeHandlerUtil.getSelectedBusinessObjectContexts().stream()
				.filter(boc -> isSubcomponentOrConnectionEnd(boc))
				.collect(Collectors.toList());

		referenceService = Objects.requireNonNull(Adapters.adapt(editor, ProjectReferenceService.class),
				"Unable to retrieve reference service");
		final ExtensionService extService = Objects.requireNonNull(Adapters.adapt(editor, ExtensionService.class),
				"Unable to retrieve extension service");

		try (final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService)) {
			final AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
					.getFeatureProvider();
			final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();
			final BusinessObjectNode boTree = getBoTree((AgeDiagramEditor) editor, boTreeExpander);

			for (final BusinessObjectContext selectedElement : selectedElements) {
				final BusinessObjectNode selectedNode = getSelectedNode(boTree, selectedElement);
				final Object selectedBo = selectedNode.getBusinessObject();
				if (selectedBo instanceof ConnectionEnd) {
					final SimpleEntry<Optional<ComponentImplementation>, BusinessObjectNode> compImplToConnectionEnd = getComponentImplToConnectionEnd(
							selectedNode);
					final Optional<ComponentImplementation> ciOpt = compImplToConnectionEnd.getKey();
					final BusinessObjectNode connectionEndNode = compImplToConnectionEnd.getValue();
					final BusinessObjectNode ciNode = selectedBo instanceof Subcomponent && connectionEndNode == selectedNode
							? selectedNode
									: connectionEndNode.getParent();

					ciOpt.ifPresent(ci -> {
						ci.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
							final ConnectedElement dest = con.getDestination();
							final ConnectedElement src = con.getSource();
							// Destination Connection Ends
							final List<ConnectionEnd> destConnectionEnds = getConnectionEnds(con.getDestination());
							if (destConnectionEnds.contains(selectedBo)
									&& dest.getConnectionEnd() == connectionEndNode.getBusinessObject()) {
								// Enable Selected Element
								enableConnectedElements(ciNode, con.getDestination());

								// Enable Source Context
								BusinessObjectNode context = ciNode;
								if (con.getAllSourceContext() != null) {
									final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(
											con.getAllSourceContext());
									context = ciNode.getChild(contextRef);
									if (context == null) {
										context = createNode(ciNode, contextRef, con.getAllSourceContext());
									}
								}

								// Enable Source
								enableConnectedElements(context, con.getSource());

								// Enable connection
								final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
								final BusinessObjectNode conNode = ciNode.getChild(conRef);
								if (conNode == null) {
									createNode(ciNode, conRef, con);
								}
							}

							// Source Connection Ends
							final List<ConnectionEnd> srcConnectionEnds = getConnectionEnds(con.getSource());
							if (srcConnectionEnds.contains(selectedNode.getBusinessObject())
									&& src.getConnectionEnd() == connectionEndNode.getBusinessObject()) {
								// Enable Selected
								enableConnectedElements(ciNode, con.getSource());
								// Enable Destination Context
								BusinessObjectNode context = ciNode;
								if (con.getAllDestinationContext() != null) {
									final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(
											con.getAllDestinationContext());
									context = ciNode.getChild(contextRef);
									if (context == null) {
										context = createNode(ciNode, contextRef, con.getAllDestinationContext());
									}
								}

								enableConnectedElements(context, con.getDestination());
								final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
								final BusinessObjectNode conNode = ciNode.getChild(conRef);
								if (conNode == null) {
									createNode(ciNode, conRef, con);
								}
							}
						});
					});

					// Check opCi parent for connections?
					// final BusinessObjectNode parentCiNode = ciNode.getParent();
					AadlClassifierUtil.getComponentImplementation(ciNode.getParent()).ifPresent(ci -> {
						ci.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
							// TODO
							final ConnectedElement dest = con.getDestination();
							final ConnectedElement src = con.getSource();
							if (test(dest, src, con.getAllSourceContext(), selectedNode,
									connectionEndNode.getBusinessObject(), ciNode)
									|| test(src, dest, con.getAllDestinationContext(), selectedNode,
											connectionEndNode.getBusinessObject(),
											ciNode)) {
								enableConnection(con, ciNode.getParent());
							}

							// final List<ConnectionEnd> destConnectionEnds = getConnectionEnds(dest);
//							if (destConnectionEnds.contains(selectedNode.getBusinessObject())
//									&& dest.getConnectionEnd() == connectionEndNode.getBusinessObject()) {
//								enableConnectedElements(ciNode, dest);
//								BusinessObjectNode context = parentCiNode;
//								if (con.getAllSourceContext() != null) {
//									final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(
//											con.getAllSourceContext());
//
//									context = parentCiNode.getChild(contextRef);
//									if (context == null) {
//										context = createNode(parentCiNode, contextRef, con.getAllSourceContext());
//									}
//								}
//								enableConnectedElements(context, src);
//
//								final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
//								final BusinessObjectNode conNode = parentCiNode.getChild(conRef);
//								if (conNode == null) {
//									createNode(parentCiNode, conRef, con);
//								}
//							}

//							final List<ConnectionEnd> srcConnectionEnds = getConnectionEnds(src);
//							if (srcConnectionEnds.contains(selectedNode.getBusinessObject())
//									&& src.getConnectionEnd() == connectionEndNode.getBusinessObject()) {
//								enableConnectedElements(ciNode, src);
//								BusinessObjectNode context = parentCiNode;
//								if (con.getAllDestinationContext() != null) {
//									final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(
//											con.getAllDestinationContext());
//									context = parentCiNode.getChild(contextRef);
//									if (context == null) {
//										context = createNode(parentCiNode, contextRef, con.getAllDestinationContext());
//									}
//								}
//
//								enableConnectedElements(context, dest);
//								final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
//								final BusinessObjectNode conNode = parentCiNode.getChild(conRef);
//								if (conNode == null) {
//									createNode(parentCiNode, conRef, con);
//								}
//							}
						});
					});
				}

				if (selectedElement.getBusinessObject() instanceof Subcomponent) {
					// final BusinessObjectNode selectedNode = getSelectedNode(boTree, selectedElement);
					final BusinessObjectNode parent = selectedNode.getParent();
					// Parent Connections to Subcomponent
					AadlClassifierUtil.getComponentImplementation(parent)
					.ifPresent(ci -> enableComponentImplemenationConnections(ci, parent, selectedNode));
					// Internal Connections to Subcomponent
					AadlClassifierUtil.getComponentImplementation(selectedNode)
					.ifPresent(ci -> enableSelectedElementConnections(ci, selectedNode));
				} else if (selectedElement.getBusinessObject() instanceof InstanceObject) {
					AadlInstanceObjectUtil.getComponentInstance(selectedElement).ifPresent(ci -> {
						if (ci.getOwner() instanceof ComponentInstance) {
							final ComponentInstance ciOwner = (ComponentInstance) ci.getOwner();
							ciOwner.getAllEnclosingConnectionInstances().stream()
							.flatMap(connectionInstance -> connectionInstance.getConnectionReferences().stream()).forEach(cr -> {
								if (cr.getSource().getComponentInstance() == ci
										|| cr.getDestination().getComponentInstance() == ci) {
									enableConnectionReferenceNodes(boTree, cr);
								}
							});
						}
						ci.getAllEnclosingConnectionInstances().stream()
						.flatMap(connectionInstance -> connectionInstance.getConnectionReferences().stream()).forEach(cr -> {
							if (cr.getSource().getComponentInstance() == ci
									|| cr.getDestination().getComponentInstance() == ci) {
								enableConnectionReferenceNodes(boTree, cr);
							}
						});
					});

					if (selectedElement.getBusinessObject() instanceof ConnectionInstanceEnd) {
						final ConnectionInstanceEnd connectionInstanceEnd = (ConnectionInstanceEnd) selectedElement
								.getBusinessObject();
						connectionInstanceEnd.getAllEnclosingConnectionInstances()
						.forEach(ci -> {
							ci.getConnectionReferences().forEach(cr -> {
								// Showing connected elements when source or destination is contained within a FeatureGroup
								if (connectionEndFound(cr.getSource(), connectionInstanceEnd)
										|| connectionEndFound(cr.getDestination(), connectionInstanceEnd)) {
									enableConnectionReferenceNodes(boTree, cr);
								}
							});
						});
					}
				}
			}

			final AgeDiagram diagram = editor.getAgeDiagram();
			final DiagramConfigurationBuilder diagramConfigBuilder = new DiagramConfigurationBuilder(Objects
					.requireNonNull(editor.getAgeDiagram().getConfiguration(), "diagramConfig must not be null"));
			final DiagramConfigurationDialog.Result result = new DiagramConfigurationDialog.Result(
					diagramConfigBuilder.build(), boTree);
			if (result != null) {
				final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
				final GraphitiService graphitiService = Objects.requireNonNull(
						Adapters.adapt(editor, GraphitiService.class), "Unable to retrieve graphiti service");
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

		return null;
	}

	private boolean test(final ConnectedElement dest, final ConnectedElement src, final Context srcCtx,
			final BusinessObjectNode selectedNode, final Object /* rename */ connectionEndNode,
			final BusinessObjectNode ciNode) {
		final List<ConnectionEnd> destConnectionEnds = getConnectionEnds(dest);
		if (destConnectionEnds.contains(selectedNode.getBusinessObject())
				&& dest.getConnectionEnd() == connectionEndNode) {
			final BusinessObjectNode parentCiNode = ciNode.getParent();
			enableConnectedElements(ciNode, dest);
			BusinessObjectNode context = parentCiNode;
			if (/* con.getAllSourceContext() */srcCtx != null) {
				final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(
						/* con.getAllSourceContext() */srcCtx);

				context = parentCiNode.getChild(contextRef);
				if (context == null) {
					context = createNode(parentCiNode, contextRef, /* con.getAllSourceContext() */srcCtx);
				}
			}
			enableConnectedElements(context, src);

//			final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
//			final BusinessObjectNode conNode = parentCiNode.getChild(conRef);
//			if (conNode == null) {
//				createNode(parentCiNode, conRef, con);
//			}

			return true;
		}

		return false;
	}

	private void enableConnectionReferenceNodes(final BusinessObjectNode boTree, final ConnectionReference cr) {
		final Map<Object, Queryable> descendantBoToQueryable = boTree
				.getAllDescendants().collect(Collectors.toMap(
						Queryable::getBusinessObject, Function.identity()));
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

	// Find ancestors and create if necessary
	private void enableAncestorNodes(final Map<Object, Queryable> descendantBoToQueryable, final Element ancestor) {
		final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<Element>());
		populateAncestorsQueue(descendantBoToQueryable, ancestors, ancestor);
		enableAncestorNodes(descendantBoToQueryable, ancestors, ancestors.poll());
	}

	// Gets the first element ancestor that is enabled
	private void populateAncestorsQueue(final Map<Object, Queryable> descendants, final Queue<Element> ancestors,
			Element ancestor) {
		while (!descendants.containsKey(ancestor)) {
			ancestors.add(ancestor);
			ancestor = ancestor.getOwner();
		}

		ancestors.add(ancestor);
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

	private List<ConnectionEnd> getConnectionEnds(ConnectedElement ce) {
		final List<ConnectionEnd> connectionEnds = new ArrayList<>();
		connectionEnds.add(ce.getConnectionEnd());
		while (ce.getNext() != null) {
			ce = ce.getNext();
			connectionEnds.add(ce.getConnectionEnd());
		}
		return connectionEnds;
	}

	private SimpleEntry<Optional<ComponentImplementation>, BusinessObjectNode> getComponentImplToConnectionEnd(
			BusinessObjectNode node) {
		BusinessObjectNode connectionEnd = node;
		for (; node != null; node = node.getParent()) {
			final Optional<ComponentImplementation> compImplOpt = AadlClassifierUtil.getComponentImplementation(node);
			if (compImplOpt.isPresent()) {
				return new AbstractMap.SimpleEntry<Optional<ComponentImplementation>, BusinessObjectNode>(compImplOpt,
						connectionEnd);
			}

			connectionEnd = node;
		}


		return new AbstractMap.SimpleEntry<Optional<ComponentImplementation>, BusinessObjectNode>(Optional.empty(),
				connectionEnd);
	}

	private void enableSelectedElementConnections(final ComponentImplementation ci,
			final BusinessObjectNode selectedNode) {
		ci.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
//			if (con.getAllDestinationContext() == null || !(con.getAllDestinationContext() instanceof Subcomponent)) {
//				test(selectedNode, con.getAllDestinationContext(), con.getAllSourceContext(), con.getSource(),
//						con.getDestination());
//				enableConnection(con, selectedNode);
//			} else if (con.getAllSourceContext() == null || !(con.getAllSourceContext() instanceof Subcomponent)) {
//				test(selectedNode, con.getAllSourceContext(), con.getAllDestinationContext(), con.getDestination(),
//						con.getSource());
//				enableConnection(con, selectedNode);
//			}

			if (enabledConnectionEnds(selectedNode, con.getAllDestinationContext(), con.getAllSourceContext(), con.getSource(),
					con.getDestination())
					|| enabledConnectionEnds(selectedNode, con.getAllSourceContext(), con.getAllDestinationContext(),
							con.getDestination(), con.getSource())) {
				enableConnection(con, selectedNode);
			}
		});
	}

	private void enableConnection(final Connection con, final BusinessObjectNode selectedNode) {
		// TODO Auto-generated method stub
		final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
		final BusinessObjectNode conNode = selectedNode.getChild(conRef);
		if (conNode == null) {
			createNode(selectedNode, conRef, con);
		}
	}

	// TODO rename
	private boolean enabledConnectionEnds(final BusinessObjectNode selectedNode, final Context context1,
			final Context context2, final ConnectedElement ce1, final ConnectedElement ce2) {
		if (context1 == null || !(context1 instanceof Subcomponent)) {
			if (context2 != null) {
				final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(context2);
				BusinessObjectNode contextNode = selectedNode.getChild(contextRef);
				if (contextNode == null) {
					contextNode = createNode(selectedNode, contextRef, context2);
				}

				enableConnectedElements(contextNode, ce1);
			}
			enableConnectedElements(selectedNode, ce2);

			return true;
		}

		return false;
	}

	private void enableComponentImplemenationConnections(final ComponentImplementation ci,
			BusinessObjectNode parent,
			BusinessObjectNode selectedNode) {
		ci.getAllConnections().forEach(con -> {
			con = con.getRootConnection();
			if (con.getAllDestinationContext() == selectedNode.getBusinessObject()) {

				enableConnectedElements(selectedNode, con.getDestination());

				BusinessObjectNode context = parent;
				if (con.getAllSourceContext() != null) {
					// Enable context node
					final RelativeBusinessObjectReference srcContextRef = getRelativeBusinessObjectReference(
							con.getAllSourceContext());
					// Get or create method?
					context = parent.getChild(srcContextRef);
					if (context == null) {
						context = createNode(parent, srcContextRef, con.getAllSourceContext());
					}
				}

				enableConnectedElements(context, con.getSource());

				final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
				if (parent.getChild(conRef) == null) {
					createNode(parent, conRef, con);
				}
			} else if (con.getAllSourceContext() == selectedNode.getBusinessObject()) {
				enableConnectedElements(selectedNode, con.getSource());

				BusinessObjectNode context = parent;
				if (con.getAllDestinationContext() != null) {
					// Enable context node
					final RelativeBusinessObjectReference dstContextRef = getRelativeBusinessObjectReference(
							con.getAllDestinationContext());
					context = parent.getChild(dstContextRef);
					if (context == null) {
						context = createNode(parent, dstContextRef, con.getAllDestinationContext());
					}
				}

				enableConnectedElements(context, con.getDestination());

				final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
				if (parent.getChild(conRef) == null) {
					createNode(parent, conRef, con);
				}
			}
		});
	}

	private void enableConnectedElements(BusinessObjectNode parent, ConnectedElement ce) {
		while (ce != null) {
			final ConnectionEnd connectionEnd = ce.getConnectionEnd();
			final RelativeBusinessObjectReference ceRef = getRelativeBusinessObjectReference(connectionEnd);
			final BusinessObjectNode ceNode = parent.getChild(ceRef);
			parent = ceNode == null ? createNode(parent, ceRef, connectionEnd) : ceNode;
			ce = ce.getNext();
		}
	}

	/**
	 * Get the selected mode parent node and create ancestor nodes if necessary
	 */
	// TODO rename these params
	private BusinessObjectNode getSelectedNode(BusinessObjectNode parent, BusinessObjectContext nodeParent) {
		final Queue<Object> ancestors = Collections.asLifoQueue(new LinkedList<Object>());
		while (nodeParent.getBusinessObject() != null) {
			ancestors.add(nodeParent.getBusinessObject());
			nodeParent = nodeParent.getParent();
		}

		// Find ancestors to parent
		for (final Object ancestor : ancestors) {
			parent = getAncestor(ancestor, parent);
		}

		return parent;
	}

	private BusinessObjectNode getAncestor(final Object ancestor, final BusinessObjectNode parent) {
		final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(ancestor);
		final BusinessObjectNode node = parent.getChild(ref);
		// Enable ancestor node if necessary
		return node == null ? createNode(parent, ref, ancestor) : node;
	}

	private static boolean connectionEndFound(Element owner, final ConnectionInstanceEnd connectionInstanceEnd) {
		while (!(owner instanceof ComponentInstance)) {
			if (owner == connectionInstanceEnd) {
				return true;
			}
			owner = owner.getOwner();
		}

		return false;
	}

	private static BusinessObjectNode createNode(final BusinessObjectNode container,
			final RelativeBusinessObjectReference ref, final Object bo) {
		return new BusinessObjectNode(container, UUID.randomUUID(), ref, bo, Completeness.UNKNOWN, false);
	}

	// TODO check if this works on instance model, should be disabled for non subcomponents
	// TODO componentInstance.getSubcomponent returns null or not a subcomponent?
	private static boolean isSubcomponentOrConnectionEnd(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return (Subcomponent.class.isInstance(bo) && ((Subcomponent) bo).getComponentImplementation() != null)
				|| (ComponentInstance.class.isInstance(bo) && ((ComponentInstance) bo).getSubcomponent() != null)
				|| ConnectionEnd.class.isInstance(bo) || ConnectionInstanceEnd.class.isInstance(bo);
	}

	private static AgeDiagramEditor getAgeDiagramEditor(final ExecutionEvent event) {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		return (AgeDiagramEditor) activeEditor;
	}

	private static BusinessObjectNode getBoTree(final AgeDiagramEditor editor, final TreeUpdater boTreeExpander) {
		final BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter
				.createBusinessObjectNode(editor.getAgeDiagram());
		return boTreeExpander.expandTree(editor.getAgeDiagram().getConfiguration(), boTree);
	}

	private RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
		return referenceService.getRelativeReference(bo);
	}
}
