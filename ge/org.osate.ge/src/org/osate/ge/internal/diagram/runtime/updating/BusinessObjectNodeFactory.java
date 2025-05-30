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
package org.osate.ge.internal.diagram.runtime.updating;

import java.util.Objects;
import java.util.UUID;

import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * Factory class which creates {@link BusinessObjectNode} instances.
 */
public class BusinessObjectNodeFactory {
	private final ReferenceBuilderService referenceBuilder;

	/**
	 * Creates a new instance which uses the specified reference service when creating {@link BusinessObjectNode} instances
	 * @param referenceBuilder is a reference builder
	 */
	public BusinessObjectNodeFactory(final ReferenceBuilderService referenceBuilder) {
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
	}

	/**
	 * Creates a new node. {@link BusinessObjectNode#getDefaultChildrenHaveBeenPopulated()} will return true for the new node.
	 * @param parent the parent of the new new node
	 * @param id the ID of the new node
	 * @param bo the business object of the new node.
	 * @param completeness the completeness state of the new node
	 * @return the new node
	 * @throws NullPointerException if the business object is null for a non-root node or the relative reference could not be retrieved for the business object.
	 * @throws IllegalArgumentException if a non-null business object was specified for a root node.
	 */
	public BusinessObjectNode create(final BusinessObjectNode parent,
			final UUID id,
			final Object bo,
			final Completeness completeness) {
		final RelativeBusinessObjectReference relativeReference = bo == null ? null
				: Objects.requireNonNull(referenceBuilder.getRelativeReference(bo),
						"unable to get relative reference for " + bo);

		// Validate
		if(parent == null) {
			if (relativeReference != null) {
				throw new IllegalArgumentException("Root nodes must have a null relative reference");
			}
		} else {
			Objects.requireNonNull(bo, "bo must not be null");
		}

		return new BusinessObjectNode(parent, id, relativeReference, bo, completeness, true);
	}
}
