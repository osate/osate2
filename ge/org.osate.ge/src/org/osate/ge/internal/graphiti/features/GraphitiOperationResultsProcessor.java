package org.osate.ge.internal.graphiti.features;

import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.operations.DefaultOperationResultsProcessor;
import org.osate.ge.internal.operations.DefaultStepResult;
import org.osate.ge.operations.StepResult;
import org.osate.ge.services.ReferenceBuilderService;

public class GraphitiOperationResultsProcessor extends DefaultOperationResultsProcessor {
	private final Diagram diagram;
	private final IFeatureProvider featureProvider;

	public GraphitiOperationResultsProcessor(final Diagram diagram, final IFeatureProvider featureProvider,
			final DiagramUpdater diagramUpdater, final ReferenceBuilderService refBuilder, final DiagramNode targetNode,
			final Point targetPosition) {
		super(diagramUpdater, refBuilder, targetNode, targetPosition);
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		this.featureProvider = Objects.requireNonNull(featureProvider, "featureProvider must not be null");
	}

	public GraphitiOperationResultsProcessor(final Diagram diagram, final IFeatureProvider featureProvider,
			final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder) {
		this(diagram, featureProvider, diagramUpdater, refBuilder, null, null);
	}

	@Override
	public void processResults(final List<StepResult<?>> results) {
		super.processResults(results);

		if (shouldUpdateDiagram(results)) {
			final IUpdateContext uc = new UpdateContext(diagram);
			featureProvider.getUpdateFeature(uc).update(uc);
		}
	}

	/**
	 * Returns true if the results processor needs to manually update the diagram.
	 * This should be done if an embedded business object was created. In that case, the model change listeners won't be notified.
	 * @param results
	 * @return
	 */
	private boolean shouldUpdateDiagram(final List<StepResult<?>> results) {
		for (final StepResult<?> result : results) {
			if (!(result instanceof DefaultStepResult)) {
				throw new RuntimeException(
						"All results must be created using StepResultBuilder. Unsupported result: " + result);
			}

			final DefaultStepResult<?> defaultStepResult = (DefaultStepResult<?>) result;
			for (final Entry<BusinessObjectContext, Object> containerToBoToShowEntry : defaultStepResult
					.getContainerToBoToShowMap().entries()) {
				final Object newBo = containerToBoToShowEntry.getValue();
				if (newBo instanceof EmbeddedBusinessObject) {
					return true;
				}
			}
		}

		return false;
	}
}
