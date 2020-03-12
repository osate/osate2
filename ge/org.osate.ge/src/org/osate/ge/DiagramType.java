/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge;

import org.osate.ge.internal.diagram.runtime.filtering.ContentFilterProvider;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public interface DiagramType {
	/**
	 * Returns a unique identifier for the diagram type.
	 * @return
	 */
	String getId();

	/**
	 * Returns the UI friendly name for the diagram type.
	 * @return
	 */
	String getName();

	/**
	 * Returns the plural UI friendly name for the diagram type.
	 * @return
	 */
	default String getPluralName() {
		return getName() + "s";
	}

	/**
	 * Returns whether the diagram type supports the use of a specified business object as a context.
	 * @param contextBo
	 * @return
	 */
	boolean isApplicableToContext(final Object contextBo);

	/**
	 * Returns the IDs of the default content filters for a business object. Must never return null.
	 * @param bo
	 * @return
	 */
	ImmutableSet<String> getDefaultContentFilters(Object bo);

	/**
	 * Returns the set of all AADL properties that are added to the diagram configuration by default. The user may choose to remove such properties.
	 * Changing this set will not result in changes to existing diagrams.
	 * @return
	 */
	ImmutableCollection<String> getDefaultAadlPropertyNames();

	/**
	 * Returns the default value for the connection primary labels visible configuration option.
	 * @return
	 */
	default boolean getDefaultConnectionPrimaryLabelsVisible() {
		return false;
	}

	/**
	 * Returns whether the diagram type is one that should be provided to the user as an option when creating a diagram.
	 * @return
	 */
	default boolean isUserCreatable() {
		return true;
	}

	/**
	 *
	 * @noreference
	 */
	public default ImmutableSet<ContentFilter> getApplicableDefaultContentFilters(final Object bo,
			final ContentFilterProvider contentFilterProvider) {
		return getDefaultContentFilters(bo).stream()
				.map(id -> contentFilterProvider.getContentFilterById(id).orElse(null))
				.filter(cf -> cf != null && cf.isApplicable(bo))
				.collect(ImmutableSet.toImmutableSet());
	}
}
