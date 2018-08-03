package org.osate.ge.internal.operations;

import java.util.Objects;
import java.util.function.Function;

import org.osate.ge.operations.StepResult;

class MapStep<PrevResultUserType, ResultUserType> extends AbstractStep<ResultUserType> {
	private final Function<PrevResultUserType, StepResult<ResultUserType>> mapper;

	public MapStep(final Step<?> nextStep,
			final Function<PrevResultUserType, StepResult<ResultUserType>> mapper) {
		super(nextStep);
		this.mapper = Objects.requireNonNull(mapper, "handler must not be null");
	}

	public Function<PrevResultUserType, StepResult<ResultUserType>> getMapper() {
		return mapper;
	}
}
