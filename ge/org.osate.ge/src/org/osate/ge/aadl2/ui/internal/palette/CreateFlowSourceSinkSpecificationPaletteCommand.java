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
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;

public class CreateFlowSourceSinkSpecificationPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	private final FlowKind flowKind;

	private CreateFlowSourceSinkSpecificationPaletteCommand(final String label, final String imageName, final FlowKind flowKind) {
		super(label,
				AadlPaletteCategories.FLOWS,
				AadlImages.getImage(imageName));
		this.flowKind = flowKind;
	}

	public static CreateFlowSourceSinkSpecificationPaletteCommand createFlowSourceCommand() {
		return new CreateFlowSourceSinkSpecificationPaletteCommand("Flow Source Specification", "FlowSource",
				FlowKind.SOURCE);
	}

	public static CreateFlowSourceSinkSpecificationPaletteCommand createFlowSinkCommand() {
		return new CreateFlowSourceSinkSpecificationPaletteCommand("Flow Sink Specification", "FlowSink",
				FlowKind.SINK);
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		return ctx.getTarget().getBusinessObject(Feature.class).map(feature -> {
			final DirectionType requiredDirection;
			if (flowKind == FlowKind.SOURCE) {
				requiredDirection = DirectionType.OUT;
			} else if (flowKind == FlowKind.SINK) {
				requiredDirection = DirectionType.IN;
			} else {
				return null;
			}

			final List<ComponentType> potentialOwners = FlowSpecificationCreationUtil
					.getPotentialOwnersByFeature(ctx.getTarget(), ctx.getQueryService());
			if (potentialOwners
					.isEmpty()
					|| !FlowSpecificationCreationUtil.isValidFlowEnd(feature, ctx.getTarget(), requiredDirection,
							ctx.getQueryService())) {
				return null;
			}

			final BusinessObjectContext container = FlowSpecificationCreationUtil
					.getFlowSpecificationOwnerBoc(ctx.getTarget(),
					ctx.getQueryService());
			if (container == null) {
				return null;
			}

			return Operation.createWithBuilder(createOp -> {
				AadlUiUtil.selectClassifier(createOp,
						potentialOwners)
				.modifyPreviousResult(ct -> {
					final FlowSpecification fs = ct.createOwnedFlowSpecification();
					fs.setKind(flowKind);
							fs.setName(FlowSpecificationCreationUtil.getNewFlowSpecificationName(ct));

					// Create the appropriate flow end depending on the type being created
					final FlowEnd flowEnd;
					if (flowKind == FlowKind.SOURCE) {
						flowEnd = fs.createOutEnd();
					} else if (flowKind == FlowKind.SINK) {
						flowEnd = fs.createInEnd();
					} else {
						throw new RuntimeException("Unexpected flow kind: " + flowKind);
					}
					flowEnd.setFeature(feature);
							flowEnd.setContext(
									FlowSpecificationCreationUtil.getContext(ctx.getTarget(), ctx.getQueryService()));

					// Clear the no flows flag
					ct.setNoFlows(false);

					return StepResultBuilder.create().showNewBusinessObject(container, fs).build();
				});
			});
		});
	}
}