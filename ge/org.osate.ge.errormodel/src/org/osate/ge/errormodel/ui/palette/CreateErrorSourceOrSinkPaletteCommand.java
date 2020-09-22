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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.DirectionType;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.errormodel.combined.CombinedErrorModelSubclause;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.GetTargetedOperationContext;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;

public class CreateErrorSourceOrSinkPaletteCommand extends BasePaletteCommand implements TargetedPaletteCommand {
	private final EClass eclass;
	private final DirectionType requiredPropagationDirection;

	public static TargetedPaletteCommand createErrorSourcePaletteCommand() {
		return new CreateErrorSourceOrSinkPaletteCommand("Error Source", ErrorModelPackage.eINSTANCE.getErrorSource(),
				DirectionType.OUT);
	}

	public static TargetedPaletteCommand createErrorSinkPaletteCommand() {
		return new CreateErrorSourceOrSinkPaletteCommand("Error Sink", ErrorModelPackage.eINSTANCE.getErrorSink(),
				DirectionType.IN);
	}

	private CreateErrorSourceOrSinkPaletteCommand(final String label, final EClass eclass,
			DirectionType propagationDirection) {
		super(label, ErrorModelPaletteCategories.ERROR_FLOWS, null);
		this.eclass = Objects.requireNonNull(eclass, "eclass must not be null");
		this.requiredPropagationDirection = Objects.requireNonNull(propagationDirection,
				"propagationDirection must not be null");
	}

	@Override
	public Optional<Operation> getOperation(final GetTargetedOperationContext ctx) {
		if (ErrorFlowPaletteCommandUtil.isPotentialEnd(ctx.getTarget())) {
			return createPropgationCreationOperation(ctx.getTarget());
		}

		return Optional.empty();
	}

	private Optional<Operation> createPropgationCreationOperation(final BusinessObjectContext target) {
		return ErrorModelGeUtil.getClassifierSourceBoc(target).flatMap(container -> {
			return ErrorModelGeUtil.createErrorModelSubclausePromptAndModifyOperation(container, () -> {
				final CombinedErrorModelSubclause combined = CombinedErrorModelSubclause
						.create(ErrorModelGeUtil.getClassifier(container).get());
				return ErrorFlowPaletteCommandUtil.validateAndShowError(combined, target, requiredPropagationDirection)
						? Optional.of(true)
						: Optional.empty();
			}, (subclause, unused) -> {
				final ErrorFlow newFlow = (ErrorFlow) EcoreUtil.create(eclass);

				// Set name
				final String newName = ErrorModelNamingUtil.buildUniqueIdentifier(subclause.getContainingClassifier(),
						"new_error_flow");
				newFlow.setName(newName);

				// Finish creating the source or sink
				final CombinedErrorModelSubclause combined = CombinedErrorModelSubclause
						.create(subclause.getContainingClassifier());
				final boolean allTarget = ErrorFlowPaletteCommandUtil.isAll(target);
				if (newFlow instanceof ErrorSource) {
					final ErrorSource src = ((ErrorSource) newFlow);
					if (allTarget) {
						src.setAll(allTarget);
					} else {
						src.setSourceModelElement(ErrorFlowPaletteCommandUtil.findErrorPropagationOrThrow(combined,
								target, requiredPropagationDirection));
					}
				} else if (newFlow instanceof ErrorSink) {
					final ErrorSink snk = (ErrorSink) newFlow;
					if (allTarget) {
						snk.setAllIncoming(allTarget);
					} else {
						snk.setIncoming(ErrorFlowPaletteCommandUtil.findErrorPropagationOrThrow(combined, target,
								requiredPropagationDirection));
					}
				}

				subclause.getFlows().add(newFlow);

				return StepResultBuilder.create().showNewBusinessObject(container, newFlow).build();
			});
		});
	}
}
