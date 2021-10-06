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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

/**
 * Builder for the {@link StepResult} class.
 * @param <R> the type of the result's user value
 */
public class StepResultBuilder<R> {
	private R userValue;
	private Multimap<BusinessObjectContext, Object> containerToBoToShowMap = ArrayListMultimap.create();
	private boolean aborted = false;

	/**
	 * Private constructor to prevent direct instantiation.
	 * @param userValue is the user value
	 * @see #create()
	 */
	private StepResultBuilder(final R userValue) {
		this.userValue = userValue;
	}

	/**
	 * Creates a new instance configured to create a result with the specified user value.
	 * @param <R> the type of the user value
	 * @param userValue the user value
	 * @return a new builder
	 */
	public static <R> StepResultBuilder<R> create(final R userValue) {
		return new StepResultBuilder<>(userValue);
	}

	/**
	 * Creates a new instance configured to create a result with a null use value
	 * @return a new builder
	 */
	public static StepResultBuilder<Void> create() {
		return new StepResultBuilder<>(null);
	}

	/**
	 * Configures the builder to add an entry for the specified container and business object to the map containing business objects to show on
	 * the diagram.
	 * @param container the business object context for the container. This is expected to be a diagram node.
	 * @param bo the child business object to show
	 * @return this builder to allow method chaining.
	 * @see StepResult#getContainerToBoToShowMap()
	 */
	public StepResultBuilder<R> showNewBusinessObject(final BusinessObjectContext container,
			final Object bo) {
		Objects.requireNonNull(container, "container must not be null");
		Objects.requireNonNull(bo, "bo must not be null");
		containerToBoToShowMap.put(container, bo);
		return this;
	}

	/**
	 * Configures the builder to create a result which indicates that the operation was aborted.
	 * Aborting an operation will not revert previously made modifications. It is recommended to perform any prompting and potential aborting before
	 * any modification steps.
	 * @return this builder to allow method chaining.
	 * @see StepResult#aborted()
	 */
	public StepResultBuilder<R> abort() {
		aborted = true;
		return this;
	}

	/**
	 * Creates a new step result with the configured values.
	 * @return a new step result with the configured values
	 */
	public StepResult<R> build() {
		return new StepResult<>(userValue, ImmutableMultimap.copyOf(containerToBoToShowMap), aborted);
	}
}
