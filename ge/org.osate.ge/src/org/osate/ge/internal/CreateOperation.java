package org.osate.ge.internal;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.ge.BusinessObjectContext;

// Internal API used for multi-step create operations.
public interface CreateOperation {
	public static interface CreateStepHandler<E extends EObject> {
		CreateStepResult modify(final Resource resource, final E bo);
	}

	public static class CreateStepResult {
		public final BusinessObjectContext container;
		public final Object newBo;

		public CreateStepResult(final BusinessObjectContext container, final Object newBo) {
			this.container = container;
			this.newBo = Objects.requireNonNull(newBo, "newBo must not be null");
		}
	}

	<E extends EObject> void addStep(final E objToModify, CreateStepHandler<E> stepHandler);
}