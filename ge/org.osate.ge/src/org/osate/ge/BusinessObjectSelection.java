/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.OperationBuilder;

/**
 * Interface for accessing a collection of selected business objects.
 */
public interface BusinessObjectSelection {
	/**
	 * Returns a stream of all the business objects which are instances of the specified type.
	 * Business objects provided by this stream must not be modified.
	 * @param <T> the type of business objects to return.
	 * @param c the class object for the type of business objects to return. Other types of business objects will be ignored.
	 * @return a stream containing the business objects of the specified type.
	 */
	<T> Stream<T> boStream(Class<T> c);

	/**
	 * Returns a stream of selected {@link BusinessObjectContext} instances.
	 * Business objects provided by this stream must not be modified.
	 * @return the selected {@link BusinessObjectContext} instances.
	 */
	Stream<BusinessObjectContext> bocStream();

	/**
	 * Calls the specified modifier for each business object provided by the bocToBoToModifyMapper.
	 * Also provides the business object context.
	 * The business objects contained in the business object context must not be modified.
	 * @param <T> is the type of business object to be modified.
	 * @param bocToBoToModifyMapper is a function which returns the object which should be modified based on a business object context.
	 * @param modifier is a function which is passed the object to be modified and the business object context. The business object included
	 * in the business object context should be not modified.
	 */
	default <T extends EObject> void modify(Function<BusinessObjectContext, T> bocToBoToModifyMapper,
			BiConsumer<T, BusinessObjectContext> modifier) {
		modify("Modify Model", boc -> true, bocToBoToModifyMapper, modifier);
	}

	/**
	 * After filtering business object contexts using the specified filter,
	 * calls the specified modifier for each business object provided by the bocToBoToModifyMapper.
	 * Also provides the business object context.
	 * The business objects contained in the business object context must not be modified.
	 * @param <T> is the type of business object to be modified.
	 * @param label is a description of the modification.
	 * @param bocFilter is the filter for business object contexts. Only business object contexts which pass the filter are modified.
	 * @param bocToBoToModifyMapper is a function which returns the object which should be modified based on a business object context.
	 * @param modifier is a function which is passed the object to be modified and the business object context.
	 * @since 2.0
	 */
	<T extends EObject> void modify(String label, Predicate<BusinessObjectContext> bocFilter,
			Function<BusinessObjectContext, T> bocToBoToModifyMapper,
			BiConsumer<T, BusinessObjectContext> modifier);

	/**
	 * Calls the specified modifier for each business object which is an instance of of the specified class.
	 * @param <T> is the type of business object to be modified.
	 * @param c the class object for the type of business object to modify
	 * @param modifier the function to call to modify the business object
	 */
	default <T extends EObject> void modify(Class<T> c, Consumer<T> modifier) {
		modify("Modify Model", c, boc -> true, modifier);
	}

	/**
	 * Calls the specified modifier for each business object for the business object contexts which pass the bocFilter and are instances
	 * of the specified class.
	 * @param <T> is the type of business object to be modified.
	 * @param label is a description of the modification.
	 * @param c is the class object for the type of object being modified.
	 * @param bocFilter is the filter for business object contexts. Only called for business object contexts which are instances of the specified class. Only business object contexts which pass the filter are modified.
	 * @param modifier is the function to call to modify the business object.
	 * @since 2.0
	 */
	<T extends EObject> void modify(String label, Class<T> c, Predicate<BusinessObjectContext> bocFilter,
			Consumer<T> modifier);

	/**
	 * Adds a modification for each business object to the operation being constructed using opBuilder
	 * Ignores business objects which are not of the specified type.
	 * @param <T> is the type of business object to be modified.
	 * @param <O> is the result type of the operation builder being used.
	 * @param opBuilder is the operation builder to use to modify the business object. {@link OperationBuilder#modifyModel} will be called for each
	 * business object to be modified.
	 * @param c is the class object for the type of object being modified.
	 * @param modifier is the function to call to modify the business object. The business object to be modified and the previous value from the operation
	 * will be passed to the function. The previous value from the operation must not be modified by the modifier.
	 */
	<T extends EObject, O> void modifyWithOperation(final OperationBuilder<O> opBuilder, Class<T> c,
			BiConsumer<T, O> modifier);

}