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
