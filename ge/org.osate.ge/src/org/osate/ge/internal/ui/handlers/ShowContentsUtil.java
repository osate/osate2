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
package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.ContentFilter;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.diagram.runtime.updating.FutureElementInfo;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.ContentFilterUtil;
import org.osate.ge.services.ReferenceBuilderService;

import com.google.common.collect.ImmutableSet;

/**
 * Contains utility functions related to adding child diagram elements for business objects which match content filters
 *
 */
final class ShowContentsUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private ShowContentsUtil() {
	}

	/**
	 * Adds contents to the selected diagram elements. Adds all children which pass the specified filter.
	 * @param event is the ExecutionEvent of the handler which provides the active editor.
	 * @param filters determines the filters to apply to the selected elements.
	 */
	public static void addContentsToSelectedElements(final ExecutionEvent event,
			final Function<DiagramElement, ImmutableSet<ContentFilter>> filters) {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final InternalDiagramEditor diagramEditor = (InternalDiagramEditor) activeEditor;

		final ExtensionRegistryService extService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ExtensionRegistryService.class), "Unable to retrieve extension service");
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = diagramEditor.getDiagram();
		if (diagram == null) {
			throw new RuntimeException("Unable to retrieve diagram");
		}

		final DiagramUpdater diagramUpdater = Objects.requireNonNull(diagramEditor.getDiagramUpdater(),
				"Unable to retrieve diagram updater");

		final ReferenceBuilderService referenceBuilder = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ReferenceBuilderService.class),
				"Unable to retrieve reference builder service");

		if (addChildrenDuringNextUpdate(selectedDiagramElements, diagramUpdater, extService, referenceBuilder,
				filters)) {
			diagramEditor.getActionExecutor().execute("Show Contents", ExecutionMode.NORMAL, () -> {
				diagramEditor.updateDiagram();
				return null;
			});
		}
	}


	/**
	 * Adds children of the specified diagram elements to the list of elements which will be added during the next diagram update.
	 * @return whether children were added to the diagram.
	 */
	private static boolean addChildrenDuringNextUpdate(final List<DiagramElement> diagramElements,
			final DiagramUpdater diagramUpdater, final ExtensionRegistryService extService,
			final ReferenceBuilderService referenceBuilder,
			final Function<DiagramElement, ImmutableSet<ContentFilter>> filters) {
		boolean childrenAdded = false;
		final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extService);
		for (final DiagramElement selectedElement : diagramElements) {
			final ImmutableSet<ContentFilter> contentFilters = filters.apply(selectedElement);
			if (!contentFilters.isEmpty()) {
				for (final Object childBo : bopHelper.getChildBusinessObjects(selectedElement)) {
					final RelativeBusinessObjectReference relativeReference = referenceBuilder
							.getRelativeReference(childBo);
					if (relativeReference != null
							&& selectedElement.getChildByRelativeReference(relativeReference) == null
							&& ContentFilterUtil.passesAnyContentFilter(childBo, contentFilters)) {
						diagramUpdater.addToNextUpdate(selectedElement, relativeReference, new FutureElementInfo());
						childrenAdded = true;
					}
				}
			}
		}

		return childrenAdded;
	}

}
