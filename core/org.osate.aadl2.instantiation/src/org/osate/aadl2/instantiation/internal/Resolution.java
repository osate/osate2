/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import java.util.Optional;

import org.osate.aadl2.Element;

/**
 * The outcome of resolving one step of a semantic connection path.
 *
 * <p>
 * A step that does not apply, an end the model should have had and does not, and a
 * successful resolution are three outcomes, and the compiler enforces that a caller
 * handles each. One nullable result cannot distinguish them: a model error then reaches
 * the caller as an absent value and surfaces as a {@code NullPointerException} instead of
 * as the diagnostic the reader needs.
 * </p>
 *
 * @param <T> what a successful resolution produced
 */
public sealed interface Resolution<T> {

	/** Resolution succeeded. */
	record Resolved<T>(T value) implements Resolution<T> {
		public Resolved {
			if (value == null) {
				throw new IllegalArgumentException("A resolved result must have a value");
			}
		}
	}

	/**
	 * The step does not apply to this path. This is a normal traversal outcome, not
	 * an error: a candidate declaration may simply not continue the path.
	 *
	 * @param reason why the step does not apply, for tests and debugging only; it is
	 *            never reported to the user
	 */
	record NotApplicable<T>(String reason) implements Resolution<T> {
	}

	/**
	 * The step should have resolved and did not. This is a model or implementation
	 * error, and it is reported.
	 *
	 * @param target the element to attach the diagnostic to; it must belong to a
	 *            resource, otherwise the diagnostic cannot be reported anywhere
	 * @param message the exact diagnostic text
	 */
	record Failed<T>(Element target, String message) implements Resolution<T> {
		public Failed {
			if (target == null) {
				throw new IllegalArgumentException("A failed resolution needs a diagnostic target");
			}
			if (target.eResource() == null) {
				throw new IllegalArgumentException(
						"A failed resolution needs a resource-backed diagnostic target, but " + target.eClass().getName()
								+ " is not in a resource");
			}
			if (message == null || message.isBlank()) {
				throw new IllegalArgumentException("A failed resolution needs a message");
			}
		}
	}

	static <T> Resolution<T> resolved(T value) {
		return new Resolved<>(value);
	}

	static <T> Resolution<T> notApplicable(String reason) {
		return new NotApplicable<>(reason);
	}

	static <T> Resolution<T> failed(Element target, String message) {
		return new Failed<>(target, message);
	}

	/** The resolved value, or empty for either of the other two outcomes. */
	default Optional<T> asOptional() {
		return this instanceof Resolved<T> resolved ? Optional.of(resolved.value()) : Optional.empty();
	}
}
