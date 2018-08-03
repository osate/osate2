package org.osate.ge.internal.operations;

public class AbstractStep<ResultUserType> implements Step<ResultUserType> {
	private final Step<?> nextStep;

	public AbstractStep(final Step<?> nextStep) {
		this.nextStep = nextStep;
	}

	@Override
	public Step<?> getNextStep() {
		return nextStep;
	}

}
