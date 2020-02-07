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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
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
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.dialogs.DiagramConfigurationDialog;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;

public class ShowConnectedElementsHandler extends AbstractHandler {
	private ProjectReferenceService referenceService;

	@Override
	public void setEnabled(final Object evaluationContext) {
		// Connection Ends?
		// setBaseEnabled(AgeHandlerUtil.getSelectedBusinessObjectContexts().stream()
		// .filter(boc -> isConnectionEnd(boc)).findAny().isPresent());
		setBaseEnabled(true);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Feature selected, go up until componentImpl.hasconnections go down
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
				// If selectedElement.getBo instanceof
				if (selectedElement.getBusinessObject() instanceof ConnectionEnd) {
					// Could be certain subcomponents better to check if sub or ce first?
					// Go up two parents if you can // assume you can with subcomponents, get connections
					// For features go up two also consider featuregroups // go up until CI and then parent of that?
					// Also make sure they exist
					// Can select outline view
					// For subcomponent CES do not go up two
					if (selectedElement.getBusinessObject() instanceof Subcomponent) {

					} else {

					}

				} else if (selectedElement.getBusinessObject() instanceof Subcomponent) { // could also be a connection end
					System.err.println(
							getParentNode(boTree, selectedElement.getParent()).getBusinessObject() + " getParentNode");
					// Check 1 parent up connections to selectedElement
					// System.err.println(getParentNode(boTree, selectedElement.getParent()) + " getParentNode");
					// Check connections in parent CI
					final BusinessObjectNode parent = getParentNode(boTree, selectedElement.getParent());
					final ComponentImplementation parentCi = AadlClassifierUtil.getComponentImplementation(parent)
							.orElseThrow(() -> new RuntimeException("Component Implementation cannot be null."));
					final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(
							selectedElement.getBusinessObject());
					if (parent.getChild(ref) == null) {
						createNode(parent, ref, selectedElement.getBusinessObject());
					}

					final BusinessObjectNode selectedNode = parent.getChild(ref);

					parentCi.getAllConnections().forEach(con -> {
						// System.err.println(con);
						// Con dst or src context should be selectedElement
						System.err.println(con + " con");
						System.err.println(con.getAllDestination() + " allDest");
						System.err.println(con.getAllLastDestination() + " getAllLastDest");
						System.err.println(con.getAllDestinationContext() + " allDestContext");
						System.err.println(con.getAllSource() + " allSource");
						System.err.println(con.getAllLastSource() + " getAllLastSrouce");
						System.err.println(con.getAllSourceContext() + " allSourceContext");
						if(con.getAllLastDestination() instanceof Feature) {
							Feature f = (Feature)con.getAllLastDestination();
							System.err.println(f + " feature");
							System.err.println(f.getAllClassifier() + " getAllClassifier");
						}

						if (con.getAllLastSource() instanceof Feature) {
							Feature f = (Feature) con.getAllLastSource();
							System.err.println(f + " feature");
							// f.get
							System.err.println(f.getAllClassifier() + " getAllClassifier");
						}
						if (con.getAllDestinationContext() == selectedElement.getBusinessObject()) {
							final RelativeBusinessObjectReference dstRef = getRelativeBusinessObjectReference(
									con.getAllDestination());
							if (selectedNode.getChild(dstRef) == null) {
								// if its a featuregroup

								createNode(selectedNode, dstRef, con.getAllDestination());
							}

							final RelativeBusinessObjectReference srcRef = getRelativeBusinessObjectReference(
									con.getAllSource());
							if (con.getAllSourceContext() == null) {
								// It's in parent
								if (parent.getChild(srcRef) == null) {
									createNode(parent, srcRef, con.getAllSource());
								}
							} else {
								// Create context bo in parent
								final RelativeBusinessObjectReference srcContextRef = getRelativeBusinessObjectReference(
										con.getAllSourceContext());
								BusinessObjectNode contextNode = parent.getChild(srcContextRef);
								if (contextNode == null) {
									contextNode = createNode(parent, srcContextRef, con.getAllSourceContext());
								}

								if (contextNode.getChild(srcRef) == null) {
									createNode(contextNode, srcRef, con.getAllSource());
								}
							}

							final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
							if (parent.getChild(conRef) == null) {
								createNode(parent, conRef, con);
							}

						} else if (con.getAllSourceContext() == selectedElement.getBusinessObject()) {
							final RelativeBusinessObjectReference srcRef = getRelativeBusinessObjectReference(
									con.getAllSource());
							if (selectedNode.getChild(srcRef) == null) {
								createNode(selectedNode, srcRef, con.getAllSource());
							}

							final RelativeBusinessObjectReference dstRef = getRelativeBusinessObjectReference(
									con.getAllDestination());
							if (con.getAllDestinationContext() == null) {
								// It's in parent
								if (parent.getChild(dstRef) == null) {
									createNode(parent, dstRef, con.getAllDestination());
								}
							} else {
								// Create context bo in parent
								final RelativeBusinessObjectReference dstContextRef = getRelativeBusinessObjectReference(
										con.getAllDestinationContext());
								BusinessObjectNode contextNode = parent.getChild(dstContextRef);
								if (contextNode == null) {
									contextNode = createNode(parent, dstContextRef, con.getAllDestinationContext());
								}

								if (contextNode.getChild(dstRef) == null) {
									createNode(contextNode, dstRef, con.getAllDestination());
								}
							}

							final RelativeBusinessObjectReference conRef = getRelativeBusinessObjectReference(con);
							if (parent.getChild(conRef) == null) {
								createNode(parent, conRef, con);
							}

						}
					});

					// Check connections in selected CI
					// AadlClassifierUtil.getComponentImplementation(selectedElement);

					// } else if (selectedElement.getBusinessObject() instanceof ComponentInstance) { // Also a connectionEndInstance
					// .getSubcomponent not null
				} else if (selectedElement.getBusinessObject() instanceof ConnectionInstanceEnd) {
					if (selectedElement.getBusinessObject() instanceof ComponentInstance) {

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
		// final Connection connection = null;
		// connection.getAllSource()

		return null;
	}

	private void enable() {

	}

	// Create ancestor nodes
//	private void enableAncestorNodes(final Map<Object, Queryable> descendantBoToQueryable,
//			final Queue<Element> ancestors, final Element ancestor) {
//		BusinessObjectNode ancestorNode = (BusinessObjectNode) descendantBoToQueryable.get(ancestor);
//		for (final Element ancestorToEnable : ancestors) {
//			final RelativeBusinessObjectReference ancestorRef = getRelativeBusinessObjectReference(ancestorToEnable);
//			if (ancestorNode.getChild(ancestorRef) == null) {
//				ancestorNode = createNode(ancestorNode, ancestorRef, ancestorToEnable);
//			}
//		}
//	}

	/**
	 * Get the selected mode parent node and create ancestor nodes if necessary
	 */
	private BusinessObjectNode getParentNode(BusinessObjectNode parent, BusinessObjectContext selectedModeParent) {
		final Queue<Object> ancestors = Collections.asLifoQueue(new LinkedList<Object>());
		while (selectedModeParent.getBusinessObject() != null) {
			ancestors.add(selectedModeParent.getBusinessObject());
			selectedModeParent = selectedModeParent.getParent();
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

	private static ComponentImplementation getParent(BusinessObjectContext boc) {
		Optional<ComponentImplementation> ci = null;
//		for (ci = AadlClassifierUtil.getComponentImplementation(boc); !ci
//				.isPresent(); boc = boc.getParent()) {
//			System.err.println(boc.getBusinessObject() + " boc");
//			ci = AadlClassifierUtil.getComponentImplementation(boc);
//			// if boc.getbo == null throw exception?
//		}

		// while (!(boc.getBusinessObject() instanceof Subcomponent
		// || boc.getBusinessObject() instanceof ComponentImplementation)) {

		// }

		return ci.orElseThrow(() -> new RuntimeException("Cannot find component implementation"));
	}

	private static BusinessObjectNode createNode(final BusinessObjectNode container,
			final RelativeBusinessObjectReference ref, final Object bo) {
		return new BusinessObjectNode(container, UUID.randomUUID(), ref, bo, Completeness.UNKNOWN, false);
	}

	// TODO check if this works on instance model, should be disabled for non subcomponents
	// TODO componentInstance.getSubcomponent returns null or not a subcomponent?
	private static boolean isSubcomponentOrConnectionEnd(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return Subcomponent.class.isInstance(bo)
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

	/*
	 * ci.getAllConnections().stream().map(con -> {
	 * System.err.println(con + " con");
	 * if (con.getAllDestination() == connectionEnd) {
	 * // Find source if dest is selected
	 * final Context context = con.getAllSourceContext();
	 * System.err.println(con.getAllSourceContext() + " getAllsourceContext");
	 * m.put(con, context);
	 * }
	 *
	 * if (con.getAllSource() == connectionEnd) {
	 * // Find dest if source is selected
	 * final Context context = con.getAllDestinationContext();
	 * // ensureChildExists(connection);
	 * //con.getAllDestinationContext()
	 * System.err.println(con.getAllDestinationContext() + " getAlldestContext");
	 * m.put(con, context);
	 * }
	 * return null;
	 * }).collect(Collectors.toList());
	 *
	 *
	 *
	 * ci.getAllConnections().forEach(con -> {
	 * if (con.getAllDestination() == connectionEnd) {
	 * // Find source if dest is selected
	 * final Context context = con.getAllSourceContext();
	 * }
	 *
	 * if (con.getAllSource() == connectionEnd) {
	 * // Find dest if source is selected
	 * final Context context = con.getAllDestinationContext();
	 * // ensureChildExists(connection);
	 * //con.getAllDestinationContext()
	 * }
	 * });
	 */
}
