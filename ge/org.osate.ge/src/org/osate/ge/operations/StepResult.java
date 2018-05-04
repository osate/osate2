package org.osate.ge.operations;

public interface StepResult<UserValueType> {
	public static <UserValueType> StepResult<UserValueType> forValue(final UserValueType userValue) {
		return StepResultBuilder.create(userValue).build();
	}

	@SuppressWarnings("unchecked")
	public static <UserValueType> StepResult<UserValueType> abort() {
		return (StepResult<UserValueType>) StepResultBuilder.create().abort().build();
	}
}
