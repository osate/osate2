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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.List;
import java.util.Optional;

import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.ui.internal.AadlUiUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.services.QueryService;

public class CreateFlowPathSpecificationPaletteCommand extends BasePaletteCommand
		implements CreateConnectionPaletteCommand {

	public CreateFlowPathSpecificationPaletteCommand() {
		super("Flow Path Specification", AadlPaletteCategories.FLOWS, AadlImages.getImage("FlowPath"));
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ctx.getSource().getBusinessObject(Feature.class)
				.map(srcFeature -> FlowSpecificationCreationUtil.isValidFlowEnd(srcFeature, ctx.getSource(), DirectionType.IN,
						ctx.getQueryService()))
				.orElse(false);
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		final BusinessObjectContext srcBoc = ctx.getSource();
		final Feature srcFeature = srcBoc.getBusinessObject(Feature.class).orElse(null);
		final BusinessObjectContext dstBoc = ctx.getDestination();
		final Feature dstFeature = dstBoc.getBusinessObject(Feature.class).orElse(null);

		if (srcFeature == null || dstFeature == null) {
			return Optional.empty();
		}
		final List<ComponentType> potentialOwners = getPotentialOwners(srcBoc, dstBoc, ctx.getQueryService());
		if (potentialOwners.size() == 0 || !FlowSpecificationCreationUtil.isValidFlowEnd(dstFeature, dstBoc, DirectionType.OUT,
				ctx.getQueryService())) {
			return Optional.empty();
		}

		final BusinessObjectContext container = FlowSpecificationCreationUtil.getFlowSpecificationOwnerBoc(
				srcBoc,
				ctx.getQueryService());
		if (container == null) {
			return Optional.empty();
		}

		return Optional.of(Operation.createWithBuilder(createOp -> {
			AadlUiUtil.selectClassifier(createOp, potentialOwners).modifyPreviousResult(ct -> {
				final FlowSpecification fs = ct.createOwnedFlowSpecification();
				fs.setKind(FlowKind.PATH);
				fs.setName(FlowSpecificationCreationUtil.getNewFlowSpecificationName(ct));

				// Create the flow ends
				final FlowEnd inFlowEnd = fs.createInEnd();
				inFlowEnd.setFeature(srcFeature);
				inFlowEnd.setContext(FlowSpecificationCreationUtil.getContext(srcBoc, ctx.getQueryService()));

				final FlowEnd outFlowEnd = fs.createOutEnd();
				outFlowEnd.setFeature(dstFeature);
				outFlowEnd.setContext(FlowSpecificationCreationUtil.getContext(dstBoc, ctx.getQueryService()));

				ct.setNoFlows(false);

				return StepResultBuilder.create().showNewBusinessObject(container, fs).build();
			});
		}));

	}

	private List<ComponentType> getPotentialOwners(final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc, final QueryService queryService) {
		final List<ComponentType> potentialOwners = FlowSpecificationCreationUtil.getPotentialOwnersByFeature(srcBoc,
				queryService);
		potentialOwners.retainAll(FlowSpecificationCreationUtil.getPotentialOwnersByFeature(dstBoc, queryService));
		return potentialOwners;
	}

}
