package org.osate.ge.operations;

import java.util.function.Consumer;

import org.osate.ge.internal.operations.DefaultOperationBuilder;

/**
 * Represents an operation. An operation is a sequence of steps. An operation may branch into additional sequences of steps.
 * Steps may modify the model, prompt the user, or perform other operations. The result of the previous step is provided to the followings step.
 * Operations provide a means to perform relatively complex model operations while abstracting how the details regarding how the model
 * is accessed.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Operation {
	/**
	 * Creates an operation by calling a consumer which will provide an OperationBuilder to use to create the operation.
	 * @param operationBuilder
	 * @return
	 */
	public static Operation create(final Consumer<OperationBuilder<?>> operationBuilder) {
		final DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		operationBuilder.accept(rootOpBuilder);
		return rootOpBuilder.build();
	}
}
