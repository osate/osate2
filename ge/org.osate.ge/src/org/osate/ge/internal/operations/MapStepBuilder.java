package org.osate.ge.internal.operations;

import java.util.Objects;
import java.util.function.Function;

import org.osate.ge.operations.StepResult;

class MapStepBuilder<PrevResultUserType, ResultUserType> extends AbstractStepBuilder<ResultUserType> {
	private final Function<PrevResultUserType, StepResult<ResultUserType>> mapper;

	public MapStepBuilder(final Function<PrevResultUserType, StepResult<ResultUserType>> mapper) {
		this.mapper = Objects.requireNonNull(mapper, "mapper must not be null");
	}

	@Override
	protected Step<?> buildStep(final Step<?> nextStep) {
		return new MapStep<PrevResultUserType, ResultUserType>(nextStep, mapper);
	}
}
