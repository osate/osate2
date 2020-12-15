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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.osate.ge.DockingPosition;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.diagram.runtime.AgeDiagramUtil;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * ICreateFeature implementation that delegates behavior to a {@link org.osate.ge.na.TargetedPaletteCommand.CreatePaletteCommand}
 *
 */
public class PaletteCommandCreateFeature extends AbstractCreateFeature implements Categorized {
	private final GraphitiService graphitiService;
	private final AadlModificationService aadlModService;
	private final DiagramUpdater diagramUpdater;
	private final ReferenceBuilderService refBuilder;
	private final QueryService queryService;
	private final TargetedPaletteCommand cmd;

	public PaletteCommandCreateFeature(
			final GraphitiService graphitiService,
			final AadlModificationService aadlModService, final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder, final QueryService queryService,
			final IFeatureProvider fp,
			final TargetedPaletteCommand cmd) {
		super(fp, cmd.getLabel(), "");
		this.graphitiService = Objects.requireNonNull(graphitiService, "graphitiAgeDiagramProvider must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.diagramUpdater = Objects.requireNonNull(diagramUpdater, "diagramUpdater must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
		this.queryService = Objects.requireNonNull(queryService, "queryService must not be null");
		this.cmd = Objects.requireNonNull(cmd, "cmd must not be null");
	}

	@Override
	public String getCategory() {
		return cmd.getCategoryId();
	}

	@Override
	public String getCreateImageId() {
		return cmd.getIconId().orElse(null);
	}

	@Override
	public boolean canCreate(final ICreateContext context) {
		return createContext(context).flatMap(cmd::getOperation).isPresent();
	}

	@Override
	public Object[] create(final ICreateContext context) {
		return createContext(context).map(c -> {
			class CreateAction implements AgeAction {
				private Object[] result = null;

				@Override
				public AgeAction execute() {
					final DiagramNode targetNode = (DiagramNode) c.getTarget();
					cmd.getOperation(c).ifPresent(operation -> {
						// Perform modification
						final OperationExecutor opExecutor = new OperationExecutor(aadlModService, refBuilder);
						opExecutor.execute(operation,
								new GraphitiOperationResultsProcessor(getDiagram(), getFeatureProvider(),
										diagramUpdater, targetNode,
										new Point(context.getX(), context.getY())));
						result = EMPTY;
					});

					return null;
				}
			}

			final CreateAction createAction = new CreateAction();
			graphitiService.execute("Create " + cmd.getLabel(), ExecutionMode.NORMAL, createAction);
			return createAction.result;
		}).orElse(EMPTY);
	}

	private Optional<GetTargetedOperationContext> createContext(final ICreateContext context) {
		final DiagramNode targetNode = graphitiService.getGraphitiAgeDiagram().getClosestDiagramNode(context.getTargetContainer());
		if(targetNode == null) {
			return Optional.empty();
		}

		final DockingPosition targetDockingPosition = AgeDiagramUtil.determineDockingPosition(targetNode,
				context.getX(), context.getY(), 0, 0);

		return Optional.of(new GetTargetedOperationContext(targetNode, targetDockingPosition, queryService));
	}
}
