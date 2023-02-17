/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

import org.osate.ge.operations.Operation;

/**
 * Step which executes an operation
 *
 * @param <P> the type of the user value of the result of the previous step
 */
public class SuboperationStep<P> extends AbstractStep {
	private final Function<P, Operation> opProvider;

	/**
	 * Creates a new instance
	 * @param nextStep the next step in the sequence
	 * @param opProvider the function which will return the operation to execute based on the user value from the previous step
	 */
	public SuboperationStep(final Step nextStep,
			Function<P, Operation> opProvider) {
		super(nextStep);
		this.opProvider = Objects.requireNonNull(opProvider, "opProvider must not be null");
	}

	/**
	 * Returns the function which will return the operation to execute based on the user value from the previous step
	 * @return the function which will return the operation to execute.
	 */
	public Function<P, Operation> getOperationProvider() {
		return opProvider;
	}
}
