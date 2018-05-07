package org.osate.ge.internal.operations;

/**
 * build() for this step builder will return null if the next step is null.
 *
 * @param <PrevResultUserType>
 */
public class DefaultOperationBuilder extends AbstractStepBuilder<Void> {
	@Override
	protected Step<?> buildStep(final Step<?> nextStep) {
		return nextStep;
	}
}
