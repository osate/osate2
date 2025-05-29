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

import org.osate.ge.businessobjecthandling.BusinessObjectHandler;

/**
 * Immutable data type for relative references to a business object. Relative business object references are created for a
 * business object using the registered {@link BusinessObjectHandler}.
 * A relative reference along with a containing diagram element must uniquely identify the business object.
 * @since 2.0
 */
public final class RelativeBusinessObjectReference extends BusinessObjectReference {
	/**
	 * Creates an instance from an array of segments. Segments are case insensitive. Throws an exception is optional or if the segments
	 * array is null or empty.
	 * @param segments is an array of segments that makes up the reference.
	 */
	public RelativeBusinessObjectReference(final String... segments) {
		super(segments);
	}

	/**
	 * Converts the instance to an instance of the serialized diagram model type.
	 * @return the converted object.
	 */
	public final org.osate.ge.diagram.RelativeBusinessObjectReference toMetamodel() {
		final org.osate.ge.diagram.RelativeBusinessObjectReference newValue = new org.osate.ge.diagram.RelativeBusinessObjectReference();
		for (final String seg : getSegments()) {
			newValue.getSeg().add(seg);
		}
		return newValue;
	}
}
