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
package org.osate.ge.referencehandling;

import java.util.Objects;

import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.services.ReferenceResolutionService;

/**
 * Context for resolving canonical references.
 *
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 * @since 2.0
 */
public final class ResolveContext {
	private final CanonicalBusinessObjectReference reference;
	private final ReferenceResolutionService referenceResolutionService;

	/**
	 * Creates a new instance.
	 * @param reference is the reference being resolved.
	 * @param referenceResolutionService is the reference resolution service
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public ResolveContext(final CanonicalBusinessObjectReference reference,
			final ReferenceResolutionService referenceResolutionService) {
		this.reference = Objects.requireNonNull(reference, "reference must not be null");
		this.referenceResolutionService = Objects.requireNonNull(referenceResolutionService,
				"referenceResolutionService must not be null");
	}

	/**
	 * Returns the reference to resolve.
	 * @return the reference to resolve.
	 */
	public CanonicalBusinessObjectReference getReference() {
		return this.reference;
	}

	/**
	 * Returns the reference resolution service. Provided to allow resolving nested references.
	 * @return the reference resolution service.
	 */
	public ReferenceResolutionService getReferenceResolutionService() {
		return this.referenceResolutionService;
	}

}
