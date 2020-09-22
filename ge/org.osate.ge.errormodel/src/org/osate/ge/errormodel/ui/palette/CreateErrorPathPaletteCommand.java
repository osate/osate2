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
package org.osate.ge.errormodel.ui.palette;

import java.util.Optional;

import org.osate.aadl2.DirectionType;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.errormodel.combined.CombinedErrorModelSubclause;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;

public class CreateErrorPathPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	public CreateErrorPathPaletteCommand() {
		super("Error Path", ErrorModelPaletteCategories.ERROR_FLOWS, null);
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ErrorFlowPaletteCommandUtil.isPotentialEnd(ctx.getSource());
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		// Check if the destination is a potential end
		if (!ErrorFlowPaletteCommandUtil.isPotentialEnd(ctx.getDestination())) {
			return Optional.empty();
		}

		// Find the common ancestor which is a source for the classifier to update
		final BusinessObjectContext classifierSourceBoc = BusinessObjectContext
				.getFirstCommonAncestor(ctx.getSource().getParent(), ctx.getDestination().getParent())
				.flatMap(ancestor -> ErrorModelGeUtil.getClassifierSourceBoc(ancestor)).orElse(null);
		if (classifierSourceBoc == null) {
			return Optional.empty();
		}

		return ErrorModelGeUtil.createErrorModelSubclausePromptAndModifyOperation(classifierSourceBoc, () -> {
			final CombinedErrorModelSubclause combined = CombinedErrorModelSubclause
					.create(ErrorModelGeUtil.getClassifier(classifierSourceBoc).get());

			// Validate both the source and the destination
			return (ErrorFlowPaletteCommandUtil.validateAndShowError(combined, ctx.getSource(), DirectionType.IN)
					&& ErrorFlowPaletteCommandUtil.validateAndShowError(combined, ctx.getDestination(),
							DirectionType.OUT))
					? Optional.of(true)
					: Optional.empty();
		}, (subclause, unused) -> {
			final ErrorPath newFlow = ErrorModelFactory.eINSTANCE.createErrorPath();

			// Set name
			final String newName = ErrorModelNamingUtil.buildUniqueIdentifier(subclause.getContainingClassifier(),
					"new_error_flow");
			newFlow.setName(newName);

			// Set the incoming and outgoing fields of the flow
			final CombinedErrorModelSubclause combined = CombinedErrorModelSubclause
					.create(subclause.getContainingClassifier());

			final boolean allSrc = ErrorFlowPaletteCommandUtil.isAll(ctx.getSource());
			if (allSrc) {
				newFlow.setAllIncoming(allSrc);
			} else {
				newFlow.setIncoming(ErrorFlowPaletteCommandUtil
						.findErrorPropagationOrThrow(combined, ctx.getSource(), DirectionType.IN));
			}

			final boolean allDst = ErrorFlowPaletteCommandUtil.isAll(ctx.getDestination());
			if (allDst) {
				newFlow.setAllOutgoing(allDst);
			} else {
				newFlow.setOutgoing(ErrorFlowPaletteCommandUtil
						.findErrorPropagationOrThrow(combined, ctx.getDestination(), DirectionType.OUT));
			}

			// Add the flow to the subclause
			subclause.getFlows().add(newFlow);

			return StepResultBuilder.create().showNewBusinessObject(classifierSourceBoc, newFlow).build();
		});
	}
}
