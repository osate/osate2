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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The errors enumeration found in a declaration, gathered so that they can be reported
 * once each.
 *
 * <p>
 * A {@link Resolution.Failed} is a model or implementation error rather than a
 * declaration that does not continue a path, so it has to reach the user. Enumeration
 * resolves the same declaration many times over, once per orientation, leg role, and
 * branch, so the same failure is met repeatedly and is kept once per target and
 * message: what the reader needs to know is that the endpoint does not resolve, not
 * how many times the traversal asked.
 * </p>
 *
 * <p>
 * Collecting rather than reporting immediately keeps enumeration free of the error
 * manager, which is what lets a path be explored and discarded without leaving
 * anything behind.
 * </p>
 */
public final class ResolutionFailures {

	private final Map<String, Resolution.Failed<?>> unique = new LinkedHashMap<>();

	/** Keep {@code outcome} if it is a failure, and ignore it otherwise. */
	public void add(Resolution<?> outcome) {
		if (outcome instanceof Resolution.Failed<?> failed) {
			unique.putIfAbsent(PathKeys.any(failed.target()) + '|' + failed.message(), failed);
		}
	}

	/** The distinct failures, in the order they were first met. */
	public Collection<Resolution.Failed<?>> collected() {
		return List.copyOf(unique.values());
	}
}
