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

import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.layout.IncrementalLayoutMode;
import org.osate.ge.internal.diagram.runtime.layout.LayoutPreferences;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.diagram.runtime.updating.FutureElementInfo;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.operations.StepResult;
import org.osate.ge.services.ReferenceBuilderService;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * A results processor which is intended to be used with diagrams.
 * Processes results so that business objects will be added to the diagram during the next update based on hints from the results.
 *
 */
public class DefaultOperationResultsProcessor implements OperationExecutor.ResultsProcessor {
	private final DiagramUpdater diagramUpdater;
	private final ReferenceBuilderService refBuilder;
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
			final ReferenceBuilderService refBuilder, final DiagramNode targetNode, final Point targetPosition) {
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must nto be null");
		this.targetNode = targetNode;
		this.targetPosition = targetPosition;
	}

	public DefaultOperationResultsProcessor(final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder) {
		this(diagramUpdater, refBuilder, null, null);
	}

	@Override
	public void processResults(final List<StepResult<?>> results) {
		// Combine the container to BO to show multi-maps from all the results.
		final Multimap<DiagramNode, Object> containerToBoMap = ArrayListMultimap.create();
		for (final StepResult<?> result : results) {
			if (!(result instanceof DefaultStepResult)) {
				throw new RuntimeException(
						"All results must be created using StepResultBuilder. Unsupported result: " + result);
			}

			final DefaultStepResult<?> defaultStepResult = (DefaultStepResult<?>) result;
			for (final Entry<BusinessObjectContext, Object> containerToBoToShowEntry : defaultStepResult
					.getContainerToBoToShowMap().entries()) {
				final BusinessObjectContext container = containerToBoToShowEntry.getKey();
				final Object newBo = containerToBoToShowEntry.getValue();
				if (container instanceof DiagramNode) {
					final DiagramNode containerNode = (DiagramNode) container;
					containerToBoMap.put(containerNode, newBo);
				}
			}
		}

		// Notify the diagram updater to add the element on the next update
		for (final Entry<DiagramNode, Object> containerToBoEntry : containerToBoMap.entries()) {
			final DiagramNode containerNode = containerToBoEntry.getKey();
			final Object newBo = containerToBoEntry.getValue();

			final RelativeBusinessObjectReference newRef = refBuilder.getRelativeReference(newBo);
			if (newRef != null) {
				// Don't set the position if multiple items are being added.
				// Don't set the position if the incremental layout mode is set to diagram.
				// This will ensure the shape is layed out even if it is a docked shape.
				final Point position;
				if (containerToBoMap.size() == 1
						&& LayoutPreferences.getCurrentLayoutMode() != IncrementalLayoutMode.LAYOUT_DIAGRAM
						&& containerNode == targetNode) {
					position = targetPosition;
				} else {
					position = null;
				}

				// If the BO being added is an embedded business object, it must be provided to the diagram updater.
				final EmbeddedBusinessObject embeddedBo = (newBo instanceof EmbeddedBusinessObject)
						? (EmbeddedBusinessObject) newBo
								: null;

						diagramUpdater.addToNextUpdate(containerNode, newRef,
						new FutureElementInfo(position, embeddedBo));
			}
		}
	}
}
