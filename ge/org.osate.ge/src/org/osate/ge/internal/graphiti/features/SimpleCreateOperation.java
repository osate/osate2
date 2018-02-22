package org.osate.ge.internal.graphiti.features;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.internal.CreateOperation;
import org.osate.ge.internal.services.AadlModificationService;

import com.google.common.collect.LinkedListMultimap;

class SimpleCreateOperation implements CreateOperation {
	// Maps from the object being modified to the modifier
	final LinkedListMultimap<EObject, AadlModificationService.MappedObjectModifier<EObject, CreateStepResult>> stepMap = LinkedListMultimap
			.create();

	@SuppressWarnings("unchecked")
	@Override
	public <E extends EObject> void addStep(final E objToModify, CreateStepHandler<E> stepHandler) {
		stepMap.put(objToModify,
				(resource, bo, obj) -> stepHandler.modify(resource, (E) bo));
	}

	public final boolean isEmpty() {
		return stepMap.isEmpty();
	}
}