package org.osate.ge;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.OperationBuilder;

public interface BusinessObjectSelection {
	/**
	 * Throws an exception if any of the objects in the set are not of the specified type.
	 * Business objects provided by this stream must not be modified.
	 * @param c
	 * @return a stream to the business objects represented.
	 */
	<T> Stream<T> boStream(Class<T> c);

	/**
	 * Business objects provided by this stream must not be modified.
	 * @return
	 */
	Stream<BusinessObjectContext> bocStream();

	/**
	 * Calls the specified modifier for each business object provided by the bocToBoToModifyMapper.
	 * Also provides the business object context.
	 * The business objects contained in the business object context must not be modified.
	 * @param bocToBoToModifyMapper
	 * @param modifier
	 */
	<T extends EObject> void modify(Function<BusinessObjectContext, T> bocToBoToModifyMapper,
			BiConsumer<T, BusinessObjectContext> modifier);

	/**
	 * Calls the specified modifier for each business object.
	 * Throws an exception if any of the objects in the set are not of the specified type.
	 * @param c
	 * @param modifier
	 */
	<T extends EObject> void modify(Class<T> c, Consumer<T> modifier);

	/**
	 * Adds a modification for each business object to the operation being constructed using opBuilder
	 * Throws an exception if any of the objects in the set are not of the specified type.
	 */
	<T extends EObject, O> void modifyWithOperation(final OperationBuilder<O> opBuilder, Class<T> c,
			BiConsumer<T, O> modifier);

}