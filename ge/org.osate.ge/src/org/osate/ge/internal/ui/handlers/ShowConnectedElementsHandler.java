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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentClassifier;
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
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.AadlClassifierUtil;
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
		final AgeDiagramEditor editor = getAgeDiagramEditor(event);
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
					final SimpleEntry<Optional<ComponentClassifier>, BusinessObjectNode> classifierToConnectionEnd = getClassifierToConnectionEnd(
							selectedNode);
					final Optional<ComponentClassifier> compImplOpt = classifierToConnectionEnd.getKey();
					final BusinessObjectNode conEndNode = classifierToConnectionEnd.getValue();
					// Determine component implementation of selected node
					final BusinessObjectNode compNode = selectedBo instanceof Subcomponent
							&& conEndNode == selectedNode
							? selectedNode
									: conEndNode.getParent();
					// Internal Connections to Connection End
					compImplOpt.ifPresent(ci -> {
						if (ci instanceof ComponentImplementation) {
							enableInternalConnections((ComponentImplementation) ci, conEndNode.getBusinessObject(),
									selectedBo, compNode);
						}
					});

					// Parent Connections to Connection End
					AadlClassifierUtil.getComponentImplementation(compNode.getParent()).ifPresent(ci -> {
						enableParentConnections(ci, conEndNode.getBusinessObject(), selectedBo,
								compNode);
					});
				}

				if (selectedBo instanceof Subcomponent) {
					final BusinessObjectNode parent = selectedNode.getParent();
					// Parent Connections to Subcomponent
					AadlClassifierUtil.getComponentImplementation(parent)
					.ifPresent(compImpl -> enableComponentImplementationConnections(compImpl, parent, selectedNode));

					// Internal Connections to Subcomponent
					AadlClassifierUtil.getComponentImplementation(selectedBo)
					.ifPresent(compImpl -> enableSelectedElementConnections(compImpl, selectedNode));
				} else if (selectedBo instanceof InstanceObject) {
					if (selectedBo instanceof ComponentInstance) {
						final ComponentInstance compInstance = (ComponentInstance) selectedBo;
						enableComponentInstanceConnections(compInstance, boTree);
					}

					if (selectedBo instanceof ConnectionInstanceEnd) {
						final InstanceObject selectedConnectionEnd = (InstanceObject) selectedBo;
						enableInstanceEndConnections(selectedConnectionEnd, boTree);
					}
				}
			}

			final AgeDiagram diagram = editor.getAgeDiagram();
			final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
			final GraphitiService graphitiService = Objects.requireNonNull(
					Adapters.adapt(editor, GraphitiService.class), "Unable to retrieve graphiti service");
			final ActionService actionService = Objects.requireNonNull(Adapters.adapt(editor, ActionService.class),
					"Unable to retrieve action service");
			// Update the diagram
			actionService.execute("Show Connected Elements", ExecutionMode.NORMAL, () -> {
				// Update the diagram
				diagramUpdater.updateDiagram(diagram, boTree);

				// Update layout
				diagram.modify("Layout Incrementally",
						m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, graphitiService));

				return null;
			});
		}

		return null;
	}

	private void enableInternalConnections(final ComponentImplementation ci, final Object conEndContextBo,
			final Object selectedBo, final BusinessObjectNode compImplNode) {
		ci.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
			final ConnectedElement dest = con.getDestination();
			final ConnectedElement src = con.getSource();
			if (isConnectedConnection(dest, selectedBo, conEndContextBo, compImplNode, con.getAllSourceContext(), src)
					|| isConnectedConnection(src, selectedBo, conEndContextBo, compImplNode,
							con.getAllDestinationContext(), dest)) {
				enableConnection(con, compImplNode);
			}
		});
	}

	private void enableParentConnections(final ComponentImplementation ci, final Object conEndBo,
			final Object selectedBo, final BusinessObjectNode compNode) {
		ci.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
			final ConnectedElement dest = con.getDestination();
			final ConnectedElement src = con.getSource();
			if (isConnectedToConnectionEnd(dest, src, con.getAllSourceContext(), selectedBo, conEndBo,
					compNode)
					|| isConnectedToConnectionEnd(src, dest, con.getAllDestinationContext(), selectedBo,
							conEndBo, compNode)) {
				enableConnection(con, compNode.getParent());
			}
		});
	}

	private void enableInstanceEndConnections(final InstanceObject selectedConnectionEnd,
			final BusinessObjectNode boTree) {
		getConnectionReferences(selectedConnectionEnd).forEach(connectionReference -> {
			if (connectionEndFound(connectionReference.getSource(), selectedConnectionEnd)
					|| connectionEndFound(connectionReference.getDestination(), selectedConnectionEnd)) {
				enableConnectionReferenceNodes(boTree, connectionReference);
			}
		});
	}

	private void enableComponentInstanceConnections(final ComponentInstance compInstance,
			final BusinessObjectNode boTree) {
		if (compInstance.getOwner() instanceof ComponentInstance) {
			getConnectionReferences((InstanceObject) compInstance.getOwner()).forEach(connectionReference -> {
				if (connectionReference.getSource().getComponentInstance() == compInstance
						|| connectionReference.getDestination().getComponentInstance() == compInstance) {
					enableConnectionReferenceNodes(boTree, connectionReference);
				}
			});
		}
	}

	private static Stream<ConnectionReference> getConnectionReferences(final InstanceObject io) {
		return io.getAllEnclosingConnectionInstances().stream()
				.flatMap(connectionInstance -> connectionInstance.getConnectionReferences().stream());
	}

	private boolean isConnectedConnection(ConnectedElement destination, Object selectedBo, Object connectionEndBo,
			BusinessObjectNode ciNode, Context allSourceContext, ConnectedElement source) {
		// Destination Connection Ends
		final List<ConnectionEnd> destConnectionEnds = getConnectionEnds(destination);
		if (destConnectionEnds.contains(selectedBo) && destination.getConnectionEnd() == connectionEndBo) {
			// Enable Selected Element
			enableConnectedElements(ciNode, destination);

			// Enable Source Context
			BusinessObjectNode context = ciNode;
			if (allSourceContext != null) {
				final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(allSourceContext);
				context = ciNode.getChild(contextRef);
				if (context == null) {
					context = createNode(ciNode, contextRef, allSourceContext);
				}
			}

			// Enable Source
			enableConnectedElements(context, source);

			return true;
		}

		return false;
	}

	private boolean isConnectedToConnectionEnd(final ConnectedElement ce1, final ConnectedElement ce2,
			final Context ctx,
			final Object selectedBo, final Object connectionEndBo,
			final BusinessObjectNode ciNode) {
		final List<ConnectionEnd> connectionEnds = getConnectionEnds(ce1);
		if (connectionEnds.contains(selectedBo)
				&& ce1.getConnectionEnd() == connectionEndBo
				&& (ciNode.getBusinessObject() == ce1.getContext()
				|| ce1.getConnectionEnd() == ciNode.getBusinessObject())) {
			enableConnectedElements(ciNode, ce1);
			final BusinessObjectNode parentCiNode = ciNode.getParent();
			BusinessObjectNode context = parentCiNode;
			if (ctx != null) {
				final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(
						ctx);
				context = parentCiNode.getChild(contextRef);
				if (context == null) {
					context = createNode(parentCiNode, contextRef, ctx);
				}
			}
			enableConnectedElements(context, ce2);
			return true;
		}

		return false;
	}

	private void enableConnectionReferenceNodes(final BusinessObjectNode boTree, final ConnectionReference cr) {
		Element tmpElement = cr;
		// Ancestors to ensure are enabled on the diagram
		final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<Element>());
		while (tmpElement.getOwner() != null) {
			ancestors.add(tmpElement);
			tmpElement = tmpElement.getOwner();
			// First owner of connection reference is connection instance
			if (tmpElement instanceof ConnectionInstance) {
				tmpElement = tmpElement.getOwner();
			}
		}

		// Connection reference
		final Map<Object, BusinessObjectNode> nodes = getEnableAncestorNodes(boTree, ancestors, tmpElement);

		// Enable source and destination nodes
		enableAncestorNodes(nodes, cr.getSource());
		enableAncestorNodes(nodes, cr.getDestination());
	}

	// Find ancestors and create if necessary
	private void enableAncestorNodes(final Map<Object, BusinessObjectNode> nodes, final Element ancestor) {
		final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<Element>());
		populateAncestorsQueue(nodes, ancestors, ancestor);
		enableAncestorNodes(nodes, ancestors, ancestors.poll());
	}

	// Gets the first element ancestor that is enabled
	private void populateAncestorsQueue(final Map<Object, BusinessObjectNode> nodes, final Queue<Element> ancestors,
			Element ancestor) {
		while (!nodes.containsKey(ancestor)) {
			ancestors.add(ancestor);
			ancestor = ancestor.getOwner();
		}

		ancestors.add(ancestor);
	}

	// Create ancestor nodes
	private void enableAncestorNodes(final Map<Object, BusinessObjectNode> ancestorToNode,
			final Queue<Element> ancestors, final Element ancestor) {
		BusinessObjectNode ancestorNode = (BusinessObjectNode) ancestorToNode.get(ancestor);
		for (final Element ancestorToEnable : ancestors) {
			final RelativeBusinessObjectReference ancestorRef = getRelativeBusinessObjectReference(ancestorToEnable);
			final BusinessObjectNode tmpNode = ancestorNode.getChild(ancestorRef);
			ancestorNode = tmpNode == null ? createNode(ancestorNode, ancestorRef, ancestorToEnable) : tmpNode;
		}
	}

	// Create ancestor nodes
	private Map<Object, BusinessObjectNode> getEnableAncestorNodes(final BusinessObjectNode boTree,
			final Queue<Element> ancestors,
			final Element ancestor) {
		final Map<Object, BusinessObjectNode> boToAncestorNodes = new HashMap<Object, BusinessObjectNode>();
		BusinessObjectNode ancestorNode = boTree.getChild(getRelativeBusinessObjectReference(ancestor));
		boToAncestorNodes.put(ancestorNode.getBusinessObject(), ancestorNode);
		for (final Element ancestorToEnable : ancestors) {
			final RelativeBusinessObjectReference ancestorRef = getRelativeBusinessObjectReference(ancestorToEnable);
			final BusinessObjectNode tmpNode = ancestorNode.getChild(ancestorRef);
			ancestorNode = tmpNode == null ? createNode(ancestorNode, ancestorRef, ancestorToEnable) : tmpNode;
			boToAncestorNodes.put(ancestorNode.getBusinessObject(), ancestorNode);
		}

		return boToAncestorNodes;
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

	private SimpleEntry<Optional<ComponentClassifier>, BusinessObjectNode> getClassifierToConnectionEnd(
			BusinessObjectNode node) {
		BusinessObjectNode connectionEnd = node;
		for (; node != null; node = node.getParent()) {
			final Optional<ComponentClassifier> classifierOpt = AadlClassifierUtil.getComponentClassifier(node);
			if (classifierOpt.isPresent()) {
				return new AbstractMap.SimpleEntry<Optional<ComponentClassifier>, BusinessObjectNode>(classifierOpt,
						connectionEnd);
			}

			connectionEnd = node;
		}

		return new AbstractMap.SimpleEntry<Optional<ComponentClassifier>, BusinessObjectNode>(Optional.empty(),
				connectionEnd);
	}

	private void enableSelectedElementConnections(final ComponentImplementation ci,
			final BusinessObjectNode selectedNode) {
		ci.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
			if (enabledConnectionEnds(selectedNode, con.getAllDestinationContext(), con.getAllSourceContext(), con.getSource(),
					con.getDestination())
					|| enabledConnectionEnds(selectedNode, con.getAllSourceContext(), con.getAllDestinationContext(),
							con.getDestination(), con.getSource())) {
				enableConnection(con, selectedNode);
			}
		});
	}

	private void enableConnection(final Connection con, final BusinessObjectNode parent) {
		final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
		final BusinessObjectNode conNode = parent.getChild(conRef);
		if (conNode == null) {
			createNode(parent, conRef, con);
		}
	}

	private boolean enabledConnectionEnds(final BusinessObjectNode selectedNode, final Context context1,
			final Context context2, final ConnectedElement connectedElement1, final ConnectedElement connectedElement2) {
		if (context1 == null || !(context1 instanceof Subcomponent)) {
			if (context2 != null) {
				final RelativeBusinessObjectReference contextRef = getRelativeBusinessObjectReference(context2);
				BusinessObjectNode contextNode = selectedNode.getChild(contextRef);
				if (contextNode == null) {
					contextNode = createNode(selectedNode, contextRef, context2);
				}

				enableConnectedElements(contextNode, connectedElement1);
			}
			enableConnectedElements(selectedNode, connectedElement2);

			return true;
		}

		return false;
	}

	private void enableComponentImplementationConnections(final ComponentImplementation compImpl,
			final BusinessObjectNode parent, final BusinessObjectNode selectedNode) {
		compImpl.getAllConnections().stream().map(Connection::getRootConnection).forEach(con -> {
			if (isConnectedToSubcomponent(con.getAllDestinationContext(), selectedNode, con.getDestination(), parent,
					con.getAllSourceContext(), con.getSource())
					|| isConnectedToSubcomponent(con.getAllSourceContext(), selectedNode, con.getSource(), parent,
							con.getAllDestinationContext(), con.getDestination())) {
				enableConnection(con, parent);
			}
		});
	}

	private boolean isConnectedToSubcomponent(final Context context1, final BusinessObjectNode selectedNode,
			final ConnectedElement connectedElement1, final BusinessObjectNode parent, final Context context2,
			final ConnectedElement connectedElement2) {
		if (context1 == selectedNode.getBusinessObject()) {
			enableConnectedElements(selectedNode, connectedElement1);

			BusinessObjectNode context = parent;
			if (context2 != null) {
				// Enable context node
				final RelativeBusinessObjectReference srcContextRef = getRelativeBusinessObjectReference(context2);
				context = parent.getChild(srcContextRef);
				if (context == null) {
					context = createNode(parent, srcContextRef, context2);
				}
			}

			enableConnectedElements(context, connectedElement2);
			return true;
		}

		return false;
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
	 * Get and create selected node and ancestors
	 */
	private BusinessObjectNode getSelectedNode(BusinessObjectNode ancestorNode, BusinessObjectContext selectedBoc) {
		final Queue<Object> ancestors = Collections.asLifoQueue(new LinkedList<Object>());
		while (selectedBoc.getBusinessObject() != null) {
			ancestors.add(selectedBoc.getBusinessObject());
			selectedBoc = selectedBoc.getParent();
		}

		// Find ancestors to parent
		for (final Object ancestor : ancestors) {
			ancestorNode = getAncestor(ancestor, ancestorNode);
		}

		return ancestorNode;
	}

	private BusinessObjectNode getAncestor(final Object ancestor, final BusinessObjectNode parent) {
		final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(ancestor);
		final BusinessObjectNode node = parent.getChild(ref);
		// Enable ancestor node if necessary
		return node == null ? createNode(parent, ref, ancestor) : node;
	}

	// Check if connection end matches selected element
	private static boolean connectionEndFound(Element connectionEnd, final InstanceObject selectedConnectionEnd) {
		while (!(connectionEnd instanceof ComponentInstance)) {
			if (connectionEnd == selectedConnectionEnd) {
				return true;
			}
			connectionEnd = connectionEnd.getOwner();
		}

		return false;
	}

	private static BusinessObjectNode createNode(final BusinessObjectNode container,
			final RelativeBusinessObjectReference ref, final Object bo) {
		return new BusinessObjectNode(container, UUID.randomUUID(), ref, bo, Completeness.UNKNOWN, false);
	}

	// Eligible Subcomponents and ConnectionEnds
	private static boolean isSubcomponentOrConnectionEnd(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return (Subcomponent.class.isInstance(bo)/* && ((Subcomponent) bo).getComponentImplementation() != null */)
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
