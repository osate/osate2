/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.operations;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;

/**
 * Builder uses for creating operations. This class is not a builder pattern in the sense of the builder pattern. It does not create an {@link Operation}.
 *
 * This interface is used in conjunction with {@link Operation#createWithBuilder(java.util.function.Consumer)} to create the operation.
 * Each call to an operation builder creates a step in the resulting operation. Multiple calls to the same instance will
 * result in multiple branches in the operation.
 *
 * For simple operations, {@link Operation} defines other methods to create operations which does not require the user of this interface.
 *
 * @param <P> the type of the user value of the result of the previous step
 * @see Operation#createWithBuilder(java.util.function.Consumer)
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OperationBuilder<P> {
	/**
	 * Interface used to provide the business object to modify to a model modification step based on the tag specified when creating th step
	 * and the result of the previous operation step.
	 * @param <T> the type of the tag.
	 * @param <B> the type of business object to modify
	 * @param <P> the type of the user value of the result of the previous step
	 * @since 2.0
	 * @see #modifyModel
	 */
	interface BusinessObjectToModifyProvider<T, B, P> {
		/**
		 * Returns the business object that should be modified
		 * @param tag the tag specified when creating the model modification step
		 * @param previousUserValue the user
		 * @return the object to modify
		 */
		B getBusinessObject(T tag, P previousUserValue);
	}

	/**
	 * Create a model modification step.
	 * The business object passed to the modifier may be different from the object returned by the
	 * the business object provider. During operation execution, the appropriate modifiable object will be retrieved
	 * and passed to the modifier.
	 * @param <T> the type of the tag
	 * @param <B> the type of business object to modify
	 * @param <R> the type of the user value of the new step's result
	 * @param tag an object that will be passed to the model provider. May be null.
	 * @param boProvider the object which determines what business object is modified. Must not be null.
	 * @param modifier the object which performs the model modification. Must not be null.
	 * @return a new instance which adds steps after the newly created step.
	 * @since 2.0
	 */
	<T, B extends EObject, R> OperationBuilder<R> modifyModel(
			T tag,
			BusinessObjectToModifyProvider<T, B, P> boProvider,
			ModelModifier<T, B, P, R> modifier);

	/**
	 * Modifies the user value contained in the previous step's result. The previous result must be an {@link EObject} belonging to the AADL model.
	 * @param <R> the type of the user value of the new step's result
	 * @param modifier the object which performs the model modification. Must not return null
	 * @return a new instance which adds steps after the newly created step.
	 * @throws IllegalStateException if the user value from the previous step is not an instance of of {@link EObject}
	 */
	@SuppressWarnings("unchecked")
	default <R> OperationBuilder<R> modifyPreviousResult(
			final Function<P, StepResult<R>> modifier) {

		return modifyModel(null, (tag, prevResult) -> {
			if (!(prevResult instanceof EObject)) {
				throw new IllegalStateException("Previous result must be an EObject. Previous result: " + prevResult);
			}
			return (EObject) prevResult;
		}, (tag, boToModify, prevResult) -> modifier.apply((P) boToModify));
	}

	/**
	 * Creates a step which maps the user value provided by the previous step to a new value. The new value will be passed to
	 * subsequent steps.
	 * @param <R> the type of the user value of the new step's result
	 * @param mapper a function which returns the result for the step. The user value from this result will be used for subsequent steps in this branch.
	 * @return a new instance which adds steps after the newly created step.
	 */
	<R> OperationBuilder<R> map(
			Function<P, StepResult<R>> mapper);

	/**
	 * Create a step which executes another operation. This function is intended for use only in the rare cases that the number of steps is not known
	 * until runtime.
	 * @param opProvider a function that provides a operation to execute.
	 * @since 2.0
	 */
	void executeOperation(Function<P, Operation> opProvider);

	/**
	 * Creates a new step which uses the value provided by the specified supplier as the user value of the result.
	 * This is equivalent to a a map step which ignores the previous result.
	 * @param <R> the type of the user value of the new step's result
	 * @param supplier the supplier which returns the user value for the step's result
	 * @return a new instance which adds steps after the newly created step.
	 * @see #map(Function)
	 */
	default <R> OperationBuilder<R> supply(final Supplier<StepResult<R>> supplier) {
		return map(prevResult -> supplier.get());
	}
}
