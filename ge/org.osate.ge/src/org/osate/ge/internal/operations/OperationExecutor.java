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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;

public class OperationExecutor {
	private final AadlModificationService modificationService;

	public static interface ResultsProcessor {
		void processResults(final List<StepResult<?>> results);
	}

	public OperationExecutor(final AadlModificationService modificationService) {
		this.modificationService = Objects.requireNonNull(modificationService, "modificationService must not be null");
	}

	private static class ExecutionState {
		final LinkedHashSet<Supplier<? extends StepResult<?>>> pendingStepConsumers = new LinkedHashSet<>();
		final List<AadlModificationService.Modification<?, ?>> modifications = new ArrayList<>();
		final List<StepResult<?>> allResults = new ArrayList<>(); // Will only contain non-null results
		boolean aborted = false;
	}

	/**
	 * @param step
	 * @param resultsProcessor handles the results of the operation. Will not be called if any of the modifications fail.
	 */
	public void execute(final Operation op, final ResultsProcessor resultsProcessor) {
		Objects.requireNonNull(resultsProcessor, "resultsProcessor must not be null");

		if (op == null) {
			return;
		}

		if (!(op instanceof Step)) {
			throw new RuntimeException("Operation is not of type Step");
		}

		final ExecutionState executionState = new ExecutionState();
		prepareToExecute((Step<?>) op, () -> StepResultBuilder.create().build(), executionState);

		if (executionState.modifications.isEmpty()) {
			finishExecution(resultsProcessor, executionState.pendingStepConsumers, executionState.allResults);
		} else {
			modificationService.modify(executionState.modifications, allSuccessful -> {
				if (allSuccessful) {
					finishExecution(resultsProcessor, executionState.pendingStepConsumers, executionState.allResults);
				}
			});
		}
	}

	/**
	 * Executes without a results processor
	 * @param op
	 */
	public void execute(final Operation op) {
		this.execute(op, results -> {

		});
	}

	/**
	 * Finishes executing an operation. Ensures that pending step suppliers are called and the results processor is called
	 * @param resultsProcessor
	 * @param pendingStepConsumers
	 * @param allResults
	 */
	private void finishExecution(final ResultsProcessor resultsProcessor,
			LinkedHashSet<Supplier<? extends StepResult<?>>> pendingStepConsumers,
			final List<StepResult<?>> allResults) {
		// Evaluate steps which have not been evaluated.
		while (!pendingStepConsumers.isEmpty()) {
			pendingStepConsumers.iterator().next().get();
		}

		resultsProcessor.processResults(allResults);
	}

	/**
	 *
	 * @param step is the step to process. The steps and all subsequent steps will be processed.
	 * @param prevResultSupplier the supplier for the value of the previous step. Must not be null.
	 * @param allResults a list to which the results of each step should be added. This list will be modified when the actual execution is performed. Will only contain non-null results.
	 * @param modifications a list of modifications that need to be executed by the the AADL modification service.
	 * @param uncalledStepResultSuppliers a list which will contain consumers generated by steps which have not been evaluated. This list will be modified as the consumers are executed.
	 */
	private <PrevResultUserType, ResultUserType> void prepareToExecute(final Step<ResultUserType> step,
			final Supplier<StepResult<PrevResultUserType>> prevResultSupplier,
			final ExecutionState executionState) {
		Objects.requireNonNull(step, "step must not be null");

		final Supplier<StepResult<ResultUserType>> stepResultSupplier;

		if (step instanceof SplitStep) {
			for (final Step<?> nextStep : ((SplitStep) step).getSteps()) {
				prepareToExecute(nextStep, prevResultSupplier, executionState);
			}
			stepResultSupplier = () -> null; // Split steps don't produce a result and shouldn't have next steps either.
		} else if (step instanceof ModelModificationStep) {
			@SuppressWarnings("unchecked")
			final ModelModificationStep<?, ?, PrevResultUserType, ResultUserType> ms = (ModelModificationStep<?, ?, PrevResultUserType, ResultUserType>) step;
			stepResultSupplier = prepareToExecuteModification(ms, prevResultSupplier, executionState);
		} else if (step instanceof MapStep) {
			stepResultSupplier = new Supplier<StepResult<ResultUserType>>() {
				private boolean resultIsValid = false;
				private StepResult<ResultUserType> result;

				@Override
				public StepResult<ResultUserType> get() {
					if (!resultIsValid) {
						@SuppressWarnings("unchecked")
						final MapStep<PrevResultUserType, ResultUserType> ts = (MapStep<PrevResultUserType, ResultUserType>) step;
						final DefaultStepResult<PrevResultUserType> prevResult = (DefaultStepResult<PrevResultUserType>) prevResultSupplier
								.get();
						if (executionState.aborted) {
							result = StepResult.abort();
						} else {
							result = ts.getMapper().apply(prevResult.getUserValue());
							if (((DefaultStepResult<ResultUserType>) result).aborted()) {
								executionState.aborted = true;
							}
						}

						resultIsValid = true;

						executionState.pendingStepConsumers.remove(this);

						if (result != null) {
							executionState.allResults.add(result);
						}
					}

					return result;
				}
			};

			// Only add the step result supplier to the uncalled step suppliers if there isn't a next step.
			// If there is a next step, the supplier will be called when that step is evaluated.
			// Modification step result suppliers aren't added to the list because the result is produced when the modification is executed.
			if (step.getNextStep() == null) {
				executionState.pendingStepConsumers.add(stepResultSupplier);
			}
		} else {
			throw new RuntimeException("Unexpected step: " + step);
		}

		if (step.getNextStep() != null) {
			prepareToExecute(step.getNextStep(), stepResultSupplier, executionState);
		}
	}

	private static <TagType, BusinessObjectType extends EObject, PrevResultUserType, ResultUserType> Supplier<StepResult<ResultUserType>> prepareToExecuteModification(
			ModelModificationStep<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modificationStep,
			final Supplier<StepResult<PrevResultUserType>> prevResultSupplier,
			final ExecutionState executionState) {
		class ModificationStepModifier implements AadlModificationService.Modifier<TagType, BusinessObjectType> {
			DefaultStepResult<ResultUserType> result;

			@Override
			public void modify(final TagType tag, final BusinessObjectType boToModify) {
				result = (DefaultStepResult<ResultUserType>)modificationStep.getModifier().modify(tag, boToModify,
						((DefaultStepResult<PrevResultUserType>) prevResultSupplier.get()).getUserValue());
				if (result != null) {
					executionState.allResults.add(result);
					if (result.aborted()) {
						executionState.aborted = true;
					}
				}
			}
		}

		final ModificationStepModifier modifier = new ModificationStepModifier();

		final AadlModificationService.Modification<TagType, BusinessObjectType> modification = AadlModificationService.Modification
				.create(modificationStep.getTag(),
						(tag) -> {
							final DefaultStepResult<PrevResultUserType> prevResult = (DefaultStepResult<PrevResultUserType>) prevResultSupplier
									.get();
							return executionState.aborted ? null
									: modificationStep.getBusinessObjectProvider().getBusinessObject(tag,
											prevResult.getUserValue());
						},
						modifier);
		executionState.modifications.add(modification);
		return () -> modifier.result;
	}
}
