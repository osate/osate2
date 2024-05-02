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
package org.osate.ge.internal.operations;

import java.util.Objects;
import java.util.function.Function;

import org.osate.ge.operations.StepResult;

/**
 * A step which converts/replaces the user value from the previous step to a new value.
 *
 * @param <P> the type of the user value of the result of the previous step
 * @param <R> the type of the user value of the new step's result
 */
public class MapStep<P, R> extends AbstractStep {
	private final Function<P, StepResult<R>> mapper;

	/**
	 * Creates a new instance
	 * @param nextStep the next step in the sequence
	 * @param mapper the function which converts the previous step result's user value to a new result.
	 */
	public MapStep(final Step nextStep,
			final Function<P, StepResult<R>> mapper) {
		super(nextStep);
		this.mapper = Objects.requireNonNull(mapper, "mapper must not be null");
	}

	/**
	 * Returns the mapping the function which converts the previous step result's user value to a new result.
	 * @return the mapping function
	 */
	public Function<P, StepResult<R>> getMapper() {
		return mapper;
	}
}
