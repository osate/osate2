package org.osate.ge.internal.services;

public interface ActionExecutor {
	void execute(AgeAction action);

	void executeGroup(String label, Runnable runnable);
}
