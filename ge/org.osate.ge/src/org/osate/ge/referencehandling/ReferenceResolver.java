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

import java.util.Optional;

import org.osate.ge.businessobjecthandling.BusinessObjectHandler;

/**
 * Implementations of this interface are responsible for resolving references provided by {@link BusinessObjectHandler}. Reference
 * resolution is only required for canonical references which may be used as a diagram context. Instances are created using a registered
 * {@link ReferenceResolverFactory} extension.
 *
 * @see ReferenceResolverFactory
 * @since 2.0
 */
public interface ReferenceResolver extends AutoCloseable {
	@Override
	default void close() {
	}

	/**
	 * Finds the business object referenced by a canonical reference. Only required for canonical reference which may be used as
	 * a diagram context.
	 * @param ctx is the context containing the canonical reference to resolve.
	 * @return an optional containing the referenced business object. Must not return null. If the specified reference is not handled
	 * by the resolver or resolution fails, an empty optional must be returned.
	 */
	Optional<Object> resolve(ResolveContext ctx);

}
