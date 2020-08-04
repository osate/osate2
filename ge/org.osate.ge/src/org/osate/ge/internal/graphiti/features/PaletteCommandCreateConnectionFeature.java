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
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * ICreateConnectionFeature implementation that delegates behavior to a {@link org.osate.ge.na.palette.CreateConnectionPaletteCommand}
 *
 */
public class PaletteCommandCreateConnectionFeature extends AbstractCreateConnectionFeature implements Categorized {
	private final GraphitiService graphitiService;
	private final AadlModificationService aadlModService;
	private final DiagramUpdater diagramUpdater;
	private final ReferenceBuilderService refBuilder;
	private final QueryService queryService;
	private final CreateConnectionPaletteCommand cmd;

	public PaletteCommandCreateConnectionFeature(
			final GraphitiService graphitiService,
			final AadlModificationService aadlModService, final DiagramUpdater diagramUpdater,
			final ReferenceBuilderService refBuilder, final QueryService queryService,
			final IFeatureProvider fp,
			final CreateConnectionPaletteCommand cmd) {
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
	public boolean canStartConnection(final ICreateConnectionContext context) {
		final DiagramElement srcElement = graphitiService
				.getGraphitiAgeDiagram()
				.getClosestDiagramElement(context.getSourcePictogramElement());
		if (srcElement == null) {
			return false;
		}

		return cmd.canStartConnection(new CanStartConnectionContext(srcElement, queryService));
	}

	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		return createContext(context).flatMap(cmd::getOperation).isPresent();
	}

	@Override
	public Connection create(final ICreateConnectionContext context) {
		createContext(context).ifPresent(c -> {
			class CreateAction implements AgeAction {
				@Override
				public AgeAction execute() {
					cmd.getOperation(c).ifPresent(operation -> {
						// Perform modification
						final OperationExecutor opExecutor = new OperationExecutor(aadlModService);
						opExecutor.execute(operation,
								new GraphitiOperationResultsProcessor(getDiagram(), getFeatureProvider(),
										diagramUpdater, refBuilder));
					});

					return null;
				}
			}

			final CreateAction createAction = new CreateAction();
			graphitiService.execute("Create " + cmd.getLabel(), ExecutionMode.NORMAL, createAction);

		});

		return null;
	}

	private Optional<GetCreateConnectionOperationContext> createContext(final ICreateConnectionContext context) {
		final GraphitiAgeDiagram graphitiAgeDiagram = graphitiService.getGraphitiAgeDiagram();
		final DiagramElement srcElement = graphitiAgeDiagram
				.getClosestDiagramElement(context.getSourcePictogramElement());
		final DiagramElement dstElement = graphitiAgeDiagram
				.getClosestDiagramElement(context.getTargetPictogramElement());
		if (srcElement == null || dstElement == null) {
			return Optional.empty();
		}

		return Optional.of(new GetCreateConnectionOperationContext(srcElement, dstElement, queryService));
	}
}
