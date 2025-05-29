/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.transientviews;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.DiagramType;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.gef.DiagramRootNode;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.gef.ui.services.GefDiagramExportService;
import org.osate.ge.internal.businessobjecthandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutOptionsBuilder;
import org.osate.ge.internal.diagram.runtime.updating.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.updating.BusinessObjectNodeFactory;
import org.osate.ge.internal.diagram.runtime.updating.BusinessObjectTreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.Completeness;
import org.osate.ge.internal.diagram.runtime.updating.DefaultDiagramElementGraphicalConfigurationProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.DefaultColoringService;
import org.osate.ge.internal.services.impl.DefaultColoringService.StyleRefresher;
import org.osate.ge.internal.services.impl.DefaultReferenceService;
import org.osate.ge.internal.services.impl.SimpleActionExecutor;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;

/**
 * A transient view is a visualization of a business object tree which is not persisted. Views match the
 * structure and appearance of editable diagrams.
 *
 * The purpose of this class is to allow plugins to create JavaFX nodes for a non-persistent diagram from a tree of business objects.
 *
 * @since 1.1
 */
public final class TransientView {
	/**
	 * Diagram type used internally when creating a diagram. All diagrams must have a diagram type.
	 */
	private static class TransientViewDiagramType implements DiagramType {
		public static final String ID = "gef.transientView";

		@Override
		public String getId() {
			return ID;
		}

		@Override
		public String getName() {
			return "Transient View";
		}

		@Override
		public boolean isApplicableToContext(final Object contextBo) {
			return contextBo == null;
		}

		@Override
		public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
			return ImmutableSet.of();
		}

