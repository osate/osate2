package org.osate.ge.operations;

import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.operations.DefaultStepResult;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class StepResultBuilder<UserValueType> {
	private UserValueType userValue;
	private Multimap<BusinessObjectContext, Object> containerToBoToShowMap = ArrayListMultimap.create();
	private boolean aborted = false;

	private StepResultBuilder(final UserValueType userValue) {
		this.userValue = userValue;
	}

	public StepResultBuilder<UserValueType> showNewBusinessObject(final BusinessObjectContext container,
			final Object bo) {
		Objects.requireNonNull(container, "container must not be null");
		Objects.requireNonNull(bo, "bo must not be null");
		containerToBoToShowMap.put(container, bo);
		return this;
	}

	/**
	 * Aborting a step will not revert previously made modifications. It is recommended to perform any prompting and potential aborting before
	 * any modification steps.
	 * @return
	 */
	public StepResultBuilder<UserValueType> abort() {
		aborted = true;
		return this;
	}

	public static <UserValue> StepResultBuilder<UserValue> create(final UserValue userValue) {
		return new StepResultBuilder<>(userValue);
	}

	public static StepResultBuilder<?> create() {
		return new StepResultBuilder<>(null);
	}

	public StepResult<UserValueType> build() {
		return new DefaultStepResult<>(userValue, ImmutableMultimap.copyOf(containerToBoToShowMap), aborted);
	}
}
