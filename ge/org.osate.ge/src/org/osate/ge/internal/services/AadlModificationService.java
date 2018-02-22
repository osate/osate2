package org.osate.ge.internal.services;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.LinkedListMultimap;

/**
 * Service providing a mechanism for making changes to the model
 *
 */
public interface AadlModificationService {
	/**
	 * Calls the specified modifier for each business object provided by applying objToBoToModifyMapper for each object object in the specified object list.
	 * @param modifier
	 * @param objToBoToModifyMapper
	 */
	<I, E extends EObject, R> List<R> modify(List<I> objs, Function<I, E> objToBoToModifyMapper,
			MappedObjectModifier<E, R> modifier);

	/**
	 * For each key in the specified map, calls the value modifier for each business object provided by applying objToBoToModifyMapper.
	 * @param objectsToModifierMap
	 * @param objToBoToModifyMapper
	 * @param resultConsumer is a consumer which is called with the results before the modification is completed and the change notifier is unlocked.
	 */
	<I, E extends EObject, R> List<R> modify(LinkedListMultimap<I, MappedObjectModifier<E, R>> objectsToModifierMap,
			Function<I, E> objToBoToModifyMapper, final Consumer<List<R>> resultConsumer);

	/**
	 * Modifies an AADL model. Performs any necessary work to ensure it is done safely and appropriately regardless of the current state.
	 * The modification is considered to have failed if the model that results from the modification contains validation errors.
	 * @param element a named element that is contained in the model to be modified
	 * @param modifier the modifier that will perform the actual modification
	 * @returns the result of the modification or null if the modification failed
	 */
	<E extends EObject, R> R modify(E bo, Modifier<E, R> modifier);

	public static interface Modifier<E, R> {
		R modify(Resource resource, final E bo);
	}

	/**
	 * Version of Modifier which provides the object that was mapped to be business object.
	 */
	public static interface MappedObjectModifier<E, R> {
		R modify(Resource resource, final E bo, final Object obj);
	}
}
