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
package org.osate.ge.internal.util;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectProviderContext;
import org.osate.ge.internal.services.ExtensionRegistryService;

/**
 * Helper class for invoking business object providers.
 *
 */
public class BusinessObjectProviderHelper {
	private final ExtensionRegistryService extRegistry;

	/**
	 * Creates a new instance
	 * @param extRegistry the extension registry
	 */
	public BusinessObjectProviderHelper(final ExtensionRegistryService extRegistry) {
		this.extRegistry = Objects.requireNonNull(extRegistry, "extRegistry must not be null");
	}

	/**
	 * Returns the business objects from all the business object providers for the specified business object context.
	 * @param parentBoc the business object context for which to retrieve business object
	 * @return the children business objects for the specified business object context
	 */
	public Collection<Object> getChildBusinessObjects(final BusinessObjectContext parentBoc) {
		// Use business object providers to determine the children
		final BusinessObjectProviderContext ctx = new BusinessObjectProviderContext(parentBoc, extRegistry);
		final Stream<Object> allChildren = extRegistry.getBusinessObjectProviders()
				.stream()
				.flatMap(bop -> bop.getChildBusinessObjects(ctx));
		return allChildren.distinct().collect(Collectors.toList());
	}
}
