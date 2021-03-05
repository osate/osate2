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
package org.osate.ge.businessobjecthandling;

import java.util.Objects;
import java.util.Optional;

import org.osate.ge.services.ReferenceBuilderService;

/**
 * Contains contextual information for getting the reference to a business object.
 *
 * @since 2.0
 * @noextend This class is not intended to be subclassed by clients.
 */
public class ReferenceContext {
	private final Object bo;
	private final ReferenceBuilderService referenceBuilder;

	/**
	 * Creates a new instance.
	 * @param bo is the business object for which to retrieve a reference.
	 * @param referenceBuilder is a reference to the reference builder service.
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public ReferenceContext(final Object bo, final ReferenceBuilderService referenceBuilder) {
		this.bo = Objects.requireNonNull(bo, "bo must not be null");
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
	}

	/**
	 * Retrieves the business object for which a reference is being requested.
	 * @return the business object for which a reference is being requested.
	 *
	 * @since 2.0
	 */
	public Object getBusinessObject() {
		return bo;
	}

	/**
	 * Retrieves the business object for which a reference is being requested if the business object is an instance
	 * of the specified class.
	 * @param <T> is the requested type.
	 * @param boType is the class to which to cast the business object.
	 * @return an optional containing the context's business object. An empty optional if the context's business object is not
	 * an instance the specified class.
	 *
	 * @since 2.0
	 */
	public <T> Optional<T> getBusinessObject(final Class<T> boType) {
		if (!boType.isInstance(bo)) {
			return Optional.empty();
		}

		return Optional.of(boType.cast(bo));
	}

	/**
	 * Returns a reference to the reference builder service.
	 * @return a reference to the reference builder service
	 */
	public ReferenceBuilderService getReferenceBuilder() {
		return this.referenceBuilder;
	}
}
