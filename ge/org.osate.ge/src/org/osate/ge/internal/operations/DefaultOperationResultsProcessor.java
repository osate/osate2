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
package org.osate.ge.internal.operations;

import java.util.Map.Entry;
import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.layout.IncrementalLayoutMode;
import org.osate.ge.internal.diagram.runtime.layout.LayoutPreferences;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.diagram.runtime.updating.FutureElementInfo;
import org.osate.ge.internal.model.EmbeddedBusinessObject;

/**
 * A results processor which is intended to be used with diagrams.
 * Processes results so that business objects will be added to the diagram during the next update based on hints from the results.
 *
 */
public class DefaultOperationResultsProcessor implements OperationExecutor.ResultsProcessor {
	private final DiagramUpdater diagramUpdater;
	private final DiagramNode targetNode;
	private final Point targetPosition;

	/**
	 *
	 * @param diagramUpdater
	 * @param refBuilder
	 * @param targetNode is the node to which the targetPosition is relative.
	 * @param targetPosition
	 */
	public DefaultOperationResultsProcessor(final DiagramUpdater diagramUpdater,
			final DiagramNode targetNode, final Point targetPosition) {
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.targetNode = targetNode;
		this.targetPosition = targetPosition;
	}

	public DefaultOperationResultsProcessor(final DiagramUpdater diagramUpdater) {
		this(diagramUpdater, null, null);
	}

	@Override
	public void processResults(final OperationResults results) {
		// Notify the diagram updater to add the element on the next update
		for (final Entry<BusinessObjectContext, OperationResults.BusinessObjectToShowDetails> containerToBoEntry : results
				.getContainerToBoToShowDetailsMap().entries()) {
			if (containerToBoEntry.getKey() instanceof DiagramNode) {
				final DiagramNode containerNode = (DiagramNode) containerToBoEntry.getKey();
				final OperationResults.BusinessObjectToShowDetails newValue = containerToBoEntry.getValue();

				// Don't set the position if multiple items are being added.
				// Don't set the position if the incremental layout mode is set to diagram.
				// This will ensure the shape is layed out even if it is a docked shape.
				final Point position;
				if (results.getContainerToBoToShowDetailsMap().size() == 1
						&& LayoutPreferences.getCurrentLayoutMode() != IncrementalLayoutMode.LAYOUT_DIAGRAM
						&& containerNode == targetNode) {
					position = targetPosition;
				} else {
					position = null;
				}

				// If the BO being added is an embedded business object, it must be provided to the diagram updater.
				final EmbeddedBusinessObject embeddedBo = (newValue.bo instanceof EmbeddedBusinessObject)
						? (EmbeddedBusinessObject) newValue.bo
								: null;

						diagramUpdater.addToNextUpdate(containerNode, newValue.ref,
								new FutureElementInfo(position, embeddedBo));
			}
		}
	}
}
