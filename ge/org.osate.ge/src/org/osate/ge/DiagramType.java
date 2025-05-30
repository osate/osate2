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
package org.osate.ge;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

/**
 * A diagram type defines specialized behavior for a diagram.
 * Specifically, the diagram types define the content filters which determine which business objects are shown by default and
 * which AADL properties are shown by default.
 * Diagram types are registered using the <i>org.osate.ge.diagramTypes</i> extension point.
 */
public interface DiagramType {
	/**
	 * Returns a unique identifier for the diagram type.
	 * @return the unique identifier for the diagram type.
	 */
	String getId();

	/**
	 * Returns the UI friendly name for the diagram type.
	 * @return the user-friendly name for the diagram type.
	 */
	String getName();

	/**
	 * Returns the plural UI friendly name for the diagram type.
	 * @return the plural version of the user-friendly name.
	 */
	default String getPluralName() {
		return getName() + "s";
	}

	/**
	 * Returns whether the diagram type supports the use of a specified business object as a context.
	 * @param contextBo the context business object
	 * @return whether this diagram type is valid for the specified context business object
	 */
	boolean isApplicableToContext(final Object contextBo);

	/**
	 * Returns the IDs of the content filters to use to determine whether child business objects should be shown by default.. Must never return null.
	 * @param bo is the business object for which to return the content filters.
	 * @return the content filters to use to determine which business objects should be shown.
	 */
	ImmutableSet<String> getDefaultContentFilters(Object bo);

	/**
	 * Returns the set of all AADL properties that are added to the diagram configuration by default. The user may choose to remove such properties.
	 * Changing this set will not result in changes to existing diagrams.
	 * @return is a set containing the qualified names of the properties to be show by default for diagrams of this type.
	 */
	ImmutableCollection<String> getDefaultAadlPropertyNames();

	/**
	 * Returns the default value for the connection primary labels visible configuration option.
	 * @return whether to show connection primary labels by default.
	 */
	default boolean getDefaultConnectionPrimaryLabelsVisible() {
		return false;
	}
}
