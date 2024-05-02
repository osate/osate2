/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.ge.internal.services.impl.ReferenceEncoder;

/**
 * Immutable data type for canonical references to a business object. Canonical business object references are created for a
 * business object using the registered {@link BusinessObjectHandler}.
 * A canonical reference uniquely identifies a business object in the context of the current project.
 * If the canonical references of two business objects are equal, then the business objects are treated as being the same object.
 * @since 2.0
 *
 */
public final class CanonicalBusinessObjectReference extends BusinessObjectReference {
	/**
	 * Creates an instance from an array of segments. Segments are case insensitive. Throws an exception is optional or if the segments
	 * array is null or empty.
	 * @param segments is an array of segments that makes up the reference.
	 */
	public CanonicalBusinessObjectReference(final String... segments) {
		super(segments);
	}

	/**
	 * Returns a string representation of the reference that can be converted back to an equal instance using
	 * {@link CanonicalBusinessObjectReference#decode(String)}. One use of this method is to convert a canonical reference into a string that can be used
	 * as a segment of another canonical reference.
	 * @return the encoded reference
	 */
	public String encode() {
		return ReferenceEncoder.encode(getSegments());
	}

	/**
	 * Converts the instance to an instance of the serialized diagram model type.
	 * @return the converted object.
	 */
	public final org.osate.ge.diagram.CanonicalBusinessObjectReference toMetamodel() {
		final org.osate.ge.diagram.CanonicalBusinessObjectReference newValue = new org.osate.ge.diagram.CanonicalBusinessObjectReference();
		for (final String seg : getSegments()) {
			newValue.getSeg().add(seg);
		}
		return newValue;
	}

	/**
	 * Converts an encoded string as returned by {@link CanonicalBusinessObjectReference#encode()} into an instance of {@link CanonicalBusinessObjectReference}
	 * @param reference the encoded reference
	 * @return the decoded reference object
	 */
	public static CanonicalBusinessObjectReference decode(final String reference) {
		return new CanonicalBusinessObjectReference(ReferenceEncoder.decode(reference));
	}
}
