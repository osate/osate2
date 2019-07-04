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
