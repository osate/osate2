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
package org.osate.ge.internal.ui;

import java.util.Map.Entry;
import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.layout.IncrementalLayoutMode;
import org.osate.ge.internal.diagram.runtime.layout.LayoutPreferences;
import org.osate.ge.internal.diagram.runtime.updating.FutureElementInfo;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.operations.OperationResults;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;

/**
 * Utility class which processes {@link OperationResults} returned by {@link OperationExecutor}
 * Processes results so that business objects will be added to the diagram during the next update based on hints from the results.
 *
 */
public final class OperationResultsProcessor {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private OperationResultsProcessor() {
	}

	/**
	 * Process results
	 * @param editor the editor which is displaying the diagram for which the operation was executed
	 * @param results the results to process
	 */
	public static void processResults(final InternalDiagramEditor editor, final OperationResults results) {
		processResults(editor, null, null, results);
	}

	/**
	 *
	 * @param editor the editor which is displaying the diagram for which the operation was executed
	 * @param targetNode is the node to which the targetPosition is relative.
	 * @param targetPosition the position at which the operation was executed. Relative to the target node. This is used to position
	 * a newly created diagram element.
	 * @param results the results to process
	 */
	public static void processResults(final InternalDiagramEditor editor, final DiagramNode targetNode,
			final Point targetPosition, final OperationResults results) {
		Objects.requireNonNull(editor, "diagram must not be null");
		boolean update = false;

		// Notify the diagram updater to add the element on the next update
		for (final Entry<BusinessObjectContext, OperationResults.BusinessObjectToShowDetails> containerToBoEntry : results
				.getContainerToBoToShowDetailsMap()
				.entries()) {
			if (containerToBoEntry.getKey() instanceof DiagramNode) {
				final DiagramNode containerNode = (DiagramNode) containerToBoEntry.getKey();
				final OperationResults.BusinessObjectToShowDetails newValue = containerToBoEntry.getValue();

				// Don't set the position if multiple items are being added.
				// Don't set the position if the incremental layout mode is set to diagram.
				// This will ensure the shape is laid out even if it is a docked shape.
				final Point position;
				if (results.getContainerToBoToShowDetailsMap().size() == 1
						&& LayoutPreferences.getCurrentIncrementalLayoutMode() != IncrementalLayoutMode.LAYOUT_DIAGRAM
						&& containerNode == targetNode) {
					position = targetPosition;
				} else {
					position = null;
				}

				// If the BO being added is an embedded business object, it must be provided to the diagram updater.
				final EmbeddedBusinessObject embeddedBo = (newValue.bo instanceof EmbeddedBusinessObject)
						? (EmbeddedBusinessObject) newValue.bo
								: null;
				editor.getDiagramUpdater()
				.addToNextUpdate(containerNode, newValue.ref, new FutureElementInfo(position, embeddedBo));

				if (embeddedBo != null) {
					update = true;
				}
			}
		}

		// If an embedded business object was added, then update the diagram to ensure it was updated.
		if (update) {
			editor.updateDiagram();
		}
	}
}
