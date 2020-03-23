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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.ui.dialogs.RestoreMissingDiagramElementsDialog;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.BusinessObjectContextHelper;
import org.osate.ge.internal.util.BusinessObjectContextUtil;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Requires AADL Graphical Editor to be active
 */
public class RestoreMissingDiagramElementsHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get editor and various services
		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;
		final AgeFeatureProvider featureProvider = (AgeFeatureProvider) diagramEditor.getDiagramTypeProvider()
				.getFeatureProvider();
		final ProjectProvider projectProvider = (ProjectProvider) Objects
				.requireNonNull(diagramEditor.getAdapter(ProjectProvider.class), "Unable to retrieve project provider");
		final DiagramUpdater diagramUpdater = Objects.requireNonNull(featureProvider.getDiagramUpdater(),
				"Unable to retrieve diagram updater");
		final ExtensionService extService = (ExtensionService) Objects.requireNonNull(
				diagramEditor.getAdapter(ExtensionService.class), "Unable to retrieve extension service");

		final AgeDiagram diagram = diagramEditor.getAgeDiagram();

		final IEclipseContext serviceContext = EclipseContextFactory
				.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		final ReferenceService referenceService = Objects.requireNonNull(serviceContext.get(ReferenceService.class),
				"Unable to retrieve reference service");
		final LayoutInfoProvider layoutInfoProvider = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, LayoutInfoProvider.class), "Unable to retrieve layout info provider");
		final ActionService actionService = Objects.requireNonNull(Adapters.adapt(diagramEditor, ActionService.class),
				"Unable to retrieve action service");

		// Stores child business object contexts which are applicable for a given parent node
		final Multimap<DiagramNode, BusinessObjectContext> diagramNodeToAvailableBusinessObjectContextsMap = ArrayListMultimap
				.create();

		// Build a list of ghosts that will be presented to the user to modify
		final List<DiagramUpdater.GhostedElement> ghostsToModify = new ArrayList<>();

		try (final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService);
				final BusinessObjectContextHelper bocHelper = new BusinessObjectContextHelper(extService)) {
			// Walk all nodes and look for ghosts
			diagram.getAllDiagramNodes().forEachOrdered(parent -> {
				final Collection<DiagramUpdater.GhostedElement> ghosts = diagramUpdater.getGhosts(parent);
				if (!ghosts.isEmpty()) {
					final BusinessObjectContext parentToUse;
					if (diagram.getConfiguration().getContextBoReference() == null && parent.getParent() == null) {
						parentToUse = BusinessObjectContextUtil.getRootContextForProject(projectProvider);
					} else {
						parentToUse = parent;
					}

					// Create a mapping between relative reference and available child business objects
					final Map<RelativeBusinessObjectReference, Object> relRefToBusinessObjectMap = bopHelper
							.getChildBusinessObjects(parentToUse).stream().collect(HashMap::new, (map, bo) -> {
								final RelativeBusinessObjectReference relRef = referenceService
										.getRelativeReference(bo);
								if (relRef != null) {
									map.put(relRef, bo);
								}
							}, Map::putAll);

					// Remove any entries based on existing node relative references.
					parent.getDiagramElements()
					.forEach(de -> relRefToBusinessObjectMap.remove(de.getRelativeReference()));

					// Don't show ghosts if there aren't any unused business objects
					if (!relRefToBusinessObjectMap.isEmpty()) {
						// Store the ghosts and the available business objects
						relRefToBusinessObjectMap.values().stream().map(bo -> new BusinessObjectContext() {
							@Override
							public Collection<? extends Queryable> getChildren() {
								return Collections.emptyList();
							}

							@Override
							public BusinessObjectContext getParent() {
								return parent;
							}

							@Override
							public Object getBusinessObject() {
								return bo;
							}
						}).forEachOrdered(
								// type cast is needed to compile using maven/tycho
								// see https://github.com/osate/osate2/issues/976
								boc -> diagramNodeToAvailableBusinessObjectContextsMap.put(parent,
										(BusinessObjectContext) boc));
						ghostsToModify.addAll(ghosts);
					}
				}
			});

			// Show the dialog
			final RestoreMissingDiagramElementsDialog.Result<DiagramUpdater.GhostedElement, BusinessObjectContext> result = RestoreMissingDiagramElementsDialog
					.show(null,
							new RestoreMissingDiagramElementsDialog.Model<DiagramUpdater.GhostedElement, BusinessObjectContext>() {
						@Override
						public Collection<DiagramUpdater.GhostedElement> getElements() {
							return ghostsToModify;
						}

						@Override
						public String getParentLabel(final DiagramUpdater.GhostedElement element) {
							return UiUtil.getPathLabel(element.getParent());
						}

						@Override
						public String getMissingReferenceLabel(final DiagramUpdater.GhostedElement element) {
							final String label = referenceService.getLabel(element.getRelativeReference());
							return label == null ? element.getRelativeReference().toString() : label;
						}

						@Override
						public Collection<BusinessObjectContext> getAvailableBusinessObjects(
								final DiagramUpdater.GhostedElement element) {
							return diagramNodeToAvailableBusinessObjectContextsMap.get(element.getParent());
						}

						@Override
						public String getBusinessObjectLabel(final BusinessObjectContext boc) {
							return UiUtil.getDescription(boc, extService, bocHelper);
						}

					});

			if (result != null) {
				actionService.execute("Restore Missing Diagram Elements", ExecutionMode.NORMAL, () -> {
					// Update the ghosts and the diagram
					diagram.modify("Restore Missing Diagram Elements", m -> {
						result.getObjectToNewBoMap().forEach((ghost, newBoc) -> {
							final Object newBo = newBoc.getBusinessObject();
							ghost.updateBusinessObject(m, newBo, referenceService.getRelativeReference(newBo));
						});

						// Update the diagram
						diagramUpdater.updateDiagram(diagram);
					});

					diagram.modify("Layout",
							m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, layoutInfoProvider));

					return null;
				});
			}
		}

		return null;
	}
}