		@Override
		public ImmutableCollection<String> getDefaultAadlPropertyNames() {
			return ImmutableSet.of();
		}
	}

	/**
	 * The object which manages creating an updating the scene graph for the diagram
	 */
	private final GefAgeDiagram gefDiagram;

	/**
	 * Bidirectional mapping between the tree nodes specified in the constructor and the diagram nodes.
	 */
	private final BiMap<TransientViewTreeNode, DiagramNode> transientViewNodeToDiagramNodeMap;

	/**
	 * Creates a new instance which contains the business objects in the specified tree.
	 * @param tree the tree containing the business objects to visualize
	 * @see TransientView#TransientView(TransientViewTreeNode, Collection)
	 */
	public TransientView(final TransientViewTreeNode tree) {
		this(tree, Collections.emptyList());
	}

	/**
	 * Creates a new instance which contains the business objects in the specified tree and which uses the specified
	 * business object handlers in addition to the registered business object handlers.
	 * In cases where both a registered and a specified business object handler is applicable, the one specified is
	 * used.
	 * If a business object is encountered that does not have a business object handler available, an exception will be thrown.
	 * @param tree the tree containing the business objects to visualize
	 * @param additionalBusinessObjectHandlers additional business object handlers which should be used for the transient view.
	 */
	public TransientView(final TransientViewTreeNode tree,
			final Collection<BusinessObjectHandler> additionalBusinessObjectHandlers) {
		Objects.requireNonNull(tree, "treeRoot must not be null");
		Objects.requireNonNull(additionalBusinessObjectHandlers, "additionalBusinessObjectHandlers must not be null");

		// Create the business object provider which delegates the the extension registry if none of the
		// specified business object handlers are applicable
		final IEclipseContext eclipseContext = EclipseContextFactory
				.getServiceContext(FrameworkUtil.getBundle(GefDiagramExportService.class).getBundleContext());
		final ExtensionRegistryService extensionRegistry = Objects.requireNonNull(
				eclipseContext.get(ExtensionRegistryService.class), "Unable to retrieve extension registry");
		final BusinessObjectHandlerProvider bohProvider = bo -> {
			final IsApplicableContext ctx = new IsApplicableContext(bo);
			for (final BusinessObjectHandler boh : additionalBusinessObjectHandlers) {
				if (boh.isApplicable(ctx)) {
					return boh;
				}
			}
			return extensionRegistry.getApplicableBusinessObjectHandler(bo);
		};

		// Create a reference service which uses the business object handler and instantiate remaining objects which are needed
		// to create the diagram
		final ReferenceService referenceService = new DefaultReferenceService(bohProvider);
		final SimpleActionExecutor actionExecutor = new SimpleActionExecutor();
		final QueryService queryService = new DefaultQueryService(referenceService);
		final BusinessObjectNodeFactory nodeFactory = new BusinessObjectNodeFactory(referenceService);

		// Create the business object node tree needed by the diagram updater to build the diagram using the specified tree
		final Map<BusinessObjectNode, TransientViewTreeNode> bonToTransientNodeMap = new HashMap<>();
		final BusinessObjectNode boTree = transientViewNodeToBusinessObjectNode(null, tree, nodeFactory,
				bonToTransientNodeMap);

		// Create the diagram and diagram updater
		final AgeDiagram diagram = new AgeDiagram();
		final BusinessObjectTreeUpdater boTreeUpdater = (configuration, oldTree) -> boTree;
		final DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(
				queryService, () -> diagram, bohProvider);
		final DiagramUpdater diagramUpdater = new DiagramUpdater(boTreeUpdater, deInfoProvider, actionExecutor,
				(bo) -> null, referenceService);

		// Initialize the diagram.
		diagram.modify("Configure and Update Diagram", m -> {
			m.setDiagramConfiguration(new DiagramConfigurationBuilder(new TransientViewDiagramType(), true).build());
			diagramUpdater.updateDiagram(diagram);
		});

		// Build the mapping between transient tree nodes and diagram nodes
		this.transientViewNodeToDiagramNodeMap = buildTransientViewNodeToDiagramNodeMap(boTree, diagram,
				bonToTransientNodeMap, HashBiMap.create());

		// Set the style of the diagram elements to match the styles specified in tree
		diagram.modify("Set Style", m -> {
			for (final Entry<TransientViewTreeNode, DiagramNode> e : transientViewNodeToDiagramNodeMap.entrySet()) {
				if (e.getValue() instanceof DiagramElement) {
					m.setStyle((DiagramElement) e.getValue(), e.getKey().getStyle());
				}
			}
		});

		// Create the GEF Age Diagram. This will create the scene nodes and will layout the diagram when it is added
		// to a Java FX scene graph
		this.gefDiagram = new GefAgeDiagram(diagram, new DefaultColoringService(new StyleRefresher() {
			@Override
			public void refreshDiagramColoring() {
				// No-op. Handling coloring service refresh requests is not required.
			}

			@Override
			public void refreshColoring(final Collection<DiagramElement> diagramElements) {
				// No-op. Handling coloring service refresh requests is not required.
			}
		}));

		// Register a listener which will layout the diagram when it is attached to the scene.
		// This listener is unregistered after the first execution.
		final ChangeListener<Scene> sceneSetListener = new ChangeListener<Scene>() {
			@Override
			public void changed(final ObservableValue<? extends Scene> observable, final Scene oldValue,
					final Scene newValue) {
				if (newValue != null) {
					gefDiagram.updateDiagramFromSceneGraph(false);

					DiagramElementLayoutUtil.layout("Layout", diagram, gefDiagram, new LayoutOptionsBuilder().build());

					// Remove the listener
					gefDiagram.getSceneNode().sceneProperty().removeListener(this);
				}
			}
		};


		gefDiagram.getSceneNode().sceneProperty().addListener(sceneSetListener);
	}

	/**
	 * Builds a mapping between transient view nodes and diagram nodes by using the business object node tree that was created
	 * from the transient view nodes.
	 * @param bon the business object node
	 * @param dn the corresponding diagram node
	 * @param bonToTransientViewNodeMap a mapping between business object nodes and transient view tree nodes
	 * @param result the map being populated.
	 * @return the result
	 */
	private static BiMap<TransientViewTreeNode, DiagramNode> buildTransientViewNodeToDiagramNodeMap(
			final BusinessObjectNode bon, final DiagramNode dn,
			final Map<BusinessObjectNode, TransientViewTreeNode> bonToTransientViewNodeMap,
			final BiMap<TransientViewTreeNode, DiagramNode> result) {
		result.put(bonToTransientViewNodeMap.get(bon), dn);
		for (final BusinessObjectNode bonChild : bon.getChildren()) {
			final DiagramNode dnChild = dn.getChildByRelativeReference(bonChild.getRelativeReference());
			if (dnChild != null) {
				buildTransientViewNodeToDiagramNodeMap(bonChild, dnChild, bonToTransientViewNodeMap, result);
			}
		}
		return result;
	}

	/**
	 * Creates a {@link BusinessObjectNode} from a {@link TransientViewTreeNode}.
	 * @param parent the parent of the new {@link BusinessObjectNode}
	 * @param n the {@link TransientViewTreeNode} from which the {@link BusinessObjectNode} is being created
	 * @param nodeFactory the factory used to create the {@link BusinessObjectNode}
	 * @param bonToTransientNodeMap a map to populate with the mapping between nodes
	 * @return the new {@link BusinessObjectNode}
	 */
	private static BusinessObjectNode transientViewNodeToBusinessObjectNode(final BusinessObjectNode parent,
			final TransientViewTreeNode n,
			final BusinessObjectNodeFactory nodeFactory,
			final Map<BusinessObjectNode, TransientViewTreeNode> bonToTransientNodeMap) {
		final BusinessObjectNode newNode = nodeFactory.create(parent, UUID.randomUUID(), n.getBusinessObject(),
				Completeness.COMPLETE);
		bonToTransientNodeMap.put(newNode, n);
		for (final var child : n.getChildren()) {
			transientViewNodeToBusinessObjectNode(newNode, child, nodeFactory, bonToTransientNodeMap);
		}
		return newNode;
	}

	/**
	 * Returns the root JavaFX scene node for the view. This is the node that should be added to the scene graph.
	 * @return the root scene node for the view.
	 */
	public DiagramRootNode getRootSceneNode() {
		return gefDiagram.getSceneNode();
	}

	/**
	 * Returns the scene node for the transient view tree node which was used to create it.
	 * The returned scene node is a descendant of the root scene node for the view.
	 * @param treeNode the tree node for which to return the scene node.
	 * @return the scene node. Returns null if a scene node was not created for the specified tree node.
	 * @see #getRootSceneNode()
	 */
	public Node getSceneNode(final TransientViewTreeNode treeNode) {
		final DiagramNode dn = this.transientViewNodeToDiagramNodeMap.get(treeNode);
		return gefDiagram.getSceneNode(dn);
	}

	/**
	 * Returns the transient view tree node which was used to create the specified scene node.
	 * If the node does not have a tree node associated with it, the scene node's ancestors are checked
	 * until a tree node is found.
	 * @param sceneNode the scene node for which to return the tree node.
	 * @return the tree node which was used to created the specified node. Returns null if
	 * the transient tree node was not found.
	 */
	public TransientViewTreeNode getTransientViewTreeNode(final Node sceneNode) {
		// Walk up scene graph as necessary and find the transient view tree node
		for (Node tmp = sceneNode; tmp != null; tmp = tmp.getParent()) {
			final DiagramElement de = gefDiagram.getDiagramElement(tmp);
			final var tn = transientViewNodeToDiagramNodeMap.inverse().get(de);
			if (tn != null) {
				return tn;
			}
		}

		return null;
	}
}
