/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.operations.DefaultOperationBuilder;

/**
 * Represents an operation. An operation is a sequence of steps. An operation may branch into additional sequences of steps.
 * Steps may modify the model, prompt the user, or perform other operations. The result of the previous step is provided to the followings step.
 * Operations provide a means to perform relatively complex model operations while abstracting how the details regarding how the model
 * is accessed.
 *
 * Operations are important for allowing complex operations using a minimal number of transactions.
 * Operations typically perform any user prompting at the start of the operation to allow the operation to abort before
 * any modifications occur.
 *
 * If an operation contains many modifications, the underlying implementation may aggregate modifications to reduce
 * the number of times the model is locked.
 *
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Operation {
	/**
	 * Creates an operation by calling a consumer which will provide an OperationBuilder to use to create the operation.
	 * @param operationBuilder
	 * @return
	 * @since 2.0
	 */
	public static Operation createWithBuilder(final Consumer<OperationBuilder<?>> operationBuilder) {
		final DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		operationBuilder.accept(rootOpBuilder);
		return rootOpBuilder.build();
	}

	/**
	 * Create an operation that modifies the business object of the specified business object context. Automatically adds the
	 * newly created object to the diagram. The newly created object must be a valid child of the specified business object
	 * context.
	 * @param <BusinessObjectType> is the type of business object being modified
	 * @param containerToModify is the business object context which is being modified
	 * @param containerBoType is the type of business object expected for the context.
	 * @param modifier is a function that performs the modification operation to the passed in business object.
	 * @return an optional containing an operation. If the type of the context's business object does not match the specified type an empty optional will be returned.
	 * @since 2.0
	 */
	public static <BusinessObjectType> Optional<Operation> createSimple(final BusinessObjectContext containerToModify,
			final Class<BusinessObjectType> containerBoType, Function<BusinessObjectType, StepResult<?>> modifier) {
		return containerToModify.getBusinessObject(containerBoType)
				.map(containerBo -> Operation.createWithBuilder(b -> {
					b.supply(() -> StepResult.forValue(containerBo)).modifyPreviousResult(bo2 -> {
						return modifier.apply(bo2);
					});
				}));
	}

	/**
	 * Creates an operation that is intended to be used to implement the common pattern of prompting to select the business object to modify.
	 * @param <BusinessObjectType> is the business object being modified
	 * @param prompter is a function which returns the business object to be modified. Must not return null.
	 * @param modifier is a function used to modify the model. The argument for this function may not match that which is returned by the prompter. Only the business object passed into this function should be modified.
	 * @return the created operation.
	 * @since 2.0
	 */
	public static <BusinessObjectType> Operation createPromptAndModify(
			final Supplier<Optional<BusinessObjectType>> prompter,
			Function<BusinessObjectType, StepResult<?>> modifier) {
		return createWithBuilder(b -> {
			b.supply(() -> {
				return prompter.get().map(v -> StepResult.forValue(v)).orElseGet(() -> StepResult.abort());
			}).modifyPreviousResult(v -> {
				return modifier.apply(v);
			});
		});
	}

	/**
	 * Creates an operation that is intended to be used to implement the common pattern of prompting the user to determine the business object to modify and additional arguments.
	 * @param <BusinessObjectType>
	 * @param <Extra> is the type of the data beyond the business object to modify which will be collected.
	 * @param prompter is a function that prompts the user and then provides a business object to modify along with additional data. Must not return null.
	 * @param modifier is a function used to modify the model. The argument for this function may not match that which is returned by the prompter. Only the business object passed into this function should be modified.
	 * @return the created operation.
	 * @since 2.0
	 */
	public static <BusinessObjectType extends EObject, Extra> Operation createPromptAndModifyWithExtra(
			final Supplier<Optional<BusinessObjectAndExtra<BusinessObjectType, Extra>>> prompter,
			Function<BusinessObjectAndExtra<BusinessObjectType, Extra>, StepResult<?>> modifier) {
		return createWithBuilder(b -> {
			b.supply(() -> {
				return prompter.get().map(v -> StepResult.forValue(v)).orElseGet(() -> StepResult.abort());
			}).modifyModel(null, (t, args) -> args.getBusinessObject(), (tag, boToModify, args) -> {
				return modifier.apply(new BusinessObjectAndExtra<>(boToModify, args.getExtra()));
			});
		});
	}

}
