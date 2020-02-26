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
import java.util.Queue;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
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
import org.osate.ge.internal.util.AadlInstanceObjectUtil;
import org.osate.ge.internal.util.AadlModalElementUtil;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;

public class ShowElementsInModeHandler extends AbstractHandler {
	private ProjectReferenceService referenceService;

	@Override
	public void setEnabled(final Object evaluationContext) {
		// Modal element selected
		setBaseEnabled(AgeHandlerUtil.getSelectedBusinessObjectContexts().stream()
				.filter(de -> (isModal(de.getBusinessObject()))).findAny().isPresent());
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final AgeDiagramEditor editor = getAgeDiagramEditor(event);
		referenceService = Objects.requireNonNull(Adapters.adapt(editor, ProjectReferenceService.class),
				"Unable to retrieve reference service");
		final ExtensionService extService = Objects.requireNonNull(Adapters.adapt(editor, ExtensionService.class),
				"Unable to retrieve extension service");
		try (final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService)) {
			final AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
					.getFeatureProvider();
			final TreeUpdater boTreeExpander = featureProvider.getBoTreeUpdater();
			final BusinessObjectNode boTree = getBoTree((AgeDiagramEditor) editor, boTreeExpander);
			final List<BusinessObjectContext> selectedModes = AgeHandlerUtil.getSelectedBusinessObjectContexts()
					.stream().filter(de -> isModal(de.getBusinessObject())).collect(Collectors.toList());
			for (final BusinessObjectContext selectedMode : selectedModes) {
				enableInModeNodes(bopHelper, boTree, selectedMode);
			}

			final AgeDiagram diagram = editor.getAgeDiagram();
			final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
			final GraphitiService graphitiService = Objects.requireNonNull(
					Adapters.adapt(editor, GraphitiService.class), "Unable to retrieve graphiti service");

			final ActionService actionService = Objects.requireNonNull(Adapters.adapt(editor, ActionService.class),
					"Unable to retrieve action service");
			actionService.execute("Show Elements In Mode", ExecutionMode.NORMAL, () -> {
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

	private void enableInModeNodes(final BusinessObjectProviderHelper bopHelper, final BusinessObjectNode boTree,
			final BusinessObjectContext selectedMode) {
		final BusinessObjectNode parentNode = getParentNode(boTree, selectedMode.getParent());
		bopHelper.getChildBusinessObjects(parentNode).forEach(childBo -> {
			if (childBo instanceof ModalElement) {
				final ModeFeature modeFeature = getModeFeature(selectedMode);
				final List<ModeFeature> modeFeatures = AadlModalElementUtil
						.getAllInModesOrTransitions((ModalElement) childBo);
				// Enable if ModalElement is in selected mode
				enableInModeChild(bopHelper, modeFeatures, childBo, modeFeature, parentNode);
			} else if (childBo instanceof InstanceObject) {
				final ModalElement modalElement = AadlInstanceObjectUtil.getModalElement((InstanceObject) childBo);
				if (modalElement != null) {
					final List<ModeFeature> modeFeatures = AadlModalElementUtil
							.getAllInModesOrTransitions(modalElement);
					// Get ModeFeature from ModeInstance or ModeTransitionInstance
					final ModeFeature modeFeature = getModeFeature(selectedMode);
					// Enable if ModalElement is in selected mode
					enableInModeChild(bopHelper, modeFeatures, childBo, modeFeature, parentNode);
				} else if (childBo instanceof NamedElement
						&& !(childBo instanceof ModeInstance || childBo instanceof ModeTransitionInstance)) {
					// Child with no mode should be enabled
					enableChild(bopHelper, selectedMode, childBo, parentNode);
				}
			} else if (childBo instanceof NamedElement && !(childBo instanceof ModeFeature)) {
				// Child with no mode should be enabled
				enableChild(bopHelper, selectedMode, childBo, parentNode);
			}
		});
	}

	/**
	 * Get the mode feature of the selected BOC
	 */
	private static ModeFeature getModeFeature(final BusinessObjectContext selectedBoc) {
		if (selectedBoc.getBusinessObject() instanceof InstanceObject) {
			final Object modeFeatureInstance = selectedBoc.getBusinessObject();
			return modeFeatureInstance instanceof ModeInstance
					? ((ModeInstance) modeFeatureInstance).getMode()
							: ((ModeTransitionInstance) modeFeatureInstance).getModeTransition();
		}

		return (ModeFeature) selectedBoc.getBusinessObject();
	}

	private static boolean isModal(final Object ob) {
		return Mode.class.isInstance(ob) || ModeInstance.class.isInstance(ob) || ModeTransition.class.isInstance(ob)
				|| ModeTransitionInstance.class.isInstance(ob);
	}

	private void enableInModeChild(final BusinessObjectProviderHelper bopHelper,
			final List<ModeFeature> inModeFeatures, final Object child,
			final ModeFeature selectedModeFeature,
			final BusinessObjectNode parentNode) {
		if (inModeFeatures.isEmpty() || inModeFeatures.contains(selectedModeFeature)) {
			enableChild(bopHelper, selectedModeFeature, child, parentNode);
		}
	}

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

	private static AgeDiagramEditor getAgeDiagramEditor(final ExecutionEvent event) {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		return (AgeDiagramEditor) activeEditor;
	}

	/**
	 * Enable child node if necessary
	 */
	private void enableChild(final BusinessObjectProviderHelper bopHelper, final Object selectedMode,
			final Object bo,
			final BusinessObjectNode container) {
		final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(bo);
		final BusinessObjectNode childNode = container.getChild(ref);
		if (childNode == null) {
			final BusinessObjectNode node = createNode(container, ref, bo);
			// Show in mode feature group children
			if (bo instanceof FeatureGroup) {
				enableChildren(bopHelper, selectedMode, node);
			}
		} else if (childNode.getBusinessObject() instanceof FeatureGroup) {
			enableChildren(bopHelper, selectedMode, childNode);
		}
	}

	private void enableChildren(final BusinessObjectProviderHelper bopHelper, final Object selectedMode,
			final BusinessObjectNode node) {
		for (final Object childBo : bopHelper.getChildBusinessObjects(node)) {
			final RelativeBusinessObjectReference ref = getRelativeBusinessObjectReference(childBo);
			final BusinessObjectNode childNode = node.getChild(ref);
			if (childNode == null) {
				if (childBo instanceof ModalElement) {
					final ModalElement modalElement = (ModalElement) childBo;
					final List<ModeFeature> inModeFeatures = AadlModalElementUtil.getAllInModesOrTransitions(modalElement);
					if (inModeFeatures.isEmpty() || inModeFeatures.contains(selectedMode)) {
						enableChild(bopHelper, selectedMode, childBo, node);
					}
				} else {
					enableChild(bopHelper, selectedMode, childBo, node);
				}
				enableChildren(bopHelper, selectedMode, node.getChild(ref));
			}
		}
	}

	private static BusinessObjectNode createNode(final BusinessObjectNode container,
			final RelativeBusinessObjectReference ref, final Object bo) {
		return new BusinessObjectNode(container, UUID.randomUUID(), ref, bo, Completeness.UNKNOWN, false);
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
