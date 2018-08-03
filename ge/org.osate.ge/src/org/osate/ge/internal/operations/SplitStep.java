package org.osate.ge.internal.operations;

import java.util.Objects;

import com.google.common.collect.ImmutableList;

/**
 * A step that contains multiple next steps. Each next steps is a separate chain of steps which will all be provided the same previous step.
 * A split step does not have a result.
 *
 */
class SplitStep extends AbstractStep<Void> {
	private final ImmutableList<Step<?>> steps;

	public SplitStep(final ImmutableList<Step<?>> steps) {
		super(null);
		this.steps = Objects.requireNonNull(steps, "steps must not be null");
	}

	public ImmutableList<Step<?>> getSteps() {
		return steps;
	}
}
