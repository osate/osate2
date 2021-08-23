/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Objects;

import org.osate.ge.BusinessObjectContext;

import com.google.common.collect.ImmutableMultimap;

/**
 * Stores the result of an operation step.
 *
 * @param <R> the type of the user value stored in the result
 */
public final class StepResult<R> {
	private final R userValue;
	private final ImmutableMultimap<BusinessObjectContext, Object> containerToBoToShowMap;
	private final boolean aborted;

	/**
	 * Create a new instance. Either the static methods contained in {@link StepResult} or {@link StepResultBuilder} should be used to create
	 * new instances.
	 * @param userValue the user value for the result
	 * @param containerToBoToShowMap a mapping between business object contexts to business objects for which to add diagram elements.
	 * @param aborted whether the operation was aborted. If the operation was aborted, the remainder of the operation is aborted.
	 * @see #forValue(Object)
	 * @see #abort()
	 * @see StepResultBuilder
	 */
	StepResult(
			final R userValue,
			final ImmutableMultimap<BusinessObjectContext, Object> containerToBoToShowMap, final boolean aborted) {
		this.userValue = userValue;
		this.containerToBoToShowMap = Objects.requireNonNull(containerToBoToShowMap,
				"containerToBoToShowMap must not be null");
		this.aborted = aborted;
	}

	/**
	 * Returns the user value
	 * @return the user value
	 */
	public R getUserValue() {
		return userValue;
	}

	/**
	 * Returns a mapping between business object contexts to business objects for which to add diagram elements.
	 * @return a mapping between business object contexts to business objects for which to add diagram elements.
	 */
	public ImmutableMultimap<BusinessObjectContext, Object> getContainerToBoToShowMap() {
		return containerToBoToShowMap;
	}

	/**
	 * Returns whether the operation was aborted.
	 * @return true if the operation was aborted
	 */
	public boolean aborted() {
		return aborted;
	}

	/**
	 * Creates a new step result with the specified user value
	 * @param <R> the type of the user value
	 * @param userValue the user value
	 * @return a new step result with the specified user value
	 */
	public static <R> StepResult<R> forValue(final R userValue) {
		return StepResultBuilder.create(userValue).build();
	}

	/**
	 * Creates a new step result which indicates the step was completed but provides a null user value
	 * @return a new step result with a null user value.
	 * @since 3.0
	 */
	public static StepResult<Object> complete() {
		return StepResultBuilder.create(null).build();
	}

	/**
	 * Returns a step result which aborts the operation
	 * @param <R> the type of the user value of the resulting result. Since the user value will be null, this can be any type.
	 * @return a step result which aborts the operation
	 */
	@SuppressWarnings("unchecked")
	public static <R> StepResult<R> abort() {
		return (StepResult<R>) StepResultBuilder.create().abort().build();
	}
}
